package gameloginsdk;

import b.a.g;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.eg;
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
      paramInt1 = eg.a;
      a(paramInt3, (int)this.d);
      return;
    }
    if (paramInt3 == -50004)
    {
      paramInt1 = eg.a;
      paramJceStruct = new StringBuilder();
      paramJceStruct.append("回包超时  gameLoginCallback   retCode : ");
      paramJceStruct.append(paramInt3);
      paramJceStruct.toString();
      a(paramInt3, (int)this.d);
      return;
    }
    paramJceStruct = (g)paramJceStruct;
    paramInt1 = eg.a;
    long l = paramJceStruct.a;
    paramInt1 = paramJceStruct.b;
    l = paramJceStruct.c;
    if (paramInt3 == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SCGameLogin timestamp : ");
      localStringBuilder.append(paramJceStruct.c);
      localStringBuilder.toString();
      if (!this.a.g.a(paramJceStruct.a))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("忽略这个包，因为没收到过SCConfirm包的reqid : ");
        localStringBuilder.append(paramJceStruct.a);
        localStringBuilder.toString();
        paramInt1 = eg.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("忽略这个包，因为没收到过包的reqid : ");
        localStringBuilder.append(paramJceStruct.a);
        localStringBuilder.toString();
        return;
      }
      this.b = 0;
      if (GameLogin.g(this.a).get() < paramJceStruct.c) {
        GameLogin.g(this.a).set(paramJceStruct.c);
      }
      GameLogin.h(this.a);
      if (this.a.f != null)
      {
        paramJceStruct = new CallbackGameLoginStruct();
        this.a.f.onRespCallback(paramInt3, (int)this.d, 1, paramJceStruct);
      }
    }
    else
    {
      paramInt1 = this.b + 1;
      this.b = paramInt1;
      if (paramInt1 < 3)
      {
        if (this.c != null)
        {
          paramJceStruct = new StringBuilder();
          paramJceStruct.append("resendGameLoginInfo retCode : ");
          paramJceStruct.append(paramInt3);
          paramJceStruct.toString();
          this.a.a(this);
        }
      }
      else
      {
        paramJceStruct = new StringBuilder();
        paramJceStruct.append("sendGameLoginInfo --- retCode = ");
        paramJceStruct.append(paramInt3);
        paramJceStruct.toString();
        a(paramInt3, (int)this.d);
        this.b = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.h
 * JD-Core Version:    0.7.0.1
 */