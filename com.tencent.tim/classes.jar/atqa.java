import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class atqa
  implements View.OnClickListener
{
  public atqa(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof atqm.a))
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)((atqm.a)paramView.getTag()).entity;
      QfileBaseCloudFileTabView.a(this.this$0, localWeiYunFileInfo);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqa
 * JD-Core Version:    0.7.0.1
 */