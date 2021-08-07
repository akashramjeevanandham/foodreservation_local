package com.akash.second.ui.addcart;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.akash.second.ui.Dbhandler.DBHandler;

import java.util.ArrayList;
import java.util.List;


public class AddcartViewModel extends ViewModel {

    private MutableLiveData<List<addcartfood>> mText;
    private DBHandler DB;
    private List<addcartfood> list;

    public AddcartViewModel() {

        mText = new MutableLiveData<>();

        list=new ArrayList<>();
        list.add(new addcartfood(0,"default",2,8));
        mText.setValue(list);

    }
    public int gettotal(Context context){
        DB=new DBHandler(context);
       int total= DB.gettotalprice();
       return total;

    }

    public LiveData<List<addcartfood>> getText() {
        return mText;
    }
}