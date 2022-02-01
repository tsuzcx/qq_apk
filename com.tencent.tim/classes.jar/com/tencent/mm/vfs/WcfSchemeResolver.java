package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import java.util.Map;

public final class WcfSchemeResolver
  extends SchemeResolver.Base
{
  public static final SingletonCreator CREATOR = new SingletonCreator(null);
  
  public static WcfSchemeResolver instance()
  {
    return SingletonCreator.INSTANCE;
  }
  
  public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    FileSystem localFileSystem = (FileSystem)((ResolverState)paramResolverContext).mFileSystems.get(paramUri.getAuthority());
    paramResolverContext = paramUri.getPath();
    if (paramResolverContext == null) {}
    for (paramResolverContext = "";; paramResolverContext = VFSUtils.normalizePath(paramResolverContext, true, true)) {
      return new Pair(localFileSystem, paramResolverContext);
    }
  }
  
  static class SingletonCreator
    implements Parcelable.Creator<WcfSchemeResolver>
  {
    static final WcfSchemeResolver INSTANCE = new WcfSchemeResolver(null);
    
    public WcfSchemeResolver createFromParcel(Parcel paramParcel)
    {
      return INSTANCE;
    }
    
    public WcfSchemeResolver[] newArray(int paramInt)
    {
      return new WcfSchemeResolver[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.WcfSchemeResolver
 * JD-Core Version:    0.7.0.1
 */