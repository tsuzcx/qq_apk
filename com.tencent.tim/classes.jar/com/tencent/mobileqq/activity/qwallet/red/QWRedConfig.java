package com.tencent.mobileqq.activity.qwallet.red;

import aadk.a;
import aagd;
import aagi;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QWRedConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private transient String mCurUin;
  private transient byte[] mSaveLock;
  private transient String mSavePath;
  public List<PathInfo> pathInfos = new LinkedList();
  public long version;
  
  private void D(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.mSavePath = paramString;
    this.mCurUin = paramQQAppInterface.getCurrentAccountUin();
    this.mSaveLock = new byte[0];
  }
  
  private PathInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.pathInfos.iterator();
    while (localIterator.hasNext())
    {
      PathInfo localPathInfo = (PathInfo)localIterator.next();
      if ((localPathInfo.isMatchPath(paramString)) && (localPathInfo.isShow())) {
        return localPathInfo;
      }
    }
    return null;
  }
  
  private static String getConfigPath(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = new StringBuilder(aagi.bcS).append(paramAppRuntime.getAccount()).append("/.config/");
    paramAppRuntime.append(".redConfig");
    return paramAppRuntime.toString();
  }
  
  public static List<PathInfo> parseConfigToPathInfos(String paramString)
  {
    localLinkedList = new LinkedList();
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("list");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          PathInfo localPathInfo = PathInfo.parseToPathInfo(paramString.optJSONObject(i));
          if (localPathInfo != null) {
            localLinkedList.add(localPathInfo);
          }
          i += 1;
        }
      }
      return localLinkedList;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static QWRedConfig readConfig(QQAppInterface paramQQAppInterface)
  {
    String str = getConfigPath(paramQQAppInterface);
    try
    {
      QWRedConfig localQWRedConfig1 = (QWRedConfig)aagd.o(str);
      QWRedConfig localQWRedConfig2 = localQWRedConfig1;
      if (localQWRedConfig1 == null) {
        localQWRedConfig2 = new QWRedConfig();
      }
      localQWRedConfig2.D(paramQQAppInterface, str);
      if (QLog.isColorLevel()) {
        QLog.d("RedConfig", 2, "readQWRedConfig:" + localQWRedConfig2);
      }
      return localQWRedConfig2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public List<RedInfo> getCurShowRedInfosByPath(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (paramString.redInfos == null)) {
      return new LinkedList();
    }
    return paramString.getCurShowRedInfos();
  }
  
  public String getNotShowListStr()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator1 = this.pathInfos.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((PathInfo)localIterator1.next()).redInfos.iterator();
      while (localIterator2.hasNext())
      {
        RedInfo localRedInfo = (RedInfo)localIterator2.next();
        if (localRedInfo.isShow == 0) {
          localLinkedList.add(localRedInfo);
        }
      }
    }
    return RedInfo.transToReportStr(localLinkedList);
  }
  
  public aadk.a getShowInfoByPath(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.getShowInfo();
    }
    return new aadk.a(false, false, "", "");
  }
  
  /* Error */
  public void parseConfig(com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +17 -> 20
    //   6: ldc 217
    //   8: aload_1
    //   9: getfield 222	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:module	Ljava/lang/String;
    //   12: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +55 -> 81
    //   29: ldc 170
    //   31: iconst_2
    //   32: new 88	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   39: ldc 229
    //   41: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: getfield 231	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:version	J
    //   48: invokevirtual 234	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   51: ldc 236
    //   53: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 237	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:version	J
    //   60: invokevirtual 234	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: ldc 236
    //   65: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: getfield 240	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:configStr	Ljava/lang/String;
    //   72: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_1
    //   82: getfield 231	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:version	J
    //   85: aload_0
    //   86: getfield 237	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:version	J
    //   89: lcmp
    //   90: ifle -70 -> 20
    //   93: aload_0
    //   94: aload_1
    //   95: getfield 240	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:configStr	Ljava/lang/String;
    //   98: invokestatic 242	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:parseConfigToPathInfos	(Ljava/lang/String;)Ljava/util/List;
    //   101: putfield 34	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:pathInfos	Ljava/util/List;
    //   104: aload_0
    //   105: aload_1
    //   106: getfield 231	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig$a:version	J
    //   109: putfield 237	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:version	J
    //   112: aload_0
    //   113: invokevirtual 245	com/tencent/mobileqq/activity/qwallet/red/QWRedConfig:saveConfig	()V
    //   116: goto -96 -> 20
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	QWRedConfig
    //   0	124	1	parama	com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.a
    //   15	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	16	119	finally
    //   23	81	119	finally
    //   81	116	119	finally
  }
  
  public void saveConfig()
  {
    ThreadManager.getFileThreadHandler().post(new QWRedConfig.1(this));
  }
  
  public String toString()
  {
    return "QWRedConfig{pathInfos=" + this.pathInfos + ", version=" + this.version + '}';
  }
  
  public static class PathInfo
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public String path;
    public List<QWRedConfig.RedInfo> redInfos = new LinkedList();
    
    public static PathInfo parseToPathInfo(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {}
      for (;;)
      {
        return null;
        try
        {
          String str = paramJSONObject.optString("path");
          if (!TextUtils.isEmpty(str))
          {
            PathInfo localPathInfo = new PathInfo();
            localPathInfo.path = str;
            paramJSONObject = paramJSONObject.optJSONArray("infos");
            if (paramJSONObject != null)
            {
              int i = 0;
              while (i < paramJSONObject.length())
              {
                QWRedConfig.RedInfo localRedInfo = QWRedConfig.RedInfo.parseToRedInfo(paramJSONObject.optJSONObject(i), str);
                if (localRedInfo != null) {
                  localPathInfo.redInfos.add(localRedInfo);
                }
                i += 1;
              }
            }
            return localPathInfo;
          }
        }
        catch (Throwable paramJSONObject)
        {
          paramJSONObject.printStackTrace();
        }
      }
      return null;
    }
    
    public List<QWRedConfig.RedInfo> getCurShowRedInfos()
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.redInfos.iterator();
      int j = 0;
      int i = 0;
      QWRedConfig.RedInfo localRedInfo;
      if (localIterator.hasNext())
      {
        localRedInfo = (QWRedConfig.RedInfo)localIterator.next();
        if (!localRedInfo.isShow()) {
          break label132;
        }
        if ((localRedInfo.showPos != 2) || (i != 0)) {
          break label92;
        }
        localLinkedList.add(localRedInfo);
        i = j;
        j = 1;
      }
      for (;;)
      {
        if ((j != 0) && (i != 0))
        {
          return localLinkedList;
          label92:
          if ((localRedInfo.showPos == 0) && (j == 0))
          {
            localLinkedList.add(localRedInfo);
            k = 1;
            j = i;
            i = k;
          }
        }
        else
        {
          k = j;
          j = i;
          i = k;
          break;
        }
        label132:
        int k = i;
        i = j;
        j = k;
      }
    }
    
    public aadk.a getShowInfo()
    {
      Iterator localIterator = this.redInfos.iterator();
      boolean bool2 = false;
      boolean bool1 = false;
      Object localObject1 = "";
      Object localObject2 = "";
      Object localObject3;
      if (localIterator.hasNext())
      {
        localObject3 = (QWRedConfig.RedInfo)localIterator.next();
        if (((QWRedConfig.RedInfo)localObject3).isShow()) {
          if (((QWRedConfig.RedInfo)localObject3).type == 0)
          {
            if (bool1) {
              break label162;
            }
            localObject3 = ((QWRedConfig.RedInfo)localObject3).buffer;
            bool1 = bool2;
            bool2 = true;
            localObject2 = localObject1;
            localObject1 = localObject3;
            label84:
            if ((!bool2) || (!bool1)) {
              break label141;
            }
          }
        }
      }
      for (;;)
      {
        return new aadk.a(bool2, bool1, (String)localObject2, (String)localObject1);
        if ((((QWRedConfig.RedInfo)localObject3).type == 3) && (!bool2))
        {
          localObject3 = ((QWRedConfig.RedInfo)localObject3).content;
          localObject1 = localObject2;
          bool2 = bool1;
          localObject2 = localObject3;
          bool1 = true;
          break label84;
          label141:
          bool3 = bool2;
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          bool2 = bool1;
          bool1 = bool3;
          break;
        }
        label162:
        localObject3 = localObject1;
        boolean bool3 = bool1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        bool1 = bool2;
        bool2 = bool3;
        break label84;
        localObject3 = localObject1;
        bool3 = bool1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        bool1 = bool2;
        bool2 = bool3;
      }
    }
    
    public boolean isMatchPath(String paramString)
    {
      return (this.path.equals(paramString)) || (this.path.endsWith("." + paramString));
    }
    
    public boolean isShow()
    {
      Iterator localIterator = this.redInfos.iterator();
      while (localIterator.hasNext()) {
        if (((QWRedConfig.RedInfo)localIterator.next()).isShow()) {
          return true;
        }
      }
      return false;
    }
    
    public String toString()
    {
      return "PathInfo{path='" + this.path + '\'' + ", redInfos=" + this.redInfos + '}';
    }
  }
  
  public static class RedInfo
    implements Serializable
  {
    public static final int GONE_TYPE_ALWAYS = 1;
    public static final int GONE_TYPE_CLICK = 0;
    public static final int IMG_TYPE_DOWNLOAD_URL = 0;
    public static final int IS_SHOW_NO = 0;
    public static final int IS_SHOW_YES = 1;
    public static final int SHOW_POS_LEFT_BOTTOM = 3;
    public static final int SHOW_POS_LEFT_TOP = 2;
    public static final int SHOW_POS_RIGHT_BOTTOM = 1;
    public static final int SHOW_POS_RIGHT_TOP = 0;
    public static final int TASK_ID_DEFAULT = -1;
    public static final int TYPE_IMG = 3;
    public static final int TYPE_NUM = 1;
    public static final int TYPE_RED = 0;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_WORD = 2;
    private static final long serialVersionUID = 1L;
    public long beginTime;
    public String buffer;
    public String content;
    public long endTime;
    public int goneType;
    public int imgType;
    public int isShow;
    public String path;
    public int showPos;
    public long taskId;
    public int type;
    
    private void ctO()
    {
      this.isShow = 0;
    }
    
    public static RedInfo parseToRedInfo(JSONObject paramJSONObject, String paramString)
    {
      if (paramJSONObject == null) {
        return null;
      }
      try
      {
        RedInfo localRedInfo = new RedInfo();
        localRedInfo.path = paramString;
        localRedInfo.taskId = paramJSONObject.optLong("taskId", -1L);
        localRedInfo.isShow = paramJSONObject.optInt("isShow", 0);
        localRedInfo.type = paramJSONObject.optInt("type", -1);
        localRedInfo.content = paramJSONObject.optString("content");
        localRedInfo.imgType = paramJSONObject.optInt("imgType", 0);
        localRedInfo.goneType = paramJSONObject.optInt("goneType", 0);
        localRedInfo.showPos = paramJSONObject.optInt("showPos", 0);
        localRedInfo.beginTime = aagd.W(paramJSONObject.optString("beginTime"));
        localRedInfo.endTime = aagd.W(paramJSONObject.optString("endTime"));
        if (localRedInfo.endTime == -1L) {}
        for (long l = 9223372036854775807L;; l = localRedInfo.endTime)
        {
          localRedInfo.endTime = l;
          localRedInfo.buffer = paramJSONObject.optString("buf");
          return localRedInfo;
        }
        return null;
      }
      catch (Throwable paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    
    public static String transToReportStr(List<RedInfo> paramList)
    {
      JSONArray localJSONArray;
      try
      {
        localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          RedInfo localRedInfo = (RedInfo)paramList.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("path", localRedInfo.path);
          localJSONObject.put("taskId", localRedInfo.taskId);
          localJSONObject.put("isShow", localRedInfo.isShow);
          localJSONArray.put(localJSONObject);
        }
        if (localJSONArray.length() <= 0) {
          break label121;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return null;
      }
      paramList = new JSONObject();
      paramList.put("list", localJSONArray);
      paramList = paramList.toString();
      return paramList;
      label121:
      return null;
    }
    
    public boolean doClick()
    {
      if (this.goneType == 0)
      {
        ctO();
        return true;
      }
      return false;
    }
    
    public boolean isShow()
    {
      if (this.isShow == 0) {}
      long l;
      do
      {
        do
        {
          return false;
        } while (((this.type != 0) && (this.type != 3)) || ((this.type == 0) && (this.showPos != 0)) || ((this.type == 3) && (this.showPos != 2)) || ((this.type == 3) && (this.imgType != 0)) || ((this.type == 3) && (this.imgType == 0) && (TextUtils.isEmpty(this.content))));
        l = NetConnInfoCenter.getServerTimeMillis();
      } while ((l < this.beginTime) || (l > this.endTime));
      return true;
    }
    
    public String toString()
    {
      return "RedInfo{path='" + this.path + '\'' + ", taskId=" + this.taskId + ", isShow=" + this.isShow + ", type=" + this.type + ", content='" + this.content + '\'' + ", imgType=" + this.imgType + ", goneType=" + this.goneType + ", showPos=" + this.showPos + ", beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", buffer='" + this.buffer + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.red.QWRedConfig
 * JD-Core Version:    0.7.0.1
 */