import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class xej
{
  private static Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  public biau a;
  public String a;
  public WeakReference<Activity> a;
  public List<int[]> a;
  private xei jdField_a_of_type_Xei;
  public boolean a;
  public boolean b = true;
  
  public xej(Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public static boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - jdField_a_of_type_JavaLangLong.longValue();
    if ((l2 > 0L) && (l2 < 800L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isFastDoubleClick", 2, "time:" + l1 + ", mLastClickTIme:" + jdField_a_of_type_JavaLangLong + ", timeDiff:" + l2);
      }
      return true;
    }
    jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
    return false;
  }
  
  public Activity a()
  {
    return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  protected abstract void a();
  
  protected void a(int paramInt)
  {
    if (a()) {
      return;
    }
    b();
    this.jdField_a_of_type_Xei.a(b(paramInt));
  }
  
  public void a(xei paramxei)
  {
    this.jdField_a_of_type_Xei = paramxei;
  }
  
  public abstract int b(int paramInt);
  
  public void b()
  {
    if (!this.b) {}
    do
    {
      Activity localActivity;
      do
      {
        return;
        if (this.jdField_a_of_type_Biau != null) {
          break;
        }
        localActivity = a();
      } while (localActivity == null);
      int i = localActivity.getResources().getDimensionPixelSize(2131298998);
      this.jdField_a_of_type_Biau = new biau(localActivity);
      this.jdField_a_of_type_Biau.a(anni.a(2131712736));
      this.jdField_a_of_type_Biau.b(i);
    } while (this.jdField_a_of_type_Biau.isShowing());
    this.jdField_a_of_type_Biau.show();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
      this.jdField_a_of_type_Biau.dismiss();
    }
  }
  
  public void d()
  {
    a();
    if (this.jdField_a_of_type_Xei != null) {
      this.jdField_a_of_type_Xei.a();
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Xei != null) {
      this.jdField_a_of_type_Xei.b();
    }
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_Xei != null) {
      this.jdField_a_of_type_Xei.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xej
 * JD-Core Version:    0.7.0.1
 */