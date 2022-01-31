package btmsdkobf;

import java.util.ArrayList;

public class cy$f
{
  public int jH = 0;
  public boolean jI = false;
  public boolean jJ = false;
  public boolean jK = false;
  public boolean jL = false;
  public boolean jM = false;
  public boolean jN = false;
  public boolean jO = false;
  public boolean jP = false;
  public int jQ;
  public cs.b jR;
  public long jS;
  public ArrayList jT;
  public cy.b jU;
  public long jV = System.currentTimeMillis();
  public boolean jW = false;
  public byte jX = 0;
  public long jY = -1L;
  
  public cy$f(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong1, ArrayList paramArrayList, cy.b paramb, long paramLong2)
  {
    this.jH = paramInt;
    this.jI = paramBoolean1;
    this.jL = paramBoolean2;
    this.jM = paramBoolean3;
    this.jS = paramLong1;
    this.jT = paramArrayList;
    this.jU = paramb;
    this.jQ = cu.bv().bm();
    this.jY = paramLong2;
  }
  
  public boolean bP()
  {
    long l = Math.abs(System.currentTimeMillis() - this.jV);
    boolean bool;
    int i;
    label85:
    as localas;
    if (l >= 30000L)
    {
      bool = true;
      if (!bool) {
        break label165;
      }
      eh.h("ocean", "[ocean][time_out]SharkNetwork.SharkSend.isTimeOut(), SharkSend.seqNoTag: " + this.jQ + " time(s): " + l / 1000L);
      if (this.jT == null) {
        break label165;
      }
      int j = this.jT.size();
      i = 0;
      if (i >= j) {
        break label165;
      }
      localas = (as)this.jT.get(i);
      if (localas != null) {
        break label121;
      }
    }
    for (;;)
    {
      i += 1;
      break label85;
      bool = false;
      break;
      label121:
      eh.h("ocean", "[ocean][time_out]SharkNetwork.SharkSend.isTimeOut(), cmdId|" + localas.bM + "|seqNo|" + localas.dc);
    }
    label165:
    return bool;
  }
  
  public boolean bQ()
  {
    return (this.jL) || (this.jM);
  }
  
  public boolean bR()
  {
    return this.jI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cy.f
 * JD-Core Version:    0.7.0.1
 */