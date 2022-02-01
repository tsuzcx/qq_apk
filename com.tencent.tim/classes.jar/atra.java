import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class atra
  implements View.OnClickListener
{
  public atra(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    atrj.a locala = (atrj.a)paramView.getTag();
    FileInfo localFileInfo = (FileInfo)locala.entity;
    switch (locala.actionType)
    {
    }
    for (;;)
    {
      this.this$0.refreshUI();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.b.a().dlV();
      this.this$0.f(localFileInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atra
 * JD-Core Version:    0.7.0.1
 */