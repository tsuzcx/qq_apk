public class nch
{
  public long bitrate;
  public long duration;
  public long fileSize;
  public int height;
  public int rotate;
  public int width;
  public long xk;
  
  /* Error */
  @android.support.annotation.RequiresApi(api=16)
  public static nch a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 33	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 35	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 42	java/io/File:exists	()Z
    //   24: ifeq +21 -> 45
    //   27: aload 4
    //   29: invokevirtual 45	java/io/File:isFile	()Z
    //   32: ifeq +13 -> 45
    //   35: aload 4
    //   37: invokevirtual 49	java/io/File:length	()J
    //   40: lconst_0
    //   41: lcmp
    //   42: ifne +30 -> 72
    //   45: ldc 51
    //   47: iconst_1
    //   48: new 53	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   55: ldc 56
    //   57: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aconst_null
    //   71: areturn
    //   72: new 2	nch
    //   75: dup
    //   76: invokespecial 71	nch:<init>	()V
    //   79: astore_3
    //   80: aload_3
    //   81: aload 4
    //   83: invokevirtual 49	java/io/File:length	()J
    //   86: putfield 73	nch:fileSize	J
    //   89: new 75	android/media/MediaMetadataRetriever
    //   92: dup
    //   93: invokespecial 76	android/media/MediaMetadataRetriever:<init>	()V
    //   96: astore 4
    //   98: aload 4
    //   100: aload_0
    //   101: invokevirtual 79	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   104: aload_3
    //   105: aload 4
    //   107: bipush 18
    //   109: invokevirtual 83	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   112: invokestatic 89	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   115: invokevirtual 93	java/lang/Integer:intValue	()I
    //   118: putfield 95	nch:width	I
    //   121: aload_3
    //   122: aload 4
    //   124: bipush 19
    //   126: invokevirtual 83	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   129: invokestatic 89	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   132: invokevirtual 93	java/lang/Integer:intValue	()I
    //   135: putfield 97	nch:height	I
    //   138: aload_3
    //   139: aload 4
    //   141: bipush 24
    //   143: invokevirtual 83	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   146: invokestatic 89	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   149: invokevirtual 93	java/lang/Integer:intValue	()I
    //   152: putfield 99	nch:rotate	I
    //   155: aload_3
    //   156: aload 4
    //   158: bipush 9
    //   160: invokevirtual 83	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   163: invokestatic 89	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   166: invokevirtual 93	java/lang/Integer:intValue	()I
    //   169: i2l
    //   170: putfield 101	nch:duration	J
    //   173: aload_3
    //   174: aload 4
    //   176: bipush 20
    //   178: invokevirtual 83	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   181: invokestatic 89	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   184: invokevirtual 93	java/lang/Integer:intValue	()I
    //   187: i2l
    //   188: putfield 103	nch:bitrate	J
    //   191: aload 4
    //   193: invokevirtual 106	android/media/MediaMetadataRetriever:release	()V
    //   196: new 108	android/media/MediaExtractor
    //   199: dup
    //   200: invokespecial 109	android/media/MediaExtractor:<init>	()V
    //   203: astore 4
    //   205: aload 4
    //   207: aload_0
    //   208: invokevirtual 110	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   211: aload 4
    //   213: invokevirtual 113	android/media/MediaExtractor:getTrackCount	()I
    //   216: istore_2
    //   217: iconst_0
    //   218: istore_1
    //   219: iload_1
    //   220: iload_2
    //   221: if_icmpge +119 -> 340
    //   224: aload 4
    //   226: iload_1
    //   227: invokevirtual 117	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   230: astore_0
    //   231: aload_0
    //   232: ldc 119
    //   234: invokevirtual 125	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   237: ldc 127
    //   239: invokevirtual 133	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   242: ifeq +63 -> 305
    //   245: aload_0
    //   246: ldc 135
    //   248: invokevirtual 138	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   251: ifeq +14 -> 265
    //   254: aload_3
    //   255: aload_0
    //   256: ldc 135
    //   258: invokevirtual 142	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   261: i2l
    //   262: putfield 144	nch:xk	J
    //   265: aload_3
    //   266: getfield 101	nch:duration	J
    //   269: lconst_0
    //   270: lcmp
    //   271: ifne +14 -> 285
    //   274: aload_3
    //   275: aload_0
    //   276: ldc 146
    //   278: invokevirtual 142	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   281: i2l
    //   282: putfield 101	nch:duration	J
    //   285: aload_3
    //   286: getfield 103	nch:bitrate	J
    //   289: lconst_0
    //   290: lcmp
    //   291: ifne +14 -> 305
    //   294: aload_3
    //   295: aload_0
    //   296: ldc 147
    //   298: invokevirtual 142	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   301: i2l
    //   302: putfield 103	nch:bitrate	J
    //   305: iload_1
    //   306: iconst_1
    //   307: iadd
    //   308: istore_1
    //   309: goto -90 -> 219
    //   312: astore 5
    //   314: ldc 51
    //   316: iconst_1
    //   317: ldc 149
    //   319: aload 5
    //   321: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: aload 4
    //   326: invokevirtual 106	android/media/MediaMetadataRetriever:release	()V
    //   329: goto -133 -> 196
    //   332: astore_0
    //   333: aload 4
    //   335: invokevirtual 106	android/media/MediaMetadataRetriever:release	()V
    //   338: aload_0
    //   339: athrow
    //   340: aload 4
    //   342: invokevirtual 153	android/media/MediaExtractor:release	()V
    //   345: aload_3
    //   346: areturn
    //   347: astore_0
    //   348: ldc 51
    //   350: iconst_1
    //   351: ldc 149
    //   353: aload_0
    //   354: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   357: aload 4
    //   359: invokevirtual 153	android/media/MediaExtractor:release	()V
    //   362: aload_3
    //   363: areturn
    //   364: astore_0
    //   365: ldc 51
    //   367: iconst_1
    //   368: ldc 149
    //   370: aload_0
    //   371: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   374: aload 4
    //   376: invokevirtual 153	android/media/MediaExtractor:release	()V
    //   379: aload_3
    //   380: areturn
    //   381: astore_0
    //   382: aload 4
    //   384: invokevirtual 153	android/media/MediaExtractor:release	()V
    //   387: aload_0
    //   388: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramString	String
    //   218	91	1	i	int
    //   216	6	2	j	int
    //   79	301	3	localnch	nch
    //   17	366	4	localObject	Object
    //   312	8	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   98	191	312	java/lang/Throwable
    //   98	191	332	finally
    //   314	324	332	finally
    //   205	217	347	java/io/IOException
    //   224	265	347	java/io/IOException
    //   265	285	347	java/io/IOException
    //   285	305	347	java/io/IOException
    //   205	217	364	java/lang/Throwable
    //   224	265	364	java/lang/Throwable
    //   265	285	364	java/lang/Throwable
    //   285	305	364	java/lang/Throwable
    //   205	217	381	finally
    //   224	265	381	finally
    //   265	285	381	finally
    //   285	305	381	finally
    //   348	357	381	finally
    //   365	374	381	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("VideoMediaInfo[ ").append("\n");
    localStringBuilder.append("width: ").append(this.width).append("\n");
    localStringBuilder.append("height: ").append(this.height).append("\n");
    localStringBuilder.append("frameRate: ").append(this.xk).append("\n");
    localStringBuilder.append("bitrate: ").append(this.bitrate).append("\n");
    localStringBuilder.append("rotate: ").append(this.rotate).append("\n");
    localStringBuilder.append("duration: ").append(this.duration).append("\n");
    localStringBuilder.append("fileSize: ").append(this.fileSize).append("\n");
    localStringBuilder.append("] ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nch
 * JD-Core Version:    0.7.0.1
 */