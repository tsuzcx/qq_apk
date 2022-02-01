package com.tencent.commonsdk.zip;

import java.io.IOException;
import java.util.zip.ZipEntry;

public class QZipIOException
  extends IOException
{
  public static boolean isInvalidEntry(ZipEntry paramZipEntry)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramZipEntry != null)
    {
      paramZipEntry = paramZipEntry.getName();
      bool1 = bool2;
      if (paramZipEntry != null) {
        if (!paramZipEntry.contains("../"))
        {
          bool1 = bool2;
          if (!paramZipEntry.contains("..\\")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.commonsdk.zip.QZipIOException
 * JD-Core Version:    0.7.0.1
 */