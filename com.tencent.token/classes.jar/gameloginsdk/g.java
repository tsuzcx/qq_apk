package gameloginsdk;

import b.a.e;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.eg;

class g
  extends p
{
  public g(GameLogin paramGameLogin, long paramLong, JceStruct paramJceStruct)
  {
    super(paramLong, paramJceStruct);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.f != null)
    {
      CallbackGameConfirmStruct localCallbackGameConfirmStruct = new CallbackGameConfirmStruct();
      localCallbackGameConfirmStruct.errMsg = GameLogin.a(this.a, paramInt1);
      this.a.f.onRespCallback(paramInt1, paramInt2, 2, localCallbackGameConfirmStruct);
    }
    GameLogin.i(this.a);
    this.a.b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null)
    {
      paramInt1 = eg.a;
      paramJceStruct = new StringBuilder();
      paramJceStruct.append("resp == null  gameConfirmCallback   retCode : ");
      paramJceStruct.append(paramInt3);
      paramJceStruct.toString();
      a(paramInt3, (int)this.d);
      return;
    }
    if (paramInt3 == -50004)
    {
      paramInt1 = eg.a;
      paramJceStruct = new StringBuilder();
      paramJceStruct.append("回包超时  gameConfirmCallback   retCode : ");
      paramJceStruct.append(paramInt3);
      paramJceStruct.toString();
      a(paramInt3, (int)this.d);
      return;
    }
    paramJceStruct = (e)paramJceStruct;
    paramInt1 = eg.a;
    long l = paramJceStruct.a;
    l = paramJceStruct.b;
    paramInt1 = paramJceStruct.d;
    paramInt1 = paramJceStruct.e;
    Object localObject = paramJceStruct.c;
    if (paramInt3 == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCConfirm appid : ");
      ((StringBuilder)localObject).append(paramJceStruct.b);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCConfirm qq : ");
      ((StringBuilder)localObject).append(paramJceStruct.c);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCConfirm code : ");
      ((StringBuilder)localObject).append(paramJceStruct.d);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCConfirm playerstatus : ");
      ((StringBuilder)localObject).append(paramJceStruct.e);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCConfirm wording : ");
      ((StringBuilder)localObject).append(paramJceStruct.f);
      ((StringBuilder)localObject).toString();
      if (!this.a.g.a(paramJceStruct.a))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("忽略这个包，因为没收到过SCConfirm包的reqid : ");
        ((StringBuilder)localObject).append(paramJceStruct.a);
        ((StringBuilder)localObject).toString();
        paramInt1 = eg.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("忽略这个包，因为没收到过SCConfirm包的reqid : ");
        ((StringBuilder)localObject).append(paramJceStruct.a);
        ((StringBuilder)localObject).toString();
        return;
      }
      if (this.a.f != null)
      {
        localObject = new CallbackGameConfirmStruct();
        ((CallbackGameConfirmStruct)localObject).appid = paramJceStruct.b;
        ((CallbackGameConfirmStruct)localObject).uin = paramJceStruct.c;
        ((CallbackGameConfirmStruct)localObject).wording = paramJceStruct.f;
        ((CallbackGameConfirmStruct)localObject).playerStatus = j.b(paramJceStruct.e);
        this.a.f.onRespCallback(GameLogin.a(this.a, paramInt3, paramJceStruct.d), (int)this.d, 2, localObject);
      }
      this.b = 0;
      GameLogin.i(this.a);
      this.a.b();
      return;
    }
    paramInt1 = this.b + 1;
    this.b = paramInt1;
    if (paramInt1 < 3)
    {
      if (this.c != null)
      {
        paramJceStruct = new StringBuilder();
        paramJceStruct.append("resendGameConfirm retCode : ");
        paramJceStruct.append(paramInt3);
        paramJceStruct.toString();
        this.a.b(this);
      }
    }
    else
    {
      paramJceStruct = new StringBuilder();
      paramJceStruct.append("sendGameConfirm --- retCode = ");
      paramJceStruct.append(paramInt3);
      paramJceStruct.toString();
      a(paramInt3, (int)this.d);
      this.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.g
 * JD-Core Version:    0.7.0.1
 */