package com.tencent.mm.vfs;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.Map;

public abstract interface FileSystem
  extends Parcelable
{
  public static final int CAP_DIRECTORIES = 8;
  public static final int CAP_DIRECT_ACCESS = 2;
  public static final int CAP_LISTABLE = 4;
  public static final int CAP_SEEKABLE = 16;
  public static final int CAP_WRITABLE = 1;
  
  public abstract int batchDelete(List<String> paramList);
  
  public abstract int capabilityFlags();
  
  public abstract void configure(Map<String, String> paramMap);
  
  public abstract long copyFile(String paramString1, FileSystem paramFileSystem, String paramString2)
    throws IOException;
  
  public abstract boolean delete(String paramString);
  
  public abstract boolean deleteDir(String paramString, boolean paramBoolean);
  
  public abstract boolean exists(String paramString);
  
  public abstract FsStat fileSystemStat(String paramString);
  
  public abstract Iterable<FileEntry> list(String paramString, boolean paramBoolean);
  
  public abstract void maintain(CancellationSignalCompat paramCancellationSignalCompat);
  
  public abstract boolean mkdirs(String paramString);
  
  public abstract boolean moveFile(String paramString1, FileSystem paramFileSystem, String paramString2)
    throws IOException;
  
  public abstract ParcelFileDescriptor openParcelFd(String paramString1, String paramString2)
    throws FileNotFoundException;
  
  public abstract InputStream openRead(String paramString)
    throws FileNotFoundException;
  
  public abstract ReadableByteChannel openReadChannel(String paramString)
    throws FileNotFoundException;
  
  public abstract ByteChannel openReadWriteChannel(String paramString)
    throws FileNotFoundException;
  
  public abstract OutputStream openWrite(String paramString, boolean paramBoolean)
    throws FileNotFoundException;
  
  public abstract WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
    throws FileNotFoundException;
  
  public abstract String realPath(String paramString, boolean paramBoolean);
  
  public abstract boolean setModifiedTime(String paramString, long paramLong);
  
  public abstract FileEntry stat(String paramString);
  
  public static class FileEntry
  {
    public final long diskSpace;
    final FileSystem fileSystem;
    public final boolean isDirectory;
    public final long modifiedTime;
    public final String name;
    public final String relPath;
    public final long size;
    
    public FileEntry(FileSystem paramFileSystem, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
    {
      this.fileSystem = paramFileSystem;
      this.relPath = paramString1;
      this.name = paramString2;
      this.size = paramLong1;
      this.diskSpace = paramLong2;
      this.modifiedTime = paramLong3;
      this.isDirectory = paramBoolean;
    }
    
    public boolean delete()
    {
      if (this.isDirectory) {
        return this.fileSystem.deleteDir(this.relPath, false);
      }
      return this.fileSystem.delete(this.relPath);
    }
    
    public InputStream openRead()
      throws FileNotFoundException
    {
      return this.fileSystem.openRead(this.relPath);
    }
    
    public OutputStream openWrite(boolean paramBoolean)
      throws FileNotFoundException
    {
      return this.fileSystem.openWrite(this.relPath, paramBoolean);
    }
    
    public String toString()
    {
      String str2 = this.relPath + " -> " + this.fileSystem.toString();
      String str1 = str2;
      if (this.isDirectory) {
        str1 = "[DIR] " + str2;
      }
      return str1;
    }
  }
  
  public static class FsStat
  {
    public long availableBlocks;
    public long availableSpace;
    public long blockSize;
    public long totalBlocks;
    public long totalSpace;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem
 * JD-Core Version:    0.7.0.1
 */