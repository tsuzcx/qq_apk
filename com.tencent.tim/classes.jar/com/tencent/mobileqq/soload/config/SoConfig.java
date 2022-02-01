package com.tencent.mobileqq.soload.config;

import aeic;
import android.text.TextUtils;
import anmb;
import anme;
import anmh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class SoConfig
  implements Serializable
{
  private static final byte[] cl = new byte[0];
  public int mLastAppId;
  public Map<String, SoInfo> mSoInfos = new HashMap();
  
  private static String Ae()
  {
    StringBuilder localStringBuilder = new StringBuilder(BaseApplicationImpl.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/QWallet/").append("/.config/");
    localStringBuilder.append("sl.config");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static SoConfig readConfig()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: invokestatic 72	com/tencent/mobileqq/soload/config/SoConfig:Ae	()Ljava/lang/String;
    //   7: astore 4
    //   9: aload 4
    //   11: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +92 -> 106
    //   17: aload_2
    //   18: astore_0
    //   19: getstatic 23	com/tencent/mobileqq/soload/config/SoConfig:cl	[B
    //   22: astore_3
    //   23: aload_2
    //   24: astore_0
    //   25: aload_3
    //   26: monitorenter
    //   27: aload 4
    //   29: invokestatic 88	aagd:o	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast 2	com/tencent/mobileqq/soload/config/SoConfig
    //   35: astore_0
    //   36: aload_3
    //   37: monitorexit
    //   38: aload_0
    //   39: astore_1
    //   40: aload_0
    //   41: ifnonnull +11 -> 52
    //   44: new 2	com/tencent/mobileqq/soload/config/SoConfig
    //   47: dup
    //   48: invokespecial 89	com/tencent/mobileqq/soload/config/SoConfig:<init>	()V
    //   51: astore_1
    //   52: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +28 -> 83
    //   58: ldc 97
    //   60: iconst_2
    //   61: new 36	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   68: ldc 100
    //   70: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_1
    //   84: areturn
    //   85: astore_2
    //   86: aload_1
    //   87: astore_0
    //   88: aload_0
    //   89: astore_1
    //   90: aload_3
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   99: goto -61 -> 38
    //   102: astore_2
    //   103: goto -15 -> 88
    //   106: aconst_null
    //   107: astore_0
    //   108: goto -70 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	90	0	localObject1	Object
    //   3	87	1	localObject2	Object
    //   94	2	1	localException	java.lang.Exception
    //   1	23	2	localObject3	Object
    //   85	8	2	localObject4	Object
    //   102	1	2	localObject5	Object
    //   22	69	3	arrayOfByte	byte[]
    //   7	21	4	str	String
    // Exception table:
    //   from	to	target	type
    //   27	36	85	finally
    //   90	92	85	finally
    //   19	23	94	java/lang/Exception
    //   25	27	94	java/lang/Exception
    //   92	94	94	java/lang/Exception
    //   36	38	102	finally
  }
  
  public boolean isValid(String paramString)
  {
    return (this.mLastAppId == AppSetting.getAppId()) && (this.mSoInfos != null) && (this.mSoInfos.size() > 0) && (this.mSoInfos.get(paramString) != null);
  }
  
  public void saveConfig()
  {
    ThreadManager.getFileThreadHandler().post(new SoConfig.2(this));
  }
  
  public String toString()
  {
    return "SoConfig{mSoInfos=" + this.mSoInfos + '}';
  }
  
  public void update(anmh paramanmh)
  {
    HashMap localHashMap = new HashMap();
    if ((paramanmh != null) && (paramanmh.a != null))
    {
      try
      {
        localObject = new LinkedList(Arrays.asList(paramanmh.a));
        Collections.sort((List)localObject, new anme(this));
        paramanmh = (anmh)localObject;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          SoInfo localSoInfo1;
          try
          {
            Object localObject;
            JSONArray localJSONArray = new JSONObject(((aeic)localObject).content).optJSONArray("so_info_list");
            if (localJSONArray == null) {
              continue;
            }
            int i = 0;
            if (i >= localJSONArray.length()) {
              continue;
            }
            localSoInfo1 = SoInfo.create(localJSONArray.optJSONObject(i));
            if (localSoInfo1 != null)
            {
              if (!localHashMap.containsKey(localSoInfo1.name)) {
                break label296;
              }
              localSoInfo2 = (SoInfo)localHashMap.get(localSoInfo1.name);
              if (localSoInfo2 == null) {
                localHashMap.put(localSoInfo1.name, localSoInfo1);
              }
            }
            else
            {
              i += 1;
              continue;
              localThrowable1 = localThrowable1;
              paramanmh = new LinkedList(Arrays.asList(paramanmh.a));
              continue;
            }
            SoInfo localSoInfo2 = localSoInfo2.merge(localSoInfo1);
            localHashMap.put(localSoInfo1.name, localSoInfo2);
            continue;
          }
          catch (Throwable localThrowable2)
          {
            QLog.e("SoLoadWidget.SoConfig", 1, localThrowable2, new Object[0]);
            VACDReportUtil.a(null, "SoLoadModule", "SoLoadSingle", "Exception", localThrowable1.taskId + "", 1, localThrowable2.getMessage());
          }
          localHashMap.put(localSoInfo1.name, localSoInfo1);
        }
      }
      paramanmh = paramanmh.iterator();
      do
      {
        if (!paramanmh.hasNext()) {
          break;
        }
        localObject = (aeic)paramanmh.next();
      } while (TextUtils.isEmpty(((aeic)localObject).content));
    }
    label296:
    this.mSoInfos = localHashMap;
    this.mLastAppId = AppSetting.getAppId();
    saveConfig();
  }
  
  public static class SoDetailInfo
    implements Serializable
  {
    public long crc = -1L;
    public String md5;
    public String url;
    public String ver;
    
    public static SoDetailInfo create(JSONObject paramJSONObject, String paramString)
    {
      if (paramJSONObject == null) {}
      String str1;
      String str2;
      do
      {
        return null;
        str1 = paramJSONObject.optString("url");
        str2 = paramJSONObject.optString("md5");
      } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
      long l = paramJSONObject.optLong("so_crc", -1L);
      paramJSONObject = new SoDetailInfo();
      paramJSONObject.md5 = str2;
      paramJSONObject.url = str1;
      paramJSONObject.ver = paramString;
      paramJSONObject.crc = l;
      return paramJSONObject;
    }
    
    public String toString()
    {
      return "SDInfo{url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", v='" + this.ver + '\'' + ", c='" + this.crc + '}';
    }
  }
  
  public static class SoInfo
    implements Serializable
  {
    public SoConfig.SoDetailInfo arm32Info;
    public SoConfig.SoDetailInfo arm64Info;
    public String name;
    public String ver;
    
    private static int compareVersion(String paramString1, String paramString2)
    {
      for (;;)
      {
        int j;
        int i;
        int k;
        try
        {
          if (TextUtils.equals(paramString1, paramString2)) {
            return 0;
          }
          paramString1 = paramString1.split("\\.");
          paramString2 = paramString2.split("\\.");
          int m = Math.min(paramString1.length, paramString2.length);
          j = 0;
          i = 0;
          k = j;
          if (i >= m) {
            break label137;
          }
          j = safeParseInt(paramString1[i]) - safeParseInt(paramString2[i]);
          k = j;
          if (j != 0) {
            break label137;
          }
          i += 1;
          continue;
          j = i;
          if (k < paramString1.length)
          {
            if (safeParseInt(paramString1[k]) > 0) {
              break label135;
            }
            k += 1;
            continue;
          }
          if (j < paramString2.length)
          {
            i = safeParseInt(paramString2[j]);
            if (i <= 0) {
              break label148;
            }
            return -1;
          }
          return 0;
        }
        catch (Throwable paramString1)
        {
          paramString1.printStackTrace();
        }
        if (k <= 0) {
          return -1;
        }
        label135:
        return 1;
        label137:
        if (k == 0)
        {
          k = i;
          continue;
          label148:
          j += 1;
        }
      }
    }
    
    public static SoInfo create(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {}
      String str1;
      String str2;
      SoConfig.SoDetailInfo localSoDetailInfo;
      do
      {
        return null;
        str1 = paramJSONObject.optString("name");
        str2 = paramJSONObject.optString("ver", "0.0.0");
        localSoDetailInfo = SoConfig.SoDetailInfo.create(paramJSONObject.optJSONObject("arm32"), str2);
        paramJSONObject = SoConfig.SoDetailInfo.create(paramJSONObject.optJSONObject("arm64"), str2);
      } while ((TextUtils.isEmpty(str1)) || ((localSoDetailInfo == null) && (paramJSONObject == null)));
      SoInfo localSoInfo = new SoInfo();
      localSoInfo.name = str1;
      localSoInfo.ver = str2;
      localSoInfo.arm32Info = localSoDetailInfo;
      localSoInfo.arm64Info = paramJSONObject;
      return localSoInfo;
    }
    
    public static int getReportCode(SoInfo paramSoInfo)
    {
      if (paramSoInfo == null) {}
      do
      {
        do
        {
          return 1;
          if (!anmb.is64Bit()) {
            break;
          }
        } while (paramSoInfo.arm64Info == null);
        return 0;
      } while (paramSoInfo.arm32Info == null);
      return 0;
    }
    
    private static int safeParseInt(String paramString)
    {
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      return 0;
    }
    
    public SoInfo merge(SoInfo paramSoInfo)
    {
      if (paramSoInfo == null) {}
      do
      {
        do
        {
          int i;
          do
          {
            return this;
            i = compareVersion(this.ver, paramSoInfo.ver);
          } while (i > 0);
          if (i < 0) {
            return paramSoInfo;
          }
        } while ((this.arm32Info != null) && (this.arm64Info != null));
        if ((paramSoInfo.arm32Info != null) && (paramSoInfo.arm64Info != null)) {
          return paramSoInfo;
        }
        if ((this.arm32Info == null) && (paramSoInfo.arm32Info != null)) {
          this.arm32Info = paramSoInfo.arm32Info;
        }
      } while ((this.arm64Info != null) || (paramSoInfo.arm64Info == null));
      this.arm64Info = paramSoInfo.arm64Info;
      return this;
    }
    
    public String toString()
    {
      return "SoInfo{name='" + this.name + '\'' + ", arm32Info=" + this.arm32Info + ", arm64Info=" + this.arm64Info + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.soload.config.SoConfig
 * JD-Core Version:    0.7.0.1
 */