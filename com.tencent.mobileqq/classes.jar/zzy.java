import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class zzy
{
  private static ConcurrentHashMap<Class, zzu> a;
  public static Class<? extends zzu>[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangClass = new Class[] { zzx.class };
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static String a(ArrayList<Integer> paramArrayList)
  {
    Class[] arrayOfClass = jdField_a_of_type_ArrayOfJavaLangClass;
    int k = arrayOfClass.length;
    int i = 0;
    int j = 0;
    Object localObject2 = null;
    zzu localzzu;
    Object localObject1;
    if (i < k)
    {
      localzzu = a(arrayOfClass[i]);
      localObject1 = paramArrayList.iterator();
      int m = 0;
      while (((Iterator)localObject1).hasNext())
      {
        boolean bool = localzzu.a(((Integer)((Iterator)localObject1).next()).intValue());
        m = bool;
        if (bool) {
          m = bool;
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new StringBuilder();
      }
      if (m == 0) {
        break label167;
      }
    }
    label167:
    for (localObject2 = localzzu.a;; localObject2 = "")
    {
      if (j == 1) {
        ((StringBuilder)localObject1).append(";");
      }
      if (localObject1 != null) {
        ((StringBuilder)localObject1).append((String)localObject2);
      }
      j += 1;
      i += 1;
      localObject2 = localObject1;
      break;
      if (localObject2 != null) {
        return ((StringBuilder)localObject2).toString();
      }
      return "";
    }
  }
  
  public static ArrayList<Integer> a(String paramString, HashMap<String, String> paramHashMap, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString != null) {
      if ("actSceneMem".equals(paramString)) {
        localArrayList.add(Integer.valueOf(4));
      }
    }
    while (paramJSONObject == null)
    {
      do
      {
        return localArrayList;
        if ("actScenePerf".equals(paramString))
        {
          localArrayList.add(Integer.valueOf(1));
          localArrayList.add(Integer.valueOf(4));
          return localArrayList;
        }
      } while (!"unifiedMonitor".equals(paramString));
      switch (Integer.parseInt((String)paramHashMap.get("family")))
      {
      default: 
        return localArrayList;
      case 0: 
        localArrayList.add(Integer.valueOf(2));
        return localArrayList;
      case 10: 
        localArrayList.add(Integer.valueOf(2));
        return localArrayList;
      case 9: 
        localArrayList.add(Integer.valueOf(2));
        return localArrayList;
      case 20: 
        localArrayList.add(Integer.valueOf(1));
        localArrayList.add(Integer.valueOf(4));
        return localArrayList;
      }
      localArrayList.add(Integer.valueOf(1));
      return localArrayList;
    }
    try
    {
      if (!paramJSONObject.has("newplugin")) {
        break label267;
      }
      i = paramJSONObject.getInt("newplugin");
    }
    catch (JSONException paramString)
    {
      QLog.e("MagnifierSDK.AbFactorManger", 1, "getRelationPerfType ", paramString);
      return localArrayList;
    }
    localArrayList.add(Integer.valueOf(2));
    return localArrayList;
    label267:
    int i = paramJSONObject.getInt("plugin");
    break label362;
    localArrayList.add(Integer.valueOf(2));
    return localArrayList;
    localArrayList.add(Integer.valueOf(1));
    return localArrayList;
    localArrayList.add(Integer.valueOf(4));
    return localArrayList;
    localArrayList.add(Integer.valueOf(4));
    return localArrayList;
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    return localArrayList;
    label362:
    switch (i)
    {
    }
    return localArrayList;
  }
  
  /* Error */
  public static zzu a(Class paramClass)
  {
    // Byte code:
    //   0: getstatic 24	zzy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_0
    //   4: invokevirtual 140	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 53	zzu
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +53 -> 65
    //   15: getstatic 24	zzy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   18: astore_3
    //   19: aload_3
    //   20: monitorenter
    //   21: aload_0
    //   22: invokevirtual 143	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   25: checkcast 53	zzu
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: getstatic 24	zzy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual 147	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: pop
    //   40: aload_3
    //   41: monitorexit
    //   42: aload_1
    //   43: areturn
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 150	java/lang/IllegalAccessException:printStackTrace	()V
    //   49: goto -18 -> 31
    //   52: astore_0
    //   53: aload_3
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual 151	java/lang/InstantiationException:printStackTrace	()V
    //   62: goto -31 -> 31
    //   65: aload_1
    //   66: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramClass	Class
    //   10	56	1	localObject	Object
    //   28	2	2	localzzu	zzu
    //   44	2	2	localIllegalAccessException	java.lang.IllegalAccessException
    //   57	2	2	localInstantiationException	java.lang.InstantiationException
    // Exception table:
    //   from	to	target	type
    //   21	29	44	java/lang/IllegalAccessException
    //   21	29	52	finally
    //   31	42	52	finally
    //   45	49	52	finally
    //   53	55	52	finally
    //   58	62	52	finally
    //   21	29	57	java/lang/InstantiationException
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {}
    do
    {
      do
      {
        return;
        paramHashMap.put("deviceLv", String.valueOf(bbdh.f()));
        paramString = a(paramString, paramHashMap, null);
      } while (paramString.size() <= 0);
      paramString = a(paramString);
    } while ((paramString == null) || (paramString.length() <= 0));
    paramHashMap.put("abfactor", paramString);
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = a(null, null, paramJSONObject);
        if (((ArrayList)localObject).size() > 0)
        {
          localObject = a((ArrayList)localObject);
          if ((localObject != null) && (((String)localObject).length() > 0))
          {
            paramJSONObject.put("abfactor", localObject);
            return;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("MagnifierSDK.AbFactorManger", 2, "", paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zzy
 * JD-Core Version:    0.7.0.1
 */