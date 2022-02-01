package gameloginsdk;

import android.os.Handler;
import android.util.Pair;
import b.a.h;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.ed;
import com.tencent.token.ef;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

class c
  implements ef
{
  c(GameLogin paramGameLogin) {}
  
  public Pair a(int paramInt1, int paramInt2, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null)
    {
      paramInt1 = ed.a;
      return null;
    }
    paramJceStruct = (h)paramJceStruct;
    Object localObject = paramJceStruct.k;
    if ((GameLogin.a(this.a).b((byte[])localObject)) || (!GameLogin.b(this.a).contains(paramJceStruct.o))) {
      paramInt1 = ed.a;
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(51), new b.a.d(paramJceStruct.a, paramJceStruct.b));
      paramInt1 = ed.a;
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
      new StringBuilder().append("SCPushGameInfo appid : ").append(paramJceStruct.b).toString();
      new StringBuilder().append("SCPushGameInfo qq : ").append(paramJceStruct.c).toString();
      new StringBuilder().append("SCPushGameInfo schemeflag : ").append(paramJceStruct.d).toString();
      new StringBuilder().append("SCPushGameInfo expirttime : ").append(paramJceStruct.f).toString();
      new StringBuilder().append("SCPushGameInfo player : ").append(paramJceStruct.g).toString();
      new StringBuilder().append("SCPushGameInfo world : ").append(paramJceStruct.h).toString();
      new StringBuilder().append("SCPushGameInfo scene : ").append(paramJceStruct.i).toString();
      new StringBuilder().append("SCPushGameInfo name : ").append(paramJceStruct.j).toString();
      new StringBuilder().append("SCPushGameInfo md5 : ").append(paramJceStruct.l).toString();
      new StringBuilder().append("SCPushGameInfo qrcodemd5 : ").append(paramJceStruct.o).toString();
      new StringBuilder().append("SCPushGameInfo timestamp : ").append(paramJceStruct.m).toString();
      new StringBuilder().append("SCPushGameInfo session : ").append(GameLogin.a(this.a, paramJceStruct.k)).toString();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.c
 * JD-Core Version:    0.7.0.1
 */