package tencent.im.oidb.cmd0x5d2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x5d2$RspGetList
  extends MessageMicro
{
  public static final int LIST_FIELD_NUMBER = 2;
  public static final int SEQ_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "seq", "list" }, new Object[] { Integer.valueOf(0), null }, RspGetList.class);
  public final PBRepeatMessageField list = PBField.initRepeatMessage(oidb_0x5d2.FriendList.class);
  public final PBUInt32Field seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d2.oidb_0x5d2.RspGetList
 * JD-Core Version:    0.7.0.1
 */