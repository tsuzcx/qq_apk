package dov.com.qq.im.ptv;

import akrf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anlm;
import aqec;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import imm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LightVideoConfigMgr
{
  private static AtomicReference<LightVideoConfigMgr> m = new AtomicReference(null);
  private a a = new a();
  
  private static boolean D(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("lightBlackList");
    if (TextUtils.isEmpty(paramJSONObject)) {}
    for (;;)
    {
      return false;
      paramJSONObject = paramJSONObject.split("\\|");
      if (paramJSONObject.length > 0)
      {
        String str = Build.MODEL + ";" + Build.VERSION.SDK_INT;
        int j = paramJSONObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramJSONObject[i].equalsIgnoreCase(str)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private static String Ij()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_light_filter_cfg", 4).getString("video_light_content_key", "");
  }
  
  private static void QE(String paramString)
  {
    ThreadManager.post(new LightVideoConfigMgr.1(paramString), 5, null, true);
  }
  
  public static int RB()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_light_filter_cfg", 4).getInt("video_light_version_key", 0);
  }
  
  private static int a(JSONObject paramJSONObject, List<StrategyItem> paramList)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONArray("lightStrategy");
      if (paramJSONObject == null) {
        return 0;
      }
      j = paramJSONObject.length();
      if (j <= 0)
      {
        VideoEnvironment.k("LightVideoConfigMgr", "parseConfigData: arrayLength=" + j, null);
        return 0;
      }
    }
    catch (JSONException paramJSONObject)
    {
      int j;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoConfigMgr", 2, "parseConfigData[JSONException]", paramJSONObject);
      }
      paramList.clear();
      for (i = -100;; i = 0)
      {
        VideoEnvironment.k("LightVideoConfigMgr", "parseConfigData:errCode=" + i, null);
        return i;
        i = 0;
        while (i < j)
        {
          StrategyItem localStrategyItem = (StrategyItem)aqec.convertFrom(paramJSONObject.getJSONObject(i), StrategyItem.class);
          if (localStrategyItem == null)
          {
            VideoEnvironment.k("LightVideoConfigMgr", "parseConfigData:item=null i=" + i, null);
            paramList.clear();
            return -100;
          }
          paramList.add(localStrategyItem);
          i += 1;
        }
      }
    }
    catch (OutOfMemoryError paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoConfigMgr", 2, "parseConfigData[OutOfMemoryError]", paramJSONObject);
        }
        paramList.clear();
        int i = -100;
      }
    }
  }
  
  public static LightVideoConfigMgr a()
  {
    Object localObject;
    if (m.get() == null)
    {
      localObject = Ij();
      if ((localObject != null) && (!"".equals(localObject))) {
        break label52;
      }
      localObject = new LightVideoConfigMgr();
      m.getAndSet(localObject);
    }
    for (;;)
    {
      return (LightVideoConfigMgr)m.get();
      label52:
      adt((String)localObject);
    }
  }
  
  private static LightVideoConfigMgr a(String paramString)
  {
    int j = 450;
    int k = 20;
    LightVideoConfigMgr localLightVideoConfigMgr = new LightVideoConfigMgr();
    try
    {
      paramString = new JSONObject(paramString);
      localLightVideoConfigMgr.a.dxz = paramString.optBoolean("showLightEntry", false);
      localLightVideoConfigMgr.a.eJa = paramString.optInt("longClickEntry", 0);
      int n = paramString.optInt("lightDuration", 20);
      i = n;
      if (n > 5) {
        break label212;
      }
      i = 20;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("LightVideoConfigMgr", 2, "loadGeneralConfigMgr[JSONException]", paramString);
      return localLightVideoConfigMgr;
    }
    localLightVideoConfigMgr.a.eJb = i;
    k = paramString.optInt("lightBitrate", 450);
    int i = k;
    if (k >= 2000) {
      i = 450;
    }
    for (;;)
    {
      label115:
      localLightVideoConfigMgr.a.eJc = i;
      localLightVideoConfigMgr.a.dxA = false;
      if ((localLightVideoConfigMgr.a.dxz) && (!D(paramString)))
      {
        ArrayList localArrayList = new ArrayList(3);
        if (a(paramString, localArrayList) == 0) {
          localLightVideoConfigMgr.a.dxA = aE(localArrayList);
        }
      }
      return localLightVideoConfigMgr;
      label212:
      do
      {
        break label115;
        do
        {
          break;
        } while (i < 200);
        i = k;
        break;
      } while (i > 100);
      i = j;
    }
  }
  
  private static boolean a(StrategyItem paramStrategyItem)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = b(paramStrategyItem);
    String str = "" + paramStrategyItem.strategy;
    if (str.equalsIgnoreCase("<="))
    {
      if ((i > paramStrategyItem.sdk_int) || (!bool)) {}
    }
    else {
      while ((str.equalsIgnoreCase("=")) && (i == paramStrategyItem.sdk_int) && (bool)) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean aA(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("video_light_filter_cfg", 4).edit();
    localEditor.putString("video_light_content_key", paramString);
    localEditor.putInt("video_light_version_key", paramInt);
    return localEditor.commit();
  }
  
  private static boolean aE(List<StrategyItem> paramList)
  {
    if (paramList.size() <= 0) {
      return true;
    }
    String str = Build.MODEL;
    boolean bool2 = false;
    Object localObject = paramList.iterator();
    StrategyItem localStrategyItem;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localStrategyItem = (StrategyItem)((Iterator)localObject).next();
    } while ((localStrategyItem == null) || (!("" + localStrategyItem.model).equalsIgnoreCase("All")));
    boolean bool1 = a(localStrategyItem);
    if (bool1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (StrategyItem)paramList.next();
        if ((localObject != null) && (("" + ((StrategyItem)localObject).model).equalsIgnoreCase(str))) {
          return a((StrategyItem)localObject);
        }
      }
    }
    return bool1;
  }
  
  private static void adt(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      m.getAndSet(paramString);
    }
  }
  
  private static int ax(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoConfigMgr", 2, "updateLightVideoConfigContent|received save version: " + paramInt + ",config_content=" + paramString);
    }
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      int j = -101;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("LightVideoConfigMgr", 2, "updateLightVideoConfigContent| version=" + paramInt + ",config_content=" + paramString);
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        QE(paramString);
      }
      return i;
      boolean bool = aA(paramString, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoConfigMgr", 2, "updateLightVideoConfigContent| saveContentOK=" + bool);
      }
      if (bool) {
        i = 0;
      } else {
        i = -128;
      }
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int k = RB();
    int n = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoConfigMgr", 2, "handleLightFilterConfig|received remote version: " + n + " | localVersion: " + k);
    }
    if (n != k) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramConfig.msg_content_list.size() - 1);
        if (paramQQAppInterface != null) {
          if (paramQQAppInterface.compress.get() == 1)
          {
            paramQQAppInterface = akrf.inflateConfigString(paramQQAppInterface.content.get().toByteArray());
            if (paramQQAppInterface == null) {}
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new String(paramQQAppInterface, "UTF-8");
        i = ax(paramQQAppInterface, n);
        j = i;
        if (i != 0)
        {
          if (paramConfig.content_list.size() <= 0) {
            break label385;
          }
          i = ax((String)paramConfig.content_list.get(0), n);
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]| content_list has data,version: " + n + ",localVersion:" + k);
            j = i;
          }
        }
        return j;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]|Throwable:" + paramQQAppInterface.getMessage());
        }
        paramQQAppInterface = "";
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]|inflateConfigString error!");
      }
      paramQQAppInterface = "";
      continue;
      paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]| content==null");
      }
      int i = -125;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]| msg_content_list is empty ,version: " + n + ",localVersion:" + k);
      }
      i = -125;
      continue;
      label385:
      int j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]| content_list has no data,version: " + n + ",localVersion:" + k);
        return i;
        i = 0;
      }
    }
  }
  
  private static boolean b(StrategyItem paramStrategyItem)
  {
    if (paramStrategyItem.cpuKernel <= 0) {}
    while (imm.getNumCores() <= paramStrategyItem.cpuKernel) {
      return true;
    }
    return false;
  }
  
  public int RC()
  {
    return this.a.eJb;
  }
  
  public int RD()
  {
    return this.a.eJc;
  }
  
  public boolean aPY()
  {
    return (this.a.dxz) && (!anlm.ayn());
  }
  
  public boolean aPZ()
  {
    return this.a.eJa == 1;
  }
  
  public boolean aQa()
  {
    return this.a.dxA;
  }
  
  public static class StrategyItem
  {
    public int cpuKernel;
    public String model;
    public int sdk_int;
    public String strategy;
  }
  
  public static class a
  {
    public boolean dxA;
    public boolean dxz;
    public int eJa;
    public int eJb = 20;
    public int eJc = 500;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoConfigMgr
 * JD-Core Version:    0.7.0.1
 */