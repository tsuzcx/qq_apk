package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8bb
{
  public static final class ForbidUin
    extends MessageMicro<ForbidUin>
  {
    public static final int UINT32_UPDATE_TIME_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint32_update_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ForbidUin.class);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GroupConcernedInfo
    extends MessageMicro<GroupConcernedInfo>
  {
    public static final int RPT_MSG_CONCERNED_FIELD_NUMBER = 3;
    public static final int RPT_MSG_FORBID_UINS_FIELD_NUMBER = 5;
    public static final int RPT_MSG_WORD_FIELD_NUMBER = 4;
    public static final int RPT_UINT64_DEFAULT_UINS_FIELD_NUMBER = 6;
    public static final int UINT32_UPDATE_TIME_FIELD_NUMBER = 2;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "uint64_group_code", "uint32_update_time", "rpt_msg_concerned", "rpt_msg_word", "rpt_msg_forbid_uins", "rpt_uint64_default_uins" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, null, Long.valueOf(0L) }, GroupConcernedInfo.class);
    public final PBRepeatMessageField<oidb_0x8bb.UinInfo> rpt_msg_concerned = PBField.initRepeatMessage(oidb_0x8bb.UinInfo.class);
    public final PBRepeatMessageField<oidb_0x8bb.ForbidUin> rpt_msg_forbid_uins = PBField.initRepeatMessage(oidb_0x8bb.ForbidUin.class);
    public final PBRepeatMessageField<oidb_0x8bb.WordInfo> rpt_msg_word = PBField.initRepeatMessage(oidb_0x8bb.WordInfo.class);
    public final PBRepeatField<Long> rpt_uint64_default_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class ReadReq
    extends MessageMicro<ReadReq>
  {
    public static final int RPT_MSG_GROUP_CONCERNED_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_group_concerned" }, new Object[] { null }, ReadReq.class);
    public final PBRepeatMessageField<oidb_0x8bb.GroupConcernedInfo> rpt_msg_group_concerned = PBField.initRepeatMessage(oidb_0x8bb.GroupConcernedInfo.class);
  }
  
  public static final class ReadRsp
    extends MessageMicro<ReadRsp>
  {
    public static final int RPT_MSG_GROUP_CONCERNED_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_group_concerned" }, new Object[] { null }, ReadRsp.class);
    public final PBRepeatMessageField<oidb_0x8bb.GroupConcernedInfo> rpt_msg_group_concerned = PBField.initRepeatMessage(oidb_0x8bb.GroupConcernedInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_READ_REQ_FIELD_NUMBER = 2;
    public static final int MSG_WRITE_REQ_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_write_req", "msg_read_req" }, new Object[] { null, null }, ReqBody.class);
    public oidb_0x8bb.ReadReq msg_read_req = new oidb_0x8bb.ReadReq();
    public oidb_0x8bb.WriteReq msg_write_req = new oidb_0x8bb.WriteReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_READ_RSP_FIELD_NUMBER = 2;
    public static final int MSG_WRITE_RSP_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_write_rsp", "msg_read_rsp" }, new Object[] { null, null }, RspBody.class);
    public oidb_0x8bb.ReadRsp msg_read_rsp = new oidb_0x8bb.ReadRsp();
    public oidb_0x8bb.WriteRsp msg_write_rsp = new oidb_0x8bb.WriteRsp();
  }
  
  public static final class UinInfo
    extends MessageMicro<UinInfo>
  {
    public static final int UINT32_FROM_FIELD_NUMBER = 3;
    public static final int UINT32_UPDATE_TIME_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_update_time", "uint32_from" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, UinInfo.class);
    public final PBUInt32Field uint32_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class WordInfo
    extends MessageMicro<WordInfo>
  {
    public static final int STR_KEYWORD_FIELD_NUMBER = 1;
    public static final int UINT32_UPDATE_TIME_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_keyword", "uint32_update_time" }, new Object[] { "", Integer.valueOf(0) }, WordInfo.class);
    public final PBStringField str_keyword = PBField.initString("");
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
  }
  
  public static final class WriteReq
    extends MessageMicro<WriteReq>
  {
    public static final int RPT_MSG_GROUP_CONCERNED_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_group_concerned" }, new Object[] { null }, WriteReq.class);
    public final PBRepeatMessageField<oidb_0x8bb.GroupConcernedInfo> rpt_msg_group_concerned = PBField.initRepeatMessage(oidb_0x8bb.GroupConcernedInfo.class);
  }
  
  public static final class WriteRsp
    extends MessageMicro<WriteRsp>
  {
    public static final int RPT_MSG_GROUP_CONCERNED_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_group_concerned" }, new Object[] { null }, WriteRsp.class);
    public final PBRepeatMessageField<oidb_0x8bb.GroupConcernedInfo> rpt_msg_group_concerned = PBField.initRepeatMessage(oidb_0x8bb.GroupConcernedInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8bb.oidb_0x8bb
 * JD-Core Version:    0.7.0.1
 */