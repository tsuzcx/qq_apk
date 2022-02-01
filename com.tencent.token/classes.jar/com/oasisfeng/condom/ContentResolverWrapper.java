package com.oasisfeng.condom;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import android.content.UriPermission;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

@Keep
public class ContentResolverWrapper
  extends ContentResolver
{
  private final ContentResolver mBase;
  
  protected ContentResolverWrapper(Context paramContext, ContentResolver paramContentResolver)
  {
    super(paramContext);
    this.mBase = paramContentResolver;
  }
  
  public IContentProvider acquireExistingProvider(Context paramContext, String paramString)
  {
    return this.mBase.acquireExistingProvider(paramContext, paramString);
  }
  
  public IContentProvider acquireProvider(Context paramContext, String paramString)
  {
    return this.mBase.acquireProvider(paramContext, paramString);
  }
  
  public IContentProvider acquireUnstableProvider(Context paramContext, String paramString)
  {
    return this.mBase.acquireUnstableProvider(paramContext, paramString);
  }
  
  public ContentProviderResult[] applyBatch(String paramString, ArrayList<ContentProviderOperation> paramArrayList)
  {
    return this.mBase.applyBatch(paramString, paramArrayList);
  }
  
  public void cancelSync(Uri paramUri)
  {
    this.mBase.cancelSync(paramUri);
  }
  
  public List<UriPermission> getOutgoingPersistedUriPermissions()
  {
    return this.mBase.getOutgoingPersistedUriPermissions();
  }
  
  public List<UriPermission> getPersistedUriPermissions()
  {
    return this.mBase.getPersistedUriPermissions();
  }
  
  public String[] getStreamTypes(Uri paramUri, String paramString)
  {
    return this.mBase.getStreamTypes(paramUri, paramString);
  }
  
  public void notifyChange(Uri paramUri, ContentObserver paramContentObserver)
  {
    this.mBase.notifyChange(paramUri, paramContentObserver);
  }
  
  public void notifyChange(Uri paramUri, ContentObserver paramContentObserver, int paramInt)
  {
    this.mBase.notifyChange(paramUri, paramContentObserver, paramInt);
  }
  
  public void notifyChange(Uri paramUri, ContentObserver paramContentObserver, boolean paramBoolean)
  {
    this.mBase.notifyChange(paramUri, paramContentObserver, paramBoolean);
  }
  
  public void releasePersistableUriPermission(Uri paramUri, int paramInt)
  {
    this.mBase.releasePersistableUriPermission(paramUri, paramInt);
  }
  
  public boolean releaseProvider(IContentProvider paramIContentProvider)
  {
    return this.mBase.releaseProvider(paramIContentProvider);
  }
  
  public boolean releaseUnstableProvider(IContentProvider paramIContentProvider)
  {
    return this.mBase.releaseUnstableProvider(paramIContentProvider);
  }
  
  public void startSync(Uri paramUri, Bundle paramBundle)
  {
    this.mBase.startSync(paramUri, paramBundle);
  }
  
  public void takePersistableUriPermission(Uri paramUri, int paramInt)
  {
    this.mBase.takePersistableUriPermission(paramUri, paramInt);
  }
  
  public void takePersistableUriPermission(String paramString, Uri paramUri, int paramInt)
  {
    this.mBase.takePersistableUriPermission(paramString, paramUri, paramInt);
  }
  
  public void unstableProviderDied(IContentProvider paramIContentProvider)
  {
    this.mBase.unstableProviderDied(paramIContentProvider);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.ContentResolverWrapper
 * JD-Core Version:    0.7.0.1
 */