package com.qzone.download.strategy;

import android.text.TextUtils;
import com.qzone.common.IPInfo;
import com.qzone.common.logging.QDLog;
import com.qzone.download.NetworkManager;
import com.qzone.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

public class IPConfigStrategy
{
  private static final String TAG = "IPConfigStrategy";
  private ReadWriteLock RW_Lock = new ReentrantReadWriteLock();
  private Map<String, Pattern> dominPatterns = new HashMap();
  private int mDefaultIsp = -1;
  private Map<String, Map<Integer, IPConfig>> mIPConfigs = new HashMap();
  
  private String getDominKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return null;
        localIterator = this.mIPConfigs.entrySet().iterator();
      }
      str = (String)((Map.Entry)localIterator.next()).getKey();
    } while (!Utils.match((Pattern)this.dominPatterns.get(str), paramString));
    return str;
  }
  
  public void clear()
  {
    this.mIPConfigs.clear();
    this.dominPatterns.clear();
  }
  
  /* Error */
  public void initConfig(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: ldc 11
    //   10: new 97	java/lang/StringBuilder
    //   13: dup
    //   14: ldc 99
    //   16: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 108
    //   25: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_2
    //   29: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 121	com/qzone/common/logging/QDLog:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: iload_2
    //   39: ifne +7 -> 46
    //   42: aload_0
    //   43: invokevirtual 122	com/qzone/download/strategy/IPConfigStrategy:clear	()V
    //   46: aload_0
    //   47: getfield 29	com/qzone/download/strategy/IPConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   50: invokeinterface 128 1 0
    //   55: invokeinterface 133 1 0
    //   60: new 135	org/json/JSONObject
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 136	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   68: astore 7
    //   70: aload 7
    //   72: ifnull +30 -> 102
    //   75: aload 7
    //   77: invokevirtual 140	org/json/JSONObject:names	()Lorg/json/JSONArray;
    //   80: astore 8
    //   82: aload 8
    //   84: ifnull +18 -> 102
    //   87: iconst_0
    //   88: istore_3
    //   89: aload 8
    //   91: invokevirtual 146	org/json/JSONArray:length	()I
    //   94: istore 4
    //   96: iload_3
    //   97: iload 4
    //   99: if_icmplt +18 -> 117
    //   102: aload_0
    //   103: getfield 29	com/qzone/download/strategy/IPConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   106: invokeinterface 128 1 0
    //   111: invokeinterface 149 1 0
    //   116: return
    //   117: aload 8
    //   119: iload_3
    //   120: invokevirtual 153	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   123: astore 9
    //   125: new 31	java/util/HashMap
    //   128: dup
    //   129: invokespecial 32	java/util/HashMap:<init>	()V
    //   132: astore 10
    //   134: aload 7
    //   136: aload 8
    //   138: iload_3
    //   139: invokevirtual 153	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   142: invokevirtual 157	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   145: astore 11
    //   147: aload 11
    //   149: ifnull +16 -> 165
    //   152: iconst_0
    //   153: istore 4
    //   155: iload 4
    //   157: aload 11
    //   159: invokevirtual 146	org/json/JSONArray:length	()I
    //   162: if_icmplt +63 -> 225
    //   165: aload_0
    //   166: getfield 34	com/qzone/download/strategy/IPConfigStrategy:mIPConfigs	Ljava/util/Map;
    //   169: aload 9
    //   171: invokeinterface 80 2 0
    //   176: checkcast 49	java/util/Map
    //   179: astore_1
    //   180: aload_1
    //   181: ifnonnull +156 -> 337
    //   184: aload_0
    //   185: getfield 34	com/qzone/download/strategy/IPConfigStrategy:mIPConfigs	Ljava/util/Map;
    //   188: aload 9
    //   190: aload 10
    //   192: invokeinterface 161 3 0
    //   197: pop
    //   198: aload 9
    //   200: iconst_2
    //   201: invokestatic 165	java/util/regex/Pattern:compile	(Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   204: astore_1
    //   205: aload_0
    //   206: getfield 36	com/qzone/download/strategy/IPConfigStrategy:dominPatterns	Ljava/util/Map;
    //   209: aload 9
    //   211: aload_1
    //   212: invokeinterface 161 3 0
    //   217: pop
    //   218: iload_3
    //   219: iconst_1
    //   220: iadd
    //   221: istore_3
    //   222: goto -133 -> 89
    //   225: aload 11
    //   227: iload 4
    //   229: invokevirtual 169	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   232: astore 6
    //   234: aload 6
    //   236: ldc 171
    //   238: invokevirtual 173	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: astore_1
    //   242: aload 6
    //   244: ldc 175
    //   246: invokevirtual 179	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   249: istore 5
    //   251: aload 6
    //   253: ldc 181
    //   255: invokevirtual 179	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   258: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: astore 12
    //   263: new 189	com/qzone/common/IPInfo
    //   266: dup
    //   267: aload_1
    //   268: iload 5
    //   270: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: invokevirtual 192	java/lang/Integer:intValue	()I
    //   276: invokespecial 195	com/qzone/common/IPInfo:<init>	(Ljava/lang/String;I)V
    //   279: astore 13
    //   281: aload 10
    //   283: aload 12
    //   285: invokeinterface 80 2 0
    //   290: checkcast 6	com/qzone/download/strategy/IPConfigStrategy$IPConfig
    //   293: astore 6
    //   295: aload 6
    //   297: astore_1
    //   298: aload 6
    //   300: ifnonnull +22 -> 322
    //   303: new 6	com/qzone/download/strategy/IPConfigStrategy$IPConfig
    //   306: dup
    //   307: invokespecial 196	com/qzone/download/strategy/IPConfigStrategy$IPConfig:<init>	()V
    //   310: astore_1
    //   311: aload 10
    //   313: aload 12
    //   315: aload_1
    //   316: invokeinterface 161 3 0
    //   321: pop
    //   322: aload_1
    //   323: aload 13
    //   325: invokevirtual 200	com/qzone/download/strategy/IPConfigStrategy$IPConfig:appendIP	(Lcom/qzone/common/IPInfo;)V
    //   328: iload 4
    //   330: iconst_1
    //   331: iadd
    //   332: istore 4
    //   334: goto -179 -> 155
    //   337: aload_1
    //   338: aload 10
    //   340: invokeinterface 204 2 0
    //   345: goto -147 -> 198
    //   348: astore_1
    //   349: ldc 11
    //   351: ldc 206
    //   353: aload_1
    //   354: invokestatic 210	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   357: aload_0
    //   358: getfield 29	com/qzone/download/strategy/IPConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   361: invokeinterface 128 1 0
    //   366: invokeinterface 149 1 0
    //   371: return
    //   372: astore_1
    //   373: aload_0
    //   374: getfield 29	com/qzone/download/strategy/IPConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   377: invokeinterface 128 1 0
    //   382: invokeinterface 149 1 0
    //   387: aload_1
    //   388: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	IPConfigStrategy
    //   0	389	1	paramString	String
    //   0	389	2	paramBoolean	boolean
    //   88	134	3	i	int
    //   94	239	4	j	int
    //   249	20	5	k	int
    //   232	67	6	localObject	Object
    //   68	67	7	localJSONObject	org.json.JSONObject
    //   80	57	8	localJSONArray1	org.json.JSONArray
    //   123	87	9	str	String
    //   132	207	10	localHashMap	HashMap
    //   145	81	11	localJSONArray2	org.json.JSONArray
    //   261	53	12	localInteger	Integer
    //   279	45	13	localIPInfo	IPInfo
    // Exception table:
    //   from	to	target	type
    //   60	70	348	java/lang/Throwable
    //   75	82	348	java/lang/Throwable
    //   89	96	348	java/lang/Throwable
    //   117	147	348	java/lang/Throwable
    //   155	165	348	java/lang/Throwable
    //   165	180	348	java/lang/Throwable
    //   184	198	348	java/lang/Throwable
    //   198	218	348	java/lang/Throwable
    //   225	295	348	java/lang/Throwable
    //   303	322	348	java/lang/Throwable
    //   322	328	348	java/lang/Throwable
    //   337	345	348	java/lang/Throwable
    //   60	70	372	finally
    //   75	82	372	finally
    //   89	96	372	finally
    //   117	147	372	finally
    //   155	165	372	finally
    //   165	180	372	finally
    //   184	198	372	finally
    //   198	218	372	finally
    //   225	295	372	finally
    //   303	322	372	finally
    //   322	328	372	finally
    //   337	345	372	finally
    //   349	357	372	finally
  }
  
  /* Error */
  public boolean isIPValid(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: iconst_0
    //   17: istore 5
    //   19: invokestatic 217	com/qzone/download/NetworkManager:getIspType	()I
    //   22: istore_3
    //   23: aload_0
    //   24: getfield 29	com/qzone/download/strategy/IPConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   27: invokeinterface 220 1 0
    //   32: invokeinterface 133 1 0
    //   37: iload 5
    //   39: istore 4
    //   41: aload_2
    //   42: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +104 -> 149
    //   48: aload_0
    //   49: aload_2
    //   50: invokespecial 222	com/qzone/download/strategy/IPConfigStrategy:getDominKey	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore_2
    //   54: iload 5
    //   56: istore 4
    //   58: aload_2
    //   59: ifnull +90 -> 149
    //   62: iload 5
    //   64: istore 4
    //   66: aload_0
    //   67: getfield 34	com/qzone/download/strategy/IPConfigStrategy:mIPConfigs	Ljava/util/Map;
    //   70: aload_2
    //   71: invokeinterface 226 2 0
    //   76: ifeq +73 -> 149
    //   79: aload_0
    //   80: getfield 34	com/qzone/download/strategy/IPConfigStrategy:mIPConfigs	Ljava/util/Map;
    //   83: aload_2
    //   84: invokeinterface 80 2 0
    //   89: checkcast 49	java/util/Map
    //   92: iload_3
    //   93: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: invokeinterface 80 2 0
    //   101: checkcast 6	com/qzone/download/strategy/IPConfigStrategy$IPConfig
    //   104: astore_2
    //   105: iload 5
    //   107: istore 4
    //   109: aload_2
    //   110: ifnull +39 -> 149
    //   113: iload 5
    //   115: istore 4
    //   117: aload_2
    //   118: getfield 230	com/qzone/download/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   121: ifnull +28 -> 149
    //   124: aload_2
    //   125: getfield 230	com/qzone/download/strategy/IPConfigStrategy$IPConfig:ipInfos	Ljava/util/ArrayList;
    //   128: invokevirtual 233	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   131: astore_2
    //   132: aload_2
    //   133: invokeinterface 65 1 0
    //   138: istore 4
    //   140: iload 4
    //   142: ifne +24 -> 166
    //   145: iload 5
    //   147: istore 4
    //   149: aload_0
    //   150: getfield 29	com/qzone/download/strategy/IPConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   153: invokeinterface 220 1 0
    //   158: invokeinterface 149 1 0
    //   163: iload 4
    //   165: ireturn
    //   166: aload_1
    //   167: aload_2
    //   168: invokeinterface 69 1 0
    //   173: checkcast 189	com/qzone/common/IPInfo
    //   176: getfield 235	com/qzone/common/IPInfo:ip	Ljava/lang/String;
    //   179: invokevirtual 238	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: istore 4
    //   184: iload 4
    //   186: ifeq -54 -> 132
    //   189: iconst_1
    //   190: istore 4
    //   192: goto -43 -> 149
    //   195: astore_1
    //   196: ldc 11
    //   198: ldc 206
    //   200: aload_1
    //   201: invokestatic 241	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   204: aload_0
    //   205: getfield 29	com/qzone/download/strategy/IPConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   208: invokeinterface 220 1 0
    //   213: invokeinterface 149 1 0
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 29	com/qzone/download/strategy/IPConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   225: invokeinterface 220 1 0
    //   230: invokeinterface 149 1 0
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	IPConfigStrategy
    //   0	237	1	paramString1	String
    //   0	237	2	paramString2	String
    //   22	71	3	i	int
    //   39	152	4	bool1	boolean
    //   17	129	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   41	54	195	java/lang/Throwable
    //   66	105	195	java/lang/Throwable
    //   117	132	195	java/lang/Throwable
    //   132	140	195	java/lang/Throwable
    //   166	184	195	java/lang/Throwable
    //   41	54	220	finally
    //   66	105	220	finally
    //   117	132	220	finally
    //   132	140	220	finally
    //   166	184	220	finally
    //   196	204	220	finally
  }
  
  public void onDownloadResult(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBoolean) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    int i = NetworkManager.getIspType();
    this.RW_Lock.writeLock().lock();
    try
    {
      paramString1 = getDominKey(Utils.getDomin(paramString1));
      if (this.mIPConfigs.containsKey(paramString1))
      {
        paramString1 = (IPConfig)((Map)this.mIPConfigs.get(paramString1)).get(Integer.valueOf(i));
        if ((paramString1 != null) && (paramString1.ipInfos != null))
        {
          if (paramString1.getCurrFailCount() < 0) {
            paramString1.initFailCount(paramString2);
          }
          if (paramString2.equals(((IPInfo)paramString1.ipInfos.get(paramString1.getFailCount() % paramString1.ipInfos.size())).ip)) {
            paramString1.setFailCount(paramString1.getFailCount() + 1);
          }
        }
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QDLog.i("IPConfigStrategy", "", paramString1);
      return;
    }
    finally
    {
      this.RW_Lock.writeLock().unlock();
    }
  }
  
  public String resolve(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject2 = null;
    int i = NetworkManager.getIspType();
    this.RW_Lock.readLock().lock();
    try
    {
      paramString = getDominKey(paramString);
      Object localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = localObject2;
        if (this.mIPConfigs.containsKey(paramString))
        {
          Map localMap = (Map)this.mIPConfigs.get(paramString);
          localObject1 = (IPConfig)localMap.get(Integer.valueOf(i));
          paramString = (String)localObject1;
          if (localObject1 == null)
          {
            paramString = (String)localObject1;
            if (this.mDefaultIsp != -1) {
              paramString = (IPConfig)localMap.get(Integer.valueOf(this.mDefaultIsp));
            }
          }
          localObject1 = localObject2;
          if (paramString != null)
          {
            localObject1 = localObject2;
            if (paramString.ipInfos != null)
            {
              localObject1 = localObject2;
              if (paramString.ipInfos.size() > 0)
              {
                i = paramString.getFailCount();
                int j = paramString.ipInfos.size();
                paramString = (IPInfo)paramString.ipInfos.get(i % j);
                localObject1 = localObject2;
                if (paramString != null) {
                  localObject1 = paramString.ip;
                }
              }
            }
          }
        }
      }
      return localObject1;
    }
    catch (Throwable paramString)
    {
      QDLog.i("IPConfigStrategy", "", paramString);
      return null;
    }
    finally
    {
      this.RW_Lock.readLock().unlock();
    }
  }
  
  public String resolve(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1 = null;
    this.RW_Lock.readLock().lock();
    try
    {
      Object localObject2 = getDominKey(paramString);
      paramString = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramString = localObject1;
        if (this.mIPConfigs.containsKey(localObject2))
        {
          localObject2 = (IPConfig)((Map)this.mIPConfigs.get(localObject2)).get(Integer.valueOf(paramInt));
          paramString = localObject1;
          if (localObject2 != null)
          {
            paramString = localObject1;
            if (((IPConfig)localObject2).ipInfos != null)
            {
              paramString = localObject1;
              if (((IPConfig)localObject2).ipInfos.size() > 0)
              {
                paramInt = ((IPConfig)localObject2).getFailCount();
                int i = ((IPConfig)localObject2).ipInfos.size();
                localObject2 = (IPInfo)((IPConfig)localObject2).ipInfos.get(paramInt % i);
                paramString = localObject1;
                if (localObject2 != null) {
                  paramString = ((IPInfo)localObject2).ip;
                }
              }
            }
          }
        }
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      QDLog.i("IPConfigStrategy", "", paramString);
      return null;
    }
    finally
    {
      this.RW_Lock.readLock().unlock();
    }
  }
  
  public void setDefaultIsp(int paramInt)
  {
    this.mDefaultIsp = paramInt;
  }
  
  public static class IPConfig
  {
    private int failCount = -1;
    public ArrayList<IPInfo> ipInfos = new ArrayList();
    
    public void appendIP(IPInfo paramIPInfo)
    {
      if (paramIPInfo == null) {
        return;
      }
      this.ipInfos.add(paramIPInfo);
    }
    
    public int getCurrFailCount()
    {
      return this.failCount;
    }
    
    public int getFailCount()
    {
      if (this.failCount < 0) {
        initStrarIndex();
      }
      return this.failCount;
    }
    
    public void initFailCount(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {}
      IPInfo localIPInfo;
      int j;
      do
      {
        return;
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          i = -1;
          localIterator = this.ipInfos.iterator();
        }
        localIPInfo = (IPInfo)localIterator.next();
        j = i + 1;
        int i = j;
      } while (!paramString.endsWith(localIPInfo.ip));
      this.failCount = j;
    }
    
    public void initStrarIndex()
    {
      if ((this.ipInfos == null) || (this.ipInfos.size() <= 0)) {
        return;
      }
      this.failCount = (Math.abs(new Random(System.currentTimeMillis()).nextInt()) % this.ipInfos.size());
    }
    
    public void setFailCount(int paramInt)
    {
      this.failCount = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.strategy.IPConfigStrategy
 * JD-Core Version:    0.7.0.1
 */