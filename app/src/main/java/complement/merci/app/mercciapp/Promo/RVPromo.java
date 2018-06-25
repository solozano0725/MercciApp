package complement.merci.app.mercciapp.Promo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import complement.merci.app.mercciapp.R;

public class RVPromo extends RecyclerView.Adapter<VHPromo> implements View.OnClickListener{

    LayoutInflater inflater;
    Context context;
    View.OnClickListener listener;

    public RVPromo(Context c){
        this.context = c;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public VHPromo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_promo, parent, false);
        view.setOnClickListener(this);
        return new VHPromo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHPromo holder, int position) {
        switch (position){
            case 0:
                holder.imageView.setImageResource(R.drawable.promo1);
                break;
            case 1:
                holder.imageView.setImageResource(R.drawable.promo2);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

}


