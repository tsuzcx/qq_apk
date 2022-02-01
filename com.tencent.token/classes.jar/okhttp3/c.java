package okhttp3;

import com.tencent.token.fg;
import com.tencent.token.fh;
import java.io.Closeable;
import java.io.Flushable;

public final class c
  implements Closeable, Flushable
{
  final fh a;
  final fg b;
  
  public void close()
  {
    this.b.close();
  }
  
  public void flush()
  {
    this.b.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.c
 * JD-Core Version:    0.7.0.1
 */