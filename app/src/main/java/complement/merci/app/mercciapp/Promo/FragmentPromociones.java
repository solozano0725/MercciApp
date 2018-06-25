package complement.merci.app.mercciapp.Promo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import complement.merci.app.mercciapp.R;


public class FragmentPromociones extends Fragment {

    RecyclerView rv;

    public FragmentPromociones() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_promociones, container, false);
        rv = view.findViewById(R.id.rvP);
        rv.setAdapter(new RVPromo(getContext().getApplicationContext()));
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        return view;
    }

}
