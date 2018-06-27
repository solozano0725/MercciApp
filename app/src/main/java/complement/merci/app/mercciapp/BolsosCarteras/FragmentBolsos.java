package complement.merci.app.mercciapp.BolsosCarteras;


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
public class FragmentBolsos extends Fragment {

    RecyclerView rv;
    String [] titles, subtitles;
    int[] images, img1, img2;
    Informacion info;
    Bundle args;
    FragmentInfo fragment;

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
        RVBolsosCarteras adapter = new RVBolsosCarteras(getContext().getApplicationContext(), titles, subtitles, images);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext().getApplicationContext(), 2));


        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = rv.getChildLayoutPosition(v);
                switch(pos){
                    case 0:
                        img1 = new int[]{R.drawable.bolso1, R.drawable.bolso12, R.drawable.bolso13, R.drawable.bolso14};
                        info = new Informacion(getString(R.string.bolsos),img1, "SKU: BC01-1",
                                titles[0], getString(R.string.combinado), getString(R.string.descripBolsosNaus), 251000, 0);
                        args = new Bundle();
                        args.putSerializable("data", info);
                        fragment = new FragmentInfo();
                        fragment.setArguments(args);

                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).addToBackStack(null).commit();
                        break;
                    case 1:
                        img2 = new int[]{R.drawable.bolso2, R.drawable.bolso21, R.drawable.bolso22, R.drawable.bolso23};
                        info = new Informacion(getString(R.string.bolsos), img2, "SKU: BC01-2",
                                titles[1], getString(R.string.combinado), getString(R.string.descripBolsoPolim), 81000, 0);
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
