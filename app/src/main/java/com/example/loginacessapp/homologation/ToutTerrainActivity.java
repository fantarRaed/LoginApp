package com.example.loginacessapp.homologation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginacessapp.QRScanner;
import com.example.loginacessapp.R;
import com.example.loginacessapp.Team;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ToutTerrainActivity extends AppCompatActivity {

    private TextView name,score;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("teams");
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList<Team> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tout_terrain);


        Button btn = findViewById(R.id.btnscan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToutTerrainActivity.this, QRScanner.class));
            }
        });

        BottomNavigationItemView bt1 = findViewById(R.id.btnsuiveur);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToutTerrainActivity.this, SuiveurActivity.class));
            }
        });
        BottomNavigationItemView bt2 = findViewById(R.id.btnautonome);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToutTerrainActivity.this, AutonomeActivity.class));
            }
        });
        BottomNavigationItemView bt3 = findViewById(R.id.btnjunior);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToutTerrainActivity.this, JuniorActivity.class));
            }
        });

        name = findViewById(R.id.list_name);
        score = findViewById(R.id.list_score);
        recyclerView = findViewById(R.id.list_t);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Team model = dataSnapshot.getValue(Team.class);
                    if(model.getConcours().equals("toutterrain") && model.getScore_homologation()>-1)
                        list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

/*
        //======list======
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.list_t);

        //Query
        Query query = firebaseFirestore.collection("ToutTerrain");
        //RecyclerOptions
        FirestoreRecyclerOptions<ToutTerrainModel> options = new FirestoreRecyclerOptions.Builder<ToutTerrainModel>()
                .setQuery(query, ToutTerrainModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<ToutTerrainModel, ToutTerrainActivity.ToutTerrainViewHolder>(options) {
            @NonNull
            @Override
            public ToutTerrainActivity.ToutTerrainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_list, parent, false);
                return new ToutTerrainActivity.ToutTerrainViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ToutTerrainActivity.ToutTerrainViewHolder holder, int position, @NonNull ToutTerrainModel model) {
                holder.list_name.setText(model.getName());
                holder.list_score.setText(model.getScore()+"");
            }
        };

        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);


    }

    private class ToutTerrainViewHolder extends RecyclerView.ViewHolder {

        private TextView list_name;
        private TextView list_score;


        public ToutTerrainViewHolder(@NonNull View itemView) {
            super(itemView);

            list_name = itemView.findViewById(R.id.list_name);
            list_score = itemView.findViewById(R.id.list_score);
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();

    //======end list=========

 */
    }
}