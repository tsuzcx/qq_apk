package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x823
{
  public static final class KickPublicGroupVisitorReqBody
    extends MessageMicro<KickPublicGroupVisitorReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_visitor_uin" }, new Object[] { Long.valueOf(0L) }, KickPublicGroupVisitorReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_visitor_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class KickPublicGroupVisitorRspBody
    extends MessageMicro<KickPublicGroupVisitorRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_visitor_uin" }, new Object[] { Long.valueOf(0L) }, KickPublicGroupVisitorRspBody.class);
    public final PBRepeatField<Long> rpt_uint64_visitor_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class PlayerDeviceInfo
    extends MessageMicro<PlayerDeviceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_client_type", "uint32_portal" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PlayerDeviceInfo.class);
    public final PBInt32Field int32_client_type = PBField.initInt32(0);
    public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "msg_req_info", "uint64_group_uin", "uint64_group_code", "msg_kick_visitor" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), null }, ReqBody.class);
    public oidb_0x823.KickPublicGroupVisitorReqBody msg_kick_visitor = new oidb_0x823.KickPublicGroupVisitorReqBody();
    public oidb_0x823.PlayerDeviceInfo msg_req_info = new oidb_0x823.PlayerDeviceInfo();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_kick_visitor" }, new Object[] { null }, RspBody.class);
    public oidb_0x823.KickPublicGroupVisitorRspBody msg_kick_visitor = new oidb_0x823.KickPublicGroupVisitorRspBody();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x823
 * JD-Core Version:    0.7.0.1
 */