package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtIncompatible
public abstract class CharSource
{
  public static CharSource concat(Iterable<? extends CharSource> paramIterable)
  {
    return new ConcatenatedCharSource(paramIterable);
  }
  
  public static CharSource concat(Iterator<? extends CharSource> paramIterator)
  {
    return concat(ImmutableList.copyOf(paramIterator));
  }
  
  public static CharSource concat(CharSource... paramVarArgs)
  {
    return concat(ImmutableList.copyOf(paramVarArgs));
  }
  
  private long countBySkipping(Reader paramReader)
    throws IOException
  {
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramReader.skip(9223372036854775807L);
      if (l2 == 0L) {
        break;
      }
    }
    return l1;
  }
  
  public static CharSource empty()
  {
    return EmptyCharSource.INSTANCE;
  }
  
  public static CharSource wrap(CharSequence paramCharSequence)
  {
    return new CharSequenceCharSource(paramCharSequence);
  }
  
  @Beta
  public ByteSource asByteSource(Charset paramCharset)
  {
    return new AsByteSource(paramCharset);
  }
  
  @CanIgnoreReturnValue
  public long copyTo(CharSink paramCharSink)
    throws IOException
  {
    Preconditions.checkNotNull(paramCharSink);
    Closer localCloser = Closer.create();
    try
    {
      long l = CharStreams.copy((Reader)localCloser.register(openStream()), (Writer)localCloser.register(paramCharSink.openStream()));
      return l;
    }
    catch (Throwable paramCharSink)
    {
      throw localCloser.rethrow(paramCharSink);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  @CanIgnoreReturnValue
  public long copyTo(Appendable paramAppendable)
    throws IOException
  {
    Preconditions.checkNotNull(paramAppendable);
    Closer localCloser = Closer.create();
    try
    {
      long l = CharStreams.copy((Reader)localCloser.register(openStream()), paramAppendable);
      return l;
    }
    catch (Throwable paramAppendable)
    {
      throw localCloser.rethrow(paramAppendable);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  /* Error */
  public boolean isEmpty()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 126	com/google/common/io/CharSource:lengthIfKnown	()Lcom/google/common/base/Optional;
    //   4: astore_3
    //   5: aload_3
    //   6: invokevirtual 131	com/google/common/base/Optional:isPresent	()Z
    //   9: ifeq +20 -> 29
    //   12: aload_3
    //   13: invokevirtual 135	com/google/common/base/Optional:get	()Ljava/lang/Object;
    //   16: checkcast 137	java/lang/Long
    //   19: invokevirtual 141	java/lang/Long:longValue	()J
    //   22: lconst_0
    //   23: lcmp
    //   24: ifne +5 -> 29
    //   27: iconst_1
    //   28: ireturn
    //   29: invokestatic 91	com/google/common/io/Closer:create	()Lcom/google/common/io/Closer;
    //   32: astore_3
    //   33: aload_3
    //   34: aload_0
    //   35: invokevirtual 95	com/google/common/io/CharSource:openStream	()Ljava/io/Reader;
    //   38: invokevirtual 99	com/google/common/io/Closer:register	(Ljava/io/Closeable;)Ljava/io/Closeable;
    //   41: checkcast 51	java/io/Reader
    //   44: invokevirtual 145	java/io/Reader:read	()I
    //   47: istore_1
    //   48: iload_1
    //   49: iconst_m1
    //   50: if_icmpne +11 -> 61
    //   53: iconst_1
    //   54: istore_2
    //   55: aload_3
    //   56: invokevirtual 115	com/google/common/io/Closer:close	()V
    //   59: iload_2
    //   60: ireturn
    //   61: iconst_0
    //   62: istore_2
    //   63: goto -8 -> 55
    //   66: astore 4
    //   68: aload_3
    //   69: aload 4
    //   71: invokevirtual 119	com/google/common/io/Closer:rethrow	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   74: athrow
    //   75: astore 4
    //   77: aload_3
    //   78: invokevirtual 115	com/google/common/io/Closer:close	()V
    //   81: aload 4
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	CharSource
    //   47	4	1	i	int
    //   54	9	2	bool	boolean
    //   4	74	3	localObject1	Object
    //   66	4	4	localThrowable	Throwable
    //   75	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	48	66	java/lang/Throwable
    //   33	48	75	finally
    //   68	75	75	finally
  }
  
  @Beta
  public long length()
    throws IOException
  {
    Object localObject1 = lengthIfKnown();
    if (((Optional)localObject1).isPresent()) {
      return ((Long)((Optional)localObject1).get()).longValue();
    }
    localObject1 = Closer.create();
    try
    {
      long l = countBySkipping((Reader)((Closer)localObject1).register(openStream()));
      return l;
    }
    catch (Throwable localThrowable)
    {
      throw ((Closer)localObject1).rethrow(localThrowable);
    }
    finally
    {
      ((Closer)localObject1).close();
    }
  }
  
  @Beta
  public Optional<Long> lengthIfKnown()
  {
    return Optional.absent();
  }
  
  public BufferedReader openBufferedStream()
    throws IOException
  {
    Reader localReader = openStream();
    if ((localReader instanceof BufferedReader)) {
      return (BufferedReader)localReader;
    }
    return new BufferedReader(localReader);
  }
  
  public abstract Reader openStream()
    throws IOException;
  
  public String read()
    throws IOException
  {
    Closer localCloser = Closer.create();
    try
    {
      String str = CharStreams.toString((Reader)localCloser.register(openStream()));
      return str;
    }
    catch (Throwable localThrowable)
    {
      throw localCloser.rethrow(localThrowable);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  @Nullable
  public String readFirstLine()
    throws IOException
  {
    Closer localCloser = Closer.create();
    try
    {
      String str = ((BufferedReader)localCloser.register(openBufferedStream())).readLine();
      return str;
    }
    catch (Throwable localThrowable)
    {
      throw localCloser.rethrow(localThrowable);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  public ImmutableList<String> readLines()
    throws IOException
  {
    Closer localCloser = Closer.create();
    try
    {
      BufferedReader localBufferedReader = (BufferedReader)localCloser.register(openBufferedStream());
      ArrayList localArrayList = Lists.newArrayList();
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localArrayList.add(str);
      }
      localImmutableList = ImmutableList.copyOf(localArrayList);
    }
    catch (Throwable localThrowable)
    {
      throw localCloser.rethrow(localThrowable);
    }
    finally
    {
      localCloser.close();
    }
    ImmutableList localImmutableList;
    localCloser.close();
    return localImmutableList;
  }
  
  @Beta
  @CanIgnoreReturnValue
  public <T> T readLines(LineProcessor<T> paramLineProcessor)
    throws IOException
  {
    Preconditions.checkNotNull(paramLineProcessor);
    Closer localCloser = Closer.create();
    try
    {
      paramLineProcessor = CharStreams.readLines((Reader)localCloser.register(openStream()), paramLineProcessor);
      return paramLineProcessor;
    }
    catch (Throwable paramLineProcessor)
    {
      throw localCloser.rethrow(paramLineProcessor);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  final class AsByteSource
    extends ByteSource
  {
    final Charset charset;
    
    AsByteSource(Charset paramCharset)
    {
      this.charset = ((Charset)Preconditions.checkNotNull(paramCharset));
    }
    
    public CharSource asCharSource(Charset paramCharset)
    {
      if (paramCharset.equals(this.charset)) {
        return CharSource.this;
      }
      return super.asCharSource(paramCharset);
    }
    
    public InputStream openStream()
      throws IOException
    {
      return new ReaderInputStream(CharSource.this.openStream(), this.charset, 8192);
    }
    
    public String toString()
    {
      return CharSource.this.toString() + ".asByteSource(" + this.charset + ")";
    }
  }
  
  static class CharSequenceCharSource
    extends CharSource
  {
    private static final Splitter LINE_SPLITTER = Splitter.onPattern("\r\n|\n|\r");
    private final CharSequence seq;
    
    protected CharSequenceCharSource(CharSequence paramCharSequence)
    {
      this.seq = ((CharSequence)Preconditions.checkNotNull(paramCharSequence));
    }
    
    private Iterable<String> lines()
    {
      return new CharSource.CharSequenceCharSource.1(this);
    }
    
    public boolean isEmpty()
    {
      return this.seq.length() == 0;
    }
    
    public long length()
    {
      return this.seq.length();
    }
    
    public Optional<Long> lengthIfKnown()
    {
      return Optional.of(Long.valueOf(this.seq.length()));
    }
    
    public Reader openStream()
    {
      return new CharSequenceReader(this.seq);
    }
    
    public String read()
    {
      return this.seq.toString();
    }
    
    public String readFirstLine()
    {
      Iterator localIterator = lines().iterator();
      if (localIterator.hasNext()) {
        return (String)localIterator.next();
      }
      return null;
    }
    
    public ImmutableList<String> readLines()
    {
      return ImmutableList.copyOf(lines());
    }
    
    public <T> T readLines(LineProcessor<T> paramLineProcessor)
      throws IOException
    {
      Iterator localIterator = lines().iterator();
      while ((localIterator.hasNext()) && (paramLineProcessor.processLine((String)localIterator.next()))) {}
      return paramLineProcessor.getResult();
    }
    
    public String toString()
    {
      return "CharSource.wrap(" + Ascii.truncate(this.seq, 30, "...") + ")";
    }
  }
  
  static final class ConcatenatedCharSource
    extends CharSource
  {
    private final Iterable<? extends CharSource> sources;
    
    ConcatenatedCharSource(Iterable<? extends CharSource> paramIterable)
    {
      this.sources = ((Iterable)Preconditions.checkNotNull(paramIterable));
    }
    
    public boolean isEmpty()
      throws IOException
    {
      Iterator localIterator = this.sources.iterator();
      while (localIterator.hasNext()) {
        if (!((CharSource)localIterator.next()).isEmpty()) {
          return false;
        }
      }
      return true;
    }
    
    public long length()
      throws IOException
    {
      Iterator localIterator = this.sources.iterator();
      for (long l = 0L; localIterator.hasNext(); l = ((CharSource)localIterator.next()).length() + l) {}
      return l;
    }
    
    public Optional<Long> lengthIfKnown()
    {
      Iterator localIterator = this.sources.iterator();
      Optional localOptional;
      for (long l = 0L; localIterator.hasNext(); l = ((Long)localOptional.get()).longValue() + l)
      {
        localOptional = ((CharSource)localIterator.next()).lengthIfKnown();
        if (!localOptional.isPresent()) {
          return Optional.absent();
        }
      }
      return Optional.of(Long.valueOf(l));
    }
    
    public Reader openStream()
      throws IOException
    {
      return new MultiReader(this.sources.iterator());
    }
    
    public String toString()
    {
      return "CharSource.concat(" + this.sources + ")";
    }
  }
  
  static final class EmptyCharSource
    extends CharSource.CharSequenceCharSource
  {
    private static final EmptyCharSource INSTANCE = new EmptyCharSource();
    
    private EmptyCharSource()
    {
      super();
    }
    
    public String toString()
    {
      return "CharSource.empty()";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.CharSource
 * JD-Core Version:    0.7.0.1
 */