import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.qphone.base.util.QLog;

public class uyf
  extends uyn
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public uyg a;
  public vcv a;
  public vcw a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = uyf.class.getSimpleName();
  }
  
  public uyf(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Vcv = new vcv();
    this.jdField_a_of_type_Vcv.a(false);
    this.jdField_a_of_type_Vcv.a(6.0F);
    this.jdField_a_of_type_Vcv.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Vcv.b(this.jdField_a_of_type_Vcw, f1, f2)) {
      if (this.jdField_a_of_type_Uyg != null) {
        this.jdField_a_of_type_Uyg.a(this.jdField_a_of_type_Vcw);
      }
    }
    while ((this.jdField_a_of_type_Vcv.a(this.jdField_a_of_type_Vcw, f1, f2)) || (!this.jdField_a_of_type_Vcv.a(this.jdField_a_of_type_Vcw, f1, f2, true)) || (this.jdField_a_of_type_Uyg == null) || (this.jdField_a_of_type_Vcw == null)) {
      return;
    }
    urk.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Vcw);
    this.jdField_a_of_type_Uyg.a(this.jdField_a_of_type_Vcw, 0, 0);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Vcv.a(this.jdField_a_of_type_Vcw, paramFloat1, paramFloat2, true);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public vcw a()
  {
    return this.jdField_a_of_type_Vcw;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vcw = null;
    this.jdField_a_of_type_Vcv.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Vcw == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Vcw.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(uyg paramuyg)
  {
    this.jdField_a_of_type_Uyg = paramuyg;
  }
  
  public void a(vcw paramvcw)
  {
    this.jdField_a_of_type_Vcw = paramvcw;
    if (this.jdField_a_of_type_Vcw == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Vcw instanceof uyj))
      {
        this.jdField_a_of_type_Vcv.a(6.0F);
        this.jdField_a_of_type_Vcv.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Vcw instanceof uxx));
    this.jdField_a_of_type_Vcv.a(18.0F);
    this.jdField_a_of_type_Vcv.b(0.2F);
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
    this.jdField_a_of_type_Vcw = null;
    g();
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Vcw != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Vcv.a(this.jdField_a_of_type_Vcw, f1, f2, true))
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
    if (this.jdField_a_of_type_Uyo != null) {
      this.jdField_a_of_type_Uyo.a(this, paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Vcv.a(paramMotionEvent, true);
      if (this.jdField_a_of_type_Vcw == null) {
        break;
      }
      this.jdField_a_of_type_Uyg.a(this.jdField_a_of_type_Vcw.f, this.jdField_a_of_type_Vcw.k, (int)this.jdField_a_of_type_Vcw.l, (int)this.jdField_a_of_type_Vcw.m, this.jdField_a_of_type_Vcw.a, this.jdField_a_of_type_Vcw.e, 2);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Vcw != null)
      {
        this.jdField_a_of_type_Vcw.e = false;
        this.jdField_a_of_type_Vcw.f = false;
      }
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Vcw != null)
      {
        this.jdField_a_of_type_Vcv.a(this.jdField_a_of_type_Vcw);
        continue;
        if (this.jdField_a_of_type_Vcw != null) {
          this.jdField_a_of_type_Vcw.f = true;
        }
        if (j > 10)
        {
          this.jdField_a_of_type_Boolean = true;
          continue;
          if (this.jdField_a_of_type_Vcw != null)
          {
            this.jdField_a_of_type_Vcw.e = false;
            this.jdField_a_of_type_Vcw.f = false;
          }
          if (!this.jdField_a_of_type_Boolean) {
            a(paramMotionEvent);
          }
          this.jdField_a_of_type_Vcv.a();
          continue;
          if (this.jdField_a_of_type_Vcw != null)
          {
            this.jdField_a_of_type_Vcw.e = true;
            continue;
            if (this.jdField_a_of_type_Vcw != null) {
              this.jdField_a_of_type_Vcw.e = false;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Uyg.a(false, 0.0F, 0, 0, null, false, 2);
    return true;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    g();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyf
 * JD-Core Version:    0.7.0.1
 */