package tencent.im.oidb.cmd0x899;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x899
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64 }, new String[] { "uint64_group_code", "uint64_start_uin", "uint32_identify_flag", "rpt_uint64_uin_list", "memberlist_opt", "uint32_member_num", "uint32_filter_method", "uint32_online_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public oidb_0x899.memberlist memberlist_opt = new oidb_0x899.memberlist();
    public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_filter_method = PBField.initUInt32(0);
    public final PBUInt32Field uint32_identify_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<oidb_0x899.memberlist> rpt_memberlist = PBField.initRepeatMessage(oidb_0x899.memberlist.class);
    public final PBBytesField str_errorinfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_identify_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint64_group_code", "uint64_start_uin", "uint32_identify_flag", "rpt_memberlist", "str_errorinfo" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class memberlist
    extends MessageMicro<memberlist>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rich_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_special_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uin_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_active_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flagex2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_speak_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_old_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_privilege = PBField.initUInt32(0);
    public final PBUInt32Field uint32_shutup_timestap = PBField.initUInt32(0);
    public final PBUInt32Field uint32_special_title_expire_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uin_arch_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uin_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uin_flagex = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uin_mobile_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 114, 120, 128, 138, 144, 154 }, new String[] { "uint64_member_uin", "uint32_uin_flag", "uint32_uin_flagex", "uint32_uin_mobile_flag", "uint32_uin_arch_flag", "uint32_join_time", "uint32_old_msg_seq", "uint32_new_msg_seq", "uint32_last_speak_time", "uint32_level", "uint32_point", "uint32_shutup_timestap", "uint32_flagex2", "bytes_special_title", "uint32_special_title_expire_time", "uint32_active_day", "bytes_uin_key", "uint32_privilege", "bytes_rich_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, memberlist.class);
    }
  }
  
  public static final class uin_key
    extends MessageMicro<uin_key>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_group_code", "uint64_member_uin", "uint64_gen_time", "uint32_valid_time", "uint32_rand_num" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, uin_key.class);
    public final PBUInt32Field uint32_rand_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_valid_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_gen_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x899.oidb_0x899
 * JD-Core Version:    0.7.0.1
 */