package complement.merci.app.mercciapp.Shopping;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import complement.merci.app.mercciapp.R;

public class RVShop extends RecyclerView.Adapter<VHShop> implements View.OnClickListener{

    LayoutInflater inflater;
    Context context;
    View.OnClickListener listener;
    ArrayList<Venta> arrayList;

    public RVShop(Context c, ArrayList<Venta> arrayList){
        this.context = c;
        inflater=LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public VHShop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_shop, parent, false);
        view.setOnClickListener(this);
        return new VHShop(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHShop holder, int position) {

        if(arrayList.get(position).getCant()!=0)
        {
            holder.imageView.setImageResource(arrayList.get(position).getImg());
            holder.txtTitle.setText(arrayList.get(position).getTitle());
            holder.txtPrice.setText(String.valueOf(arrayList.get(position).getPrice()));
            holder.txtCant.setText(String.valueOf(arrayList.get(position).getCant()));
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();

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
