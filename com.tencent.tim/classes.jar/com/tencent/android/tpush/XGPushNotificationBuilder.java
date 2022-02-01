package com.tencent.android.tpush;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.json.JSONObject;

public abstract class XGPushNotificationBuilder
{
  public static final String BASIC_NOTIFICATION_BUILDER_TYPE = "basic";
  public static final String CUSTOM_NOTIFICATION_BUILDER_TYPE = "custom";
  protected String A = null;
  private String B = "xg-channle-id";
  private boolean C = false;
  protected String a = "xg-channle-id";
  protected String b = "message";
  protected Integer c = null;
  protected PendingIntent d = null;
  protected RemoteViews e = null;
  protected RemoteViews f = null;
  protected Integer g = null;
  protected PendingIntent h = null;
  protected Integer i = null;
  protected Integer j = null;
  protected Integer k = null;
  protected Integer l = null;
  protected Integer m = null;
  protected Integer n = null;
  protected Integer o = null;
  protected Uri p = null;
  protected CharSequence q = null;
  protected long[] r = null;
  protected Long s = null;
  protected Integer t = null;
  protected Bitmap u = null;
  protected Integer v = null;
  protected String w;
  protected Integer x = null;
  protected Bitmap y = null;
  protected Integer z = null;
  
  private Object a(Notification.Builder paramBuilder, Context paramContext)
  {
    localObject2 = null;
    try
    {
      localObject5 = getChannelId(paramContext);
      if (!((String)localObject5).equals("xg-channle-id")) {
        break label959;
      }
      localObject3 = Class.forName("android.media.AudioAttributes");
      localObject2 = Class.forName("android.app.NotificationChannel").getConstructor(new Class[] { String.class, CharSequence.class, Integer.TYPE });
      if (this.g == null) {
        this.g = Integer.valueOf(0);
      }
      switch (this.g.intValue())
      {
      }
    }
    catch (Throwable paramBuilder)
    {
      for (;;)
      {
        Object localObject5;
        try
        {
          Object localObject3;
          label959:
          TLogger.ee("XGPushNotificationBuilder", "XGPushNotification getNotificationChannel Error: " + localThrowable1.getMessage());
          localObject2 = localObject1;
          localThrowable1.printStackTrace();
          localObject2 = localObject1;
          localObject4 = Class.forName("android.media.AudioAttributes");
          localObject2 = localObject1;
          localObject1 = Class.forName("android.app.NotificationChannel").getConstructor(new Class[] { String.class, CharSequence.class, Integer.TYPE }).newInstance(new Object[] { localObject5, getChannelName(paramContext), Integer.valueOf(4) });
          paramContext = (Context)localObject1;
          localObject2 = localObject1.getClass().getMethod("setSound", new Class[] { Uri.class, localObject4 });
          paramContext = (Context)localObject1;
          localObject4 = localObject1.getClass().getMethod("enableVibration", new Class[] { Boolean.TYPE });
          paramContext = (Context)localObject1;
          Method localMethod = localObject1.getClass().getMethod("enableLights", new Class[] { Boolean.TYPE });
          paramContext = (Context)localObject1;
          if (this.g != null)
          {
            paramContext = (Context)localObject1;
            if ((this.g.intValue() & 0x1) != 1)
            {
              paramContext = (Context)localObject1;
              ((Method)localObject2).invoke(localObject1, new Object[] { null, null });
            }
            paramContext = (Context)localObject1;
            if ((this.g.intValue() & 0x2) == 2)
            {
              paramContext = (Context)localObject1;
              ((Method)localObject4).invoke(localObject1, new Object[] { Boolean.valueOf(true) });
              paramContext = (Context)localObject1;
              if ((this.g.intValue() & 0x4) == 4)
              {
                paramContext = (Context)localObject1;
                localMethod.invoke(localObject1, new Object[] { Boolean.valueOf(true) });
                paramContext = (Context)localObject1;
                if (this.i != null)
                {
                  paramContext = (Context)localObject1;
                  localMethod.invoke(localObject1, new Object[] { Boolean.valueOf(true) });
                }
                paramContext = (Context)localObject1;
                if (this.p != null)
                {
                  paramContext = (Context)localObject1;
                  ((Method)localObject2).invoke(localObject1, new Object[] { this.p, null });
                }
                paramContext = (Context)localObject1;
                paramBuilder.getClass().getMethod("setChannelId", new Class[] { String.class }).invoke(paramBuilder, new Object[] { localObject5 });
                return localObject1;
              }
            }
            else
            {
              paramContext = (Context)localObject1;
              ((Method)localObject4).invoke(localObject1, new Object[] { Boolean.valueOf(false) });
              continue;
            }
            paramContext = (Context)localObject1;
            localMethod.invoke(localObject1, new Object[] { Boolean.valueOf(false) });
            continue;
          }
          paramContext = (Context)localObject1;
          ((Method)localObject2).invoke(localObject1, new Object[] { null, null });
          paramContext = (Context)localObject1;
          ((Method)localObject4).invoke(localObject1, new Object[] { Boolean.valueOf(false) });
          paramContext = (Context)localObject1;
          localMethod.invoke(localObject1, new Object[] { Boolean.valueOf(false) });
          continue;
          paramBuilder = paramBuilder;
          paramContext = null;
        }
        catch (Throwable paramBuilder)
        {
          paramContext = (Context)localObject2;
        }
        continue;
        continue;
        Object localObject1 = localObject5;
        continue;
        continue;
        localObject1 = "xg-s-channle-id";
        continue;
        localObject1 = "xg-v-channle-id";
        continue;
        localObject1 = "xg-s-v-channle-id";
        continue;
        localObject1 = "xg-l-channle-id";
        continue;
        localObject1 = "xg-s-l-channle-id";
        continue;
        localObject1 = "xg-l-v-channle-id";
      }
    }
    if (this.p != null)
    {
      localObject1 = getChannelId(paramContext) + "-" + b(paramContext);
      TLogger.i("XGPushNotificationBuilder", "XGPushNotification create notificationChannle, channelId:" + (String)localObject1 + ", channelName:" + getChannelName(paramContext));
      localObject2 = ((Constructor)localObject2).newInstance(new Object[] { localObject1, getChannelName(paramContext), Integer.valueOf(4) });
      paramContext = (Context)localObject2;
      for (;;)
      {
        try
        {
          localObject3 = localObject2.getClass().getMethod("setSound", new Class[] { Uri.class, localObject3 });
          paramContext = (Context)localObject2;
          localObject5 = localObject2.getClass().getMethod("enableVibration", new Class[] { Boolean.TYPE });
          paramContext = (Context)localObject2;
          localMethod = localObject2.getClass().getMethod("enableLights", new Class[] { Boolean.TYPE });
          paramContext = (Context)localObject2;
          switch (this.g.intValue())
          {
          case 0: 
            paramContext = (Context)localObject2;
            if (this.p != null)
            {
              paramContext = (Context)localObject2;
              ((Method)localObject3).invoke(localObject2, new Object[] { this.p, null });
            }
            paramContext = (Context)localObject2;
            paramBuilder.getClass().getMethod("setChannelId", new Class[] { String.class }).invoke(paramBuilder, new Object[] { localObject1 });
            paramContext = (Context)localObject2;
            this.B = ((String)localObject1);
            return localObject2;
          }
        }
        catch (Throwable paramBuilder) {}
        localObject1 = "xg-n-channle-id";
        break;
        localObject1 = "xg-channle-id";
        break;
        paramContext = (Context)localObject2;
        ((Method)localObject3).invoke(localObject2, new Object[] { null, null });
        paramContext = (Context)localObject2;
        ((Method)localObject5).invoke(localObject2, new Object[] { Boolean.valueOf(false) });
        paramContext = (Context)localObject2;
        localMethod.invoke(localObject2, new Object[] { Boolean.valueOf(false) });
        continue;
        TLogger.ee("XGPushNotificationBuilder", "XGPushNotification create channel Error: " + paramBuilder.getMessage());
        paramBuilder.printStackTrace();
        return paramContext;
        paramContext = (Context)localObject2;
        ((Method)localObject5).invoke(localObject2, new Object[] { Boolean.valueOf(false) });
        paramContext = (Context)localObject2;
        localMethod.invoke(localObject2, new Object[] { Boolean.valueOf(false) });
        continue;
        paramContext = (Context)localObject2;
        ((Method)localObject3).invoke(localObject2, new Object[] { null, null });
        paramContext = (Context)localObject2;
        ((Method)localObject5).invoke(localObject2, new Object[] { Boolean.valueOf(true) });
        paramContext = (Context)localObject2;
        localMethod.invoke(localObject2, new Object[] { Boolean.valueOf(false) });
        continue;
        paramContext = (Context)localObject2;
        ((Method)localObject5).invoke(localObject2, new Object[] { Boolean.valueOf(true) });
        paramContext = (Context)localObject2;
        localMethod.invoke(localObject2, new Object[] { Boolean.valueOf(false) });
        continue;
        paramContext = (Context)localObject2;
        ((Method)localObject3).invoke(localObject2, new Object[] { null, null });
        paramContext = (Context)localObject2;
        ((Method)localObject5).invoke(localObject2, new Object[] { Boolean.valueOf(false) });
        paramContext = (Context)localObject2;
        localMethod.invoke(localObject2, new Object[] { Boolean.valueOf(true) });
        continue;
        paramContext = (Context)localObject2;
        ((Method)localObject5).invoke(localObject2, new Object[] { Boolean.valueOf(false) });
        paramContext = (Context)localObject2;
        localMethod.invoke(localObject2, new Object[] { Boolean.valueOf(true) });
        continue;
        paramContext = (Context)localObject2;
        ((Method)localObject3).invoke(localObject2, new Object[] { null, null });
        paramContext = (Context)localObject2;
        ((Method)localObject5).invoke(localObject2, new Object[] { Boolean.valueOf(true) });
        paramContext = (Context)localObject2;
        localMethod.invoke(localObject2, new Object[] { Boolean.valueOf(true) });
        continue;
        paramContext = (Context)localObject2;
        ((Method)localObject5).invoke(localObject2, new Object[] { Boolean.valueOf(true) });
        paramContext = (Context)localObject2;
        localMethod.invoke(localObject2, new Object[] { Boolean.valueOf(true) });
      }
      TLogger.i("XGPushNotificationBuilder", "XGPushNotification create notificationChannle has channelId:" + (String)localObject5);
      try
      {
        localObject1 = (NotificationManager)paramContext.getSystemService("notification");
        localObject1 = localObject1.getClass().getMethod("getNotificationChannel", new Class[] { String.class }).invoke(localObject1, new Object[] { this.a });
        try
        {
          this.B = this.a;
          if (localObject1 == null) {
            break label1685;
          }
          TLogger.ii("XGPushNotificationBuilder", "Use old notificationChannel id:" + this.a);
          paramBuilder.getClass().getMethod("setChannelId", new Class[] { String.class }).invoke(paramBuilder, new Object[] { this.a });
          return localObject1;
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject4;
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
    }
  }
  
  private int b(Context paramContext)
  {
    int i1 = SharePrefsUtil.getInt(paramContext, "tpush.sound.channel.count", 0);
    SharePrefsUtil.setInt(paramContext, "tpush.sound.channel.count", i1 + 1);
    return i1;
  }
  
  private Notification c(Context paramContext)
  {
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
    NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
    if (this.t != null) {
      localBuilder.setSmallIcon(this.t.intValue());
    }
    if ((this.z != null) && (this.z.intValue() > 0)) {
      localBuilder.setColor(this.z.intValue());
    }
    if (this.v != null) {}
    try
    {
      localBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), this.v.intValue()));
      if (this.u != null) {
        localBuilder.setLargeIcon(this.u);
      }
      if (this.w == null)
      {
        this.w = getTitle(paramContext);
        if ((this.q == null) || (this.e != null)) {
          break label271;
        }
        localBigTextStyle.bigText(this.q);
        localBuilder.setStyle(localBigTextStyle);
        localBuilder.setContentText(this.q);
        localBuilder.setTicker(this.q);
        if (this.y == null) {}
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        for (;;)
        {
          localBuilder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(this.y));
          if ((this.A != null) && (Build.VERSION.SDK_INT >= 24)) {
            localBuilder.setGroup(this.A);
          }
          return localBuilder.build();
          localOutOfMemoryError = localOutOfMemoryError;
          TLogger.w("XGPushNotificationBuilder", "getNotificationCompatBuilder setLargeIcon res oom " + localOutOfMemoryError.toString());
          continue;
          localBuilder.setContentTitle(this.w);
        }
        label271:
        localBuilder.setContentText(this.q);
        localBuilder.setTicker(this.q);
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          TLogger.w("XGPushNotificationBuilder", "getNotificationCompatBuilder setStyle error " + paramContext.toString());
        }
      }
    }
  }
  
  public static void createNotificationChannel(Context paramContext, Object paramObject)
  {
    TLogger.d("XGPushNotificationBuilder", "createNotificationChannel");
    if (paramObject != null) {}
    try
    {
      Class localClass = Class.forName("android.app.NotificationChannel");
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      paramContext.getClass().getMethod("createNotificationChannel", new Class[] { localClass }).invoke(paramContext, new Object[] { paramObject });
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.ee("XGPushNotificationBuilder", "XGPushNotification createNotificationChannel Error: ", paramContext);
    }
  }
  
  protected Pair<Notification, Object> a(Context paramContext)
  {
    Object localObject = null;
    if (this.x == null) {
      this.x = Integer.valueOf(0);
    }
    TLogger.ii("XGPushNotificationBuilder", "XGPushNotification Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT + ", targetSDK:" + paramContext.getApplicationInfo().targetSdkVersion);
    if ((Build.VERSION.SDK_INT >= 26) && ((paramContext.getApplicationInfo().targetSdkVersion >= 26) || (this.C)))
    {
      localObject = getChannelNotification(paramContext);
      paramContext = (Notification)((Pair)localObject).first;
      localObject = ((Pair)localObject).second;
      if (this.c != null) {
        paramContext.audioStreamType = this.c.intValue();
      }
      if (this.d != null) {
        paramContext.contentIntent = this.d;
      }
      if (this.e != null)
      {
        if (!"oppo".equals(Build.MANUFACTURER.trim().toLowerCase())) {
          break label398;
        }
        TLogger.ww("XGPushNotificationBuilder", "XGPushNotification: Oppo Rom not allow custom contentview. Not set it");
      }
      label172:
      if (this.g != null) {
        paramContext.defaults = this.g.intValue();
      }
      if (this.j != null) {
        paramContext.icon = this.j.intValue();
      }
      if (this.h != null) {
        paramContext.deleteIntent = this.h;
      }
      if (this.i == null) {
        break label409;
      }
      paramContext.flags = this.i.intValue();
      label241:
      if (this.k != null) {
        paramContext.iconLevel = this.k.intValue();
      }
      if (this.l != null) {
        paramContext.ledARGB = this.l.intValue();
      }
      if (this.m != null) {
        paramContext.ledOffMS = this.m.intValue();
      }
      if (this.n != null) {
        paramContext.ledOnMS = this.n.intValue();
      }
      if (this.o != null) {
        paramContext.number = this.o.intValue();
      }
      if (this.p != null) {
        paramContext.sound = this.p;
      }
      if (this.r != null) {
        paramContext.vibrate = this.r;
      }
      if (this.s == null) {
        break label418;
      }
    }
    label398:
    label409:
    label418:
    for (paramContext.when = this.s.longValue();; paramContext.when = System.currentTimeMillis())
    {
      return new Pair(paramContext, localObject);
      paramContext = c(paramContext);
      break;
      paramContext.contentView = this.e;
      break label172;
      paramContext.flags = 16;
      break label241;
    }
  }
  
  protected abstract void a(JSONObject paramJSONObject);
  
  protected abstract void b(JSONObject paramJSONObject);
  
  public abstract Pair<Notification, Object> buildNotification(Context paramContext);
  
  public void decode(String paramString)
  {
    paramString = new JSONObject(paramString);
    b(paramString);
    this.c = ((Integer)CommonHelper.jsonGet(paramString, "audioStringType", null));
    this.g = ((Integer)CommonHelper.jsonGet(paramString, "defaults", null));
    this.i = ((Integer)CommonHelper.jsonGet(paramString, "flags", null));
    this.j = ((Integer)CommonHelper.jsonGet(paramString, "icon", null));
    this.k = ((Integer)CommonHelper.jsonGet(paramString, "iconLevel", null));
    this.l = ((Integer)CommonHelper.jsonGet(paramString, "ledARGB", null));
    this.m = ((Integer)CommonHelper.jsonGet(paramString, "ledOffMS", null));
    this.n = ((Integer)CommonHelper.jsonGet(paramString, "ledOnMS", null));
    this.o = ((Integer)CommonHelper.jsonGet(paramString, "number", null));
    Object localObject = (String)CommonHelper.jsonGet(paramString, "sound", null);
    this.t = ((Integer)CommonHelper.jsonGet(paramString, "smallIcon", null));
    this.v = ((Integer)CommonHelper.jsonGet(paramString, "notificationLargeIcon", null));
    if (localObject != null) {
      this.p = Uri.parse((String)localObject);
    }
    localObject = (String)CommonHelper.jsonGet(paramString, "vibrate", null);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(",");
      int i2 = localObject.length;
      this.r = new long[i2];
      int i1 = 0;
      for (;;)
      {
        if (i1 < i2) {
          try
          {
            this.r[i1] = Long.valueOf(localObject[i1]).longValue();
            i1 += 1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              TLogger.w("XGPushNotificationBuilder", "parse vibrate str error " + localNumberFormatException.toString());
            }
          }
        }
      }
    }
    this.x = ((Integer)CommonHelper.jsonGet(paramString, "notificationId", null));
    this.A = ((String)CommonHelper.jsonGet(paramString, "thread_id", null));
  }
  
  public void encode(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
    CommonHelper.jsonPut(paramJSONObject, "audioStringType", this.c);
    CommonHelper.jsonPut(paramJSONObject, "defaults", this.g);
    CommonHelper.jsonPut(paramJSONObject, "flags", this.i);
    CommonHelper.jsonPut(paramJSONObject, "icon", this.j);
    CommonHelper.jsonPut(paramJSONObject, "iconLevel", this.k);
    CommonHelper.jsonPut(paramJSONObject, "ledARGB", this.l);
    CommonHelper.jsonPut(paramJSONObject, "ledOffMS", this.m);
    CommonHelper.jsonPut(paramJSONObject, "ledOnMS", this.n);
    CommonHelper.jsonPut(paramJSONObject, "number", this.o);
    CommonHelper.jsonPut(paramJSONObject, "sound", this.p);
    CommonHelper.jsonPut(paramJSONObject, "smallIcon", this.t);
    CommonHelper.jsonPut(paramJSONObject, "notificationLargeIcon", this.v);
    if (this.r != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i1 = 0;
      while (i1 < this.r.length)
      {
        localStringBuilder.append(String.valueOf(this.r[i1]));
        if (i1 != this.r.length - 1) {
          localStringBuilder.append(",");
        }
        i1 += 1;
      }
      CommonHelper.jsonPut(paramJSONObject, "vibrate", localStringBuilder.toString());
    }
    CommonHelper.jsonPut(paramJSONObject, "notificationId", this.x);
    CommonHelper.jsonPut(paramJSONObject, "thread_id", this.A);
  }
  
  public int getApplicationIcon(Context paramContext)
  {
    return paramContext.getApplicationInfo().icon;
  }
  
  public int getAudioStringType()
  {
    return this.c.intValue();
  }
  
  public String getChannelId(Context paramContext)
  {
    if (this.a.equals("xg-channle-id"))
    {
      paramContext = XGPushConfig.getNotificationChannelID(paramContext);
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext))) {
        return paramContext;
      }
    }
    return this.a;
  }
  
  public String getChannelName(Context paramContext)
  {
    if (this.b.equals("message"))
    {
      paramContext = XGPushConfig.getNotificationChannelName(paramContext);
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext))) {
        return paramContext;
      }
    }
    return this.b;
  }
  
  @SuppressLint({"NewApi"})
  public Pair<Notification, Object> getChannelNotification(Context paramContext)
  {
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    Notification.BigTextStyle localBigTextStyle = new Notification.BigTextStyle();
    if (this.t != null) {
      localBuilder.setSmallIcon(this.t.intValue());
    }
    if ((this.z != null) && (this.z.intValue() > 0)) {
      localBuilder.setColor(this.z.intValue());
    }
    if (this.v != null) {}
    try
    {
      localBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), this.v.intValue()));
      if (this.u != null) {
        localBuilder.setLargeIcon(this.u);
      }
      if (this.w == null)
      {
        this.w = getTitle(paramContext);
        if ((this.q == null) || (this.e != null)) {
          break label278;
        }
        localBigTextStyle.bigText(this.q);
        localBuilder.setStyle(localBigTextStyle);
        localBuilder.setContentText(this.q);
        localBuilder.setTicker(this.q);
        if (this.y == null) {}
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        for (;;)
        {
          localBuilder.setStyle(new Notification.BigPictureStyle().bigPicture(this.y));
          if (this.A != null) {
            localBuilder.setGroup(this.A);
          }
          paramContext = a(localBuilder, paramContext);
          return new Pair(localBuilder.build(), paramContext);
          localOutOfMemoryError = localOutOfMemoryError;
          TLogger.w("XGPushNotificationBuilder", "getChannelNotification setLargeIcon res oom " + localOutOfMemoryError.toString());
          continue;
          localBuilder.setContentTitle(this.w);
        }
        label278:
        localBuilder.setContentText(this.q);
        localBuilder.setTicker(this.q);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          TLogger.w("XGPushNotificationBuilder", "getChannelNotification setStyle error " + localThrowable.toString());
        }
      }
    }
  }
  
  public PendingIntent getContentIntent()
  {
    return this.d;
  }
  
  public String getCurrentChannelId()
  {
    if ((this.B != null) && (this.B.length() > 0)) {
      return this.B;
    }
    return "xg-channle-id";
  }
  
  public int getDefaults()
  {
    return this.g.intValue();
  }
  
  public int getFlags()
  {
    return this.i.intValue();
  }
  
  public Integer getIcon()
  {
    return this.j;
  }
  
  public int getIconLevel()
  {
    return this.k.intValue();
  }
  
  public Bitmap getLargeIcon()
  {
    return this.u;
  }
  
  public int getLedARGB()
  {
    return this.l.intValue();
  }
  
  public int getLedOffMS()
  {
    return this.m.intValue();
  }
  
  public int getLedOnMS()
  {
    return this.n.intValue();
  }
  
  public Integer getNotificationLargeIcon()
  {
    return this.v;
  }
  
  public int getNumber()
  {
    return this.o.intValue();
  }
  
  public Bitmap getRichIcon()
  {
    return this.y;
  }
  
  public Integer getSmallIcon()
  {
    return this.t;
  }
  
  public Uri getSound()
  {
    return this.p;
  }
  
  public String getThread_id()
  {
    return this.A;
  }
  
  public CharSequence getTickerText()
  {
    return this.q;
  }
  
  public String getTitle(Context paramContext)
  {
    if (this.w == null)
    {
      ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
      this.w = ((String)paramContext.getApplicationContext().getPackageManager().getApplicationLabel(localApplicationInfo));
    }
    return this.w;
  }
  
  public abstract String getType();
  
  public long[] getVibrate()
  {
    return this.r;
  }
  
  public long getWhen()
  {
    return this.s.longValue();
  }
  
  public XGPushNotificationBuilder setAudioStringType(int paramInt)
  {
    this.c = Integer.valueOf(paramInt);
    return this;
  }
  
  public void setChannelId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setChannelName(String paramString)
  {
    this.b = paramString;
  }
  
  public XGPushNotificationBuilder setColor(Integer paramInteger)
  {
    this.z = paramInteger;
    return this;
  }
  
  public XGPushNotificationBuilder setContentIntent(PendingIntent paramPendingIntent)
  {
    this.d = paramPendingIntent;
    return this;
  }
  
  public XGPushNotificationBuilder setContentView(RemoteViews paramRemoteViews)
  {
    this.e = paramRemoteViews;
    return this;
  }
  
  public XGPushNotificationBuilder setDefaults(int paramInt)
  {
    if (this.g == null)
    {
      this.g = Integer.valueOf(paramInt);
      return this;
    }
    this.g = Integer.valueOf(this.g.intValue() | paramInt);
    return this;
  }
  
  public XGPushNotificationBuilder setFlags(int paramInt)
  {
    if (this.i == null)
    {
      this.i = Integer.valueOf(paramInt);
      return this;
    }
    this.i = Integer.valueOf(this.i.intValue() | paramInt);
    return this;
  }
  
  public XGPushNotificationBuilder setIcon(Integer paramInteger)
  {
    this.j = paramInteger;
    return this;
  }
  
  public XGPushNotificationBuilder setIconLevel(int paramInt)
  {
    this.k = Integer.valueOf(paramInt);
    return this;
  }
  
  public XGPushNotificationBuilder setLargeIcon(Bitmap paramBitmap)
  {
    this.u = paramBitmap;
    return this;
  }
  
  public XGPushNotificationBuilder setLedARGB(int paramInt)
  {
    this.l = Integer.valueOf(paramInt);
    return this;
  }
  
  public XGPushNotificationBuilder setLedOffMS(int paramInt)
  {
    this.m = Integer.valueOf(paramInt);
    return this;
  }
  
  public XGPushNotificationBuilder setLedOnMS(int paramInt)
  {
    this.n = Integer.valueOf(paramInt);
    return this;
  }
  
  public XGPushNotificationBuilder setNotificationLargeIcon(int paramInt)
  {
    this.v = Integer.valueOf(paramInt);
    return this;
  }
  
  public XGPushNotificationBuilder setNumber(int paramInt)
  {
    this.o = Integer.valueOf(paramInt);
    return this;
  }
  
  public XGPushNotificationBuilder setRichIcon(Bitmap paramBitmap)
  {
    this.y = paramBitmap;
    return this;
  }
  
  public void setRunAsSysAndAndBuildSdk26(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public XGPushNotificationBuilder setSmallIcon(Integer paramInteger)
  {
    this.t = paramInteger;
    return this;
  }
  
  public XGPushNotificationBuilder setSound(Uri paramUri)
  {
    this.p = paramUri;
    return this;
  }
  
  public void setThread_id(String paramString)
  {
    this.A = paramString;
  }
  
  public XGPushNotificationBuilder setTickerText(CharSequence paramCharSequence)
  {
    this.q = paramCharSequence;
    return this;
  }
  
  public void setTitle(String paramString)
  {
    this.w = paramString;
  }
  
  public XGPushNotificationBuilder setVibrate(long[] paramArrayOfLong)
  {
    this.r = paramArrayOfLong;
    return this;
  }
  
  public XGPushNotificationBuilder setWhen(long paramLong)
  {
    this.s = Long.valueOf(paramLong);
    return this;
  }
  
  public XGPushNotificationBuilder setbigContentView(RemoteViews paramRemoteViews)
  {
    this.f = paramRemoteViews;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushNotificationBuilder
 * JD-Core Version:    0.7.0.1
 */