package com.tencent.android.tpush.message;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.jg.JgMethodChecked;
import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.TpnsActivity;
import com.tencent.android.tpush.XGBasicPushNotificationBuilder;
import com.tencent.android.tpush.XGCustomPushNotificationBuilder;
import com.tencent.android.tpush.XGNotifaction;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushNotifactionCallback;
import com.tencent.android.tpush.XGPushNotificationBuilder;
import com.tencent.android.tpush.XGSysNotifaction;
import com.tencent.android.tpush.XGSysPushNotifactionCallback;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.f.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static volatile BroadcastReceiver a = null;
  private static volatile BroadcastReceiver b = null;
  private static MediaPlayer c;
  
  private static Notification a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
    localBuilder.setGroup(paramString3).setGroupSummary(true).setAutoCancel(true);
    if (Build.VERSION.SDK_INT >= 26) {}
    try
    {
      localBuilder.getClass().getMethod("setChannelId", new Class[] { String.class }).invoke(localBuilder, new Object[] { paramString2 });
      if (paramInt1 > 0)
      {
        localBuilder.setSmallIcon(paramInt1);
        if (paramInt2 > 0) {
          localBuilder.setColor(paramInt2);
        }
        if (!TextUtils.isEmpty(paramString4)) {
          localBuilder.setStyle(new NotificationCompat.BigTextStyle().setSummaryText(paramString4));
        }
        if (ChannelUtils.isBrandBlackShark())
        {
          if (TextUtils.isEmpty(paramString1)) {
            break label172;
          }
          localBuilder.setContentTitle(paramString1);
        }
        return localBuilder.build();
      }
    }
    catch (Throwable paramString2)
    {
      for (;;)
      {
        TLogger.e("MessageHelper", "NotificationGroup setChannelId error", paramString2);
        continue;
        localBuilder.setSmallIcon(paramContext.getApplicationInfo().icon);
        continue;
        label172:
        localBuilder.setContentTitle(" ");
      }
    }
  }
  
  public static Intent a(Context paramContext, d.a parama, boolean paramBoolean1, PushMessageManager paramPushMessageManager, boolean paramBoolean2)
  {
    Intent localIntent = null;
    Object localObject1 = null;
    Object localObject2 = NotificationAction.getNotificationAction(parama.a);
    if (localObject2 == null) {
      return localObject1;
    }
    switch (b.3.a[localObject2.ordinal()])
    {
    default: 
      TLogger.e("MessageHelper", "getIntentByOpenType unknown action_type: " + parama.a);
      paramContext = localIntent;
    }
    for (;;)
    {
      if (paramContext != null)
      {
        paramContext.putExtra("action_confirm", parama.g);
        paramContext.putExtra("msgId", paramPushMessageManager.getMsgId());
        paramContext.putExtra("busiMsgId", paramPushMessageManager.getBusiMsgId());
        paramContext.putExtra("pushTime", paramPushMessageManager.pushTime);
        paramContext.putExtra("pushChannel", paramPushMessageManager.pushChannel);
        paramContext.putExtra("groupId", paramPushMessageManager.getGroupId());
        paramContext.putExtra("targetType", paramPushMessageManager.getTargetType());
        paramContext.putExtra("source", paramPushMessageManager.getSource());
      }
      localObject1 = paramContext;
      if (paramContext == null) {
        break;
      }
      localObject1 = paramContext;
      if (!paramBoolean2) {
        break;
      }
      if ((parama.c != null) && (parama.c.a > 0)) {
        break label686;
      }
      paramContext.setFlags(67108864);
      return paramContext;
      localIntent = new Intent("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE");
      localObject2 = parama.b;
      localObject1 = localObject2;
      if (i.b((String)localObject2)) {
        localObject1 = b(paramContext);
      }
      if ((parama.c == null) || (parama.c.a <= 0))
      {
        if (paramBoolean1) {}
        localIntent.setFlags(67108864);
      }
      for (;;)
      {
        localIntent.putExtra("activity", (String)localObject1);
        localIntent.putExtra("notificationActionType", NotificationAction.activity.getType());
        localIntent.putExtra("action_type", NotificationAction.activity.getType());
        localIntent.putExtra("PUSH.CHANNEL", paramPushMessageManager.pushChannel);
        localIntent.setClass(paramContext, TpnsActivity.class);
        paramContext = localIntent;
        break;
        localIntent.setFlags(parama.c.a);
      }
      localObject1 = new Intent("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE");
      ((Intent)localObject1).putExtra("activity", parama.f);
      ((Intent)localObject1).putExtra("action_type", parama.a);
      ((Intent)localObject1).putExtra("notificationActionType", NotificationAction.url.getType());
      ((Intent)localObject1).putExtra("PUSH.CHANNEL", paramPushMessageManager.pushChannel);
      ((Intent)localObject1).setClass(paramContext, TpnsActivity.class);
      paramContext = (Context)localObject1;
      continue;
      localObject1 = new Intent("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE");
      ((Intent)localObject1).putExtra("activity", parama.d);
      ((Intent)localObject1).putExtra("action_type", parama.a);
      if (parama.a == NotificationAction.intent_with_action.getType()) {
        ((Intent)localObject1).putExtra("notificationActionType", NotificationAction.intent_with_action.getType());
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("PUSH.CHANNEL", paramPushMessageManager.pushChannel);
        ((Intent)localObject1).setClass(paramContext, TpnsActivity.class);
        paramContext = (Context)localObject1;
        break;
        ((Intent)localObject1).putExtra("notificationActionType", NotificationAction.intent.getType());
      }
      localIntent = new Intent("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE");
      localObject2 = parama.h;
      localObject1 = localIntent;
      if (i.b((String)localObject2)) {
        break;
      }
      localIntent.putExtra("action_type", parama.a);
      localIntent.putExtra("packageDownloadUrl", parama.j);
      localIntent.putExtra("packageName", (String)localObject2);
      localIntent.putExtra("activity", (String)localObject2);
      localIntent.putExtra("notificationActionType", NotificationAction.action_package.getType());
      localIntent.putExtra("PUSH.CHANNEL", paramPushMessageManager.pushChannel);
      localIntent.setClass(paramContext, TpnsActivity.class);
      paramContext = localIntent;
    }
    label686:
    paramContext.setFlags(parama.c.a);
    return paramContext;
  }
  
  /* Error */
  private static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: new 297	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 298	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 301	java/net/URL:getProtocol	()Ljava/lang/String;
    //   13: invokevirtual 304	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   16: ldc_w 306
    //   19: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +149 -> 171
    //   25: aload_0
    //   26: invokevirtual 314	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   29: checkcast 316	javax/net/ssl/HttpsURLConnection
    //   32: astore_0
    //   33: aload_0
    //   34: checkcast 316	javax/net/ssl/HttpsURLConnection
    //   37: getstatic 322	org/apache/http/conn/ssl/SSLSocketFactory:STRICT_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   40: invokevirtual 326	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   43: getstatic 42	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 20
    //   48: if_icmpge +423 -> 471
    //   51: aload_0
    //   52: checkcast 316	javax/net/ssl/HttpsURLConnection
    //   55: new 328	com/tencent/tpns/baseapi/core/net/TlsCompatSocketFactory
    //   58: dup
    //   59: aload_0
    //   60: checkcast 316	javax/net/ssl/HttpsURLConnection
    //   63: invokevirtual 332	javax/net/ssl/HttpsURLConnection:getSSLSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   66: invokespecial 335	com/tencent/tpns/baseapi/core/net/TlsCompatSocketFactory:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   69: invokevirtual 338	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   72: aload_0
    //   73: sipush 20000
    //   76: invokevirtual 344	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   79: aload_0
    //   80: sipush 20000
    //   83: invokevirtual 347	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   86: aload_0
    //   87: ldc_w 349
    //   90: invokevirtual 352	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   93: aload_0
    //   94: ldc_w 354
    //   97: ldc_w 356
    //   100: invokevirtual 359	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: iconst_1
    //   105: invokevirtual 363	java/net/HttpURLConnection:setDoInput	(Z)V
    //   108: aload_0
    //   109: iconst_0
    //   110: invokevirtual 366	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   113: aload_0
    //   114: ldc_w 368
    //   117: ldc_w 370
    //   120: invokevirtual 359	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_0
    //   124: invokevirtual 373	java/net/HttpURLConnection:getResponseCode	()I
    //   127: istore_1
    //   128: iload_1
    //   129: sipush 200
    //   132: if_icmpeq +53 -> 185
    //   135: iconst_0
    //   136: ifeq +11 -> 147
    //   139: new 375	java/lang/NullPointerException
    //   142: dup
    //   143: invokespecial 376	java/lang/NullPointerException:<init>	()V
    //   146: athrow
    //   147: iconst_0
    //   148: ifeq +11 -> 159
    //   151: new 375	java/lang/NullPointerException
    //   154: dup
    //   155: invokespecial 376	java/lang/NullPointerException:<init>	()V
    //   158: athrow
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 379	java/net/HttpURLConnection:disconnect	()V
    //   167: aconst_null
    //   168: astore_3
    //   169: aload_3
    //   170: areturn
    //   171: aload_0
    //   172: invokevirtual 314	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   175: checkcast 340	java/net/HttpURLConnection
    //   178: astore_0
    //   179: goto -107 -> 72
    //   182: astore_0
    //   183: aconst_null
    //   184: areturn
    //   185: aload_0
    //   186: invokevirtual 383	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   189: astore 4
    //   191: aload 4
    //   193: ifnull +124 -> 317
    //   196: new 385	java/io/ByteArrayOutputStream
    //   199: dup
    //   200: invokespecial 386	java/io/ByteArrayOutputStream:<init>	()V
    //   203: astore_3
    //   204: sipush 1024
    //   207: newarray byte
    //   209: astore_2
    //   210: aload 4
    //   212: aload_2
    //   213: invokevirtual 392	java/io/InputStream:read	([B)I
    //   216: istore_1
    //   217: iload_1
    //   218: iconst_m1
    //   219: if_icmpeq +51 -> 270
    //   222: aload_3
    //   223: aload_2
    //   224: iconst_0
    //   225: iload_1
    //   226: invokevirtual 396	java/io/ByteArrayOutputStream:write	([BII)V
    //   229: goto -19 -> 210
    //   232: astore_2
    //   233: aload_3
    //   234: astore 5
    //   236: aload 4
    //   238: astore_2
    //   239: aload_0
    //   240: astore_3
    //   241: aload 5
    //   243: astore_0
    //   244: aload_2
    //   245: ifnull +7 -> 252
    //   248: aload_2
    //   249: invokevirtual 399	java/io/InputStream:close	()V
    //   252: aload_0
    //   253: ifnull +7 -> 260
    //   256: aload_0
    //   257: invokevirtual 400	java/io/ByteArrayOutputStream:close	()V
    //   260: aload_3
    //   261: ifnull +7 -> 268
    //   264: aload_3
    //   265: invokevirtual 379	java/net/HttpURLConnection:disconnect	()V
    //   268: aconst_null
    //   269: areturn
    //   270: aload_3
    //   271: invokevirtual 404	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   274: iconst_0
    //   275: aload_3
    //   276: invokevirtual 404	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   279: arraylength
    //   280: invokestatic 410	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   283: astore_2
    //   284: aload 4
    //   286: ifnull +8 -> 294
    //   289: aload 4
    //   291: invokevirtual 399	java/io/InputStream:close	()V
    //   294: aload_3
    //   295: ifnull +7 -> 302
    //   298: aload_3
    //   299: invokevirtual 400	java/io/ByteArrayOutputStream:close	()V
    //   302: aload_2
    //   303: astore_3
    //   304: aload_0
    //   305: ifnull -136 -> 169
    //   308: aload_0
    //   309: invokevirtual 379	java/net/HttpURLConnection:disconnect	()V
    //   312: aload_2
    //   313: areturn
    //   314: astore_0
    //   315: aconst_null
    //   316: areturn
    //   317: aload 4
    //   319: ifnull +8 -> 327
    //   322: aload 4
    //   324: invokevirtual 399	java/io/InputStream:close	()V
    //   327: iconst_0
    //   328: ifeq +11 -> 339
    //   331: new 375	java/lang/NullPointerException
    //   334: dup
    //   335: invokespecial 376	java/lang/NullPointerException:<init>	()V
    //   338: athrow
    //   339: aload_0
    //   340: ifnull +7 -> 347
    //   343: aload_0
    //   344: invokevirtual 379	java/net/HttpURLConnection:disconnect	()V
    //   347: aconst_null
    //   348: areturn
    //   349: astore_0
    //   350: aconst_null
    //   351: areturn
    //   352: astore_0
    //   353: aconst_null
    //   354: areturn
    //   355: astore_2
    //   356: aconst_null
    //   357: astore_3
    //   358: aconst_null
    //   359: astore 4
    //   361: aconst_null
    //   362: astore_0
    //   363: aload 4
    //   365: ifnull +8 -> 373
    //   368: aload 4
    //   370: invokevirtual 399	java/io/InputStream:close	()V
    //   373: aload_3
    //   374: ifnull +7 -> 381
    //   377: aload_3
    //   378: invokevirtual 400	java/io/ByteArrayOutputStream:close	()V
    //   381: aload_0
    //   382: ifnull +7 -> 389
    //   385: aload_0
    //   386: invokevirtual 379	java/net/HttpURLConnection:disconnect	()V
    //   389: aload_2
    //   390: athrow
    //   391: astore_0
    //   392: aconst_null
    //   393: areturn
    //   394: astore_2
    //   395: aconst_null
    //   396: astore 4
    //   398: aconst_null
    //   399: astore_3
    //   400: goto -37 -> 363
    //   403: astore_2
    //   404: aconst_null
    //   405: astore_3
    //   406: aconst_null
    //   407: astore 4
    //   409: goto -46 -> 363
    //   412: astore_2
    //   413: aconst_null
    //   414: astore_3
    //   415: goto -52 -> 363
    //   418: astore_2
    //   419: goto -56 -> 363
    //   422: astore_0
    //   423: aconst_null
    //   424: astore_0
    //   425: aconst_null
    //   426: astore_2
    //   427: aconst_null
    //   428: astore_3
    //   429: goto -185 -> 244
    //   432: astore_2
    //   433: aconst_null
    //   434: astore_2
    //   435: aload_0
    //   436: astore_3
    //   437: aconst_null
    //   438: astore_0
    //   439: goto -195 -> 244
    //   442: astore_2
    //   443: aconst_null
    //   444: astore 4
    //   446: aconst_null
    //   447: astore_2
    //   448: aload_0
    //   449: astore_3
    //   450: aload 4
    //   452: astore_0
    //   453: goto -209 -> 244
    //   456: astore_2
    //   457: aconst_null
    //   458: astore 5
    //   460: aload 4
    //   462: astore_2
    //   463: aload_0
    //   464: astore_3
    //   465: aload 5
    //   467: astore_0
    //   468: goto -224 -> 244
    //   471: goto -399 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	paramString	String
    //   127	99	1	i	int
    //   209	15	2	arrayOfByte	byte[]
    //   232	1	2	localThrowable1	Throwable
    //   238	75	2	localObject1	Object
    //   355	35	2	localObject2	Object
    //   394	1	2	localObject3	Object
    //   403	1	2	localObject4	Object
    //   412	1	2	localObject5	Object
    //   418	1	2	localObject6	Object
    //   426	1	2	localObject7	Object
    //   432	1	2	localThrowable2	Throwable
    //   434	1	2	localObject8	Object
    //   442	1	2	localThrowable3	Throwable
    //   447	1	2	localObject9	Object
    //   456	1	2	localThrowable4	Throwable
    //   462	1	2	localInputStream1	java.io.InputStream
    //   168	297	3	localObject10	Object
    //   189	272	4	localInputStream2	java.io.InputStream
    //   234	232	5	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   139	147	182	java/io/IOException
    //   151	159	182	java/io/IOException
    //   163	167	182	java/io/IOException
    //   204	210	232	java/lang/Throwable
    //   210	217	232	java/lang/Throwable
    //   222	229	232	java/lang/Throwable
    //   270	284	232	java/lang/Throwable
    //   289	294	314	java/io/IOException
    //   298	302	314	java/io/IOException
    //   308	312	314	java/io/IOException
    //   322	327	349	java/io/IOException
    //   331	339	349	java/io/IOException
    //   343	347	349	java/io/IOException
    //   248	252	352	java/io/IOException
    //   256	260	352	java/io/IOException
    //   264	268	352	java/io/IOException
    //   0	33	355	finally
    //   171	179	355	finally
    //   368	373	391	java/io/IOException
    //   377	381	391	java/io/IOException
    //   385	389	391	java/io/IOException
    //   33	72	394	finally
    //   72	128	403	finally
    //   185	191	403	finally
    //   196	204	412	finally
    //   204	210	418	finally
    //   210	217	418	finally
    //   222	229	418	finally
    //   270	284	418	finally
    //   0	33	422	java/lang/Throwable
    //   171	179	422	java/lang/Throwable
    //   33	72	432	java/lang/Throwable
    //   72	128	442	java/lang/Throwable
    //   185	191	442	java/lang/Throwable
    //   196	204	456	java/lang/Throwable
  }
  
  public static XGPushNotificationBuilder a(Context paramContext)
  {
    try
    {
      paramContext = new XGBasicPushNotificationBuilder().setFlags(16);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static XGPushNotificationBuilder a(Context paramContext, int paramInt)
  {
    XGBasicPushNotificationBuilder localXGBasicPushNotificationBuilder = null;
    if (paramContext == null) {
      return null;
    }
    Object localObject2 = PushPreferences.getString(paramContext, a(paramInt), null);
    if (localObject2 != null) {
      paramContext = localXGBasicPushNotificationBuilder;
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        paramContext = localXGBasicPushNotificationBuilder;
        if (!((JSONObject)localObject2).has("basic")) {
          break label84;
        }
        paramContext = localXGBasicPushNotificationBuilder;
        localXGBasicPushNotificationBuilder = new XGBasicPushNotificationBuilder();
        TLogger.e("MessageHelper", "unexpected for getNotificationBuilder", localJSONException1);
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localObject2 = ((JSONObject)localObject2).getString("basic");
          paramContext = localXGBasicPushNotificationBuilder;
          localXGBasicPushNotificationBuilder.decode((String)localObject2);
          return localXGBasicPushNotificationBuilder;
        }
        catch (JSONException localJSONException2)
        {
          Object localObject1;
          for (;;)
          {
            paramContext = (Context)localObject1;
            localObject1 = localJSONException2;
          }
        }
        localJSONException1 = localJSONException1;
      }
      return paramContext;
      label84:
      paramContext = localJSONException1;
      if (!((JSONObject)localObject2).has("custom")) {
        break;
      }
      paramContext = localJSONException1;
      localObject1 = new XGCustomPushNotificationBuilder();
      try
      {
        localObject2 = ((JSONObject)localObject2).getString("custom");
      }
      catch (JSONException localJSONException3)
      {
        paramContext = (Context)localObject1;
        localObject1 = localJSONException3;
      }
    }
    TLogger.i("MessageHelper", "PushNotificationBuilder not found :" + paramInt);
    return null;
  }
  
  private static String a(int paramInt)
  {
    return "TPUSH_NOTIF_BUILDID_" + String.valueOf(paramInt);
  }
  
  public static void a(Context paramContext, int paramInt, XGPushNotificationBuilder paramXGPushNotificationBuilder)
  {
    String str = a(paramInt);
    JSONObject localJSONObject1 = new JSONObject();
    paramXGPushNotificationBuilder.encode(localJSONObject1);
    JSONObject localJSONObject2 = new JSONObject();
    CommonHelper.jsonPut(localJSONObject2, paramXGPushNotificationBuilder.getType(), localJSONObject1.toString());
    PushPreferences.putString(paramContext, str, localJSONObject2.toString());
  }
  
  @JgMethodChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.RECEIVERCHECK, com.jg.EType.INTENTCHECK})
  public static void a(Context paramContext1, Context paramContext2, PushMessageManager paramPushMessageManager)
  {
    boolean bool1;
    if (paramContext2 == null) {
      bool1 = false;
    }
    d locald;
    Object localObject2;
    boolean bool2;
    for (Object localObject1 = paramContext1;; localObject1 = paramContext2)
    {
      locald = (d)paramPushMessageManager.getMessageHolder();
      localObject3 = locald.l();
      localObject2 = a(paramContext1, locald.g());
      if (localObject2 != null)
      {
        paramContext2 = (Context)localObject2;
        if (locald.u() != 1) {}
      }
      else
      {
        paramContext2 = b(paramContext1, locald, (XGPushNotificationBuilder)localObject2);
      }
      a(paramContext1, locald, paramContext2);
      boolean bool3 = false;
      localObject2 = locald.f();
      bool2 = bool3;
      if (!i.b((String)localObject2))
      {
        bool2 = bool3;
        if (!"{}".equalsIgnoreCase((String)localObject2)) {
          bool2 = true;
        }
      }
      localObject2 = a(paramContext1, (d.a)localObject3, bool2, paramPushMessageManager, bool1);
      if (localObject2 != null) {
        break;
      }
      TLogger.e("MessageHelper", "unexpected action intent null, Action -> showNotification terminate");
      return;
      bool1 = true;
    }
    if (bool2) {
      ((Intent)localObject2).putExtra("custom_content", locald.f());
    }
    ((Intent)localObject2).putExtra("tag.tpush.MSG", "true");
    ((Intent)localObject2).putExtra("title", Rijndael.encrypt(locald.d()));
    ((Intent)localObject2).putExtra("content", Rijndael.encrypt(locald.e()));
    if (locald.f() != null) {
      ((Intent)localObject2).putExtra("custom_content", Rijndael.encrypt(locald.f()));
    }
    ((Intent)localObject2).putExtra("msgId", paramPushMessageManager.getMsgId());
    ((Intent)localObject2).putExtra("accId", paramPushMessageManager.getAccessId());
    ((Intent)localObject2).putExtra("busiMsgId", paramPushMessageManager.getBusiMsgId());
    ((Intent)localObject2).putExtra("timestamps", paramPushMessageManager.getTimestamps());
    ((Intent)localObject2).putExtra("group_id", paramPushMessageManager.getGroupId());
    ((Intent)localObject2).putExtra("templateId", paramPushMessageManager.getTemplateId());
    ((Intent)localObject2).putExtra("traceId", paramPushMessageManager.getTraceId());
    long l = System.currentTimeMillis();
    ((Intent)localObject2).putExtra("protect", Rijndael.encrypt("" + (l - 1000L)));
    NotificationManager localNotificationManager = (NotificationManager)paramContext1.getSystemService("notification");
    int j = locald.k();
    if (j == -1) {
      localNotificationManager.cancelAll();
    }
    int i = j;
    if (j <= 0) {
      i = b(paramContext1, locald.g());
    }
    ((Intent)localObject2).putExtra("notifaction_id", i);
    int k = 134217728;
    j = k;
    if (((d.a)localObject3).c != null)
    {
      j = k;
      if (((d.a)localObject3).c.b > 0) {
        j = ((d.a)localObject3).c.b;
      }
    }
    if (a == null)
    {
      a = new b.1();
      localObject3 = new IntentFilter();
      ((IntentFilter)localObject3).addAction(((Context)localObject1).getPackageName() + ".APP_PUSH_CANCELLED.RESULT");
      BroadcastAgent.registerReceiver((Context)localObject1, a, (IntentFilter)localObject3);
    }
    Object localObject3 = new Intent(((Context)localObject1).getPackageName() + ".APP_PUSH_CANCELLED.RESULT");
    ((Intent)localObject3).setPackage(((Context)localObject1).getPackageName());
    ((Intent)localObject3).putExtra("packName", paramContext1.getPackageName());
    ((Intent)localObject3).putExtra("action", NotificationAction.delete.getType());
    ((Intent)localObject3).putExtras((Intent)localObject2);
    if (Build.VERSION.SDK_INT == 19) {
      PendingIntent.getActivity(paramContext1, i, (Intent)localObject2, j).cancel();
    }
    if (!bool1) {
      paramContext2.setContentIntent(PendingIntent.getActivity(paramContext1, i, (Intent)localObject2, j));
    }
    Object localObject4;
    for (;;)
    {
      if (b == null)
      {
        b = new b.2();
        localObject4 = new IntentFilter();
        ((IntentFilter)localObject4).addAction(paramContext1.getPackageName() + ".APP_PUSH_MEDIA.PLAY");
        ((IntentFilter)localObject4).addAction(paramContext1.getPackageName() + ".APP_PUSH_MEDIA.STOP");
        BroadcastAgent.registerReceiver(paramContext1, b, (IntentFilter)localObject4);
      }
      a(paramContext1, paramPushMessageManager, locald, paramContext2, i, j);
      localObject4 = paramContext2.buildNotification(paramContext1);
      paramPushMessageManager = (Notification)((Pair)localObject4).first;
      localObject4 = ((Pair)localObject4).second;
      paramPushMessageManager.deleteIntent = PendingIntent.getBroadcast((Context)localObject1, i, (Intent)localObject3, j);
      int m = 0;
      bool2 = i.d((Context)localObject1, paramContext1.getPackageName());
      k = m;
      if (locald.x() == 1)
      {
        k = m;
        if (bool2) {
          k = 1;
        }
      }
      TLogger.d("MessageHelper", "is_show_type:" + locald.x() + ", OnForeground:" + bool2);
      if (!bool1) {
        break label1006;
      }
      paramContext2 = XGPushManager.getSysNotifactionCallback();
      if (paramContext2 != null) {
        break;
      }
      TLogger.ee("MessageHelper", "XG Sys Push init Error, no notifactionCallback!");
      return;
      if (Build.VERSION.SDK_INT >= 26) {
        paramContext2.setRunAsSysAndAndBuildSdk26(true);
      }
    }
    if (k != 0) {
      TLogger.d("MessageHelper", "appOnForeground ");
    }
    for (;;)
    {
      paramContext2 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
      paramContext2.putExtra("TPUSH.ERRORCODE", 0);
      paramContext2.setPackage(paramContext1.getPackageName());
      paramContext2.putExtras((Intent)localObject2);
      paramContext2.putExtra("TPUSH.FEEDBACK", 5);
      paramContext2.putExtra("notifaction_id", i);
      BroadcastAgent.sendBroadcast(paramContext1, paramContext2);
      return;
      paramContext2.handleNotify(new XGSysNotifaction(paramContext1.getPackageName(), i, paramPushMessageManager, (Intent)localObject2, j, localObject4));
      continue;
      label1006:
      localObject1 = XGPushManager.getNotifactionCallback();
      if (localObject4 != null) {
        XGPushNotificationBuilder.createNotificationChannel(paramContext1, localObject4);
      }
      if (k != 0)
      {
        TLogger.d("MessageHelper", "appOnForeground ");
      }
      else if (localObject1 == null)
      {
        j = locald.y();
        if (j == -2) {
          XGPushConfig.changeHuaweiBadgeNum(paramContext1, 1);
        }
        try
        {
          for (;;)
          {
            localObject1 = locald.z();
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (Build.VERSION.SDK_INT >= 24))
            {
              localObject3 = locald.A();
              j = paramContext2.getSmallIcon().intValue();
              k = locald.B();
              paramContext2 = paramContext2.getCurrentChannelId();
              paramContext2 = a(paramContext1, locald.d(), paramContext2, (String)localObject1, (String)localObject3, j, k);
              localNotificationManager.notify(-((String)localObject1).hashCode(), paramContext2);
            }
            localNotificationManager.notify(i, paramPushMessageManager);
            break;
            if (j >= 0) {
              XGPushConfig.setBadgeNum(paramContext1, j);
            }
          }
        }
        catch (Throwable paramContext2)
        {
          for (;;)
          {
            TLogger.e("MessageHelper", "show group notification error: " + paramContext2.toString());
          }
        }
      }
      else
      {
        TLogger.i("MessageHelper", "call notifactionCallback:" + paramPushMessageManager);
        ((XGPushNotifactionCallback)localObject1).handleNotify(new XGNotifaction(paramContext1, i, paramPushMessageManager, locald));
        TLogger.d("MessageHelper", "not appOnForeground ");
      }
    }
  }
  
  public static void a(Context paramContext, PushMessageManager paramPushMessageManager)
  {
    if ((paramPushMessageManager.getMessageHolder() instanceof d))
    {
      TLogger.ii("MessageHelper", "Action -> showNotification " + paramPushMessageManager.getContent());
      d locald = (d)paramPushMessageManager.getMessageHolder();
      if ((locald == null) || (locald.l() == null)) {
        TLogger.e("MessageHelper", "showNotification holder == null || holder.getAction() == null");
      }
    }
    else
    {
      return;
    }
    try
    {
      paramContext = paramContext.getApplicationContext();
      if ((a.a(paramContext)) && (paramPushMessageManager.getAppPkgName() != null) && (!paramPushMessageManager.getAppPkgName().equals(paramContext.getPackageName())))
      {
        TLogger.ii("MessageHelper", "receive otehr app notification: " + paramPushMessageManager.getAppPkgName());
        a(paramContext.createPackageContext(paramPushMessageManager.getAppPkgName(), 3), paramContext, paramPushMessageManager);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.ww("MessageHelper", "showNotification Throwable:", paramContext);
      return;
    }
    a(paramContext, null, paramPushMessageManager);
  }
  
  private static void a(Context paramContext, PushMessageManager paramPushMessageManager, d paramd, XGPushNotificationBuilder paramXGPushNotificationBuilder, int paramInt1, int paramInt2)
  {
    int j;
    int m;
    int i1;
    int i2;
    RemoteViews localRemoteViews;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 16)
    {
      int i = paramContext.getResources().getIdentifier("xg_notification", "layout", paramContext.getPackageName());
      if (i == 0) {
        break label529;
      }
      TLogger.d("MessageHelper", "has xg_notification layout");
      j = paramContext.getResources().getIdentifier("xg_notification_icon", "id", paramContext.getPackageName());
      int k = paramContext.getResources().getIdentifier("xg_notification_style_title", "id", paramContext.getPackageName());
      m = paramContext.getResources().getIdentifier("xg_notification_date", "id", paramContext.getPackageName());
      int n = paramContext.getResources().getIdentifier("xg_notification_style_content", "id", paramContext.getPackageName());
      i1 = paramContext.getResources().getIdentifier("xg_notification_audio_play", "id", paramContext.getPackageName());
      i2 = paramContext.getResources().getIdentifier("xg_notification_audio_stop", "id", paramContext.getPackageName());
      localRemoteViews = new RemoteViews(paramContext.getPackageName(), i);
      if ((j != 0) && (k != 0) && (n != 0))
      {
        localRemoteViews.setTextViewText(k, paramd.d());
        localRemoteViews.setTextViewText(n, paramd.e());
        if (TextUtils.isEmpty(paramd.r())) {
          break label512;
        }
        localObject = a(paramd.r());
        if (localObject != null) {
          break label500;
        }
        localRemoteViews.setImageViewResource(j, paramContext.getApplicationInfo().icon);
      }
    }
    for (;;)
    {
      if (m != 0) {
        localRemoteViews.setTextViewText(m, String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis()))));
      }
      if ((i1 != 0) && (i2 != 0) && (!TextUtils.isEmpty(paramd.o())))
      {
        localRemoteViews.setViewVisibility(i1, 0);
        localRemoteViews.setViewVisibility(i2, 0);
        localObject = new Intent(paramContext.getPackageName() + ".APP_PUSH_MEDIA.PLAY");
        ((Intent)localObject).putExtra("msgId", paramPushMessageManager.getMsgId());
        ((Intent)localObject).putExtra("xg_media_audio_resources", paramd.o());
        ((Intent)localObject).putExtra("packName", paramContext.getPackageName());
        localRemoteViews.setOnClickPendingIntent(i1, PendingIntent.getBroadcast(paramContext, paramInt1, (Intent)localObject, paramInt2));
        localObject = new Intent(paramContext.getPackageName() + ".APP_PUSH_MEDIA.STOP");
        ((Intent)localObject).putExtra("msgId", paramPushMessageManager.getMsgId());
        ((Intent)localObject).putExtra("xg_media_audio_resources", paramd.o());
        ((Intent)localObject).putExtra("packName", paramContext.getPackageName());
        localRemoteViews.setOnClickPendingIntent(i2, PendingIntent.getBroadcast(paramContext, paramInt1, (Intent)localObject, paramInt2));
      }
      paramXGPushNotificationBuilder.setContentView(localRemoteViews);
      return;
      label500:
      localRemoteViews.setImageViewBitmap(j, (Bitmap)localObject);
      continue;
      label512:
      localRemoteViews.setImageViewResource(j, paramContext.getApplicationInfo().icon);
    }
    label529:
    TLogger.d("MessageHelper", "no xg_notification layout");
  }
  
  private static void a(Context paramContext, d paramd, XGPushNotificationBuilder paramXGPushNotificationBuilder)
  {
    if (paramd.m() > 0) {
      paramXGPushNotificationBuilder.setIcon(Integer.valueOf(paramd.m()));
    }
    if ((paramd.n() != null) && (!TextUtils.isEmpty(paramd.n())))
    {
      Bitmap localBitmap = a(paramd.n());
      if (localBitmap != null) {
        paramXGPushNotificationBuilder.setRichIcon(localBitmap);
      }
    }
    if ((paramXGPushNotificationBuilder.getSmallIcon() == null) && (paramXGPushNotificationBuilder.getLargeIcon() == null) && (paramXGPushNotificationBuilder.getIcon() == null))
    {
      int i = paramContext.getResources().getIdentifier("notification_icon", "drawable", paramContext.getPackageName());
      if (i <= 0) {
        break label199;
      }
      paramXGPushNotificationBuilder.setSmallIcon(Integer.valueOf(i));
    }
    for (;;)
    {
      paramXGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), paramContext.getApplicationInfo().icon));
      paramXGPushNotificationBuilder.setTitle(paramd.d());
      paramXGPushNotificationBuilder.setTickerText(paramd.e());
      paramContext = paramd.v();
      if (!TextUtils.isEmpty(paramContext)) {
        paramXGPushNotificationBuilder.setChannelId(paramContext);
      }
      if (!TextUtils.isEmpty(paramd.w())) {
        paramXGPushNotificationBuilder.setChannelName(paramd.w());
      }
      if (!TextUtils.isEmpty(paramd.z())) {
        paramXGPushNotificationBuilder.setThread_id(paramd.z());
      }
      return;
      label199:
      paramXGPushNotificationBuilder.setSmallIcon(Integer.valueOf(paramContext.getApplicationInfo().icon));
    }
  }
  
  /* Error */
  private static int b(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 146	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 996
    //   13: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: iload_1
    //   17: invokestatic 466	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   20: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_0
    //   28: aload_3
    //   29: iconst_0
    //   30: invokestatic 1000	com/tencent/tpns/baseapi/base/PushPreferences:getInt	(Landroid/content/Context;Ljava/lang/String;I)I
    //   33: istore_2
    //   34: iload_2
    //   35: istore_1
    //   36: iload_2
    //   37: ldc_w 1001
    //   40: if_icmplt +5 -> 45
    //   43: iconst_0
    //   44: istore_1
    //   45: aload_0
    //   46: aload_3
    //   47: iload_1
    //   48: iconst_1
    //   49: iadd
    //   50: invokestatic 1005	com/tencent/tpns/baseapi/base/PushPreferences:putInt	(Landroid/content/Context;Ljava/lang/String;I)V
    //   53: ldc 2
    //   55: monitorexit
    //   56: iload_1
    //   57: ireturn
    //   58: astore_0
    //   59: iconst_0
    //   60: istore_1
    //   61: ldc 103
    //   63: ldc_w 583
    //   66: aload_0
    //   67: invokestatic 111	com/tencent/android/tpush/logging/TLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: goto -17 -> 53
    //   73: astore_0
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_0
    //   78: athrow
    //   79: astore_0
    //   80: goto -19 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramContext	Context
    //   0	83	1	paramInt	int
    //   33	8	2	i	int
    //   26	21	3	str	String
    // Exception table:
    //   from	to	target	type
    //   3	34	58	java/lang/Throwable
    //   3	34	73	finally
    //   45	53	73	finally
    //   61	70	73	finally
    //   45	53	79	java/lang/Throwable
  }
  
  private static XGPushNotificationBuilder b(Context paramContext, d paramd, XGPushNotificationBuilder paramXGPushNotificationBuilder)
  {
    if (paramXGPushNotificationBuilder == null) {
      paramXGPushNotificationBuilder = XGPushManager.getDefaultNotificationBuilder(paramContext);
    }
    for (;;)
    {
      XGPushNotificationBuilder localXGPushNotificationBuilder = paramXGPushNotificationBuilder;
      if (paramXGPushNotificationBuilder == null) {
        localXGPushNotificationBuilder = a(paramContext);
      }
      if (paramd.j() != 0) {
        localXGPushNotificationBuilder.setFlags(16);
      }
      int i;
      Object localObject;
      if (paramd.h() != 0)
      {
        if (TextUtils.isEmpty(paramd.q())) {
          break label333;
        }
        i = paramContext.getResources().getIdentifier(paramd.q(), "raw", paramContext.getPackageName());
        if (i > 0) {
          localXGPushNotificationBuilder.setSound(Uri.parse("android.resource://" + paramContext.getPackageName() + "/" + i));
        }
      }
      else
      {
        if (paramd.i() != 0) {
          localXGPushNotificationBuilder.setDefaults(2);
        }
        if (paramd.p() != 0)
        {
          localXGPushNotificationBuilder.setDefaults(4);
          localXGPushNotificationBuilder.setFlags(1);
        }
        paramXGPushNotificationBuilder = paramd.s();
        localObject = com.tencent.android.tpush.d.d.g();
        if ((paramXGPushNotificationBuilder == null) || (TextUtils.isEmpty(paramXGPushNotificationBuilder))) {
          break label427;
        }
        i = paramContext.getResources().getIdentifier(paramXGPushNotificationBuilder, "drawable", paramContext.getPackageName());
        if (i <= 0) {
          break label343;
        }
        localXGPushNotificationBuilder.setSmallIcon(Integer.valueOf(i));
        label205:
        i = paramd.t();
        localObject = paramd.r();
        paramXGPushNotificationBuilder = null;
        if ((localXGPushNotificationBuilder instanceof XGCustomPushNotificationBuilder)) {
          paramXGPushNotificationBuilder = ((XGCustomPushNotificationBuilder)localXGPushNotificationBuilder).getLayoutIconId();
        }
        if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          if (i > 0) {
            break label542;
          }
          i = paramContext.getResources().getIdentifier((String)localObject, "drawable", paramContext.getPackageName());
          if (i <= 0) {
            break label519;
          }
          localXGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), i));
          if (paramXGPushNotificationBuilder != null) {
            ((XGCustomPushNotificationBuilder)localXGPushNotificationBuilder).setLayoutIconDrawableId(i);
          }
        }
      }
      for (;;)
      {
        i = paramd.B();
        if (i > 0) {
          localXGPushNotificationBuilder.setColor(Integer.valueOf(i));
        }
        return localXGPushNotificationBuilder;
        localXGPushNotificationBuilder.setDefaults(1);
        break;
        label333:
        localXGPushNotificationBuilder.setDefaults(1);
        break;
        label343:
        if (((String)localObject).equals("google"))
        {
          i = paramContext.getResources().getIdentifier("notification_icon", "drawable", paramContext.getPackageName());
          if (i > 0)
          {
            localXGPushNotificationBuilder.setSmallIcon(Integer.valueOf(i));
            break label205;
          }
          localXGPushNotificationBuilder.setSmallIcon(Integer.valueOf(paramContext.getApplicationInfo().icon));
          break label205;
        }
        localXGPushNotificationBuilder.setSmallIcon(Integer.valueOf(paramContext.getApplicationInfo().icon));
        break label205;
        label427:
        if (localXGPushNotificationBuilder.getSmallIcon() != null) {
          break label205;
        }
        if (((String)localObject).equals("google"))
        {
          i = paramContext.getResources().getIdentifier("notification_icon", "drawable", paramContext.getPackageName());
          if (i > 0)
          {
            localXGPushNotificationBuilder.setSmallIcon(Integer.valueOf(i));
            break label205;
          }
          localXGPushNotificationBuilder.setSmallIcon(Integer.valueOf(paramContext.getApplicationInfo().icon));
          break label205;
        }
        localXGPushNotificationBuilder.setSmallIcon(Integer.valueOf(paramContext.getApplicationInfo().icon));
        break label205;
        label519:
        localXGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), paramContext.getApplicationInfo().icon));
        continue;
        label542:
        localObject = a((String)localObject);
        if (localObject == null)
        {
          localXGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), paramContext.getApplicationInfo().icon));
        }
        else
        {
          localXGPushNotificationBuilder.setLargeIcon((Bitmap)localObject);
          if (paramXGPushNotificationBuilder != null) {
            ((XGCustomPushNotificationBuilder)localXGPushNotificationBuilder).setLayoutIconDrawableBmp((Bitmap)localObject);
          }
        }
      }
    }
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      Object localObject = new Intent("android.intent.action.MAIN", null);
      ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject).setPackage(paramContext.getPackageName());
      paramContext = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0).iterator();
      while (paramContext.hasNext())
      {
        localObject = (ResolveInfo)paramContext.next();
        if (((ResolveInfo)localObject).activityInfo != null)
        {
          paramContext = ((ResolveInfo)localObject).activityInfo.name;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.e("MessageHelper", "get Activity error", paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.b
 * JD-Core Version:    0.7.0.1
 */