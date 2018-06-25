package complement.merci.app.mercciapp.Promo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import complement.merci.app.mercciapp.R;

public class VHPromo extends RecyclerView.ViewHolder{

    ImageView imageView;

    public VHPromo(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imgP);
    }
}
