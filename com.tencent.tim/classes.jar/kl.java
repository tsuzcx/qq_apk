import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class kl
{
  private static int hM = 32;
  private static int hN = 32;
  
  public static long a(ETFont paramETFont, String paramString)
  {
    int j;
    try
    {
      localObject1 = new JSONObject(paramString);
      i4 = new kl().b((JSONObject)localObject1);
      if (i4 < hM) {
        break label635;
      }
      arrayOfByte = new byte[i4];
      arrayOfInt = new int[6];
      if (!((JSONObject)localObject1).has("chars")) {
        break label637;
      }
      paramString = ((JSONObject)localObject1).getJSONArray("chars");
      if (paramString.length() <= 0) {
        break label649;
      }
      i = paramString.length();
    }
    catch (JSONException paramETFont)
    {
      Object localObject1;
      int i4;
      byte[] arrayOfByte;
      int[] arrayOfInt;
      QLog.e("VasFont", 1, "createNativeJsonHandle error: " + paramETFont.getMessage());
    }
    int i = ((JSONObject)localObject1).getInt("version");
    int k = ((JSONObject)localObject1).getInt("font_id");
    int m = ((JSONObject)localObject1).getInt("color_style");
    int n = ((JSONObject)localObject1).getInt("theme_style");
    writeInt(arrayOfByte, 0, i);
    writeInt(arrayOfByte, 4, k);
    a(arrayOfByte, 8, (short)m);
    a(arrayOfByte, 10, (short)n);
    a(arrayOfByte, 12, (short)j);
    i = 14;
    for (;;)
    {
      if (i < hM)
      {
        arrayOfByte[i] = 0;
        i = i + 1 + 1;
      }
      else if ((j > 0) && (paramString != null))
      {
        k = hM + j * 8;
        n = k + (j + 1) * 4;
        if (n <= i4) {
          break label654;
        }
        return 0L;
      }
    }
    for (;;)
    {
      label217:
      Object localObject2;
      int i5;
      int i3;
      if (m < j)
      {
        localObject2 = paramString.getJSONObject(m);
        localObject1 = ((JSONObject)localObject2).getJSONArray("components");
        int i6 = ((JSONObject)localObject2).getInt("unicode");
        i5 = ((JSONObject)localObject2).getInt("color_style");
        i3 = ((JSONObject)localObject2).getInt("theme_style");
        if (((JSONArray)localObject1).length() <= 0) {
          break label671;
        }
        n = ((JSONArray)localObject1).length();
        label282:
        a(arrayOfByte, i2, (short)i6);
        i2 += 2;
        a(arrayOfByte, i2, (short)i5);
        i2 += 2;
        a(arrayOfByte, i2, (short)i3);
        i5 = i2 + 2;
        a(arrayOfByte, i5, (short)n);
        writeInt(arrayOfByte, k, i1);
        i3 = i1 + n * 26;
        i1 = 0;
      }
      for (;;)
      {
        if (i1 >= n) {
          break label686;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(i1);
        i2 = ((JSONObject)localObject2).getInt("component");
        localObject2 = ((JSONObject)localObject2).getString("matrix").split(",");
        if ((localObject2 != null) && (localObject2.length == 6))
        {
          arrayOfInt[0] = ((int)(Float.parseFloat(localObject2[0].trim()) * 65536.0F));
          arrayOfInt[1] = ((int)(Float.parseFloat(localObject2[1].trim()) * 65536.0F));
          arrayOfInt[2] = ((int)(Float.parseFloat(localObject2[2].trim()) * 65536.0F));
          arrayOfInt[3] = ((int)(Float.parseFloat(localObject2[3].trim()) * 65536.0F));
          arrayOfInt[4] = ((int)(Float.parseFloat(localObject2[4].trim()) * 64.0F));
          arrayOfInt[5] = ((int)(Float.parseFloat(localObject2[5].trim()) * 64.0F));
          if (i + 26 > i4) {
            return 0L;
          }
          a(arrayOfByte, i, (short)i2);
          i += 2;
          i2 = 0;
        }
        for (;;)
        {
          if (i2 < 6)
          {
            writeInt(arrayOfByte, i, arrayOfInt[i2]);
            i += 4;
            i2 += 1;
            continue;
            writeInt(arrayOfByte, k, i1);
            long l = ETEngine.getInstance().native_diyFontCreateNativeConfig(paramETFont, arrayOfByte);
            return l;
            label635:
            return 0L;
            label637:
            paramString = null;
            j = 0;
            break;
            for (;;)
            {
              j = i;
              break;
              label649:
              i = 0;
            }
            label654:
            i1 = 0;
            i2 = i;
            m = 0;
            i = n;
            break label217;
            return 0L;
            label671:
            n = 0;
            break label282;
          }
        }
        i1 += 1;
      }
      label686:
      m += 1;
      k += 4;
      int i2 = i5 + 2;
      int i1 = i3;
    }
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    paramArrayOfByte[(paramInt + 0)] = ((byte)(paramShort >> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort & 0xFF));
  }
  
  private int b(JSONObject paramJSONObject)
  {
    int j;
    if (paramJSONObject == null)
    {
      j = 0;
      return j;
    }
    int i1;
    label309:
    label311:
    do
    {
      int m;
      for (;;)
      {
        for (;;)
        {
          int i;
          try
          {
            paramJSONObject.getInt("version");
            paramJSONObject.getInt("font_id");
            i = paramJSONObject.getInt("theme_style");
            j = paramJSONObject.getInt("color_style");
            if ((i < 0) || (i >= 65535)) {
              return 0;
            }
            if ((j < 0) || (j >= 65535)) {
              return 0;
            }
            i = 32;
            j = i;
          }
          catch (JSONException paramJSONObject)
          {
            int n;
            int k;
            Object localObject1;
            Object localObject2;
            int i2;
            i = 0;
            paramJSONObject.printStackTrace();
            return i;
          }
          try
          {
            paramJSONObject = paramJSONObject.getJSONArray("chars");
            j = i;
            n = paramJSONObject.length();
            j = n * 8 + 32;
            i = j;
            if (n > 0) {
              i = j + (n + 1) * 4;
            }
            k = 0;
            j = i;
            if (k >= n) {
              break;
            }
          }
          catch (JSONException paramJSONObject)
          {
            i = j;
          }
        }
        try
        {
          localObject1 = paramJSONObject.getJSONObject(k);
          j = ((JSONObject)localObject1).getInt("unicode");
          m = ((JSONObject)localObject1).getInt("theme_style");
          i1 = ((JSONObject)localObject1).getInt("color_style");
          if (j < 19968) {
            break label309;
          }
          if (j <= 40869) {
            break label311;
          }
        }
        catch (JSONException paramJSONObject)
        {
          continue;
        }
        localObject1 = ((JSONObject)localObject1).getJSONArray("components");
        i1 = ((JSONArray)localObject1).length();
        m = 0;
        if (m < i1)
        {
          j = i;
          localObject2 = ((JSONArray)localObject1).getJSONObject(m);
          j = i;
          i2 = ((JSONObject)localObject2).getInt("component");
          if ((i2 < 0) || (i2 >= 65535)) {
            break label339;
          }
          j = i;
          localObject2 = ((JSONObject)localObject2).getString("matrix").split(",");
          if (localObject2 != null)
          {
            j = i;
            i2 = localObject2.length;
            if (i2 == 6) {}
          }
          else
          {
            return 0;
          }
          i += 26;
          m += 1;
        }
        else
        {
          k += 1;
        }
      }
      return 0;
      if ((m < 0) || (m >= 65535)) {
        return 0;
      }
    } while ((i1 >= 0) && (i1 < 65535));
    return 0;
    label339:
    return 0;
  }
  
  /* Error */
  public static String d(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 150	java/io/File:exists	()Z
    //   4: ifne +8 -> 12
    //   7: ldc 152
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: new 154	java/io/InputStreamReader
    //   15: dup
    //   16: new 156	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 159	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: ldc 161
    //   26: invokespecial 164	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   29: astore_2
    //   30: aload_2
    //   31: astore_0
    //   32: new 166	java/lang/StringBuffer
    //   35: dup
    //   36: invokespecial 167	java/lang/StringBuffer:<init>	()V
    //   39: astore_3
    //   40: aload_2
    //   41: astore_0
    //   42: aload_2
    //   43: invokevirtual 170	java/io/InputStreamReader:read	()I
    //   46: istore_1
    //   47: iload_1
    //   48: iconst_m1
    //   49: if_icmpeq +39 -> 88
    //   52: aload_2
    //   53: astore_0
    //   54: aload_3
    //   55: iload_1
    //   56: i2c
    //   57: invokevirtual 173	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   60: pop
    //   61: goto -21 -> 40
    //   64: astore_3
    //   65: aload_2
    //   66: astore_0
    //   67: ldc 175
    //   69: aload_3
    //   70: invokevirtual 176	java/io/IOException:getMessage	()Ljava/lang/String;
    //   73: invokestatic 181	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 184	java/io/InputStreamReader:close	()V
    //   85: ldc 152
    //   87: areturn
    //   88: aload_2
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 185	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   94: astore_3
    //   95: aload_3
    //   96: astore_0
    //   97: aload_0
    //   98: astore_3
    //   99: aload_2
    //   100: ifnull -90 -> 10
    //   103: aload_2
    //   104: invokevirtual 184	java/io/InputStreamReader:close	()V
    //   107: aload_0
    //   108: areturn
    //   109: astore_2
    //   110: ldc 175
    //   112: aload_2
    //   113: invokevirtual 176	java/io/IOException:getMessage	()Ljava/lang/String;
    //   116: invokestatic 181	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: aload_0
    //   121: areturn
    //   122: astore_0
    //   123: ldc 175
    //   125: aload_0
    //   126: invokevirtual 176	java/io/IOException:getMessage	()Ljava/lang/String;
    //   129: invokestatic 181	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: goto -48 -> 85
    //   136: astore_2
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 184	java/io/InputStreamReader:close	()V
    //   147: aload_2
    //   148: athrow
    //   149: astore_0
    //   150: ldc 175
    //   152: aload_0
    //   153: invokevirtual 176	java/io/IOException:getMessage	()Ljava/lang/String;
    //   156: invokestatic 181	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   159: pop
    //   160: goto -13 -> 147
    //   163: astore_2
    //   164: goto -25 -> 139
    //   167: astore_3
    //   168: aconst_null
    //   169: astore_2
    //   170: goto -105 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramFile	java.io.File
    //   46	10	1	i	int
    //   29	75	2	localInputStreamReader	java.io.InputStreamReader
    //   109	4	2	localIOException1	java.io.IOException
    //   136	12	2	localObject1	Object
    //   163	1	2	localObject2	Object
    //   169	1	2	localObject3	Object
    //   9	46	3	localObject4	Object
    //   64	27	3	localIOException2	java.io.IOException
    //   94	5	3	localObject5	Object
    //   167	1	3	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   32	40	64	java/io/IOException
    //   42	47	64	java/io/IOException
    //   54	61	64	java/io/IOException
    //   90	95	64	java/io/IOException
    //   103	107	109	java/io/IOException
    //   81	85	122	java/io/IOException
    //   12	30	136	finally
    //   143	147	149	java/io/IOException
    //   32	40	163	finally
    //   42	47	163	finally
    //   54	61	163	finally
    //   67	77	163	finally
    //   90	95	163	finally
    //   12	30	167	java/io/IOException
  }
  
  public static void j(long paramLong)
  {
    if (0L != paramLong) {
      ETEngine.getInstance().native_diyFontDeleteNativeConfig(paramLong);
    }
  }
  
  private static void writeInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 24 & 0xFF));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 & 0xFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kl
 * JD-Core Version:    0.7.0.1
 */