package com.akash.second.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.akash.second.R;
import com.akash.second.databinding.FragmentHomeBinding;
import com.akash.second.ui.Dbhandler.DBHandler;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    public RecyclerView breakfastview;
    private recycleviewAdapter adapter1;
    private ArrayList<String> arr3;
    private List<foods> org;
    private DBHandler mydb;
    private TextView notifytxt;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        breakfastview = (RecyclerView)root.findViewById(R.id.foodview2);
        breakfastview.setHasFixedSize(false);
        notifytxt=(TextView) root.findViewById(R.id.notitext);
        this.setHasOptionsMenu(true);
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.getfood().observe(getViewLifecycleOwner(), foodlistupdate);






        return root;

    }
     private Observer<List<foods>>foodlistupdate = new Observer<List<foods>>() {
        @Override
        public void onChanged(List<foods> arrfood) {
            mydb= new DBHandler(getActivity());
           //arr3=new ArrayList<>();
            adapter1=new recycleviewAdapter(getContext());
           org=mydb.getAllitems();

                 notifytxt.setVisibility(View.GONE);
                 adapter1.setfood(org);
                breakfastview.setAdapter(adapter1);


//           else
//               {
//                   org=new ArrayList<>();
//
//                   for(int i=1;i<arr3.size();i++){
//                       String str[]=arr3.get(i).split(",");
//                       org.add(new foods(str[1],str[2],str[3],str[4]));
//               }





        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}