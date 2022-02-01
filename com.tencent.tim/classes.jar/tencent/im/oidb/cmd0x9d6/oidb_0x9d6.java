package tencent.im.oidb.cmd0x9d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9d6
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_feed_id", "uint32_operation" }, new Object[] { "", Integer.valueOf(0) }, ReqBody.class);
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBUInt32Field uint32_operation = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_error_tips", "uint32_praise_count" }, new Object[] { "", Integer.valueOf(0) }, RspBody.class);
    public final PBStringField str_error_tips = PBField.initString("");
    public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9d6.oidb_0x9d6
 * JD-Core Version:    0.7.0.1
 */