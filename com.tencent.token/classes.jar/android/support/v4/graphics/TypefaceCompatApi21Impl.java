package android.support.v4.graphics;

import android.os.ParcelFileDescriptor;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.File;

@RequiresApi(21)
@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class TypefaceCompatApi21Impl
  extends TypefaceCompatBaseImpl
{
  private static final String TAG = "TypefaceCompatApi21Impl";
  
  private File getFile(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/proc/self/fd/");
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
  public android.graphics.Typeface createFromFontInfo(android.content.Context paramContext, android.os.CancellationSignal paramCancellationSignal, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: aload_3
    //   10: iload 4
    //   12: invokevirtual 83	android/support/v4/graphics/TypefaceCompatApi21Impl:findBestInfo	([Landroid/support/v4/provider/FontsContractCompat$FontInfo;I)Landroid/support/v4/provider/FontsContractCompat$FontInfo;
    //   15: astore_3
    //   16: aload_1
    //   17: invokevirtual 89	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore 5
    //   22: aload 5
    //   24: aload_3
    //   25: invokevirtual 95	android/support/v4/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   28: ldc 97
    //   30: aload_2
    //   31: invokevirtual 103	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   34: astore_3
    //   35: aload_0
    //   36: aload_3
    //   37: invokespecial 105	android/support/v4/graphics/TypefaceCompatApi21Impl:getFile	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +28 -> 70
    //   45: aload_2
    //   46: invokevirtual 109	java/io/File:canRead	()Z
    //   49: ifne +6 -> 55
    //   52: goto +18 -> 70
    //   55: aload_2
    //   56: invokestatic 115	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   59: astore_1
    //   60: aload_3
    //   61: ifnull +7 -> 68
    //   64: aload_3
    //   65: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   68: aload_1
    //   69: areturn
    //   70: new 120	java/io/FileInputStream
    //   73: dup
    //   74: aload_3
    //   75: invokevirtual 124	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   78: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   81: astore 5
    //   83: aload_0
    //   84: aload_1
    //   85: aload 5
    //   87: invokespecial 131	android/support/v4/graphics/TypefaceCompatBaseImpl:createFromInputStream	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   90: astore_1
    //   91: aload 5
    //   93: invokevirtual 132	java/io/FileInputStream:close	()V
    //   96: aload_3
    //   97: ifnull +7 -> 104
    //   100: aload_3
    //   101: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   104: aload_1
    //   105: areturn
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_2
    //   109: goto +7 -> 116
    //   112: astore_2
    //   113: aload_2
    //   114: athrow
    //   115: astore_1
    //   116: aload_2
    //   117: ifnull +22 -> 139
    //   120: aload 5
    //   122: invokevirtual 132	java/io/FileInputStream:close	()V
    //   125: goto +19 -> 144
    //   128: astore 5
    //   130: aload_2
    //   131: aload 5
    //   133: invokevirtual 136	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   136: goto +8 -> 144
    //   139: aload 5
    //   141: invokevirtual 132	java/io/FileInputStream:close	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_2
    //   149: goto +7 -> 156
    //   152: astore_2
    //   153: aload_2
    //   154: athrow
    //   155: astore_1
    //   156: aload_3
    //   157: ifnull +27 -> 184
    //   160: aload_2
    //   161: ifnull +19 -> 180
    //   164: aload_3
    //   165: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   168: goto +16 -> 184
    //   171: astore_3
    //   172: aload_2
    //   173: aload_3
    //   174: invokevirtual 136	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   177: goto +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   184: aload_1
    //   185: athrow
    //   186: astore_1
    //   187: aconst_null
    //   188: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	TypefaceCompatApi21Impl
    //   0	189	1	paramContext	android.content.Context
    //   0	189	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	189	3	paramArrayOfFontInfo	android.support.v4.provider.FontsContractCompat.FontInfo[]
    //   0	189	4	paramInt	int
    //   20	101	5	localObject	java.lang.Object
    //   128	12	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   83	91	106	finally
    //   83	91	112	java/lang/Throwable
    //   113	115	115	finally
    //   120	125	128	java/lang/Throwable
    //   35	41	146	finally
    //   45	52	146	finally
    //   55	60	146	finally
    //   70	83	146	finally
    //   91	96	146	finally
    //   120	125	146	finally
    //   130	136	146	finally
    //   139	144	146	finally
    //   144	146	146	finally
    //   35	41	152	java/lang/Throwable
    //   45	52	152	java/lang/Throwable
    //   55	60	152	java/lang/Throwable
    //   70	83	152	java/lang/Throwable
    //   91	96	152	java/lang/Throwable
    //   130	136	152	java/lang/Throwable
    //   139	144	152	java/lang/Throwable
    //   144	146	152	java/lang/Throwable
    //   153	155	155	finally
    //   164	168	171	java/lang/Throwable
    //   22	35	186	java/io/IOException
    //   64	68	186	java/io/IOException
    //   100	104	186	java/io/IOException
    //   164	168	186	java/io/IOException
    //   172	177	186	java/io/IOException
    //   180	184	186	java/io/IOException
    //   184	186	186	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.TypefaceCompatApi21Impl
 * JD-Core Version:    0.7.0.1
 */