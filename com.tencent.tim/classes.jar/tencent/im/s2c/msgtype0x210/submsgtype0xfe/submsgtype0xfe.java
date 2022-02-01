package tencent.im.s2c.msgtype0x210.submsgtype0xfe;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xfe
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_box_unread_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inner_unread_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "bytes_wording", "uint32_inner_unread_num", "uint32_box_unread_num", "uint32_update_time" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MsgBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xfe.submsgtype0xfe
 * JD-Core Version:    0.7.0.1
 */