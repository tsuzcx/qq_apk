import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class atqb
  implements View.OnClickListener
{
  public atqb(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    int i;
    if ((localObject instanceof atqm.a))
    {
      localObject = (atqm.a)paramView.getTag();
      i = ((atqm.a)localObject).actionType;
      localObject = (WeiYunFileInfo)((atqm.a)localObject).entity;
    }
    for (;;)
    {
      this.this$0.a((WeiYunFileInfo)localObject, i);
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      } while (!(localObject instanceof atpn));
      localObject = (WeiYunFileInfo)((atpn)paramView.getTag()).entity;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqb
 * JD-Core Version:    0.7.0.1
 */