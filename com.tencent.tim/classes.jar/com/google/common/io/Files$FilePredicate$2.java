package com.google.common.io;

import java.io.File;

 enum Files$FilePredicate$2
{
  Files$FilePredicate$2()
  {
    super(str, i, null);
  }
  
  public boolean apply(File paramFile)
  {
    return paramFile.isFile();
  }
  
  public String toString()
  {
    return "Files.isFile()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.Files.FilePredicate.2
 * JD-Core Version:    0.7.0.1
 */