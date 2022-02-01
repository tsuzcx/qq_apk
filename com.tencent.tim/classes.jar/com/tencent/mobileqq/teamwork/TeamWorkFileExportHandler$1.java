package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import aoam;
import aobk;
import com.tencent.mobileqq.app.QQAppInterface;

public class TeamWorkFileExportHandler$1
  implements Runnable
{
  public TeamWorkFileExportHandler$1(aoam paramaoam, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.val$url))) {
      return;
    }
    aobk.a(this.this$0.app, this.val$url, this.val$fileName, this.bOb, this.lr, this.this$0.app.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileExportHandler.1
 * JD-Core Version:    0.7.0.1
 */