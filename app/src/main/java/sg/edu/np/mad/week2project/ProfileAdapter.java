package sg.edu.np.mad.week2project;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder>{
    ArrayList<User> data;

    public ProfileAdapter(ArrayList<User> input){
        data = input;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;

        if(viewType == 7) {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.reviewitem2,
                    parent,
                    false
            );
        } else {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.reviewitem,
                    parent,
                    false
            );
        }
        return new ProfileViewHolder(item);
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(data.get(position).name.substring(data.get(position).name.length()-1));
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, @SuppressLint("RecyclerView") int position) {
        User myUser = data.get(position);
        holder.txtTitle.setText(myUser.name);
        holder.txtDesc.setText(myUser.description);


        holder.image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Debug", "Image clicked");

                new AlertDialog.Builder(holder.image.getContext())
                        .setTitle("Profile")
                        .setMessage(myUser.name)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent viewProfile = new Intent(holder.image.getContext(), MainActivity.class);
                                viewProfile.putExtra("id", position);
                                holder.image.getContext().startActivity(viewProfile);
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
