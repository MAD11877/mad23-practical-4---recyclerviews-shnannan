package sg.edu.np.mad.week2project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    final String title = "List Activity"; // differentiate Main Activity from List Activity
    ArrayList<User> myList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        User myUser = new User();

        // randomizing name, descriptions, followed statuses for array list
        //adding to a array list
        for (int i = 0; i<20; i++) {
            myUser.setName("Name" + randomNum()); // random name and number
            myUser.setDescription("Description" + randomNum()); // random description and number

            Random rd = new Random(); // creating Random object
            myUser.setFollowed(rd.nextBoolean()); // displaying a random boolean
            myList.add(myUser);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(title, "On Resume! List Activity Page Started!");
        // starting the recycler view page
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ProfileAdapter profileAdapter = new ProfileAdapter(myList);
        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator()); // set animation
        recyclerView.setAdapter(profileAdapter);

        // when image is clicked, show alert dialog with corresponding page
        ImageView listView = findViewById(R.id.imageView);
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(title, "List image clicked!");
                // alert dialog is launched
                ImageAlertDialog();
            }
        });
    }

    private void ImageAlertDialog(){ // click on image prompts alert dialog method
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness").setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // what happens when View Button is clicked
                Log.v(title, "User accepts to view profile page");
                // intent to go back to main activity through View button
                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                String randNum = String.valueOf(randomNum());
                // getting random number from List Activity Page
                myIntent.putExtra("Random Number", randNum);
                // getting randomized contents and throwing over (overcoming global static variable)
                myIntent.putExtra("My Objects", myList);
                startActivity(myIntent); // the action of the Intent
                Log.v(title, "New random number generated");
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(title, "User declines to view profile page");
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show(); // show the alert title
    }

    private int randomNum(){
        Random ran = new Random();
        int myRandomNumber = ran.nextInt(100000);
        return myRandomNumber;
    }
}