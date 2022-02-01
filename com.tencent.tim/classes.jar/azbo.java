import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class azbo
{
  private String bYL;
  private FileOutputStream l;
  private String mCachePath;
  
  private static void l(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("AudioDataCache", 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("AudioDataCache", 2, "[@] " + paramString);
  }
  
  public String a(RMVideoStateMgr paramRMVideoStateMgr)
  {
    l("closeCache: path=" + this.bYL, null);
    String str = this.mCachePath + this.bYL;
    if ((this.l == null) || (paramRMVideoStateMgr != null)) {}
    try
    {
      paramRMVideoStateMgr.Xg();
      this.l.close();
    }
    catch (IOException paramRMVideoStateMgr)
    {
      label74:
      break label74;
    }
    this.l = null;
    this.bYL = null;
    return str;
  }
  
  public void a(RMVideoStateMgr paramRMVideoStateMgr)
  {
    File localFile;
    try
    {
      l("initCache: oldpath=" + this.bYL + " mOutStream=" + this.l, null);
      a(paramRMVideoStateMgr);
      this.bYL = azcc.Ab();
      paramRMVideoStateMgr = this.mCachePath + this.bYL;
      localFile = new File(paramRMVideoStateMgr);
      if (localFile.exists()) {
        throw new RuntimeException("AudioDataCache: file exists| " + paramRMVideoStateMgr);
      }
    }
    finally {}
    try
    {
      this.l = new FileOutputStream(localFile);
      l("initCache: newPath=" + this.bYL, null);
      return;
    }
    catch (FileNotFoundException paramRMVideoStateMgr)
    {
      for (;;)
      {
        this.l = null;
      }
    }
  }
  
  public boolean e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (this.l != null) {}
    try
    {
      this.l.write(paramArrayOfByte, paramInt1, paramInt2);
      bool = true;
      return bool;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      l("writeData: exp=", paramArrayOfByte);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azbo
 * JD-Core Version:    0.7.0.1
 */