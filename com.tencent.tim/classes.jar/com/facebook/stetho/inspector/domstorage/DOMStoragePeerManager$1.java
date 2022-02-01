package com.facebook.stetho.inspector.domstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DOMStoragePeerManager$1
  extends PeersRegisteredListener
{
  private final List<DOMStoragePeerManager.DevToolsSharedPreferencesListener> mPrefsListeners = new ArrayList();
  
  DOMStoragePeerManager$1(DOMStoragePeerManager paramDOMStoragePeerManager) {}
  
  public void onFirstPeerRegistered()
  {
    try
    {
      Iterator localIterator = SharedPreferencesHelper.getSharedPreferenceTags(DOMStoragePeerManager.access$000(this.this$0)).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        SharedPreferences localSharedPreferences = DOMStoragePeerManager.access$000(this.this$0).getSharedPreferences((String)localObject2, 0);
        localObject2 = new DOMStoragePeerManager.DevToolsSharedPreferencesListener(this.this$0, localSharedPreferences, (String)localObject2);
        localSharedPreferences.registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener)localObject2);
        this.mPrefsListeners.add(localObject2);
      }
    }
    finally {}
  }
  
  public void onLastPeerUnregistered()
  {
    try
    {
      Iterator localIterator = this.mPrefsListeners.iterator();
      while (localIterator.hasNext()) {
        ((DOMStoragePeerManager.DevToolsSharedPreferencesListener)localIterator.next()).unregister();
      }
      this.mPrefsListeners.clear();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.domstorage.DOMStoragePeerManager.1
 * JD-Core Version:    0.7.0.1
 */