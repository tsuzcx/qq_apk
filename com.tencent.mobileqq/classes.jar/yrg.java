import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.qphone.base.util.QLog;

public class yrg
  extends yro
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public yrh a;
  public yvo a;
  public yvp a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = yrg.class.getSimpleName();
  }
  
  public yrg(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Yvo = new yvo();
    this.jdField_a_of_type_Yvo.a(false);
    this.jdField_a_of_type_Yvo.a(6.0F);
    this.jdField_a_of_type_Yvo.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Yvo.b(this.jdField_a_of_type_Yvp, f1, f2)) {
      if (this.jdField_a_of_type_Yrh != null) {
        this.jdField_a_of_type_Yrh.a(this.jdField_a_of_type_Yvp);
      }
    }
    while ((this.jdField_a_of_type_Yvo.a(this.jdField_a_of_type_Yvp, f1, f2)) || (!this.jdField_a_of_type_Yvo.a(this.jdField_a_of_type_Yvp, f1, f2, true)) || (this.jdField_a_of_type_Yrh == null) || (this.jdField_a_of_type_Yvp == null)) {
      return;
    }
    ykq.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Yvp);
    this.jdField_a_of_type_Yrh.a(this.jdField_a_of_type_Yvp, 0, 0);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Yvo.a(this.jdField_a_of_type_Yvp, paramFloat1, paramFloat2, true);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public yvp a()
  {
    return this.jdField_a_of_type_Yvp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Yvp = null;
    this.jdField_a_of_type_Yvo.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Yvp == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Yvp.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(yrh paramyrh)
  {
    this.jdField_a_of_type_Yrh = paramyrh;
  }
  
  public void a(yvp paramyvp)
  {
    this.jdField_a_of_type_Yvp = paramyvp;
    if (this.jdField_a_of_type_Yvp == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Yvp instanceof yrk))
      {
        this.jdField_a_of_type_Yvo.a(6.0F);
        this.jdField_a_of_type_Yvo.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Yvp instanceof yqz));
    this.jdField_a_of_type_Yvo.a(18.0F);
    this.jdField_a_of_type_Yvo.b(0.2F);
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
    this.jdField_a_of_type_Yvp = null;
    g();
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Yvp != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Yvo.a(this.jdField_a_of_type_Yvp, f1, f2, true))
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
    if (this.jdField_a_of_type_Yrp != null) {
      this.jdField_a_of_type_Yrp.a(this, paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Yvo.a(paramMotionEvent, true);
      if (this.jdField_a_of_type_Yvp == null) {
        break;
      }
      this.jdField_a_of_type_Yrh.a(this.jdField_a_of_type_Yvp.f, this.jdField_a_of_type_Yvp.k, (int)this.jdField_a_of_type_Yvp.l, (int)this.jdField_a_of_type_Yvp.m, this.jdField_a_of_type_Yvp.a, this.jdField_a_of_type_Yvp.e, 2);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Yvp != null)
      {
        this.jdField_a_of_type_Yvp.e = false;
        this.jdField_a_of_type_Yvp.f = false;
      }
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Yvp != null)
      {
        this.jdField_a_of_type_Yvo.a(this.jdField_a_of_type_Yvp);
        continue;
        if (this.jdField_a_of_type_Yvp != null) {
          this.jdField_a_of_type_Yvp.f = true;
        }
        if (j > 10)
        {
          this.jdField_a_of_type_Boolean = true;
          continue;
          if (this.jdField_a_of_type_Yvp != null)
          {
            this.jdField_a_of_type_Yvp.e = false;
            this.jdField_a_of_type_Yvp.f = false;
          }
          if (!this.jdField_a_of_type_Boolean) {
            a(paramMotionEvent);
          }
          this.jdField_a_of_type_Yvo.a();
          continue;
          if (this.jdField_a_of_type_Yvp != null)
          {
            this.jdField_a_of_type_Yvp.e = true;
            continue;
            if (this.jdField_a_of_type_Yvp != null) {
              this.jdField_a_of_type_Yvp.e = false;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Yrh.a(false, 0.0F, 0, 0, null, false, 2);
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
 * Qualified Name:     yrg
 * JD-Core Version:    0.7.0.1
 */