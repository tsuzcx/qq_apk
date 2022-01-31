package gameloginsdk;

import b.a.h;
import d.b.b;
import tmsdk.common.c.a.d;

class f
  implements Runnable
{
  f(GameLogin paramGameLogin, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6) {}
  
  public void run()
  {
    h localh = new h();
    localh.b = 18L;
    localh.a = GameLogin.j(this.i);
    localh.g = this.a;
    localh.f = this.b;
    localh.j = this.c;
    localh.i = this.d;
    localh.c = this.e;
    localh.d = this.f;
    localh.k = GameLogin.k(this.i);
    localh.h = this.g;
    localh.o = d.a(GameLogin.a(this.i, this.h));
    this.i.j.a(1, 10051, localh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.f
 * JD-Core Version:    0.7.0.1
 */