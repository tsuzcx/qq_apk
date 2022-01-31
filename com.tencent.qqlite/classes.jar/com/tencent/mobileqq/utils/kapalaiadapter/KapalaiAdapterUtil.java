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
import ewl;
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
    return ewl.a;
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
    //   0: aload 7
    //   2: invokevirtual 175	com/tencent/mobileqq/app/QQAppInterface:b	()Z
    //   5: istore 9
    //   7: invokestatic 181	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   10: iconst_0
    //   11: aload_1
    //   12: ldc 182
    //   14: invokestatic 188	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   17: astore_1
    //   18: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +28 -> 49
    //   24: ldc 190
    //   26: iconst_2
    //   27: new 192	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   34: ldc 195
    //   36: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 208	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   52: bipush 11
    //   54: if_icmpge +118 -> 172
    //   57: new 128	android/app/Notification
    //   60: dup
    //   61: ldc 209
    //   63: aload_3
    //   64: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   67: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   70: astore_2
    //   71: aload_2
    //   72: aload_1
    //   73: putfield 213	android/app/Notification:contentIntent	Landroid/app/PendingIntent;
    //   76: iload 9
    //   78: ifeq +24 -> 102
    //   81: aload_2
    //   82: aload_2
    //   83: getfield 216	android/app/Notification:flags	I
    //   86: bipush 32
    //   88: ior
    //   89: putfield 216	android/app/Notification:flags	I
    //   92: aload_2
    //   93: aload_2
    //   94: getfield 216	android/app/Notification:flags	I
    //   97: iconst_2
    //   98: ior
    //   99: putfield 216	android/app/Notification:flags	I
    //   102: invokestatic 181	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   105: aload 7
    //   107: invokestatic 221	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   110: ifeq +57 -> 167
    //   113: invokestatic 227	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   116: bipush 11
    //   118: invokevirtual 231	java/util/Calendar:get	(I)I
    //   121: istore 8
    //   123: iload 8
    //   125: bipush 23
    //   127: if_icmpge +10 -> 137
    //   130: iload 8
    //   132: bipush 8
    //   134: if_icmpge +35 -> 169
    //   137: aload_2
    //   138: aload_2
    //   139: getfield 216	android/app/Notification:flags	I
    //   142: iconst_1
    //   143: ior
    //   144: putfield 216	android/app/Notification:flags	I
    //   147: aload_2
    //   148: ldc 232
    //   150: putfield 235	android/app/Notification:ledARGB	I
    //   153: aload_2
    //   154: sipush 2000
    //   157: putfield 238	android/app/Notification:ledOffMS	I
    //   160: aload_2
    //   161: sipush 2000
    //   164: putfield 241	android/app/Notification:ledOnMS	I
    //   167: aload_2
    //   168: areturn
    //   169: goto -32 -> 137
    //   172: new 139	android/app/Notification$Builder
    //   175: dup
    //   176: invokestatic 181	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   179: invokespecial 142	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   182: ldc 209
    //   184: invokevirtual 245	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   187: iconst_1
    //   188: invokevirtual 249	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   191: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   194: invokevirtual 253	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   197: aload_3
    //   198: invokevirtual 257	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   201: astore 10
    //   203: iload 9
    //   205: ifeq +10 -> 215
    //   208: aload 10
    //   210: iconst_1
    //   211: invokevirtual 260	android/app/Notification$Builder:setOngoing	(Z)Landroid/app/Notification$Builder;
    //   214: pop
    //   215: ldc 144
    //   217: invokestatic 103	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   220: ldc 146
    //   222: iconst_1
    //   223: anewarray 76	java/lang/Class
    //   226: dup
    //   227: iconst_0
    //   228: getstatic 82	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   231: aastore
    //   232: invokevirtual 149	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   235: astore 11
    //   237: aload 11
    //   239: ifnull +22 -> 261
    //   242: aload 11
    //   244: aload 10
    //   246: iconst_1
    //   247: anewarray 4	java/lang/Object
    //   250: dup
    //   251: iconst_0
    //   252: iconst_1
    //   253: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: aastore
    //   257: invokevirtual 96	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: invokestatic 181	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   264: aload 7
    //   266: invokestatic 221	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   269: ifeq +41 -> 310
    //   272: invokestatic 227	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   275: bipush 11
    //   277: invokevirtual 231	java/util/Calendar:get	(I)I
    //   280: istore 8
    //   282: iload 8
    //   284: bipush 23
    //   286: if_icmpge +10 -> 296
    //   289: iload 8
    //   291: bipush 8
    //   293: if_icmpge +76 -> 369
    //   296: aload 10
    //   298: ldc 232
    //   300: sipush 2000
    //   303: sipush 2000
    //   306: invokevirtual 264	android/app/Notification$Builder:setLights	(III)Landroid/app/Notification$Builder;
    //   309: pop
    //   310: iload 6
    //   312: ifeq +60 -> 372
    //   315: aload_2
    //   316: ifnull +10 -> 326
    //   319: aload 10
    //   321: aload_2
    //   322: invokevirtual 268	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   325: pop
    //   326: aload 10
    //   328: aload 4
    //   330: invokevirtual 271	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   333: aload 5
    //   335: invokevirtual 274	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   338: aload_1
    //   339: invokevirtual 278	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   342: pop
    //   343: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   346: bipush 16
    //   348: if_icmplt +55 -> 403
    //   351: aload 10
    //   353: invokevirtual 153	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   356: astore_1
    //   357: aload_1
    //   358: areturn
    //   359: astore 11
    //   361: aload 11
    //   363: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   366: goto -105 -> 261
    //   369: goto -73 -> 296
    //   372: aload 10
    //   374: aload 4
    //   376: invokevirtual 271	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   379: aload 5
    //   381: invokevirtual 274	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   384: aload_1
    //   385: invokevirtual 278	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   388: pop
    //   389: aload_2
    //   390: ifnull -47 -> 343
    //   393: aload 10
    //   395: aload_2
    //   396: invokevirtual 268	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   399: pop
    //   400: goto -57 -> 343
    //   403: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   406: bipush 16
    //   408: if_icmpge +17 -> 425
    //   411: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   414: bipush 11
    //   416: if_icmplt +9 -> 425
    //   419: aload 10
    //   421: invokevirtual 156	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   424: areturn
    //   425: new 128	android/app/Notification
    //   428: dup
    //   429: ldc 209
    //   431: aload_3
    //   432: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   435: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   438: astore_1
    //   439: aload_1
    //   440: areturn
    //   441: astore_1
    //   442: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +14 -> 459
    //   448: ldc_w 280
    //   451: iconst_2
    //   452: aload_1
    //   453: invokevirtual 167	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   456: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: new 128	android/app/Notification
    //   462: dup
    //   463: ldc 209
    //   465: aload_3
    //   466: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   469: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   472: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	this	KapalaiAdapterUtil
    //   0	473	1	paramIntent	Intent
    //   0	473	2	paramBitmap	Bitmap
    //   0	473	3	paramString1	String
    //   0	473	4	paramString2	String
    //   0	473	5	paramString3	String
    //   0	473	6	paramBoolean	boolean
    //   0	473	7	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   121	173	8	i	int
    //   5	199	9	bool	boolean
    //   201	219	10	localBuilder	Notification.Builder
    //   235	8	11	localMethod	Method
    //   359	3	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   215	237	359	java/lang/Exception
    //   242	261	359	java/lang/Exception
    //   343	357	441	java/lang/Exception
    //   403	425	441	java/lang/Exception
    //   425	439	441	java/lang/Exception
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
    paramWindow.setType(2004);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil
 * JD-Core Version:    0.7.0.1
 */