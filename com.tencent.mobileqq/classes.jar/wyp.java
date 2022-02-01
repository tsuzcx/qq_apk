import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class wyp
{
  private static Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  public bisl a;
  public String a;
  public WeakReference<Activity> a;
  public List<int[]> a;
  private wyo jdField_a_of_type_Wyo;
  public boolean a;
  public boolean b = true;
  
  public wyp(Activity paramActivity)
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
    this.jdField_a_of_type_Wyo.a(b(paramInt));
  }
  
  public void a(wyo paramwyo)
  {
    this.jdField_a_of_type_Wyo = paramwyo;
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
        if (this.jdField_a_of_type_Bisl != null) {
          break;
        }
        localActivity = a();
      } while (localActivity == null);
      int i = localActivity.getResources().getDimensionPixelSize(2131299080);
      this.jdField_a_of_type_Bisl = new bisl(localActivity);
      this.jdField_a_of_type_Bisl.a(anvx.a(2131713424));
      this.jdField_a_of_type_Bisl.b(i);
    } while (this.jdField_a_of_type_Bisl.isShowing());
    this.jdField_a_of_type_Bisl.show();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  public void d()
  {
    a();
    if (this.jdField_a_of_type_Wyo != null) {
      this.jdField_a_of_type_Wyo.a();
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Wyo != null) {
      this.jdField_a_of_type_Wyo.b();
    }
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_Wyo != null) {
      this.jdField_a_of_type_Wyo.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyp
 * JD-Core Version:    0.7.0.1
 */