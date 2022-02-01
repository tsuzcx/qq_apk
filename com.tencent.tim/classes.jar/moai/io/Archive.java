package moai.io;

import android.content.Context;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

public class Archive
{
  public static final String TAG = Archive.class.getSimpleName();
  
  public static void ArchiveFiles(Context paramContext, String paramString, long paramLong, List<File> paramList, ArchiveListener paramArchiveListener)
  {
    paramContext = new ArrayList();
    for (;;)
    {
      ArchiveResult localArchiveResult;
      int i;
      try
      {
        ZipOutputStream localZipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramString)));
        localArchiveResult = new ArchiveResult();
        localArchiveResult.total = paramList.size();
        i = 0;
        if (i < paramList.size())
        {
          boolean bool = zipFile(localZipOutputStream, (File)paramList.get(i), paramLong);
          if (!bool)
          {
            Log.e(TAG, "failed to zip file");
            if (paramArchiveListener == null) {
              break label226;
            }
            localArchiveResult.upadte(bool, (File)paramList.get(i), i);
            paramArchiveListener.onArchiveFile(localArchiveResult);
            break label226;
          }
          paramContext.add(((File)paramList.get(i)).getAbsolutePath());
          continue;
        }
        localZipOutputStream.close();
      }
      catch (Exception paramContext)
      {
        Log.e(TAG, "ArchiveFiles" + paramContext.getMessage());
        return;
      }
      if (paramArchiveListener != null)
      {
        localArchiveResult.succfiles = paramContext;
        localArchiveResult.zippath = paramString;
        paramArchiveListener.onArchiveComplete(localArchiveResult);
        return;
        label226:
        i += 1;
      }
    }
  }
  
  /* Error */
  private static boolean zipFile(ZipOutputStream paramZipOutputStream, File paramFile, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 125	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: sipush 8192
    //   16: newarray byte
    //   18: astore 7
    //   20: new 127	java/io/FileInputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore 6
    //   30: aload 6
    //   32: astore 5
    //   34: aload_0
    //   35: new 132	java/util/zip/ZipEntry
    //   38: dup
    //   39: aload_1
    //   40: invokevirtual 135	java/io/File:getName	()Ljava/lang/String;
    //   43: invokespecial 136	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 140	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   49: aload 6
    //   51: astore 5
    //   53: aload 6
    //   55: lconst_0
    //   56: aload_1
    //   57: invokevirtual 144	java/io/File:length	()J
    //   60: lload_2
    //   61: lsub
    //   62: invokestatic 150	java/lang/Math:max	(JJ)J
    //   65: invokevirtual 154	java/io/FileInputStream:skip	(J)J
    //   68: pop2
    //   69: aload 6
    //   71: astore 5
    //   73: aload 7
    //   75: iconst_0
    //   76: invokestatic 160	java/util/Arrays:fill	([BB)V
    //   79: aload 6
    //   81: astore 5
    //   83: aload 6
    //   85: aload 7
    //   87: invokevirtual 164	java/io/FileInputStream:read	([B)I
    //   90: istore 4
    //   92: iload 4
    //   94: ifle +95 -> 189
    //   97: aload 6
    //   99: astore 5
    //   101: aload_0
    //   102: aload 7
    //   104: iconst_0
    //   105: iload 4
    //   107: invokevirtual 168	java/util/zip/ZipOutputStream:write	([BII)V
    //   110: goto -31 -> 79
    //   113: astore 7
    //   115: aload 6
    //   117: astore 5
    //   119: getstatic 22	moai/io/Archive:TAG	Ljava/lang/String;
    //   122: new 92	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   129: ldc 170
    //   131: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_1
    //   135: invokevirtual 135	java/io/File:getName	()Ljava/lang/String;
    //   138: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 172
    //   143: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 7
    //   148: invokevirtual 173	java/io/IOException:getMessage	()Ljava/lang/String;
    //   151: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 75	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   160: pop
    //   161: aload 6
    //   163: ifnull +8 -> 171
    //   166: aload 6
    //   168: invokevirtual 174	java/io/FileInputStream:close	()V
    //   171: aload_0
    //   172: invokevirtual 177	java/util/zip/ZipOutputStream:closeEntry	()V
    //   175: iconst_0
    //   176: ireturn
    //   177: astore_0
    //   178: getstatic 22	moai/io/Archive:TAG	Ljava/lang/String;
    //   181: ldc 179
    //   183: invokestatic 75	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   186: pop
    //   187: iconst_0
    //   188: ireturn
    //   189: aload 6
    //   191: ifnull +8 -> 199
    //   194: aload 6
    //   196: invokevirtual 174	java/io/FileInputStream:close	()V
    //   199: aload_0
    //   200: invokevirtual 177	java/util/zip/ZipOutputStream:closeEntry	()V
    //   203: iconst_1
    //   204: ireturn
    //   205: astore_0
    //   206: getstatic 22	moai/io/Archive:TAG	Ljava/lang/String;
    //   209: ldc 179
    //   211: invokestatic 75	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   214: pop
    //   215: iconst_1
    //   216: ireturn
    //   217: astore_1
    //   218: aconst_null
    //   219: astore 5
    //   221: aload 5
    //   223: ifnull +8 -> 231
    //   226: aload 5
    //   228: invokevirtual 174	java/io/FileInputStream:close	()V
    //   231: aload_0
    //   232: invokevirtual 177	java/util/zip/ZipOutputStream:closeEntry	()V
    //   235: aload_1
    //   236: athrow
    //   237: astore_0
    //   238: getstatic 22	moai/io/Archive:TAG	Ljava/lang/String;
    //   241: ldc 179
    //   243: invokestatic 75	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   246: pop
    //   247: goto -12 -> 235
    //   250: astore_1
    //   251: goto -30 -> 221
    //   254: astore 7
    //   256: aconst_null
    //   257: astore 6
    //   259: goto -144 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramZipOutputStream	ZipOutputStream
    //   0	262	1	paramFile	File
    //   0	262	2	paramLong	long
    //   90	16	4	i	int
    //   32	195	5	localFileInputStream1	java.io.FileInputStream
    //   28	230	6	localFileInputStream2	java.io.FileInputStream
    //   18	85	7	arrayOfByte	byte[]
    //   113	34	7	localIOException1	java.io.IOException
    //   254	1	7	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   34	49	113	java/io/IOException
    //   53	69	113	java/io/IOException
    //   73	79	113	java/io/IOException
    //   83	92	113	java/io/IOException
    //   101	110	113	java/io/IOException
    //   166	171	177	java/lang/Exception
    //   171	175	177	java/lang/Exception
    //   194	199	205	java/lang/Exception
    //   199	203	205	java/lang/Exception
    //   20	30	217	finally
    //   226	231	237	java/lang/Exception
    //   231	235	237	java/lang/Exception
    //   34	49	250	finally
    //   53	69	250	finally
    //   73	79	250	finally
    //   83	92	250	finally
    //   101	110	250	finally
    //   119	161	250	finally
    //   20	30	254	java/io/IOException
  }
  
  public static abstract interface ArchiveListener
  {
    public abstract void onArchiveComplete(Archive.ArchiveResult paramArchiveResult);
    
    public abstract void onArchiveFile(Archive.ArchiveResult paramArchiveResult);
  }
  
  public static class ArchiveResult
  {
    public File file;
    public int index;
    public boolean ret;
    public ArrayList<String> succfiles;
    public int total;
    public String zippath;
    
    public void upadte(boolean paramBoolean, File paramFile, int paramInt)
    {
      this.ret = paramBoolean;
      this.file = paramFile;
      this.index = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.Archive
 * JD-Core Version:    0.7.0.1
 */