import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.cloudfile.CloudUploadFileOption.1;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class atik
{
  private atik.a b;
  
  public atik(atik.a parama)
  {
    this.b = parama;
  }
  
  private void G(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      return;
      paramString = paramString.listFiles();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
          localObject.delete();
        }
        i += 1;
      }
    }
  }
  
  private void a(String paramString1, InputStream paramInputStream, long paramLong, String paramString2)
  {
    ThreadManager.post(new CloudUploadFileOption.1(this, paramString1, paramInputStream, paramLong, paramString2), 5, null, true);
  }
  
  /* Error */
  private String c(Uri paramUri, Context paramContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: checkcast 68	android/app/Activity
    //   4: astore 10
    //   6: aload 10
    //   8: invokevirtual 72	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   11: astore 11
    //   13: aload 11
    //   15: aload_1
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokestatic 78	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnonnull +31 -> 56
    //   28: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +11 -> 42
    //   34: ldc 85
    //   36: iconst_2
    //   37: ldc 87
    //   39: invokestatic 91	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_2
    //   43: ifnull +9 -> 52
    //   46: aload_2
    //   47: invokeinterface 96 1 0
    //   52: aconst_null
    //   53: astore_1
    //   54: aload_1
    //   55: areturn
    //   56: aload_2
    //   57: ldc 98
    //   59: invokeinterface 102 2 0
    //   64: istore 5
    //   66: aload_2
    //   67: ldc 104
    //   69: invokeinterface 102 2 0
    //   74: istore 6
    //   76: aload_2
    //   77: invokeinterface 107 1 0
    //   82: pop
    //   83: aload_2
    //   84: iload 6
    //   86: invokeinterface 111 2 0
    //   91: lstore 7
    //   93: lload 7
    //   95: l2f
    //   96: fstore_3
    //   97: invokestatic 117	aqhq:bB	()F
    //   100: fstore 4
    //   102: fload_3
    //   103: fload 4
    //   105: fcmpl
    //   106: ifle +15 -> 121
    //   109: aload_2
    //   110: ifnull +9 -> 119
    //   113: aload_2
    //   114: invokeinterface 96 1 0
    //   119: aconst_null
    //   120: areturn
    //   121: iload 5
    //   123: iconst_m1
    //   124: if_icmpne +147 -> 271
    //   127: new 119	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   134: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   137: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   140: ldc 126
    //   142: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore 9
    //   150: new 119	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   157: aload 10
    //   159: invokevirtual 137	android/app/Activity:getExternalCacheDir	()Ljava/io/File;
    //   162: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: ldc 142
    //   167: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc 144
    //   172: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 142
    //   177: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: astore 12
    //   185: aload_0
    //   186: aload 12
    //   188: invokespecial 146	atik:G	(Ljava/lang/String;)V
    //   191: new 119	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   198: aload 12
    //   200: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload 12
    //   205: aload 9
    //   207: invokestatic 150	aqhq:bY	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   210: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: astore 10
    //   218: new 21	java/io/File
    //   221: dup
    //   222: aload 12
    //   224: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   227: astore 12
    //   229: aload 12
    //   231: invokevirtual 27	java/io/File:exists	()Z
    //   234: ifne +50 -> 284
    //   237: aload 12
    //   239: invokevirtual 153	java/io/File:mkdirs	()Z
    //   242: ifne +42 -> 284
    //   245: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +11 -> 259
    //   251: ldc 85
    //   253: iconst_2
    //   254: ldc 155
    //   256: invokestatic 91	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload_2
    //   260: ifnull +9 -> 269
    //   263: aload_2
    //   264: invokeinterface 96 1 0
    //   269: aconst_null
    //   270: areturn
    //   271: aload_2
    //   272: iload 5
    //   274: invokeinterface 159 2 0
    //   279: astore 9
    //   281: goto -131 -> 150
    //   284: aload 11
    //   286: aload_1
    //   287: invokevirtual 165	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   290: astore_1
    //   291: aload_1
    //   292: ifnonnull +29 -> 321
    //   295: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +11 -> 309
    //   301: ldc 85
    //   303: iconst_2
    //   304: ldc 167
    //   306: invokestatic 91	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload_2
    //   310: ifnull +9 -> 319
    //   313: aload_2
    //   314: invokeinterface 96 1 0
    //   319: aconst_null
    //   320: areturn
    //   321: aload_0
    //   322: aload 10
    //   324: aload_1
    //   325: lload 7
    //   327: aload 9
    //   329: invokespecial 169	atik:a	(Ljava/lang/String;Ljava/io/InputStream;JLjava/lang/String;)V
    //   332: aload 10
    //   334: astore_1
    //   335: aload_2
    //   336: ifnull -282 -> 54
    //   339: aload_2
    //   340: invokeinterface 96 1 0
    //   345: aload 10
    //   347: areturn
    //   348: astore_2
    //   349: aconst_null
    //   350: astore_1
    //   351: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +12 -> 366
    //   357: ldc 85
    //   359: iconst_2
    //   360: ldc 171
    //   362: aload_2
    //   363: invokestatic 174	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   366: aload_1
    //   367: ifnull +9 -> 376
    //   370: aload_1
    //   371: invokeinterface 96 1 0
    //   376: aconst_null
    //   377: areturn
    //   378: astore_1
    //   379: aconst_null
    //   380: astore_2
    //   381: aload_2
    //   382: ifnull +9 -> 391
    //   385: aload_2
    //   386: invokeinterface 96 1 0
    //   391: aload_1
    //   392: athrow
    //   393: astore_1
    //   394: goto -13 -> 381
    //   397: astore 9
    //   399: aload_1
    //   400: astore_2
    //   401: aload 9
    //   403: astore_1
    //   404: goto -23 -> 381
    //   407: astore 9
    //   409: aload_2
    //   410: astore_1
    //   411: aload 9
    //   413: astore_2
    //   414: goto -63 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	atik
    //   0	417	1	paramUri	Uri
    //   0	417	2	paramContext	Context
    //   96	7	3	f1	float
    //   100	4	4	f2	float
    //   64	209	5	i	int
    //   74	11	6	j	int
    //   91	235	7	l	long
    //   148	180	9	str	String
    //   397	5	9	localObject1	Object
    //   407	5	9	localException	java.lang.Exception
    //   4	342	10	localObject2	Object
    //   11	274	11	localContentResolver	android.content.ContentResolver
    //   183	55	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   13	24	348	java/lang/Exception
    //   13	24	378	finally
    //   28	42	393	finally
    //   56	93	393	finally
    //   97	102	393	finally
    //   127	150	393	finally
    //   150	259	393	finally
    //   271	281	393	finally
    //   284	291	393	finally
    //   295	309	393	finally
    //   321	332	393	finally
    //   351	366	397	finally
    //   28	42	407	java/lang/Exception
    //   56	93	407	java/lang/Exception
    //   97	102	407	java/lang/Exception
    //   127	150	407	java/lang/Exception
    //   150	259	407	java/lang/Exception
    //   271	281	407	java/lang/Exception
    //   284	291	407	java/lang/Exception
    //   295	309	407	java/lang/Exception
    //   321	332	407	java/lang/Exception
  }
  
  /* Error */
  private String getDataColumn(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokevirtual 179	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: aload_2
    //   8: iconst_1
    //   9: anewarray 181	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc 183
    //   16: aastore
    //   17: aload_3
    //   18: aload 4
    //   20: aconst_null
    //   21: invokestatic 78	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +79 -> 105
    //   29: aload_3
    //   30: invokeinterface 107 1 0
    //   35: ifeq +70 -> 105
    //   38: aload_3
    //   39: aload_3
    //   40: ldc 183
    //   42: invokeinterface 186 2 0
    //   47: invokeinterface 159 2 0
    //   52: astore 4
    //   54: aload 4
    //   56: invokestatic 192	aueh:sV	(Ljava/lang/String;)Z
    //   59: ifne +30 -> 89
    //   62: aload_0
    //   63: aload_2
    //   64: aload_1
    //   65: invokespecial 194	atik:c	(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;
    //   68: astore 4
    //   70: aload 4
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_3
    //   76: ifnull +11 -> 87
    //   79: aload_3
    //   80: invokeinterface 96 1 0
    //   85: aload_2
    //   86: astore_1
    //   87: aload_1
    //   88: areturn
    //   89: aload 4
    //   91: astore_1
    //   92: aload_3
    //   93: ifnull -6 -> 87
    //   96: aload_3
    //   97: invokeinterface 96 1 0
    //   102: aload 4
    //   104: areturn
    //   105: aload_3
    //   106: ifnull +9 -> 115
    //   109: aload_3
    //   110: invokeinterface 96 1 0
    //   115: aconst_null
    //   116: areturn
    //   117: astore 4
    //   119: aload 5
    //   121: astore_3
    //   122: aload 4
    //   124: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   127: aload_0
    //   128: aload_2
    //   129: aload_1
    //   130: invokespecial 194	atik:c	(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;
    //   133: astore_2
    //   134: aload_2
    //   135: astore_1
    //   136: aload_3
    //   137: ifnull -50 -> 87
    //   140: aload_3
    //   141: invokeinterface 96 1 0
    //   146: aload_2
    //   147: areturn
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_3
    //   151: aload_3
    //   152: ifnull +9 -> 161
    //   155: aload_3
    //   156: invokeinterface 96 1 0
    //   161: aload_1
    //   162: athrow
    //   163: astore_1
    //   164: goto -13 -> 151
    //   167: astore_1
    //   168: goto -17 -> 151
    //   171: astore 4
    //   173: goto -51 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	atik
    //   0	176	1	paramContext	Context
    //   0	176	2	paramUri	Uri
    //   0	176	3	paramString	String
    //   0	176	4	paramArrayOfString	String[]
    //   1	119	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	25	117	java/lang/Exception
    //   3	25	148	finally
    //   29	70	163	finally
    //   122	134	167	finally
    //   29	70	171	java/lang/Exception
  }
  
  private void x(String paramString1, String paramString2, long paramLong)
  {
    String str;
    long l;
    if (paramLong != 0L)
    {
      str = paramString1;
      l = paramLong;
      if (paramString1 != null) {}
    }
    else
    {
      str = paramString1;
      l = paramLong;
      if (paramString2 != null)
      {
        str = ahav.getFileName(paramString2);
        l = ahav.getFileSizes(paramString2);
      }
    }
    if ((str != null) && (paramString2 != null) && (l != 0L) && (aueh.sV(paramString2)))
    {
      paramString1 = new FileInfo();
      paramString1.setPath(paramString2);
      paramString1.setSize(l);
      paramString1.setName(str);
      paramString2 = new ArrayList();
      paramString2.add(paramString1);
      this.b.fK(paramString2);
    }
  }
  
  public void b(Uri paramUri, Context paramContext)
  {
    Object localObject = null;
    long l1 = 0L;
    String str;
    if (paramUri != null)
    {
      str = paramUri.getScheme();
      if ((str == null) || (str.equals("file")))
      {
        paramUri = new File(paramUri.getPath());
        if (paramUri == null) {
          break label201;
        }
        paramUri = paramUri.getAbsolutePath();
        paramContext = localObject;
      }
    }
    for (;;)
    {
      x(paramContext, paramUri, l1);
      return;
      if (str.equals("content"))
      {
        Cursor localCursor = alld.query(paramContext.getContentResolver(), paramUri, null, null, null, null);
        if (localCursor == null) {
          break label193;
        }
        localCursor.moveToFirst();
        long l2 = localCursor.getLong(localCursor.getColumnIndex("_size"));
        str = localCursor.getString(localCursor.getColumnIndex("_display_name"));
        localObject = str;
        l1 = l2;
        if (Integer.parseInt(Build.VERSION.SDK) < 14)
        {
          localCursor.close();
          l1 = l2;
          localObject = str;
        }
      }
      for (;;)
      {
        paramUri = getDataColumn(paramContext, paramUri, null, null);
        paramContext = localObject;
        break;
        paramUri = paramUri.getPath();
        paramContext = localObject;
        break;
        label193:
        localObject = null;
        l1 = 0L;
      }
      label201:
      paramUri = null;
      paramContext = localObject;
    }
  }
  
  public static abstract interface a
  {
    public abstract void fK(List<FileInfo> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atik
 * JD-Core Version:    0.7.0.1
 */