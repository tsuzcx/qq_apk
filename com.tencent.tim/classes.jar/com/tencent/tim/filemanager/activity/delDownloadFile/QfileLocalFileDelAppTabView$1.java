package com.tencent.tim.filemanager.activity.delDownloadFile;

import audn;
import audt;
import java.util.HashMap;

class QfileLocalFileDelAppTabView$1
  implements Runnable
{
  QfileLocalFileDelAppTabView$1(QfileLocalFileDelAppTabView paramQfileLocalFileDelAppTabView) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    audt.a(false, audn.a().vZ(), ".apk", "", localHashMap, this.this$0);
    String str = audn.a().vY();
    if (str != null) {
      audt.a(false, str, ".apk", "", localHashMap, null);
    }
    audt.ai(localHashMap);
    QfileLocalFileDelAppTabView.a(this.this$0, new QfileLocalFileDelAppTabView.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.delDownloadFile.QfileLocalFileDelAppTabView.1
 * JD-Core Version:    0.7.0.1
 */