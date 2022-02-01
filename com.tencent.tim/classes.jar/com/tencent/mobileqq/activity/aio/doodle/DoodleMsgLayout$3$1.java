package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class DoodleMsgLayout$3$1
  implements Runnable
{
  DoodleMsgLayout$3$1(DoodleMsgLayout.3 param3, Drawable paramDrawable) {}
  
  public void run()
  {
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent start update drawable:" + this.a.bRe);
    if (this.a.bRe != DoodleMsgLayout.a(this.a.this$0)) {
      return;
    }
    if (DoodleMsgLayout.b(this.a.this$0) != null) {
      DoodleMsgLayout.b(this.a.this$0).setImageDrawable(null);
    }
    if (DoodleMsgLayout.c(this.a.this$0) != null) {
      DoodleMsgLayout.c(this.a.this$0).setImageDrawable(null);
    }
    if (DoodleMsgLayout.a(this.a.this$0) != null) {
      DoodleMsgLayout.a(this.a.this$0).setImageDrawable(this.dG);
    }
    DoodleMsgLayout.a(this.a.this$0, 0);
    if (DoodleMsgLayout.a(this.a.this$0) != null) {
      this.a.this$0.CH(DoodleMsgLayout.a(this.a.this$0).getDataState());
    }
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent finish update drawable:" + this.a.bRe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.3.1
 * JD-Core Version:    0.7.0.1
 */