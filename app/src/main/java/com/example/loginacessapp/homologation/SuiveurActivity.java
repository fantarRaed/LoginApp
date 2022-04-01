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

public class SuiveurActivity extends AppCompatActivity {

    private TextView name,score;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("teams");
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList<Team> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suiveur);


        Button btn = findViewById(R.id.btnscan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuiveurActivity.this, QRScanner.class));
            }
        });

        BottomNavigationItemView bt1 = findViewById(R.id.btnjunior);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuiveurActivity.this, JuniorActivity.class));
            }
        });
        BottomNavigationItemView bt2 = findViewById(R.id.btnautonome);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuiveurActivity.this, AutonomeActivity.class));
            }
        });
        BottomNavigationItemView bt3 = findViewById(R.id.btntoutterrian);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuiveurActivity.this, ToutTerrainActivity.class));
            }
        });

        name = findViewById(R.id.list_name);
        score = findViewById(R.id.list_score);
        recyclerView = findViewById(R.id.list_s);
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
                    if(model.getConcours().equals("suiveur") && model.getScore_homologation()>-1)
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
        mFirestoreList = findViewById(R.id.list_s);

        //Query
        Query query = firebaseFirestore.collection("Suiveur");
        //RecyclerOptions
        FirestoreRecyclerOptions<SuiveurModel> options = new FirestoreRecyclerOptions.Builder<SuiveurModel>()
                .setQuery(query, SuiveurModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<SuiveurModel, SuiveurActivity.SuiveurViewHolder>(options) {
            @NonNull
            @Override
            public SuiveurActivity.SuiveurViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_list, parent, false);
                return new SuiveurActivity.SuiveurViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull SuiveurActivity.SuiveurViewHolder holder, int position, @NonNull SuiveurModel model) {
                holder.list_name.setText(model.getName());
                holder.list_score.setText(model.getScore()+"");
            }
        };

        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);


    }

    private class SuiveurViewHolder extends RecyclerView.ViewHolder {

        private TextView list_name;
        private TextView list_score;


        public SuiveurViewHolder(@NonNull View itemView) {
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