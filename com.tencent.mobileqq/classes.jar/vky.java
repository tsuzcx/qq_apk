import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.qphone.base.util.QLog;

public class vky
  extends vlg
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public vkz a;
  public vpo a;
  public vpp a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = vky.class.getSimpleName();
  }
  
  public vky(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Vpo = new vpo();
    this.jdField_a_of_type_Vpo.a(false);
    this.jdField_a_of_type_Vpo.a(6.0F);
    this.jdField_a_of_type_Vpo.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Vpo.b(this.jdField_a_of_type_Vpp, f1, f2)) {
      if (this.jdField_a_of_type_Vkz != null) {
        this.jdField_a_of_type_Vkz.a(this.jdField_a_of_type_Vpp);
      }
    }
    while ((this.jdField_a_of_type_Vpo.a(this.jdField_a_of_type_Vpp, f1, f2)) || (!this.jdField_a_of_type_Vpo.a(this.jdField_a_of_type_Vpp, f1, f2, true)) || (this.jdField_a_of_type_Vkz == null) || (this.jdField_a_of_type_Vpp == null)) {
      return;
    }
    ved.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_Vpp);
    this.jdField_a_of_type_Vkz.a(this.jdField_a_of_type_Vpp, 0, 0);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Vpo.a(this.jdField_a_of_type_Vpp, paramFloat1, paramFloat2, true);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public vpp a()
  {
    return this.jdField_a_of_type_Vpp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vpp = null;
    this.jdField_a_of_type_Vpo.a();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Vpp == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Vpp.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(vkz paramvkz)
  {
    this.jdField_a_of_type_Vkz = paramvkz;
  }
  
  public void a(vpp paramvpp)
  {
    this.jdField_a_of_type_Vpp = paramvpp;
    if (this.jdField_a_of_type_Vpp == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Vpp instanceof vlc))
      {
        this.jdField_a_of_type_Vpo.a(6.0F);
        this.jdField_a_of_type_Vpo.b(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Vpp instanceof vkq));
    this.jdField_a_of_type_Vpo.a(18.0F);
    this.jdField_a_of_type_Vpo.b(0.2F);
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
    this.jdField_a_of_type_Vpp = null;
    g();
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Vpp != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Vpo.a(this.jdField_a_of_type_Vpp, f1, f2, true))
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
    if (this.jdField_a_of_type_Vlh != null) {
      this.jdField_a_of_type_Vlh.a(this, paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Vpo.a(paramMotionEvent, true);
      if (this.jdField_a_of_type_Vpp == null) {
        break;
      }
      this.jdField_a_of_type_Vkz.a(this.jdField_a_of_type_Vpp.f, this.jdField_a_of_type_Vpp.k, (int)this.jdField_a_of_type_Vpp.l, (int)this.jdField_a_of_type_Vpp.m, this.jdField_a_of_type_Vpp.a, this.jdField_a_of_type_Vpp.e, 2);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Vpp != null)
      {
        this.jdField_a_of_type_Vpp.e = false;
        this.jdField_a_of_type_Vpp.f = false;
      }
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Vpp != null)
      {
        this.jdField_a_of_type_Vpo.a(this.jdField_a_of_type_Vpp);
        continue;
        if (this.jdField_a_of_type_Vpp != null) {
          this.jdField_a_of_type_Vpp.f = true;
        }
        if (j > 10)
        {
          this.jdField_a_of_type_Boolean = true;
          continue;
          if (this.jdField_a_of_type_Vpp != null)
          {
            this.jdField_a_of_type_Vpp.e = false;
            this.jdField_a_of_type_Vpp.f = false;
          }
          if (!this.jdField_a_of_type_Boolean) {
            a(paramMotionEvent);
          }
          this.jdField_a_of_type_Vpo.a();
          continue;
          if (this.jdField_a_of_type_Vpp != null)
          {
            this.jdField_a_of_type_Vpp.e = true;
            continue;
            if (this.jdField_a_of_type_Vpp != null) {
              this.jdField_a_of_type_Vpp.e = false;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Vkz.a(false, 0.0F, 0, 0, null, false, 2);
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
 * Qualified Name:     vky
 * JD-Core Version:    0.7.0.1
 */