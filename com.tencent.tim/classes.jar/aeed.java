import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class aeed
{
  private boolean VA;
  private Context mContext;
  private WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
  private View mView;
  private WindowManager mWindowManager;
  
  public aeed(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.mWindowManager = ((WindowManager)this.mContext.getSystemService("window"));
    this.mLayoutParams.height = -2;
    this.mLayoutParams.width = -2;
    this.mLayoutParams.format = -3;
    this.mLayoutParams.windowAnimations = 0;
    this.mLayoutParams.type = 2010;
    this.mLayoutParams.gravity = 51;
    this.mLayoutParams.setTitle("Toast");
    this.mView = paramView;
    arf();
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
          QLog.d("ColorNoteSmallScreenToast", 2, "stopHandler removeView start");
        }
        this.mWindowManager.removeView(this.mView);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenToast", 2, "stopHandler removeView end");
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenToast", 2, "stopHandler error : " + localIllegalArgumentException);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public WindowManager.LayoutParams b()
  {
    return this.mLayoutParams;
  }
  
  public WindowManager getWindowManager()
  {
    return this.mWindowManager;
  }
  
  public void update()
  {
    if (this.VA) {}
    try
    {
      this.mWindowManager.updateViewLayout(this.mView, this.mLayoutParams);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ColorNoteSmallScreenToast", 2, "layout error : " + localIllegalArgumentException);
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
    //   7: getfield 108	aeed:VA	Z
    //   10: ifne +57 -> 67
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield 108	aeed:VA	Z
    //   18: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +11 -> 32
    //   24: ldc 116
    //   26: iconst_2
    //   27: ldc 164
    //   29: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 38	aeed:mWindowManager	Landroid/view/WindowManager;
    //   36: aload_0
    //   37: getfield 65	aeed:mView	Landroid/view/View;
    //   40: aload_0
    //   41: getfield 24	aeed:mLayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   44: invokeinterface 167 3 0
    //   49: iload_2
    //   50: istore_1
    //   51: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +13 -> 67
    //   57: ldc 116
    //   59: iconst_2
    //   60: ldc 169
    //   62: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: iload_2
    //   66: istore_1
    //   67: aload_0
    //   68: getfield 65	aeed:mView	Landroid/view/View;
    //   71: invokevirtual 175	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   74: checkcast 21	android/view/WindowManager$LayoutParams
    //   77: ifnull +255 -> 332
    //   80: iload_1
    //   81: ifeq +251 -> 332
    //   84: aload_0
    //   85: getfield 26	aeed:mContext	Landroid/content/Context;
    //   88: invokestatic 181	aeds:checkPermission	(Landroid/content/Context;)Z
    //   91: istore_1
    //   92: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +56 -> 151
    //   98: ldc 116
    //   100: iconst_2
    //   101: new 130	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   108: ldc 183
    //   110: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 108	aeed:VA	Z
    //   117: invokevirtual 186	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   120: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: ldc 116
    //   128: iconst_2
    //   129: new 130	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   136: ldc 188
    //   138: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload_1
    //   142: invokevirtual 186	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   145: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_0
    //   152: monitorexit
    //   153: iload_1
    //   154: ireturn
    //   155: astore_3
    //   156: aload_0
    //   157: getfield 38	aeed:mWindowManager	Landroid/view/WindowManager;
    //   160: aload_0
    //   161: getfield 65	aeed:mView	Landroid/view/View;
    //   164: aload_0
    //   165: getfield 24	aeed:mLayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   168: invokeinterface 153 3 0
    //   173: iload_2
    //   174: istore_1
    //   175: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq -111 -> 67
    //   181: ldc 116
    //   183: iconst_2
    //   184: new 130	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   191: ldc 190
    //   193: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_3
    //   197: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: iload_2
    //   207: istore_1
    //   208: goto -141 -> 67
    //   211: astore_3
    //   212: aload_0
    //   213: monitorexit
    //   214: aload_3
    //   215: athrow
    //   216: astore_3
    //   217: aload_0
    //   218: iconst_0
    //   219: putfield 108	aeed:VA	Z
    //   222: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +110 -> 335
    //   228: ldc 116
    //   230: iconst_2
    //   231: new 130	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   238: ldc 190
    //   240: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_3
    //   244: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: goto +82 -> 335
    //   256: astore_3
    //   257: aload_0
    //   258: iconst_0
    //   259: putfield 108	aeed:VA	Z
    //   262: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +75 -> 340
    //   268: ldc 116
    //   270: iconst_2
    //   271: new 130	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   278: ldc 190
    //   280: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_3
    //   284: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: goto +47 -> 340
    //   296: astore_3
    //   297: aload_0
    //   298: iconst_0
    //   299: putfield 108	aeed:VA	Z
    //   302: ldc 116
    //   304: iconst_2
    //   305: new 130	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   312: ldc 190
    //   314: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_3
    //   318: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: iconst_0
    //   328: istore_1
    //   329: goto -262 -> 67
    //   332: goto -240 -> 92
    //   335: iconst_0
    //   336: istore_1
    //   337: goto -270 -> 67
    //   340: iconst_0
    //   341: istore_1
    //   342: goto -275 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	aeed
    //   5	337	1	bool1	boolean
    //   1	206	2	bool2	boolean
    //   155	42	3	localIllegalStateException	java.lang.IllegalStateException
    //   211	4	3	localObject	Object
    //   216	28	3	localBadTokenException	android.view.WindowManager.BadTokenException
    //   256	28	3	localSecurityException	java.lang.SecurityException
    //   296	22	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   18	32	155	java/lang/IllegalStateException
    //   32	49	155	java/lang/IllegalStateException
    //   51	65	155	java/lang/IllegalStateException
    //   6	18	211	finally
    //   18	32	211	finally
    //   32	49	211	finally
    //   51	65	211	finally
    //   67	80	211	finally
    //   84	92	211	finally
    //   92	151	211	finally
    //   151	153	211	finally
    //   156	173	211	finally
    //   175	206	211	finally
    //   212	214	211	finally
    //   217	253	211	finally
    //   257	293	211	finally
    //   297	327	211	finally
    //   18	32	216	android/view/WindowManager$BadTokenException
    //   32	49	216	android/view/WindowManager$BadTokenException
    //   51	65	216	android/view/WindowManager$BadTokenException
    //   18	32	256	java/lang/SecurityException
    //   32	49	256	java/lang/SecurityException
    //   51	65	256	java/lang/SecurityException
    //   18	32	296	java/lang/Exception
    //   32	49	296	java/lang/Exception
    //   51	65	296	java/lang/Exception
  }
  
  public boolean vH()
  {
    return this.VA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeed
 * JD-Core Version:    0.7.0.1
 */