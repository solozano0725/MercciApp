package complement.merci.app.mercciapp.Main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import complement.merci.app.mercciapp.R;

public class VHMain extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView title;

    public VHMain(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imgM);
        title = (TextView) itemView.findViewById(R.id.txtM);
    }
}
