import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;

public class ahpl
  implements Manager
{
  private aopo a;
  private QQAppInterface app;
  private EntityManager em;
  private String mMD5;
  private String mURL;
  
  public ahpl(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.em = paramQQAppInterface.a().createEntityManager();
  }
  
  private void Gu(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
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
      QLog.e("IntimateInfoManager", 1, "unzipResource fail.", paramString1);
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
    if (!TextUtils.isEmpty(this.mMD5))
    {
      String str = uI();
      if (l(new String[] { str + "/boy_add", str + "/boy_reduce", str + "/couple_add", str + "/couple_reduce", str + "/girl_add", str + "/girl_reduce" })) {
        return true;
      }
    }
    return false;
  }
  
  private String kH(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { uJ(), paramString });
  }
  
  public static boolean l(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!new File(str).exists())
      {
        QLog.e("IntimateInfoManager", 1, String.format("isFilesExist check fail. filePath=%s", new Object[] { str }));
        return false;
      }
      i += 1;
    }
    return true;
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
      localObject2 = ((File)localObject2).getAbsolutePath() + "/pddata/prd/intimate_res";
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
  
  public void Kt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((this.em == null) || (!this.em.isOpen()));
      paramString = (IntimateInfo)this.em.find(IntimateInfo.class, paramString);
      if (paramString != null) {
        this.em.remove(paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("intimate_relationship", 2, "removeIntimateInfo: " + paramString);
  }
  
  public IntimateInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.em == null) || (!this.em.isOpen())) {
      return null;
    }
    return (IntimateInfo)this.em.find(IntimateInfo.class, paramString);
  }
  
  public void a(IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo == null) {}
    do
    {
      return;
      if ((this.em != null) && (this.em.isOpen())) {
        this.em.update(paramIntimateInfo);
      }
    } while (!QLog.isColorLevel());
    QLog.d("intimate_relationship", 2, String.format("updateIntimateInfo, uin: %s", new Object[] { paramIntimateInfo.friendUin }));
  }
  
  public void a(String paramString, IntimateInfo paramIntimateInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIntimateInfo == null)) {}
    do
    {
      return;
      if ((this.em != null) && (this.em.isOpen())) {
        this.em.persistOrReplace(paramIntimateInfo);
      }
    } while (!QLog.isColorLevel());
    QLog.d("intimate_relationship", 2, String.format("updateIntimateInfo, uin: %s", new Object[] { paramString }));
  }
  
  public boolean akh()
  {
    boolean bool1 = aki();
    boolean bool2 = akj();
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (bool2);
  }
  
  public void dbY()
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.mURL))) {
      this.a.a(this.mURL);
    }
  }
  
  public void downloadResource()
  {
    if ((TextUtils.isEmpty(this.mURL)) || (TextUtils.isEmpty(this.mMD5))) {
      QLog.e("IntimateInfoManager", 1, "downloadResource invalid parameters.");
    }
    boolean bool1;
    boolean bool2;
    do
    {
      String str;
      do
      {
        do
        {
          return;
          if (this.a == null) {
            this.a = ((aopo)this.app.getManager(193));
          }
          str = kH(this.mMD5);
          if (x(str, this.mMD5)) {
            break;
          }
          Gu(str);
        } while (this.a == null);
        Object localObject = new aoll();
        ((aoll)localObject).f = new ahpm(this);
        ((aoll)localObject).bZ = this.mURL;
        ((aoll)localObject).mHttpMethod = 0;
        ((aoll)localObject).atY = str;
        ((aoll)localObject).dPo = 0;
        ((aoll)localObject).a = new ahpn(this);
        localObject = new aopn(this.app, this.mMD5, new ahpo(this), (aoll)localObject);
        this.a.a(10089, "prd", this.mMD5, 0, this.mURL, str, 2, 0, false, (aopm)localObject);
        return;
      } while (akj());
      bool1 = aU(str, uI());
      bool2 = akj();
    } while (!QLog.isColorLevel());
    QLog.d("IntimateInfoManager", 2, String.format("downloadResource unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
  }
  
  public void gi(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("checkAndDownloadIntimateResources url=%s md5=%s", new Object[] { paramString1, paramString2 }));
    }
    this.mURL = paramString1;
    this.mMD5 = paramString2;
    if (!akh()) {
      downloadResource();
    }
  }
  
  public String m(int paramInt, boolean paramBoolean)
  {
    String str = uI();
    if (paramInt == 3) {
      if (paramBoolean) {
        str = str + "/boy_add/data.json";
      }
    }
    for (;;)
    {
      if ((!new File(str).exists()) && (QLog.isColorLevel())) {
        QLog.d("IntimateInfoManager", 2, "getIntimateScoreAnimJsonPath not exists:" + str);
      }
      return str;
      str = str + "/boy_reduce/data.json";
      continue;
      if (paramInt == 2)
      {
        if (paramBoolean) {
          str = str + "/girl_add/data.json";
        } else {
          str = str + "/girl_reduce/data.json";
        }
      }
      else
      {
        if (paramInt != 1) {
          break;
        }
        if (paramBoolean) {
          str = str + "/couple_add/data.json";
        } else {
          str = str + "/couple_reduce/data.json";
        }
      }
    }
    return null;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "IntimateInfoManager onDestroy");
    }
    this.em.close();
    dbY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahpl
 * JD-Core Version:    0.7.0.1
 */