package com.example.loginacessapp.homologation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginacessapp.R;

public class SuiveurActivity extends AppCompatActivity {
/*
    //=====list=====
    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;
    private FirestoreRecyclerAdapter adapter;
    //==============
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suiveur);


        TextView btn = findViewById(R.id.btnscan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuiveurActivity.this, InputActivity.class));
            }
        });

        Button bt1 = findViewById(R.id.btnjunior);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuiveurActivity.this, JuniorActivity.class));
            }
        });
        Button bt2 = findViewById(R.id.btnautonome);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuiveurActivity.this, AutonomeActivity.class));
            }
        });
        Button bt3 = findViewById(R.id.btntoutterrian);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuiveurActivity.this, ToutTerrainActivity.class));
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