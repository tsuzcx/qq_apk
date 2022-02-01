import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSAppLoader.1;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSAppLoader.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class lve
{
  private static volatile lve a;
  private static String afQ;
  private boolean aly;
  private List<String> iy = new ArrayList();
  
  public static lve a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new lve();
      }
      return a;
    }
    finally {}
  }
  
  private void ns(String paramString)
  {
    ThreadManager.excute(new PTSAppLoader.2(this, paramString), 128, null, true);
  }
  
  private void nt(String paramString)
  {
    int j = 0;
    this.iy.clear();
    String str1 = eL(paramString);
    boolean bool2 = aqhq.fileExists(str1);
    boolean bool3 = lvk.H(str1, paramString);
    String str2 = str1 + "/" + "pts_app_config.json";
    boolean bool4 = lvk.dO(str2);
    boolean bool1;
    if ((bool2) && (bool3) && (bool4)) {
      bool1 = true;
    }
    for (;;)
    {
      this.aly = bool1;
      afQ = lvk.eN(str2);
      Object localObject1 = str1 + File.separator + "pages";
      try
      {
        localObject1 = new File((String)localObject1);
        if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
        {
          localObject1 = ((File)localObject1).listFiles();
          int k = localObject1.length;
          i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            String str3 = localObject2.getName();
            if ((localObject2.isDirectory()) && (!TextUtils.isEmpty(str3))) {
              this.iy.add(str3);
            }
            i += 1;
            continue;
            bool1 = false;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("PTSAppLoader", 1, "[checkPTSApp], e = " + localException);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[checkPTSApp], bid = ").append(paramString).append("\n").append(", appPath = ").append(str1).append("\n").append(", ptsAppVersion = ").append(afQ).append("\n").append(", isAppExists = ").append(bool2).append("\n").append(", isAppValid = ").append(bool3).append("\n").append(", configPath = ").append(str2).append("\n").append(", isAppVersionValid = ").append(bool4).append("\n").append(", isAppOfflineDirValid = ").append(this.aly).append("\n").append(", appNameList = ");
        int i = j;
        while (i < this.iy.size())
        {
          localStringBuilder.append("[").append(i).append("]: ").append((String)this.iy.get(i)).append("\n");
          i += 1;
        }
        QLog.i("PTSAppLoader", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void aNC()
  {
    init();
    PTSAppLoader.1 local1 = new PTSAppLoader.1(this);
    ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
  }
  
  public boolean dN(String paramString)
  {
    boolean bool = this.iy.contains(paramString);
    QLog.i("PTSAppLoader", 1, "[isPTSAppReady], appName = " + paramString + ", isAppExists = " + bool + ", isAppOfflineDirValid = " + this.aly);
    return (this.aly) && (bool);
  }
  
  public String eL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = jpe.dO(paramString) + paramString;
    QLog.i("PTSAppLoader", 1, "[getPTSAppDownloadPath], bid = " + paramString + ", path = " + str);
    return str;
  }
  
  public void init()
  {
    try
    {
      this.aly = false;
      nt("3978");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String jy()
  {
    return afQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lve
 * JD-Core Version:    0.7.0.1
 */