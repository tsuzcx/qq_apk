package tencent.im.s2c.msgtype0x210.submsgtype0x28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x28
{
  public static final class FollowList
    extends MessageMicro<FollowList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_puin", "uint64_uin", "uint32_type", "uint32_seqno" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, FollowList.class);
    public final PBUInt32Field uint32_seqno = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_sub_cmd", "msg_rsp_followlist", "msg_rsp_typelist" }, new Object[] { Integer.valueOf(0), null, null }, MsgBody.class);
    public SubMsgType0x28.RspFollowList msg_rsp_followlist = new SubMsgType0x28.RspFollowList();
    public SubMsgType0x28.RspTypeList msg_rsp_typelist = new SubMsgType0x28.RspTypeList();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class RspFollowList
    extends MessageMicro<RspFollowList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_followlist" }, new Object[] { null }, RspFollowList.class);
    public final PBRepeatMessageField<SubMsgType0x28.FollowList> rpt_msg_followlist = PBField.initRepeatMessage(SubMsgType0x28.FollowList.class);
  }
  
  public static final class RspTypeList
    extends MessageMicro<RspTypeList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_typelist" }, new Object[] { null }, RspTypeList.class);
    public final PBRepeatMessageField<SubMsgType0x28.TypeList> rpt_msg_typelist = PBField.initRepeatMessage(SubMsgType0x28.TypeList.class);
  }
  
  public static final class TypeList
    extends MessageMicro<TypeList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_puin", "uint32_flag", "uint32_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, TypeList.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28
 * JD-Core Version:    0.7.0.1
 */