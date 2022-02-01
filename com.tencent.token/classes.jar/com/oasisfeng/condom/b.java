package com.oasisfeng.condom;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;

class b
  extends ContentResolverWrapper
{
  private final CondomCore a;
  
  b(CondomCore paramCondomCore, Context paramContext, ContentResolver paramContentResolver)
  {
    super(paramContext, paramContentResolver);
    this.a = paramCondomCore;
  }
  
  public IContentProvider acquireProvider(Context paramContext, String paramString)
  {
    if (!this.a.shouldAllowProvider(paramContext, paramString, 131072)) {
      return null;
    }
    return super.acquireProvider(paramContext, paramString);
  }
  
  public IContentProvider acquireUnstableProvider(Context paramContext, String paramString)
  {
    if (!this.a.shouldAllowProvider(paramContext, paramString, 131072)) {
      return null;
    }
    return super.acquireUnstableProvider(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.b
 * JD-Core Version:    0.7.0.1
 */