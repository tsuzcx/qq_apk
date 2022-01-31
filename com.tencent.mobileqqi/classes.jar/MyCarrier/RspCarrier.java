package MyCarrier;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RspCarrier
  extends JceStruct
{
  static Carrier cache_carrrier;
  public Carrier carrrier = null;
  public String msg = "";
  public String optBuf = "";
  public int refreshTime = 0;
  public int ret = 0;
  
  public RspCarrier() {}
  
  public RspCarrier(int paramInt1, String paramString1, Carrier paramCarrier, String paramString2, int paramInt2)
  {
    this.ret = paramInt1;
    this.msg = paramString1;
    this.carrrier = paramCarrier;
    this.optBuf = paramString2;
    this.refreshTime = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    if (cache_carrrier == null) {
      cache_carrrier = new Carrier();
    }
    this.carrrier = ((Carrier)paramJceInputStream.read(cache_carrrier, 2, true));
    this.optBuf = paramJceInputStream.readString(3, true);
    this.refreshTime = paramJceInputStream.read(this.refreshTime, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.msg, 1);
    paramJceOutputStream.write(this.carrrier, 2);
    paramJceOutputStream.write(this.optBuf, 3);
    paramJceOutputStream.write(this.refreshTime, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MyCarrier.RspCarrier
 * JD-Core Version:    0.7.0.1
 */