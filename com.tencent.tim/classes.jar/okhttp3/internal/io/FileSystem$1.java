package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

class FileSystem$1
  implements FileSystem
{
  public Sink appendingSink(File paramFile)
    throws FileNotFoundException
  {
    try
    {
      Sink localSink = Okio.appendingSink(paramFile);
      return localSink;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      paramFile.getParentFile().mkdirs();
    }
    return Okio.appendingSink(paramFile);
  }
  
  public void delete(File paramFile)
    throws IOException
  {
    if ((!paramFile.delete()) && (paramFile.exists())) {
      throw new IOException("failed to delete " + paramFile);
    }
  }
  
  public void deleteContents(File paramFile)
    throws IOException
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("not a readable directory: " + paramFile);
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      paramFile = arrayOfFile[i];
      if (paramFile.isDirectory()) {
        deleteContents(paramFile);
      }
      if (!paramFile.delete()) {
        throw new IOException("failed to delete " + paramFile);
      }
      i += 1;
    }
  }
  
  public boolean exists(File paramFile)
  {
    return paramFile.exists();
  }
  
  public void rename(File paramFile1, File paramFile2)
    throws IOException
  {
    delete(paramFile2);
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException("failed to rename " + paramFile1 + " to " + paramFile2);
    }
  }
  
  public Sink sink(File paramFile)
    throws FileNotFoundException
  {
    try
    {
      Sink localSink = Okio.sink(paramFile);
      return localSink;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      paramFile.getParentFile().mkdirs();
    }
    return Okio.sink(paramFile);
  }
  
  public long size(File paramFile)
  {
    return paramFile.length();
  }
  
  public Source source(File paramFile)
    throws FileNotFoundException
  {
    return Okio.source(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.io.FileSystem.1
 * JD-Core Version:    0.7.0.1
 */