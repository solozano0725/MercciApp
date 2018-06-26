package complement.merci.app.mercciapp.Cinturones;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import complement.merci.app.mercciapp.R;

public class RVCinturones extends RecyclerView.Adapter<VHCinturones> implements View.OnClickListener{

    LayoutInflater inflater;
    Context context;
    View.OnClickListener listener;
    String[] titles, subtitles, sub;
    int [] image;
    public RVCinturones(Context c, String[] t, String[] s, String[] st, int[] img){
        this.context = c;
        inflater=LayoutInflater.from(context);
        titles = t;
        subtitles = s;
        sub = st;
        image = img;
    }

    @NonNull
    @Override
    public VHCinturones onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_cinturones, parent, false);
        view.setOnClickListener(this);
        return new VHCinturones(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHCinturones holder, int position) {
        switch (position){
            case 0:
                holder.imageView.setImageResource(image[position]);
                holder.txtTitle.setText(titles[position].toString());
                holder.txtSubTitle.setText(subtitles[position].toString());
                holder.txtSub.setText(sub[position].toString());
                break;
            case 1:
                holder.imageView.setImageResource(image[position]);
                holder.txtTitle.setText(titles[position].toString());
                holder.txtSubTitle.setText(subtitles[position].toString());
                holder.txtSub.setText(sub[position].toString());
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