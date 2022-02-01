package tencent.im.oidb.cmd0x82a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x82a
{
  public static final class MsgInfo
    extends MessageMicro<MsgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96 }, new String[] { "uint64_from_uin", "uint64_to_uin", "uint32_msg_seq", "uint64_msg_uid", "uint64_msg_time", "uint32_msg_random", "uint32_pkg_num", "uint32_pkg_index", "uint32_div_seq", "uint32_msg_type", "uint32_type", "uint32_subtype" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MsgInfo.class);
    public final PBUInt32Field uint32_div_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pkg_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pkg_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subtype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_msg_uid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgStatus
    extends MessageMicro<MsgStatus>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_info", "uint32_status" }, new Object[] { null, Integer.valueOf(0) }, MsgStatus.class);
    public cmd0x82a.MsgInfo msg_info = new cmd0x82a.MsgInfo();
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reserved = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<cmd0x82a.MsgInfo> msg_info = PBField.initRepeatMessage(cmd0x82a.MsgInfo.class);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inst_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_long_message_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "msg_info", "uint32_app_id", "uint32_inst_id", "uint32_long_message_flag", "bytes_reserved" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_status" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<cmd0x82a.MsgStatus> msg_status = PBField.initRepeatMessage(cmd0x82a.MsgStatus.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x82a.cmd0x82a
 * JD-Core Version:    0.7.0.1
 */