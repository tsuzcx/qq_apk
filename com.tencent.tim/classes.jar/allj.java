import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

public class allj
  implements ILoadSo
{
  boolean cxB = false;
  
  public boolean isCkeygeneratorV2Load()
  {
    return this.cxB;
  }
  
  public boolean isCkguardLoad()
  {
    return this.cxB;
  }
  
  public boolean isDownProxyLoad()
  {
    return this.cxB;
  }
  
  public boolean isTPCoreLoad()
  {
    return this.cxB;
  }
  
  public boolean loadDownProxySync()
  {
    boolean bool = anmc.a().a("DownloadProxy").isSucc();
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "loadDownProxySync, bDownProxyResult  = " + bool);
    }
    return bool;
  }
  
  public void loadSo(LoadSoCallback paramLoadSoCallback)
  {
    anmc localanmc = anmc.a();
    paramLoadSoCallback = new allk(this, paramLoadSoCallback);
    localanmc.a(new String[] { "TPCore-master", "DownloadProxy", "ckguard", "ckeygeneratorV2" }, paramLoadSoCallback);
  }
  
  public boolean loadTPCoreSync()
  {
    boolean bool = anmc.a().a("TPCore-master").isSucc();
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "loadTPCoreSync, bTPCoreResult  = " + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     allj
 * JD-Core Version:    0.7.0.1
 */