package com.tencent.mm.vfs;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class AssetsSchemeResolver
  extends SchemeResolver.Base
{
  public static final SingletonCreator CREATOR = new SingletonCreator(null);
  private final AssetsFileSystem mFileSystem = new AssetsFileSystem(FileSystemManager.instance().getContext());
  
  public static AssetsSchemeResolver instance()
  {
    return SingletonCreator.INSTANCE;
  }
  
  public Pair<FileSystem, String> resolve(SchemeResolver.ResolverContext paramResolverContext, Uri paramUri)
  {
    paramResolverContext = paramUri.getPath();
    if (paramResolverContext == null) {}
    for (paramResolverContext = "";; paramResolverContext = VFSUtils.normalizePath(paramResolverContext, true, true)) {
      return new Pair(this.mFileSystem, paramResolverContext);
    }
  }
  
  static final class AssetsFileSystem
    extends AbstractFileSystem
  {
    public static final Parcelable.Creator<AssetsFileSystem> CREATOR = null;
    private AssetManager mAssets;
    
    AssetsFileSystem(Context paramContext)
    {
      this.mAssets = paramContext.getAssets();
    }
    
    private void recursiveList(String paramString1, String paramString2, ArrayList<FileSystem.FileEntry> paramArrayList)
      throws IOException
    {
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        if (paramString1.isEmpty()) {
          paramString1 = paramString2;
        }
      }
      for (;;)
      {
        String[] arrayOfString = this.mAssets.list(paramString1);
        if ((arrayOfString == null) || (arrayOfString.length == 0)) {
          if (paramString2 != null) {
            paramArrayList.add(new FileSystem.FileEntry(this, paramString1, paramString2, 0L, 0L, 0L, false));
          }
        }
        for (;;)
        {
          return;
          paramString1 = paramString1 + '/' + paramString2;
          break;
          if (paramString2 != null) {
            paramArrayList.add(new FileSystem.FileEntry(this, paramString1, paramString2, 0L, 0L, 0L, true));
          }
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            paramString2 = arrayOfString[i];
            if ((paramString2 != null) && (!paramString2.isEmpty())) {
              recursiveList(paramString1, paramString2, paramArrayList);
            }
            i += 1;
          }
        }
      }
    }
    
    public int batchDelete(List<String> paramList)
    {
      return 0;
    }
    
    public int capabilityFlags()
    {
      return 12;
    }
    
    protected long copyFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
      throws IOException
    {
      throw new IOException("Not implemented");
    }
    
    public boolean delete(String paramString)
    {
      return false;
    }
    
    public boolean deleteDir(String paramString, boolean paramBoolean)
    {
      return false;
    }
    
    public boolean exists(String paramString)
    {
      try
      {
        openRead(paramString).close();
        return true;
      }
      catch (IOException paramString) {}
      return false;
    }
    
    public FileSystem.FsStat fileSystemStat(String paramString)
    {
      return new FileSystem.FsStat();
    }
    
    public Iterable<FileSystem.FileEntry> list(String paramString, boolean paramBoolean)
    {
      String str1 = paramString;
      if (paramString.endsWith("/")) {
        str1 = paramString.substring(0, paramString.length() - 1);
      }
      if (paramBoolean) {}
      try
      {
        paramString = new ArrayList();
        recursiveList(str1, null, paramString);
        return paramString;
      }
      catch (IOException paramString) {}
      paramString = this.mAssets.list(str1);
      if (paramString == null) {
        return null;
      }
      str1 = str1 + '/';
      ArrayList localArrayList = new ArrayList(paramString.length);
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        String str2 = paramString[i];
        String str3 = str1 + str2;
        String[] arrayOfString = this.mAssets.list(str3);
        if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localArrayList.add(new FileSystem.FileEntry(this, str3, str2, 0L, 0L, 0L, paramBoolean));
          i += 1;
          break;
        }
      }
      return localArrayList;
      return null;
    }
    
    public boolean mkdirs(String paramString)
    {
      return false;
    }
    
    protected boolean moveFileImpl(String paramString1, FileSystem paramFileSystem, String paramString2)
      throws IOException
    {
      throw new IOException("Not implemented");
    }
    
    public InputStream openRead(String paramString)
      throws FileNotFoundException
    {
      try
      {
        paramString = this.mAssets.open(paramString);
        return paramString;
      }
      catch (IOException paramString)
      {
        if ((paramString instanceof FileNotFoundException)) {
          throw ((FileNotFoundException)paramString);
        }
        throw new FileNotFoundException(paramString.getMessage());
      }
    }
    
    public OutputStream openWrite(String paramString, boolean paramBoolean)
      throws FileNotFoundException
    {
      throw new FileNotFoundException("Cannot open files for writing on read-only filesystems");
    }
    
    public String realPath(String paramString, boolean paramBoolean)
    {
      return null;
    }
    
    public boolean setModifiedTime(String paramString, long paramLong)
    {
      return false;
    }
    
    public FileSystem.FileEntry stat(String paramString)
    {
      for (;;)
      {
        int j;
        try
        {
          localObject = openRead(paramString);
          int i = ((InputStream)localObject).available();
          ((InputStream)localObject).close();
          j = paramString.lastIndexOf('/');
          if (j < 0)
          {
            localObject = paramString;
            return new FileSystem.FileEntry(this, paramString, (String)localObject, i, 0L, 0L, false);
          }
        }
        catch (IOException paramString)
        {
          return null;
        }
        Object localObject = paramString.substring(j + 1);
      }
    }
    
    public String toString()
    {
      return "AssetsFS";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static class SingletonCreator
    implements Parcelable.Creator<AssetsSchemeResolver>
  {
    static final AssetsSchemeResolver INSTANCE = new AssetsSchemeResolver(null);
    
    public AssetsSchemeResolver createFromParcel(Parcel paramParcel)
    {
      return INSTANCE;
    }
    
    public AssetsSchemeResolver[] newArray(int paramInt)
    {
      return new AssetsSchemeResolver[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.AssetsSchemeResolver
 * JD-Core Version:    0.7.0.1
 */