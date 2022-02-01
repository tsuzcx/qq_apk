package gameloginsdk;

import com.tencent.token.agy;
import com.tencent.token.apb;
import com.tencent.token.jv;

class f
  implements Runnable
{
  f(GameLogin paramGameLogin, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6) {}
  
  public void run()
  {
    jv localjv = new jv();
    localjv.b = 18L;
    localjv.a = GameLogin.j(this.i);
    localjv.g = this.a;
    localjv.f = this.b;
    localjv.j = this.c;
    localjv.i = this.d;
    localjv.c = this.e;
    localjv.d = this.f;
    localjv.k = GameLogin.k(this.i);
    localjv.h = this.g;
    localjv.o = apb.a(GameLogin.a(this.i, this.h));
    this.i.j.a(1, 10051, localjv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.f
 * JD-Core Version:    0.7.0.1
 */