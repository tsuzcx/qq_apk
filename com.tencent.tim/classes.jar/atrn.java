import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import java.util.ArrayList;
import java.util.List;

public class atrn
  implements View.OnClickListener
{
  public atrn(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject = (atse.b)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((atse.b)localObject).entity;
    if (5 != localFileManagerEntity.cloudType) {
      audx.I(localFileManagerEntity);
    }
    switch (((atse.b)localObject).actionType)
    {
    }
    for (;;)
    {
      this.this$0.refreshUI();
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.this$0.b.a().dlW();
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          auds.OS(2131693819);
        }
        else if (localFileManagerEntity.status == 16)
        {
          auds.OS(2131694128);
        }
        else
        {
          audk.a(localFileManagerEntity).a(false, this.this$0.getContext(), new atro(this, localFileManagerEntity));
          break;
          this.this$0.b.a().dlV();
          this.this$0.aa(localFileManagerEntity);
          break;
          this.this$0.b.a().dlX();
          if (localFileManagerEntity.getCloudType() == 0)
          {
            QfileBaseRecentFileTabView.t(this.this$0).a().js(localFileManagerEntity.nSessionId);
            break;
          }
          if (localFileManagerEntity.getCloudType() == 6)
          {
            ((acde)QfileBaseRecentFileTabView.u(this.this$0).getBusinessHandler(8)).g(0, localFileManagerEntity.uniseq, false);
            break;
          }
          QfileBaseRecentFileTabView.v(this.this$0).a().bZ(localFileManagerEntity.nSessionId);
          break;
          this.this$0.b.a().dlY();
          if (!aqiw.isNetSupport(BaseApplication.getContext()))
          {
            auds.OS(2131693819);
          }
          else
          {
            if (localFileManagerEntity.status != 16) {
              break label347;
            }
            auds.OS(2131694128);
          }
        }
      }
      label347:
      if (localFileManagerEntity.nOpType == 0)
      {
        i = 1;
        label357:
        localObject = audk.a(localFileManagerEntity);
        if (i != 0) {
          break label419;
        }
        label368:
        if (!((audk)localObject).bd(bool)) {
          break label430;
        }
        localObject = this.this$0.getContext();
        if (i == 0) {
          break label424;
        }
      }
      label419:
      label424:
      for (int i = 2131693832;; i = 2131693828)
      {
        ahal.a((Context)localObject, 2131693826, i, new atrp(this, localFileManagerEntity));
        break;
        i = 0;
        break label357;
        bool = false;
        break label368;
      }
      label430:
      if (localFileManagerEntity.getCloudType() == 0)
      {
        QfileBaseRecentFileTabView.z(this.this$0).a().jt(localFileManagerEntity.nSessionId);
      }
      else if (localFileManagerEntity.getCloudType() == 6)
      {
        localObject = (acde)QfileBaseRecentFileTabView.A(this.this$0).getBusinessHandler(8);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(localFileManagerEntity.uniseq));
        if (!((acde)localObject).af(localArrayList)) {
          auds.OS(2131693818);
        }
      }
      else
      {
        QfileBaseRecentFileTabView.B(this.this$0).a().jk(localFileManagerEntity.nSessionId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atrn
 * JD-Core Version:    0.7.0.1
 */