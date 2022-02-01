import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker.4;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class apke
{
  private static Map<String, Boolean> nH = new ConcurrentHashMap();
  int byV = 0;
  private String ceJ;
  private String cpL;
  private String mBid;
  private Context mContext;
  
  public apke(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mBid = paramString1;
    this.ceJ = paramString2;
    this.cpL = paramString3;
  }
  
  public static String G(Context paramContext, String paramString)
  {
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + paramString;
  }
  
  private aqvc a()
  {
    return ((aqva)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(47)).a(1);
  }
  
  private boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
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
            break label583;
          }
          QLog.i("SoLibraryLoader", 2, "doUnzipZip: no zip ! : businessId:" + str2);
          break label583;
        }
        long l = System.currentTimeMillis();
        str1 = localFile.getParent() + File.separator + str2;
        localObject = BidDownloader.dK(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("SoLibraryLoader", 2, "fileFormat: " + (String)localObject + ", path: " + paramString);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label368;
        }
        if (((String)localObject).equals("zip"))
        {
          i = jqp.unZipFolder(paramString, str1);
          if (QLog.isColorLevel()) {
            QLog.i("SoLibraryLoader", 2, "now delete original download offline zip, path: " + paramString);
          }
          jqo.deleteFile(paramString);
          if (i <= 0) {
            break label429;
          }
          jpa.a(str2, 13, 0L, i, "lixian_update", "0");
          if (!QLog.isColorLevel()) {
            break label578;
          }
          QLog.i("SoLibraryLoader", 2, "unZipFolder fail!");
          paramBoolean1 = false;
          jqo.dn(str1);
          paramBoolean2 = paramBoolean1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("SoLibraryLoader", 2, "time of unzip zip：" + (System.currentTimeMillis() - l) + ", isSuccess: " + paramBoolean1);
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
      label368:
      QLog.w("SoLibraryLoader", 1, "can not recognize download compress file format, " + paramString);
      if (paramBoolean1)
      {
        i = jqp.unZipFolder(paramString, str1);
      }
      else if (paramBoolean2)
      {
        i = LzmaUtils.m(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, str1);
        continue;
        label429:
        paramString = str1 + File.separator + str2 + ".zip";
        localObject = new File(paramString);
        str2 = localFile.getParent() + File.separator + str2 + ".zip";
        if (QLog.isColorLevel()) {
          QLog.i("SoLibraryLoader", 2, "now move zip file to location: " + str2);
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
          label578:
          paramBoolean1 = false;
          continue;
          label583:
          paramBoolean2 = false;
        }
      }
    }
  }
  
  public static boolean ah(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getFilesDir().getAbsolutePath() + File.separator + paramString);
    return (paramContext != null) && (paramContext.exists());
  }
  
  private void bM(JSONObject paramJSONObject)
  {
    boolean bool1 = true;
    int i = paramJSONObject.optInt("code");
    String str = jpe.dP(this.mBid);
    boolean bool2;
    if (!TextUtils.isEmpty(str)) {
      if (i == 4)
      {
        str = str + this.mBid + ".7z";
        bool2 = false;
      }
    }
    for (;;)
    {
      apkh localapkh = new apkh(this, str, bool2, bool1);
      if (!TextUtils.isEmpty(str)) {
        ThreadManager.post(new SoLibraryChecker.4(this, paramJSONObject, str, localapkh), 8, null, false);
      }
      return;
      if ((i == 3) || (i == 2))
      {
        str = str + this.mBid + ".zip";
        bool2 = true;
        bool1 = false;
      }
      else
      {
        QLog.e("SoLibraryLoader", 1, "do not know what format, use default zip name!");
        str = str + this.mBid + ".zip";
        bool2 = false;
        bool1 = false;
        continue;
        bool1 = false;
        bool2 = false;
        str = null;
      }
    }
  }
  
  private void eau()
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
        QLog.d("SoLibraryLoader", 2, "checkSoUpdate version = " + str);
      }
      if ((!new File(jpe.dO(this.mBid) + this.mBid + "/" + this.ceJ).exists()) && (!TextUtils.isEmpty(str)) && (!"0".equals(str))) {
        aqhq.cn(jpe.dO(this.mBid) + this.mBid);
      }
      if (localQQAppInterface != null) {
        break;
      }
      return;
    }
    jpa.a(this.mBid, localQQAppInterface, new apkf(this), false);
  }
  
  private void eav()
  {
    String str = "https://" + this.ceJ + "?_bid=" + this.mBid;
    long l = System.currentTimeMillis();
    if ((!jpa.a(BaseApplicationImpl.getContext(), str, new apkg(this, l))) && (QLog.isColorLevel())) {
      QLog.i("SoLibraryLoader", 2, "so file = " + this.ceJ + " transToLocalUrl: return false");
    }
  }
  
  public void execute()
  {
    if (!nH.containsKey(this.mBid)) {
      nH.put(this.mBid, Boolean.valueOf(false));
    }
    if ((!ah(this.mContext, this.ceJ)) || (!((Boolean)nH.get(this.mBid)).booleanValue()))
    {
      eau();
      nH.put(this.mBid, Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apke
 * JD-Core Version:    0.7.0.1
 */