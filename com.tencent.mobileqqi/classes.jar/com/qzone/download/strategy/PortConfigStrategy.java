package com.qzone.download.strategy;

import android.text.TextUtils;
import com.qzone.common.logging.QDLog;
import com.qzone.utils.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

public class PortConfigStrategy
{
  private static final String TAG = "PortConfig";
  private ReadWriteLock RW_Lock = new ReentrantReadWriteLock();
  public Map<String, Pattern> mDominPatterns = new HashMap();
  private String mJsonConfig = null;
  private Map<String, List<Integer>> mapAvailablePorts = new HashMap();
  
  public int changePort(String paramString, int paramInt)
  {
    if ((paramInt <= 0) || (TextUtils.isEmpty(paramString))) {
      return 80;
    }
    this.RW_Lock.readLock().lock();
    for (;;)
    {
      try
      {
        Map localMap1 = this.mapAvailablePorts;
        Map localMap2 = this.mDominPatterns;
        Object localObject = null;
        Iterator localIterator = localMap1.entrySet().iterator();
        if (!localIterator.hasNext())
        {
          paramString = localObject;
          paramString = (List)localMap1.get(paramString);
          if (paramString != null)
          {
            int i = paramString.indexOf(new Integer(paramInt));
            paramInt = i;
            if (i < 0) {
              paramInt = 0;
            }
            paramInt = ((Integer)paramString.get((paramInt + 1) % paramString.size())).intValue();
            return paramInt;
          }
        }
        else
        {
          String str = (String)((Map.Entry)localIterator.next()).getKey();
          boolean bool = Utils.match((Pattern)localMap2.get(str), paramString);
          if (!bool) {
            continue;
          }
          paramString = str;
          continue;
        }
      }
      catch (Throwable paramString)
      {
        QDLog.i("PortConfig", "", paramString);
        return -1;
      }
      finally
      {
        this.RW_Lock.readLock().unlock();
      }
    }
  }
  
  /* Error */
  public void initConfig(String paramString)
  {
    // Byte code:
    //   0: ldc 8
    //   2: new 133	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 135
    //   8: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_1
    //   12: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: invokestatic 148	com/qzone/common/logging/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_1
    //   22: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +14 -> 39
    //   28: aload_1
    //   29: aload_0
    //   30: getfield 27	com/qzone/download/strategy/PortConfigStrategy:mJsonConfig	Ljava/lang/String;
    //   33: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +4 -> 40
    //   39: return
    //   40: aload_0
    //   41: getfield 25	com/qzone/download/strategy/PortConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   44: invokeinterface 155 1 0
    //   49: invokeinterface 56 1 0
    //   54: aload_0
    //   55: aload_1
    //   56: putfield 27	com/qzone/download/strategy/PortConfigStrategy:mJsonConfig	Ljava/lang/String;
    //   59: aload_0
    //   60: getfield 32	com/qzone/download/strategy/PortConfigStrategy:mapAvailablePorts	Ljava/util/Map;
    //   63: invokeinterface 158 1 0
    //   68: aload_0
    //   69: getfield 34	com/qzone/download/strategy/PortConfigStrategy:mDominPatterns	Ljava/util/Map;
    //   72: invokeinterface 158 1 0
    //   77: new 160	org/json/JSONObject
    //   80: dup
    //   81: aload_1
    //   82: invokespecial 161	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +27 -> 114
    //   90: aload_1
    //   91: invokevirtual 165	org/json/JSONObject:names	()Lorg/json/JSONArray;
    //   94: astore 4
    //   96: aload 4
    //   98: ifnull +16 -> 114
    //   101: iconst_0
    //   102: istore_2
    //   103: aload 4
    //   105: invokevirtual 170	org/json/JSONArray:length	()I
    //   108: istore_3
    //   109: iload_2
    //   110: iload_3
    //   111: if_icmplt +18 -> 129
    //   114: aload_0
    //   115: getfield 25	com/qzone/download/strategy/PortConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   118: invokeinterface 155 1 0
    //   123: invokeinterface 102 1 0
    //   128: return
    //   129: aload 4
    //   131: iload_2
    //   132: invokevirtual 174	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   135: astore 5
    //   137: new 176	java/util/ArrayList
    //   140: dup
    //   141: invokespecial 177	java/util/ArrayList:<init>	()V
    //   144: astore 6
    //   146: aload_1
    //   147: aload 4
    //   149: iload_2
    //   150: invokevirtual 174	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   153: invokevirtual 181	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   156: astore 7
    //   158: aload 7
    //   160: ifnull +14 -> 174
    //   163: iconst_0
    //   164: istore_3
    //   165: iload_3
    //   166: aload 7
    //   168: invokevirtual 170	org/json/JSONArray:length	()I
    //   171: if_icmplt +46 -> 217
    //   174: aload_0
    //   175: getfield 32	com/qzone/download/strategy/PortConfigStrategy:mapAvailablePorts	Ljava/util/Map;
    //   178: aload 5
    //   180: aload 6
    //   182: invokeinterface 185 3 0
    //   187: pop
    //   188: aload 5
    //   190: iconst_2
    //   191: invokestatic 189	java/util/regex/Pattern:compile	(Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   194: astore 6
    //   196: aload_0
    //   197: getfield 34	com/qzone/download/strategy/PortConfigStrategy:mDominPatterns	Ljava/util/Map;
    //   200: aload 5
    //   202: aload 6
    //   204: invokeinterface 185 3 0
    //   209: pop
    //   210: iload_2
    //   211: iconst_1
    //   212: iadd
    //   213: istore_2
    //   214: goto -111 -> 103
    //   217: aload 6
    //   219: aload 7
    //   221: iload_3
    //   222: invokevirtual 193	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   225: ldc 195
    //   227: invokevirtual 199	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   230: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: invokeinterface 206 2 0
    //   238: pop
    //   239: iload_3
    //   240: iconst_1
    //   241: iadd
    //   242: istore_3
    //   243: goto -78 -> 165
    //   246: astore_1
    //   247: ldc 8
    //   249: ldc 123
    //   251: aload_1
    //   252: invokestatic 209	com/qzone/common/logging/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   255: aload_0
    //   256: getfield 25	com/qzone/download/strategy/PortConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   259: invokeinterface 155 1 0
    //   264: invokeinterface 102 1 0
    //   269: return
    //   270: astore_1
    //   271: aload_0
    //   272: getfield 25	com/qzone/download/strategy/PortConfigStrategy:RW_Lock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   275: invokeinterface 155 1 0
    //   280: invokeinterface 102 1 0
    //   285: aload_1
    //   286: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	PortConfigStrategy
    //   0	287	1	paramString	String
    //   102	112	2	i	int
    //   108	135	3	j	int
    //   94	54	4	localJSONArray1	org.json.JSONArray
    //   135	66	5	str	String
    //   144	74	6	localObject	Object
    //   156	64	7	localJSONArray2	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   54	86	246	java/lang/Throwable
    //   90	96	246	java/lang/Throwable
    //   103	109	246	java/lang/Throwable
    //   129	158	246	java/lang/Throwable
    //   165	174	246	java/lang/Throwable
    //   174	210	246	java/lang/Throwable
    //   217	239	246	java/lang/Throwable
    //   54	86	270	finally
    //   90	96	270	finally
    //   103	109	270	finally
    //   129	158	270	finally
    //   165	174	270	finally
    //   174	210	270	finally
    //   217	239	270	finally
    //   247	255	270	finally
  }
  
  public boolean supportExtraPort(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.RW_Lock.readLock().lock();
    try
    {
      Object localObject = this.mapAvailablePorts;
      Map localMap = this.mDominPatterns;
      localObject = ((Map)localObject).entrySet().iterator();
      boolean bool;
      do
      {
        bool = ((Iterator)localObject).hasNext();
        if (!bool) {
          return false;
        }
        bool = Utils.match((Pattern)localMap.get((String)((Map.Entry)((Iterator)localObject).next()).getKey()), paramString);
      } while (!bool);
      return true;
    }
    catch (Throwable paramString)
    {
      QDLog.i("PortConfig", "", paramString);
      return false;
    }
    finally
    {
      this.RW_Lock.readLock().unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.strategy.PortConfigStrategy
 * JD-Core Version:    0.7.0.1
 */