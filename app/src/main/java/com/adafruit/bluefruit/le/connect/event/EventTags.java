package com.adafruit.bluefruit.le.connect.event;

/**
 * Created by hujunbao
 */

public interface EventTags {
    /**
     * 登录成功
     */
    int ON_USER_LOGIN = 0x0000;
    int FLASH_INIT_UI = 0x0001;
    int JUMP_TO_MAIN = 0x0002;
    int SHOW_TAB_LIST = 0x0003;
    public static final int TEST = 0x0004;
    /**
     * 发布公开成功
     */
    int ON_RELEASE_OPEN = 0x0004;
}
