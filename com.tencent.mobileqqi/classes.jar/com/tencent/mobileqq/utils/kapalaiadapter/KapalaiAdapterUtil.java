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
import hep;
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
    return hep.a;
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
    //   5: istore 10
    //   7: invokestatic 181	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   10: iconst_0
    //   11: aload_1
    //   12: ldc 182
    //   14: invokestatic 188	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   17: astore 11
    //   19: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +29 -> 51
    //   25: ldc 190
    //   27: iconst_2
    //   28: new 192	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   35: ldc 195
    //   37: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 11
    //   42: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 208	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: ldc 209
    //   53: istore 9
    //   55: iload 9
    //   57: istore 8
    //   59: aload_1
    //   60: ldc 211
    //   62: iconst_m1
    //   63: invokevirtual 217	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   66: sipush 1008
    //   69: if_icmpne +22 -> 91
    //   72: getstatic 223	com/tencent/mobileqq/app/AppConstants:L	Ljava/lang/String;
    //   75: aload_1
    //   76: ldc 225
    //   78: invokevirtual 229	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +124 -> 208
    //   87: iload 9
    //   89: istore 8
    //   91: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   94: bipush 11
    //   96: if_icmpge +123 -> 219
    //   99: new 128	android/app/Notification
    //   102: dup
    //   103: iload 8
    //   105: aload_3
    //   106: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   109: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   112: astore_1
    //   113: aload_1
    //   114: aload 11
    //   116: putfield 239	android/app/Notification:contentIntent	Landroid/app/PendingIntent;
    //   119: aload_1
    //   120: aload_1
    //   121: getfield 242	android/app/Notification:flags	I
    //   124: bipush 32
    //   126: ior
    //   127: putfield 242	android/app/Notification:flags	I
    //   130: aload_1
    //   131: aload_1
    //   132: getfield 242	android/app/Notification:flags	I
    //   135: iconst_2
    //   136: ior
    //   137: putfield 242	android/app/Notification:flags	I
    //   140: invokestatic 181	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   143: aload 7
    //   145: invokestatic 247	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   148: ifeq +58 -> 206
    //   151: invokestatic 253	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   154: bipush 11
    //   156: invokevirtual 257	java/util/Calendar:get	(I)I
    //   159: istore 8
    //   161: iload 8
    //   163: bipush 23
    //   165: if_icmpge +10 -> 175
    //   168: iload 8
    //   170: bipush 8
    //   172: if_icmpge +44 -> 216
    //   175: aload_1
    //   176: aload_1
    //   177: getfield 242	android/app/Notification:flags	I
    //   180: iconst_1
    //   181: ior
    //   182: putfield 242	android/app/Notification:flags	I
    //   185: aload_1
    //   186: ldc_w 258
    //   189: putfield 261	android/app/Notification:ledARGB	I
    //   192: aload_1
    //   193: sipush 2000
    //   196: putfield 264	android/app/Notification:ledOffMS	I
    //   199: aload_1
    //   200: sipush 2000
    //   203: putfield 267	android/app/Notification:ledOnMS	I
    //   206: aload_1
    //   207: areturn
    //   208: ldc_w 268
    //   211: istore 8
    //   213: goto -122 -> 91
    //   216: goto -41 -> 175
    //   219: new 139	android/app/Notification$Builder
    //   222: dup
    //   223: invokestatic 181	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   226: invokespecial 142	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   229: iload 8
    //   231: invokevirtual 272	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   234: iconst_1
    //   235: invokevirtual 276	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   238: iconst_1
    //   239: invokevirtual 279	android/app/Notification$Builder:setOngoing	(Z)Landroid/app/Notification$Builder;
    //   242: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   245: invokevirtual 283	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   248: aload_3
    //   249: invokevirtual 287	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   252: astore_1
    //   253: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   256: bipush 21
    //   258: if_icmplt +9 -> 267
    //   261: aload_1
    //   262: iconst_1
    //   263: invokevirtual 290	android/app/Notification$Builder:setVisibility	(I)Landroid/app/Notification$Builder;
    //   266: pop
    //   267: iload 10
    //   269: ifeq +9 -> 278
    //   272: aload_1
    //   273: iconst_1
    //   274: invokevirtual 279	android/app/Notification$Builder:setOngoing	(Z)Landroid/app/Notification$Builder;
    //   277: pop
    //   278: ldc 144
    //   280: invokestatic 103	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   283: ldc 146
    //   285: iconst_1
    //   286: anewarray 76	java/lang/Class
    //   289: dup
    //   290: iconst_0
    //   291: getstatic 82	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   294: aastore
    //   295: invokevirtual 149	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   298: astore 12
    //   300: aload 12
    //   302: ifnull +21 -> 323
    //   305: aload 12
    //   307: aload_1
    //   308: iconst_1
    //   309: anewarray 4	java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: iconst_1
    //   315: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: aastore
    //   319: invokevirtual 96	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   322: pop
    //   323: invokestatic 181	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   326: aload 7
    //   328: invokestatic 247	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   331: ifeq +41 -> 372
    //   334: invokestatic 253	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   337: bipush 11
    //   339: invokevirtual 257	java/util/Calendar:get	(I)I
    //   342: istore 9
    //   344: iload 9
    //   346: bipush 23
    //   348: if_icmpge +10 -> 358
    //   351: iload 9
    //   353: bipush 8
    //   355: if_icmpge +74 -> 429
    //   358: aload_1
    //   359: ldc_w 258
    //   362: sipush 2000
    //   365: sipush 2000
    //   368: invokevirtual 294	android/app/Notification$Builder:setLights	(III)Landroid/app/Notification$Builder;
    //   371: pop
    //   372: iload 6
    //   374: ifeq +58 -> 432
    //   377: aload_2
    //   378: ifnull +9 -> 387
    //   381: aload_1
    //   382: aload_2
    //   383: invokevirtual 298	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   386: pop
    //   387: aload_1
    //   388: aload 4
    //   390: invokevirtual 301	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   393: aload 5
    //   395: invokevirtual 304	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   398: aload 11
    //   400: invokevirtual 308	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   403: pop
    //   404: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   407: bipush 16
    //   409: if_icmplt +53 -> 462
    //   412: aload_1
    //   413: invokevirtual 153	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   416: astore_1
    //   417: aload_1
    //   418: areturn
    //   419: astore 12
    //   421: aload 12
    //   423: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   426: goto -103 -> 323
    //   429: goto -71 -> 358
    //   432: aload_1
    //   433: aload 4
    //   435: invokevirtual 301	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   438: aload 5
    //   440: invokevirtual 304	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   443: aload 11
    //   445: invokevirtual 308	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   448: pop
    //   449: aload_2
    //   450: ifnull -46 -> 404
    //   453: aload_1
    //   454: aload_2
    //   455: invokevirtual 298	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   458: pop
    //   459: goto -55 -> 404
    //   462: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   465: bipush 16
    //   467: if_icmpge +16 -> 483
    //   470: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   473: bipush 11
    //   475: if_icmplt +8 -> 483
    //   478: aload_1
    //   479: invokevirtual 156	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   482: areturn
    //   483: new 128	android/app/Notification
    //   486: dup
    //   487: iload 8
    //   489: aload_3
    //   490: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   493: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   496: astore_1
    //   497: aload_1
    //   498: areturn
    //   499: astore_1
    //   500: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +14 -> 517
    //   506: ldc_w 310
    //   509: iconst_2
    //   510: aload_1
    //   511: invokevirtual 167	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   514: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: new 128	android/app/Notification
    //   520: dup
    //   521: iload 8
    //   523: aload_3
    //   524: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   527: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   530: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	KapalaiAdapterUtil
    //   0	531	1	paramIntent	Intent
    //   0	531	2	paramBitmap	Bitmap
    //   0	531	3	paramString1	String
    //   0	531	4	paramString2	String
    //   0	531	5	paramString3	String
    //   0	531	6	paramBoolean	boolean
    //   0	531	7	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   57	465	8	i	int
    //   53	303	9	j	int
    //   5	263	10	bool	boolean
    //   17	427	11	localPendingIntent	android.app.PendingIntent
    //   298	8	12	localMethod	Method
    //   419	3	12	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   278	300	419	java/lang/Exception
    //   305	323	419	java/lang/Exception
    //   404	417	499	java/lang/Exception
    //   462	483	499	java/lang/Exception
    //   483	497	499	java/lang/Exception
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