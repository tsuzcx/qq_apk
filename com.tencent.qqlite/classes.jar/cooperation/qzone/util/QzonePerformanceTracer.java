package cooperation.qzone.util;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Debug;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fnx;
import fny;
import fnz;
import foa;
import fob;
import foc;
import fod;
import java.lang.reflect.Field;

public class QzonePerformanceTracer
{
  public static final int a = 52428800;
  private static QzonePerformanceTracer jdField_a_of_type_CooperationQzoneUtilQzonePerformanceTracer;
  public static final String a = "qzone_performance";
  public static final String b = "QZ_Per_Config";
  public static String c;
  public static String d;
  private static final String jdField_e_of_type_JavaLangString = QzonePerformanceTracer.class.getSimpleName();
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new fny(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new fnx(this);
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int = 200;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new fnz(this);
  private View jdField_b_of_type_AndroidViewView;
  private final int jdField_c_of_type_Int = 300;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new foa(this);
  private View jdField_c_of_type_AndroidViewView;
  private int jdField_d_of_type_Int = 200;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new fob(this);
  private View jdField_d_of_type_AndroidViewView;
  private int jdField_e_of_type_Int = 300;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new foc(this);
  private View jdField_e_of_type_AndroidViewView;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  
  static
  {
    jdField_c_of_type_JavaLangString = "qzone_performance_trace_need_show_window";
    jdField_d_of_type_JavaLangString = "qzone_performance_is_tracing";
  }
  
  public static int a(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i = paramContext.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  private long a()
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.a().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    if (QLog.isDevelopLevel())
    {
      QLog.d(jdField_e_of_type_JavaLangString, 4, "系统剩余内存:" + Formatter.formatFileSize(BaseApplicationImpl.a(), localMemoryInfo.availMem));
      QLog.d(jdField_e_of_type_JavaLangString, 4, "当系统剩余内存低于:" + Formatter.formatFileSize(BaseApplicationImpl.a(), localMemoryInfo.threshold) + "MB时就看成低内存运行");
    }
    return localMemoryInfo.availMem;
  }
  
  public static QzonePerformanceTracer a()
  {
    if (jdField_a_of_type_CooperationQzoneUtilQzonePerformanceTracer == null) {
      jdField_a_of_type_CooperationQzoneUtilQzonePerformanceTracer = new QzonePerformanceTracer();
    }
    return jdField_a_of_type_CooperationQzoneUtilQzonePerformanceTracer;
  }
  
  private void a(String paramString)
  {
    BaseApplicationImpl.a();
    QQToast.a(BaseApplicationImpl.getContext(), 0, paramString, 2000).a();
  }
  
  private void a(boolean paramBoolean)
  {
    e();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(jdField_d_of_type_JavaLangString, paramBoolean).commit();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      f();
      if (this.jdField_a_of_type_AndroidViewWindowManager != null)
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_AndroidViewView = null;
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("QZ_Per_Config", 4);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewWindowManager == null)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
      BaseApplication.getContext();
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)localBaseApplicationImpl.getSystemService("window"));
    }
  }
  
  private void g()
  {
    ThreadManager.a(new fod(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(BaseApplicationImpl.a());
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2002;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 8;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = 200;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = 300;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 51;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -2;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903597, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298683);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298684);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298685);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131298687).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298686);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (b())
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
      f();
    } while (this.jdField_a_of_type_AndroidViewWindowManager == null);
    this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
  
  public boolean a()
  {
    e();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(jdField_c_of_type_JavaLangString, false);
  }
  
  public void b()
  {
    if (!SystemUtil.a()) {}
    for (;;)
    {
      return;
      long l2 = 1024L * SystemUtil.a();
      long l3 = a();
      if (l2 < l3) {}
      for (long l1 = l2;; l1 = l3)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(jdField_e_of_type_JavaLangString, 4, "remainSDsize: " + l2 + "/t remainMemSize:" + l3);
        }
        if (l1 >= 16777216L) {
          break label109;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_e_of_type_JavaLangString, 2, "SDCard空间/内存空间不足，无法进行性能文件录制");
        return;
      }
      label109:
      l2 = System.currentTimeMillis();
      String str = "qzone_performance" + "_" + Long.toString(l2);
      l2 = l1;
      if (l1 > 52428800L) {
        l2 = 52428800L;
      }
      try
      {
        int i = new Long(l2).intValue() - 8388608;
        if (i > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_e_of_type_JavaLangString, 2, "maxBuffer: " + i / 1048576 + "M");
          }
          Debug.startMethodTracing(str, i);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_e_of_type_JavaLangString, 2, "无法进行性能文件录制");
        }
        localException.printStackTrace();
        return;
      }
      catch (InternalError localInternalError)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_e_of_type_JavaLangString, 2, "性能文件创建失败");
        }
        localInternalError.printStackTrace();
      }
    }
  }
  
  public boolean b()
  {
    e();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(jdField_d_of_type_JavaLangString, false);
  }
  
  public void c()
  {
    try
    {
      
      if (QLog.isColorLevel()) {
        QLog.d(jdField_e_of_type_JavaLangString, 2, "trace文件保存成功");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d(jdField_e_of_type_JavaLangString, 2, "trace文件保存失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cooperation.qzone.util.QzonePerformanceTracer
 * JD-Core Version:    0.7.0.1
 */