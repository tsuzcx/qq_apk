package tencent.im.s2c.msgtype0x210.submsgtype0x120;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x120
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reserve1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reserve2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reserve3 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_clear_themeid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_notice_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_notice_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_app_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 64 }, new String[] { "uint32_src_app_id", "uint32_notice_type", "bytes_reserve1", "bytes_reserve2", "bytes_reserve3", "uint32_notice_time", "uint64_frd_uin", "uint32_clear_themeid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, MsgBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x120.SubMsgType0x120
 * JD-Core Version:    0.7.0.1
 */