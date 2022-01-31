package com.tmsdk.base.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class PhoneInfoFetcher$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.PhoneInfoFetcher.1
 * JD-Core Version:    0.7.0.1
 */