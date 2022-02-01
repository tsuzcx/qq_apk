package com.tencent.beacon.a.c;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class d
  implements FileFilter
{
  d(e parame) {}
  
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.c.d
 * JD-Core Version:    0.7.0.1
 */