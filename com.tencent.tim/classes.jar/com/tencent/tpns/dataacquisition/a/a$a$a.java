package com.tencent.tpns.dataacquisition.a;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class a$a$a
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.dataacquisition.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */