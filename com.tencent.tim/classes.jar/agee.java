import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agee
  implements View.OnClickListener
{
  public agee(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    int i;
    if ((localObject instanceof agep.a))
    {
      localObject = (agep.a)paramView.getTag();
      i = ((agep.a)localObject).actionType;
      localObject = (WeiYunFileInfo)((agep.a)localObject).entity;
    }
    for (;;)
    {
      QfileBaseCloudFileTabView localQfileBaseCloudFileTabView;
      if (localObject != null)
      {
        if ((paramView.getId() == 2131367020) && (QfileBaseCloudFileTabView.c(this.this$0))) {
          anot.a(QfileBaseCloudFileTabView.c(this.this$0), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
        }
        localQfileBaseCloudFileTabView = this.this$0;
        if (paramView.getId() != 2131367020) {
          break label155;
        }
      }
      label155:
      for (boolean bool = true;; bool = false)
      {
        localQfileBaseCloudFileTabView.a((WeiYunFileInfo)localObject, i, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject instanceof agdp)) {
          break label160;
        }
        localObject = (WeiYunFileInfo)((agdp)paramView.getTag()).entity;
        i = -1;
        break;
      }
      label160:
      i = 0;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agee
 * JD-Core Version:    0.7.0.1
 */