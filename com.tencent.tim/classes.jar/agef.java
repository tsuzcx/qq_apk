import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agef
  implements View.OnClickListener
{
  public agef(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    agep.a locala = (agep.a)paramView.getTag();
    Object localObject2 = (WeiYunFileInfo)locala.entity;
    Object localObject1 = QfileBaseCloudFileTabView.d(this.this$0).a().c(((WeiYunFileInfo)localObject2).bIk);
    if (localObject1 != null) {
      if (locala.actionType == 1)
      {
        this.this$0.a.a().dlW();
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          ahao.OS(2131693819);
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
        agzy.a((FileManagerEntity)localObject1).a(false, this.this$0.a, new ageg(this, (FileManagerEntity)localObject1));
      }
    }
    for (;;)
    {
      this.this$0.refreshUI();
      break;
      if (locala.actionType == 3)
      {
        this.this$0.a.a().dlY();
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          ahao.OS(2131693819);
          break;
        }
        agzy.a((FileManagerEntity)localObject1).a(false, this.this$0.a, new ageh(this, (FileManagerEntity)localObject1));
        continue;
      }
      if (locala.actionType == 0)
      {
        this.this$0.a.a().dlV();
        localObject2 = new ahau.a();
        ((ahau.a)localObject2).bJE = "file_viewer_in";
        ((ahau.a)localObject2).cYX = 73;
        ((ahau.a)localObject2).bJF = ahbj.getExtension(((FileManagerEntity)localObject1).fileName);
        ((ahau.a)localObject2).nFileSize = ((FileManagerEntity)localObject1).fileSize;
        ahau.a(QfileBaseCloudFileTabView.g(this.this$0).getCurrentAccountUin(), (ahau.a)localObject2);
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
      else if (locala.actionType == 2)
      {
        this.this$0.a.a().dlX();
        QfileBaseCloudFileTabView.h(this.this$0).a().bZ(((FileManagerEntity)localObject1).nSessionId);
        continue;
        this.this$0.a.a().dlW();
        localObject1 = new agei(this, (WeiYunFileInfo)localObject2);
        if ((((WeiYunFileInfo)localObject2).nFileSize > agmx.fJ()) && (ahav.amK())) {
          ahav.b(false, this.this$0.a, (ahal.a)localObject1);
        } else {
          ((ahal.a)localObject1).aD();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agef
 * JD-Core Version:    0.7.0.1
 */