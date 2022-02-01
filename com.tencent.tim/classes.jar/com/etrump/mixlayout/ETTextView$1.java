package com.etrump.mixlayout;

import android.view.View;
import aofk.c;
import com.tencent.mobileqq.widget.AnimationTextView.b;
import com.tencent.qphone.base.util.QLog;
import ko;

class ETTextView$1
  implements Runnable
{
  ETTextView$1(ETTextView paramETTextView) {}
  
  public void run()
  {
    if (this.this$0.getTag(2131368813) != null) {}
    for (boolean bool = ((Boolean)this.this$0.getTag(2131368813)).booleanValue();; bool = false)
    {
      if ((this.this$0.isSingleClick) && (this.this$0.onSingleClick != null) && (!bool))
      {
        if (this.this$0.isUsingHYFont())
        {
          Object localObject = this.this$0.mLayout.a(this.this$0.mEmojiX, this.this$0.mEmojiY);
          if ((localObject instanceof aofk.c))
          {
            localObject = (aofk.c)localObject;
            this.this$0.mClickEpId = ((aofk.c)localObject).dOt;
            this.this$0.mClickcEId = ((aofk.c)localObject).dOu;
            if (QLog.isColorLevel()) {
              QLog.d("ETTextView", 2, "click span: " + this.this$0.mClickEpId);
            }
          }
        }
        this.this$0.onSingleClick.fk(this.this$0);
      }
      this.this$0.setTag(2131368813, Boolean.valueOf(false));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView.1
 * JD-Core Version:    0.7.0.1
 */