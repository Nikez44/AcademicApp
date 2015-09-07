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
import com.example.user.academicapp.adapters.CategoryAdapter;
import com.example.user.academicapp.fragments.NavigationDrawerFragment;
import com.example.user.academicapp.helpers.RecyclerItemClickListener;
import com.example.user.academicapp.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recy_subjects;
    private DrawerLayout drawerLayout;
    private NavigationDrawerFragment drawerFragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
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
        CategoryAdapter adapter = new CategoryAdapter(this, listDummy());
        recy_subjects.setHasFixedSize(true);
        recy_subjects.setLayoutManager(new LinearLayoutManager(this));
        recy_subjects.setAdapter(adapter);
    }

    //TODO:Obtener la verdadera lista Dummy
    private List<Category> listDummy(){
        List<Category> categoryList = new ArrayList<>();

        String [] names = { "Sentido Númerico",
                            "Pensamiento Algebraico",
                            "Forma",
                            "Espacio",
                            "Medida",
                            "Manejo de la información",
                            "Name 7",
                            "Name 8",
                            "Name 9",
                            "Name 10" };

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

        for(int i =0; i<colors.length && i<names.length; i++){
            categoryList.add(new Category(names[i], colors[i]));
        }
        return categoryList;
    }

    private void effect(View view){
        RecyclerView recy_sections= (RecyclerView)view.findViewById(R.id.recy);
        if(recy_sections.getVisibility()==View.VISIBLE){
            recy_sections.setVisibility(View.GONE);
        }else recy_sections.setVisibility(View.VISIBLE);
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
