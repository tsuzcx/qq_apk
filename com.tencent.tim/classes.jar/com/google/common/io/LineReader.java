package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;

@Beta
@GwtIncompatible
public final class LineReader
{
  private final char[] buf = this.cbuf.array();
  private final CharBuffer cbuf = CharStreams.createBuffer();
  private final LineBuffer lineBuf = new LineReader.1(this);
  private final Queue<String> lines = new LinkedList();
  private final Readable readable;
  private final Reader reader;
  
  public LineReader(Readable paramReadable)
  {
    this.readable = ((Readable)Preconditions.checkNotNull(paramReadable));
    if ((paramReadable instanceof Reader)) {}
    for (paramReadable = (Reader)paramReadable;; paramReadable = null)
    {
      this.reader = paramReadable;
      return;
    }
  }
  
  @CanIgnoreReturnValue
  public String readLine()
    throws IOException
  {
    for (;;)
    {
      if (this.lines.peek() == null)
      {
        this.cbuf.clear();
        if (this.reader == null) {
          break label70;
        }
      }
      label70:
      for (int i = this.reader.read(this.buf, 0, this.buf.length); i == -1; i = this.readable.read(this.cbuf))
      {
        this.lineBuf.finish();
        return (String)this.lines.poll();
      }
      this.lineBuf.add(this.buf, 0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.LineReader
 * JD-Core Version:    0.7.0.1
 */