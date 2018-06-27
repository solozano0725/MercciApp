package complement.merci.app.mercciapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.valdesekamdem.library.mdtoast.MDToast;

import complement.merci.app.mercciapp.Shopping.Compras;
import complement.merci.app.mercciapp.Shopping.Venta;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInfo extends Fragment {

    CarouselView carouselView;

    TextView txtTitleClass, txtRef, txtTitle, txtColor, txtDescripcion, txtPrice;
    ImageView btnPlus, btnMinus;
    EditText editCant;
    Informacion info;
    int cant;
    ImageButton btnComprar;
    Compras c;

    public FragmentInfo() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_info, container, false);
        c = new Compras();
        txtTitleClass = view.findViewById(R.id.txtTitleClass);
        txtRef = view.findViewById(R.id.txtRefI);
        txtTitle = view.findViewById(R.id.txtTitleI);
        txtColor = view.findViewById(R.id.txtColorI);
        txtDescripcion = view.findViewById(R.id.txtDesc);
        txtPrice = view.findViewById(R.id.txtPrecioI);
        btnPlus = view.findViewById(R.id.imgPlus);
        btnMinus = view.findViewById(R.id.imgMinus);
        carouselView = view.findViewById(R.id.carouselView);
        editCant = view.findViewById(R.id.editCantidad);
        btnComprar = view.findViewById(R.id.btnComprar);
        Bundle args = getArguments();
        info = (Informacion) args.getSerializable("data");

        txtTitleClass.setText(info.getTitleClass());
        txtRef.setText(info.getRef());
        txtTitle.setText(info.getNameI());
        txtColor.setText(info.getColorI());
        txtDescripcion.setText(info.getDescI());
        txtPrice.setText("$ "+info.getPriceI());
        editCant.setText(String.valueOf(info.getCantI()));
        carouselView.setPageCount(info.getImg().length);
        carouselView.setImageListener(imageListener);

        cant = info.getCantI();

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cant++;
                editCant.setText(String.valueOf(cant));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cant--<0){
                    cant = 0;
                } else{
                    cant--;
                }

                editCant.setText(String.valueOf(cant));
            }
        });

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Venta ve = new Venta(info.getImg()[0], info.getNameI(), info.getPriceI(), cant);
                if(c.getTotalCompra().size() == 0){
                    c.addCompra(ve);
                    MDToast mdToast = MDToast.makeText(getActivity().getApplicationContext(), "Felicidades por su eleccion! Le invitamos a revisar su carrito en el menu principal.", MDToast.LENGTH_SHORT, MDToast.TYPE_INFO);
                    mdToast.show();
                } else{
                    for(int i=0; i<c.getTotalCompra().size();i++){
                        if(c.getTotalCompra().get(i).getTitle().equalsIgnoreCase(info.getNameI())){
                            c.getTotalCompra().get(i).setCant(c.getTotalCompra().get(i).getCant()+cant);
                            break;
                        } else if(cant!=0){
                            c.addCompra(ve);
                            MDToast mdToast = MDToast.makeText(getActivity().getApplicationContext(), "Felicidades por su eleccion! Le invitamos a revisar su carrito en el menu principal.", MDToast.LENGTH_SHORT, MDToast.TYPE_INFO);
                            mdToast.show();
                            break;
                        }
                    }
                }

            }
        });
        return view;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(info.getImg()[position]);

        }
    };
}
