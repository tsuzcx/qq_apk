package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class TreeDocumentFile
  extends DocumentFile
{
  private Context mContext;
  private Uri mUri;
  
  TreeDocumentFile(DocumentFile paramDocumentFile, Context paramContext, Uri paramUri)
  {
    super(paramDocumentFile);
    this.mContext = paramContext;
    this.mUri = paramUri;
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
  
  private static Uri createFile(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    try
    {
      paramContext = DocumentsContract.createDocument(paramContext.getContentResolver(), paramUri, paramString1, paramString2);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label13:
      break label13;
    }
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
  
  public DocumentFile createDirectory(String paramString)
  {
    paramString = createFile(this.mContext, this.mUri, "vnd.android.document/directory", paramString);
    if (paramString != null) {
      return new TreeDocumentFile(this, this.mContext, paramString);
    }
    return null;
  }
  
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
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    return false;
  }
  
  public boolean exists()
  {
    return DocumentsContractApi19.exists(this.mContext, this.mUri);
  }
  
  public String getName()
  {
    return DocumentsContractApi19.getName(this.mContext, this.mUri);
  }
  
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
    //   1: getfield 18	android/support/v4/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   4: invokevirtual 41	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 20	android/support/v4/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   13: astore_2
    //   14: aload_2
    //   15: aload_2
    //   16: invokestatic 107	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   19: invokestatic 111	android/provider/DocumentsContract:buildChildDocumentsUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   22: astore 5
    //   24: new 113	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 115	java/util/ArrayList:<init>	()V
    //   31: astore 6
    //   33: iconst_0
    //   34: istore_1
    //   35: aconst_null
    //   36: astore_2
    //   37: aconst_null
    //   38: astore_3
    //   39: aload 4
    //   41: aload 5
    //   43: iconst_1
    //   44: anewarray 117	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc 119
    //   51: aastore
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 125	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 4
    //   60: aload 4
    //   62: astore 5
    //   64: aload 4
    //   66: astore_3
    //   67: aload 4
    //   69: astore_2
    //   70: aload 4
    //   72: invokeinterface 130 1 0
    //   77: ifeq +43 -> 120
    //   80: aload 4
    //   82: astore_3
    //   83: aload 4
    //   85: astore_2
    //   86: aload 4
    //   88: iconst_0
    //   89: invokeinterface 134 2 0
    //   94: astore 5
    //   96: aload 4
    //   98: astore_3
    //   99: aload 4
    //   101: astore_2
    //   102: aload 6
    //   104: aload_0
    //   105: getfield 20	android/support/v4/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   108: aload 5
    //   110: invokestatic 137	android/provider/DocumentsContract:buildDocumentUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   113: invokevirtual 141	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   116: pop
    //   117: goto -57 -> 60
    //   120: aload 5
    //   122: invokestatic 143	android/support/v4/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   125: goto +59 -> 184
    //   128: astore_2
    //   129: goto +111 -> 240
    //   132: astore 4
    //   134: aload_2
    //   135: astore_3
    //   136: new 145	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   143: astore 5
    //   145: aload_2
    //   146: astore_3
    //   147: aload 5
    //   149: ldc 148
    //   151: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_2
    //   156: astore_3
    //   157: aload 5
    //   159: aload 4
    //   161: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_2
    //   166: astore_3
    //   167: ldc 157
    //   169: aload 5
    //   171: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 166	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   177: pop
    //   178: aload_2
    //   179: astore 5
    //   181: goto -61 -> 120
    //   184: aload 6
    //   186: aload 6
    //   188: invokevirtual 170	java/util/ArrayList:size	()I
    //   191: anewarray 172	android/net/Uri
    //   194: invokevirtual 176	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   197: checkcast 178	[Landroid/net/Uri;
    //   200: astore_2
    //   201: aload_2
    //   202: arraylength
    //   203: anewarray 4	android/support/v4/provider/DocumentFile
    //   206: astore_3
    //   207: iload_1
    //   208: aload_2
    //   209: arraylength
    //   210: if_icmpge +28 -> 238
    //   213: aload_3
    //   214: iload_1
    //   215: new 2	android/support/v4/provider/TreeDocumentFile
    //   218: dup
    //   219: aload_0
    //   220: aload_0
    //   221: getfield 18	android/support/v4/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   224: aload_2
    //   225: iload_1
    //   226: aaload
    //   227: invokespecial 65	android/support/v4/provider/TreeDocumentFile:<init>	(Landroid/support/v4/provider/DocumentFile;Landroid/content/Context;Landroid/net/Uri;)V
    //   230: aastore
    //   231: iload_1
    //   232: iconst_1
    //   233: iadd
    //   234: istore_1
    //   235: goto -28 -> 207
    //   238: aload_3
    //   239: areturn
    //   240: aload_3
    //   241: invokestatic 143	android/support/v4/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   244: aload_2
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	TreeDocumentFile
    //   34	201	1	i	int
    //   13	89	2	localObject1	java.lang.Object
    //   128	51	2	localObject2	java.lang.Object
    //   200	45	2	arrayOfUri	Uri[]
    //   38	203	3	localObject3	java.lang.Object
    //   7	93	4	localObject4	java.lang.Object
    //   132	28	4	localException	Exception
    //   22	158	5	localObject5	java.lang.Object
    //   31	156	6	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   39	60	128	finally
    //   70	80	128	finally
    //   86	96	128	finally
    //   102	117	128	finally
    //   136	145	128	finally
    //   147	155	128	finally
    //   157	165	128	finally
    //   167	178	128	finally
    //   39	60	132	java/lang/Exception
    //   70	80	132	java/lang/Exception
    //   86	96	132	java/lang/Exception
    //   102	117	132	java/lang/Exception
  }
  
  public boolean renameTo(String paramString)
  {
    try
    {
      paramString = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, paramString);
      if (paramString != null)
      {
        this.mUri = paramString;
        return true;
      }
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.TreeDocumentFile
 * JD-Core Version:    0.7.0.1
 */