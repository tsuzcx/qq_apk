package com.tencent.mobileqq.dating;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class MsgBoxListActivity$4
  implements Runnable
{
  MsgBoxListActivity$4(MsgBoxListActivity paramMsgBoxListActivity, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.rb.setEnabled(true);
    this.rb.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= this.dS;
    ((Rect)localObject).bottom += this.aME;
    ((Rect)localObject).left -= this.mQ;
    ((Rect)localObject).right += this.aMD;
    if (QLog.isColorLevel()) {
      QLog.d("TouchDelegate", 2, " bounds.top=" + ((Rect)localObject).top + "bounds.bottom=" + ((Rect)localObject).bottom);
    }
    localObject = new TouchDelegate((Rect)localObject, this.rb);
    if (View.class.isInstance(this.rb.getParent())) {
      ((View)this.rb.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.4
 * JD-Core Version:    0.7.0.1
 */