import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class atqk
  implements View.OnClickListener
{
  public atqk(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseCloudFileTabView.TAG, 2, "qfilebaserecenttabview del error, tag is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramView.getTag();
      if (localWeiYunFileInfo != null)
      {
        if (this.this$0.a != null) {
          this.this$0.a.bk(null);
        }
        QfileBaseCloudFileTabView.a(this.this$0).a().b(localWeiYunFileInfo);
      }
      this.this$0.a.bk(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.this$0.setListFooter();
      this.this$0.refreshList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqk
 * JD-Core Version:    0.7.0.1
 */