package btmsdkobf;

import com.qq.taf.jce.JceStruct;

class gk
  implements cm
{
  gk(cy paramcy) {}
  
  public dj a(int paramInt1, long paramLong, int paramInt2, JceStruct paramJceStruct)
  {
    if (paramJceStruct == null)
    {
      eh.h("SharkNetwork", "[ip_list][cu_guid_p]onRecvPush() null == push");
      return null;
    }
    switch (paramInt2)
    {
    default: 
      return null;
    case 10155: 
      return cy.a(this.a, paramLong, paramInt1, (u)paramJceStruct);
    }
    return cy.a(this.a, paramLong, paramInt1, (au)paramJceStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gk
 * JD-Core Version:    0.7.0.1
 */