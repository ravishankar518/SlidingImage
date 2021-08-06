package com.example.slidingimagewithsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private RecyclerView mRecyclerView;
    private ListAdapter listAdapter;
    ArrayList<Student> studentList;
    ArrayList<String> name =new ArrayList<>();
    ArrayList<Integer> image =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name.add("raju");
        name.add("ravi");
        name.add("sujata");
        name.add("golu");
        name.add("shankar");
        name.add("pradeep");
        name.add("abhi");
        name.add("sohan");
        name.add("mohan");
        name.add("kamlesh");

        image.add(R.drawable.one);
        image.add(R.drawable.two);
        image.add(R.drawable.three);


        initCarousel();
    }


    private void initCarousel() {

        studentList = new ArrayList<>();

        listAdapter = new ListAdapter(studentList);

        ((EditText) findViewById(R.id.et_search)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                listAdapter.getFilter().filter(s);
            }
        });

        final ArrayList<Carousel> carousels = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            ArrayList<Student> students = new ArrayList<>();

            for (int y = 1; y < 10; y++) {
               students.add(new Student("" + name.get(y) + " c" + i, "http://placehold.it/120x120&text=image" + y));
            }

           carousels.add(new Carousel("http://placehold.it/400x150&text=image" + i, students));


        }

        studentList.addAll(carousels.get(0).getStudents());

        mViewPager = findViewById(R.id.viewPager);
        mRecyclerView = findViewById(R.id.rv);
        mViewPager.setAdapter(new CarouselAdapter(this, carousels));

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(listAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                studentList.clear();
                studentList.addAll(carousels.get(position).getStudents());
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}