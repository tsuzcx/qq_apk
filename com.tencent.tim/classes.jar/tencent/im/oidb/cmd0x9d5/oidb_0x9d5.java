package tencent.im.oidb.cmd0x9d5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9d5
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_feed_id", "str_comment_id" }, new Object[] { "", "" }, ReqBody.class);
    public final PBStringField str_comment_id = PBField.initString("");
    public final PBStringField str_feed_id = PBField.initString("");
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "str_error_tips", "str_comment_count_info", "uint32_comment_count" }, new Object[] { "", "", Integer.valueOf(0) }, RspBody.class);
    public final PBStringField str_comment_count_info = PBField.initString("");
    public final PBStringField str_error_tips = PBField.initString("");
    public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9d5.oidb_0x9d5
 * JD-Core Version:    0.7.0.1
 */