import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agfv
  implements View.OnClickListener
{
  public agfv(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    agga.a locala = (agga.a)paramView.getTag();
    FileInfo localFileInfo = (FileInfo)locala.entity;
    switch (locala.actionType)
    {
    }
    for (;;)
    {
      this.this$0.refreshUI();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.a.a().dlV();
      this.this$0.a(localFileInfo, locala.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfv
 * JD-Core Version:    0.7.0.1
 */