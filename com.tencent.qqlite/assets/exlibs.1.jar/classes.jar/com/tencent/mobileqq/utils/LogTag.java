package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class LogTag
{
  public static final String a = "StartRecordTime";
  private static ThreadLocal a = new ThreadLocal();
  public static final String b = "ThemeDownloadTrace";
  public static final String c = "SelectPhotoTrace";
  public static final String d = "AIOSign";
  public static final String e = "VoiceTipMsg";
  public static final String f = "AIOQzoneFeed";
  public static final String g = "AIOAudioPanel";
  public static final String h = "PEAK";
  public static final String i = "PEAK_ACTIVITY";
  public static final String j = PhotoListActivity.class.getSimpleName();
  public static final String k = AlbumListActivity.class.getSimpleName();
  public static final String l = PhotoPreviewActivity.class.getSimpleName();
  
  public static void a()
  {
    if (QLog.isColorLevel())
    {
      LinkedList localLinkedList2 = (LinkedList)a.get();
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = new LinkedList();
        a.set(localLinkedList1);
      }
      localLinkedList1.addFirst(Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      Object localObject2 = (LinkedList)a.get();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedList();
        a.set(localObject1);
        ((LinkedList)localObject1).addFirst(Long.valueOf(SystemClock.uptimeMillis()));
      }
      localObject2 = new StringBuilder();
      int m = 1;
      while (m < ((LinkedList)localObject1).size())
      {
        ((StringBuilder)localObject2).append("    ");
        m += 1;
      }
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(":cost ");
      ((StringBuilder)localObject2).append(SystemClock.uptimeMillis() - ((Long)((LinkedList)a.get()).removeFirst()).longValue());
      QLog.i(paramString1, 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.LogTag
 * JD-Core Version:    0.7.0.1
 */