package android.support.v4.view;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

class GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler
  extends Handler
{
  GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(GestureDetectorCompat.GestureDetectorCompatImplBase paramGestureDetectorCompatImplBase) {}
  
  GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(GestureDetectorCompat.GestureDetectorCompatImplBase paramGestureDetectorCompatImplBase, Handler paramHandler)
  {
    super(paramHandler.getLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("Unknown message " + paramMessage);
    case 1: 
      this.this$0.mListener.onShowPress(this.this$0.mCurrentDownEvent);
    }
    do
    {
      return;
      this.this$0.dispatchLongPress();
      return;
    } while (this.this$0.mDoubleTapListener == null);
    if (!this.this$0.mStillDown)
    {
      this.this$0.mDoubleTapListener.onSingleTapConfirmed(this.this$0.mCurrentDownEvent);
      return;
    }
    this.this$0.mDeferConfirmSingleTap = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler
 * JD-Core Version:    0.7.0.1
 */