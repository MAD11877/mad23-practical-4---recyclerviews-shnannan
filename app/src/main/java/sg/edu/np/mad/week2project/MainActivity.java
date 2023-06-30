package sg.edu.np.mad.week2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    final String title = "Main Activity";
    // Declare the User object
    User myUser = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(title, "Create!");
        Intent rec = getIntent();
        int value = rec.getIntExtra("id",0);
        myUser = ListActivity.userList.get(value);

        TextView UserName = findViewById(R.id.txtName);
        UserName.setText(myUser.getName());
        TextView description = findViewById(R.id.txtDescription);
        description.setText(myUser.getDescription());
        setFollowBtn();
        setMessageBtn();
    }

    private void setFollowBtn() {
        Button follow = findViewById(R.id.followBtn);
        if(myUser.followed) {
            follow.setText("Unfollow");
            Log.v(title,"Button: Follow clicked! Now Unfollowing");
        }
        else {
            follow.setText("Follow");
            Log.v(title,"Button: Unfollow clicked! Now Following");
        }
    }

    public void onFollowClick(View v) {
        myUser.followed = !myUser.followed;
        if(myUser.followed)
            Toast.makeText(this, "Followed", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Unfollowed", Toast.LENGTH_SHORT).show();
        setFollowBtn();
    }

    private void setMessageBtn() {
        Button message = findViewById(R.id.messageBtn);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(title,"Toggle Button: Message clicked!");
                message.setText("Messaged!");  // user is messaged
                Toast.makeText(MainActivity.this, "Messaged User!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}