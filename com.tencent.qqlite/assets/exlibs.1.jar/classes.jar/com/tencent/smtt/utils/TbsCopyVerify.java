package com.tencent.smtt.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TbsCopyVerify
{
  private static final String TAG = "TbsCopyVerify";
  private FileInfoSet mReferenceFileSet = null;
  private FileInfoSet mVerifyFileSet = null;
  
  private boolean equal(FileInfoSet paramFileInfoSet1, FileInfoSet paramFileInfoSet2)
  {
    Object localObject1;
    if ((paramFileInfoSet1 != null) && (paramFileInfoSet1.get() != null) && (paramFileInfoSet2 != null) && (paramFileInfoSet2.get() != null))
    {
      localObject1 = paramFileInfoSet1.get();
      paramFileInfoSet1 = paramFileInfoSet2.get();
      paramFileInfoSet2 = ((Map)localObject1).entrySet().iterator();
    }
    while (paramFileInfoSet2.hasNext())
    {
      Object localObject2 = (Map.Entry)paramFileInfoSet2.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (FileInfo)((Map.Entry)localObject2).getValue();
      if (paramFileInfoSet1.containsKey(localObject1))
      {
        localObject1 = (FileInfo)paramFileInfoSet1.get(localObject1);
        if ((((FileInfo)localObject2).getFileSize() == ((FileInfo)localObject1).getFileSize()) && (((FileInfo)localObject2).getLastModify() == ((FileInfo)localObject1).getLastModify())) {
          break;
        }
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public void generateReferenceValue(File paramFile)
  {
    this.mReferenceFileSet = new FileInfoSet(paramFile);
  }
  
  public void generateVerifyValue(File paramFile)
  {
    this.mVerifyFileSet = new FileInfoSet(paramFile);
  }
  
  public boolean verify()
  {
    if ((this.mVerifyFileSet == null) || (this.mReferenceFileSet == null)) {}
    while ((this.mVerifyFileSet.get().size() != this.mReferenceFileSet.get().size()) || (!equal(this.mReferenceFileSet, this.mVerifyFileSet))) {
      return false;
    }
    return true;
  }
  
  class FileInfo
  {
    private long mFileSize;
    private long mLastModify;
    private String mName;
    
    FileInfo(String paramString, long paramLong1, long paramLong2)
    {
      this.mName = paramString;
      this.mFileSize = paramLong1;
      this.mLastModify = paramLong2;
    }
    
    long getFileSize()
    {
      return this.mFileSize;
    }
    
    long getLastModify()
    {
      return this.mLastModify;
    }
    
    String getName()
    {
      return this.mName;
    }
  }
  
  class FileInfoSet
  {
    private Map<String, TbsCopyVerify.FileInfo> mFileMap = new HashMap();
    
    FileInfoSet(File paramFile)
    {
      this.mFileMap.clear();
      generateFileInfo(paramFile);
    }
    
    private void generateFileInfo(File paramFile)
    {
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        int i = 0;
        while (i < paramFile.length)
        {
          generateFileInfo(paramFile[i]);
          i += 1;
        }
      }
      if (paramFile.isFile()) {
        generateFileInfo(paramFile.getName(), paramFile.length(), paramFile.lastModified());
      }
    }
    
    private void generateFileInfo(String paramString, long paramLong1, long paramLong2)
    {
      if ((paramString != null) && (paramString.length() > 0) && (paramLong1 > 0L) && (paramLong2 > 0L))
      {
        TbsCopyVerify.FileInfo localFileInfo = new TbsCopyVerify.FileInfo(TbsCopyVerify.this, paramString, paramLong1, paramLong2);
        if (!this.mFileMap.containsKey(paramString)) {
          this.mFileMap.put(paramString, localFileInfo);
        }
      }
    }
    
    Map<String, TbsCopyVerify.FileInfo> get()
    {
      return this.mFileMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsCopyVerify
 * JD-Core Version:    0.7.0.1
 */