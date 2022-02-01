public class rfi
{
  public long BW;
  public String aAe;
  public byte[] bL;
  public String mFileName;
  public long mFileSize;
  public int mHeight;
  public int mWidth;
  
  /* Error */
  public static rfi a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 2	rfi
    //   3: dup
    //   4: invokespecial 27	rfi:<init>	()V
    //   7: astore 6
    //   9: new 29	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: invokestatic 38	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +41 -> 63
    //   25: ldc 40
    //   27: iconst_2
    //   28: new 42	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   35: ldc 45
    //   37: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 51
    //   46: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 5
    //   51: invokevirtual 54	java/io/File:exists	()Z
    //   54: invokevirtual 57	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: new 67	java/io/FileInputStream
    //   66: dup
    //   67: aload 5
    //   69: invokespecial 70	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: astore 4
    //   74: aload 4
    //   76: astore_3
    //   77: aload 6
    //   79: aload 5
    //   81: invokevirtual 74	java/io/File:length	()J
    //   84: putfield 76	rfi:mFileSize	J
    //   87: aload 4
    //   89: astore_3
    //   90: aload 6
    //   92: aload 4
    //   94: aload 6
    //   96: getfield 76	rfi:mFileSize	J
    //   99: invokestatic 82	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   102: putfield 84	rfi:bL	[B
    //   105: aload 4
    //   107: astore_3
    //   108: aload 6
    //   110: aload 6
    //   112: getfield 84	rfi:bL	[B
    //   115: invokestatic 90	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   118: putfield 92	rfi:mFileName	Ljava/lang/String;
    //   121: aload 4
    //   123: astore_3
    //   124: new 94	android/graphics/BitmapFactory$Options
    //   127: dup
    //   128: invokespecial 95	android/graphics/BitmapFactory$Options:<init>	()V
    //   131: astore 5
    //   133: aload 4
    //   135: astore_3
    //   136: aload 5
    //   138: iconst_1
    //   139: putfield 99	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   142: aload 4
    //   144: astore_3
    //   145: aload_0
    //   146: aload 5
    //   148: invokestatic 105	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   151: pop
    //   152: aload 4
    //   154: astore_3
    //   155: aload 6
    //   157: aload 5
    //   159: getfield 108	android/graphics/BitmapFactory$Options:outHeight	I
    //   162: putfield 110	rfi:mHeight	I
    //   165: aload 4
    //   167: astore_3
    //   168: aload 6
    //   170: aload 5
    //   172: getfield 113	android/graphics/BitmapFactory$Options:outWidth	I
    //   175: putfield 115	rfi:mWidth	I
    //   178: aload 4
    //   180: astore_3
    //   181: aload 6
    //   183: aload_0
    //   184: putfield 117	rfi:aAe	Ljava/lang/String;
    //   187: aload 4
    //   189: astore_3
    //   190: aload 6
    //   192: lload_1
    //   193: putfield 119	rfi:BW	J
    //   196: aload 4
    //   198: ifnull +8 -> 206
    //   201: aload 4
    //   203: invokevirtual 122	java/io/FileInputStream:close	()V
    //   206: aload 6
    //   208: areturn
    //   209: astore_0
    //   210: aload_0
    //   211: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   214: aload 6
    //   216: areturn
    //   217: astore 5
    //   219: aconst_null
    //   220: astore_0
    //   221: aload_0
    //   222: astore_3
    //   223: aload 5
    //   225: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   228: aload_0
    //   229: ifnull +7 -> 236
    //   232: aload_0
    //   233: invokevirtual 122	java/io/FileInputStream:close	()V
    //   236: aconst_null
    //   237: areturn
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   243: goto -7 -> 236
    //   246: astore_0
    //   247: aconst_null
    //   248: astore_3
    //   249: aload_3
    //   250: ifnull -44 -> 206
    //   253: aload_3
    //   254: invokevirtual 122	java/io/FileInputStream:close	()V
    //   257: aload 6
    //   259: areturn
    //   260: astore_0
    //   261: aload_0
    //   262: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   265: aload 6
    //   267: areturn
    //   268: astore_0
    //   269: goto -20 -> 249
    //   272: astore 5
    //   274: aload 4
    //   276: astore_0
    //   277: goto -56 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramString	String
    //   0	280	1	paramLong	long
    //   76	178	3	localObject1	Object
    //   72	203	4	localFileInputStream	java.io.FileInputStream
    //   17	154	5	localObject2	Object
    //   217	7	5	localException1	java.lang.Exception
    //   272	1	5	localException2	java.lang.Exception
    //   7	259	6	localrfi	rfi
    // Exception table:
    //   from	to	target	type
    //   201	206	209	java/io/IOException
    //   9	63	217	java/lang/Exception
    //   63	74	217	java/lang/Exception
    //   232	236	238	java/io/IOException
    //   9	63	246	finally
    //   63	74	246	finally
    //   253	257	260	java/io/IOException
    //   77	87	268	finally
    //   90	105	268	finally
    //   108	121	268	finally
    //   124	133	268	finally
    //   136	142	268	finally
    //   145	152	268	finally
    //   155	165	268	finally
    //   168	178	268	finally
    //   181	187	268	finally
    //   190	196	268	finally
    //   223	228	268	finally
    //   77	87	272	java/lang/Exception
    //   90	105	272	java/lang/Exception
    //   108	121	272	java/lang/Exception
    //   124	133	272	java/lang/Exception
    //   136	142	272	java/lang/Exception
    //   145	152	272	java/lang/Exception
    //   155	165	272	java/lang/Exception
    //   168	178	272	java/lang/Exception
    //   181	187	272	java/lang/Exception
    //   190	196	272	java/lang/Exception
  }
  
  public String toString()
  {
    return "FilterUploadInfo{mFileOringinPath='" + this.aAe + '\'' + ", mFileSize=" + this.mFileSize + ", mLocalMd5=" + new String(this.bL) + ", mFileName='" + this.mFileName + '\'' + ", mHeight=" + this.mHeight + ", mWidth=" + this.mWidth + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfi
 * JD-Core Version:    0.7.0.1
 */