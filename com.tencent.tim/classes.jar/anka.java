import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class anka
{
  private String bYL;
  private FileOutputStream l;
  private String mCachePath;
  
  public anka(String paramString)
    throws RuntimeException
  {
    this.mCachePath = paramString;
    this.mCachePath = (this.mCachePath + File.separator + "audio_data_cache" + File.separator);
    paramString = new File(this.mCachePath);
    boolean bool1 = paramString.mkdirs();
    boolean bool2 = paramString.isDirectory();
    if ((!bool1) && (!bool2)) {
      throw new RuntimeException("AudioDataCache: mkd=" + bool1 + " isdir=" + bool2);
    }
  }
  
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
    l("initCache: oldpath=" + this.bYL + " mOutStream=" + this.l, null);
    a(paramRMVideoStateMgr);
    this.bYL = anlb.Ab();
    paramRMVideoStateMgr = this.mCachePath + this.bYL;
    File localFile = new File(paramRMVideoStateMgr);
    if (localFile.exists()) {
      throw new RuntimeException("AudioDataCache: file exists| " + paramRMVideoStateMgr);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anka
 * JD-Core Version:    0.7.0.1
 */