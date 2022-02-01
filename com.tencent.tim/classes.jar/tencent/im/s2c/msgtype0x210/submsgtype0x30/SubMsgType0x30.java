package tencent.im.s2c.msgtype0x210.submsgtype0x30;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x30
{
  public static final class BlockListNotify
    extends MessageMicro<BlockListNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_msg_block_uin_info", "rpt_uint64_del_uin" }, new Object[] { null, Long.valueOf(0L) }, BlockListNotify.class);
    public final PBRepeatMessageField<SubMsgType0x30.BlockUinInfo> rpt_msg_block_uin_info = PBField.initRepeatMessage(SubMsgType0x30.BlockUinInfo.class);
    public final PBRepeatField<Long> rpt_uint64_del_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class BlockUinInfo
    extends MessageMicro<BlockUinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_block_uin", "uint32_source_id", "uint32_source_sub_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, BlockUinInfo.class);
    public final PBUInt32Field uint32_source_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source_sub_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_sub_cmd", "msg_s2c_blocklist_notify" }, new Object[] { Integer.valueOf(0), null }, MsgBody.class);
    public SubMsgType0x30.BlockListNotify msg_s2c_blocklist_notify = new SubMsgType0x30.BlockListNotify();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30
 * JD-Core Version:    0.7.0.1
 */