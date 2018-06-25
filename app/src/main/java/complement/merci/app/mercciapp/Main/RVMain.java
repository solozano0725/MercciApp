package complement.merci.app.mercciapp.Main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import complement.merci.app.mercciapp.R;

public class RVMain extends RecyclerView.Adapter<VHMain> implements View.OnClickListener{

    LayoutInflater inflater;
    Context context;
    View.OnClickListener listener;
    String[] titles;

    public RVMain(Context c){
        this.context = c;
        this.titles = context.getResources().getStringArray(R.array.titleMains);
        inflater=LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public VHMain onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_main, parent, false);
        view.setOnClickListener(this);
        return new VHMain(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHMain holder, int position) {
        holder.title.setText(titles[position].toString());
        switch (position){
            case 0:
                holder.imageView.setImageResource(R.drawable.main1);
                break;
            case 1:
                holder.imageView.setImageResource(R.drawable.main2);
                break;
            case 2:
                holder.imageView.setImageResource(R.drawable.main3);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
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
