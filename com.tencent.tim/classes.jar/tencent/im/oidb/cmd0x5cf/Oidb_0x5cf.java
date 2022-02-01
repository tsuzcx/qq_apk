package tencent.im.oidb.cmd0x5cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5cf
{
  public static final class All
    extends MessageMicro<All>
  {
    public static final int RPT_STR_WORDING_FIELD_NUMBER = 5;
    public static final int STR_ADD_SOURCE_FIELD_NUMBER = 6;
    public static final int STR_MAINEMAILACCOUNT_FIELD_NUMBER = 13;
    public static final int UINT32_ACKFLAG_FIELD_NUMBER = 10;
    public static final int UINT32_COMM_FRIEND_NUM_FIELD_NUMBER = 16;
    public static final int UINT32_COUNT_FIELD_NUMBER = 12;
    public static final int UINT32_FLAG_FIELD_NUMBER = 9;
    public static final int UINT32_GROUPID_FIELD_NUMBER = 11;
    public static final int UINT32_RELATIOIN_FIELD_NUMBER = 15;
    public static final int UINT32_REQTYPE_FIELD_NUMBER = 3;
    public static final int UINT32_SOURCEID_FIELD_NUMBER = 7;
    public static final int UINT32_SOURCESUBID_FIELD_NUMBER = 8;
    public static final int UINT32_TIME_FIELD_NUMBER = 4;
    public static final int UINT64_FUIN_FIELD_NUMBER = 2;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 14;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64, 72, 80, 88, 96, 106, 112, 120, 128 }, new String[] { "uint64_uin", "uint64_fuin", "uint32_reqtype", "uint32_time", "rpt_str_wording", "str_add_source", "uint32_sourceid", "uint32_sourcesubid", "uint32_flag", "uint32_ackflag", "uint32_groupid", "uint32_count", "str_mainemailaccount", "uint64_group_code", "uint32_relatioin", "uint32_comm_friend_num" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, All.class);
    public final PBRepeatField<String> rpt_str_wording = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_add_source = PBField.initString("");
    public final PBStringField str_mainemailaccount = PBField.initString("");
    public final PBUInt32Field uint32_ackflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comm_friend_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_relatioin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reqtype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sourceid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sourcesubid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ClrMsgInfo
    extends MessageMicro<ClrMsgInfo>
  {
    public static final int UINT32_PLATFORM_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_platform" }, new Object[] { Integer.valueOf(0) }, ClrMsgInfo.class);
    public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  }
  
  public static final class Decided
    extends MessageMicro<Decided>
  {
    public static final int RPT_STR_WORDING_FIELD_NUMBER = 5;
    public static final int STR_ADD_SOURCE_FIELD_NUMBER = 6;
    public static final int UINT32_REQTYPE_FIELD_NUMBER = 3;
    public static final int UINT32_SOURCEID_FIELD_NUMBER = 7;
    public static final int UINT32_SOURCESUBID_FIELD_NUMBER = 8;
    public static final int UINT32_TIME_FIELD_NUMBER = 4;
    public static final int UINT64_FUIN_FIELD_NUMBER = 2;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 9;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64, 72 }, new String[] { "uint64_uin", "uint64_fuin", "uint32_reqtype", "uint32_time", "rpt_str_wording", "str_add_source", "uint32_sourceid", "uint32_sourcesubid", "uint64_group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, Decided.class);
    public final PBRepeatField<String> rpt_str_wording = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_add_source = PBField.initString("");
    public final PBUInt32Field uint32_reqtype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sourceid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sourcesubid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class DelDecideInfo
    extends MessageMicro<DelDecideInfo>
  {
    public static final int UINT32_REQ_TYPE_FIELD_NUMBER = 3;
    public static final int UINT32_TIME_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_time", "uint32_req_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, DelDecideInfo.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class DelMsgInfo
    extends MessageMicro<DelMsgInfo>
  {
    public static final int RPT_MSG_DECIDE_INFO_FIELD_NUMBER = 1;
    public static final int RPT_MSG_UNDECIDE_INFO_FIELD_NUMBER = 2;
    public static final int UINT32_PLATFORM_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_msg_decide_info", "rpt_msg_undecide_info", "uint32_platform" }, new Object[] { null, null, Integer.valueOf(0) }, DelMsgInfo.class);
    public final PBRepeatMessageField<Oidb_0x5cf.DelDecideInfo> rpt_msg_decide_info = PBField.initRepeatMessage(Oidb_0x5cf.DelDecideInfo.class);
    public final PBRepeatMessageField<Oidb_0x5cf.DelUnDecideInfo> rpt_msg_undecide_info = PBField.initRepeatMessage(Oidb_0x5cf.DelUnDecideInfo.class);
    public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  }
  
  public static final class DelUnDecideInfo
    extends MessageMicro<DelUnDecideInfo>
  {
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, DelUnDecideInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class FailedSys
    extends MessageMicro<FailedSys>
  {
    public static final int STR_MSG_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_msg" }, new Object[] { "" }, FailedSys.class);
    public final PBStringField str_msg = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int FIXED32_SEQUENCE_FIELD_NUMBER = 2;
    public static final int MSG_CLR_MSG_INFO_FIELD_NUMBER = 16;
    public static final int MSG_DEL_MSG_INFO_FIELD_NUMBER = 15;
    public static final int STR_RESERVE_FIELD_NUMBER = 7;
    public static final int UINT32_CLEARTIME_FIELD_NUMBER = 10;
    public static final int UINT32_GETFLAG_FIELD_NUMBER = 8;
    public static final int UINT32_NEED_COMM_FRIEND_FIELD_NUMBER = 12;
    public static final int UINT32_NEED_GROUP_UIN_FIELD_NUMBER = 14;
    public static final int UINT32_NEED_UNREAD_NOAGREE_COUNT_FIELD_NUMBER = 13;
    public static final int UINT32_NEED_UNREAD_UNDECIDE_NUM_FIELD_NUMBER = 11;
    public static final int UINT32_REQNUM_FIELD_NUMBER = 6;
    public static final int UINT32_STARTINDEX_FIELD_NUMBER = 5;
    public static final int UINT32_STARTTIME_FIELD_NUMBER = 9;
    public static final int UINT32_TYPE_FIELD_NUMBER = 3;
    public static final int UINT32_VERSION_FIELD_NUMBER = 1;
    public static final int UINT64_TOUIN_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 40, 48, 58, 64, 72, 80, 88, 96, 104, 112, 122, 130 }, new String[] { "uint32_version", "fixed32_sequence", "uint32_type", "uint64_touin", "uint32_startindex", "uint32_reqnum", "str_reserve", "uint32_getFlag", "uint32_starttime", "uint32_cleartime", "uint32_need_unread_undecide_num", "uint32_need_comm_friend", "uint32_need_unread_noagree_count", "uint32_need_group_uin", "msg_del_msg_info", "msg_clr_msg_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, ReqBody.class);
    public final PBFixed32Field fixed32_sequence = PBField.initFixed32(0);
    public Oidb_0x5cf.ClrMsgInfo msg_clr_msg_info = new Oidb_0x5cf.ClrMsgInfo();
    public Oidb_0x5cf.DelMsgInfo msg_del_msg_info = new Oidb_0x5cf.DelMsgInfo();
    public final PBStringField str_reserve = PBField.initString("");
    public final PBUInt32Field uint32_cleartime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_getFlag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_comm_friend = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_group_uin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_unread_noagree_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_unread_undecide_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reqnum = PBField.initUInt32(0);
    public final PBUInt32Field uint32_startindex = PBField.initUInt32(0);
    public final PBUInt32Field uint32_starttime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_FAILEDSYS_FIELD_NUMBER = 4;
    public static final int MSG_SUCCESSREAD_FIELD_NUMBER = 3;
    public static final int STR_RESERVE_FIELD_NUMBER = 5;
    public static final int UINT32_RESULT_FIELD_NUMBER = 2;
    public static final int UINT32_VERSION_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_version", "uint32_result", "msg_successread", "msg_failedsys", "str_reserve" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, "" }, RspBody.class);
    public Oidb_0x5cf.FailedSys msg_failedsys = new Oidb_0x5cf.FailedSys();
    public Oidb_0x5cf.SuccessRead msg_successread = new Oidb_0x5cf.SuccessRead();
    public final PBStringField str_reserve = PBField.initString("");
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  }
  
  public static final class SuccessRead
    extends MessageMicro<SuccessRead>
  {
    public static final int FIXED32_SEQUENCE_FIELD_NUMBER = 1;
    public static final int RPT_MSG_ALL_FIELD_NUMBER = 7;
    public static final int RPT_MSG_DECIDED_FIELD_NUMBER = 5;
    public static final int RPT_MSG_UNDECIDE_FIELD_NUMBER = 4;
    public static final int RPT_UINT64_UNREAD_UNDECIDE_UIN_FIELD_NUMBER = 12;
    public static final int UINT32_FIRST_UPDATE_FIELD_NUMBER = 10;
    public static final int UINT32_OVER_FIELD_NUMBER = 2;
    public static final int UINT32_TOTLE_FIELD_NUMBER = 3;
    public static final int UINT32_UNREAD_UNDECIDE_NUM_FIELD_NUMBER = 11;
    public static final int UINT32_UN_READ_COUNT2_FIELD_NUMBER = 9;
    public static final int UINT32_UN_READ_COUNT_FIELD_NUMBER = 6;
    public static final int UINT64_UPDATETIME_FIELD_NUMBER = 8;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 24, 34, 42, 48, 58, 64, 72, 80, 88, 96 }, new String[] { "fixed32_sequence", "uint32_over", "uint32_totle", "rpt_msg_undecide", "rpt_msg_decided", "uint32_un_read_count", "rpt_msg_all", "uint64_updatetime", "uint32_un_read_count2", "uint32_first_update", "uint32_unread_undecide_num", "rpt_uint64_unread_undecide_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, SuccessRead.class);
    public final PBFixed32Field fixed32_sequence = PBField.initFixed32(0);
    public final PBRepeatMessageField<Oidb_0x5cf.All> rpt_msg_all = PBField.initRepeatMessage(Oidb_0x5cf.All.class);
    public final PBRepeatMessageField<Oidb_0x5cf.Decided> rpt_msg_decided = PBField.initRepeatMessage(Oidb_0x5cf.Decided.class);
    public final PBRepeatMessageField<Oidb_0x5cf.UnDecide> rpt_msg_undecide = PBField.initRepeatMessage(Oidb_0x5cf.UnDecide.class);
    public final PBRepeatField<Long> rpt_uint64_unread_undecide_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_first_update = PBField.initUInt32(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_totle = PBField.initUInt32(0);
    public final PBUInt32Field uint32_un_read_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_un_read_count2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_undecide_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_updatetime = PBField.initUInt64(0L);
  }
  
  public static final class UnDecide
    extends MessageMicro<UnDecide>
  {
    public static final int RPT_STR_WORDING_FIELD_NUMBER = 11;
    public static final int STR_ADD_SOURCE_FIELD_NUMBER = 13;
    public static final int STR_MAINEMAILACCOUNT_FIELD_NUMBER = 12;
    public static final int UINT32_ACKFLAG_FIELD_NUMBER = 4;
    public static final int UINT32_COUNT_FIELD_NUMBER = 10;
    public static final int UINT32_FLAG_FIELD_NUMBER = 3;
    public static final int UINT32_GROUPID_FIELD_NUMBER = 6;
    public static final int UINT32_REQTYPE_FIELD_NUMBER = 5;
    public static final int UINT32_SOURCEID_FIELD_NUMBER = 7;
    public static final int UINT32_SOURCESUBID_FIELD_NUMBER = 8;
    public static final int UINT32_TIME_FIELD_NUMBER = 9;
    public static final int UINT64_FUIN_FIELD_NUMBER = 2;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 14;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 90, 98, 106, 112 }, new String[] { "uint64_uin", "uint64_fuin", "uint32_flag", "uint32_ackflag", "uint32_reqtype", "uint32_groupid", "uint32_sourceid", "uint32_sourcesubid", "uint32_time", "uint32_count", "rpt_str_wording", "str_mainemailaccount", "str_add_source", "uint64_group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Long.valueOf(0L) }, UnDecide.class);
    public final PBRepeatField<String> rpt_str_wording = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_add_source = PBField.initString("");
    public final PBStringField str_mainemailaccount = PBField.initString("");
    public final PBUInt32Field uint32_ackflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reqtype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sourceid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sourcesubid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5cf.Oidb_0x5cf
 * JD-Core Version:    0.7.0.1
 */