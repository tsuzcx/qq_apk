import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.NotificationClickReceiver;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import cooperation.qzone.report.lp.LpReportInfo_dc01245;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class avyt
{
  private static avyt a;
  
  private Intent a(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = avpw.k(paramQQAppInterface.getApp());
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getAccount());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("FromNotification", true);
    localIntent.putExtras(paramQQAppInterface);
    localIntent.addFlags(67108864);
    localIntent.putExtra("src_type", "app");
    localIntent.putExtra("isFromQQ", "true");
    localIntent.putExtra("page", "tab_remind");
    localIntent.putExtra("version", "1");
    return localIntent;
  }
  
  private Intent a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    paramQQAppInterface = new Intent(paramQQAppInterface.getApp(), TranslucentActivity.class);
    paramQQAppInterface.addFlags(268435456);
    if (paramIntent != null) {
      paramQQAppInterface.putExtras(paramIntent);
    }
    return paramQQAppInterface;
  }
  
  private Intent a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.x(paramQQAppInterface, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramQQAppInterface.putExtra("qqid", Long.parseLong(paramString));
    paramQQAppInterface.putExtra("qzone_entry", 0);
    return paramQQAppInterface;
  }
  
  public static avyt a()
  {
    if (a == null) {
      a = new avyt();
    }
    return a;
  }
  
  private void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramInt != 0)) {}
    try
    {
      paramQQAppInterface.cLD();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("MsgNotification", 1, paramQQAppInterface, new Object[0]);
    }
  }
  
  private Intent b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.x(paramQQAppInterface, "com.qzone.misc.web.QZoneTranslucentActivity");
    paramQQAppInterface.setAction("action_js2qzone");
    paramQQAppInterface.putExtra("cmd", "Schema");
    paramQQAppInterface.putExtra("schema", paramString);
    return paramQQAppInterface;
  }
  
  private void d(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str2 = "";
    String str1 = str2;
    Uri localUri;
    if (paramString1 != null)
    {
      localUri = Uri.parse(paramString1);
      if (!TextUtils.isEmpty(localUri.getQueryParameter("from"))) {
        break label142;
      }
      str1 = str2;
      if (localUri.getPathSegments().size() > 0) {
        str1 = (String)localUri.getPathSegments().get(0);
      }
    }
    if (paramBoolean) {
      LpReportInfo_dc00420.report(10, 0, str1, paramString2, 1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("pushReport", 2, "EXPOSE: uin: " + paramQQAppInterface.getAccount() + " schema: " + paramString1 + " pushstatkey: " + paramString2 + " fake:" + paramBoolean);
      }
      return;
      label142:
      str1 = localUri.getQueryParameter("from");
      break;
      LpReportInfo_dc00420.report(2, 0, str1, paramString2, 1);
    }
  }
  
  private Intent i(String paramString)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localUri = Uri.parse(paramString);
        localBundle.putString("cellid", localUri.getQueryParameter("uid"));
        localObject = localUri.getQueryParameter("subid");
        if (paramString.contains("photonum"))
        {
          localHashMap = new HashMap();
          localHashMap.put(Integer.valueOf(7), localUri.getQueryParameter("photonum"));
          if (Integer.valueOf(localUri.getQueryParameter("photonum")).intValue() <= 1) {
            continue;
          }
          str = localUri.getQueryParameter("bid");
          localObject = str;
          if (paramString.contains("bid"))
          {
            localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
            localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
            localObject = str;
          }
          localBundle.putParcelable("businessparam", new MapParcelable(localHashMap));
        }
        localBundle.putString("subid", (String)localObject);
        localBundle.putLong("targetuin", Long.parseLong(localUri.getQueryParameter("uin")));
        localBundle.putInt("appid", Integer.parseInt(localUri.getQueryParameter("appid")));
      }
      catch (Exception paramString)
      {
        Uri localUri;
        Object localObject;
        HashMap localHashMap;
        String str;
        QLog.e("MsgNotification", 1, "getQZoneDetailIntent", paramString);
        continue;
      }
      paramString = avpw.G();
      paramString.putExtras(localBundle);
      return paramString;
      str = "";
      localObject = str;
      if (paramString.contains("bid"))
      {
        localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
        localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
        localObject = str;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, String paramString5, String paramString6, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramQQAppInterface == null) {}
    AppRuntime.Status localStatus;
    label25:
    do
    {
      return;
      localStatus = paramQQAppInterface.getOnlineStatus();
      if (localStatus == AppRuntime.Status.dnd) {
        break;
      }
      a(paramInt1, paramQQAppInterface);
    } while (FriendsStatusUtil.bc(paramQQAppInterface.getApp()));
    a(paramInt1, paramQQAppInterface);
    Object localObject2 = (aneo)paramQQAppInterface.getManager(10);
    Object localObject1;
    int i;
    switch (paramInt2)
    {
    default: 
      paramInt1 = 1;
      localObject1 = null;
      i = 0;
    }
    for (;;)
    {
      for (;;)
      {
        label120:
        localObject2 = new Intent();
        ((Intent)localObject2).setClass(paramQQAppInterface.getApp(), NotificationClickReceiver.class);
        ((Intent)localObject2).putExtra("realIntent", (Parcelable)localObject1);
        ((Intent)localObject2).putExtra("hostuin", paramQQAppInterface.getAccount());
        ((Intent)localObject2).putExtra("pushschema", paramString5);
        ((Intent)localObject2).putExtra("pushstatkey", paramString6);
        ((Intent)localObject2).putExtra("param_notifyid", i);
        Object localObject3 = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), i, (Intent)localObject2, 134217728);
        if ((paramInt2 != 366) || (!TextUtils.isEmpty(paramString1))) {}
        try
        {
          localObject1 = BitmapFactory.decodeResource(paramQQAppInterface.getApp().getResources(), 2130849366);
          localObject2 = localObject1;
          if (localObject1 != null) {
            localObject2 = localObject1;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          try
          {
            for (;;)
            {
              if (Build.VERSION.SDK_INT >= 11)
              {
                j = paramQQAppInterface.getApp().getResources().getDimensionPixelSize(17104901);
                k = paramQQAppInterface.getApp().getResources().getDimensionPixelSize(17104902);
                if (j == ((Bitmap)localObject1).getWidth())
                {
                  localObject2 = localObject1;
                  if (k == ((Bitmap)localObject1).getHeight()) {}
                }
                else
                {
                  localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, j, k, false);
                }
              }
              localObject1 = localObject2;
              j = 2130848386;
              if (paramInt2 != 8) {
                break label1311;
              }
              j = 2130842268;
              localObject1 = null;
              localObject2 = ajcd.a(paramQQAppInterface);
              if (((ajcd)localObject2).bh(paramString3, paramString4)) {
                localObject1 = ((ajcd)localObject2).a(paramString3, paramString4, null);
              }
              if (aqoq.cVi) {
                break label1385;
              }
              paramString1 = avyu.a().a((PendingIntent)localObject3, paramQQAppInterface.getApp(), (Bitmap)localObject1, paramString1, paramString2, j);
              if ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 300))
              {
                paramString2 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
                paramString2.setPackage(MobileQQ.getContext().getPackageName());
                paramString2.putExtra("pushstatkey", paramString6);
                paramString2.putExtra("mergenum", paramInt1);
                paramString2.putExtra("pushtype", paramInt2);
                paramString1.deleteIntent = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), i, paramString2, 134217728);
              }
              auqw.setMIUI6Badge(paramQQAppInterface.getApp(), 0, paramString1);
              if (localStatus != AppRuntime.Status.dnd) {
                break label1443;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("MsgNotification", 2, "showQZoneMsgNotification, dnd shield hide notify");
              return;
              if (!QLog.isColorLevel()) {
                break label25;
              }
              QLog.d("MsgNotification", 2, "showQZoneMsgNotification, dnd shield sound");
              break label25;
              localObject1 = a(paramQQAppInterface);
              ((Intent)localObject1).putExtra("launch_time", System.currentTimeMillis());
              ((Intent)localObject1).putExtra("refer", "msg_notification");
              ((Intent)localObject1).putExtra("fling_action_key", 2);
              ((Intent)localObject1).putExtra("fling_code_key", hashCode());
              localObject1 = a(paramQQAppInterface, (Intent)localObject1);
              if (localObject2 == null) {
                break label1565;
              }
              paramInt1 = ((aneo)localObject2).jn(1);
              ((aneo)localObject2).an(1, paramInt1);
              if (paramInt1 > 0) {
                break label1557;
              }
              paramInt1 = 1;
              i = 241;
              break label120;
              localObject1 = a(paramQQAppInterface, i(paramString5));
              paramInt1 = 1;
              i = 244;
              break label120;
              for (;;)
              {
                try
                {
                  for (;;)
                  {
                    localObject2 = b(paramQQAppInterface, paramString5);
                    localObject1 = localObject2;
                    try
                    {
                      for (;;)
                      {
                        localObject2 = a(paramQQAppInterface, (Intent)localObject2);
                        if (paramBoolean2)
                        {
                          localObject1 = localObject2;
                          localObject3 = new QZoneClickReport.a();
                          localObject1 = localObject2;
                          ((QZoneClickReport.a)localObject3).actionType = String.valueOf(322);
                          localObject1 = localObject2;
                          ((QZoneClickReport.a)localObject3).cMI = String.valueOf(2);
                          localObject1 = localObject2;
                          ((QZoneClickReport.a)localObject3).reserves = String.valueOf(6);
                          localObject1 = localObject2;
                          QZoneClickReport.report(paramQQAppInterface.getAccount(), (QZoneClickReport.a)localObject3, true);
                        }
                        localObject1 = localObject2;
                        localObject3 = Uri.parse(paramString5);
                        localObject1 = localObject2;
                        avyv localavyv = new avyv(((Uri)localObject3).getQueryParameter("room"), paramString2, paramBoolean1, paramInt2, paramString5, paramString6);
                        localObject1 = localObject2;
                        if (aneb.Gt == null)
                        {
                          localObject1 = localObject2;
                          aneb.Gt = Collections.synchronizedList(new ArrayList());
                        }
                        if (paramBoolean2)
                        {
                          localObject1 = localObject2;
                          aneb.Gt.add(localavyv);
                        }
                        try
                        {
                          LpReportInfo_dc01245.report(Long.parseLong(((Uri)localObject3).getQueryParameter("uin")), Long.parseLong(BaseApplicationImpl.getApplication().getRuntime().getAccount()), 11, 0);
                          localObject1 = localObject2;
                          paramInt1 = 1;
                          i = 242;
                        }
                        catch (Exception localException5)
                        {
                          for (;;)
                          {
                            localObject1 = localObject2;
                            QLog.e("MsgNotification", 1, localException5.getStackTrace());
                          }
                        }
                      }
                      QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_LIVE error", localException1);
                    }
                    catch (Exception localException1) {}
                  }
                }
                catch (Exception localException4)
                {
                  Bitmap localBitmap1 = null;
                }
              }
              if ((paramString5 != null) && (paramString5.startsWith("mqzonev2://arouse/openhomepage"))) {}
              for (;;)
              {
                try
                {
                  localObject1 = a(paramQQAppInterface, Uri.parse(paramString5).getQueryParameter("uin"));
                }
                catch (Exception localException2)
                {
                  try
                  {
                    Intent localIntent = a(paramQQAppInterface, (Intent)localObject1);
                    localObject1 = localIntent;
                    paramInt1 = 1;
                    i = 243;
                  }
                  catch (Exception localException3)
                  {
                    Bitmap localBitmap2;
                    Bitmap localBitmap3;
                    ajcd localajcd;
                    break label1002;
                  }
                  localException2 = localException2;
                  localObject1 = null;
                }
                label1002:
                QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_SCHEMA error", localException2);
                continue;
                localObject1 = a(paramQQAppInterface, b(paramQQAppInterface, paramString5));
              }
              paramString1 = BaseApplication.getContext().getString(2131720731);
              continue;
              if ((TextUtils.isEmpty(paramString1)) || (paramInt2 != 8)) {
                if (paramBoolean1)
                {
                  if ((paramInt2 == 2) || (paramInt2 == 8) || (paramInt2 == 4)) {
                    paramString1 = BaseApplication.getContext().getString(2131718994);
                  } else {
                    paramString1 = BaseApplication.getContext().getString(2131718994) + "(" + BaseApplication.getContext().getString(2131694791) + paramInt1 + BaseApplication.getContext().getString(2131720491) + BaseApplication.getContext().getString(2131721567) + ")";
                  }
                }
                else {
                  paramString1 = BaseApplication.getContext().getString(2131718994);
                }
              }
            }
            localOutOfMemoryError1 = localOutOfMemoryError1;
            if (QLog.isColorLevel()) {
              QLog.e("MsgNotification", 2, "Exception:" + localOutOfMemoryError1.toString());
            }
            localBitmap1 = null;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              try
              {
                localBitmap2 = BitmapFactory.decodeResource(paramQQAppInterface.getApp().getResources(), 2130849263);
                localBitmap1 = localBitmap2;
                try
                {
                  QLog.e("MsgNotification", 1, "use small icon ,exp:", localThrowable);
                }
                catch (OutOfMemoryError localOutOfMemoryError2) {}
              }
              catch (OutOfMemoryError localOutOfMemoryError3)
              {
                int j;
                int k;
                label1311:
                label1385:
                continue;
              }
              if (QLog.isColorLevel()) {
                QLog.e("MsgNotification", 2, "Exception:" + localOutOfMemoryError2.toString());
              }
              continue;
              if (paramInt2 == 366)
              {
                k = 2130849080;
                localBitmap3 = aqcu.decodeResource(paramQQAppInterface.getApp().getResources(), 2130840732);
                localajcd = ajcd.a(paramQQAppInterface);
                localBitmap1 = localBitmap3;
                j = k;
                if (localajcd.bh(paramString3, paramString4))
                {
                  localBitmap1 = localajcd.a(paramString3, paramString4, localBitmap3);
                  j = k;
                  continue;
                  if ("oppo".equalsIgnoreCase(aqgz.getManufacturer())) {
                    paramString1 = avyu.a().b(localException5, paramQQAppInterface.getApp(), localBitmap1, paramString1, paramString2, j);
                  } else {
                    paramString1 = avyu.a().c(localException5, paramQQAppInterface.getApp(), localBitmap1, paramString1, paramString2, j);
                  }
                }
              }
            }
            label1443:
            if (paramBoolean3) {
              try
              {
                d(paramQQAppInterface, paramString5, paramString6, true);
                return;
              }
              catch (Exception paramString1)
              {
                QLog.e("MsgNotification", 1, "MsgNotification.showQZoneMsgNotification notify exception ", paramString1);
              }
            }
            for (;;)
            {
              if (paramQQAppInterface != null)
              {
                avpw.bp(paramQQAppInterface, getClass().getSimpleName());
                if (GuardManager.a != null) {
                  GuardManager.a.y(0, null);
                }
              }
              if (!paramBoolean2) {
                break;
              }
              d(paramQQAppInterface, paramString5, paramString6, false);
              return;
              paramString2 = QQNotificationManager.getInstance();
              if (paramString2 != null) {
                paramString2.notify("MsgNotification.showQZoneMsgNotification", i, paramString1);
              }
            }
            label1557:
            i = 241;
          }
        }
      }
      continue;
      label1565:
      paramInt1 = 1;
      i = 241;
    }
  }
  
  /* Error */
  public void y(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 32	android/content/Intent
    //   3: dup
    //   4: invokespecial 82	android/content/Intent:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc 127
    //   13: invokestatic 90	cooperation/qzone/QzonePluginProxyActivity:x	(Landroid/content/Intent;Ljava/lang/String;)V
    //   16: aload 7
    //   18: ldc 129
    //   20: invokevirtual 133	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   23: pop
    //   24: aload 7
    //   26: ldc 135
    //   28: ldc 137
    //   30: invokevirtual 36	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   33: pop
    //   34: aload 7
    //   36: ldc 139
    //   38: aload 4
    //   40: invokevirtual 36	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   43: pop
    //   44: new 32	android/content/Intent
    //   47: dup
    //   48: aload_1
    //   49: ldc 73
    //   51: invokespecial 76	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   54: astore 4
    //   56: aload 4
    //   58: ldc 77
    //   60: invokevirtual 54	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   63: pop
    //   64: aload 4
    //   66: aload 7
    //   68: invokevirtual 80	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   71: pop
    //   72: aload 4
    //   74: ldc_w 338
    //   77: sipush 245
    //   80: invokevirtual 106	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   83: pop
    //   84: aload_1
    //   85: sipush 245
    //   88: aload 4
    //   90: ldc_w 339
    //   93: invokestatic 652	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   96: astore 9
    //   98: aload_1
    //   99: invokevirtual 655	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   102: ldc_w 352
    //   105: invokestatic 358	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   108: astore 4
    //   110: aload 4
    //   112: astore 7
    //   114: aload 4
    //   116: ifnull +75 -> 191
    //   119: aload 4
    //   121: astore 7
    //   123: getstatic 364	android/os/Build$VERSION:SDK_INT	I
    //   126: bipush 11
    //   128: if_icmplt +63 -> 191
    //   131: aload_1
    //   132: invokevirtual 655	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   135: ldc_w 365
    //   138: invokevirtual 371	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   141: istore 5
    //   143: aload_1
    //   144: invokevirtual 655	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   147: ldc_w 372
    //   150: invokevirtual 371	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   153: istore 6
    //   155: iload 5
    //   157: aload 4
    //   159: invokevirtual 377	android/graphics/Bitmap:getWidth	()I
    //   162: if_icmpne +17 -> 179
    //   165: aload 4
    //   167: astore 7
    //   169: iload 6
    //   171: aload 4
    //   173: invokevirtual 380	android/graphics/Bitmap:getHeight	()I
    //   176: if_icmpeq +15 -> 191
    //   179: aload 4
    //   181: iload 5
    //   183: iload 6
    //   185: iconst_0
    //   186: invokestatic 384	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   189: astore 7
    //   191: getstatic 404	aqoq:cVi	Z
    //   194: ifne +175 -> 369
    //   197: invokestatic 409	avyu:a	()Lavyu;
    //   200: aload 9
    //   202: aload_1
    //   203: aload 7
    //   205: aload_2
    //   206: aload_3
    //   207: ldc_w 385
    //   210: invokevirtual 412	avyu:a	(Landroid/app/PendingIntent;Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)Landroid/app/Notification;
    //   213: astore_2
    //   214: aload_1
    //   215: iconst_0
    //   216: aload_2
    //   217: invokestatic 444	auqw:setMIUI6Badge	(Landroid/content/Context;ILandroid/app/Notification;)V
    //   220: invokestatic 642	com/tencent/commonsdk/util/notification/QQNotificationManager:getInstance	()Lcom/tencent/commonsdk/util/notification/QQNotificationManager;
    //   223: astore_1
    //   224: aload_1
    //   225: ifnull +14 -> 239
    //   228: aload_1
    //   229: ldc_w 644
    //   232: sipush 245
    //   235: aload_2
    //   236: invokevirtual 648	com/tencent/commonsdk/util/notification/QQNotificationManager:notify	(Ljava/lang/String;ILandroid/app/Notification;)V
    //   239: return
    //   240: astore 4
    //   242: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +33 -> 278
    //   248: ldc 118
    //   250: iconst_2
    //   251: new 191	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 584
    //   261: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 4
    //   266: invokevirtual 585	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   269: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 587	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aconst_null
    //   279: astore 4
    //   281: goto -171 -> 110
    //   284: astore 8
    //   286: aload_1
    //   287: invokevirtual 655	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   290: ldc_w 588
    //   293: invokestatic 358	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   296: astore 7
    //   298: aload 7
    //   300: astore 4
    //   302: ldc 118
    //   304: iconst_1
    //   305: ldc_w 590
    //   308: aload 8
    //   310: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   313: aload 4
    //   315: astore 7
    //   317: goto -126 -> 191
    //   320: astore 8
    //   322: aload 4
    //   324: astore 7
    //   326: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq -138 -> 191
    //   332: ldc 118
    //   334: iconst_2
    //   335: new 191	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   342: ldc_w 584
    //   345: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 8
    //   350: invokevirtual 585	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   353: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 587	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload 4
    //   364: astore 7
    //   366: goto -175 -> 191
    //   369: ldc_w 597
    //   372: invokestatic 602	aqgz:getManufacturer	()Ljava/lang/String;
    //   375: invokevirtual 605	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   378: ifeq +23 -> 401
    //   381: invokestatic 409	avyu:a	()Lavyu;
    //   384: aload 9
    //   386: aload_1
    //   387: aload 7
    //   389: aload_2
    //   390: aload_3
    //   391: ldc_w 385
    //   394: invokevirtual 607	avyu:b	(Landroid/app/PendingIntent;Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)Landroid/app/Notification;
    //   397: astore_2
    //   398: goto -184 -> 214
    //   401: invokestatic 409	avyu:a	()Lavyu;
    //   404: aload 9
    //   406: aload_1
    //   407: aload 7
    //   409: aload_2
    //   410: aload_3
    //   411: ldc_w 385
    //   414: invokevirtual 610	avyu:c	(Landroid/app/PendingIntent;Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;I)Landroid/app/Notification;
    //   417: astore_2
    //   418: goto -204 -> 214
    //   421: astore_1
    //   422: ldc 118
    //   424: iconst_1
    //   425: ldc_w 614
    //   428: aload_1
    //   429: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   432: return
    //   433: astore 8
    //   435: goto -113 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	avyt
    //   0	438	1	paramContext	android.content.Context
    //   0	438	2	paramString1	String
    //   0	438	3	paramString2	String
    //   0	438	4	paramString3	String
    //   141	41	5	i	int
    //   153	31	6	j	int
    //   7	401	7	localObject	Object
    //   284	25	8	localThrowable	Throwable
    //   320	29	8	localOutOfMemoryError1	OutOfMemoryError
    //   433	1	8	localOutOfMemoryError2	OutOfMemoryError
    //   96	309	9	localPendingIntent	PendingIntent
    // Exception table:
    //   from	to	target	type
    //   98	110	240	java/lang/OutOfMemoryError
    //   123	165	284	java/lang/Throwable
    //   169	179	284	java/lang/Throwable
    //   179	191	284	java/lang/Throwable
    //   302	313	320	java/lang/OutOfMemoryError
    //   220	224	421	java/lang/Exception
    //   228	239	421	java/lang/Exception
    //   286	298	433	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyt
 * JD-Core Version:    0.7.0.1
 */