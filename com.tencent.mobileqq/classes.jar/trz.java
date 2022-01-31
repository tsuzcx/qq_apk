import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class trz
{
  private static Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  public bcpq a;
  public String a;
  public WeakReference<Activity> a;
  public List<int[]> a;
  private try jdField_a_of_type_Try;
  public boolean a;
  public boolean b = true;
  
  public trz(Activity paramActivity)
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
    this.jdField_a_of_type_Try.a(b(paramInt));
  }
  
  public void a(try paramtry)
  {
    this.jdField_a_of_type_Try = paramtry;
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
        if (this.jdField_a_of_type_Bcpq != null) {
          break;
        }
        localActivity = a();
      } while (localActivity == null);
      int i = localActivity.getResources().getDimensionPixelSize(2131298865);
      this.jdField_a_of_type_Bcpq = new bcpq(localActivity);
      this.jdField_a_of_type_Bcpq.a(ajyc.a(2131713971));
      this.jdField_a_of_type_Bcpq.b(i);
    } while (this.jdField_a_of_type_Bcpq.isShowing());
    this.jdField_a_of_type_Bcpq.show();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
  }
  
  public void d()
  {
    a();
    if (this.jdField_a_of_type_Try != null) {
      this.jdField_a_of_type_Try.a();
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Try != null) {
      this.jdField_a_of_type_Try.b();
    }
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_Try != null) {
      this.jdField_a_of_type_Try.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     trz
 * JD-Core Version:    0.7.0.1
 */