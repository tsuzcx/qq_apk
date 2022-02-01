import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class agta
  implements agsw
{
  private final String TAG = "VideoForC2C<QFile>";
  protected FileManagerEntity c;
  protected QQAppInterface mApp;
  
  public agta(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.mApp = paramQQAppInterface;
    this.c = paramFileManagerEntity;
  }
  
  public void JB(boolean paramBoolean)
  {
    this.c.status = 0;
    if (paramBoolean)
    {
      this.c.status = 16;
      this.mApp.a().u(this.c);
    }
    this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 12, null, 2, null);
    agkw.a(this);
  }
  
  public void Jk(String paramString)
  {
    this.c.status = 1;
    this.c.setFilePath(paramString);
    File localFile = new File(this.c.getFilePath());
    this.c.localModifyTime = localFile.lastModified();
    this.c.nOLfileSessionId = 0L;
    this.c.fProgress = 1.0F;
    this.c.setCloudType(3);
    ahav.K(this.c);
    this.mApp.a().u(this.c);
    this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 11, new Object[] { paramString, Long.valueOf(this.c.fileSize), Boolean.valueOf(true), this.c.strServerPath }, 0, null);
    agkw.a(this);
  }
  
  public void a(agkw.a parama)
  {
    if (TextUtils.isEmpty(this.c.Uuid))
    {
      JB(true);
      parama.onError(-6101, BaseApplication.getContext().getResources().getString(2131694161));
      QLog.e("VideoForC2C<QFile>", 2, "[" + this.c.nSessionId + "],[getOnlinePlay]  uuid is null");
      return;
    }
    this.c.nOpType = 1;
    this.mApp.a().a(this.c.Uuid, this.c.fileIdCrc, this.c.bSend, false, new agtb(this, parama));
  }
  
  public String getFileName()
  {
    return this.c.fileName;
  }
  
  public long getFileSize()
  {
    return this.c.fileSize;
  }
  
  public void jL(long paramLong)
  {
    this.c.status = 2;
    this.c.fProgress = ((float)paramLong / (float)this.c.fileSize);
    this.mApp.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 16, null, 0, null);
  }
  
  public String vL()
  {
    return ahaf.a().wa() + atad.toMD5(this.c.Uuid);
  }
  
  public String ve()
  {
    return this.c.nSessionId + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agta
 * JD-Core Version:    0.7.0.1
 */