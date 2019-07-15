package picodiploma.dicoding.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Movie> movies;

    MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder{
        private TextView txtName;
        private TextView txtDate;
        private TextView txtGenre;
        private TextView txtDesc;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_name);
            txtDate = view.findViewById(R.id.txt_date);
            txtGenre = view.findViewById(R.id.txt_genre);
//            txtDesc = view.findViewById(R.id.txt_desc);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Movie movie){
            txtName.setText(movie.getName());
            txtDate.setText(movie.getDate());
            txtGenre.setText(movie.getGenre());
//            txtDesc.setText(movie.getDesc());
            Picasso.get().load(movie.getPhoto()).fit().centerCrop().into(imgPhoto);
        }
    }
}
