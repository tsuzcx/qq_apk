import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.viewplugin.ViewPluginLoader.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

public class ssf
{
  public static final HashMap<String, ssf> fV = new HashMap();
  public sse a;
  public String aGf;
  private String aGg;
  public String aGh;
  public volatile boolean aMP;
  public String aoF = null;
  jpn b = new jpn();
  int byV = 0;
  boolean isLoading = false;
  public SharedPreferences k;
  public Object lock = new Object();
  public String mBid;
  public ClassLoader mClassLoader;
  public String mPluginName;
  
  public ssf(String paramString1, String paramString2)
  {
    this.mBid = paramString1;
    this.mPluginName = paramString2;
    this.aoF = (BaseApplicationImpl.getContext().getFilesDir() + "/pluginopt/" + paramString2 + "/opt");
    this.k = BaseApplicationImpl.getContext().getSharedPreferences("viewplugin_sp", 0);
    fV.put(paramString2, this);
    this.aGg = (Environment.getExternalStorageDirectory().getPath() + "/tencent/plugins/");
  }
  
  public aqvc a()
  {
    return ((aqva)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(47)).a(1);
  }
  
  public void a(JSONObject paramJSONObject, QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = true;
    int i = paramJSONObject.optInt("code");
    paramQQAppInterface = jpe.dP(this.mBid);
    boolean bool2;
    if (!TextUtils.isEmpty(paramQQAppInterface)) {
      if (i == 4)
      {
        paramQQAppInterface = paramQQAppInterface + this.mBid + ".7z";
        bool2 = false;
      }
    }
    for (;;)
    {
      ThreadManager.post(new ViewPluginLoader.5(this, paramJSONObject, paramQQAppInterface, new ssi(this, paramQQAppInterface, bool2, bool1)), 8, null, false);
      return;
      if ((i == 3) || (i == 2))
      {
        paramQQAppInterface = paramQQAppInterface + this.mBid + ".zip";
        bool2 = true;
        bool1 = false;
      }
      else
      {
        QLog.e("ViewPluginLoader", 1, "do not know what format, use default zip name!");
        paramQQAppInterface = paramQQAppInterface + this.mBid + ".zip";
        bool2 = false;
        bool1 = false;
        continue;
        bool1 = false;
        bool2 = false;
        paramQQAppInterface = null;
      }
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    for (;;)
    {
      String str2;
      File localFile;
      String str1;
      Object localObject;
      try
      {
        str2 = this.mBid;
        boolean bool = TextUtils.isEmpty(str2);
        if (bool)
        {
          paramBoolean2 = false;
          return paramBoolean2;
        }
        if (TextUtils.isEmpty(jpe.dP(str2)))
        {
          paramBoolean2 = false;
          continue;
        }
        localFile = new File(paramString);
        if (!localFile.exists())
        {
          if (!QLog.isColorLevel()) {
            break label589;
          }
          QLog.i("ViewPluginLoader", 2, "doUnzipZip: no zip ! : businessId:" + str2);
          break label589;
        }
        long l = System.currentTimeMillis();
        str1 = localFile.getParent() + File.separator + str2;
        localObject = BidDownloader.dK(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ViewPluginLoader", 2, "fileFormat: " + (String)localObject + ", path: " + paramString);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label372;
        }
        if (((String)localObject).equals("zip"))
        {
          i = jqp.unZipFolder(paramString, str1);
          if (QLog.isColorLevel()) {
            QLog.i("ViewPluginLoader", 2, "now delete original download offline zip, path: " + paramString);
          }
          jqo.deleteFile(paramString);
          if (i <= 0) {
            break label434;
          }
          jpa.a(str2, 13, 0L, i, "lixian_update", "0");
          if (!QLog.isColorLevel()) {
            break label584;
          }
          QLog.i("ViewPluginLoader", 2, "unZipFolder fail!");
          paramBoolean1 = false;
          jqo.dn(str1);
          paramBoolean2 = paramBoolean1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("ViewPluginLoader", 2, "time of unzip zip：" + (System.currentTimeMillis() - l) + ", isSuccess: " + paramBoolean1);
          paramBoolean2 = paramBoolean1;
          continue;
        }
        if (!((String)localObject).equals("7z")) {
          continue;
        }
      }
      finally {}
      i = LzmaUtils.m(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, str1);
      continue;
      label372:
      QLog.w("ViewPluginLoader", 1, "can not recognize download compress file format, " + paramString);
      if (paramBoolean1)
      {
        i = jqp.unZipFolder(paramString, str1);
      }
      else if (paramBoolean2)
      {
        i = LzmaUtils.m(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, str1);
        continue;
        label434:
        paramString = str1 + File.separator + str2 + ".zip";
        localObject = new File(paramString);
        str2 = localFile.getParent() + File.separator + str2 + ".zip";
        if (QLog.isColorLevel()) {
          QLog.i("ViewPluginLoader", 2, "now move zip file to location: " + str2);
        }
        if (((File)localObject).exists())
        {
          paramBoolean2 = ((File)localObject).renameTo(new File(str2));
          paramBoolean1 = paramBoolean2;
          if (!paramBoolean2) {
            paramBoolean1 = aqhq.moveFile(paramString, str2);
          }
        }
        else
        {
          label584:
          paramBoolean1 = false;
          continue;
          label589:
          paramBoolean2 = false;
        }
      }
    }
  }
  
  public void bAB()
  {
    ardq localardq = (ardq)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(107);
    try
    {
      if (this.isLoading)
      {
        localardq.notifyUI(3, true, Integer.valueOf(4));
        return;
      }
      this.isLoading = true;
      String str = "https://" + this.mPluginName + "?_bid=" + this.mBid;
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      long l = System.currentTimeMillis();
      if ((!jpa.a(BaseApplicationImpl.getContext(), str, new ssg(this, l, localardq, localBaseApplication))) && (QLog.isColorLevel()))
      {
        QLog.i("ViewPluginLoader", 2, "plugin:" + this.mPluginName + " transToLocalUrl: return false");
        return;
      }
    }
    finally {}
  }
  
  public void bAC()
  {
    this.byV = 0;
    jpa.init();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (localQQAppInterface.getLongAccountUin() % 10L == 6L)) {}
    for (boolean bool = true;; bool = false)
    {
      jpa.aba = bool;
      String str = jpa.dL(this.mBid);
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginLoader", 2, "checkOfflineAndLoad version = " + str);
      }
      if ((!new File(jpe.dO(this.mBid) + this.mBid + "/" + this.mPluginName).exists()) && (!TextUtils.isEmpty(str)) && (!"0".equals(str))) {
        aqhq.cn(jpe.dO(this.mBid) + this.mBid);
      }
      if (localQQAppInterface != null) {
        break;
      }
      return;
    }
    jpa.a(this.mBid, localQQAppInterface, new ssh(this, localQQAppInterface), false);
  }
  
  public void c(BaseActivity paramBaseActivity)
  {
    if (this.a != null)
    {
      this.a = new sse(paramBaseActivity, 0, this.a);
      return;
    }
    this.a = new sse(paramBaseActivity, 0, this.aGh, this.mClassLoader);
  }
  
  public void clear()
  {
    this.a = null;
  }
  
  public void vc(boolean paramBoolean)
  {
    if (paramBoolean) {}
    bAC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssf
 * JD-Core Version:    0.7.0.1
 */