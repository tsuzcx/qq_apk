package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x791$ReqBody
  extends MessageMicro
{
  public static final int MSG_GET_REDDOT_FIELD_NUMBER = 2;
  public static final int MSG_SET_REDDOT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_set_reddot", "msg_get_reddot" }, new Object[] { null, null }, ReqBody.class);
  public oidb_0x791.GetRedDotOpt msg_get_reddot = new oidb_0x791.GetRedDotOpt();
  public oidb_0x791.SetRedDotOpt msg_set_reddot = new oidb_0x791.SetRedDotOpt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.ReqBody
 * JD-Core Version:    0.7.0.1
 */