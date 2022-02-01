package com.tencent.tim.filemanager.activity.localfile;

import atsl;
import atso;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.filemanager.activity.FMActivity;
import java.util.LinkedHashMap;

class QfileLocalFilePicTabView$2$1
  implements Runnable
{
  QfileLocalFilePicTabView$2$1(QfileLocalFilePicTabView.2 param2, LinkedHashMap paramLinkedHashMap) {}
  
  public void run()
  {
    this.a.this$0.R.clear();
    this.a.this$0.R.putAll(this.X);
    Object localObject = QfileLocalFilePicTabView.a(this.a.this$0).a().a(1);
    int j;
    int i;
    if ((localObject != null) && ((localObject instanceof atsl)))
    {
      localObject = (atsl)localObject;
      j = ((atsl)localObject).OA();
      i = ((atsl)localObject).OB();
    }
    for (;;)
    {
      this.a.this$0.refreshUI();
      if ((j == -1) || (i == -1))
      {
        this.a.this$0.setSelect(0);
        return;
      }
      if (this.a.this$0.b.aWg)
      {
        this.a.this$0.setPos(j, i);
        return;
      }
      this.a.this$0.setSelect(0);
      return;
      i = -1;
      j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.localfile.QfileLocalFilePicTabView.2.1
 * JD-Core Version:    0.7.0.1
 */