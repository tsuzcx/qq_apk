package com.tencent.qqmail.utilities.sharedpreference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.receiver.QMIPCBroadcastManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SPManager
{
  private static final Map<SharedPreferences, Set<OnChangedListener>> LISTENERS = new ConcurrentHashMap();
  private static final String TAG = "SPManager";
  
  public static SharedPreferences.Editor getEditor(String paramString)
  {
    return getSp(paramString).edit();
  }
  
  public static SharedPreferences.Editor getEditorInMultiProcess(String paramString)
  {
    return getSp(paramString, true).edit();
  }
  
  public static SharedPreferences getSp(String paramString)
  {
    return getSp(paramString, false);
  }
  
  public static SharedPreferences getSp(String paramString, boolean paramBoolean)
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    if (paramBoolean) {}
    for (int i = 4;; i = 0) {
      return localQMApplicationContext.getSharedPreferences(paramString, i);
    }
  }
  
  public static void handleChanged(String paramString)
  {
    Object localObject = getSp(paramString, true);
    localObject = (Set)LISTENERS.get(localObject);
    if ((localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnChangedListener)((Iterator)localObject).next()).onChanged(paramString);
      }
    }
  }
  
  public static void notifyChanged(String paramString)
  {
    QMIPCBroadcastManager.notifySPChanged(paramString);
  }
  
  public static void registerOnChangedListener(String paramString, OnChangedListener paramOnChangedListener)
  {
    QMLog.log(4, "SPManager", "registerOnChangedListener, name: " + paramString);
    if (paramOnChangedListener == null) {
      return;
    }
    SharedPreferences localSharedPreferences = getSp(paramString, true);
    Set localSet = (Set)LISTENERS.get(localSharedPreferences);
    paramString = localSet;
    if (localSet == null)
    {
      paramString = Collections.newSetFromMap(new ConcurrentHashMap());
      LISTENERS.put(localSharedPreferences, paramString);
    }
    paramString.add(paramOnChangedListener);
  }
  
  public static void unregisterAllOnChangedListener(String paramString)
  {
    paramString = getSp(paramString, true);
    paramString = (Set)LISTENERS.get(paramString);
    if ((paramString == null) || (paramString.size() == 0)) {
      return;
    }
    paramString.clear();
  }
  
  public static void unregisterOnChangedListener(String paramString, OnChangedListener paramOnChangedListener)
  {
    if (paramOnChangedListener == null) {}
    do
    {
      return;
      paramString = getSp(paramString, true);
      paramString = (Set)LISTENERS.get(paramString);
    } while ((paramString == null) || (paramString.size() == 0));
    paramString.remove(paramOnChangedListener);
  }
  
  public static abstract interface OnChangedListener
  {
    public abstract void onChanged(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.sharedpreference.SPManager
 * JD-Core Version:    0.7.0.1
 */