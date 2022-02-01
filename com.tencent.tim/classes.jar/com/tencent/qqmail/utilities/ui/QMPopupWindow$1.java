package com.tencent.qqmail.utilities.ui;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.PopupWindow;

class QMPopupWindow$1
  implements View.OnKeyListener
{
  QMPopupWindow$1(QMPopupWindow paramQMPopupWindow) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    long l = System.currentTimeMillis();
    if (((paramInt == 82) || (paramInt == 4)) && (this.this$0.isShowing()) && (l - this.this$0.mLastShowTime > 500L))
    {
      this.this$0.mWindow.dismiss();
      Log.e("algerwindow", "close");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */