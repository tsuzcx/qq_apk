package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class FastWebActivity$24
  implements Runnable
{
  FastWebActivity$24(FastWebActivity paramFastWebActivity, View paramView, AbsListView paramAbsListView, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    int i = this.jL.getBottom() + this.b.getTop() - this.b.getBottom() - this.b.getPaddingBottom();
    this.b.setInterpolator(FastWebActivity.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d(FastWebActivity.a(this.this$0), 2, "adjust scroll Before:" + (this.aJV - i) + ", After:" + this.aJW / 2);
    }
    if (this.ate) {}
    for (i = i - this.aJW / 2 + 1;; i = i + this.aJW / 2 + 1)
    {
      int j = (int)(FastWebActivity.a(this.this$0) * 1000.0F * 2.0F * i / this.b.getFlingVelocityY());
      if (this.ate) {
        j = (int)(FastWebActivity.a(this.this$0) * 1000.0F * 2.0F * i / FastWebActivity.b(this.this$0));
      }
      this.b.smoothScrollByImmediately(i, j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.24
 * JD-Core Version:    0.7.0.1
 */