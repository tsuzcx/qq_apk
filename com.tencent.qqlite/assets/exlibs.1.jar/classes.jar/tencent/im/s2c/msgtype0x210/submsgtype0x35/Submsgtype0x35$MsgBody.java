package tencent.im.s2c.msgtype0x210.submsgtype0x35;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Submsgtype0x35$MsgBody
  extends MessageMicro
{
  public static final int UINT32_BUBBLE_TIMESTAMP_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_bubble_timestamp" }, new Object[] { Integer.valueOf(0) }, MsgBody.class);
  public final PBUInt32Field uint32_bubble_timestamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x35.Submsgtype0x35.MsgBody
 * JD-Core Version:    0.7.0.1
 */