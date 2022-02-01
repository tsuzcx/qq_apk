import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.VasEmojiManager.1;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afli
{
  public static HashMap<String, afks> kr = new HashMap();
  public afke c;
  public ConcurrentHashMap<String, Bundle> fl = new ConcurrentHashMap();
  private aquy g = new aflj(this);
  public QQAppInterface mApp;
  
  public afli(AppInterface paramAppInterface)
  {
    this.mApp = ((QQAppInterface)paramAppInterface);
    this.c = ((afke)this.mApp.getManager(43));
  }
  
  private String a(String paramString1, String paramString2, String paramString3, File paramFile)
  {
    File localFile = new File(afnu.bEu.replace("[epId]", paramString1));
    boolean bool = true;
    if (localFile.exists()) {
      bool = localFile.delete();
    }
    if (!bool) {
      return "delete jsonFile failed.";
    }
    if (!paramFile.renameTo(localFile)) {
      return "rename tmpJsonFile failed.";
    }
    aqhq.cn(paramString2);
    paramFile = new File(paramString2);
    if (paramFile.exists()) {
      return "delete h5magic failed.";
    }
    if (!new File(paramString3).renameTo(paramFile)) {
      return "rename tmpUnzipPath failed.";
    }
    a().fx(paramString1, paramString2);
    return null;
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, ArrayList<Emoticon> paramArrayList, boolean paramBoolean, Bundle paramBundle)
  {
    afke localafke = a();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramBundle.putSerializable("emoticonList", paramArrayList);
    localafke.b(localArrayList, localHashMap, paramEmoticonPackage, paramBundle);
    int i = localafke.a(paramEmoticonPackage, paramArrayList, localArrayList, localHashMap, paramBundle, 6);
    if (i != 0)
    {
      QLog.e("VasEmojiManager", 1, "downloadOthers error : " + i);
      return;
    }
    paramArrayList = new aquz(localArrayList, localHashMap, "vipEmoticonKey_" + paramEmoticonPackage.epId);
    paramArrayList.cWw = true;
    if (localArrayList.size() == 0)
    {
      paramArrayList.dy(paramBundle);
      paramArrayList.setStatus(3);
      this.g.onDone(paramArrayList);
    }
    for (;;)
    {
      localafke.b(paramEmoticonPackage, paramBoolean);
      return;
      localafke.a().a(paramArrayList, this.g, paramBundle);
    }
  }
  
  private boolean a(String paramString, Bundle paramBundle, EmoticonPackage paramEmoticonPackage)
  {
    boolean bool;
    String str1;
    label119:
    try
    {
      bool = paramBundle.getBoolean("newPkgAdd");
      str1 = paramEmoticonPackage.epId;
      try
      {
        str2 = afnu.bEy.replace("[epId]", str1);
        localObject = str2.replace("h5magic", "tmp_unzip");
        aqhq.W(paramString, (String)localObject, false);
        paramString = (String)localObject + "h5.zip";
        str3 = (String)localObject + "h5magic";
        if (new File(paramString).exists()) {
          break label119;
        }
        QLog.e("VasEmojiManager", 1, "h5.zip is not exist");
        bool = false;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          String str2;
          Object localObject;
          String str3;
          ArrayList localArrayList;
          afkz localafkz;
          QLog.e("VasEmojiManager", 1, "", paramString);
          bool = false;
        }
      }
      return bool;
    }
    finally {}
    aqhq.W(paramString, str3, false);
    localArrayList = new ArrayList();
    localafkz = new afkz();
    localObject = new File((String)localObject + str1 + "_android.json");
    paramString = null;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          break label631;
        }
        paramString = aqhq.fileToBytes((File)localObject);
        paramString = afkp.a(this.mApp, paramEmoticonPackage, afke.cRu, paramString, localArrayList, localafkz);
        if (paramString != null)
        {
          QLog.e("VasEmojiManager", 1, "parseJsonError: " + paramString);
          bool = false;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("VasEmojiManager", 1, "OutOfMemoryError e = " + paramString.getMessage());
        paramString = null;
        continue;
        if (paramEmoticonPackage.jobType != 5)
        {
          QLog.e("VasEmojiManager", 1, "not support jobType: " + paramEmoticonPackage.jobType);
          bool = false;
          break;
        }
        paramString = a();
        if ((!localafkz.bYL) && (paramEmoticonPackage.jobType != 4))
        {
          int i = 0;
          localafkz.bDO = null;
          if (QLog.isColorLevel()) {
            QLog.d("VasEmojiManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + i);
          }
          paramString.a(paramEmoticonPackage.epId, localArrayList, localafkz);
          int j = i + 1;
          if (!localafkz.bYL)
          {
            i = j;
            if (j < 3) {
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("VasEmojiManager", 2, "addEmoticonsTask| fetchEncryptKeys count=" + j + " encryptKeysSuccess=" + localafkz.bYL);
          }
          if (!localafkz.bYL)
          {
            QLog.e("VasEmojiManager", 1, "addEmoticonsTask| fetchEncryptKeys fail epId=" + paramEmoticonPackage.epId + " encryptGetKeySeq=" + localafkz.bDO + " encryptKeysResultCode" + localafkz.cRP);
            bool = false;
            break;
          }
        }
        paramString = a(str1, str2, str3, (File)localObject);
        if (paramString != null)
        {
          QLog.e("VasEmojiManager", 1, "moveFiles error: " + paramString);
          bool = false;
          break;
        }
        a(paramEmoticonPackage, localArrayList, bool, paramBundle);
        bool = true;
      }
      break;
      label631:
      paramString = null;
    }
  }
  
  public static void delete(String paramString)
  {
    paramString = kG(paramString);
    VasQuickUpdateEngine.safeDeleteFile(new File(afnu.bEq.replace("[epId]", paramString)));
  }
  
  public static String kA(String paramString)
  {
    paramString = kG(paramString);
    return afnu.bEx.replace("[epId]", paramString);
  }
  
  public static String kG(String paramString)
  {
    int i = "bqmall.android.h5magic.".length();
    return paramString.substring(i, paramString.indexOf('.', i));
  }
  
  public static void s(JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int i = paramJSONArray.length();
      for (;;)
      {
        if (i >= 0)
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.opt(i);
          if (localJSONObject != null) {}
          try
          {
            String str = localJSONObject.getString("id");
            afks localafks = new afks();
            localafks.bDM = localJSONObject.getString("leftText");
            localafks.bDN = localJSONObject.getString("linkText");
            localafks.type = localJSONObject.getString("type");
            localHashMap.put(str, localafks);
            i -= 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              QLog.e("VasEmojiManager", 1, "setMagicTips: ", localJSONException);
            }
          }
        }
      }
    }
    kr = localHashMap;
  }
  
  public afke a()
  {
    return this.c;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = "bqmall.android.h5magic." + paramEmoticonPackage.epId + ".zip";
    if (this.fl.contains(paramEmoticonPackage.epId)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    localBundle.putBoolean("newPkgAdd", paramBoolean1);
    localBundle.putBoolean("wifiAutoDownload", paramBoolean2);
    localBundle.putBoolean("isUpdate", afnu.a(paramEmoticonPackage));
    localBundle.putLong("vas_download_start", System.currentTimeMillis());
    this.fl.put(paramEmoticonPackage.epId, localBundle);
    a().fi.put(paramEmoticonPackage.epId, new aflh(paramEmoticonPackage.epId, null));
    ThreadManager.post(new VasEmojiManager.1(this, str, paramEmoticonPackage), 5, null, true);
  }
  
  public void ey(String paramString, int paramInt)
  {
    if (paramInt != 0) {
      QLog.e("VasEmojiManager", 1, "complete error: " + paramInt);
    }
    String str = kG(paramString);
    Object localObject1 = (Bundle)this.fl.remove(str);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = new Bundle();
      EmoticonPackage localEmoticonPackage = ((ajdg)this.mApp.getManager(14)).b(str);
      localObject1 = localEmoticonPackage;
      if (localEmoticonPackage == null)
      {
        localObject1 = new EmoticonPackage();
        ((EmoticonPackage)localObject1).name = acfp.m(2131716308);
        ((EmoticonPackage)localObject1).epId = str;
        ((EmoticonPackage)localObject1).jobType = 5;
        ((EmoticonPackage)localObject1).type = 1;
        ((EmoticonPackage)localObject1).aio = true;
        ((EmoticonPackage)localObject1).isMagicFaceDownloading = true;
      }
      ((Bundle)localObject2).putSerializable("emoticonPackage", (Serializable)localObject1);
      ((Bundle)localObject2).putBoolean("newPkgAdd", false);
      ((Bundle)localObject2).putBoolean("wifiAutoDownload", false);
      ((Bundle)localObject2).putBoolean("isUpdate", afnu.a((EmoticonPackage)localObject1));
      ((Bundle)localObject2).putLong("vas_download_start", System.currentTimeMillis());
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
      if ((paramInt != 0) || (!a(kA(paramString), (Bundle)localObject1, (EmoticonPackage)localObject2))) {
        afke.b.a((EmoticonPackage)localObject2, paramInt, 8, this.mApp);
      }
      a().fi.remove(str);
      return;
    }
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    paramString = kG(paramString);
    aflh localaflh = (aflh)a().fi.get(paramString);
    if (localaflh != null) {
      localaflh.setPercent((float)paramLong1 * 100.0F / (float)paramLong2);
    }
    paramString = (Bundle)this.fl.get(paramString);
    if (paramString != null)
    {
      paramString = (EmoticonPackage)paramString.getSerializable("emoticonPackage");
      afke.b.e(paramString, (int)paramLong1, (int)paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afli
 * JD-Core Version:    0.7.0.1
 */