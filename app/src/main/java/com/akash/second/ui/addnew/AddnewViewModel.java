package com.akash.second.ui.addnew;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.akash.second.ui.home.foods;
import com.akash.second.ui.home.HomeViewModel;

import java.util.List;

public class AddnewViewModel extends ViewModel {

    private MutableLiveData<List<foods>> food;
    private List<foods> arrfood;
    private HomeViewModel homeViewModel;

    public AddnewViewModel(List<foods> value) {
        food = new MutableLiveData<>();
    }

    public MutableLiveData<List<foods>> getfood() {
        return food;
    }
}