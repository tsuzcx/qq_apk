package com.tencent.mobileqq.widget;

import android.view.View;
import android.widget.ImageView;
import argh;
import com.tencent.qphone.base.util.QLog;

public class NewStyleDropdownView$2$1
  implements Runnable
{
  public NewStyleDropdownView$2$1(argh paramargh, View paramView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "arrow clicked and postDelayed 250 run, set icon up and isLastDropDown true");
    }
    ((ImageView)this.val$v).setImageDrawable(this.a.this$0.gd);
    if (this.a.this$0.a != null) {
      this.a.this$0.a.cvw();
    }
    this.a.this$0.dab = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView.2.1
 * JD-Core Version:    0.7.0.1
 */