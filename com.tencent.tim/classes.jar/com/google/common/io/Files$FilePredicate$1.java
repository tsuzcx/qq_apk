package com.google.common.io;

import java.io.File;

 enum Files$FilePredicate$1
{
  Files$FilePredicate$1()
  {
    super(str, i, null);
  }
  
  public boolean apply(File paramFile)
  {
    return paramFile.isDirectory();
  }
  
  public String toString()
  {
    return "Files.isDirectory()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.Files.FilePredicate.1
 * JD-Core Version:    0.7.0.1
 */