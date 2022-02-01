package tencent.im.oidb.cmd0x62c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x62c
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16 }, new String[] { "uint64_tinyid" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatField<Long> uint64_tinyid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_tinyid_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0x62c.TinyIDInfo> msg_tinyid_info = PBField.initRepeatMessage(oidb_cmd0x62c.TinyIDInfo.class);
  }
  
  public static final class TinyIDInfo
    extends MessageMicro<TinyIDInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_appid", "uint64_uin", "uint64_tinyid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, TinyIDInfo.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x62c.oidb_cmd0x62c
 * JD-Core Version:    0.7.0.1
 */