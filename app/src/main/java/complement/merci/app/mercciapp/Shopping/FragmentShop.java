package complement.merci.app.mercciapp.Shopping;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.valdesekamdem.library.mdtoast.MDToast;

import complement.merci.app.mercciapp.BolsosCarteras.FragmentBolsos;
import complement.merci.app.mercciapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentShop extends Fragment {

    RecyclerView rv;
    TextView total;
    Button btnContinuar, btnFinalizar;
    Compras c;
    double t;
    public FragmentShop() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_shop, container, false);
        rv = view.findViewById(R.id.rvShop);
        total = view.findViewById(R.id.txtTotal);
        btnContinuar = view.findViewById(R.id.btnContinuar);
        btnFinalizar = view.findViewById(R.id.btnFinalizar);
        c = new Compras();
        RVShop adapter = new RVShop(getContext().getApplicationContext(), c.getTotalCompra());
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));

        for(int i = 0; i<c.getTotalCompra().size(); i++){
            t+=c.getTotalCompra().get(i).getPrice()*c.getTotalCompra().get(i).getCant();
        }

        total.setText("$ "+String.valueOf(t));

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new FragmentBolsos()).addToBackStack(null).commit();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MDToast mdToast = MDToast.makeText(getActivity().getApplicationContext(), "Felicidades por su compra!", MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS);
                mdToast.show();
            }
        });
        return view;
    }

}
