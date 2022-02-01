package com.tencent.mm.vfs;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import java.util.Map;
import java.util.SortedMap;

public abstract interface SchemeResolver
  extends Parcelable
{
  public abstract void configure(Map<String, String> paramMap);
  
  public abstract Uri exportUri(ResolverContext paramResolverContext, Uri paramUri);
  
  public abstract void maintain(CancellationSignalCompat paramCancellationSignalCompat);
  
  public abstract Pair<FileSystem, String> resolve(ResolverContext paramResolverContext, Uri paramUri);
  
  public static abstract class Base
    implements SchemeResolver
  {
    public void configure(Map<String, String> paramMap) {}
    
    public int describeContents()
    {
      return 0;
    }
    
    public Uri exportUri(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
    {
      Uri localUri = paramUri;
      if (resolve(paramResolverContext, paramUri) == null) {
        localUri = null;
      }
      return localUri;
    }
    
    public void maintain(CancellationSignalCompat paramCancellationSignalCompat) {}
    
    public void writeToParcel(Parcel paramParcel, int paramInt) {}
  }
  
  public static abstract interface ResolverContext
  {
    public abstract SortedMap<String, FileSystem> activeMountPoints();
    
    public abstract Map<String, String> envVars();
    
    public abstract Map<String, FileSystem> fileSystems();
    
    public abstract FileSystem root();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.SchemeResolver
 * JD-Core Version:    0.7.0.1
 */