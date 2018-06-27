package complement.merci.app.mercciapp.Shopping;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import complement.merci.app.mercciapp.R;

public class VHShop extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView txtTitle;
    TextView txtCant;
    TextView txtPrice;

    public VHShop(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imgS);
        txtTitle = (TextView) itemView.findViewById(R.id.titleS);
        txtCant = (TextView) itemView.findViewById(R.id.cantS);
        txtPrice = (TextView) itemView.findViewById(R.id.priceS);

    }
}
