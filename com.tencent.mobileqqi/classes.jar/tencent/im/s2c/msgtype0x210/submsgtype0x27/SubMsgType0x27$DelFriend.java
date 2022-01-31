package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$DelFriend
  extends MessageMicro
{
  public static final int RPT_UINT64_UINS_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_uins" }, new Object[] { Long.valueOf(0L) }, DelFriend.class);
  public final PBRepeatField rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelFriend
 * JD-Core Version:    0.7.0.1
 */