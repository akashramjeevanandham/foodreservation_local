package com.akash.second.ui.addnew;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.akash.second.R;
import com.akash.second.databinding.FragmentAddnewBinding;
import com.akash.second.ui.Dbhandler.DBHandler;
import com.akash.second.ui.home.HomeViewModel;

import java.util.ArrayList;

public class AddnewFragment extends Fragment {

    //private AddnewViewModel addnewViewModel;
    private FragmentAddnewBinding binding;
    private EditText Name, imageurl,short_description,long_description,price_val,available_val;
    private Button additemBtn;
    private DBHandler dbHandler;
    private HomeViewModel homeViewModel ;

    private ArrayList<String> adddata;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       // addnewViewModel =
            //    new ViewModelProvider(this).get(AddnewViewModel.class);



        binding = FragmentAddnewBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Name=root.findViewById(R.id.foodname_text);
        imageurl = root.findViewById(R.id.imageurl_text);
        short_description = root.findViewById(R.id.short_text);
        long_description =root.findViewById(R.id.long_text);
        price_val=root.findViewById(R.id.price_text);
        available_val=root.findViewById(R.id.available_text);
        additemBtn =root.findViewById(R.id.BtnAdditem);

        dbHandler=new DBHandler(getActivity());


        additemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=Name.getText().toString();
                String Imageurl=imageurl.getText().toString();
                String shortdes=short_description.getText().toString();
                String longsesc=long_description.getText().toString();
                int price= Integer.parseInt(price_val.getText().toString());
                int available= Integer.parseInt(available_val.getText().toString());

                dbHandler.addNewitem(name,Imageurl,shortdes,longsesc,price,available);

            }
        });

//
//        adddata=new ArrayList<>();
//        adddata.add(Name.getText().toString());
//        adddata.add(imageurl.getText().toString());
//        adddata.add (description.getText().toString());
//        adddata.add(quantityt.getText().toString());



        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}