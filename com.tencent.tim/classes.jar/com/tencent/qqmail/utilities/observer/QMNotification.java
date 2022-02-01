package com.tencent.qqmail.utilities.observer;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QMNotification
{
  public static final HashMap<String, Object> EMPTY_NOTIFICATION = new QMNotification.1();
  private static final ConcurrentHashMap<String, ConcurrentObservable> notificationmanager = new ConcurrentHashMap(16, 0.9F, 1);
  
  public static HashMap<String, Object> createNotification(Object... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      if (j % 2 == 1) {
        throw new IllegalArgumentException("objects need double");
      }
      int i = 0;
      while (i < j)
      {
        ValidateHelper.notNullAndNotEmpty((String)paramVarArgs[i]);
        localHashMap.put((String)paramVarArgs[i], paramVarArgs[(i + 1)]);
        i += 2;
      }
    }
    return localHashMap;
  }
  
  public static int getTotalObserver()
  {
    Iterator localIterator = notificationmanager.keySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (notificationmanager.get(str) == null) {
        break label64;
      }
      i = ((ConcurrentObservable)notificationmanager.get(str)).countObservers() + i;
    }
    label64:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static void postNotification(String paramString, int paramInt, HashMap<String, Object> paramHashMap)
  {
    QMLog.log(4, "postNotification", "str:" + paramString);
    if (notificationmanager.get(paramString) == null) {
      notificationmanager.put(paramString, new ConcurrentObservable());
    }
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    ((HashMap)localObject).put("GROUP_TYPE", Integer.valueOf(paramInt));
    ((ConcurrentObservable)notificationmanager.get(paramString)).trigger(localObject);
  }
  
  public static void postNotification(String paramString, Object paramObject)
  {
    if (notificationmanager.get(paramString) == null) {
      notificationmanager.put(paramString, new ConcurrentObservable());
    }
    ((ConcurrentObservable)notificationmanager.get(paramString)).trigger(paramObject);
  }
  
  public static void registNotification(String paramString, Observer paramObserver)
  {
    ConcurrentObservable localConcurrentObservable2 = (ConcurrentObservable)notificationmanager.get(paramString);
    ConcurrentObservable localConcurrentObservable1 = localConcurrentObservable2;
    if (localConcurrentObservable2 == null)
    {
      localConcurrentObservable1 = new ConcurrentObservable();
      notificationmanager.put(paramString, localConcurrentObservable1);
    }
    localConcurrentObservable1.addObserver(paramObserver);
  }
  
  public static void registNotification(String paramString, Observer paramObserver, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      registNotification(paramString, paramObserver);
      return;
    }
    unregistNotification(paramString, paramObserver);
  }
  
  public static void unregistNotification(String paramString, Observer paramObserver)
  {
    paramString = (ConcurrentObservable)notificationmanager.get(paramString);
    if (paramString != null) {
      paramString.deleteObserver(paramObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.observer.QMNotification
 * JD-Core Version:    0.7.0.1
 */