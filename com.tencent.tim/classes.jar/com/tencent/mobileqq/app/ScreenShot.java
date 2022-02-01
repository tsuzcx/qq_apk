package com.tencent.mobileqq.app;

import acbn;
import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.Toast;
import anot;
import aqoo;
import aqoq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.NativeUtil;

public class ScreenShot
  implements Handler.Callback, View.OnClickListener
{
  public static final String bpb = acbn.SDCARD_ROOT + "/QQ_Screenshot/";
  final ScreenView a;
  private final Handler cb;
  private ViewGroup e;
  Bitmap eL;
  Bitmap eM;
  Bitmap eN;
  Drawable ey;
  Drawable ez;
  Button fI;
  Button fJ;
  Button fK;
  Button fL;
  final Context mContext;
  private boolean mIsInit;
  private final Handler mUiHandler;
  Window mWindow;
  
  public ScreenShot(Context paramContext, Window paramWindow)
  {
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      for (paramWindow = (Activity)this.mContext; paramWindow.getParent() != null; paramWindow = paramWindow.getParent()) {}
    }
    for (this.mWindow = paramWindow.getWindow();; this.mWindow = paramWindow)
    {
      this.ey = paramContext.getResources().getDrawable(2130850597);
      this.ez = paramContext.getResources().getDrawable(2130850596);
      this.a = new ScreenView(this.mContext);
      this.mUiHandler = new Handler(Looper.getMainLooper(), this);
      this.cb = new Handler(ThreadManager.getFileThreadLooper(), this);
      if (Looper.getMainLooper() == Looper.myLooper()) {
        break;
      }
      this.mUiHandler.sendEmptyMessage(4);
      return;
    }
    initView();
  }
  
  public static void EN(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenShot", 2, paramString);
    }
  }
  
  private void FC(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.fI.setVisibility(8);
      this.fJ.setVisibility(8);
      this.fK.setVisibility(0);
      this.fL.setVisibility(0);
      return;
    }
    this.fI.setVisibility(0);
    this.fJ.setVisibility(0);
    this.fK.setVisibility(8);
    this.fL.setVisibility(8);
  }
  
  private boolean a(Bitmap paramBitmap)
  {
    int k = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Object localObject = this.mContext.getResources().getDisplayMetrics();
    int i = ((DisplayMetrics)localObject).widthPixels;
    int m = ((DisplayMetrics)localObject).heightPixels;
    if (((k == i) && (j == m)) || ((k == m) && (j == i)))
    {
      localObject = new int[k];
      paramBitmap.getPixels((int[])localObject, 0, k, 0, j / 2, k, 1);
      i = 0;
      while (i < k)
      {
        if (localObject[i] != -16777216) {
          return true;
        }
        i += 1;
      }
      localObject = new int[j];
      paramBitmap.getPixels((int[])localObject, 0, 1, k / 2, 0, 1, j);
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label151;
        }
        if (localObject[i] != -16777216) {
          break;
        }
        i += 1;
      }
    }
    label151:
    return false;
  }
  
  private boolean abE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity.ScreenShot", 2, "current phone Build.Model is " + Build.MODEL);
    }
    return (!Build.MODEL.contains("Galaxy Nexus")) && (!Build.MODEL.contains("HTC S720")) && (!Build.MODEL.contains("SM-N9006")) && ((!Build.MODEL.contains("ZTE U930")) || (Build.VERSION.SDK_INT != 16)) && ((!Build.MODEL.contains("HTC One X")) || (Build.VERSION.SDK_INT != 16)) && ((!Build.MODEL.contains("GT-I9260")) || (Build.VERSION.SDK_INT != 16)) && (!Build.MODEL.contains("vivo Y18L")) && (!Build.MODEL.contains("HM 1SW")) && (!Build.MODEL.contains("DOOV S2y")) && (!Build.MODEL.contains("H30-T10")) && (!Build.MODEL.contains("vivo Y17T")) && (!Build.MODEL.contains("HUAWEI B199")) && (!Build.MODEL.contains("NX511J")) && (!Build.MODEL.contains("vivo Y11iW")) && (!Build.MODEL.contains("R809")) && (!Build.MODEL.contains("V185")) && (!Build.MODEL.contains("I9300")) && (!Build.MODEL.contains("Lenovo S810t")) && (!Build.MODEL.contains("OPPO R7005")) && (!Build.MODEL.contains(acfp.m(2131714068))) && (!Build.MODEL.contains("vivo X5L")) && (!Build.MODEL.contains("OPPO N3")) && (!Build.MODEL.contains("OPPO R7")) && (!abF());
  }
  
  private boolean abF()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.MANUFACTURER.contains("Meizu")) {
      if ((!Build.MODEL.contains("M351")) && (!Build.MODEL.contains("M353")) && (!Build.MODEL.contains("M355")) && (!Build.MODEL.contains("M356")) && (!Build.MODEL.contains("MX4")) && (!Build.MODEL.contains("MX4 Pro")))
      {
        bool1 = bool2;
        if (!Build.MODEL.contains("m2 note")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void hide()
  {
    if (isShowing()) {
      ((WindowManager)this.mContext.getSystemService("window")).removeView(this.e);
    }
    for (;;)
    {
      this.eN = null;
      this.eL = null;
      this.eM = null;
      return;
      if (this.mUiHandler.hasMessages(4)) {
        this.mUiHandler.removeMessages(4);
      }
    }
  }
  
  private void initView()
  {
    this.e = ((ViewGroup)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131563002, null));
    this.e.addView(this.a, 0);
    this.fK = ((Button)this.e.findViewById(2131377743));
    this.fI = ((Button)this.e.findViewById(2131367793));
    this.fL = ((Button)this.e.findViewById(2131364221));
    this.fJ = ((Button)this.e.findViewById(2131365940));
    this.fL.setOnClickListener(this);
    this.fK.setOnClickListener(this);
    this.fI.setOnClickListener(this);
    this.fJ.setOnClickListener(this);
    this.mIsInit = true;
  }
  
  private void show()
  {
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (!isShowing())
    {
      localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      if (Build.VERSION.SDK_INT >= 26) {
        break label79;
      }
      localLayoutParams.type = 2003;
    }
    for (;;)
    {
      localLayoutParams.format = 1;
      localLayoutParams.flags |= 0x100;
      try
      {
        localWindowManager.addView(this.e, localLayoutParams);
        EN("ScreenShot show");
        return;
        label79:
        localLayoutParams.type = 2038;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ScreenShot", 2, "", localThrowable);
          }
        }
      }
    }
  }
  
  public static native int snapScreen(int paramInt1, int paramInt2);
  
  public boolean activate()
  {
    this.a.state = 0;
    this.a.rect.setEmpty();
    this.eM = null;
    FC(false);
    if (abE()) {}
    try
    {
      Bitmap localBitmap = NativeUtil.screenshot(this.mContext);
      this.eL = localBitmap;
      this.eN = localBitmap;
      if ((this.eL != null) && (!a(this.eL)))
      {
        this.eL = null;
        this.eN = null;
      }
      EN("ScreenShot activate");
      bool = this.mContext instanceof Activity;
      if ((!bool) && (this.eL == null)) {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShot", 2, "", localThrowable);
        }
      }
      this.mUiHandler.sendEmptyMessage(3);
      if (!bool) {}
    }
    for (String str = "1";; str = "0")
    {
      anot.a(null, "CliOper", "", "", "0X8005006", "0X8005006", 0, 0, str, "", "", "");
      return true;
    }
  }
  
  public void cMo()
  {
    EN("disactivate");
    hide();
    anot.a(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "0", "", "", "");
  }
  
  /* Error */
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: getfield 440	android/os/Message:what	I
    //   7: tableswitch	default:+29 -> 36, 1:+43->50, 2:+150->157, 3:+37->44, 4:+31->38
    //   37: ireturn
    //   38: aload_0
    //   39: invokespecial 132	com/tencent/mobileqq/app/ScreenShot:initView	()V
    //   42: iconst_1
    //   43: ireturn
    //   44: aload_0
    //   45: invokespecial 442	com/tencent/mobileqq/app/ScreenShot:show	()V
    //   48: iconst_1
    //   49: ireturn
    //   50: aload_1
    //   51: getfield 445	android/os/Message:arg1	I
    //   54: iconst_1
    //   55: if_icmpne +83 -> 138
    //   58: aload_1
    //   59: getfield 449	android/os/Message:obj	Ljava/lang/Object;
    //   62: checkcast 10	com/tencent/mobileqq/app/ScreenShot$ScreenView
    //   65: astore_1
    //   66: aload_1
    //   67: ldc_w 450
    //   70: putfield 386	com/tencent/mobileqq/app/ScreenShot$ScreenView:state	I
    //   73: aload_0
    //   74: iconst_0
    //   75: invokespecial 170	com/tencent/mobileqq/app/ScreenShot:FC	(Z)V
    //   78: aload_1
    //   79: invokevirtual 453	com/tencent/mobileqq/app/ScreenShot$ScreenView:invalidate	()V
    //   82: aload_1
    //   83: aconst_null
    //   84: new 455	com/tencent/mobileqq/app/ScreenShot$1
    //   87: dup
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 458	com/tencent/mobileqq/app/ScreenShot$1:<init>	(Lcom/tencent/mobileqq/app/ScreenShot;Lcom/tencent/mobileqq/app/ScreenShot$ScreenView;)V
    //   93: invokestatic 464	android/os/SystemClock:uptimeMillis	()J
    //   96: ldc2_w 465
    //   99: ladd
    //   100: invokevirtual 470	com/tencent/mobileqq/app/ScreenShot$ScreenView:scheduleDrawable	(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V
    //   103: aload_0
    //   104: getfield 67	com/tencent/mobileqq/app/ScreenShot:mContext	Landroid/content/Context;
    //   107: invokevirtual 474	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   110: aload_0
    //   111: getfield 67	com/tencent/mobileqq/app/ScreenShot:mContext	Landroid/content/Context;
    //   114: ldc_w 475
    //   117: invokevirtual 478	android/content/Context:getString	(I)Ljava/lang/String;
    //   120: ldc_w 480
    //   123: getstatic 62	com/tencent/mobileqq/app/ScreenShot:bpb	Ljava/lang/String;
    //   126: invokevirtual 484	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   129: iconst_1
    //   130: invokestatic 490	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   133: invokevirtual 491	android/widget/Toast:show	()V
    //   136: iconst_1
    //   137: ireturn
    //   138: aload_0
    //   139: getfield 67	com/tencent/mobileqq/app/ScreenShot:mContext	Landroid/content/Context;
    //   142: invokevirtual 474	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   145: ldc_w 492
    //   148: iconst_1
    //   149: invokestatic 495	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   152: invokevirtual 491	android/widget/Toast:show	()V
    //   155: iconst_1
    //   156: ireturn
    //   157: aload_1
    //   158: getfield 449	android/os/Message:obj	Ljava/lang/Object;
    //   161: checkcast 10	com/tencent/mobileqq/app/ScreenShot$ScreenView
    //   164: astore 6
    //   166: new 497	java/io/File
    //   169: dup
    //   170: getstatic 62	com/tencent/mobileqq/app/ScreenShot:bpb	Ljava/lang/String;
    //   173: invokespecial 499	java/io/File:<init>	(Ljava/lang/String;)V
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 502	java/io/File:exists	()Z
    //   181: ifne +8 -> 189
    //   184: aload_1
    //   185: invokevirtual 505	java/io/File:mkdirs	()Z
    //   188: pop
    //   189: new 497	java/io/File
    //   192: dup
    //   193: new 42	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   200: getstatic 62	com/tencent/mobileqq/app/ScreenShot:bpb	Ljava/lang/String;
    //   203: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokestatic 510	java/lang/System:currentTimeMillis	()J
    //   209: invokevirtual 513	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: ldc_w 515
    //   215: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokespecial 499	java/io/File:<init>	(Ljava/lang/String;)V
    //   224: astore 5
    //   226: aload 5
    //   228: ifnull +197 -> 425
    //   231: new 517	java/io/FileOutputStream
    //   234: dup
    //   235: aload 5
    //   237: invokespecial 520	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   240: astore_1
    //   241: aload 6
    //   243: getfield 523	com/tencent/mobileqq/app/ScreenShot$ScreenView:eO	Landroid/graphics/Bitmap;
    //   246: getstatic 529	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   249: bipush 80
    //   251: aload_1
    //   252: invokevirtual 533	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   255: istore_3
    //   256: aload 6
    //   258: aconst_null
    //   259: putfield 523	com/tencent/mobileqq/app/ScreenShot$ScreenView:eO	Landroid/graphics/Bitmap;
    //   262: aload_1
    //   263: ifnull +167 -> 430
    //   266: aload_1
    //   267: invokevirtual 536	java/io/FileOutputStream:close	()V
    //   270: aload_0
    //   271: getfield 67	com/tencent/mobileqq/app/ScreenShot:mContext	Landroid/content/Context;
    //   274: invokestatic 542	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   277: invokeinterface 548 1 0
    //   282: astore_1
    //   283: aload_1
    //   284: ldc_w 550
    //   287: aload 5
    //   289: invokestatic 556	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   292: invokevirtual 557	android/net/Uri:toString	()Ljava/lang/String;
    //   295: invokeinterface 563 3 0
    //   300: pop
    //   301: aload_1
    //   302: invokeinterface 566 1 0
    //   307: pop
    //   308: aload_0
    //   309: getfield 67	com/tencent/mobileqq/app/ScreenShot:mContext	Landroid/content/Context;
    //   312: new 568	android/content/Intent
    //   315: dup
    //   316: ldc_w 570
    //   319: aload 5
    //   321: invokestatic 556	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   324: invokespecial 573	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   327: invokevirtual 577	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   330: aload_0
    //   331: getfield 115	com/tencent/mobileqq/app/ScreenShot:mUiHandler	Landroid/os/Handler;
    //   334: astore_1
    //   335: iload_3
    //   336: ifeq +63 -> 399
    //   339: iconst_1
    //   340: istore_2
    //   341: aload_1
    //   342: iconst_1
    //   343: iload_2
    //   344: iconst_0
    //   345: aload 6
    //   347: invokevirtual 581	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   350: invokevirtual 584	android/os/Message:sendToTarget	()V
    //   353: iconst_1
    //   354: ireturn
    //   355: aload 6
    //   357: aconst_null
    //   358: putfield 523	com/tencent/mobileqq/app/ScreenShot$ScreenView:eO	Landroid/graphics/Bitmap;
    //   361: aload_1
    //   362: ifnull +63 -> 425
    //   365: aload_1
    //   366: invokevirtual 536	java/io/FileOutputStream:close	()V
    //   369: iconst_0
    //   370: istore_3
    //   371: goto -101 -> 270
    //   374: astore_1
    //   375: iconst_0
    //   376: istore_3
    //   377: goto -107 -> 270
    //   380: astore_1
    //   381: aload 6
    //   383: aconst_null
    //   384: putfield 523	com/tencent/mobileqq/app/ScreenShot$ScreenView:eO	Landroid/graphics/Bitmap;
    //   387: aload 4
    //   389: ifnull +8 -> 397
    //   392: aload 4
    //   394: invokevirtual 536	java/io/FileOutputStream:close	()V
    //   397: aload_1
    //   398: athrow
    //   399: iconst_0
    //   400: istore_2
    //   401: goto -60 -> 341
    //   404: astore 4
    //   406: goto -9 -> 397
    //   409: astore 5
    //   411: aload_1
    //   412: astore 4
    //   414: aload 5
    //   416: astore_1
    //   417: goto -36 -> 381
    //   420: astore 4
    //   422: goto -67 -> 355
    //   425: iconst_0
    //   426: istore_3
    //   427: goto -157 -> 270
    //   430: goto -160 -> 270
    //   433: astore_1
    //   434: iconst_1
    //   435: ireturn
    //   436: astore_1
    //   437: goto -167 -> 270
    //   440: astore_1
    //   441: aconst_null
    //   442: astore_1
    //   443: goto -88 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	this	ScreenShot
    //   0	446	1	paramMessage	Message
    //   340	61	2	i	int
    //   255	172	3	bool	boolean
    //   1	392	4	localObject1	Object
    //   404	1	4	localIOException	java.io.IOException
    //   412	1	4	localMessage	Message
    //   420	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   224	96	5	localFile	java.io.File
    //   409	6	5	localObject2	Object
    //   164	218	6	localScreenView	ScreenView
    // Exception table:
    //   from	to	target	type
    //   365	369	374	java/io/IOException
    //   231	241	380	finally
    //   392	397	404	java/io/IOException
    //   241	256	409	finally
    //   241	256	420	java/io/FileNotFoundException
    //   157	189	433	java/lang/Exception
    //   189	226	433	java/lang/Exception
    //   256	262	433	java/lang/Exception
    //   266	270	433	java/lang/Exception
    //   270	335	433	java/lang/Exception
    //   341	353	433	java/lang/Exception
    //   355	361	433	java/lang/Exception
    //   365	369	433	java/lang/Exception
    //   381	387	433	java/lang/Exception
    //   392	397	433	java/lang/Exception
    //   397	399	433	java/lang/Exception
    //   266	270	436	java/io/IOException
    //   231	241	440	java/io/FileNotFoundException
  }
  
  public boolean isInit()
  {
    return this.mIsInit;
  }
  
  public boolean isShowing()
  {
    return (this.e != null) && (this.e.getParent() != null);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.FD(true);
      if ((!aqoq.cVk) && (Build.VERSION.SDK_INT < 11))
      {
        aqoo.a().setActivityWindowType_TYPE_APPLICATION(this.mWindow);
        continue;
        this.a.FD(false);
        if ((!aqoq.cVk) && (Build.VERSION.SDK_INT < 11))
        {
          aqoo.a().setActivityWindowType_TYPE_APPLICATION(this.mWindow);
          continue;
          EN("click disable");
          hide();
          anot.a(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "1", "", "", "");
          if ((!aqoq.cVk) && (Build.VERSION.SDK_INT < 11))
          {
            aqoo.a().setActivityWindowType_TYPE_APPLICATION(this.mWindow);
            continue;
            EN("click cancel");
            hide();
            anot.a(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "2", "", "", "");
            if ((!aqoq.cVk) && (Build.VERSION.SDK_INT < 11)) {
              aqoo.a().setActivityWindowType_TYPE_APPLICATION(this.mWindow);
            }
          }
        }
      }
    }
  }
  
  class ScreenView
    extends View
  {
    final Matrix G = new Matrix();
    boolean bJl;
    final Paint bx = new Paint();
    int cxU;
    int cxV;
    int cxW;
    int cxX;
    int cxY;
    Bitmap eO;
    final Paint paint = new Paint();
    final Matrix q = new Matrix();
    final Rect rect = new Rect();
    int state;
    final Rect tmp = new Rect();
    
    public ScreenView(Context paramContext)
    {
      super();
      setLongClickable(true);
    }
    
    public void FD(boolean paramBoolean)
    {
      Object localObject;
      if (paramBoolean)
      {
        if (ScreenShot.this.eL != null) {
          break label242;
        }
        localObject = new Rect();
        ScreenShot.this.mWindow.getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      }
      label236:
      label242:
      for (int i = ((Rect)localObject).top;; i = 0)
      {
        if (ScreenShot.this.eN != null)
        {
          if (this.q.isIdentity()) {
            this.rect.set(0, i, ScreenShot.this.eN.getWidth(), ScreenShot.this.eN.getHeight());
          }
        }
        else
        {
          if (this.rect.isEmpty())
          {
            this.rect.left = getLeft();
            this.rect.right = getRight();
            this.rect.top = getTop();
            this.rect.bottom = getBottom();
          }
          if ((this.rect.width() > 0) && (this.rect.height() > 0))
          {
            this.bJl = true;
            if (!paramBoolean) {
              break label236;
            }
          }
        }
        for (localObject = "1";; localObject = "0")
        {
          anot.a(null, "CliOper", "", "", "0X8005007", "0X8005007", 0, 0, (String)localObject, "", "", "");
          invalidate();
          return;
          this.rect.set(i, 0, ScreenShot.this.eN.getHeight(), ScreenShot.this.eN.getWidth());
          break;
        }
      }
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      super.onDraw(paramCanvas);
      Object localObject;
      float f;
      if (ScreenShot.this.eL != null)
      {
        ScreenShot.this.eN = ScreenShot.this.eL;
        this.q.reset();
        localObject = getResources().getDisplayMetrics();
        this.q.reset();
        if ((((DisplayMetrics)localObject).heightPixels == ScreenShot.this.eN.getWidth()) && (((DisplayMetrics)localObject).widthPixels == ScreenShot.this.eN.getHeight()))
        {
          this.q.postTranslate(-ScreenShot.this.eN.getWidth() / 2, -ScreenShot.this.eN.getHeight() / 2);
          this.q.postRotate(90.0F);
          this.q.postTranslate(ScreenShot.this.eN.getHeight() / 2, ScreenShot.this.eN.getWidth() / 2);
        }
        if (ScreenShot.this.eN != null) {
          paramCanvas.drawBitmap(ScreenShot.this.eN, this.q, this.paint);
        }
        if ((this.state == 0) || (this.state == 100001)) {
          break label839;
        }
        this.paint.setStrokeWidth(3.0F);
        localObject = this.paint;
        i = this.cxY + 1;
        this.cxY = i;
        f = i;
        ((Paint)localObject).setPathEffect(new DashPathEffect(new float[] { 15.0F, 5.0F, 8.0F, 5.0F }, f));
        invalidate();
        this.paint.setColor(-16847);
        if (this.rect.left > this.rect.right)
        {
          i = this.rect.left;
          this.rect.left = this.rect.right;
          this.rect.right = i;
        }
        if (this.rect.top > this.rect.bottom)
        {
          i = this.rect.top;
          this.rect.top = this.rect.bottom;
          this.rect.bottom = i;
        }
        if ((!this.bJl) || (ScreenShot.this.eN == null)) {
          break label965;
        }
        this.bJl = false;
      }
      label839:
      do
      {
        try
        {
          for (;;)
          {
            this.eO = Bitmap.createBitmap(this.rect.width(), this.rect.height(), Bitmap.Config.ARGB_8888);
            localObject = new Canvas(this.eO);
            this.G.reset();
            this.G.postConcat(this.q);
            this.G.postTranslate(-this.rect.left, -this.rect.top);
            if (ScreenShot.this.eN != null) {
              ((Canvas)localObject).drawBitmap(ScreenShot.this.eN, this.G, this.paint);
            }
            this.paint.setColor(-2147483648);
            this.paint.setStyle(Paint.Style.FILL);
            paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.paint);
            ScreenShot.EN("save and hide");
            ScreenShot.a(ScreenShot.this);
            if (this.eO != null) {
              break label947;
            }
            Toast.makeText(ScreenShot.this.mContext.getApplicationContext(), 2131718925, 1).show();
            return;
            i = getWidth();
            j = getHeight();
            if ((ScreenShot.this.eM == null) && (i > 0) && (j > 0)) {}
            try
            {
              ScreenShot.this.eM = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
              if (ScreenShot.this.eM != null)
              {
                localObject = new Canvas(ScreenShot.this.eM);
                ScreenShot.this.mWindow.getDecorView().draw((Canvas)localObject);
                ScreenShot.this.eN = ScreenShot.this.eM;
              }
              this.q.reset();
              if ((ScreenShot.this.eN == null) || (ScreenShot.this.eN.getWidth() == i)) {
                break;
              }
              this.q.postTranslate(-ScreenShot.this.eN.getWidth() / 2, -ScreenShot.this.eN.getHeight() / 2);
              this.q.postRotate(90.0F);
              this.q.postTranslate(ScreenShot.this.eN.getHeight() / 2, ScreenShot.this.eN.getWidth() / 2);
            }
            catch (Throwable localThrowable1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("mqq", 2, "", localThrowable1);
                }
              }
            }
          }
          this.paint.setStrokeWidth(1.0F);
          this.paint.setPathEffect(null);
          this.cxY = 0;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ScreenShot", 2, this.rect.width() + ":" + this.rect.height(), localIllegalArgumentException);
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            this.eO = null;
            if (QLog.isColorLevel()) {
              QLog.d("ScreenShot", 2, "", localThrowable2);
            }
          }
          ScreenShot.a(ScreenShot.this).obtainMessage(2, 0, 0, this).sendToTarget();
          return;
        }
        this.paint.setColor(-2147483648);
        this.paint.setStyle(Paint.Style.FILL);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.rect.top, this.paint);
        paramCanvas.drawRect(0.0F, this.rect.bottom, getWidth(), getHeight(), this.paint);
        paramCanvas.drawRect(0.0F, this.rect.top, this.rect.left, this.rect.bottom, this.paint);
        paramCanvas.drawRect(this.rect.right, this.rect.top, getWidth(), this.rect.bottom, this.paint);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(-16847);
        paramCanvas.drawRect(this.rect, this.paint);
        if (this.rect.isEmpty())
        {
          i = getWidth() / 2 - ScreenShot.this.ey.getIntrinsicWidth() / 2;
          j = getHeight() / 2 - ScreenShot.this.ey.getIntrinsicHeight() / 2;
          k = ScreenShot.this.ey.getIntrinsicWidth();
          m = ScreenShot.this.ey.getIntrinsicHeight() + j;
          f = getResources().getDisplayMetrics().density;
          ScreenShot.this.ey.setBounds(i, j, k + i, m);
          ScreenShot.this.ey.draw(paramCanvas);
          this.bx.setTextSize(20.0F * getResources().getDisplayMetrics().scaledDensity);
          this.bx.setAntiAlias(true);
          this.bx.setTextAlign(Paint.Align.CENTER);
          this.bx.setColor(-1);
          this.bx.setShadowLayer(2.0F, 0.0F, 2.0F * f, -2147483648);
          paramCanvas.drawText(ScreenShot.this.mContext.getString(2131720374), getWidth() / 2, m + 26.0F * f, this.bx);
        }
      } while ((this.state == 100001) || (this.state == 0));
      label947:
      label965:
      this.paint.setStyle(Paint.Style.FILL);
      int k = this.rect.left - ScreenShot.this.ez.getIntrinsicWidth() / 2;
      int i = this.rect.top - ScreenShot.this.ez.getIntrinsicHeight() / 2;
      int m = ScreenShot.this.ez.getIntrinsicWidth();
      int j = ScreenShot.this.ez.getIntrinsicHeight() + i;
      ScreenShot.this.ez.setBounds(k, i, m + k, j);
      ScreenShot.this.ez.draw(paramCanvas);
      k = this.rect.right - ScreenShot.this.ez.getIntrinsicWidth() / 2;
      m = ScreenShot.this.ez.getIntrinsicWidth() + k;
      ScreenShot.this.ez.setBounds(k, i, m, j);
      ScreenShot.this.ez.draw(paramCanvas);
      i = this.rect.bottom - ScreenShot.this.ez.getIntrinsicHeight() / 2;
      j = ScreenShot.this.ez.getIntrinsicHeight() + i;
      ScreenShot.this.ez.setBounds(k, i, m, j);
      ScreenShot.this.ez.draw(paramCanvas);
      k = this.rect.left - ScreenShot.this.ez.getIntrinsicWidth() / 2;
      m = ScreenShot.this.ez.getIntrinsicWidth();
      ScreenShot.this.ez.setBounds(k, i, m + k, j);
      ScreenShot.this.ez.draw(paramCanvas);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      default: 
        return super.onTouchEvent(paramMotionEvent);
      case 0: 
        this.cxU = ((int)paramMotionEvent.getX());
        this.cxV = ((int)paramMotionEvent.getY());
        if (!this.rect.isEmpty()) {
          if (this.rect.contains(this.cxU, this.cxV)) {
            this.state = 100004;
          }
        }
        for (;;)
        {
          invalidate();
          break;
          if (new Rect(this.rect.left - 20, this.rect.top - 20, this.rect.right + 20, this.rect.bottom + 20).contains(this.cxU, this.cxV))
          {
            this.state = 100005;
            this.tmp.set(this.rect);
          }
          else
          {
            this.rect.setEmpty();
            this.state = 100001;
            this.paint.setStrokeWidth(1.0F);
            this.paint.setPathEffect(null);
            ScreenShot.a(ScreenShot.this, false);
            continue;
            this.state = 100001;
            ScreenShot.a(ScreenShot.this, false);
          }
        }
      case 1: 
        if (Math.abs(this.rect.width()) < 5) {
          this.rect.setEmpty();
        }
        break;
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          this.state = 100002;
          ScreenShot.a(ScreenShot.this, true);
        }
        for (;;)
        {
          invalidate();
          break;
          this.state = 0;
          ScreenShot.a(ScreenShot.this, false);
        }
        this.cxW = ((int)paramMotionEvent.getX());
        this.cxX = ((int)paramMotionEvent.getY());
        int j;
        Rect localRect;
        if (this.state == 100004)
        {
          i = this.cxW - this.cxU;
          j = this.cxX - this.cxV;
          this.cxU = this.cxW;
          this.cxV = this.cxX;
          if ((this.rect.left + i >= 0) && (this.rect.right + i <= getWidth()))
          {
            localRect = this.rect;
            localRect.left += i;
            localRect = this.rect;
            localRect.right = (i + localRect.right);
          }
          if ((this.rect.top + j >= 0) && (this.rect.bottom + j <= getHeight()))
          {
            localRect = this.rect;
            localRect.top += j;
            localRect = this.rect;
            localRect.bottom = (j + localRect.bottom);
          }
        }
        for (;;)
        {
          ScreenShot.this.fI.setVisibility(8);
          ScreenShot.this.fJ.setVisibility(8);
          ScreenShot.this.fK.setVisibility(8);
          ScreenShot.this.fL.setVisibility(8);
          invalidate();
          break;
          if (this.state == 100001)
          {
            this.rect.left = this.cxU;
            this.rect.top = this.cxV;
            this.rect.right = this.cxW;
            this.rect.bottom = this.cxX;
          }
          else if (this.state == 100005)
          {
            i = this.cxW - this.cxU;
            j = this.cxX - this.cxV;
            this.rect.set(this.tmp);
            if (this.cxU < this.rect.left + this.rect.width() / 2)
            {
              localRect = this.rect;
              localRect.left = (i + localRect.left);
              this.rect.left = Math.max(this.rect.left, 0);
            }
            for (;;)
            {
              if (this.cxV >= this.rect.top + this.rect.height() / 2) {
                break label812;
              }
              localRect = this.rect;
              localRect.top = (j + localRect.top);
              this.rect.top = Math.max(this.rect.top, 0);
              break;
              localRect = this.rect;
              localRect.right = (i + localRect.right);
              this.rect.right = Math.min(this.rect.right, getWidth());
            }
            label812:
            localRect = this.rect;
            localRect.bottom = (j + localRect.bottom);
            this.rect.bottom = Math.min(this.rect.bottom, getHeight());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot
 * JD-Core Version:    0.7.0.1
 */