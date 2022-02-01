import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.qphone.base.util.QLog;

public class rga
  extends rgf
  implements Drawable.Callback
{
  public static final String TAG = rga.class.getSimpleName();
  public rga.a a;
  public riy.a a;
  public riy a;
  public boolean aHA;
  public int mStartY;
  
  public rga(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Riy = new riy();
    this.jdField_a_of_type_Riy.tP(false);
    this.jdField_a_of_type_Riy.setMaxScale(6.0F);
    this.jdField_a_of_type_Riy.setMinScale(0.2F);
  }
  
  private void O(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Riy.b(this.jdField_a_of_type_Riy$a, f1, f2)) {
      if (this.jdField_a_of_type_Rga$a != null) {
        this.jdField_a_of_type_Rga$a.c(this.jdField_a_of_type_Riy$a);
      }
    }
    while ((this.jdField_a_of_type_Riy.a(this.jdField_a_of_type_Riy$a, f1, f2)) || (!this.jdField_a_of_type_Riy.a(this.jdField_a_of_type_Riy$a, f1, f2, true)) || (this.jdField_a_of_type_Rga$a == null) || (this.jdField_a_of_type_Riy$a == null)) {
      return;
    }
    ram.d(TAG, "click the item:" + this.jdField_a_of_type_Riy$a);
    this.jdField_a_of_type_Rga$a.a(this.jdField_a_of_type_Riy$a, 0, 0);
  }
  
  private boolean z(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Riy.a(this.jdField_a_of_type_Riy$a, paramFloat1, paramFloat2, true);
  }
  
  protected boolean H(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Riy.a(this.jdField_a_of_type_Riy$a, f1, f2, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    }
    return false;
  }
  
  public boolean J(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean L(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Rgf$a != null) {
      this.jdField_a_of_type_Rgf$a.a(this, paramMotionEvent);
    }
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.mStartY);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Riy.a(paramMotionEvent, true);
      if (this.jdField_a_of_type_Riy$a == null) {
        break;
      }
      this.jdField_a_of_type_Rga$a.b(this.jdField_a_of_type_Riy$a.aIq, this.jdField_a_of_type_Riy$a.nI, (int)this.jdField_a_of_type_Riy$a.translateXValue, (int)this.jdField_a_of_type_Riy$a.translateYValue, this.jdField_a_of_type_Riy$a.centerP, this.jdField_a_of_type_Riy$a.aHC, 2);
      return true;
      this.mStartY = i;
      this.aHA = false;
      if (this.jdField_a_of_type_Riy$a != null)
      {
        this.jdField_a_of_type_Riy$a.aHC = false;
        this.jdField_a_of_type_Riy$a.aIq = false;
      }
      z(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_Riy$a != null)
      {
        this.jdField_a_of_type_Riy.d(this.jdField_a_of_type_Riy$a);
        continue;
        if (this.jdField_a_of_type_Riy$a != null) {
          this.jdField_a_of_type_Riy$a.aIq = true;
        }
        if (j > 10)
        {
          this.aHA = true;
          continue;
          if (this.jdField_a_of_type_Riy$a != null)
          {
            this.jdField_a_of_type_Riy$a.aHC = false;
            this.jdField_a_of_type_Riy$a.aIq = false;
          }
          if (!this.aHA) {
            O(paramMotionEvent);
          }
          this.jdField_a_of_type_Riy.reset();
          continue;
          if (this.jdField_a_of_type_Riy$a != null)
          {
            this.jdField_a_of_type_Riy$a.aHC = true;
            continue;
            if (this.jdField_a_of_type_Riy$a != null) {
              this.jdField_a_of_type_Riy$a.aHC = false;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Rga$a.b(false, 0.0F, 0, 0, null, false, 2);
    return true;
  }
  
  public boolean Lp()
  {
    return this.jdField_a_of_type_Riy$a != null;
  }
  
  public riy.a a()
  {
    return this.jdField_a_of_type_Riy$a;
  }
  
  public void a(rga.a parama)
  {
    this.jdField_a_of_type_Rga$a = parama;
  }
  
  protected void an(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Riy$a == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_Riy$a.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void ao(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void b(riy.a parama)
  {
    this.jdField_a_of_type_Riy$a = parama;
    if (this.jdField_a_of_type_Riy$a == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Riy$a instanceof rgb.b))
      {
        this.jdField_a_of_type_Riy.setMaxScale(6.0F);
        this.jdField_a_of_type_Riy.setMinScale(0.2F);
        return;
      }
    } while (!(this.jdField_a_of_type_Riy$a instanceof rft.b));
    this.jdField_a_of_type_Riy.setMaxScale(18.0F);
    this.jdField_a_of_type_Riy.setMinScale(0.2F);
  }
  
  public void btS()
  {
    this.jdField_a_of_type_Riy$a = null;
    notifyChange();
  }
  
  public void clear()
  {
    this.jdField_a_of_type_Riy$a = null;
    this.jdField_a_of_type_Riy.reset();
  }
  
  public String getTag()
  {
    return TAG;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    notifyChange();
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
  
  public static abstract interface a
  {
    public abstract void a(riy.a parama, int paramInt1, int paramInt2);
    
    public abstract void b(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3);
    
    public abstract void c(riy.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rga
 * JD-Core Version:    0.7.0.1
 */