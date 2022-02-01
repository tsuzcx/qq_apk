package okhttp3;

import com.tencent.token.ff;
import javax.annotation.Nullable;
import okio.d;

public abstract class y
{
  public static y a(@Nullable u paramu, byte[] paramArrayOfByte)
  {
    return a(paramu, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static y a(@Nullable u paramu, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      ff.a(paramArrayOfByte.length, paramInt1, paramInt2);
      new y()
      {
        @Nullable
        public u a()
        {
          return y.this;
        }
        
        public void a(d paramAnonymousd)
        {
          paramAnonymousd.c(paramArrayOfByte, paramInt1, paramInt2);
        }
        
        public long b()
        {
          return paramInt2;
        }
      };
    }
    throw new NullPointerException("content == null");
  }
  
  @Nullable
  public abstract u a();
  
  public abstract void a(d paramd);
  
  public long b()
  {
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.y
 * JD-Core Version:    0.7.0.1
 */