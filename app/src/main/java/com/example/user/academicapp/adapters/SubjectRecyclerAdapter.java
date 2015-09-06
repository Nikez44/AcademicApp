package com.example.user.academicapp.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.user.academicapp.R;
import com.example.user.academicapp.models.Section;
import com.example.user.academicapp.models.Subject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Elsy on 01/09/2015.
 */
public class SubjectRecyclerAdapter extends RecyclerView.Adapter<SubjectRecyclerAdapter.ViewHolder> {

    private final Context context;
    private List<Subject> subjectList;

    public SubjectRecyclerAdapter(Context context, List<Subject> data) {
        this.context = context;
        if (data != null)
            subjectList = data;
        else subjectList = new ArrayList<Subject>();
    }

    public void add(Subject s,int position) {
        position = position == -1 ? getItemCount()  : position;
        subjectList.add(position, s);
        notifyItemInserted(position);
    }

    public void remove(int position){
        if (position < getItemCount()  ) {
            subjectList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.adapter_recy_subject, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
   //     holder.txt_survey_title.setText(subjectList.get(position).getTitle());
        changeBackground(holder, position);
        setPropertiesRecycler(holder);
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final LinearLayout rl_container;
        public final RecyclerView recy_sections;
      ///  public final RobotoTextView txt_survey_title;
       // public final RobotoTextView txt_winks_numbers;

        public ViewHolder(View view) {
            super(view);
          //  txt_survey_title = (RobotoTextView) view.findViewById(R.id.survey_title);
            rl_container = (LinearLayout)view.findViewById(R.id.container);
            recy_sections = (RecyclerView) view.findViewById(R.id.recy);
          //  txt_winks_numbers = (RobotoTextView) view.findViewById(R.id.nwinks_number);
        }
    }


    private void setPropertiesRecycler(ViewHolder holder){
        SectionRecyclerAdapter adapter = new SectionRecyclerAdapter(context,listDummy());
        holder.recy_sections.setHasFixedSize(true);
        holder.recy_sections.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
        holder.recy_sections.setAdapter(adapter);
    }

    private List<Section> listDummy(){
        List<Section> subjectList = new ArrayList<>();
        for(int i =0; i<10; i++){
            subjectList.add(new Section(getColor(i)));
        }
        return subjectList;
    }

    private String getColor(int position) {
        String color;
        switch (position){
            case 0:
                color= "red";
                break;
            case 1:
                color ="pink";
                break;
            case 2:
                color ="purple";
                break;
            case 3:
                color ="deep_purple";
                break;
            case 4:
                color ="indigo";
                break;
            case 5:
                color ="blue";
                break;
            case 6:
                color ="cyan";
                break;
            case 7:
                color ="green";
                break;
            case 8:
                color ="yellow";
                break;
            case 9:
                color ="line";
                break;
            case 10:
                color ="amber";
                break;
            case 11:
                color ="orange";
                break;
            case 12:
                color ="brown";
                break;
            default:
                color ="orange";
                break;
        }
        return color;
    }


    private void changeBackground(ViewHolder holder,int position){
        int color;
            switch (subjectList.get(position).getColor()){
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