package com.jakewharton.disklrucache;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DiskLruCache
  implements Closeable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream()
  {
    public void write(int paramAnonymousInt)
      throws IOException
    {}
  };
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Callable<Void> cleanupCallable = new Callable()
  {
    public Void call()
      throws Exception
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.this.journalWriter == null) {
          return null;
        }
        DiskLruCache.this.trimToSize();
        if (DiskLruCache.this.journalRebuildRequired())
        {
          DiskLruCache.this.rebuildJournal();
          DiskLruCache.access$402(DiskLruCache.this, 0);
        }
        return null;
      }
    }
  };
  private final File directory;
  final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  private Writer journalWriter;
  private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private long maxSize;
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
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
  }
  
  private void checkNotClosed()
  {
    if (this.journalWriter == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void completeEdit(Editor paramEditor, boolean paramBoolean)
    throws IOException
  {
    Entry localEntry;
    try
    {
      localEntry = paramEditor.entry;
      if (localEntry.currentEditor != paramEditor) {
        throw new IllegalStateException();
      }
    }
    finally {}
    if ((paramBoolean) && (!localEntry.readable))
    {
      i = 0;
      while (i < this.valueCount)
      {
        if (paramEditor.written[i] == 0)
        {
          paramEditor.abort();
          throw new IllegalStateException("Newly created entry didn't create value for index " + i);
        }
        if (!localEntry.getDirtyFile(i).exists())
        {
          paramEditor.abort();
          return;
        }
        i += 1;
      }
    }
    int i = 0;
    for (;;)
    {
      long l1;
      if (i < this.valueCount)
      {
        paramEditor = localEntry.getDirtyFile(i);
        if (paramBoolean)
        {
          if (paramEditor.exists())
          {
            File localFile = localEntry.getCleanFile(i);
            paramEditor.renameTo(localFile);
            l1 = localEntry.lengths[i];
            long l2 = localFile.length();
            localEntry.lengths[i] = l2;
            this.size = (this.size - l1 + l2);
          }
        }
        else {
          deleteIfExists(paramEditor);
        }
      }
      else
      {
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
          this.journalWriter.flush();
          if ((this.size <= this.maxSize) && (!journalRebuildRequired())) {
            break;
          }
          this.executorService.submit(this.cleanupCallable);
          break;
          this.lruEntries.remove(localEntry.key);
          this.journalWriter.write("REMOVE " + localEntry.key + '\n');
        }
      }
      i += 1;
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
    Editor localEditor1 = null;
    for (;;)
    {
      Entry localEntry;
      try
      {
        checkNotClosed();
        validateKey(paramString);
        localEntry = (Entry)this.lruEntries.get(paramString);
        if (paramLong != -1L)
        {
          localObject = localEditor1;
          if (localEntry != null)
          {
            long l = localEntry.sequenceNumber;
            if (l != paramLong) {
              localObject = localEditor1;
            }
          }
          else
          {
            return localObject;
          }
        }
        if (localEntry == null)
        {
          localObject = new Entry(paramString, null);
          this.lruEntries.put(paramString, localObject);
          localEditor1 = new Editor((Entry)localObject, null);
          Entry.access$702((Entry)localObject, localEditor1);
          this.journalWriter.write("DIRTY " + paramString + '\n');
          this.journalWriter.flush();
          localObject = localEditor1;
          continue;
        }
        localEditor2 = localEntry.currentEditor;
      }
      finally {}
      Editor localEditor2;
      Object localObject = localEntry;
      if (localEditor2 != null) {
        localObject = localEditor1;
      }
    }
  }
  
  private static String inputStreamToString(InputStream paramInputStream)
    throws IOException
  {
    return Util.readFully(new InputStreamReader(paramInputStream, Util.UTF_8));
  }
  
  private boolean journalRebuildRequired()
  {
    return (this.redundantOpCount >= 2000) && (this.redundantOpCount >= this.lruEntries.size());
  }
  
  public static DiskLruCache open(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    Object localObject = new File(paramFile, "journal.bkp");
    File localFile;
    if (((File)localObject).exists())
    {
      localFile = new File(paramFile, "journal");
      if (!localFile.exists()) {
        break label150;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      localObject = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
      if (!((DiskLruCache)localObject).journalFile.exists()) {
        break label214;
      }
      try
      {
        ((DiskLruCache)localObject).readJournal();
        ((DiskLruCache)localObject).processJournal();
        ((DiskLruCache)localObject).journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((DiskLruCache)localObject).journalFile, true), Util.US_ASCII));
        return localObject;
      }
      catch (IOException localIOException)
      {
        label150:
        System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
        ((DiskLruCache)localObject).delete();
      }
      renameTo((File)localObject, localFile, false);
    }
    label214:
    paramFile.mkdirs();
    paramFile = new DiskLruCache(paramFile, paramInt1, paramInt2, paramLong);
    paramFile.rebuildJournal();
    return paramFile;
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
  
  /* Error */
  private void readJournal()
    throws IOException
  {
    // Byte code:
    //   0: new 447	com/jakewharton/disklrucache/StrictLineReader
    //   3: dup
    //   4: new 449	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 142	com/jakewharton/disklrucache/DiskLruCache:journalFile	Ljava/io/File;
    //   12: invokespecial 451	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: getstatic 385	com/jakewharton/disklrucache/Util:US_ASCII	Ljava/nio/charset/Charset;
    //   18: invokespecial 452	com/jakewharton/disklrucache/StrictLineReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 455	com/jakewharton/disklrucache/StrictLineReader:readLine	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_2
    //   28: invokevirtual 455	com/jakewharton/disklrucache/StrictLineReader:readLine	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_2
    //   34: invokevirtual 455	com/jakewharton/disklrucache/StrictLineReader:readLine	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_2
    //   40: invokevirtual 455	com/jakewharton/disklrucache/StrictLineReader:readLine	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload_2
    //   46: invokevirtual 455	com/jakewharton/disklrucache/StrictLineReader:readLine	()Ljava/lang/String;
    //   49: astore 7
    //   51: ldc 45
    //   53: aload_3
    //   54: invokevirtual 461	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +54 -> 111
    //   60: ldc 54
    //   62: aload 4
    //   64: invokevirtual 461	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +44 -> 111
    //   70: aload_0
    //   71: getfield 135	com/jakewharton/disklrucache/DiskLruCache:appVersion	I
    //   74: invokestatic 466	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   77: aload 5
    //   79: invokevirtual 461	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +29 -> 111
    //   85: aload_0
    //   86: getfield 148	com/jakewharton/disklrucache/DiskLruCache:valueCount	I
    //   89: invokestatic 466	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   92: aload 6
    //   94: invokevirtual 461	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +14 -> 111
    //   100: ldc_w 468
    //   103: aload 7
    //   105: invokevirtual 461	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +77 -> 185
    //   111: new 157	java/io/IOException
    //   114: dup
    //   115: new 228	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 470
    //   125: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_3
    //   129: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 472
    //   135: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 4
    //   140: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 472
    //   146: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 6
    //   151: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 472
    //   157: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 7
    //   162: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 474
    //   168: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 475	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   177: athrow
    //   178: astore_3
    //   179: aload_2
    //   180: invokestatic 479	com/jakewharton/disklrucache/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   183: aload_3
    //   184: athrow
    //   185: iconst_0
    //   186: istore_1
    //   187: aload_0
    //   188: aload_2
    //   189: invokevirtual 455	com/jakewharton/disklrucache/StrictLineReader:readLine	()Ljava/lang/String;
    //   192: invokespecial 482	com/jakewharton/disklrucache/DiskLruCache:readJournalLine	(Ljava/lang/String;)V
    //   195: iload_1
    //   196: iconst_1
    //   197: iadd
    //   198: istore_1
    //   199: goto -12 -> 187
    //   202: astore_3
    //   203: aload_0
    //   204: iload_1
    //   205: aload_0
    //   206: getfield 106	com/jakewharton/disklrucache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   209: invokevirtual 356	java/util/LinkedHashMap:size	()I
    //   212: isub
    //   213: putfield 198	com/jakewharton/disklrucache/DiskLruCache:redundantOpCount	I
    //   216: aload_2
    //   217: invokestatic 479	com/jakewharton/disklrucache/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   220: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	DiskLruCache
    //   186	27	1	i	int
    //   21	196	2	localStrictLineReader	StrictLineReader
    //   26	103	3	str1	String
    //   178	6	3	localObject	Object
    //   202	1	3	localEOFException	java.io.EOFException
    //   31	108	4	str2	String
    //   37	41	5	str3	String
    //   43	107	6	str4	String
    //   49	112	7	str5	String
    // Exception table:
    //   from	to	target	type
    //   22	111	178	finally
    //   111	178	178	finally
    //   187	195	178	finally
    //   203	216	178	finally
    //   187	195	202	java/io/EOFException
  }
  
  private void readJournalLine(String paramString)
    throws IOException
  {
    int i = paramString.indexOf(' ');
    if (i == -1) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    int j = i + 1;
    int k = paramString.indexOf(' ', j);
    Object localObject2;
    Object localObject1;
    if (k == -1)
    {
      localObject2 = paramString.substring(j);
      localObject1 = localObject2;
      if (i != "REMOVE".length()) {
        break label112;
      }
      localObject1 = localObject2;
      if (!paramString.startsWith("REMOVE")) {
        break label112;
      }
      this.lruEntries.remove(localObject2);
    }
    label112:
    do
    {
      return;
      localObject1 = paramString.substring(j, k);
      Entry localEntry = (Entry)this.lruEntries.get(localObject1);
      localObject2 = localEntry;
      if (localEntry == null)
      {
        localObject2 = new Entry((String)localObject1, null);
        this.lruEntries.put(localObject1, localObject2);
      }
      if ((k != -1) && (i == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        Entry.access$602((Entry)localObject2, true);
        Entry.access$702((Entry)localObject2, null);
        ((Entry)localObject2).setLengths(paramString);
        return;
      }
      if ((k == -1) && (i == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        Entry.access$702((Entry)localObject2, new Editor((Entry)localObject2, null));
        return;
      }
    } while ((k == -1) && (i == "READ".length()) && (paramString.startsWith("READ")));
    throw new IOException("unexpected journal line: " + paramString);
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
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
        Entry localEntry;
        try
        {
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
          localEntry = (Entry)localIterator.next();
          if (localEntry.currentEditor != null)
          {
            localBufferedWriter.write("DIRTY " + localEntry.key + '\n');
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
        localObject1.write("CLEAN " + localEntry.key + localEntry.getLengths() + '\n');
      }
      finally {}
    }
    localObject1.close();
    if (this.journalFile.exists()) {
      renameTo(this.journalFile, this.journalFileBackup, true);
    }
    renameTo(this.journalFileTmp, this.journalFile, false);
    this.journalFileBackup.delete();
    this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
  }
  
  private static void renameTo(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      deleteIfExists(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException();
    }
  }
  
  private void trimToSize()
    throws IOException
  {
    while (this.size > this.maxSize) {
      remove((String)((Map.Entry)this.lruEntries.entrySet().iterator().next()).getKey());
    }
  }
  
  private void validateKey(String paramString)
  {
    if (!LEGAL_KEY_PATTERN.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
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
    Util.deleteContents(this.directory);
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
    //   6: invokespecial 316	com/jakewharton/disklrucache/DiskLruCache:checkNotClosed	()V
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 319	com/jakewharton/disklrucache/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 106	com/jakewharton/disklrucache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   18: aload_1
    //   19: invokevirtual 322	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 18	com/jakewharton/disklrucache/DiskLruCache$Entry
    //   25: astore 6
    //   27: aload 6
    //   29: ifnonnull +10 -> 39
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: areturn
    //   39: aload 4
    //   41: astore_3
    //   42: aload 6
    //   44: invokestatic 219	com/jakewharton/disklrucache/DiskLruCache$Entry:access$600	(Lcom/jakewharton/disklrucache/DiskLruCache$Entry;)Z
    //   47: ifeq -12 -> 35
    //   50: aload_0
    //   51: getfield 148	com/jakewharton/disklrucache/DiskLruCache:valueCount	I
    //   54: anewarray 562	java/io/InputStream
    //   57: astore 5
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: aload_0
    //   63: getfield 148	com/jakewharton/disklrucache/DiskLruCache:valueCount	I
    //   66: if_icmpge +65 -> 131
    //   69: aload 5
    //   71: iload_2
    //   72: new 449	java/io/FileInputStream
    //   75: dup
    //   76: aload 6
    //   78: iload_2
    //   79: invokevirtual 252	com/jakewharton/disklrucache/DiskLruCache$Entry:getCleanFile	(I)Ljava/io/File;
    //   82: invokespecial 451	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   85: aastore
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -29 -> 61
    //   93: astore_1
    //   94: iconst_0
    //   95: istore_2
    //   96: aload 4
    //   98: astore_3
    //   99: iload_2
    //   100: aload_0
    //   101: getfield 148	com/jakewharton/disklrucache/DiskLruCache:valueCount	I
    //   104: if_icmpge -69 -> 35
    //   107: aload 4
    //   109: astore_3
    //   110: aload 5
    //   112: iload_2
    //   113: aaload
    //   114: ifnull -79 -> 35
    //   117: aload 5
    //   119: iload_2
    //   120: aaload
    //   121: invokestatic 479	com/jakewharton/disklrucache/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   124: iload_2
    //   125: iconst_1
    //   126: iadd
    //   127: istore_2
    //   128: goto -32 -> 96
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 198	com/jakewharton/disklrucache/DiskLruCache:redundantOpCount	I
    //   136: iconst_1
    //   137: iadd
    //   138: putfield 198	com/jakewharton/disklrucache/DiskLruCache:redundantOpCount	I
    //   141: aload_0
    //   142: getfield 154	com/jakewharton/disklrucache/DiskLruCache:journalWriter	Ljava/io/Writer;
    //   145: new 228	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 564
    //   155: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: bipush 10
    //   164: invokevirtual 288	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   167: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 567	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   173: pop
    //   174: aload_0
    //   175: invokespecial 182	com/jakewharton/disklrucache/DiskLruCache:journalRebuildRequired	()Z
    //   178: ifeq +15 -> 193
    //   181: aload_0
    //   182: getfield 126	com/jakewharton/disklrucache/DiskLruCache:executorService	Ljava/util/concurrent/ThreadPoolExecutor;
    //   185: aload_0
    //   186: getfield 131	com/jakewharton/disklrucache/DiskLruCache:cleanupCallable	Ljava/util/concurrent/Callable;
    //   189: invokevirtual 304	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   192: pop
    //   193: new 21	com/jakewharton/disklrucache/DiskLruCache$Snapshot
    //   196: dup
    //   197: aload_0
    //   198: aload_1
    //   199: aload 6
    //   201: invokestatic 326	com/jakewharton/disklrucache/DiskLruCache$Entry:access$1200	(Lcom/jakewharton/disklrucache/DiskLruCache$Entry;)J
    //   204: aload 5
    //   206: aload 6
    //   208: invokestatic 260	com/jakewharton/disklrucache/DiskLruCache$Entry:access$1000	(Lcom/jakewharton/disklrucache/DiskLruCache$Entry;)[J
    //   211: aconst_null
    //   212: invokespecial 570	com/jakewharton/disklrucache/DiskLruCache$Snapshot:<init>	(Lcom/jakewharton/disklrucache/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;[JLcom/jakewharton/disklrucache/DiskLruCache$1;)V
    //   215: astore_3
    //   216: goto -181 -> 35
    //   219: astore_1
    //   220: aload_0
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	DiskLruCache
    //   0	224	1	paramString	String
    //   60	68	2	i	int
    //   34	182	3	localObject1	Object
    //   1	107	4	localObject2	Object
    //   57	148	5	arrayOfInputStream	InputStream[]
    //   25	182	6	localEntry	Entry
    // Exception table:
    //   from	to	target	type
    //   61	86	93	java/io/FileNotFoundException
    //   5	27	219	finally
    //   42	59	219	finally
    //   61	86	219	finally
    //   99	107	219	finally
    //   117	124	219	finally
    //   131	193	219	finally
    //   193	216	219	finally
  }
  
  public File getDirectory()
  {
    return this.directory;
  }
  
  public long getMaxSize()
  {
    try
    {
      long l = this.maxSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isClosed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 154	com/jakewharton/disklrucache/DiskLruCache:journalWriter	Ljava/io/Writer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	DiskLruCache
    //   12	7	1	bool	boolean
    //   6	2	2	localWriter	Writer
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public boolean remove(String paramString)
    throws IOException
  {
    for (;;)
    {
      Entry localEntry;
      int i;
      try
      {
        checkNotClosed();
        validateKey(paramString);
        localEntry = (Entry)this.lruEntries.get(paramString);
        if (localEntry != null)
        {
          localObject = localEntry.currentEditor;
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
        }
        i = 0;
        if (i >= this.valueCount) {
          break label146;
        }
        Object localObject = localEntry.getCleanFile(i);
        if ((((File)localObject).exists()) && (!((File)localObject).delete())) {
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.size -= localEntry.lengths[i];
      localEntry.lengths[i] = 0L;
      i += 1;
      continue;
      label146:
      this.redundantOpCount += 1;
      this.journalWriter.append("REMOVE " + paramString + '\n');
      this.lruEntries.remove(paramString);
      if (journalRebuildRequired()) {
        this.executorService.submit(this.cleanupCallable);
      }
      boolean bool = true;
    }
  }
  
  public void setMaxSize(long paramLong)
  {
    try
    {
      this.maxSize = paramLong;
      this.executorService.submit(this.cleanupCallable);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
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
    private boolean committed;
    private final DiskLruCache.Entry entry;
    private boolean hasErrors;
    private final boolean[] written;
    
    private Editor(DiskLruCache.Entry paramEntry)
    {
      this.entry = paramEntry;
      if (DiskLruCache.Entry.access$600(paramEntry)) {}
      for (this$1 = null;; this$1 = new boolean[DiskLruCache.this.valueCount])
      {
        this.written = DiskLruCache.this;
        return;
      }
    }
    
    public void abort()
      throws IOException
    {
      DiskLruCache.this.completeEdit(this, false);
    }
    
    public void abortUnlessCommitted()
    {
      if (!this.committed) {}
      try
      {
        abort();
        return;
      }
      catch (IOException localIOException) {}
    }
    
    public void commit()
      throws IOException
    {
      if (this.hasErrors)
      {
        DiskLruCache.this.completeEdit(this, false);
        DiskLruCache.this.remove(DiskLruCache.Entry.access$1100(this.entry));
      }
      for (;;)
      {
        this.committed = true;
        return;
        DiskLruCache.this.completeEdit(this, true);
      }
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
        if (DiskLruCache.Entry.access$700(this.entry) != this) {
          throw new IllegalStateException();
        }
      }
      if (!DiskLruCache.Entry.access$600(this.entry)) {
        return null;
      }
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(this.entry.getCleanFile(paramInt));
        return localFileInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
    
    public OutputStream newOutputStream(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.Entry.access$700(this.entry) != this) {
          throw new IllegalStateException();
        }
      }
      if (!DiskLruCache.Entry.access$600(this.entry)) {
        this.written[paramInt] = true;
      }
      File localFile = this.entry.getDirtyFile(paramInt);
      try
      {
        Object localObject2 = new FileOutputStream(localFile);
        localObject2 = new FaultHidingOutputStream((OutputStream)localObject2, null);
        return localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          DiskLruCache.this.directory.mkdirs();
          try
          {
            FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            OutputStream localOutputStream = DiskLruCache.NULL_OUTPUT_STREAM;
            return localOutputStream;
          }
        }
      }
    }
    
    public void set(int paramInt, String paramString)
      throws IOException
    {
      Object localObject3 = null;
      try
      {
        OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(newOutputStream(paramInt), Util.UTF_8);
        Util.closeQuietly(paramString);
      }
      finally
      {
        try
        {
          localOutputStreamWriter.write(paramString);
          Util.closeQuietly(localOutputStreamWriter);
          return;
        }
        finally
        {
          paramString = localObject1;
          Object localObject2 = localObject4;
        }
        localObject1 = finally;
        paramString = localObject3;
      }
      throw localObject1;
    }
    
    private class FaultHidingOutputStream
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
          DiskLruCache.Editor.access$2302(DiskLruCache.Editor.this, true);
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
          DiskLruCache.Editor.access$2302(DiskLruCache.Editor.this, true);
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
          DiskLruCache.Editor.access$2302(DiskLruCache.Editor.this, true);
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
          DiskLruCache.Editor.access$2302(DiskLruCache.Editor.this, true);
        }
      }
    }
  }
  
  private final class Entry
  {
    private DiskLruCache.Editor currentEditor;
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
      return new File(DiskLruCache.this.directory, this.key + "." + paramInt);
    }
    
    public File getDirtyFile(int paramInt)
    {
      return new File(DiskLruCache.this.directory, this.key + "." + paramInt + ".tmp");
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
    private final long[] lengths;
    private final long sequenceNumber;
    
    private Snapshot(String paramString, long paramLong, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
    {
      this.key = paramString;
      this.sequenceNumber = paramLong;
      this.ins = paramArrayOfInputStream;
      this.lengths = paramArrayOfLong;
    }
    
    public void close()
    {
      InputStream[] arrayOfInputStream = this.ins;
      int j = arrayOfInputStream.length;
      int i = 0;
      while (i < j)
      {
        Util.closeQuietly(arrayOfInputStream[i]);
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
    
    public long getLength(int paramInt)
    {
      return this.lengths[paramInt];
    }
    
    public String getString(int paramInt)
      throws IOException
    {
      return DiskLruCache.inputStreamToString(getInputStream(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.jakewharton.disklrucache.DiskLruCache
 * JD-Core Version:    0.7.0.1
 */