package com.tencent.mm.vfs;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

class NativeFileSystem$1$1
  extends NativeFileSystem.FileEntryIterator
{
  NativeFileSystem$1$1(NativeFileSystem.1 param1, File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(param1.this$0, paramFile, paramBoolean1, paramBoolean2);
  }
  
  protected FileSystem.FileEntry convert(File paramFile)
  {
    return null;
  }
  
  protected Iterator<? extends FileSystem.FileEntry> traversal(File paramFile, FileSystem.FileEntry paramFileEntry)
  {
    paramFile = paramFile.listFiles();
    if (paramFile == null) {
      return null;
    }
    return new NativeFileSystem.FileEntryIterator(this.this$1.this$0, Arrays.asList(paramFile), this.mChildrenFirst, this.this$1.val$recursive, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem.1.1
 * JD-Core Version:    0.7.0.1
 */