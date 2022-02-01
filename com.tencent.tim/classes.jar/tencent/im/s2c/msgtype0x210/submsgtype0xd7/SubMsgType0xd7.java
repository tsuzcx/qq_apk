package tencent.im.s2c.msgtype0x210.submsgtype0xd7;

import appoint.define.appoint_define.RichText;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xd7
{
  public static final class Content
    extends MessageMicro<Content>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buluo_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_from_user = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_plain_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.RichText rich_fresh_word = new appoint_define.RichText();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_from_user", "bytes_plain_text", "bytes_buluo_word", "rich_fresh_word" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null }, Content.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint32_type", "uint32_msgbox_unread_count", "uint32_unread_count", "msg_content", "uint64_timestamp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L) }, MsgBody.class);
    public SubMsgType0xd7.Content msg_content = new SubMsgType0xd7.Content();
    public final PBUInt32Field uint32_msgbox_unread_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xd7.SubMsgType0xd7
 * JD-Core Version:    0.7.0.1
 */