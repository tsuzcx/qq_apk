package com.tencent.tim.teamwork;

import android.text.TextUtils;
import aukr;
import aulk;
import com.tencent.mobileqq.app.QQAppInterface;

public class TeamWorkFileExportHandler$1
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.val$url))) {
      return;
    }
    aulk.a(this.this$0.app, this.val$url, this.val$fileName, this.bOb, this.lr, this.this$0.app.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkFileExportHandler.1
 * JD-Core Version:    0.7.0.1
 */