package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x95a
{
  public static final class ArActivityItem
    extends MessageMicro<ArActivityItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66 }, new String[] { "uint32_activity_id", "uint32_activity_type", "str_activity_pic_url", "str_activity_name", "str_scan_name", "uint32_new_activity", "uint32_jump_type", "str_jump_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), "" }, ArActivityItem.class);
    public final PBStringField str_activity_name = PBField.initString("");
    public final PBStringField str_activity_pic_url = PBField.initString("");
    public final PBStringField str_jump_url = PBField.initString("");
    public final PBStringField str_scan_name = PBField.initString("");
    public final PBUInt32Field uint32_activity_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_activity_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_activity = PBField.initUInt32(0);
  }
  
  public static final class ArCountItem
    extends MessageMicro<ArCountItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_count_type", "uint32_count_value", "str_count_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, ArCountItem.class);
    public final PBStringField str_count_name = PBField.initString("");
    public final PBUInt32Field uint32_count_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_count_value = PBField.initUInt32(0);
  }
  
  public static final class GetArActivityDetailReq
    extends MessageMicro<GetArActivityDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint32_activity_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GetArActivityDetailReq.class);
    public final PBUInt32Field uint32_activity_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetArActivityDetailRsp
    extends MessageMicro<GetArActivityDetailRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "uint64_uin", "uint32_activity_id", "uint32_activity_type", "str_activity_name", "str_head_pic_url", "str_activity_desc", "rpt_str_identify_pic_url", "str_identify_pic_wording" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "" }, GetArActivityDetailRsp.class);
    public final PBRepeatField<String> rpt_str_identify_pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_activity_desc = PBField.initString("");
    public final PBStringField str_activity_name = PBField.initString("");
    public final PBStringField str_head_pic_url = PBField.initString("");
    public final PBStringField str_identify_pic_wording = PBField.initString("");
    public final PBUInt32Field uint32_activity_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_activity_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetArActivityListReq
    extends MessageMicro<GetArActivityListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 37 }, new String[] { "uint64_uin", "uint32_start_pos", "uint32_want_num", "fixed32_last_get_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetArActivityListReq.class);
    public final PBFixed32Field fixed32_last_get_time = PBField.initFixed32(0);
    public final PBUInt32Field uint32_start_pos = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetArActivityListRsp
    extends MessageMicro<GetArActivityListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 32, 42 }, new String[] { "uint64_uin", "fixed32_get_time", "uint32_completed", "uint32_now_pos", "rpt_msg_ar_activity_item" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, GetArActivityListRsp.class);
    public final PBFixed32Field fixed32_get_time = PBField.initFixed32(0);
    public final PBRepeatMessageField<cmd0x95a.ArActivityItem> rpt_msg_ar_activity_item = PBField.initRepeatMessage(cmd0x95a.ArActivityItem.class);
    public final PBUInt32Field uint32_completed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_now_pos = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetArActivityRedReq
    extends MessageMicro<GetArActivityRedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint64_client_activity_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GetArActivityRedReq.class);
    public final PBUInt64Field uint64_client_activity_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetArActivityRedRsp
    extends MessageMicro<GetArActivityRedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_red_switch", "uint64_server_activity_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, GetArActivityRedRsp.class);
    public final PBUInt32Field uint32_red_switch = PBField.initUInt32(0);
    public final PBUInt64Field uint64_server_activity_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetArCountListReq
    extends MessageMicro<GetArCountListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, GetArCountListReq.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetArCountListRsp
    extends MessageMicro<GetArCountListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "rpt_msg_ar_count_item" }, new Object[] { Long.valueOf(0L), null }, GetArCountListRsp.class);
    public final PBRepeatMessageField<cmd0x95a.ArCountItem> rpt_msg_ar_count_item = PBField.initRepeatMessage(cmd0x95a.ArCountItem.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetWorldCupInfoReq
    extends MessageMicro<GetWorldCupInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_share_id" }, new Object[] { "" }, GetWorldCupInfoReq.class);
    public final PBStringField str_share_id = PBField.initString("");
  }
  
  public static final class GetWorldCupInfoRsp
    extends MessageMicro<GetWorldCupInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_worldcup_info" }, new Object[] { null }, GetWorldCupInfoRsp.class);
    public cmd0x95a.WorldCupInfo msg_worldcup_info = new cmd0x95a.WorldCupInfo();
  }
  
  public static final class JoinWorldCupReq
    extends MessageMicro<JoinWorldCupReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_t_req_recommend_nick" }, new Object[] { Integer.valueOf(0) }, JoinWorldCupReq.class);
    public final PBUInt32Field uint32_t_req_recommend_nick = PBField.initUInt32(0);
  }
  
  public static final class JoinWorldCupRsp
    extends MessageMicro<JoinWorldCupRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_recommend_uin", "str_recommend_nick" }, new Object[] { Long.valueOf(0L), "" }, JoinWorldCupRsp.class);
    public final PBStringField str_recommend_nick = PBField.initString("");
    public final PBUInt64Field uint64_recommend_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 810, 818, 826 }, new String[] { "msg_update_ar_count_req", "msg_get_ar_count_list_req", "msg_get_ar_activity_list_req", "msg_get_ar_activity_detail_req", "msg_get_ar_activity_red_req", "msg_get_world_cup_info_req", "msg_set_world_cup_info_req", "msg_join_world_cup_req" }, new Object[] { null, null, null, null, null, null, null, null }, ReqBody.class);
    public cmd0x95a.GetArActivityDetailReq msg_get_ar_activity_detail_req = new cmd0x95a.GetArActivityDetailReq();
    public cmd0x95a.GetArActivityListReq msg_get_ar_activity_list_req = new cmd0x95a.GetArActivityListReq();
    public cmd0x95a.GetArActivityRedReq msg_get_ar_activity_red_req = new cmd0x95a.GetArActivityRedReq();
    public cmd0x95a.GetArCountListReq msg_get_ar_count_list_req = new cmd0x95a.GetArCountListReq();
    public cmd0x95a.GetWorldCupInfoReq msg_get_world_cup_info_req = new cmd0x95a.GetWorldCupInfoReq();
    public cmd0x95a.JoinWorldCupReq msg_join_world_cup_req = new cmd0x95a.JoinWorldCupReq();
    public cmd0x95a.SetWorldCupInfoReq msg_set_world_cup_info_req = new cmd0x95a.SetWorldCupInfoReq();
    public cmd0x95a.UpdateArCountReq msg_update_ar_count_req = new cmd0x95a.UpdateArCountReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 810, 818, 826 }, new String[] { "msg_update_ar_count_rsp", "msg_get_ar_count_list_rsp", "msg_get_ar_activity_list_rsp", "msg_get_ar_activity_detail_rsp", "msg_get_ar_activity_red_rsp", "msg_get_world_cup_info_rsp", "msg_set_world_cup_info_rsp", "msg_join_world_cup_rsp" }, new Object[] { null, null, null, null, null, null, null, null }, RspBody.class);
    public cmd0x95a.GetArActivityDetailRsp msg_get_ar_activity_detail_rsp = new cmd0x95a.GetArActivityDetailRsp();
    public cmd0x95a.GetArActivityListRsp msg_get_ar_activity_list_rsp = new cmd0x95a.GetArActivityListRsp();
    public cmd0x95a.GetArActivityRedRsp msg_get_ar_activity_red_rsp = new cmd0x95a.GetArActivityRedRsp();
    public cmd0x95a.GetArCountListRsp msg_get_ar_count_list_rsp = new cmd0x95a.GetArCountListRsp();
    public cmd0x95a.GetWorldCupInfoRsp msg_get_world_cup_info_rsp = new cmd0x95a.GetWorldCupInfoRsp();
    public cmd0x95a.JoinWorldCupRsp msg_join_world_cup_rsp = new cmd0x95a.JoinWorldCupRsp();
    public cmd0x95a.SetWorldCupInfoRsp msg_set_world_cup_info_rsp = new cmd0x95a.SetWorldCupInfoRsp();
    public cmd0x95a.UpdateArCountRsp msg_update_ar_count_rsp = new cmd0x95a.UpdateArCountRsp();
  }
  
  public static final class SetWorldCupInfoReq
    extends MessageMicro<SetWorldCupInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_worldcup_info" }, new Object[] { null }, SetWorldCupInfoReq.class);
    public cmd0x95a.WorldCupInfo msg_worldcup_info = new cmd0x95a.WorldCupInfo();
  }
  
  public static final class SetWorldCupInfoRsp
    extends MessageMicro<SetWorldCupInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_share_id" }, new Object[] { "" }, SetWorldCupInfoRsp.class);
    public final PBStringField str_share_id = PBField.initString("");
  }
  
  public static final class UpdateArCountReq
    extends MessageMicro<UpdateArCountReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_uin", "uint32_update_type", "uint32_count_type", "uint32_count_value" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UpdateArCountReq.class);
    public final PBUInt32Field uint32_count_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_count_value = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class UpdateArCountRsp
    extends MessageMicro<UpdateArCountRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_uin" }, new Object[] { Long.valueOf(0L) }, UpdateArCountRsp.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class WorldCupInfo
    extends MessageMicro<WorldCupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "str_share_id", "str_nick", "str_video_url", "str_config", "str_qq_head_url" }, new Object[] { "", "", "", "", "" }, WorldCupInfo.class);
    public final PBStringField str_config = PBField.initString("");
    public final PBStringField str_nick = PBField.initString("");
    public final PBStringField str_qq_head_url = PBField.initString("");
    public final PBStringField str_share_id = PBField.initString("");
    public final PBStringField str_video_url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a
 * JD-Core Version:    0.7.0.1
 */