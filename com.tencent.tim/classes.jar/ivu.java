import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class ivu
{
  boolean VA = false;
  Context mContext;
  WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
  View mView = null;
  WindowManager mWindowManager;
  
  public ivu(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.mWindowManager = ((WindowManager)this.mContext.getSystemService("window"));
    this.mLayoutParams.height = -2;
    this.mLayoutParams.width = -2;
    this.mLayoutParams.flags = 776;
    this.mLayoutParams.format = -3;
    this.mLayoutParams.windowAnimations = 0;
    this.mLayoutParams.type = 2010;
    this.mLayoutParams.gravity = 51;
    this.mLayoutParams.setTitle("Toast");
    this.mView = paramView;
    arf();
  }
  
  void arf()
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
          QLog.d("SmallScreenToast", 2, "stopHandler removeView start");
        }
        this.mWindowManager.removeView(this.mView);
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenToast", 2, "stopHandler removeView end");
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenToast", 2, "stopHandler error : " + localIllegalArgumentException);
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
      QLog.d("SmallScreenToast", 2, "layout error : " + localIllegalArgumentException);
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
    //   7: getfield 28	ivu:VA	Z
    //   10: ifne +57 -> 67
    //   13: aload_0
    //   14: iconst_1
    //   15: putfield 28	ivu:VA	Z
    //   18: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +11 -> 32
    //   24: ldc 119
    //   26: iconst_2
    //   27: ldc 165
    //   29: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 42	ivu:mWindowManager	Landroid/view/WindowManager;
    //   36: aload_0
    //   37: getfield 26	ivu:mView	Landroid/view/View;
    //   40: aload_0
    //   41: getfield 24	ivu:mLayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   44: invokeinterface 168 3 0
    //   49: iload_2
    //   50: istore_1
    //   51: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +13 -> 67
    //   57: ldc 119
    //   59: iconst_2
    //   60: ldc 170
    //   62: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: iload_2
    //   66: istore_1
    //   67: aload_0
    //   68: getfield 26	ivu:mView	Landroid/view/View;
    //   71: invokevirtual 176	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   74: checkcast 21	android/view/WindowManager$LayoutParams
    //   77: ifnull +254 -> 331
    //   80: iload_1
    //   81: ifeq +250 -> 331
    //   84: aload_0
    //   85: getfield 30	ivu:mContext	Landroid/content/Context;
    //   88: invokestatic 182	ivv:isFloatWindowOpAllowed	(Landroid/content/Context;)Z
    //   91: istore_1
    //   92: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +56 -> 151
    //   98: ldc 119
    //   100: iconst_2
    //   101: new 133	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   108: ldc 184
    //   110: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 28	ivu:VA	Z
    //   117: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   120: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: ldc 119
    //   128: iconst_2
    //   129: new 133	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   136: ldc 189
    //   138: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload_1
    //   142: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   145: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_0
    //   152: monitorexit
    //   153: iload_1
    //   154: ireturn
    //   155: astore_3
    //   156: aload_0
    //   157: getfield 42	ivu:mWindowManager	Landroid/view/WindowManager;
    //   160: aload_0
    //   161: getfield 26	ivu:mView	Landroid/view/View;
    //   164: aload_0
    //   165: getfield 24	ivu:mLayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   168: invokeinterface 154 3 0
    //   173: iload_2
    //   174: istore_1
    //   175: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq -111 -> 67
    //   181: ldc 119
    //   183: iconst_2
    //   184: new 133	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   191: ldc 191
    //   193: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_3
    //   197: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   219: putfield 28	ivu:VA	Z
    //   222: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +109 -> 334
    //   228: ldc 119
    //   230: iconst_2
    //   231: new 133	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   238: ldc 191
    //   240: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_3
    //   244: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: goto +81 -> 334
    //   256: astore_3
    //   257: aload_0
    //   258: iconst_0
    //   259: putfield 28	ivu:VA	Z
    //   262: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +74 -> 339
    //   268: ldc 119
    //   270: iconst_2
    //   271: new 133	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   278: ldc 191
    //   280: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_3
    //   284: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: goto +46 -> 339
    //   296: astore_3
    //   297: aload_0
    //   298: iconst_0
    //   299: putfield 28	ivu:VA	Z
    //   302: ldc 119
    //   304: new 133	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   311: ldc 191
    //   313: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_3
    //   317: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 197	igd:aL	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: iconst_0
    //   327: istore_1
    //   328: goto -261 -> 67
    //   331: goto -239 -> 92
    //   334: iconst_0
    //   335: istore_1
    //   336: goto -269 -> 67
    //   339: iconst_0
    //   340: istore_1
    //   341: goto -274 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	ivu
    //   5	336	1	bool1	boolean
    //   1	206	2	bool2	boolean
    //   155	42	3	localIllegalStateException	java.lang.IllegalStateException
    //   211	4	3	localObject	Object
    //   216	28	3	localBadTokenException	android.view.WindowManager.BadTokenException
    //   256	28	3	localSecurityException	java.lang.SecurityException
    //   296	21	3	localException	Exception
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
    //   297	326	211	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivu
 * JD-Core Version:    0.7.0.1
 */