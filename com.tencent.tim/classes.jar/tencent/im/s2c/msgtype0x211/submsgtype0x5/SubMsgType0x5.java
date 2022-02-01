package tencent.im.s2c.msgtype0x211.submsgtype0x5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x5
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    public static final int UINT32_SESSIONID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_sessionid" }, new Object[] { Integer.valueOf(0) }, MsgBody.class);
    public final PBUInt32Field uint32_sessionid = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x5.SubMsgType0x5
 * JD-Core Version:    0.7.0.1
 */