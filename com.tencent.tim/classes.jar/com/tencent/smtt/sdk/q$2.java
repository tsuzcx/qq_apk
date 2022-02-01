package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import java.io.File;
import java.io.FileFilter;

final class q$2
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    if (paramFile == null) {}
    while ((paramFile.endsWith(".jar_is_first_load_dex_flag_file")) || ((Build.VERSION.SDK_INT >= 21) && (paramFile.endsWith(".dex"))) || ((Build.VERSION.SDK_INT >= 26) && (paramFile.endsWith(".prof"))) || ((Build.VERSION.SDK_INT >= 26) && (paramFile.equals("oat")))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.q.2
 * JD-Core Version:    0.7.0.1
 */