package com.tencent.mobileqq.activity.qwallet.preload;

import aacp;
import aagd;
import android.net.Uri;
import android.text.TextUtils;
import aquy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jpa;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreloadModule
  implements Serializable
{
  public static final int DEFAULT_VALUE_RETRY_COUNT = 5;
  public static final int DEFAULT_VALUE_RETRY_TIME_INTERVAL = 24;
  private static final long serialVersionUID = 1L;
  public boolean isForbidAutoDownload;
  public boolean mBackControl;
  public String mBaseUrl;
  private CopyOnWriteArrayList<PreloadResource> mPreloadResources = new CopyOnWriteArrayList();
  public int mRetryCount = 5;
  public int mRetryTimeInterval = 24;
  public String mid;
  public String name;
  public int option;
  
  public PreloadModule() {}
  
  public PreloadModule(PreloadModule paramPreloadModule)
  {
    this();
    this.mid = paramPreloadModule.mid;
    this.mBackControl = paramPreloadModule.mBackControl;
    this.name = paramPreloadModule.name;
    this.option = paramPreloadModule.option;
    this.isForbidAutoDownload = paramPreloadModule.isForbidAutoDownload;
    this.mBaseUrl = paramPreloadModule.mBaseUrl;
    Iterator localIterator = paramPreloadModule.mPreloadResources.iterator();
    while (localIterator.hasNext())
    {
      PreloadResource localPreloadResource = (PreloadResource)localIterator.next();
      this.mPreloadResources.add(new PreloadResource(localPreloadResource));
    }
    this.mRetryTimeInterval = paramPreloadModule.mRetryTimeInterval;
    this.mRetryCount = paramPreloadModule.mRetryCount;
  }
  
  private boolean ar(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private void c(String paramString, AppRuntime paramAppRuntime)
  {
    Object localObject = null;
    try
    {
      Uri localUri = Uri.parse(paramString);
      paramString = localObject;
      if (localUri != null)
      {
        paramString = localObject;
        if (localUri.isHierarchical()) {
          paramString = localUri.getQueryParameter("_bid");
        }
      }
      if (!ar(paramString)) {
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    jpa.b(paramString, paramAppRuntime, true, new aacp(this));
  }
  
  public static PreloadModule parsePreloadModule(JSONObject paramJSONObject, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    int i = 0;
    PreloadModule localPreloadModule = new PreloadModule();
    for (;;)
    {
      try
      {
        if (paramJSONObject.optInt("back_control") != 1) {
          break label248;
        }
        bool1 = true;
        localPreloadModule.mBackControl = bool1;
        if (!paramBoolean) {
          break label240;
        }
        localPreloadModule.mBackControl = false;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      Object localObject = paramJSONObject.optString("module_id");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localPreloadModule.mid = localPreloadModule.name;
        localPreloadModule.option = paramJSONObject.optInt("option");
        if (paramJSONObject.optInt("forbid_download") == 1)
        {
          bool1 = bool2;
          localPreloadModule.isForbidAutoDownload = bool1;
          localPreloadModule.mBaseUrl = paramJSONObject.optString("url_base");
          localPreloadModule.mRetryTimeInterval = paramJSONObject.optInt("retry_t_interval", 24);
          localPreloadModule.mRetryCount = paramJSONObject.optInt("retry_cnt", 5);
          localPreloadModule.mRetryCount = Math.max(localPreloadModule.mRetryCount, 5);
          paramJSONObject = paramJSONObject.optJSONArray("resources");
          if (i < paramJSONObject.length())
          {
            localObject = PreloadResource.parsePreloadResource(paramJSONObject.getJSONObject(i), localPreloadModule, paramBoolean, paramInt);
            localPreloadModule.mPreloadResources.add(localObject);
            i += 1;
            continue;
            localPreloadModule.name = paramJSONObject.optString("module_name");
            continue;
          }
          return localPreloadModule;
        }
      }
      else
      {
        localPreloadModule.mid = ((String)localObject);
        continue;
      }
      boolean bool1 = false;
      continue;
      label240:
      if (paramInt == 2)
      {
        continue;
        label248:
        bool1 = false;
      }
    }
  }
  
  public void check()
  {
    if (TextUtils.isEmpty(this.mid)) {
      this.mid = this.name;
    }
    if (this.mRetryTimeInterval <= 0)
    {
      i = 24;
      this.mRetryTimeInterval = i;
      if (this.mRetryCount > 0) {
        break label56;
      }
    }
    label56:
    for (int i = 5;; i = this.mRetryCount)
    {
      this.mRetryCount = i;
      return;
      i = this.mRetryTimeInterval;
      break;
    }
  }
  
  public void deleteResFromServer(PreloadManager paramPreloadManager, int paramInt)
  {
    paramPreloadManager = this.mPreloadResources.iterator();
    while (paramPreloadManager.hasNext())
    {
      PreloadResource localPreloadResource = (PreloadResource)paramPreloadManager.next();
      if ((localPreloadResource.mIsFromLocal) || (localPreloadResource.mFromType == paramInt)) {
        this.mPreloadResources.remove(localPreloadResource);
      }
    }
  }
  
  public void downloadModule(boolean paramBoolean1, aquy paramaquy, PreloadManager paramPreloadManager, boolean paramBoolean2)
  {
    if (this.name.equals("wallet_offline")) {
      handleHtmlOffline(paramPreloadManager.mApp);
    }
    for (;;)
    {
      return;
      if ((paramBoolean1) || (!this.isForbidAutoDownload))
      {
        Iterator localIterator = this.mPreloadResources.iterator();
        while (localIterator.hasNext())
        {
          PreloadResource localPreloadResource = (PreloadResource)localIterator.next();
          if (!localPreloadResource.isInValidTime())
          {
            localPreloadResource.deleteResFile(this, paramPreloadManager, 6);
            this.mPreloadResources.remove(localPreloadResource);
          }
          else if ((localPreloadResource.isAbiMatch()) && (localPreloadResource.isTimeToDownload(paramPreloadManager)))
          {
            localPreloadResource.startDownload(paramPreloadManager, this, paramaquy, paramBoolean2);
          }
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof PreloadModule)))
    {
      paramObject = (PreloadModule)paramObject;
      if ((this.mid != null) && (this.mid.equals(paramObject.mid))) {
        return true;
      }
    }
    return false;
  }
  
  public void filterInvalidRes(PreloadManager paramPreloadManager)
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext())
    {
      PreloadResource localPreloadResource = (PreloadResource)localIterator.next();
      if (!localPreloadResource.isInValidTime())
      {
        localPreloadResource.deleteResFile(this, paramPreloadManager, 6);
        this.mPreloadResources.remove(localPreloadResource);
      }
      else if (localPreloadResource.handleAbnormalRetry(this))
      {
        this.mPreloadResources.remove(localPreloadResource);
        localPreloadResource.deleteResFile(this, paramPreloadManager, 9);
      }
    }
  }
  
  public int getModuleResSize()
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((PreloadResource)localIterator.next()).size + i) {}
    return i;
  }
  
  public List<PreloadResource> getResList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((PreloadResource)localIterator.next());
    }
    return localArrayList;
  }
  
  public int getResNum()
  {
    return this.mPreloadResources.size();
  }
  
  public PreloadResource getResourceByResId(String paramString)
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext())
    {
      PreloadResource localPreloadResource = (PreloadResource)localIterator.next();
      if (aagd.j(localPreloadResource.mResId, paramString)) {
        return localPreloadResource;
      }
    }
    return null;
  }
  
  public PreloadResource getResourceByType(int paramInt)
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext())
    {
      PreloadResource localPreloadResource = (PreloadResource)localIterator.next();
      if (localPreloadResource.type == paramInt) {
        return localPreloadResource;
      }
    }
    return null;
  }
  
  public void handleHtmlOffline(AppRuntime paramAppRuntime)
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext()) {
      c(((PreloadResource)localIterator.next()).url, paramAppRuntime);
    }
  }
  
  public boolean isModuleChange(PreloadModule paramPreloadModule)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!aagd.j(this.mid, paramPreloadModule.mid))
    {
      bool1 = true;
      return bool1;
    }
    if (this.mBackControl != paramPreloadModule.mBackControl) {
      return true;
    }
    if (!aagd.j(this.name, paramPreloadModule.name)) {
      return true;
    }
    if (this.option != paramPreloadModule.option) {
      return true;
    }
    if (this.isForbidAutoDownload != paramPreloadModule.isForbidAutoDownload) {
      return true;
    }
    if (this.mRetryTimeInterval != paramPreloadModule.mRetryTimeInterval) {
      return true;
    }
    if (this.mRetryCount != paramPreloadModule.mRetryCount) {
      return true;
    }
    if (!aagd.j(this.mBaseUrl, paramPreloadModule.mBaseUrl)) {
      return true;
    }
    List localList = getResList();
    if (localList.size() != paramPreloadModule.mPreloadResources.size()) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= localList.size()) {
        break;
      }
      if (((PreloadResource)localList.get(i)).isResChange((PreloadResource)paramPreloadModule.mPreloadResources.get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  public boolean isModuleFinish(PreloadManager paramPreloadManager)
  {
    paramPreloadManager = this.mPreloadResources.iterator();
    while (paramPreloadManager.hasNext()) {
      if (!((PreloadResource)paramPreloadManager.next()).isResFileExist(this)) {
        return false;
      }
    }
    return true;
  }
  
  public void removeResource(PreloadResource paramPreloadResource)
  {
    if (paramPreloadResource == null) {
      return;
    }
    this.mPreloadResources.remove(paramPreloadResource);
  }
  
  public String toString()
  {
    return "Module [mid=" + this.mid + ", mBC=" + this.mBackControl + ", mRes=" + this.mPreloadResources + "]";
  }
  
  public void updateNewModuleWhenReplace(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager, int paramInt)
  {
    Iterator localIterator = this.mPreloadResources.iterator();
    while (localIterator.hasNext())
    {
      PreloadResource localPreloadResource1 = (PreloadResource)localIterator.next();
      PreloadResource localPreloadResource2 = paramPreloadModule.getResourceByResId(localPreloadResource1.mResId);
      if (localPreloadResource2 == null)
      {
        if ((!localPreloadResource1.mIsFromLocal) && (paramInt != localPreloadResource1.mFromType)) {
          paramPreloadModule.mPreloadResources.add(localPreloadResource1);
        }
      }
      else if (localPreloadResource1.isNeedDeleteOldFileWhenUpdate(this, localPreloadResource2, paramPreloadManager)) {
        localPreloadResource1.deleteResFile(this, paramPreloadManager, 3);
      }
    }
  }
  
  public void updatePreloadModule(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager)
  {
    this.mid = paramPreloadModule.mid;
    this.mBackControl = paramPreloadModule.mBackControl;
    this.name = paramPreloadModule.name;
    this.option = paramPreloadModule.option;
    this.isForbidAutoDownload = paramPreloadModule.isForbidAutoDownload;
    this.mBaseUrl = paramPreloadModule.mBaseUrl;
    this.mRetryTimeInterval = paramPreloadModule.mRetryTimeInterval;
    this.mRetryCount = paramPreloadModule.mRetryCount;
    paramPreloadModule = paramPreloadModule.mPreloadResources.iterator();
    while (paramPreloadModule.hasNext())
    {
      PreloadResource localPreloadResource1 = (PreloadResource)paramPreloadModule.next();
      PreloadResource localPreloadResource2 = getResourceByResId(localPreloadResource1.mResId);
      if (localPreloadResource2 == null)
      {
        this.mPreloadResources.add(localPreloadResource1);
      }
      else
      {
        if (localPreloadResource2.isNeedDeleteOldFileWhenUpdate(this, localPreloadResource1, paramPreloadManager))
        {
          localPreloadResource2.deleteResFile(this, paramPreloadManager, 4);
          localPreloadResource2.mHasUnzip = false;
        }
        localPreloadResource2.mDownloadTime = localPreloadResource1.mDownloadTime;
        localPreloadResource2.mInvalidTime = localPreloadResource1.mInvalidTime;
        localPreloadResource2.md5 = localPreloadResource1.md5;
        localPreloadResource2.type = localPreloadResource1.type;
        localPreloadResource2.size = localPreloadResource1.size;
        localPreloadResource2.urlPath = localPreloadResource1.urlPath;
        localPreloadResource2.url = localPreloadResource1.url;
        localPreloadResource2.mResId = localPreloadResource1.mResId;
        localPreloadResource2.mFlowControl = localPreloadResource1.mFlowControl;
        localPreloadResource2.mIsFromLocal = localPreloadResource1.mIsFromLocal;
        localPreloadResource2.mIsTemp = localPreloadResource1.mIsTemp;
        localPreloadResource2.mIsNeedUnzip = localPreloadResource1.mIsNeedUnzip;
        localPreloadResource2.mIsUnzipInside = localPreloadResource1.mIsUnzipInside;
        localPreloadResource2.mUnzipPrefix = localPreloadResource1.mUnzipPrefix;
        localPreloadResource2.mFromType = localPreloadResource1.mFromType;
        localPreloadResource2.mFilePos = localPreloadResource1.mFilePos;
        localPreloadResource2.mAbi = localPreloadResource1.mAbi;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadModule
 * JD-Core Version:    0.7.0.1
 */