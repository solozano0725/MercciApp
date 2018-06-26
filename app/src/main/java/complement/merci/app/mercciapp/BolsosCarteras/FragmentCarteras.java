package complement.merci.app.mercciapp.BolsosCarteras;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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
                        break;
                    case 1:
                        break;
                }
            }
        });
        return view;}

}
