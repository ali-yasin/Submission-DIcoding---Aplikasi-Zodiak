package NamaZodiak.SubmissionDicoding.AndroidPemula;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

public class ZodiakListAdapter extends RecyclerView.Adapter<ZodiakListAdapter.ListViewHolder> {

    public interface OnItemClickCallback {
        void onItemClicked(Zodiak data);
    }
    private OnItemClickCallback onItemClickCallback;
    private ArrayList<Zodiak> listZodiak;

    public ZodiakListAdapter(ArrayList<Zodiak> zodiaks) {
        this.listZodiak = zodiaks;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Zodiak zodiak = listZodiak.get(position);
        Glide.with(holder.itemView.getContext())
                .load(zodiak.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(zodiak.getName());
        holder.tvOrigin.setText(zodiak.getOrigin());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listZodiak.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listZodiak.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvOrigin;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvOrigin = itemView.findViewById(R.id.tv_item_origin);
        }
    }
}

