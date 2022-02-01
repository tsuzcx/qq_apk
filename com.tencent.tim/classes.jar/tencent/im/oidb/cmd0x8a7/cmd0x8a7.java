package tencent.im.oidb.cmd0x8a7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8a7
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_sub_cmd", "uint32_limit_interval_type_for_uin", "uint32_limit_interval_type_for_group", "uint64_uin", "uint64_group_code" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt32Field uint32_limit_interval_type_for_group = PBField.initUInt32(0);
    public final PBUInt32Field uint32_limit_interval_type_for_uin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_can_at_all = PBField.initBool(false);
    public final PBBoolField bool_show_at_all_lable = PBField.initBool(false);
    public final PBBytesField bytes_prompt_msg_1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_prompt_msg_2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_remain_at_all_count_for_group = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remain_at_all_count_for_uin = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48 }, new String[] { "bool_can_at_all", "uint32_remain_at_all_count_for_uin", "uint32_remain_at_all_count_for_group", "bytes_prompt_msg_1", "bytes_prompt_msg_2", "bool_show_at_all_lable" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a7.cmd0x8a7
 * JD-Core Version:    0.7.0.1
 */