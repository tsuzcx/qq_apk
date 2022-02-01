package com.tencent.token;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.File;

class dc
  extends df
{
  private static File a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("/proc/self/fd/");
      localStringBuilder.append(paramParcelFileDescriptor.getFd());
      paramParcelFileDescriptor = Os.readlink(localStringBuilder.toString());
      if (OsConstants.S_ISREG(Os.stat(paramParcelFileDescriptor).st_mode))
      {
        paramParcelFileDescriptor = new File(paramParcelFileDescriptor);
        return paramParcelFileDescriptor;
      }
      return null;
    }
    catch (ErrnoException paramParcelFileDescriptor) {}
    return null;
  }
  
  /* Error */
  public android.graphics.Typeface a(android.content.Context paramContext, dt.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: arraylength
    //   2: ifgt +5 -> 7
    //   5: aconst_null
    //   6: areturn
    //   7: aload_0
    //   8: aload_2
    //   9: iload_3
    //   10: invokevirtual 67	com/tencent/token/dc:a	([Lcom/tencent/token/dt$b;I)Lcom/tencent/token/dt$b;
    //   13: astore_2
    //   14: aload_1
    //   15: invokevirtual 73	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: astore 4
    //   20: aload 4
    //   22: aload_2
    //   23: getfield 78	com/tencent/token/dt$b:a	Landroid/net/Uri;
    //   26: ldc 80
    //   28: aconst_null
    //   29: invokevirtual 86	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   32: astore 4
    //   34: aload 4
    //   36: invokestatic 88	com/tencent/token/dc:a	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +30 -> 71
    //   44: aload_2
    //   45: invokevirtual 92	java/io/File:canRead	()Z
    //   48: ifne +6 -> 54
    //   51: goto +20 -> 71
    //   54: aload_2
    //   55: invokestatic 98	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   58: astore_1
    //   59: aload 4
    //   61: ifnull +8 -> 69
    //   64: aload 4
    //   66: invokevirtual 101	android/os/ParcelFileDescriptor:close	()V
    //   69: aload_1
    //   70: areturn
    //   71: new 103	java/io/FileInputStream
    //   74: dup
    //   75: aload 4
    //   77: invokevirtual 107	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   80: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   83: astore 5
    //   85: aload_1
    //   86: aload 5
    //   88: invokestatic 113	com/tencent/token/df:a	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   91: astore_1
    //   92: aload 5
    //   94: invokevirtual 114	java/io/FileInputStream:close	()V
    //   97: aload 4
    //   99: ifnull +8 -> 107
    //   102: aload 4
    //   104: invokevirtual 101	android/os/ParcelFileDescriptor:close	()V
    //   107: aload_1
    //   108: areturn
    //   109: astore_2
    //   110: aconst_null
    //   111: astore_1
    //   112: goto +7 -> 119
    //   115: astore_1
    //   116: aload_1
    //   117: athrow
    //   118: astore_2
    //   119: aload_1
    //   120: ifnull +22 -> 142
    //   123: aload 5
    //   125: invokevirtual 114	java/io/FileInputStream:close	()V
    //   128: goto +19 -> 147
    //   131: astore 5
    //   133: aload_1
    //   134: aload 5
    //   136: invokevirtual 118	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   139: goto +8 -> 147
    //   142: aload 5
    //   144: invokevirtual 114	java/io/FileInputStream:close	()V
    //   147: aload_2
    //   148: athrow
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_2
    //   152: goto +7 -> 159
    //   155: astore_2
    //   156: aload_2
    //   157: athrow
    //   158: astore_1
    //   159: aload 4
    //   161: ifnull +31 -> 192
    //   164: aload_2
    //   165: ifnull +22 -> 187
    //   168: aload 4
    //   170: invokevirtual 101	android/os/ParcelFileDescriptor:close	()V
    //   173: goto +19 -> 192
    //   176: astore 4
    //   178: aload_2
    //   179: aload 4
    //   181: invokevirtual 118	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   184: goto +8 -> 192
    //   187: aload 4
    //   189: invokevirtual 101	android/os/ParcelFileDescriptor:close	()V
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aconst_null
    //   196: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	dc
    //   0	197	1	paramContext	android.content.Context
    //   0	197	2	paramArrayOfb	dt.b[]
    //   0	197	3	paramInt	int
    //   18	151	4	localObject	java.lang.Object
    //   176	12	4	localThrowable1	java.lang.Throwable
    //   83	41	5	localFileInputStream	java.io.FileInputStream
    //   131	12	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   85	92	109	finally
    //   85	92	115	java/lang/Throwable
    //   116	118	118	finally
    //   123	128	131	java/lang/Throwable
    //   34	40	149	finally
    //   44	51	149	finally
    //   54	59	149	finally
    //   71	85	149	finally
    //   92	97	149	finally
    //   123	128	149	finally
    //   133	139	149	finally
    //   142	147	149	finally
    //   147	149	149	finally
    //   34	40	155	java/lang/Throwable
    //   44	51	155	java/lang/Throwable
    //   54	59	155	java/lang/Throwable
    //   71	85	155	java/lang/Throwable
    //   92	97	155	java/lang/Throwable
    //   133	139	155	java/lang/Throwable
    //   142	147	155	java/lang/Throwable
    //   147	149	155	java/lang/Throwable
    //   156	158	158	finally
    //   168	173	176	java/lang/Throwable
    //   20	34	194	java/io/IOException
    //   64	69	194	java/io/IOException
    //   102	107	194	java/io/IOException
    //   168	173	194	java/io/IOException
    //   178	184	194	java/io/IOException
    //   187	192	194	java/io/IOException
    //   192	194	194	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dc
 * JD-Core Version:    0.7.0.1
 */