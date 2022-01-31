package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.util.Calendar;
import java.util.HashMap;

public class TimeManager
{
  private static TimeManager jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private long jdField_a_of_type_Long;
  public CountDownTimer a;
  private final String jdField_a_of_type_JavaLangString = TimeManager.class.getName();
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private String jdField_b_of_type_JavaLangString = "yyyy-MM-dd";
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  private TimeManager()
  {
    b(BaseApplicationImpl.a);
  }
  
  public static TimeManager a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager = new TimeManager();
      }
      TimeManager localTimeManager = jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager;
      return localTimeManager;
    }
  }
  
  private boolean a()
  {
    if (System.currentTimeMillis() >= this.jdField_a_of_type_Long)
    {
      f();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return false;
    }
    return true;
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    f();
    a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer = new CountDownTimer(paramContext.getMainLooper());
  }
  
  private void f()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a(String paramString, long paramLong)
  {
    Object localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString + "_" + LocaleUtil.a());
    if ((localObject == null) || (!a()))
    {
      localObject = new HashMap();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString + "_" + LocaleUtil.a(), localObject);
    }
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      localObject = TimeFormatterUtils.a(this.jdField_a_of_type_JavaLangStringBuffer, 1000L * paramLong, true, this.jdField_b_of_type_JavaLangString);
      paramString.put(paramLong + "", localObject);
      paramString = (String)localObject;
      String str;
      do
      {
        return paramString;
        str = (String)((HashMap)localObject).get(paramLong + "");
        paramString = str;
      } while (str != null);
      ((HashMap)localObject).clear();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void a(Context paramContext)
  {
    String str = null;
    if (paramContext != null) {
      str = Settings.System.getString(paramContext.getContentResolver(), "date_format");
    }
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_b_of_type_JavaLangString = str;
      return;
    }
    this.jdField_b_of_type_JavaLangString = "yyyy-MM-dd";
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.g();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.f();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.d();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TimeManager
 * JD-Core Version:    0.7.0.1
 */