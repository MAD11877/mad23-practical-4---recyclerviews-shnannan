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
    static ArrayList<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        userList = new ArrayList<>();
        for(int i=0; i<20; i++)
        {
            User myUser = new User();
            myUser.name = "Name" + new Random().nextInt();
            myUser.description = "Description " + new Random().nextInt();
            myUser.followed = new Random().nextInt()%2 == 0;
            userList.add(myUser);
        }

        RecyclerView rv = findViewById(R.id.rv);
        ProfileAdapter Adapter = new ProfileAdapter(userList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(Adapter);
    }
}