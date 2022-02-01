import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.MiniAppInfoManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ajco
{
  Map<String, ajcn> lI = new ConcurrentHashMap();
  
  ajcn a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ajcn localajcn = (ajcn)this.lI.get(paramString);
    if ((localajcn != null) && (paramBoolean)) {
      if (!a(localajcn, paramInt1, paramInt2)) {}
    }
    while (!QLog.isColorLevel())
    {
      return localajcn;
      return null;
    }
    QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache invalid. cacheKey=", paramString });
    return localajcn;
  }
  
  void a(ajcn paramajcn, int paramInt, ajco.a parama)
  {
    ThreadManagerV2.excute(new MiniAppInfoManager.1(this, parama, paramajcn, paramInt), 128, null, true);
  }
  
  boolean a(ajcn paramajcn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyAppInfo. appState=", Integer.valueOf(paramajcn.appState) });
    }
    return (paramajcn != null) && (paramajcn.appState == 1);
  }
  
  boolean a(ajcn paramajcn, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "getAppInfoFromCache cache valid. cacheKey=", paramajcn.cacheKey });
    }
    if (paramInt2 == 1)
    {
      if (paramajcn.expirationTime <= NetConnInfoCenter.getServerTimeMillis()) {}
    }
    else {
      while ((paramInt2 == 0) && (((paramInt1 == 1) && (paramajcn.ace > NetConnInfoCenter.getServerTimeMillis())) || ((paramInt1 == 2) && (paramajcn.acf > NetConnInfoCenter.getServerTimeMillis())))) {
        return true;
      }
    }
    return false;
  }
  
  boolean b(ajcn paramajcn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInfoManager", 2, new Object[] { "verifyDownloadUrl. downloadUrl=", paramajcn.bQG });
    }
    return !TextUtils.isEmpty(paramajcn.bQG);
  }
  
  public static abstract class a<T>
  {
    public WeakReference<T> bs;
    
    public a(T paramT)
    {
      this.bs = new WeakReference(paramT);
    }
    
    public abstract void a(T paramT, boolean paramBoolean, ajcn paramajcn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajco
 * JD-Core Version:    0.7.0.1
 */