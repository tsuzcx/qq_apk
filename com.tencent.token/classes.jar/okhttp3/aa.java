package okhttp3;

import com.tencent.token.fc;
import java.io.Closeable;
import java.io.InputStream;
import javax.annotation.Nullable;
import okio.c;
import okio.e;

public abstract class aa
  implements Closeable
{
  public static aa a(@Nullable u paramu, final long paramLong, e parame)
  {
    if (parame != null) {
      new aa()
      {
        public long a()
        {
          return paramLong;
        }
        
        public e c()
        {
          return this.c;
        }
      };
    }
    throw new NullPointerException("source == null");
  }
  
  public static aa a(@Nullable u paramu, byte[] paramArrayOfByte)
  {
    c localc = new c().b(paramArrayOfByte);
    return a(paramu, paramArrayOfByte.length, localc);
  }
  
  public abstract long a();
  
  public final InputStream b()
  {
    return c().f();
  }
  
  public abstract e c();
  
  public void close()
  {
    fc.a(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.aa
 * JD-Core Version:    0.7.0.1
 */