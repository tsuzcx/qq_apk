package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import wja;

public class ColorNoteSmallScreenFullToast
  extends RelativeLayout
  implements View.OnClickListener
{
  private RelativeLayout.LayoutParams F;
  public boolean VA = false;
  private a a;
  private Context mContext;
  private WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
  private WindowManager mWindowManager;
  private ImageView yt;
  
  public ColorNoteSmallScreenFullToast(Context paramContext, a parama)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.a = parama;
    this.mWindowManager = ((WindowManager)this.mContext.getSystemService("window"));
    this.mLayoutParams.height = -1;
    this.mLayoutParams.width = -1;
    this.mLayoutParams.format = -3;
    this.mLayoutParams.windowAnimations = 0;
    this.mLayoutParams.gravity = 51;
    this.mLayoutParams.setTitle("Toast");
    this.mLayoutParams.flags = 768;
    if (Build.VERSION.SDK_INT >= 26) {}
    for (this.mLayoutParams.type = 2038;; this.mLayoutParams.type = 2002)
    {
      this.yt = new ImageView(paramContext);
      this.yt.setContentDescription(paramContext.getResources().getString(2131691729));
      this.yt.setBackgroundResource(2130839500);
      this.yt.setVisibility(8);
      this.F = new RelativeLayout.LayoutParams(wja.dp2px(24.0F, paramContext.getResources()), wja.dp2px(24.0F, paramContext.getResources()));
      addView(this.yt, this.F);
      setOnClickListener(this);
      this.yt.setOnClickListener(this);
      return;
    }
  }
  
  public void arg()
  {
    try
    {
      if (this.VA) {
        this.VA = false;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler removeView start");
        }
        if (this.F != null)
        {
          this.F.leftMargin = 0;
          this.F.topMargin = 0;
          this.yt.requestLayout();
        }
        this.yt.setVisibility(8);
        this.mWindowManager.removeView(this);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler removeView end");
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenFullToast", 2, "stopHandler error : " + localIllegalArgumentException);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (this.a != null) {
        this.a.cVS();
      }
      arg();
      return true;
    }
    return false;
  }
  
  public void hF(int paramInt1, int paramInt2)
  {
    if (this.F != null)
    {
      this.F.leftMargin = (paramInt1 - wja.dp2px(12.0F, getResources()));
      int[] arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      this.F.topMargin = (paramInt2 - wja.dp2px(5.5F, getResources()) - arrayOfInt[1]);
      this.yt.requestLayout();
    }
    if (this.yt.getVisibility() == 8) {
      this.yt.setVisibility(0);
    }
    this.yt.setAlpha(0.0F);
    this.yt.animate().alpha(1.0F).setDuration(150L).setInterpolator(new LinearInterpolator()).start();
  }
  
  public void onClick(View paramView)
  {
    arg();
    if (paramView == this) {
      if (this.a != null) {
        this.a.cVT();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.yt) && (this.a != null)) {
        this.a.cVU();
      }
    }
  }
  
  /* Error */
  public boolean vG()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: iload_2
    //   5: istore_1
    //   6: aload_0
    //   7: getfield 36	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:VA	Z
    //   10: ifne +56 -> 66
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield 36	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:VA	Z
    //   18: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 147
    //   26: iconst_2
    //   27: ldc_w 265
    //   30: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 52	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:mWindowManager	Landroid/view/WindowManager;
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 34	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:mLayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   42: invokeinterface 266 3 0
    //   47: iload_2
    //   48: istore_1
    //   49: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +14 -> 66
    //   55: ldc 147
    //   57: iconst_2
    //   58: ldc_w 268
    //   61: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: iload_2
    //   65: istore_1
    //   66: aload_0
    //   67: invokevirtual 272	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   70: checkcast 29	android/view/WindowManager$LayoutParams
    //   73: ifnull +258 -> 331
    //   76: iload_1
    //   77: ifeq +254 -> 331
    //   80: aload_0
    //   81: getfield 38	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:mContext	Landroid/content/Context;
    //   84: invokestatic 278	aeds:checkPermission	(Landroid/content/Context;)Z
    //   87: istore_1
    //   88: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +58 -> 149
    //   94: ldc 147
    //   96: iconst_2
    //   97: new 170	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 280
    //   107: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: getfield 36	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:VA	Z
    //   114: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: ldc 147
    //   125: iconst_2
    //   126: new 170	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 285
    //   136: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: iload_1
    //   140: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   143: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_0
    //   150: monitorexit
    //   151: iload_1
    //   152: ireturn
    //   153: astore_3
    //   154: aload_0
    //   155: getfield 52	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:mWindowManager	Landroid/view/WindowManager;
    //   158: aload_0
    //   159: aload_0
    //   160: getfield 34	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:mLayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   163: invokeinterface 288 3 0
    //   168: iload_2
    //   169: istore_1
    //   170: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq -107 -> 66
    //   176: ldc 147
    //   178: iconst_2
    //   179: new 170	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 290
    //   189: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_3
    //   193: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: iload_2
    //   203: istore_1
    //   204: goto -138 -> 66
    //   207: astore_3
    //   208: aload_0
    //   209: monitorexit
    //   210: aload_3
    //   211: athrow
    //   212: astore_3
    //   213: aload_0
    //   214: iconst_0
    //   215: putfield 36	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:VA	Z
    //   218: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +113 -> 334
    //   224: ldc 147
    //   226: iconst_2
    //   227: new 170	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 290
    //   237: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_3
    //   241: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: goto +84 -> 334
    //   253: astore_3
    //   254: aload_0
    //   255: iconst_0
    //   256: putfield 36	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:VA	Z
    //   259: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +77 -> 339
    //   265: ldc 147
    //   267: iconst_2
    //   268: new 170	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 290
    //   278: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_3
    //   282: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: goto +48 -> 339
    //   294: astore_3
    //   295: aload_0
    //   296: iconst_0
    //   297: putfield 36	com/tencent/mobileqq/colornote/smallscreen/ColorNoteSmallScreenFullToast:VA	Z
    //   300: ldc 147
    //   302: iconst_2
    //   303: new 170	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 290
    //   313: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_3
    //   317: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: iconst_0
    //   327: istore_1
    //   328: goto -262 -> 66
    //   331: goto -243 -> 88
    //   334: iconst_0
    //   335: istore_1
    //   336: goto -270 -> 66
    //   339: iconst_0
    //   340: istore_1
    //   341: goto -275 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	ColorNoteSmallScreenFullToast
    //   5	336	1	bool1	boolean
    //   1	202	2	bool2	boolean
    //   153	40	3	localIllegalStateException	java.lang.IllegalStateException
    //   207	4	3	localObject	Object
    //   212	29	3	localBadTokenException	android.view.WindowManager.BadTokenException
    //   253	29	3	localSecurityException	java.lang.SecurityException
    //   294	23	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   18	33	153	java/lang/IllegalStateException
    //   33	47	153	java/lang/IllegalStateException
    //   49	64	153	java/lang/IllegalStateException
    //   6	18	207	finally
    //   18	33	207	finally
    //   33	47	207	finally
    //   49	64	207	finally
    //   66	76	207	finally
    //   80	88	207	finally
    //   88	149	207	finally
    //   149	151	207	finally
    //   154	168	207	finally
    //   170	202	207	finally
    //   208	210	207	finally
    //   213	250	207	finally
    //   254	291	207	finally
    //   295	326	207	finally
    //   18	33	212	android/view/WindowManager$BadTokenException
    //   33	47	212	android/view/WindowManager$BadTokenException
    //   49	64	212	android/view/WindowManager$BadTokenException
    //   18	33	253	java/lang/SecurityException
    //   33	47	253	java/lang/SecurityException
    //   49	64	253	java/lang/SecurityException
    //   18	33	294	java/lang/Exception
    //   33	47	294	java/lang/Exception
    //   49	64	294	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void cVS();
    
    public abstract void cVT();
    
    public abstract void cVU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenFullToast
 * JD-Core Version:    0.7.0.1
 */