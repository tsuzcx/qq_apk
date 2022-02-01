import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class atrb
  implements View.OnClickListener
{
  public atrb(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof atrj.a))
    {
      FileInfo localFileInfo = (FileInfo)((atrj.a)paramView.getTag()).entity;
      QfileBaseLocalFileTabView.a(this.this$0, localFileInfo);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atrb
 * JD-Core Version:    0.7.0.1
 */