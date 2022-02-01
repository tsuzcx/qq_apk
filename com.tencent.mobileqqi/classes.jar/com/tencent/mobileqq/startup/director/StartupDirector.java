package com.tencent.mobileqq.startup.director;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.SetPermission;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import gjv;
import gjw;
import gjx;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.util.WeakReference;

public class StartupDirector
  implements Handler.Callback
{
  public static final int a = 8;
  public static final long a = 550L;
  public static final String a = "AutoMonitor";
  public static final boolean a = false;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  private static final int jdField_b_of_type_Int = -1;
  private static final long jdField_b_of_type_Long = 2100L;
  public static final String b = "com.tencent.mobileqqi";
  public static final boolean b = false;
  private static final int[] jdField_b_of_type_ArrayOfInt;
  private static final int jdField_c_of_type_Int = 0;
  private static final String jdField_c_of_type_JavaLangString = "suicide_count";
  public static final boolean c = false;
  private static final int[] jdField_c_of_type_ArrayOfInt;
  private static final int jdField_d_of_type_Int = 1;
  private static final long jdField_d_of_type_Long = 1000L;
  public static final boolean d = true;
  private static final int[] jdField_d_of_type_ArrayOfInt;
  private static final int jdField_e_of_type_Int = 2;
  public static boolean e = false;
  private static final int[] jdField_e_of_type_ArrayOfInt;
  private static final int jdField_f_of_type_Int = 3;
  private static long jdField_f_of_type_Long = 0L;
  public static boolean f = false;
  private static final int[] jdField_f_of_type_ArrayOfInt;
  private static final int jdField_g_of_type_Int = 4;
  private static final int[] jdField_g_of_type_ArrayOfInt;
  private static final int jdField_h_of_type_Int = 5;
  private static final boolean jdField_h_of_type_Boolean = false;
  private static final int[] jdField_h_of_type_ArrayOfInt;
  private static final int jdField_i_of_type_Int = 6;
  private static final int[] jdField_i_of_type_ArrayOfInt;
  private static final int jdField_j_of_type_Int = 101;
  private static final int[] jdField_j_of_type_ArrayOfInt;
  private static final int jdField_k_of_type_Int = 201;
  private static final int[] jdField_k_of_type_ArrayOfInt;
  private static final int jdField_l_of_type_Int = 1000;
  private static final int[] jdField_l_of_type_ArrayOfInt;
  private static final int jdField_m_of_type_Int;
  private static final int[] jdField_m_of_type_ArrayOfInt;
  private static final int[] jdField_n_of_type_ArrayOfInt;
  private static final int p = 1;
  private static final int q = 2;
  private static final int r = 3;
  private static final int s = 4;
  private static final int t = 5;
  private static final int u = 6;
  private static final int v = 7;
  private static final int w = 8;
  private static final int x = 9;
  private static final int y = 10;
  private static final int z = 11;
  private int A = 0;
  private int B;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SetPermission jdField_a_of_type_ComTencentMobileqqStartupStepSetPermission;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public AppActivity a;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private long jdField_c_of_type_Long = 0L;
  private long jdField_e_of_type_Long;
  public boolean g;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_n_of_type_Int = -1;
  private int o = 0;
  
  static
  {
    if (Build.MODEL.toLowerCase().startsWith("coolpad 80")) {}
    for (int i1 = 0;; i1 = 3)
    {
      jdField_m_of_type_Int = i1;
      jdField_a_of_type_ArrayOfInt = new int[] { 1, 9, 8, 15 };
      jdField_b_of_type_ArrayOfInt = new int[] { 6, 7, 17 };
      jdField_c_of_type_ArrayOfInt = new int[] { 6 };
      d = new int[] { 11, 12, 16 };
      jdField_e_of_type_ArrayOfInt = new int[] { 11, 12, 16 };
      jdField_f_of_type_ArrayOfInt = new int[] { 7, 17 };
      jdField_g_of_type_ArrayOfInt = new int[] { 11, 16 };
      h = jdField_f_of_type_ArrayOfInt;
      jdField_i_of_type_ArrayOfInt = new int[] { 6, 11, 14, 10 };
      j = new int[] { 11, 14 };
      k = new int[] { 18, 6, 10 };
      l = new int[] { 13, 6 };
      jdField_m_of_type_ArrayOfInt = new int[] { 13, 6, 14, 12, 10 };
      jdField_n_of_type_ArrayOfInt = new int[] { 13, 6, 14, 12, 19 };
      jdField_e_of_type_Boolean = false;
      jdField_f_of_type_Boolean = false;
      jdField_f_of_type_Long = 0L;
      return;
    }
  }
  
  /* Error */
  private final int a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: iconst_0
    //   13: istore_2
    //   14: new 149	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 155	android/content/Context:getFilesDir	()Ljava/io/File;
    //   22: ldc 27
    //   24: invokespecial 158	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore 9
    //   29: iload 4
    //   31: istore_3
    //   32: aload 9
    //   34: invokevirtual 162	java/io/File:exists	()Z
    //   37: ifeq +49 -> 86
    //   40: new 164	java/io/BufferedInputStream
    //   43: dup
    //   44: new 166	java/io/FileInputStream
    //   47: dup
    //   48: aload 9
    //   50: invokespecial 169	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 172	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore 5
    //   58: aload 5
    //   60: astore_1
    //   61: aload 5
    //   63: invokevirtual 176	java/io/BufferedInputStream:read	()I
    //   66: istore_3
    //   67: iload_3
    //   68: iconst_m1
    //   69: if_icmpne +228 -> 297
    //   72: iload_2
    //   73: istore_3
    //   74: aload 5
    //   76: ifnull +10 -> 86
    //   79: aload 5
    //   81: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   84: iload_2
    //   85: istore_3
    //   86: iload_3
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: aload 8
    //   92: astore_1
    //   93: new 181	java/io/FileOutputStream
    //   96: dup
    //   97: aload 9
    //   99: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   102: astore 5
    //   104: aload 5
    //   106: iload_2
    //   107: invokevirtual 186	java/io/FileOutputStream:write	(I)V
    //   110: aload 5
    //   112: ifnull +8 -> 120
    //   115: aload 5
    //   117: invokevirtual 187	java/io/FileOutputStream:close	()V
    //   120: iload_2
    //   121: ireturn
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   127: iload_2
    //   128: istore_3
    //   129: goto -43 -> 86
    //   132: astore 6
    //   134: aconst_null
    //   135: astore 5
    //   137: aload 5
    //   139: astore_1
    //   140: aload 6
    //   142: invokevirtual 191	java/lang/Exception:printStackTrace	()V
    //   145: iload 4
    //   147: istore_3
    //   148: aload 5
    //   150: ifnull -64 -> 86
    //   153: aload 5
    //   155: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   158: iload 4
    //   160: istore_3
    //   161: goto -75 -> 86
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   169: iload 4
    //   171: istore_3
    //   172: goto -86 -> 86
    //   175: astore_1
    //   176: aload 6
    //   178: astore 5
    //   180: aload 5
    //   182: ifnull +8 -> 190
    //   185: aload 5
    //   187: invokevirtual 179	java/io/BufferedInputStream:close	()V
    //   190: aload_1
    //   191: athrow
    //   192: astore 5
    //   194: aload 5
    //   196: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   199: goto -9 -> 190
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   207: iload_2
    //   208: ireturn
    //   209: astore 6
    //   211: aload 7
    //   213: astore 5
    //   215: aload 5
    //   217: astore_1
    //   218: aload 6
    //   220: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   223: aload 5
    //   225: ifnull -105 -> 120
    //   228: aload 5
    //   230: invokevirtual 187	java/io/FileOutputStream:close	()V
    //   233: iload_2
    //   234: ireturn
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   240: iload_2
    //   241: ireturn
    //   242: astore 6
    //   244: aload_1
    //   245: astore 5
    //   247: aload 6
    //   249: astore_1
    //   250: aload 5
    //   252: ifnull +8 -> 260
    //   255: aload 5
    //   257: invokevirtual 187	java/io/FileOutputStream:close	()V
    //   260: aload_1
    //   261: athrow
    //   262: astore 5
    //   264: aload 5
    //   266: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   269: goto -9 -> 260
    //   272: astore_1
    //   273: goto -23 -> 250
    //   276: astore 6
    //   278: goto -63 -> 215
    //   281: astore 6
    //   283: aload_1
    //   284: astore 5
    //   286: aload 6
    //   288: astore_1
    //   289: goto -109 -> 180
    //   292: astore 6
    //   294: goto -157 -> 137
    //   297: iload_3
    //   298: istore_2
    //   299: goto -227 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	StartupDirector
    //   0	302	1	paramContext	android.content.Context
    //   13	286	2	i1	int
    //   31	267	3	i2	int
    //   10	160	4	i3	int
    //   56	130	5	localObject1	Object
    //   192	3	5	localIOException1	java.io.IOException
    //   213	43	5	localObject2	Object
    //   262	3	5	localIOException2	java.io.IOException
    //   284	1	5	localContext	android.content.Context
    //   7	1	6	localObject3	Object
    //   132	45	6	localException1	java.lang.Exception
    //   209	10	6	localIOException3	java.io.IOException
    //   242	6	6	localObject4	Object
    //   276	1	6	localIOException4	java.io.IOException
    //   281	6	6	localObject5	Object
    //   292	1	6	localException2	java.lang.Exception
    //   1	211	7	localObject6	Object
    //   4	87	8	localObject7	Object
    //   27	71	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   79	84	122	java/io/IOException
    //   40	58	132	java/lang/Exception
    //   153	158	164	java/io/IOException
    //   40	58	175	finally
    //   185	190	192	java/io/IOException
    //   115	120	202	java/io/IOException
    //   93	104	209	java/io/IOException
    //   228	233	235	java/io/IOException
    //   93	104	242	finally
    //   218	223	242	finally
    //   255	260	262	java/io/IOException
    //   104	110	272	finally
    //   104	110	276	java/io/IOException
    //   61	67	281	finally
    //   140	145	281	finally
    //   61	67	292	java/lang/Exception
  }
  
  public static StartupDirector a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onApplicationCreate ");
    }
    paramBaseApplicationImpl = new StartupDirector();
    paramBaseApplicationImpl.a(0);
    Step.a(0, paramBaseApplicationImpl, jdField_a_of_type_ArrayOfInt).b();
    if ("com.tencent.mobileqqi".equals(BaseApplicationImpl.processName))
    {
      paramBaseApplicationImpl.a(1);
      return paramBaseApplicationImpl;
    }
    if (BaseApplicationImpl.processName.endsWith(":web"))
    {
      Step.a(13, paramBaseApplicationImpl, null).b();
      Step.a(11, paramBaseApplicationImpl, null).b();
      paramBaseApplicationImpl.a(1);
      return paramBaseApplicationImpl;
    }
    jdField_e_of_type_Boolean = false;
    Step.a(13, paramBaseApplicationImpl, null).b();
    if (BaseApplicationImpl.processName.endsWith("qzone"))
    {
      new Thread(Step.a(0, paramBaseApplicationImpl, k)).start();
      Step.a(0, paramBaseApplicationImpl, j).b();
    }
    for (;;)
    {
      return null;
      Step.a(0, paramBaseApplicationImpl, jdField_i_of_type_ArrayOfInt).b();
    }
  }
  
  private void a(int paramInt)
  {
    long l1;
    if (jdField_e_of_type_Boolean)
    {
      if (this.jdField_n_of_type_Int == -1) {
        break label105;
      }
      l1 = SystemClock.uptimeMillis();
      Log.i("AutoMonitor", "STATE_" + this.jdField_n_of_type_Int + ", cost=" + (l1 - jdField_f_of_type_Long) + " then " + paramInt);
    }
    for (;;)
    {
      if (paramInt != 1000)
      {
        if (this.jdField_n_of_type_Int == -1) {
          l1 = SystemClock.uptimeMillis();
        }
        if (l1 != 0L) {
          jdField_f_of_type_Long = l1;
        }
      }
      this.jdField_n_of_type_Int = paramInt;
      return;
      label105:
      l1 = 0L;
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  private void a(AppActivity paramAppActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAppActivity == null) {
      return;
    }
    TextView localTextView = new TextView(paramAppActivity);
    paramAppActivity.getWindow().setBackgroundDrawableResource(17170446);
    localTextView.setGravity(17);
    localTextView.setBackgroundColor(-16777216);
    localTextView.setTextColor(-1);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (!paramBoolean1) {
      localTextView.setText(2131562559);
    }
    for (;;)
    {
      paramAppActivity.setContentView(localTextView);
      InjectUtils.a(paramAppActivity, "SuicideFailed", Integer.toString(this.o));
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new gjx(this, paramAppActivity), 8000L);
      return;
      localTextView.setText("程序启动失败，请稍候重试.");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onEndStep with " + paramBoolean + ", when " + this.jdField_n_of_type_Int);
    }
    if (paramBoolean)
    {
      Step.a(10, this, null).run();
      if (this.jdField_i_of_type_Boolean) {
        Step.a(20, this, null).run();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    a(1000);
    if ((paramBoolean) && ((this.jdField_g_of_type_Boolean) || (this.jdField_c_of_type_Long > 0L) || (BaseApplicationImpl.jdField_a_of_type_Long < 0L)))
    {
      long l1 = this.jdField_c_of_type_Long;
      long l2 = SystemClock.uptimeMillis();
      long l3 = this.jdField_c_of_type_Long;
      long l4 = BaseApplicationImpl.jdField_a_of_type_Long;
      long l5 = SystemClock.uptimeMillis();
      long l6 = BaseApplicationImpl.b;
      paramBoolean = this.jdField_g_of_type_Boolean;
      ThreadManager.b().postDelayed(new gjv(this, paramBoolean, l1, l2 - l3, l4, l5 - l6), 10000L);
    }
    BaseApplicationImpl.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector = null;
  }
  
  private void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    this.A = 1;
    paramArrayOfInt1 = Step.a(0, this, paramArrayOfInt1);
    if (paramArrayOfInt2 != null)
    {
      this.A = 2;
      this.B = paramInt;
      paramArrayOfInt1.a(this.jdField_b_of_type_AndroidOsHandler, 10);
      paramArrayOfInt2 = Step.a(0, this, paramArrayOfInt2);
      paramArrayOfInt2.a(this.jdField_b_of_type_AndroidOsHandler, 10);
      ThreadManager.a(paramArrayOfInt2);
    }
    for (;;)
    {
      paramArrayOfInt1.b();
      return;
      paramArrayOfInt1.a(this.jdField_b_of_type_AndroidOsHandler, paramInt);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "realCreateActivity when " + this.jdField_n_of_type_Int + ", " + this.jdField_a_of_type_JavaUtilArrayList);
    }
    if (this.jdField_n_of_type_Int == 3) {
      a(4);
    }
    int i1;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (i1 >= 0)
      {
        Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localObject != null) {}
        for (localObject = (AppActivity)((WeakReference)localObject).get();; localObject = null)
        {
          if (localObject != null) {
            ((AppActivity)localObject).realOnCreate();
          }
          i1 -= 1;
          break;
        }
      }
    }
    a(5);
    a(2, 0, 3000L);
    if (BaseApplicationImpl.processName.endsWith(":web"))
    {
      i1 = (int)(SystemClock.uptimeMillis() - BaseApplicationImpl.b);
      if (QLog.isColorLevel()) {
        QLog.i("AutoMonitor", 2, "start:" + BaseApplicationImpl.b + ", end:" + SystemClock.uptimeMillis());
      }
      ThreadManager.b().postDelayed(new gjw(this, i1), 10000L);
    }
  }
  
  public void a()
  {
    a(2, 0, 0L);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(paramInt1);
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(paramInt1, paramInt2, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onActivityFocusChanged when " + this.jdField_n_of_type_Int + ", " + paramAppActivity + ", " + paramBoolean);
    }
    if (!paramBoolean) {}
    do
    {
      do
      {
        return;
      } while ((Build.VERSION.SDK_INT >= 23) && (!Step.a(4, this, null).b()));
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
      if (this.jdField_n_of_type_Int == 2)
      {
        a(11, 1, 500L);
        a(3);
        return;
      }
      if (this.jdField_n_of_type_Int == 101)
      {
        a(11, 7, 5L);
        a(3);
        return;
      }
      if (this.jdField_n_of_type_Int == 201)
      {
        a(11, 8, 5L);
        a(3);
        return;
      }
      if ((this.jdField_n_of_type_Int == 5) || (this.jdField_n_of_type_Int == 6))
      {
        a(true);
        return;
      }
    } while (this.jdField_n_of_type_Int == 3);
  }
  
  public boolean a(AppActivity paramAppActivity, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "onActivityCreate when " + this.jdField_n_of_type_Int + ", " + paramAppActivity + ", " + paramIntent);
    }
    if (paramAppActivity == null) {
      if (this.jdField_n_of_type_Int == 1)
      {
        BaseApplicationImpl.jdField_a_of_type_Long = 0L;
        if (paramIntent != null) {
          this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("k_suicide_reborn", false);
        }
        if (QLog.isColorLevel()) {
          QLog.i("AutoMonitor", 2, "onActivityCreate when " + this.jdField_n_of_type_Int + ", " + this.jdField_i_of_type_Boolean);
        }
        if (this.jdField_i_of_type_Boolean)
        {
          paramAppActivity = jdField_n_of_type_ArrayOfInt;
          Step.a(0, this, paramAppActivity).b();
          if (GuardManager.a != null) {
            GuardManager.a.a(6, null);
          }
          a(201);
          label183:
          bool2 = false;
        }
      }
    }
    do
    {
      return bool2;
      paramAppActivity = jdField_m_of_type_ArrayOfInt;
      break;
      if (this.jdField_n_of_type_Int != 2) {
        break label183;
      }
      Step.a(0, this, l).b();
      a(101);
      break label183;
      if ((this.jdField_n_of_type_Int != 1) && (this.jdField_n_of_type_Int != 2) && (this.jdField_n_of_type_Int != 101) && (this.jdField_n_of_type_Int != 201)) {
        break label561;
      }
      if ((BaseApplicationImpl.jdField_a_of_type_JavaLangString != null) || ((paramAppActivity instanceof InstallActivity)) || ((paramAppActivity instanceof JumpActivity)) || ((paramAppActivity instanceof qfileJumpActivity))) {
        break label346;
      }
      paramIntent = new Intent(paramAppActivity, InstallActivity.class);
      paramIntent.addFlags(603979776);
      paramAppActivity.startActivity(paramIntent);
      paramAppActivity.superFinish();
      this.o = a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      bool2 = bool1;
    } while (this.o > jdField_m_of_type_Int);
    System.exit(-1);
    return true;
    label346:
    this.jdField_a_of_type_MqqAppAppActivity = paramAppActivity;
    if (this.jdField_n_of_type_Int == 201) {
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    }
    if ((paramAppActivity instanceof InstallActivity)) {}
    for (;;)
    {
      try
      {
        new File(this.jdField_a_of_type_MqqAppAppActivity.getFilesDir(), "suicide_count").delete();
        Step.a(3, this, null).b();
        a(2, 0, 1000L);
        bool1 = bool2;
        if (this.jdField_n_of_type_Int == 1)
        {
          a(2);
          bool1 = bool2;
        }
        if (bool1)
        {
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramAppActivity));
        }
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AutoMonitor", 2, "onActivityCreate end: " + this.jdField_n_of_type_Int + ", " + bool1);
        return bool1;
      }
      catch (Throwable paramIntent)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AutoMonitor", 2, "suicide_count " + Log.getStackTraceString(paramIntent));
        continue;
      }
      label561:
      if ((this.jdField_n_of_type_Int == 5) || (this.jdField_n_of_type_Int == 6))
      {
        this.jdField_a_of_type_MqqAppAppActivity = paramAppActivity;
        a(6);
        a(2, 0, 1000L);
        bool1 = false;
      }
      else
      {
        bool1 = bool2;
        if (this.jdField_n_of_type_Int == 3) {
          bool1 = bool2;
        }
      }
    }
  }
  
  public void b()
  {
    a(2, 0, 0L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.i("AutoMonitor", 2, "handleMessage when " + this.jdField_n_of_type_Int + ", " + paramMessage);
    }
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 7: 
    case 8: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 9: 
    case 10: 
      do
      {
        do
        {
          do
          {
            return true;
            a(4, 0, 300L);
            bool1 = Step.a(13, this, null).b();
            if ((bool1) && (this.o <= jdField_m_of_type_Int))
            {
              a(5, 0, 0L);
              paramMessage = ThreadManager.a();
              i1 = paramMessage.getPriority();
              paramMessage.setPriority(10);
              if (BaseApplicationImpl.processName.endsWith(":web")) {
                a(jdField_c_of_type_ArrayOfInt, null, 6);
              }
              for (;;)
              {
                paramMessage.setPriority(i1);
                a(9, 0, 200L);
                return true;
                a(jdField_b_of_type_ArrayOfInt, d, 6);
              }
            }
            if (bool1) {
              i1 = 1;
            }
            a(3, i1, 0L);
            return true;
            a(9, 0, 200L);
            a(jdField_e_of_type_ArrayOfInt, jdField_f_of_type_ArrayOfInt, 6);
            return true;
            a(9, 0, 200L);
            a(jdField_g_of_type_ArrayOfInt, h, 6);
            return true;
            a(this.jdField_a_of_type_MqqAppAppActivity, true);
            return true;
          } while (this.jdField_a_of_type_MqqAppAppActivity == null);
          AppActivity localAppActivity = this.jdField_a_of_type_MqqAppAppActivity;
          if (paramMessage.arg1 > 0) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            if (this.o < jdField_m_of_type_Int) {
              bool2 = true;
            }
            a(localAppActivity, bool1, bool2);
            return true;
          }
        } while (this.jdField_a_of_type_MqqAppAppActivity == null);
        QQUtils.a(this.jdField_a_of_type_MqqAppAppActivity, "com.tencent.mobileqq.activity.MainActivity");
        QQUtils.a(this.jdField_a_of_type_MqqAppAppActivity, SplashActivity.class.getName());
        return true;
        if (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(4)) {
          QQUtils.a(this.jdField_a_of_type_MqqAppAppActivity.getApplicationContext(), SplashActivity.class.getName());
        }
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(4);
        return true;
        long l1 = 2100L + this.jdField_e_of_type_Long - SystemClock.uptimeMillis();
        if ((this.jdField_g_of_type_Boolean) && (l1 > 0L) && (l1 < 2100L))
        {
          if (BaseApplicationImpl.jdField_a_of_type_Long > 0L) {
            BaseApplicationImpl.jdField_a_of_type_Long += l1;
          }
          if (this.jdField_c_of_type_Long > 0L) {
            this.jdField_c_of_type_Long += l1;
          }
          a(6, 0, l1);
          return true;
        }
        c();
        return true;
        Step.a(14, this, null).b();
        return true;
        i1 = this.A - 1;
        this.A = i1;
      } while (i1 != 0);
      a(this.B, 0, 0L);
      return true;
    }
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_e_of_type_Long = SystemClock.uptimeMillis();
    }
    a(paramMessage.arg1, 0L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector
 * JD-Core Version:    0.7.0.1
 */