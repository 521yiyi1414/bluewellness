package com.adafruit.bluefruit.le.connect.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateUtils {

    private String dateString;
    private String[] dateStrings;
    private Date startDate;
    private Date endDate;
    private Calendar calendar;
    private List<Date> dateList;
    private List<Date> weekDateList;
    private List<Date> monthDateList;

    private String year;
    private String month;
    private String monthEn;
    private String day;
    private String clock;
    private String week;
    private String weekEn;
    private String monthDate;
    private String monthDateEn;
    private String monthSlashDate;
    private int monthDays;

    private final String backSpace = " ";
    private final String yearStr = "年";
    private final String monthStr = "月";
    private final String dayStr = "日";
    private final String weekStr = "周";
    private final String slash= "/";

    public static com.adafruit.bluefruit.le.connect.utils.DateUtils getInstance() {
        return DateUtilsHolder.holder;
    }

    private static class DateUtilsHolder {
        private static com.adafruit.bluefruit.le.connect.utils.DateUtils holder = new com.adafruit.bluefruit.le.connect.utils.DateUtils();
    }


    private String getDateString() {
        return dateString;
    }

    public com.adafruit.bluefruit.le.connect.utils.DateUtils setDateString(Date date) {
        this.dateString = date.toString();
        return this;
    }

    public com.adafruit.bluefruit.le.connect.utils.DateUtils setDateString(String dateString) {
        this.dateString = dateString;
        return this;
    }

    private String[] getDateStrings() throws Exception {
        if (!getDateString().isEmpty()) {
            if (getDateString().contains(backSpace)) {
                dateStrings = getDateString().split(backSpace);
            }else {
                throw new Exception("DateStrings form Exception");
            }
        }
        return dateStrings;
    }


    public Date getStartDate() {
        return startDate;
    }


    public com.adafruit.bluefruit.le.connect.utils.DateUtils setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public com.adafruit.bluefruit.le.connect.utils.DateUtils setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    private Calendar getCalendar() {
        calendar = Calendar.getInstance();
        calendar.setTime(getStartDate());
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public List<Date> getDateList() {
        dateList = new ArrayList<>();
        getCalendar();
        dateList.add(startDate);
        do {
            calendar.add(Calendar.DATE,1);
            dateList.add(calendar.getTime());
        }while (endDate.after(calendar.getTime()));
//        if (endDate.getTime() < dateList.get(dateList.size() - 1).getTime()) {
//            dateList.remove(dateList.get(dateList.size() - 1));
//        }
        return dateList;
    }

    public List<Date> getWeekDateList() throws Exception {
        weekDateList = new ArrayList<>();
        weekDateList.add(getDateList().get(0));
        if (getDateList().size() > 7) {
            switch (setDateString(startDate).getWeek()) {
                case "一":
                    restOfMon(getDateList(),0);
                    break;
                case "二":
                    restOfMon(getDateList(),7);
                    break;
                case "三":
                    restOfMon(getDateList(),6);
                    break;
                case "四":
                    restOfMon(getDateList(),5);
                    break;
                case "五":
                    restOfMon(getDateList(),3);
                    break;
                case "六":
                    restOfMon(getDateList(),2);
                    break;
                case "日":
                    restOfMon(getDateList(),1);
                    break;
            }
        }
        return weekDateList;
    }

    /**
     * 得到剩下的周一
     *
     * @param dates 剩下的日期列表
     * @param start 第二个周一的开始索引
     */
    private void restOfMon(List<Date> dates, int start) {
//        System.out.println((dates.size() - start) % 7);
        int index = start;
        for (int i = 0; i < (dates.size() - start) / 7; i++) {
            if (index != 0) {
                weekDateList.add(dates.get(index));
            }
            index = index + 7;
        }
        weekDateList.add(dates.get(dates.size() - ((dates.size() - start) % 7)));
//        System.out.println( "开始 "+ start +" 日期 "+ dates.get(start).toString());
    }


    public List<Date> getMonthDateList() throws Exception {
        monthDateList = new ArrayList<>();
        String month = setDateString(getDateList().get(0)).getMonth();
        monthDateList.add(dateList.get(0));
        for (Date date : dateList) {
            if (!setDateString(date).getMonth().equals(month)) {
                monthDateList.add(date);
                month = setDateString(date).getMonth();
            }
        }
        return monthDateList;
    }



    public void setDateList(List<Date> dateList) {
        this.dateList = dateList;
    }

    public String getYear() throws Exception {
        this.year = getDateStrings()[5];
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() throws Exception {
        this.month = String.valueOf(coverMonth());
        return month;
    }

    public void setDay(String day) {

        this.day = day;
    }

    public String getDay() throws Exception {
        this.day = getDateStrings()[2];
        return day;
    }

    public void setWeek(String week) {
        this.week = week;
    }
    
    public String getClock() throws Exception {
        this.clock = getDateStrings()[3];
        return clock;
    }

    public String getMonthEn() throws Exception {
        this.monthEn = getDateStrings()[1];
        return monthEn;
    }


    public String getWeekEn() throws Exception {
        this.weekEn = getDateStrings()[0];
        return weekEn;
    }


    public String getWeek() throws Exception {
        this.week = coverWeek(getDateStrings()[0]);
        return week;
    }

    public int getMonthDays() throws Exception {
        try {
            monthDays = daysCountOfMonth(Integer.parseInt(getYear()), Integer.parseInt(getDay()));
        }catch (NumberFormatException ignore){}
        return monthDays;
    }

    /**
     * * 月 * 日 周 *
     * @return eg：8 月 20 日 周 一
     * @throws Exception e
     */
    public String getMonthDate() throws Exception {
        this.monthDate = getMonth() + backSpace + monthStr + backSpace +
                getDay() + backSpace + dayStr + backSpace + weekStr + backSpace +getWeek();
        return monthDate;
    }

    /**
     * 英文的月日周
     * @return eg:Fri Aug 10
     * @throws Exception e
     */
    public String getMonthDateEn() throws Exception {
        this.monthDate = getWeekEn() + backSpace + getMonthEn() + backSpace + getDay();
        return monthDateEn;
    }

    /**
     * @return eg: 8/9
     * @throws Exception e
     */
    public String getMonthSlashDate() throws Exception {
        this.monthSlashDate = String.format("%s%s%s", getMonth(), slash, getDay());
        return monthSlashDate;
    }

    /**
     * 返回月份
     * @return eg: 八 月
     * @throws Exception e
     */
    public String getMonthWithoutDate() throws Exception {
        return getMonth() + backSpace + monthStr;
    }

    /**
     * 返回年份
     * @return eg：2018 年
     * @throws Exception e
     */
    public String getYearWithoutDate() throws Exception {
        return getYear() + backSpace + yearStr;
    }

    /**
     * 计算一周的范围
     * @return eg：八 月 6 日 周 一 ～ 八 月 12 日 周 日
     * @throws Exception
     */
    public String getOneWeekScope() throws Exception {
        Date afterWeekDate = new Date();
        setStartDate(dateStrToDate());
        String MonthDate = getMonthDate();
        Calendar calendar = getCalendar();
        calendar.add(Calendar.DATE,6);
        afterWeekDate = calendar.getTime();
        setDateString(afterWeekDate);
        String afterWeekMonthDate = getMonthDate();
        return MonthDate + " ~ " + afterWeekMonthDate;
    }

    public Date dateStrToDate() throws Exception {
        Date date = null;
//        if (!TextUtils.isEmpty(getDateString())) {
            DateFormat format = new
                    SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            String dateCoverString = this.getYear() +"-"+ this.getMonth() +"-"+ this.getDay() +
                    " "+ this.getClock();
            try {
                date = format.parse(dateCoverString);
//                System.out.println(dateCoverString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
//        }
        return date;
    }

    /**
     * 计算一个月有多少天
     * @param year 年份
     * @param month 月份
     * @return 天数
     */
     public int daysCountOfMonth(int year,int month) {
        int dayS = 0;
        switch (month) {
            case 1:
                dayS = 31;
                break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0  ) {
                    dayS = 29;
                }else {
                    dayS = 28;
                }
                break;
            case 3:
                dayS = 31;
                break;
            case 4:
                dayS = 30;
                break;
            case 5:
                dayS = 31;
                break;
            case 6:
                dayS = 30;
                break;
            case 7:
                dayS = 31;
                break;
            case 8:
                dayS = 31;
                break;
            case 9:
                dayS = 30;
                break;
            case 10:
                dayS = 31;
                break;
            case 11:
                dayS = 30;
                break;
            case 12:
                dayS = 31;
                break;
            default:
                break;
        }
        return dayS;
    }


    /**
     * Jan
     * Feb
     * Mar
     * Apr
     * May
     * Jun
     * Jul
     * Aug
     * Sep
     * Oct
     * Nov
     * Dec
     * @return int
     */
    private int coverMonth() throws Exception {
        int month = 0;
        if (!getDateString().isEmpty()) {
            switch (getMonthEn()) {
                case "Jan":
                    month = 1;
                    break;
                case "Feb":
                    month = 2;
                    break;
                case "Mar":
                    month = 3;
                    break;
                case "Apr":
                    month = 4;
                    break;
                case "May":
                    month = 5;
                    break;
                case "Jun":
                    month = 6;
                    break;
                case "Jul":
                    month = 7;
                    break;
                case "Aug":
                    month = 8;
                    break;
                case "Sep":
                    month = 9;
                    break;
                case "Oct":
                    month = 10;
                    break;
                case "Nov":
                    month = 11;
                    break;
                case "Dec":
                    month = 12;
                    break;
            }

        }
        return month;
    }


    /**
     * Mon
     Tue
     Wed
     Thu
     Fri
     Sat
     Sun
     * @param weekEn
     * @return
     */
    public String coverWeek(String weekEn) {
        String week = "";
        switch (weekEn) {
            case "Mon":
                week = "一";
                break;
            case "Tue":
                week = "二";
                break;
            case "Wed":
                week = "三";
                break;
            case "Thu":
                week = "四";
                break;
            case "Fri":
                week = "五";
                break;
            case "Sat":
                week = "六";
                break;
            case "Sun":
                week = "日";
                break;
        }
        return week;

    }

}
