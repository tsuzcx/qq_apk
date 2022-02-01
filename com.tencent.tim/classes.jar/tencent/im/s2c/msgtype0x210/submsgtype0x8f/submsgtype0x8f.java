package tencent.im.s2c.msgtype0x210.submsgtype0x8f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x8f
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    public static final int MSG_TYPE_ALL_CONFIRM = 2;
    public static final int MSG_TYPE_CONFIRMED = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_msg_type = PBField.initEnum(1);
    public submsgtype0x8f.SourceID msg_source_id = new submsgtype0x8f.SourceID();
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_confirm_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48 }, new String[] { "msg_source_id", "bytes_feeds_id", "enum_msg_type", "bytes_ext_msg", "uint64_author_uin", "uint64_confirm_uin" }, new Object[] { null, localByteStringMicro1, Integer.valueOf(1), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L) }, MsgBody.class);
    }
  }
  
  public static final class SourceID
    extends MessageMicro<SourceID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source_type", "uint64_source_code" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, SourceID.class);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_source_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x8f.submsgtype0x8f
 * JD-Core Version:    0.7.0.1
 */