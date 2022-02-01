package com.tencent.mm.vfs;

import java.util.Iterator;

class DelegateFileSystem$1$1
  extends VFSUtils.CascadeIterator<FileSystem, FileSystem.FileEntry>
{
  DelegateFileSystem$1$1(DelegateFileSystem.1 param1, Iterator paramIterator)
  {
    super(paramIterator);
  }
  
  protected FileSystem.FileEntry convert(FileSystem paramFileSystem)
  {
    return null;
  }
  
  protected Iterator<? extends FileSystem.FileEntry> traversal(FileSystem paramFileSystem, FileSystem.FileEntry paramFileEntry)
  {
    paramFileSystem = paramFileSystem.list(this.this$1.val$prefix, this.this$1.val$recursive);
    if (paramFileSystem == null) {
      return null;
    }
    return paramFileSystem.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.DelegateFileSystem.1.1
 * JD-Core Version:    0.7.0.1
 */