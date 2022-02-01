package com.tencent.token.utils;

import android.net.Uri;
import android.os.Environment;
import com.tencent.token.ez;
import com.tencent.token.global.g;
import com.tencent.token.utils.encrypt.c;
import java.io.File;
import java.io.FileOutputStream;

public class f
{
  private static File a;
  
  public static Uri a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("path");
    ((StringBuilder)localObject1).append(paramString);
    g.b(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(c.b(paramString));
    ((StringBuilder)localObject1).append(paramString.substring(paramString.lastIndexOf(".")));
    Object localObject2 = ((StringBuilder)localObject1).toString();
    a = new File(Environment.getExternalStorageDirectory(), "cache");
    if (!a.exists()) {
      a.mkdirs();
    }
    if (!a.exists()) {
      return null;
    }
    localObject1 = new File(a, (String)localObject2);
    if (((File)localObject1).exists())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exists");
      localStringBuilder.append(paramString);
      localStringBuilder.append("name");
      localStringBuilder.append((String)localObject2);
      g.b(localStringBuilder.toString());
      return Uri.fromFile((File)localObject1);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("fromnet");
    ((StringBuilder)localObject2).append(paramString);
    g.b(((StringBuilder)localObject2).toString());
    paramString = new ez().a(paramString);
    if (paramString != null)
    {
      localObject2 = new FileOutputStream((File)localObject1);
      ((FileOutputStream)localObject2).write(paramString, 0, paramString.length);
      ((FileOutputStream)localObject2).close();
      return Uri.fromFile((File)localObject1);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.f
 * JD-Core Version:    0.7.0.1
 */