package oicq.wlogin_sdk.tools;

import java.io.File;
import java.io.FilenameFilter;

final class h
  implements FilenameFilter
{
  public final boolean accept(File paramFile, String paramString)
  {
    return paramString.matches("wtlogin_[0-9]+\\.log");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.h
 * JD-Core Version:    0.7.0.1
 */