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
                        info = new Informacion("Bolso", img1, "SKU: BC01-1",
                        "BOLSO NAUS", "COMBINADO", "Esta colección está dedicada a las mujeres arriesgadas , gracias a su personalidad y carácter innovador, las combinaciones tricolores y los detalles modernos en el diseño de este bolso lo hace la elección acertada, su tamaño es de  30X44 , los materiales son sintéticos , vistas de cremallera con cremallera de cobre , bolsillo interino picado.", 251.000);
                        args = new Bundle();
                        args.putSerializable("data", info);
                        fragment = new FragmentInfo();
                        fragment.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).addToBackStack(null).commit();
                        break;
                    case 1:
                        img2 = new int[]{R.drawable.bolso2, R.drawable.bolso21, R.drawable.bolso22, R.drawable.bolso23};
                        info = new Informacion("Bolso", img2, "SKU: BC01-2",
                                "BOLSO POLIM", "COMBINADO", "Esta colección está dedicada a las mujeres arriesgadas , gracias a su personalidad y carácter innovador, las combinaciones tricolores y los detalles modernos en el diseño de este bolso lo hace la elección acertada, su tamaño es de  32 X44 , los materiales son sintéticos , vistas de cremallera con cremallera de cobre , bolsillo interino picado.", 81.000);
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
