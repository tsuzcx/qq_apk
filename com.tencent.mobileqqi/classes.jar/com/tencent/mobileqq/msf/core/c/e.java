package com.tencent.mobileqq.msf.core.c;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.k;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.m;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.h;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.pb.offlinepush.C2CMsgReadedNotify;
import com.tencent.msf.service.protocol.pb.offlinepush.C2CTmpOffMsgHead;
import com.tencent.msf.service.protocol.pb.offlinepush.DisMsgReadedNotify;
import com.tencent.msf.service.protocol.pb.offlinepush.DiscussOffInfo;
import com.tencent.msf.service.protocol.pb.offlinepush.GroupOffInfo;
import com.tencent.msf.service.protocol.pb.offlinepush.PbPushOffMsg;
import com.tencent.msf.service.protocol.pb.offlinepush.PbPushOffReadedNotify;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class e
  extends BroadcastReceiver
{
  public static final String B = "com.tencent.mobileqqi.msf.receiveofflinepush";
  public static final String C = "com.tencent.mobileqqi.msf.offlinepushclearall";
  public static final String D = "com.tencent.mobileqq.msf.devlockquickloginpush";
  public static final String E = "com.tencent.mobileqq.msf.devlockquickloginpushclear";
  public static final String F = "com.tencent.mobileqqi.msf.receiveofflinepushav";
  public static final String G = "com.tencent.mobileqqi.msf.offlinepushclearallav";
  static final int I = 20140416;
  public static final int R = 0;
  public static final int S = 1;
  public static final int T = 2;
  public static final int U = 3;
  public static final int V = -56;
  public static final int W = -55;
  public static final String a = "app_push_info_";
  private static ArrayMap aa;
  private static ArrayMap ab;
  private static ArrayMap ac;
  private static ArrayMap ad;
  private static ArrayMap ae;
  private static final long[] ag = { 100L, 200L, 200L, 100L };
  static final String e = "MSF.C.PushManager";
  static SimpleDateFormat f = new SimpleDateFormat("dd HH:mm:ss");
  public static boolean l = false;
  public static String m = "0";
  public static volatile boolean n = false;
  static final String o = "OnlinePush.ReqPush";
  static final String p = "CliNotifySvc.SvcReqPush";
  static final String q = "StatSvc.QueryHB";
  static int w = 10101;
  static int x = 10102;
  public static int y = 10103;
  ArrayList A = new ArrayList();
  public MediaPlayer H;
  Handler J = new i(this);
  String K = Environment.getExternalStorageDirectory().getAbsolutePath();
  String L = this.K + "/Tencent/MobileQQ/";
  String M = "head/";
  String N = this.L + this.M + "_hd/";
  String O = this.L + this.M + "_thd/";
  String P = this.M + "_hd/";
  String Q = this.L + ".billd_urldrawable/";
  String X = "message.ring.switch";
  String Y = "message.vibrate.switch";
  private PendingIntent Z;
  private long af = 0L;
  MsfCore b;
  String c = "";
  String d = "";
  public ConcurrentHashMap g = new ConcurrentHashMap();
  public c h;
  AlarmManager i;
  b j = new b();
  boolean k = false;
  volatile Object r = new Object();
  int s = 30000;
  long t = 0L;
  final long u = 300000L;
  long v = 0L;
  ArrayList z = new ArrayList();
  
  public e(MsfCore paramMsfCore)
  {
    this.b = paramMsfCore;
    this.h = new c(this);
    this.j.setName("MsfCorePushManager");
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1 = i2;
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg unknow msgtype:" + paramInt1);
      }
      i1 = -1;
    case 9: 
    case 10: 
    case 16: 
    case 17: 
    case 31: 
    case 79: 
    case 97: 
    case 120: 
    case 132: 
    case 133: 
    case 166: 
    case 167: 
    case 208: 
    case 529: 
    case 734: 
      return i1;
    case 42: 
    case 83: 
      return 1;
    case 215: 
    case 519: 
      i1 = i2;
      switch (paramInt2)
      {
      case 1: 
      case 11: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg unknow dwVideoType:" + paramInt2);
        }
        return -1;
      case 2: 
      case 12: 
        return 2;
      }
      return 1;
    case 140: 
    case 141: 
      return 2;
    }
    return 3;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      if (paramBitmap == null) {
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      Object localObject = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect((RectF)localObject, paramFloat, paramFloat, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localObject = new Matrix();
      ((Matrix)localObject).setRectToRect(new RectF(localRect1), new RectF(localRect2), Matrix.ScaleToFit.FILL);
      localCanvas.drawBitmap(Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true), localRect2, localRect2, localPaint);
      return localBitmap;
    }
    catch (Throwable paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    int i1 = (paramInt1 + paramInt2) / 2;
    int i2 = (int)(f1 * 4.0D);
    if (i1 <= 70) {
      i1 = (int)(2.0D * f1);
    }
    for (;;)
    {
      paramInt1 = (int)(paramInt1 * f1);
      paramInt2 = (int)(f1 * paramInt2);
      return a(paramBitmap, i1, paramInt1, paramInt2);
      if (i1 <= 100) {
        i1 = (int)(f1 * 4.0D);
      } else if (i1 <= 128) {
        i1 = (int)(8.0D * f1);
      } else {
        i1 = (int)((paramInt1 / 100 * 4 + 8) * f1);
      }
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", Long.toString(paramLong), "OnlinePush.RespPush");
    Object localObject = BaseApplication.getContext().getPackageName();
    localToServiceMsg.setAppId(((a)this.g.get(localObject)).a);
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.setRequestSsoSeq(paramInt1);
    localToServiceMsg.setNeedCallback(false);
    localObject = new com.tencent.msf.service.protocol.c.b();
    ((com.tencent.msf.service.protocol.c.b)localObject).a = paramLong;
    ((com.tencent.msf.service.protocol.c.b)localObject).c = paramInt2;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("OnlinePush.RespPush");
    localUniPacket.setFuncName("SvcRespPushMsg");
    localUniPacket.setRequestId(paramInt1);
    localUniPacket.put("resp", localObject);
    localToServiceMsg.putWupBuffer(localUniPacket.encode());
    this.b.sender.b(localToServiceMsg);
  }
  
  public static boolean a(Context paramContext, long paramLong)
  {
    
    if (SettingCloneUtil.readValue(paramContext, "" + paramLong, "通知时指示灯闪烁", "qqsetting_notify_blncontrol_key", true))
    {
      boolean bool = SettingCloneUtil.readValue(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg isNoDisturbMode:" + bool);
        }
        int i1 = Calendar.getInstance().get(11);
        if ((i1 < 23) && (i1 >= 8)) {}
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  private boolean a(SharedPreferences paramSharedPreferences)
  {
    try
    {
      if ((this.z != null) && (this.z.size() > 0))
      {
        offlinepush.PbPushOffMsg localPbPushOffMsg = ((a)this.z.get(this.z.size() - 1)).a;
        boolean bool = paramSharedPreferences.contains("special_sound_type" + localPbPushOffMsg.to_uin.get() + localPbPushOffMsg.from_uin.get());
        return bool;
      }
    }
    catch (Exception paramSharedPreferences)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushManager", 2, "isSpecialCareSound...exception=" + paramSharedPreferences.getMessage());
      }
      paramSharedPreferences.printStackTrace();
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return (paramString1.equals(paramString2)) || (paramString1.equals(paramString2 + ":video")) || (paramString1.equals(paramString2 + ":QQ"));
  }
  
  private Object[] b(int paramInt, String paramString)
  {
    if ((paramInt != 3) && (paramInt == 1)) {
      new StringBuilder().append("troop_").append(paramString).toString();
    }
    return new Object[] { Integer.valueOf(paramInt), paramString };
  }
  
  private Object[] b(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    Object localObject5 = null;
    String str;
    int i1;
    if (paramPbPushOffMsg.msg_str.has())
    {
      str = paramPbPushOffMsg.msg_str.get().toStringUtf8();
      i1 = a(paramPbPushOffMsg.msg_type.get(), paramPbPushOffMsg.dwViedoType.get());
    }
    Object localObject1;
    Object localObject4;
    Object localObject3;
    label249:
    long l1;
    switch (i1)
    {
    default: 
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg no msg str exit");
      }
      return null;
    case 0: 
      if ((paramPbPushOffMsg.from_nick.has()) && (paramPbPushOffMsg.from_nick.get().toStringUtf8().length() != 0))
      {
        localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
        if (!paramPbPushOffMsg.from_uin.has()) {
          break label249;
        }
        paramPbPushOffMsg.from_uin.get();
        paramPbPushOffMsg = a(0, "" + paramPbPushOffMsg.from_uin.get());
        localObject4 = null;
        localObject2 = localObject1;
        localObject3 = localObject5;
        localObject1 = localObject4;
      }
    case 1: 
    case 2: 
      for (;;)
      {
        return new Object[] { Integer.valueOf(i1), str, localObject2, paramPbPushOffMsg, localObject1, localObject3 };
        localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
        break;
        localObject3 = null;
        localObject2 = localObject1;
        paramPbPushOffMsg = "";
        localObject1 = localObject3;
        localObject3 = localObject5;
        continue;
        if (paramPbPushOffMsg.discuss_info.has())
        {
          if (paramPbPushOffMsg.discuss_info.discuss_remark.has())
          {
            localObject1 = paramPbPushOffMsg.discuss_info.discuss_remark.get().toStringUtf8();
            label308:
            if (!paramPbPushOffMsg.discuss_info.dis_name.has()) {
              break label463;
            }
          }
          label463:
          for (localObject2 = paramPbPushOffMsg.discuss_info.dis_name.get().toStringUtf8();; localObject2 = Long.toString(paramPbPushOffMsg.discuss_info.discuss_uin.get()))
          {
            if (!paramPbPushOffMsg.discuss_info.discuss_uin.has()) {
              break label498;
            }
            l1 = paramPbPushOffMsg.discuss_info.discuss_uin.get();
            if (localObject2 != null)
            {
              localObject3 = localObject2;
              if (((String)localObject2).length() != 0) {}
            }
            else
            {
              localObject3 = Long.toString(l1);
            }
            paramPbPushOffMsg = a(3, "" + l1);
            localObject2 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject5;
            break;
            if (paramPbPushOffMsg.from_nick.has())
            {
              localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
              break label308;
            }
            localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
            break label308;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get discuss msg, but no msg.discuss_info exit");
        }
        return null;
        label498:
        localObject4 = localObject1;
        paramPbPushOffMsg = "";
        localObject1 = localObject2;
        localObject3 = localObject5;
        localObject2 = localObject4;
        continue;
        if (paramPbPushOffMsg.c2c_tmp_msg_head.has())
        {
          if ((paramPbPushOffMsg.from_nick.has()) && (paramPbPushOffMsg.from_nick.get().toStringUtf8().length() != 0)) {
            localObject1 = paramPbPushOffMsg.from_nick.get().toStringUtf8();
          }
          for (;;)
          {
            if (!paramPbPushOffMsg.c2c_tmp_msg_head.group_uin.has()) {
              break label775;
            }
            l1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_uin.get();
            paramPbPushOffMsg = a(3, "" + l1);
            localObject3 = null;
            localObject2 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject5;
            break;
            if (paramPbPushOffMsg.c2c_tmp_msg_head.discuss_remark.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.discuss_remark.get().toStringUtf8();
            }
            else if (paramPbPushOffMsg.c2c_tmp_msg_head.group_card.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_card.get().toStringUtf8();
            }
            else if (paramPbPushOffMsg.c2c_tmp_msg_head.group_name.has())
            {
              localObject1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_name.get().toStringUtf8();
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get c2c temp msg, no nick find use from_uin");
              }
              localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get c2c temp msg, but no msg.c2c_tmp_msg_head exit");
        }
        return null;
        label775:
        if (paramPbPushOffMsg.c2c_tmp_msg_head.group_code.has())
        {
          l1 = paramPbPushOffMsg.c2c_tmp_msg_head.group_code.get();
          paramPbPushOffMsg = a(3, "" + l1);
          localObject3 = null;
          localObject2 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject5;
        }
        else
        {
          localObject3 = null;
          localObject2 = localObject1;
          paramPbPushOffMsg = "";
          localObject1 = localObject3;
          localObject3 = localObject5;
        }
      }
    }
    if (paramPbPushOffMsg.group_info.has()) {
      if (paramPbPushOffMsg.group_info.group_card.has())
      {
        localObject1 = paramPbPushOffMsg.group_info.group_card.get().toStringUtf8();
        label901:
        if (!paramPbPushOffMsg.group_info.group_name.has()) {
          break label1081;
        }
      }
    }
    label1081:
    for (Object localObject2 = paramPbPushOffMsg.group_info.group_name.get().toStringUtf8();; localObject2 = null)
    {
      if (paramPbPushOffMsg.group_info.group_code.has())
      {
        l1 = paramPbPushOffMsg.group_info.group_code.get();
        if (localObject2 != null)
        {
          paramPbPushOffMsg = (offlinepush.PbPushOffMsg)localObject2;
          if (((String)localObject2).length() != 0) {}
        }
        else
        {
          paramPbPushOffMsg = Long.toString(l1);
        }
        localObject3 = a(1, "" + l1);
        localObject4 = null;
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = paramPbPushOffMsg;
        paramPbPushOffMsg = (offlinepush.PbPushOffMsg)localObject1;
        localObject1 = localObject4;
        break;
        localObject1 = Long.toString(paramPbPushOffMsg.from_uin.get());
        break label901;
      }
      localObject3 = null;
      localObject4 = localObject1;
      paramPbPushOffMsg = "";
      localObject1 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject4;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get troop msg, but no msg.group_info exit");
      }
      return null;
    }
  }
  
  private Object[] b(boolean paramBoolean)
  {
    String str = q();
    Object[] arrayOfObject;
    long l1;
    if ((this.z.size() == 1) && (!paramBoolean))
    {
      arrayOfObject = new Object[4];
      localObject3 = b(((a)this.z.get(0)).a);
      if (localObject3 == null) {
        return null;
      }
      switch (((Integer)localObject3[0]).intValue())
      {
      default: 
        return null;
      case 0: 
      case 2: 
        localObject1 = "[" + (String)aa.get(str) + "]" + localObject3[2] + ":" + localObject3[1];
        localObject2 = localObject3[2] + "[" + (String)aa.get(str) + "]";
        str = (String)localObject3[1];
        arrayOfObject[0] = localObject1;
        arrayOfObject[1] = localObject2;
        arrayOfObject[2] = str;
        arrayOfObject[3] = localObject3[3];
        return arrayOfObject;
      case 1: 
        localObject1 = "[" + (String)aa.get(str) + "]" + localObject3[2] + "(" + localObject3[4] + ")" + ":" + localObject3[1];
        localObject2 = localObject3[4] + "[" + (String)aa.get(str) + "]";
        str = localObject3[2] + ":" + localObject3[1];
        arrayOfObject[0] = localObject1;
        arrayOfObject[1] = localObject2;
        arrayOfObject[2] = str;
        arrayOfObject[3] = localObject3[3];
        return arrayOfObject;
      }
      localObject2 = "";
      localObject1 = localObject2;
      if (((a)this.z.get(0)).a.msg_flag.has())
      {
        l1 = ((a)this.z.get(0)).a.msg_flag.get();
        if ((0x2 & l1) != 2L) {
          break label701;
        }
        localObject1 = "[" + (String)ab.get(str) + "]";
      }
      for (;;)
      {
        localObject2 = "[" + (String)aa.get(str) + "]" + (String)localObject1 + localObject3[2] + ":" + localObject3[1];
        str = localObject3[5] + "[" + (String)aa.get(str) + "]";
        localObject1 = (String)localObject1 + localObject3[2] + ":" + localObject3[1];
        arrayOfObject[0] = localObject2;
        arrayOfObject[1] = str;
        arrayOfObject[2] = localObject1;
        arrayOfObject[3] = localObject3[3];
        return arrayOfObject;
        label701:
        localObject1 = localObject2;
        if ((l1 & 1L) == 1L) {
          localObject1 = "[" + (String)ac.get(str) + "]";
        }
      }
    }
    int i1 = r();
    if ((i1 == 1) && (!paramBoolean))
    {
      arrayOfObject = b(((a)this.z.get(this.z.size() - 1)).a);
      if (arrayOfObject == null) {
        return null;
      }
      localObject3 = new Object[4];
      switch (((Integer)arrayOfObject[0]).intValue())
      {
      }
    }
    for (;;)
    {
      return null;
      localObject1 = "[" + (String)aa.get(str) + "]" + arrayOfObject[2] + ":" + arrayOfObject[1];
      localObject2 = arrayOfObject[2] + "[" + this.z.size() + " " + (String)aa.get(str) + "]";
      str = (String)arrayOfObject[1];
      localObject3[0] = localObject1;
      localObject3[1] = localObject2;
      localObject3[2] = str;
      localObject3[3] = arrayOfObject[3];
      return localObject3;
      int i2 = s();
      if (i2 == 1) {}
      for (i1 = 1; i1 != 0; i1 = 0)
      {
        localObject1 = "[" + (String)aa.get(str) + "]" + arrayOfObject[2] + "(" + arrayOfObject[4] + ")" + ":" + arrayOfObject[1];
        localObject2 = arrayOfObject[4] + "[" + this.z.size() + " " + (String)aa.get(str) + "]";
        str = arrayOfObject[2] + ":" + arrayOfObject[1];
        localObject3[0] = localObject1;
        localObject3[1] = localObject2;
        localObject3[2] = str;
        localObject3[3] = arrayOfObject[3];
        return localObject3;
      }
      localObject3[2] = (i2 + (String)ad.get(str) + this.z.size() + " " + (String)aa.get(str));
      localObject3[3] = arrayOfObject[3];
      localObject3[1] = ("QQ[" + (String)aa.get(str) + "]");
      localObject3[0] = ("[" + (String)aa.get(str) + "]" + arrayOfObject[2] + "(" + arrayOfObject[4] + ")" + ":" + arrayOfObject[1]);
      return localObject3;
      localObject2 = "";
      localObject1 = localObject2;
      if (((a)this.z.get(0)).a.msg_flag.has())
      {
        l1 = ((a)this.z.get(this.z.size() - 1)).a.msg_flag.get();
        if ((0x2 & l1) != 2L) {
          break label1726;
        }
        localObject1 = "[" + (String)ab.get(str) + "]";
      }
      for (;;)
      {
        localObject2 = "[" + (String)aa.get(str) + "]" + (String)localObject1 + arrayOfObject[2] + ":" + arrayOfObject[1];
        str = arrayOfObject[5] + "[" + this.z.size() + " " + (String)aa.get(str) + "]";
        localObject1 = (String)localObject1 + arrayOfObject[2] + ":" + arrayOfObject[1];
        localObject3[0] = localObject2;
        localObject3[1] = str;
        localObject3[2] = localObject1;
        localObject3[3] = arrayOfObject[3];
        return localObject3;
        label1726:
        localObject1 = localObject2;
        if ((l1 & 1L) == 1L) {
          localObject1 = "[" + (String)ac.get(str) + "]";
        }
      }
      arrayOfObject = b(((a)this.z.get(this.z.size() - 1)).a);
      if (arrayOfObject == null) {
        return null;
      }
      switch (((Integer)arrayOfObject[0]).intValue())
      {
      }
    }
    Object localObject1 = i1 + (String)ad.get(str) + this.z.size() + " " + (String)aa.get(str);
    Object localObject2 = arrayOfObject[3];
    Object localObject3 = "QQ[" + (String)aa.get(str) + "]";
    return new Object[] { "[" + (String)aa.get(str) + "]" + arrayOfObject[2] + ":" + arrayOfObject[1], localObject3, localObject1, localObject2 };
    localObject1 = i1 + (String)ad.get(str) + this.z.size() + " " + (String)aa.get(str);
    localObject2 = arrayOfObject[3];
    localObject3 = "QQ[" + (String)aa.get(str) + "]";
    return new Object[] { "[" + (String)aa.get(str) + "]" + arrayOfObject[2] + "(" + arrayOfObject[4] + ")" + ":" + arrayOfObject[1], localObject3, localObject1, localObject2 };
    localObject2 = "";
    localObject1 = localObject2;
    if (((a)this.z.get(0)).a.msg_flag.has())
    {
      l1 = ((a)this.z.get(this.z.size() - 1)).a.msg_flag.get();
      if ((0x2 & l1) != 2L) {
        break label2533;
      }
      localObject1 = "[" + (String)ab.get(str) + "]";
    }
    for (;;)
    {
      return new Object[] { "[" + (String)aa.get(str) + "]" + (String)localObject1 + arrayOfObject[2] + ":" + arrayOfObject[1], "QQ[" + (String)aa.get(str) + "]", i1 + (String)ad.get(str) + this.z.size() + " " + (String)aa.get(str), arrayOfObject[3] };
      label2533:
      localObject1 = localObject2;
      if ((l1 & 1L) == 1L) {
        localObject1 = "[" + (String)ac.get(str) + "]";
      }
    }
  }
  
  private void c(String paramString)
  {
    a locala = (a)this.g.get(paramString);
    locala.n = String.valueOf(com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext()));
    JceOutputStream localJceOutputStream = new JceOutputStream();
    locala.writeTo(localJceOutputStream);
    k.a().setConfig("app_push_info_" + paramString, HexUtil.bytes2HexStr(localJceOutputStream.toByteArray()));
  }
  
  private void c(boolean paramBoolean)
  {
    offlinepush.PbPushOffMsg localPbPushOffMsg;
    Context localContext;
    if (this.z.size() > 0)
    {
      localPbPushOffMsg = ((a)this.z.get(0)).a;
      localContext = BaseApplication.getContext();
      if (a(localContext, localPbPushOffMsg.to_uin.get())) {
        break label82;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg no_disturb_mode return now");
      }
    }
    label82:
    do
    {
      return;
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(w);
      return;
      localObject1 = b(paramBoolean);
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager", 2, "Decode Message error, exit now");
    return;
    Object localObject2 = (String)localObject1[0];
    String str1 = (String)localObject1[1];
    String str2 = (String)localObject1[2];
    Object localObject1 = BitmapFactory.decodeFile((String)localObject1[3]);
    if (localObject1 != null) {
      localObject1 = a((Bitmap)localObject1, 50, 50);
    }
    int i1;
    int i2;
    for (;;)
    {
      NotificationManager localNotificationManager = (NotificationManager)localContext.getSystemService("notification");
      localObject2 = new NotificationCompat.Builder(localContext).setContentTitle(str1).setContentText(str2).setAutoCancel(true).setSmallIcon(BaseApplication.getQQNewMsgIcon()).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
      if (localObject1 != null)
      {
        ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject1);
        if (Build.VERSION.SDK_INT < 11) {
          ((NotificationCompat.Builder)localObject2).setSmallIcon(BaseApplication.getQQLaunchIcon());
        }
        i1 = Calendar.getInstance().get(11);
        if ((i1 < 23) && (i1 < 8)) {}
        ((NotificationCompat.Builder)localObject2).setLights(-16711936, 2000, 2000);
        ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqqi.msf.receiveofflinepush"), 0));
        ((NotificationCompat.Builder)localObject2).setDeleteIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqqi.msf.offlinepushclearall"), 0));
        localObject1 = ((NotificationCompat.Builder)localObject2).build();
        if (localNotificationManager != null) {
          localNotificationManager.cancel(w);
        }
        localNotificationManager.notify(w, (Notification)localObject1);
        localObject1 = PreferenceManager.getDefaultSharedPreferences(localContext);
        if ((b(String.valueOf(localPbPushOffMsg.to_uin.get()), localContext) == 1) && (!h()))
        {
          localObject2 = (Vibrator)localContext.getSystemService("vibrator");
          if (!a((SharedPreferences)localObject1)) {
            break label654;
          }
          ((Vibrator)localObject2).vibrate(1000L);
        }
      }
      for (;;)
      {
        if ((a(String.valueOf(localPbPushOffMsg.to_uin.get()), localContext) != 1) || (h())) {
          break label664;
        }
        i1 = ((SharedPreferences)localObject1).getInt("sound_type" + localPbPushOffMsg.to_uin.get(), BaseApplication.getDefaultNotifSoundResourceId());
        i2 = i1;
        if (a((SharedPreferences)localObject1))
        {
          i2 = ((SharedPreferences)localObject1).getInt("special_sound_type" + ((a)this.z.get(this.z.size() - 1)).a.to_uin.get() + ((a)this.z.get(this.z.size() - 1)).a.from_uin.get(), i1);
          if (i2 != 1) {
            break label666;
          }
        }
        try
        {
          i2 = ((SharedPreferences)localObject1).getInt("defaulut_special_sound_source" + i2, i2);
          i1 = i2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("PushManager", 2, "special sound play exception|" + localException.getMessage());
            }
            localException.printStackTrace();
            i2 = i1;
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("PushManager", 2, "special sound not exist.");
            }
          }
        }
        i2 = i1;
        a(i2, false);
        return;
        ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapFactory.decodeResource(localContext.getResources(), BaseApplication.getQQLaunchIcon()));
        break;
        label654:
        ((Vibrator)localObject2).vibrate(ag, -1);
      }
      label664:
      break;
      label666:
      localObject1 = ((SharedPreferences)localObject1).getString("special_sound_url" + i2, "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new File(BaseApplication.getContext().getFilesDir(), (String)localObject1);
        if (((File)localObject1).exists())
        {
          a(((File)localObject1).getAbsolutePath(), false);
          return;
        }
      }
    }
  }
  
  private boolean c(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg msg_type:0x" + Integer.toHexString(paramPbPushOffMsg.msg_type.get()) + " dwViedoType:" + paramPbPushOffMsg.dwViedoType.get());
    }
    return (paramPbPushOffMsg.msg_type.get() == 734) || (paramPbPushOffMsg.msg_type.get() == 215) || (paramPbPushOffMsg.msg_type.get() == 519);
  }
  
  private void p()
  {
    aa = new ArrayMap();
    aa.put("en", "Offline Message");
    aa.put("zh", "离线消息");
    aa.put("ja", "オフラインメッセージ");
    aa.put("ko", "오프라인 메시지");
    aa.put("de", "Offline Nachricht");
    aa.put("fr", "En ligne des messages");
    aa.put("es", "Desconectado Mensaje");
    ab = new ArrayMap();
    ab.put("en", "Someone @ me");
    ab.put("zh", "有人@我");
    ab.put("ja", "私@誰か");
    ab.put("ko", "나 @ 사람");
    ab.put("de", "Jemand @ me");
    ab.put("fr", "Quelqu'un me @");
    ab.put("es", "Alguien me @");
    ac = new ArrayMap();
    ac.put("en", "Special attention");
    ac.put("zh", "特别关注");
    ac.put("ja", "特別な注意");
    ac.put("ko", "특별한주의");
    ac.put("de", "Besondere Aufmerksamkeit");
    ac.put("fr", "Une attention particulière");
    ac.put("es", "Especial atención");
    ad = new ArrayMap();
    ad.put("en", "Contacts send to you ");
    ad.put("zh", "个联系人给你发来");
    ad.put("ja", "連絡先は、あなたに送る");
    ad.put("ko", "연락처 당신에게 보내");
    ad.put("de", "Kontakte zu senden, um Sie");
    ad.put("fr", "Contacts envoyer à vous");
    ad.put("es", "Contactos envían a usted");
    ae = new ArrayMap();
    ae.put("en", " call request");
    ae.put("zh", "通话请求");
    ae.put("ja", "コール要求");
    ae.put("ko", "전화 요청");
    ae.put("de", " anrufanforderung");
    ae.put("fr", " demande d'appel");
    ae.put("es", " solicitud de llamada");
  }
  
  private String q()
  {
    String str = Locale.getDefault().getLanguage();
    if ((str.equals("en")) || (str.equals("zh")) || (str.equals("ja")) || (str.equals("ko")) || (str.equals("de")) || (str.equals("fr")) || (str.equals("es"))) {
      return str;
    }
    return "en";
  }
  
  private int r()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.z.iterator();
    label106:
    for (;;)
    {
      Long localLong;
      if (localIterator1.hasNext())
      {
        localLong = Long.valueOf(((a)localIterator1.next()).a.from_uin.get());
        Iterator localIterator2 = localArrayList.iterator();
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
        } while (!((Long)localIterator2.next()).equals(localLong));
      }
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label106;
        }
        localArrayList.add(localLong);
        break;
        return localArrayList.size();
      }
    }
  }
  
  private int s()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.z.iterator();
    label178:
    for (;;)
    {
      Object localObject;
      if (localIterator1.hasNext())
      {
        localObject = (a)localIterator1.next();
        switch (a(((a)localObject).a.msg_type.get(), ((a)localObject).a.dwViedoType.get()))
        {
        case 0: 
        default: 
          break;
        case 1: 
          if (!((a)localObject).a.discuss_info.has()) {
            continue;
          }
          localObject = Long.valueOf(((a)localObject).a.discuss_info.discuss_uin.get());
          Iterator localIterator2 = localArrayList.iterator();
          do
          {
            if (!localIterator2.hasNext()) {
              break;
            }
          } while (!((Long)localIterator2.next()).equals(localObject));
        }
      }
      else
      {
        for (int i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label178;
          }
          localArrayList.add(localObject);
          break;
          return localArrayList.size();
        }
      }
    }
  }
  
  private Object[] t()
  {
    String str1 = q();
    if (this.A.size() == 1)
    {
      arrayOfObject = new Object[4];
      localObject = b(((a)this.A.get(0)).a);
      if (localObject == null) {
        return null;
      }
      switch (((Integer)localObject[0]).intValue())
      {
      default: 
        return null;
      case 0: 
      case 2: 
        str2 = "[" + (String)aa.get(str1) + "]" + localObject[2] + ":" + localObject[1];
        str1 = localObject[2] + "[" + (String)aa.get(str1) + "]";
        str3 = (String)localObject[1];
        arrayOfObject[0] = str2;
        arrayOfObject[1] = str1;
        arrayOfObject[2] = str3;
        arrayOfObject[3] = localObject[3];
        return arrayOfObject;
      }
      String str2 = "[" + (String)aa.get(str1) + "]" + localObject[2] + "(" + localObject[4] + ")" + ":" + localObject[1];
      str1 = localObject[4] + "[" + (String)aa.get(str1) + "]";
      String str3 = localObject[2] + ":" + localObject[1];
      arrayOfObject[0] = str2;
      arrayOfObject[1] = str1;
      arrayOfObject[2] = str3;
      arrayOfObject[3] = localObject[3];
      return arrayOfObject;
    }
    Object[] arrayOfObject = new Object[4];
    Object localObject = this.A.size() + (String)ae.get(str1);
    arrayOfObject[2] = localObject;
    arrayOfObject[1] = ("QQ[" + (String)aa.get(str1) + "]");
    arrayOfObject[0] = ("[" + (String)aa.get(str1) + "]QQ" + " " + (String)localObject);
    return arrayOfObject;
  }
  
  private void u()
  {
    offlinepush.PbPushOffMsg localPbPushOffMsg;
    Context localContext;
    if (this.A.size() > 0)
    {
      localPbPushOffMsg = ((a)this.A.get(0)).a;
      localContext = BaseApplication.getContext();
      if (a(localContext, localPbPushOffMsg.to_uin.get())) {
        break label80;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg no_disturb_mode return now");
      }
    }
    label80:
    do
    {
      return;
      ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(x);
      return;
      localObject1 = t();
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager", 2, "Decode Message error, exit now");
    return;
    Object localObject2 = (String)localObject1[0];
    String str1 = (String)localObject1[1];
    String str2 = (String)localObject1[2];
    Object localObject1 = BitmapFactory.decodeFile((String)localObject1[3]);
    if (localObject1 != null) {
      localObject1 = a((Bitmap)localObject1, 50, 50);
    }
    for (;;)
    {
      NotificationManager localNotificationManager = (NotificationManager)localContext.getSystemService("notification");
      localObject2 = new NotificationCompat.Builder(localContext).setContentTitle(str1).setContentText(str2).setAutoCancel(true).setSmallIcon(BaseApplication.getQQNewAVMsgIcon()).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
      if (localObject1 != null) {
        ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject1);
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT < 11) {
          ((NotificationCompat.Builder)localObject2).setSmallIcon(BaseApplication.getQQLaunchIcon());
        }
        int i1 = Calendar.getInstance().get(11);
        if ((i1 < 23) && (i1 < 8)) {}
        ((NotificationCompat.Builder)localObject2).setLights(-16711936, 2000, 2000);
        ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqqi.msf.receiveofflinepushav"), 0));
        ((NotificationCompat.Builder)localObject2).setDeleteIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqqi.msf.offlinepushclearallav"), 0));
        localObject1 = ((NotificationCompat.Builder)localObject2).build();
        if (localNotificationManager != null) {
          localNotificationManager.cancel(x);
        }
        localNotificationManager.notify(x, (Notification)localObject1);
        if ((a(String.valueOf(localPbPushOffMsg.to_uin.get()), localContext) == 1) && (!h())) {
          a(PreferenceManager.getDefaultSharedPreferences(localContext).getInt("sound_type" + localPbPushOffMsg.to_uin.get(), BaseApplication.getDefaultNotifSoundResourceId()), false);
        }
        if ((b(String.valueOf(localPbPushOffMsg.to_uin.get()), localContext) != 1) || (h())) {
          break;
        }
        ((Vibrator)localContext.getSystemService("vibrator")).vibrate(ag, -1);
        return;
        ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapFactory.decodeResource(localContext.getResources(), BaseApplication.getQQLaunchIcon()));
      }
    }
  }
  
  public int a(String paramString)
  {
    Iterator localIterator = this.g.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.g.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).k.getUin().equals(paramString)))
      {
        if (((a)localObject).c == 0L) {
          return -2;
        }
        return ((a)localObject).k.iStatus;
      }
    }
    return -1;
  }
  
  public int a(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 1;
    }
    paramString = paramContext.getSharedPreferences(paramString, 0).getString(this.X, String.valueOf(1));
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 1;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = BaseApplication.getContext().getFilesDir().getPath();
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      localStringBuilder.append(this.N);
      localObject = b(paramInt, paramString);
      switch (((Integer)localObject[0]).intValue())
      {
      }
    }
    for (;;)
    {
      localObject = MD5.toMD5(paramString);
      localObject = MD5.toMD5((String)localObject + paramString);
      localStringBuilder.append(MD5.toMD5((String)localObject + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append((String)localObject + this.P);
      break;
      localStringBuilder.append("troop_sys_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("discussion_");
      continue;
      localStringBuilder.append("troop_");
    }
  }
  
  public void a()
  {
    try
    {
      if (!this.k)
      {
        this.j.start();
        this.k = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   6: ifnull +30 -> 36
    //   9: aload_0
    //   10: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   13: invokevirtual 1147	android/media/MediaPlayer:isPlaying	()Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   28: invokevirtual 1150	android/media/MediaPlayer:release	()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   36: iload_1
    //   37: sipush 1000
    //   40: if_icmpeq +81 -> 121
    //   43: aload_0
    //   44: invokestatic 377	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   47: iload_1
    //   48: invokestatic 1154	android/media/MediaPlayer:create	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   51: putfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   54: aload_0
    //   55: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   58: ifnull -37 -> 21
    //   61: aload_0
    //   62: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   65: new 1156	com/tencent/mobileqq/msf/core/c/h
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 1157	com/tencent/mobileqq/msf/core/c/h:<init>	(Lcom/tencent/mobileqq/msf/core/c/e;)V
    //   73: invokevirtual 1161	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   76: aload_0
    //   77: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   80: invokevirtual 1162	android/media/MediaPlayer:start	()V
    //   83: aload_0
    //   84: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   87: iload_2
    //   88: invokevirtual 1165	android/media/MediaPlayer:setLooping	(Z)V
    //   91: goto -70 -> 21
    //   94: astore 4
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   101: goto -65 -> 36
    //   104: astore 4
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 4
    //   110: athrow
    //   111: astore 4
    //   113: aload_0
    //   114: aconst_null
    //   115: putfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   118: aload 4
    //   120: athrow
    //   121: aload_0
    //   122: invokestatic 377	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   125: getstatic 1171	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   128: invokestatic 1174	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   131: putfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   134: goto -80 -> 54
    //   137: astore 4
    //   139: goto -118 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	e
    //   0	142	1	paramInt	int
    //   0	142	2	paramBoolean	boolean
    //   16	2	3	bool	boolean
    //   94	1	4	localException1	Exception
    //   104	5	4	localObject1	Object
    //   111	8	4	localObject2	Object
    //   137	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	31	94	java/lang/Exception
    //   2	17	104	finally
    //   31	36	104	finally
    //   43	54	104	finally
    //   54	91	104	finally
    //   96	101	104	finally
    //   113	121	104	finally
    //   121	134	104	finally
    //   24	31	111	finally
    //   2	17	137	java/lang/Exception
    //   31	36	137	java/lang/Exception
    //   43	54	137	java/lang/Exception
    //   54	91	137	java/lang/Exception
    //   96	101	137	java/lang/Exception
    //   113	121	137	java/lang/Exception
    //   121	134	137	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    long l1;
    if (paramLong < 30000L)
    {
      if (!QLog.isColorLevel()) {
        break label202;
      }
      QLog.d("MSF.C.PushManager", 2, "queryPushIntervTime less than 30000,change to 30000.");
      l1 = 30000L;
    }
    for (;;)
    {
      if (this.Z != null) {
        a(BaseApplication.getContext());
      }
      Intent localIntent = new Intent(this.d);
      localIntent.setAction(this.d);
      this.Z = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 0);
      this.i = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
      this.i.set(0, System.currentTimeMillis() + l1, this.Z);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "register " + this.d + " alarm alive send at " + f.format(Long.valueOf(System.currentTimeMillis() + l1)));
      }
      return;
      l1 = paramLong;
      if (paramLong > 3600000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "queryPushIntervTime greater than 600000 ,change to 600000.");
        }
        l1 = 3600000L;
        continue;
        label202:
        l1 = 30000L;
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.Z != null) {
      this.i.cancel(this.Z);
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    this.c = (Build.MODEL + "|" + Build.VERSION.RELEASE);
    this.d = (MsfSdkUtils.getProcessName(paramContext) + "_" + getClass().hashCode());
    paramContext = new IntentFilter();
    paramContext.addAction(this.d);
    BaseApplication.getContext().registerReceiver(this, paramContext);
    this.i = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    a(paramBoolean);
    p();
  }
  
  public void a(a parama, j paramj)
  {
    if (parama.c > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "send " + parama.b + " push register, pushId is " + parama.c);
      }
      this.h.a(parama, null, false, paramj);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MSF.C.PushManager", 2, parama.b + " queryPushId is " + parama.c + " ,skip register.");
  }
  
  public void a(CommandCallbackerInfo paramCommandCallbackerInfo, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      String str = h.b(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " appCmdCallbacker " + paramCommandCallbackerInfo);
      }
      if (!this.g.containsKey(str)) {
        this.g.putIfAbsent(str, new a(str));
      }
      ((a)this.g.get(str)).m = paramCommandCallbackerInfo;
      paramCommandCallbackerInfo = h.a(paramToServiceMsg);
      paramCommandCallbackerInfo.setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, paramCommandCallbackerInfo);
      c(str);
      return;
    }
    finally {}
  }
  
  public void a(PushRegisterInfo paramPushRegisterInfo, ToServiceMsg paramToServiceMsg)
  {
    String str;
    try
    {
      str = h.b(paramToServiceMsg);
      if (!a(str, BaseApplication.getContext().getPackageName())) {
        break label322;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv unRegisterPush ");
      }
      if (!this.g.containsKey(str)) {
        this.g.putIfAbsent(str, new a(str));
      }
      ((a)this.g.get(str)).k = paramPushRegisterInfo;
      ((a)this.g.get(str)).a = paramToServiceMsg.getAppId();
      ((a)this.g.get(str)).c = 0L;
      this.h.a((a)this.g.get(str), paramToServiceMsg, true, j.b);
      paramToServiceMsg = ((a)this.g.get(str)).k.pushIds;
      paramPushRegisterInfo = paramPushRegisterInfo.pushIds;
      ArrayList localArrayList = new ArrayList();
      paramToServiceMsg = paramToServiceMsg.iterator();
      while (paramToServiceMsg.hasNext())
      {
        long l1 = ((Long)paramToServiceMsg.next()).longValue();
        if (!paramPushRegisterInfo.contains(Long.valueOf(l1))) {
          localArrayList.add(Long.valueOf(l1));
        }
      }
      ((a)this.g.get(str)).k.pushIds = localArrayList;
    }
    finally {}
    if (((a)this.g.get(str)).c == 0L) {
      ((a)this.g.get(str)).k = null;
    }
    c(str);
    for (;;)
    {
      return;
      label322:
      if (QLog.isColorLevel()) {
        QLog.e("MSF.C.PushManager", 2, "recv other processName:" + str + " recv unRegisterPush ");
      }
    }
  }
  
  public void a(com.tencent.mobileqq.msf.sdk.l paraml, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + h.b(paramToServiceMsg) + " recv ProxyRegisterInfo " + paraml);
      }
      if (!this.g.containsKey(paraml.d())) {
        this.g.putIfAbsent(paraml.d(), new a(paraml.d()));
      }
      Object localObject = (a)this.g.get(paraml.d());
      ((a)localObject).a = paraml.c();
      ((a)localObject).m = paraml.g();
      ((a)localObject).l = paraml.f();
      localObject = com.tencent.mobileqq.msf.core.j.a(paramToServiceMsg);
      ((FromServiceMsg)localObject).setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject);
      c(paraml.d());
      return;
    }
    finally {}
  }
  
  public void a(offlinepush.PbPushOffMsg paramPbPushOffMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onRecvDevlockQuickloginOfflinePush start...");
    }
    try
    {
      if (paramPbPushOffMsg.msg_str.has())
      {
        paramPbPushOffMsg = new String(paramPbPushOffMsg.msg_str.get().toByteArray(), "utf-8");
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "onRecvDevlockQuickloginOfflinePush  maintip=" + paramPbPushOffMsg);
        }
        localContext = BaseApplication.getContext();
        Bitmap localBitmap = BitmapFactory.decodeResource(localContext.getResources(), BaseApplication.getDevlockQuickloginIcon());
        Object localObject = localBitmap;
        if (localBitmap != null) {
          localObject = a(localBitmap, 50, 50);
        }
        paramPbPushOffMsg = new NotificationCompat.Builder(localContext).setContentTitle("一键验证").setContentText(paramPbPushOffMsg).setAutoCancel(true).setSmallIcon(BaseApplication.getQQNewMsgIcon()).setTicker("一键验证").setWhen(System.currentTimeMillis());
        if (localObject == null) {
          break label289;
        }
        paramPbPushOffMsg.setLargeIcon((Bitmap)localObject);
        if (Build.VERSION.SDK_INT < 11) {
          paramPbPushOffMsg.setSmallIcon(BaseApplication.getQQLaunchIcon());
        }
        paramPbPushOffMsg.setContentIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqqi.msf.receiveofflinepush"), 0));
        paramPbPushOffMsg.setDeleteIntent(PendingIntent.getBroadcast(localContext, 0, new Intent("com.tencent.mobileqq.msf.devlockquickloginpushclear"), 0));
        paramPbPushOffMsg = paramPbPushOffMsg.build();
        localObject = (NotificationManager)localContext.getSystemService("notification");
        if (localObject != null)
        {
          ((NotificationManager)localObject).cancel(y);
          ((NotificationManager)localObject).notify(y, paramPbPushOffMsg);
          this.J.removeMessages(20140416);
          this.J.sendEmptyMessageDelayed(20140416, 120000L);
        }
      }
    }
    catch (Exception paramPbPushOffMsg)
    {
      for (;;)
      {
        Context localContext;
        paramPbPushOffMsg.printStackTrace();
        paramPbPushOffMsg = null;
        continue;
        label289:
        paramPbPushOffMsg.setLargeIcon(BitmapFactory.decodeResource(localContext.getResources(), BaseApplication.getQQLaunchIcon()));
      }
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onConnClosed " + parama);
    }
    n = false;
    this.v = 0L;
    this.af = 0L;
    parama = new f(this);
    parama.setName("onConnClosedPushThread");
    parama.start();
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    Iterator localIterator = this.g.keySet().iterator();
    int i1 = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (a)this.g.get(localObject);
        if (localObject != null) {
          if (paramFromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush"))
          {
            localObject = new UniPacket(true);
            ((UniPacket)localObject).setEncodeName("UTF-8");
            try
            {
              ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
            }
            catch (Throwable paramFromServiceMsg)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "decode PushMsg error " + paramFromServiceMsg, paramFromServiceMsg);
              }
            }
          }
        }
      }
    }
    while ((i1 != 0) || (!QLog.isColorLevel())) {
      for (;;)
      {
        Object localObject;
        return;
        if (paramFromServiceMsg.getServiceCmd().equals("StatSvc.QueryHB"))
        {
          if (com.tencent.mobileqq.msf.core.a.a.t)
          {
            ((a)localObject).i = this.b.nowSocketConnAdd;
            ((a)localObject).f = System.currentTimeMillis();
            a((a)localObject, j.f);
            i1 = 1;
          }
          else
          {
            QLog.e("MSF.C.PushManager", 2, "recv push StatSvc.QueryHB, but do not support useAnyPacketAsPushHB ");
          }
        }
        else if (paramFromServiceMsg.isSuccess())
        {
          if (a((a)localObject, paramFromServiceMsg)) {
            i1 = 1;
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "recv error onRecvPushMsg FromServiceMsg  " + paramFromServiceMsg);
        }
      }
    }
    QLog.w("MSF.C.PushManager", 2, "found not handle push msg " + paramFromServiceMsg);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    this.h.a(paramFromServiceMsg, paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, j paramj)
  {
    String str = h.b(paramToServiceMsg);
    if (a(str, BaseApplication.getContext().getPackageName()))
    {
      if (!this.g.containsKey(str)) {
        this.g.putIfAbsent(str, new a(str));
      }
      localObject = m.b(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv regPush ");
      }
      locala = (a)this.g.get(str);
      if ((locala != null) && (locala.k != null) && (locala.c != 0L) && (locala.k.uin.equals(((PushRegisterInfo)localObject).uin)) && (locala.k.iStatus == ((PushRegisterInfo)localObject).iStatus) && (locala.k.bKikPC == ((PushRegisterInfo)localObject).bKikPC) && (locala.k.bKikWeak == ((PushRegisterInfo)localObject).bKikWeak) && (locala.k.timeStamp == ((PushRegisterInfo)localObject).timeStamp))
      {
        if (QLog.isColorLevel()) {
          QLog.e("MSF.C.PushManager", 2, "handlerPush also register Push " + MD5.toMD5(((PushRegisterInfo)localObject).uin) + "iStatus:" + ((PushRegisterInfo)localObject).iStatus);
        }
        paramj = h.a(paramToServiceMsg);
        paramj.setMsgSuccess();
        this.b.addRespToQuque(paramToServiceMsg, paramj);
      }
    }
    while (!QLog.isColorLevel())
    {
      a locala;
      return;
      if (QLog.isColorLevel()) {
        QLog.e("MSF.C.PushManager", 2, "handlerPush not found the same register Push " + MD5.toMD5(((PushRegisterInfo)localObject).uin) + " iStatus:" + ((PushRegisterInfo)localObject).iStatus);
      }
      locala.k = ((PushRegisterInfo)localObject);
      locala.a = paramToServiceMsg.getAppId();
      Object localObject = ((PushRegisterInfo)localObject).pushIds.iterator();
      while (((Iterator)localObject).hasNext()) {
        locala.c = (((Long)((Iterator)localObject).next()).longValue() | locala.c);
      }
      c(str);
      this.h.a(locala, paramToServiceMsg, false, paramj);
      return;
    }
    QLog.e("MSF.C.PushManager", 2, "recv other processName:" + str + " recv regPush ");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.h.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(String paramString, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + h.b(paramToServiceMsg) + " recv proxyUnRegister " + paramString);
      }
      this.g.remove(paramString);
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.core.j.a(paramToServiceMsg);
      localFromServiceMsg.setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, localFromServiceMsg);
      k.a().removeConfig("app_push_info_" + paramString);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   6: ifnull +30 -> 36
    //   9: aload_0
    //   10: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   13: invokevirtual 1147	android/media/MediaPlayer:isPlaying	()Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   28: invokevirtual 1150	android/media/MediaPlayer:release	()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   36: aload_0
    //   37: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   40: ifnonnull +14 -> 54
    //   43: aload_0
    //   44: new 1144	android/media/MediaPlayer
    //   47: dup
    //   48: invokespecial 1474	android/media/MediaPlayer:<init>	()V
    //   51: putfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   54: aload_0
    //   55: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   58: invokevirtual 1477	android/media/MediaPlayer:reset	()V
    //   61: aload_0
    //   62: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   65: new 1479	java/io/FileInputStream
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 1480	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   73: invokevirtual 1484	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   76: invokevirtual 1488	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   79: aload_0
    //   80: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   83: invokevirtual 1491	android/media/MediaPlayer:prepare	()V
    //   86: aload_0
    //   87: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   90: new 1493	com/tencent/mobileqq/msf/core/c/g
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 1494	com/tencent/mobileqq/msf/core/c/g:<init>	(Lcom/tencent/mobileqq/msf/core/c/e;)V
    //   98: invokevirtual 1161	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   101: aload_0
    //   102: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   105: invokevirtual 1162	android/media/MediaPlayer:start	()V
    //   108: aload_0
    //   109: getfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   112: iload_2
    //   113: invokevirtual 1165	android/media/MediaPlayer:setLooping	(Z)V
    //   116: goto -95 -> 21
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 567	java/lang/Exception:printStackTrace	()V
    //   124: goto -103 -> 21
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    //   132: astore 4
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   139: goto -103 -> 36
    //   142: astore_1
    //   143: aload_0
    //   144: aconst_null
    //   145: putfield 1142	com/tencent/mobileqq/msf/core/c/e:H	Landroid/media/MediaPlayer;
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	e
    //   0	150	1	paramString	String
    //   0	150	2	paramBoolean	boolean
    //   16	2	3	bool	boolean
    //   132	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	17	119	java/lang/Exception
    //   31	36	119	java/lang/Exception
    //   36	54	119	java/lang/Exception
    //   54	116	119	java/lang/Exception
    //   134	139	119	java/lang/Exception
    //   143	150	119	java/lang/Exception
    //   2	17	127	finally
    //   31	36	127	finally
    //   36	54	127	finally
    //   54	116	127	finally
    //   120	124	127	finally
    //   134	139	127	finally
    //   143	150	127	finally
    //   24	31	132	java/lang/Exception
    //   24	31	142	finally
  }
  
  public void a(boolean paramBoolean)
  {
    String[] arrayOfString = k.a().getConfigList("app_push_info_");
    int i3 = com.tencent.mobileqq.msf.core.c.e(BaseApplication.getContext());
    int i4 = arrayOfString.length;
    int i2 = 0;
    Object localObject;
    a locala;
    int i1;
    if (i2 < i4)
    {
      localObject = HexUtil.hexStr2Bytes(arrayOfString[i2]);
      locala = new a();
      locala.readFrom(new JceInputStream((byte[])localObject));
      localObject = BaseApplication.getContext().getPackageName();
      if (!a(locala.b, (String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.e("MSF.C.PushManager", 2, "filter other push process. processName:" + locala.b);
        }
        k.a().removeConfig("app_push_info_" + locala.b);
      }
      do
      {
        i2 += 1;
        break;
        this.g.put(locala.b, locala);
      } while ((locala.k == null) || (locala.c <= 0L));
      if (i3 == -1)
      {
        if (!QLog.isColorLevel()) {
          break label623;
        }
        QLog.d("MSF.C.PushManager", 2, "nVersionCode:" + i3 + " sendMsgPushRegister now");
        i1 = 1;
      }
    }
    for (;;)
    {
      label237:
      if (i1 != 0) {
        this.h.a(locala, null, false, j.a);
      }
      for (;;)
      {
        if (l) {
          break label620;
        }
        l = true;
        m = locala.k.uin;
        break;
        localObject = String.valueOf(i3);
        if (locala.n != null)
        {
          if (locala.n.equals(localObject))
          {
            if (!QLog.isColorLevel()) {
              break label623;
            }
            QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + locala.n + " strVersionCode:" + (String)localObject + " sendMsgPushRegister now");
            i1 = 1;
            break label237;
          }
          if (paramBoolean)
          {
            if (!QLog.isColorLevel()) {
              break label623;
            }
            QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + locala.n + " bBoot:" + paramBoolean + " strVersionCode:" + (String)localObject + " sendMsgPushRegister now");
            i1 = 1;
            break label237;
          }
          if (!QLog.isColorLevel()) {
            break label608;
          }
          QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + locala.n + " strVersionCode:" + (String)localObject + " no need sendMsgPushRegister");
          i1 = 0;
          break label237;
        }
        if (paramBoolean)
        {
          if (!QLog.isColorLevel()) {
            break label623;
          }
          QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + locala.n + " bBoot:" + paramBoolean + " sendMsgPushRegister now");
          i1 = 1;
          break label237;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.PushManager", 2, "info.installVersion :" + locala.n + " bBoot:" + paramBoolean + " no need sendMsgPushRegister");
        }
        label608:
        i1 = 0;
        break label237;
        locala.c = 0L;
      }
      label620:
      break;
      return;
      label623:
      i1 = 1;
    }
  }
  
  public boolean a(a parama, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parama.m != null)
    {
      bool1 = bool2;
      if (parama.m.uin.equals(paramFromServiceMsg.getUin()))
      {
        Iterator localIterator = parama.m.cmds.iterator();
        bool1 = false;
        if (localIterator.hasNext())
        {
          if (!((String)localIterator.next()).equals(paramFromServiceMsg.getServiceCmd())) {
            break label120;
          }
          paramFromServiceMsg.addAttribute("resp_needBootApp", Integer.valueOf(1));
          MsfSdkUtils.addFromMsgProcessName(parama.b, paramFromServiceMsg);
          paramFromServiceMsg.setMsfCommand(MsfCommand.onRecvPushMsg);
          this.b.addRespToQuque(null, paramFromServiceMsg);
          bool1 = true;
        }
      }
    }
    label120:
    for (;;)
    {
      break;
      return bool1;
    }
  }
  
  public int b(String paramString, Context paramContext)
  {
    if (paramString == null) {
      return 1;
    }
    paramString = paramContext.getSharedPreferences(paramString, 0).getString(this.Y, String.valueOf(1));
    try
    {
      int i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 1;
  }
  
  public void b(long paramLong)
  {
    this.af = paramLong;
  }
  
  public void b(CommandCallbackerInfo paramCommandCallbackerInfo, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      String str = h.b(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv unRegisterCmdCall ");
      }
      if (!this.g.containsKey(str)) {
        this.g.putIfAbsent(str, new a(str));
      }
      ((a)this.g.get(str)).m = paramCommandCallbackerInfo;
      paramCommandCallbackerInfo = h.a(paramToServiceMsg);
      paramCommandCallbackerInfo.setMsgSuccess();
      this.b.addRespToQuque(paramToServiceMsg, paramCommandCallbackerInfo);
      c(str);
      return;
    }
    finally {}
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded getted");
    }
    long l1 = 0L;
    offlinepush.PbPushOffReadedNotify localPbPushOffReadedNotify;
    Object localObject1;
    Object localObject2;
    int i1;
    long l2;
    Iterator localIterator;
    a locala;
    try
    {
      localPbPushOffReadedNotify = new offlinepush.PbPushOffReadedNotify();
      localObject1 = paramFromServiceMsg.getWupBuffer();
      localObject2 = new byte[localObject1.length - 4];
      System.arraycopy(localObject1, 4, localObject2, 0, localObject1.length - 4);
      localPbPushOffReadedNotify.mergeFrom((byte[])localObject2);
      i1 = localPbPushOffReadedNotify.cNotifyType.get();
      if ((i1 & 0x1) == 0) {
        break label333;
      }
      localObject1 = new ArrayList();
      localObject2 = localPbPushOffReadedNotify.vC2CReadedNotify.get().iterator();
      l1 = 0L;
      while (((Iterator)localObject2).hasNext())
      {
        l2 = ((offlinepush.C2CMsgReadedNotify)((Iterator)localObject2).next()).lPeerUin.get();
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded C2C uin:" + l2);
        }
        localIterator = this.z.iterator();
        while (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          l1 = locala.a.to_uin.get();
          if (locala.a.from_uin.get() == l2) {
            ((List)localObject1).add(locala);
          }
        }
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "onRecvPushReaded decode error:" + paramFromServiceMsg, paramFromServiceMsg);
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded remove" + ((List)localObject1).size() + " message");
    }
    this.z.removeAll((Collection)localObject1);
    label333:
    if ((i1 & 0x4) != 0)
    {
      localObject1 = new ArrayList();
      localObject2 = localPbPushOffReadedNotify.vDisReadedNotify.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        l2 = ((offlinepush.DisMsgReadedNotify)((Iterator)localObject2).next()).lDisUin.get();
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded Discuss uin:" + l2);
        }
        localIterator = this.z.iterator();
        while (localIterator.hasNext())
        {
          locala = (a)localIterator.next();
          l1 = locala.a.to_uin.get();
          if (locala.a.discuss_info.discuss_uin.get() == l2) {
            ((List)localObject1).add(locala);
          }
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.PushManager", 4, "onRecvPushReaded remove" + ((List)localObject1).size() + " message");
      }
      this.z.removeAll((Collection)localObject1);
    }
    for (;;)
    {
      localObject1 = BaseApplication.getContext().getSharedPreferences("unreadcount", 0);
      ((SharedPreferences)localObject1).edit();
      i1 = ((SharedPreferences)localObject1).getInt("unread", -1);
      int i2 = this.z.size();
      b.d(BaseApplication.getContext(), i1 + i2);
      c(true);
      a(l1, paramFromServiceMsg.getRequestSsoSeq(), localPbPushOffReadedNotify.svr_ip.get());
      return;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.h.b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void b(String paramString)
  {
    try
    {
      String str = BaseApplication.getContext().getPackageName();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv KickedMsg ");
      }
      a locala = (a)this.g.get(str);
      if ((locala != null) && (locala.k != null) && (locala.k.uin.equals(paramString)))
      {
        locala.c = 0L;
        locala.k = null;
        c(str);
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    Iterator localIterator = this.g.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.g.get(localObject);
      if ((localObject != null) && (((a)localObject).k != null) && (((a)localObject).c != 0L)) {
        return true;
      }
    }
    return false;
  }
  
  public void c()
  {
    synchronized (this.r)
    {
      this.r.notify();
      return;
    }
  }
  
  public void c(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg getted");
    }
    if (MsfService.getCore().getUinPushStatus(paramFromServiceMsg.getUin()) != 95) {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg client status:" + MsfService.getCore().getUinPushStatus(paramFromServiceMsg.getUin()) + " drop now");
      }
    }
    int i1;
    do
    {
      do
      {
        do
        {
          return;
          if (!h.b()) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("MSF.C.PushManager", 4, "onRecvPbPushOffMsg mobileqq is running drop now");
        return;
        localObject = this.z.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          i1 = ((a)((Iterator)localObject).next()).b;
        } while (paramFromServiceMsg.getRequestSsoSeq() != i1);
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get duplicate msg drop now.");
      return;
      localObject = this.A.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i1 = ((a)((Iterator)localObject).next()).b;
      } while (paramFromServiceMsg.getRequestSsoSeq() != i1);
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg get duplicate av msg drop now ssoseq:" + i1);
    return;
    Object localObject = new a();
    for (;;)
    {
      offlinepush.PbPushOffMsg localPbPushOffMsg;
      try
      {
        localPbPushOffMsg = new offlinepush.PbPushOffMsg();
        byte[] arrayOfByte1 = paramFromServiceMsg.getWupBuffer();
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 4];
        System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, arrayOfByte1.length - 4);
        localPbPushOffMsg.mergeFrom(arrayOfByte2);
        ((a)localObject).a = localPbPushOffMsg;
        ((a)localObject).b = paramFromServiceMsg.getRequestSsoSeq();
        if (!c(localPbPushOffMsg)) {
          break label433;
        }
        this.A.add(localObject);
        u();
        a(localPbPushOffMsg.to_uin.get(), paramFromServiceMsg.getRequestSsoSeq(), localPbPushOffMsg.svr_ip.get());
        paramFromServiceMsg = BaseApplication.getContext().getSharedPreferences("unreadcount", 0);
        paramFromServiceMsg.edit();
        i1 = paramFromServiceMsg.getInt("unread", -5);
        int i2 = this.z.size();
        b.d(BaseApplication.getContext(), i1 + i2);
        return;
      }
      catch (Exception paramFromServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MSF.C.PushManager", 2, "onRecvPbPushOffMsg decode error:" + paramFromServiceMsg, paramFromServiceMsg);
      return;
      label433:
      if (localPbPushOffMsg.msg_type.get() == 528)
      {
        a(localPbPushOffMsg);
      }
      else
      {
        this.z.add(localObject);
        c(false);
      }
    }
  }
  
  public void d()
  {
    synchronized (this.r)
    {
      this.r.notify();
      n = false;
      return;
    }
  }
  
  public long e()
  {
    if (this.v == 0L) {
      return 300000L;
    }
    return this.v;
  }
  
  void f()
  {
    Iterator localIterator = this.g.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.g.get(localObject);
      if (localObject != null)
      {
        try
        {
          long l1 = System.currentTimeMillis();
          if ((((a)localObject).f == 0L) || (l1 - ((a)localObject).f <= 25200000L)) {
            break label116;
          }
          a((a)localObject, j.d);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          QLog.w("MSF.C.PushManager", 2, localException.toString(), localException);
          continue;
          label116:
          if ((n) && (localException.i != null) && (this.b.nowSocketConnAdd != null) && (localException.i.equals(this.b.nowSocketConnAdd)))
          {
            this.h.a(localException, false);
          }
          else
          {
            ToServiceMsg localToServiceMsg;
            if (this.b.nowSocketConnAdd == null)
            {
              localToServiceMsg = MsfMsgUtil.getConnOpenMsg("");
              MsfSdkUtils.addToMsgProcessName("", localToServiceMsg);
              this.b.sendSsoMsg(localToServiceMsg);
              a(e());
            }
            else
            {
              a(localToServiceMsg, j.e);
            }
          }
        }
      }
    }
  }
  
  public long g()
  {
    return this.af;
  }
  
  public boolean h()
  {
    AudioManager localAudioManager = (AudioManager)BaseApplication.getContext().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 0);
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationClearAll");
    }
    this.z.clear();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationClearAllAV");
    }
    this.A.clear();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearOfflinePushNotification");
    }
    ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(w);
    this.z.clear();
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearOfflinePushNotificationAV");
    }
    ((NotificationManager)BaseApplication.getContext().getSystemService("notification")).cancel(x);
    this.A.clear();
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onNotificationBroadcast");
    }
    Context localContext = BaseApplication.getContext();
    ((NotificationManager)localContext.getSystemService("notification")).cancel(w);
    this.z.clear();
    try
    {
      if (b())
      {
        localIntent = new Intent("com.tencent.mobileqqi.action.MAINACTIVITY");
        localIntent.addFlags(268435456);
        localContext.startActivity(localIntent);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "uin kicked out");
      }
      Intent localIntent = new Intent("com.tencent.mobileqqi.action.MAINACTIVITY");
      localIntent.addFlags(268435456);
      localContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager", 2, "Start QQ failed" + localException);
      }
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "onAVNotificationBroadcast");
    }
    Context localContext = BaseApplication.getContext();
    ((NotificationManager)localContext.getSystemService("notification")).cancel(x);
    this.A.clear();
    try
    {
      Intent localIntent = new Intent("com.tencent.mobileqqi.action.MAINACTIVITY");
      localIntent.addFlags(268435456);
      localContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSF.C.PushManager", 2, "Start QQ failed" + localException);
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "clearDevlockQuickloginNotification");
    }
    NotificationManager localNotificationManager = (NotificationManager)BaseApplication.getContext().getSystemService("notification");
    if (localNotificationManager != null) {
      localNotificationManager.cancel(y);
    }
  }
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager", 2, "alarm receive " + paramIntent);
    }
    synchronized (this.r)
    {
      this.r.notify();
      return;
    }
  }
  
  class a
  {
    public offlinepush.PbPushOffMsg a;
    public int b;
    
    a() {}
  }
  
  class b
    extends Thread
  {
    b() {}
    
    public void run()
    {
      synchronized (e.this.r)
      {
        try
        {
          e.this.r.wait();
          e.this.f();
          com.tencent.mobileqq.msf.core.d.f.e();
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("MSF.C.PushManager", 2, localInterruptedException.toString(), localInterruptedException);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.e
 * JD-Core Version:    0.7.0.1
 */