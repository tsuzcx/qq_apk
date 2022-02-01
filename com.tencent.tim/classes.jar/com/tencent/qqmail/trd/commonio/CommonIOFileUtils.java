package com.tencent.qqmail.trd.commonio;

import com.tencent.qqmail.utilities.fileextention.FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CommonIOFileUtils
{
  public static final File[] EMPTY_FILE_ARRAY = new File[0];
  private static final long FILE_COPY_BUFFER_SIZE = 1048576L;
  public static final long ONE_KB = 1024L;
  public static final long ONE_MB = 1048576L;
  
  public static void copyFile(File paramFile1, File paramFile2)
    throws IOException
  {
    copyFile(paramFile1, paramFile2, true);
  }
  
  public static void copyFile(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' exists but is a directory");
    }
    if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
      throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
    }
    File localFile = paramFile2.getParentFile();
    if ((localFile != null) && (!FileUtil.tryMkdirs(localFile))) {
      throw new IOException("Destination '" + localFile + "' directory cannot be created");
    }
    if ((paramFile2.exists()) && (!paramFile2.canWrite())) {
      throw new IOException("Destination '" + paramFile2 + "' exists but is read-only");
    }
    doCopyFile(paramFile1, paramFile2, paramBoolean);
  }
  
  public static void copyFileToDirectory(File paramFile1, File paramFile2)
    throws IOException
  {
    copyFileToDirectory(paramFile1, paramFile2, true);
  }
  
  public static void copyFileToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if ((paramFile2.exists()) && (!paramFile2.isDirectory())) {
      throw new IllegalArgumentException("Destination '" + paramFile2 + "' is not a directory");
    }
    copyFile(paramFile1, new File(paramFile2, paramFile1.getName()), paramBoolean);
  }
  
  /* Error */
  private static void doCopyFile(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aload_1
    //   4: invokevirtual 45	java/io/File:exists	()Z
    //   7: ifeq +42 -> 49
    //   10: aload_1
    //   11: invokevirtual 69	java/io/File:isDirectory	()Z
    //   14: ifeq +35 -> 49
    //   17: new 28	java/io/IOException
    //   20: dup
    //   21: new 49	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   28: ldc 97
    //   30: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 71
    //   39: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 72	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: new 123	java/io/FileInputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 126	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: astore 9
    //   59: new 128	java/io/FileOutputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 129	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore 10
    //   69: aload 9
    //   71: invokevirtual 133	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   74: astore 11
    //   76: aload 10
    //   78: invokevirtual 134	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   81: astore 13
    //   83: aload 11
    //   85: invokevirtual 140	java/nio/channels/FileChannel:size	()J
    //   88: lstore 7
    //   90: lconst_0
    //   91: lstore_3
    //   92: goto +281 -> 373
    //   95: aload 13
    //   97: aload 11
    //   99: lload_3
    //   100: lload 5
    //   102: invokevirtual 144	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   105: lstore 5
    //   107: lload_3
    //   108: lload 5
    //   110: ladd
    //   111: lstore_3
    //   112: goto +261 -> 373
    //   115: lload 7
    //   117: lload_3
    //   118: lsub
    //   119: lstore 5
    //   121: goto -26 -> 95
    //   124: aload 13
    //   126: ifnull +8 -> 134
    //   129: aload 13
    //   131: invokevirtual 147	java/nio/channels/FileChannel:close	()V
    //   134: aload 10
    //   136: ifnull +8 -> 144
    //   139: aload 10
    //   141: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   144: aload 11
    //   146: ifnull +8 -> 154
    //   149: aload 11
    //   151: invokevirtual 147	java/nio/channels/FileChannel:close	()V
    //   154: aload 9
    //   156: ifnull +8 -> 164
    //   159: aload 9
    //   161: invokevirtual 149	java/io/FileInputStream:close	()V
    //   164: aload_0
    //   165: invokevirtual 152	java/io/File:length	()J
    //   168: aload_1
    //   169: invokevirtual 152	java/io/File:length	()J
    //   172: lcmp
    //   173: ifeq +97 -> 270
    //   176: new 28	java/io/IOException
    //   179: dup
    //   180: new 49	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   187: ldc 154
    //   189: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_0
    //   193: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   196: ldc 156
    //   198: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_1
    //   202: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: ldc 158
    //   207: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokespecial 72	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   216: athrow
    //   217: astore_0
    //   218: aconst_null
    //   219: astore_1
    //   220: aconst_null
    //   221: astore 9
    //   223: aconst_null
    //   224: astore 10
    //   226: aload 13
    //   228: astore 11
    //   230: aload_1
    //   231: ifnull +7 -> 238
    //   234: aload_1
    //   235: invokevirtual 147	java/nio/channels/FileChannel:close	()V
    //   238: aload 9
    //   240: ifnull +8 -> 248
    //   243: aload 9
    //   245: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   248: aload 11
    //   250: ifnull +8 -> 258
    //   253: aload 11
    //   255: invokevirtual 147	java/nio/channels/FileChannel:close	()V
    //   258: aload 10
    //   260: ifnull +8 -> 268
    //   263: aload 10
    //   265: invokevirtual 149	java/io/FileInputStream:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: iload_2
    //   271: ifeq +12 -> 283
    //   274: aload_1
    //   275: aload_0
    //   276: invokevirtual 161	java/io/File:lastModified	()J
    //   279: invokevirtual 165	java/io/File:setLastModified	(J)Z
    //   282: pop
    //   283: return
    //   284: astore_1
    //   285: goto -17 -> 268
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_1
    //   291: aconst_null
    //   292: astore 12
    //   294: aload 9
    //   296: astore 10
    //   298: aload 13
    //   300: astore 11
    //   302: aload 12
    //   304: astore 9
    //   306: goto -76 -> 230
    //   309: astore_0
    //   310: aconst_null
    //   311: astore_1
    //   312: aload 9
    //   314: astore 12
    //   316: aload 13
    //   318: astore 11
    //   320: aload 10
    //   322: astore 9
    //   324: aload 12
    //   326: astore 10
    //   328: goto -98 -> 230
    //   331: astore_0
    //   332: aload 9
    //   334: astore 12
    //   336: aconst_null
    //   337: astore_1
    //   338: aload 10
    //   340: astore 9
    //   342: aload 12
    //   344: astore 10
    //   346: goto -116 -> 230
    //   349: astore_0
    //   350: aload 9
    //   352: astore 12
    //   354: aload 13
    //   356: astore_1
    //   357: aload 10
    //   359: astore 9
    //   361: aload 12
    //   363: astore 10
    //   365: goto -135 -> 230
    //   368: astore 9
    //   370: goto -206 -> 164
    //   373: lload_3
    //   374: lload 7
    //   376: lcmp
    //   377: ifge -253 -> 124
    //   380: lload 7
    //   382: lload_3
    //   383: lsub
    //   384: ldc2_w 9
    //   387: lcmp
    //   388: ifle -273 -> 115
    //   391: ldc2_w 9
    //   394: lstore 5
    //   396: goto -301 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	paramFile1	File
    //   0	399	1	paramFile2	File
    //   0	399	2	paramBoolean	boolean
    //   91	292	3	l1	long
    //   100	1	5	localObject1	Object
    //   105	290	5	l2	long
    //   88	293	7	l3	long
    //   57	303	9	localObject2	Object
    //   368	1	9	localIOException	IOException
    //   67	297	10	localObject3	Object
    //   74	245	11	localFileChannel1	java.nio.channels.FileChannel
    //   292	70	12	localObject4	Object
    //   1	354	13	localFileChannel2	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   49	59	217	finally
    //   234	238	284	java/io/IOException
    //   243	248	284	java/io/IOException
    //   253	258	284	java/io/IOException
    //   263	268	284	java/io/IOException
    //   59	69	288	finally
    //   69	76	309	finally
    //   76	83	331	finally
    //   83	90	349	finally
    //   95	107	349	finally
    //   129	134	368	java/io/IOException
    //   139	144	368	java/io/IOException
    //   149	154	368	java/io/IOException
    //   159	164	368	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.commonio.CommonIOFileUtils
 * JD-Core Version:    0.7.0.1
 */