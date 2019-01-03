package Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raunak.new1.NextActivity;
import com.example.raunak.new1.R;

import java.util.List;
import Model.User;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<User> list;

    public MyAdapter(Context context, List<User> ls) {
        this.context = context;
        this.list = ls;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.linear, viewGroup, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {
        User user = list.get(i);
        viewHolder.name.setText(user.getName());
        viewHolder.description.setText(user.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.textView1);
            description = itemView.findViewById(R.id.textView2);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            User user = list.get(pos);

            Intent intent = new Intent(context,NextActivity.class);
            intent.putExtra("name",user.getName());
            intent.putExtra("desc",user.getDescription());
            context.startActivity(intent);
        }
    }
}
