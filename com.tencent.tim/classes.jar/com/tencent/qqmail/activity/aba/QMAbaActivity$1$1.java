package com.tencent.qqmail.activity.aba;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qqmail.model.media.QMCameraManager.StartRunnable;
import com.tencent.qqmail.utilities.log.QMLog;

class QMAbaActivity$1$1
  implements QMCameraManager.StartRunnable
{
  QMAbaActivity$1$1(QMAbaActivity.1 param1) {}
  
  public void run(Intent paramIntent)
  {
    QMLog.log(4, "QMAbaActivity", "click camera button path ");
    this.this$1.this$0.getActivity().startActivityForResult(paramIntent, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.aba.QMAbaActivity.1.1
 * JD-Core Version:    0.7.0.1
 */