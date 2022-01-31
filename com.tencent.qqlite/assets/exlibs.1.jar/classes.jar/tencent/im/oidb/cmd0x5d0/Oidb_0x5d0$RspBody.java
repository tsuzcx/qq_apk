package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0x5d0$RspBody
  extends MessageMicro
{
  public static final int RPT_MSG_CONTENTITEM_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_contentItem" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_contentItem = PBField.initRepeatMessage(Oidb_0x5d0.ContentItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.RspBody
 * JD-Core Version:    0.7.0.1
 */