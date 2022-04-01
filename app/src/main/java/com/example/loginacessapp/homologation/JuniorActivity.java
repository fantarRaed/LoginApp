package com.example.loginacessapp.homologation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginacessapp.JuryActivity;
import com.example.loginacessapp.QRScanner;
import com.example.loginacessapp.R;
import com.example.loginacessapp.ReceptionActivity;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class JuniorActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_junior);

        Button btn = findViewById(R.id.btnscan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JuniorActivity.this, QRScanner.class));
            }
        });


        BottomNavigationItemView bt1 = findViewById(R.id.btnsuiveur);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JuniorActivity.this, SuiveurActivity.class));
            }
        });
        BottomNavigationItemView bt2 = findViewById(R.id.btnautonome);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JuniorActivity.this, AutonomeActivity.class));
            }
        });
        BottomNavigationItemView bt3 = findViewById(R.id.btntoutterrian);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JuniorActivity.this, ToutTerrainActivity.class));
            }
        });

/*
        //======list======
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.list_j);

        //Query
        Query query = firebaseFirestore.collection("Junior");
        //RecyclerOptions
        FirestoreRecyclerOptions<JuniorModel> options = new FirestoreRecyclerOptions.Builder<JuniorModel>()
                .setQuery(query, JuniorModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<JuniorModel, JuniorViewHolder>(options) {
            @NonNull
            @Override
            public JuniorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_list, parent, false);
                return new JuniorViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull JuniorViewHolder holder, int position, @NonNull JuniorModel model) {
                holder.list_name.setText(model.getName());
                holder.list_score.setText(model.getScore()+"");
            }
        };

        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);


    }

    private class JuniorViewHolder extends RecyclerView.ViewHolder {

        private TextView list_name;
        private TextView list_score;


        public JuniorViewHolder(@NonNull View itemView) {
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

