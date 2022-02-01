package cooperation.vip.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public final class adv_report
{
  public static final class MobileAdvReportReq
    extends MessageMicro<MobileAdvReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 56, 66, 74 }, new String[] { "qq", "device_info", "adv_pos", "recomm_cookie", "action_type", "action_value", "feed_index", "reward_report_info", "subscribe_info" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, MobileAdvReportReq.class);
    public final PBInt32Field action_type = PBField.initInt32(0);
    public final PBInt32Field action_value = PBField.initInt32(0);
    public final PBInt32Field adv_pos = PBField.initInt32(0);
    public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
    public final PBUInt32Field feed_index = PBField.initUInt32(0);
    public final PBUInt64Field qq = PBField.initUInt64(0L);
    public final PBStringField recomm_cookie = PBField.initString("");
    public adv_report.RewardReportInfo reward_report_info = new adv_report.RewardReportInfo();
    public adv_report.SubscribeInfo subscribe_info = new adv_report.SubscribeInfo();
  }
  
  public static final class MobileAdvReportRsp
    extends MessageMicro<MobileAdvReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "error_msg" }, new Object[] { Integer.valueOf(0), "" }, MobileAdvReportRsp.class);
    public final PBStringField error_msg = PBField.initString("");
    public final PBInt32Field ret_code = PBField.initInt32(0);
  }
  
  public static final class RewardReportInfo
    extends MessageMicro<RewardReportInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field nonce = PBField.initInt32(0);
    public final PBBytesField reward_item = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field reward_type = PBField.initInt32(0);
    public final PBStringField signature = PBField.initString("");
    public final PBUInt64Field time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "reward_type", "reward_item", "time", "nonce", "signature" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), "" }, RewardReportInfo.class);
    }
  }
  
  public static final class SubscribeInfo
    extends MessageMicro<SubscribeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "id" }, new Object[] { "" }, SubscribeInfo.class);
    public final PBStringField id = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.pb.adv_report
 * JD-Core Version:    0.7.0.1
 */