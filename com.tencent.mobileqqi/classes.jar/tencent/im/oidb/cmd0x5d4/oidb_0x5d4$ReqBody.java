package tencent.im.oidb.cmd0x5d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5d4$ReqBody
  extends MessageMicro
{
  public static final int UIN_LIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin_list" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
  public final PBRepeatField uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d4.oidb_0x5d4.ReqBody
 * JD-Core Version:    0.7.0.1
 */