package com.tencent.mobileqq.app;

import SecurityAccountServer.RespondQueryQQBindingStat;
import acdt;
import acff;
import acfp;
import acle;
import acms;
import acnt;
import acnu;
import acnv;
import acnw;
import acnx;
import acxw;
import afem;
import affh;
import aifl;
import aizb;
import aizf;
import aizy;
import ajdo;
import aldj;
import alkm;
import alkq;
import anaz;
import anbi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Window;
import anot;
import anre;
import aolm.b;
import aqgv;
import aqha;
import aqjl;
import aqju;
import aqlr;
import aqmf;
import aqmj;
import aqpr;
import aqwu;
import com.tencent.av.VideoConstants;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.h;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jjc;
import jjk;
import jjy;
import jkm;
import jkw;
import jlc;
import jll;
import jlo;
import mqq.os.MqqHandler;
import tog;
import top;
import ujt;
import wja;
import wkj;

public class VideoBroadcastReceiver
  extends BroadcastReceiver
{
  public static String TAG = "VideoBroadCastReceiver";
  static VideoBroadcastReceiver a;
  boolean auZ = false;
  aolm.b jdField_b_of_type_Aolm$b = new acnx(this);
  MqqHandler jdField_b_of_type_MqqOsMqqHandler = null;
  private WeakReference<QQAppInterface> gj;
  
  VideoBroadcastReceiver(QQAppInterface paramQQAppInterface)
  {
    this.gj = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_MqqOsMqqHandler = new a(Looper.getMainLooper(), this);
  }
  
  private void b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.gj.get();
    if (localQQAppInterface == null) {
      return;
    }
    alkm localalkm = (alkm)localQQAppInterface.getManager(38);
    if (localalkm != null)
    {
      if ((paramInt1 != 3) && (paramInt1 != 4)) {
        break label136;
      }
      localalkm.c(paramInt2, paramString1, paramString2, paramString3, 8);
    }
    for (;;)
    {
      try
      {
        paramString2 = anbi.d(-4008);
        paramString2.selfuin = localQQAppInterface.getCurrentAccountUin();
        paramString2.frienduin = paramString1;
        paramString2.senderuin = paramString3;
        paramString2.msgtype = -4008;
        paramString2.isread = true;
        paramString2.issend = 1;
        paramString2.istroop = paramInt2;
        paramString2.time = anaz.gQ();
        localQQAppInterface.a(1, true, true, paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        return;
      }
      label136:
      localalkm.c(paramInt2, paramString1, paramString2, paramString3, 2);
    }
  }
  
  public static void cNd()
  {
    try
    {
      if ((a != null) && (a.auZ))
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)a.gj.get();
        if (localQQAppInterface != null) {
          localQQAppInterface.getApp().unregisterReceiver(a);
        }
        a.auZ = false;
        a.gj = null;
        a = null;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void cy(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 129	com/tencent/mobileqq/app/VideoBroadcastReceiver:a	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   6: ifnonnull +14 -> 20
    //   9: new 2	com/tencent/mobileqq/app/VideoBroadcastReceiver
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 142	com/tencent/mobileqq/app/VideoBroadcastReceiver:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   17: putstatic 129	com/tencent/mobileqq/app/VideoBroadcastReceiver:a	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   20: ldc 2
    //   22: monitorexit
    //   23: new 144	android/content/IntentFilter
    //   26: dup
    //   27: invokespecial 145	android/content/IntentFilter:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc 147
    //   34: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   37: aload_1
    //   38: ldc 153
    //   40: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: ldc 155
    //   46: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   49: aload_1
    //   50: ldc 157
    //   52: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   55: aload_1
    //   56: ldc 159
    //   58: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: ldc 161
    //   64: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   67: aload_1
    //   68: ldc 163
    //   70: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: ldc 165
    //   76: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   79: aload_1
    //   80: ldc 167
    //   82: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   85: aload_1
    //   86: ldc 169
    //   88: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: ldc 171
    //   94: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   97: aload_1
    //   98: ldc 173
    //   100: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   103: aload_1
    //   104: ldc 175
    //   106: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: ldc 177
    //   112: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   115: aload_1
    //   116: ldc 179
    //   118: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   121: aload_1
    //   122: ldc 181
    //   124: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   127: aload_1
    //   128: ldc 183
    //   130: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   133: aload_1
    //   134: ldc 185
    //   136: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   139: aload_1
    //   140: ldc 187
    //   142: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   145: aload_1
    //   146: ldc 189
    //   148: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   151: aload_1
    //   152: ldc 191
    //   154: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   157: aload_1
    //   158: ldc 193
    //   160: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   163: aload_1
    //   164: ldc 195
    //   166: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   169: aload_1
    //   170: ldc 197
    //   172: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   175: aload_1
    //   176: ldc 199
    //   178: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   181: aload_1
    //   182: ldc 201
    //   184: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   187: aload_1
    //   188: ldc 203
    //   190: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   193: aload_1
    //   194: ldc 205
    //   196: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   199: aload_1
    //   200: ldc 207
    //   202: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   205: aload_1
    //   206: ldc 209
    //   208: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   211: aload_1
    //   212: ldc 211
    //   214: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   217: aload_1
    //   218: ldc 213
    //   220: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   223: aload_1
    //   224: ldc 215
    //   226: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   229: aload_1
    //   230: ldc 217
    //   232: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   235: aload_1
    //   236: ldc 219
    //   238: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   241: aload_1
    //   242: ldc 221
    //   244: invokevirtual 151	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   247: aload_0
    //   248: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   251: getstatic 129	com/tencent/mobileqq/app/VideoBroadcastReceiver:a	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   254: aload_1
    //   255: ldc 223
    //   257: aconst_null
    //   258: invokevirtual 227	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   261: pop
    //   262: getstatic 129	com/tencent/mobileqq/app/VideoBroadcastReceiver:a	Lcom/tencent/mobileqq/app/VideoBroadcastReceiver;
    //   265: iconst_1
    //   266: putfield 31	com/tencent/mobileqq/app/VideoBroadcastReceiver:auZ	Z
    //   269: return
    //   270: astore_0
    //   271: ldc 2
    //   273: monitorexit
    //   274: aload_0
    //   275: athrow
    //   276: astore_0
    //   277: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq -11 -> 269
    //   283: getstatic 24	com/tencent/mobileqq/app/VideoBroadcastReceiver:TAG	Ljava/lang/String;
    //   286: iconst_2
    //   287: new 235	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   294: ldc 238
    //   296: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_0
    //   300: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramQQAppInterface	QQAppInterface
    //   30	225	1	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   3	20	270	finally
    //   20	23	270	finally
    //   271	274	270	finally
    //   247	269	276	java/lang/Exception
  }
  
  void A(Context paramContext, Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("sessionType", 0);
    int i = paramIntent.getIntExtra("uinType", 0);
    int m = paramIntent.getIntExtra("bindType", 0);
    String str1 = paramIntent.getStringExtra("bindId");
    Object localObject = paramIntent.getStringExtra("peerUin");
    String str2 = paramIntent.getStringExtra("extraUin");
    boolean bool2 = paramIntent.getBooleanExtra("isReceiver", false);
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool6 = paramIntent.getBooleanExtra("updateTime", false);
    boolean bool3 = paramIntent.getBooleanExtra("showTime", false);
    int n = paramIntent.getIntExtra("relationType", 0);
    long l = paramIntent.getLongExtra("relationId", 0L);
    boolean bool4 = paramIntent.getBooleanExtra("isNearbyVideoChat", false);
    boolean bool5 = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    if (bool5)
    {
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = String.valueOf(l);
      }
      if (j == 3)
      {
        i = 1;
        int k = 0;
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "onStartVideoChat, double meeting. peer[" + paramContext + "], sessionType[" + i + "]");
        }
        j = i;
        bool1 = true;
        i = k;
      }
    }
    for (;;)
    {
      if (AudioHelper.aCz()) {
        AudioHelper.b("onStartVideoChat[VideoConstants.ACTION_START_VIDEO_CHAT]", paramIntent.getExtras(), true);
      }
      if (i == -1) {}
      label295:
      do
      {
        do
        {
          return;
          i = j;
          if (j != 4) {
            break;
          }
          i = 2;
          break;
          if (!bool1) {
            break label482;
          }
        } while (((paramContext == null) || (paramContext.length() <= 2)) && ((str2 == null) || (str2.length() <= 2)));
        paramIntent = (QQAppInterface)this.gj.get();
      } while (paramIntent == null);
      if (bool2) {
        paramIntent.a().iv(bool2);
      }
      if (bool6)
      {
        paramIntent.a().iy(true);
        paramIntent.a().iw(true);
        label345:
        if (!bool1) {
          break label524;
        }
        paramIntent.a().f(6, paramContext, j);
        paramIntent.a().b(i, paramContext, str2, bool2);
        localObject = paramIntent.a();
        j = jll.cL(i);
        if (bool3) {
          break label518;
        }
        bool1 = true;
        label395:
        ((AVNotifyCenter)localObject).b(j, paramContext, bool1, bool2);
        if (!bool5) {
          break label594;
        }
        paramIntent.a().Y(paramContext, true);
      }
      label518:
      label524:
      label594:
      for (;;)
      {
        paramIntent.a().iz(bool4);
        paramIntent.a().c(28, i, paramContext, str2);
        if ((i == 1) || (i == 9500) || (i == 1011)) {
          break;
        }
        a(paramIntent, str2, i, paramContext, m, bool3, str1, bool2, bool4);
        return;
        label482:
        if (l >= 100L) {
          break label295;
        }
        return;
        if ((!bool3) || (paramIntent.a().un())) {
          break label345;
        }
        paramIntent.a().iw(true);
        break label345;
        bool1 = false;
        break label395;
        paramIntent.a().a(n, Long.valueOf(l), true);
        paramIntent.a().a(6, n, l, j);
        paramContext = paramIntent.a();
        if (!bool3) {}
        for (bool1 = true;; bool1 = false)
        {
          paramContext.a(n, l, bool1, bool2);
          paramContext = String.valueOf(l);
          break;
        }
      }
      paramContext = (Context)localObject;
    }
  }
  
  void B(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("bindType", 0);
    String str2 = paramIntent.getStringExtra("bindId");
    Object localObject = paramIntent.getStringExtra("peerUin");
    String str1 = paramIntent.getStringExtra("extraUin");
    int k = paramIntent.getIntExtra("stopReason", 0);
    String str3 = paramIntent.getStringExtra("senderUin");
    String str4 = paramIntent.getStringExtra("selfUin");
    boolean bool1 = paramIntent.getBooleanExtra("isDouble", true);
    boolean bool2 = paramIntent.getBooleanExtra("isSystemCalling", false);
    int m = paramIntent.getIntExtra("relationType", 0);
    long l2 = paramIntent.getLongExtra("relationId", 0L);
    long l3 = paramIntent.getLongExtra(VideoConstants.Md, 0L);
    long l4 = paramIntent.getLongExtra(VideoConstants.Me, 0L);
    int n = paramIntent.getIntExtra(VideoConstants.Mf, 0);
    long l5 = paramIntent.getLongExtra(VideoConstants.Mi, 0L);
    long l6 = paramIntent.getLongExtra(VideoConstants.Mj, 0L);
    long l7 = paramIntent.getLongExtra("score_connect_duration", 0L);
    paramIntent.getIntExtra("sessionType", 0);
    long l1;
    if (paramIntent.getBooleanExtra("isDoubleVideoMeeting", false))
    {
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = String.valueOf(l2);
      }
      l1 = l2;
      if (l2 == 0L) {
        l1 = jjc.A(paramContext);
      }
      bool1 = true;
    }
    for (;;)
    {
      if (AudioHelper.aCz()) {
        AudioHelper.b("onVideoChatEnd[VideoConstants.ACTION_STOP_VIDEO_CHAT]", paramIntent.getExtras(), true);
      }
      if (i == 26) {
        paramContext = str1;
      }
      for (;;)
      {
        localObject = (QQAppInterface)this.gj.get();
        if (localObject == null) {
          return;
        }
        ((QQAppInterface)localObject).a().iv(false);
        if ((k == 4) || (k == 6) || (k == 1)) {
          if (bool1)
          {
            ((QQAppInterface)localObject).a().b(i, paramContext, str1, false);
            ((QQAppInterface)localObject).a().f(8, paramContext, 0);
          }
        }
        label648:
        for (;;)
        {
          ((QQAppInterface)localObject).a().c(28, i, paramContext, str1);
          if ((i == 1) || (i == 1011) || (i == 9500)) {
            break;
          }
          a((QQAppInterface)localObject, paramIntent, k, bool2, str4, str3, str1, i, paramContext, j, str2, l7, l3, l4, n, l5, l6);
          return;
          ((QQAppInterface)localObject).a().a(m, Long.valueOf(l1), false);
          ((QQAppInterface)localObject).a().a(8, m, l1, 0);
          continue;
          if ((k == 0) && ((((QQAppInterface)localObject).a().getSessionType() == 3) || (((QQAppInterface)localObject).a().getSessionType() == 4)))
          {
            ((QQAppInterface)localObject).a().b(i, paramContext, str1, false);
            ((QQAppInterface)localObject).a().f(8, paramContext, 0);
          }
          else
          {
            if (bool1) {
              if ((str4 != null) && (((QQAppInterface)localObject).getCurrentAccountUin() != null) && (str4.equals(((QQAppInterface)localObject).getCurrentAccountUin())))
              {
                ((QQAppInterface)localObject).a().b(i, paramContext, str1, false);
                ((QQAppInterface)localObject).a().f(8, paramContext, 0);
                ((QQAppInterface)localObject).a().iw(false);
              }
            }
            for (;;)
            {
              if (k != 7) {
                break label648;
              }
              String str5 = paramIntent.getStringExtra("actId");
              String str6 = paramIntent.getStringExtra("mp_ext_params");
              if (str5 == null) {
                break;
              }
              VideoMsgTools.a((QQAppInterface)localObject, "https://iyouxi3.vip.qq.com/ams3.0.php?", str5, str6, this.jdField_b_of_type_Aolm$b);
              break;
              ((QQAppInterface)localObject).a().a(m, Long.valueOf(l1), false);
              ((QQAppInterface)localObject).a().a(8, m, l1, 0);
              ((QQAppInterface)localObject).a().iw(false);
            }
          }
        }
      }
      paramContext = (Context)localObject;
      l1 = l2;
    }
  }
  
  void C(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sessionType", 0);
    int j = paramIntent.getIntExtra("uinType", 0);
    long l = paramIntent.getLongExtra("roomId", 0L);
    String str = paramIntent.getStringExtra("peerUin");
    boolean bool = paramIntent.getBooleanExtra("isReceiver", false);
    QLog.d(TAG, 1, "onAnotherTerminal ACTION_VIDEO_ANOTHER_CHATING uinType: " + j + ", peerUin: " + str + ", roomId: " + l + ", isReceiver: " + bool + ",sessionType:" + i);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.gj.get();
    if (localQQAppInterface == null)
    {
      QLog.d(TAG, 1, "onAnotherTerminal app is null");
      return;
    }
    paramContext = (acff)localQQAppInterface.getManager(51);
    if ((paramContext != null) && (!paramContext.isFriend(str)) && (i != 0))
    {
      QLog.d(TAG, 1, "onAnotherTerminal other terminal chating with not friend ,ignore");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "other terminal chating with: " + str + " , sessionType: " + i + " ,uintype: " + j);
    }
    alkm localalkm = (alkm)localQQAppInterface.getManager(38);
    if (i == 0)
    {
      paramIntent = localQQAppInterface.a().aj(l);
      QLog.i(TAG, 1, "onAnotherTerminal roomId reset peerUin=" + paramIntent);
      localQQAppInterface.a().jk(paramIntent);
      paramContext = paramIntent;
      if (localalkm != null)
      {
        paramContext = paramIntent;
        if (!TextUtils.isEmpty(paramIntent))
        {
          paramContext = paramIntent;
          if (j != 1)
          {
            paramContext = paramIntent;
            if (localalkm.ac(paramIntent, j) == 7)
            {
              localalkm.az(paramIntent, j, 0);
              paramContext = paramIntent;
            }
          }
        }
      }
      localQQAppInterface.a().c(28, j, paramContext, "");
      return;
    }
    localQQAppInterface.a().d(str, l, i);
    paramIntent = localQQAppInterface.a();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.a();
    }
    if ((paramContext != null) && (paramContext.b(str, 0) == null) && (!bool)) {
      if (i != 2) {
        break label504;
      }
    }
    label504:
    for (bool = true;; bool = false)
    {
      VideoMsgTools.a(localQQAppInterface, j, 53, bool, str, localQQAppInterface.getCurrentUin(), true, null, true, new Object[0]);
      paramContext = str;
      if (j == 1) {
        break;
      }
      paramContext = str;
      if (localalkm == null) {
        break;
      }
      paramContext = str;
      if (localalkm.ac(str, j) == 6) {
        break;
      }
      localalkm.az(str, j, 7);
      paramContext = str;
      break;
    }
  }
  
  void D(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    String str1 = paramIntent.getStringExtra("friendUin");
    Object localObject = paramIntent.getStringExtra("friendName");
    String str2 = paramIntent.getStringExtra("extraUin");
    String str3 = paramIntent.getStringExtra("replyMsg");
    boolean bool = paramIntent.getBooleanExtra("isDiyMsg", false);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ACTION_MSG_REPLY uinType: " + i + ", friendUin: " + str1 + ", friendNick: " + (String)localObject + ", extraUin: " + str2 + ", replyMsg: " + str3 + ", isDiyMsg: " + bool);
    }
    if (bool)
    {
      paramIntent = wja.a(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
      paramIntent.putExtra("uintype", i);
      paramIntent.putExtra("uinname", (String)localObject);
      localObject = (QQAppInterface)this.gj.get();
      if (localObject == null) {
        return;
      }
      if (i == 1006)
      {
        paramIntent.putExtra("uin", str2);
        paramContext = paramIntent;
        if (!aqlr.isScreenLocked(((QQAppInterface)localObject).getApp())) {
          break label393;
        }
        paramContext.putExtra("ext_panel_onresume", 2);
      }
      for (;;)
      {
        paramContext.putExtra("enter_ext_panel", 1);
        ((QQAppInterface)localObject).getApp().startActivity(paramContext);
        return;
        if (i == 1000)
        {
          paramIntent.putExtra("uin", str1);
          paramContext = ((TroopManager)((QQAppInterface)localObject).getManager(52)).b(str2);
          paramIntent.putExtra("troop_uin", paramContext.troopcode);
          paramIntent.putExtra("troop_code", paramContext.troopuin);
          paramContext = paramIntent;
          break;
        }
        if (i == 1004)
        {
          paramIntent.putExtra("uin", str1);
          paramIntent.putExtra("troop_uin", str2);
          paramContext = paramIntent;
          break;
        }
        if (i == 1044)
        {
          paramContext = aizy.d(paramContext, str1, 21);
          break;
        }
        paramIntent.putExtra("uin", str1);
        paramContext = paramIntent;
        break;
        label393:
        paramContext.putExtra("ext_panel_onresume", 1);
      }
    }
    paramIntent = new Message();
    paramIntent.what = 0;
    paramIntent.obj = new Object[] { Integer.valueOf(i), localObject, str2, str1, paramContext, str3 };
    this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 300L);
  }
  
  void E(Context paramContext, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("isPtt", false);
    int i = paramIntent.getIntExtra("uinType", 0);
    String str1 = paramIntent.getStringExtra("friendUin");
    Object localObject = paramIntent.getStringExtra("friendName");
    String str2 = paramIntent.getStringExtra("extraUin");
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ACTION_MSG_LEAVE uinType: " + i + ", friendUin: " + str1 + ", friendNick: " + (String)localObject + ", extraUin: " + str2 + ", isPtt: " + bool);
    }
    paramIntent = wja.a(new Intent(paramContext, SplashActivity.class), new int[] { 2 });
    paramIntent.putExtra("uintype", i);
    paramIntent.putExtra("uinname", (String)localObject);
    localObject = (QQAppInterface)this.gj.get();
    if (localObject == null) {
      return;
    }
    if (i == 1006)
    {
      paramIntent.putExtra("uin", str2);
      paramContext = paramIntent;
      label201:
      if (!aqlr.isScreenLocked(((QQAppInterface)localObject).getApp())) {
        break label473;
      }
      paramContext.putExtra("ext_panel_onresume", 2);
      label221:
      if (!bool) {
        break label485;
      }
      paramContext.putExtra("enter_ext_panel", 2);
    }
    for (;;)
    {
      paramIntent = new Message();
      paramIntent.what = 4;
      paramIntent.obj = new Object[] { paramContext };
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 300L);
      return;
      if (i == 1000)
      {
        paramIntent.putExtra("uin", str1);
        paramContext = ((TroopManager)((QQAppInterface)localObject).getManager(52)).b(str2);
        if (paramContext == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e(TAG, 2, "findTroopInfo fail ,uin : " + str2);
          return;
        }
        paramIntent.putExtra("troop_uin", paramContext.troopuin);
        paramIntent.putExtra("troop_code", paramContext.troopcode);
        paramContext = paramIntent;
        break label201;
      }
      if (i == 1004)
      {
        paramIntent.putExtra("uin", str1);
        paramIntent.putExtra("troop_uin", str2);
        paramContext = paramIntent;
        break label201;
      }
      if (i == 1044)
      {
        paramContext = aizy.d(paramContext, str1, 21);
        anot.a(null, "dc00898", "", "", "0X800AD97", "0X800AD97", 0, 0, "", "", "", "");
        break label201;
      }
      paramIntent.putExtra("uin", str1);
      paramContext = paramIntent;
      break label201;
      label473:
      paramContext.putExtra("ext_panel_onresume", 1);
      break label221;
      label485:
      paramContext.putExtra("enter_ext_panel", 1);
    }
  }
  
  void F(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("size", 0L);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ACTION_VIDEO_FLOW_SIZE: " + l);
    }
    paramContext = (QQAppInterface)this.gj.get();
    if (paramContext == null) {
      return;
    }
    paramContext.sendAppDataIncerment(paramContext.getAccount(), new String[] { "param_XGVideoFlow", "param_XGFlow", "param_Flow" }, l);
  }
  
  void G(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", 0);
    paramContext = paramIntent.getStringExtra("peerUin");
    String str = paramIntent.getStringExtra("extraUin");
    paramIntent = paramIntent.getByteArrayExtra("sig");
    QQAppInterface localQQAppInterface = (QQAppInterface)this.gj.get();
    if (localQQAppInterface == null) {
      return;
    }
    VideoMsgTools.a(localQQAppInterface, i, paramContext, str, paramIntent);
  }
  
  void H(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("peerUin");
    int k = paramIntent.getIntExtra("sessionType", 0);
    int m = paramIntent.getIntExtra("relationType", 0);
    long l2 = paramIntent.getLongExtra("relationId", 0L);
    boolean bool = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    int j = k;
    int i;
    if (bool) {
      if (k == 3)
      {
        i = 1;
        j = i;
        if (!TextUtils.isEmpty(paramContext)) {
          break label270;
        }
        paramContext = String.valueOf(l2);
      }
    }
    for (;;)
    {
      long l1 = l2;
      if (m == 0)
      {
        l1 = l2;
        if (l2 == 0L) {
          l1 = jjc.A(paramContext);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "VideoConstants.ACTION_START_VIDEO_AVSWITCH relationType[" + m + "], relationId[" + l1 + "], sessionType[" + i + "], peerUin[" + paramContext + "], isDoubleVideoMeeting[" + bool + "]");
      }
      paramIntent = (QQAppInterface)this.gj.get();
      if (paramIntent == null) {}
      for (;;)
      {
        return;
        i = k;
        if (k != 4) {
          break;
        }
        i = 2;
        break;
        if ((bool) || (m == 0)) {
          paramIntent.a().f(5, paramContext, i);
        }
        while (bool)
        {
          paramIntent.a().Y(paramContext, true);
          return;
          paramIntent.a().a(5, m, l1, i);
        }
      }
      label270:
      i = j;
    }
  }
  
  void I(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "VideoConstants.ACTION_CALLING_DIALOG");
    }
    boolean bool1 = paramIntent.getBooleanExtra("isAudio", false);
    String str1 = paramIntent.getStringExtra("friendUin");
    int j = paramIntent.getIntExtra("uinType", 0);
    int k = paramIntent.getIntExtra("type", 0);
    String str2 = paramIntent.getStringExtra("senderUin");
    boolean bool2 = paramIntent.getBooleanExtra("isSender", false);
    paramIntent = (QQAppInterface)this.gj.get();
    if (paramIntent == null) {
      return;
    }
    Object localObject1 = paramIntent.getApp().getString(2131697640);
    Object localObject2 = aqgv.A(paramIntent, str1);
    if (((String)localObject2).length() > 10) {
      new StringBuilder().append(((String)localObject2).substring(0, 4)).append("...").toString();
    }
    localObject2 = paramIntent.getApp();
    int i;
    if (bool1)
    {
      i = 2131697637;
      localObject2 = ((BaseApplication)localObject2).getString(i);
      localObject1 = aqha.a(paramIntent.getApp().getApplicationContext(), 230, (String)localObject1, (String)localObject2, 2131721058, 2131697810, new acnt(this, paramIntent, j, k, bool1, str1, str2, bool2), null);
      if (Build.VERSION.SDK_INT < 26) {
        break label353;
      }
      if (Settings.canDrawOverlays(paramContext)) {
        ((aqju)localObject1).getWindow().setType(2038);
      }
      label243:
      if (Build.VERSION.SDK_INT < 23) {
        break label409;
      }
      if (!Settings.canDrawOverlays(paramContext)) {
        break label396;
      }
      ((aqju)localObject1).show();
    }
    for (;;)
    {
      jjk.O(paramIntent.isBackground_Pause, bool1);
      paramContext = new Message();
      paramContext.what = 1;
      paramContext.obj = new Object[] { localObject1, Integer.valueOf(j), Boolean.valueOf(bool1), str1, str2, Boolean.valueOf(bool2) };
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed(paramContext, 10000L);
      return;
      i = 2131697641;
      break;
      label353:
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (!Settings.canDrawOverlays(paramContext)) {
          break label243;
        }
        ((aqju)localObject1).getWindow().setType(2003);
        break label243;
      }
      ((aqju)localObject1).getWindow().setType(2003);
      break label243;
      label396:
      QLog.d(TAG, 1, "can not DrawOverlays !!");
      continue;
      label409:
      ((aqju)localObject1).show();
    }
  }
  
  void J(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "VideoConstants.ACTION_CALLING_DIALOG_MULTI");
    }
    String str1 = String.valueOf(paramIntent.getLongExtra("friendUin", 0L));
    String str2 = String.valueOf(paramIntent.getLongExtra("relationId", 0L));
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("type", 0);
    String str3 = paramIntent.getStringExtra("realSenderUin");
    String str4 = paramIntent.getStringExtra("peerUin");
    QQAppInterface localQQAppInterface = (QQAppInterface)this.gj.get();
    if (localQQAppInterface == null) {
      return;
    }
    String str5 = localQQAppInterface.getApp().getString(2131697640);
    if (i == 3000)
    {
      paramIntent = aqgv.m(localQQAppInterface, str2, str1);
      paramIntent = String.format(localQQAppInterface.getApp().getString(2131697639), new Object[] { paramIntent });
      jjk.S(false, true);
      if (!GesturePWDUtils.isAppOnForegroundByTasks(localQQAppInterface.getApp().getApplicationContext())) {
        break label327;
      }
      paramContext = PopupDialog.b(localQQAppInterface.getApp().getApplicationContext(), 230, str5, paramIntent, 2131721058, 2131721079, new acnu(this, i, localQQAppInterface, j, str2, str1, str4, str3), null);
    }
    for (;;)
    {
      jjk.kY(localQQAppInterface.isBackground_Pause);
      paramIntent = new Message();
      paramIntent.what = 2;
      paramIntent.obj = new Object[] { paramContext, Integer.valueOf(i), Integer.valueOf(j), str2, str1, str4, str3 };
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 10000L);
      return;
      if (i == 1)
      {
        paramIntent = aqgv.n(localQQAppInterface, str1, str2);
        break;
      }
      paramIntent = aqgv.A(localQQAppInterface, str1);
      break;
      label327:
      paramIntent = aqha.a(localQQAppInterface.getApp().getApplicationContext(), 230, str5, paramIntent, 2131721058, 2131721079, new acnv(this, i, localQQAppInterface, j, str2, str1, str4, str3), null);
      if (Build.VERSION.SDK_INT >= 26) {
        paramIntent.getWindow().setType(2038);
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (Settings.canDrawOverlays(paramContext))
          {
            paramIntent.show();
            paramContext = paramIntent;
            break;
            paramIntent.getWindow().setType(2003);
            continue;
          }
          QLog.d(TAG, 1, "can not DrawOverlays oncallingDialogMulti()!!");
          paramContext = paramIntent;
          break;
        }
      }
      paramIntent.show();
      paramContext = paramIntent;
    }
  }
  
  void K(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("status", 0);
    int j = paramIntent.getIntExtra("type", 0);
    long l = paramIntent.getLongExtra("guild_group_id", -1L);
    int k = paramIntent.getIntExtra("guild_member_num", -1);
    paramContext = paramIntent.getStringExtra("sessionName");
    String str1 = paramIntent.getStringExtra("guild_business_type");
    String str2 = paramIntent.getStringExtra("uin");
    String str3 = paramIntent.getStringExtra("nickName");
    paramIntent = paramIntent.getStringExtra("headUrl");
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ACTION_RANDOM_SET_CHAT_STATUS status:" + i + ", type" + j);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.gj.get();
    if (localQQAppInterface == null) {
      return;
    }
    if (i == 0)
    {
      localQQAppInterface.a().ji(null);
      localQQAppInterface.a().cj(-1L);
      localQQAppInterface.a().lf(-1);
      localQQAppInterface.a().jj(null);
    }
    for (;;)
    {
      localQQAppInterface.a().bC(i, j);
      return;
      if (!TextUtils.isEmpty(paramContext)) {
        localQQAppInterface.a().ji(paramContext);
      }
      if (!TextUtils.isEmpty(str2)) {
        localQQAppInterface.a().C(str2, str3, paramIntent);
      }
      localQQAppInterface.a().cj(l);
      localQQAppInterface.a().lf(k);
      localQQAppInterface.a().jj(str1);
    }
  }
  
  void L(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("uin");
    String str = paramIntent.getStringExtra("nickName");
    paramIntent = paramIntent.getStringExtra("headUrl");
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ACTION_RANDOM_UPDATE_CHAT_INFO uin:" + paramContext + ", nickName: " + str + ", headUrl: " + paramIntent);
    }
    QQAppInterface localQQAppInterface;
    if (!TextUtils.isEmpty(paramContext))
    {
      localQQAppInterface = (QQAppInterface)this.gj.get();
      if (localQQAppInterface != null) {}
    }
    else
    {
      return;
    }
    localQQAppInterface.a().C(paramContext, str, paramIntent);
  }
  
  void M(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w(TAG, 2, "EarlyDownload trigger AV so EarlyDownload");
    }
    paramContext = (QQAppInterface)this.gj.get();
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        paramContext = (afem)paramContext.getManager(77);
      } while (paramContext == null);
      paramContext = (affh)paramContext.a("qq.android.qav.muteaudio");
    } while (paramContext == null);
    paramContext.HL(false);
  }
  
  void N(Context paramContext, Intent paramIntent)
  {
    paramContext = (QQAppInterface)this.gj.get();
    if (paramContext == null) {
      return;
    }
    paramIntent = paramContext.getApp().getString(2131697899);
    String str = paramContext.getApp().getString(2131697879);
    paramContext = aqha.a(paramContext.getApp().getApplicationContext(), 230, str, paramIntent, 2131721058, 2131697810, new acnw(this), null);
    paramContext.getWindow().setType(2003);
    paramContext.show();
    paramIntent = new Message();
    paramIntent.what = 3;
    paramIntent.obj = new Object[] { paramContext };
    this.jdField_b_of_type_MqqOsMqqHandler.sendMessageDelayed(paramIntent, 5000L);
  }
  
  void a(long paramLong, Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("type", 20);
    boolean bool = paramIntent.getBooleanExtra("isStart", false);
    int j = paramIntent.getIntExtra("MultiAVType", 0);
    if ((AudioHelper.aCz()) || (i == 22) || (i == 23) || (i == 25)) {
      AudioHelper.I(TAG + ".onMultiMsgV2Q", paramIntent.getExtras());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.gj.get();
    if (localQQAppInterface == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            long l;
            do
            {
              do
              {
                do
                {
                  int k;
                  do
                  {
                    return;
                    if (QLog.isDevelopLevel()) {
                      QLog.i(TAG, 4, "onMultiMsgV2Q, type[" + i + "]");
                    }
                    if (i == 22)
                    {
                      a(localQQAppInterface, paramContext, paramIntent, i, bool, j);
                      return;
                    }
                    if (i == 23)
                    {
                      b(localQQAppInterface, paramContext, paramIntent, i, bool, j);
                      return;
                    }
                    if (i != 32) {
                      break;
                    }
                    paramLong = paramIntent.getLongExtra("relationId", -1L);
                    k = paramIntent.getIntExtra("uinType", -1);
                  } while (k != 1);
                  l = paramIntent.getIntExtra("closeType", 1);
                  localQQAppInterface.a().a(i, k, paramLong, l, j);
                  return;
                  if (i != 33) {
                    break;
                  }
                  paramLong = paramIntent.getLongExtra("relationId", -1L);
                  j = paramIntent.getIntExtra("uinType", -1);
                  l = paramIntent.getLongExtra("info", -1L);
                  paramContext = paramIntent.getStringExtra("strMsg");
                } while (j != 1);
                localQQAppInterface.a().a(i, j, paramLong, l, paramContext);
                return;
                if (i == 25)
                {
                  b(localQQAppInterface, paramContext, paramIntent, j);
                  return;
                }
                if (i != 401) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(TAG, 2, "TYPE_DOUBLE_MEETING_MEMBER_JOIN");
                }
                i = paramIntent.getIntExtra("relationType", 0);
                paramLong = paramIntent.getLongExtra("relationId", 0L);
                l = paramIntent.getLongExtra("friendUin", 0L);
                if (QLog.isColorLevel()) {
                  QLog.d("AVShare", 2, "TYPE_DOUBLE_MEETING_MEMBER_JOIN, relationType[" + i + "], relationId[" + paramLong + "], friendUin[" + l + "]");
                }
                if (l == paramLong) {
                  localQQAppInterface.a().a(0, Long.valueOf(paramLong), true);
                }
                localQQAppInterface.a().Y(String.valueOf(paramLong), true);
              } while (l != paramLong);
              localQQAppInterface.a().iy(true);
              localQQAppInterface.a().iw(true);
              return;
              if (i != 402) {
                break;
              }
              i = paramIntent.getIntExtra("relationType", 0);
              paramLong = paramIntent.getLongExtra("relationId", 0L);
              l = paramIntent.getLongExtra("friendUin", 0L);
              if (QLog.isColorLevel()) {
                QLog.d("AVShare", 2, "TYPE_DOUBLE_MEETING_MEMBER_LEAVE, relationType[" + i + "], relationId[" + paramLong + "], friendUin[" + l + "]");
              }
              localQQAppInterface.a().Y(String.valueOf(paramLong), false);
              localQQAppInterface.a().iw(false);
              paramContext = (alkm)localQQAppInterface.getManager(38);
            } while (paramContext == null);
            paramContext.az("" + l, 0, 0);
            return;
            if (i == 403)
            {
              i = paramIntent.getIntExtra("relationType", 3);
              paramLong = paramIntent.getLongExtra("relationId", 0L);
              l = paramIntent.getLongExtra("friendUin", 0L);
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "TYPE_DOUBLE_MEETING_INVITE_DESTORY-->RelationType = " + i + " ,relationId = " + paramLong + " ,friendUin = " + l);
              }
              paramContext = (alkm)localQQAppInterface.getManager(38);
              if (paramContext != null) {
                paramContext.az("" + l, 0, 0);
              }
              localQQAppInterface.a().Y(String.valueOf(l), false);
              localQQAppInterface.a().iw(false);
              return;
            }
          } while (i != 411);
          paramContext = (ArrayList)paramIntent.getExtras().getSerializable("phoneList");
          if (paramContext != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(TAG, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> no data");
        return;
        paramLong = paramIntent.getLongExtra("relationId", -1L);
        paramContext = jkm.h(paramContext);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "TYPE_GAUDIO_OTHER_ADD_PSTN_MEMBERS --> JsonObject = " + paramContext);
        }
        paramIntent = (alkm)localQQAppInterface.getManager(38);
      } while (paramIntent == null);
      paramIntent.d(0, paramLong, "", paramContext);
      paramContext = (acdt)localQQAppInterface.getBusinessHandler(6);
    } while ((paramContext == null) || (paramContext.a() == null));
    paramContext.a().FU(String.valueOf(paramLong));
  }
  
  void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = paramIntent.getIntExtra("relationType", 0);
    long l1 = paramIntent.getLongExtra("relationId", 0L);
    long l2 = paramIntent.getLongExtra("friendUin", 0L);
    int j = paramIntent.getIntExtra("roomUserNum", 0);
    paramQQAppInterface.a().a(9, i, l1, 3);
    if (l2 == Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue())
    {
      paramQQAppInterface.a().a(i, Long.valueOf(l1), true);
      paramQQAppInterface.a().a(9, i, l1, 3);
      paramQQAppInterface.a().s(i, l1);
      paramQQAppInterface.a().k(12, l1, paramInt2);
      if (j == 1)
      {
        paramQQAppInterface.a().a(i, l1, true, false);
        paramContext = paramQQAppInterface.a().a();
        if (paramContext != null)
        {
          paramIntent = String.valueOf(l1);
          paramInt2 = jll.cM(i);
          if ((paramInt2 != -1) && (paramInt2 != 1011) && (!TextUtils.isEmpty(paramIntent)))
          {
            if (paramInt2 != 1) {
              break label444;
            }
            TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
            if ((localTroopManager != null) && (localTroopManager.b(paramIntent) != null))
            {
              paramIntent = paramContext.a(paramIntent, paramInt2);
              if (paramIntent != null)
              {
                paramIntent.lastmsgtime = anaz.gQ();
                paramContext.e(paramIntent);
              }
            }
          }
        }
        label243:
        if ((i != 1) && (i != 7) && (i != 9) && (i != 10))
        {
          paramContext = (alkm)paramQQAppInterface.getManager(38);
          if (paramContext != null) {
            paramContext.a(l1, l2, true, -1L, paramBoolean);
          }
        }
        if ((paramQQAppInterface.a().bG() == l1) && (paramQQAppInterface.a().lh() >= 4) && (paramQQAppInterface.a().uo()))
        {
          paramQQAppInterface.a().iw(true);
          paramQQAppInterface.a().iy(true);
        }
      }
    }
    for (;;)
    {
      paramQQAppInterface.a().b(paramInt1, i, l1, l2);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "member join discussId: " + l1 + ", friendUin: " + l2 + ", roomUserNum:" + j);
      }
      return;
      paramQQAppInterface.a().a(i, l1, false, false);
      paramQQAppInterface.a().iw(true);
      break;
      label444:
      paramIntent = paramContext.a(paramIntent, paramInt2);
      if (paramIntent == null) {
        break label243;
      }
      paramIntent.lastmsgtime = anaz.gQ();
      paramContext.e(paramIntent);
      break label243;
      if ((paramQQAppInterface.a().bG() == l1) && (paramQQAppInterface.a().uo()))
      {
        paramQQAppInterface.a().a(i, l1, false, false);
        paramQQAppInterface.a().iw(true);
        paramQQAppInterface.a().iy(true);
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt1, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, long paramLong1, long paramLong2, long paramLong3, int paramInt4, long paramLong4, long paramLong5)
  {
    if ((paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 == 8)) {
      if (paramBoolean)
      {
        break label32;
        break label32;
      }
    }
    label386:
    label1030:
    label1038:
    for (;;)
    {
      label32:
      return;
      if (paramInt2 != 1008)
      {
        if (paramInt2 == 0)
        {
          paramBoolean = false;
          if (!TextUtils.isEmpty(paramString1)) {
            paramBoolean = paramString1.equals(paramString2);
          }
          VideoMsgTools.a(paramQQAppInterface, paramInt2, 1, true, paramString4, paramString2, paramBoolean, null, true, new Object[0]);
          return;
        }
        b(paramInt1, paramInt2, paramString3, paramString4, paramString2);
        return;
        if ((paramInt1 != 0) && (paramInt1 != 1) && (paramInt1 != 2)) {
          break;
        }
        if ((!TextUtils.isEmpty(paramString3)) && (paramInt2 == 1006) && ((paramString4 == null) || (paramString4.indexOf("+") < 0))) {}
        for (paramString2 = paramString3;; paramString2 = paramString4)
        {
          if ((paramString1 != null) && (paramQQAppInterface.getCurrentAccountUin() != null) && (!paramString1.equals(paramQQAppInterface.getCurrentAccountUin()))) {
            break label1038;
          }
          paramString3 = (alkm)paramQQAppInterface.getManager(38);
          if ((paramQQAppInterface.a().cz(paramString2)) || (paramString3 == null)) {
            break;
          }
          if ((paramInt3 == 2) || (paramInt3 == 3) || (paramInt2 == 25)) {
            paramString3.a(paramString2, 8, paramInt2, paramInt3, paramString5, 0);
          }
          boolean bool1;
          do
          {
            paramString1 = paramIntent.getStringExtra("actId");
            paramIntent = paramIntent.getStringExtra("mp_ext_params");
            if (paramString1 == null) {
              break;
            }
            VideoMsgTools.a(paramQQAppInterface, "https://iyouxi3.vip.qq.com/ams3.0.php?", paramString1, paramIntent, this.jdField_b_of_type_Aolm$b);
            return;
            paramString3.az(paramString2, paramInt2, 0);
            paramString3 = aqmj.i(paramQQAppInterface.getCurrentAccountUin());
            paramInt1 = paramString3.getInt("qav_score_switch", 0);
            paramInt3 = paramString3.getInt("qav_score_rate", 5);
            int i = paramString3.getInt("qav_score_time", 0);
            if ((paramString1 == null) || (paramInt1 != 1) || (paramInt3 == 0) || (paramLong1 < i) || (!jjy.cK("qav_score_good.jpg")) || (!jjy.cK("qav_score_normal.jpg")) || (!jjy.cK("qav_score_bad.jpg"))) {
              break label1005;
            }
            paramBoolean = true;
            bool1 = false;
            if (AudioHelper.jY(17) == 1)
            {
              AudioHelper.UA(acfp.m(2131716366));
              bool1 = true;
            }
            if (QLog.isColorLevel()) {
              QLog.w(TAG, 1, "onVideoChatEnd, scoreSwitch[" + paramInt1 + "], scoreRate[" + paramInt3 + "], scoreTime[" + i + "], duration[" + paramLong1 + "], show1[" + paramBoolean + "], forceShow[" + bool1 + "]");
            }
          } while (((!bool1) && (!paramBoolean)) || (paramString1 == null));
          paramInt1 = paramString3.getInt(VideoConstants.Mc, 0) + 1;
          boolean bool2 = paramString3.getBoolean(VideoConstants.Ml, false);
          long l = 0L;
          paramLong1 = l;
          if (paramInt1 == 1)
          {
            paramLong1 = l;
            if (!bool2)
            {
              l = paramString3.getLong("qav_score_msg_uniseq", 0L);
              paramLong1 = l;
              if (l != 0L)
              {
                paramQQAppInterface.b().t(paramString2, paramInt2, l);
                paramLong1 = l;
              }
            }
          }
          if (paramInt3 == 0)
          {
            paramBoolean = false;
            label616:
            if (QLog.isColorLevel()) {
              QLog.w(TAG, 1, "onVideoChatEnd, scoreCount[" + paramInt1 + "], hasCommit[" + bool2 + "], uniseq[" + paramLong1 + "], show2[" + paramBoolean + "]");
            }
            if ((!bool1) && (!paramBoolean)) {
              break label1030;
            }
            jkw.kN("{\n" + VideoConstants.Md + ":" + paramLong2 + ",\n" + VideoConstants.Me + ":" + paramLong3 + ",\n" + VideoConstants.Mf + ":" + paramInt4 + ",\n" + VideoConstants.Mi + ":" + paramLong4 + ",\n" + VideoConstants.Mj + ":" + paramLong5 + ",\n" + VideoConstants.Mk + ":" + paramString2 + "\n}");
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "addTipsVideoMsg beginTime: " + paramLong2 + ", endTime: " + paramLong3 + ", sdkVersion: " + paramInt4 + ", bussinessType: " + paramLong4 + ", bussinessFlag: " + paramLong5 + ",toUin: " + paramString2);
            }
            VideoMsgTools.a(paramQQAppInterface, paramInt2, 61, true, paramString2, null);
            paramInt1 = 0;
            paramString3.edit().putBoolean(VideoConstants.Ml, false).commit();
          }
          for (;;)
          {
            paramString3.edit().putInt(VideoConstants.Mc, paramInt1).commit();
            break;
            label1005:
            paramBoolean = false;
            break label386;
            if (paramInt1 % paramInt3 == 0)
            {
              paramBoolean = true;
              break label616;
            }
            paramBoolean = false;
            break label616;
          }
        }
      }
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramInt1 == 1006) && ((paramString2 == null) || (paramString2.indexOf("+") < 0))) {}
    for (;;)
    {
      paramString2 = (alkm)paramQQAppInterface.getManager(38);
      try
      {
        paramString2.a().b(paramString1, paramInt1).isSystemCall = 0;
        label55:
        if (paramString2 != null)
        {
          if ((paramInt2 != 2) && (paramInt2 != 3) && (paramInt1 != 25)) {
            break label154;
          }
          if (!paramBoolean1) {
            break label137;
          }
          paramString2.a(paramString1, 8, paramInt1, paramInt2, paramString3, 6);
        }
        for (;;)
        {
          if (paramInt1 != 1008) {}
          try
          {
            if ((!top.x(paramString1, paramInt1)) && (top.fL(paramInt1)))
            {
              paramBoolean1 = paramQQAppInterface.a().u(paramString1, paramInt1);
              if (paramBoolean1) {}
            }
            label137:
            label154:
            do
            {
              do
              {
                do
                {
                  return;
                  paramString2.a(paramString1, 8, paramInt1, paramInt2, paramString3, 5);
                  break;
                  if (paramBoolean1)
                  {
                    paramString2.az(paramString1, paramInt1, 6);
                    break;
                  }
                  if (paramBoolean2) {
                    break;
                  }
                  paramString2.az(paramString1, paramInt1, 5);
                  break;
                } while ((paramInt2 == 2) || (paramInt2 == 3) || (paramInt1 == 25) || (paramBoolean3));
                paramQQAppInterface = paramQQAppInterface.a().a();
              } while ((paramQQAppInterface == null) || (paramQQAppInterface.b(paramString1, paramInt1) != null) || (TextUtils.isEmpty(paramString1)) || (paramString1.length() <= 2));
              paramString1 = paramQQAppInterface.a(paramString1, paramInt1);
            } while (paramString1 == null);
            paramString1.lastmsgtime = anaz.gQ();
            paramQQAppInterface.e(paramString1);
            return;
          }
          catch (Exception paramQQAppInterface)
          {
            return;
          }
        }
      }
      catch (Exception localException)
      {
        break label55;
      }
      paramString1 = paramString2;
    }
  }
  
  void b(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    long l = paramIntent.getLongExtra("relationId", -1L);
    int m = paramIntent.getIntExtra("relationType", -1);
    int i = paramIntent.getIntExtra("reason", -1);
    boolean bool2 = paramIntent.getBooleanExtra("openClass", false);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "TYPE_GAUDIO_ROOM_DESTROY-->relationid=" + l + " relationType=" + m + " reason=" + i + " avtype" + paramInt);
    }
    if (i == 4) {
      paramQQAppInterface.a().a(32, 1, l, i, paramInt);
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (m == 1)
      {
        bool1 = bool2;
        if (paramInt == 2)
        {
          paramContext = paramQQAppInterface.a().a(l, paramInt);
          bool1 = bool2;
          if (paramContext != null)
          {
            bool1 = bool2;
            if (paramContext.ang == 2)
            {
              bool1 = bool2;
              if (paramContext.gameId == 4) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    paramContext = paramQQAppInterface.a();
    int j;
    label229:
    int k;
    if (bool1)
    {
      i = 2;
      if (!bool1) {
        break label335;
      }
      j = 4;
      if (!bool1) {
        break label341;
      }
      k = 0;
      label237:
      paramContext.a(9, l, paramInt, i, j, k, 25, 0);
      if (paramQQAppInterface.a().d(m, l) <= 0L) {
        break label347;
      }
      paramQQAppInterface.a().a(13, m, l, null, 0L);
      VideoMsgTools.a(paramQQAppInterface, m, 14, false, String.valueOf(l), paramQQAppInterface.getCurrentAccountUin(), false, null, false, paramInt, new Object[0]);
      paramQQAppInterface.a().b(21, m, l, 0L);
    }
    label335:
    label341:
    label347:
    while (!QLog.isColorLevel())
    {
      return;
      i = 0;
      break;
      j = 0;
      break label229;
      k = -1;
      break label237;
    }
    QLog.w(TAG, 2, "MultiRoomMemberNum is 0");
  }
  
  void b(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = paramIntent.getIntExtra("relationType", 0);
    long l1 = paramIntent.getLongExtra("relationId", 0L);
    long l2 = paramIntent.getLongExtra("friendUin", 0L);
    int j = paramIntent.getIntExtra("roomUserNum", 0);
    if (l2 == Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue())
    {
      long l3 = paramIntent.getLongExtra("time", 0L);
      paramQQAppInterface.a().a(9, i, l1, 0);
      paramQQAppInterface.a().a(i, Long.valueOf(l1), false);
      paramQQAppInterface.a().j(i, l1, paramInt2);
      paramQQAppInterface.a().a(9, i, l1, 0);
      paramQQAppInterface.a().iw(false);
      if (i != 1)
      {
        paramContext = (alkm)paramQQAppInterface.getManager(38);
        if (paramContext != null) {
          paramContext.a(l1, l2, false, l3, paramBoolean);
        }
      }
      aqjl.a(paramQQAppInterface, paramIntent, i, l1);
    }
    if (j == 1) {
      paramQQAppInterface.a().a(i, l1, true, false);
    }
    paramQQAppInterface.a().b(paramInt1, i, l1, l2);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "member quit discussId: " + l1 + ", friendUin: " + l2);
    }
  }
  
  void b(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(16711696));
      }
    }
  }
  
  void c(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "VideoConstants.ACTION_GAUDIO_TROOP_CARD");
    }
    String str2 = paramIntent.getStringExtra("troopUin");
    String str1 = paramIntent.getStringExtra("memberUin");
    if (paramIntent.getIntExtra("uinType", -1) == 3000)
    {
      if (str1.equals(paramQQAppInterface.getCurrentAccountUin()))
      {
        paramQQAppInterface = new ProfileActivity.AllInOne(str1, 0);
        paramQQAppInterface.bIZ = 5;
        ProfileActivity.b(paramContext, paramQQAppInterface);
        return;
      }
      if (((acff)paramQQAppInterface.getManager(51)).isFriend(str1))
      {
        paramIntent = new ProfileActivity.AllInOne(str1, 1);
        paramIntent.nickname = aqgv.d(paramQQAppInterface, str1, 0);
        paramIntent.bIZ = 5;
        ProfileActivity.b(paramContext, paramIntent);
        return;
      }
      paramIntent = new ProfileActivity.AllInOne(str1, 46);
      paramIntent.nickname = aqgv.d(paramQQAppInterface, str1, 0);
      paramIntent.aOF = str1;
      paramIntent.bIX = 3000;
      paramIntent.discussUin = str2;
      paramIntent.bIZ = 5;
      ProfileActivity.b(paramContext, paramIntent);
      return;
    }
    aldj.a(paramQQAppInterface, paramQQAppInterface.getApp(), str2, str1, 0, -1);
  }
  
  void d(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("peerUin");
    long l = paramIntent.getLongExtra("roomId", 0L);
    if ((l != 0L) && (paramContext != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "<qav printer> message send: cmd[0x211, 0xb]");
      }
      paramQQAppInterface = (jlo)paramQQAppInterface.getBusinessHandler(39);
      paramQQAppInterface.mPeerUin = paramContext;
      paramQQAppInterface.qh = l;
      paramQQAppInterface.axN();
    }
  }
  
  void e(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("relationId");
    long l = paramIntent.getLongExtra("friendUin", 0L);
    if (l == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO, inviterUin:" + l);
      }
    }
    do
    {
      return;
      String str = paramIntent.getStringExtra("inviteId");
      int i = paramIntent.getIntExtra("dealResult", 1);
      ((acms)paramQQAppInterface.getBusinessHandler(20)).b(paramContext, l, str, i);
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.fd(paramContext, l + "");
  }
  
  boolean i(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    try
    {
      long l = Long.parseLong(paramString);
      AVNotifyCenter.h localh = paramQQAppInterface.a().a(l, 2);
      if ((localh != null) && (localh.memberNum > 0) && (paramInt == 13)) {
        return false;
      }
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.b(paramString);
          if (paramQQAppInterface == null) {
            return false;
          }
        }
      }
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      return false;
    }
    return true;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    long l = jlc.a(paramIntent);
    QLog.w(TAG, 1, "onReceive, action[" + str1 + "], seq[" + l + "]");
    if (this.gj == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          localObject = (QQAppInterface)this.gj.get();
                        } while (localObject == null);
                        if ((TextUtils.isEmpty(paramIntent.getPackage())) || (!paramIntent.getPackage().equals(((QQAppInterface)localObject).getApp().getPackageName())))
                        {
                          QLog.d(TAG, 1, "onReceive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + str1);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.AddVideoMsg"))
                        {
                          y(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.VideoFlowSize"))
                        {
                          F(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.av.v2q.MultiVideo"))
                        {
                          a(l, paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.av.v2q.StartDoubleVideoMeeting"))
                        {
                          z(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.av.v2q.StartVideoChat"))
                        {
                          A(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.av.v2q.StopVideoChat"))
                        {
                          B(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.av.v2q.AvSwitch"))
                        {
                          H(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.av.v2q.AnotherTerChating"))
                        {
                          C(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.AddMsgSig"))
                        {
                          G(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.CallingDialog"))
                        {
                          I(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.CallingDialogMulti"))
                        {
                          J(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.setChatStatus"))
                        {
                          K(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.updateChatInfo"))
                        {
                          L(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.av.v2q.CheckChatAbility"))
                        {
                          N(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.downloadGAudioSound"))
                        {
                          M(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.AddContactsToDiscuss"))
                        {
                          VideoMsgTools.c((QQAppInterface)localObject, paramIntent.getStringExtra("discussUin"));
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.MeetingMemberManager"))
                        {
                          VideoMsgTools.b((QQAppInterface)localObject, paramIntent.getStringExtra("discussUin"));
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.AddContactsFromC2C"))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "addMemberFromC2C");
                          }
                          VideoMsgTools.d((QQAppInterface)localObject, paramIntent.getStringExtra("peerUin"), paramIntent.getIntExtra("supportUinType", 3000));
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.replyMsg"))
                        {
                          D(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.leaveMsg"))
                        {
                          E(paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.AudioEngineReady"))
                        {
                          d((QQAppInterface)localObject, paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.GaudioOpenTroopCard"))
                        {
                          c((QQAppInterface)localObject, paramContext, paramIntent);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.BindContact"))
                        {
                          paramContext = new Intent(paramContext, BindNumberActivity.class);
                          paramContext.putExtra("kNeedUnbind", true);
                          paramContext.addFlags(268435456);
                          ((QQAppInterface)localObject).getApp().startActivity(paramContext);
                          return;
                        }
                        if (str1.equals("tencent.video.v2q.OpenContactList"))
                        {
                          paramContext = new Intent(paramContext, PhoneFrameActivity.class);
                          paramContext.putExtra("key_req_type", 0);
                          paramContext.addFlags(268435456);
                          ((QQAppInterface)localObject).getApp().startActivity(paramContext);
                          return;
                        }
                        if (!str1.equals("tencent.video.v2q.AnnimateDownloadStart")) {
                          break;
                        }
                        i = paramIntent.getIntExtra("callId", 0);
                      } while ((i <= 0) || (!aqwu.aFN()));
                      paramContext = (aqwu)((QQAppInterface)localObject).getManager(84);
                    } while (paramContext == null);
                    paramContext.c(i, aqwu.getResourceType(), false, 0);
                    return;
                    if (!str1.equals("tencent.video.v2q.commingRingDownload")) {
                      break;
                    }
                    i = paramIntent.getIntExtra("comming_ring_down_key", 0);
                  } while ((i <= 0) || (!aqwu.aFN()));
                  ((aqpr)((QQAppInterface)localObject).getManager(45)).a(i, 3, false, 0, "comering");
                  int j = ((acle)((QQAppInterface)localObject).getBusinessHandler(13)).AX();
                  anot.a(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, 0, "" + j, i + "", "", "");
                  return;
                  if (str1.equals("chatbgBroadcast"))
                  {
                    str1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                    i = paramIntent.getIntExtra("uinType", 0);
                    String str2 = paramIntent.getStringExtra("friendUin");
                    j = paramIntent.getIntExtra("effectId", 0);
                    ThemeBackground.setThemeBackgroundPic(paramContext, "theme_bg_aio_path", ((QQAppInterface)localObject).getAccount(), str1, "", "", "", 0, null, false);
                    wkj.a(paramContext, ((QQAppInterface)localObject).getAccount(), str2, str1, j, i);
                    return;
                  }
                  if (!str1.equals("tencent.video.v2q.insertSystemCall")) {
                    break;
                  }
                  localObject = ((QQAppInterface)localObject).a();
                } while (localObject == null);
                paramIntent = paramIntent.getStringExtra("phoneNumber");
                paramContext = paramIntent;
                if (paramIntent != null)
                {
                  paramContext = paramIntent;
                  if (!paramIntent.startsWith("+")) {
                    paramContext = "+86" + paramIntent;
                  }
                }
                ((alkm)localObject).Oq(paramContext);
                return;
                if (str1.equals("tencent.video.v2q.upgradeInvite"))
                {
                  VideoMsgTools.e((QQAppInterface)localObject, paramIntent.getStringExtra("peerUin"), paramIntent.getIntExtra("type", 0));
                  return;
                }
                if (!str1.equals("tencent.video.v2q.SmallScreenState")) {
                  break;
                }
                int i = paramIntent.getIntExtra("SmallScreenState", 0);
                paramContext = paramIntent.getStringExtra("uin");
                if (AudioHelper.aCz()) {
                  QLog.w(TAG, 1, "ACTION_SMALL_SCREEN_STATE, smallScreenState[" + i + "], peerUin[" + paramContext + "], seq[" + l + "]");
                }
                ((QQAppInterface)localObject).a().y(l, i);
              } while (TextUtils.isEmpty(paramContext));
              ((QQAppInterface)localObject).a().jl(paramContext);
              return;
              if (!str1.equals("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO")) {
                break;
              }
              paramContext = new HashMap();
              paramContext.put("MultiAVType", String.valueOf(2));
              paramContext.put("enterType", paramIntent.getIntExtra("enterType", 0) + "");
            } while (BaseActivity.sTopActivity == null);
            ChatActivityUtils.a((QQAppInterface)localObject, BaseActivity.sTopActivity, 1, paramIntent.getStringExtra("relationId"), true, true, null, paramContext);
            return;
            if (str1.equals("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO"))
            {
              e((QQAppInterface)localObject, paramContext, paramIntent);
              return;
            }
            if (!str1.equals("tencent.video.v2q.ACTION_GROUP_VEDIO_INVITE_END")) {
              break;
            }
            paramContext = (TroopManager)((QQAppInterface)localObject).getManager(52);
          } while (paramContext == null);
          paramContext.fd(paramIntent.getStringExtra("relationId"), paramIntent.getStringExtra("inviterUin"));
          return;
          if (!str1.equals("tencent.video.v2q.generalFuncCall")) {
            break;
          }
        } while (!"SEND_STRUCT_MSG".equals(paramIntent.getStringExtra("func")));
        paramContext = anre.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      } while (paramContext == null);
      aqmf.a((QQAppInterface)localObject, paramIntent.getStringExtra("uin"), paramIntent.getIntExtra("uintype", -1), paramContext, null);
      return;
      if (str1.equals("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED"))
      {
        ((aifl)((QQAppInterface)localObject).getManager(306)).dsl();
        return;
      }
    } while (!str1.equals("tencent.video.v2q.AddMembersToGroup"));
    VideoMsgTools.a((QQAppInterface)localObject, paramContext, paramIntent);
  }
  
  void y(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ACTION_ADD_VIDEO_MSG");
    }
    int i = paramIntent.getIntExtra("uinType", 0);
    int j = paramIntent.getIntExtra("msgType", 5);
    int k = paramIntent.getIntExtra("msgDetail", 0);
    paramIntent.getIntExtra("bindType", 0);
    paramIntent.getStringExtra("bindId");
    boolean bool5 = paramIntent.getBooleanExtra("isVideoMsg", true);
    String str1 = paramIntent.getStringExtra("friendUin");
    String str2 = paramIntent.getStringExtra("senderUin");
    String str3 = paramIntent.getStringExtra("selfUin");
    boolean bool6 = paramIntent.getBooleanExtra("isSender", true);
    boolean bool7 = paramIntent.getBooleanExtra("isRead", false);
    paramContext = paramIntent.getStringExtra("extra");
    boolean bool3 = false;
    boolean bool4 = false;
    int m = paramIntent.getIntExtra("MultiAVType", 0);
    paramIntent.getLongExtra("relationId", 0L);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ACTION_ADD_VIDEO_MSG selfUin = " + str3);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.gj.get();
    if (localQQAppInterface == null) {
      break label203;
    }
    label203:
    label341:
    label629:
    label630:
    for (;;)
    {
      return;
      if ((j != 0) || (str3 == null) || (localQQAppInterface.getCurrentAccountUin() == null) || (str3.equals(localQQAppInterface.getCurrentAccountUin())))
      {
        boolean bool2;
        boolean bool1;
        if (((j == 2) || (j == 24)) && (paramContext == null))
        {
          bool2 = bool4;
          bool1 = bool3;
          if (aqlr.isScreenLocked(localQQAppInterface.getApp()))
          {
            bool1 = SettingCloneUtil.readValue(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), localQQAppInterface.getApp().getString(2131695500), "qqsetting_lock_screen_whenexit_key", true);
            bool2 = SettingCloneUtil.readValue(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin(), localQQAppInterface.getApp().getString(2131718988), "qqsetting_notify_showcontent_key", true);
            b(localQQAppInterface, bool1, bool2);
          }
          if (j != 17) {
            break label629;
          }
          paramContext = String.valueOf(k);
        }
        for (;;)
        {
          if ((m == 2) && (str1 != null) && (!i(localQQAppInterface, str1, j))) {
            break label630;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addVideoMsgWithAvtype");
          }
          VideoMsgTools.a(localQQAppInterface, i, j, bool5, str1, str2, bool6, paramContext, bool7, m, new Object[0]);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addVideoMsgWithAvtype end");
          }
          if ((!bool1) || (!bool2)) {
            break;
          }
          paramContext = (aizf)localQQAppInterface.getManager(72);
          paramContext.a(localQQAppInterface, str1, i, true, aizb.a(str1, i, paramIntent), true);
          paramContext.a(localQQAppInterface, str1, i, true, aizb.a(str1, i, paramIntent));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  videoMsgReceiver");
          return;
          if ((j != 17) && (j != 15))
          {
            bool2 = bool4;
            bool1 = bool3;
            if (j != 16) {
              break label341;
            }
          }
          if (i != 3000)
          {
            bool2 = bool4;
            bool1 = bool3;
            if (i != 1) {
              break label341;
            }
          }
          bool2 = bool4;
          bool1 = bool3;
          if (str1 == null) {
            break label341;
          }
          localQQAppInterface.a().a(12, jll.cL(i), Long.valueOf(str1).longValue(), null, 0L);
          localQQAppInterface.a().b(21, jll.cL(i), Long.valueOf(str1).longValue(), 0L);
          bool2 = bool4;
          bool1 = bool3;
          break label341;
        }
      }
    }
  }
  
  void z(Context paramContext, Intent paramIntent)
  {
    paramIntent.getIntExtra("sessionType", 0);
    int i = paramIntent.getIntExtra("uinType", 0);
    paramContext = paramIntent.getStringExtra("peerUin");
    boolean bool1;
    Object localObject;
    for (;;)
    {
      long l;
      boolean bool2;
      try
      {
        l = Long.parseLong(paramContext);
        if (l == 0L)
        {
          QLog.i(TAG, 2, "onStartVideoDoubleMeeting, uin is 0.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        l = 0L;
        continue;
        bool1 = paramIntent.getBooleanExtra("isReceiver", false);
        boolean bool3 = paramIntent.getBooleanExtra("updateTime", false);
        bool2 = paramIntent.getBooleanExtra("showTime", false);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "ACTION_START_DOUBLE_VIDEO_MEETING uinType: " + i + ", peerUin: " + paramContext + ", updateTime: " + bool3 + ", showTime: " + bool2);
        }
        paramIntent = (QQAppInterface)this.gj.get();
        if (paramIntent == null) {
          continue;
        }
        if (bool3)
        {
          paramIntent.a().iy(true);
          paramIntent.a().iw(true);
        }
        paramIntent.a().f(7, paramContext, 2);
        paramIntent.a().b(i, paramContext, null, bool1);
        paramIntent.a().Y(paramContext, true);
        localObject = paramIntent.a();
        if (bool2) {
          break;
        }
      }
      bool1 = true;
      label240:
      ((AVNotifyCenter)localObject).a(0, l, bool1, true);
      if (i == 0)
      {
        localObject = (alkm)paramIntent.getManager(38);
        if (!bool2) {
          break label403;
        }
        ((alkm)localObject).az(paramContext, i, 6);
      }
    }
    for (;;)
    {
      try
      {
        if ((!top.x(paramContext, i)) && (top.fL(i)) && (!paramIntent.a().u(paramContext, i))) {
          break;
        }
        paramIntent = paramIntent.a().a();
        if ((paramIntent == null) || (paramIntent.b(paramContext, i) != null) || (TextUtils.isEmpty(paramContext))) {
          break;
        }
        paramContext = paramIntent.a(paramContext, i);
        if (paramContext == null) {
          break;
        }
        paramContext.lastmsgtime = anaz.gQ();
        paramIntent.e(paramContext);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG, 2, "Recent User Proxy Error-->e=" + paramContext.getMessage());
      return;
      bool1 = false;
      break label240;
      label403:
      ((alkm)localObject).az(paramContext, i, 5);
    }
  }
  
  static class a
    extends MqqHandler
  {
    WeakReference<VideoBroadcastReceiver> bs;
    
    public a(Looper paramLooper, VideoBroadcastReceiver paramVideoBroadcastReceiver)
    {
      super();
      this.bs = new WeakReference(paramVideoBroadcastReceiver);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.bs == null) {}
      QQAppInterface localQQAppInterface;
      do
      {
        Object localObject1;
        Object localObject2;
        int i;
        Object localObject4;
        String str;
        Object localObject3;
        int j;
        do
        {
          boolean bool2;
          boolean bool3;
          do
          {
            do
            {
              do
              {
                return;
                localObject1 = (VideoBroadcastReceiver)this.bs.get();
              } while ((localObject1 == null) || (VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject1) == null));
              localQQAppInterface = (QQAppInterface)VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject1).get();
            } while (localQQAppInterface == null);
            switch (paramMessage.what)
            {
            default: 
              return;
            case 0: 
              localObject2 = (Object[])paramMessage.obj;
              i = ((Integer)localObject2[0]).intValue();
              localObject4 = (String)localObject2[1];
              localObject1 = (String)localObject2[2];
              str = (String)localObject2[3];
              paramMessage = (Context)localObject2[4];
              localObject2 = (String)localObject2[5];
              localObject3 = new SessionInfo();
              ((SessionInfo)localObject3).cZ = i;
              ((SessionInfo)localObject3).aTn = ((String)localObject4);
              if (i == 1006)
              {
                ((SessionInfo)localObject3).aTl = ((String)localObject1);
                localObject1 = ((ajdo)localQQAppInterface.getManager(11)).a();
                if (localObject1 != null) {
                  ((SessionInfo)localObject3).phoneNum = (((RespondQueryQQBindingStat)localObject1).nationCode + ((RespondQueryQQBindingStat)localObject1).mobileNo);
                }
              }
              for (;;)
              {
                ujt.e(localQQAppInterface, paramMessage, (SessionInfo)localObject3, (String)localObject2);
                return;
                if (i == 1000)
                {
                  localObject4 = ((TroopManager)localQQAppInterface.getManager(52)).b((String)localObject1);
                  if (localObject4 == null)
                  {
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.e(VideoBroadcastReceiver.TAG, 2, "findTroopInfo fail ,uin : " + (String)localObject1);
                    return;
                  }
                  ((SessionInfo)localObject3).aTl = str;
                  ((SessionInfo)localObject3).troopUin = ((TroopInfo)localObject4).troopcode;
                  ((SessionInfo)localObject3).aTm = ((TroopInfo)localObject4).troopuin;
                  continue;
                }
                if (i == 1004)
                {
                  ((SessionInfo)localObject3).aTl = str;
                  ((SessionInfo)localObject3).troopUin = ((String)localObject1);
                }
                else
                {
                  ((SessionInfo)localObject3).aTl = str;
                }
              }
            case 1: 
              paramMessage = (Object[])paramMessage.obj;
              localObject1 = (aqju)paramMessage[0];
              i = ((Integer)paramMessage[1]).intValue();
              bool2 = ((Boolean)paramMessage[2]).booleanValue();
              str = (String)paramMessage[3];
              localObject2 = (String)paramMessage[4];
              bool3 = ((Boolean)paramMessage[5]).booleanValue();
            }
          } while (!((aqju)localObject1).isShowing());
          ((aqju)localObject1).dismiss();
          if (!bool2) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            VideoMsgTools.a(localQQAppInterface, i, 10, bool1, str, (String)localObject2, bool3, null, true, new Object[0]);
            jjk.Q(localQQAppInterface.isBackground_Pause, bool2);
            return;
          }
          localObject4 = (Object[])paramMessage.obj;
          paramMessage = (aqju)localObject4[0];
          i = ((Integer)localObject4[1]).intValue();
          j = ((Integer)localObject4[2]).intValue();
          str = (String)localObject4[3];
          localObject2 = (String)localObject4[4];
          localObject3 = (String)localObject4[5];
          localObject4 = (String)localObject4[6];
        } while (!paramMessage.isShowing());
        paramMessage.dismiss();
        if (i == 3000)
        {
          VideoMsgTools.a(localQQAppInterface, i, j, false, str, (String)localObject2, false, null, false, new Object[0]);
          VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject1, 8, i, str, (String)localObject3, (String)localObject4);
        }
        jjk.la(localQQAppInterface.isBackground_Pause);
        return;
        paramMessage = (aqju)((Object[])(Object[])paramMessage.obj)[0];
      } while (!paramMessage.isShowing());
      paramMessage.dismiss();
      return;
      paramMessage = (Intent)((Object[])(Object[])paramMessage.obj)[0];
      localQQAppInterface.getApp().startActivity(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.VideoBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */