package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x787
{
  public static final class Filter
    extends MessageMicro<Filter>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184 }, new String[] { "uint32_member_level_info_uin", "uint32_member_level_info_point", "uint32_member_level_info_active_day", "uint32_member_level_info_level", "uint32_member_level_info_name", "uint32_level_name", "uint32_data_time", "uint32_user_show_flag", "uint32_sys_show_flag", "uint32_time_to_update", "uint32_nick_name", "uint32_special_title", "uint32_phone", "uint32_email", "uint32_remark", "uint32_gender", "uint32_job", "uint32_office_mode", "uint32_glamour_level", "uint32_torchbearer_flag", "uint32_global_group_level", "uint32_title_id", "uint32_global_group_point" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Filter.class);
    public final PBUInt32Field uint32_data_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_email = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_glamour_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_global_group_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_global_group_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_job = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level_name = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_level_info_active_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_level_info_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_level_info_name = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_level_info_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_level_info_uin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_nick_name = PBField.initUInt32(0);
    public final PBUInt32Field uint32_office_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_phone = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remark = PBField.initUInt32(0);
    public final PBUInt32Field uint32_special_title = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sys_show_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time_to_update = PBField.initUInt32(0);
    public final PBUInt32Field uint32_title_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_torchbearer_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_show_flag = PBField.initUInt32(0);
  }
  
  public static final class LevelName
    extends MessageMicro<LevelName>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField str_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_level", "str_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, LevelName.class);
    }
  }
  
  public static final class MemberLevelInfo
    extends MessageMicro<MemberLevelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_email = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_job = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_phone = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_special_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_active_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_glamour_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_global_group_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_global_group_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rich_card_name_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_special_title_expire_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_title_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_torchbearer_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 64, 74, 82, 90, 96, 106, 112, 120, 128, 136, 144, 152 }, new String[] { "uint64_uin", "uint32_point", "uint32_active_day", "uint32_level", "str_name", "bytes_nick_name", "bytes_special_title", "uint32_special_title_expire_time", "bytes_phone", "bytes_email", "bytes_remark", "uint32_gender", "bytes_job", "uint32_glamour_level", "uint32_torchbearer_flag", "uint32_global_group_level", "uint32_title_id", "uint32_global_group_point", "uint32_rich_card_name_ver" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MemberLevelInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 40, 50, 56, 64, 72, 80 }, new String[] { "uint64_group_code", "uint64_begin_uin", "uint64_data_time", "rpt_uin_list", "opt_filter", "uint32_seq", "uint32_uin_num", "uint32_group_type", "uint32_rich_card_name_ver" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public oidb_0x787.Filter opt_filter = new oidb_0x787.Filter();
    public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rich_card_name_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uin_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_begin_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_data_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_admin_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_owner_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x787.LevelName> rpt_msg_level_name = PBField.initRepeatMessage(oidb_0x787.LevelName.class);
    public final PBRepeatMessageField<oidb_0x787.MemberLevelInfo> rpt_msg_member_level_info = PBField.initRepeatMessage(oidb_0x787.MemberLevelInfo.class);
    public final PBUInt32Field uint32_level_name_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_office_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sys_show_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time_to_update = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_show_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_data_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104 }, new String[] { "uint64_group_code", "rpt_msg_member_level_info", "rpt_msg_level_name", "uint64_end_uin", "uint64_data_time", "uint32_user_show_flag", "uint32_sys_show_flag", "uint32_time_to_update", "bytes_owner_name", "bytes_admin_name", "uint32_seq", "uint32_office_mode", "uint32_level_name_seq" }, new Object[] { Long.valueOf(0L), null, null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x787.oidb_0x787
 * JD-Core Version:    0.7.0.1
 */