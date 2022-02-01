import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class agqw
  implements View.OnClickListener
{
  agqw(FileManagerEntity paramFileManagerEntity, Activity paramActivity, agsa paramagsa) {}
  
  public void onClick(View paramView)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      ahau.a locala = new ahau.a();
      locala.bJE = "file_forward";
      locala.cYX = 71;
      locala.nFileSize = this.j.fileSize;
      locala.bJF = ahbj.getExtension(this.j.fileName);
      locala.bJH = ahav.H(this.j.getCloudType(), this.j.peerType);
      ahau.a(localQQAppInterface.getCurrentAccountUin(), locala);
      ahbr.b(localQQAppInterface, this.val$activity, this.j);
      if (this.c != null) {
        this.c.au(2);
      }
      label113:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label113;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqw
 * JD-Core Version:    0.7.0.1
 */