package complement.merci.app.mercciapp.Cinturones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import complement.merci.app.mercciapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCinturones extends Fragment {

    RecyclerView rv;
    String [] titles, subtitles, sub;
    int[] images;

    public FragmentCinturones() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_cinturones, container, false);
        rv = view.findViewById(R.id.rvCin);
        images = new int[]{R.drawable.correa1, R.drawable.correa2};
        titles = view.getResources().getStringArray(R.array.titleCinturon);
        subtitles = view.getResources().getStringArray(R.array.subTCinturon);
        sub = view.getResources().getStringArray(R.array.subCinturon);
        rv.setAdapter(new RVCinturones(getContext().getApplicationContext(), titles, subtitles, sub, images));
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext().getApplicationContext(), 2));
        return view;

    }

}
