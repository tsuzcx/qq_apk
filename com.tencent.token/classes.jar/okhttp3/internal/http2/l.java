package okhttp3.internal.http2;

import com.tencent.token.gm;
import java.io.IOException;
import java.util.List;
import java.util.Set;

class l
  extends gm
{
  l(h paramh, String paramString, Object[] paramArrayOfObject, int paramInt, List paramList, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void c()
  {
    boolean bool = this.e.h.a(this.a, this.c, this.d);
    if (bool) {}
    try
    {
      this.e.o.a(this.a, ErrorCode.CANCEL);
      if ((bool) || (this.d)) {
        synchronized (this.e)
        {
          this.e.q.remove(Integer.valueOf(this.a));
          return;
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.l
 * JD-Core Version:    0.7.0.1
 */