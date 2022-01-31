import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public abstract class xeh
  implements xel
{
  protected float a;
  public Context a;
  public Rect a;
  protected DoodleView a;
  protected xei a;
  protected boolean b;
  protected Paint e;
  protected Paint f;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  
  public xeh(DoodleView paramDoodleView)
  {
    if (paramDoodleView == null) {
      throw new IllegalStateException("DoodleView can not be null.");
    }
    this.jdField_a_of_type_AndroidContentContext = paramDoodleView.getContext();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = paramDoodleView;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setStrokeWidth(5.0F);
    this.f.setColor(-16776961);
    this.b = false;
  }
  
  public abstract String a();
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException("illegal width or height, width=" + paramInt1 + ",height=" + paramInt2);
    }
    wxe.b("BaseLayer", "layer size,width=" + paramInt1 + ",height=" + paramInt2);
    this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.right = paramInt1;
    this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = paramInt2;
    this.n = this.jdField_a_of_type_AndroidGraphicsRect.left;
    this.o = this.jdField_a_of_type_AndroidGraphicsRect.right;
    this.l = this.jdField_a_of_type_AndroidGraphicsRect.top;
    this.m = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  public void a(xei paramxei)
  {
    this.jdField_a_of_type_Xei = paramxei;
  }
  
  protected abstract boolean a(MotionEvent paramMotionEvent);
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.width();
  }
  
  public void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setActiveLayer(this);
    }
    for (;;)
    {
      g();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.d();
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.height();
  }
  
  public abstract boolean c(MotionEvent paramMotionEvent);
  
  public final void d(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
  
  public boolean d()
  {
    return this.b;
  }
  
  public boolean d(MotionEvent paramMotionEvent)
  {
    return f(paramMotionEvent);
  }
  
  public void f()
  {
    wxe.b("BaseLayer", getClass().getName() + " onDestroy.");
  }
  
  public final boolean f(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Xei != null) {
      this.jdField_a_of_type_Xei.a(this, paramMotionEvent);
    }
    g();
    return a(paramMotionEvent);
  }
  
  public void g()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.postInvalidate();
  }
  
  public void h()
  {
    wxe.b("BaseLayer", getClass().getName() + " onPause.");
    this.b = false;
  }
  
  public void i()
  {
    wxe.b("BaseLayer", getClass().getName() + " onResume.");
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xeh
 * JD-Core Version:    0.7.0.1
 */