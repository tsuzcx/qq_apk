package gameloginsdk;

import android.os.Handler;
import android.util.Pair;
import b.a.h;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.ee;
import com.tencent.token.eg;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

class c
  implements eg
{
  c(GameLogin paramGameLogin) {}
  
  public Pair a(int paramInt1, int paramInt2, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null)
    {
      paramInt1 = ee.a;
      return null;
    }
    paramJceStruct = (h)paramJceStruct;
    Object localObject = paramJceStruct.k;
    if ((!GameLogin.a(this.a).b((byte[])localObject)) && (GameLogin.b(this.a).contains(paramJceStruct.o)))
    {
      paramInt1 = ee.a;
      localObject = paramJceStruct.c;
      long l = paramJceStruct.b;
      l = paramJceStruct.a;
      paramInt1 = paramJceStruct.d;
      paramInt1 = paramJceStruct.f;
      localObject = paramJceStruct.g;
      localObject = paramJceStruct.h;
      localObject = paramJceStruct.i;
      localObject = paramJceStruct.j;
      GameLogin.a(this.a, paramJceStruct.k);
      localObject = paramJceStruct.l;
      l = paramJceStruct.m;
      GameLogin.b(this.a).remove(paramJceStruct.o);
      tmsdk.common.c.a.a.a().a(paramJceStruct.o);
      l = paramJceStruct.m;
      if (GameLogin.c(this.a).get() < l) {
        GameLogin.c(this.a).set(l);
      }
      GameLogin.d(this.a).a(paramJceStruct.k);
      GameLogin.a(this.a).a(paramJceStruct.k);
      GameLogin.e(this.a).push(Long.valueOf(paramJceStruct.b));
      this.a.i.postDelayed(new d(this), this.a.a);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo appid : ");
      ((StringBuilder)localObject).append(paramJceStruct.b);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo qq : ");
      ((StringBuilder)localObject).append(paramJceStruct.c);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo schemeflag : ");
      ((StringBuilder)localObject).append(paramJceStruct.d);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo expirttime : ");
      ((StringBuilder)localObject).append(paramJceStruct.f);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo player : ");
      ((StringBuilder)localObject).append(paramJceStruct.g);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo world : ");
      ((StringBuilder)localObject).append(paramJceStruct.h);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo scene : ");
      ((StringBuilder)localObject).append(paramJceStruct.i);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo name : ");
      ((StringBuilder)localObject).append(paramJceStruct.j);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo md5 : ");
      ((StringBuilder)localObject).append(paramJceStruct.l);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo qrcodemd5 : ");
      ((StringBuilder)localObject).append(paramJceStruct.o);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo timestamp : ");
      ((StringBuilder)localObject).append(paramJceStruct.m);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SCPushGameInfo session : ");
      ((StringBuilder)localObject).append(GameLogin.a(this.a, paramJceStruct.k));
      ((StringBuilder)localObject).toString();
      if (this.a.f != null)
      {
        localObject = new CallbackPushStruct();
        ((CallbackPushStruct)localObject).appid = GameLogin.f(this.a).a(paramJceStruct.o);
        ((CallbackPushStruct)localObject).uin = paramJceStruct.c;
        ((CallbackPushStruct)localObject).schemeFlag = j.c(paramJceStruct.d);
        ((CallbackPushStruct)localObject).expirtTime = paramJceStruct.f;
        ((CallbackPushStruct)localObject).world = paramJceStruct.h;
        ((CallbackPushStruct)localObject).player = paramJceStruct.g;
        ((CallbackPushStruct)localObject).scene = paramJceStruct.i;
        ((CallbackPushStruct)localObject).gameName = paramJceStruct.j;
        this.a.f.onPush(0, localObject);
      }
    }
    else
    {
      paramInt1 = ee.a;
    }
    return new Pair(Integer.valueOf(51), new b.a.d(paramJceStruct.a, paramJceStruct.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.c
 * JD-Core Version:    0.7.0.1
 */