package com.tencent.av.ui;

import android.app.Activity;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class DoubleVideoCtrlUI$20
  implements Runnable
{
  DoubleVideoCtrlUI$20(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.this$0.mContext != null)
    {
      localObject1 = localObject2;
      if (this.this$0.mContext.get() != null) {
        localObject1 = (ChildLockCircle)((Activity)this.this$0.mContext.get()).findViewById(2131373959);
      }
    }
    if (localObject1 != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.this$0.TAG, 1, "timtest HideChildLockUIRunnable");
      }
      ((ChildLockCircle)localObject1).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.20
 * JD-Core Version:    0.7.0.1
 */