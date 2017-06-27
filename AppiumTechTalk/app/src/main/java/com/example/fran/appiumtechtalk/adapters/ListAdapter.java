package com.example.fran.appiumtechtalk.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fran.appiumtechtalk.R;
import com.example.fran.appiumtechtalk.bussines.ListItem;

import java.util.ArrayList;

/**
 * @author f.visintini on 27/06/17.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {

    private ArrayList<ListItem> items;

    public ListAdapter() {
        items = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            items.add(new ListItem("Title "+(i+1), "Description "+(i+1)));
        }
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListItemViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        ListItem item = items.get(position);

        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ListItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView description;

        public ListItemViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
