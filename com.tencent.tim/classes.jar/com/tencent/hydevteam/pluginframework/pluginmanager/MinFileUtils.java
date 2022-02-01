package com.tencent.hydevteam.pluginframework.pluginmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class MinFileUtils
{
  static void a(File paramFile)
    throws IOException
  {
    File localFile = paramFile.getParentFile();
    if ((!localFile.isDirectory()) && (!localFile.mkdirs())) {
      throw new IOException("创建父目录失败,文件目录:" + paramFile.getAbsolutePath() + " parent dir exists=" + localFile.exists());
    }
  }
  
  static List<File> b(File paramFile)
  {
    paramFile = paramFile.listFiles();
    LinkedList localLinkedList = new LinkedList();
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        if (!localObject.isDirectory()) {
          localLinkedList.add(localObject);
        }
        i += 1;
      }
      Collections.sort(localLinkedList, new MinFileUtils.1());
    }
    return localLinkedList;
  }
  
  static void c(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    label267:
    for (;;)
    {
      File localFile2;
      if (i < j) {
        localFile2 = arrayOfFile[i];
      }
      try
      {
        if (localFile2.isDirectory())
        {
          localFile1 = paramFile;
          if (!localFile2.exists()) {
            break label267;
          }
          c(localFile2);
          localFile1 = paramFile;
          if (localFile2.delete()) {
            break label267;
          }
          throw new IOException("Unable to delete directory " + localFile2 + ".");
        }
        boolean bool = localFile2.exists();
        File localFile1 = paramFile;
        if (localFile2.delete()) {
          break label267;
        }
        if (!bool) {
          throw new FileNotFoundException("File does not exist: " + localFile2);
        }
        throw new IOException("Unable to delete file: " + localFile2);
      }
      catch (IOException localIOException)
      {
        i += 1;
        paramFile = localIOException;
      }
      if (paramFile != null) {
        throw paramFile;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.MinFileUtils
 * JD-Core Version:    0.7.0.1
 */