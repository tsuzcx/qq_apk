package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RspGroupVideoInviteMember
{
  public static final class GroupVideoInviteListChange
    extends MessageMicro<GroupVideoInviteListChange>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_member_join", "rpt_member_quit", "uint32_invite_list_total_count" }, new Object[] { null, null, Integer.valueOf(0) }, GroupVideoInviteListChange.class);
    public final PBRepeatMessageField<RspGroupVideoInviteMember.MemberInfo> rpt_member_join = PBField.initRepeatMessage(RspGroupVideoInviteMember.MemberInfo.class);
    public final PBRepeatMessageField<RspGroupVideoInviteMember.MemberInfo> rpt_member_quit = PBField.initRepeatMessage(RspGroupVideoInviteMember.MemberInfo.class);
    public final PBUInt32Field uint32_invite_list_total_count = PBField.initUInt32(0);
  }
  
  public static final class MemberInfo
    extends MessageMicro<MemberInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_member_uin", "uint32_invite_timestamp" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, MemberInfo.class);
    public final PBUInt32Field uint32_invite_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.RspGroupVideoInviteMember
 * JD-Core Version:    0.7.0.1
 */