import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class atsa
  implements View.OnClickListener
{
  public atsa(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    FileManagerEntity localFileManagerEntity = null;
    if ((localObject instanceof atse.b)) {
      localFileManagerEntity = (FileManagerEntity)((atse.b)paramView.getTag()).entity;
    }
    for (;;)
    {
      if (localFileManagerEntity != null) {
        this.this$0.aa(localFileManagerEntity);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof atpn)) {
        localFileManagerEntity = (FileManagerEntity)((atpn)paramView.getTag()).entity;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atsa
 * JD-Core Version:    0.7.0.1
 */