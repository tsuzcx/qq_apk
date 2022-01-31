package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ClientRes
  extends JceStruct
{
  static ClientUinConfRes cache_stClientUinConfRes;
  static GetResourceRespV2 cache_stResourceRespV2;
  static SDKConfRes cache_stSDKConfRes;
  static SDKUpgradeRes cache_stSDKUpgradeRes;
  static GetServerListRes cache_stServerListRes;
  static GetServerListRes cache_stServerListRes2;
  static GetServerListResV2 cache_stServerListV2;
  static VelocityMeasureReq cache_stVelocityMeasureReq;
  public int iCmdType = 0;
  public int iResult = 0;
  public int iVelocityMeasureFlag = 0;
  public ClientUinConfRes stClientUinConfRes = null;
  public GetResourceRespV2 stResourceRespV2 = null;
  public SDKConfRes stSDKConfRes = null;
  public SDKUpgradeRes stSDKUpgradeRes = null;
  public GetServerListRes stServerListRes = null;
  public GetServerListRes stServerListRes2 = null;
  public GetServerListResV2 stServerListV2 = null;
  public VelocityMeasureReq stVelocityMeasureReq = null;
  
  public ClientRes() {}
  
  public ClientRes(int paramInt1, int paramInt2, SDKUpgradeRes paramSDKUpgradeRes, SDKConfRes paramSDKConfRes, GetServerListRes paramGetServerListRes1, int paramInt3, VelocityMeasureReq paramVelocityMeasureReq, GetServerListRes paramGetServerListRes2, GetServerListResV2 paramGetServerListResV2, GetResourceRespV2 paramGetResourceRespV2, ClientUinConfRes paramClientUinConfRes)
  {
    this.iResult = paramInt1;
    this.iCmdType = paramInt2;
    this.stSDKUpgradeRes = paramSDKUpgradeRes;
    this.stSDKConfRes = paramSDKConfRes;
    this.stServerListRes = paramGetServerListRes1;
    this.iVelocityMeasureFlag = paramInt3;
    this.stVelocityMeasureReq = paramVelocityMeasureReq;
    this.stServerListRes2 = paramGetServerListRes2;
    this.stServerListV2 = paramGetServerListResV2;
    this.stResourceRespV2 = paramGetResourceRespV2;
    this.stClientUinConfRes = paramClientUinConfRes;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iResult = paramJceInputStream.read(this.iResult, 1, true);
    this.iCmdType = paramJceInputStream.read(this.iCmdType, 2, true);
    if (cache_stSDKUpgradeRes == null) {
      cache_stSDKUpgradeRes = new SDKUpgradeRes();
    }
    this.stSDKUpgradeRes = ((SDKUpgradeRes)paramJceInputStream.read(cache_stSDKUpgradeRes, 3, false));
    if (cache_stSDKConfRes == null) {
      cache_stSDKConfRes = new SDKConfRes();
    }
    this.stSDKConfRes = ((SDKConfRes)paramJceInputStream.read(cache_stSDKConfRes, 4, false));
    if (cache_stServerListRes == null) {
      cache_stServerListRes = new GetServerListRes();
    }
    this.stServerListRes = ((GetServerListRes)paramJceInputStream.read(cache_stServerListRes, 5, false));
    this.iVelocityMeasureFlag = paramJceInputStream.read(this.iVelocityMeasureFlag, 6, true);
    if (cache_stVelocityMeasureReq == null) {
      cache_stVelocityMeasureReq = new VelocityMeasureReq();
    }
    this.stVelocityMeasureReq = ((VelocityMeasureReq)paramJceInputStream.read(cache_stVelocityMeasureReq, 7, false));
    if (cache_stServerListRes2 == null) {
      cache_stServerListRes2 = new GetServerListRes();
    }
    this.stServerListRes2 = ((GetServerListRes)paramJceInputStream.read(cache_stServerListRes2, 8, false));
    if (cache_stServerListV2 == null) {
      cache_stServerListV2 = new GetServerListResV2();
    }
    this.stServerListV2 = ((GetServerListResV2)paramJceInputStream.read(cache_stServerListV2, 9, false));
    if (cache_stResourceRespV2 == null) {
      cache_stResourceRespV2 = new GetResourceRespV2();
    }
    this.stResourceRespV2 = ((GetResourceRespV2)paramJceInputStream.read(cache_stResourceRespV2, 10, false));
    if (cache_stClientUinConfRes == null) {
      cache_stClientUinConfRes = new ClientUinConfRes();
    }
    this.stClientUinConfRes = ((ClientUinConfRes)paramJceInputStream.read(cache_stClientUinConfRes, 11, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResult, 1);
    paramJceOutputStream.write(this.iCmdType, 2);
    if (this.stSDKUpgradeRes != null) {
      paramJceOutputStream.write(this.stSDKUpgradeRes, 3);
    }
    if (this.stSDKConfRes != null) {
      paramJceOutputStream.write(this.stSDKConfRes, 4);
    }
    if (this.stServerListRes != null) {
      paramJceOutputStream.write(this.stServerListRes, 5);
    }
    paramJceOutputStream.write(this.iVelocityMeasureFlag, 6);
    if (this.stVelocityMeasureReq != null) {
      paramJceOutputStream.write(this.stVelocityMeasureReq, 7);
    }
    if (this.stServerListRes2 != null) {
      paramJceOutputStream.write(this.stServerListRes2, 8);
    }
    if (this.stServerListV2 != null) {
      paramJceOutputStream.write(this.stServerListV2, 9);
    }
    if (this.stResourceRespV2 != null) {
      paramJceOutputStream.write(this.stResourceRespV2, 10);
    }
    if (this.stClientUinConfRes != null) {
      paramJceOutputStream.write(this.stClientUinConfRes, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     protocol.KQQConfig.ClientRes
 * JD-Core Version:    0.7.0.1
 */