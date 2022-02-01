package com.tencent.mobileqq.util;

import android.app.ProgressDialog;

class SystemDragUtils$2$3
  implements Runnable
{
  SystemDragUtils$2$3(SystemDragUtils.2 param2) {}
  
  public void run()
  {
    if ((this.this$0.h != null) && (this.this$0.h.isShowing())) {
      this.this$0.h.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.2.3
 * JD-Core Version:    0.7.0.1
 */