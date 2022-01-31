import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileRecentImageExpandableListAdapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentFileBaseExpandableListAdapter.RecentItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class dmq
  implements View.OnClickListener
{
  public dmq(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    FileManagerEntity localFileManagerEntity = null;
    if ((localObject instanceof QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)) {
      localFileManagerEntity = (FileManagerEntity)((QfileRecentFileBaseExpandableListAdapter.RecentItemHolder)paramView.getTag()).a;
    }
    for (;;)
    {
      this.a.c(localFileManagerEntity);
      return;
      if ((localObject instanceof QfileRecentImageExpandableListAdapter.ImageHolder)) {
        localFileManagerEntity = (FileManagerEntity)((QfileRecentImageExpandableListAdapter.ImageHolder)paramView.getTag()).a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dmq
 * JD-Core Version:    0.7.0.1
 */