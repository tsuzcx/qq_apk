package tencent.im.s2c.msgtype0x210.submsgtype0x116;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x116
{
  public static final class MemberInfo
    extends MessageMicro<MemberInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_member_uin", "uint32_invite_timestamp", "uint32_terminal_type", "uint32_client_version" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MemberInfo.class);
    public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_invite_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_terminal_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "rpt_msg_member_join", "rpt_msg_member_quit", "uint32_group_id", "uint32_room_id", "uint32_invite_list_total_count", "enum_event_type" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) }, MsgBody.class);
    public final PBEnumField enum_event_type = PBField.initEnum(1);
    public final PBRepeatMessageField<submsgtype0x116.MemberInfo> rpt_msg_member_join = PBField.initRepeatMessage(submsgtype0x116.MemberInfo.class);
    public final PBRepeatMessageField<submsgtype0x116.MemberInfo> rpt_msg_member_quit = PBField.initRepeatMessage(submsgtype0x116.MemberInfo.class);
    public final PBUInt32Field uint32_group_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_invite_list_total_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_room_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116
 * JD-Core Version:    0.7.0.1
 */