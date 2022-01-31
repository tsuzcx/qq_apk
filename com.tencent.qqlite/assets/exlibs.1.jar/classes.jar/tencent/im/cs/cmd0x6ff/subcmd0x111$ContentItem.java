package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x111$ContentItem
  extends MessageMicro
{
  public static final int MSG_GENERAL_BUFFER_FIELD_NUMBER = 2;
  public static final int UINT32_FILED_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_filed", "msg_general_buffer" }, new Object[] { Integer.valueOf(0), null }, ContentItem.class);
  public subcmd0x111.GeneralBuffer msg_general_buffer = new subcmd0x111.GeneralBuffer();
  public final PBUInt32Field uint32_filed = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x111.ContentItem
 * JD-Core Version:    0.7.0.1
 */