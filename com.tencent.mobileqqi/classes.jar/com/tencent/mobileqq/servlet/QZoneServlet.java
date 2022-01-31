package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gjh;
import java.util.Timer;
import mqq.app.Servlet;

public class QZoneServlet
  extends Servlet
  implements IHttpCommunicatorListener
{
  private static long jdField_a_of_type_Long = 60000L;
  public static final String a = "QZone_Get_Unread";
  public static final String b = "QZone_Update_Unread_Count";
  public SharedPreferences a;
  private gjh jdField_a_of_type_Gjh;
  private Timer jdField_a_of_type_JavaUtilTimer;
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilTimer == null) {
      this.jdField_a_of_type_JavaUtilTimer = ThreadManager.a();
    }
    if (this.jdField_a_of_type_Gjh != null)
    {
      this.jdField_a_of_type_Gjh.cancel();
      this.jdField_a_of_type_Gjh = null;
    }
    this.jdField_a_of_type_Gjh = new gjh(this, null);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_Gjh, jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneServlet", 2, "QZONE GET UNREAD Start");
    }
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg2.a() == null) {
      return;
    }
    paramHttpMsg1 = QZoneFeedCountPackeger.a(paramHttpMsg2.a(), null, null);
    if (paramHttpMsg1 != null)
    {
      ((QZoneManagerImp)((QQAppInterface)getAppRuntime()).getManager(9)).a(paramHttpMsg1, null);
      if ((paramHttpMsg1[0] <= 0L) && (paramHttpMsg1[1] <= 0L)) {
        break label143;
      }
    }
    label143:
    for (boolean bool = true;; bool = false)
    {
      if (paramHttpMsg1[2] > 0L) {}
      paramHttpMsg1 = new Bundle();
      paramHttpMsg1.putBoolean("new", bool);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneServlet", 2, "inform QZONE_GET_UNREAD isSuccess true");
      }
      notifyObserver(null, 1000, true, paramHttpMsg1, QZoneObserver.class);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneServlet", 2, "inform QZONE_GET_UNREAD isSuccess false");
      }
      notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
      return;
    }
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
  }
  
  public void onDestroy() {}
  
  public void service(Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (((String)localObject).equals("QZone_Get_Unread"))
    {
      localObject = (QQAppInterface)getAppRuntime();
      bool1 = paramIntent.getBooleanExtra("bNotWorkInBackGround", false);
      bool2 = paramIntent.getBooleanExtra("isQzoneStart", false);
      if ((bool1) && (((QQAppInterface)localObject).isBackground_Pause) && (!bool2)) {
        a();
      }
    }
    while (!"QZone_Update_Unread_Count".equals(localObject))
    {
      do
      {
        boolean bool1;
        boolean bool2;
        return;
        int i = ((QQAppInterface)localObject).a().getResources().getDisplayMetrics().widthPixels;
        int j = ((QQAppInterface)localObject).a().getResources().getDisplayMetrics().heightPixels;
        paramIntent = QZoneFeedCountPackeger.a(Long.parseLong(((QQAppInterface)localObject).getAccount()), ((QQAppInterface)localObject).getSid(), i, j, 102);
        if (paramIntent != null)
        {
          paramIntent = new HttpMsg("http://scannon.3g.qq.com/api", paramIntent, this);
          paramIntent.c("POST");
          paramIntent.a(false);
          ((QQAppInterface)localObject).a().a(paramIntent);
        }
        a();
      } while (!QLog.isColorLevel());
      QLog.d("QZoneServlet", 2, "QZONE GET UNREAD Start");
      return;
    }
    paramIntent = new Bundle();
    paramIntent.putBoolean("new", true);
    notifyObserver(null, 1000, true, paramIntent, QZoneObserver.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneServlet
 * JD-Core Version:    0.7.0.1
 */