package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import aqnm;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.qphone.base.util.QLog;

class AddContactsView$13
  implements Runnable
{
  AddContactsView$13(AddContactsView paramAddContactsView) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.j != null)
      {
        if (this.this$0.h != null) {
          return;
        }
        View localView = ((LayoutInflater)this.this$0.mContext.getSystemService("layout_inflater")).inflate(2131558530, this.this$0.j, false);
        localView.measure(0, 0);
        this.this$0.h = new PopupWindow(localView);
        this.this$0.h.setHeight(-2);
        this.this$0.h.setWidth(-2);
        this.this$0.h.setOutsideTouchable(false);
        this.this$0.h.setFocusable(false);
        int i = aqnm.dip2px(16.0F);
        int j = -localView.getMeasuredHeight();
        int k = this.this$0.j.getMeasuredHeight();
        int m = aqnm.dip2px(24.0F);
        this.this$0.h.showAsDropDown(this.this$0.j, i, j - k + m);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("AddContactsView", 1, "face2faceGuideTipsRunnable exception, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.13
 * JD-Core Version:    0.7.0.1
 */