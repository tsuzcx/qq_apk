import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import org.jetbrains.annotations.NotNull;

public class men
  implements meg.a
{
  private int aQF;
  private int aQG;
  private int aQH = 20000;
  private String agn = "";
  private boolean amf;
  
  public boolean Ds()
  {
    return RIJRedPacketManager.a().Ds();
  }
  
  public boolean dQ(String paramString)
  {
    return RIJRedPacketManager.a().dQ(paramString);
  }
  
  public boolean dR(@NotNull String paramString)
  {
    boolean bool = dQ(paramString);
    if ((!bool) && (!this.amf))
    {
      this.amf = true;
      RIJRedPacketManager.a().a(paramString, new meo(this, paramString));
    }
    return bool;
  }
  
  public String jD()
  {
    return RIJRedPacketManager.a().jD();
  }
  
  public String jF()
  {
    return this.agn;
  }
  
  public void nA(String paramString)
  {
    this.agn = paramString;
  }
  
  public void ny(String paramString)
  {
    RIJRedPacketManager.a().ny(paramString);
  }
  
  public int oT()
  {
    return RIJRedPacketManager.a().oT();
  }
  
  public int oU()
  {
    return RIJRedPacketManager.a().oU();
  }
  
  public int oY()
  {
    return RIJRedPacketManager.a().oY();
  }
  
  public int pb()
  {
    return RIJRedPacketManager.a().pb();
  }
  
  public int pc()
  {
    return this.aQF;
  }
  
  public int pd()
  {
    return this.aQG;
  }
  
  public int pe()
  {
    return oU() / pb();
  }
  
  public int pf()
  {
    return this.aQH;
  }
  
  public void q(String paramString, int paramInt1, int paramInt2)
  {
    RIJRedPacketManager.a().a(paramString, paramInt1, paramInt2, null);
  }
  
  public void rE(int paramInt)
  {
    this.aQF = paramInt;
  }
  
  public void rF(int paramInt)
  {
    this.aQG = paramInt;
  }
  
  public void rG(int paramInt)
  {
    this.aQH = paramInt;
  }
  
  public void rH(int paramInt)
  {
    RIJRedPacketManager.a().rz(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     men
 * JD-Core Version:    0.7.0.1
 */