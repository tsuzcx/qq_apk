package okhttp3;

import com.tencent.token.gn;
import java.io.Closeable;
import java.io.InputStream;
import javax.annotation.Nullable;
import okio.f;
import okio.i;

public abstract class av
  implements Closeable
{
  public static av a(@Nullable aj paramaj, long paramLong, i parami)
  {
    if (parami == null) {
      throw new NullPointerException("source == null");
    }
    return new aw(paramaj, paramLong, parami);
  }
  
  public static av a(@Nullable aj paramaj, byte[] paramArrayOfByte)
  {
    f localf = new f().b(paramArrayOfByte);
    return a(paramaj, paramArrayOfByte.length, localf);
  }
  
  public abstract long a();
  
  public final InputStream b()
  {
    return c().f();
  }
  
  public abstract i c();
  
  public void close()
  {
    gn.a(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.av
 * JD-Core Version:    0.7.0.1
 */