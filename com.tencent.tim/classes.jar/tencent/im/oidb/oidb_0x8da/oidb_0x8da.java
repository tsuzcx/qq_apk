package tencent.im.oidb.oidb_0x8da;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8da
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_user_info" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_0x8da.UserInfo> rpt_msg_user_info = PBField.initRepeatMessage(oidb_0x8da.UserInfo.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_tiny_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x8da.TinyInfo> rpt_msg_tiny_info = PBField.initRepeatMessage(oidb_0x8da.TinyInfo.class);
  }
  
  public static final class TinyInfo
    extends MessageMicro<TinyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint64_tinyid", "uint32_result" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, TinyInfo.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, UserInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8da.oidb_0x8da
 * JD-Core Version:    0.7.0.1
 */