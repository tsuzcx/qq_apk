import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.subtitles.RDBaseDataManager.1;
import com.tencent.mobileqq.activity.richmedia.subtitles.RDBaseDataManager.2;
import com.tencent.mobileqq.activity.richmedia.subtitles.RDBaseDataManager.3;
import com.tencent.mobileqq.activity.richmedia.subtitles.RDBaseDataManager.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public abstract class aaue
  implements aolm.b
{
  private boolean NO;
  private AtomicInteger aN = new AtomicInteger(0);
  protected BaseApplicationImpl c;
  protected int ckA;
  protected HashMap<Integer, String> hY;
  protected int mConfigVersion;
  private Handler mHandler;
  private int mState = 0;
  private String mUin;
  
  public aaue(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.ckA = paramInt;
    this.mState = 0;
    this.NO = paramBoolean2;
    this.c = BaseApplicationImpl.getApplication();
    if (paramBoolean1) {}
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = this.c.getRuntime();
        if (localAppRuntime != null) {
          this.mUin = String.valueOf(localAppRuntime.getLongAccountUin());
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("RDBaseDataManager", 2, "get uin exception:" + this.mUin);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RDBaseDataManager", 2, "init uin:" + this.mUin);
      }
      return;
      this.mUin = null;
    }
  }
  
  private void AU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = paramString.substring(0, paramString.lastIndexOf(File.separator));
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new File(paramString);
          if (!paramString.exists())
          {
            paramString.mkdirs();
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.d("RDBaseDataManagerdownloading", 2, "makedir execption: " + paramString);
      }
    }
  }
  
  private boolean HT()
  {
    try
    {
      this.mConfigVersion = aaug.b(this.c, this.ckA, this.mUin);
      if (QLog.isColorLevel()) {
        QLog.i("RDBaseDataManager", 2, "local sp config version is : " + this.mConfigVersion);
      }
      boolean bool = aaug.a(this.c, this.ckA, this.mUin, new aauf(this));
      if (!bool)
      {
        this.mState = 0;
        this.mConfigVersion = 0;
      }
      return bool;
    }
    finally {}
  }
  
  private boolean Xp()
  {
    try
    {
      if ((this.hY == null) || (this.hY.size() == 0)) {
        return false;
      }
      Iterator localIterator = this.hY.entrySet().iterator();
      int i = 0;
      boolean bool1 = true;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = aqhq.py((String)localEntry.getValue());
        i += 1;
        boolean bool2 = a(0, ((Integer)localEntry.getKey()).intValue(), str, i, this.hY.size());
        bool1 = bool2;
        if (!bool2) {
          bool1 = bool2;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("RDBaseDataManager", 2, "initFromAsset: " + bool1);
      }
      return bool1;
    }
    finally {}
  }
  
  private boolean a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    if (paramInt3 == 1) {
      gt(paramInt1, paramInt4);
    }
    boolean bool = c(paramInt1, paramInt2, paramString);
    if (paramInt3 == paramInt4) {
      gu(paramInt1, paramInt4);
    }
    return bool;
  }
  
  private void cyA()
  {
    try
    {
      if (this.mState != 0) {
        return;
      }
      this.mState = 1;
      onInit();
      loadConfig();
      this.mState = 2;
      if (QLog.isColorLevel())
      {
        QLog.d("RDBaseDataManager", 2, "RDBaseDataManager init end, configType :" + this.ckA);
        return;
      }
    }
    finally {}
  }
  
  private void loadConfig()
  {
    try
    {
      if (!HT()) {
        Xp();
      }
      return;
    }
    finally {}
  }
  
  protected void Df(boolean paramBoolean)
  {
    this.NO = paramBoolean;
  }
  
  public int b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (this.c == null)) {
      return -1;
    }
    AU(paramString2);
    aatu localaatu = new aatu();
    localaatu.mID = this.aN.addAndGet(1);
    localaatu.ben = paramString4;
    localaatu.mMd5 = paramString3;
    try
    {
      paramString3 = new aoll();
      paramString3.bZ = paramString1;
      paramString3.mHttpMethod = 0;
      paramString3.atY = paramString2;
      paramString3.bw(localaatu);
      paramString3.f = this;
      paramString3.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      ige.a().a(paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("RDBaseDataManager", 2, "startDownload, url: " + paramString1 + " ; path:" + paramString2);
      }
      return localaatu.mID;
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        localaatu.mID = -1;
        QLog.e("RDBaseDataManager", 2, "startDownload, url: " + paramString1 + " ; path:" + paramString2);
        QLog.i("RDBaseDataManager", 2, "exception: " + paramString3.toString());
      }
    }
  }
  
  public abstract boolean c(int paramInt1, int paramInt2, String paramString);
  
  public abstract void g(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public int getState()
  {
    return this.mState;
  }
  
  public abstract void gt(int paramInt1, int paramInt2);
  
  public abstract void gu(int paramInt1, int paramInt2);
  
  public abstract void gv(int paramInt1, int paramInt2);
  
  public void init(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RDBaseDataManager", 2, "init begin, state:" + this.mState + " configType :" + this.ckA + " baccountdependent:" + false);
    }
    if (this.mState != 0) {
      return;
    }
    if (paramBoolean)
    {
      if (this.mHandler == null) {
        this.mHandler = new Handler(ThreadManager.getSubThreadLooper());
      }
      this.mHandler.post(new RDBaseDataManager.1(this));
      return;
    }
    cyA();
  }
  
  public abstract void onInit();
  
  public void onResp(aomh paramaomh)
  {
    int j = 0;
    if ((paramaomh == null) || (paramaomh.b == null))
    {
      QLog.e("RDBaseDataManager", 2, "onResp  param error!");
      return;
    }
    aatu localaatu = (aatu)paramaomh.b.U();
    if (QLog.isColorLevel()) {
      QLog.i("RDBaseDataManager", 2, "onResp  ID:" + localaatu.mID + "  result:" + paramaomh.mResult);
    }
    if (paramaomh.mResult != 0)
    {
      ThreadManager.getUIHandler().post(new RDBaseDataManager.2(this, localaatu));
      return;
    }
    int i;
    if (!TextUtils.isEmpty(paramaomh.b.atY))
    {
      i = j;
      if (!TextUtils.isEmpty(localaatu.mMd5))
      {
        String str = aqhq.px(paramaomh.b.atY);
        if (localaatu.mMd5.equalsIgnoreCase(str)) {
          i = j;
        }
      }
      else
      {
        j = i;
        if (TextUtils.isEmpty(localaatu.ben)) {}
      }
    }
    for (;;)
    {
      try
      {
        aqhq.W(paramaomh.b.atY, localaatu.ben, false);
        j = i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("RDBaseDataManager", 2, "unzip file exception:" + localException);
        j = i;
        continue;
      }
      ThreadManager.getUIHandler().post(new RDBaseDataManager.3(this, localaatu, j, paramaomh));
      return;
      i = 1;
      break;
      j = 1;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (paramaomg == null) {
      return;
    }
    paramaomg = (aatu)paramaomg.U();
    ThreadManager.getUIHandler().post(new RDBaseDataManager.4(this, paramaomg, paramLong1, paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaue
 * JD-Core Version:    0.7.0.1
 */