package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x5d0$ContentItem
  extends MessageMicro
{
  public static final int MSG_GENERAL_BUFFER_FIELD_NUMBER = 2;
  public static final int UINT32_FIELD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_field", "msg_general_buffer" }, new Object[] { Integer.valueOf(0), null }, ContentItem.class);
  public Oidb_0x5d0.GeneralBuffer msg_general_buffer = new Oidb_0x5d0.GeneralBuffer();
  public final PBUInt32Field uint32_field = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.ContentItem
 * JD-Core Version:    0.7.0.1
 */