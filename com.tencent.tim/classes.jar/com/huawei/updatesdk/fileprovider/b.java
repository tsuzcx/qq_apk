package com.huawei.updatesdk.fileprovider;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class b
  implements a
{
  private final String a;
  private final HashMap<String, File> b = new HashMap();
  
  protected b(String paramString)
  {
    this.a = paramString;
  }
  
  public Uri a(File paramFile)
  {
    for (;;)
    {
      String str1;
      try
      {
        str1 = paramFile.getCanonicalPath();
        paramFile = null;
        Iterator localIterator = this.b.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str2 = ((File)localEntry.getValue()).getPath();
          if (!str1.startsWith(str2)) {
            break label242;
          }
          localObject = localEntry;
          if (paramFile != null)
          {
            if (str2.length() <= ((File)paramFile.getValue()).getPath().length()) {
              break label242;
            }
            localObject = localEntry;
          }
          paramFile = (File)localObject;
          continue;
        }
        if (paramFile != null) {
          break label128;
        }
      }
      catch (Exception paramFile)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for wisedist");
      }
      throw new IllegalArgumentException("wisedist: Failed to find configured root that contains");
      label128:
      Object localObject = ((File)paramFile.getValue()).getPath();
      if (((String)localObject).endsWith("/")) {}
      for (localObject = str1.substring(((String)localObject).length());; localObject = str1.substring(((String)localObject).length() + 1))
      {
        paramFile = Uri.encode((String)paramFile.getKey()) + '/' + Uri.encode((String)localObject, "/");
        return new Uri.Builder().scheme("content").authority(this.a).encodedPath(paramFile).build();
      }
      label242:
      localObject = paramFile;
    }
  }
  
  public File a(Uri paramUri)
  {
    try
    {
      localObject = paramUri.getEncodedPath();
      int i = ((String)localObject).indexOf('/', 1);
      paramUri = Uri.decode(((String)localObject).substring(1, i));
      localObject = Uri.decode(((String)localObject).substring(i + 1));
      paramUri = (File)this.b.get(paramUri);
      if (paramUri == null) {
        throw new IllegalArgumentException("wisedist: Unable to find configured root for");
      }
    }
    catch (Exception paramUri)
    {
      throw new IllegalArgumentException("UpdateSDKFileProvider error: " + paramUri.toString());
    }
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).contains("../")) || (((String)localObject).contains("..")) || (((String)localObject).contains("%00")) || (((String)localObject).contains(".\\.\\")) || (((String)localObject).contains("./"))) {
      throw new IllegalArgumentException("wisedist: Not a standard path");
    }
    Object localObject = new File(paramUri, (String)localObject);
    try
    {
      localObject = ((File)localObject).getCanonicalFile();
      if (!((File)localObject).getPath().startsWith(paramUri.getPath())) {
        throw new SecurityException("wisedist: Resolved path jumped beyond configured root");
      }
    }
    catch (IOException paramUri)
    {
      throw new IllegalArgumentException("wisedist: Failed to resolve canonical path for");
    }
    return localObject;
  }
  
  public void a(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("wisedist Name must not be empty");
    }
    try
    {
      paramFile = paramFile.getCanonicalFile();
      this.b.put(paramString, paramFile);
      return;
    }
    catch (Exception paramString)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for root");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.fileprovider.b
 * JD-Core Version:    0.7.0.1
 */