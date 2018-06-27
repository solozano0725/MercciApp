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
public class FragmentCarteras extends Fragment {

    RecyclerView rv;
    String [] titles, subtitles;
    int[] images, img1, img2;
    Informacion info;
    Bundle args;
    FragmentInfo fragment;

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
        final RVBolsosCarteras adapter =new RVBolsosCarteras(getContext().getApplicationContext(), titles, subtitles, images);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext().getApplicationContext(), 2));
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = rv.getChildLayoutPosition(v);
                switch(pos){
                    case 0:
                        img1 = new int[]{R.drawable.cartera1, R.drawable.cartera11, R.drawable.cartera12, R.drawable.cartera13};
                        info = new Informacion(getString(R.string.carteras),img1, "SKU: CC02-1",
                                titles[0], getString(R.string.combinado), getString(R.string.descripCarteraNaus), 151000, 0);
                        args = new Bundle();
                        args.putSerializable("data", info);
                        fragment = new FragmentInfo();
                        fragment.setArguments(args);

                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).addToBackStack(null).commit();
                        break;
                    case 1:
                        img2 = new int[]{R.drawable.cartera2, R.drawable.cartera21, R.drawable.cartera22, R.drawable.cartera23};
                        info = new Informacion(getString(R.string.carteras),img2, "SKU: CC02-2",
                                titles[1], getString(R.string.combinado), getString(R.string.descripCarteraPolim), 62000, 0);
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
