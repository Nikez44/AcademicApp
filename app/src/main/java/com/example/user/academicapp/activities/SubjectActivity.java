package com.example.user.academicapp.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.user.academicapp.R;
import com.example.user.academicapp.adapters.SubjectRecyclerAdapter;
import com.example.user.academicapp.fragments.NavigationDrawerFragment;
import com.example.user.academicapp.helpers.RecyclerItemClickListener;
import com.example.user.academicapp.models.Category;

import java.util.ArrayList;
import java.util.List;

public class SubjectActivity extends AppCompatActivity {

    private RecyclerView recy_subjects;
    private DrawerLayout drawerLayout;
    private NavigationDrawerFragment drawerFragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        loadViews();
        setSupportActionBar(toolbar);
        setPropertiesRecycler();

        drawerFragment.setUp(drawerLayout, toolbar);

        recy_subjects.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                effect(view);
            }
        }));
    }

    private void loadViews(){
        toolbar= (Toolbar)findViewById(R.id.toolbar);
        recy_subjects= (RecyclerView)findViewById(R.id.recy);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
    }

    private void setPropertiesRecycler(){
        SubjectRecyclerAdapter adapter = new SubjectRecyclerAdapter(this, listDummy());
        recy_subjects.setHasFixedSize(true);
        recy_subjects.setLayoutManager(new LinearLayoutManager(this));
        recy_subjects.setAdapter(adapter);
    }

    //TODO:Obtener la verdadera lista Dummy
    private List<Category> listDummy(){
        List<Category> categoryList = new ArrayList<>();
        for(int i =0; i<10; i++){
            categoryList.add(new Category(getColors(i)));
        }
        return categoryList;
    }

    private void effect(View view){
        RecyclerView recy_sections= (RecyclerView)view.findViewById(R.id.recy);
        if(recy_sections.getVisibility()==View.VISIBLE){
            recy_sections.setVisibility(View.GONE);
        }else recy_sections.setVisibility(View.VISIBLE);
    }

    private String getColors(int position) {
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subject, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
