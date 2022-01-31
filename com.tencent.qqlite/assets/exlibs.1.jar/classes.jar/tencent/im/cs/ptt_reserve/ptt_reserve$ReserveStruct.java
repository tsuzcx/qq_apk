package tencent.im.cs.ptt_reserve;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ptt_reserve$ReserveStruct
  extends MessageMicro
{
  public static final int UINT32_CHANGE_VOICE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_change_voice" }, new Object[] { Integer.valueOf(0) }, ReserveStruct.class);
  public final PBUInt32Field uint32_change_voice = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct
 * JD-Core Version:    0.7.0.1
 */