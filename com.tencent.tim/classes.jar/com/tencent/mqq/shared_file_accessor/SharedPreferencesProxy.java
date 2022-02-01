package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class SharedPreferencesProxy
  implements SharedPreferences
{
  private static final String LOG_TAG = "SharedPreferencesProxy";
  private static String sPkgSpName = null;
  private WeakReference<Context> mContext = null;
  private EditorImpl mEditor = null;
  private String mFileName = null;
  private Set<SharedPreferences.OnSharedPreferenceChangeListener> mListeners = null;
  private Monitor mMonitor = null;
  private ContentProviderClient mProviderPref = null;
  private boolean mRequestPrivate = false;
  private SharedPreferences.Editor mSystemEditor = null;
  private SharedPreferences mSystemPref = null;
  
  public SharedPreferencesProxy(WeakReference<Context> paramWeakReference, String paramString, int paramInt, boolean paramBoolean)
  {
    this.mContext = paramWeakReference;
    boolean bool;
    if (paramInt != 4)
    {
      bool = true;
      this.mRequestPrivate = bool;
      if (sPkgSpName == null) {
        sPkgSpName = ((Context)paramWeakReference.get()).getPackageName() + "_preferences";
      }
      int i = paramInt;
      if (sPkgSpName.equals(paramString))
      {
        i = paramInt;
        if (paramInt != 4)
        {
          i = paramInt;
          if (paramBoolean) {
            i = 4;
          }
        }
      }
      if (((i & 0x4) != 4) || (Utils.sIsSameProcessAsCP)) {
        break label188;
      }
      this.mProviderPref = new ContentProviderClient(paramWeakReference, paramString);
    }
    for (;;)
    {
      this.mFileName = paramString;
      this.mEditor = new EditorImpl();
      return;
      bool = false;
      break;
      label188:
      this.mSystemPref = Utils.getSystemSp((Context)paramWeakReference.get(), paramString, 0);
      this.mSystemEditor = this.mSystemPref.edit();
    }
  }
  
  public boolean contains(String paramString)
  {
    boolean bool = false;
    if (this.mProviderPref != null)
    {
      bool = ((Boolean)this.mProviderPref.read(paramString, CommonConstants.VALUE_TYPE_ANY, Boolean.valueOf(false))).booleanValue();
      return bool;
    }
    if (paramString != null) {}
    for (Object localObject = this.mEditor.mModifiedCaches.get(paramString);; localObject = null)
    {
      if (localObject == null) {
        break label73;
      }
      if (localObject.equals(this.mEditor)) {
        break;
      }
      return true;
    }
    label73:
    return this.mSystemPref.contains(paramString);
  }
  
  public SharedPreferences.Editor edit()
  {
    return this.mEditor;
  }
  
  public Map<String, ?> getAll()
  {
    Object localObject2;
    if (this.mProviderPref != null)
    {
      localObject2 = this.mProviderPref.readAll();
      return localObject2;
    }
    Object localObject1 = this.mSystemPref.getAll();
    if (localObject1 != null)
    {
      localObject1 = new HashMap((Map)localObject1);
      ((Map)localObject1).putAll(this.mEditor.mModifiedCaches);
    }
    for (;;)
    {
      Iterator localIterator = this.mEditor.mModifiedCaches.entrySet().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator.next();
        if (this.mEditor.equals(((Map.Entry)localObject2).getValue())) {
          ((Map)localObject1).remove(((Map.Entry)localObject2).getKey());
        }
      }
      localObject1 = new HashMap(this.mEditor.mModifiedCaches);
    }
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.mProviderPref != null) {
          return ((Boolean)this.mProviderPref.read(paramString, CommonConstants.VALUE_TYPE_BOOLEAN, Boolean.valueOf(paramBoolean))).booleanValue();
        }
        if (paramString == null) {
          break label110;
        }
        localObject = this.mEditor.mModifiedCaches.get(paramString);
        if (localObject != null)
        {
          if (!localObject.equals(this.mEditor)) {
            return ((Boolean)localObject).booleanValue();
          }
        }
        else
        {
          boolean bool = this.mSystemPref.getBoolean(paramString, paramBoolean);
          return bool;
        }
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (SharedPreferencesProxyManager.sIsDebugVersion) {
          throw new RuntimeException(paramString);
        }
      }
      return paramBoolean;
      label110:
      Object localObject = null;
    }
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    for (;;)
    {
      try
      {
        if (this.mProviderPref != null) {
          return ((Float)this.mProviderPref.read(paramString, CommonConstants.VALUE_TYPE_FLOAT, Float.valueOf(paramFloat))).floatValue();
        }
        if (paramString == null) {
          break label110;
        }
        localObject = this.mEditor.mModifiedCaches.get(paramString);
        if (localObject != null)
        {
          if (!localObject.equals(this.mEditor)) {
            return ((Float)localObject).floatValue();
          }
        }
        else
        {
          float f = this.mSystemPref.getFloat(paramString, paramFloat);
          return f;
        }
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (SharedPreferencesProxyManager.sIsDebugVersion) {
          throw new RuntimeException(paramString);
        }
      }
      return paramFloat;
      label110:
      Object localObject = null;
    }
  }
  
  public int getInt(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.mProviderPref != null) {
          return ((Integer)this.mProviderPref.read(paramString, CommonConstants.VALUE_TYPE_INT, Integer.valueOf(paramInt))).intValue();
        }
        if (paramString == null) {
          break label110;
        }
        localObject = this.mEditor.mModifiedCaches.get(paramString);
        if (localObject != null)
        {
          if (!localObject.equals(this.mEditor)) {
            return ((Integer)localObject).intValue();
          }
        }
        else
        {
          int i = this.mSystemPref.getInt(paramString, paramInt);
          return i;
        }
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (SharedPreferencesProxyManager.sIsDebugVersion) {
          throw new RuntimeException(paramString);
        }
      }
      return paramInt;
      label110:
      Object localObject = null;
    }
  }
  
  public long getLong(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.mProviderPref != null) {
          return ((Long)this.mProviderPref.read(paramString, CommonConstants.VALUE_TYPE_LONG, Long.valueOf(paramLong))).longValue();
        }
        if (paramString == null) {
          break label112;
        }
        localObject = this.mEditor.mModifiedCaches.get(paramString);
        if (localObject != null)
        {
          if (!localObject.equals(this.mEditor)) {
            return ((Long)localObject).longValue();
          }
        }
        else
        {
          long l = this.mSystemPref.getLong(paramString, paramLong);
          return l;
        }
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (SharedPreferencesProxyManager.sIsDebugVersion) {
          throw new RuntimeException(paramString);
        }
      }
      return paramLong;
      label112:
      Object localObject = null;
    }
  }
  
  public String getString(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (this.mProviderPref != null) {
          return (String)this.mProviderPref.read(paramString1, CommonConstants.VALUE_TYPE_STRING, paramString2);
        }
        if (paramString1 != null)
        {
          localObject = this.mEditor.mModifiedCaches.get(paramString1);
          if (localObject != null)
          {
            if (localObject.equals(this.mEditor)) {
              return paramString2;
            }
            return (String)localObject;
          }
          paramString1 = this.mSystemPref.getString(paramString1, paramString2);
          return paramString1;
        }
      }
      catch (ClassCastException paramString1)
      {
        paramString1.printStackTrace();
        if (SharedPreferencesProxyManager.sIsDebugVersion) {
          throw new RuntimeException(paramString1);
        }
        return paramString2;
      }
      Object localObject = null;
    }
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    for (;;)
    {
      try
      {
        if (this.mProviderPref == null) {
          continue;
        }
        paramString = this.mProviderPref.read(paramString, CommonConstants.VALUE_TYPE_STRSET, null);
        if (paramString != null) {
          continue;
        }
        paramString = paramSet;
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (!SharedPreferencesProxyManager.sIsDebugVersion) {
          continue;
        }
        throw new RuntimeException(paramString);
        return null;
        paramString = paramSet;
        continue;
        continue;
        Object localObject = null;
        continue;
      }
      if ((paramString == null) || (!(paramString instanceof Set))) {
        continue;
      }
      return (Set)paramString;
      if (paramString == null) {
        continue;
      }
      localObject = this.mEditor.mModifiedCaches.get(paramString);
      if (localObject != null)
      {
        paramString = paramSet;
        if (!localObject.equals(this.mEditor)) {
          paramString = (Set)localObject;
        }
      }
      else
      {
        paramString = this.mSystemPref.getStringSet(paramString, paramSet);
      }
    }
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      if (this.mListeners == null) {
        this.mListeners = new HashSet(2);
      }
      this.mListeners.add(paramOnSharedPreferenceChangeListener);
      return;
    }
    finally {}
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      if (this.mListeners != null) {
        this.mListeners.remove(paramOnSharedPreferenceChangeListener);
      }
      return;
    }
    finally
    {
      paramOnSharedPreferenceChangeListener = finally;
      throw paramOnSharedPreferenceChangeListener;
    }
  }
  
  class EditorImpl
    implements SharedPreferences.Editor, Runnable
  {
    protected final Map<String, Object> mModifiedCaches = new ConcurrentHashMap();
    
    EditorImpl() {}
    
    private void monitor()
    {
      Object localObject;
      if (SharedPreferencesProxyManager.getInstance().isMonitored())
      {
        localObject = Utils.getMiniStackInfo();
        localObject = ((Utils.StackInfo)localObject).clazz + '|' + ((Utils.StackInfo)localObject).method + '|' + ((Utils.StackInfo)localObject).stack;
        if (Utils.sIsSameProcessAsCP) {
          SharedPreferencesProxyManager.getInstance().onModifySp(SharedPreferencesProxy.this.mFileName, Utils.sCurrentProcessName, localObject);
        }
      }
      else
      {
        return;
      }
      if (SharedPreferencesProxy.this.mMonitor == null) {
        SharedPreferencesProxy.access$502(SharedPreferencesProxy.this, new Monitor(SharedPreferencesProxy.this.mContext, SharedPreferencesProxy.this.mFileName));
      }
      SharedPreferencesProxy.this.mMonitor.log((String)localObject);
    }
    
    private void notifyListeners(String paramString)
    {
      synchronized (SharedPreferencesProxy.this)
      {
        if (SharedPreferencesProxy.this.mListeners != null)
        {
          Iterator localIterator = SharedPreferencesProxy.this.mListeners.iterator();
          if (localIterator.hasNext()) {
            ((SharedPreferences.OnSharedPreferenceChangeListener)localIterator.next()).onSharedPreferenceChanged(SharedPreferencesProxy.this, paramString);
          }
        }
      }
    }
    
    public void apply()
    {
      commit(true);
    }
    
    public SharedPreferences.Editor clear()
    {
      if (SharedPreferencesProxy.this.mProviderPref != null)
      {
        SharedPreferencesProxy.this.mProviderPref.clear(null);
        return this;
      }
      this.mModifiedCaches.clear();
      SharedPreferencesProxy.this.mSystemEditor.clear();
      return this;
    }
    
    void commit(boolean paramBoolean)
    {
      if (SharedPreferencesProxy.this.mProviderPref != null)
      {
        SharedPreferencesProxy.this.mProviderPref.commit();
        if ((SharedPreferencesProxy.this.mRequestPrivate) && (paramBoolean)) {
          monitor();
        }
      }
      for (;;)
      {
        return;
        if ((Looper.getMainLooper() != Looper.myLooper()) || (SharedPreferencesProxyManager.sIsCrashing)) {
          SharedPreferencesProxy.this.mSystemEditor.commit();
        }
        while (paramBoolean)
        {
          monitor();
          return;
          PrefEditQueueWork.getInstance().queue(this);
        }
      }
    }
    
    public boolean commit()
    {
      commit(true);
      return true;
    }
    
    public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      if (SharedPreferencesProxy.this.mProviderPref != null) {
        SharedPreferencesProxy.this.mProviderPref.write(paramString, Boolean.valueOf(paramBoolean), CommonConstants.VALUE_TYPE_BOOLEAN);
      }
      for (;;)
      {
        notifyListeners(paramString);
        return this;
        if (paramString != null) {
          this.mModifiedCaches.put(paramString, Boolean.valueOf(paramBoolean));
        }
        SharedPreferencesProxy.this.mSystemEditor.putBoolean(paramString, paramBoolean);
      }
    }
    
    public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      if (SharedPreferencesProxy.this.mProviderPref != null) {
        SharedPreferencesProxy.this.mProviderPref.write(paramString, Float.valueOf(paramFloat), CommonConstants.VALUE_TYPE_FLOAT);
      }
      for (;;)
      {
        notifyListeners(paramString);
        return this;
        if (paramString != null) {
          this.mModifiedCaches.put(paramString, Float.valueOf(paramFloat));
        }
        SharedPreferencesProxy.this.mSystemEditor.putFloat(paramString, paramFloat);
      }
    }
    
    public SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      if (SharedPreferencesProxy.this.mProviderPref != null) {
        SharedPreferencesProxy.this.mProviderPref.write(paramString, Integer.valueOf(paramInt), CommonConstants.VALUE_TYPE_INT);
      }
      for (;;)
      {
        notifyListeners(paramString);
        return this;
        if (paramString != null) {
          this.mModifiedCaches.put(paramString, Integer.valueOf(paramInt));
        }
        SharedPreferencesProxy.this.mSystemEditor.putInt(paramString, paramInt);
      }
    }
    
    public SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      if (SharedPreferencesProxy.this.mProviderPref != null) {
        SharedPreferencesProxy.this.mProviderPref.write(paramString, Long.valueOf(paramLong), CommonConstants.VALUE_TYPE_LONG);
      }
      for (;;)
      {
        notifyListeners(paramString);
        return this;
        if (paramString != null) {
          this.mModifiedCaches.put(paramString, Long.valueOf(paramLong));
        }
        SharedPreferencesProxy.this.mSystemEditor.putLong(paramString, paramLong);
      }
    }
    
    public SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      if (SharedPreferencesProxy.this.mProviderPref != null)
      {
        SharedPreferencesProxy.this.mProviderPref.write(paramString1, paramString2, CommonConstants.VALUE_TYPE_STRING);
        notifyListeners(paramString1);
        return this;
      }
      if (paramString1 != null)
      {
        if (paramString2 != null) {
          break label70;
        }
        this.mModifiedCaches.put(paramString1, this);
      }
      for (;;)
      {
        SharedPreferencesProxy.this.mSystemEditor.putString(paramString1, paramString2);
        break;
        label70:
        this.mModifiedCaches.put(paramString1, paramString2);
      }
    }
    
    public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      if (SharedPreferencesProxy.this.mProviderPref != null)
      {
        SharedPreferencesProxy.this.mProviderPref.write(paramString, paramSet, CommonConstants.VALUE_TYPE_STRSET);
        notifyListeners(paramString);
        return this;
      }
      if (paramString != null)
      {
        if (paramSet != null) {
          break label70;
        }
        this.mModifiedCaches.put(paramString, this);
      }
      for (;;)
      {
        SharedPreferencesProxy.this.mSystemEditor.putStringSet(paramString, paramSet);
        break;
        label70:
        this.mModifiedCaches.put(paramString, new HashSet(paramSet));
      }
    }
    
    public SharedPreferences.Editor remove(String paramString)
    {
      if (SharedPreferencesProxy.this.mProviderPref != null) {
        SharedPreferencesProxy.this.mProviderPref.delete(paramString);
      }
      for (;;)
      {
        notifyListeners(paramString);
        return this;
        if (paramString != null) {
          this.mModifiedCaches.put(paramString, this);
        }
        SharedPreferencesProxy.this.mSystemEditor.remove(paramString);
      }
    }
    
    public void run()
    {
      SharedPreferencesProxy.this.mSystemEditor.commit();
      this.mModifiedCaches.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.SharedPreferencesProxy
 * JD-Core Version:    0.7.0.1
 */