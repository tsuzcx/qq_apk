package org.apache.commons.io.monitor;

import java.io.File;
import java.io.Serializable;

public class FileEntry
  implements Serializable
{
  static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
  private static final long serialVersionUID = -2505664948818681153L;
  private FileEntry[] children;
  private boolean directory;
  private boolean exists;
  private final File file;
  private long lastModified;
  private long length;
  private String name;
  private final FileEntry parent;
  
  public FileEntry(File paramFile)
  {
    this(null, paramFile);
  }
  
  public FileEntry(FileEntry paramFileEntry, File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("File is missing");
    }
    this.file = paramFile;
    this.parent = paramFileEntry;
    this.name = paramFile.getName();
  }
  
  public FileEntry[] getChildren()
  {
    if (this.children != null) {
      return this.children;
    }
    return EMPTY_ENTRIES;
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  public long getLastModified()
  {
    return this.lastModified;
  }
  
  public long getLength()
  {
    return this.length;
  }
  
  public int getLevel()
  {
    if (this.parent == null) {
      return 0;
    }
    return this.parent.getLevel() + 1;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public FileEntry getParent()
  {
    return this.parent;
  }
  
  public boolean isDirectory()
  {
    return this.directory;
  }
  
  public boolean isExists()
  {
    return this.exists;
  }
  
  public FileEntry newChildInstance(File paramFile)
  {
    return new FileEntry(this, paramFile);
  }
  
  public boolean refresh(File paramFile)
  {
    long l2 = 0L;
    boolean bool2 = false;
    boolean bool3 = this.exists;
    long l3 = this.lastModified;
    boolean bool4 = this.directory;
    long l4 = this.length;
    this.name = paramFile.getName();
    this.exists = paramFile.exists();
    boolean bool1;
    if ((this.exists) && (paramFile.isDirectory()))
    {
      bool1 = true;
      this.directory = bool1;
      if (!this.exists) {
        break label170;
      }
    }
    label170:
    for (long l1 = paramFile.lastModified();; l1 = 0L)
    {
      this.lastModified = l1;
      l1 = l2;
      if (this.exists)
      {
        l1 = l2;
        if (!this.directory) {
          l1 = paramFile.length();
        }
      }
      this.length = l1;
      if ((this.exists == bool3) && (this.lastModified == l3) && (this.directory == bool4))
      {
        bool1 = bool2;
        if (this.length == l4) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public void setChildren(FileEntry[] paramArrayOfFileEntry)
  {
    this.children = paramArrayOfFileEntry;
  }
  
  public void setDirectory(boolean paramBoolean)
  {
    this.directory = paramBoolean;
  }
  
  public void setExists(boolean paramBoolean)
  {
    this.exists = paramBoolean;
  }
  
  public void setLastModified(long paramLong)
  {
    this.lastModified = paramLong;
  }
  
  public void setLength(long paramLong)
  {
    this.length = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.monitor.FileEntry
 * JD-Core Version:    0.7.0.1
 */