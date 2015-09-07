package com.example.user.academicapp.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.academicapp.R;
import com.example.user.academicapp.models.Topic;
import com.example.user.academicapp.models.Category;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Elsy on 01/09/2015.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private final Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> data) {
        this.context = context;
        if (data != null)
            categoryList = data;
        else categoryList = new ArrayList<Category>();
    }

    public void add(Category s,int position) {
        position = position == -1 ? getItemCount()  : position;
        categoryList.add(position, s);
        notifyItemInserted(position);
    }

    public void remove(int position){
        if (position < getItemCount()  ) {
            categoryList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_recy_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Category currentCategory = categoryList.get(position);
        holder.txt_name.setText(currentCategory.getName());
        changeBackground(holder, currentCategory.getColor());
        setPropertiesRecycler(holder);
    }

    private void changeBackground(ViewHolder holder, String colorStr){
        int color;
        switch (colorStr){
            case "red":
                color =context.getResources().getColor(R.color.red);
                break;
            case "pink":
                color =context.getResources().getColor(R.color.pink);
                break;
            case "purple":
                color =context.getResources().getColor(R.color.purple);
                break;
            case "deep_purple":
                color =context.getResources().getColor(R.color.deep_purple);
                break;
            case "indigo":
                color =context.getResources().getColor(R.color.indigo);
                break;
            case "blue":
                color =context.getResources().getColor(R.color.blue);
                break;
            case "cyan":
                color =context.getResources().getColor(R.color.cyan);
                break;
            case "green":
                color =context.getResources().getColor(R.color.green);
                break;
            case "yellow":
                color =context.getResources().getColor(R.color.yellow);
                break;
            case "line":
                color =context.getResources().getColor(R.color.line);
                break;
            case "amber":
                color =context.getResources().getColor(R.color.amber);
                break;
            case "orange":
                color =context.getResources().getColor(R.color.orange);
                break;
            case "brown":
                color =context.getResources().getColor(R.color.brown);
                break;
            default:
                color =context.getResources().getColor(R.color.red);
                break;
        }
        holder.rl_container.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final LinearLayout rl_container;
        public final RecyclerView recy_sections;
        public final TextView txt_name;

        public ViewHolder(View view) {
            super(view);
            txt_name = (TextView) view.findViewById(R.id.category_name);
            rl_container = (LinearLayout)view.findViewById(R.id.container);
            recy_sections = (RecyclerView) view.findViewById(R.id.recy);
        }
    }


    private void setPropertiesRecycler(ViewHolder holder){
        TopicAdapter adapter = new TopicAdapter(context, listDummy());
        holder.recy_sections.setHasFixedSize(true);
        holder.recy_sections.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
        holder.recy_sections.setAdapter(adapter);
    }

    private List<Topic> listDummy(){
        List<Topic> subjectList = new ArrayList<>();

        String [] colors = { "red",
                "pink",
                "purple",
                "deep_purple",
                "indigo",
                "blue",
                "cyan",
                "green",
                "yellow",
                "line" } ;

        for (String color : colors) {
            subjectList.add(new Topic(color));
        }
        return subjectList;
    }

}