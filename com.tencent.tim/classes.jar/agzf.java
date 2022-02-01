import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class agzf
  extends agzk
{
  private MessageForFile e = (MessageForFile)this.v;
  private FileManagerEntity f = ahav.a(paramQQAppInterface, this.e);
  
  public agzf(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
    if (this.f == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "init: not find the target entity.");
      return;
    }
    QLog.e("OfflineFileSaveModel<QFile>", 1, "init: uniseq[" + paramChatMessage.uniseq + "] session[" + this.f.nSessionId + "]");
  }
  
  public agzi a()
  {
    agze localagze = new agze(this.f);
    localagze.a(new agzg(this));
    return localagze;
  }
  
  public boolean amG()
  {
    if (this.f == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "stopDownload: file entity is null.");
      return false;
    }
    this.mApp.a().bZ(this.f.nSessionId);
    return true;
  }
  
  public boolean amH()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.f != null)
    {
      bool1 = bool2;
      if (this.f.getStatus() == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean cu()
  {
    if (this.f == null)
    {
      QLog.e("OfflineFileSaveModel<QFile>", 1, "download: file entity is null.");
      return false;
    }
    int i = this.f.getCloudType();
    int j = this.f.status;
    String str = this.f.getFilePath();
    QLog.e("OfflineFileSaveModel<QFile>", 1, "download: uniseq[" + this.e.uniseq + "] session[" + this.f.nSessionId + "] cloudType[" + i + "] status[" + j + "]");
    if ((!aqhq.fileExistsAndNotEmpty(str)) && (i != 0))
    {
      if (j == 3)
      {
        this.mApp.a().jk(this.f.nSessionId);
        return true;
      }
      this.mApp.a().l(this.f);
      return true;
    }
    QLog.e("OfflineFileSaveModel<QFile>", 1, "download: error, file status is not right.");
    return false;
  }
  
  public long getFileSize()
  {
    if (this.f != null) {
      return this.f.fileSize;
    }
    return 0L;
  }
  
  public String getLocalFilePath()
  {
    if (this.f != null) {
      return this.f.getFilePath();
    }
    return "";
  }
  
  public String vV()
  {
    return this.e.frienduin + this.e.uniseq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agzf
 * JD-Core Version:    0.7.0.1
 */