package sg.edu.np.mad.week2project;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder>{
    private ArrayList<User> list_objects; // to put image and text into arraylist need an object under myObject (store it)

    public ProfileAdapter(ArrayList<User> obj){
        this.list_objects = obj; // whatever is passed will be stored here
    }

    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType){ // taking in 2 content
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent, false);
        ProfileViewHolder holder = new ProfileViewHolder(view); // not just a text now, 2 parts now
        return holder; // no longer a single text
    }

    public void onBindViewHolder(ProfileViewHolder holder, int position){
        User list_items = list_objects.get(position); // based on location get item out
        String name = list_items.getName();
        String description = list_items.getDescription();
        String nameAndDesc = name + "\n" + description;
        // holder.txt.setText(list_items.getName()); // insert text here
        // holder.txt.setText(list_items.getDescription()); // insert text here
        holder.txt.setText(nameAndDesc);
    }

    public int getItemCount(){
        return list_objects.size();
    }
}
