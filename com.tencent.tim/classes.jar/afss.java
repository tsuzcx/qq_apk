import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class afss
{
  private afss.a jdField_a_of_type_Afss$a;
  private aopo jdField_a_of_type_Aopo;
  private HashMap<String, afsi.b> kx = new HashMap();
  private Lock lock = new ReentrantLock();
  private QQAppInterface mApp;
  private String mMD5;
  private String mURL;
  
  public afss(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    if (this.mApp != null) {
      this.jdField_a_of_type_Aopo = ((aopo)this.mApp.getManager(193));
    }
  }
  
  private void Gu(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private boolean a(afsi.b paramb)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramb != null)
    {
      bool1 = bool3;
      if (paramb.akg()) {
        this.lock.lock();
      }
    }
    try
    {
      bool3 = this.kx.containsKey(paramb.name);
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  private boolean aU(String paramString1, String paramString2)
  {
    try
    {
      aden.fn(paramString1, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("ExtendFriendResourceDownloader", 1, "unzipResource fail.", paramString1);
    }
    return false;
  }
  
  private boolean aki()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(this.mMD5)) {
      bool = x(kH(this.mMD5), this.mMD5);
    }
    return bool;
  }
  
  private boolean akj()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.mMD5))
    {
      bool1 = bool2;
      if (afxw.akD()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(afsi.b paramb)
  {
    c(paramb);
    ThreadManager.getSubThreadHandler().post(new ExtendFriendResourceDownloader.4(this, paramb));
  }
  
  private boolean b(afsi.b paramb)
  {
    return (paramb != null) && (paramb.akg()) && (afwv.co.contains(paramb.name));
  }
  
  private void c(afsi.b paramb)
  {
    if ((paramb != null) && (paramb.akg())) {
      this.lock.lock();
    }
    try
    {
      this.kx.put(paramb.name, paramb);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  private void d(afsi.b paramb)
  {
    if ((paramb != null) && (paramb.akg())) {
      this.lock.lock();
    }
    try
    {
      this.kx.remove(paramb.name);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  private String kH(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { uJ(), paramString });
  }
  
  public static String uI()
  {
    return String.format("%s/res", new Object[] { uJ() });
  }
  
  private static String uJ()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject2 != null)
    {
      localObject2 = ((File)localObject2).getAbsolutePath() + "/pddata/prd/ef_res";
      File localFile = new File((String)localObject2);
      localObject1 = localObject2;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  private boolean x(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (new File(paramString1).exists())
    {
      paramString1 = alab.getFileMD5String(paramString1);
      bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (paramString2.equalsIgnoreCase(paramString1)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void a(afsi.b paramb)
  {
    if (paramb == null)
    {
      QLog.e("ExtendFriendResourceDownloader", 2, "Limitchatres resInfo is null");
      return;
    }
    if (!paramb.akg())
    {
      QLog.e("ExtendFriendResourceDownloader", 2, "Limitchatres resInfo is not effect");
      return;
    }
    if (!a(paramb))
    {
      b(paramb);
      return;
    }
    QLog.i("ExtendFriendResourceDownloader", 2, "Limitchatres is downloading" + paramb.name);
  }
  
  public void a(afss.a parama)
  {
    this.jdField_a_of_type_Afss$a = parama;
  }
  
  public boolean akh()
  {
    boolean bool1 = aki();
    boolean bool2 = akj();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (bool2);
  }
  
  public void dbY()
  {
    if ((this.jdField_a_of_type_Aopo != null) && (!TextUtils.isEmpty(this.mURL))) {
      this.jdField_a_of_type_Aopo.a(this.mURL);
    }
  }
  
  public void downloadResource()
  {
    int i = 1;
    if ((TextUtils.isEmpty(this.mURL)) || (TextUtils.isEmpty(this.mMD5))) {
      QLog.e("ExtendFriendResourceDownloader", 1, "downloadResource invalid parameters.");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { this.mURL, this.mMD5 }));
    }
    Object localObject1 = kH(this.mMD5);
    if (!x((String)localObject1, this.mMD5))
    {
      Gu((String)localObject1);
      if (this.jdField_a_of_type_Aopo != null)
      {
        localObject2 = new aoll();
        ((aoll)localObject2).f = new afst(this);
        ((aoll)localObject2).bZ = this.mURL;
        ((aoll)localObject2).mHttpMethod = 0;
        ((aoll)localObject2).atY = ((String)localObject1);
        ((aoll)localObject2).dPo = 0;
        ((aoll)localObject2).a = new afsu(this);
        localObject2 = new aopn(this.mApp, this.mMD5, new afsv(this), (aoll)localObject2);
        this.jdField_a_of_type_Aopo.a(10073, "prd", this.mMD5, 0, this.mURL, (String)localObject1, 2, 0, false, (aopm)localObject2);
      }
    }
    while (akj())
    {
      Object localObject2;
      return;
    }
    boolean bool3 = aU((String)localObject1, uI());
    boolean bool2 = akj();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("downloadResource unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2) }));
    }
    boolean bool1;
    if (this.jdField_a_of_type_Afss$a != null)
    {
      localObject1 = this.jdField_a_of_type_Afss$a;
      if ((bool3) && (bool2))
      {
        bool1 = true;
        ((afss.a)localObject1).Im(bool1);
      }
    }
    else
    {
      localObject1 = afxv.a();
      if ((!bool3) || (!bool2)) {
        break label349;
      }
      bool1 = true;
      label332:
      if (bool2) {
        break label354;
      }
    }
    for (;;)
    {
      ((afxv)localObject1).bj(bool1, i);
      return;
      bool1 = false;
      break;
      label349:
      bool1 = false;
      break label332;
      label354:
      i = 0;
    }
  }
  
  public void fy(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("setDownloadInfo url=%s md5=%s", new Object[] { paramString1, paramString2 }));
    }
    this.mURL = paramString1;
    this.mMD5 = paramString2;
  }
  
  public static abstract interface a
  {
    public abstract void Im(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afss
 * JD-Core Version:    0.7.0.1
 */