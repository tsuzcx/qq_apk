package gameloginsdk;

import android.os.Handler;
import android.util.Pair;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.aih;
import com.tencent.token.aij;
import com.tencent.token.aqv;
import com.tencent.token.ju;
import com.tencent.token.jy;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

class c
  implements aij
{
  c(GameLogin paramGameLogin) {}
  
  public Pair a(int paramInt1, int paramInt2, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null)
    {
      paramInt1 = aih.a;
      return null;
    }
    paramJceStruct = (jy)paramJceStruct;
    Object localObject = paramJceStruct.k;
    if ((!GameLogin.a(this.a).b((byte[])localObject)) && (GameLogin.b(this.a).contains(paramJceStruct.o)))
    {
      paramInt1 = aih.a;
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
      aqv.a().a(paramJceStruct.o);
      l = paramJceStruct.m;
      if (GameLogin.c(this.a).get() < l) {
        GameLogin.c(this.a).set(l);
      }
      GameLogin.d(this.a).a(paramJceStruct.k);
      GameLogin.a(this.a).a(paramJceStruct.k);
      GameLogin.e(this.a).push(Long.valueOf(paramJceStruct.b));
      this.a.i.postDelayed(new d(this), this.a.a);
      new StringBuilder("SCPushGameInfo appid : ").append(paramJceStruct.b);
      new StringBuilder("SCPushGameInfo qq : ").append(paramJceStruct.c);
      new StringBuilder("SCPushGameInfo schemeflag : ").append(paramJceStruct.d);
      new StringBuilder("SCPushGameInfo expirttime : ").append(paramJceStruct.f);
      new StringBuilder("SCPushGameInfo player : ").append(paramJceStruct.g);
      new StringBuilder("SCPushGameInfo world : ").append(paramJceStruct.h);
      new StringBuilder("SCPushGameInfo scene : ").append(paramJceStruct.i);
      new StringBuilder("SCPushGameInfo name : ").append(paramJceStruct.j);
      new StringBuilder("SCPushGameInfo md5 : ").append(paramJceStruct.l);
      new StringBuilder("SCPushGameInfo qrcodemd5 : ").append(paramJceStruct.o);
      new StringBuilder("SCPushGameInfo timestamp : ").append(paramJceStruct.m);
      new StringBuilder("SCPushGameInfo session : ").append(GameLogin.a(this.a, paramJceStruct.k));
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
      paramInt1 = aih.a;
    }
    return new Pair(Integer.valueOf(51), new ju(paramJceStruct.a, paramJceStruct.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.c
 * JD-Core Version:    0.7.0.1
 */