//package com.adafruit.bluefruit.le.connect.utils;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import cc.hent.ramoc.industry.contract.Contract;
//import cc.hent.ramoc.industry.converter.DateConverter;
//
///**
// * Created by sqz on 2017/3/7.
// *
// */
//
//public class SharedPreferencesTool {
//
//    private static SharedPreferences sp;
//
//    public static cc.hent.ramoc.industry.util.SharedPreferencesTool RCConfig(Context context) {
//        sp = context.getSharedPreferences(Contract.RAMOC_Config, Context.MODE_PRIVATE);
//        return new cc.hent.ramoc.industry.util.SharedPreferencesTool();
//    }
//
//
//    public static cc.hent.ramoc.industry.util.SharedPreferencesTool ACConfig(Context context) {
//        sp = context.getSharedPreferences(Contract.APP_Config, Context.MODE_PRIVATE);
//        return new cc.hent.ramoc.industry.util.SharedPreferencesTool();
//    }
//
//
//    public void saveDeviceStatus(Boolean value) {
//        if (sp != null) {
//            sp.edit().putBoolean(Contract.DEVICE_STATUS,value).apply();
//        }
//    }
//
//    public Boolean findDeviceStatus(){
//        return sp.getBoolean(Contract.DEVICE_STATUS,false);
//    }
//
//
//    public void saveBell(Boolean value) {
//        if (sp != null) {
//            sp.edit().putBoolean(Contract.BELL,value).apply();
//        }
//    }
//
//    public Boolean findBell() {
//        return sp.getBoolean(Contract.BELL,false);
//    }
//
//    public void saveVibration(Boolean value) {
//        if (sp != null) {
//            sp.edit().putBoolean(Contract.VIBRATION,value).apply();
//        }
//    }
//
//    public Boolean findVibration() {
//        return sp.getBoolean(Contract.VIBRATION,true);
//    }
//
//    public void saveBackLightTime(int value) {
//        if (sp != null) {
//            sp.edit().putInt(Contract.BACK_LIGHT_TIME,value).apply();
//        }
//    }
//
//    public int findBackLightTime() {
//        return sp.getInt(Contract.BACK_LIGHT_TIME,0);
//    }
//
//
//    public void saveVersionCode(int value) {
//        if (sp != null) {
//            sp.edit().putInt(Contract.VERSION_CODE,value).apply();
//        }
//    }
//
//    public int findVersionCode() {
//        return sp.getInt(Contract.VERSION_CODE,0);
//    }
//
//
//    public void saveVersionName(String value) {
//        if (sp != null) {
//            sp.edit().putString(Contract.VERSION_NAME,value).apply();
//        }
//    }
//
//    public String findVersionName() {
//        return sp.getString(Contract.VERSION_NAME,"");
//    }
//
//
//    public void saveWornNotify(Boolean value) {
//        if (sp != null) {
//            sp.edit().putBoolean(Contract.WORN_NOTIFY,value).apply();
//        }
//    }
//
//    public Boolean findWornNotify() {
//        return sp.getBoolean(Contract.WORN_NOTIFY,true);
//    }
//
//
//    public void saveWornSound(Boolean value) {
//        if (sp != null) {
//            sp.edit().putBoolean(Contract.WORN_SOUND,value).apply();
//        }
//    }
//
//    public Boolean findWornSound() {
//        return sp.getBoolean(Contract.WORN_SOUND,true);
//    }
//
//    public void saveWornValue(String value) {
//        if (sp != null) {
//            sp.edit().putString(Contract.WORN_VALUE,value).apply();
//        }
//    }
//
//    public String findWornValue() {
//        return sp.getString(Contract.WORN_VALUE,"0.00");
//    }
//
//
//    public void saveWornUnit(int value) {
//        if (sp != null) {
//            sp.edit().putInt(Contract.WORN_UNIT,value).apply();
//        }
//    }
//
//    public int findWornUnit() {
//        return sp.getInt(Contract.WORN_UNIT,0);
//    }
//
//
//
//    public void saveDoseWornValue(String value) {
//        if (sp != null) {
//            sp.edit().putString(Contract.WORN_DOSE_VALUE,value).apply();
//        }
//    }
//
//
//    public String findDoseWornValue() {
//        return sp.getString(Contract.WORN_DOSE_VALUE,"0.00");
//    }
//
//
//    public void saveDoseWornUnit(int value) {
//        if (sp != null) {
//            sp.edit().putInt(Contract.WORN_DOSE_UNIT,value).apply();
//        }
//    }
//
//    public int findDoseWornUnit() {
//        return sp.getInt(Contract.WORN_DOSE_UNIT,0);
//    }
//
//
//    public void saveIsFirst(Boolean b) {
//        if (sp != null) {
//            sp.edit().putBoolean(Contract.IS_FIRST,b).apply();
//        }
//    }
//
//    public Boolean findIsFirst() {
//        return sp.getBoolean(Contract.IS_FIRST,true);
//    }
//
//    public void saveFirstDate(String date) {
//        if (sp != null) {
//            sp.edit().putString(Contract.FIRST_DATE,date).apply();
//        }
//    }
//
//    public Date findFirstDate() {
//        DateConverter dateConverter = new DateConverter();
//        Date date = new Date();
//        try {
//            return DateUtils.getInstance().setDateString(sp.getString(Contract.FIRST_DATE,""))
//                    .dateStrToDate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return date;
//    }
//
//    public void saveMapType(int type) {
//        if (sp != null) {
//            sp.edit().putInt(Contract.MAP_TYPE,type).apply();
//        }
//    }
//
//
//    public int findMapType() {
//        return sp.getInt(Contract.MAP_TYPE,Contract.GAO_DE);
//    }
//
//
//    /**
//     * 存储蓝牙信息
//     * @param map Contract.BLUETOOTH_NAME 存储的蓝牙名称 Contract.BLUETOOTH_MAC 存储的蓝牙地址
//     */
//    public void saveBlueToothInfo(Map<String, String> map) {
//        if (sp != null) {
//            sp.edit().putString(Contract.BLUETOOTH_NAME,map.get(Contract.BLUETOOTH_NAME)).apply();
//            sp.edit().putString(Contract.BLUETOOTH_MAC,map.get(Contract.BLUETOOTH_MAC)).apply();
//        }
//    }
//
//    /**
//     * 查询蓝牙信息
//     * @return BLUETOOTH_NAME 存储的蓝牙名称 BLUETOOTH_MAC 存储的蓝牙地址
//     */
//    public Map<String, String> findBlueToothInfo() {
//        Map<String, String> map = new HashMap<>();
//        String name = sp.getString(Contract.BLUETOOTH_NAME,"");
//        String mac = sp.getString(Contract.BLUETOOTH_MAC,"");
//        map.put(Contract.BLUETOOTH_NAME,name);
//        map.put(Contract.BLUETOOTH_MAC,mac);
//        return map;
//    }
//
//    /**
//     * 是否保持蓝牙连接
//     * @param isKeep true 保持连接 false 不保持连接
//     */
//    public void saveKeepConnect(boolean isKeep) {
//        if (sp != null) {
//            sp.edit().putBoolean(Contract.KEEP_CONNECT,isKeep).apply();
//        }
//    }
//
//    /**
//     * 查询是否保持连接
//     * @return 默认false
//     */
//    public boolean findKeepConnect() {
//        return sp.getBoolean(Contract.KEEP_CONNECT,false);
//    }
//
//}
