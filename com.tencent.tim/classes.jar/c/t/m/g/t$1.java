package c.t.m.g;

import android.os.Bundle;

final class t$1
  implements aj.c
{
  t$1(t paramt, Bundle paramBundle, aj.b paramb) {}
  
  public final void a(String paramString)
  {
    this.a.putString("msg_suc", paramString);
    if (this.b != null) {
      this.b.a(paramString);
    }
  }
  
  public final void b(String paramString)
  {
    this.a.putString("msg_fail", paramString);
    if (this.b != null) {
      this.b.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.t.1
 * JD-Core Version:    0.7.0.1
 */