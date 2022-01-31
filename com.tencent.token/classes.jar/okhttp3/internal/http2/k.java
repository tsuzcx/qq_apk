package okhttp3.internal.http2;

import com.tencent.token.gm;
import java.io.IOException;
import java.util.List;
import java.util.Set;

class k
  extends gm
{
  k(h paramh, String paramString, Object[] paramArrayOfObject, int paramInt, List paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void c()
  {
    if (this.d.h.a(this.a, this.c)) {
      try
      {
        this.d.o.a(this.a, ErrorCode.CANCEL);
        synchronized (this.d)
        {
          this.d.q.remove(Integer.valueOf(this.a));
          return;
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.k
 * JD-Core Version:    0.7.0.1
 */