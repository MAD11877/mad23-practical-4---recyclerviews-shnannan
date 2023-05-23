package sg.edu.np.mad.week2project;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProfileViewHolder extends RecyclerView.ViewHolder{
    TextView txt;
    ImageView image;

    public ProfileViewHolder(View itemView) {
        super(itemView);
        txt = itemView.findViewById(R.id.textView4);
        image = itemView.findViewById(R.id.imageView);
    }
}
