import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter.LocalItemHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;

public class djr
  implements View.OnClickListener
{
  public djr(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    paramView = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
    FileInfo localFileInfo = (FileInfo)paramView.a;
    switch (paramView.c)
    {
    }
    for (;;)
    {
      this.a.i();
      return;
      this.a.a.a().ac();
      this.a.c(localFileInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     djr
 * JD-Core Version:    0.7.0.1
 */