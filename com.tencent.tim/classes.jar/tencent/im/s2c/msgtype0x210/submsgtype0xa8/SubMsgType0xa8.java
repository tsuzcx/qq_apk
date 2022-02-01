package tencent.im.s2c.msgtype0x210.submsgtype0xa8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xa8
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_extend_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_action_subType = PBField.initUInt32(0);
    public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_action_type", "uint32_action_subType", "bytes_msg_summary", "bytes_extend_content" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, MsgBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xa8.SubMsgType0xa8
 * JD-Core Version:    0.7.0.1
 */