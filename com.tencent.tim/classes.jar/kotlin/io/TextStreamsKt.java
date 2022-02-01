package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="TextStreamsKt")
public final class TextStreamsKt
{
  @InlineOnly
  private static final BufferedReader buffered(@NotNull Reader paramReader, int paramInt)
  {
    if ((paramReader instanceof BufferedReader)) {
      return (BufferedReader)paramReader;
    }
    return new BufferedReader(paramReader, paramInt);
  }
  
  @InlineOnly
  private static final BufferedWriter buffered(@NotNull Writer paramWriter, int paramInt)
  {
    if ((paramWriter instanceof BufferedWriter)) {
      return (BufferedWriter)paramWriter;
    }
    return new BufferedWriter(paramWriter, paramInt);
  }
  
  public static final long copyTo(@NotNull Reader paramReader, @NotNull Writer paramWriter, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramReader, "$this$copyTo");
    Intrinsics.checkParameterIsNotNull(paramWriter, "out");
    long l = 0L;
    char[] arrayOfChar = new char[paramInt];
    for (paramInt = paramReader.read(arrayOfChar); paramInt >= 0; paramInt = paramReader.read(arrayOfChar))
    {
      paramWriter.write(arrayOfChar, 0, paramInt);
      l += paramInt;
    }
    return l;
  }
  
  public static final void forEachLine(@NotNull Reader paramReader, @NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramReader, "$this$forEachLine");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    if ((paramReader instanceof BufferedReader)) {
      paramReader = (BufferedReader)paramReader;
    }
    Closeable localCloseable;
    Throwable localThrowable;
    for (;;)
    {
      localCloseable = (Closeable)paramReader;
      localThrowable = (Throwable)null;
      paramReader = localThrowable;
      try
      {
        Iterator localIterator = lineSequence((BufferedReader)localCloseable).iterator();
        for (;;)
        {
          paramReader = localThrowable;
          if (!localIterator.hasNext()) {
            break;
          }
          paramReader = localThrowable;
          paramFunction1.invoke(localIterator.next());
        }
        paramReader = new BufferedReader(paramReader, 8192);
      }
      catch (Throwable paramFunction1)
      {
        paramReader = paramFunction1;
        throw paramFunction1;
      }
      finally
      {
        CloseableKt.closeFinally(localCloseable, paramReader);
      }
    }
    paramReader = localThrowable;
    paramFunction1 = Unit.INSTANCE;
    CloseableKt.closeFinally(localCloseable, localThrowable);
  }
  
  @NotNull
  public static final Sequence<String> lineSequence(@NotNull BufferedReader paramBufferedReader)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedReader, "$this$lineSequence");
    return SequencesKt.constrainOnce((Sequence)new LinesSequence(paramBufferedReader));
  }
  
  @NotNull
  public static final byte[] readBytes(@NotNull URL paramURL)
  {
    Intrinsics.checkParameterIsNotNull(paramURL, "$this$readBytes");
    Closeable localCloseable = (Closeable)paramURL.openStream();
    Throwable localThrowable1 = (Throwable)null;
    paramURL = localThrowable1;
    try
    {
      Object localObject2 = (InputStream)localCloseable;
      paramURL = localThrowable1;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
      paramURL = localThrowable1;
      localObject2 = ByteStreamsKt.readBytes((InputStream)localObject2);
      return localObject2;
    }
    catch (Throwable localThrowable2)
    {
      paramURL = localThrowable2;
      throw localThrowable2;
    }
    finally
    {
      CloseableKt.closeFinally(localCloseable, paramURL);
    }
  }
  
  @NotNull
  public static final List<String> readLines(@NotNull Reader paramReader)
  {
    Intrinsics.checkParameterIsNotNull(paramReader, "$this$readLines");
    ArrayList localArrayList = new ArrayList();
    forEachLine(paramReader, (Function1)new TextStreamsKt.readLines.1(localArrayList));
    return (List)localArrayList;
  }
  
  @NotNull
  public static final String readText(@NotNull Reader paramReader)
  {
    Intrinsics.checkParameterIsNotNull(paramReader, "$this$readText");
    StringWriter localStringWriter = new StringWriter();
    copyTo$default(paramReader, (Writer)localStringWriter, 0, 2, null);
    paramReader = localStringWriter.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramReader, "buffer.toString()");
    return paramReader;
  }
  
  @InlineOnly
  private static final String readText(@NotNull URL paramURL, Charset paramCharset)
  {
    return new String(readBytes(paramURL), paramCharset);
  }
  
  @InlineOnly
  private static final StringReader reader(@NotNull String paramString)
  {
    return new StringReader(paramString);
  }
  
  public static final <T> T useLines(@NotNull Reader paramReader, @NotNull Function1<? super Sequence<String>, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramReader, "$this$useLines");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    if ((paramReader instanceof BufferedReader)) {
      paramReader = (BufferedReader)paramReader;
    }
    Closeable localCloseable;
    for (;;)
    {
      localCloseable = (Closeable)paramReader;
      Throwable localThrowable = (Throwable)null;
      paramReader = localThrowable;
      try
      {
        paramFunction1 = paramFunction1.invoke(lineSequence((BufferedReader)localCloseable));
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
          CloseableKt.closeFinally(localCloseable, localThrowable);
        }
        for (;;)
        {
          InlineMarker.finallyEnd(1);
          return paramFunction1;
          paramReader = new BufferedReader(paramReader, 8192);
          break;
          localCloseable.close();
        }
        CloseableKt.closeFinally(localCloseable, paramReader);
      }
      catch (Throwable paramFunction1)
      {
        paramReader = paramFunction1;
        throw paramFunction1;
      }
      finally
      {
        InlineMarker.finallyStart(1);
        if (!PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {}
      }
    }
    for (;;)
    {
      InlineMarker.finallyEnd(1);
      throw paramFunction1;
      if (paramReader == null) {
        localCloseable.close();
      } else {
        try
        {
          localCloseable.close();
        }
        catch (Throwable paramReader) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.io.TextStreamsKt
 * JD-Core Version:    0.7.0.1
 */