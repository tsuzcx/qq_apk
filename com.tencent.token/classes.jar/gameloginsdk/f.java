package gameloginsdk;

import com.tencent.token.agx;
import com.tencent.token.apa;
import com.tencent.token.ju;

class f
  implements Runnable
{
  f(GameLogin paramGameLogin, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6) {}
  
  public void run()
  {
    ju localju = new ju();
    localju.b = 18L;
    localju.a = GameLogin.j(this.i);
    localju.g = this.a;
    localju.f = this.b;
    localju.j = this.c;
    localju.i = this.d;
    localju.c = this.e;
    localju.d = this.f;
    localju.k = GameLogin.k(this.i);
    localju.h = this.g;
    localju.o = apa.a(GameLogin.a(this.i, this.h));
    this.i.j.a(1, 10051, localju);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.f
 * JD-Core Version:    0.7.0.1
 */