package complement.merci.app.mercciapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInfo extends Fragment {


    public FragmentInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_info, container, false);
        Bundle args = getArguments();
        Informacion info = (Informacion) args.getSerializable("data");

        Log.i("data", info.getNameI());
        return view;
    }

}
