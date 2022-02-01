import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aggk
  implements View.OnClickListener
{
  public aggk(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseRecentFileTabView.TAG, 2, "qfilebaserecenttabview del error, tag is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.getTag();
      if (localFileManagerEntity != null)
      {
        if (this.this$0.b != null) {
          this.this$0.b.bk(null);
        }
        this.this$0.Yn = localFileManagerEntity.nSessionId;
        if (QfileBaseRecentFileTabView.m(this.this$0).a().ca(this.this$0.Yn)) {
          this.this$0.d(localFileManagerEntity);
        }
      }
      this.this$0.b.bk(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.this$0.refreshList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggk
 * JD-Core Version:    0.7.0.1
 */