package com.tencent.mobileqq.msf.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class f
{
  FileOutputStream a = null;
  byte b = 0;
  byte c = 0;
  boolean d = true;
  
  public f(File paramFile, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    label169:
    do
    {
      do
      {
        try
        {
          long l = paramFile.length();
          if (l < 5L) {}
        }
        catch (FileNotFoundException paramFile)
        {
          paramFile.printStackTrace();
          this.a = null;
          throw new IOException();
        }
        try
        {
          localFileInputStream = new FileInputStream(paramFile);
          try
          {
            byte[] arrayOfByte = new byte[5];
            int j = localFileInputStream.read(arrayOfByte);
            if ((j >= 1) && (arrayOfByte[0] != 0)) {
              this.d = false;
            }
            for (;;)
            {
              localFileInputStream.close();
              this.a = new FileOutputStream(paramFile, paramBoolean);
              return;
              if ((j != 5) || (arrayOfByte[0] != 0)) {
                break;
              }
              this.d = true;
              this.b = 0;
              while (i < 5)
              {
                this.b = ((byte)(this.b ^ arrayOfByte[i]));
                i += 1;
              }
            }
            localFileInputStream.close();
            throw new Exception();
          }
          catch (Exception paramFile) {}
        }
        catch (Exception paramFile)
        {
          localFileInputStream = null;
          break label169;
        }
        paramFile.printStackTrace();
        localFileInputStream.close();
        throw new IOException();
      } while (paramFile.length() <= 0L);
      this.d = false;
      this.a = new FileOutputStream(paramFile, paramBoolean);
      return;
      this.a = new FileOutputStream(paramFile, paramBoolean);
    } while (!this.d);
    paramFile = new byte[4];
    while (this.b == 0)
    {
      new Random().nextBytes(paramFile);
      i = 0;
      while (i < 4)
      {
        this.b = ((byte)(this.b ^ paramFile[i]));
        i += 1;
      }
    }
    this.a.write(this.c);
    this.a.write(paramFile);
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 40	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: new 52	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore 5
    //   24: aload_0
    //   25: astore 6
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore 7
    //   34: aload_1
    //   35: astore 5
    //   37: aload_0
    //   38: astore 6
    //   40: sipush 1024
    //   43: newarray byte
    //   45: astore 8
    //   47: aload_1
    //   48: astore 5
    //   50: aload_0
    //   51: astore 6
    //   53: aload_0
    //   54: aload 7
    //   56: iconst_0
    //   57: iconst_5
    //   58: invokevirtual 83	java/io/FileInputStream:read	([BII)I
    //   61: iconst_5
    //   62: if_icmpne +110 -> 172
    //   65: aload 7
    //   67: iconst_0
    //   68: baload
    //   69: ifne +103 -> 172
    //   72: iconst_1
    //   73: istore_3
    //   74: iconst_0
    //   75: istore_2
    //   76: goto +312 -> 388
    //   79: aload_1
    //   80: astore 5
    //   82: aload_0
    //   83: astore 6
    //   85: aload_1
    //   86: aload 8
    //   88: iconst_0
    //   89: iload 4
    //   91: invokevirtual 86	java/io/FileOutputStream:write	([BII)V
    //   94: aload_1
    //   95: astore 5
    //   97: aload_0
    //   98: astore 6
    //   100: aload_0
    //   101: invokevirtual 90	java/io/FileInputStream:available	()I
    //   104: ifle +43 -> 147
    //   107: aload_1
    //   108: astore 5
    //   110: aload_0
    //   111: astore 6
    //   113: aload_0
    //   114: aload 7
    //   116: invokevirtual 47	java/io/FileInputStream:read	([B)I
    //   119: istore 4
    //   121: iconst_0
    //   122: istore_3
    //   123: iload_3
    //   124: iload 4
    //   126: if_icmpge -47 -> 79
    //   129: aload 8
    //   131: iload_3
    //   132: aload 7
    //   134: iload_3
    //   135: baload
    //   136: iload_2
    //   137: ixor
    //   138: i2b
    //   139: bastore
    //   140: iload_3
    //   141: iconst_1
    //   142: iadd
    //   143: istore_3
    //   144: goto -21 -> 123
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 50	java/io/FileInputStream:close	()V
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   163: iconst_1
    //   164: ireturn
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   170: iconst_1
    //   171: ireturn
    //   172: aload_0
    //   173: ifnull +7 -> 180
    //   176: aload_0
    //   177: invokevirtual 50	java/io/FileInputStream:close	()V
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   188: iconst_0
    //   189: ireturn
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   195: goto -7 -> 188
    //   198: astore 6
    //   200: aconst_null
    //   201: astore_0
    //   202: aload 5
    //   204: astore_1
    //   205: aload 6
    //   207: astore 5
    //   209: aload 5
    //   211: invokevirtual 60	java/io/FileNotFoundException:printStackTrace	()V
    //   214: aload_1
    //   215: ifnull +7 -> 222
    //   218: aload_1
    //   219: invokevirtual 50	java/io/FileInputStream:close	()V
    //   222: aload_0
    //   223: ifnull -35 -> 188
    //   226: aload_0
    //   227: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   230: goto -42 -> 188
    //   233: astore_0
    //   234: aload_0
    //   235: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   238: goto -50 -> 188
    //   241: astore 7
    //   243: aconst_null
    //   244: astore_1
    //   245: aconst_null
    //   246: astore_0
    //   247: aload_1
    //   248: astore 5
    //   250: aload_0
    //   251: astore 6
    //   253: aload 7
    //   255: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   258: aload_0
    //   259: ifnull +7 -> 266
    //   262: aload_0
    //   263: invokevirtual 50	java/io/FileInputStream:close	()V
    //   266: aload_1
    //   267: ifnull -79 -> 188
    //   270: aload_1
    //   271: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   274: goto -86 -> 188
    //   277: astore_0
    //   278: aload_0
    //   279: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   282: goto -94 -> 188
    //   285: astore_1
    //   286: aconst_null
    //   287: astore 5
    //   289: aconst_null
    //   290: astore_0
    //   291: aload_0
    //   292: ifnull +7 -> 299
    //   295: aload_0
    //   296: invokevirtual 50	java/io/FileInputStream:close	()V
    //   299: aload 5
    //   301: ifnull +8 -> 309
    //   304: aload 5
    //   306: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   309: aload_1
    //   310: athrow
    //   311: astore_0
    //   312: aload_0
    //   313: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   316: goto -7 -> 309
    //   319: astore_1
    //   320: aconst_null
    //   321: astore 5
    //   323: goto -32 -> 291
    //   326: astore_1
    //   327: aload 6
    //   329: astore_0
    //   330: goto -39 -> 291
    //   333: astore 5
    //   335: aload_1
    //   336: astore 6
    //   338: aload 5
    //   340: astore_1
    //   341: aload_0
    //   342: astore 5
    //   344: aload 6
    //   346: astore_0
    //   347: goto -56 -> 291
    //   350: astore 7
    //   352: aconst_null
    //   353: astore_1
    //   354: goto -107 -> 247
    //   357: astore 7
    //   359: goto -112 -> 247
    //   362: astore 5
    //   364: aconst_null
    //   365: astore 6
    //   367: aload_0
    //   368: astore_1
    //   369: aload 6
    //   371: astore_0
    //   372: goto -163 -> 209
    //   375: astore 5
    //   377: aload_0
    //   378: astore 6
    //   380: aload_1
    //   381: astore_0
    //   382: aload 6
    //   384: astore_1
    //   385: goto -176 -> 209
    //   388: iload_3
    //   389: iconst_5
    //   390: if_icmpge -296 -> 94
    //   393: iload_2
    //   394: aload 7
    //   396: iload_3
    //   397: baload
    //   398: ixor
    //   399: i2b
    //   400: istore_2
    //   401: iload_3
    //   402: iconst_1
    //   403: iadd
    //   404: istore_3
    //   405: goto -17 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	paramString1	String
    //   0	408	1	paramString2	String
    //   75	326	2	i	int
    //   73	332	3	j	int
    //   89	38	4	k	int
    //   1	321	5	localObject1	Object
    //   333	6	5	localObject2	Object
    //   342	1	5	str1	String
    //   362	1	5	localFileNotFoundException1	FileNotFoundException
    //   375	1	5	localFileNotFoundException2	FileNotFoundException
    //   25	87	6	str2	String
    //   198	8	6	localFileNotFoundException3	FileNotFoundException
    //   251	132	6	str3	String
    //   32	101	7	arrayOfByte1	byte[]
    //   241	13	7	localIOException1	IOException
    //   350	1	7	localIOException2	IOException
    //   357	38	7	localIOException3	IOException
    //   45	85	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   151	155	165	java/io/IOException
    //   159	163	165	java/io/IOException
    //   176	180	190	java/io/IOException
    //   184	188	190	java/io/IOException
    //   3	12	198	java/io/FileNotFoundException
    //   218	222	233	java/io/IOException
    //   226	230	233	java/io/IOException
    //   3	12	241	java/io/IOException
    //   262	266	277	java/io/IOException
    //   270	274	277	java/io/IOException
    //   3	12	285	finally
    //   295	299	311	java/io/IOException
    //   304	309	311	java/io/IOException
    //   12	21	319	finally
    //   27	34	326	finally
    //   40	47	326	finally
    //   53	65	326	finally
    //   85	94	326	finally
    //   100	107	326	finally
    //   113	121	326	finally
    //   253	258	326	finally
    //   209	214	333	finally
    //   12	21	350	java/io/IOException
    //   27	34	357	java/io/IOException
    //   40	47	357	java/io/IOException
    //   53	65	357	java/io/IOException
    //   85	94	357	java/io/IOException
    //   100	107	357	java/io/IOException
    //   113	121	357	java/io/IOException
    //   12	21	362	java/io/FileNotFoundException
    //   27	34	375	java/io/FileNotFoundException
    //   40	47	375	java/io/FileNotFoundException
    //   53	65	375	java/io/FileNotFoundException
    //   85	94	375	java/io/FileNotFoundException
    //   100	107	375	java/io/FileNotFoundException
    //   113	121	375	java/io/FileNotFoundException
  }
  
  public static byte[] b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        byte[] arrayOfByte2 = paramString.getBytes("UTF-8");
        int j = arrayOfByte2.length;
        byte[] arrayOfByte1 = new byte[j];
        int i = 0;
        for (;;)
        {
          paramString = arrayOfByte1;
          if (i >= j) {
            break;
          }
          arrayOfByte1[i] = ((byte)(arrayOfByte2[i] ^ 0xCC));
          i += 1;
        }
        return null;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a()
    throws IOException
  {
    if (this.a != null) {
      this.a.flush();
    }
  }
  
  public void a(String paramString)
    throws IOException
  {
    if ((this.a == null) || (paramString == null) || (paramString.length() == 0)) {
      return;
    }
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int j = paramString.length;
      if (this.d)
      {
        byte[] arrayOfByte = new byte[j];
        int i = 0;
        while (i < j)
        {
          arrayOfByte[i] = ((byte)(paramString[i] ^ this.b));
          i += 1;
        }
        this.a.write(arrayOfByte);
        return;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    this.a.write(paramString);
  }
  
  public void b()
    throws IOException
  {
    if (this.a != null) {
      this.a.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.f
 * JD-Core Version:    0.7.0.1
 */