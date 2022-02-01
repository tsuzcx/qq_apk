import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public abstract class rgf
  implements rgi
{
  protected DoodleView a;
  protected rgf.a a;
  protected Paint aI;
  protected Paint ba;
  protected int brc;
  protected int brd;
  public Context context;
  public Rect drawRect;
  protected boolean isActive;
  protected int limitLeft;
  protected int limitRight;
  protected float scaleValue;
  
  public rgf(DoodleView paramDoodleView)
  {
    if (paramDoodleView == null) {
      throw new IllegalStateException("DoodleView can not be null.");
    }
    this.context = paramDoodleView.getContext();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = paramDoodleView;
    init();
  }
  
  private void init()
  {
    this.drawRect = new Rect();
    this.ba = new Paint();
    this.ba.setAntiAlias(true);
    this.aI = new Paint();
    this.aI.setAntiAlias(true);
    this.aI.setStyle(Paint.Style.STROKE);
    this.aI.setStrokeWidth(5.0F);
    this.aI.setColor(-16776961);
    this.isActive = false;
  }
  
  protected abstract boolean H(MotionEvent paramMotionEvent);
  
  public abstract boolean J(MotionEvent paramMotionEvent);
  
  public boolean K(MotionEvent paramMotionEvent)
  {
    return M(paramMotionEvent);
  }
  
  public final boolean M(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Rgf$a != null) {
      this.jdField_a_of_type_Rgf$a.a(this, paramMotionEvent);
    }
    notifyChange();
    return H(paramMotionEvent);
  }
  
  public void a(rgf.a parama)
  {
    this.jdField_a_of_type_Rgf$a = parama;
  }
  
  public void ae(float paramFloat)
  {
    this.scaleValue = paramFloat;
  }
  
  protected abstract void an(Canvas paramCanvas);
  
  public final void draw(Canvas paramCanvas)
  {
    an(paramCanvas);
  }
  
  public int getHeight()
  {
    return this.drawRect.height();
  }
  
  public abstract String getTag();
  
  public int getWidth()
  {
    return this.drawRect.width();
  }
  
  public boolean isActive()
  {
    return this.isActive;
  }
  
  public void notifyChange()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.postInvalidate();
  }
  
  public void onDestroy()
  {
    ram.d("BaseLayer", getClass().getName() + " onDestroy.");
  }
  
  public void onPause()
  {
    ram.d("BaseLayer", getClass().getName() + " onPause.");
    this.isActive = false;
  }
  
  public void onResume()
  {
    ram.d("BaseLayer", getClass().getName() + " onResume.");
    this.isActive = true;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException("illegal width or height, width=" + paramInt1 + ",height=" + paramInt2);
    }
    ram.d("BaseLayer", "layer size,width=" + paramInt1 + ",height=" + paramInt2);
    this.drawRect.left = 0;
    this.drawRect.right = paramInt1;
    this.drawRect.top = 0;
    this.drawRect.bottom = paramInt2;
    this.limitLeft = this.drawRect.left;
    this.limitRight = this.drawRect.right;
    this.brc = this.drawRect.top;
    this.brd = this.drawRect.bottom;
  }
  
  public void tJ(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setActiveLayer(this);
    }
    for (;;)
    {
      notifyChange();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.buy();
    }
  }
  
  public static abstract interface a<T extends rgf>
  {
    public abstract boolean a(T paramT, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgf
 * JD-Core Version:    0.7.0.1
 */