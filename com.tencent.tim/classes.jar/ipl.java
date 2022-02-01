import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public class ipl
  extends ipk
{
  private static final PointF FOCUS_DELTA_ZERO = new PointF();
  private final ipl.a a;
  private PointF mCurrFocusInternal;
  private PointF mFocusDeltaExternal = new PointF();
  private PointF mFocusExternal = new PointF();
  private PointF mPrevFocusInternal;
  
  public ipl(Context paramContext, ipl.a parama)
  {
    super(paramContext);
    this.a = parama;
  }
  
  private PointF determineFocalPoint(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    float f2 = 0.0F;
    while (i < j)
    {
      f2 += paramMotionEvent.getX(i);
      f1 += paramMotionEvent.getY(i);
      i += 1;
    }
    return new PointF(f2 / j, f1 / j);
  }
  
  public PointF getFocusDelta()
  {
    return this.mFocusDeltaExternal;
  }
  
  public float getFocusX()
  {
    return this.mFocusExternal.x;
  }
  
  public float getFocusY()
  {
    return this.mFocusExternal.y;
  }
  
  protected void handleInProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.a.a(this);
      resetState();
      return;
      updateStateByEvent(paramMotionEvent);
    } while ((this.mCurrPressure / this.mPrevPressure <= 0.67F) || (!this.a.a(this)) || (this.mPrevEvent == null));
    this.mPrevEvent.recycle();
    this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
  }
  
  protected void handleStartProgressEvent(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      resetState();
      this.mPrevEvent = MotionEvent.obtain(paramMotionEvent);
      this.mTimeDelta = 0L;
      updateStateByEvent(paramMotionEvent);
      return;
    }
    this.mGestureInProgress = this.a.b(this);
  }
  
  protected void updateStateByEvent(MotionEvent paramMotionEvent)
  {
    super.updateStateByEvent(paramMotionEvent);
    MotionEvent localMotionEvent = this.mPrevEvent;
    if ((paramMotionEvent == null) || (localMotionEvent == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseGestureDetector", 2, "updateStateByEvent-->Curr Or Prev is null");
      }
      return;
    }
    this.mCurrFocusInternal = determineFocalPoint(paramMotionEvent);
    this.mPrevFocusInternal = determineFocalPoint(localMotionEvent);
    int i;
    if (localMotionEvent.getPointerCount() != paramMotionEvent.getPointerCount())
    {
      i = 1;
      if (i == 0) {
        break label125;
      }
    }
    label125:
    for (paramMotionEvent = FOCUS_DELTA_ZERO;; paramMotionEvent = new PointF(this.mCurrFocusInternal.x - this.mPrevFocusInternal.x, this.mCurrFocusInternal.y - this.mPrevFocusInternal.y))
    {
      this.mFocusDeltaExternal = paramMotionEvent;
      paramMotionEvent = this.mFocusExternal;
      paramMotionEvent.x += this.mFocusDeltaExternal.x;
      paramMotionEvent = this.mFocusExternal;
      paramMotionEvent.y += this.mFocusDeltaExternal.y;
      return;
      i = 0;
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ipl paramipl);
    
    public abstract boolean a(ipl paramipl);
    
    public abstract boolean b(ipl paramipl);
  }
  
  public static class b
    implements ipl.a
  {
    public void a(ipl paramipl) {}
    
    public boolean a(ipl paramipl)
    {
      return false;
    }
    
    public boolean b(ipl paramipl)
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipl
 * JD-Core Version:    0.7.0.1
 */