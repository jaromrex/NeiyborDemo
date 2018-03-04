package cs405.neiybordemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by Jarom on 3/2/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<Listing> list = Collections.emptyList();
    Context context;

    public RecyclerViewAdapter(List<Listing> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).getListingName());
        holder.description.setText(list.get(position).getDescription());
        if(list.get(position).getPhoto() == null) {
            holder.imageView.setImageResource(list.get(position).getPhotoResource());
        }
        else {
            holder.imageView.setImageBitmap(list.get(position).getPhoto());
        }
    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Listing listing) {
        list.add(position, listing);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Listing listing) {
        int position = list.indexOf(listing);
        list.remove(position);
        notifyItemRemoved(position);
    }

}
