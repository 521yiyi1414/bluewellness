package com.adafruit.bluefruit.le.connect.ui.base.utils;

import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class LogUtils {

    private static boolean isDebug = true;

    private static String mTag = "LogUtils";

    //for error log
    public static void error(String msg) {
        if (isDebug) {
            Log.e(mTag, msg);
        }
    }

    //for warming log
    public static void warn(String msg) {
        if (isDebug) {
            Log.w(mTag, msg);
        }
    }

    //for info log
    public static void info(String msg) {
        if (isDebug) {
            Log.i(mTag, msg);
        }
    }

    //for debug log
    public static void debug(String msg) {
        if (isDebug) {
            Log.d(mTag, msg);
        }
    }

    //for verbose log
    public static void verbose(String msg) {
        if (isDebug) {
            Log.v(mTag, msg);
        }
    }

    //for error log
    public static void e(String msg) {
        if (isDebug) {
            Log.e(mTag, msg);
        }
    }

    //for warming log
    public static void w(String msg) {
        if (isDebug) {
            Log.w(mTag, msg);
        }
    }

    //for info log
    public static void i(String msg) {
        if (isDebug) {
            Log.i(mTag, msg);
        }
    }

    //for debug log
    public static void d(String msg) {
        if (isDebug) {
            Log.d(mTag, msg);
        }
    }

    //for verbose log
    public static void v(String msg) {
        if (isDebug) {
            Log.v(mTag, msg);
        }
    }


    //for warming log
    public static void w(String tag, String msg) {
        if (isDebug) {
            if (tag == null || "".equalsIgnoreCase(tag.trim())) {
                tag = mTag;
            }
            Log.w(tag, msg);
        }
    }

    //for info log
    public static void i(String tag, String msg) {
        if (isDebug) {
            if (tag == null || "".equalsIgnoreCase(tag.trim())) {
                tag = mTag;
            }
            Log.i(tag, msg);
        }
    }


    public static void hexDataLog(String tag, byte[] bytes) {
        if (isDebug) {
            ArrayList<String> hexList = new ArrayList<>();
            ArrayList<Byte> list = new ArrayList<>();
            for (byte by : bytes) {
                hexList.add(Integer.toHexString(0xFF & by));
                list.add(by);
            }
            com.adafruit.bluefruit.le.connect.ui.base.utils.LogUtils.d(tag, hexList.toString());
        }
    }

    //for debug log
    public static void d(String tag, String msg) {
        if (isDebug) {
            if (tag == null || "".equalsIgnoreCase(tag.trim())) {
                tag = mTag;
            }
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, List list) {
        if (isDebug) {
            if (tag == null || "".equalsIgnoreCase(tag.trim())) {
                tag = mTag;
            }
            StringBuilder listStr = new StringBuilder();
            String dot = "\n | ";
            for (Object o : list) {
                listStr.append(dot).append(o.toString()).append(dot);
            }
            Log.d(tag, String.valueOf(listStr));
        }
    }

    //for verbose log
    public static void v(String tag, String msg) {
        if (isDebug) {
            if (tag == null || "".equalsIgnoreCase(tag.trim())) {
                tag = mTag;
            }
            Log.v(tag, msg);
        }
    }

    //for verbose log
    public static void e(String tag, String msg) {
        if (isDebug) {
            if (tag == null || "".equalsIgnoreCase(tag.trim())) {
                tag = mTag;
            }
            Log.e(tag, msg);
        }
    }

    public static void setDebug(boolean isDebug) {
        com.adafruit.bluefruit.le.connect.ui.base.utils.LogUtils.isDebug = isDebug;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    /**
     * 点击Log跳转到指定源码位置
     *
     * @param tag tag
     * @param msg msg
     */
    public static void showLog(String tag, String msg) {
        if (isDebug && !TextUtils.isEmpty(msg) ) {
            if (TextUtils.isEmpty(tag)) tag = mTag;
            StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
            int currentIndex = -1;
            for (int i = 0; i < stackTraceElement.length; i++) {
                if (stackTraceElement[i].getMethodName().compareTo("showLog") == 0) {
                    currentIndex = i + 1;
                    break;
                }
            }
            if (currentIndex >= 0) {
                String fullClassName = stackTraceElement[currentIndex].getClassName();
                String className = fullClassName.substring(fullClassName
                        .lastIndexOf(".") + 1);
                String methodName = stackTraceElement[currentIndex].getMethodName();
                String lineNumber = String
                        .valueOf(stackTraceElement[currentIndex].getLineNumber());

                Log.i(tag, msg + "\n  ---->at " + className + "." + methodName + "("
                        + className + ".java:" + lineNumber + ")");
            } else {
                Log.i(tag, msg);
            }
        }
    }
}
