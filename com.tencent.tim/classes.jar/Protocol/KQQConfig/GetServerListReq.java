package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetServerListReq
  extends JceStruct
{
  static ArrayList<String> cache_vUin;
  public byte bLinkType = 1;
  public int iLastTime;
  public int netType;
  public String sImsi = "46000";
  public ArrayList<String> vUin;
  
  public GetServerListReq() {}
  
  public GetServerListReq(ArrayList<String> paramArrayList, int paramInt1, byte paramByte, String paramString, int paramInt2)
  {
    this.vUin = paramArrayList;
    this.iLastTime = paramInt1;
    this.bLinkType = paramByte;
    this.sImsi = paramString;
    this.netType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vUin == null)
    {
      cache_vUin = new ArrayList();
      cache_vUin.add("");
    }
    this.vUin = ((ArrayList)paramJceInputStream.read(cache_vUin, 1, true));
    this.iLastTime = paramJceInputStream.read(this.iLastTime, 2, true);
    this.bLinkType = paramJceInputStream.read(this.bLinkType, 3, false);
    this.sImsi = paramJceInputStream.readString(4, false);
    this.netType = paramJceInputStream.read(this.netType, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vUin, 1);
    paramJceOutputStream.write(this.iLastTime, 2);
    paramJceOutputStream.write(this.bLinkType, 3);
    if (this.sImsi != null) {
      paramJceOutputStream.write(this.sImsi, 4);
    }
    paramJceOutputStream.write(this.netType, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     protocol.KQQConfig.GetServerListReq
 * JD-Core Version:    0.7.0.1
 */