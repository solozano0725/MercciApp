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
public class FragmentBolsos extends Fragment {

    RecyclerView rv;
    String [] titles, subtitles;
    int[] images;
    public FragmentBolsos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_bolsos, container, false);
        rv = view.findViewById(R.id.rvBol);
        images = new int[]{R.drawable.bolso1, R.drawable.bolso2};
        titles = view.getResources().getStringArray(R.array.titleBolsos);
        subtitles = view.getResources().getStringArray(R.array.subBolsos);
        rv.setAdapter(new RVBolsosCarteras(getContext().getApplicationContext(), titles, subtitles, images));
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext().getApplicationContext(), 2));
        return view;
    }

}
