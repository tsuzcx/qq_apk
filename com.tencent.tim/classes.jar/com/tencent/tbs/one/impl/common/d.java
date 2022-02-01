package com.tencent.tbs.one.impl.common;

import android.text.TextUtils;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements Serializable
{
  public int a;
  private String b;
  private Map<String, a> c;
  
  private d(JSONObject paramJSONObject)
  {
    this.b = paramJSONObject.optString("VERSIONNAME");
    this.a = paramJSONObject.optInt("VERSIONCODE");
    paramJSONObject = paramJSONObject.optJSONArray("COMPONENTS");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int j = paramJSONObject.length();
      this.c = new HashMap(j);
      int i = 0;
      while (i < j)
      {
        a locala = a(paramJSONObject.optJSONObject(i));
        if (locala != null) {
          this.c.put(locala.a, locala);
        }
        i += 1;
      }
    }
  }
  
  private static a a(JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramJSONObject == null) {}
    a locala;
    do
    {
      do
      {
        String str;
        do
        {
          return localObject;
          str = paramJSONObject.optString("NAME");
        } while (TextUtils.isEmpty(str));
        locala = new a();
        locala.a = str;
        locala.b = paramJSONObject.optString("VERSIONNAME");
        locala.c = paramJSONObject.optInt("VERSIONCODE");
        locala.d = paramJSONObject.optString("URL");
        locala.e = paramJSONObject.optString("MD5");
        paramJSONObject = paramJSONObject.optJSONArray("DEPENDENCIES");
        localObject = locala;
      } while (paramJSONObject == null);
      localObject = locala;
    } while (paramJSONObject.length() <= 0);
    int j = paramJSONObject.length();
    locala.f = new String[j];
    int i = 0;
    for (;;)
    {
      localObject = locala;
      if (i >= j) {
        break;
      }
      locala.f[i] = paramJSONObject.optString(i);
      i += 1;
    }
  }
  
  /* Error */
  public static d a(java.io.File paramFile)
    throws TBSOneException
  {
    // Byte code:
    //   0: new 113	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 116	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokestatic 119	com/tencent/tbs/one/impl/common/d:a	(Ljava/io/InputStream;)Lcom/tencent/tbs/one/impl/common/d;
    //   15: astore_2
    //   16: aload_1
    //   17: invokestatic 124	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_2
    //   23: aconst_null
    //   24: astore_0
    //   25: new 109	com/tencent/tbs/one/TBSOneException
    //   28: dup
    //   29: sipush 306
    //   32: new 126	java/lang/StringBuilder
    //   35: dup
    //   36: ldc 128
    //   38: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload_2
    //   42: invokevirtual 135	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   45: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: aload_2
    //   52: invokespecial 145	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   55: athrow
    //   56: astore_2
    //   57: aload_0
    //   58: astore_1
    //   59: aload_2
    //   60: astore_0
    //   61: aload_1
    //   62: invokestatic 124	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   65: aload_0
    //   66: athrow
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_1
    //   70: goto -9 -> 61
    //   73: astore_2
    //   74: aload_1
    //   75: astore_0
    //   76: goto -51 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramFile	java.io.File
    //   8	67	1	localObject1	Object
    //   15	6	2	locald	d
    //   22	30	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   56	4	2	localObject2	Object
    //   73	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	9	22	java/io/FileNotFoundException
    //   11	16	56	finally
    //   25	56	56	finally
    //   0	9	67	finally
    //   11	16	73	java/io/FileNotFoundException
  }
  
  private static d a(InputStream paramInputStream)
    throws TBSOneException
  {
    try
    {
      paramInputStream = c.a(paramInputStream, "utf-8");
      return a(paramInputStream);
    }
    catch (IOException paramInputStream)
    {
      throw new TBSOneException(307, "Failed to read DEPS contents, error: " + paramInputStream.getMessage(), paramInputStream);
    }
  }
  
  public static d a(String paramString)
    throws TBSOneException
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return new d(localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      throw new TBSOneException(308, "Failed to parse DEPS " + paramString + ", error: " + localJSONException.getMessage(), localJSONException);
    }
  }
  
  public final a b(String paramString)
  {
    if (this.c == null) {
      return null;
    }
    return (a)this.c.get(paramString);
  }
  
  public static final class a
  {
    public String a;
    public String b;
    public int c;
    public String d;
    public String e;
    public String[] f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.d
 * JD-Core Version:    0.7.0.1
 */