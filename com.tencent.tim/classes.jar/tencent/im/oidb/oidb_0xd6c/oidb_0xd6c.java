package tencent.im.oidb.oidb_0xd6c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd6c
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_host_uin", "uint64_friend_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_host_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "str_gift_url", "str_custom_url", "str_desc", "str_send_times" }, new Object[] { "", "", "", Integer.valueOf(0) }, RspBody.class);
    public final PBStringField str_custom_url = PBField.initString("");
    public final PBStringField str_desc = PBField.initString("");
    public final PBRepeatField<String> str_gift_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field str_send_times = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd6c.oidb_0xd6c
 * JD-Core Version:    0.7.0.1
 */