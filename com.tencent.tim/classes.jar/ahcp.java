import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class ahcp
{
  public static String TAG = "UniformDownloaderAssinfo<FileAssistant>";
  protected final long Zd;
  protected String bJZ;
  protected String bJr;
  protected int cZm;
  protected Object dS = new Object();
  protected Object dT = new Object();
  protected Object dU = new Object();
  protected String mCookie;
  protected String mFileName;
  protected int mProgress;
  protected int mStatus = 0;
  protected String mUrl;
  protected long nFileSize;
  
  public ahcp(long paramLong)
  {
    this.Zd = paramLong;
  }
  
  protected int EQ()
  {
    synchronized (this.dS)
    {
      int i = this.cZm;
      return i;
    }
  }
  
  protected void OV(int paramInt)
  {
    synchronized (this.dS)
    {
      this.cZm = paramInt;
      return;
    }
  }
  
  public int e(String paramString, Bundle paramBundle)
  {
    if (isInited()) {
      return 0;
    }
    if ((paramString == null) || (paramBundle == null)) {
      try
      {
        QLog.e(TAG, 1, "[UniformDL][" + this.Zd + "]. init param error");
        return -1;
      }
      finally {}
    }
    this.mUrl = paramString;
    this.bJr = paramBundle.getString("_PARAM_FILEPATH");
    this.bJZ = paramBundle.getString("_PARAM_TMP_FILEPATH");
    this.mFileName = paramBundle.getString("_PARAM_FILENAME");
    this.nFileSize = paramBundle.getLong("_PARAM_FILESIZE");
    this.mCookie = paramBundle.getString("_PARAM_COOKIE");
    QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] init. ST:" + getStatus() + " PGR:" + getProgress());
    setStatus(1);
    return 0;
  }
  
  public int getProgress()
  {
    synchronized (this.dT)
    {
      int i = this.mProgress;
      return i;
    }
  }
  
  public int getStatus()
  {
    synchronized (this.dU)
    {
      int i = this.mStatus;
      return i;
    }
  }
  
  protected boolean isInited()
  {
    return getStatus() >= 1;
  }
  
  protected void setProgress(int paramInt)
  {
    synchronized (this.dT)
    {
      this.mProgress = paramInt;
      return;
    }
  }
  
  protected void setStatus(int paramInt)
  {
    synchronized (this.dU)
    {
      QLog.i(TAG, 1, "[UniformDL][" + this.Zd + "] setStatus. " + this.mStatus + "->" + paramInt);
      this.mStatus = paramInt;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcp
 * JD-Core Version:    0.7.0.1
 */