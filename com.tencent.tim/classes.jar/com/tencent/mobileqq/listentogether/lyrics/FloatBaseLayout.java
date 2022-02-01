package com.tencent.mobileqq.listentogether.lyrics;

import aipa;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import wja;

public class FloatBaseLayout
  extends FrameLayout
{
  aipa a;
  boolean ckV = false;
  boolean ckW = false;
  public int dem;
  public int den;
  int deo = 0;
  boolean mAdded = false;
  WindowManager.LayoutParams mLayoutParams;
  WindowManager mWindowManager;
  float wQ;
  float wR;
  float wS;
  float wT;
  float wU = 6.0F;
  
  public FloatBaseLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    ey(paramContext);
  }
  
  private void arf()
  {
    try
    {
      int i = ((Integer)this.mLayoutParams.getClass().getField("privateFlags").get(this.mLayoutParams)).intValue();
      this.mLayoutParams.getClass().getField("privateFlags").set(this.mLayoutParams, Integer.valueOf(i | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  private void ey(Context paramContext)
  {
    this.wU = wja.dp2px(3.0F, getResources());
    this.mWindowManager = ((WindowManager)getContext().getSystemService("window"));
    this.mLayoutParams = new WindowManager.LayoutParams();
    this.mLayoutParams.format = -3;
    this.mLayoutParams.flags = 808;
    if (Build.VERSION.SDK_INT >= 26) {}
    for (this.mLayoutParams.type = 2038;; this.mLayoutParams.type = 2002)
    {
      this.mLayoutParams.systemUiVisibility = 5892;
      this.mLayoutParams.gravity = 85;
      this.mLayoutParams.setTitle("FloatBaseLayout");
      this.mLayoutParams.x = 0;
      this.mLayoutParams.y = 0;
      arf();
      return;
    }
  }
  
  public int FN()
  {
    return this.mLayoutParams.x + this.mLayoutParams.width / 2;
  }
  
  public int FO()
  {
    return this.mLayoutParams.x + this.mLayoutParams.width;
  }
  
  public int FP()
  {
    return this.mLayoutParams.x;
  }
  
  public int FQ()
  {
    return this.dem;
  }
  
  public int FR()
  {
    return this.den;
  }
  
  /* Error */
  public boolean apm()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 138
    //   10: iconst_2
    //   11: new 173	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   18: ldc 176
    //   20: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 31	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:mAdded	Z
    //   27: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 31	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:mAdded	Z
    //   42: ifne +103 -> 145
    //   45: aload_0
    //   46: getfield 33	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:deo	I
    //   49: istore_1
    //   50: iload_3
    //   51: istore_2
    //   52: iload_1
    //   53: iconst_4
    //   54: if_icmpge +29 -> 83
    //   57: aload_0
    //   58: getfield 112	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:mWindowManager	Landroid/view/WindowManager;
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 51	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:mLayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   66: invokeinterface 195 3 0
    //   71: aload_0
    //   72: iconst_1
    //   73: putfield 31	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:mAdded	Z
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 33	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:deo	I
    //   81: iload_3
    //   82: istore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: iload_2
    //   86: ireturn
    //   87: astore 5
    //   89: aload_0
    //   90: aload_0
    //   91: getfield 33	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:deo	I
    //   94: iconst_1
    //   95: iadd
    //   96: putfield 33	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:deo	I
    //   99: ldc 138
    //   101: iconst_1
    //   102: new 173	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   109: ldc 197
    //   111: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_0
    //   115: getfield 33	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:deo	I
    //   118: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc 202
    //   123: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 5
    //   128: invokevirtual 205	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   131: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: iconst_0
    //   141: istore_2
    //   142: goto -59 -> 83
    //   145: aload_0
    //   146: getfield 31	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:mAdded	Z
    //   149: istore 4
    //   151: iload_3
    //   152: istore_2
    //   153: iload 4
    //   155: ifeq -72 -> 83
    //   158: aload_0
    //   159: getfield 112	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:mWindowManager	Landroid/view/WindowManager;
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 51	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:mLayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   167: invokeinterface 211 3 0
    //   172: iload_3
    //   173: istore_2
    //   174: goto -91 -> 83
    //   177: astore 5
    //   179: ldc 138
    //   181: iconst_1
    //   182: new 173	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   189: ldc 213
    //   191: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 5
    //   196: invokevirtual 205	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: iconst_0
    //   209: istore_2
    //   210: goto -127 -> 83
    //   213: astore 5
    //   215: aload_0
    //   216: monitorexit
    //   217: aload 5
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	FloatBaseLayout
    //   49	6	1	i	int
    //   51	159	2	bool1	boolean
    //   1	172	3	bool2	boolean
    //   149	5	4	bool3	boolean
    //   87	40	5	localThrowable1	Throwable
    //   177	18	5	localThrowable2	Throwable
    //   213	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   57	81	87	java/lang/Throwable
    //   158	172	177	java/lang/Throwable
    //   38	50	213	finally
    //   57	81	213	finally
    //   83	85	213	finally
    //   89	140	213	finally
    //   145	151	213	finally
    //   158	172	213	finally
    //   179	208	213	finally
    //   215	217	213	finally
  }
  
  public boolean apn()
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      boolean bool3 = this.mAdded;
      bool1 = bool2;
      if (bool3) {}
      try
      {
        this.mWindowManager.removeView(this);
        this.mAdded = false;
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("FloatBaseLayout", 1, "showOrUpdate addView error: " + localThrowable.getMessage());
          bool1 = false;
        }
      }
      this.deo = 0;
      return bool1;
    }
    finally {}
  }
  
  public WindowManager.LayoutParams b()
  {
    return this.mLayoutParams;
  }
  
  public void destroy()
  {
    this.a = null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
    case 0: 
    case 2: 
      for (;;)
      {
        this.wQ = f1;
        this.wR = f2;
        return bool1;
        this.wS = f1;
        this.wT = f2;
        this.ckV = false;
        this.ckW = true;
        bool1 = super.dispatchTouchEvent(paramMotionEvent);
        continue;
        if ((Math.abs(f1 - this.wS) > this.wU) && (Math.abs(f2 - this.wT) > this.wU) && (this.ckW) && (!this.ckV))
        {
          this.ckV = true;
          dtl();
        }
        if ((this.a != null) && (this.ckV)) {
          this.a.iw((int)(f1 - this.wQ), (int)(f2 - this.wR));
        }
        if (!this.ckV) {
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
        }
      }
    }
    if ((this.a != null) && (this.ckV)) {
      this.a.dtq();
    }
    if (this.ckV) {
      dtm();
    }
    for (bool1 = bool2;; bool1 = super.dispatchTouchEvent(paramMotionEvent))
    {
      this.ckV = false;
      this.ckW = false;
      break;
    }
  }
  
  public void dtk()
  {
    if (this.mAdded) {}
    try
    {
      this.mWindowManager.updateViewLayout(this, this.mLayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FloatBaseLayout", 1, "showOrUpdate updateViewLayout error: " + localThrowable.getMessage());
    }
  }
  
  protected void dtl() {}
  
  protected void dtm() {}
  
  public int getCurrentX()
  {
    return this.mLayoutParams.x;
  }
  
  public boolean isVisible()
  {
    return this.mAdded;
  }
  
  public void iv(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.mLayoutParams.x) || (paramInt2 != this.mLayoutParams.y))
    {
      this.mLayoutParams.x = paramInt1;
      this.mLayoutParams.y = paramInt2;
    }
  }
  
  public int mu()
  {
    return this.mLayoutParams.y;
  }
  
  public void setFloatLayoutCallback(aipa paramaipa)
  {
    this.a = paramaipa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatBaseLayout
 * JD-Core Version:    0.7.0.1
 */