package com.tencent.mobileqq.app;

import PayMQQ.UniPayRequest;
import PayMQQ.UniPayResponse;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UniPayHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "UniPayHandler";
  public static final int b = 2;
  public static final String b = "VipSTCheckServer.UinPay";
  public static final int c = 3;
  public static final String c = "uniPaySp_";
  public static final int d = 4;
  public static final String d = "sUin";
  public static final int e = 5;
  public static final String e = "isShowOpen";
  public static final int f = 6;
  public static final String f = "iUinpPayType";
  public static final int g = 7;
  public static final String g = "uniMap";
  public static final int h = 8;
  public static final String h = "cur_st";
  public static final int i = 9;
  public static final String i = "net_mobile_club";
  public static final String j = "open_month";
  public static final String k = "platform";
  public static final String l = "ret";
  public static final String m = "show_open";
  public static final String n = "uin";
  public static final String o = "uin_pay_type";
  private ArrayList a;
  
  protected UniPayHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((UniPayHandler.UniPayUpdateListener)localIterator.next()).a();
    }
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(UniPayHandler.UniPayUpdateListener paramUniPayUpdateListener)
  {
    if (paramUniPayUpdateListener == null) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramUniPayUpdateListener)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramUniPayUpdateListener);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null)) {}
    do
    {
      do
      {
        return;
        str1 = paramToServiceMsg.getServiceCmd();
      } while (TextUtils.isEmpty(str1));
      if ((str1.compareTo("VipSTCheckServer.UinPay") == 0) && (QLog.isColorLevel())) {
        QLog.i("UniPayHandler", 2, "req---" + paramToServiceMsg + ",res----" + paramFromServiceMsg + ",data-----" + paramObject);
      }
    } while (str1.compareTo("VipSTCheckServer.UinPay") != 0);
    paramFromServiceMsg = (UniPayResponse)paramObject;
    paramToServiceMsg = paramFromServiceMsg.getSUin();
    int i1 = paramFromServiceMsg.getIShowOpen();
    int i2 = paramFromServiceMsg.getIUniPayType();
    new HashMap();
    Object localObject = paramFromServiceMsg.getMapResponse();
    paramFromServiceMsg = (String)((Map)localObject).get("cur_st");
    paramObject = (String)((Map)localObject).get("net_mobile_club");
    String str1 = (String)((Map)localObject).get("open_month");
    String str2 = (String)((Map)localObject).get("platform");
    String str3 = (String)((Map)localObject).get("ret");
    String str4 = (String)((Map)localObject).get("show_open");
    String str5 = (String)((Map)localObject).get("uin");
    localObject = (String)((Map)localObject).get("uin_pay_type");
    if (QLog.isColorLevel()) {
      QLog.d("UniPayHandler", 2, "sUin==" + paramToServiceMsg + ",isShowOpen==" + i1 + ",iUniPayType==" + i2);
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("uniPaySp_" + paramToServiceMsg, 0);
    localSharedPreferences.edit().putString("sUin", paramToServiceMsg).commit();
    localSharedPreferences.edit().putInt("isShowOpen", i1).commit();
    localSharedPreferences.edit().putInt("iUinpPayType", i2).commit();
    localSharedPreferences.edit().putString("cur_st", paramFromServiceMsg).commit();
    localSharedPreferences.edit().putString("net_mobile_club", paramObject).commit();
    localSharedPreferences.edit().putString("open_month", str1).commit();
    localSharedPreferences.edit().putString("platform", str2).commit();
    localSharedPreferences.edit().putString("ret", str3).commit();
    localSharedPreferences.edit().putString("show_open", str4).commit();
    localSharedPreferences.edit().putString("uin", str5).commit();
    localSharedPreferences.edit().putString("uin_pay_type", (String)localObject).commit();
    a();
  }
  
  public void a(String paramString)
  {
    paramString = new UniPayRequest(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "android" + paramString);
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "VipSTCheckServer.UinPay");
    localToServiceMsg.extraData.putSerializable("UniPayRequest", paramString);
    super.a(localToServiceMsg);
  }
  
  public void b(UniPayHandler.UniPayUpdateListener paramUniPayUpdateListener)
  {
    if ((paramUniPayUpdateListener != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramUniPayUpdateListener))) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramUniPayUpdateListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.UniPayHandler
 * JD-Core Version:    0.7.0.1
 */