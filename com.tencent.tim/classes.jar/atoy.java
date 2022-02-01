import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;

public class atoy
  implements View.OnClickListener
{
  public atoy(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (atwf.a)paramView.getTag();
    FileInfo localFileInfo = ((atwf.a)localObject1).b;
    if (localFileInfo.isDirectory()) {
      LocalFileBrowserActivity.a(this.this$0, localFileInfo.getPath(), true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2;
      if (this.this$0.akL())
      {
        if (atwb.d(localFileInfo)) {
          atwb.e(localFileInfo);
        }
        for (;;)
        {
          this.this$0.deR();
          if (!this.this$0.akL()) {
            break label235;
          }
          ((atwf.a)localObject1).a.setVisibility(0);
          ((atwf.a)localObject1).a.setChecked(atwb.d(localFileInfo));
          break;
          localObject2 = (atgc)this.this$0.app.getManager(373);
          if ((this.this$0.dit) && (((atgc)localObject2).iu() < localFileInfo.getSize()))
          {
            auds.JG("选择的文件大于" + athu.c((float)((atgc)localObject2).iu()) + "，添加失败");
          }
          else
          {
            if (this.this$0.ccD) {
              atwb.clearSelected();
            }
            if (localFileInfo.getType() == -1) {
              localFileInfo.setType(audx.fM(localFileInfo.getPath()));
            }
            atwb.d(localFileInfo);
            if (this.this$0.ccD) {
              LocalFileBrowserActivity.a(this.this$0);
            }
          }
        }
        label235:
        ((atwf.a)localObject1).a.setVisibility(8);
      }
      else if (!this.this$0.H())
      {
        if (QLog.isColorLevel()) {
          QLog.i(LocalFileBrowserActivity.TAG, 2, "click too fast , wait a minute.");
        }
      }
      else
      {
        this.this$0.aM();
        localObject2 = audx.a(localFileInfo);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.p(((FileManagerEntity)localObject2).nSessionId);
        localForwardFileInfo.Oj(3);
        localForwardFileInfo.setType(10000);
        localForwardFileInfo.setLocalPath(localFileInfo.getPath());
        localForwardFileInfo.setFileName(localFileInfo.getName());
        localForwardFileInfo.setFileSize(localFileInfo.getSize());
        localObject1 = new Intent(this.this$0.getApplicationContext(), FileBrowserActivity.class);
        ((Intent)localObject1).putExtra("fileinfo", localForwardFileInfo);
        if ((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 1))
        {
          atwb.en(this.this$0.wA);
          ((Intent)localObject1).putExtra("clicked_file_hashcode", localFileInfo.hashCode());
        }
        localObject2 = new audw.b();
        ((audw.b)localObject2).bJE = "file_viewer_in";
        ((audw.b)localObject2).cYX = 80;
        ((audw.b)localObject2).bJF = aueh.getExtension(localFileInfo.getName());
        ((audw.b)localObject2).nFileSize = localFileInfo.getSize();
        audw.a(this.this$0.app.getCurrentAccountUin(), (audw.b)localObject2);
        this.this$0.startActivityForResult((Intent)localObject1, 102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atoy
 * JD-Core Version:    0.7.0.1
 */