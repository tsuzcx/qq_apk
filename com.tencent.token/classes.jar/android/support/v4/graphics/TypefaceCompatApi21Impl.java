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
      paramParcelFileDescriptor = Os.readlink("/proc/self/fd/" + paramParcelFileDescriptor.getFd());
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
    //   42: ifnull +10 -> 52
    //   45: aload_2
    //   46: invokevirtual 109	java/io/File:canRead	()Z
    //   49: ifne +151 -> 200
    //   52: new 111	java/io/FileInputStream
    //   55: dup
    //   56: aload_3
    //   57: invokevirtual 115	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   60: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   63: astore 5
    //   65: aload_0
    //   66: aload_1
    //   67: aload 5
    //   69: invokespecial 122	android/support/v4/graphics/TypefaceCompatBaseImpl:createFromInputStream	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   72: astore_1
    //   73: aload 5
    //   75: ifnull +12 -> 87
    //   78: iconst_0
    //   79: ifeq +52 -> 131
    //   82: aload 5
    //   84: invokevirtual 125	java/io/FileInputStream:close	()V
    //   87: aload_3
    //   88: ifnull +11 -> 99
    //   91: iconst_0
    //   92: ifeq +62 -> 154
    //   95: aload_3
    //   96: invokevirtual 126	android/os/ParcelFileDescriptor:close	()V
    //   99: aload_1
    //   100: areturn
    //   101: astore_1
    //   102: new 128	java/lang/NullPointerException
    //   105: dup
    //   106: invokespecial 129	java/lang/NullPointerException:<init>	()V
    //   109: athrow
    //   110: astore_2
    //   111: aload_2
    //   112: athrow
    //   113: astore_1
    //   114: aload_3
    //   115: ifnull +11 -> 126
    //   118: aload_2
    //   119: ifnull +125 -> 244
    //   122: aload_3
    //   123: invokevirtual 126	android/os/ParcelFileDescriptor:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aconst_null
    //   130: areturn
    //   131: aload 5
    //   133: invokevirtual 125	java/io/FileInputStream:close	()V
    //   136: goto -49 -> 87
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_2
    //   142: goto -28 -> 114
    //   145: astore_1
    //   146: new 128	java/lang/NullPointerException
    //   149: dup
    //   150: invokespecial 129	java/lang/NullPointerException:<init>	()V
    //   153: athrow
    //   154: aload_3
    //   155: invokevirtual 126	android/os/ParcelFileDescriptor:close	()V
    //   158: goto -59 -> 99
    //   161: astore_1
    //   162: aload_1
    //   163: athrow
    //   164: astore_2
    //   165: aload 5
    //   167: ifnull +12 -> 179
    //   170: aload_1
    //   171: ifnull +21 -> 192
    //   174: aload 5
    //   176: invokevirtual 125	java/io/FileInputStream:close	()V
    //   179: aload_2
    //   180: athrow
    //   181: astore 5
    //   183: aload_1
    //   184: aload 5
    //   186: invokevirtual 133	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   189: goto -10 -> 179
    //   192: aload 5
    //   194: invokevirtual 125	java/io/FileInputStream:close	()V
    //   197: goto -18 -> 179
    //   200: aload_2
    //   201: invokestatic 139	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   204: astore_1
    //   205: aload_3
    //   206: ifnull +11 -> 217
    //   209: iconst_0
    //   210: ifeq +18 -> 228
    //   213: aload_3
    //   214: invokevirtual 126	android/os/ParcelFileDescriptor:close	()V
    //   217: aload_1
    //   218: areturn
    //   219: astore_1
    //   220: new 128	java/lang/NullPointerException
    //   223: dup
    //   224: invokespecial 129	java/lang/NullPointerException:<init>	()V
    //   227: athrow
    //   228: aload_3
    //   229: invokevirtual 126	android/os/ParcelFileDescriptor:close	()V
    //   232: goto -15 -> 217
    //   235: astore_3
    //   236: aload_2
    //   237: aload_3
    //   238: invokevirtual 133	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   241: goto -115 -> 126
    //   244: aload_3
    //   245: invokevirtual 126	android/os/ParcelFileDescriptor:close	()V
    //   248: goto -122 -> 126
    //   251: astore_2
    //   252: aconst_null
    //   253: astore_1
    //   254: goto -89 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	TypefaceCompatApi21Impl
    //   0	257	1	paramContext	android.content.Context
    //   0	257	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	257	3	paramArrayOfFontInfo	android.support.v4.provider.FontsContractCompat.FontInfo[]
    //   0	257	4	paramInt	int
    //   20	155	5	localObject	java.lang.Object
    //   181	12	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   82	87	101	java/lang/Throwable
    //   35	41	110	java/lang/Throwable
    //   45	52	110	java/lang/Throwable
    //   52	65	110	java/lang/Throwable
    //   102	110	110	java/lang/Throwable
    //   131	136	110	java/lang/Throwable
    //   179	181	110	java/lang/Throwable
    //   183	189	110	java/lang/Throwable
    //   192	197	110	java/lang/Throwable
    //   200	205	110	java/lang/Throwable
    //   111	113	113	finally
    //   22	35	128	java/io/IOException
    //   95	99	128	java/io/IOException
    //   122	126	128	java/io/IOException
    //   126	128	128	java/io/IOException
    //   146	154	128	java/io/IOException
    //   154	158	128	java/io/IOException
    //   213	217	128	java/io/IOException
    //   220	228	128	java/io/IOException
    //   228	232	128	java/io/IOException
    //   236	241	128	java/io/IOException
    //   244	248	128	java/io/IOException
    //   35	41	139	finally
    //   45	52	139	finally
    //   52	65	139	finally
    //   82	87	139	finally
    //   102	110	139	finally
    //   131	136	139	finally
    //   174	179	139	finally
    //   179	181	139	finally
    //   183	189	139	finally
    //   192	197	139	finally
    //   200	205	139	finally
    //   95	99	145	java/lang/Throwable
    //   65	73	161	java/lang/Throwable
    //   162	164	164	finally
    //   174	179	181	java/lang/Throwable
    //   213	217	219	java/lang/Throwable
    //   122	126	235	java/lang/Throwable
    //   65	73	251	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.TypefaceCompatApi21Impl
 * JD-Core Version:    0.7.0.1
 */