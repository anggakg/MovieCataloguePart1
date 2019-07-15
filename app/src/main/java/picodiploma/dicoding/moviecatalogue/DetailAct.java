package picodiploma.dicoding.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailAct extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    ImageView mvPhoto, mvDetailPhoto;
    TextView mvName, mvGenre, mvDate, mvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mvPhoto = findViewById(R.id.mv_photo);
        mvName = findViewById(R.id.mv_name);
        mvGenre = findViewById(R.id.mv_genre);
        mvDate = findViewById(R.id.mv_date);
        mvDesc = findViewById(R.id.mv_desc);
        mvDetailPhoto = findViewById(R.id.mv_detail_photo);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        Picasso.get().load(movie.getPhoto()).fit().centerCrop().into(mvPhoto);
        Picasso.get().load(movie.getPhoto()).fit().centerCrop(Gravity.TOP).into(mvDetailPhoto);
        mvName.setText(movie.getName());
        mvGenre.setText(movie.getGenre());
        mvDate.setText(movie.getDate());
        mvDesc.setText(movie.getDesc());


    }
}
