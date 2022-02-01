import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.qphone.base.util.QLog;

public class yxk
  extends yxs
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public yxl a;
  public zca a;
  public zcb a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = yxk.class.getSimpleName();
  }
  
  public yxk(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Zca = new zca();
    this.jdField_a_of_type_Zca.a(false);
    this.jdField_a_of_type_Zca.a(6.0F);
    this.jdField_a_of_type_Zca.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Zca.b(this.jdField_a_of_type_Zcb, f1, f2)) {
      if (this.jdField_a_of_type_Yxl != null) {
        this.jdField_a_of_type_Yxl.a(this.jdField_a_of_type_Zcb);
      }
    }
    while ((this.jdField_a_of_type_Zca.a(this.jdField_a_of_type_Zcb, f1, f2)) || (!this.jdField_a_of_type_Zca.a(this.jdField_a_of_type_Zcb, f1, f2, true)) || (this.jdField_a_of_type_Yxl == null) || (this.jdField_a_of_type_Zcb == null)) {
      return;
    }
    yqp.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Zcb);
    this.jdField_a_of_type_Yxl.a(this.jdField_a_of_type_Zcb, 0, 0);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Zca.a(this.jdField_a_of_type_Zcb, paramFloat1, paramFloat2, true);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public zcb a()
  {
    return this.jdField_a_of_type_Zcb;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Zcb = null;
    this.jdField_a_of_type_Zca.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Zcb == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Zcb.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(yxl paramyxl)
  {
    this.jdField_a_of_type_Yxl = paramyxl;
  }
  
  public void a(zcb paramzcb)
  {
    this.jdField_a_of_type_Zcb = paramzcb;
    if (this.jdField_a_of_type_Zcb == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Zcb instanceof yxo))
      {
        this.jdField_a_of_type_Zca.a(6.0F);
        this.jdField_a_of_type_Zca.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Zcb instanceof yxc));
    this.jdField_a_of_type_Zca.a(18.0F);
    this.jdField_a_of_type_Zca.b(0.2F);
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Zcb = null;
    g();
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Zcb != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Zca.a(this.jdField_a_of_type_Zcb, f1, f2, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    }
    return false;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean e(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Yxt != null) {
      this.jdField_a_of_type_Yxt.a(this, paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Zca.a(paramMotionEvent, true);
      if (this.jdField_a_of_type_Zcb == null) {
        break;
      }
      this.jdField_a_of_type_Yxl.a(this.jdField_a_of_type_Zcb.f, this.jdField_a_of_type_Zcb.k, (int)this.jdField_a_of_type_Zcb.l, (int)this.jdField_a_of_type_Zcb.m, this.jdField_a_of_type_Zcb.a, this.jdField_a_of_type_Zcb.e, 2);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Zcb != null)
      {
        this.jdField_a_of_type_Zcb.e = false;
        this.jdField_a_of_type_Zcb.f = false;
      }
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Zcb != null)
      {
        this.jdField_a_of_type_Zca.a(this.jdField_a_of_type_Zcb);
        continue;
        if (this.jdField_a_of_type_Zcb != null) {
          this.jdField_a_of_type_Zcb.f = true;
        }
        if (j > 10)
        {
          this.jdField_a_of_type_Boolean = true;
          continue;
          if (this.jdField_a_of_type_Zcb != null)
          {
            this.jdField_a_of_type_Zcb.e = false;
            this.jdField_a_of_type_Zcb.f = false;
          }
          if (!this.jdField_a_of_type_Boolean) {
            a(paramMotionEvent);
          }
          this.jdField_a_of_type_Zca.a();
          continue;
          if (this.jdField_a_of_type_Zcb != null)
          {
            this.jdField_a_of_type_Zcb.e = true;
            continue;
            if (this.jdField_a_of_type_Zcb != null) {
              this.jdField_a_of_type_Zcb.e = false;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Yxl.a(false, 0.0F, 0, 0, null, false, 2);
    return true;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    g();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxk
 * JD-Core Version:    0.7.0.1
 */