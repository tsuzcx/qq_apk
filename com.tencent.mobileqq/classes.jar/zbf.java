import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.qphone.base.util.QLog;

public class zbf
  extends zbn
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public zbg a;
  public zfv a;
  public zfw a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = zbf.class.getSimpleName();
  }
  
  public zbf(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Zfv = new zfv();
    this.jdField_a_of_type_Zfv.a(false);
    this.jdField_a_of_type_Zfv.a(6.0F);
    this.jdField_a_of_type_Zfv.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Zfv.b(this.jdField_a_of_type_Zfw, f1, f2)) {
      if (this.jdField_a_of_type_Zbg != null) {
        this.jdField_a_of_type_Zbg.a(this.jdField_a_of_type_Zfw);
      }
    }
    while ((this.jdField_a_of_type_Zfv.a(this.jdField_a_of_type_Zfw, f1, f2)) || (!this.jdField_a_of_type_Zfv.a(this.jdField_a_of_type_Zfw, f1, f2, true)) || (this.jdField_a_of_type_Zbg == null) || (this.jdField_a_of_type_Zfw == null)) {
      return;
    }
    yuk.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Zfw);
    this.jdField_a_of_type_Zbg.a(this.jdField_a_of_type_Zfw, 0, 0);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Zfv.a(this.jdField_a_of_type_Zfw, paramFloat1, paramFloat2, true);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public zfw a()
  {
    return this.jdField_a_of_type_Zfw;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Zfw = null;
    this.jdField_a_of_type_Zfv.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Zfw == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Zfw.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(zbg paramzbg)
  {
    this.jdField_a_of_type_Zbg = paramzbg;
  }
  
  public void a(zfw paramzfw)
  {
    this.jdField_a_of_type_Zfw = paramzfw;
    if (this.jdField_a_of_type_Zfw == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Zfw instanceof zbj))
      {
        this.jdField_a_of_type_Zfv.a(6.0F);
        this.jdField_a_of_type_Zfv.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Zfw instanceof zax));
    this.jdField_a_of_type_Zfv.a(18.0F);
    this.jdField_a_of_type_Zfv.b(0.2F);
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
    this.jdField_a_of_type_Zfw = null;
    g();
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Zfw != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Zfv.a(this.jdField_a_of_type_Zfw, f1, f2, true))
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
    if (this.jdField_a_of_type_Zbo != null) {
      this.jdField_a_of_type_Zbo.a(this, paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Zfv.a(paramMotionEvent, true);
      if (this.jdField_a_of_type_Zfw == null) {
        break;
      }
      this.jdField_a_of_type_Zbg.a(this.jdField_a_of_type_Zfw.f, this.jdField_a_of_type_Zfw.k, (int)this.jdField_a_of_type_Zfw.l, (int)this.jdField_a_of_type_Zfw.m, this.jdField_a_of_type_Zfw.a, this.jdField_a_of_type_Zfw.e, 2);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Zfw != null)
      {
        this.jdField_a_of_type_Zfw.e = false;
        this.jdField_a_of_type_Zfw.f = false;
      }
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Zfw != null)
      {
        this.jdField_a_of_type_Zfv.a(this.jdField_a_of_type_Zfw);
        continue;
        if (this.jdField_a_of_type_Zfw != null) {
          this.jdField_a_of_type_Zfw.f = true;
        }
        if (j > 10)
        {
          this.jdField_a_of_type_Boolean = true;
          continue;
          if (this.jdField_a_of_type_Zfw != null)
          {
            this.jdField_a_of_type_Zfw.e = false;
            this.jdField_a_of_type_Zfw.f = false;
          }
          if (!this.jdField_a_of_type_Boolean) {
            a(paramMotionEvent);
          }
          this.jdField_a_of_type_Zfv.a();
          continue;
          if (this.jdField_a_of_type_Zfw != null)
          {
            this.jdField_a_of_type_Zfw.e = true;
            continue;
            if (this.jdField_a_of_type_Zfw != null) {
              this.jdField_a_of_type_Zfw.e = false;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Zbg.a(false, 0.0F, 0, 0, null, false, 2);
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
 * Qualified Name:     zbf
 * JD-Core Version:    0.7.0.1
 */