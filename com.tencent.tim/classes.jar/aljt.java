import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aljt
{
  public boolean bPM;
  public String bWM = "";
  public String bWN = "";
  public String bWO = "";
  public String bWP = "";
  public String bWQ = "";
  public String bWR;
  public String bWS;
  public boolean cxt;
  public int duI;
  public int duJ;
  public int duK;
  public int mContentType = -1;
  public String mDownloadUrl = "";
  public int mJumpType = -1;
  public String mResPath;
  public String mUin;
  public String mVideoPath;
  
  public aljt(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString8, int paramInt4, String paramString9, String paramString10, int paramInt5)
  {
    this.mUin = paramString1;
    this.bWM = paramString2;
    this.bWN = paramString3;
    this.bWO = paramString4;
    this.mContentType = paramInt1;
    this.mDownloadUrl = paramString5;
    this.mJumpType = paramInt2;
    this.bWP = paramString6;
    this.duI = paramInt3;
    this.bWQ = paramString7;
    this.cxt = paramBoolean1;
    this.bPM = paramBoolean3;
    this.mResPath = paramString8;
    this.duJ = paramInt4;
    this.bWR = paramString9;
    this.bWS = paramString10;
    this.duK = paramInt5;
  }
  
  public static boolean H(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    try
    {
      paramString = new File(paramString);
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.exists())
        {
          if (paramBoolean)
          {
            paramBoolean = paramString.getAbsolutePath().endsWith(".splashtemp");
            if (!paramBoolean) {}
          }
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public boolean atH()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.bPM)
    {
      bool1 = bool2;
      if (H(this.mResPath, true)) {
        bool1 = true;
      }
    }
    QLog.i("QSplash@QbossSplashUtil", 1, "adid [" + this.bWM + "] shouldSplash " + bool1);
    return bool1;
  }
  
  public boolean atI()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!H(this.mResPath, true))
    {
      bool1 = bool2;
      if (!this.cxt)
      {
        bool1 = bool2;
        if (!aljs.ob(this.bWO)) {
          bool1 = true;
        }
      }
    }
    QLog.i("QSplash@QbossSplashUtil", 1, "adid [" + this.bWM + "] shouldRequestRes result = " + bool1);
    return bool1;
  }
  
  public String toString()
  {
    return "SplashADEntry{, mAdID='" + this.bWM + '\'' + ", mBeginTime='" + this.bWN + '\'' + ", mEndTime='" + this.bWO + '\'' + ", mContentType=" + this.mContentType + ", mDownloadUrl='" + this.mDownloadUrl + '\'' + ", mJumpType=" + this.mJumpType + ", mJumpH5Url='" + this.bWP + '\'' + ", mExposureUrl='" + this.bWQ + '\'' + ", mResPath='" + this.mResPath + '\'' + ", mVideoPath='" + this.mVideoPath + '\'' + ", mShowpriority" + this.duJ + '\'' + ", isLowerDeviceLimit=" + this.cxt + '\'' + ", mCanShow=" + this.bPM + '\'' + ", mResTraceinfo=" + this.bWR + '\'' + ", mResMD5=" + this.bWS + '\'' + ", mShowAdMark=" + this.duK + '}';
  }
  
  public static class a
  {
    private boolean bPM;
    private String bWM = "";
    private String bWN = "";
    private String bWO = "";
    private String bWP = "";
    private String bWQ = "";
    private String bWR = "";
    private String bWS = "";
    private boolean bXG;
    private boolean cxt;
    private int duI;
    private int duJ;
    private int duK;
    private int mContentType = -1;
    private String mDownloadUrl = "";
    private int mJumpType = -1;
    private String mResPath;
    private String mUin;
    
    public a a(int paramInt)
    {
      this.duK = paramInt;
      return this;
    }
    
    public a a(String paramString)
    {
      this.bWM = paramString;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.bPM = paramBoolean;
      return this;
    }
    
    public aljt a()
    {
      for (;;)
      {
        try
        {
          switch (this.mContentType)
          {
          case 0: 
            if (this.cxt) {
              this.bPM = false;
            }
            return new aljt(this.mUin, this.bWM, this.bWN, this.bWO, this.mContentType, this.mDownloadUrl, this.mJumpType, this.bWP, this.duI, this.bWQ, this.cxt, this.bXG, this.bPM, this.mResPath, this.duJ, this.bWR, this.bWS, this.duK);
          }
        }
        catch (Exception localException)
        {
          QLog.e("QSplash@SplashItem", 1, localException, new Object[0]);
          return null;
        }
        this.mResPath = (aqul.getSDKPrivatePath(aljs.DOWNLOAD_PATH) + "pic/" + this.mDownloadUrl.hashCode());
        continue;
        this.mResPath = (aqul.getSDKPrivatePath(aljs.DOWNLOAD_PATH) + "gif/" + this.mDownloadUrl.hashCode());
        this.mResPath = (aqul.getSDKPrivatePath(aljs.DOWNLOAD_PATH) + "video/" + this.mDownloadUrl.hashCode());
      }
    }
    
    public a b(int paramInt)
    {
      this.duJ = paramInt;
      return this;
    }
    
    public a b(String paramString)
    {
      this.bWN = paramString;
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.cxt = paramBoolean;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.mContentType = paramInt;
      return this;
    }
    
    public a c(String paramString)
    {
      this.bWO = paramString;
      return this;
    }
    
    public a d(int paramInt)
    {
      this.mJumpType = paramInt;
      return this;
    }
    
    public a d(String paramString)
    {
      this.mDownloadUrl = paramString;
      return this;
    }
    
    public a e(int paramInt)
    {
      this.duI = paramInt;
      return this;
    }
    
    public a e(String paramString)
    {
      this.bWP = paramString;
      return this;
    }
    
    public a f(String paramString)
    {
      this.bWQ = paramString;
      return this;
    }
    
    public a g(String paramString)
    {
      this.mUin = paramString;
      return this;
    }
    
    public a h(String paramString)
    {
      this.bWR = paramString;
      return this;
    }
    
    public a i(String paramString)
    {
      this.bWS = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aljt
 * JD-Core Version:    0.7.0.1
 */