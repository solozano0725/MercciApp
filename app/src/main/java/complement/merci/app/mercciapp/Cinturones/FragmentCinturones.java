package complement.merci.app.mercciapp.Cinturones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        RVCinturones adapter = new RVCinturones(getContext().getApplicationContext(), titles, subtitles, sub, images);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext().getApplicationContext(), 2));
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = rv.getChildLayoutPosition(v);
                switch(pos){
                    case 0:
                        break;
                    case 1:
                        break;
                }
            }
        });
        return view;

    }

}
