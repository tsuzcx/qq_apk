package a.a.a.a;

import a.a.a.b.h;
import android.content.Context;
import android.content.ContextWrapper;
import java.io.EOFException;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class b
{
  /* Error */
  public static File a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 16	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: aload_0
    //   8: invokevirtual 20	android/content/Context:getPackageName	()Ljava/lang/String;
    //   11: sipush 8192
    //   14: invokevirtual 26	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   17: astore_0
    //   18: aload_0
    //   19: ifnull +36 -> 55
    //   22: aload_0
    //   23: getfield 32	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnonnull +42 -> 70
    //   31: aconst_null
    //   32: astore_0
    //   33: aload_0
    //   34: invokevirtual 38	java/io/File:exists	()Z
    //   37: ifeq +14 -> 51
    //   40: aload_0
    //   41: astore_1
    //   42: aload_0
    //   43: invokevirtual 42	java/io/File:length	()J
    //   46: lconst_0
    //   47: lcmp
    //   48: ifgt +5 -> 53
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: areturn
    //   55: aconst_null
    //   56: astore_0
    //   57: goto -30 -> 27
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 46	java/lang/Exception:printStackTrace	()V
    //   65: aconst_null
    //   66: astore_0
    //   67: goto -40 -> 27
    //   70: aload_2
    //   71: astore 4
    //   73: aload_2
    //   74: getstatic 49	java/io/File:separator	Ljava/lang/String;
    //   77: invokevirtual 55	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   80: ifne +25 -> 105
    //   83: new 57	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   90: aload_2
    //   91: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: getstatic 49	java/io/File:separator	Ljava/lang/String;
    //   97: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 4
    //   105: new 34	java/io/File
    //   108: dup
    //   109: aload 4
    //   111: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: invokevirtual 73	java/io/File:mkdirs	()Z
    //   117: pop
    //   118: new 57	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   125: ldc 75
    //   127: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokestatic 78	a/a/a/a/b:b	()Ljava/lang/String;
    //   133: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 80
    //   138: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore 6
    //   146: new 57	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   153: ldc 75
    //   155: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokestatic 78	a/a/a/a/b:b	()Ljava/lang/String;
    //   161: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 80
    //   166: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_1
    //   170: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: astore_1
    //   177: new 82	a/a/a/a/e
    //   180: dup
    //   181: new 34	java/io/File
    //   184: dup
    //   185: aload_0
    //   186: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   189: aload_1
    //   190: invokespecial 85	a/a/a/a/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   193: astore_2
    //   194: aload_2
    //   195: ifnull -164 -> 31
    //   198: aload_2
    //   199: getfield 89	a/a/a/a/e:f	La/a/a/a/d;
    //   202: astore 7
    //   204: aload 7
    //   206: ifnull +223 -> 429
    //   209: aload 7
    //   211: getfield 93	a/a/a/a/d:a	Ljava/lang/String;
    //   214: aload 6
    //   216: invokevirtual 97	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   219: ifeq +210 -> 429
    //   222: aload 7
    //   224: getfield 93	a/a/a/a/d:a	Ljava/lang/String;
    //   227: ldc 99
    //   229: invokevirtual 55	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   232: ifeq +197 -> 429
    //   235: aload 7
    //   237: getfield 93	a/a/a/a/d:a	Ljava/lang/String;
    //   240: astore_1
    //   241: aload_1
    //   242: bipush 47
    //   244: invokevirtual 103	java/lang/String:lastIndexOf	(I)I
    //   247: istore_3
    //   248: aload_1
    //   249: astore_0
    //   250: iload_3
    //   251: iconst_m1
    //   252: if_icmpeq +11 -> 263
    //   255: aload_1
    //   256: iload_3
    //   257: iconst_1
    //   258: iadd
    //   259: invokevirtual 107	java/lang/String:substring	(I)Ljava/lang/String;
    //   262: astore_0
    //   263: new 34	java/io/File
    //   266: dup
    //   267: new 57	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   274: aload 4
    //   276: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload_0
    //   280: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   289: astore_0
    //   290: aload_0
    //   291: invokevirtual 38	java/io/File:exists	()Z
    //   294: ifeq +8 -> 302
    //   297: aload_0
    //   298: invokevirtual 110	java/io/File:delete	()Z
    //   301: pop
    //   302: sipush 4096
    //   305: newarray byte
    //   307: astore 4
    //   309: aload_2
    //   310: aload 7
    //   312: invokevirtual 113	a/a/a/a/e:a	(La/a/a/a/d;)Ljava/io/InputStream;
    //   315: astore 6
    //   317: new 115	java/io/FileOutputStream
    //   320: dup
    //   321: aload_0
    //   322: invokespecial 118	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   325: astore_1
    //   326: aload 6
    //   328: aload 4
    //   330: invokevirtual 124	java/io/InputStream:read	([B)I
    //   333: istore_3
    //   334: iload_3
    //   335: ifle +46 -> 381
    //   338: aload_1
    //   339: aload 4
    //   341: iconst_0
    //   342: iload_3
    //   343: invokevirtual 128	java/io/FileOutputStream:write	([BII)V
    //   346: goto -20 -> 326
    //   349: astore 4
    //   351: aload 4
    //   353: invokevirtual 46	java/lang/Exception:printStackTrace	()V
    //   356: aload_1
    //   357: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   360: aload_2
    //   361: invokevirtual 133	a/a/a/a/e:a	()V
    //   364: goto -331 -> 33
    //   367: astore_1
    //   368: aload_1
    //   369: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   372: goto -339 -> 33
    //   375: astore_0
    //   376: aconst_null
    //   377: astore_2
    //   378: goto -184 -> 194
    //   381: aload_1
    //   382: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   385: goto -25 -> 360
    //   388: astore_0
    //   389: aload_1
    //   390: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   393: aload_0
    //   394: athrow
    //   395: astore 4
    //   397: aconst_null
    //   398: astore_1
    //   399: goto -48 -> 351
    //   402: astore_1
    //   403: aload_1
    //   404: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   407: goto -47 -> 360
    //   410: astore_0
    //   411: goto -22 -> 389
    //   414: astore_1
    //   415: aload_1
    //   416: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   419: goto -26 -> 393
    //   422: astore_0
    //   423: aload 5
    //   425: astore_1
    //   426: goto -37 -> 389
    //   429: aconst_null
    //   430: astore_0
    //   431: goto -71 -> 360
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	paramContext	Context
    //   0	434	1	paramString1	String
    //   0	434	2	paramString2	String
    //   247	96	3	i	int
    //   71	269	4	localObject1	Object
    //   349	3	4	localException1	Exception
    //   395	1	4	localException2	Exception
    //   1	423	5	localObject2	Object
    //   144	183	6	localObject3	Object
    //   202	109	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   3	18	60	java/lang/Exception
    //   22	27	60	java/lang/Exception
    //   326	334	349	java/lang/Exception
    //   338	346	349	java/lang/Exception
    //   360	364	367	java/io/IOException
    //   177	194	375	java/io/IOException
    //   326	334	388	finally
    //   338	346	388	finally
    //   309	326	395	java/lang/Exception
    //   356	360	402	java/io/IOException
    //   381	385	402	java/io/IOException
    //   351	356	410	finally
    //   389	393	414	java/io/IOException
    //   309	326	422	finally
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 140	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: aload_0
    //   12: ldc 142
    //   14: invokevirtual 97	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +11 -> 28
    //   20: ldc 142
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: ifnull +18 -> 47
    //   32: aload_0
    //   33: ldc 144
    //   35: invokevirtual 97	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +9 -> 47
    //   41: ldc 144
    //   43: astore_0
    //   44: goto -21 -> 23
    //   47: aload_0
    //   48: ifnull +18 -> 66
    //   51: aload_0
    //   52: ldc 146
    //   54: invokevirtual 97	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   57: ifeq +9 -> 66
    //   60: ldc 146
    //   62: astore_0
    //   63: goto -40 -> 23
    //   66: ldc 148
    //   68: astore_0
    //   69: goto -46 -> 23
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	63	0	str	String
    //   72	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	72	finally
    //   11	20	72	finally
    //   32	41	72	finally
    //   51	60	72	finally
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ new byte[] { 69, 16, -45, 32, 78, 91, 23, -99, 0, 0, 0, 0, 0, 0, 0, 0 }[(i % 8)]));
      i += 1;
    }
    return new String(arrayOfByte);
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (;;)
    {
      return;
      if (paramInputStream == null) {
        break label82;
      }
      if (paramArrayOfByte == null) {
        break label72;
      }
      if (((paramInt1 | paramInt2) >= 0) && (paramInt1 <= paramArrayOfByte.length) && (paramArrayOfByte.length - paramInt1 >= paramInt2)) {
        while (paramInt2 > 0)
        {
          int i = paramInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
          if (i < 0) {
            break label64;
          }
          paramInt1 += i;
          paramInt2 -= i;
        }
      }
    }
    label64:
    throw new EOFException();
    label72:
    throw new NullPointerException("dst == null");
    label82:
    throw new NullPointerException("in == null");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    String str = "lib" + paramString + ".so";
    Object localObject1 = new StringBuilder();
    boolean bool1;
    try
    {
      paramString = paramContext.getFilesDir().getParent();
      localObject2 = paramString + "/.seclib/";
      try
      {
        localObject1 = new File((String)localObject2 + str);
        if (((File)localObject1).exists())
        {
          paramString = (String)localObject1;
          if (((File)localObject1).length() != 0L) {}
        }
        else
        {
          paramString = a(paramContext, str, (String)localObject2);
        }
        if ((paramString == null) || (!paramString.exists())) {
          break label291;
        }
        if (h.a(paramString, null)) {
          break label281;
        }
        paramString.delete();
        bool1 = h.a(a(paramContext, str, (String)localObject2), null);
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          boolean bool2;
          paramContext.printStackTrace();
          bool1 = false;
        }
      }
      bool2 = bool1;
      if (!bool1) {}
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        try
        {
          System.load((String)localObject2 + str);
          bool2 = true;
          return bool2;
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          Object localObject2;
          label281:
          paramContext.printStackTrace();
        }
        paramString = paramString;
        try
        {
          if ((paramContext instanceof ContextWrapper))
          {
            paramString = ((ContextWrapper)paramContext).getBaseContext();
            localObject2 = paramString.getClass();
            localObject2 = ((Class)localObject2).getDeclaredMethod("getDataDirFile", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            paramString = ((File)((Method)localObject2).invoke(paramString, new Object[0])).getAbsolutePath();
            continue;
          }
          paramString = ContextWrapper.class.getDeclaredField("mBase");
          paramString.setAccessible(true);
          paramString = paramString.get(paramContext);
          continue;
          continue;
        }
        finally
        {
          paramString.printStackTrace();
          paramString = null;
        }
        bool1 = true;
      }
    }
    label291:
    return bool1;
  }
  
  public static String b()
  {
    try
    {
      String str = a();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      boolean bool = a(paramContext, paramString);
      localUnsatisfiedLinkError.printStackTrace();
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */