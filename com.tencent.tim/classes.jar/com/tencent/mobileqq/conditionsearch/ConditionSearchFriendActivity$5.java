package com.tencent.mobileqq.conditionsearch;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.qphone.base.util.QLog;

class ConditionSearchFriendActivity$5
  implements Runnable
{
  ConditionSearchFriendActivity$5(ConditionSearchFriendActivity paramConditionSearchFriendActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = this.this$0.d.getHeight();
    ConditionSearchFriendActivity.b(this.this$0, this.cMy - (this.this$0.mRoot.getBottom() - i) + this.aMN);
    int j = this.this$0.getResources().getDisplayMetrics().heightPixels;
    int k = this.this$0.getResources().getDisplayMetrics().widthPixels;
    if (QLog.isColorLevel()) {
      QLog.d("meassure", 2, "(" + k + "," + j + ")value: " + ConditionSearchFriendActivity.a(this.this$0) + " itemTop:" + this.cMy + "  pvTop:" + (this.this$0.mRoot.getBottom() - i) + "  itemHeight:" + this.aMN + " RootBottom:" + this.this$0.mRoot.getBottom() + " pvHeight:" + i);
    }
    if ((ConditionSearchFriendActivity.a(this.this$0) <= 0) || (this.cMy == -1) || (this.aMN == -1)) {
      return;
    }
    this.this$0.By.scrollBy(0, ConditionSearchFriendActivity.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.5
 * JD-Core Version:    0.7.0.1
 */