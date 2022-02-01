import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.QQStoryFollowCaptureResManager.1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ayzv
{
  private static String TAG = "QQStoryFollowCaptureResManager";
  private static ayzv a;
  private static File bt = createDir(new File(aasa.SDCARD_PATH), "qqstroy_follow_capture");
  private static File bu = createDir(bt, "follow_capture_template");
  private static File bv = createDir(bt, "follow_capture_original_video");
  private String bYP;
  private Boolean bd;
  
  static
  {
    eUA();
  }
  
  public static String[] H(String paramString)
  {
    paramString = bu.getPath() + File.separator + paramString + File.separator;
    return new String[] { paramString + "background.png", paramString + "foreground" };
  }
  
  public static File U()
  {
    if (!bv.exists()) {
      bv.mkdirs();
    }
    return bv;
  }
  
  public static ayzv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ayzv();
      }
      return a;
    }
    finally {}
  }
  
  public static void a(String paramString, ayzv.a parama)
  {
    String str1 = sU(paramString);
    if (str1 == null) {}
    for (;;)
    {
      return;
      if (!bu.exists()) {
        bu.mkdirs();
      }
      String str2 = bu.getPath() + File.separator + str1 + ".zip";
      if (!cB(str2, str1))
      {
        aoll localaoll = new aoll();
        localaoll.f = new ayzw(str2, str1, parama);
        localaoll.bZ = paramString;
        localaoll.mHttpMethod = 0;
        localaoll.atY = str2;
        localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
        try
        {
          parama = BaseApplicationImpl.getApplication().getRuntime();
          if (QQAppInterface.class.isInstance(parama))
          {
            ((QQAppInterface)parama).getNetEngine(0).a(localaoll);
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "start download follow capture template, url: " + paramString);
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          QLog.e(TAG, 1, "download follow capture template error", paramString);
        }
      }
    }
  }
  
  private static boolean cB(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (i(paramString1, paramString2)) {
      return j(paramString1, paramString2);
    }
    paramString1.delete();
    if (QLog.isColorLevel()) {
      QLog.e(TAG, 2, "template zip md5 is wrong");
    }
    return false;
  }
  
  private static File createDir(File paramFile, String paramString)
  {
    paramFile = new File(paramFile, paramString);
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    return paramFile;
  }
  
  public static void deleteCache()
  {
    deleteFile(bv, false);
    deleteFile(bu, false);
  }
  
  private static void deleteFile(File paramFile, boolean paramBoolean)
  {
    List localList = g(paramFile);
    int i = localList.size() - 1;
    while (i >= 0)
    {
      ((File)localList.get(i)).delete();
      i -= 1;
    }
    if (paramBoolean) {
      paramFile.delete();
    }
  }
  
  private static void eUA()
  {
    File localFile = new File(bt, ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "create .nomedia file error");
    }
  }
  
  private void eUB()
  {
    iU(psr.my());
  }
  
  public static void eUz()
  {
    if (bt != null)
    {
      List localList = g(bt);
      Iterator localIterator = localList.iterator();
      for (long l = 0L; localIterator.hasNext(); l = ((File)localIterator.next()).length() + l) {}
      if (l > 209715200L)
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          ((File)localList.get(i)).delete();
          i -= 1;
        }
      }
      eUA();
    }
  }
  
  private static List<File> g(File paramFile)
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (paramFile.isFile()) {
        return localArrayList1;
      }
      ArrayList localArrayList2 = new ArrayList();
      paramFile = paramFile.listFiles();
      int i;
      if ((paramFile != null) && (paramFile.length != 0))
      {
        int j = paramFile.length;
        i = 0;
        while (i < j)
        {
          localArrayList2.add(paramFile[i]);
          i += 1;
        }
      }
      while (localArrayList2.size() > 0)
      {
        paramFile = (File)localArrayList2.remove(0);
        localArrayList1.add(paramFile);
        if (paramFile.isDirectory())
        {
          paramFile = paramFile.listFiles();
          i = 0;
          while (i < paramFile.length)
          {
            localArrayList2.add(paramFile[i]);
            i += 1;
          }
        }
      }
    }
    return localArrayList1;
  }
  
  private static boolean i(File paramFile, String paramString)
  {
    boolean bool = true;
    if (!paramFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 2, "template zip file not exists");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        paramFile = aqhq.px(paramFile.getPath());
        if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramFile))) {
          break label72;
        }
        return bool;
      }
      catch (UnsatisfiedLinkError paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(TAG, 1, "calculate follow capture template zip md5 error", paramFile);
      return false;
      label72:
      bool = false;
    }
  }
  
  private boolean iU(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "parse config: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new JSONObject(paramString);
        this.bd = Boolean.valueOf(paramString.optBoolean("enableFollowCapture"));
        this.bYP = paramString.optString("guideVideoUrl");
        return true;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 1, "parse follow capture config error", paramString);
        }
        return false;
      }
      finally
      {
        if (this.bd == null) {
          this.bd = Boolean.valueOf(false);
        }
      }
    }
  }
  
  private static boolean j(File paramFile, String paramString)
  {
    try
    {
      paramString = bu.getPath() + File.separator + paramString + File.separator;
      deleteFile(new File(paramString), true);
      File localFile = new File(paramString + "complete");
      if (localFile.exists()) {
        return true;
      }
      jqp.b(paramFile, paramString);
      localFile.createNewFile();
      return true;
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "uncompress template zip file error", paramFile);
      }
    }
    return false;
  }
  
  public static String sU(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w(TAG, 2, "template url is null");
      return null;
    }
    int i = paramString.lastIndexOf("/");
    int j = paramString.lastIndexOf(".");
    if ((i == -1) || (j == -1) || (i + 1 > j))
    {
      QLog.w(TAG, 2, "template url is :" + paramString);
      return null;
    }
    return paramString.substring(i + 1, j);
  }
  
  public static boolean uq(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      bool = false;
    }
    while (new File(bu.getPath() + File.separator + paramString + File.separator + "complete").exists()) {
      return bool;
    }
    File localFile = new File(bu.getPath() + File.separator + paramString + ".zip");
    bool = i(localFile, paramString);
    if (bool) {
      ThreadManagerV2.excute(new QQStoryFollowCaptureResManager.1(localFile, paramString), 16, null, true);
    }
    return bool;
  }
  
  public boolean aRA()
  {
    return !TextUtils.isEmpty(psr.my());
  }
  
  public boolean aRB()
  {
    if (this.bd == null) {
      eUB();
    }
    if (this.bd != null) {
      return this.bd.booleanValue();
    }
    return false;
  }
  
  public void eUy()
  {
    try
    {
      psr.bmG();
      return;
    }
    finally {}
  }
  
  public boolean n(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (!iU(paramString)) {
      return false;
    }
    psr.ri(paramString);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void onDownloadError();
    
    public abstract void onDownloadSuccess();
    
    public abstract void onProgress(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzv
 * JD-Core Version:    0.7.0.1
 */