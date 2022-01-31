package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0x5d0$SnsPbBuffer
  extends MessageMicro
{
  public static final int RPT_MSG_SNS_UPDATE_ITEM_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_sns_update_item" }, new Object[] { null }, SnsPbBuffer.class);
  public final PBRepeatMessageField rpt_msg_sns_update_item = PBField.initRepeatMessage(Oidb_0x5d0.SnsUpdateItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsPbBuffer
 * JD-Core Version:    0.7.0.1
 */