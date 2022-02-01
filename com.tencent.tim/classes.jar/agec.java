import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agec
  implements View.OnClickListener
{
  agec(ageb paramageb, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.val$view.getTag();
    if ((localObject instanceof agdp))
    {
      localObject = (WeiYunFileInfo)((agdp)this.val$view.getTag()).entity;
      if ((agmz.mz(((WeiYunFileInfo)localObject).bIk)) && (QLog.isColorLevel())) {
        QLog.d(QfileBaseCloudFileTabView.TAG, 2, "there is a bug ");
      }
      QfileBaseCloudFileTabView.b(this.a.this$0).a().b((WeiYunFileInfo)localObject);
      this.a.this$0.refreshList();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof agep.a))
      {
        localObject = (WeiYunFileInfo)((agep.a)this.val$view.getTag()).entity;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseCloudFileTabView.TAG, 2, "unknow Object");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agec
 * JD-Core Version:    0.7.0.1
 */