package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
public class TreeDocumentFile
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
    //   1: getfield 19	android/support/v4/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   4: invokevirtual 43	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 21	android/support/v4/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   12: aload_0
    //   13: getfield 21	android/support/v4/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   16: invokestatic 110	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   19: invokestatic 114	android/provider/DocumentsContract:buildChildDocumentsUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   22: astore_3
    //   23: new 116	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 118	java/util/ArrayList:<init>	()V
    //   30: astore 5
    //   32: aconst_null
    //   33: checkcast 120	java/lang/String
    //   36: astore 4
    //   38: aconst_null
    //   39: checkcast 122	[Ljava/lang/String;
    //   42: astore 6
    //   44: aconst_null
    //   45: checkcast 120	java/lang/String
    //   48: astore 7
    //   50: aload_2
    //   51: aload_3
    //   52: iconst_1
    //   53: anewarray 120	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: ldc 124
    //   60: aastore
    //   61: aload 4
    //   63: aload 6
    //   65: aload 7
    //   67: invokevirtual 130	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_3
    //   74: invokeinterface 135 1 0
    //   79: ifeq +127 -> 206
    //   82: aload_3
    //   83: astore_2
    //   84: aload_3
    //   85: iconst_0
    //   86: invokeinterface 139 2 0
    //   91: astore 4
    //   93: aload_3
    //   94: astore_2
    //   95: aload 5
    //   97: aload_0
    //   98: getfield 21	android/support/v4/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   101: aload 4
    //   103: invokestatic 142	android/provider/DocumentsContract:buildDocumentUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   106: invokevirtual 146	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   109: pop
    //   110: goto -39 -> 71
    //   113: astore 4
    //   115: aload_3
    //   116: astore_2
    //   117: ldc 148
    //   119: new 150	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   126: ldc 153
    //   128: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload 4
    //   133: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 169	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   142: pop
    //   143: aload_3
    //   144: invokestatic 171	android/support/v4/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   147: aload 5
    //   149: aload 5
    //   151: invokevirtual 175	java/util/ArrayList:size	()I
    //   154: anewarray 177	android/net/Uri
    //   157: invokevirtual 181	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   160: checkcast 183	[Landroid/net/Uri;
    //   163: checkcast 183	[Landroid/net/Uri;
    //   166: astore_2
    //   167: aload_2
    //   168: arraylength
    //   169: anewarray 4	android/support/v4/provider/DocumentFile
    //   172: astore_3
    //   173: iconst_0
    //   174: istore_1
    //   175: iload_1
    //   176: aload_2
    //   177: arraylength
    //   178: if_icmpge +44 -> 222
    //   181: aload_3
    //   182: iload_1
    //   183: new 2	android/support/v4/provider/TreeDocumentFile
    //   186: dup
    //   187: aload_0
    //   188: aload_0
    //   189: getfield 19	android/support/v4/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   192: aload_2
    //   193: iload_1
    //   194: aaload
    //   195: invokespecial 68	android/support/v4/provider/TreeDocumentFile:<init>	(Landroid/support/v4/provider/DocumentFile;Landroid/content/Context;Landroid/net/Uri;)V
    //   198: aastore
    //   199: iload_1
    //   200: iconst_1
    //   201: iadd
    //   202: istore_1
    //   203: goto -28 -> 175
    //   206: aload_3
    //   207: invokestatic 171	android/support/v4/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   210: goto -63 -> 147
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_2
    //   216: aload_2
    //   217: invokestatic 171	android/support/v4/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   220: aload_3
    //   221: athrow
    //   222: aload_3
    //   223: areturn
    //   224: astore_3
    //   225: goto -9 -> 216
    //   228: astore 4
    //   230: aconst_null
    //   231: astore_3
    //   232: goto -117 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	TreeDocumentFile
    //   174	29	1	i	int
    //   7	210	2	localObject1	java.lang.Object
    //   22	185	3	localObject2	java.lang.Object
    //   213	10	3	arrayOfDocumentFile	DocumentFile[]
    //   224	1	3	localObject3	java.lang.Object
    //   231	1	3	localObject4	java.lang.Object
    //   36	66	4	str1	String
    //   113	19	4	localException1	Exception
    //   228	1	4	localException2	Exception
    //   30	120	5	localArrayList	java.util.ArrayList
    //   42	22	6	arrayOfString	String[]
    //   48	18	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   73	82	113	java/lang/Exception
    //   84	93	113	java/lang/Exception
    //   95	110	113	java/lang/Exception
    //   32	71	213	finally
    //   73	82	224	finally
    //   84	93	224	finally
    //   95	110	224	finally
    //   117	143	224	finally
    //   32	71	228	java/lang/Exception
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
 * Qualified Name:     android.support.v4.provider.TreeDocumentFile
 * JD-Core Version:    0.7.0.1
 */