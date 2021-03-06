package com.adafruit.bluefruit.le.connect.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.adafruit.bluefruit.le.connect.converter.DateConverter;
import com.adafruit.bluefruit.le.connect.contract.Contract;


/**
 * Created by sqz on 2017/3/7.
 *
 */

public class SharedPreferencesTool {

    private static SharedPreferences sp;

    public static com.adafruit.bluefruit.le.connect.utils.SharedPreferencesTool RCConfig(Context context) {
        sp = context.getSharedPreferences(Contract.RAMOC_Config, Context.MODE_PRIVATE);
        return new com.adafruit.bluefruit.le.connect.utils.SharedPreferencesTool();
    }


    public static com.adafruit.bluefruit.le.connect.utils.SharedPreferencesTool ACConfig(Context context) {
        sp = context.getSharedPreferences(Contract.APP_Config, Context.MODE_PRIVATE);
        return new com.adafruit.bluefruit.le.connect.utils.SharedPreferencesTool();
    }


    public void saveDeviceStatus(Boolean value) {
        if (sp != null) {
            sp.edit().putBoolean(Contract.DEVICE_STATUS,value).apply();
        }
    }

    public Boolean findDeviceStatus(){
        return sp.getBoolean(Contract.DEVICE_STATUS,false);
    }


    public void saveBell(Boolean value) {
        if (sp != null) {
            sp.edit().putBoolean(Contract.BELL,value).apply();
        }
    }

    public Boolean findBell() {
        return sp.getBoolean(Contract.BELL,false);
    }

    public void saveVibration(Boolean value) {
        if (sp != null) {
            sp.edit().putBoolean(Contract.VIBRATION,value).apply();
        }
    }

    public Boolean findVibration() {
        return sp.getBoolean(Contract.VIBRATION,true);
    }

    public void saveBackLightTime(int value) {
        if (sp != null) {
            sp.edit().putInt(Contract.BACK_LIGHT_TIME,value).apply();
        }
    }

    public int findBackLightTime() {
        return sp.getInt(Contract.BACK_LIGHT_TIME,0);
    }


    public void saveVersionCode(int value) {
        if (sp != null) {
            sp.edit().putInt(Contract.VERSION_CODE,value).apply();
        }
    }

    public int findVersionCode() {
        return sp.getInt(Contract.VERSION_CODE,0);
    }


    public void saveVersionName(String value) {
        if (sp != null) {
            sp.edit().putString(Contract.VERSION_NAME,value).apply();
        }
    }

    public String findVersionName() {
        return sp.getString(Contract.VERSION_NAME,"");
    }


    public void saveWornNotify(Boolean value) {
        if (sp != null) {
            sp.edit().putBoolean(Contract.WORN_NOTIFY,value).apply();
        }
    }

    public Boolean findWornNotify() {
        return sp.getBoolean(Contract.WORN_NOTIFY,true);
    }


    public void saveWornSound(Boolean value) {
        if (sp != null) {
            sp.edit().putBoolean(Contract.WORN_SOUND,value).apply();
        }
    }

    public Boolean findWornSound() {
        return sp.getBoolean(Contract.WORN_SOUND,true);
    }

    public void saveWornValue(String value) {
        if (sp != null) {
            sp.edit().putString(Contract.WORN_VALUE,value).apply();
        }
    }

    public String findWornValue() {
        return sp.getString(Contract.WORN_VALUE,"0.00");
    }


    public void saveWornUnit(int value) {
        if (sp != null) {
            sp.edit().putInt(Contract.WORN_UNIT,value).apply();
        }
    }

    public int findWornUnit() {
        return sp.getInt(Contract.WORN_UNIT,0);
    }



    public void saveDoseWornValue(String value) {
        if (sp != null) {
            sp.edit().putString(Contract.WORN_DOSE_VALUE,value).apply();
        }
    }


    public String findDoseWornValue() {
        return sp.getString(Contract.WORN_DOSE_VALUE,"0.00");
    }


    public void saveDoseWornUnit(int value) {
        if (sp != null) {
            sp.edit().putInt(Contract.WORN_DOSE_UNIT,value).apply();
        }
    }

    public int findDoseWornUnit() {
        return sp.getInt(Contract.WORN_DOSE_UNIT,0);
    }


    public void saveIsFirst(Boolean b) {
        if (sp != null) {
            sp.edit().putBoolean(Contract.IS_FIRST,b).apply();
        }
    }

    public Boolean findIsFirst() {
        return sp.getBoolean(Contract.IS_FIRST,true);
    }

    public void saveFirstDate(String date) {
        if (sp != null) {
            sp.edit().putString(Contract.FIRST_DATE,date).apply();
        }
    }

    public Date findFirstDate() {
        DateConverter dateConverter = new DateConverter();
        Date date = new Date();
        try {
            return DateUtils.getInstance().setDateString(sp.getString(Contract.FIRST_DATE,""))
                    .dateStrToDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public void saveMapType(int type) {
        if (sp != null) {
            sp.edit().putInt(Contract.MAP_TYPE,type).apply();
        }
    }


    public int findMapType() {
        return sp.getInt(Contract.MAP_TYPE,Contract.GAO_DE);
    }


    /**
     * ??????????????????
     * @param map Contract.BLUETOOTH_NAME ????????????????????? Contract.BLUETOOTH_MAC ?????????????????????
     */
    public void saveBlueToothInfo(Map<String, String> map) {
        if (sp != null) {
            sp.edit().putString(Contract.BLUETOOTH_NAME,map.get(Contract.BLUETOOTH_NAME)).apply();
            sp.edit().putString(Contract.BLUETOOTH_MAC,map.get(Contract.BLUETOOTH_MAC)).apply();
        }
    }

    /**
     * ??????????????????
     * @return BLUETOOTH_NAME ????????????????????? BLUETOOTH_MAC ?????????????????????
     */
    public Map<String, String> findBlueToothInfo() {
        Map<String, String> map = new HashMap<>();
        String name = sp.getString(Contract.BLUETOOTH_NAME,"");
        String mac = sp.getString(Contract.BLUETOOTH_MAC,"");
        map.put(Contract.BLUETOOTH_NAME,name);
        map.put(Contract.BLUETOOTH_MAC,mac);
        return map;
    }

    /**
     * ????????????????????????
     * @param isKeep true ???????????? false ???????????????
     */
    public void saveKeepConnect(boolean isKeep) {
        if (sp != null) {
            sp.edit().putBoolean(Contract.KEEP_CONNECT,isKeep).apply();
        }
    }

    /**
     * ????????????????????????
     * @return ??????false
     */
    public boolean findKeepConnect() {
        return sp.getBoolean(Contract.KEEP_CONNECT,false);
    }

}
