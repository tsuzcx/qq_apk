package com.tencent.mobileqq.matchchat;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

final class MatchChatMsgListFragment$6
  implements Runnable
{
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.6
 * JD-Core Version:    0.7.0.1
 */