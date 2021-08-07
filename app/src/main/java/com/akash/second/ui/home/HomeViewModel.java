package com.akash.second.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.akash.second.ui.Dbhandler.DBHandler;

import java.util.ArrayList;
import java.util.List;



public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<foods>>food;
    private List<foods>arrfood,arrfood2;
    private MutableLiveData<String> STR;

    public HomeViewModel() {
        food = new MutableLiveData<>();
        STR=new MutableLiveData<>();
        STR.setValue("hello");

        init();

    }

    public MutableLiveData<List<foods>> getfood() {
        return food;
    }

    public MutableLiveData<String> getSTR() {

        return STR;
    }

    private void init(){
        populateList();
        food.setValue(arrfood2);
    }

    private void populateList(){

      // foods f=new foods();
        //f.setFoodName("PEAKY BLINDERS");
       //f.setImageurl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/peaky-blinders-1614180392.jpg");
       //f.setShortdesc("wifuwfji38jio340jk3iioji4jk42p292");
       //f.setLongdesc(" Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani origin set in Birmingham, England, in 1919, several months after the end of the");
        arrfood2=new ArrayList<>();
        arrfood2.add(new foods(0,"PEAKY BLINDERS","https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/peaky-blinders-1614180392.jpg","Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani ..."," Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani origin set in Birmingham, England, in 1919, several months after the end of the",10,10));
//       arrfood2.add(new foods("\t\t\tGOT","https://wallpapercave.com/wp/wp6668390.jpg","Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani ..."," Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani origin set in Birmingham, England, in 1919, several months after the end of the"));
//        arrfood2.add(new foods("BREAKINNG BAD ","https://wallpaperaccess.com/full/781822.jpg","Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani ..."," Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani origin set in Birmingham, England, in 1919, several months after the end of the"));
//        arrfood2.add(new foods("SEXEDUCATION ","https://wallpapercave.com/wp/wp4726317.jpg","Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani ..."," Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani origin set in Birmingham, England, in 1919, several months after the end of the"));
//       arrfood2.add(new foods("\tSHADOWBONE ","https://wallpapercave.com/wp/wp8781052.jpg","Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani ..."," Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani origin set in Birmingham, England, in 1919, several months after the end of the"));
//        arrfood2.add(new foods("\t\tDARK     ","https://wallpapercave.com/wp/wp4056399.jpg","Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani ..."," Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani origin set in Birmingham, England, in 1919, several months after the end of the"));
//        arrfood2.add(new foods(" \tLUCIFIER   ","https://pavbca.com/walldb/original/c/b/3/565434.jpg","Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani ...", " Peaky Blinders is an epic following of a gangster family of Irish Traveller or Romani origin set in Birmingham, England, in 1919, several months after the end of the"));

    }

}