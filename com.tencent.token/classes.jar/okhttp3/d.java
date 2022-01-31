package okhttp3;

import com.tencent.token.gw;
import com.tencent.token.gz;
import java.io.Closeable;
import java.io.Flushable;

public final class d
  implements Closeable, Flushable
{
  final gz a;
  final gw b;
  
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
 * Qualified Name:     okhttp3.d
 * JD-Core Version:    0.7.0.1
 */