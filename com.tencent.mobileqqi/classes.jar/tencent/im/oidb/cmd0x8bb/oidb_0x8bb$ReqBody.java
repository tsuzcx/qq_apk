package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x8bb$ReqBody
  extends MessageMicro
{
  public static final int MSG_READ_REQ_FIELD_NUMBER = 2;
  public static final int MSG_WRITE_REQ_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_write_req", "msg_read_req" }, new Object[] { null, null }, ReqBody.class);
  public oidb_0x8bb.ReadReq msg_read_req = new oidb_0x8bb.ReadReq();
  public oidb_0x8bb.WriteReq msg_write_req = new oidb_0x8bb.WriteReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8bb.oidb_0x8bb.ReqBody
 * JD-Core Version:    0.7.0.1
 */