package okhttp3.internal.http2;

import com.tencent.token.gm;
import java.io.IOException;
import java.util.Set;
import okio.f;

class m
  extends gm
{
  m(h paramh, String paramString, Object[] paramArrayOfObject, int paramInt1, f paramf, int paramInt2, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.f.h.a(this.a, this.c, this.d, this.e);
      if (bool) {
        this.f.o.a(this.a, ErrorCode.CANCEL);
      }
      if ((bool) || (this.e)) {
        synchronized (this.f)
        {
          this.f.q.remove(Integer.valueOf(this.a));
          return;
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.m
 * JD-Core Version:    0.7.0.1
 */