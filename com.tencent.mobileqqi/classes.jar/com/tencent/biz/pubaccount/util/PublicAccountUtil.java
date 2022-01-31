package com.tencent.biz.pubaccount.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import blb;
import blc;
import bld;
import ble;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpResponseBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.AccountManager;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

public class PublicAccountUtil
{
  public static final int a = 1;
  public static final String a = "PublicAccountUtil";
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static AccountDetail a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramString = (AccountDetail)paramQQAppInterface.a(AccountDetail.class, paramString);
    paramQQAppInterface.a();
    return paramString;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(paramArrayOfByte[i]).append(",");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if ((localComponentName == null) || (TextUtils.isEmpty(paramString))) {}
    label187:
    for (;;)
    {
      return;
      int i = paramString.indexOf("?");
      if (i != -1)
      {
        paramString = paramString.substring(i + 1).split("&");
        i = 0;
        for (;;)
        {
          if (i >= paramString.length) {
            break label187;
          }
          if (paramString[i].startsWith("_webviewtype="))
          {
            paramString = paramString[i].split("=");
            if ((paramString.length != 2) || (TextUtils.isEmpty(paramString[1]))) {
              break;
            }
            try
            {
              switch (Integer.parseInt(paramString[1]))
              {
              case 0: 
              case 1: 
                paramIntent.setComponent(new ComponentName(localComponentName.getPackageName(), CouponActivity.class.getName()));
                return;
              }
            }
            catch (NumberFormatException paramIntent)
            {
              return;
            }
          }
          if (paramString[i].startsWith("url="))
          {
            paramString = paramString[i].split("=");
            if ((paramString.length != 2) || (TextUtils.isEmpty(paramString[1]))) {
              break;
            }
            a(paramIntent, URLDecoder.decode(paramString[1]));
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    if ((paramAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      NewIntent localNewIntent = new NewIntent(paramContext.getApplicationContext(), PublicAccountServlet.class);
      localNewIntent.putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      try
      {
        localFollowRequest.uin.set((int)Long.parseLong(paramString));
        localNewIntent.setObserver(new bld(paramAppInterface, paramContext, paramString));
        localNewIntent.putExtra("data", localFollowRequest.toByteArray());
        paramAppInterface.startServlet(localNewIntent);
        return;
      }
      catch (NumberFormatException paramAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.w("PublicAccountUtil", 2, "Follow Request got wrong uin:" + paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    String str = paramQQAppInterface.getSid();
    if (TextUtils.isEmpty(str))
    {
      ((AccountManager)paramQQAppInterface.getManager(0)).updateSid(new blb(paramQQAppInterface, paramContext, paramString));
      return;
    }
    b(paramQQAppInterface, paramContext, paramString, str);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    localActionSheet.a(paramContext.getResources().getString(2131560601));
    localActionSheet.a(2131561917, 3);
    if (paramString.equals("2010741172")) {
      localActionSheet.c(2131560550);
    }
    localActionSheet.d(2131561746);
    localActionSheet.a(new blc(paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean, paramContext, localActionSheet));
    localActionSheet.show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AccountDetail paramAccountDetail)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.b(paramAccountDetail);
    paramQQAppInterface.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.a(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.a(10);
    if (localPublicAccountHandler.a == null) {
      localPublicAccountHandler.a = new ArrayList();
    }
    localPublicAccountHandler.a.add(paramString);
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.a(paramString);
    paramQQAppInterface.a();
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      paramAppInterface = paramAppInterface.a(paramAppInterface.getAccount()).createEntityManager();
      paramString = (AccountDetail)paramAppInterface.a(AccountDetail.class, paramString);
      paramAppInterface.a();
    } while (paramString == null);
    try
    {
      paramAppInterface = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      paramAppInterface.mergeFrom(paramString.accountData);
      int i = paramAppInterface.follow_type.get();
      if (i == 1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramAppInterface) {}
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.a(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.a(10);
    if (localPublicAccountHandler.a == null)
    {
      EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
      localPublicAccountHandler.a = localEntityManager.a(UinPair.class, false, "userUin=? ", new String[] { paramQQAppInterface.a() }, null, null, null, null);
      localEntityManager.a();
      if (localPublicAccountHandler.a == null) {
        localPublicAccountHandler.a = new ArrayList();
      }
    }
    return localPublicAccountHandler.a.contains(paramString);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString2.indexOf("?") != -1) {
      return b(paramString1, paramString2);
    }
    if (paramString2.indexOf("*") != -1) {
      return c(paramString1, paramString2);
    }
    return false;
  }
  
  public static byte[] a(String paramString)
  {
    paramString = paramString.split(",");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramString.length);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.put((byte)Integer.parseInt(paramString[i]));
      i += 1;
    }
    return localByteBuffer.array();
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    label39:
    label319:
    label326:
    for (;;)
    {
      return;
      int i = paramString1.indexOf("?");
      if (i != -1)
      {
        paramString1 = paramString1.substring(i + 1).split("&");
        i = 0;
        if (i < paramString1.length) {
          if (!paramString1[i].startsWith("url=")) {}
        }
        for (paramString1 = URLDecoder.decode(paramString1[i].split("=")[1]);; paramString1 = "")
        {
          if (TextUtils.isEmpty(paramString1)) {
            break label326;
          }
          i = paramString1.indexOf("?");
          if (i == -1) {
            break;
          }
          paramString1 = paramString1.substring(i + 1).split("&");
          paramQQAppInterface.a();
          i = 0;
          label116:
          if (i < paramString1.length) {
            if (!paramString1[i].startsWith("mailid=")) {}
          }
          for (paramString1 = paramString1[i].split("=")[1];; paramString1 = "")
          {
            if (TextUtils.isEmpty(paramString1)) {
              break label319;
            }
            paramQQAppInterface = String.format("http://w.mail.qq.com/cgi-bin/login?mailid=%1$s&target=mobileqqdel&fwd=mq&uin=%2$s&fun=from3g&3g_sid=%3$s", new Object[] { paramString1, paramQQAppInterface.a(), paramString2 });
            try
            {
              paramQQAppInterface = HttpBaseUtil.a(paramQQAppInterface, "GET", new Bundle(), null).a;
              if (paramQQAppInterface.getStatusLine().getStatusCode() != 200) {
                continue;
              }
              paramQQAppInterface = new JSONObject(HttpBaseUtil.a(paramQQAppInterface));
              if (!paramQQAppInterface.has("ret")) {
                continue;
              }
              i = paramQQAppInterface.getInt("ret");
              if (i != 0) {
                continue;
              }
              i = 1;
            }
            catch (Exception paramQQAppInterface)
            {
              for (;;)
              {
                i = 0;
                continue;
                i = 0;
              }
            }
            if (i != 0) {
              break;
            }
            QQToast.a(paramContext.getApplicationContext(), paramContext.getResources().getString(2131560551), 0).a();
            return;
            i += 1;
            break label39;
            i += 1;
            break label116;
          }
          break;
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = new UinPair(paramQQAppInterface.a(), paramString);
    PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)paramQQAppInterface.a(10);
    if ((localPublicAccountHandler.a != null) && (localPublicAccountHandler.a.contains(paramString))) {
      localPublicAccountHandler.a.remove(paramString);
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.b(paramString);
    paramQQAppInterface.a();
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    if (paramString1.length() != paramString2.length()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramString2.length()) {
        break label53;
      }
      if ((paramString1.charAt(i) != paramString2.charAt(i)) && (paramString2.charAt(i) != '?')) {
        break;
      }
      i += 1;
    }
    label53:
    return true;
  }
  
  private static void c(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest");
    }
    NewIntent localNewIntent = new NewIntent(paramContext, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.version.set(1);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      label76:
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new ble(paramContext, paramAppInterface));
      paramAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception paramString)
    {
      break label76;
    }
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    int m = paramString1.length();
    int k = paramString2.length();
    int n = paramString2.indexOf("*");
    int i;
    boolean bool1;
    switch (n)
    {
    default: 
      i = 0;
      if (i < n) {
        if (paramString1.charAt(i) != paramString2.charAt(i)) {
          bool1 = false;
        }
      }
      break;
    case -1: 
    case 0: 
      label72:
      do
      {
        do
        {
          return bool1;
          if (m != k) {
            break;
          }
          bool1 = bool2;
        } while (m == 0);
        i = 0;
        for (;;)
        {
          bool1 = bool2;
          if (i >= k) {
            break;
          }
          if (paramString1.charAt(i) != paramString2.charAt(i)) {
            return false;
          }
          i += 1;
        }
        return false;
        bool1 = bool2;
      } while (k == 1);
      i = 0;
      label139:
      if (i < m) {
        if ((paramString1.charAt(i) != paramString2.charAt(n + 1)) && (paramString2.charAt(n + 1) != '*')) {}
      }
      break;
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        return false;
        i += 1;
        break label139;
      }
      bool1 = bool2;
      if (i == m) {
        break label72;
      }
      return c(paramString1.substring(i, m), paramString2.substring(n + 1, k));
      i += 1;
      break;
      return c(paramString1.substring(n, m), paramString2.substring(n, k));
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil
 * JD-Core Version:    0.7.0.1
 */