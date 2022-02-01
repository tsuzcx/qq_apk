package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import java.util.LinkedHashMap;
import java.util.Map;

class QfileLocalFilePicTabView$1$1
  implements Runnable
{
  QfileLocalFilePicTabView$1$1(QfileLocalFilePicTabView.1 param1, Map paramMap, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.a.this$0.R.clear();
    this.a.this$0.R.putAll(this.kw);
    this.a.this$0.refreshUI();
    if ((this.cWQ == -1) || (this.cWR == -1))
    {
      this.a.this$0.setSelect(0);
      return;
    }
    if ((this.a.this$0.a.akM()) || (this.a.this$0.a.akN()))
    {
      this.a.this$0.setPos(this.cWQ, this.cWR);
      return;
    }
    this.a.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.1.1
 * JD-Core Version:    0.7.0.1
 */