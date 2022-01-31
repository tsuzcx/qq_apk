package com.tencent.mobileqq.utils.kapalaiadapter;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import heq;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class KapalaiAdapterUtil
{
  public int a;
  private DualSimManager a;
  
  private KapalaiAdapterUtil()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = DualSimManager.a();
  }
  
  public static KapalaiAdapterUtil a()
  {
    return heq.a;
  }
  
  private Camera b()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Camera.Parameters localParameters;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label57;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localParameters = ((Camera)localObject1).getParameters();
        if (localParameters != null)
        {
          localParameters.set("video_input", "secondary");
          ((Camera)localObject1).setParameters(localParameters);
        }
        return localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return localObject1;
  }
  
  private Camera c()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Camera.Parameters localParameters;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label57;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localParameters = ((Camera)localObject1).getParameters();
        if (localParameters != null)
        {
          localParameters.set("device", "/dev/video1");
          ((Camera)localObject1).setParameters(localParameters);
        }
        return localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return localObject1;
  }
  
  private Camera d()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Method localMethod;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label76;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localMethod = localObject1.getClass().getMethod("setSensorID", new Class[] { Integer.TYPE });
        if (localMethod != null) {
          localMethod.invoke(localObject1, new Object[] { Integer.valueOf(1) });
        }
        return localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return localObject1;
  }
  
  private Camera e()
  {
    Camera localCamera = null;
    try
    {
      Class localClass = Class.forName("android.hardware.Camera");
      Method localMethod = localClass.getMethod("setCurrentCamera", new Class[] { Integer.TYPE });
      if (localMethod != null)
      {
        localMethod.invoke(localClass, new Object[] { Integer.valueOf(1) });
        localCamera = Camera.open();
      }
      return localCamera;
    }
    catch (Exception localException)
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  @TargetApi(9)
  private Camera f()
  {
    Camera localCamera = null;
    try
    {
      if (VersionUtils.c()) {
        localCamera = Camera.open();
      }
      return localCamera;
    }
    catch (Exception localException)
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @TargetApi(16)
  public Notification a(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          paramContext = new Notification(paramInt, null, System.currentTimeMillis());
          localObject = paramContext;
          if (paramContext == null) {
            localObject = new Notification(paramInt, null, System.currentTimeMillis());
          }
          return localObject;
        }
        paramContext = new Notification.Builder(paramContext);
        Object localObject = Class.forName("android.app.Notification$Builder").getDeclaredMethod("setInternalApp", new Class[] { Integer.TYPE });
        if (localObject != null)
        {
          ((Method)localObject).invoke(paramContext, new Object[] { Integer.valueOf(1) });
          if (Build.VERSION.SDK_INT >= 16)
          {
            paramContext = paramContext.build();
            continue;
          }
          if ((Build.VERSION.SDK_INT < 16) && (Build.VERSION.SDK_INT >= 11))
          {
            paramContext = paramContext.getNotification();
            continue;
            return null;
          }
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("newNotificationForMeizu", 2, paramContext.getMessage());
        }
        if (0 == 0) {
          return new Notification(paramInt, null, System.currentTimeMillis());
        }
      }
      finally
      {
        if (0 == 0) {
          new Notification(paramInt, null, System.currentTimeMillis());
        }
      }
      paramContext = null;
    }
  }
  
  /* Error */
  public Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 177	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3: iconst_0
    //   4: aload_1
    //   5: ldc 178
    //   7: invokestatic 184	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   10: astore 10
    //   12: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +29 -> 44
    //   18: ldc 186
    //   20: iconst_2
    //   21: new 188	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   28: ldc 191
    //   30: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 10
    //   35: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 204	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: ldc 205
    //   46: istore 9
    //   48: iload 9
    //   50: istore 8
    //   52: aload_1
    //   53: ldc 207
    //   55: iconst_m1
    //   56: invokevirtual 213	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   59: sipush 1008
    //   62: if_icmpne +22 -> 84
    //   65: getstatic 219	com/tencent/mobileqq/app/AppConstants:L	Ljava/lang/String;
    //   68: aload_1
    //   69: ldc 221
    //   71: invokevirtual 225	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   74: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq +123 -> 200
    //   80: iload 9
    //   82: istore 8
    //   84: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   87: bipush 11
    //   89: if_icmpge +122 -> 211
    //   92: new 128	android/app/Notification
    //   95: dup
    //   96: iload 8
    //   98: aload_3
    //   99: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   102: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   105: astore_1
    //   106: aload_1
    //   107: aload 10
    //   109: putfield 235	android/app/Notification:contentIntent	Landroid/app/PendingIntent;
    //   112: aload_1
    //   113: aload_1
    //   114: getfield 238	android/app/Notification:flags	I
    //   117: bipush 32
    //   119: ior
    //   120: putfield 238	android/app/Notification:flags	I
    //   123: aload_1
    //   124: aload_1
    //   125: getfield 238	android/app/Notification:flags	I
    //   128: iconst_2
    //   129: ior
    //   130: putfield 238	android/app/Notification:flags	I
    //   133: invokestatic 177	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   136: aload 7
    //   138: invokestatic 243	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   141: ifeq +57 -> 198
    //   144: invokestatic 249	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   147: bipush 11
    //   149: invokevirtual 253	java/util/Calendar:get	(I)I
    //   152: istore 8
    //   154: iload 8
    //   156: bipush 23
    //   158: if_icmpge +10 -> 168
    //   161: iload 8
    //   163: bipush 8
    //   165: if_icmpge +43 -> 208
    //   168: aload_1
    //   169: aload_1
    //   170: getfield 238	android/app/Notification:flags	I
    //   173: iconst_1
    //   174: ior
    //   175: putfield 238	android/app/Notification:flags	I
    //   178: aload_1
    //   179: ldc 254
    //   181: putfield 257	android/app/Notification:ledARGB	I
    //   184: aload_1
    //   185: sipush 2000
    //   188: putfield 260	android/app/Notification:ledOffMS	I
    //   191: aload_1
    //   192: sipush 2000
    //   195: putfield 263	android/app/Notification:ledOnMS	I
    //   198: aload_1
    //   199: areturn
    //   200: ldc_w 264
    //   203: istore 8
    //   205: goto -121 -> 84
    //   208: goto -40 -> 168
    //   211: new 139	android/app/Notification$Builder
    //   214: dup
    //   215: invokestatic 177	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   218: invokespecial 142	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   221: iload 8
    //   223: invokevirtual 268	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   226: iconst_1
    //   227: invokevirtual 272	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   230: iconst_1
    //   231: invokevirtual 275	android/app/Notification$Builder:setOngoing	(Z)Landroid/app/Notification$Builder;
    //   234: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   237: invokevirtual 279	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   240: aload_3
    //   241: invokevirtual 283	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   244: astore_1
    //   245: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   248: bipush 21
    //   250: if_icmplt +9 -> 259
    //   253: aload_1
    //   254: iconst_1
    //   255: invokevirtual 286	android/app/Notification$Builder:setVisibility	(I)Landroid/app/Notification$Builder;
    //   258: pop
    //   259: ldc 144
    //   261: invokestatic 103	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   264: ldc 146
    //   266: iconst_1
    //   267: anewarray 76	java/lang/Class
    //   270: dup
    //   271: iconst_0
    //   272: getstatic 82	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   275: aastore
    //   276: invokevirtual 149	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   279: astore 11
    //   281: aload 11
    //   283: ifnull +21 -> 304
    //   286: aload 11
    //   288: aload_1
    //   289: iconst_1
    //   290: anewarray 4	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: iconst_1
    //   296: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   299: aastore
    //   300: invokevirtual 96	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   303: pop
    //   304: invokestatic 177	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   307: aload 7
    //   309: invokestatic 243	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   312: ifeq +40 -> 352
    //   315: invokestatic 249	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   318: bipush 11
    //   320: invokevirtual 253	java/util/Calendar:get	(I)I
    //   323: istore 9
    //   325: iload 9
    //   327: bipush 23
    //   329: if_icmpge +10 -> 339
    //   332: iload 9
    //   334: bipush 8
    //   336: if_icmpge +73 -> 409
    //   339: aload_1
    //   340: ldc 254
    //   342: sipush 2000
    //   345: sipush 2000
    //   348: invokevirtual 290	android/app/Notification$Builder:setLights	(III)Landroid/app/Notification$Builder;
    //   351: pop
    //   352: iload 6
    //   354: ifeq +58 -> 412
    //   357: aload_2
    //   358: ifnull +9 -> 367
    //   361: aload_1
    //   362: aload_2
    //   363: invokevirtual 294	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   366: pop
    //   367: aload_1
    //   368: aload 4
    //   370: invokevirtual 297	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   373: aload 5
    //   375: invokevirtual 300	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   378: aload 10
    //   380: invokevirtual 304	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   383: pop
    //   384: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   387: bipush 16
    //   389: if_icmplt +53 -> 442
    //   392: aload_1
    //   393: invokevirtual 153	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   396: astore_1
    //   397: aload_1
    //   398: areturn
    //   399: astore 11
    //   401: aload 11
    //   403: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   406: goto -102 -> 304
    //   409: goto -70 -> 339
    //   412: aload_1
    //   413: aload 4
    //   415: invokevirtual 297	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   418: aload 5
    //   420: invokevirtual 300	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   423: aload 10
    //   425: invokevirtual 304	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   428: pop
    //   429: aload_2
    //   430: ifnull -46 -> 384
    //   433: aload_1
    //   434: aload_2
    //   435: invokevirtual 294	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   438: pop
    //   439: goto -55 -> 384
    //   442: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   445: bipush 16
    //   447: if_icmpge +16 -> 463
    //   450: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   453: bipush 11
    //   455: if_icmplt +8 -> 463
    //   458: aload_1
    //   459: invokevirtual 156	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   462: areturn
    //   463: new 128	android/app/Notification
    //   466: dup
    //   467: iload 8
    //   469: aload_3
    //   470: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   473: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   476: astore_1
    //   477: aload_1
    //   478: areturn
    //   479: astore_1
    //   480: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +14 -> 497
    //   486: ldc_w 306
    //   489: iconst_2
    //   490: aload_1
    //   491: invokevirtual 167	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   494: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: new 128	android/app/Notification
    //   500: dup
    //   501: iload 8
    //   503: aload_3
    //   504: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   507: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   510: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	KapalaiAdapterUtil
    //   0	511	1	paramIntent	Intent
    //   0	511	2	paramBitmap	Bitmap
    //   0	511	3	paramString1	String
    //   0	511	4	paramString2	String
    //   0	511	5	paramString3	String
    //   0	511	6	paramBoolean	boolean
    //   0	511	7	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   50	452	8	i	int
    //   46	291	9	j	int
    //   10	414	10	localPendingIntent	android.app.PendingIntent
    //   279	8	11	localMethod	Method
    //   399	3	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   259	281	399	java/lang/Exception
    //   286	304	399	java/lang/Exception
    //   384	397	479	java/lang/Exception
    //   442	463	479	java/lang/Exception
    //   463	477	479	java/lang/Exception
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra(a(), Integer.parseInt(c()));
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap != null) {
      return Bitmap.createScaledBitmap(paramBitmap, paramInt, paramInt, true);
    }
    return null;
  }
  
  public Camera a()
  {
    Camera localCamera = null;
    if (Build.MANUFACTURER.equalsIgnoreCase("HTC")) {
      localCamera = b();
    }
    do
    {
      return localCamera;
      if (Build.MANUFACTURER.equalsIgnoreCase("YuLong")) {
        return c();
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("HISENSE")) {
        return d();
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
        return e();
      }
    } while (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO"));
    return f();
  }
  
  public String a()
  {
    return DualSimManager.a;
  }
  
  public String a(Camera.Parameters paramParameters)
  {
    String str = "off";
    List localList = paramParameters.getSupportedFlashModes();
    if (localList.contains("torch")) {
      paramParameters = "torch";
    }
    do
    {
      return paramParameters;
      if (localList.contains("on")) {
        return "on";
      }
      paramParameters = str;
    } while (!localList.contains("auto"));
    return "auto";
  }
  
  public ArrayList a(Context paramContext)
  {
    ArrayList localArrayList1 = b(paramContext);
    if ((localArrayList1 == null) || (localArrayList1.size() < 1)) {
      return null;
    }
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      String str = (String)localArrayList1.get(i);
      if (SDCardMountInforUtil.a(paramContext).a(str)) {
        localArrayList2.add(str);
      }
      i += 1;
    }
    return localArrayList2;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent.setFlags(337641472);
  }
  
  public void a(Window paramWindow)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramWindow.setType(2004);
    }
  }
  
  public void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.screenBrightness = 0.035F;
  }
  
  public void a(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.setSelection(this.jdField_a_of_type_Int);
    }
  }
  
  public boolean a()
  {
    return (!this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager.a(0)) && (this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager.a(1));
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    return DualSimManager.a().a(paramInt, paramString1, paramString2, paramArrayList1, paramArrayList2, paramArrayList3);
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    return SDCardMountInforUtil.a(paramContext).a(paramString);
  }
  
  public boolean a(Camera.Parameters paramParameters, Context paramContext)
  {
    return (paramParameters.getSupportedFlashModes() != null) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) && (paramParameters.getSupportedFlashModes().size() > 1);
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    return DualSimManager.b;
  }
  
  public ArrayList b(Context paramContext)
  {
    return SDCardMountInforUtil.a(paramContext).a();
  }
  
  public void b(Window paramWindow)
  {
    paramWindow.setType(2);
  }
  
  public String c()
  {
    return DualSimManager.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil
 * JD-Core Version:    0.7.0.1
 */