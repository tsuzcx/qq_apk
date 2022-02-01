package com.facebook.stetho.inspector.domstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.DomStorageItemAddedParams;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.DomStorageItemRemovedParams;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.DomStorageItemUpdatedParams;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.StorageId;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DOMStoragePeerManager
  extends ChromePeerManager
{
  private final Context mContext;
  private final PeerRegistrationListener mPeerListener = new DOMStoragePeerManager.1(this);
  
  public DOMStoragePeerManager(Context paramContext)
  {
    this.mContext = paramContext;
    setListener(this.mPeerListener);
  }
  
  private static Map<String, Object> prefsCopy(Map<String, ?> paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof Set)) {
        localHashMap.put(str, shallowCopy((Set)localObject));
      } else {
        localHashMap.put(str, localObject);
      }
    }
    return localHashMap;
  }
  
  private static <T> Set<T> shallowCopy(Set<T> paramSet)
  {
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(paramSet.next());
    }
    return localHashSet;
  }
  
  public void signalItemAdded(DOMStorage.StorageId paramStorageId, String paramString1, String paramString2)
  {
    DOMStorage.DomStorageItemAddedParams localDomStorageItemAddedParams = new DOMStorage.DomStorageItemAddedParams();
    localDomStorageItemAddedParams.storageId = paramStorageId;
    localDomStorageItemAddedParams.key = paramString1;
    localDomStorageItemAddedParams.newValue = paramString2;
    sendNotificationToPeers("DOMStorage.domStorageItemAdded", localDomStorageItemAddedParams);
  }
  
  public void signalItemRemoved(DOMStorage.StorageId paramStorageId, String paramString)
  {
    DOMStorage.DomStorageItemRemovedParams localDomStorageItemRemovedParams = new DOMStorage.DomStorageItemRemovedParams();
    localDomStorageItemRemovedParams.storageId = paramStorageId;
    localDomStorageItemRemovedParams.key = paramString;
    sendNotificationToPeers("DOMStorage.domStorageItemRemoved", localDomStorageItemRemovedParams);
  }
  
  public void signalItemUpdated(DOMStorage.StorageId paramStorageId, String paramString1, String paramString2, String paramString3)
  {
    DOMStorage.DomStorageItemUpdatedParams localDomStorageItemUpdatedParams = new DOMStorage.DomStorageItemUpdatedParams();
    localDomStorageItemUpdatedParams.storageId = paramStorageId;
    localDomStorageItemUpdatedParams.key = paramString1;
    localDomStorageItemUpdatedParams.oldValue = paramString2;
    localDomStorageItemUpdatedParams.newValue = paramString3;
    sendNotificationToPeers("DOMStorage.domStorageItemUpdated", localDomStorageItemUpdatedParams);
  }
  
  class DevToolsSharedPreferencesListener
    implements SharedPreferences.OnSharedPreferenceChangeListener
  {
    private final Map<String, Object> mCopy;
    private final SharedPreferences mPrefs;
    private final DOMStorage.StorageId mStorageId;
    
    public DevToolsSharedPreferencesListener(SharedPreferences paramSharedPreferences, String paramString)
    {
      this.mPrefs = paramSharedPreferences;
      this.mStorageId = new DOMStorage.StorageId();
      this.mStorageId.securityOrigin = paramString;
      this.mStorageId.isLocalStorage = true;
      this.mCopy = DOMStoragePeerManager.prefsCopy(paramSharedPreferences.getAll());
    }
    
    public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
    {
      paramSharedPreferences = paramSharedPreferences.getAll();
      boolean bool1 = this.mCopy.containsKey(paramString);
      boolean bool2 = paramSharedPreferences.containsKey(paramString);
      if (bool2) {}
      for (paramSharedPreferences = paramSharedPreferences.get(paramString); (bool1) && (bool2); paramSharedPreferences = null)
      {
        DOMStoragePeerManager.this.signalItemUpdated(this.mStorageId, paramString, SharedPreferencesHelper.valueToString(this.mCopy.get(paramString)), SharedPreferencesHelper.valueToString(paramSharedPreferences));
        this.mCopy.put(paramString, paramSharedPreferences);
        return;
      }
      if (bool1)
      {
        DOMStoragePeerManager.this.signalItemRemoved(this.mStorageId, paramString);
        this.mCopy.remove(paramString);
        return;
      }
      if (bool2)
      {
        DOMStoragePeerManager.this.signalItemAdded(this.mStorageId, paramString, SharedPreferencesHelper.valueToString(paramSharedPreferences));
        this.mCopy.put(paramString, paramSharedPreferences);
        return;
      }
      LogUtil.i("Detected rapid put/remove of %s", new Object[] { paramString });
    }
    
    public void unregister()
    {
      this.mPrefs.unregisterOnSharedPreferenceChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.domstorage.DOMStoragePeerManager
 * JD-Core Version:    0.7.0.1
 */