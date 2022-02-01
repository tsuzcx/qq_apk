package wf7;

import android.net.Uri;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public final class gk
{
  /* Error */
  public static void a(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 4
    //   14: aload 6
    //   16: astore_3
    //   17: ldc 12
    //   19: invokestatic 18	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   22: invokevirtual 24	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +71 -> 96
    //   28: aload 6
    //   30: astore_3
    //   31: aload_0
    //   32: invokevirtual 30	java/io/File:exists	()Z
    //   35: ifne +25 -> 60
    //   38: aload 6
    //   40: astore_3
    //   41: aload_0
    //   42: invokevirtual 34	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   45: invokevirtual 37	java/io/File:getParentFile	()Ljava/io/File;
    //   48: invokevirtual 40	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload 6
    //   54: astore_3
    //   55: aload_0
    //   56: invokevirtual 43	java/io/File:createNewFile	()Z
    //   59: pop
    //   60: aload 6
    //   62: astore_3
    //   63: new 45	java/io/FileOutputStream
    //   66: dup
    //   67: aload_0
    //   68: iload_2
    //   69: invokespecial 49	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   72: astore_0
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 53	java/io/FileOutputStream:write	([B)V
    //   78: aload_0
    //   79: astore 4
    //   81: goto +15 -> 96
    //   84: astore_1
    //   85: aload_0
    //   86: astore_3
    //   87: aload_1
    //   88: astore_0
    //   89: goto +47 -> 136
    //   92: astore_1
    //   93: goto +22 -> 115
    //   96: aload 4
    //   98: ifnull +37 -> 135
    //   101: aload 4
    //   103: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   106: return
    //   107: astore_0
    //   108: goto +28 -> 136
    //   111: astore_1
    //   112: aload 5
    //   114: astore_0
    //   115: aload_0
    //   116: astore_3
    //   117: aload_1
    //   118: invokevirtual 60	java/lang/Throwable:printStackTrace	()V
    //   121: aload_0
    //   122: ifnull +13 -> 135
    //   125: aload_0
    //   126: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   129: return
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   135: return
    //   136: aload_3
    //   137: ifnull +15 -> 152
    //   140: aload_3
    //   141: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   144: goto +8 -> 152
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   152: aload_0
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramFile	File
    //   0	154	1	paramArrayOfByte	byte[]
    //   0	154	2	paramBoolean	boolean
    //   16	125	3	localObject1	Object
    //   12	90	4	localFile	File
    //   9	104	5	localObject2	Object
    //   6	55	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   73	78	84	finally
    //   73	78	92	java/lang/Throwable
    //   17	28	107	finally
    //   31	38	107	finally
    //   41	52	107	finally
    //   55	60	107	finally
    //   63	73	107	finally
    //   117	121	107	finally
    //   17	28	111	java/lang/Throwable
    //   31	38	111	java/lang/Throwable
    //   41	52	111	java/lang/Throwable
    //   55	60	111	java/lang/Throwable
    //   63	73	111	java/lang/Throwable
    //   101	106	130	java/io/IOException
    //   125	129	130	java/io/IOException
    //   140	144	147	java/io/IOException
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_3
    //   13: new 26	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 30	java/io/File:exists	()Z
    //   26: ifne +19 -> 45
    //   29: aload_1
    //   30: invokevirtual 34	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   33: invokevirtual 37	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 40	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 43	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 45	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iconst_0
    //   51: invokespecial 49	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: invokevirtual 53	java/io/FileOutputStream:write	([B)V
    //   60: iconst_1
    //   61: istore_2
    //   62: aload_1
    //   63: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   66: iconst_1
    //   67: ireturn
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   73: iload_2
    //   74: ireturn
    //   75: astore_0
    //   76: goto +9 -> 85
    //   79: goto +24 -> 103
    //   82: astore_0
    //   83: aload_3
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +15 -> 101
    //   89: aload_1
    //   90: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   93: goto +8 -> 101
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   101: aload_0
    //   102: athrow
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 57	java/io/FileOutputStream:close	()V
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_0
    //   114: aload 4
    //   116: astore_1
    //   117: goto -14 -> 103
    //   120: astore_0
    //   121: goto -42 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramArrayOfByte	byte[]
    //   0	124	1	paramString	String
    //   1	73	2	bool	boolean
    //   12	72	3	localObject1	Object
    //   9	106	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   62	66	68	java/io/IOException
    //   107	111	68	java/io/IOException
    //   55	60	75	finally
    //   13	45	82	finally
    //   45	55	82	finally
    //   89	93	96	java/io/IOException
    //   13	45	113	java/lang/Throwable
    //   45	55	113	java/lang/Throwable
    //   55	60	120	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 69	java/io/BufferedInputStream
    //   5: dup
    //   6: new 71	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: invokespecial 77	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: new 79	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 81	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore 6
    //   27: aload_0
    //   28: astore_2
    //   29: aload 6
    //   31: astore 4
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore_3
    //   39: aload_0
    //   40: astore_2
    //   41: aload 6
    //   43: astore 4
    //   45: aload_0
    //   46: aload_3
    //   47: invokevirtual 85	java/io/BufferedInputStream:read	([B)I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_m1
    //   53: if_icmpeq +20 -> 73
    //   56: aload_0
    //   57: astore_2
    //   58: aload 6
    //   60: astore 4
    //   62: aload 6
    //   64: aload_3
    //   65: iconst_0
    //   66: iload_1
    //   67: invokevirtual 88	java/io/ByteArrayOutputStream:write	([BII)V
    //   70: goto -31 -> 39
    //   73: aload_0
    //   74: astore_2
    //   75: aload 6
    //   77: astore 4
    //   79: aload 6
    //   81: invokevirtual 92	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   84: astore_3
    //   85: aload 6
    //   87: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   90: goto +8 -> 98
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   98: aload_0
    //   99: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   102: aload_3
    //   103: areturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   109: aload_3
    //   110: areturn
    //   111: astore 5
    //   113: aload_0
    //   114: astore_3
    //   115: aload 6
    //   117: astore_0
    //   118: goto +30 -> 148
    //   121: astore_3
    //   122: goto +75 -> 197
    //   125: astore 5
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_0
    //   130: astore_3
    //   131: aload_2
    //   132: astore_0
    //   133: goto +15 -> 148
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_0
    //   139: goto +58 -> 197
    //   142: astore 5
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: astore_3
    //   148: aload_3
    //   149: astore_2
    //   150: aload_0
    //   151: astore 4
    //   153: aload 5
    //   155: invokevirtual 60	java/lang/Throwable:printStackTrace	()V
    //   158: aload_0
    //   159: ifnull +15 -> 174
    //   162: aload_0
    //   163: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   166: goto +8 -> 174
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   174: aload_3
    //   175: ifnull +14 -> 189
    //   178: aload_3
    //   179: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_3
    //   192: aload_2
    //   193: astore_0
    //   194: aload 4
    //   196: astore_2
    //   197: aload_2
    //   198: ifnull +15 -> 213
    //   201: aload_2
    //   202: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   205: goto +8 -> 213
    //   208: astore_2
    //   209: aload_2
    //   210: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   213: aload_0
    //   214: ifnull +15 -> 229
    //   217: aload_0
    //   218: invokevirtual 94	java/io/BufferedInputStream:close	()V
    //   221: goto +8 -> 229
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 61	java/io/IOException:printStackTrace	()V
    //   229: goto +5 -> 234
    //   232: aload_3
    //   233: athrow
    //   234: goto -2 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramFile	File
    //   50	17	1	i	int
    //   1	74	2	localFile1	File
    //   93	2	2	localIOException1	IOException
    //   128	74	2	localObject1	Object
    //   208	2	2	localIOException2	IOException
    //   38	77	3	localObject2	Object
    //   121	1	3	localObject3	Object
    //   130	1	3	localFile2	File
    //   136	1	3	localObject4	Object
    //   147	32	3	localFile3	File
    //   191	42	3	localObject5	Object
    //   31	164	4	localObject6	Object
    //   111	1	5	localThrowable1	java.lang.Throwable
    //   125	1	5	localThrowable2	java.lang.Throwable
    //   142	12	5	localThrowable3	java.lang.Throwable
    //   25	91	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   85	90	93	java/io/IOException
    //   98	102	104	java/io/IOException
    //   33	39	111	java/lang/Throwable
    //   45	51	111	java/lang/Throwable
    //   62	70	111	java/lang/Throwable
    //   79	85	111	java/lang/Throwable
    //   18	27	121	finally
    //   18	27	125	java/lang/Throwable
    //   2	18	136	finally
    //   2	18	142	java/lang/Throwable
    //   162	166	169	java/io/IOException
    //   178	182	184	java/io/IOException
    //   33	39	191	finally
    //   45	51	191	finally
    //   62	70	191	finally
    //   79	85	191	finally
    //   153	158	191	finally
    //   201	205	208	java/io/IOException
    //   217	221	224	java/io/IOException
  }
  
  public static boolean eV()
  {
    try
    {
      String str = Environment.getExternalStorageState();
      if (str == null) {
        return false;
      }
      boolean bool = str.equals("mounted");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean eW()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().toString());
    ((StringBuilder)localObject).append("/DCIM");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if ((!localFile.isDirectory()) && (!localFile.mkdirs())) {
      return false;
    }
    localObject = new File((String)localObject, ".probe");
    try
    {
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      if (!((File)localObject).createNewFile()) {
        return false;
      }
      ((File)localObject).delete();
      return true;
    }
    catch (IOException localIOException) {}
    return false;
  }
  
  public static final String h(String paramString1, String paramString2)
  {
    String str = Uri.decode(paramString1);
    if (str != null)
    {
      int i = str.indexOf('?');
      paramString1 = str;
      if (i > 0) {
        paramString1 = str.substring(0, i);
      }
      if (!paramString1.endsWith("/"))
      {
        i = paramString1.lastIndexOf('/') + 1;
        if (i > 0)
        {
          str = paramString1.substring(i);
          break label62;
        }
      }
    }
    str = null;
    label62:
    paramString1 = str;
    if (str == null) {
      paramString1 = paramString2;
    }
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "downloadfile";
    }
    return paramString2;
  }
  
  public static int i(long paramLong)
  {
    if (!eV()) {
      return 1;
    }
    if (!eW()) {
      return 2;
    }
    gr.a locala = new gr.a();
    gr.b(locala);
    if (locala.sw < paramLong) {
      return 3;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.gk
 * JD-Core Version:    0.7.0.1
 */