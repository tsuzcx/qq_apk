package okhttp3.internal.connection;

import com.tencent.token.hi;
import okhttp3.ah;
import okhttp3.ai;
import okhttp3.ak;
import okhttp3.ap;
import okhttp3.at;

public final class a
  implements ah
{
  public final ak a;
  
  public a(ak paramak)
  {
    this.a = paramak;
  }
  
  public at a(ai paramai)
  {
    hi localhi = (hi)paramai;
    ap localap = localhi.a();
    g localg = localhi.f();
    if (!localap.b().equals("GET")) {}
    for (boolean bool = true;; bool = false) {
      return localhi.a(localap, localg, localg.a(this.a, paramai, bool), localg.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.a
 * JD-Core Version:    0.7.0.1
 */