import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.qphone.base.util.QLog;

public class xdz
  extends xeh
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public xea a;
  public xip a;
  public xiq a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = xdz.class.getSimpleName();
  }
  
  public xdz(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Xip = new xip();
    this.jdField_a_of_type_Xip.a(false);
    this.jdField_a_of_type_Xip.a(6.0F);
    this.jdField_a_of_type_Xip.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Xip.b(this.jdField_a_of_type_Xiq, f1, f2)) {
      if (this.jdField_a_of_type_Xea != null) {
        this.jdField_a_of_type_Xea.a(this.jdField_a_of_type_Xiq);
      }
    }
    while ((this.jdField_a_of_type_Xip.a(this.jdField_a_of_type_Xiq, f1, f2)) || (!this.jdField_a_of_type_Xip.a(this.jdField_a_of_type_Xiq, f1, f2, true)) || (this.jdField_a_of_type_Xea == null) || (this.jdField_a_of_type_Xiq == null)) {
      return;
    }
    wxe.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Xiq);
    this.jdField_a_of_type_Xea.a(this.jdField_a_of_type_Xiq, 0, 0);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Xip.a(this.jdField_a_of_type_Xiq, paramFloat1, paramFloat2, true);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public xiq a()
  {
    return this.jdField_a_of_type_Xiq;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xiq = null;
    this.jdField_a_of_type_Xip.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Xiq == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Xiq.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(xea paramxea)
  {
    this.jdField_a_of_type_Xea = paramxea;
  }
  
  public void a(xiq paramxiq)
  {
    this.jdField_a_of_type_Xiq = paramxiq;
    if (this.jdField_a_of_type_Xiq == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Xiq instanceof xed))
      {
        this.jdField_a_of_type_Xip.a(6.0F);
        this.jdField_a_of_type_Xip.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Xiq instanceof xdr));
    this.jdField_a_of_type_Xip.a(18.0F);
    this.jdField_a_of_type_Xip.b(0.2F);
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
    this.jdField_a_of_type_Xiq = null;
    g();
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Xiq != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Xip.a(this.jdField_a_of_type_Xiq, f1, f2, true))
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
    if (this.jdField_a_of_type_Xei != null) {
      this.jdField_a_of_type_Xei.a(this, paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Xip.a(paramMotionEvent, true);
      if (this.jdField_a_of_type_Xiq == null) {
        break;
      }
      this.jdField_a_of_type_Xea.a(this.jdField_a_of_type_Xiq.f, this.jdField_a_of_type_Xiq.k, (int)this.jdField_a_of_type_Xiq.l, (int)this.jdField_a_of_type_Xiq.m, this.jdField_a_of_type_Xiq.a, this.jdField_a_of_type_Xiq.e, 2);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Xiq != null)
      {
        this.jdField_a_of_type_Xiq.e = false;
        this.jdField_a_of_type_Xiq.f = false;
      }
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Xiq != null)
      {
        this.jdField_a_of_type_Xip.a(this.jdField_a_of_type_Xiq);
        continue;
        if (this.jdField_a_of_type_Xiq != null) {
          this.jdField_a_of_type_Xiq.f = true;
        }
        if (j > 10)
        {
          this.jdField_a_of_type_Boolean = true;
          continue;
          if (this.jdField_a_of_type_Xiq != null)
          {
            this.jdField_a_of_type_Xiq.e = false;
            this.jdField_a_of_type_Xiq.f = false;
          }
          if (!this.jdField_a_of_type_Boolean) {
            a(paramMotionEvent);
          }
          this.jdField_a_of_type_Xip.a();
          continue;
          if (this.jdField_a_of_type_Xiq != null)
          {
            this.jdField_a_of_type_Xiq.e = true;
            continue;
            if (this.jdField_a_of_type_Xiq != null) {
              this.jdField_a_of_type_Xiq.e = false;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Xea.a(false, 0.0F, 0, 0, null, false, 2);
    return true;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    g();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xdz
 * JD-Core Version:    0.7.0.1
 */