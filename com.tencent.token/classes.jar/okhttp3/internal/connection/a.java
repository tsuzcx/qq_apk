package okhttp3.internal.connection;

import com.tencent.token.fo;
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
    fo localfo = (fo)parama;
    x localx = localfo.a();
    f localf = localfo.f();
    if (!localx.b().equals("GET")) {}
    for (boolean bool = true;; bool = false) {
      return localfo.a(localx, localf, localf.a(this.a, parama, bool), localf.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.a
 * JD-Core Version:    0.7.0.1
 */