import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import cooperation.qzone.networkedmodule.QzoneModuleRecordFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class avwe
{
  private static volatile avwe a;
  private Map<String, avwe.a> qh = A(LocalMultiProcConfig.getString("Qz_setting", "NetworkedModuleConfig_cur", ""));
  private Map<String, avwe.a> qi = new ConcurrentHashMap();
  
  static Map<String, avwe.a> A(String paramString)
  {
    localConcurrentHashMap = new ConcurrentHashMap();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("qzone_networked_modules");
        if (paramString != null)
        {
          int j = paramString.length();
          int i = 0;
          while (i < j)
          {
            Object localObject2 = paramString.getJSONObject(i);
            Object localObject1 = ((JSONObject)localObject2).optString("module_id");
            String str1 = ((JSONObject)localObject2).optString("module_md5");
            String str2 = ((JSONObject)localObject2).optString("module_url");
            String str3 = ((JSONObject)localObject2).optString("module_version");
            String str4 = ((JSONObject)localObject2).optString("module_main_version");
            String str5 = ((JSONObject)localObject2).optString("module_key_class_name");
            String str6 = ((JSONObject)localObject2).optString("module_class_ids");
            int k = ((JSONObject)localObject2).optInt("module_class_ids_count");
            long l = ((JSONObject)localObject2).optLong("module_file_length");
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
            {
              localObject2 = new avwe.b();
              ((avwe.b)localObject2).a((String)localObject1).b(str3).c(str4).d(str2).e(str1).f(str5).g(str6).a(k).a(l);
              localObject1 = ((avwe.b)localObject2).c();
              localConcurrentHashMap.put(((avwe.a)localObject1).mModuleId, localObject1);
            }
            i += 1;
          }
        }
        return localConcurrentHashMap;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        QLog.e("QzoneModuleConfigManager", 1, paramString, new Object[0]);
      }
    }
  }
  
  private avwe.a a(UPDATE_INFO paramUPDATE_INFO)
  {
    String str3 = paramUPDATE_INFO.id;
    String str4 = paramUPDATE_INFO.md5;
    Object localObject1 = "";
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneModuleConfigManager", 1, "id:" + str3);
    }
    String str5 = paramUPDATE_INFO.ver;
    String str6 = paramUPDATE_INFO.mainVersion;
    Object localObject3 = "";
    Object localObject4 = "";
    String str2;
    String str1;
    String[] arrayOfString;
    if (paramUPDATE_INFO.plugin_info != null)
    {
      str2 = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(2));
      str1 = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(0));
      paramUPDATE_INFO = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(1));
      localObject1 = str2;
      localObject3 = str1;
      localObject4 = paramUPDATE_INFO;
      if (!TextUtils.isEmpty(paramUPDATE_INFO))
      {
        arrayOfString = paramUPDATE_INFO.split("#");
        localObject1 = str2;
        localObject3 = str1;
        localObject4 = paramUPDATE_INFO;
        if (arrayOfString.length < 2) {}
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        i = Integer.parseInt(arrayOfString[0]);
        localObject4 = arrayOfString[1];
        paramUPDATE_INFO = str2;
        localObject3 = str1;
        if (QLog.isColorLevel()) {
          QLog.i("QzoneModuleConfigManager", 1, "id:" + str3 + " ,md5:" + str4 + ",url:" + (String)localObject3 + " ,keyClassName:" + paramUPDATE_INFO + ",version:" + str5 + ",mainVersion:" + str6 + ",classIds:" + (String)localObject4 + ",classIDsCount:" + i);
        }
        if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str4))) {
          break;
        }
        localObject1 = new avwe.b();
        ((avwe.b)localObject1).a(str3).b(str5).c(str6).d((String)localObject3).e(str4).f(paramUPDATE_INFO).g((String)localObject4).a(i).a(0L);
        return ((avwe.b)localObject1).c();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("QzoneModuleConfigManager", 1, "catch an exception: ", localNumberFormatException);
        localObject4 = paramUPDATE_INFO;
        localObject3 = str1;
        localObject2 = str2;
      }
      paramUPDATE_INFO = localObject2;
      int i = 0;
    }
    return null;
  }
  
  public static avwe a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avwe();
      }
      return a;
    }
    finally {}
  }
  
  static String i(Map<String, avwe.a> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramMap.keySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          JSONObject localJSONObject2 = new JSONObject();
          localObject = (avwe.a)paramMap.get(localObject);
          try
          {
            localJSONObject2.put("module_id", ((avwe.a)localObject).mModuleId);
            localJSONObject2.put("module_md5", ((avwe.a)localObject).mMD5);
            localJSONObject2.put("module_url", ((avwe.a)localObject).mUrl);
            localJSONObject2.put("module_version", ((avwe.a)localObject).mVersion);
            localJSONObject2.put("module_main_version", ((avwe.a)localObject).cOh);
            localJSONObject2.put("module_key_class_name", ((avwe.a)localObject).cOi);
            localJSONObject2.put("module_class_ids", ((avwe.a)localObject).cOk);
            localJSONObject2.put("module_class_ids_count", ((avwe.a)localObject).eyS);
            localJSONObject2.put("module_file_length", ((avwe.a)localObject).aAA);
            localJSONArray.put(localJSONObject2);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
      try
      {
        localJSONObject1.put("qzone_networked_modules", localJSONArray);
        paramMap = localJSONObject1.toString();
        return paramMap;
      }
      catch (JSONException paramMap)
      {
        paramMap.printStackTrace();
      }
    }
    return "";
  }
  
  public avwe.a a(String paramString)
  {
    boolean bool = true;
    label386:
    for (;;)
    {
      try
      {
        avwe.a locala1 = (avwe.a)this.qh.get(paramString);
        avwe.a locala2 = (avwe.a)this.qi.get(paramString);
        Object localObject = locala2;
        if (locala2 == null)
        {
          locala2 = QzoneModuleRecordFactory.getInstance().createRecord(paramString);
          localObject = new StringBuilder().append("try to create record locally,success ? : ");
          if (locala2 == null) {
            continue;
          }
          QLog.i("QzoneModuleConfigManager", 2, String.valueOf(bool));
          localObject = locala2;
          if (locala2 != null)
          {
            this.qi.put(paramString, locala2);
            localObject = locala2;
          }
        }
        if (locala1 != null)
        {
          locala1.a = ((avwe.a)localObject);
          paramString = locala1;
          localObject = paramString;
          if (paramString != null)
          {
            if ((paramString.a != null) && (!TextUtils.isEmpty(paramString.a.cOj)) && (!avpq.getQUA3().equalsIgnoreCase(paramString.a.cOj)))
            {
              QLog.i("QzoneModuleConfigManager", 1, "mNewVersion.mQua=" + paramString.a.cOj + " is not equal QUA=" + avpq.getQUA3());
              paramString.a = null;
            }
            localObject = paramString;
            if (!TextUtils.isEmpty(paramString.cOj))
            {
              localObject = paramString;
              if (!avpq.getQUA3().equalsIgnoreCase(paramString.cOj))
              {
                QLog.i("QzoneModuleConfigManager", 1, "curRecord.mQua=" + paramString.cOj + " is not equal QUA=" + avpq.getQUA3());
                if ((paramString.a == null) || (!paramString.mMD5.equalsIgnoreCase(paramString.a.mMD5))) {
                  continue;
                }
                localObject = paramString.a;
                a((avwe.a)localObject);
                QLog.i("QzoneModuleConfigManager", 1, "curRecord and updateRecord has the same md5,so needn't to download again,just call updateConfigAfterDownloaded to update cur configs");
              }
            }
          }
          return localObject;
          bool = false;
        }
        else
        {
          paramString = locala1;
          if (localObject == null) {
            continue;
          }
          ((avwe.a)localObject).a = ((avwe.a)localObject);
          if (!TextUtils.equals(((avwe.a)localObject).mMD5, ((avwe.a)localObject).mMD5)) {
            break label386;
          }
          ((avwe.a)localObject).aAA = ((avwe.a)localObject).aAA;
          break label386;
        }
        localObject = paramString.a;
        continue;
        paramString = (String)localObject;
      }
      finally {}
    }
  }
  
  public void a(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP)
  {
    for (;;)
    {
      try
      {
        QLog.i("QzoneModuleConfigManager", 1, "handleModuleRsp:");
        if ((paramSQ_CLIENT_UPDATE_RSP == null) || (paramSQ_CLIENT_UPDATE_RSP.vModule == null) || (paramSQ_CLIENT_UPDATE_RSP.vModule.size() <= 0)) {
          break label505;
        }
        QLog.i("QzoneModuleConfigManager", 1, "handleModuleRsp:" + paramSQ_CLIENT_UPDATE_RSP.vModule.size());
        paramSQ_CLIENT_UPDATE_RSP = paramSQ_CLIENT_UPDATE_RSP.vModule;
        i = 0;
        paramSQ_CLIENT_UPDATE_RSP = paramSQ_CLIENT_UPDATE_RSP.iterator();
        if (paramSQ_CLIENT_UPDATE_RSP.hasNext())
        {
          UPDATE_INFO localUPDATE_INFO = (UPDATE_INFO)paramSQ_CLIENT_UPDATE_RSP.next();
          Object localObject = a(localUPDATE_INFO);
          if (localObject != null) {
            this.qi.put(((avwe.a)localObject).mModuleId, localObject);
          }
          if (localUPDATE_INFO.actype == 4)
          {
            QLog.w("QzoneModuleConfigManager", 1, "clear module config:" + localUPDATE_INFO.id);
            localObject = (avwe.a)this.qh.get(localUPDATE_INFO.id);
            if (localObject == null) {
              break label508;
            }
            localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), (avwe.a)localObject));
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
            this.qh.remove(localUPDATE_INFO.id);
            i = 1;
            if (this.qi.containsKey(localUPDATE_INFO.id)) {
              this.qi.remove(localUPDATE_INFO.id);
            }
            QzoneModuleConst.clearLastCrashCount(localUPDATE_INFO.id);
            continue;
          }
          if (localUPDATE_INFO.actype == 0) {
            continue;
          }
          QLog.w("QzoneModuleConfigManager", 1, "force update module config:" + localUPDATE_INFO.id);
          avwe.a locala = (avwe.a)this.qh.get(localUPDATE_INFO.id);
          if (locala == null) {
            continue;
          }
          this.qh.remove(localUPDATE_INFO.id);
          if (!locala.mMD5.equalsIgnoreCase(localUPDATE_INFO.md5))
          {
            localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), locala));
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
            QLog.w("QzoneModuleConfigManager", 1, "force update module md5 is not same,so just delete local file and config:" + localUPDATE_INFO.id);
          }
          else if (localObject != null)
          {
            this.qh.put(localUPDATE_INFO.id, localObject);
            QLog.w("QzoneModuleConfigManager", 1, "force update module md5 is same,so just update config:" + localUPDATE_INFO.id);
            QzoneModuleConst.clearLastCrashCount(localUPDATE_INFO.id);
          }
        }
      }
      finally {}
      if (i != 0) {
        LocalMultiProcConfig.putString("Qz_setting", "NetworkedModuleConfig_cur", i(this.qh));
      }
      label505:
      return;
      label508:
      continue;
      int i = 1;
    }
  }
  
  public void a(avwe.a parama)
  {
    if (parama != null) {}
    try
    {
      this.qi.remove(parama.mModuleId);
      Object localObject = (avwe.a)this.qh.get(parama.mModuleId);
      if ((localObject != null) && (!((avwe.a)localObject).mMD5.equalsIgnoreCase(parama.mMD5)))
      {
        localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), (avwe.a)localObject));
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), parama));
      if (((File)localObject).exists()) {
        parama.aAA = ((File)localObject).length();
      }
      this.qh.put(parama.mModuleId, parama);
      LocalMultiProcConfig.putString("Qz_setting", "NetworkedModuleConfig_cur", i(this.qh));
      QzoneModuleConst.clearLastCrashCount(parama.mModuleId);
      return;
    }
    finally {}
  }
  
  public void b(avwe.a parama)
  {
    try
    {
      this.qi.put(parama.mModuleId, parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public ArrayList<UPDATE_INFO> eD()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = QzoneModuleConst.QZONE_MODULES_QBOSS.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      UPDATE_INFO localUPDATE_INFO = new UPDATE_INFO();
      localUPDATE_INFO.id = str;
      avwe.a locala = (avwe.a)this.qh.get(str);
      if (locala != null) {}
      for (localUPDATE_INFO.ver = locala.mVersion;; localUPDATE_INFO.ver = "0")
      {
        localArrayList.add(localUPDATE_INFO);
        QLog.i("QzoneModuleConfigManager", 1, "getUpdateInfo:" + str);
        break;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avwe
 * JD-Core Version:    0.7.0.1
 */