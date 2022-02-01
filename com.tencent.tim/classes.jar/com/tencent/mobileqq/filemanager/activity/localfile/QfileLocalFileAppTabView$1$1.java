package com.tencent.mobileqq.filemanager.activity.localfile;

import agfx;
import agfy;
import agfz;
import aqha;
import aqju;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;

public class QfileLocalFileAppTabView$1$1
  implements Runnable
{
  QfileLocalFileAppTabView$1$1(QfileLocalFileAppTabView.1 param1) {}
  
  public void run()
  {
    if ((this.a.this$0.a == null) || (this.a.this$0.a.isFinishing())) {
      return;
    }
    aqju localaqju = aqha.a(QfileLocalFileAppTabView.a(this.a.this$0), 230).setMessage(2131693687).setNegativeButton(2131721058, new agfy(this)).setPositiveButton(2131693688, new agfx(this));
    localaqju.setOnDismissListener(new agfz(this));
    localaqju.setTitle(2131693689);
    localaqju.setCancelable(false);
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.show();
    this.a.this$0.refreshUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.1.1
 * JD-Core Version:    0.7.0.1
 */