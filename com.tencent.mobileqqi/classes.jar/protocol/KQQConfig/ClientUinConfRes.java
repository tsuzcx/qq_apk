package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ClientUinConfRes
  extends JceStruct
{
  static ClientGetUinConfRes cache_clientGetUinConfRes;
  static ClientSetUinConfRes cache_clientSetUinConfRes;
  public ClientGetUinConfRes clientGetUinConfRes = null;
  public ClientSetUinConfRes clientSetUinConfRes = null;
  public int iUinCmdType = 0;
  
  public ClientUinConfRes() {}
  
  public ClientUinConfRes(int paramInt, ClientSetUinConfRes paramClientSetUinConfRes, ClientGetUinConfRes paramClientGetUinConfRes)
  {
    this.iUinCmdType = paramInt;
    this.clientSetUinConfRes = paramClientSetUinConfRes;
    this.clientGetUinConfRes = paramClientGetUinConfRes;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUinCmdType = paramJceInputStream.read(this.iUinCmdType, 1, true);
    if (cache_clientSetUinConfRes == null) {
      cache_clientSetUinConfRes = new ClientSetUinConfRes();
    }
    this.clientSetUinConfRes = ((ClientSetUinConfRes)paramJceInputStream.read(cache_clientSetUinConfRes, 3, false));
    if (cache_clientGetUinConfRes == null) {
      cache_clientGetUinConfRes = new ClientGetUinConfRes();
    }
    this.clientGetUinConfRes = ((ClientGetUinConfRes)paramJceInputStream.read(cache_clientGetUinConfRes, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUinCmdType, 1);
    if (this.clientSetUinConfRes != null) {
      paramJceOutputStream.write(this.clientSetUinConfRes, 3);
    }
    if (this.clientGetUinConfRes != null) {
      paramJceOutputStream.write(this.clientGetUinConfRes, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.ClientUinConfRes
 * JD-Core Version:    0.7.0.1
 */