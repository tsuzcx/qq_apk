package com.tencent.biz.pubaccount;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import bkf;
import bkh;
import bki;
import bkj;
import bkk;
import bkl;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.activity.PublicAccountChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ActionInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class PublicAccountManager
{
  public static final int a = 0;
  public static final long a = 350749526L;
  private static final PublicAccountManager jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager = new PublicAccountManager();
  public static final String a = "PublicAccountManager";
  public static final boolean a = false;
  public static final int b = 1;
  static final long jdField_b_of_type_Long = 86400000L;
  public static final String b = "menuEventSharePre";
  public static final int c = 2;
  public static final String c = "update_type";
  public static final String d = "PubAccountSvc";
  public static final String e = "get_follow_list";
  public static final String f = "get_detail_info";
  public static final String g = "follow";
  public static final String h = "unfollow";
  public static final String i = "get_account_menu";
  public static final String j = "get_share_list";
  public static final String k = "set_recv_msg";
  public static final String l = "set_share_lbs";
  public static final String m = "share_to_public";
  public static final String n = "set_function_flag";
  public static final String o = "send_menu_evt";
  public Context a;
  public LBSObserver a;
  protected Runnable a;
  public WeakReference a;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(null);
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private Map c = new HashMap();
  public String p = null;
  public String q = null;
  private String r;
  
  private PublicAccountManager()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaLangRunnable = new bkk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new bkl(this);
  }
  
  public static PublicAccountManager a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager;
  }
  
  private mobileqq_mp.ButtonInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    List localList = b(paramQQAppInterface, paramString);
    if ((localList == null) || (localList.isEmpty()))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= localList.size()) {
        break label190;
      }
      paramString = (mobileqq_mp.ButtonInfo)localList.get(i1);
      if (paramString.id.has())
      {
        paramQQAppInterface = paramString;
        if (paramString.id.get() == paramInt) {
          break;
        }
      }
      if (paramString.sub_button.has())
      {
        paramQQAppInterface = paramString.sub_button.get();
        if (paramQQAppInterface.size() > 0)
        {
          int i2 = 0;
          while (i2 < paramQQAppInterface.size())
          {
            if ((((mobileqq_mp.ButtonInfo)paramQQAppInterface.get(i2)).id.has()) && (((mobileqq_mp.ButtonInfo)paramQQAppInterface.get(i2)).id.get() == paramInt)) {
              return (mobileqq_mp.ButtonInfo)paramQQAppInterface.get(i2);
            }
            i2 += 1;
          }
        }
      }
      i1 += 1;
    }
    label190:
    return null;
  }
  
  public static Class a(String paramString, AppInterface paramAppInterface)
  {
    if (((PublicAccountDataManager)paramAppInterface.getManager(51)).a(paramString + "").extendType == 2) {
      return ChatForEnterpriseActivity.class;
    }
    return PublicAccountChatActivity.class;
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo.url.has())
    {
      paramButtonInfo = paramButtonInfo.url.get();
      paramButtonInfo = new StringBuilder(paramButtonInfo);
      if (paramButtonInfo.indexOf("?") >= 0) {
        break label227;
      }
      paramButtonInfo.append("?");
    }
    for (;;)
    {
      paramButtonInfo.append("uin=" + paramQQAppInterface.a());
      paramButtonInfo.append("&puin=" + paramString);
      paramButtonInfo.append("&sid=" + paramQQAppInterface.getSid());
      Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
      localIntent.putExtra("from", QQBrowserActivity.class);
      localIntent.putExtra("url", paramButtonInfo.toString());
      localIntent.putExtra("uin", paramQQAppInterface.a());
      localIntent.putExtra("puin", paramString);
      localIntent.putExtra("assignBackText", paramContext.getResources().getString(2131561692));
      if (paramString.equalsIgnoreCase("2632129500")) {
        localIntent.putExtra("hide_operation_bar", true);
      }
      paramContext.startActivity(localIntent);
      return;
      paramButtonInfo = "";
      break;
      label227:
      if (paramButtonInfo.indexOf("?") < paramButtonInfo.length() - 1) {
        if (paramButtonInfo.indexOf("&") < 0) {
          paramButtonInfo.append("&");
        } else if (paramButtonInfo.lastIndexOf("&") < paramButtonInfo.length() - 1) {
          paramButtonInfo.append("&");
        }
      }
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, AccountDetailActivity.class);
    localIntent.putExtra("uin", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if ((paramButtonInfo.item_id.has()) && (paramButtonInfo.item_id.get() == 5))
    {
      paramQQAppInterface = new Intent(paramContext, CouponActivity.class);
      paramQQAppInterface.putExtra("url", "http://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
      paramQQAppInterface.putExtra("source", "1");
      paramQQAppInterface.putExtra("from", 5);
      paramContext.startActivity(paramQQAppInterface);
      return;
    }
    if ((paramButtonInfo.item_id.has()) && (paramButtonInfo.item_id.get() == 6))
    {
      paramQQAppInterface = new Intent(paramContext, CouponActivity.class);
      if (paramButtonInfo.url.has()) {
        paramQQAppInterface.putExtra("url", paramButtonInfo.url.get());
      }
      paramQQAppInterface.putExtra("webStyle", "noBottomBar");
      paramContext.startActivity(paramQQAppInterface);
      return;
    }
    a(paramContext, paramQQAppInterface, paramString, paramButtonInfo);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, mobileqq_mp.ButtonInfo paramButtonInfo, String paramString2)
  {
    boolean bool = true;
    long l1 = paramButtonInfo.actionInfo.appid.get();
    Object localObject = Uri.parse(paramString2);
    paramString2 = ((Uri)localObject).getScheme();
    localObject = ((Uri)localObject).getHost();
    if ((!TextUtils.isEmpty(paramString2)) && (AppUtil.a(paramString2)))
    {
      AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
      int i1;
      Bundle localBundle;
      int i2;
      if (AppLaucherHelper.a((String)localObject) == 0)
      {
        i1 = 0;
        localBundle = AppLaucherHelper.a((String)localObject);
        i2 = localBundle.getInt("a_launch_mode", 268435456);
        if (i1 == 0) {
          break label136;
        }
        localAppLaucherHelper.a(paramQQAppInterface, paramContext, String.valueOf(l1), (String)localObject, paramString2, i2);
      }
      for (;;)
      {
        if (!bool) {
          a(paramQQAppInterface, paramContext, paramString1, paramButtonInfo);
        }
        return;
        i1 = 1;
        break;
        label136:
        bool = AppUtil.a(paramContext, paramString2, localBundle, i2);
      }
    }
    a(paramQQAppInterface, paramContext, paramString1, paramButtonInfo);
  }
  
  private void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(paramLong));
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();
      return System.currentTimeMillis() - l1 >= 86400000L;
    }
    return true;
  }
  
  private List b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return (List)this.c.get(paramString);
  }
  
  public int a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {
      return ((Integer)this.jdField_b_of_type_JavaUtilMap.get(paramString)).intValue();
    }
    return 0;
  }
  
  public List a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return b(paramQQAppInterface, paramString);
  }
  
  public NewIntent a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    NewIntent localNewIntent = null;
    label105:
    do
    {
      long l1;
      try
      {
        l1 = Long.valueOf(paramString).longValue();
        if ((paramBoolean) || (a("" + l1))) {
          break label105;
        }
        paramContext = localNewIntent;
        if (QLog.isColorLevel())
        {
          QLog.i("PublicAccountManager", 2, "menu setting not outdate yet--");
          paramContext = localNewIntent;
        }
      }
      catch (NumberFormatException paramContext)
      {
        do
        {
          paramContext = localNewIntent;
        } while (!QLog.isColorLevel());
        QLog.e("PublicAccountManager", 2, "puin is invalid format:" + paramString);
        return null;
      }
      return paramContext;
      int i1 = 0;
      if (this.jdField_b_of_type_JavaUtilMap.containsKey("" + l1)) {
        i1 = ((Integer)this.jdField_b_of_type_JavaUtilMap.get("" + l1)).intValue();
      }
      localNewIntent = new NewIntent(paramContext, PublicAccountServlet.class);
      localNewIntent.putExtra("cmd", "get_account_menu");
      paramContext = new mobileqq_mp.GetPublicAccountMenuRequest();
      paramContext.seqno.set(i1);
      paramContext.uin.set((int)l1);
      localNewIntent.putExtra("data", paramContext.toByteArray());
      localNewIntent.setObserver(new bkh(this, localNewIntent, paramQQAppInterface, paramString, paramBusinessObserver));
      paramContext = localNewIntent;
    } while (paramQQAppInterface == null);
    paramQQAppInterface.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.c.clear();
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, PublicAccountManager.InitDoneObserver paramInitDoneObserver)
  {
    if ((paramString1 != null) && (!paramString1.equals(this.r))) {
      a();
    }
    this.r = paramString1;
    ThreadManager.b(new bkf(this, paramString2, paramQQAppInterface, paramInitDoneObserver, paramContext));
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2, BusinessObserver paramBusinessObserver)
  {
    try
    {
      long l1 = Long.valueOf(paramString1).longValue();
      NewIntent localNewIntent = new NewIntent(paramContext, PublicAccountServlet.class);
      localNewIntent.putExtra("cmd", "send_menu_evt");
      mobileqq_mp.SendMenuEventRequest localSendMenuEventRequest = new mobileqq_mp.SendMenuEventRequest();
      localSendMenuEventRequest.key.set(paramString2);
      localSendMenuEventRequest.uin.set((int)l1);
      localSendMenuEventRequest.type.set(1);
      if (paramBoolean)
      {
        localSendMenuEventRequest.is_need_lbs.set(true);
        localSendMenuEventRequest.latitude.set(paramDouble1);
        localSendMenuEventRequest.longitude.set(paramDouble2);
      }
      localNewIntent.putExtra("data", localSendMenuEventRequest.toByteArray());
      localNewIntent.setObserver(new bki(this, localNewIntent, paramContext, paramString1, paramBusinessObserver, paramQQAppInterface));
      if (paramQQAppInterface != null) {
        paramQQAppInterface.startServlet(localNewIntent);
      }
      return;
    }
    catch (NumberFormatException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublicAccountManager", 2, "puin is invalid format:" + paramString1);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountManager", 4, "savePublicAccountMenuSetting");
    }
    if (paramGetPublicAccountMenuResponse == null) {
      break label19;
    }
    label19:
    while (paramQQAppInterface == null) {
      return;
    }
    if (paramGetPublicAccountMenuResponse.seqno.has()) {}
    for (int i1 = paramGetPublicAccountMenuResponse.seqno.get();; i1 = 0)
    {
      a(paramString, i1);
      long l1 = System.currentTimeMillis();
      a(paramString, l1);
      if (paramGetPublicAccountMenuResponse.toByteArray() == null) {
        break;
      }
      ThreadManager.b(new bkj(this, paramQQAppInterface, paramString, paramGetPublicAccountMenuResponse, l1));
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2, int paramInt, BusinessObserver paramBusinessObserver, Handler paramHandler)
  {
    mobileqq_mp.ButtonInfo localButtonInfo = a(paramQQAppInterface, paramString2, paramInt);
    if (localButtonInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountManager", 2, "Can't find menu via menu id:" + paramInt + ".");
      }
    }
    do
    {
      return;
      if (localButtonInfo.type.has()) {
        paramInt = localButtonInfo.type.get();
      }
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBusinessObserver);
        if ((localButtonInfo.is_need_lbs.has()) && (localButtonInfo.is_need_lbs.get()))
        {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
          this.jdField_a_of_type_AndroidContentContext = paramContext;
          this.p = paramString2;
          if (localButtonInfo.key.has()) {}
          for (paramString1 = localButtonInfo.key.get();; paramString1 = "")
          {
            this.q = paramString1;
            new Thread(this.jdField_a_of_type_JavaLangRunnable).start();
            return;
            paramInt = 0;
            break;
          }
        }
        if (paramHandler != null) {
          paramHandler.sendEmptyMessage(19);
        }
        a(paramContext, paramQQAppInterface, paramString2, paramString1, false, 0.0D, 0.0D, (BusinessObserver)this.jdField_b_of_type_JavaLangRefWeakReference.get());
        return;
      case 2: 
        paramString1 = localButtonInfo.actionInfo.a_actionData.get();
        paramBusinessObserver = localButtonInfo.actionInfo.actionData.get();
        if (TextUtils.isEmpty(paramString1)) {
          paramString1 = paramBusinessObserver;
        }
        while (TextUtils.isEmpty(paramString1))
        {
          a(paramQQAppInterface, paramContext, paramString2, localButtonInfo);
          return;
        }
        paramBusinessObserver = JumpParser.a(paramQQAppInterface, paramContext, paramString1);
        if (paramBusinessObserver == null)
        {
          if (localButtonInfo.actionInfo.appid.has())
          {
            a(paramQQAppInterface, paramContext, paramString2, localButtonInfo, paramString1);
            return;
          }
          a(paramQQAppInterface, paramContext, paramString2, localButtonInfo);
          return;
        }
        if (TextUtils.isEmpty(paramBusinessObserver.a()))
        {
          a(paramQQAppInterface, paramContext, paramString2, localButtonInfo, paramString1);
          return;
        }
        break;
      }
    } while (paramBusinessObserver.b());
    a(paramQQAppInterface, paramContext, paramString2, localButtonInfo);
    return;
    if (localButtonInfo.event_id.has()) {}
    for (paramInt = localButtonInfo.event_id.get();; paramInt = 0)
    {
      switch (paramInt)
      {
      default: 
        return;
      }
      a(paramContext, paramString2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountManager
 * JD-Core Version:    0.7.0.1
 */