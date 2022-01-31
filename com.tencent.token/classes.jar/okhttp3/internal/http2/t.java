package okhttp3.internal.http2;

import com.tencent.token.gm;
import com.tencent.token.ih;
import java.io.IOException;

class t
  extends gm
{
  t(s params, String paramString, Object[] paramArrayOfObject, z paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void c()
  {
    try
    {
      this.c.c.b.a(this.a);
      return;
    }
    catch (IOException localIOException1)
    {
      ih.c().a(4, "Http2Connection.Listener failure for " + this.c.c.d, localIOException1);
      try
      {
        this.a.a(ErrorCode.PROTOCOL_ERROR);
        return;
      }
      catch (IOException localIOException2) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.t
 * JD-Core Version:    0.7.0.1
 */