package com.squareup.okhttp.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Sink;
import okio.Source;

public abstract interface FileSystem
{
  public static final FileSystem SYSTEM = new FileSystem.1();
  
  public abstract Sink appendingSink(File paramFile)
    throws FileNotFoundException;
  
  public abstract void delete(File paramFile)
    throws IOException;
  
  public abstract void deleteContents(File paramFile)
    throws IOException;
  
  public abstract boolean exists(File paramFile)
    throws IOException;
  
  public abstract void rename(File paramFile1, File paramFile2)
    throws IOException;
  
  public abstract Sink sink(File paramFile)
    throws FileNotFoundException;
  
  public abstract long size(File paramFile);
  
  public abstract Source source(File paramFile)
    throws FileNotFoundException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.io.FileSystem
 * JD-Core Version:    0.7.0.1
 */