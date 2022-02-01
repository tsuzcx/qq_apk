package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetJoinedHotChatList
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint32_req_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint32_req_type", "rpt_msg_wifi_poi_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspBody.class);
    public final PBRepeatMessageField<Common.WifiPOIInfo> rpt_msg_wifi_poi_info = PBField.initRepeatMessage(Common.WifiPOIInfo.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.hotchat.GetJoinedHotChatList
 * JD-Core Version:    0.7.0.1
 */