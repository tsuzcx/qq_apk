import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lwe
{
  private static volatile lwe a;
  private static final String[] bs = { "native_article", "default_feeds" };
  private HashMap<String, List<String>> ea = new HashMap();
  
  public static lwe a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new lwe();
      }
      return a;
    }
    finally {}
  }
  
  private void bF(String paramString1, String paramString2)
  {
    if (this.ea == null) {
      return;
    }
    List localList = (List)this.ea.get(paramString2);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.ea.put(paramString2, localObject);
    }
    ((List)localObject).add(paramString1);
  }
  
  private String getBid(String paramString)
  {
    String str = "";
    if (TextUtils.equals(paramString, "native_article")) {
      str = awit.sn("native_proteus_offline_bid");
    }
    if (TextUtils.equals(paramString, "default_feeds")) {
      str = awit.sn("default_feeds_proteus_offline_bid");
    }
    return str;
  }
  
  private void nu(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if ((localBaseApplication == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject = localBaseApplication.getAssets();
    String str1 = "proteus" + File.separator + paramString + File.separator + "pages";
    QLog.i("PTSStyleManager", 1, "[loadLocalStyleFileImp], businessName = " + paramString + ", path = " + str1);
    for (;;)
    {
      int i;
      try
      {
        localObject = ((AssetManager)localObject).list(str1);
        if (localObject != null)
        {
          int j = localObject.length;
          i = 0;
          if (i >= j) {
            break;
          }
          String str2 = localObject[i];
          QLog.i("PTSStyleManager", 1, "[loadLocalStyleFileImp], pageName = " + str2);
          String str3 = PTSFileUtil.getFilePath(str2, str1, ".frametree");
          PTSFileUtil.loadFile(str3, localBaseApplication, true);
          if (!PTSFileUtil.isFileInMap(str3)) {
            break label277;
          }
          bF(str2, paramString);
          if ((!QLog.isColorLevel()) && (!QLog.isDebugVersion())) {
            break label277;
          }
          QLog.i("PTSStyleManager", 2, "[loadLocalStyleFileImp] load style succeed, pageName = " + str2 + ", frameTreeJsonPath = " + str3);
          break label277;
        }
        QLog.i("PTSStyleManager", 1, "[loadLocalStyleFileImp], fileLists is null.");
        return;
      }
      catch (IOException paramString)
      {
        QLog.e("PTSStyleManager", 1, "[loadLocalStyleFileImp], e = " + paramString);
        return;
      }
      label277:
      i += 1;
    }
  }
  
  private void nv(String paramString)
  {
    int i = 0;
    String str1 = getBid(paramString);
    if ((TextUtils.isEmpty(str1)) || (str1.equals("0")))
    {
      QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], bid is null or empty.");
      return;
    }
    str1 = jpe.dO(str1) + str1;
    str1 = str1 + File.separator + "pages";
    QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], businessName = " + paramString + ", path = " + str1);
    for (;;)
    {
      try
      {
        Object localObject = new File(str1);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localObject = ((File)localObject).listFiles();
          int j = localObject.length;
          if (i >= j) {
            break;
          }
          String str2 = localObject[i].getName();
          QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], pageName = " + str2);
          String str3 = PTSFileUtil.getFilePath(str2, str1, ".frametree");
          PTSFileUtil.loadFile(str3, null, false);
          if (!PTSFileUtil.isFileInMap(str3)) {
            break label323;
          }
          bF(str2, paramString);
          if ((!QLog.isColorLevel()) && (!QLog.isDebugVersion())) {
            break label323;
          }
          QLog.i("PTSStyleManager", 2, "[loadOfflineStyleFileImp] load style succeed, pageName = " + str2 + ", frameTreeJsonPath = " + str3);
          break label323;
        }
        QLog.i("PTSStyleManager", 1, "[loadOfflineStyleFileImp], pages directory does not exists.");
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("PTSStyleManager", 1, "[loadOfflineStyleFileImp], e = " + paramString);
        return;
      }
      label323:
      i += 1;
    }
  }
  
  public List<String> E(String paramString)
  {
    if (this.ea == null) {
      return null;
    }
    return (List)this.ea.get(paramString);
  }
  
  public String T(String paramString1, String paramString2)
  {
    Object localObject1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("PTSStyleManager", 1, "[getFrameTreeJson], businessName or pageName is null.");
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject1 = "";
      localObject2 = getBid(paramString1);
      localObject2 = PTSFileUtil.getFilePath(paramString2, jpe.dO((String)localObject2) + (String)localObject2 + File.separator + "pages", ".frametree");
      if (PTSFileUtil.isFileInMap((String)localObject2)) {
        localObject1 = PTSFileUtil.getFileContent((String)localObject2, null, false);
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        String str = PTSFileUtil.getFilePath(paramString2, "proteus" + File.separator + paramString1 + File.separator + "pages", ".frametree");
        localObject2 = localObject1;
        if (PTSFileUtil.isFileInMap(str)) {
          localObject2 = PTSFileUtil.getFileContent(str, BaseApplicationImpl.getContext(), true);
        }
      }
      localObject1 = localObject2;
    } while (!TextUtils.isEmpty((CharSequence)localObject2));
    QLog.e("PTSStyleManager", 1, "[getFrameTreeJson], frameTreeJson is empty, businessName = " + paramString1 + ", pageName = " + paramString2);
    return localObject2;
  }
  
  public void aNN()
  {
    String[] arrayOfString = bs;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      nu(str);
      nv(str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lwe
 * JD-Core Version:    0.7.0.1
 */