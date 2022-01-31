package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

final class k
{
  private d a = null;
  private String b = "";
  private String c = "";
  private final String d = "ver";
  private final String e = ":";
  private String f = "1301";
  private String g = "";
  private boolean h = false;
  private String i = "";
  private final String j = "1301";
  private final int k = 64;
  
  public k(Context paramContext, j paramj)
  {
    if (paramj == null) {
      return;
    }
    boolean bool2 = false;
    this.i = paramj.h;
    if (!paramj.q.equals(""))
    {
      File localFile = new File(paramj.q);
      bool2 = localFile.exists();
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = localFile.mkdirs();
      }
      bool2 = bool1;
      if (bool1 == true)
      {
        bool2 = bool1;
        if (d(paramj.q) < 5L) {
          bool2 = false;
        }
      }
    }
    if (!bool2) {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        this.c = paramContext.getFilesDir().getPath();
        this.c = (this.c + File.separator + "TencentMapSDK" + File.separator);
        if ((!this.i.equals("map_raster")) && (!this.i.equals("map_satellite"))) {
          break label343;
        }
        paramContext = c(this.i);
        if (paramContext != null) {
          this.f = paramContext;
        }
      }
    }
    for (;;)
    {
      b();
      return;
      this.c = Environment.getExternalStorageDirectory().getPath();
      if (d(this.b) >= 5L) {
        break;
      }
      this.c = paramContext.getFilesDir().getPath();
      if (d(this.b) >= 5L) {
        break;
      }
      this.c = Environment.getExternalStorageDirectory().getPath();
      break;
      this.c = paramj.q;
      break;
      label343:
      this.h = true;
    }
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 % 64 * 64 + paramInt2 % 64;
  }
  
  private static int a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return paramArrayOfByte[3] & 0xFF | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[0] << 24 & 0xFF000000;
    }
    return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[3] << 24 & 0xFF000000;
  }
  
  private static String a(File paramFile, String paramString)
  {
    InputStreamReader localInputStreamReader = null;
    BufferedReader localBufferedReader = null;
    Object localObject3 = null;
    Object localObject2 = localInputStreamReader;
    Object localObject1 = localBufferedReader;
    try
    {
      if (paramFile.isFile())
      {
        localObject2 = localInputStreamReader;
        localObject1 = localBufferedReader;
        if (paramFile.exists())
        {
          localObject1 = localBufferedReader;
          localInputStreamReader = new InputStreamReader(new FileInputStream(paramFile), "utf-8");
          localObject1 = localBufferedReader;
          localBufferedReader = new BufferedReader(localInputStreamReader);
          paramFile = localObject3;
          do
          {
            localObject1 = paramFile;
            localObject2 = localBufferedReader.readLine();
            if (localObject2 == null) {
              break;
            }
            localObject1 = localObject2;
            localObject2 = ((String)localObject2).trim();
            paramFile = (File)localObject2;
            localObject1 = localObject2;
          } while (!((String)localObject2).contains(paramString));
          paramFile = (File)localObject2;
          localObject1 = paramFile;
          localInputStreamReader.close();
          localObject2 = paramFile;
        }
      }
      return localObject2;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
    return localObject1;
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = new File(this.c);
    boolean bool2 = ((File)localObject1).exists();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = ((File)localObject1).mkdirs();
    }
    if (!bool1) {}
    for (;;)
    {
      return;
      Object localObject2 = new File((File)localObject1, this.i + ".cfg");
      if (((File)localObject2).exists() == true)
      {
        if (!paramBoolean) {
          continue;
        }
        ((File)localObject2).delete();
      }
      try
      {
        paramBoolean = ((File)localObject2).createNewFile();
        if (!paramBoolean) {
          continue;
        }
        localObject1 = null;
        try
        {
          localObject2 = new FileWriter((File)localObject2, true);
          localObject1 = localObject2;
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            localIOException3.printStackTrace();
          }
        }
        if (localObject1 == null) {
          continue;
        }
        localObject2 = new StringBuilder();
        getClass();
        localObject2 = ((StringBuilder)localObject2).append("ver");
        getClass();
        localObject2 = ":" + this.f;
        try
        {
          ((FileWriter)localObject1).write((String)localObject2 + System.getProperty("line.separator"));
          ((FileWriter)localObject1).close();
          return;
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          return;
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
          paramBoolean = bool1;
        }
      }
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      bool1 = this.h;
      if (bool1 == true) {
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        String str1 = q.a(this.i);
        bool1 = bool2;
        if (str1 != null)
        {
          str1 = str1.trim();
          bool1 = bool2;
          if (!str1.equals(""))
          {
            this.g = this.f;
            this.f = str1;
            if (!this.f.equals(this.g)) {
              break;
            }
            a(false);
            this.h = true;
            bool1 = bool2;
          }
        }
      }
      b();
    }
    finally {}
    String str2;
    if ((this.i.equals("map_raster")) || (this.i.equals("map_satellite")))
    {
      if (!this.g.equals("1301")) {
        break label222;
      }
      str2 = this.c + this.i;
      label162:
      if (new File(str2).exists())
      {
        File localFile = new File(str2);
        if (localFile.exists())
        {
          if (!localFile.isFile()) {
            break label257;
          }
          b(str2);
        }
      }
    }
    for (;;)
    {
      a(true);
      this.h = true;
      bool1 = true;
      break;
      label222:
      str2 = this.c + this.i + this.g;
      break label162;
      label257:
      a(str2);
    }
  }
  
  private boolean a(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.endsWith(File.separator)) {
      localObject = paramString + File.separator;
    }
    paramString = new File((String)localObject);
    label59:
    int n;
    int m;
    if ((!paramString.exists()) || (!paramString.isDirectory()))
    {
      break label111;
      return false;
    }
    else
    {
      n = 1;
      localObject = paramString.listFiles();
      m = 0;
    }
    for (;;)
    {
      if (m < localObject.length)
      {
        if (localObject[m].isFile())
        {
          bool = b(localObject[m].getAbsolutePath());
          n = bool;
          if (bool) {
            break label148;
          }
          n = bool;
        }
      }
      else
      {
        label111:
        if ((n == 0) || (!paramString.delete())) {
          break label59;
        }
        return true;
      }
      boolean bool = a(localObject[m].getAbsolutePath());
      n = bool;
      if (!bool) {
        break;
      }
      n = bool;
      label148:
      m += 1;
    }
  }
  
  private static byte[] a(int paramInt, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[4];
    if (paramBoolean == true)
    {
      arrayOfByte[3] = ((byte)(paramInt & 0xFF));
      arrayOfByte[2] = ((byte)((0xFF00 & paramInt) >> 8));
      arrayOfByte[1] = ((byte)((0xFF0000 & paramInt) >> 16));
      arrayOfByte[0] = ((byte)((0xFF000000 & paramInt) >> 24));
      return arrayOfByte;
    }
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    arrayOfByte[1] = ((byte)((0xFF00 & paramInt) >> 8));
    arrayOfByte[2] = ((byte)((0xFF0000 & paramInt) >> 16));
    arrayOfByte[3] = ((byte)((0xFF000000 & paramInt) >> 24));
    return arrayOfByte;
  }
  
  private static byte[] a(String paramString, int paramInt)
  {
    localObject = new File(paramString);
    if (!((File)localObject).exists()) {}
    do
    {
      return null;
      paramString = null;
      try
      {
        localObject = new RandomAccessFile((File)localObject, "r");
        paramString = (String)localObject;
      }
      catch (FileNotFoundException localIOException1)
      {
        try
        {
          long l;
          paramString.seek(l);
        }
        catch (IOException localIOException1)
        {
          try
          {
            for (;;)
            {
              paramString.read((byte[])localObject, 0, 4);
              paramInt = a((byte[])localObject, false);
              if (paramInt > 0) {
                break;
              }
              try
              {
                paramString.close();
                return null;
              }
              catch (IOException paramString)
              {
                paramString.printStackTrace();
                return null;
              }
              localFileNotFoundException = localFileNotFoundException;
              localFileNotFoundException.printStackTrace();
              continue;
              localIOException1 = localIOException1;
              localIOException1.printStackTrace();
            }
          }
          catch (IOException localIOException2)
          {
            for (;;)
            {
              localIOException2.printStackTrace();
            }
            try
            {
              byte[] arrayOfByte = new byte[paramInt];
              try
              {
                paramString.read(arrayOfByte, 0, paramInt);
                try
                {
                  paramString.close();
                  return arrayOfByte;
                }
                catch (IOException paramString)
                {
                  paramString.printStackTrace();
                  return arrayOfByte;
                }
              }
              catch (IOException localIOException3)
              {
                for (;;)
                {
                  localIOException3.printStackTrace();
                }
              }
              return null;
            }
            catch (OutOfMemoryError paramString) {}
          }
        }
      }
    } while (paramString == null);
    localObject = new byte[4];
    l = paramInt;
  }
  
  private String[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramInt1 /= 64;
    paramInt2 /= 64;
    int m = paramInt1 / 10;
    int n = paramInt2 / 10;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("/");
    localStringBuilder.append(m);
    localStringBuilder.append("/");
    localStringBuilder.append(n);
    localStringBuilder.append("/");
    if (!paramBoolean)
    {
      File localFile = new File(localStringBuilder.toString());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    return new String[] { localStringBuilder.toString() + ".ind", localStringBuilder.toString() + ".dat" };
  }
  
  private void b()
  {
    if ((!this.i.equals("map_raster")) && (!this.i.equals("map_satellite")))
    {
      this.b = (this.c + this.i);
      return;
    }
    if (this.f.equals("1301"))
    {
      this.b = (this.c + this.i);
      return;
    }
    this.b = (this.c + this.i + this.f);
  }
  
  private static boolean b(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.isFile())
    {
      bool1 = bool2;
      if (paramString.exists())
      {
        paramString.delete();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  private String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload 4
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 32	com/tencent/tencentmap/mapsdk/map/k:c	Ljava/lang/String;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 32	com/tencent/tencentmap/mapsdk/map/k:c	Ljava/lang/String;
    //   19: ldc 28
    //   21: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: istore_2
    //   25: iload_2
    //   26: iconst_1
    //   27: if_icmpne +10 -> 37
    //   30: aload 4
    //   32: astore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_3
    //   36: areturn
    //   37: aload 4
    //   39: astore_3
    //   40: aload_1
    //   41: ifnull -8 -> 33
    //   44: aload 4
    //   46: astore_3
    //   47: aload_1
    //   48: ldc 28
    //   50: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: iconst_1
    //   54: if_icmpeq -21 -> 33
    //   57: new 69	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: getfield 32	com/tencent/tencentmap/mapsdk/map/k:c	Ljava/lang/String;
    //   65: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 5
    //   70: aload 4
    //   72: astore_3
    //   73: aload 5
    //   75: invokevirtual 76	java/io/File:exists	()Z
    //   78: ifeq -45 -> 33
    //   81: new 69	java/io/File
    //   84: dup
    //   85: aload 5
    //   87: new 103	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   94: aload_1
    //   95: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 178
    //   100: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokespecial 181	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   109: astore_1
    //   110: aload 4
    //   112: astore_3
    //   113: aload_1
    //   114: invokevirtual 76	java/io/File:exists	()Z
    //   117: ifeq -84 -> 33
    //   120: aload_1
    //   121: ldc 34
    //   123: invokestatic 269	com/tencent/tencentmap/mapsdk/map/k:a	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   126: astore_1
    //   127: aload 4
    //   129: astore_3
    //   130: aload_1
    //   131: ifnull -98 -> 33
    //   134: aload 4
    //   136: astore_3
    //   137: aload_1
    //   138: ldc 28
    //   140: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifne -110 -> 33
    //   146: aload_1
    //   147: ldc 34
    //   149: ldc 28
    //   151: invokevirtual 273	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   154: ldc 38
    //   156: ldc 28
    //   158: invokevirtual 273	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   161: astore_3
    //   162: goto -129 -> 33
    //   165: astore_1
    //   166: aload_0
    //   167: monitorexit
    //   168: aload_1
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	k
    //   0	170	1	paramString	String
    //   24	4	2	bool	boolean
    //   7	155	3	localObject1	Object
    //   1	134	4	localObject2	Object
    //   68	18	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   8	25	165	finally
    //   47	70	165	finally
    //   73	110	165	finally
    //   113	127	165	finally
    //   137	162	165	finally
  }
  
  private static long d(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l = paramString.getBlockSize() * paramString.getAvailableBlocks() / 1024L / 1024L;
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public final void a(d paramd)
  {
    this.a = paramd;
  }
  
  /* Error */
  public final boolean a(v.a parama, g.a parama1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/tencent/tencentmap/mapsdk/map/k:h	Z
    //   4: ifne +33 -> 37
    //   7: aload_0
    //   8: invokespecial 289	com/tencent/tencentmap/mapsdk/map/k:a	()Z
    //   11: iconst_1
    //   12: if_icmpne +25 -> 37
    //   15: aload_0
    //   16: getfield 26	com/tencent/tencentmap/mapsdk/map/k:a	Lcom/tencent/tencentmap/mapsdk/map/d;
    //   19: getfield 294	com/tencent/tencentmap/mapsdk/map/d:a	Lcom/tencent/tencentmap/mapsdk/map/e;
    //   22: invokevirtual 298	com/tencent/tencentmap/mapsdk/map/e:a	()V
    //   25: aload_2
    //   26: ifnull +9 -> 35
    //   29: aload_2
    //   30: invokeinterface 301 1 0
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_0
    //   38: aload_1
    //   39: getfield 305	com/tencent/tencentmap/mapsdk/map/v$a:a	I
    //   42: aload_1
    //   43: getfield 307	com/tencent/tencentmap/mapsdk/map/v$a:b	I
    //   46: aload_1
    //   47: getfield 309	com/tencent/tencentmap/mapsdk/map/v$a:c	I
    //   50: iconst_1
    //   51: invokespecial 311	com/tencent/tencentmap/mapsdk/map/k:a	(IIIZ)[Ljava/lang/String;
    //   54: astore 9
    //   56: aload 9
    //   58: ifnull +34 -> 92
    //   61: aload 9
    //   63: arraylength
    //   64: iconst_2
    //   65: if_icmpne +27 -> 92
    //   68: aload 9
    //   70: iconst_0
    //   71: aaload
    //   72: ldc 28
    //   74: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifne +15 -> 92
    //   80: aload 9
    //   82: iconst_1
    //   83: aaload
    //   84: ldc 28
    //   86: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifeq +5 -> 94
    //   92: iconst_0
    //   93: ireturn
    //   94: new 69	java/io/File
    //   97: dup
    //   98: aload 9
    //   100: iconst_0
    //   101: aaload
    //   102: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore_2
    //   106: aload_2
    //   107: invokevirtual 76	java/io/File:exists	()Z
    //   110: ifne +5 -> 115
    //   113: iconst_0
    //   114: ireturn
    //   115: aload_1
    //   116: getfield 305	com/tencent/tencentmap/mapsdk/map/v$a:a	I
    //   119: aload_1
    //   120: getfield 307	com/tencent/tencentmap/mapsdk/map/v$a:b	I
    //   123: invokestatic 313	com/tencent/tencentmap/mapsdk/map/k:a	(II)I
    //   126: istore_3
    //   127: iload_3
    //   128: ifge +5 -> 133
    //   131: iconst_0
    //   132: ireturn
    //   133: aconst_null
    //   134: astore 8
    //   136: aconst_null
    //   137: astore 7
    //   139: new 240	java/io/RandomAccessFile
    //   142: dup
    //   143: aload_2
    //   144: ldc 242
    //   146: invokespecial 243	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   149: astore_2
    //   150: iload_3
    //   151: iconst_4
    //   152: imul
    //   153: i2l
    //   154: lstore 4
    //   156: aload_2
    //   157: lload 4
    //   159: invokevirtual 247	java/io/RandomAccessFile:seek	(J)V
    //   162: aload_2
    //   163: ifnonnull +31 -> 194
    //   166: iconst_0
    //   167: ireturn
    //   168: astore 6
    //   170: aload 7
    //   172: astore_2
    //   173: aload 6
    //   175: invokevirtual 255	java/io/FileNotFoundException:printStackTrace	()V
    //   178: goto -16 -> 162
    //   181: astore 6
    //   183: aload 8
    //   185: astore_2
    //   186: aload 6
    //   188: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   191: goto -29 -> 162
    //   194: iconst_4
    //   195: newarray byte
    //   197: astore 6
    //   199: aload_2
    //   200: aload 6
    //   202: iconst_0
    //   203: iconst_4
    //   204: invokevirtual 251	java/io/RandomAccessFile:read	([BII)I
    //   207: pop
    //   208: aload 6
    //   210: iconst_1
    //   211: invokestatic 253	com/tencent/tencentmap/mapsdk/map/k:a	([BZ)I
    //   214: istore_3
    //   215: aload_2
    //   216: invokevirtual 254	java/io/RandomAccessFile:close	()V
    //   219: iload_3
    //   220: iconst_m1
    //   221: if_icmpne +23 -> 244
    //   224: iconst_0
    //   225: ireturn
    //   226: astore 7
    //   228: aload 7
    //   230: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   233: goto -25 -> 208
    //   236: astore_2
    //   237: aload_2
    //   238: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   241: goto -22 -> 219
    //   244: aconst_null
    //   245: astore 6
    //   247: aload 6
    //   249: astore_2
    //   250: iload_3
    //   251: bipush 254
    //   253: if_icmpeq +30 -> 283
    //   256: aload 6
    //   258: astore_2
    //   259: iload_3
    //   260: bipush 253
    //   262: if_icmpeq +21 -> 283
    //   265: aload 6
    //   267: astore_2
    //   268: iload_3
    //   269: bipush 156
    //   271: if_icmpeq +12 -> 283
    //   274: aload 9
    //   276: iconst_1
    //   277: aaload
    //   278: iload_3
    //   279: invokestatic 315	com/tencent/tencentmap/mapsdk/map/k:a	(Ljava/lang/String;I)[B
    //   282: astore_2
    //   283: aload_2
    //   284: ifnonnull +5 -> 289
    //   287: iconst_0
    //   288: ireturn
    //   289: new 103	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   296: astore 6
    //   298: aload 6
    //   300: aload_1
    //   301: getfield 305	com/tencent/tencentmap/mapsdk/map/v$a:a	I
    //   304: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 6
    //   310: ldc_w 317
    //   313: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 6
    //   319: aload_1
    //   320: getfield 307	com/tencent/tencentmap/mapsdk/map/v$a:b	I
    //   323: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 6
    //   329: ldc_w 317
    //   332: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 6
    //   338: aload_1
    //   339: getfield 309	com/tencent/tencentmap/mapsdk/map/v$a:c	I
    //   342: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_0
    //   347: getfield 26	com/tencent/tencentmap/mapsdk/map/k:a	Lcom/tencent/tencentmap/mapsdk/map/d;
    //   350: ifnonnull +5 -> 355
    //   353: iconst_0
    //   354: ireturn
    //   355: aload_0
    //   356: getfield 26	com/tencent/tencentmap/mapsdk/map/k:a	Lcom/tencent/tencentmap/mapsdk/map/d;
    //   359: aload_2
    //   360: aload 6
    //   362: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokevirtual 320	com/tencent/tencentmap/mapsdk/map/d:a	([BLjava/lang/String;)Z
    //   368: ireturn
    //   369: astore 6
    //   371: goto -185 -> 186
    //   374: astore 6
    //   376: goto -203 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	k
    //   0	379	1	parama	v.a
    //   0	379	2	parama1	g.a
    //   126	153	3	m	int
    //   154	4	4	l	long
    //   168	6	6	localFileNotFoundException1	FileNotFoundException
    //   181	6	6	localIOException1	IOException
    //   197	164	6	localObject1	Object
    //   369	1	6	localIOException2	IOException
    //   374	1	6	localFileNotFoundException2	FileNotFoundException
    //   137	34	7	localObject2	Object
    //   226	3	7	localIOException3	IOException
    //   134	50	8	localObject3	Object
    //   54	221	9	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   139	150	168	java/io/FileNotFoundException
    //   139	150	181	java/io/IOException
    //   199	208	226	java/io/IOException
    //   215	219	236	java/io/IOException
    //   156	162	369	java/io/IOException
    //   156	162	374	java/io/FileNotFoundException
  }
  
  /* Error */
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +11 -> 14
    //   6: iconst_0
    //   7: istore 6
    //   9: aload_0
    //   10: monitorexit
    //   11: iload 6
    //   13: ireturn
    //   14: aload_1
    //   15: arraylength
    //   16: istore 5
    //   18: iload 5
    //   20: ifgt +9 -> 29
    //   23: iconst_0
    //   24: istore 6
    //   26: goto -17 -> 9
    //   29: aload_0
    //   30: iload_2
    //   31: iload_3
    //   32: iload 4
    //   34: iconst_0
    //   35: invokespecial 311	com/tencent/tencentmap/mapsdk/map/k:a	(IIIZ)[Ljava/lang/String;
    //   38: astore 18
    //   40: aload 18
    //   42: ifnull +618 -> 660
    //   45: aload 18
    //   47: arraylength
    //   48: iconst_2
    //   49: if_icmpne +611 -> 660
    //   52: aload 18
    //   54: iconst_0
    //   55: aaload
    //   56: ldc 28
    //   58: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifne +599 -> 660
    //   64: aload 18
    //   66: iconst_1
    //   67: aaload
    //   68: ldc 28
    //   70: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifeq +6 -> 79
    //   76: goto +584 -> 660
    //   79: new 69	java/io/File
    //   82: dup
    //   83: aload 18
    //   85: iconst_1
    //   86: aaload
    //   87: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: astore 15
    //   92: aload 15
    //   94: invokevirtual 76	java/io/File:exists	()Z
    //   97: istore 6
    //   99: iload 6
    //   101: ifne +43 -> 144
    //   104: iconst_0
    //   105: istore 6
    //   107: aload 15
    //   109: invokevirtual 187	java/io/File:createNewFile	()Z
    //   112: istore 7
    //   114: iload 7
    //   116: istore 6
    //   118: iload 6
    //   120: ifne +24 -> 144
    //   123: iconst_0
    //   124: istore 6
    //   126: goto -117 -> 9
    //   129: astore 14
    //   131: aload 14
    //   133: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   136: goto -18 -> 118
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    //   144: lconst_0
    //   145: lstore 8
    //   147: aconst_null
    //   148: astore 17
    //   150: aconst_null
    //   151: astore 14
    //   153: aconst_null
    //   154: astore 16
    //   156: new 240	java/io/RandomAccessFile
    //   159: dup
    //   160: aload 15
    //   162: ldc_w 323
    //   165: invokespecial 243	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   168: astore 15
    //   170: lload 8
    //   172: lstore 10
    //   174: lload 8
    //   176: lstore 12
    //   178: iload 5
    //   180: iconst_0
    //   181: invokestatic 325	com/tencent/tencentmap/mapsdk/map/k:a	(IZ)[B
    //   184: astore 14
    //   186: lload 8
    //   188: lstore 10
    //   190: lload 8
    //   192: lstore 12
    //   194: aload 15
    //   196: invokevirtual 329	java/io/RandomAccessFile:length	()J
    //   199: lstore 8
    //   201: lload 8
    //   203: lstore 10
    //   205: lload 8
    //   207: lstore 12
    //   209: aload 15
    //   211: lload 8
    //   213: invokevirtual 247	java/io/RandomAccessFile:seek	(J)V
    //   216: lload 8
    //   218: lstore 10
    //   220: lload 8
    //   222: lstore 12
    //   224: aload 15
    //   226: aload 14
    //   228: invokevirtual 332	java/io/RandomAccessFile:write	([B)V
    //   231: lload 8
    //   233: lstore 10
    //   235: lload 8
    //   237: lstore 12
    //   239: aload 15
    //   241: aload_1
    //   242: invokevirtual 332	java/io/RandomAccessFile:write	([B)V
    //   245: aload 15
    //   247: invokevirtual 254	java/io/RandomAccessFile:close	()V
    //   250: new 69	java/io/File
    //   253: dup
    //   254: aload 18
    //   256: iconst_0
    //   257: aaload
    //   258: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 76	java/io/File:exists	()Z
    //   266: istore 6
    //   268: iload 6
    //   270: ifne +142 -> 412
    //   273: iconst_0
    //   274: istore 6
    //   276: aload_1
    //   277: invokevirtual 187	java/io/File:createNewFile	()Z
    //   280: istore 7
    //   282: iload 7
    //   284: istore 6
    //   286: iload 6
    //   288: ifne +124 -> 412
    //   291: iconst_0
    //   292: istore 6
    //   294: goto -285 -> 9
    //   297: astore_1
    //   298: goto -48 -> 250
    //   301: astore 15
    //   303: aload 16
    //   305: astore_1
    //   306: lload 8
    //   308: lstore 12
    //   310: aload_1
    //   311: astore 14
    //   313: aload 15
    //   315: invokevirtual 255	java/io/FileNotFoundException:printStackTrace	()V
    //   318: lload 12
    //   320: lstore 8
    //   322: aload_1
    //   323: ifnull -73 -> 250
    //   326: aload_1
    //   327: invokevirtual 254	java/io/RandomAccessFile:close	()V
    //   330: lload 12
    //   332: lstore 8
    //   334: goto -84 -> 250
    //   337: astore_1
    //   338: lload 12
    //   340: lstore 8
    //   342: goto -92 -> 250
    //   345: astore 15
    //   347: aload 17
    //   349: astore_1
    //   350: lload 8
    //   352: lstore 10
    //   354: aload_1
    //   355: astore 14
    //   357: aload 15
    //   359: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   362: lload 10
    //   364: lstore 8
    //   366: aload_1
    //   367: ifnull -117 -> 250
    //   370: aload_1
    //   371: invokevirtual 254	java/io/RandomAccessFile:close	()V
    //   374: lload 10
    //   376: lstore 8
    //   378: goto -128 -> 250
    //   381: astore_1
    //   382: lload 10
    //   384: lstore 8
    //   386: goto -136 -> 250
    //   389: astore_1
    //   390: aload 14
    //   392: ifnull +8 -> 400
    //   395: aload 14
    //   397: invokevirtual 254	java/io/RandomAccessFile:close	()V
    //   400: aload_1
    //   401: athrow
    //   402: astore 14
    //   404: aload 14
    //   406: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   409: goto -123 -> 286
    //   412: lconst_0
    //   413: lstore 10
    //   415: aconst_null
    //   416: astore 15
    //   418: aconst_null
    //   419: astore 14
    //   421: new 240	java/io/RandomAccessFile
    //   424: dup
    //   425: aload_1
    //   426: ldc_w 323
    //   429: invokespecial 243	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   432: astore_1
    //   433: aload_1
    //   434: invokevirtual 329	java/io/RandomAccessFile:length	()J
    //   437: lstore 12
    //   439: lload 12
    //   441: lstore 10
    //   443: lload 10
    //   445: lconst_0
    //   446: lcmp
    //   447: ifne +48 -> 495
    //   450: sipush 16384
    //   453: newarray byte
    //   455: astore 14
    //   457: aload 14
    //   459: iconst_m1
    //   460: invokestatic 338	java/util/Arrays:fill	([BB)V
    //   463: aload_1
    //   464: ifnonnull +25 -> 489
    //   467: iconst_0
    //   468: istore 6
    //   470: goto -461 -> 9
    //   473: aload 14
    //   475: invokevirtual 255	java/io/FileNotFoundException:printStackTrace	()V
    //   478: goto -35 -> 443
    //   481: aload 14
    //   483: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   486: goto -43 -> 443
    //   489: aload_1
    //   490: aload 14
    //   492: invokevirtual 332	java/io/RandomAccessFile:write	([B)V
    //   495: iload_2
    //   496: iload_3
    //   497: invokestatic 313	com/tencent/tencentmap/mapsdk/map/k:a	(II)I
    //   500: istore_2
    //   501: iload_2
    //   502: ifge +31 -> 533
    //   505: aload_1
    //   506: invokevirtual 254	java/io/RandomAccessFile:close	()V
    //   509: iconst_0
    //   510: istore 6
    //   512: goto -503 -> 9
    //   515: astore 14
    //   517: aload 14
    //   519: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   522: goto -27 -> 495
    //   525: astore_1
    //   526: aload_1
    //   527: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   530: goto -21 -> 509
    //   533: iload_2
    //   534: iconst_4
    //   535: imul
    //   536: i2l
    //   537: lstore 10
    //   539: aload_1
    //   540: lload 10
    //   542: invokevirtual 247	java/io/RandomAccessFile:seek	(J)V
    //   545: aload_1
    //   546: lload 8
    //   548: l2i
    //   549: iconst_1
    //   550: invokestatic 325	com/tencent/tencentmap/mapsdk/map/k:a	(IZ)[B
    //   553: invokevirtual 332	java/io/RandomAccessFile:write	([B)V
    //   556: aload_1
    //   557: ifnull +7 -> 564
    //   560: aload_1
    //   561: invokevirtual 254	java/io/RandomAccessFile:close	()V
    //   564: iconst_1
    //   565: istore 6
    //   567: goto -558 -> 9
    //   570: astore 14
    //   572: aload 14
    //   574: invokevirtual 208	java/io/IOException:printStackTrace	()V
    //   577: aload_1
    //   578: ifnull -14 -> 564
    //   581: aload_1
    //   582: invokevirtual 254	java/io/RandomAccessFile:close	()V
    //   585: goto -21 -> 564
    //   588: astore_1
    //   589: goto -25 -> 564
    //   592: astore 14
    //   594: aload_1
    //   595: ifnull +7 -> 602
    //   598: aload_1
    //   599: invokevirtual 254	java/io/RandomAccessFile:close	()V
    //   602: aload 14
    //   604: athrow
    //   605: astore 14
    //   607: goto -207 -> 400
    //   610: astore_1
    //   611: goto -47 -> 564
    //   614: astore_1
    //   615: goto -13 -> 602
    //   618: astore 14
    //   620: goto -139 -> 481
    //   623: astore 14
    //   625: goto -152 -> 473
    //   628: astore_1
    //   629: aload 15
    //   631: astore 14
    //   633: goto -243 -> 390
    //   636: astore 14
    //   638: aload 15
    //   640: astore_1
    //   641: aload 14
    //   643: astore 15
    //   645: goto -291 -> 354
    //   648: astore 14
    //   650: aload 15
    //   652: astore_1
    //   653: aload 14
    //   655: astore 15
    //   657: goto -347 -> 310
    //   660: iconst_0
    //   661: istore 6
    //   663: goto -654 -> 9
    //   666: astore 15
    //   668: aload 14
    //   670: astore_1
    //   671: aload 15
    //   673: astore 14
    //   675: goto -202 -> 473
    //   678: astore 14
    //   680: aload 15
    //   682: astore_1
    //   683: goto -202 -> 481
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	686	0	this	k
    //   0	686	1	paramArrayOfByte	byte[]
    //   0	686	2	paramInt1	int
    //   0	686	3	paramInt2	int
    //   0	686	4	paramInt3	int
    //   16	163	5	m	int
    //   7	655	6	bool1	boolean
    //   112	171	7	bool2	boolean
    //   145	402	8	l1	long
    //   172	369	10	l2	long
    //   176	264	12	l3	long
    //   129	3	14	localIOException1	IOException
    //   151	245	14	arrayOfByte1	byte[]
    //   402	3	14	localIOException2	IOException
    //   419	72	14	arrayOfByte2	byte[]
    //   515	3	14	localIOException3	IOException
    //   570	3	14	localIOException4	IOException
    //   592	11	14	localObject1	Object
    //   605	1	14	localIOException5	IOException
    //   618	1	14	localIOException6	IOException
    //   623	1	14	localFileNotFoundException1	FileNotFoundException
    //   631	1	14	localObject2	Object
    //   636	6	14	localIOException7	IOException
    //   648	21	14	localFileNotFoundException2	FileNotFoundException
    //   673	1	14	localFileNotFoundException3	FileNotFoundException
    //   678	1	14	localIOException8	IOException
    //   90	156	15	localObject3	Object
    //   301	13	15	localFileNotFoundException4	FileNotFoundException
    //   345	13	15	localIOException9	IOException
    //   416	240	15	localObject4	Object
    //   666	15	15	localFileNotFoundException5	FileNotFoundException
    //   154	150	16	localObject5	Object
    //   148	200	17	localObject6	Object
    //   38	217	18	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   107	114	129	java/io/IOException
    //   14	18	139	finally
    //   29	40	139	finally
    //   45	76	139	finally
    //   79	99	139	finally
    //   107	114	139	finally
    //   131	136	139	finally
    //   245	250	139	finally
    //   250	268	139	finally
    //   276	282	139	finally
    //   326	330	139	finally
    //   370	374	139	finally
    //   395	400	139	finally
    //   400	402	139	finally
    //   404	409	139	finally
    //   421	433	139	finally
    //   433	439	139	finally
    //   450	463	139	finally
    //   473	478	139	finally
    //   481	486	139	finally
    //   489	495	139	finally
    //   495	501	139	finally
    //   505	509	139	finally
    //   517	522	139	finally
    //   526	530	139	finally
    //   560	564	139	finally
    //   581	585	139	finally
    //   598	602	139	finally
    //   602	605	139	finally
    //   245	250	297	java/io/IOException
    //   156	170	301	java/io/FileNotFoundException
    //   326	330	337	java/io/IOException
    //   156	170	345	java/io/IOException
    //   370	374	381	java/io/IOException
    //   156	170	389	finally
    //   313	318	389	finally
    //   357	362	389	finally
    //   276	282	402	java/io/IOException
    //   489	495	515	java/io/IOException
    //   505	509	525	java/io/IOException
    //   539	556	570	java/io/IOException
    //   581	585	588	java/io/IOException
    //   539	556	592	finally
    //   572	577	592	finally
    //   395	400	605	java/io/IOException
    //   560	564	610	java/io/IOException
    //   598	602	614	java/io/IOException
    //   433	439	618	java/io/IOException
    //   433	439	623	java/io/FileNotFoundException
    //   178	186	628	finally
    //   194	201	628	finally
    //   209	216	628	finally
    //   224	231	628	finally
    //   239	245	628	finally
    //   178	186	636	java/io/IOException
    //   194	201	636	java/io/IOException
    //   209	216	636	java/io/IOException
    //   224	231	636	java/io/IOException
    //   239	245	636	java/io/IOException
    //   178	186	648	java/io/FileNotFoundException
    //   194	201	648	java/io/FileNotFoundException
    //   209	216	648	java/io/FileNotFoundException
    //   224	231	648	java/io/FileNotFoundException
    //   239	245	648	java/io/FileNotFoundException
    //   421	433	666	java/io/FileNotFoundException
    //   421	433	678	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.k
 * JD-Core Version:    0.7.0.1
 */