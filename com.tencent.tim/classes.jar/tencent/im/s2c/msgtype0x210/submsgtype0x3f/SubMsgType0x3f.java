package tencent.im.s2c.msgtype0x210.submsgtype0x3f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x3f
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_pubunikey" }, new Object[] { null }, MsgBody.class);
    public final PBRepeatMessageField<SubMsgType0x3f.PubUniKey> rpt_msg_pubunikey = PBField.initRepeatMessage(SubMsgType0x3f.PubUniKey.class);
  }
  
  public static final class PubUniKey
    extends MessageMicro<PubUniKey>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_fromPubUin", "uint64_qwMsgId" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, PubUniKey.class);
    public final PBUInt64Field uint64_fromPubUin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_qwMsgId = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x3f.SubMsgType0x3f
 * JD-Core Version:    0.7.0.1
 */