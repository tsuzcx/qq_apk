package tencent.im.oidb.cmd0x8fd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x8fd
{
  public static final class GroupMemberInfo
    extends MessageMicro<GroupMemberInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_group_code", "uint32_show_flag", "uint32_sys_show_flag", "rpt_msg_level_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, GroupMemberInfo.class);
    public final PBRepeatMessageField<Oidb_0x8fd.LevelName> rpt_msg_level_name = PBField.initRepeatMessage(Oidb_0x8fd.LevelName.class);
    public final PBUInt32Field uint32_show_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sys_show_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class LevelName
    extends MessageMicro<LevelName>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_level", "str_name" }, new Object[] { Integer.valueOf(0), "" }, LevelName.class);
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "rpt_uint64_group_code", "msg_reqfilter" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
    public Oidb_0x8fd.ReqFilter msg_reqfilter = new Oidb_0x8fd.ReqFilter();
    public final PBRepeatField<Long> rpt_uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class ReqFilter
    extends MessageMicro<ReqFilter>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_level_name_flag" }, new Object[] { Integer.valueOf(0) }, ReqFilter.class);
    public final PBUInt32Field uint32_level_name_flag = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_grp_member_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<Oidb_0x8fd.GroupMemberInfo> rpt_msg_grp_member_info = PBField.initRepeatMessage(Oidb_0x8fd.GroupMemberInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8fd.Oidb_0x8fd
 * JD-Core Version:    0.7.0.1
 */