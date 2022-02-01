package tencent.im.s2c.msgtype0x210.submsgtype0xf6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class Submsgtype0xf6
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mail_digest = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mail_sender = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mail_sender_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mail_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mail_to = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "bytes_mail_sender", "bytes_mail_title", "bytes_mail_digest", "bytes_mail_to", "bytes_mail_sender_nickname" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, MsgBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xf6.Submsgtype0xf6
 * JD-Core Version:    0.7.0.1
 */