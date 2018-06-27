package complement.merci.app.mercciapp.Cinturones;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import complement.merci.app.mercciapp.FragmentInfo;
import complement.merci.app.mercciapp.Informacion;
import complement.merci.app.mercciapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCinturones extends Fragment {

    RecyclerView rv;
    String [] titles, subtitles, sub;
    int[] images, img1, img2;
    Informacion info;
    Bundle args;
    FragmentInfo fragment;


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
                        img1 = new int[]{R.drawable.correa1};
                        info = new Informacion(getString(R.string.cinturones),img1, "SKU: CIC03-1",
                                titles[0], subtitles[0], getString(R.string.descripCinturonAzul), 61000, 0);
                        args = new Bundle();
                        args.putSerializable("data", info);
                        fragment = new FragmentInfo();
                        fragment.setArguments(args);

                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).addToBackStack(null).commit();
                        break;
                    case 1:
                        img2 = new int[]{R.drawable.correa2};
                        info = new Informacion(getString(R.string.cinturones),img2, "SKU: CIC03-2",
                                titles[1], subtitles[1], getString(R.string.descripCinturonBlanco), 30000, 0);
                        args = new Bundle();
                        args.putSerializable("data", info);
                        fragment = new FragmentInfo();
                        fragment.setArguments(args);

                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).addToBackStack(null).commit();
                        break;
                }
            }
        });
        return view;

    }

}
