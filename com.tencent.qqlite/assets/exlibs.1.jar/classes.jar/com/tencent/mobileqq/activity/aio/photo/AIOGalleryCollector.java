package com.tencent.mobileqq.activity.aio.photo;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import byt;
import byu;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AIOGalleryCollector
  extends DataCollector
{
  public static final int a = 0;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Colloector-Tasker");
  private static final String jdField_a_of_type_JavaLangString = "AIOGalleryCollector";
  public static final int b = 1;
  private static final String b = "Pic.AioPreview";
  public static final int c = 2;
  private static final String c = "stay_seconds";
  public static final int d = 15;
  private static final String d = "gesture_double_click";
  private static final String e = "view_again";
  private static final String f = "view_count";
  private static final String g = "view_image_counts";
  private Handler jdField_a_of_type_AndroidOsHandler = new byt(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  private byu a(String paramString)
  {
    byu localbyu2 = (byu)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    byu localbyu1 = localbyu2;
    if (localbyu2 == null)
    {
      localbyu1 = new byu(this, null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localbyu1);
    }
    return localbyu1;
  }
  
  private void a()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      byu localbyu = (byu)localIterator.next();
      if (byu.a(localbyu) <= 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("AIOGalleryCollector", 4, "View count is 0!");
        }
      }
      else
      {
        localHashMap.clear();
        localHashMap.put("stay_seconds", String.valueOf(byu.a(localbyu)));
        localHashMap.put("gesture_double_click", String.valueOf(byu.b(localbyu)));
        localHashMap.put("view_count", String.valueOf(byu.a(localbyu)));
        localHashMap.put("view_image_counts", "1");
        if (byu.a(localbyu)) {
          localHashMap.put("view_again", "1");
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, "Pic.AioPreview", true, 0L, 0L, localHashMap, "");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      throw new RuntimeException("You must invoke postEnter() instead of this");
    }
    if (paramInt == 15)
    {
      a(paramInt, null);
      return;
    }
    try
    {
      a(paramInt, (String)this.jdField_a_of_type_JavaUtilLinkedList.getFirst());
      return;
    }
    catch (NoSuchElementException localNoSuchElementException) {}
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if ((paramString != null) || (paramInt == 15)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AIOGalleryCollector", 2, "post key is null, what is " + paramInt);
    return;
    if (paramInt == 0) {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramString))
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramString);
        if (QLog.isDevelopLevel()) {
          QLog.i("AIOGalleryCollector", 4, "Add key is " + paramString);
        }
      }
    }
    for (;;)
    {
      paramString = a(paramString);
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramInt, paramString).sendToTarget();
      return;
      if (1 == paramInt)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
        if (QLog.isDevelopLevel()) {
          QLog.i("AIOGalleryCollector", 4, "remove key is " + paramString);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryCollector
 * JD-Core Version:    0.7.0.1
 */