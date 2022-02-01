package com.tencent.ad.tangram.offline;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForXJ;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@Keep
public enum AdOffline
{
  INSTANCE;
  
  private static final String TAG = "AdOffline";
  private WeakReference<AdOfflineAdapter> adapter;
  private Map<String, String> map = new HashMap();
  
  private AdOffline() {}
  
  private void update(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString2))
      {
        this.map.put(paramString1, paramString2);
        return;
      }
    } while (!this.map.containsKey(paramString1));
    this.map.remove(paramString1);
  }
  
  public AdOfflineAdapter getAdapter()
  {
    if (this.adapter != null) {
      return (AdOfflineAdapter)this.adapter.get();
    }
    return null;
  }
  
  public String getVersionIfExists(String paramString)
  {
    Object localObject = getAdapter();
    if (localObject != null) {}
    for (localObject = ((AdOfflineAdapter)localObject).getVersionIfExists(paramString);; localObject = null)
    {
      update(paramString, (String)localObject);
      AdLog.i("AdOffline", String.format("getVersionIfExists businessId:%s version:%s", new Object[] { paramString, localObject }));
      return localObject;
    }
  }
  
  public String getVersionIfExistsFromMemory(String paramString)
  {
    return (String)this.map.get(paramString);
  }
  
  public boolean isEnable(Context paramContext)
  {
    paramContext = AdSettingsUtil.INSTANCE.getSettingsCache(paramContext);
    if (paramContext != null) {
      return paramContext.settingsForXJ.offline;
    }
    return false;
  }
  
  public void setAdapter(WeakReference<AdOfflineAdapter> paramWeakReference)
  {
    this.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.offline.AdOffline
 * JD-Core Version:    0.7.0.1
 */