package complement.merci.app.mercciapp.Cinturones;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import complement.merci.app.mercciapp.R;

public class VHCinturones extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView txtTitle;
    TextView txtSubTitle;
    TextView txtSub;

    public VHCinturones(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imgC);
        txtTitle = (TextView) itemView.findViewById(R.id.titleC);
        txtSubTitle = (TextView) itemView.findViewById(R.id.subTC);
        txtSub = (TextView) itemView.findViewById(R.id.subC);
    }
}
