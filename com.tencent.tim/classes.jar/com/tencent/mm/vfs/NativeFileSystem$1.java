package com.tencent.mm.vfs;

import java.io.File;
import java.util.Iterator;

class NativeFileSystem$1
  implements Iterable<FileSystem.FileEntry>
{
  NativeFileSystem$1(NativeFileSystem paramNativeFileSystem, File paramFile, boolean paramBoolean) {}
  
  public Iterator<FileSystem.FileEntry> iterator()
  {
    return new NativeFileSystem.1.1(this, this.val$dir, false, this.val$recursive);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem.1
 * JD-Core Version:    0.7.0.1
 */