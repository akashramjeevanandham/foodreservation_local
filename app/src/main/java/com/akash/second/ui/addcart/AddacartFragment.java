package com.akash.second.ui.addcart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akash.second.R;
import com.akash.second.databinding.FragmentAddcartBinding;
import com.akash.second.ui.Dbhandler.DBHandler;
import com.akash.second.ui.home.foods;
import com.akash.second.ui.home.recycleviewAdapter;

import java.util.List;

public class AddacartFragment extends Fragment {

    private AddcartViewModel addcartViewModel;
    private FragmentAddcartBinding binding;
    private addrecyclerviewAdapter recycleadapt;
    private RecyclerView addcartview;
    private DBHandler mydb;
    private List<addcartfood> useradd;
    private TextView priceval;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addcartViewModel =
                new ViewModelProvider(this).get(AddcartViewModel.class);

        binding = FragmentAddcartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        addcartview=root.findViewById(R.id.addcardfood);
        TextView headtxt=root.findViewById(R.id.toptext);
        TextView pricetxt=root.findViewById(R.id.pricetxt);
         priceval=root.findViewById(R.id.totalprice);
        addcartViewModel.getText().observe(getViewLifecycleOwner(),updatedpage);

        return root;
    }
    private Observer<List<addcartfood>>updatedpage = new Observer<List<addcartfood>>() {
        @Override
        public void onChanged(List<addcartfood> arrfood) {
            mydb = new DBHandler(getActivity());
            //arr3=new ArrayList<>();
            recycleadapt = new addrecyclerviewAdapter(getContext());
            useradd = mydb.getAlladdcart();
            recycleadapt.setaddcartfood(useradd);
            priceval.setText(String.valueOf(addcartViewModel.gettotal(getActivity())));
            addcartview.setLayoutManager(new LinearLayoutManager(getContext()));
            addcartview.setAdapter(recycleadapt);

        }

    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}