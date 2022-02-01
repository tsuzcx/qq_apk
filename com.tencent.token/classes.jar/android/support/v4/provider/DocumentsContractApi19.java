package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

@RequiresApi(19)
class DocumentsContractApi19
{
  private static final int FLAG_VIRTUAL_DOCUMENT = 512;
  private static final String TAG = "DocumentFile";
  
  public static boolean canRead(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) != 0) {
      return false;
    }
    return !TextUtils.isEmpty(getRawType(paramContext, paramUri));
  }
  
  public static boolean canWrite(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) != 0) {
      return false;
    }
    String str = getRawType(paramContext, paramUri);
    int i = queryForInt(paramContext, paramUri, "flags", 0);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if ((i & 0x4) != 0) {
      return true;
    }
    if (("vnd.android.document/directory".equals(str)) && ((i & 0x8) != 0)) {
      return true;
    }
    return (!TextUtils.isEmpty(str)) && ((i & 0x2) != 0);
  }
  
  private static void closeQuietly(AutoCloseable paramAutoCloseable)
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
      return;
    }
    catch (Exception paramAutoCloseable) {}
  }
  
  /* Error */
  public static boolean exists(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 5
    //   6: iconst_1
    //   7: istore_3
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_0
    //   13: aload 5
    //   15: aload_1
    //   16: iconst_1
    //   17: anewarray 48	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc 70
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: astore 4
    //   37: aload_1
    //   38: invokeinterface 82 1 0
    //   43: istore_2
    //   44: iload_2
    //   45: ifle +6 -> 51
    //   48: goto +5 -> 53
    //   51: iconst_0
    //   52: istore_3
    //   53: aload_1
    //   54: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   57: iload_3
    //   58: ireturn
    //   59: astore_1
    //   60: goto +58 -> 118
    //   63: astore_1
    //   64: aload 4
    //   66: astore_0
    //   67: new 86	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   74: astore 5
    //   76: aload 4
    //   78: astore_0
    //   79: aload 5
    //   81: ldc 89
    //   83: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 4
    //   89: astore_0
    //   90: aload 5
    //   92: aload_1
    //   93: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 4
    //   99: astore_0
    //   100: ldc 14
    //   102: aload 5
    //   104: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 106	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   110: pop
    //   111: aload 4
    //   113: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   116: iconst_0
    //   117: ireturn
    //   118: aload_0
    //   119: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramContext	Context
    //   0	124	1	paramUri	Uri
    //   43	2	2	i	int
    //   7	51	3	bool	boolean
    //   9	103	4	localUri	Uri
    //   4	99	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	32	59	finally
    //   37	44	59	finally
    //   67	76	59	finally
    //   79	87	59	finally
    //   90	97	59	finally
    //   100	111	59	finally
    //   13	32	63	java/lang/Exception
    //   37	44	63	java/lang/Exception
  }
  
  public static long getFlags(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "flags", 0L);
  }
  
  public static String getName(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "_display_name", null);
  }
  
  private static String getRawType(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "mime_type", null);
  }
  
  public static String getType(Context paramContext, Uri paramUri)
  {
    paramContext = getRawType(paramContext, paramUri);
    if ("vnd.android.document/directory".equals(paramContext)) {
      return null;
    }
    return paramContext;
  }
  
  public static boolean isDirectory(Context paramContext, Uri paramUri)
  {
    return "vnd.android.document/directory".equals(getRawType(paramContext, paramUri));
  }
  
  public static boolean isDocumentUri(Context paramContext, Uri paramUri)
  {
    return DocumentsContract.isDocumentUri(paramContext, paramUri);
  }
  
  public static boolean isFile(Context paramContext, Uri paramUri)
  {
    paramContext = getRawType(paramContext, paramUri);
    return (!"vnd.android.document/directory".equals(paramContext)) && (!TextUtils.isEmpty(paramContext));
  }
  
  public static boolean isVirtual(Context paramContext, Uri paramUri)
  {
    boolean bool2 = isDocumentUri(paramContext, paramUri);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if ((getFlags(paramContext, paramUri) & 0x200) != 0L) {
      bool1 = true;
    }
    return bool1;
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
    //   1: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore_0
    //   11: aload 8
    //   13: aload_1
    //   14: iconst_1
    //   15: anewarray 48	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_2
    //   21: aastore
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: astore 7
    //   34: aload_1
    //   35: invokeinterface 145 1 0
    //   40: ifeq +39 -> 79
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: astore 7
    //   48: aload_1
    //   49: iconst_0
    //   50: invokeinterface 149 2 0
    //   55: ifne +24 -> 79
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: astore 7
    //   63: aload_1
    //   64: iconst_0
    //   65: invokeinterface 153 2 0
    //   70: lstore 5
    //   72: aload_1
    //   73: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   76: lload 5
    //   78: lreturn
    //   79: aload_1
    //   80: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   83: lload_3
    //   84: lreturn
    //   85: astore_1
    //   86: goto +54 -> 140
    //   89: astore_1
    //   90: aload 7
    //   92: astore_0
    //   93: new 86	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   100: astore_2
    //   101: aload 7
    //   103: astore_0
    //   104: aload_2
    //   105: ldc 89
    //   107: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 7
    //   113: astore_0
    //   114: aload_2
    //   115: aload_1
    //   116: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 7
    //   122: astore_0
    //   123: ldc 14
    //   125: aload_2
    //   126: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 106	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: aload 7
    //   135: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   138: lload_3
    //   139: lreturn
    //   140: aload_0
    //   141: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramContext	Context
    //   0	146	1	paramUri	Uri
    //   0	146	2	paramString	String
    //   0	146	3	paramLong	long
    //   70	7	5	l	long
    //   7	127	7	localUri	Uri
    //   4	8	8	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   11	29	85	finally
    //   34	43	85	finally
    //   48	58	85	finally
    //   63	72	85	finally
    //   93	101	85	finally
    //   104	111	85	finally
    //   114	120	85	finally
    //   123	133	85	finally
    //   11	29	89	java/lang/Exception
    //   34	43	89	java/lang/Exception
    //   48	58	89	java/lang/Exception
    //   63	72	89	java/lang/Exception
  }
  
  /* Error */
  private static String queryForString(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 68	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_0
    //   11: aload 5
    //   13: aload_1
    //   14: iconst_1
    //   15: anewarray 48	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_2
    //   21: aastore
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: astore 4
    //   34: aload_1
    //   35: invokeinterface 145 1 0
    //   40: ifeq +37 -> 77
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: astore 4
    //   48: aload_1
    //   49: iconst_0
    //   50: invokeinterface 149 2 0
    //   55: ifne +22 -> 77
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: astore 4
    //   63: aload_1
    //   64: iconst_0
    //   65: invokeinterface 157 2 0
    //   70: astore_2
    //   71: aload_1
    //   72: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   75: aload_2
    //   76: areturn
    //   77: aload_1
    //   78: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   81: aload_3
    //   82: areturn
    //   83: astore_1
    //   84: goto +54 -> 138
    //   87: astore_1
    //   88: aload 4
    //   90: astore_0
    //   91: new 86	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   98: astore_2
    //   99: aload 4
    //   101: astore_0
    //   102: aload_2
    //   103: ldc 89
    //   105: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 4
    //   111: astore_0
    //   112: aload_2
    //   113: aload_1
    //   114: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 4
    //   120: astore_0
    //   121: ldc 14
    //   123: aload_2
    //   124: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 106	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   130: pop
    //   131: aload 4
    //   133: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   136: aload_3
    //   137: areturn
    //   138: aload_0
    //   139: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   142: aload_1
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContext	Context
    //   0	144	1	paramUri	Uri
    //   0	144	2	paramString1	String
    //   0	144	3	paramString2	String
    //   7	125	4	localUri	Uri
    //   4	8	5	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   11	29	83	finally
    //   34	43	83	finally
    //   48	58	83	finally
    //   63	71	83	finally
    //   91	99	83	finally
    //   102	109	83	finally
    //   112	118	83	finally
    //   121	131	83	finally
    //   11	29	87	java/lang/Exception
    //   34	43	87	java/lang/Exception
    //   48	58	87	java/lang/Exception
    //   63	71	87	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.DocumentsContractApi19
 * JD-Core Version:    0.7.0.1
 */