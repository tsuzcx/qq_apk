import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;

public class atqc
  implements View.OnClickListener
{
  public atqc(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = (atqm.a)paramView.getTag();
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)((atqm.a)localObject2).entity;
    Object localObject1 = QfileBaseCloudFileTabView.b(this.this$0).a().c(localWeiYunFileInfo.bIk);
    if (localObject1 != null) {
      if (((atqm.a)localObject2).actionType == 1)
      {
        this.this$0.b.a().dlW();
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          auds.OS(2131693819);
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
        if (audk.a((FileManagerEntity)localObject1).bd(true)) {
          ahal.a(this.this$0.getContext(), 2131693826, 2131693828, new atqd(this, (FileManagerEntity)localObject1));
        }
      }
    }
    for (;;)
    {
      this.this$0.refreshUI();
      break;
      ((FileManagerEntity)localObject1).nOpType = 5;
      QfileBaseCloudFileTabView.d(this.this$0).a().jk(((FileManagerEntity)localObject1).nSessionId);
      continue;
      if (((atqm.a)localObject2).actionType == 3)
      {
        this.this$0.b.a().dlY();
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          auds.OS(2131693819);
          break;
        }
        if (audk.a((FileManagerEntity)localObject1).bd(true))
        {
          ahal.a(this.this$0.getContext(), 2131693826, 2131693832, new atqe(this, (FileManagerEntity)localObject1));
          continue;
        }
        ((FileManagerEntity)localObject1).nOpType = 5;
        QfileBaseCloudFileTabView.f(this.this$0).a().jk(((FileManagerEntity)localObject1).nSessionId);
        continue;
      }
      if (((atqm.a)localObject2).actionType == 0)
      {
        this.this$0.b.a().dlV();
        localObject2 = new audw.b();
        ((audw.b)localObject2).bJE = "file_viewer_in";
        ((audw.b)localObject2).cYX = 73;
        ((audw.b)localObject2).bJF = aueh.getExtension(((FileManagerEntity)localObject1).fileName);
        ((audw.b)localObject2).nFileSize = ((FileManagerEntity)localObject1).fileSize;
        audw.a(QfileBaseCloudFileTabView.g(this.this$0).getCurrentAccountUin(), (audw.b)localObject2);
        localObject2 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject2).Oj(((FileManagerEntity)localObject1).getCloudType());
        ((ForwardFileInfo)localObject2).setType(10001);
        ((ForwardFileInfo)localObject2).p(((FileManagerEntity)localObject1).nSessionId);
        ((ForwardFileInfo)localObject2).jB(((FileManagerEntity)localObject1).uniseq);
        ((ForwardFileInfo)localObject2).setFileName(((FileManagerEntity)localObject1).fileName);
        ((ForwardFileInfo)localObject2).setFileSize(((FileManagerEntity)localObject1).fileSize);
        ((ForwardFileInfo)localObject2).setUuid(((FileManagerEntity)localObject1).Uuid);
        localObject1 = new Intent(QfileBaseCloudFileTabView.a(this.this$0), FileBrowserActivity.class);
        ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
        QfileBaseCloudFileTabView.b(this.this$0).startActivityForResult((Intent)localObject1, 102);
      }
      else if (((atqm.a)localObject2).actionType == 2)
      {
        this.this$0.b.a().dlX();
        QfileBaseCloudFileTabView.h(this.this$0).a().bZ(((FileManagerEntity)localObject1).nSessionId);
        continue;
        this.this$0.b.a().dlW();
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          auds.OS(2131693819);
          break;
        }
        if ((localWeiYunFileInfo.nFileSize > atvz.fJ()) && (audx.amK()))
        {
          ahal.a(this.this$0.getContext(), 2131693826, 2131693832, new atqf(this, localWeiYunFileInfo));
        }
        else
        {
          localObject1 = audx.b(localWeiYunFileInfo);
          QfileBaseCloudFileTabView.k(this.this$0).a().l((FileManagerEntity)localObject1);
          QfileBaseCloudFileTabView.l(this.this$0).a().s((FileManagerEntity)localObject1);
          this.this$0.f((FileManagerEntity)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqc
 * JD-Core Version:    0.7.0.1
 */