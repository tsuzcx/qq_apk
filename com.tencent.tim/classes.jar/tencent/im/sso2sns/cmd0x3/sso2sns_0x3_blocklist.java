package tencent.im.sso2sns.cmd0x3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sso2sns_0x3_blocklist
{
  public static final class BlockUinInfo
    extends MessageMicro<BlockUinInfo>
  {
    public static final int UINT32_SOURCE_ID_FIELD_NUMBER = 2;
    public static final int UINT32_SOURCE_SUB_ID_FIELD_NUMBER = 3;
    public static final int UINT64_BLOCK_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_block_uin", "uint32_source_id", "uint32_source_sub_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, BlockUinInfo.class);
    public final PBUInt32Field uint32_source_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source_sub_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_BODY_ADD_BLOCKLIST_FIELD_NUMBER = 2;
    public static final int MSG_BODY_DEL_BLOCKLIST_FIELD_NUMBER = 3;
    public static final int MSG_BODY_GET_BLOCKLIST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_body_get_blocklist", "msg_body_add_blocklist", "msg_body_del_blocklist" }, new Object[] { null, null, null }, ReqBody.class);
    public sso2sns_0x3_blocklist.ReqBodyAddBlockList msg_body_add_blocklist = new sso2sns_0x3_blocklist.ReqBodyAddBlockList();
    public sso2sns_0x3_blocklist.ReqBodyDelBlockList msg_body_del_blocklist = new sso2sns_0x3_blocklist.ReqBodyDelBlockList();
    public sso2sns_0x3_blocklist.ReqBodyGetBlockList msg_body_get_blocklist = new sso2sns_0x3_blocklist.ReqBodyGetBlockList();
  }
  
  public static final class ReqBodyAddBlockList
    extends MessageMicro<ReqBodyAddBlockList>
  {
    public static final int RPT_MSG_BLOCK_UIN_INFO_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "rpt_msg_block_uin_info" }, new Object[] { Long.valueOf(0L), null }, ReqBodyAddBlockList.class);
    public final PBRepeatMessageField<sso2sns_0x3_blocklist.BlockUinInfo> rpt_msg_block_uin_info = PBField.initRepeatMessage(sso2sns_0x3_blocklist.BlockUinInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBodyDelBlockList
    extends MessageMicro<ReqBodyDelBlockList>
  {
    public static final int RPT_UINT64_DEL_UIN_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "rpt_uint64_del_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBodyDelBlockList.class);
    public final PBRepeatField<Long> rpt_uint64_del_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBodyGetBlockList
    extends MessageMicro<ReqBodyGetBlockList>
  {
    public static final int FIXED32_LAST_GET_TIME_FIELD_NUMBER = 2;
    public static final int UINT32_GET_TYPE_FIELD_NUMBER = 5;
    public static final int UINT32_START_POS_FIELD_NUMBER = 3;
    public static final int UINT32_WANT_NUM_FIELD_NUMBER = 4;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 40 }, new String[] { "uint64_uin", "fixed32_last_get_time", "uint32_start_pos", "uint32_want_num", "uint32_get_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBodyGetBlockList.class);
    public final PBFixed32Field fixed32_last_get_time = PBField.initFixed32(0);
    public final PBUInt32Field uint32_get_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_pos = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_BODY_ADD_BLOCKLIST_FIELD_NUMBER = 2;
    public static final int MSG_BODY_DEL_BLOCKLIST_FIELD_NUMBER = 3;
    public static final int MSG_BODY_GET_BLOCKLIST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_body_get_blocklist", "msg_body_add_blocklist", "msg_body_del_blocklist" }, new Object[] { null, null, null }, RspBody.class);
    public sso2sns_0x3_blocklist.RspBodyAddBlockList msg_body_add_blocklist = new sso2sns_0x3_blocklist.RspBodyAddBlockList();
    public sso2sns_0x3_blocklist.RspBodyDelBlockList msg_body_del_blocklist = new sso2sns_0x3_blocklist.RspBodyDelBlockList();
    public sso2sns_0x3_blocklist.RspBodyGetBlockList msg_body_get_blocklist = new sso2sns_0x3_blocklist.RspBodyGetBlockList();
  }
  
  public static final class RspBodyAddBlockList
    extends MessageMicro<RspBodyAddBlockList>
  {
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, RspBodyAddBlockList.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBodyDelBlockList
    extends MessageMicro<RspBodyDelBlockList>
  {
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, RspBodyDelBlockList.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBodyGetBlockList
    extends MessageMicro<RspBodyGetBlockList>
  {
    public static final int FIXED32_GET_TIME_FIELD_NUMBER = 2;
    public static final int RPT_MSG_BLOCK_UIN_INFO_FIELD_NUMBER = 6;
    public static final int UINT32_COMPLETED_FIELD_NUMBER = 4;
    public static final int UINT32_GET_TYPE_FIELD_NUMBER = 3;
    public static final int UINT32_NOW_POS_FIELD_NUMBER = 5;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 40, 50 }, new String[] { "uint64_uin", "fixed32_get_time", "uint32_get_type", "uint32_completed", "uint32_now_pos", "rpt_msg_block_uin_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, RspBodyGetBlockList.class);
    public final PBFixed32Field fixed32_get_time = PBField.initFixed32(0);
    public final PBRepeatMessageField<sso2sns_0x3_blocklist.BlockUinInfo> rpt_msg_block_uin_info = PBField.initRepeatMessage(sso2sns_0x3_blocklist.BlockUinInfo.class);
    public final PBUInt32Field uint32_completed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_get_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_now_pos = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist
 * JD-Core Version:    0.7.0.1
 */