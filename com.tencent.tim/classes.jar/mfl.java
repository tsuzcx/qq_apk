import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public abstract class mfl
  implements Manager
{
  protected ConcurrentHashMap<String, String> br = new ConcurrentHashMap();
  protected aqvc c;
  protected HashMap<String, String> ed = new HashMap();
  protected ArrayList<aquy> kR = new ArrayList();
  protected AppInterface mApp;
  protected EntityManager mEntityManager;
  
  public mfl(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    this.c = ((aqva)paramAppInterface.getManager(47)).a(1);
    this.mEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
  }
  
  public String U(String paramString1, String paramString2)
  {
    String str = aZ(paramString1);
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = str + paramString2 + "/";
    }
    return paramString1;
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData) {}
  
  public void a(aquy paramaquy)
  {
    this.kR.add(paramaquy);
  }
  
  public void a(String paramString, aquz paramaquz) {}
  
  public void a(String paramString, BaseResData paramBaseResData) {}
  
  public abstract boolean a(String paramString, BaseResData paramBaseResData);
  
  public boolean a(String paramString, BaseResData paramBaseResData, int paramInt)
  {
    boolean bool = false;
    Object localObject = paramBaseResData.id;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide: id = " + (String)localObject);
    }
    String str = U(paramString, (String)localObject);
    if (anyk.E(new File(str)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("readinjoy", 4, "isAnimationPackageValid");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (this.ed.get(paramString + "_" + (String)localObject) == null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("readinjoy", 4, "mDownloadingRes _");
      return false;
      if (!(paramBaseResData instanceof MaterialData)) {
        aqhq.cn(str);
      }
      this.ed.put(paramString + "_" + (String)localObject, paramBaseResData.url);
      str = str + ".zip";
      File localFile = new File(str);
      Bundle localBundle = new Bundle();
      localBundle.putString("resId", (String)localObject);
      localBundle.putString("prefix", paramString);
      localObject = new aquz(paramBaseResData.url, localFile);
      ((aquz)localObject).retryCount = paramInt;
      ((aquz)localObject).atW = 60L;
      this.c.a((aquz)localObject, new mfm(this, str, paramBaseResData, paramString), localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("readinjoy", 4, "startDownload");
    return false;
  }
  
  public void aOX()
  {
    this.kR.clear();
  }
  
  public String aZ(String paramString)
  {
    String str2 = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".readInjoy/resource/");
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString)) {
      str1 = str2 + paramString + "/";
    }
    return str1;
  }
  
  public void b(aquy paramaquy)
  {
    this.kR.remove(paramaquy);
  }
  
  public abstract void b(String paramString, BaseResData paramBaseResData);
  
  public abstract boolean b(String paramString, BaseResData paramBaseResData);
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    return a(paramString, paramBaseResData, 0);
  }
  
  public void onDestroy()
  {
    this.mEntityManager.close();
    this.mApp = null;
    aOX();
  }
  
  public void q(String[] paramArrayOfString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfl
 * JD-Core Version:    0.7.0.1
 */