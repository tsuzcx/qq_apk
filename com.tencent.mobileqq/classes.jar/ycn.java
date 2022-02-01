import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.qphone.base.util.QLog;

public class ycn
  extends ycv
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public yco a;
  public ygv a;
  public ygw a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ycn.class.getSimpleName();
  }
  
  public ycn(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Ygv = new ygv();
    this.jdField_a_of_type_Ygv.a(false);
    this.jdField_a_of_type_Ygv.a(6.0F);
    this.jdField_a_of_type_Ygv.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Ygv.b(this.jdField_a_of_type_Ygw, f1, f2)) {
      if (this.jdField_a_of_type_Yco != null) {
        this.jdField_a_of_type_Yco.a(this.jdField_a_of_type_Ygw);
      }
    }
    while ((this.jdField_a_of_type_Ygv.a(this.jdField_a_of_type_Ygw, f1, f2)) || (!this.jdField_a_of_type_Ygv.a(this.jdField_a_of_type_Ygw, f1, f2, true)) || (this.jdField_a_of_type_Yco == null) || (this.jdField_a_of_type_Ygw == null)) {
      return;
    }
    xvv.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Ygw);
    this.jdField_a_of_type_Yco.a(this.jdField_a_of_type_Ygw, 0, 0);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Ygv.a(this.jdField_a_of_type_Ygw, paramFloat1, paramFloat2, true);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public ygw a()
  {
    return this.jdField_a_of_type_Ygw;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ygw = null;
    this.jdField_a_of_type_Ygv.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Ygw == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Ygw.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(yco paramyco)
  {
    this.jdField_a_of_type_Yco = paramyco;
  }
  
  public void a(ygw paramygw)
  {
    this.jdField_a_of_type_Ygw = paramygw;
    if (this.jdField_a_of_type_Ygw == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Ygw instanceof ycr))
      {
        this.jdField_a_of_type_Ygv.a(6.0F);
        this.jdField_a_of_type_Ygv.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Ygw instanceof ycg));
    this.jdField_a_of_type_Ygv.a(18.0F);
    this.jdField_a_of_type_Ygv.b(0.2F);
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
    this.jdField_a_of_type_Ygw = null;
    g();
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Ygw != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Ygv.a(this.jdField_a_of_type_Ygw, f1, f2, true))
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
    if (this.jdField_a_of_type_Ycw != null) {
      this.jdField_a_of_type_Ycw.a(this, paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Ygv.a(paramMotionEvent, true);
      if (this.jdField_a_of_type_Ygw == null) {
        break;
      }
      this.jdField_a_of_type_Yco.a(this.jdField_a_of_type_Ygw.f, this.jdField_a_of_type_Ygw.k, (int)this.jdField_a_of_type_Ygw.l, (int)this.jdField_a_of_type_Ygw.m, this.jdField_a_of_type_Ygw.a, this.jdField_a_of_type_Ygw.e, 2);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Ygw != null)
      {
        this.jdField_a_of_type_Ygw.e = false;
        this.jdField_a_of_type_Ygw.f = false;
      }
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Ygw != null)
      {
        this.jdField_a_of_type_Ygv.a(this.jdField_a_of_type_Ygw);
        continue;
        if (this.jdField_a_of_type_Ygw != null) {
          this.jdField_a_of_type_Ygw.f = true;
        }
        if (j > 10)
        {
          this.jdField_a_of_type_Boolean = true;
          continue;
          if (this.jdField_a_of_type_Ygw != null)
          {
            this.jdField_a_of_type_Ygw.e = false;
            this.jdField_a_of_type_Ygw.f = false;
          }
          if (!this.jdField_a_of_type_Boolean) {
            a(paramMotionEvent);
          }
          this.jdField_a_of_type_Ygv.a();
          continue;
          if (this.jdField_a_of_type_Ygw != null)
          {
            this.jdField_a_of_type_Ygw.e = true;
            continue;
            if (this.jdField_a_of_type_Ygw != null) {
              this.jdField_a_of_type_Ygw.e = false;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Yco.a(false, 0.0F, 0, 0, null, false, 2);
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
 * Qualified Name:     ycn
 * JD-Core Version:    0.7.0.1
 */