package com.example.user.academicapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.user.academicapp.R;
import com.example.user.academicapp.models.Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elsy on 01/09/2015.
 */
public class SectionRecyclerAdapter extends RecyclerView.Adapter<SectionRecyclerAdapter.ViewHolder> {

    private final Context context;
    private List<Topic> topicList;
    public void add(Topic s,int position) {
        position = position == -1 ? getItemCount()  : position;
        topicList.add(position, s);
        notifyItemInserted(position);
    }

    public void remove(int position){
        if (position < getItemCount()  ) {
            topicList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public SectionRecyclerAdapter(Context context, List<Topic> data) {
        this.context = context;
        if (data != null)
            topicList = data;
        else topicList = new ArrayList<Topic>();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_recy_topic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //     holder.txt_survey_title.setText(sectionList.get(position).getTitle());
        changeBackground(holder,position);
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final LinearLayout rl_container;
        ///  public final RobotoTextView txt_survey_title;
        // public final RobotoTextView txt_winks_numbers;

        public ViewHolder(View view) {
            super(view);
            //  txt_survey_title = (RobotoTextView) view.findViewById(R.id.survey_title);
            rl_container = (LinearLayout)view.findViewById(R.id.container);
            //  txt_winks_numbers = (RobotoTextView) view.findViewById(R.id.nwinks_number);
        }
    }

   private void changeBackground(ViewHolder holder,int position){
        int color;
        switch (topicList.get(position).getColor()){
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

}