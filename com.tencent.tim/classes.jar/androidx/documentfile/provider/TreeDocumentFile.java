package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class TreeDocumentFile
  extends DocumentFile
{
  private Context mContext;
  private Uri mUri;
  
  TreeDocumentFile(@Nullable DocumentFile paramDocumentFile, Context paramContext, Uri paramUri)
  {
    super(paramDocumentFile);
    this.mContext = paramContext;
    this.mUri = paramUri;
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
  
  @Nullable
  private static Uri createFile(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    try
    {
      paramContext = DocumentsContract.createDocument(paramContext.getContentResolver(), paramUri, paramString1, paramString2);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public boolean canRead()
  {
    return DocumentsContractApi19.canRead(this.mContext, this.mUri);
  }
  
  public boolean canWrite()
  {
    return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
  }
  
  @Nullable
  public DocumentFile createDirectory(String paramString)
  {
    paramString = createFile(this.mContext, this.mUri, "vnd.android.document/directory", paramString);
    if (paramString != null) {
      return new TreeDocumentFile(this, this.mContext, paramString);
    }
    return null;
  }
  
  @Nullable
  public DocumentFile createFile(String paramString1, String paramString2)
  {
    paramString1 = createFile(this.mContext, this.mUri, paramString1, paramString2);
    if (paramString1 != null) {
      return new TreeDocumentFile(this, this.mContext, paramString1);
    }
    return null;
  }
  
  public boolean delete()
  {
    try
    {
      boolean bool = DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean exists()
  {
    return DocumentsContractApi19.exists(this.mContext, this.mUri);
  }
  
  @Nullable
  public String getName()
  {
    return DocumentsContractApi19.getName(this.mContext, this.mUri);
  }
  
  @Nullable
  public String getType()
  {
    return DocumentsContractApi19.getType(this.mContext, this.mUri);
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean isDirectory()
  {
    return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
  }
  
  public boolean isFile()
  {
    return DocumentsContractApi19.isFile(this.mContext, this.mUri);
  }
  
  public boolean isVirtual()
  {
    return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
  }
  
  public long lastModified()
  {
    return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
  }
  
  public long length()
  {
    return DocumentsContractApi19.length(this.mContext, this.mUri);
  }
  
  /* Error */
  public DocumentFile[] listFiles()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	androidx/documentfile/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   4: invokevirtual 43	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 21	androidx/documentfile/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   12: aload_0
    //   13: getfield 21	androidx/documentfile/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   16: invokestatic 110	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   19: invokestatic 114	android/provider/DocumentsContract:buildChildDocumentsUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   22: astore_3
    //   23: new 116	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 118	java/util/ArrayList:<init>	()V
    //   30: astore 5
    //   32: aload_2
    //   33: aload_3
    //   34: iconst_1
    //   35: anewarray 120	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: ldc 122
    //   42: aastore
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 128	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_3
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: invokeinterface 133 1 0
    //   58: ifeq +124 -> 182
    //   61: aload_3
    //   62: astore_2
    //   63: aload_3
    //   64: iconst_0
    //   65: invokeinterface 137 2 0
    //   70: astore 4
    //   72: aload_3
    //   73: astore_2
    //   74: aload 5
    //   76: aload_0
    //   77: getfield 21	androidx/documentfile/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   80: aload 4
    //   82: invokestatic 140	android/provider/DocumentsContract:buildDocumentUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   85: invokevirtual 144	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   88: pop
    //   89: goto -39 -> 50
    //   92: astore 4
    //   94: aload_3
    //   95: astore_2
    //   96: ldc 146
    //   98: new 148	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   105: ldc 151
    //   107: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 4
    //   112: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 167	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   121: pop
    //   122: aload_3
    //   123: invokestatic 169	androidx/documentfile/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   126: aload 5
    //   128: aload 5
    //   130: invokevirtual 173	java/util/ArrayList:size	()I
    //   133: anewarray 175	android/net/Uri
    //   136: invokevirtual 179	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   139: checkcast 181	[Landroid/net/Uri;
    //   142: astore_2
    //   143: aload_2
    //   144: arraylength
    //   145: anewarray 4	androidx/documentfile/provider/DocumentFile
    //   148: astore_3
    //   149: iconst_0
    //   150: istore_1
    //   151: iload_1
    //   152: aload_2
    //   153: arraylength
    //   154: if_icmpge +44 -> 198
    //   157: aload_3
    //   158: iload_1
    //   159: new 2	androidx/documentfile/provider/TreeDocumentFile
    //   162: dup
    //   163: aload_0
    //   164: aload_0
    //   165: getfield 19	androidx/documentfile/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   168: aload_2
    //   169: iload_1
    //   170: aaload
    //   171: invokespecial 68	androidx/documentfile/provider/TreeDocumentFile:<init>	(Landroidx/documentfile/provider/DocumentFile;Landroid/content/Context;Landroid/net/Uri;)V
    //   174: aastore
    //   175: iload_1
    //   176: iconst_1
    //   177: iadd
    //   178: istore_1
    //   179: goto -28 -> 151
    //   182: aload_3
    //   183: invokestatic 169	androidx/documentfile/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   186: goto -60 -> 126
    //   189: astore_3
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_2
    //   193: invokestatic 169	androidx/documentfile/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   196: aload_3
    //   197: athrow
    //   198: aload_3
    //   199: areturn
    //   200: astore_3
    //   201: goto -9 -> 192
    //   204: astore 4
    //   206: aconst_null
    //   207: astore_3
    //   208: goto -114 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	TreeDocumentFile
    //   150	29	1	i	int
    //   7	186	2	localObject1	java.lang.Object
    //   22	161	3	localObject2	java.lang.Object
    //   189	10	3	arrayOfDocumentFile	DocumentFile[]
    //   200	1	3	localObject3	java.lang.Object
    //   207	1	3	localObject4	java.lang.Object
    //   70	11	4	str	String
    //   92	19	4	localException1	Exception
    //   204	1	4	localException2	Exception
    //   30	99	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   52	61	92	java/lang/Exception
    //   63	72	92	java/lang/Exception
    //   74	89	92	java/lang/Exception
    //   32	50	189	finally
    //   52	61	200	finally
    //   63	72	200	finally
    //   74	89	200	finally
    //   96	122	200	finally
    //   32	50	204	java/lang/Exception
  }
  
  public boolean renameTo(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, paramString);
      if (paramString != null)
      {
        this.mUri = paramString;
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.documentfile.provider.TreeDocumentFile
 * JD-Core Version:    0.7.0.1
 */