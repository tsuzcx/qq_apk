import android.content.Context;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public abstract class ipk
{
  protected final Context mContext;
  protected MotionEvent mCurrEvent;
  protected float mCurrPressure;
  protected boolean mGestureInProgress;
  protected MotionEvent mPrevEvent;
  protected float mPrevPressure;
  protected long mTimeDelta;
  
  public ipk(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  protected abstract void handleInProgressEvent(int paramInt, MotionEvent paramMotionEvent);
  
  protected abstract void handleStartProgressEvent(int paramInt, MotionEvent paramMotionEvent);
  
  public boolean isInProgress()
  {
    return this.mGestureInProgress;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (!this.mGestureInProgress) {
      handleStartProgressEvent(i, paramMotionEvent);
    }
    for (;;)
    {
      return true;
      handleInProgressEvent(i, paramMotionEvent);
    }
  }
  
  protected void resetState()
  {
    if (this.mPrevEvent != null)
    {
      this.mPrevEvent.recycle();
      this.mPrevEvent = null;
    }
    if (this.mCurrEvent != null)
    {
      this.mCurrEvent.recycle();
      this.mCurrEvent = null;
    }
    this.mGestureInProgress = false;
  }
  
  protected void updateStateByEvent(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = this.mPrevEvent;
    if ((paramMotionEvent == null) || (localMotionEvent == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseGestureDetector", 2, "updateStateByEvent-->Curr Or Prev is null");
      }
      return;
    }
    if (this.mCurrEvent != null)
    {
      this.mCurrEvent.recycle();
      this.mCurrEvent = null;
    }
    this.mCurrEvent = MotionEvent.obtain(paramMotionEvent);
    this.mTimeDelta = (paramMotionEvent.getEventTime() - localMotionEvent.getEventTime());
    this.mCurrPressure = paramMotionEvent.getPressure(paramMotionEvent.getActionIndex());
    this.mPrevPressure = localMotionEvent.getPressure(localMotionEvent.getActionIndex());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipk
 * JD-Core Version:    0.7.0.1
 */