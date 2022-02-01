package com.tencent.qmsp.sdk.f;

import java.io.IOException;
import java.util.zip.ZipEntry;

public class h
  extends IOException
{
  public static boolean a(ZipEntry paramZipEntry)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.h
 * JD-Core Version:    0.7.0.1
 */