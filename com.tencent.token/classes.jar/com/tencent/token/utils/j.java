package com.tencent.token.utils;

import android.net.Uri;
import android.os.Environment;
import com.tencent.token.global.e;
import com.tencent.token.gv;
import com.tencent.token.utils.encrypt.c;
import java.io.File;
import java.io.FileOutputStream;

public final class j
{
  private static File a;
  
  public static Uri a(String paramString)
  {
    e.b("path" + paramString);
    Object localObject = c.b(paramString) + paramString.substring(paramString.lastIndexOf("."));
    File localFile = new File(Environment.getExternalStorageDirectory(), "cache");
    a = localFile;
    if (!localFile.exists()) {
      a.mkdirs();
    }
    if (!a.exists()) {}
    do
    {
      return null;
      localFile = new File(a, (String)localObject);
      if (localFile.exists())
      {
        e.b("exists" + paramString + "name" + (String)localObject);
        return Uri.fromFile(localFile);
      }
      e.b("fromnet" + paramString);
      paramString = new gv().a(paramString);
    } while (paramString == null);
    localObject = new FileOutputStream(localFile);
    ((FileOutputStream)localObject).write(paramString, 0, paramString.length);
    ((FileOutputStream)localObject).close();
    return Uri.fromFile(localFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.j
 * JD-Core Version:    0.7.0.1
 */