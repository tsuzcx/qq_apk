import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.qphone.base.util.QLog;

public class wzq
  extends wzy
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public wzr a;
  public xeg a;
  public xeh a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = wzq.class.getSimpleName();
  }
  
  public wzq(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Xeg = new xeg();
    this.jdField_a_of_type_Xeg.a(false);
    this.jdField_a_of_type_Xeg.a(6.0F);
    this.jdField_a_of_type_Xeg.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Xeg.b(this.jdField_a_of_type_Xeh, f1, f2)) {
      if (this.jdField_a_of_type_Wzr != null) {
        this.jdField_a_of_type_Wzr.a(this.jdField_a_of_type_Xeh);
      }
    }
    while ((this.jdField_a_of_type_Xeg.a(this.jdField_a_of_type_Xeh, f1, f2)) || (!this.jdField_a_of_type_Xeg.a(this.jdField_a_of_type_Xeh, f1, f2, true)) || (this.jdField_a_of_type_Wzr == null) || (this.jdField_a_of_type_Xeh == null)) {
      return;
    }
    wsv.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Xeh);
    this.jdField_a_of_type_Wzr.a(this.jdField_a_of_type_Xeh, 0, 0);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Xeg.a(this.jdField_a_of_type_Xeh, paramFloat1, paramFloat2, true);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public xeh a()
  {
    return this.jdField_a_of_type_Xeh;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xeh = null;
    this.jdField_a_of_type_Xeg.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Xeh == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Xeh.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(wzr paramwzr)
  {
    this.jdField_a_of_type_Wzr = paramwzr;
  }
  
  public void a(xeh paramxeh)
  {
    this.jdField_a_of_type_Xeh = paramxeh;
    if (this.jdField_a_of_type_Xeh == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Xeh instanceof wzu))
      {
        this.jdField_a_of_type_Xeg.a(6.0F);
        this.jdField_a_of_type_Xeg.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Xeh instanceof wzi));
    this.jdField_a_of_type_Xeg.a(18.0F);
    this.jdField_a_of_type_Xeg.b(0.2F);
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
    this.jdField_a_of_type_Xeh = null;
    g();
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Xeh != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Xeg.a(this.jdField_a_of_type_Xeh, f1, f2, true))
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
    if (this.jdField_a_of_type_Wzz != null) {
      this.jdField_a_of_type_Wzz.a(this, paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Xeg.a(paramMotionEvent, true);
      if (this.jdField_a_of_type_Xeh == null) {
        break;
      }
      this.jdField_a_of_type_Wzr.a(this.jdField_a_of_type_Xeh.f, this.jdField_a_of_type_Xeh.k, (int)this.jdField_a_of_type_Xeh.l, (int)this.jdField_a_of_type_Xeh.m, this.jdField_a_of_type_Xeh.a, this.jdField_a_of_type_Xeh.e, 2);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Xeh != null)
      {
        this.jdField_a_of_type_Xeh.e = false;
        this.jdField_a_of_type_Xeh.f = false;
      }
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Xeh != null)
      {
        this.jdField_a_of_type_Xeg.a(this.jdField_a_of_type_Xeh);
        continue;
        if (this.jdField_a_of_type_Xeh != null) {
          this.jdField_a_of_type_Xeh.f = true;
        }
        if (j > 10)
        {
          this.jdField_a_of_type_Boolean = true;
          continue;
          if (this.jdField_a_of_type_Xeh != null)
          {
            this.jdField_a_of_type_Xeh.e = false;
            this.jdField_a_of_type_Xeh.f = false;
          }
          if (!this.jdField_a_of_type_Boolean) {
            a(paramMotionEvent);
          }
          this.jdField_a_of_type_Xeg.a();
          continue;
          if (this.jdField_a_of_type_Xeh != null)
          {
            this.jdField_a_of_type_Xeh.e = true;
            continue;
            if (this.jdField_a_of_type_Xeh != null) {
              this.jdField_a_of_type_Xeh.e = false;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Wzr.a(false, 0.0F, 0, 0, null, false, 2);
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
 * Qualified Name:     wzq
 * JD-Core Version:    0.7.0.1
 */