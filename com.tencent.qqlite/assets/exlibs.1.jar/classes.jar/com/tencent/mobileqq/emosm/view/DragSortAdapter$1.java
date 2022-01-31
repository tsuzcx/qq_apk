package com.tencent.mobileqq.emosm.view;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;

class DragSortAdapter$1
  implements Runnable
{
  DragSortAdapter$1(DragSortAdapter paramDragSortAdapter, Button paramButton) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.val$updateBtn.getHitRect((Rect)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("DragSortAdapter", 2, "===originalRnage====width:" + ((Rect)localObject).width() + " height:" + ((Rect)localObject).height());
    }
    ((Rect)localObject).left += 5;
    ((Rect)localObject).right += 5;
    ((Rect)localObject).bottom += 5;
    ((Rect)localObject).top += 5;
    localObject = new TouchDelegate((Rect)localObject, this.val$updateBtn);
    if (View.class.isInstance(this.val$updateBtn.getParent())) {
      ((View)this.val$updateBtn.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.1
 * JD-Core Version:    0.7.0.1
 */