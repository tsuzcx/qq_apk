import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class atpy
  implements View.OnLongClickListener
{
  public atpy(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.this$0))) {
      return false;
    }
    this.this$0.b.eum();
    Object localObject;
    int i;
    if (QfileBaseCloudFileTabView.c(this.this$0))
    {
      localObject = paramView.getTag();
      if (!(localObject instanceof atqm.a)) {
        break label80;
      }
      paramView = (atqm.a)paramView.getTag();
      i = paramView.actionType;
      paramView = (WeiYunFileInfo)paramView.entity;
    }
    for (;;)
    {
      this.this$0.a(paramView, i);
      return true;
      label80:
      if (!(localObject instanceof atpn)) {
        break;
      }
      paramView = (WeiYunFileInfo)((atpn)paramView.getTag()).entity;
      i = -1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpy
 * JD-Core Version:    0.7.0.1
 */