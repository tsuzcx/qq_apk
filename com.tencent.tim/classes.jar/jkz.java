import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.VideoController;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class jkz
{
  static int aAK = -1;
  String TAG = "SensorHelper";
  private boolean Vp = true;
  boolean ZP = false;
  boolean ZQ = false;
  private boolean ZR;
  boolean ZS = false;
  private boolean ZT = true;
  private boolean ZU = true;
  private boolean ZV = true;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper;
  jkz.a jdField_a_of_type_Jkz$a = null;
  jkz.b jdField_a_of_type_Jkz$b = null;
  jkz.c jdField_a_of_type_Jkz$c = null;
  jla jdField_a_of_type_Jla = new jla();
  int aAJ = 0;
  PowerManager.WakeLock c = null;
  Sensor f = null;
  Sensor g = null;
  private boolean hi;
  WeakReference<Context> mContext = null;
  boolean mIsStarted = false;
  SensorManager mSensorManager = null;
  
  private jkz(Activity paramActivity, VideoController paramVideoController, TraeHelper paramTraeHelper)
  {
    this.mContext = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = paramTraeHelper;
    axB();
  }
  
  public static jkz a(jkz paramjkz, Activity paramActivity, VideoController paramVideoController, TraeHelper paramTraeHelper)
  {
    if (paramjkz != null) {
      paramjkz.lh(false);
    }
    return new jkz(paramActivity, paramVideoController, paramTraeHelper);
  }
  
  /* Error */
  void T(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 131	jkz:xO	()Z
    //   6: istore_3
    //   7: aload_0
    //   8: getfield 92	jkz:mIsStarted	Z
    //   11: iload_1
    //   12: if_icmpeq +17 -> 29
    //   15: aload_0
    //   16: getfield 121	jkz:ZR	Z
    //   19: ifne +324 -> 343
    //   22: iload_1
    //   23: ifne +6 -> 29
    //   26: goto +317 -> 343
    //   29: aload_0
    //   30: getfield 57	jkz:TAG	Ljava/lang/String;
    //   33: iconst_1
    //   34: ldc 133
    //   36: iconst_4
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: iload_1
    //   43: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_0
    //   50: getfield 92	jkz:mIsStarted	Z
    //   53: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: aload_0
    //   60: getfield 121	jkz:ZR	Z
    //   63: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: dup
    //   68: iconst_3
    //   69: iload_3
    //   70: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   73: aastore
    //   74: invokestatic 145	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: aload_0
    //   84: getfield 90	jkz:c	Landroid/os/PowerManager$WakeLock;
    //   87: ifnonnull +51 -> 138
    //   90: aload_0
    //   91: getfield 84	jkz:mContext	Lmqq/util/WeakReference;
    //   94: invokevirtual 154	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   97: checkcast 156	android/content/Context
    //   100: ldc 158
    //   102: invokevirtual 162	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   105: checkcast 164	android/os/PowerManager
    //   108: astore 4
    //   110: aload_0
    //   111: aload 4
    //   113: bipush 32
    //   115: ldc 166
    //   117: invokevirtual 170	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   120: putfield 90	jkz:c	Landroid/os/PowerManager$WakeLock;
    //   123: aload_0
    //   124: getfield 90	jkz:c	Landroid/os/PowerManager$WakeLock;
    //   127: ifnull +11 -> 138
    //   130: aload_0
    //   131: getfield 90	jkz:c	Landroid/os/PowerManager$WakeLock;
    //   134: iconst_0
    //   135: invokevirtual 175	android/os/PowerManager$WakeLock:setReferenceCounted	(Z)V
    //   138: aload_0
    //   139: getfield 90	jkz:c	Landroid/os/PowerManager$WakeLock;
    //   142: ifnonnull +46 -> 188
    //   145: aload_0
    //   146: getfield 57	jkz:TAG	Ljava/lang/String;
    //   149: iconst_1
    //   150: ldc 177
    //   152: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: goto -75 -> 80
    //   158: astore 4
    //   160: aload_0
    //   161: monitorexit
    //   162: aload 4
    //   164: athrow
    //   165: astore 4
    //   167: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq -32 -> 138
    //   173: aload_0
    //   174: getfield 57	jkz:TAG	Ljava/lang/String;
    //   177: iconst_2
    //   178: ldc 182
    //   180: aload 4
    //   182: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: goto -47 -> 138
    //   188: aload_0
    //   189: getfield 90	jkz:c	Landroid/os/PowerManager$WakeLock;
    //   192: ifnull -112 -> 80
    //   195: aload_0
    //   196: getfield 90	jkz:c	Landroid/os/PowerManager$WakeLock;
    //   199: invokevirtual 188	android/os/PowerManager$WakeLock:isHeld	()Z
    //   202: istore_3
    //   203: aload_0
    //   204: getfield 57	jkz:TAG	Ljava/lang/String;
    //   207: iconst_1
    //   208: ldc 190
    //   210: iconst_2
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: iload_1
    //   217: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: iload_3
    //   224: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   227: aastore
    //   228: invokestatic 145	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iload_1
    //   235: ifeq +57 -> 292
    //   238: iload_3
    //   239: ifne +53 -> 292
    //   242: aload_0
    //   243: getfield 90	jkz:c	Landroid/os/PowerManager$WakeLock;
    //   246: invokevirtual 193	android/os/PowerManager$WakeLock:acquire	()V
    //   249: aload_0
    //   250: iconst_1
    //   251: putfield 92	jkz:mIsStarted	Z
    //   254: aload_0
    //   255: getfield 78	jkz:jdField_a_of_type_Jla	Ljla;
    //   258: invokevirtual 196	jla:axC	()V
    //   261: aload_0
    //   262: iload_1
    //   263: putfield 92	jkz:mIsStarted	Z
    //   266: goto -186 -> 80
    //   269: astore 4
    //   271: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq -194 -> 80
    //   277: aload_0
    //   278: getfield 57	jkz:TAG	Ljava/lang/String;
    //   281: iconst_2
    //   282: ldc 198
    //   284: aload 4
    //   286: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   289: goto -209 -> 80
    //   292: iload_1
    //   293: ifne -32 -> 261
    //   296: iload_3
    //   297: ifeq -36 -> 261
    //   300: aload_0
    //   301: getfield 90	jkz:c	Landroid/os/PowerManager$WakeLock;
    //   304: invokevirtual 201	android/os/PowerManager$WakeLock:release	()V
    //   307: aload_0
    //   308: iconst_0
    //   309: putfield 92	jkz:mIsStarted	Z
    //   312: aload_0
    //   313: getfield 78	jkz:jdField_a_of_type_Jla	Ljla;
    //   316: aload_0
    //   317: getfield 98	jkz:ZV	Z
    //   320: aload_0
    //   321: getfield 121	jkz:ZR	Z
    //   324: aload_0
    //   325: getfield 96	jkz:ZU	Z
    //   328: aload_0
    //   329: getfield 80	jkz:aAJ	I
    //   332: iload_2
    //   333: aload_0
    //   334: getfield 82	jkz:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   337: invokevirtual 204	jla:a	(ZZZIZLcom/tencent/av/VideoController;)V
    //   340: goto -79 -> 261
    //   343: iload_3
    //   344: ifeq -261 -> 83
    //   347: goto -318 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	jkz
    //   0	350	1	paramBoolean1	boolean
    //   0	350	2	paramBoolean2	boolean
    //   6	338	3	bool	boolean
    //   108	4	4	localPowerManager	PowerManager
    //   158	5	4	localObject	Object
    //   165	16	4	localException1	java.lang.Exception
    //   269	16	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	22	158	finally
    //   29	80	158	finally
    //   83	110	158	finally
    //   110	138	158	finally
    //   138	155	158	finally
    //   167	185	158	finally
    //   188	234	158	finally
    //   242	261	158	finally
    //   261	266	158	finally
    //   271	289	158	finally
    //   300	340	158	finally
    //   110	138	165	java/lang/Exception
    //   188	234	269	java/lang/Exception
    //   242	261	269	java/lang/Exception
    //   261	266	269	java/lang/Exception
    //   300	340	269	java/lang/Exception
  }
  
  void axB()
  {
    if (this.mContext != null)
    {
      Context localContext = (Context)this.mContext.get();
      if ((localContext != null) && (this.mSensorManager == null)) {
        this.mSensorManager = ((SensorManager)localContext.getSystemService("sensor"));
      }
    }
    if (this.mSensorManager != null)
    {
      if (this.f == null) {
        this.f = this.mSensorManager.getDefaultSensor(1);
      }
      if (this.g == null) {
        this.g = this.mSensorManager.getDefaultSensor(8);
      }
    }
    if (this.jdField_a_of_type_Jkz$a == null) {
      this.jdField_a_of_type_Jkz$a = new jkz.a();
    }
    if (this.jdField_a_of_type_Jkz$b == null) {
      this.jdField_a_of_type_Jkz$b = new jkz.b();
    }
  }
  
  public void lh(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "startSensor " + paramBoolean);
    }
    if ((this.jdField_a_of_type_Jkz$a == null) || (this.jdField_a_of_type_Jkz$b == null) || (this.mContext == null) || (this.mContext.get() == null)) {
      QLog.e(this.TAG, 1, "startSensor error, start[" + paramBoolean);
    }
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_Jla.begin();
    } while (this.ZQ);
    this.ZQ = true;
    this.mSensorManager.registerListener(this.jdField_a_of_type_Jkz$a, this.f, 3);
    this.mSensorManager.registerListener(this.jdField_a_of_type_Jkz$b, this.g, 3);
    if (this.jdField_a_of_type_Jkz$c == null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.jdField_a_of_type_Jkz$c = new jkz.c();
      ((Context)this.mContext.get()).registerReceiver(this.jdField_a_of_type_Jkz$c, localIntentFilter);
      return;
    }
    QLog.e(this.TAG, 1, "startSensor error, mSreenActionReceive had exist");
    return;
    if (this.ZQ)
    {
      this.mSensorManager.unregisterListener(this.jdField_a_of_type_Jkz$a);
      this.mSensorManager.unregisterListener(this.jdField_a_of_type_Jkz$b);
      QLog.d(this.TAG, 1, "toggleProximityWakeLock[false], when[StopSensor]");
      T(false, true);
      li(false);
      lj(false);
      if (this.jdField_a_of_type_Jkz$c != null)
      {
        ((Context)this.mContext.get()).unregisterReceiver(this.jdField_a_of_type_Jkz$c);
        this.jdField_a_of_type_Jkz$c = null;
      }
    }
    this.ZQ = false;
    this.jdField_a_of_type_Jla.end();
  }
  
  public void li(boolean paramBoolean)
  {
    try
    {
      this.ZR = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void lj(boolean paramBoolean)
  {
    try
    {
      this.ZS = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onConnected()
  {
    this.jdField_a_of_type_Jla.u(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  boolean xO()
  {
    if (aAK == -1)
    {
      String str = Build.MODEL;
      if (!Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
        break label73;
      }
      if ((!str.equalsIgnoreCase("GT-I9200")) && (!str.equalsIgnoreCase("GT-I8262D")) && (!str.equalsIgnoreCase("SM-N9008"))) {
        break label66;
      }
      aAK = 1;
    }
    while (aAK == 1)
    {
      return true;
      label66:
      aAK = 0;
      continue;
      label73:
      aAK = 0;
    }
    return false;
  }
  
  class a
    implements SensorEventListener
  {
    long pX = 0L;
    long pY = 0L;
    
    a() {}
    
    String a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return " x[" + paramFloat1 + "], y[" + paramFloat2 + "], z[" + paramFloat3 + "], acc[" + paramFloat4 + "], mIsMoving[" + jkz.b(jkz.this) + "], mEnbaleProximiy[" + jkz.c(jkz.this) + "], mIsAppOnForeground[" + jkz.d(jkz.this) + "], mIsStarted[" + jkz.this.mIsStarted + "], mPowerkeyStatu[" + jkz.this.aAJ + "], mlongDistense[" + jkz.a(jkz.this) + "]";
    }
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (paramSensorEvent.sensor.getType() != 1) {
        return;
      }
      long l = System.currentTimeMillis();
      boolean bool6 = jkz.b(jkz.this);
      float f1 = paramSensorEvent.values[0];
      float f2 = paramSensorEvent.values[1];
      float f3 = paramSensorEvent.values[2];
      float f4 = f1 * f1 + f2 * f2 + f3 * f3;
      label94:
      boolean bool1;
      if ((f4 < 77.0F) || (f4 > 106.0F))
      {
        this.pY = l;
        jkz.b(jkz.this, true);
        if (jkz.this.a == null) {
          break label571;
        }
        paramSensorEvent = jkz.this.a.b();
        if (paramSensorEvent == null) {
          break label571;
        }
        if (paramSensorEvent.amI != 3) {
          break label465;
        }
        bool1 = true;
      }
      for (;;)
      {
        label130:
        boolean bool4 = false;
        boolean bool5 = false;
        boolean bool2;
        boolean bool3;
        if ((bool1) && (jkz.c(jkz.this)) && (jkz.d(jkz.this)) && (!jkz.a(jkz.this)) && (jkz.this.aAJ != 1) && (jkz.this.aAJ != 3))
        {
          bool2 = bool5;
          bool3 = bool4;
          if (jkz.b(jkz.this))
          {
            bool3 = true;
            bool2 = bool5;
          }
        }
        for (;;)
        {
          if ((QLog.isDevelopLevel()) && ((bool6 != jkz.b(jkz.this)) || (l - this.pX > 1000L)))
          {
            QLog.d(jkz.this.TAG, 4, "onSensorChanged, bAudio[" + jkz.e(jkz.this) + "->" + bool1 + "], IsMoving[" + bool6 + "->" + jkz.b(jkz.this) + "], bOnScreen[" + bool2 + "], bOffScreen[" + bool3 + "]," + a(f1, f2, f3, f4));
            this.pX = l;
          }
          jkz.c(jkz.this, bool1);
          if (!bool2) {
            break label507;
          }
          if (!jkz.this.mIsStarted) {
            break;
          }
          QLog.d(jkz.this.TAG, 1, "toggleProximityWakeLock[false], when[AccelerationSensorEventListener]," + a(f1, f2, f3, f4));
          jkz.this.T(false, false);
          return;
          if (l - this.pY <= 300L) {
            break label94;
          }
          jkz.b(jkz.this, false);
          break label94;
          label465:
          if (!paramSensorEvent.QE) {
            break label571;
          }
          bool1 = true;
          break label130;
          bool2 = bool5;
          bool3 = bool4;
          if (jkz.this.aAJ != 2)
          {
            bool2 = true;
            bool3 = bool4;
          }
        }
        label507:
        if ((!bool3) || (jkz.this.mIsStarted)) {
          break;
        }
        QLog.d(jkz.this.TAG, 1, "toggleProximityWakeLock[true], when[AccelerationSensorEventListener]" + a(f1, f2, f3, f4));
        jkz.this.T(true, false);
        return;
        label571:
        bool1 = false;
      }
    }
  }
  
  class b
    implements SensorEventListener
  {
    boolean ZW = true;
    boolean ZX = false;
    boolean ZY = false;
    boolean ZZ = false;
    float gi = 0.0F;
    float id = 3.1F;
    long pX = 0L;
    
    b() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (paramSensorEvent.sensor.getType() != 8) {}
      label81:
      boolean bool1;
      label119:
      Object localObject;
      label199:
      do
      {
        float f1;
        float f2;
        do
        {
          do
          {
            return;
            f1 = this.gi;
            f2 = paramSensorEvent.values[0];
            this.gi = f2;
            if (this.id > jkz.this.g.getMaximumRange()) {
              this.id = jkz.this.g.getMaximumRange();
            }
            if ((f2 < 0.0D) || (f2 >= this.id)) {
              break;
            }
            i = 1;
            if (this.ZW)
            {
              this.ZW = false;
              if (i != 0)
              {
                jkz.this.aAJ = 3;
                paramSensorEvent = jkz.this;
                if (i != 0) {
                  break label615;
                }
                bool1 = true;
                jkz.a(paramSensorEvent, bool1);
                jkz.this.jdField_a_of_type_Jla.axD();
              }
            }
          } while ((jkz.this.g == null) || (jkz.this.jdField_a_of_type_ComTencentAvVideoController == null));
          paramSensorEvent = jkz.this.jdField_a_of_type_ComTencentAvVideoController.b();
        } while (paramSensorEvent == null);
        long l = System.currentTimeMillis();
        boolean bool2 = jkz.a(jkz.this);
        localObject = jkz.this;
        if (i != 0) {
          break label621;
        }
        bool1 = true;
        jkz.d((jkz)localObject, bool1);
        if (jkz.f(jkz.this) != jkz.a(jkz.this))
        {
          if (3 == jkz.this.aAJ) {
            jkz.this.jdField_a_of_type_Jla.axE();
          }
          jkz.this.aAJ = 0;
        }
        if ((l - this.pX > 1000L) || (bool2 != jkz.a(jkz.this)) || (this.ZX != paramSensorEvent.QB) || (this.ZY != jkz.this.ZP) || (this.ZZ != jkz.b(jkz.this)))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(jkz.this.TAG, 4, "onSensorChanged distance[" + f1 + "->" + f2 + "], mlongDistense[" + jkz.a(jkz.this) + "], lastlongDistense[" + bool2 + "], mIsMoving[" + this.ZZ + "->" + jkz.b(jkz.this) + "], mSensorSet[" + this.ZY + "->" + jkz.this.ZP + "], isSpeakerOn[" + this.ZX + "->" + paramSensorEvent.QB + "]");
          }
          this.pX = l;
        }
        this.ZX = paramSensorEvent.QB;
        this.ZY = jkz.this.ZP;
        this.ZZ = jkz.b(jkz.this);
        if ((i == 0) || (!jkz.b(jkz.this))) {
          break label732;
        }
        localObject = paramSensorEvent.aK;
      } while ((!paramSensorEvent.QB) || (localObject == null));
      int i = 0;
      label543:
      if (i < localObject.length) {
        if ((!localObject[i].equals("DEVICE_WIREDHEADSET")) && (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET"))) {}
      }
      for (i = 0;; i = 1)
      {
        if (!ivv.isAppOnForeground(BaseApplicationImpl.getApplication()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jkz.this.TAG, 2, "is App on background , Not execute sensor pressHandFreeBtn !!!");
          return;
          i = 0;
          break label81;
          label615:
          bool1 = false;
          break label119;
          label621:
          bool1 = false;
          break label199;
          i += 1;
          break label543;
        }
        if ((i == 0) || (!jkz.this.ZS)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jkz.this.TAG, 2, "1.setSensors pressHandFreeBtn, current mSensorSet = " + jkz.this.ZP);
        }
        if (jkz.this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          jkz.this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axK();
        }
        jkz.this.ZP = true;
        jjk.l(jkz.this.jdField_a_of_type_ComTencentAvVideoController);
        return;
        label732:
        if ((!jkz.this.ZP) || (i != 0)) {
          break;
        }
        if (jkz.this.jdField_a_of_type_ComTencentAvVideoController != null) {}
        for (paramSensorEvent = paramSensorEvent.aK;; paramSensorEvent = null)
        {
          if (paramSensorEvent != null)
          {
            i = 0;
            if (i >= paramSensorEvent.length) {
              break label908;
            }
            if ((!paramSensorEvent[i].equals("DEVICE_WIREDHEADSET")) && (!paramSensorEvent[i].equals("DEVICE_BLUETOOTHHEADSET"))) {
              break label899;
            }
          }
          label899:
          label908:
          for (i = 0;; i = 1)
          {
            if ((i != 0) && (jkz.this.ZS))
            {
              if (QLog.isColorLevel()) {
                QLog.d(jkz.this.TAG, 2, "2.setSensors pressHandFreeBtn, current mSensorSet = " + jkz.this.ZP);
              }
              if (jkz.this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
                jkz.this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.axK();
              }
              jjk.l(jkz.this.jdField_a_of_type_ComTencentAvVideoController);
            }
            jkz.this.ZP = false;
            return;
            i += 1;
            break;
          }
        }
      }
    }
  }
  
  class c
    extends BroadcastReceiver
  {
    c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      String str = paramIntent.getAction();
      boolean bool3;
      boolean bool1;
      int i;
      if (str.equals("android.intent.action.SCREEN_ON"))
      {
        bool3 = VideoController.isScreenLocked(paramContext);
        if (Build.VERSION.SDK_INT < 20) {
          break label437;
        }
        bool1 = ((PowerManager)((Context)jkz.this.mContext.get()).getSystemService("power")).isInteractive();
        paramContext = ((WindowManager)((Context)jkz.this.mContext.get()).getSystemService("window")).getDefaultDisplay();
        if (paramContext == null) {
          break label432;
        }
        i = paramContext.getState();
      }
      for (;;)
      {
        paramContext = jkz.this.TAG;
        paramIntent = new StringBuilder().append("ACTION_SCREEN_ON, mVideoController[");
        boolean bool2;
        if (jkz.this.a != null)
        {
          bool2 = true;
          QLog.d(paramContext, 1, bool2 + "], isInteractive[" + bool1 + "], nState[" + i + "], inKeyguardRestrictedInputMode[" + bool3 + "], mIsStarted[" + jkz.this.mIsStarted + "]");
          if (jkz.this.mIsStarted)
          {
            jkz.this.aAJ = 1;
            jkz.a(jkz.this, jkz.a(jkz.this));
          }
        }
        label313:
        do
        {
          do
          {
            do
            {
              return;
              bool2 = false;
              break;
              if (!str.equals("android.intent.action.SCREEN_OFF")) {
                break label313;
              }
              i = paramIntent.getIntExtra("why", 0);
              QLog.d(jkz.this.TAG, 1, "ACTION_SCREEN_OFF, why[" + i + "]");
            } while (jkz.this.a == null);
            jkz.this.a.a("backgroundReason", "4");
            com.tencent.av.VideoConstants.a.Mm = "4";
            return;
            if (str.equals("android.intent.action.USER_PRESENT"))
            {
              QLog.d(jkz.this.TAG, 1, "ACTION_USER_PRESENT");
              return;
            }
          } while (!str.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
          paramContext = paramIntent.getStringExtra("reason");
          QLog.d(jkz.this.TAG, 1, "ACTION_CLOSE_SYSTEM_DIALOGS, reason[" + paramContext + "]");
        } while ((!"homekey".equalsIgnoreCase(paramContext)) || (!jkz.this.mIsStarted));
        jkz.this.aAJ = 1;
        jkz.a(jkz.this, jkz.a(jkz.this));
        return;
        label432:
        i = 2;
        continue;
        label437:
        i = 2;
        bool1 = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkz
 * JD-Core Version:    0.7.0.1
 */