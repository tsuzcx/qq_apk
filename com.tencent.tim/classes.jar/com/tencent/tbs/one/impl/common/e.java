package com.tencent.tbs.one.impl.common;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public int a;
  public String b;
  public String c;
  public String d;
  public a[] e;
  public Pair<String, String>[] f;
  public String g;
  
  private e(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("VERSIONCODE");
    this.g = paramJSONObject.optString("BUILD_TYPE");
    this.b = paramJSONObject.optString("RESOURCE");
    Object localObject = paramJSONObject.optString("ENTRY");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(":");
      if (localObject.length != 1) {
        break label151;
      }
      this.c = localObject[0];
    }
    ArrayList localArrayList;
    for (;;)
    {
      localObject = paramJSONObject.optJSONArray("FILES");
      if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
        break label195;
      }
      int j = ((JSONArray)localObject).length();
      localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        a locala = a(((JSONArray)localObject).optJSONObject(i));
        if (locala != null) {
          localArrayList.add(locala);
        }
        i += 1;
      }
      label151:
      if (localObject.length >= 2)
      {
        this.c = localObject[0];
        this.d = localObject[1];
      }
    }
    this.e = ((a[])localArrayList.toArray(new a[0]));
    label195:
    a(paramJSONObject.optJSONArray("RECEIVERS"));
  }
  
  private static a a(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    if (paramJSONObject == null) {}
    a locala;
    label110:
    do
    {
      Object localObject2;
      do
      {
        return localObject1;
        localObject2 = paramJSONObject.optString("PATH");
      } while (TextUtils.isEmpty((CharSequence)localObject2));
      locala = new a();
      locala.a = ((String)localObject2);
      locala.b = paramJSONObject.optString("MD5");
      try
      {
        localObject1 = paramJSONObject.getJSONArray("UNSEALED");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          int j = ((JSONArray)localObject1).length();
          localObject2 = new String[j];
          int i = 0;
          while (i < j)
          {
            localObject2[i] = ((JSONArray)localObject1).optString(i);
            i += 1;
          }
          locala.c = ((String[])localObject2);
        }
      }
      catch (JSONException localJSONException)
      {
        break label110;
      }
      locala.e = paramJSONObject.optString("URL");
      paramJSONObject = paramJSONObject.optString("PARENT");
      localObject1 = locala;
    } while (TextUtils.isEmpty(paramJSONObject));
    localObject1 = new b();
    paramJSONObject = paramJSONObject.split(":");
    if (paramJSONObject.length == 1) {}
    for (((b)localObject1).b = paramJSONObject[0];; ((b)localObject1).b = paramJSONObject[1])
    {
      locala.d = ((b)localObject1);
      return locala;
      ((b)localObject1).a = paramJSONObject[0];
    }
  }
  
  /* Error */
  public static e a(java.io.File paramFile)
    throws TBSOneException
  {
    // Byte code:
    //   0: new 152	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: new 2	com/tencent/tbs/one/impl/common/e
    //   14: dup
    //   15: new 29	org/json/JSONObject
    //   18: dup
    //   19: aload_2
    //   20: ldc 157
    //   22: invokestatic 162	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    //   25: invokespecial 165	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: invokespecial 167	com/tencent/tbs/one/impl/common/e:<init>	(Lorg/json/JSONObject;)V
    //   31: astore_3
    //   32: aload_2
    //   33: invokestatic 170	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   36: aload_3
    //   37: areturn
    //   38: astore_3
    //   39: aconst_null
    //   40: astore_1
    //   41: new 146	com/tencent/tbs/one/TBSOneException
    //   44: dup
    //   45: sipush 401
    //   48: new 172	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 174
    //   54: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: invokevirtual 181	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   61: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 187
    //   66: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_3
    //   70: invokevirtual 190	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   73: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aload_3
    //   80: invokespecial 196	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: athrow
    //   84: astore_0
    //   85: aload_1
    //   86: invokestatic 170	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   89: aload_0
    //   90: athrow
    //   91: astore_3
    //   92: aconst_null
    //   93: astore_1
    //   94: new 146	com/tencent/tbs/one/TBSOneException
    //   97: dup
    //   98: sipush 402
    //   101: new 172	java/lang/StringBuilder
    //   104: dup
    //   105: ldc 198
    //   107: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload_0
    //   111: invokevirtual 181	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   114: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 187
    //   119: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_3
    //   123: invokevirtual 199	java/io/IOException:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: aload_3
    //   133: invokespecial 196	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   136: athrow
    //   137: new 146	com/tencent/tbs/one/TBSOneException
    //   140: dup
    //   141: sipush 403
    //   144: new 172	java/lang/StringBuilder
    //   147: dup
    //   148: ldc 201
    //   150: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   153: aload_0
    //   154: invokevirtual 181	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   157: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 187
    //   162: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_3
    //   166: invokevirtual 202	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   169: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: aload_3
    //   176: invokespecial 196	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: athrow
    //   180: astore_0
    //   181: aconst_null
    //   182: astore_1
    //   183: goto -98 -> 85
    //   186: astore_3
    //   187: aload_2
    //   188: astore_1
    //   189: goto -52 -> 137
    //   192: astore_3
    //   193: aload_2
    //   194: astore_1
    //   195: goto -101 -> 94
    //   198: astore_3
    //   199: aload_2
    //   200: astore_1
    //   201: goto -160 -> 41
    //   204: astore_3
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -70 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramFile	java.io.File
    //   10	197	1	localFileInputStream1	java.io.FileInputStream
    //   8	192	2	localFileInputStream2	java.io.FileInputStream
    //   31	6	3	locale	e
    //   38	42	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   91	85	3	localIOException1	IOException
    //   186	1	3	localJSONException1	JSONException
    //   192	1	3	localIOException2	IOException
    //   198	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   204	1	3	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   0	9	38	java/io/FileNotFoundException
    //   11	32	84	finally
    //   41	84	84	finally
    //   94	137	84	finally
    //   137	180	84	finally
    //   0	9	91	java/io/IOException
    //   0	9	180	finally
    //   11	32	186	org/json/JSONException
    //   11	32	192	java/io/IOException
    //   11	32	198	java/io/FileNotFoundException
    //   0	9	204	org/json/JSONException
  }
  
  public static e a(InputStream paramInputStream)
    throws TBSOneException
  {
    try
    {
      paramInputStream = new JSONObject(c.a(paramInputStream, "utf-8"));
      return new e(paramInputStream);
    }
    catch (IOException paramInputStream)
    {
      throw new TBSOneException(401, "Failed to read MANIFEST contents, error: " + paramInputStream.getMessage(), paramInputStream);
    }
    catch (JSONException paramInputStream)
    {
      throw new TBSOneException(401, "Failed to parse MANIFSET contents, error: " + paramInputStream.getMessage());
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0)) {
      return;
    }
    int k = paramJSONArray.length();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < k)
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      String str = ((JSONObject)localObject).optString("CLASS");
      localObject = ((JSONObject)localObject).optJSONArray("EVENTS");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int m = ((JSONArray)localObject).length();
        int j = 0;
        while (j < m)
        {
          localArrayList.add(new Pair(((JSONArray)localObject).optString(j), str));
          j += 1;
        }
      }
      i += 1;
    }
    this.f = ((Pair[])localArrayList.toArray(new Pair[0]));
  }
  
  public final a a(String paramString)
  {
    a[] arrayOfa = this.e;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.a.equals(paramString)) {
        return locala;
      }
      i += 1;
    }
    return null;
  }
  
  public static final class a
  {
    public String a;
    public String b;
    public String[] c;
    public e.b d;
    public String e;
  }
  
  public static final class b
  {
    public String a;
    public String b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.e
 * JD-Core Version:    0.7.0.1
 */