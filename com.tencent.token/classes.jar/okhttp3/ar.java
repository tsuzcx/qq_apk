package okhttp3;

import com.tencent.token.gn;
import javax.annotation.Nullable;
import okio.h;

public abstract class ar
{
  public static ar a(@Nullable aj paramaj, byte[] paramArrayOfByte)
  {
    return a(paramaj, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ar a(@Nullable aj paramaj, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("content == null");
    }
    gn.a(paramArrayOfByte.length, paramInt1, paramInt2);
    return new as(paramaj, paramInt2, paramArrayOfByte, paramInt1);
  }
  
  @Nullable
  public abstract aj a();
  
  public abstract void a(h paramh);
  
  public long b()
  {
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.ar
 * JD-Core Version:    0.7.0.1
 */