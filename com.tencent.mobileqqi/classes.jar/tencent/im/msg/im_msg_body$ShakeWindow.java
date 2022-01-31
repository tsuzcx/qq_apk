package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$ShakeWindow
  extends MessageMicro
{
  public static final int UINT32_RESERVE_FIELD_NUMBER = 2;
  public static final int UINT32_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_type", "uint32_reserve" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ShakeWindow.class);
  public final PBUInt32Field uint32_reserve = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.ShakeWindow
 * JD-Core Version:    0.7.0.1
 */