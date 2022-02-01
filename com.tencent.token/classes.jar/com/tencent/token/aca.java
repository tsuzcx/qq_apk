package com.tencent.token;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public final class aca
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aca
 * JD-Core Version:    0.7.0.1
 */