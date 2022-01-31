package gameloginsdk;

import b.a.f;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.fm;

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
          new StringBuilder().append("回包超时  httpGetAppidTypeCallback   retCode : ").append(paramInt3).toString();
          a(paramInt3, (int)this.d);
          return;
        }
        paramJceStruct = (f)paramJceStruct;
        paramInt1 = fm.a;
        paramInt1 = paramJceStruct.b;
        long l = paramJceStruct.a;
        localObject = paramJceStruct.c;
        if (paramInt3 != 0) {
          break;
        }
        new StringBuilder().append("SCGameAppid url : ").append(paramJceStruct.c).toString();
        if (!this.a.g.a(paramJceStruct.a))
        {
          paramInt1 = fm.a;
          new StringBuilder().append("忽略这个包，因为没收到过包的reqid : ").append(paramJceStruct.a).toString();
          new StringBuilder().append("忽略这个包，因为没收到过SCGameAppid包的reqid : ").append(paramJceStruct.a).toString();
          return;
        }
        this.b = 0;
      } while (this.a.f == null);
      Object localObject = new CallbackAppidTypeStruct();
      ((CallbackAppidTypeStruct)localObject).appidType = j.a(paramJceStruct.b);
      ((CallbackAppidTypeStruct)localObject).url = paramJceStruct.c;
      this.a.f.onRespCallback(paramInt3, (int)this.d, 0, localObject);
      return;
      paramInt1 = this.b + 1;
      this.b = paramInt1;
      if (paramInt1 >= 3) {
        break;
      }
    } while (this.c == null);
    new StringBuilder().append("resendGetFlowType retCode : ").append(paramInt3).toString();
    this.a.c(this);
    return;
    new StringBuilder().append("httpGetAppidTypeCallback --- retCode = ").append(paramInt3).toString();
    a(paramInt3, (int)this.d);
    this.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.i
 * JD-Core Version:    0.7.0.1
 */