package com.tencent.mm.vfs;

import java.util.Comparator;

class QuotaFileSystem$1
  implements Comparator<FileSystem.FileEntry>
{
  private final long timeThreshold = System.currentTimeMillis() - QuotaFileSystem.access$000(this.this$0);
  
  QuotaFileSystem$1(QuotaFileSystem paramQuotaFileSystem) {}
  
  public int compare(FileSystem.FileEntry paramFileEntry1, FileSystem.FileEntry paramFileEntry2)
  {
    if ((paramFileEntry1.modifiedTime >= this.timeThreshold) || (paramFileEntry2.modifiedTime >= this.timeThreshold))
    {
      int i = QuotaFileSystem.access$100(paramFileEntry2.modifiedTime - paramFileEntry1.modifiedTime);
      if (i != 0) {
        return i;
      }
    }
    return QuotaFileSystem.access$100(paramFileEntry1.diskSpace - paramFileEntry2.diskSpace);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem.1
 * JD-Core Version:    0.7.0.1
 */