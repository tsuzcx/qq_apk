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
import hix;
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
    return hix.a;
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
    //   245: ldc 144
    //   247: invokestatic 103	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   250: ldc 146
    //   252: iconst_1
    //   253: anewarray 76	java/lang/Class
    //   256: dup
    //   257: iconst_0
    //   258: getstatic 82	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   261: aastore
    //   262: invokevirtual 149	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   265: astore 11
    //   267: aload 11
    //   269: ifnull +21 -> 290
    //   272: aload 11
    //   274: aload_1
    //   275: iconst_1
    //   276: anewarray 4	java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: iconst_1
    //   282: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: invokevirtual 96	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   289: pop
    //   290: invokestatic 177	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   293: aload 7
    //   295: invokestatic 243	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   298: ifeq +40 -> 338
    //   301: invokestatic 249	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   304: bipush 11
    //   306: invokevirtual 253	java/util/Calendar:get	(I)I
    //   309: istore 9
    //   311: iload 9
    //   313: bipush 23
    //   315: if_icmpge +10 -> 325
    //   318: iload 9
    //   320: bipush 8
    //   322: if_icmpge +73 -> 395
    //   325: aload_1
    //   326: ldc 254
    //   328: sipush 2000
    //   331: sipush 2000
    //   334: invokevirtual 287	android/app/Notification$Builder:setLights	(III)Landroid/app/Notification$Builder;
    //   337: pop
    //   338: iload 6
    //   340: ifeq +58 -> 398
    //   343: aload_2
    //   344: ifnull +9 -> 353
    //   347: aload_1
    //   348: aload_2
    //   349: invokevirtual 291	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   352: pop
    //   353: aload_1
    //   354: aload 4
    //   356: invokevirtual 294	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   359: aload 5
    //   361: invokevirtual 297	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   364: aload 10
    //   366: invokevirtual 301	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   369: pop
    //   370: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   373: bipush 16
    //   375: if_icmplt +53 -> 428
    //   378: aload_1
    //   379: invokevirtual 153	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   382: astore_1
    //   383: aload_1
    //   384: areturn
    //   385: astore 11
    //   387: aload 11
    //   389: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   392: goto -102 -> 290
    //   395: goto -70 -> 325
    //   398: aload_1
    //   399: aload 4
    //   401: invokevirtual 294	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   404: aload 5
    //   406: invokevirtual 297	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   409: aload 10
    //   411: invokevirtual 301	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   414: pop
    //   415: aload_2
    //   416: ifnull -46 -> 370
    //   419: aload_1
    //   420: aload_2
    //   421: invokevirtual 291	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   424: pop
    //   425: goto -55 -> 370
    //   428: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   431: bipush 16
    //   433: if_icmpge +16 -> 449
    //   436: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   439: bipush 11
    //   441: if_icmplt +8 -> 449
    //   444: aload_1
    //   445: invokevirtual 156	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   448: areturn
    //   449: new 128	android/app/Notification
    //   452: dup
    //   453: iload 8
    //   455: aload_3
    //   456: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   459: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   462: astore_1
    //   463: aload_1
    //   464: areturn
    //   465: astore_1
    //   466: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq +14 -> 483
    //   472: ldc_w 303
    //   475: iconst_2
    //   476: aload_1
    //   477: invokevirtual 167	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   480: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: new 128	android/app/Notification
    //   486: dup
    //   487: iload 8
    //   489: aload_3
    //   490: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   493: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   496: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	this	KapalaiAdapterUtil
    //   0	497	1	paramIntent	Intent
    //   0	497	2	paramBitmap	Bitmap
    //   0	497	3	paramString1	String
    //   0	497	4	paramString2	String
    //   0	497	5	paramString3	String
    //   0	497	6	paramBoolean	boolean
    //   0	497	7	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   50	438	8	i	int
    //   46	277	9	j	int
    //   10	400	10	localPendingIntent	android.app.PendingIntent
    //   265	8	11	localMethod	Method
    //   385	3	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   245	267	385	java/lang/Exception
    //   272	290	385	java/lang/Exception
    //   370	383	465	java/lang/Exception
    //   428	449	465	java/lang/Exception
    //   449	463	465	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil
 * JD-Core Version:    0.7.0.1
 */