package com.tencent.turingfd.sdk.base;

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
  
  public void a(cy paramcy)
  {
    this.Ad = paramcy.a(this.Ad, 0, true);
    if (xd == null) {
      xd = new Loquat();
    }
    this.connected = ((Loquat)paramcy.a(xd, 1, false));
    if (yd == null)
    {
      yd = new ArrayList();
      Loquat localLoquat = new Loquat();
      yd.add(localLoquat);
    }
    this.Bd = ((ArrayList)paramcy.a(yd, 2, false));
    if (zd == null)
    {
      zd = new ArrayList();
      zd.add("");
    }
    this.Cd = ((ArrayList)paramcy.a(zd, 3, false));
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.Ad, 0);
    Object localObject = this.connected;
    if (localObject != null) {
      paramdb.a((break)localObject, 1);
    }
    localObject = this.Bd;
    if (localObject != null) {
      paramdb.a((Collection)localObject, 2);
    }
    localObject = this.Cd;
    if (localObject != null) {
      paramdb.a((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Mandarin
 * JD-Core Version:    0.7.0.1
 */