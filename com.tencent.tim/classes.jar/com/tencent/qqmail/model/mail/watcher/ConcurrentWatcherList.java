package com.tencent.qqmail.model.mail.watcher;

import com.tencent.qqmail.utilities.ConcurrentHashSet;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class ConcurrentWatcherList<T>
  extends ConcurrentHashSet<T>
{
  private static final String TAG = "ConcurrentWatcherList";
  private static final HashSet<String> clzFilter = new HashSet();
  private static final HashSet<String> methodFilter = new HashSet();
  private static final String ns = "com.tencent.qqmail.model.mail.watcher.";
  private final Class<T> clazz;
  private final ConcurrentHashMap<String, Method> methodToInvoke = new ConcurrentHashMap();
  
  static
  {
    clzFilter.add("com.tencent.qqmail.model.mail.watcher.SyncWatcher");
    clzFilter.add("com.tencent.qqmail.model.mail.watcher.LoadListWatcher");
    clzFilter.add("com.tencent.qqmail.model.mail.watcher.LoadMailWatcher");
    methodFilter.add("onPopIn");
    methodFilter.add("onProcess");
  }
  
  public ConcurrentWatcherList(Class<T> paramClass)
  {
    this.clazz = paramClass;
  }
  
  private String format(String paramString, Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.clazz.getName()).append("#").append(paramString);
    int j = paramArrayOfObject.length;
    int i = 0;
    if (i < j)
    {
      paramString = paramArrayOfObject[i];
      localStringBuilder.append(" ");
      if (paramString != null) {}
      for (paramString = paramString.toString();; paramString = "null")
      {
        localStringBuilder.append(paramString);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public void bind(boolean paramBoolean, T paramT)
  {
    if (paramBoolean)
    {
      add(paramT);
      return;
    }
    remove(paramT);
  }
  
  public void trigger(String paramString, Object... paramVarArgs)
  {
    Object localObject2 = (Method)this.methodToInvoke.get(paramString);
    Object localObject3 = localObject2;
    int j;
    int i;
    if (localObject2 == null)
    {
      localObject3 = this.clazz.getMethods();
      j = localObject3.length;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = localObject3[i];
        Class[] arrayOfClass = ((Method)localObject1).getParameterTypes();
        if ((!((Method)localObject1).getName().equals(paramString)) || (arrayOfClass.length != paramVarArgs.length)) {}
      }
      else
      {
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          this.methodToInvoke.put(paramString, localObject1);
          localObject3 = localObject1;
        }
        if (localObject3 == null) {
          break;
        }
        if ((clzFilter.contains(this.clazz.getName())) && (!methodFilter.contains(paramString))) {
          QMLog.log(4, "ConcurrentWatcherList", format(paramString, paramVarArgs));
        }
        if (size() == 0) {
          QMLog.log(4, "ConcurrentWatcherList", "no " + paramString + " listener found");
        }
        localObject1 = iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          try
          {
            QMLog.log(4, "ConcurrentWatcherList", "invoke, object: " + localObject2 + ", method: " + localObject3 + ", args: " + Arrays.toString(paramVarArgs) + ", thread: " + Thread.currentThread());
            ((Method)localObject3).invoke(localObject2, paramVarArgs);
          }
          catch (Exception localException)
          {
            QMLog.log(6, "ConcurrentWatcherList", this.clazz.getName() + "#" + paramString + ": " + localException.toString());
          }
        }
      }
      i += 1;
    }
    QMLog.log(6, "ConcurrentWatcherList", "Cannot find any method for " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.watcher.ConcurrentWatcherList
 * JD-Core Version:    0.7.0.1
 */