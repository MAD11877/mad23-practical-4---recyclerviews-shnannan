package sg.edu.np.mad.week2project;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProfileViewHolder extends RecyclerView.ViewHolder{
    TextView txtTitle;

    TextView txtDesc;
    ImageView image;


    public ProfileViewHolder(View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtDesc = itemView.findViewById(R.id.txtDesc);
        image = itemView.findViewById(R.id.profile_img);
    }
}
