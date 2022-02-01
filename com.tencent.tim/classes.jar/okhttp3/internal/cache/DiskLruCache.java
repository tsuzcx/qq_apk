package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class DiskLruCache
  implements Closeable, Flushable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  static final Pattern LEGAL_KEY_PATTERN;
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Runnable cleanupRunnable = new DiskLruCache.1(this);
  boolean closed;
  final File directory;
  private final Executor executor;
  final FileSystem fileSystem;
  boolean hasJournalErrors;
  boolean initialized;
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  BufferedSink journalWriter;
  final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private long maxSize;
  boolean mostRecentRebuildFailed;
  boolean mostRecentTrimFailed;
  private long nextSequenceNumber = 0L;
  int redundantOpCount;
  private long size = 0L;
  final int valueCount;
  
  static
  {
    if (!DiskLruCache.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
      return;
    }
  }
  
  DiskLruCache(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong, Executor paramExecutor)
  {
    this.fileSystem = paramFileSystem;
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
    this.executor = paramExecutor;
  }
  
  private void checkNotClosed()
  {
    try
    {
      if (isClosed()) {
        throw new IllegalStateException("cache is closed");
      }
    }
    finally {}
  }
  
  public static DiskLruCache create(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    return new DiskLruCache(paramFileSystem, paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
  }
  
  private BufferedSink newJournalWriter()
    throws FileNotFoundException
  {
    return Okio.buffer(new DiskLruCache.2(this, this.fileSystem.appendingSink(this.journalFile)));
  }
  
  private void processJournal()
    throws IOException
  {
    this.fileSystem.delete(this.journalFileTmp);
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
        localEntry.currentEditor = null;
        i = 0;
        while (i < this.valueCount)
        {
          this.fileSystem.delete(localEntry.cleanFiles[i]);
          this.fileSystem.delete(localEntry.dirtyFiles[i]);
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
    //   0: aload_0
    //   1: getfield 123	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   4: aload_0
    //   5: getfield 134	okhttp3/internal/cache/DiskLruCache:journalFile	Ljava/io/File;
    //   8: invokeinterface 263 2 0
    //   13: invokestatic 266	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 272 1 0
    //   23: astore_3
    //   24: aload_2
    //   25: invokeinterface 272 1 0
    //   30: astore 4
    //   32: aload_2
    //   33: invokeinterface 272 1 0
    //   38: astore 5
    //   40: aload_2
    //   41: invokeinterface 272 1 0
    //   46: astore 6
    //   48: aload_2
    //   49: invokeinterface 272 1 0
    //   54: astore 7
    //   56: ldc 42
    //   58: aload_3
    //   59: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifeq +54 -> 116
    //   65: ldc 49
    //   67: aload 4
    //   69: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifeq +44 -> 116
    //   75: aload_0
    //   76: getfield 127	okhttp3/internal/cache/DiskLruCache:appVersion	I
    //   79: invokestatic 284	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   82: aload 5
    //   84: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +29 -> 116
    //   90: aload_0
    //   91: getfield 140	okhttp3/internal/cache/DiskLruCache:valueCount	I
    //   94: invokestatic 284	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   97: aload 6
    //   99: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq +14 -> 116
    //   105: ldc_w 286
    //   108: aload 7
    //   110: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifne +77 -> 190
    //   116: new 215	java/io/IOException
    //   119: dup
    //   120: new 288	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 291
    //   130: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_3
    //   134: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 297
    //   140: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 4
    //   145: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 297
    //   151: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 6
    //   156: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 297
    //   162: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 7
    //   167: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 299
    //   173: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokespecial 302	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   182: athrow
    //   183: astore_3
    //   184: aload_2
    //   185: invokestatic 306	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   188: aload_3
    //   189: athrow
    //   190: iconst_0
    //   191: istore_1
    //   192: aload_0
    //   193: aload_2
    //   194: invokeinterface 272 1 0
    //   199: invokespecial 309	okhttp3/internal/cache/DiskLruCache:readJournalLine	(Ljava/lang/String;)V
    //   202: iload_1
    //   203: iconst_1
    //   204: iadd
    //   205: istore_1
    //   206: goto -14 -> 192
    //   209: astore_3
    //   210: aload_0
    //   211: iload_1
    //   212: aload_0
    //   213: getfield 112	okhttp3/internal/cache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   216: invokevirtual 312	java/util/LinkedHashMap:size	()I
    //   219: isub
    //   220: putfield 314	okhttp3/internal/cache/DiskLruCache:redundantOpCount	I
    //   223: aload_2
    //   224: invokeinterface 317 1 0
    //   229: ifne +12 -> 241
    //   232: aload_0
    //   233: invokevirtual 320	okhttp3/internal/cache/DiskLruCache:rebuildJournal	()V
    //   236: aload_2
    //   237: invokestatic 306	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   240: return
    //   241: aload_0
    //   242: aload_0
    //   243: invokespecial 322	okhttp3/internal/cache/DiskLruCache:newJournalWriter	()Lokio/BufferedSink;
    //   246: putfield 324	okhttp3/internal/cache/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   249: goto -13 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	DiskLruCache
    //   191	29	1	i	int
    //   16	221	2	localBufferedSource	okio.BufferedSource
    //   23	111	3	str1	String
    //   183	6	3	localObject	Object
    //   209	1	3	localEOFException	java.io.EOFException
    //   30	114	4	str2	String
    //   38	45	5	str3	String
    //   46	109	6	str4	String
    //   54	112	7	str5	String
    // Exception table:
    //   from	to	target	type
    //   17	116	183	finally
    //   116	183	183	finally
    //   192	202	183	finally
    //   210	236	183	finally
    //   241	249	183	finally
    //   192	202	209	java/io/EOFException
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
    String str;
    if (k == -1)
    {
      str = paramString.substring(j);
      if ((i == "REMOVE".length()) && (paramString.startsWith("REMOVE"))) {
        this.lruEntries.remove(str);
      }
    }
    else
    {
      str = paramString.substring(j, k);
    }
    for (;;)
    {
      Entry localEntry2 = (Entry)this.lruEntries.get(str);
      Entry localEntry1 = localEntry2;
      if (localEntry2 == null)
      {
        localEntry1 = new Entry(str);
        this.lruEntries.put(str, localEntry1);
      }
      if ((k != -1) && (i == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        localEntry1.readable = true;
        localEntry1.currentEditor = null;
        localEntry1.setLengths(paramString);
        return;
      }
      if ((k == -1) && (i == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        localEntry1.currentEditor = new Editor(localEntry1);
        return;
      }
      if ((k == -1) && (i == "READ".length()) && (paramString.startsWith("READ"))) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private void validateKey(String paramString)
  {
    if (!LEGAL_KEY_PATTERN.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + paramString + "\"");
    }
  }
  
  public void close()
    throws IOException
  {
    for (;;)
    {
      try
      {
        if ((!this.initialized) || (this.closed))
        {
          this.closed = true;
          return;
        }
        Entry[] arrayOfEntry = (Entry[])this.lruEntries.values().toArray(new Entry[this.lruEntries.size()]);
        int j = arrayOfEntry.length;
        int i = 0;
        if (i < j)
        {
          Entry localEntry = arrayOfEntry[i];
          if (localEntry.currentEditor != null) {
            localEntry.currentEditor.abort();
          }
        }
        else
        {
          trimToSize();
          this.journalWriter.close();
          this.journalWriter = null;
          this.closed = true;
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  void completeEdit(Editor paramEditor, boolean paramBoolean)
    throws IOException
  {
    int k = 0;
    Entry localEntry;
    try
    {
      localEntry = paramEditor.entry;
      if (localEntry.currentEditor != paramEditor) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int j = k;
    if (paramBoolean)
    {
      j = k;
      if (!localEntry.readable)
      {
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= this.valueCount) {
            break;
          }
          if (paramEditor.written[i] == 0)
          {
            paramEditor.abort();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
          }
          if (!this.fileSystem.exists(localEntry.dirtyFiles[i]))
          {
            paramEditor.abort();
            return;
          }
          i += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (j < this.valueCount)
      {
        paramEditor = localEntry.dirtyFiles[j];
        if (paramBoolean)
        {
          if (this.fileSystem.exists(paramEditor))
          {
            File localFile = localEntry.cleanFiles[j];
            this.fileSystem.rename(paramEditor, localFile);
            l1 = localEntry.lengths[j];
            long l2 = this.fileSystem.size(localFile);
            localEntry.lengths[j] = l2;
            this.size = (this.size - l1 + l2);
          }
        }
        else {
          this.fileSystem.delete(paramEditor);
        }
      }
      else
      {
        this.redundantOpCount += 1;
        localEntry.currentEditor = null;
        if ((localEntry.readable | paramBoolean))
        {
          localEntry.readable = true;
          this.journalWriter.writeUtf8("CLEAN").writeByte(32);
          this.journalWriter.writeUtf8(localEntry.key);
          localEntry.writeLengths(this.journalWriter);
          this.journalWriter.writeByte(10);
          if (paramBoolean)
          {
            l1 = this.nextSequenceNumber;
            this.nextSequenceNumber = (1L + l1);
            localEntry.sequenceNumber = l1;
          }
        }
        for (;;)
        {
          this.journalWriter.flush();
          if ((this.size <= this.maxSize) && (!journalRebuildRequired())) {
            break;
          }
          this.executor.execute(this.cleanupRunnable);
          break;
          this.lruEntries.remove(localEntry.key);
          this.journalWriter.writeUtf8("REMOVE").writeByte(32);
          this.journalWriter.writeUtf8(localEntry.key);
          this.journalWriter.writeByte(10);
        }
      }
      j += 1;
    }
  }
  
  public void delete()
    throws IOException
  {
    close();
    this.fileSystem.deleteContents(this.directory);
  }
  
  @Nullable
  public Editor edit(String paramString)
    throws IOException
  {
    return edit(paramString, -1L);
  }
  
  Editor edit(String paramString, long paramLong)
    throws IOException
  {
    for (;;)
    {
      try
      {
        initialize();
        checkNotClosed();
        validateKey(paramString);
        Object localObject = (Entry)this.lruEntries.get(paramString);
        if (paramLong != -1L) {
          if (localObject != null)
          {
            long l = ((Entry)localObject).sequenceNumber;
            if (l == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if ((localObject != null) && (((Entry)localObject).currentEditor != null))
        {
          paramString = null;
        }
        else if ((this.mostRecentTrimFailed) || (this.mostRecentRebuildFailed))
        {
          this.executor.execute(this.cleanupRunnable);
          paramString = null;
        }
        else
        {
          this.journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(paramString).writeByte(10);
          this.journalWriter.flush();
          if (this.hasJournalErrors)
          {
            paramString = null;
          }
          else if (localObject == null)
          {
            localObject = new Entry(paramString);
            this.lruEntries.put(paramString, localObject);
            paramString = (String)localObject;
            localObject = new Editor(paramString);
            paramString.currentEditor = ((Editor)localObject);
            paramString = (String)localObject;
          }
          else
          {
            paramString = (String)localObject;
          }
        }
      }
      finally {}
    }
  }
  
  public void evictAll()
    throws IOException
  {
    int i = 0;
    try
    {
      initialize();
      Entry[] arrayOfEntry = (Entry[])this.lruEntries.values().toArray(new Entry[this.lruEntries.size()]);
      int j = arrayOfEntry.length;
      while (i < j)
      {
        removeEntry(arrayOfEntry[i]);
        i += 1;
      }
      this.mostRecentTrimFailed = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void flush()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 392	okhttp3/internal/cache/DiskLruCache:initialized	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 483	okhttp3/internal/cache/DiskLruCache:checkNotClosed	()V
    //   18: aload_0
    //   19: invokevirtual 406	okhttp3/internal/cache/DiskLruCache:trimToSize	()V
    //   22: aload_0
    //   23: getfield 324	okhttp3/internal/cache/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   26: invokeinterface 458 1 0
    //   31: goto -20 -> 11
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	DiskLruCache
    //   6	2	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  /* Error */
  public Snapshot get(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 481	okhttp3/internal/cache/DiskLruCache:initialize	()V
    //   6: aload_0
    //   7: invokespecial 483	okhttp3/internal/cache/DiskLruCache:checkNotClosed	()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 485	okhttp3/internal/cache/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 112	okhttp3/internal/cache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual 352	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 13	okhttp3/internal/cache/DiskLruCache$Entry
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +12 -> 40
    //   31: aload_3
    //   32: getfield 368	okhttp3/internal/cache/DiskLruCache$Entry:readable	Z
    //   35: istore_2
    //   36: iload_2
    //   37: ifne +9 -> 46
    //   40: aconst_null
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_3
    //   47: invokevirtual 501	okhttp3/internal/cache/DiskLruCache$Entry:snapshot	()Lokhttp3/internal/cache/DiskLruCache$Snapshot;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull +8 -> 60
    //   55: aconst_null
    //   56: astore_1
    //   57: goto -15 -> 42
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 314	okhttp3/internal/cache/DiskLruCache:redundantOpCount	I
    //   65: iconst_1
    //   66: iadd
    //   67: putfield 314	okhttp3/internal/cache/DiskLruCache:redundantOpCount	I
    //   70: aload_0
    //   71: getfield 324	okhttp3/internal/cache/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   74: ldc 44
    //   76: invokeinterface 441 2 0
    //   81: bipush 32
    //   83: invokeinterface 445 2 0
    //   88: aload_1
    //   89: invokeinterface 441 2 0
    //   94: bipush 10
    //   96: invokeinterface 445 2 0
    //   101: pop
    //   102: aload_3
    //   103: astore_1
    //   104: aload_0
    //   105: invokevirtual 461	okhttp3/internal/cache/DiskLruCache:journalRebuildRequired	()Z
    //   108: ifeq -66 -> 42
    //   111: aload_0
    //   112: getfield 144	okhttp3/internal/cache/DiskLruCache:executor	Ljava/util/concurrent/Executor;
    //   115: aload_0
    //   116: getfield 121	okhttp3/internal/cache/DiskLruCache:cleanupRunnable	Ljava/lang/Runnable;
    //   119: invokeinterface 467 2 0
    //   124: aload_3
    //   125: astore_1
    //   126: goto -84 -> 42
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	DiskLruCache
    //   0	134	1	paramString	String
    //   35	2	2	bool	boolean
    //   26	99	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	129	finally
    //   31	36	129	finally
    //   46	51	129	finally
    //   60	102	129	finally
    //   104	124	129	finally
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
  
  public void initialize()
    throws IOException
  {
    try
    {
      if ((!$assertionsDisabled) && (!Thread.holdsLock(this))) {
        throw new AssertionError();
      }
    }
    finally {}
    boolean bool = this.initialized;
    if (bool) {
      return;
    }
    if (this.fileSystem.exists(this.journalFileBackup))
    {
      if (!this.fileSystem.exists(this.journalFile)) {
        break label191;
      }
      this.fileSystem.delete(this.journalFileBackup);
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          bool = this.fileSystem.exists(this.journalFile);
          if (bool) {
            try
            {
              readJournal();
              processJournal();
              this.initialized = true;
            }
            catch (IOException localIOException)
            {
              Platform.get().log(5, "DiskLruCache " + this.directory + " is corrupt: " + localIOException.getMessage() + ", removing", localIOException);
            }
          }
        }
        try
        {
          delete();
          this.closed = false;
          rebuildJournal();
          this.initialized = true;
        }
        finally
        {
          label191:
          this.closed = false;
        }
      }
      this.fileSystem.rename(this.journalFileBackup, this.journalFile);
    }
  }
  
  public boolean isClosed()
  {
    try
    {
      boolean bool = this.closed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean journalRebuildRequired()
  {
    return (this.redundantOpCount >= 2000) && (this.redundantOpCount >= this.lruEntries.size());
  }
  
  void rebuildJournal()
    throws IOException
  {
    for (;;)
    {
      Entry localEntry;
      try
      {
        if (this.journalWriter != null) {
          this.journalWriter.close();
        }
        BufferedSink localBufferedSink1 = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
        try
        {
          localBufferedSink1.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
          localBufferedSink1.writeUtf8("1").writeByte(10);
          localBufferedSink1.writeDecimalLong(this.appVersion).writeByte(10);
          localBufferedSink1.writeDecimalLong(this.valueCount).writeByte(10);
          localBufferedSink1.writeByte(10);
          Iterator localIterator = this.lruEntries.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localEntry = (Entry)localIterator.next();
          if (localEntry.currentEditor != null)
          {
            localBufferedSink1.writeUtf8("DIRTY").writeByte(32);
            localBufferedSink1.writeUtf8(localEntry.key);
            localBufferedSink1.writeByte(10);
            continue;
            localBufferedSink2 = finally;
          }
        }
        finally
        {
          localBufferedSink1.close();
        }
        localBufferedSink2.writeUtf8("CLEAN").writeByte(32);
      }
      finally {}
      localBufferedSink2.writeUtf8(localEntry.key);
      localEntry.writeLengths(localBufferedSink2);
      localBufferedSink2.writeByte(10);
    }
    localBufferedSink2.close();
    if (this.fileSystem.exists(this.journalFile)) {
      this.fileSystem.rename(this.journalFile, this.journalFileBackup);
    }
    this.fileSystem.rename(this.journalFileTmp, this.journalFile);
    this.fileSystem.delete(this.journalFileBackup);
    this.journalWriter = newJournalWriter();
    this.hasJournalErrors = false;
    this.mostRecentRebuildFailed = false;
  }
  
  /* Error */
  public boolean remove(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 481	okhttp3/internal/cache/DiskLruCache:initialize	()V
    //   6: aload_0
    //   7: invokespecial 483	okhttp3/internal/cache/DiskLruCache:checkNotClosed	()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 485	okhttp3/internal/cache/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 112	okhttp3/internal/cache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual 352	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 13	okhttp3/internal/cache/DiskLruCache$Entry
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +9 -> 37
    //   31: iconst_0
    //   32: istore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 496	okhttp3/internal/cache/DiskLruCache:removeEntry	(Lokhttp3/internal/cache/DiskLruCache$Entry;)Z
    //   42: istore_3
    //   43: iload_3
    //   44: istore_2
    //   45: iload_3
    //   46: ifeq -13 -> 33
    //   49: iload_3
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 104	okhttp3/internal/cache/DiskLruCache:size	J
    //   55: aload_0
    //   56: getfield 142	okhttp3/internal/cache/DiskLruCache:maxSize	J
    //   59: lcmp
    //   60: ifgt -27 -> 33
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 487	okhttp3/internal/cache/DiskLruCache:mostRecentTrimFailed	Z
    //   68: iload_3
    //   69: istore_2
    //   70: goto -37 -> 33
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	DiskLruCache
    //   0	78	1	paramString	String
    //   32	38	2	bool1	boolean
    //   42	27	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	27	73	finally
    //   37	43	73	finally
    //   51	68	73	finally
  }
  
  boolean removeEntry(Entry paramEntry)
    throws IOException
  {
    if (paramEntry.currentEditor != null) {
      paramEntry.currentEditor.detach();
    }
    int i = 0;
    while (i < this.valueCount)
    {
      this.fileSystem.delete(paramEntry.cleanFiles[i]);
      this.size -= paramEntry.lengths[i];
      paramEntry.lengths[i] = 0L;
      i += 1;
    }
    this.redundantOpCount += 1;
    this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(paramEntry.key).writeByte(10);
    this.lruEntries.remove(paramEntry.key);
    if (journalRebuildRequired()) {
      this.executor.execute(this.cleanupRunnable);
    }
    return true;
  }
  
  public void setMaxSize(long paramLong)
  {
    try
    {
      this.maxSize = paramLong;
      if (this.initialized) {
        this.executor.execute(this.cleanupRunnable);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long size()
    throws IOException
  {
    try
    {
      initialize();
      long l = this.size;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Iterator<Snapshot> snapshots()
    throws IOException
  {
    try
    {
      initialize();
      DiskLruCache.3 local3 = new DiskLruCache.3(this);
      return local3;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void trimToSize()
    throws IOException
  {
    while (this.size > this.maxSize) {
      removeEntry((Entry)this.lruEntries.values().iterator().next());
    }
    this.mostRecentTrimFailed = false;
  }
  
  public final class Editor
  {
    private boolean done;
    final DiskLruCache.Entry entry;
    final boolean[] written;
    
    Editor(DiskLruCache.Entry paramEntry)
    {
      this.entry = paramEntry;
      if (paramEntry.readable) {}
      for (this$1 = null;; this$1 = new boolean[DiskLruCache.this.valueCount])
      {
        this.written = DiskLruCache.this;
        return;
      }
    }
    
    public void abort()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (this.done) {
          throw new IllegalStateException();
        }
      }
      if (this.entry.currentEditor == this) {
        DiskLruCache.this.completeEdit(this, false);
      }
      this.done = true;
    }
    
    public void abortUnlessCommitted()
    {
      synchronized (DiskLruCache.this)
      {
        if (!this.done)
        {
          Editor localEditor = this.entry.currentEditor;
          if (localEditor != this) {}
        }
      }
      try
      {
        DiskLruCache.this.completeEdit(this, false);
        label36:
        return;
        localObject = finally;
        throw localObject;
      }
      catch (IOException localIOException)
      {
        break label36;
      }
    }
    
    public void commit()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (this.done) {
          throw new IllegalStateException();
        }
      }
      if (this.entry.currentEditor == this) {
        DiskLruCache.this.completeEdit(this, true);
      }
      this.done = true;
    }
    
    void detach()
    {
      int i;
      if (this.entry.currentEditor == this) {
        i = 0;
      }
      for (;;)
      {
        if (i < DiskLruCache.this.valueCount) {}
        try
        {
          DiskLruCache.this.fileSystem.delete(this.entry.dirtyFiles[i]);
          label45:
          i += 1;
          continue;
          this.entry.currentEditor = null;
          return;
        }
        catch (IOException localIOException)
        {
          break label45;
        }
      }
    }
    
    public Sink newSink(int paramInt)
    {
      synchronized (DiskLruCache.this)
      {
        if (this.done) {
          throw new IllegalStateException();
        }
      }
      if (this.entry.currentEditor != this)
      {
        localObject2 = Okio.blackhole();
        return localObject2;
      }
      if (!this.entry.readable) {
        this.written[paramInt] = true;
      }
      Object localObject2 = this.entry.dirtyFiles[paramInt];
      try
      {
        localObject2 = DiskLruCache.this.fileSystem.sink((File)localObject2);
        localObject2 = new DiskLruCache.Editor.1(this, (Sink)localObject2);
        return localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Sink localSink = Okio.blackhole();
        return localSink;
      }
    }
    
    public Source newSource(int paramInt)
    {
      synchronized (DiskLruCache.this)
      {
        if (this.done) {
          throw new IllegalStateException();
        }
      }
      if ((!this.entry.readable) || (this.entry.currentEditor != this)) {
        return null;
      }
      try
      {
        Source localSource = DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[paramInt]);
        return localSource;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
  }
  
  final class Entry
  {
    final File[] cleanFiles;
    DiskLruCache.Editor currentEditor;
    final File[] dirtyFiles;
    final String key;
    final long[] lengths;
    boolean readable;
    long sequenceNumber;
    
    Entry(String paramString)
    {
      this.key = paramString;
      this.lengths = new long[DiskLruCache.this.valueCount];
      this.cleanFiles = new File[DiskLruCache.this.valueCount];
      this.dirtyFiles = new File[DiskLruCache.this.valueCount];
      paramString = new StringBuilder(paramString).append('.');
      int j = paramString.length();
      int i = 0;
      while (i < DiskLruCache.this.valueCount)
      {
        paramString.append(i);
        this.cleanFiles[i] = new File(DiskLruCache.this.directory, paramString.toString());
        paramString.append(".tmp");
        this.dirtyFiles[i] = new File(DiskLruCache.this.directory, paramString.toString());
        paramString.setLength(j);
        i += 1;
      }
    }
    
    private IOException invalidLengths(String[] paramArrayOfString)
      throws IOException
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }
    
    void setLengths(String[] paramArrayOfString)
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
    
    DiskLruCache.Snapshot snapshot()
    {
      j = 0;
      if (!Thread.holdsLock(DiskLruCache.this)) {
        throw new AssertionError();
      }
      Source[] arrayOfSource = new Source[DiskLruCache.this.valueCount];
      Object localObject = (long[])this.lengths.clone();
      i = 0;
      for (;;)
      {
        try
        {
          if (i < DiskLruCache.this.valueCount)
          {
            arrayOfSource[i] = DiskLruCache.this.fileSystem.source(this.cleanFiles[i]);
            i += 1;
            continue;
          }
          localObject = new DiskLruCache.Snapshot(DiskLruCache.this, this.key, this.sequenceNumber, arrayOfSource, (long[])localObject);
          return localObject;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          i = j;
          continue;
        }
        if ((i >= DiskLruCache.this.valueCount) || (arrayOfSource[i] == null)) {
          continue;
        }
        Util.closeQuietly(arrayOfSource[i]);
        i += 1;
      }
      try
      {
        DiskLruCache.this.removeEntry(this);
        label150:
        return null;
      }
      catch (IOException localIOException)
      {
        break label150;
      }
    }
    
    void writeLengths(BufferedSink paramBufferedSink)
      throws IOException
    {
      long[] arrayOfLong = this.lengths;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        paramBufferedSink.writeByte(32).writeDecimalLong(l);
        i += 1;
      }
    }
  }
  
  public final class Snapshot
    implements Closeable
  {
    private final String key;
    private final long[] lengths;
    private final long sequenceNumber;
    private final Source[] sources;
    
    Snapshot(String paramString, long paramLong, Source[] paramArrayOfSource, long[] paramArrayOfLong)
    {
      this.key = paramString;
      this.sequenceNumber = paramLong;
      this.sources = paramArrayOfSource;
      this.lengths = paramArrayOfLong;
    }
    
    public void close()
    {
      Source[] arrayOfSource = this.sources;
      int j = arrayOfSource.length;
      int i = 0;
      while (i < j)
      {
        Util.closeQuietly(arrayOfSource[i]);
        i += 1;
      }
    }
    
    @Nullable
    public DiskLruCache.Editor edit()
      throws IOException
    {
      return DiskLruCache.this.edit(this.key, this.sequenceNumber);
    }
    
    public long getLength(int paramInt)
    {
      return this.lengths[paramInt];
    }
    
    public Source getSource(int paramInt)
    {
      return this.sources[paramInt];
    }
    
    public String key()
    {
      return this.key;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.cache.DiskLruCache
 * JD-Core Version:    0.7.0.1
 */