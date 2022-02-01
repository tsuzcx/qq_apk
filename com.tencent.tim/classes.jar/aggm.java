import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aggm
  implements View.OnClickListener
{
  public aggm(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    aggw.b localb = (aggw.b)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)localb.entity;
    if (5 != localFileManagerEntity.cloudType) {
      ahav.I(localFileManagerEntity);
    }
    switch (localb.actionType)
    {
    }
    for (;;)
    {
      this.this$0.refreshUI();
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.this$0.a.a().dlW();
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          ahao.OS(2131693819);
        }
        else if (localFileManagerEntity.status == 16)
        {
          ahao.OS(2131694128);
        }
        else
        {
          agzy.a(localFileManagerEntity).a(false, this.this$0.getContext(), new aggn(this, localFileManagerEntity));
          break;
          this.this$0.a.a().dlV();
          this.this$0.a(localFileManagerEntity, localb.a, false);
          break;
          this.this$0.a.a().dlX();
          if (localFileManagerEntity.getCloudType() == 0)
          {
            QfileBaseRecentFileTabView.w(this.this$0).a().js(localFileManagerEntity.nSessionId);
            break;
          }
          if (localFileManagerEntity.getCloudType() == 6)
          {
            ((acde)QfileBaseRecentFileTabView.x(this.this$0).getBusinessHandler(8)).g(0, localFileManagerEntity.uniseq, false);
            break;
          }
          QfileBaseRecentFileTabView.y(this.this$0).a().bZ(localFileManagerEntity.nSessionId);
          break;
          this.this$0.a.a().dlY();
          if (!aqiw.isNetSupport(BaseApplication.getContext()))
          {
            ahao.OS(2131693819);
          }
          else
          {
            if (localFileManagerEntity.status != 16) {
              break label344;
            }
            ahao.OS(2131694128);
          }
        }
      }
      label344:
      boolean bool = localFileManagerEntity.isSend();
      agzy.a(localFileManagerEntity).a(bool, this.this$0.a, new aggo(this, localFileManagerEntity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggm
 * JD-Core Version:    0.7.0.1
 */