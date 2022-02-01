package wf7;

import java.util.ArrayList;

public class em$d
{
  public boolean nA = false;
  public int nB;
  public dx nC;
  public long nD;
  public ArrayList<x> nE;
  public em.a nF;
  public long nG = System.currentTimeMillis();
  public boolean nH = false;
  public byte nI = 0;
  public long nJ = -1L;
  public int ns = 0;
  public boolean nt = false;
  public boolean nu = false;
  public boolean nv = false;
  public boolean nw = false;
  public boolean nx = false;
  public boolean ny = false;
  public boolean nz = false;
  
  public em$d(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong1, ArrayList<x> paramArrayList, em.a parama, long paramLong2)
  {
    this.ns = paramInt;
    this.nt = paramBoolean1;
    this.nw = paramBoolean2;
    this.nx = paramBoolean3;
    this.nD = paramLong1;
    this.nE = paramArrayList;
    this.nF = parama;
    this.nB = ew.dh().di();
    this.nJ = paramLong2;
  }
  
  public boolean cW()
  {
    if (Math.abs(System.currentTimeMillis() - this.nG) >= 180000L) {}
    for (boolean bool = true; (bool) && (this.nE != null); bool = false)
    {
      int j = this.nE.size();
      int i = 0;
      while (i < j)
      {
        if ((x)this.nE.get(i) == null) {}
        i += 1;
      }
    }
    return bool;
  }
  
  public boolean cX()
  {
    return (this.nw) || (this.nx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.em.d
 * JD-Core Version:    0.7.0.1
 */