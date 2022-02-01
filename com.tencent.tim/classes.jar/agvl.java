import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;

public class agvl
  extends agvk
{
  private int bPd;
  private Bundle ba;
  private FileManagerEntity f;
  private QQAppInterface mApp;
  private Context mContext;
  
  public agvl(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    super(paramQQAppInterface, paramContext);
    this.mContext = paramContext;
    ahav.I(paramFileManagerEntity);
    this.f = paramFileManagerEntity;
    this.mApp = paramQQAppInterface;
    this.bPd = paramInt;
  }
  
  private ForwardFileInfo a()
  {
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.p(this.f.nSessionId);
    localForwardFileInfo.setFileName(this.f.fileName);
    localForwardFileInfo.setFileSize(this.f.fileSize);
    localForwardFileInfo.setLocalPath(this.f.getFilePath());
    localForwardFileInfo.setType(this.bPd);
    switch (this.bPd)
    {
    case 10002: 
    case 10003: 
    default: 
      return localForwardFileInfo;
    case 10000: 
      localForwardFileInfo.Oj(3);
      localForwardFileInfo.setType(10000);
      return localForwardFileInfo;
    case 10004: 
      if (this.f.bSend) {}
      for (String str = this.mApp.getAccount();; str = this.f.peerUin)
      {
        localForwardFileInfo.Oj(this.f.getCloudType());
        if (str != null) {
          localForwardFileInfo.jA(Long.valueOf(str.replace("+", "")).longValue());
        }
        localForwardFileInfo.jB(this.f.uniseq);
        localForwardFileInfo.setUuid(this.f.Uuid);
        return localForwardFileInfo;
      }
    }
    localForwardFileInfo.Oj(this.f.getCloudType());
    localForwardFileInfo.jB(this.f.uniseq);
    localForwardFileInfo.setUuid(this.f.Uuid);
    return localForwardFileInfo;
  }
  
  private Intent w()
  {
    Intent localIntent = new Intent();
    if (this.ba != null) {
      localIntent.putExtras(this.ba);
    }
    return localIntent;
  }
  
  boolean amw()
  {
    if ((this.f.status == 0) || (this.f.status == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideo", 1, "id:" + this.f.nSessionId + " status:" + this.f.status + " resume");
      }
      this.mApp.a().jk(this.f.nSessionId);
      return true;
    }
    return false;
  }
  
  boolean amx()
  {
    int i = ahav.getFileType(getFileName());
    if (i != 2) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideo", 1, "id:" + this.f.nSessionId + " type is:" + i + " use old filebrowser:");
      }
    }
    boolean bool;
    do
    {
      return false;
      bool = ahav.mI(getFilePath());
      if (QLog.isColorLevel()) {
        QLog.i("FileVideo", 1, "id:" + this.f.nSessionId + " status:" + this.f.status + " isLocal:" + bool);
      }
    } while ((bool) && (this.f.status != 1) && (this.f.isSend()));
    return true;
  }
  
  protected int bF()
  {
    if (this.f != null) {
      return this.f.status;
    }
    return 0;
  }
  
  public void cB(Bundle paramBundle)
  {
    this.ba = paramBundle;
  }
  
  public void cC(Bundle paramBundle)
  {
    if ((this.ba != null) && (paramBundle != null) && (this.ba.containsKey("file_color_note_subType"))) {
      paramBundle.putInt("file_color_note_subType", this.ba.getInt("file_color_note_subType", -1));
    }
  }
  
  protected String getFileName()
  {
    if (this.f != null) {
      return this.f.fileName;
    }
    return "";
  }
  
  protected String getFilePath()
  {
    if (this.f != null) {
      return this.f.getFilePath();
    }
    return "";
  }
  
  protected long getFileSize()
  {
    if (this.f != null) {
      return this.f.fileSize;
    }
    return 0L;
  }
  
  public Intent x()
  {
    ForwardFileInfo localForwardFileInfo = a();
    Intent localIntent = w();
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    localIntent.putExtra("selfSet_leftViewText", acfp.m(2131704217));
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvl
 * JD-Core Version:    0.7.0.1
 */