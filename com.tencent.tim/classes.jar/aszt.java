import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class aszt
{
  private SharedPreferences ah;
  private long axM = 0L;
  private boolean dgM;
  private List<aszv.b> hr;
  private QQAppInterface mApp;
  
  public aszt(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.hr = new ArrayList();
    this.ah = this.mApp.getApp().getSharedPreferences("qp_sfu_config", 0);
  }
  
  private String Ae()
  {
    return this.mApp.getApp().getDir("qqprotect", 0).toString() + File.separator + "SFU/" + "qp_sfu_config.dat";
  }
  
  private String K(String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.equals("1"))) {
      str = this.mApp.getApp().getFilesDir().getParent();
    }
    for (;;)
    {
      paramString1 = str;
      if (!str.endsWith(File.separator))
      {
        paramString1 = str;
        if (!paramString2.startsWith(File.separator)) {
          paramString1 = str + File.separator;
        }
      }
      paramString1 = paramString1 + paramString2;
      if (!paramString2.endsWith(File.separator)) {
        break;
      }
      return paramString1 + paramString3;
      if (paramString1.equals("2")) {
        str = this.mApp.getApp().getExternalFilesDir(null).getParent();
      }
    }
    return paramString1 + File.separator + paramString3;
  }
  
  private int ak(String paramString1, String paramString2)
    throws NumberFormatException
  {
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i;
    int j;
    if (paramString1.length < paramString2.length)
    {
      i = paramString1.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label84;
      }
      int k = Integer.parseInt(paramString1[j]);
      int m = Integer.parseInt(paramString2[j]);
      if (k > m)
      {
        return 1;
        i = paramString2.length;
        break;
      }
      if (k < m) {
        return -1;
      }
      j += 1;
    }
    label84:
    return 0;
  }
  
  private boolean c(String paramString, long paramLong1, long paramLong2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || (!paramString.equals("android"))) {
      bool1 = false;
    }
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
              return false;
            }
            l = Build.VERSION.SDK_INT;
            if (paramLong1 != 0L) {
              break;
            }
            bool1 = bool2;
          } while (paramLong2 == 0L);
          if ((paramLong1 != 0L) || (paramLong2 <= 0L)) {
            break;
          }
          bool1 = bool2;
        } while (l <= paramLong2);
        return false;
        if ((paramLong1 <= 0L) || (paramLong2 != 0L)) {
          break;
        }
        bool1 = bool2;
      } while (l >= paramLong1);
      return false;
      if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
        break label147;
      }
      if (l < paramLong1) {
        break;
      }
      bool1 = bool2;
    } while (l <= paramLong2);
    return false;
    label147:
    return false;
  }
  
  private boolean ck(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString1 == null) || (paramString2 == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          paramString1 = paramString1.replace(" ", "");
          paramString2 = paramString2.replace(" ", "");
          boolean bool3 = paramString1.equals("*");
          boolean bool4 = paramString2.equals("*");
          String str;
          if (bool3)
          {
            bool1 = bool2;
            if (bool4) {}
          }
          else
          {
            str = aqgz.bd(this.mApp.getApp());
            if (TextUtils.isEmpty(str)) {
              return false;
            }
            if ((bool3) && (!bool4)) {
              bool1 = bool2;
            }
          }
          try
          {
            if (ak(str, paramString2) > 0) {
              return false;
            }
          }
          catch (Exception paramString1)
          {
            int i;
            paramString1.printStackTrace();
          }
        }
        if ((bool3) || (!bool4)) {
          break;
        }
        bool1 = bool2;
      } while (ak(str, paramString1) >= 0);
      return false;
      if ((bool3) || (bool4)) {
        break label182;
      }
      if (ak(str, paramString2) > 0) {
        break;
      }
      i = ak(str, paramString1);
      bool1 = bool2;
    } while (i >= 0);
    return false;
    label182:
    return false;
  }
  
  private boolean parse(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONObject(paramString);
      this.axM = paramString.getLong("version");
      this.dgM = paramString.getBoolean("forceupdate");
      paramString = paramString.getJSONArray("sections");
      int i = 0;
      while (i < paramString.length())
      {
        aszv.b localb = new aszv.b();
        Object localObject = paramString.getJSONObject(i);
        localb.sectionId = ((JSONObject)localObject).getLong("sid");
        localb.businessId = ((JSONObject)localObject).getLong("bid");
        localb.axN = ((JSONObject)localObject).getLong("size");
        localb.packageName = ((JSONObject)localObject).getString("name");
        localb.cGt = ((JSONObject)localObject).getString("md5");
        localb.cGu = ((JSONObject)localObject).getString("url");
        localb.axO = ((JSONObject)localObject).getLong("osminver");
        localb.axP = ((JSONObject)localObject).getLong("osmaxver");
        localb.cGw = ((JSONObject)localObject).getString("cpuabi");
        localb.minQQVersion = ((JSONObject)localObject).getString("qqminver");
        localb.cGv = ((JSONObject)localObject).getString("qqmaxver");
        localb.os = ((JSONObject)localObject).getString("os");
        localb.dgQ = c(localb.os, localb.axO, localb.axP);
        localb.dgR = sS(localb.cGw);
        localb.dgP = ck(localb.minQQVersion, localb.cGv);
        if (((JSONObject)localObject).has("flag")) {
          localb.eot = ((JSONObject)localObject).getInt("flag");
        }
        localObject = ((JSONObject)localObject).getJSONArray("files");
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
          aszv.a locala = new aszv.a();
          locala.fileSize = localJSONObject.getLong("size");
          locala.cGq = localJSONObject.getString("root");
          locala.filePath = localJSONObject.getString("path");
          locala.fileName = localJSONObject.getString("name");
          locala.cGr = K(locala.cGq, locala.filePath, locala.fileName);
          locala.cGo = localJSONObject.getString("md5");
          locala.reportId = localJSONObject.getLong("rptid");
          if (localJSONObject.has("extra")) {
            locala.extraInfo = localJSONObject.getString("extra");
          }
          localb.Ki.add(locala);
          j += 1;
        }
        localArrayList.add(localb);
        i += 1;
      }
      this.hr = localArrayList;
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] parsing config error");
      }
    }
    return false;
  }
  
  private boolean sS(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      Object localObject = paramString.replace(" ", "");
      if (((String)localObject).equals("*")) {
        return true;
      }
      paramString = Build.CPU_ABI;
      localObject = ((String)localObject).split(",");
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.contains(localObject[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public List<aszv.b> hd()
  {
    return this.hr;
  }
  
  public List<aszv.b> l(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.ah.getString("last_update_bids", "");
    String str = this.ah.getString("last_update_sections", "");
    if ((((String)localObject).indexOf(String.format("#%d#", new Object[] { Long.valueOf(paramLong) })) != -1) && (sR(Ae())) && (!this.hr.isEmpty()))
    {
      int i = 0;
      if (i < this.hr.size())
      {
        localObject = (aszv.b)this.hr.get(i);
        if (((aszv.b)localObject).businessId == paramLong) {
          if (str.indexOf(String.format("#%d#", new Object[] { Long.valueOf(((aszv.b)localObject).sectionId) })) != -1) {
            break label167;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label167:
          int j = 0;
          aszv.a locala;
          while (j < ((aszv.b)localObject).Ki.size())
          {
            locala = (aszv.a)((aszv.b)localObject).Ki.get(j);
            locala.cGs = this.ah.getString(locala.cGr, "");
            j += 1;
          }
          j = 0;
          while (j < ((aszv.b)localObject).Kk.size())
          {
            locala = (aszv.a)((aszv.b)localObject).Kk.get(j);
            locala.cGs = this.ah.getString(locala.cGr, "");
            j += 1;
          }
          j = 0;
          while (j < ((aszv.b)localObject).Kj.size())
          {
            locala = (aszv.a)((aszv.b)localObject).Kj.get(j);
            locala.cGs = this.ah.getString(locala.cGr, "");
            j += 1;
          }
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean sR(String paramString)
  {
    boolean bool = false;
    byte[] arrayOfByte = aszw.b(new File(paramString), null);
    if (arrayOfByte != null) {
      bool = parse(new String(arrayOfByte));
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] invalid sig of config: %s", new Object[] { paramString }));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszt
 * JD-Core Version:    0.7.0.1
 */