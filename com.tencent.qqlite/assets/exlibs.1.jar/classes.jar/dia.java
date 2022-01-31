import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileBaseExpandableListAdapter.CloudItemHolder;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;

public class dia
  implements View.OnClickListener
{
  public dia(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    WeiYunFileInfo localWeiYunFileInfo = null;
    int i = 0;
    if ((localObject instanceof QfileCloudFileBaseExpandableListAdapter.CloudItemHolder))
    {
      paramView = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
      i = paramView.c;
      localWeiYunFileInfo = (WeiYunFileInfo)paramView.a;
    }
    for (;;)
    {
      this.a.a(localWeiYunFileInfo, i);
      return;
      if ((localObject instanceof QfileWeiYunImageExpandableListAdapter.ImageHolder))
      {
        localWeiYunFileInfo = (WeiYunFileInfo)((QfileWeiYunImageExpandableListAdapter.ImageHolder)paramView.getTag()).a;
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dia
 * JD-Core Version:    0.7.0.1
 */