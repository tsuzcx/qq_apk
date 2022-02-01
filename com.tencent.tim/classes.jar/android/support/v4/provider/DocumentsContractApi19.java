package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

@RequiresApi(19)
class DocumentsContractApi19
{
  private static final int FLAG_VIRTUAL_DOCUMENT = 512;
  private static final String TAG = "DocumentFile";
  
  public static boolean canRead(Context paramContext, Uri paramUri)
  {
    boolean bool = true;
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) != 0) {
      return false;
    }
    if (!TextUtils.isEmpty(getRawType(paramContext, paramUri))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean canWrite(Context paramContext, Uri paramUri)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) != 0) {
      bool1 = false;
    }
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return bool1;
          str = getRawType(paramContext, paramUri);
          i = queryForInt(paramContext, paramUri, "flags", 0);
          if (TextUtils.isEmpty(str)) {
            return false;
          }
          bool1 = bool2;
        } while ((i & 0x4) != 0);
        if (!"vnd.android.document/directory".equals(str)) {
          break;
        }
        bool1 = bool2;
      } while ((i & 0x8) != 0);
      if (TextUtils.isEmpty(str)) {
        break;
      }
      bool1 = bool2;
    } while ((i & 0x2) != 0);
    return false;
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
    //   5: aconst_null
    //   6: checkcast 48	java/lang/String
    //   9: astore 4
    //   11: aconst_null
    //   12: checkcast 72	[Ljava/lang/String;
    //   15: astore 5
    //   17: aconst_null
    //   18: checkcast 48	java/lang/String
    //   21: astore 6
    //   23: aload_0
    //   24: aload_1
    //   25: iconst_1
    //   26: anewarray 48	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc 74
    //   33: aastore
    //   34: aload 4
    //   36: aload 5
    //   38: aload 6
    //   40: invokevirtual 80	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_1
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: invokeinterface 86 1 0
    //   52: istore_2
    //   53: iload_2
    //   54: ifle +11 -> 65
    //   57: iconst_1
    //   58: istore_3
    //   59: aload_1
    //   60: invokestatic 88	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   63: iload_3
    //   64: ireturn
    //   65: iconst_0
    //   66: istore_3
    //   67: goto -8 -> 59
    //   70: astore 4
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: astore_0
    //   76: ldc 14
    //   78: new 90	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   85: ldc 93
    //   87: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 4
    //   92: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 110	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   101: pop
    //   102: aload_1
    //   103: invokestatic 88	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: invokestatic 88	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: goto -7 -> 111
    //   121: astore 4
    //   123: goto -49 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramContext	Context
    //   0	126	1	paramUri	Uri
    //   52	2	2	i	int
    //   58	9	3	bool	boolean
    //   9	26	4	str1	String
    //   70	21	4	localException1	Exception
    //   121	1	4	localException2	Exception
    //   15	22	5	arrayOfString	String[]
    //   21	18	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   5	44	70	java/lang/Exception
    //   5	44	108	finally
    //   46	53	117	finally
    //   76	102	117	finally
    //   46	53	121	java/lang/Exception
  }
  
  public static long getFlags(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "flags", 0L);
  }
  
  @Nullable
  public static String getName(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "_display_name", (String)null);
  }
  
  @Nullable
  private static String getRawType(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "mime_type", (String)null);
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
    //   5: aconst_null
    //   6: checkcast 48	java/lang/String
    //   9: astore 7
    //   11: aconst_null
    //   12: checkcast 72	[Ljava/lang/String;
    //   15: astore 8
    //   17: aconst_null
    //   18: checkcast 48	java/lang/String
    //   21: astore 9
    //   23: aload_0
    //   24: aload_1
    //   25: iconst_1
    //   26: anewarray 48	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: aload_2
    //   32: aastore
    //   33: aload 7
    //   35: aload 8
    //   37: aload 9
    //   39: invokevirtual 80	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokeinterface 149 1 0
    //   51: ifeq +33 -> 84
    //   54: aload_1
    //   55: astore_0
    //   56: aload_1
    //   57: iconst_0
    //   58: invokeinterface 153 2 0
    //   63: ifne +21 -> 84
    //   66: aload_1
    //   67: astore_0
    //   68: aload_1
    //   69: iconst_0
    //   70: invokeinterface 157 2 0
    //   75: lstore 5
    //   77: aload_1
    //   78: invokestatic 88	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   81: lload 5
    //   83: lreturn
    //   84: aload_1
    //   85: invokestatic 88	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   88: lload_3
    //   89: lreturn
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_0
    //   95: ldc 14
    //   97: new 90	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   104: ldc 93
    //   106: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_2
    //   110: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 110	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: aload_1
    //   121: invokestatic 88	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   124: lload_3
    //   125: lreturn
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_0
    //   129: aload_0
    //   130: invokestatic 88	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: goto -7 -> 129
    //   139: astore_2
    //   140: goto -47 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramContext	Context
    //   0	143	1	paramUri	Uri
    //   0	143	2	paramString	String
    //   0	143	3	paramLong	long
    //   75	7	5	l	long
    //   9	25	7	str1	String
    //   15	21	8	arrayOfString	String[]
    //   21	17	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   5	43	90	java/lang/Exception
    //   5	43	126	finally
    //   45	54	135	finally
    //   56	66	135	finally
    //   68	77	135	finally
    //   95	120	135	finally
    //   45	54	139	java/lang/Exception
    //   56	66	139	java/lang/Exception
    //   68	77	139	java/lang/Exception
  }
  
  /* Error */
  @Nullable
  private static String queryForString(Context paramContext, Uri paramUri, String paramString1, @Nullable String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 70	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aconst_null
    //   6: checkcast 48	java/lang/String
    //   9: astore 5
    //   11: aconst_null
    //   12: checkcast 72	[Ljava/lang/String;
    //   15: astore 6
    //   17: aconst_null
    //   18: checkcast 48	java/lang/String
    //   21: astore 7
    //   23: aload_0
    //   24: aload_1
    //   25: iconst_1
    //   26: anewarray 48	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: aload_2
    //   32: aastore
    //   33: aload 5
    //   35: aload 6
    //   37: aload 7
    //   39: invokevirtual 80	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokeinterface 149 1 0
    //   51: ifeq +19 -> 70
    //   54: aload_1
    //   55: astore_0
    //   56: aload_1
    //   57: iconst_0
    //   58: invokeinterface 153 2 0
    //   63: istore 4
    //   65: iload 4
    //   67: ifeq +9 -> 76
    //   70: aload_1
    //   71: invokestatic 88	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   74: aload_3
    //   75: areturn
    //   76: aload_1
    //   77: astore_0
    //   78: aload_1
    //   79: iconst_0
    //   80: invokeinterface 161 2 0
    //   85: astore_2
    //   86: aload_1
    //   87: invokestatic 88	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   90: aload_2
    //   91: areturn
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: astore_0
    //   97: ldc 14
    //   99: new 90	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   106: ldc 93
    //   108: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_2
    //   112: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 110	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   121: pop
    //   122: aload_1
    //   123: invokestatic 88	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   126: aload_3
    //   127: areturn
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_0
    //   132: invokestatic 88	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: goto -7 -> 131
    //   141: astore_2
    //   142: goto -47 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramContext	Context
    //   0	145	1	paramUri	Uri
    //   0	145	2	paramString1	String
    //   0	145	3	paramString2	String
    //   63	3	4	bool	boolean
    //   9	25	5	str1	String
    //   15	21	6	arrayOfString	String[]
    //   21	17	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   5	43	92	java/lang/Exception
    //   5	43	128	finally
    //   45	54	137	finally
    //   56	65	137	finally
    //   78	86	137	finally
    //   97	122	137	finally
    //   45	54	141	java/lang/Exception
    //   56	65	141	java/lang/Exception
    //   78	86	141	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.support.v4.provider.DocumentsContractApi19
 * JD-Core Version:    0.7.0.1
 */