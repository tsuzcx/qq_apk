package gameloginsdk;

import b.a.f;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.eg;

class i
  extends p
{
  public i(GameLogin paramGameLogin, long paramLong, JceStruct paramJceStruct)
  {
    super(paramLong, paramJceStruct);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.f != null)
    {
      CallbackAppidTypeStruct localCallbackAppidTypeStruct = new CallbackAppidTypeStruct();
      localCallbackAppidTypeStruct.errMsg = GameLogin.a(this.a, paramInt1);
      this.a.f.onRespCallback(paramInt1, paramInt2, 0, localCallbackAppidTypeStruct);
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
      paramJceStruct.append("回包超时  httpGetAppidTypeCallback   retCode : ");
      paramJceStruct.append(paramInt3);
      paramJceStruct.toString();
      a(paramInt3, (int)this.d);
      return;
    }
    paramJceStruct = (f)paramJceStruct;
    paramInt1 = eg.a;
    paramInt1 = paramJceStruct.b;
    long l = paramJceStruct.a;
    Object localObject = paramJceStruct.c;
    if (paramInt3 == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCGameAppid url : ");
      ((StringBuilder)localObject).append(paramJceStruct.c);
      ((StringBuilder)localObject).toString();
      if (!this.a.g.a(paramJceStruct.a))
      {
        paramInt1 = eg.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("忽略这个包，因为没收到过包的reqid : ");
        ((StringBuilder)localObject).append(paramJceStruct.a);
        ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("忽略这个包，因为没收到过SCGameAppid包的reqid : ");
        ((StringBuilder)localObject).append(paramJceStruct.a);
        ((StringBuilder)localObject).toString();
        return;
      }
      this.b = 0;
      if (this.a.f != null)
      {
        localObject = new CallbackAppidTypeStruct();
        ((CallbackAppidTypeStruct)localObject).appidType = j.a(paramJceStruct.b);
        ((CallbackAppidTypeStruct)localObject).url = paramJceStruct.c;
        this.a.f.onRespCallback(paramInt3, (int)this.d, 0, localObject);
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
          paramJceStruct.append("resendGetFlowType retCode : ");
          paramJceStruct.append(paramInt3);
          paramJceStruct.toString();
          this.a.c(this);
        }
      }
      else
      {
        paramJceStruct = new StringBuilder();
        paramJceStruct.append("httpGetAppidTypeCallback --- retCode = ");
        paramJceStruct.append(paramInt3);
        paramJceStruct.toString();
        a(paramInt3, (int)this.d);
        this.b = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.i
 * JD-Core Version:    0.7.0.1
 */