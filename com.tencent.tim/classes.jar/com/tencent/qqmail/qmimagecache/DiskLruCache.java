package com.tencent.qqmail.qmimagecache;

import android.util.Log;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.MThreadFactory;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DiskLruCache
  implements Closeable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  private static final int IO_BUFFER_SIZE = 8192;
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_TMP = "journal.tmp";
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  private static final String TAG = DiskLruCache.class.getSimpleName();
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Callable<Void> cleanupCallable = new DiskLruCache.1(this);
  private final File directory;
  private final ExecutorService executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new MThreadFactory("QMDiskCache", 2));
  private final File journalFile;
  private final File journalFileTmp;
  private Writer journalWriter;
  private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private final long maxSize;
  private long nextSequenceNumber = 0L;
  private int redundantOpCount;
  private long size = 0L;
  private final int valueCount;
  
  private DiskLruCache(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
  }
  
  private void checkNotClosed()
  {
    if (this.journalWriter == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  private void completeEdit(Editor paramEditor, boolean paramBoolean)
    throws IOException
  {
    int k = 0;
    for (;;)
    {
      Entry localEntry;
      int j;
      int i;
      long l1;
      try
      {
        localEntry = paramEditor.entry;
        j = k;
        if (paramBoolean)
        {
          j = k;
          if (!localEntry.readable)
          {
            i = 0;
            j = k;
            if (i < this.valueCount)
            {
              if (localEntry.getDirtyFile(i).exists()) {
                break label356;
              }
              paramEditor.abort();
              break label356;
            }
          }
        }
        if (j < this.valueCount)
        {
          paramEditor = localEntry.getDirtyFile(j);
          if (paramBoolean)
          {
            if (paramEditor.exists())
            {
              File localFile = localEntry.getCleanFile(j);
              paramEditor.renameTo(localFile);
              l1 = localEntry.lengths[j];
              long l2 = localFile.length();
              localEntry.lengths[j] = l2;
              this.size = (this.size - l1 + l2);
            }
          }
          else {
            deleteIfExists(paramEditor);
          }
        }
      }
      finally {}
      this.redundantOpCount += 1;
      Entry.access$702(localEntry, null);
      if ((localEntry.readable | paramBoolean))
      {
        Entry.access$602(localEntry, true);
        this.journalWriter.write("CLEAN " + localEntry.key + localEntry.getLengths() + '\n');
        if (paramBoolean)
        {
          l1 = this.nextSequenceNumber;
          this.nextSequenceNumber = (1L + l1);
          Entry.access$1202(localEntry, l1);
        }
      }
      for (;;)
      {
        if ((this.size > this.maxSize) || (journalRebuildRequired())) {
          this.executorService.submit(this.cleanupCallable);
        }
        return;
        this.lruEntries.remove(localEntry.key);
        this.journalWriter.write("REMOVE " + localEntry.key + '\n');
      }
      label356:
      i += 1;
      continue;
      j += 1;
    }
  }
  
  private static <T> T[] copyOfRange(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfT.length;
    if (paramInt1 > paramInt2) {
      throw new IllegalArgumentException();
    }
    if ((paramInt1 < 0) || (paramInt1 > i)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt2 -= paramInt1;
    i = Math.min(paramInt2, i - paramInt1);
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt2);
    System.arraycopy(paramArrayOfT, paramInt1, arrayOfObject, 0, i);
    return arrayOfObject;
  }
  
  public static void deleteContents(File paramFile)
    throws IOException
  {
    QMLog.log(4, TAG, "deleting contents. cache dir is :" + paramFile);
    if (!paramFile.exists()) {}
    for (;;)
    {
      return;
      if (!paramFile.isDirectory())
      {
        QMLog.log(4, TAG, "deleting contents. cache dir is not a directory");
        throw new IllegalArgumentException("not a directory: " + paramFile);
      }
      paramFile = paramFile.listFiles();
      if (paramFile == null) {
        QMLog.log(5, TAG, "deleting contents. cache dir listFiles() get null result");
      }
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = paramFile[i];
          if (localFile.isDirectory()) {
            deleteContents(localFile);
          }
          if (!localFile.delete()) {
            throw new IOException("failed to delete file: " + localFile);
          }
          i += 1;
        }
      }
    }
  }
  
  private static void deleteIfExists(File paramFile)
    throws IOException
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private Editor edit(String paramString, long paramLong)
    throws IOException
  {
    for (;;)
    {
      Editor localEditor;
      try
      {
        checkNotClosed();
        validateKey(paramString);
        Entry localEntry = (Entry)this.lruEntries.get(paramString);
        if (paramLong != -1L) {
          if (localEntry != null)
          {
            long l = localEntry.sequenceNumber;
            if (l == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localEntry == null)
        {
          localEntry = new Entry(paramString, null);
          this.lruEntries.put(paramString, localEntry);
          localEditor = new Editor(localEntry, null);
          Entry.access$702(localEntry, localEditor);
          this.journalWriter.write("DIRTY " + paramString + '\n');
          this.journalWriter.flush();
          paramString = localEditor;
          continue;
        }
        localEditor = localEntry.currentEditor;
      }
      finally {}
      if (localEditor == null) {}
    }
  }
  
  private static String inputStreamToString(InputStream paramInputStream)
    throws IOException
  {
    return readFully(new InputStreamReader(paramInputStream, UTF_8));
  }
  
  private boolean journalRebuildRequired()
  {
    return (this.redundantOpCount >= 2000) && (this.redundantOpCount >= this.lruEntries.size());
  }
  
  public static DiskLruCache open(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    int i = 1;
    if (paramLong <= 0L) {
      paramLong = 104857600L;
    }
    for (;;)
    {
      if (paramInt2 <= 0) {
        paramInt2 = i;
      }
      for (;;)
      {
        DiskLruCache localDiskLruCache = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
        if (localDiskLruCache.journalFile.exists()) {
          try
          {
            localDiskLruCache.readJournal();
            localDiskLruCache.journalWriter = new BufferedWriter(new FileWriter(localDiskLruCache.journalFile, true), 8192);
            return localDiskLruCache;
          }
          catch (IOException localIOException)
          {
            localDiskLruCache.delete();
          }
        }
        paramFile.mkdirs();
        paramFile = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
        paramFile.rebuildJournal();
        return paramFile;
      }
    }
  }
  
  private void processJournal()
    throws IOException
  {
    deleteIfExists(this.journalFileTmp);
    Iterator localIterator = this.lruEntries.values().iterator();
    while (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      int i;
      if (localEntry.currentEditor == null)
      {
        i = 0;
        while (i < this.valueCount)
        {
          this.size += localEntry.lengths[i];
          i += 1;
        }
      }
      else
      {
        Entry.access$702(localEntry, null);
        i = 0;
        while (i < this.valueCount)
        {
          deleteIfExists(localEntry.getCleanFile(i));
          deleteIfExists(localEntry.getDirtyFile(i));
          i += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  public static String readAsciiLine(InputStream paramInputStream)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        throw new EOFException();
      }
      if (i == 10)
      {
        i = localStringBuilder.length();
        if ((i > 0) && (localStringBuilder.charAt(i - 1) == '\r')) {
          localStringBuilder.setLength(i - 1);
        }
        return localStringBuilder.toString();
      }
      localStringBuilder.append((char)i);
    }
  }
  
  public static String readFully(Reader paramReader)
    throws IOException
  {
    try
    {
      StringWriter localStringWriter = new StringWriter();
      char[] arrayOfChar = new char[1024];
      for (;;)
      {
        int i = paramReader.read(arrayOfChar);
        if (i == -1) {
          break;
        }
        localStringWriter.write(arrayOfChar, 0, i);
      }
      str = localObject.toString();
    }
    finally
    {
      paramReader.close();
    }
    String str;
    paramReader.close();
    return str;
  }
  
  /* Error */
  private void readJournal()
    throws IOException
  {
    // Byte code:
    //   0: new 505	java/io/BufferedInputStream
    //   3: dup
    //   4: new 507	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 149	com/tencent/qqmail/qmimagecache/DiskLruCache:journalFile	Ljava/io/File;
    //   12: invokespecial 509	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: sipush 8192
    //   18: invokespecial 512	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokestatic 514	com/tencent/qqmail/qmimagecache/DiskLruCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   26: astore_2
    //   27: aload_1
    //   28: invokestatic 514	com/tencent/qqmail/qmimagecache/DiskLruCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   31: astore_3
    //   32: aload_1
    //   33: invokestatic 514	com/tencent/qqmail/qmimagecache/DiskLruCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_1
    //   39: invokestatic 514	com/tencent/qqmail/qmimagecache/DiskLruCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   42: astore 5
    //   44: aload_1
    //   45: invokestatic 514	com/tencent/qqmail/qmimagecache/DiskLruCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   48: astore 6
    //   50: ldc 39
    //   52: aload_2
    //   53: invokevirtual 520	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +53 -> 109
    //   59: ldc 49
    //   61: aload_3
    //   62: invokevirtual 520	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifeq +44 -> 109
    //   68: aload_0
    //   69: getfield 142	com/tencent/qqmail/qmimagecache/DiskLruCache:appVersion	I
    //   72: invokestatic 525	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   75: aload 4
    //   77: invokevirtual 520	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +29 -> 109
    //   83: aload_0
    //   84: getfield 153	com/tencent/qqmail/qmimagecache/DiskLruCache:valueCount	I
    //   87: invokestatic 525	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   90: aload 5
    //   92: invokevirtual 520	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifeq +14 -> 109
    //   98: ldc_w 527
    //   101: aload 6
    //   103: invokevirtual 520	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifne +76 -> 182
    //   109: new 162	java/io/IOException
    //   112: dup
    //   113: new 267	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 529
    //   123: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_2
    //   127: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 531
    //   133: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_3
    //   137: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 531
    //   143: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 5
    //   148: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 531
    //   154: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 6
    //   159: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 533
    //   165: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokespecial 379	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   174: athrow
    //   175: astore_2
    //   176: aload_1
    //   177: invokestatic 535	com/tencent/qqmail/qmimagecache/DiskLruCache:closeQuietly	(Ljava/io/Closeable;)V
    //   180: aload_2
    //   181: athrow
    //   182: aload_0
    //   183: aload_1
    //   184: invokestatic 514	com/tencent/qqmail/qmimagecache/DiskLruCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   187: invokespecial 538	com/tencent/qqmail/qmimagecache/DiskLruCache:readJournalLine	(Ljava/lang/String;)V
    //   190: goto -8 -> 182
    //   193: astore_2
    //   194: aload_1
    //   195: invokestatic 535	com/tencent/qqmail/qmimagecache/DiskLruCache:closeQuietly	(Ljava/io/Closeable;)V
    //   198: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	DiskLruCache
    //   21	174	1	localBufferedInputStream	java.io.BufferedInputStream
    //   26	101	2	str1	String
    //   175	6	2	localObject	Object
    //   193	1	2	localEOFException	EOFException
    //   31	106	3	str2	String
    //   36	40	4	str3	String
    //   42	105	5	str4	String
    //   48	110	6	str5	String
    // Exception table:
    //   from	to	target	type
    //   22	109	175	finally
    //   109	175	175	finally
    //   182	190	175	finally
    //   182	190	193	java/io/EOFException
  }
  
  private void readJournalLine(String paramString)
    throws IOException
  {
    String[] arrayOfString = paramString.split(" ");
    if (arrayOfString.length < 2) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    String str = arrayOfString[1];
    if ((arrayOfString[0].equals("REMOVE")) && (arrayOfString.length == 2))
    {
      this.lruEntries.remove(str);
      return;
    }
    Entry localEntry = (Entry)this.lruEntries.get(str);
    if (localEntry == null)
    {
      localEntry = new Entry(str, null);
      this.lruEntries.put(str, localEntry);
    }
    for (;;)
    {
      if ((arrayOfString[0].equals("CLEAN")) && (arrayOfString.length == this.valueCount + 2))
      {
        Entry.access$602(localEntry, true);
        Entry.access$702(localEntry, null);
        localEntry.setLengths((String[])copyOfRange(arrayOfString, 2, arrayOfString.length));
        return;
      }
      if ((arrayOfString[0].equals("DIRTY")) && (arrayOfString.length == 2))
      {
        Entry.access$702(localEntry, new Editor(localEntry, null));
        return;
      }
      if ((arrayOfString[0].equals("READ")) && (arrayOfString.length == 2)) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private void rebuildJournal()
    throws IOException
  {
    for (;;)
    {
      try
      {
        if (this.journalWriter != null) {
          this.journalWriter.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(this.journalFileTmp), 8192);
        localBufferedWriter.write("libcore.io.DiskLruCache");
        localBufferedWriter.write("\n");
        localBufferedWriter.write("1");
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.appVersion));
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.valueCount));
        localBufferedWriter.write("\n");
        localBufferedWriter.write("\n");
        Iterator localIterator = this.lruEntries.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Entry localEntry = (Entry)localIterator.next();
        if (localEntry.currentEditor != null) {
          localBufferedWriter.write("DIRTY " + localEntry.key + '\n');
        } else {
          localObject.write("CLEAN " + localEntry.key + localEntry.getLengths() + '\n');
        }
      }
      finally {}
    }
    localObject.close();
    this.journalFileTmp.renameTo(this.journalFile);
    this.journalWriter = new BufferedWriter(new FileWriter(this.journalFile, true), 8192);
  }
  
  private void trimToSize()
    throws IOException
  {
    while (this.size > this.maxSize)
    {
      QMLog.log(4, TAG, "dir:" + getDirectory() + "maxSize:" + this.maxSize + ",size:" + this.size);
      remove((String)((Map.Entry)this.lruEntries.entrySet().iterator().next()).getKey());
    }
  }
  
  private void validateKey(String paramString)
  {
    if ((paramString.contains("\n")) || (paramString.contains("\r"))) {
      throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + paramString + "\"");
    }
  }
  
  public void Empty()
  {
    if (this.journalWriter != null) {
      this.journalWriter = null;
    }
  }
  
  public void close()
    throws IOException
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.journalWriter;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.lruEntries.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          Entry localEntry = (Entry)((Iterator)localObject1).next();
          if (localEntry.currentEditor == null) {
            continue;
          }
          localEntry.currentEditor.abort();
          continue;
        }
        trimToSize();
      }
      finally {}
      this.journalWriter.close();
      this.journalWriter = null;
    }
  }
  
  public void delete()
    throws IOException
  {
    close();
    deleteContents(this.directory);
  }
  
  public Editor edit(String paramString)
    throws IOException
  {
    return edit(paramString, -1L);
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      checkNotClosed();
      trimToSize();
      this.journalWriter.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public Snapshot get(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokespecial 382	com/tencent/qqmail/qmimagecache/DiskLruCache:checkNotClosed	()V
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 385	com/tencent/qqmail/qmimagecache/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 104	com/tencent/qqmail/qmimagecache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   18: aload_1
    //   19: invokevirtual 388	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 14	com/tencent/qqmail/qmimagecache/DiskLruCache$Entry
    //   25: astore 5
    //   27: aload 5
    //   29: ifnonnull +10 -> 39
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: areturn
    //   39: aload 4
    //   41: astore_3
    //   42: aload 5
    //   44: invokestatic 228	com/tencent/qqmail/qmimagecache/DiskLruCache$Entry:access$600	(Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Entry;)Z
    //   47: ifeq -12 -> 35
    //   50: aload_0
    //   51: getfield 153	com/tencent/qqmail/qmimagecache/DiskLruCache:valueCount	I
    //   54: anewarray 475	java/io/InputStream
    //   57: astore_3
    //   58: iconst_0
    //   59: istore_2
    //   60: iload_2
    //   61: aload_0
    //   62: getfield 153	com/tencent/qqmail/qmimagecache/DiskLruCache:valueCount	I
    //   65: if_icmpge +26 -> 91
    //   68: aload_3
    //   69: iload_2
    //   70: new 507	java/io/FileInputStream
    //   73: dup
    //   74: aload 5
    //   76: iload_2
    //   77: invokevirtual 241	com/tencent/qqmail/qmimagecache/DiskLruCache$Entry:getCleanFile	(I)Ljava/io/File;
    //   80: invokespecial 509	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: aastore
    //   84: iload_2
    //   85: iconst_1
    //   86: iadd
    //   87: istore_2
    //   88: goto -28 -> 60
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 203	com/tencent/qqmail/qmimagecache/DiskLruCache:redundantOpCount	I
    //   96: iconst_1
    //   97: iadd
    //   98: putfield 203	com/tencent/qqmail/qmimagecache/DiskLruCache:redundantOpCount	I
    //   101: aload_0
    //   102: getfield 159	com/tencent/qqmail/qmimagecache/DiskLruCache:journalWriter	Ljava/io/Writer;
    //   105: new 267	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 610
    //   115: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: bipush 10
    //   124: invokevirtual 284	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   127: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokevirtual 613	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   133: pop
    //   134: aload_0
    //   135: invokespecial 191	com/tencent/qqmail/qmimagecache/DiskLruCache:journalRebuildRequired	()Z
    //   138: ifeq +17 -> 155
    //   141: aload_0
    //   142: getfield 131	com/tencent/qqmail/qmimagecache/DiskLruCache:executorService	Ljava/util/concurrent/ExecutorService;
    //   145: aload_0
    //   146: getfield 138	com/tencent/qqmail/qmimagecache/DiskLruCache:cleanupCallable	Ljava/util/concurrent/Callable;
    //   149: invokeinterface 302 2 0
    //   154: pop
    //   155: new 17	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot
    //   158: dup
    //   159: aload_0
    //   160: aload_1
    //   161: aload 5
    //   163: invokestatic 392	com/tencent/qqmail/qmimagecache/DiskLruCache$Entry:access$1200	(Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Entry;)J
    //   166: aload_3
    //   167: aconst_null
    //   168: invokespecial 616	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:<init>	(Lcom/tencent/qqmail/qmimagecache/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;Lcom/tencent/qqmail/qmimagecache/DiskLruCache$1;)V
    //   171: astore_3
    //   172: goto -137 -> 35
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: aload 4
    //   183: astore_3
    //   184: goto -149 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	DiskLruCache
    //   0	187	1	paramString	String
    //   59	29	2	i	int
    //   34	150	3	localObject1	Object
    //   1	181	4	localObject2	Object
    //   25	137	5	localEntry	Entry
    // Exception table:
    //   from	to	target	type
    //   5	27	175	finally
    //   42	58	175	finally
    //   60	84	175	finally
    //   91	155	175	finally
    //   155	172	175	finally
    //   60	84	180	java/io/FileNotFoundException
  }
  
  public File getDirectory()
  {
    return this.directory;
  }
  
  public String getFilePath(String paramString)
  {
    checkNotClosed();
    validateKey(paramString);
    paramString = (Entry)this.lruEntries.get(paramString);
    if ((paramString == null) || (!paramString.readable)) {
      return "";
    }
    if (paramString.getCleanFile(0).exists()) {
      return paramString.getCleanFile(0).getAbsolutePath();
    }
    return "";
  }
  
  public File getReadableFile(String paramString)
  {
    for (;;)
    {
      try
      {
        checkNotClosed();
        validateKey(paramString);
        Entry localEntry = (Entry)this.lruEntries.get(paramString);
        if (localEntry == null)
        {
          paramString = null;
          return paramString;
        }
        if (!localEntry.readable)
        {
          paramString = null;
          continue;
        }
        File localFile = localEntry.getCleanFile(0);
        boolean bool = localFile.exists();
        if (bool) {
          try
          {
            this.journalWriter.append("READ " + paramString + '\n');
            this.redundantOpCount += 1;
            if (journalRebuildRequired()) {
              this.executorService.submit(this.cleanupCallable);
            }
            paramString = localFile;
          }
          catch (IOException localIOException2)
          {
            QMLog.log(6, TAG, "getReadableFile R: " + localIOException2.getMessage() + ", " + paramString);
            continue;
          }
        }
        this.lruEntries.remove(paramString);
      }
      finally {}
      try
      {
        this.journalWriter.write("REMOVE " + localIOException2.key + '\n');
        paramString = null;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          QMLog.log(6, TAG, "getReadableFile W: " + localIOException1.getMessage() + ", " + paramString);
        }
      }
    }
  }
  
  public boolean isClosed()
  {
    return this.journalWriter == null;
  }
  
  public boolean isExist(String paramString)
  {
    checkNotClosed();
    validateKey(paramString);
    paramString = (Entry)this.lruEntries.get(paramString);
    if (paramString == null) {
      return false;
    }
    if (!paramString.readable) {
      return false;
    }
    return paramString.getCleanFile(0).exists();
  }
  
  public long maxSize()
  {
    return this.maxSize;
  }
  
  public boolean remove(String paramString)
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      try
      {
        checkNotClosed();
        validateKey(paramString);
        Entry localEntry = (Entry)this.lruEntries.get(paramString);
        Object localObject;
        if (localEntry != null)
        {
          localObject = localEntry.currentEditor;
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          this.size -= localEntry.lengths[i];
          localEntry.lengths[i] = 0L;
          i += 1;
        }
        if (i < this.valueCount)
        {
          localObject = localEntry.getCleanFile(i);
          if (((File)localObject).delete()) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.redundantOpCount += 1;
      this.journalWriter.append("REMOVE " + paramString + '\n');
      this.lruEntries.remove(paramString);
      if (journalRebuildRequired()) {
        this.executorService.submit(this.cleanupCallable);
      }
      boolean bool = true;
    }
  }
  
  public long size()
  {
    try
    {
      long l = this.size;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final class Editor
  {
    private final DiskLruCache.Entry entry;
    private boolean hasErrors;
    
    private Editor(DiskLruCache.Entry paramEntry)
    {
      this.entry = paramEntry;
    }
    
    public void abort()
      throws IOException
    {
      DiskLruCache.this.completeEdit(this, false);
    }
    
    public void commit()
      throws IOException
    {
      if (this.hasErrors)
      {
        DiskLruCache.this.completeEdit(this, false);
        DiskLruCache.this.remove(DiskLruCache.Entry.access$1100(this.entry));
        return;
      }
      DiskLruCache.this.completeEdit(this, true);
    }
    
    public File getFile(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean) {
        return this.entry.getDirtyFile(paramInt);
      }
      return this.entry.getCleanFile(paramInt);
    }
    
    public String getString(int paramInt)
      throws IOException
    {
      InputStream localInputStream = newInputStream(paramInt);
      if (localInputStream != null) {
        return DiskLruCache.inputStreamToString(localInputStream);
      }
      return null;
    }
    
    public InputStream newInputStream(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (!DiskLruCache.Entry.access$600(this.entry)) {
          return null;
        }
        FileInputStream localFileInputStream = new FileInputStream(this.entry.getCleanFile(paramInt));
        return localFileInputStream;
      }
    }
    
    public OutputStream newOutputStream(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        Object localObject1 = this.entry.getDirtyFile(paramInt);
        Log.v("ImageCacheTest", "file: " + ((File)localObject1).getAbsolutePath());
        localObject1 = new FaultHidingOutputStream(new FileOutputStream((File)localObject1), null);
        return localObject1;
      }
    }
    
    public OutputStream newOutputStream(int paramInt, boolean paramBoolean)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        Object localObject1 = this.entry.getDirtyFile(paramInt);
        File localFile = this.entry.getCleanFile(paramInt);
        if ((paramBoolean) && (!((File)localObject1).exists()) && (localFile.exists())) {
          localFile.renameTo((File)localObject1);
        }
        localObject1 = new FaultHidingOutputStream(new FileOutputStream((File)localObject1, paramBoolean), null);
        return localObject1;
      }
    }
    
    public void set(int paramInt, String paramString)
      throws IOException
    {
      try
      {
        OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(newOutputStream(paramInt), DiskLruCache.UTF_8);
        DiskLruCache.closeQuietly(localOutputStreamWriter);
      }
      finally
      {
        try
        {
          localOutputStreamWriter.write(paramString);
          DiskLruCache.closeQuietly(localOutputStreamWriter);
          return;
        }
        finally {}
        paramString = finally;
        localOutputStreamWriter = null;
      }
      throw paramString;
    }
    
    class FaultHidingOutputStream
      extends FilterOutputStream
    {
      private FaultHidingOutputStream(OutputStream paramOutputStream)
      {
        super();
      }
      
      public void close()
      {
        try
        {
          this.out.close();
          return;
        }
        catch (IOException localIOException)
        {
          DiskLruCache.Editor.access$2002(DiskLruCache.Editor.this, true);
        }
      }
      
      public void flush()
      {
        try
        {
          this.out.flush();
          return;
        }
        catch (IOException localIOException)
        {
          DiskLruCache.Editor.access$2002(DiskLruCache.Editor.this, true);
        }
      }
      
      public void write(int paramInt)
      {
        try
        {
          this.out.write(paramInt);
          return;
        }
        catch (IOException localIOException)
        {
          DiskLruCache.Editor.access$2002(DiskLruCache.Editor.this, true);
        }
      }
      
      public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        try
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        catch (IOException paramArrayOfByte)
        {
          DiskLruCache.Editor.access$2002(DiskLruCache.Editor.this, true);
        }
      }
    }
  }
  
  final class Entry
  {
    private DiskLruCache.Editor currentEditor = null;
    private final String key;
    private final long[] lengths;
    private boolean readable;
    private long sequenceNumber;
    
    private Entry(String paramString)
    {
      this.key = paramString;
      this.lengths = new long[DiskLruCache.this.valueCount];
    }
    
    private IOException invalidLengths(String[] paramArrayOfString)
      throws IOException
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }
    
    private void setLengths(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length != DiskLruCache.this.valueCount) {
        throw invalidLengths(paramArrayOfString);
      }
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.lengths[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw invalidLengths(paramArrayOfString);
      }
    }
    
    public File getCleanFile(int paramInt)
    {
      return new File(DiskLruCache.this.directory, this.key);
    }
    
    public File getDirtyFile(int paramInt)
    {
      return new File(DiskLruCache.this.directory, this.key + ".tmp");
    }
    
    public String getLengths()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      long[] arrayOfLong = this.lengths;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        localStringBuilder.append(' ').append(l);
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
  
  public final class Snapshot
    implements Closeable
  {
    private final InputStream[] ins;
    private final String key;
    private final long sequenceNumber;
    
    private Snapshot(String paramString, long paramLong, InputStream[] paramArrayOfInputStream)
    {
      this.key = paramString;
      this.sequenceNumber = paramLong;
      this.ins = paramArrayOfInputStream;
    }
    
    public void close()
    {
      InputStream[] arrayOfInputStream = this.ins;
      int j = arrayOfInputStream.length;
      int i = 0;
      while (i < j)
      {
        DiskLruCache.closeQuietly(arrayOfInputStream[i]);
        i += 1;
      }
    }
    
    public DiskLruCache.Editor edit()
      throws IOException
    {
      return DiskLruCache.this.edit(this.key, this.sequenceNumber);
    }
    
    public InputStream getInputStream(int paramInt)
    {
      return this.ins[paramInt];
    }
    
    public String getString(int paramInt)
      throws IOException
    {
      return DiskLruCache.inputStreamToString(getInputStream(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.DiskLruCache
 * JD-Core Version:    0.7.0.1
 */