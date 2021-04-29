package com.adafruit.bluefruit.le.connect.contract;

import java.util.UUID;

/**
 * Created by sqz cs on 2018/3/26.
 * email : shiqizhenyes@163.com
 * Beijing High energy science and technology
 */

public class Contract {

    public final static String ACTION_GATT_CONNECTED =
            "com.nordicsemi.nrfUART.ACTION_GATT_CONNECTED";
    public final static String ACTION_GATT_DISCONNECTED =
            "com.nordicsemi.nrfUART.ACTION_GATT_DISCONNECTED";
    public final static String ACTION_GATT_SERVICES_DISCOVERED =
            "com.nordicsemi.nrfUART.ACTION_GATT_SERVICES_DISCOVERED";
    public final static String ACTION_DATA_AVAILABLE =
            "com.nordicsemi.nrfUART.ACTION_DATA_AVAILABLE";
    public final static String EXTRA_DATA =
            "com.nordicsemi.nrfUART.EXTRA_DATA";
    public final static String DEVICE_DOES_NOT_SUPPORT_UART =
            "com.nordicsemi.nrfUART.DEVICE_DOES_NOT_SUPPORT_UART";

    public static final UUID TX_POWER_UUID = UUID.fromString("00001804-0000-1000-8000-00805f9b34fb");
    public static final UUID TX_POWER_LEVEL_UUID = UUID.fromString("00002a07-0000-1000-8000-00805f9b34fb");
    public static final UUID CCCD = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public static final UUID FIRMWARE_REVISON_UUID = UUID.fromString("00002a26-0000-1000-8000-00805f9b34fb");
    public static final UUID DIS_UUID = UUID.fromString("0000180a-0000-1000-8000-00805f9b34fb");
    public static final UUID RX_SERVICE_UUID = UUID.fromString("6e400001-b5a3-f393-e0a9-e50e24dcca9e");
    public static final UUID RX_CHAR_UUID = UUID.fromString("6e400002-b5a3-f393-e0a9-e50e24dcca9e");
    public static final UUID TX_CHAR_UUID = UUID.fromString("6e400003-b5a3-f393-e0a9-e50e24dcca9e");


    public static final int ADD_Device = 300;


    public static final int SEND_COMMON = 0x100;
    public static final int SEND_TB = 0x200;


    public static final int COMMON = 0x101;
    public static final int TB = 0x102;

    public static final int UPDATE_DWT = 0x300;



    public static final String CODE_MEDICAL_CONNECT = "# cet $";

    public static final String CODE_MEDICAL_BIND = "# bl $";


    //===============控制指令=============== //

    public static final String CODE_COMMON_USE = "# gd $";
    /**获得温度和电量**/
    public static final String CODE_GET_TEMPERATURE_BATTERY = "# ud1 $";
    /**同步状态**/
    public static final String CODE_SYNC_STATE = "# ud2 $";
//    /**打开屏幕显示**/
//    public static final String CODE_OPEN_SCREEN = "# cd on $";
//    /**关闭屏幕显示**/
//    public static final String CODE_CLOSE_SCREEN = "# cd off $";

    /**背光**/
    public static final String CODE_CONTROL_BACKLIGHT = "# cb $";
    /**切换显示模式**/
    public static final String CODE_CHANGE_DOSE_CPS = "# sm $";
    /**报警声音**/
    public static final String CODE_CONTROL_SOUND = "# cs $";
    /**报警震动**/
    public static final String CODE_CONTROL_VIBRATE = "# cv $";

    /**清零总剂量**/
    public static final String CODE_ZERO_CLEARING = "# ct $";

    /**关闭设备**/
    public static final String CODE_CLOSE_DEVICE = "# pd $";


    public static final String CODE_FIRMWARE_UPGRADE = "# dn $";



    /**同步报警阈值**/
    public static final String SP_ALARM_VALUE = "sp_alarm_value";
    /**同步报警阈值的单位**/
    public static final String SP_ALARM_VALUE_UNIT = "sp_alarm_value_unit";
    /**报警的action**/
    public static final String ACTION_ALARMING ="cc.hent.wmoc.action_alarming";

    /**eventbus 正在报警**/
//    public static final int EVENT_BUS_MESSAGE_ISALARMING = 0;
//    public static final String BACKLIGHT_IS_OPEN = "isopen";

    //===============控制指令=============== //
    /**背光时间**/
//    public static final String SP_BACKLIGHT_FIVE = "five";
//    public static final String SP_BACKLIGHT_FIFTEEN = "fifteen";
//    public static final String SP_BACKLIGHT_THIRTY = "thirty";
//    public static final String SP_BACKLIGHT_NEVER = "never";
//    public static final String SP_BACKLIGHT_CURRENT_TIME = "currentTime";
//    public static final String SP_BACKLIGHT_CUSTOME_TIME = "customeTime";
//    public static final String ACTION_BACKLIGHT_RECEIVER = "cc.hent.www.BACKLIGHT_RECEIVER";
//    public static final String SP_DEVICE_PROGRAM_VERSION = "sp_device_program_version";
//    public static final String SP_BOUND_DEVICE = "bound_device";


//    public static final String MEDICAL_TEST_URL = "http://106.37.108.30:5001/test/medical/msg.html";

    public static final String UPGRADE_TEST_URL = "http://106.37.108.30:5001/test/industry/output.json";

    public static final String BASE_TEST_URL = "http://106.37.108.30:5001/test/industry/";

    public static final String BASE_RELEASE_URL = "http://106.37.108.30:5001/release/industry/";

    public static final String UPGRADE_APP_URL = "output.json";
    public static final String UPGRADE_FIRMWARE_URL = "firmware.json";


    public static final String UPGRADE_APP = "UPGRADE_APP";
    public static final String UPGRADE_FIRMWARE = "UPGRADE_FIRMWARE";

//    public static final String INDUSTRY_TEST_URL = "http://106.37.108.30:5001/test/industry/msg.html";

    //===============Router=============== //

    public static final String Main = "Main";
    public static final String FootPrintManager = "FootPrintManager";
    public static final String HistoryData = "HistoryData";
    public static final String WornSet = "WornSet";
    public static final String LcdBackLight = "LcdBackLight";
    public static final String About = "About";
    public static final String FootPrintDetail = "FootPrintDetail";
    public static final String GDFootPrintDetail = "GDFootPrintDetail";
    public static final String Help = "Help";
    public static final String CID = "CID";

    //===============Router=============== //


    public static final String INCLUDE = "include";
    public static final String OBJECT_ID = "objectId";
    public static final int PAGE_COUNT = 10;
    public static final String PAGE = "page";


    public static final int STATUS_GD = 0x28;
    public static final int STATUS_NG = 0x37;
    public static final int STATUS_DEFAULT = 0x00;

    public static final int MARK_SET = 0x56;
    public static final int MARK_READ = 0x57;

    //===============蓝牙操作=============== //
    public static final int MEDICAL_CONNECT = 8001;
    public static final int MEDICAL_BIND = 8002;


    public static final int WRITE_SUCCESS = 1000;
    public static final int WRITE_FAIL = 1001;

    public static final int WRITE = 1005;
    public static final int INIT_BLE = 2000;

    public static final int START_SCAN = 3000;
    public static final int STOP_SCAN = 4000;

    public static final int CONNECT_DEVICE = 5000;
    public static final int RECONNECT_DEVICE = 5001;
    public static final int DISCONNECT_DEVICE = 6000;

    public static final int START_COMMON = 6001;
    public static final int STOP_COMMON = 6002;

    public static final int START_BAT = 6003;
    public static final int STOP_BAT = 6004;

    public static final int STOP_COMMON_BAT = 6005;

    public static final int TIME_OUT = 6006;

    public static final int SYNC_READY = 7001;
    public static final int SYNC_STOP = 7015;
    public static final int SYNC_REQUEST_TIME_TABLE = 7014;

    public static final int SYNC_START_REQUEST_DATA = 7002;
    public static final int SYNC_ADD_DATA = 7003;
    public static final int SYNC_SAVE_DATA = 7004;

    public static final int SYNC_STOP_REQUEST_DATA = 7005;
    public static final int SYNC_FINISH = 7006;

    public static final int UPGRADE_READY = 7007;
    public static final int UPGRADE_INFO = 7008;
    public static final int UPGRADE_START = 7009;
    public static final int UPGRADING = 7010;
    public static final int UPGRADE_FINISH = 7011;
    public static final int UPGRADE_SUCCESS = 7012;
    public static final int UPGRADE_FAIL = 7013;



    //===============蓝牙操作=============== //
    //===============数据类型=============== //

    public static final int DATA_TYPE = 0x12;
    public static final int HEX_DATA = 0x13;
    public static final int STRING_DATA  = 0x14;
    public static final int HEX_DATA_TYPE = 0x15;
    public static final int HEX_DATA_HISTORY = 0x16;
    public static final int HEX_DATA_FIRMWARE = 0x17;


    //===============数据类型=============== //


    //===============定位操作=============== //
    public static final int LOCATION = 0x88;
    public static final int LOCATION_START = 0x89;
    public static final int LOCATION_STOP = 0x90;
    //===============定位操作=============== //

    public static final int SET_BDN = 0x91; //设置标题为蓝牙设备名称

    //===============蓝牙数据=============== //



    public static final int A = 0x41;
    public static final int B = 0x42;
    public static final int C = 0x43;
    public static final int D = 0x44;
    public static final int E = 0x45;
    public static final int F = 0x46;
    public static final int G = 0x47;
    public static final int I = 0x48;
    public static final int J = 0x49;
    public static final int O = 0x50;
    public static final int P = 0x51;
    public static final int Q = 0x52;
//    public static final int R = 0x53;
    public static final int S = 0x54;
    public static final int V = 0x55;

    //===============蓝牙数据=============== //

    //===============配置数据=============== //
    public static final String RAMOC_Config = "RC";

    public static final String DEVICE_STATUS = "DEVICE_STATUS";
    public static final String BELL = "BELL";
    public static final String VIBRATION = "VIBRATION";
    public static final String WORN_NOTIFY = "WORN_NOTIFY";
    public static final String WORN_SOUND = "WORN_SOUND";
    public static final String WORN_VALUE = "WORN_VALUE";
    public static final String WORN_UNIT = "WORN_UNIT";
    public static final String WORN_DOSE_VALUE = "WORN_DOSE_VALUE";
    public static final String WORN_DOSE_UNIT = "WORN_DOSE_UNIT";
    // 9005 - 常开 ，5 - 5秒 15 - 15秒 30 - 30 秒
    public static final String BACK_LIGHT_TIME = "BACK_LIGHT_TIME";

    public static final String VERSION_CODE = "VERSION_CODE";
    public static final String VERSION_NAME = "VERSION_NAME";


    public static final String APP_Config = "AC";
    public static final String IS_FIRST = "IS_FIRST";

    public static final String USER_NAME = "USER_NAME";
    public static final String USER_PASS_FINGER = "USER_PASS_FINGER";

    public static final String FIRST_DATE = "FIRST_DATE";

    public static final String MAP_TYPE = "MAP_TYPE";

    public static final int BAI_DU = 0x905;
    public static final int GAO_DE = 0x906;


    public static final String BLUETOOTH_NAME = "BLUETOOTH_NAME";
    public static final String BLUETOOTH_MAC = "BLUETOOTH_MAC";
    public static final String KEEP_CONNECT = "KEEP_CONNECT";



    //===============配置数据=============== //


    //===============视图模式=============== //

    public static final int DAY_VIEW = 0;
    public static final int WEEK_VIEW = 1;
    public static final int MONTH_VIEW = 2;
    public static final int YEAR_VIEW = 3;

    public static final long DAY_CHECK = 500;
    public static final long WEEK_CHECK = 501;
    public static final long MONTH_CHECK = 502;
    public static final long YEAR_CHECK = 503;
    public static final long CHECK_COMPLETED = 504;

    public static final long DAY_UPDATED = 505;
    public static final long MONTH_UPDATED = 506;
    public static final long YEAR_UPDATED = 507;

    public static final long LAST_DAY_UPDATED = 508;
    public static final long LAST_MONTH_UPDATED = 509;
    public static final long LAST_YEAR_UPDATED = 510;
    public static final long UPDATE_COMPLETED = 511;

    public static final long NO_DATA_LAYOUT = 512;



    //===============视图模式=============== //


    public static final int APP_RESTART = 0x903;
    //===============任务调度=============== //
    public static final long DEFAULT_INITIAL_BACKOFF_MILLIS = 2000L;
    //===============任务调度=============== //
    public static final int DAY_SECONDS = 86400;


}
