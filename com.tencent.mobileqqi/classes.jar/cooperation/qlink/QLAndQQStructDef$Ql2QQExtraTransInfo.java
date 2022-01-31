package cooperation.qlink;

import java.io.Serializable;

public class QLAndQQStructDef$Ql2QQExtraTransInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public long apOwner;
  public String localAbs;
  public String peerAbs;
  public int peerOs;
  
  public QLAndQQStructDef$Ql2QQExtraTransInfo(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    this.apOwner = paramLong;
    this.localAbs = paramString1;
    this.peerAbs = paramString2;
    this.peerOs = paramInt;
  }
  
  public String toString()
  {
    return "apOwner[" + this.apOwner + "]localAbs[" + this.localAbs + "] peerAbs[" + this.peerAbs + "] peerOs[" + this.peerOs + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QLAndQQStructDef.Ql2QQExtraTransInfo
 * JD-Core Version:    0.7.0.1
 */