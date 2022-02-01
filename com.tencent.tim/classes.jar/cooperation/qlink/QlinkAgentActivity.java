package cooperation.qlink;

import agkf;
import android.content.Intent;
import android.os.Bundle;
import avhc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class QlinkAgentActivity
  extends BaseActivity
{
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (10 == paramInt2) {
      setResult(10, paramIntent);
    }
    if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4)) {
      this.app.a().c(new QlAndQQInterface.DailogClickInfo(8));
    }
    for (;;)
    {
      super.finish();
      return;
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.onCreate(paramBundle);
    setTitle(null);
    if (1 == getIntent().getIntExtra("what", 0))
    {
      long l = getIntent().getLongExtra("param.sessionid", 0L);
      if (0L != l)
      {
        if (this.app == null)
        {
          super.finish();
          return;
        }
        paramBundle = this.app.a();
        if (paramBundle == null)
        {
          super.finish();
          return;
        }
        Object localObject = paramBundle.b(l);
        if (localObject != null)
        {
          paramBundle = new ForwardFileInfo();
          paramBundle.Oj(((FileManagerEntity)localObject).getCloudType());
          paramBundle.setType(10010);
          paramBundle.p(((FileManagerEntity)localObject).nSessionId);
          paramBundle.jB(((FileManagerEntity)localObject).uniseq);
          paramBundle.setFileName(((FileManagerEntity)localObject).fileName);
          paramBundle.setFileSize(((FileManagerEntity)localObject).fileSize);
          paramBundle.setUuid(((FileManagerEntity)localObject).Uuid);
          paramBundle.setLocalPath(((FileManagerEntity)localObject).getFilePath());
          localObject = new Intent(getApplicationContext(), FileBrowserActivity.class);
          ((Intent)localObject).putExtra("fileinfo", paramBundle);
          ((Intent)localObject).putExtra("from_qlink_enter_recent", true);
          startActivityForResult((Intent)localObject, 102);
          return;
        }
      }
    }
    super.finish();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qlink.QlinkAgentActivity
 * JD-Core Version:    0.7.0.1
 */