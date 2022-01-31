package com.tencent.component.network.utils;

import android.content.Context;
import java.io.File;

final class b
  implements FileUtils.AssetFileComparator
{
  public final boolean equals(Context paramContext, String paramString, File paramFile)
  {
    long l = FileUtils.getAssetLength(paramContext, paramString);
    return (l != -1L) && (l == paramFile.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.b
 * JD-Core Version:    0.7.0.1
 */