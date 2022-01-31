package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetServerListResV2
  extends JceStruct
{
  static ArrayList cache_v2G3GList;
  static ArrayList cache_vWifiList;
  public byte bTestSpeed = 0;
  public int iResult = 0;
  public int iSecInterval = 86400;
  public int iTime = 0;
  public ArrayList v2G3GList = null;
  public ArrayList vWifiList = null;
  
  public GetServerListResV2() {}
  
  public GetServerListResV2(int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt2, int paramInt3, byte paramByte)
  {
    this.iResult = paramInt1;
    this.v2G3GList = paramArrayList1;
    this.vWifiList = paramArrayList2;
    this.iTime = paramInt2;
    this.iSecInterval = paramInt3;
    this.bTestSpeed = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iResult = paramJceInputStream.read(this.iResult, 1, true);
    ServerListInfo localServerListInfo;
    if (cache_v2G3GList == null)
    {
      cache_v2G3GList = new ArrayList();
      localServerListInfo = new ServerListInfo();
      cache_v2G3GList.add(localServerListInfo);
    }
    this.v2G3GList = ((ArrayList)paramJceInputStream.read(cache_v2G3GList, 2, true));
    if (cache_vWifiList == null)
    {
      cache_vWifiList = new ArrayList();
      localServerListInfo = new ServerListInfo();
      cache_vWifiList.add(localServerListInfo);
    }
    this.vWifiList = ((ArrayList)paramJceInputStream.read(cache_vWifiList, 3, true));
    this.iTime = paramJceInputStream.read(this.iTime, 4, true);
    this.iSecInterval = paramJceInputStream.read(this.iSecInterval, 5, false);
    this.bTestSpeed = paramJceInputStream.read(this.bTestSpeed, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResult, 1);
    paramJceOutputStream.write(this.v2G3GList, 2);
    paramJceOutputStream.write(this.vWifiList, 3);
    paramJceOutputStream.write(this.iTime, 4);
    paramJceOutputStream.write(this.iSecInterval, 5);
    paramJceOutputStream.write(this.bTestSpeed, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.GetServerListResV2
 * JD-Core Version:    0.7.0.1
 */