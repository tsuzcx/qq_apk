package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
class DocumentsContractApi19
{
  private static final int FLAG_VIRTUAL_DOCUMENT = 512;
  private static final String TAG = "DocumentFile";
  
  public static boolean canRead(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) != 0) {}
    while (TextUtils.isEmpty(getRawType(paramContext, paramUri))) {
      return false;
    }
    return true;
  }
  
  public static boolean canWrite(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) != 0) {}
    String str;
    int i;
    do
    {
      do
      {
        return false;
        str = getRawType(paramContext, paramUri);
        i = queryForInt(paramContext, paramUri, "flags", 0);
      } while (TextUtils.isEmpty(str));
      if ((i & 0x4) != 0) {
        return true;
      }
      if (("vnd.android.document/directory".equals(str)) && ((i & 0x8) != 0)) {
        return true;
      }
    } while ((TextUtils.isEmpty(str)) || ((i & 0x2) == 0));
    return true;
  }
  
  private static void closeQuietly(@Nullable AutoCloseable paramAutoCloseable)
  {
    if (paramAutoCloseable != null) {}
    try
    {
      paramAutoCloseable.close();
      return;
    }
    catch (RuntimeException paramAutoCloseable)
    {
      throw paramAutoCloseable;
    }
    catch (Exception paramAutoCloseable) {}
  }
  
  /* Error */
  public static boolean exists(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 70	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_1
    //   8: anewarray 48	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc 72
    //   15: aastore
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 78	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_1
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: invokeinterface 84 1 0
    //   31: istore_2
    //   32: iload_2
    //   33: ifle +11 -> 44
    //   36: iconst_1
    //   37: istore_3
    //   38: aload_1
    //   39: invokestatic 86	androidx/documentfile/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   42: iload_3
    //   43: ireturn
    //   44: iconst_0
    //   45: istore_3
    //   46: goto -8 -> 38
    //   49: astore 4
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: ldc 14
    //   57: new 88	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   64: ldc 91
    //   66: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 4
    //   71: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 108	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   80: pop
    //   81: aload_1
    //   82: invokestatic 86	androidx/documentfile/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   85: iconst_0
    //   86: ireturn
    //   87: astore_1
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: invokestatic 86	androidx/documentfile/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: goto -7 -> 90
    //   100: astore 4
    //   102: goto -49 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramContext	Context
    //   0	105	1	paramUri	Uri
    //   31	2	2	i	int
    //   37	9	3	bool	boolean
    //   49	21	4	localException1	Exception
    //   100	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   5	23	49	java/lang/Exception
    //   5	23	87	finally
    //   25	32	96	finally
    //   55	81	96	finally
    //   25	32	100	java/lang/Exception
  }
  
  public static long getFlags(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "flags", 0L);
  }
  
  @Nullable
  public static String getName(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "_display_name", null);
  }
  
  @Nullable
  private static String getRawType(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "mime_type", null);
  }
  
  @Nullable
  public static String getType(Context paramContext, Uri paramUri)
  {
    paramUri = getRawType(paramContext, paramUri);
    paramContext = paramUri;
    if ("vnd.android.document/directory".equals(paramUri)) {
      paramContext = null;
    }
    return paramContext;
  }
  
  public static boolean isDirectory(Context paramContext, Uri paramUri)
  {
    return "vnd.android.document/directory".equals(getRawType(paramContext, paramUri));
  }
  
  public static boolean isFile(Context paramContext, Uri paramUri)
  {
    paramContext = getRawType(paramContext, paramUri);
    return (!"vnd.android.document/directory".equals(paramContext)) && (!TextUtils.isEmpty(paramContext));
  }
  
  public static boolean isVirtual(Context paramContext, Uri paramUri)
  {
    if (!DocumentsContract.isDocumentUri(paramContext, paramUri)) {}
    while ((getFlags(paramContext, paramUri) & 0x200) == 0L) {
      return false;
    }
    return true;
  }
  
  public static long lastModified(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "last_modified", 0L);
  }
  
  public static long length(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "_size", 0L);
  }
  
  private static int queryForInt(Context paramContext, Uri paramUri, String paramString, int paramInt)
  {
    return (int)queryForLong(paramContext, paramUri, paramString, paramInt);
  }
  
  /* Error */
  private static long queryForLong(Context paramContext, Uri paramUri, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 70	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_1
    //   8: anewarray 48	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: aload_2
    //   14: aastore
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 78	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokeinterface 147 1 0
    //   30: ifeq +33 -> 63
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: iconst_0
    //   37: invokeinterface 151 2 0
    //   42: ifne +21 -> 63
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 155 2 0
    //   54: lstore 5
    //   56: aload_1
    //   57: invokestatic 86	androidx/documentfile/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   60: lload 5
    //   62: lreturn
    //   63: aload_1
    //   64: invokestatic 86	androidx/documentfile/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   67: lload_3
    //   68: lreturn
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: astore_0
    //   74: ldc 14
    //   76: new 88	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   83: ldc 91
    //   85: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_2
    //   89: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 108	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   98: pop
    //   99: aload_1
    //   100: invokestatic 86	androidx/documentfile/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   103: lload_3
    //   104: lreturn
    //   105: astore_1
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_0
    //   109: invokestatic 86	androidx/documentfile/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   112: aload_1
    //   113: athrow
    //   114: astore_1
    //   115: goto -7 -> 108
    //   118: astore_2
    //   119: goto -47 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   0	122	1	paramUri	Uri
    //   0	122	2	paramString	String
    //   0	122	3	paramLong	long
    //   54	7	5	l	long
    // Exception table:
    //   from	to	target	type
    //   5	22	69	java/lang/Exception
    //   5	22	105	finally
    //   24	33	114	finally
    //   35	45	114	finally
    //   47	56	114	finally
    //   74	99	114	finally
    //   24	33	118	java/lang/Exception
    //   35	45	118	java/lang/Exception
    //   47	56	118	java/lang/Exception
  }
  
  /* Error */
  @Nullable
  private static String queryForString(Context paramContext, Uri paramUri, String paramString1, @Nullable String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 70	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_1
    //   8: anewarray 48	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: aload_2
    //   14: aastore
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 78	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokeinterface 147 1 0
    //   30: ifeq +31 -> 61
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: iconst_0
    //   37: invokeinterface 151 2 0
    //   42: ifne +19 -> 61
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 159 2 0
    //   54: astore_2
    //   55: aload_1
    //   56: invokestatic 86	androidx/documentfile/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   59: aload_2
    //   60: areturn
    //   61: aload_1
    //   62: invokestatic 86	androidx/documentfile/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   65: aload_3
    //   66: areturn
    //   67: astore_2
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: ldc 14
    //   74: new 88	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   81: ldc 91
    //   83: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 108	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   96: pop
    //   97: aload_1
    //   98: invokestatic 86	androidx/documentfile/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   101: aload_3
    //   102: areturn
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_0
    //   106: aload_0
    //   107: invokestatic 86	androidx/documentfile/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   110: aload_1
    //   111: athrow
    //   112: astore_1
    //   113: goto -7 -> 106
    //   116: astore_2
    //   117: goto -47 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramUri	Uri
    //   0	120	2	paramString1	String
    //   0	120	3	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   5	22	67	java/lang/Exception
    //   5	22	103	finally
    //   24	33	112	finally
    //   35	45	112	finally
    //   47	55	112	finally
    //   72	97	112	finally
    //   24	33	116	java/lang/Exception
    //   35	45	116	java/lang/Exception
    //   47	55	116	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.documentfile.provider.DocumentsContractApi19
 * JD-Core Version:    0.7.0.1
 */