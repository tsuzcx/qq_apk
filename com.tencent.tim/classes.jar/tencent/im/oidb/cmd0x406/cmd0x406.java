package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x406
{
  public static final class GroupFee
    extends MessageMicro<GroupFee>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "string_project_id", "string_project_name", "uint32_project_cost", "uint32_project_paid_user", "uint32_project_npaid_user", "uint64_project_start_time", "uint64_project_close_time", "uint32_project_status", "uint32_project_paid" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GroupFee.class);
    public final PBStringField string_project_id = PBField.initString("");
    public final PBStringField string_project_name = PBField.initString("");
    public final PBUInt32Field uint32_project_cost = PBField.initUInt32(0);
    public final PBUInt32Field uint32_project_npaid_user = PBField.initUInt32(0);
    public final PBUInt32Field uint32_project_paid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_project_paid_user = PBField.initUInt32(0);
    public final PBUInt32Field uint32_project_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_project_close_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_project_start_time = PBField.initUInt64(0L);
  }
  
  public static final class GroupFeeInfoQuery
    extends MessageMicro<GroupFeeInfoQuery>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "string_project_id", "uint32_group_fee_type", "msg_group_fee_opt" }, new Object[] { "", Integer.valueOf(0), null }, GroupFeeInfoQuery.class);
    public cmd0x406.GroupFee msg_group_fee_opt = new cmd0x406.GroupFee();
    public final PBStringField string_project_id = PBField.initString("");
    public final PBUInt32Field uint32_group_fee_type = PBField.initUInt32(0);
  }
  
  public static final class GroupFeeInfoResult
    extends MessageMicro<GroupFeeInfoResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_group_fee_type", "msg_group_fee" }, new Object[] { Integer.valueOf(0), null }, GroupFeeInfoResult.class);
    public cmd0x406.GroupFee msg_group_fee = new cmd0x406.GroupFee();
    public final PBUInt32Field uint32_group_fee_type = PBField.initUInt32(0);
  }
  
  public static final class GroupFeeListQuery
    extends MessageMicro<GroupFeeListQuery>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_group_fee_type", "msg_group_fee_opt" }, new Object[] { Integer.valueOf(0), null }, GroupFeeListQuery.class);
    public cmd0x406.GroupFee msg_group_fee_opt = new cmd0x406.GroupFee();
    public final PBUInt32Field uint32_group_fee_type = PBField.initUInt32(0);
  }
  
  public static final class GroupFeeListResult
    extends MessageMicro<GroupFeeListResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_group_fee_type", "msg_group_fee_list" }, new Object[] { Integer.valueOf(0), null }, GroupFeeListResult.class);
    public final PBRepeatMessageField<cmd0x406.GroupFee> msg_group_fee_list = PBField.initRepeatMessage(cmd0x406.GroupFee.class);
    public final PBUInt32Field uint32_group_fee_type = PBField.initUInt32(0);
  }
  
  public static final class GroupFeeMember
    extends MessageMicro<GroupFeeMember>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint64_paid_time", "string_nick_name" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, GroupFeeMember.class);
    public final PBStringField string_nick_name = PBField.initString("");
    public final PBUInt64Field uint64_paid_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GroupFeeMemberListQuery
    extends MessageMicro<GroupFeeMemberListQuery>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "string_project_id", "uint32_member_type", "uint32_page_index", "uint32_page_size" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupFeeMemberListQuery.class);
    public final PBStringField string_project_id = PBField.initString("");
    public final PBUInt32Field uint32_member_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_page_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
  }
  
  public static final class GroupFeeMemberListResult
    extends MessageMicro<GroupFeeMemberListResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_page_index", "uint32_member_type", "msg_member_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, GroupFeeMemberListResult.class);
    public final PBInt32Field int32_page_index = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0x406.GroupFeeMember> msg_member_list = PBField.initRepeatMessage(cmd0x406.GroupFeeMember.class);
    public final PBUInt32Field uint32_member_type = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_group_id", "msg_group_fee_info", "msg_group_fee_list", "msg_member_list" }, new Object[] { Long.valueOf(0L), null, null, null }, ReqBody.class);
    public cmd0x406.GroupFeeInfoQuery msg_group_fee_info = new cmd0x406.GroupFeeInfoQuery();
    public cmd0x406.GroupFeeListQuery msg_group_fee_list = new cmd0x406.GroupFeeListQuery();
    public cmd0x406.GroupFeeMemberListQuery msg_member_list = new cmd0x406.GroupFeeMemberListQuery();
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_ret", "string_msg", "msg_group_fee_info", "msg_group_fee_list", "msg_member_list" }, new Object[] { Integer.valueOf(0), "", null, null, null }, RspBody.class);
    public cmd0x406.GroupFeeInfoResult msg_group_fee_info = new cmd0x406.GroupFeeInfoResult();
    public cmd0x406.GroupFeeListResult msg_group_fee_list = new cmd0x406.GroupFeeListResult();
    public cmd0x406.GroupFeeMemberListResult msg_member_list = new cmd0x406.GroupFeeMemberListResult();
    public final PBStringField string_msg = PBField.initString("");
    public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x406.cmd0x406
 * JD-Core Version:    0.7.0.1
 */