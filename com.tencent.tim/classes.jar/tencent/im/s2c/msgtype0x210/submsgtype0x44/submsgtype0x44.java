package tencent.im.s2c.msgtype0x210.submsgtype0x44;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x44
{
  public static final class ClearCountMsg
    extends MessageMicro<ClearCountMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_uin", "uint32_time", "uint32_processflag", "uint32_updateflag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ClearCountMsg.class);
    public final PBUInt32Field uint32_processflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_updateflag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class FriendSyncMsg
    extends MessageMicro<FriendSyncMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "uint64_uin", "uint64_fuin", "uint32_processtype", "uint32_time", "uint32_processflag", "uint32_sourceid", "uint32_sourcesubid", "rpt_str_wording" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, FriendSyncMsg.class);
    public final PBRepeatField<String> rpt_str_wording = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_processflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_processtype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sourceid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sourcesubid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GroupSyncMsg
    extends MessageMicro<GroupSyncMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cur_max_mem_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cur_mem_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ext_admin_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inviter_role = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_max_mem_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_processflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_src_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_src_sub_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_action_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_action_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_ga_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_grp_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_opt_uin1 = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_opt_uin2 = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152 }, new String[] { "uint32_msg_type", "uint64_msg_seq", "uint64_grp_code", "uint64_ga_code", "uint64_opt_uin1", "uint64_opt_uin2", "bytes_msg_buf", "bytes_auth_key", "uint32_msg_status", "uint64_action_uin", "uint64_action_time", "uint32_cur_max_mem_count", "uint32_next_max_mem_count", "uint32_cur_mem_count", "uint32_req_src_id", "uint32_req_src_sub_id", "uint32_inviter_role", "uint32_ext_admin_num", "uint32_processflag" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupSyncMsg.class);
    }
  }
  
  public static final class ModifySyncMsg
    extends MessageMicro<ModifySyncMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_time" }, new Object[] { Integer.valueOf(0) }, ModifySyncMsg.class);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_friend_msg_sync", "msg_group_msg_sync", "msg_clean_count_msg", "msg_modify_msg_sync", "msg_waiting_msg_sync" }, new Object[] { null, null, null, null, null }, MsgBody.class);
    public submsgtype0x44.ClearCountMsg msg_clean_count_msg = new submsgtype0x44.ClearCountMsg();
    public submsgtype0x44.FriendSyncMsg msg_friend_msg_sync = new submsgtype0x44.FriendSyncMsg();
    public submsgtype0x44.GroupSyncMsg msg_group_msg_sync = new submsgtype0x44.GroupSyncMsg();
    public submsgtype0x44.ModifySyncMsg msg_modify_msg_sync = new submsgtype0x44.ModifySyncMsg();
    public submsgtype0x44.WaitingSyncMsg msg_waiting_msg_sync = new submsgtype0x44.WaitingSyncMsg();
  }
  
  public static final class WaitingSyncMsg
    extends MessageMicro<WaitingSyncMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_time" }, new Object[] { Integer.valueOf(0) }, WaitingSyncMsg.class);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44
 * JD-Core Version:    0.7.0.1
 */