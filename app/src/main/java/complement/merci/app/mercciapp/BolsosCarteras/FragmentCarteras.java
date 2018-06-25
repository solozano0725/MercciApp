package complement.merci.app.mercciapp.BolsosCarteras;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import complement.merci.app.mercciapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCarteras extends Fragment {

    RecyclerView rv;
    String [] titles, subtitles;
    int[] images;
    public FragmentCarteras() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_carteras, container, false);
        rv = view.findViewById(R.id.rvCar);
        images = new int[]{R.drawable.cartera1, R.drawable.cartera2};
        titles = view.getResources().getStringArray(R.array.titleCarteras);
        subtitles = view.getResources().getStringArray(R.array.subCarteras);
        rv.setAdapter(new RVBolsosCarteras(getContext().getApplicationContext(), titles, subtitles, images));
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext().getApplicationContext(), 2));
        return view;}

}
