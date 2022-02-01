package okhttp3;

import com.tencent.token.fh;
import com.tencent.token.fi;
import java.io.Closeable;
import java.io.Flushable;

public final class c
  implements Closeable, Flushable
{
  final fi a;
  final fh b;
  
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