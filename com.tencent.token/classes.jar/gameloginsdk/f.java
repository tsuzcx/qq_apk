package gameloginsdk;

import com.tencent.token.ajj;
import com.tencent.token.arv;
import com.tencent.token.km;

class f
  implements Runnable
{
  f(GameLogin paramGameLogin, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6) {}
  
  public void run()
  {
    km localkm = new km();
    localkm.b = 18L;
    localkm.a = GameLogin.j(this.i);
    localkm.g = this.a;
    localkm.f = this.b;
    localkm.j = this.c;
    localkm.i = this.d;
    localkm.c = this.e;
    localkm.d = this.f;
    localkm.k = GameLogin.k(this.i);
    localkm.h = this.g;
    localkm.o = arv.a(GameLogin.a(this.i, this.h));
    this.i.j.a(1, 10051, localkm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.f
 * JD-Core Version:    0.7.0.1
 */