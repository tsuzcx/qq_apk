import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class agpk
{
  private List<ExcitingTransferHostInfo> By;
  private long fileSize;
  private boolean isSupportHttps;
  private byte[] md5;
  private String serverPath;
  private String sslCName;
  private String strCookie;
  private String strFileName;
  
  public void Jd(String paramString)
  {
    this.strFileName = paramString;
  }
  
  public void Je(String paramString)
  {
    this.serverPath = paramString;
  }
  
  public void Jf(String paramString)
  {
    this.strCookie = paramString;
  }
  
  public void Jg(String paramString)
  {
    this.sslCName = paramString;
  }
  
  public void Jv(boolean paramBoolean)
  {
    this.isSupportHttps = paramBoolean;
  }
  
  public byte[] aa()
  {
    return this.md5;
  }
  
  public boolean alY()
  {
    return this.isSupportHttps;
  }
  
  public List<ExcitingTransferHostInfo> eY()
  {
    return this.By;
  }
  
  public long getFileSize()
  {
    return this.fileSize;
  }
  
  public boolean isVaild()
  {
    if (TextUtils.isEmpty(this.strFileName))
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "mFilePath is null");
      return false;
    }
    if (0L == this.fileSize)
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "mFileSize is 0");
      return false;
    }
    if ((this.By == null) || (this.By.size() == 0))
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "hostList is null");
      return false;
    }
    if (TextUtils.isEmpty(this.serverPath))
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "serverPath is null");
      return false;
    }
    if (TextUtils.isEmpty(this.strCookie))
    {
      QLog.e("ExcitingTransfer.ExtfDownloadFileInfo<FileAssistant>", 1, "strCookie is null");
      return false;
    }
    return true;
  }
  
  public void kJ(List<ExcitingTransferHostInfo> paramList)
  {
    this.By = paramList;
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public String vv()
  {
    return this.strFileName;
  }
  
  public String vw()
  {
    return this.serverPath;
  }
  
  public String vx()
  {
    return this.strCookie;
  }
  
  public String vy()
  {
    return this.sslCName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agpk
 * JD-Core Version:    0.7.0.1
 */