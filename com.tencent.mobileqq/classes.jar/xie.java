import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class xie
{
  private static Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  public bjbs a;
  public String a;
  public WeakReference<Activity> a;
  public List<int[]> a;
  private xid jdField_a_of_type_Xid;
  public boolean a;
  public boolean b = true;
  
  public xie(Activity paramActivity)
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
    this.jdField_a_of_type_Xid.a(b(paramInt));
  }
  
  public void a(xid paramxid)
  {
    this.jdField_a_of_type_Xid = paramxid;
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
        if (this.jdField_a_of_type_Bjbs != null) {
          break;
        }
        localActivity = a();
      } while (localActivity == null);
      int i = localActivity.getResources().getDimensionPixelSize(2131299011);
      this.jdField_a_of_type_Bjbs = new bjbs(localActivity);
      this.jdField_a_of_type_Bjbs.a(anzj.a(2131712845));
      this.jdField_a_of_type_Bjbs.b(i);
    } while (this.jdField_a_of_type_Bjbs.isShowing());
    this.jdField_a_of_type_Bjbs.show();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
  }
  
  public void d()
  {
    a();
    if (this.jdField_a_of_type_Xid != null) {
      this.jdField_a_of_type_Xid.a();
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Xid != null) {
      this.jdField_a_of_type_Xid.b();
    }
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_Xid != null) {
      this.jdField_a_of_type_Xid.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xie
 * JD-Core Version:    0.7.0.1
 */