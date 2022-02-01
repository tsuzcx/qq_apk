package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PrivExtV2Rsp
  extends JceStruct
{
  static ItemCfgList cache_itemCfgList = new ItemCfgList();
  static VipMedalList cache_medalInfoList;
  static PayRuleCfg cache_payRule = new PayRuleCfg();
  static TrafficResultInfo cache_trafficResult;
  static VipUserInfo cache_vipInfo = new VipUserInfo();
  public int iSyncFreq = -1;
  public ItemCfgList itemCfgList;
  public VipMedalList medalInfoList;
  public PayRuleCfg payRule;
  public TrafficResultInfo trafficResult;
  public VipUserInfo vipInfo;
  
  static
  {
    cache_trafficResult = new TrafficResultInfo();
    cache_medalInfoList = new VipMedalList();
  }
  
  public PrivExtV2Rsp() {}
  
  public PrivExtV2Rsp(VipUserInfo paramVipUserInfo, TrafficResultInfo paramTrafficResultInfo, int paramInt, VipMedalList paramVipMedalList, ItemCfgList paramItemCfgList, PayRuleCfg paramPayRuleCfg)
  {
    this.vipInfo = paramVipUserInfo;
    this.trafficResult = paramTrafficResultInfo;
    this.iSyncFreq = paramInt;
    this.medalInfoList = paramVipMedalList;
    this.itemCfgList = paramItemCfgList;
    this.payRule = paramPayRuleCfg;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vipInfo = ((VipUserInfo)paramJceInputStream.read(cache_vipInfo, 0, true));
    this.trafficResult = ((TrafficResultInfo)paramJceInputStream.read(cache_trafficResult, 1, false));
    this.iSyncFreq = paramJceInputStream.read(this.iSyncFreq, 2, false);
    this.medalInfoList = ((VipMedalList)paramJceInputStream.read(cache_medalInfoList, 3, false));
    this.itemCfgList = ((ItemCfgList)paramJceInputStream.read(cache_itemCfgList, 4, false));
    this.payRule = ((PayRuleCfg)paramJceInputStream.read(cache_payRule, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vipInfo, 0);
    if (this.trafficResult != null) {
      paramJceOutputStream.write(this.trafficResult, 1);
    }
    paramJceOutputStream.write(this.iSyncFreq, 2);
    if (this.medalInfoList != null) {
      paramJceOutputStream.write(this.medalInfoList, 3);
    }
    if (this.itemCfgList != null) {
      paramJceOutputStream.write(this.itemCfgList, 4);
    }
    if (this.payRule != null) {
      paramJceOutputStream.write(this.payRule, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MQQ.PrivExtV2Rsp
 * JD-Core Version:    0.7.0.1
 */