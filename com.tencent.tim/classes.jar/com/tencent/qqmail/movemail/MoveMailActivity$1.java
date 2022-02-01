package com.tencent.qqmail.movemail;

import android.content.Intent;
import com.tencent.qqmail.model.mail.watcher.MailMoveWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.ui.QMTips;

class MoveMailActivity$1
  implements MailMoveWatcher
{
  MoveMailActivity$1(MoveMailActivity paramMoveMailActivity) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "MoveMailActivity", "afterCreateRule: setResult ERR MoveMail - isCreateRule:" + MoveMailActivity.access$000(this.this$0) + ", desFolderId:" + MoveMailActivity.access$100(this.this$0));
    this.this$0.getTips().hide();
    paramArrayOfLong = new Intent();
    paramArrayOfLong.putExtra("return_movemail_result", false);
    this.this$0.setResult(-1, paramArrayOfLong);
    this.this$0.finish();
  }
  
  public void onProcess(long[] paramArrayOfLong)
  {
    QMLog.log(4, "MoveMailActivity", "afterCreateRule: setResult onProcess");
    this.this$0.getTips().showLoading(2131696007);
  }
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    QMLog.log(4, "MoveMailActivity", "afterCreateRule: setResult SUCC MoveMail - isCreateRule:" + MoveMailActivity.access$000(this.this$0) + ", desFolderId:" + MoveMailActivity.access$100(this.this$0));
    this.this$0.getTips().hide();
    paramArrayOfLong = new Intent();
    paramArrayOfLong.putExtra("return_movemail_result", true);
    paramArrayOfLong.putExtra("createRule", MoveMailActivity.access$000(this.this$0));
    paramArrayOfLong.putExtra("folderId", MoveMailActivity.access$100(this.this$0));
    this.this$0.setResult(-1, paramArrayOfLong);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.MoveMailActivity.1
 * JD-Core Version:    0.7.0.1
 */