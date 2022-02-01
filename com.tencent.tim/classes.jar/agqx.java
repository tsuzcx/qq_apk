import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class agqx
  implements View.OnClickListener
{
  agqx(FileManagerEntity paramFileManagerEntity, agsa paramagsa) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        int i = ahav.b(this.b);
        if ((i != 1) && (i != 2) && (i != 4)) {
          continue;
        }
        new aviz(3).a(localQQAppInterface, BaseActivity.sTopActivity, this.b, null, false);
        if ((this.c != null) && (this.c.bY()))
        {
          this.c.au(3);
          ahav.l(localQQAppInterface, this.b.nSessionId);
        }
      }
      catch (Exception localException)
      {
        QQAppInterface localQQAppInterface;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.b.nFileType == 0) && (ahbj.fileExistsAndNotEmpty(this.b.getFilePath())))
      {
        aviz.b(this.b.getFilePath()).a(localQQAppInterface).b(BaseActivity.sTopActivity, localQQAppInterface.getAccount());
        avjg.a(localQQAppInterface, 7, 3);
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("FileOperaterUtils", 2, "FileVideoMediaPlayHelperthis is a local file, but favorite fail. [Uuid] = " + this.b.Uuid + " [status] = " + this.b.status + " [fileType] = " + this.b.nFileType);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqx
 * JD-Core Version:    0.7.0.1
 */