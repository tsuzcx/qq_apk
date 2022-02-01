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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;

@Keep
@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class ContentResolverWrapper
  extends ContentResolver
{
  private final ContentResolver mBase;
  
  ContentResolverWrapper(Context paramContext, ContentResolver paramContentResolver)
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
  
  @NonNull
  public ContentProviderResult[] applyBatch(@NonNull String paramString, @NonNull ArrayList<ContentProviderOperation> paramArrayList)
  {
    return this.mBase.applyBatch(paramString, paramArrayList);
  }
  
  public void cancelSync(Uri paramUri)
  {
    this.mBase.cancelSync(paramUri);
  }
  
  @NonNull
  @RequiresApi(19)
  public List<UriPermission> getOutgoingPersistedUriPermissions()
  {
    return this.mBase.getOutgoingPersistedUriPermissions();
  }
  
  @NonNull
  @RequiresApi(19)
  public List<UriPermission> getPersistedUriPermissions()
  {
    return this.mBase.getPersistedUriPermissions();
  }
  
  @Nullable
  @RequiresApi(11)
  public String[] getStreamTypes(@NonNull Uri paramUri, @NonNull String paramString)
  {
    return this.mBase.getStreamTypes(paramUri, paramString);
  }
  
  public void notifyChange(@NonNull Uri paramUri, @Nullable ContentObserver paramContentObserver)
  {
    this.mBase.notifyChange(paramUri, paramContentObserver);
  }
  
  @RequiresApi(24)
  public void notifyChange(@NonNull Uri paramUri, @Nullable ContentObserver paramContentObserver, int paramInt)
  {
    this.mBase.notifyChange(paramUri, paramContentObserver, paramInt);
  }
  
  public void notifyChange(@NonNull Uri paramUri, @Nullable ContentObserver paramContentObserver, boolean paramBoolean)
  {
    this.mBase.notifyChange(paramUri, paramContentObserver, paramBoolean);
  }
  
  @RequiresApi(19)
  public void releasePersistableUriPermission(@NonNull Uri paramUri, int paramInt)
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
  
  @RequiresApi(19)
  public void takePersistableUriPermission(@NonNull Uri paramUri, int paramInt)
  {
    this.mBase.takePersistableUriPermission(paramUri, paramInt);
  }
  
  @RequiresApi(28)
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