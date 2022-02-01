package com.tencent.token;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import java.io.EOFException;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class aa
{
  /* Error */
  private static File a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 16	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: aload_0
    //   5: invokevirtual 20	android/content/Context:getPackageName	()Ljava/lang/String;
    //   8: sipush 8192
    //   11: invokevirtual 26	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnull +17 -> 33
    //   19: aload_0
    //   20: getfield 32	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   23: astore 4
    //   25: goto +11 -> 36
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 36	java/lang/Exception:printStackTrace	()V
    //   33: aconst_null
    //   34: astore 4
    //   36: aload 4
    //   38: ifnonnull +6 -> 44
    //   41: goto +402 -> 443
    //   44: aload_2
    //   45: astore_0
    //   46: aload_2
    //   47: getstatic 41	java/io/File:separator	Ljava/lang/String;
    //   50: invokevirtual 47	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   53: ifne +30 -> 83
    //   56: new 49	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   63: astore_0
    //   64: aload_0
    //   65: aload_2
    //   66: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_0
    //   71: getstatic 41	java/io/File:separator	Ljava/lang/String;
    //   74: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_0
    //   79: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_0
    //   83: new 38	java/io/File
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: invokevirtual 66	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: new 49	java/lang/StringBuilder
    //   98: dup
    //   99: ldc 68
    //   101: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: astore_2
    //   105: aload_2
    //   106: invokestatic 71	com/tencent/token/aa:a	()Ljava/lang/String;
    //   109: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: ldc 73
    //   116: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_2
    //   121: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore 5
    //   126: new 49	java/lang/StringBuilder
    //   129: dup
    //   130: ldc 68
    //   132: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: astore_2
    //   136: aload_2
    //   137: invokestatic 71	com/tencent/token/aa:a	()Ljava/lang/String;
    //   140: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_2
    //   145: ldc 73
    //   147: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_2
    //   152: aload_1
    //   153: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_2
    //   158: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: astore_1
    //   162: new 75	com/tencent/token/ac
    //   165: dup
    //   166: new 38	java/io/File
    //   169: dup
    //   170: aload 4
    //   172: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   175: aload_1
    //   176: invokespecial 78	com/tencent/token/ac:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   179: astore_2
    //   180: goto +5 -> 185
    //   183: aconst_null
    //   184: astore_2
    //   185: aload_2
    //   186: ifnull +257 -> 443
    //   189: aload_2
    //   190: getfield 82	com/tencent/token/ac:f	Lcom/tencent/token/ab;
    //   193: astore 6
    //   195: aload 6
    //   197: ifnull +229 -> 426
    //   200: aload 6
    //   202: getfield 86	com/tencent/token/ab:a	Ljava/lang/String;
    //   205: aload 5
    //   207: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   210: ifeq +216 -> 426
    //   213: aload 6
    //   215: getfield 86	com/tencent/token/ab:a	Ljava/lang/String;
    //   218: ldc 92
    //   220: invokevirtual 47	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   223: ifeq +203 -> 426
    //   226: aload 6
    //   228: getfield 86	com/tencent/token/ab:a	Ljava/lang/String;
    //   231: astore 4
    //   233: aload 4
    //   235: bipush 47
    //   237: invokevirtual 96	java/lang/String:lastIndexOf	(I)I
    //   240: istore_3
    //   241: aload 4
    //   243: astore_1
    //   244: iload_3
    //   245: iconst_m1
    //   246: if_icmpeq +12 -> 258
    //   249: aload 4
    //   251: iload_3
    //   252: iconst_1
    //   253: iadd
    //   254: invokevirtual 100	java/lang/String:substring	(I)Ljava/lang/String;
    //   257: astore_1
    //   258: new 49	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   265: astore 4
    //   267: aload 4
    //   269: aload_0
    //   270: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 4
    //   276: aload_1
    //   277: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: new 38	java/io/File
    //   284: dup
    //   285: aload 4
    //   287: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   293: astore 5
    //   295: aload 5
    //   297: invokevirtual 103	java/io/File:exists	()Z
    //   300: ifeq +9 -> 309
    //   303: aload 5
    //   305: invokevirtual 106	java/io/File:delete	()Z
    //   308: pop
    //   309: sipush 4096
    //   312: newarray byte
    //   314: astore 4
    //   316: aload_2
    //   317: aload 6
    //   319: invokevirtual 109	com/tencent/token/ac:a	(Lcom/tencent/token/ab;)Ljava/io/InputStream;
    //   322: astore 6
    //   324: new 111	java/io/FileOutputStream
    //   327: dup
    //   328: aload 5
    //   330: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   333: astore_0
    //   334: aload_0
    //   335: astore_1
    //   336: aload 6
    //   338: aload 4
    //   340: invokevirtual 120	java/io/InputStream:read	([B)I
    //   343: istore_3
    //   344: aload_0
    //   345: astore_1
    //   346: iload_3
    //   347: ifle +44 -> 391
    //   350: aload_0
    //   351: astore_1
    //   352: aload_0
    //   353: aload 4
    //   355: iconst_0
    //   356: iload_3
    //   357: invokevirtual 124	java/io/FileOutputStream:write	([BII)V
    //   360: goto -26 -> 334
    //   363: astore_0
    //   364: goto +48 -> 412
    //   367: astore 4
    //   369: goto +13 -> 382
    //   372: astore_0
    //   373: aconst_null
    //   374: astore_1
    //   375: goto +37 -> 412
    //   378: astore 4
    //   380: aconst_null
    //   381: astore_0
    //   382: aload_0
    //   383: astore_1
    //   384: aload 4
    //   386: invokevirtual 36	java/lang/Exception:printStackTrace	()V
    //   389: aload_0
    //   390: astore_1
    //   391: aload_1
    //   392: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   395: aload 5
    //   397: astore_0
    //   398: goto +30 -> 428
    //   401: astore_0
    //   402: aload_0
    //   403: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   406: aload 5
    //   408: astore_0
    //   409: goto +19 -> 428
    //   412: aload_1
    //   413: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   416: goto +8 -> 424
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   424: aload_0
    //   425: athrow
    //   426: aconst_null
    //   427: astore_0
    //   428: aload_2
    //   429: invokevirtual 130	com/tencent/token/ac:a	()V
    //   432: goto +13 -> 445
    //   435: astore_1
    //   436: aload_1
    //   437: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   440: goto +5 -> 445
    //   443: aconst_null
    //   444: astore_0
    //   445: aload_0
    //   446: invokevirtual 103	java/io/File:exists	()Z
    //   449: ifeq +14 -> 463
    //   452: aload_0
    //   453: invokevirtual 134	java/io/File:length	()J
    //   456: lconst_0
    //   457: lcmp
    //   458: ifle +5 -> 463
    //   461: aload_0
    //   462: areturn
    //   463: aconst_null
    //   464: areturn
    //   465: astore_1
    //   466: goto -283 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	paramContext	Context
    //   0	469	1	paramString1	String
    //   0	469	2	paramString2	String
    //   240	117	3	i	int
    //   23	331	4	localObject1	Object
    //   367	1	4	localException1	Exception
    //   378	7	4	localException2	Exception
    //   124	283	5	localObject2	Object
    //   193	144	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	28	java/lang/Exception
    //   19	25	28	java/lang/Exception
    //   336	344	363	finally
    //   352	360	363	finally
    //   384	389	363	finally
    //   336	344	367	java/lang/Exception
    //   352	360	367	java/lang/Exception
    //   316	334	372	finally
    //   316	334	378	java/lang/Exception
    //   391	395	401	java/io/IOException
    //   412	416	419	java/io/IOException
    //   428	432	435	java/io/IOException
    //   162	180	465	java/io/IOException
  }
  
  private static String a()
  {
    try
    {
      String str = b();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ new byte[] { 69, 16, -45, 32, 78, 91, 23, -99, 0, 0, 0, 0, 0, 0, 0, 0 }[(i % 8)]));
      i += 1;
    }
    return new String(arrayOfByte);
  }
  
  public static void a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    if (paramInputStream != null)
    {
      if (paramArrayOfByte != null)
      {
        if (((paramInt2 | 0x0) >= 0) && (paramArrayOfByte.length >= 0) && (paramArrayOfByte.length + 0 >= paramInt2)) {
          while (paramInt2 > 0)
          {
            int i = paramInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
            if (i >= 0)
            {
              paramInt1 += i;
              paramInt2 -= i;
            }
            else
            {
              throw new EOFException();
            }
          }
        }
        return;
      }
      throw new NullPointerException("dst == null");
    }
    throw new NullPointerException("in == null");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      boolean bool = b(paramContext, paramString);
      localUnsatisfiedLinkError.printStackTrace();
      return bool;
    }
  }
  
  private static String b()
  {
    try
    {
      String str = Build.CPU_ABI;
      if ((str != null) && (str.contains("armeabi-v7a"))) {
        return "armeabi-v7a";
      }
      if ((str != null) && (str.contains("arm64-v8a"))) {
        return "arm64-v8a";
      }
      if ((str != null) && (str.contains("armeabi"))) {
        return "armeabi";
      }
      return "";
    }
    finally {}
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    Object localObject1 = new StringBuilder("lib");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(".so");
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    boolean bool2 = false;
    try
    {
      paramString = paramContext.getFilesDir().getParent();
    }
    catch (Exception paramString)
    {
      label55:
      Object localObject2;
      boolean bool1;
      break label55;
    }
    if ((paramContext instanceof ContextWrapper)) {}
    try
    {
      paramString = ((ContextWrapper)paramContext).getBaseContext();
      break label92;
      paramString = ContextWrapper.class.getDeclaredField("mBase");
      paramString.setAccessible(true);
      paramString = paramString.get(paramContext);
      label92:
      localObject2 = paramString.getClass();
      localObject2 = ((Class)localObject2).getDeclaredMethod("getDataDirFile", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      paramString = ((File)((Method)localObject2).invoke(paramString, new Object[0])).getAbsolutePath();
    }
    finally
    {
      paramString.printStackTrace();
      paramString = null;
    }
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("/.seclib/");
    localObject2 = ((StringBuilder)localObject1).toString();
    try
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject2);
      paramString.append(str);
      localObject1 = new File(paramString.toString());
      if (((File)localObject1).exists())
      {
        paramString = (String)localObject1;
        if (((File)localObject1).length() != 0L) {}
      }
      else
      {
        paramString = a(paramContext, str, (String)localObject2);
      }
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.exists()) {
          if (!al.a(paramString))
          {
            paramString.delete();
            bool1 = al.a(a(paramContext, str, (String)localObject2));
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      bool1 = bool2;
    }
    if (bool1) {
      try
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject2);
        paramContext.append(str);
        System.load(paramContext.toString());
        return true;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aa
 * JD-Core Version:    0.7.0.1
 */