package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class FileSchemeResolver
  extends SchemeResolver.Base
{
  public static final SingletonCreator CREATOR = new SingletonCreator(null);
  private static final String TAG = "VFS.FileSchemeResolver";
  
  private static String canonicalizePath(String paramString)
  {
    paramString = new File(paramString);
    try
    {
      String str = paramString.getCanonicalPath();
      return str;
    }
    catch (IOException localIOException) {}
    return paramString.getAbsolutePath();
  }
  
  public static FileSchemeResolver instance()
  {
    return SingletonCreator.INSTANCE;
  }
  
  private Pair<ResolverState.MountPointEntry, String> resolveMountPoint(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    Object localObject = ((ResolverState)paramResolverContext).mActiveMountPoints;
    paramResolverContext = paramUri.getPath();
    if ((paramResolverContext == null) || (paramResolverContext.isEmpty()))
    {
      QLog.e("VFS.FileSchemeResolver", 1, "resolveMountPoint is wrong! " + paramUri.toString());
      return null;
    }
    String str = canonicalizePath(paramResolverContext);
    int i = Collections.binarySearch((List)localObject, str);
    if (i >= 0)
    {
      localObject = (ResolverState.MountPointEntry)((List)localObject).get(i);
      paramResolverContext = "";
    }
    for (;;)
    {
      return new Pair(localObject, paramResolverContext);
      label179:
      for (i = -i - 2;; i = paramResolverContext.fallbackIndex)
      {
        if (i < 0) {
          paramUri = null;
        }
        do
        {
          if (i < 0) {
            break label187;
          }
          paramResolverContext = str.substring(paramUri.basePath.length() + 1);
          localObject = paramUri;
          break;
          paramResolverContext = (ResolverState.MountPointEntry)((List)localObject).get(i);
          if (!str.startsWith(paramResolverContext.basePath)) {
            break label179;
          }
          paramUri = paramResolverContext;
        } while (str.charAt(paramResolverContext.basePath.length()) == '/');
      }
      label187:
      localObject = paramUri;
      paramResolverContext = str;
      if (!str.isEmpty())
      {
        localObject = paramUri;
        paramResolverContext = str;
        if (str.charAt(0) == '/')
        {
          paramResolverContext = str.substring(1);
          localObject = paramUri;
        }
      }
    }
  }
  
  public Uri exportUri(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    paramResolverContext = resolveMountPoint(paramResolverContext, paramUri);
    if ((paramResolverContext == null) || (paramResolverContext.first == null)) {
      return null;
    }
    return new Uri.Builder().scheme("wcf").authority(((ResolverState.MountPointEntry)paramResolverContext.first).fileSystemName).path((String)paramResolverContext.second).build();
  }
  
  public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    paramUri = resolveMountPoint(paramResolverContext, paramUri);
    if (paramUri == null) {
      return null;
    }
    if (paramUri.first == null) {}
    for (paramResolverContext = paramResolverContext.root();; paramResolverContext = ((ResolverState.MountPointEntry)paramUri.first).fileSystem) {
      return new Pair(paramResolverContext, paramUri.second);
    }
  }
  
  static class SingletonCreator
    implements Parcelable.Creator<FileSchemeResolver>
  {
    static final FileSchemeResolver INSTANCE = new FileSchemeResolver(null);
    
    public FileSchemeResolver createFromParcel(Parcel paramParcel)
    {
      return INSTANCE;
    }
    
    public FileSchemeResolver[] newArray(int paramInt)
    {
      return new FileSchemeResolver[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSchemeResolver
 * JD-Core Version:    0.7.0.1
 */