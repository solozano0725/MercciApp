package complement.merci.app.mercciapp.BolsosCarteras;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import complement.merci.app.mercciapp.R;

public class VHBolsosCarteras extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView txtTitle;
    TextView txtSubTitle;

    public VHBolsosCarteras(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imgBC);
        txtTitle = (TextView) itemView.findViewById(R.id.titleBC);
        txtSubTitle = (TextView) itemView.findViewById(R.id.subBC);
    }
}