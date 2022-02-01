import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agcl
  implements View.OnClickListener
{
  public agcl(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = (agnh.a)paramView.getTag();
    Object localObject1 = ((agnh.a)localObject2).b;
    int i;
    if (paramView.getId() == 2131367020)
    {
      i = 1;
      if (!((FileInfo)localObject1).isDirectory()) {
        break label58;
      }
      LocalFileBrowserActivity.a(this.this$0, ((FileInfo)localObject1).getPath(), true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      label58:
      if ((this.this$0.akL()) && (i == 0))
      {
        if ((this.this$0.akO()) && (!agmz.hasFlag(agmz.cYa)))
        {
          localObject1 = aqha.a(this.this$0, 2131700303);
          ((aqju)localObject1).setPositiveButton(2131721079, new aqha.a());
          ((aqju)localObject1).show();
        }
        else
        {
          if (agmz.d((FileInfo)localObject1)) {
            agmz.e((FileInfo)localObject1);
          }
          for (;;)
          {
            this.this$0.deR();
            if (!this.this$0.akL()) {
              break label230;
            }
            ((agnh.a)localObject2).a.setVisibility(0);
            ((agnh.a)localObject2).a.setChecked(agmz.d((FileInfo)localObject1));
            break;
            if (this.this$0.ccD) {
              agmz.clearSelected();
            }
            if (((FileInfo)localObject1).getType() == -1) {
              ((FileInfo)localObject1).setType(ahav.getFileType(((FileInfo)localObject1).getPath()));
            }
            agmz.d((FileInfo)localObject1);
            if (this.this$0.ccD) {
              LocalFileBrowserActivity.a(this.this$0);
            }
          }
          label230:
          ((agnh.a)localObject2).a.setVisibility(8);
        }
      }
      else if (!this.this$0.H())
      {
        if (QLog.isColorLevel()) {
          QLog.i(LocalFileBrowserActivity.TAG, 2, "click too fast , wait a minute.");
        }
      }
      else
      {
        if (this.this$0.akL()) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
        }
        this.this$0.aM();
        Object localObject3 = ahav.a((FileInfo)localObject1);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.p(((FileManagerEntity)localObject3).nSessionId);
        localForwardFileInfo.Oj(3);
        localForwardFileInfo.setType(10000);
        localForwardFileInfo.setLocalPath(((FileInfo)localObject1).getPath());
        localForwardFileInfo.setFileName(((FileInfo)localObject1).getName());
        localForwardFileInfo.setFileSize(((FileInfo)localObject1).getSize());
        localObject2 = new Intent(this.this$0.getApplicationContext(), FileBrowserActivity.class);
        ((Intent)localObject2).putExtra("fileinfo", localForwardFileInfo);
        if ((((FileManagerEntity)localObject3).nFileType == 0) || (((FileManagerEntity)localObject3).nFileType == 1))
        {
          agmz.en(this.this$0.wA);
          ((Intent)localObject2).putExtra("clicked_file_hashcode", ((FileInfo)localObject1).hashCode());
        }
        localObject3 = new ahau.a();
        ((ahau.a)localObject3).bJE = "file_viewer_in";
        ((ahau.a)localObject3).cYX = 80;
        ((ahau.a)localObject3).bJF = ahbj.getExtension(((FileInfo)localObject1).getName());
        ((ahau.a)localObject3).nFileSize = ((FileInfo)localObject1).getSize();
        ahau.a(this.this$0.app.getCurrentAccountUin(), (ahau.a)localObject3);
        this.this$0.startActivityForResult((Intent)localObject2, 102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agcl
 * JD-Core Version:    0.7.0.1
 */