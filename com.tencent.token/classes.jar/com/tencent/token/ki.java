package com.tencent.token;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import com.oasisfeng.condom.CondomCore;
import com.oasisfeng.condom.ContentResolverWrapper;

public final class ki
  extends ContentResolverWrapper
{
  private final CondomCore a;
  
  public ki(CondomCore paramCondomCore, Context paramContext, ContentResolver paramContentResolver)
  {
    super(paramContext, paramContentResolver);
    this.a = paramCondomCore;
  }
  
  public final IContentProvider acquireProvider(Context paramContext, String paramString)
  {
    if (!this.a.shouldAllowProvider(paramContext, paramString, 131072)) {
      return null;
    }
    return super.acquireProvider(paramContext, paramString);
  }
  
  public final IContentProvider acquireUnstableProvider(Context paramContext, String paramString)
  {
    if (!this.a.shouldAllowProvider(paramContext, paramString, 131072)) {
      return null;
    }
    return super.acquireUnstableProvider(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ki
 * JD-Core Version:    0.7.0.1
 */