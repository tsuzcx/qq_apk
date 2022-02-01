package okhttp3.internal.connection;

import com.tencent.token.fp;
import okhttp3.t;
import okhttp3.t.a;
import okhttp3.v;
import okhttp3.x;
import okhttp3.z;

public final class a
  implements t
{
  public final v a;
  
  public a(v paramv)
  {
    this.a = paramv;
  }
  
  public z a(t.a parama)
  {
    fp localfp = (fp)parama;
    x localx = localfp.a();
    f localf = localfp.f();
    boolean bool = localx.b().equals("GET");
    return localfp.a(localx, localf, localf.a(this.a, parama, bool ^ true), localf.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.a
 * JD-Core Version:    0.7.0.1
 */