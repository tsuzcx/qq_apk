package com.tencent.tim.filemanager.activity.localfile;

import audn;
import audt;
import java.util.HashMap;

class QfileLocalFileAppTabView$1
  implements Runnable
{
  QfileLocalFileAppTabView$1(QfileLocalFileAppTabView paramQfileLocalFileAppTabView) {}
  
  public void run()
  {
    audt.a(this.this$0.b, this.this$0);
    HashMap localHashMap = new HashMap();
    audt.a(true, audn.a().vZ(), ".apk", "", localHashMap, this.this$0);
    String str = audn.a().vY();
    if (str != null) {
      audt.a(true, str, ".apk", "", localHashMap, null);
    }
    audt.ai(localHashMap);
    QfileLocalFileAppTabView.a(this.this$0, new QfileLocalFileAppTabView.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFileAppTabView.1
 * JD-Core Version:    0.7.0.1
 */