package com.tencent.token.utils;

import android.net.Uri;
import android.os.Environment;
import com.tencent.token.gk;
import com.tencent.token.global.h;
import com.tencent.token.utils.encrypt.c;
import java.io.File;
import java.io.FileOutputStream;

public class j
{
  private static File a;
  
  public static Uri a(String paramString)
  {
    h.b("path" + paramString);
    Object localObject = c.b(paramString) + paramString.substring(paramString.lastIndexOf("."));
    a = new File(Environment.getExternalStorageDirectory(), "cache");
    if (!a.exists()) {
      a.mkdirs();
    }
    if (!a.exists()) {}
    File localFile;
    do
    {
      return null;
      localFile = new File(a, (String)localObject);
      if (localFile.exists())
      {
        h.b("exists" + paramString + "name" + (String)localObject);
        return Uri.fromFile(localFile);
      }
      h.b("fromnet" + paramString);
      paramString = new gk().a(paramString);
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