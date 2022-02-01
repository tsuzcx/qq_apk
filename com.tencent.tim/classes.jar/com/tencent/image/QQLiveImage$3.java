package com.tencent.image;

import java.lang.ref.WeakReference;

class QQLiveImage$3
  implements Runnable
{
  QQLiveImage$3(QQLiveImage paramQQLiveImage, int paramInt, Object paramObject) {}
  
  public void run()
  {
    if ((this.this$0.mOnStateListener != null) && (this.this$0.mOnStateListener.get() != null)) {
      ((QQLiveDrawable.OnStateListener)this.this$0.mOnStateListener.get()).onStateChange(QQLiveImage.access$000(this.this$0), this.this$0.mParams, this.val$newState, this.val$extra);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.3
 * JD-Core Version:    0.7.0.1
 */