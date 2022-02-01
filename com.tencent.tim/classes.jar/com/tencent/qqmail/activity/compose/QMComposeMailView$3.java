package com.tencent.qqmail.activity.compose;

import android.util.Log;

class QMComposeMailView$3
  implements Runnable
{
  QMComposeMailView$3(QMComposeMailView paramQMComposeMailView) {}
  
  public void run()
  {
    Log.i("QMComposeMailView", "Execute focus change " + QMComposeMailView.access$100(this.this$0));
    if (QMComposeMailView.access$100(this.this$0))
    {
      this.this$0.showformatToolbar(true);
      return;
    }
    this.this$0.hideformatToolbar(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeMailView.3
 * JD-Core Version:    0.7.0.1
 */