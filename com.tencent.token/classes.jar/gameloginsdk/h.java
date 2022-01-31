package gameloginsdk;

import b.a.g;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.fm;
import java.util.concurrent.atomic.AtomicLong;

class h
  extends p
{
  public h(GameLogin paramGameLogin, long paramLong, JceStruct paramJceStruct)
  {
    super(paramLong, paramJceStruct);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.f != null)
    {
      CallbackGameLoginStruct localCallbackGameLoginStruct = new CallbackGameLoginStruct();
      localCallbackGameLoginStruct.errMsg = GameLogin.a(this.a, paramInt1);
      this.a.f.onRespCallback(paramInt1, paramInt2, 1, localCallbackGameLoginStruct);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null)
    {
      paramInt1 = fm.a;
      a(paramInt3, (int)this.d);
    }
    do
    {
      do
      {
        return;
        if (paramInt3 == -50004)
        {
          paramInt1 = fm.a;
          new StringBuilder().append("回包超时  gameLoginCallback   retCode : ").append(paramInt3).toString();
          a(paramInt3, (int)this.d);
          return;
        }
        paramJceStruct = (g)paramJceStruct;
        paramInt1 = fm.a;
        long l = paramJceStruct.a;
        paramInt1 = paramJceStruct.b;
        l = paramJceStruct.c;
        if (paramInt3 != 0) {
          break;
        }
        new StringBuilder().append("SCGameLogin timestamp : ").append(paramJceStruct.c).toString();
        if (!this.a.g.a(paramJceStruct.a))
        {
          new StringBuilder().append("忽略这个包，因为没收到过SCConfirm包的reqid : ").append(paramJceStruct.a).toString();
          paramInt1 = fm.a;
          new StringBuilder().append("忽略这个包，因为没收到过包的reqid : ").append(paramJceStruct.a).toString();
          return;
        }
        this.b = 0;
        if (GameLogin.g(this.a).get() < paramJceStruct.c) {
          GameLogin.g(this.a).set(paramJceStruct.c);
        }
        GameLogin.h(this.a);
      } while (this.a.f == null);
      paramJceStruct = new CallbackGameLoginStruct();
      this.a.f.onRespCallback(paramInt3, (int)this.d, 1, paramJceStruct);
      return;
      paramInt1 = this.b + 1;
      this.b = paramInt1;
      if (paramInt1 >= 3) {
        break;
      }
    } while (this.c == null);
    new StringBuilder().append("resendGameLoginInfo retCode : ").append(paramInt3).toString();
    this.a.a(this);
    return;
    new StringBuilder().append("sendGameLoginInfo --- retCode = ").append(paramInt3).toString();
    a(paramInt3, (int)this.d);
    this.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.h
 * JD-Core Version:    0.7.0.1
 */