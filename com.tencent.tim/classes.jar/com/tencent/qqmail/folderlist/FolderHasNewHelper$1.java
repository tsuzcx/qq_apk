package com.tencent.qqmail.folderlist;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

class FolderHasNewHelper$1
  implements View.OnTouchListener
{
  FolderHasNewHelper$1(FolderHasNewHelper paramFolderHasNewHelper, PopupWindow paramPopupWindow) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      this.val$popupWindow.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.FolderHasNewHelper.1
 * JD-Core Version:    0.7.0.1
 */