package com.tencent.beacon.event;

import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.d;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import java.util.HashSet;
import java.util.Set;

final class f
  implements Callback<byte[]>
{
  private final Set<Long> a;
  private final String b;
  private final String c;
  private g d;
  private String e;
  private com.tencent.beacon.event.a.a f;
  
  f(g paramg, String paramString1, com.tencent.beacon.event.a.a parama, Set<Long> paramSet, String paramString2)
  {
    this.d = paramg;
    this.e = paramString1;
    this.f = parama;
    this.a = new HashSet(paramSet);
    this.b = ("[EventReport(" + paramString1 + ")]");
    this.c = paramString2;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    boolean bool = ((EventModule)com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT)).c().a(new e(this));
    com.tencent.beacon.base.util.c.a(this.b, 3, "report success! sendingID will delete this time's IDs. offer task: %s! ", new Object[] { Boolean.valueOf(bool) });
    if (this.a.size() >= this.d.a()) {
      com.tencent.beacon.a.b.a.a().a(this.d);
    }
  }
  
  public void onFailure(d paramd)
  {
    com.tencent.beacon.base.util.c.a(this.b, 3, "send failure reason: %s. LogID: %s.", new Object[] { paramd.toString(), this.c });
    this.d.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.f
 * JD-Core Version:    0.7.0.1
 */