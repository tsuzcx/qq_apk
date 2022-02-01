package tencent.im.oidb.oidb_0xde5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xde5
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "uint64_longnick_uin", "str_longnick_id", "uint64_target_comment_id", "uint64_from_uin", "str_comment" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L), "" }, ReqBody.class);
    public final PBStringField str_comment = PBField.initString("");
    public final PBStringField str_longnick_id = PBField.initString("");
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_longnick_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_target_comment_id = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_comment_id" }, new Object[] { Long.valueOf(0L) }, RspBody.class);
    public final PBUInt64Field uint64_comment_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xde5.oidb_0xde5
 * JD-Core Version:    0.7.0.1
 */