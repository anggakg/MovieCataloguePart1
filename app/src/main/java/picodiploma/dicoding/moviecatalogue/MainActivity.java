package picodiploma.dicoding.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] movieName;
    private String[] movieDate;
    private String[] movieGenre;
    private String[] movieDesc;
    private TypedArray moviePhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movieArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movieArrayList.get(i).getName(), Toast.LENGTH_SHORT).show();
                Intent detailMovie = new Intent(MainActivity.this, DetailAct.class);
                detailMovie.putExtra(DetailAct.EXTRA_MOVIE, movieArrayList.get(i));
                startActivity(detailMovie);
            }
        });
    }

    private void addItem(){
        movieArrayList = new ArrayList<>();

        for(int i = 0; i < movieName.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(moviePhoto.getResourceId(i,-1));
            movie.setName(movieName[i]);
            movie.setDate(movieDate[i]);
            movie.setGenre(movieGenre[i]);
            movie.setDesc(movieDesc[i]);
            movieArrayList.add(movie);
        }
        adapter.setMovies(movieArrayList);
    }

    private void prepare(){
        movieName = getResources().getStringArray(R.array.movie_name);
        movieDate = getResources().getStringArray(R.array.movie_date);
        movieGenre = getResources().getStringArray(R.array.movie_genre);
        movieDesc = getResources().getStringArray(R.array.movie_desc);
        moviePhoto = getResources().obtainTypedArray(R.array.movie_photo);
    }
}
