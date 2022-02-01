package tencent.im.s2c.msgtype0x210.submsgtype0x83;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x83
{
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_msg_params", "uint64_seq", "uint64_group_id" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L) }, MsgBody.class);
    public final PBRepeatMessageField<SubMsgType0x83.MsgParams> rpt_msg_params = PBField.initRepeatMessage(SubMsgType0x83.MsgParams.class);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  }
  
  public static final class MsgParams
    extends MessageMicro<MsgParams>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_data = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint32_type", "uint64_from_uin", "uint64_to_uin", "str_data", "bytes_data" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro }, MsgParams.class);
    }
  }
  
  public static final class MsgRep
    extends MessageMicro<MsgRep>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MsgRep.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83
 * JD-Core Version:    0.7.0.1
 */