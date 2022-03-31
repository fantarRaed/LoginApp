package com.example.loginacessapp.homologation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginacessapp.QRScanner;
import com.example.loginacessapp.R;

public class AutonomeActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_autonome);


        TextView btn = findViewById(R.id.btnscan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AutonomeActivity.this, QRScanner.class));
            }
        });

        Button bt1 = findViewById(R.id.btnsuiveur);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AutonomeActivity.this, SuiveurActivity.class));
            }
        });
        Button bt2 = findViewById(R.id.btnjunior);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AutonomeActivity.this, JuniorActivity.class));
            }
        });
        Button bt3 = findViewById(R.id.btntoutterrian);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AutonomeActivity.this, ToutTerrainActivity.class));
            }
        });
/*
        //======list======
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.list_a);

        //Query
        Query query = firebaseFirestore.collection("Autonome");
        //RecyclerOptions
        FirestoreRecyclerOptions<AutonomeModel> options = new FirestoreRecyclerOptions.Builder<AutonomeModel>()
                .setQuery(query, AutonomeModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<AutonomeModel, AutonomeActivity.AutonomeViewHolder>(options) {
            @NonNull
            @Override
            public AutonomeActivity.AutonomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_list, parent, false);
                return new AutonomeActivity.AutonomeViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull AutonomeActivity.AutonomeViewHolder holder, int position, @NonNull AutonomeModel model) {
                holder.list_name.setText(model.getName());
                holder.list_score.setText(model.getScore()+"");
            }
        };

        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);


    }

    private class AutonomeViewHolder extends RecyclerView.ViewHolder {

        private TextView list_name;
        private TextView list_score;


        public AutonomeViewHolder(@NonNull View itemView) {
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
    }
    //======end list=========

 */}
}