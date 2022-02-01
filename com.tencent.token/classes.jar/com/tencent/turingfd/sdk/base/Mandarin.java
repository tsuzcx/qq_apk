package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;
import java.util.ArrayList;
import java.util.Collection;

public final class Mandarin
  extends break
{
  public static Loquat xd;
  public static ArrayList<Loquat> yd;
  public static ArrayList<String> zd;
  public int Ad = 0;
  public ArrayList<Loquat> Bd = null;
  public ArrayList<String> Cd = null;
  public Loquat connected = null;
  
  public final void a(afk paramafk)
  {
    this.Ad = paramafk.a(this.Ad, 0, true);
    if (xd == null) {
      xd = new Loquat();
    }
    this.connected = ((Loquat)paramafk.a(xd, 1, false));
    Object localObject;
    if (yd == null)
    {
      yd = new ArrayList();
      localObject = new Loquat();
      yd.add(localObject);
    }
    this.Bd = ((ArrayList)paramafk.a(yd, 2, false));
    if (zd == null)
    {
      localObject = new ArrayList();
      zd = (ArrayList)localObject;
      ((ArrayList)localObject).add("");
    }
    this.Cd = ((ArrayList)paramafk.a(zd, 3, false));
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.Ad, 0);
    Object localObject = this.connected;
    if (localObject != null) {
      paramafn.a((break)localObject, 1);
    }
    localObject = this.Bd;
    if (localObject != null) {
      paramafn.a((Collection)localObject, 2);
    }
    localObject = this.Cd;
    if (localObject != null) {
      paramafn.a((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Mandarin
 * JD-Core Version:    0.7.0.1
 */