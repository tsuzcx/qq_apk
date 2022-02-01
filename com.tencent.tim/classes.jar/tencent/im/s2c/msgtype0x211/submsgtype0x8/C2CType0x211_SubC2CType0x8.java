package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class C2CType0x211_SubC2CType0x8
{
  public static final class BusiReqHead
    extends MessageMicro<BusiReqHead>
  {
    public static final int INT32_SEQ_FIELD_NUMBER = 2;
    public static final int INT32_VERSION_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_version", "int32_seq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BusiReqHead.class);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
    public final PBInt32Field int32_version = PBField.initInt32(0);
  }
  
  public static final class BusiRespHead
    extends MessageMicro<BusiRespHead>
  {
    public static final int INT32_REPLY_CODE_FIELD_NUMBER = 3;
    public static final int INT32_SEQ_FIELD_NUMBER = 2;
    public static final int INT32_VERSION_FIELD_NUMBER = 1;
    public static final int STR_RESULT_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_version", "int32_seq", "int32_reply_code", "str_result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, BusiRespHead.class);
    public final PBInt32Field int32_reply_code = PBField.initInt32(0);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
    public final PBInt32Field int32_version = PBField.initInt32(0);
    public final PBStringField str_result = PBField.initString("");
  }
  
  public static final class Cell
    extends MessageMicro<Cell>
  {
    public static final int INT32_CELLID_FIELD_NUMBER = 4;
    public static final int INT32_LAC_FIELD_NUMBER = 3;
    public static final int INT32_MCC_FIELD_NUMBER = 1;
    public static final int INT32_MNC_FIELD_NUMBER = 2;
    public static final int INT32_RSSI_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "int32_mcc", "int32_mnc", "int32_lac", "int32_cellid", "int32_rssi" }, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(0) }, Cell.class);
    public final PBInt32Field int32_cellid = PBField.initInt32(-1);
    public final PBInt32Field int32_lac = PBField.initInt32(-1);
    public final PBInt32Field int32_mcc = PBField.initInt32(-1);
    public final PBInt32Field int32_mnc = PBField.initInt32(-1);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
  }
  
  public static final class ConnType
    extends MessageMicro<ConnType>
  {
    public static final int STR_DESRIPTION_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "str_desription" }, new Object[] { Integer.valueOf(1), "" }, ConnType.class);
    public final PBStringField str_desription = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    public static final int ETYPE_FIELD_NUMBER = 4;
    public static final int INT32_ALT_FIELD_NUMBER = 3;
    public static final int INT32_LAT_FIELD_NUMBER = 1;
    public static final int INT32_LON_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_lat", "int32_lon", "int32_alt", "eType" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(-10000000), Integer.valueOf(0) }, GPS.class);
    public final PBEnumField eType = PBField.initEnum(0);
    public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  }
  
  public static final class IPAddrInfo
    extends MessageMicro<IPAddrInfo>
  {
    public static final int INT32_GATEWAY_FIELD_NUMBER = 3;
    public static final int INT32_IP_FIELD_NUMBER = 1;
    public static final int INT32_MASK_FIELD_NUMBER = 2;
    public static final int INT32_PORT_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_ip", "int32_mask", "int32_gateway", "int32_port" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, IPAddrInfo.class);
    public final PBInt32Field int32_gateway = PBField.initInt32(0);
    public final PBInt32Field int32_ip = PBField.initInt32(0);
    public final PBInt32Field int32_mask = PBField.initInt32(0);
    public final PBInt32Field int32_port = PBField.initInt32(0);
  }
  
  public static final class JudgeResult
    extends MessageMicro<JudgeResult>
  {
    public static final int INT32_IDLE_TIMEOUT_FIELD_NUMBER = 4;
    public static final int STR_SSID_FIELD_NUMBER = 2;
    public static final int STR_TIPS_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int UINT32_FLAGS_NETCHECK_FIELD_NUMBER = 8;
    public static final int UINT32_FLAGS_WIFIPSW_FIELD_NUMBER = 7;
    public static final int UINT32_FORCE_WIFI_FIELD_NUMBER = 6;
    public static final int UINT32_IDLE_WAITING_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64 }, new String[] { "type", "str_ssid", "str_tips", "int32_idle_timeout", "uint32_idle_waiting", "uint32_force_wifi", "uint32_flags_wifipsw", "uint32_flags_netcheck" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, JudgeResult.class);
    public final PBInt32Field int32_idle_timeout = PBField.initInt32(0);
    public final PBStringField str_ssid = PBField.initString("");
    public final PBStringField str_tips = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBUInt32Field uint32_flags_netcheck = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flags_wifipsw = PBField.initUInt32(0);
    public final PBUInt32Field uint32_force_wifi = PBField.initUInt32(0);
    public final PBUInt32Field uint32_idle_waiting = PBField.initUInt32(0);
  }
  
  public static final class LBSInfo
    extends MessageMicro<LBSInfo>
  {
    public static final int MSG_GPS_FIELD_NUMBER = 1;
    public static final int RPT_MSG_CELLS_FIELD_NUMBER = 3;
    public static final int RPT_MSG_WIFIS_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
    public C2CType0x211_SubC2CType0x8.GPS msg_gps = new C2CType0x211_SubC2CType0x8.GPS();
    public final PBRepeatMessageField<C2CType0x211_SubC2CType0x8.Cell> rpt_msg_cells = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8.Cell.class);
    public final PBRepeatMessageField<C2CType0x211_SubC2CType0x8.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8.Wifi.class);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    public static final int MSG_CCNF_ABI_QUERY_FIELD_NUMBER = 3;
    public static final int MSG_CCNF_FILESEND_REQ_FIELD_NUMBER = 5;
    public static final int MSG_CCNF_FILESTATE_SYNC_FIELD_NUMBER = 6;
    public static final int MSG_CC_NOTIFYLIST_FIELD_NUMBER = 2;
    public static final int MSG_CC_PUSH_JUDGE_RESULT_FIELD_NUMBER = 4;
    public static final int MSG_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "msg_type", "msg_cc_notifylist", "msg_ccnf_abi_query", "msg_cc_push_judge_result", "msg_ccnf_filesend_req", "msg_ccnf_filestate_sync" }, new Object[] { Integer.valueOf(1), null, null, null, null, null }, MsgBody.class);
    public C2CType0x211_SubC2CType0x8.NotifyList msg_cc_notifylist = new C2CType0x211_SubC2CType0x8.NotifyList();
    public C2CType0x211_SubC2CType0x8.PushJudgeResult msg_cc_push_judge_result = new C2CType0x211_SubC2CType0x8.PushJudgeResult();
    public C2CType0x211_SubC2CType0x8.NearFieldAbiQuery msg_ccnf_abi_query = new C2CType0x211_SubC2CType0x8.NearFieldAbiQuery();
    public C2CType0x211_SubC2CType0x8.NearFieldFileSendReq msg_ccnf_filesend_req = new C2CType0x211_SubC2CType0x8.NearFieldFileSendReq();
    public C2CType0x211_SubC2CType0x8.NearFieldFileStateSync msg_ccnf_filestate_sync = new C2CType0x211_SubC2CType0x8.NearFieldFileStateSync();
    public final PBEnumField msg_type = PBField.initEnum(1);
  }
  
  public static final class NearFieldAbiQuery
    extends MessageMicro<NearFieldAbiQuery>
  {
    public static final int BOOL_NEED_TIPS_FIELD_NUMBER = 3;
    public static final int BYTES_COOKIE_FIELD_NUMBER = 5;
    public static final int BYTES_PEER_EXTRA_FIELD_NUMBER = 8;
    public static final int INT32_PEER_IP_FIELD_NUMBER = 6;
    public static final int INT32_PEER_PORT_FIELD_NUMBER = 7;
    public static final int INT32_TIMEOUT_FIELD_NUMBER = 4;
    public static final int UINT64_FROM_UIN_FIELD_NUMBER = 2;
    public static final int UINT64_TO_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_need_tips = PBField.initBool(false);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_peer_extra = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_peer_ip = PBField.initInt32(0);
    public final PBInt32Field int32_peer_port = PBField.initInt32(0);
    public final PBInt32Field int32_timeout = PBField.initInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66 }, new String[] { "uint64_to_uin", "uint64_from_uin", "bool_need_tips", "int32_timeout", "bytes_cookie", "int32_peer_ip", "int32_peer_port", "bytes_peer_extra" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, NearFieldAbiQuery.class);
    }
  }
  
  public static final class NearFieldFileInfo
    extends MessageMicro<NearFieldFileInfo>
  {
    public static final int INT32_TIMEOUT_FIELD_NUMBER = 8;
    public static final int STR_FILE_MD5_FIELD_NUMBER = 3;
    public static final int STR_FILE_NAME_FIELD_NUMBER = 1;
    public static final int STR_FILE_THUMB_MD5_FIELD_NUMBER = 5;
    public static final int STR_FILE_THUMB_URL_FIELD_NUMBER = 6;
    public static final int STR_FILE_URL_FIELD_NUMBER = 4;
    public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 2;
    public static final int UINT64_GROUP_ID_FIELD_NUMBER = 9;
    public static final int UINT64_SESSION_ID_FIELD_NUMBER = 7;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 56, 64, 72 }, new String[] { "str_file_name", "uint64_file_size", "str_file_md5", "str_file_url", "str_file_thumb_md5", "str_file_thumb_url", "uint64_session_id", "int32_timeout", "uint64_group_id" }, new Object[] { "", Long.valueOf(0L), "", "", "", "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, NearFieldFileInfo.class);
    public final PBInt32Field int32_timeout = PBField.initInt32(0);
    public final PBStringField str_file_md5 = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_file_thumb_md5 = PBField.initString("");
    public final PBStringField str_file_thumb_url = PBField.initString("");
    public final PBStringField str_file_url = PBField.initString("");
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
  }
  
  public static final class NearFieldFileSendReq
    extends MessageMicro<NearFieldFileSendReq>
  {
    public static final int INT32_CONN_WIFIAP_TIMEOUT_FIELD_NUMBER = 6;
    public static final int INT32_IP_FIELD_NUMBER = 3;
    public static final int INT32_UDP_PORT_FIELD_NUMBER = 4;
    public static final int RPT_MSG_FILE_LIST_FIELD_NUMBER = 2;
    public static final int STR_SSID_FIELD_NUMBER = 5;
    public static final int STR_WIFIPSW_FIELD_NUMBER = 8;
    public static final int UINT32_FORCE_WIFI_FIELD_NUMBER = 7;
    public static final int UINT64_TO_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 66 }, new String[] { "uint64_to_uin", "rpt_msg_file_list", "int32_ip", "int32_udp_port", "str_ssid", "int32_conn_wifiap_timeout", "uint32_force_wifi", "str_wifipsw" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, NearFieldFileSendReq.class);
    public final PBInt32Field int32_conn_wifiap_timeout = PBField.initInt32(0);
    public final PBInt32Field int32_ip = PBField.initInt32(0);
    public final PBInt32Field int32_udp_port = PBField.initInt32(0);
    public final PBRepeatMessageField<C2CType0x211_SubC2CType0x8.NearFieldFileInfo> rpt_msg_file_list = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8.NearFieldFileInfo.class);
    public final PBStringField str_ssid = PBField.initString("");
    public final PBStringField str_wifipsw = PBField.initString("");
    public final PBUInt32Field uint32_force_wifi = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class NearFieldFileStateSync
    extends MessageMicro<NearFieldFileStateSync>
  {
    public static final int ETYPE_FIELD_NUMBER = 1;
    public static final int INT32_ERROR_CODE_FIELD_NUMBER = 4;
    public static final int UINT64_FROM_UIN_FIELD_NUMBER = 3;
    public static final int UINT64_SESSION_ID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "eType", "uint64_session_id", "uint64_from_uin", "int32_error_code" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, NearFieldFileStateSync.class);
    public final PBEnumField eType = PBField.initEnum(1);
    public final PBInt32Field int32_error_code = PBField.initInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
  }
  
  public static final class NearfieldInfo
    extends MessageMicro<NearfieldInfo>
  {
    public static final int BYTES_EXTRA_FIELD_NUMBER = 6;
    public static final int MSG_CONN_TYPE_FIELD_NUMBER = 2;
    public static final int MSG_IP_INFO_FIELD_NUMBER = 3;
    public static final int MSG_LBS_INFO_FIELD_NUMBER = 1;
    public static final int MSG_WIFI_ABI_FIELD_NUMBER = 5;
    public static final int MSG_WIFI_DETAIL_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_extra = PBField.initBytes(ByteStringMicro.EMPTY);
    public C2CType0x211_SubC2CType0x8.ConnType msg_conn_type = new C2CType0x211_SubC2CType0x8.ConnType();
    public C2CType0x211_SubC2CType0x8.IPAddrInfo msg_ip_info = new C2CType0x211_SubC2CType0x8.IPAddrInfo();
    public C2CType0x211_SubC2CType0x8.LBSInfo msg_lbs_info = new C2CType0x211_SubC2CType0x8.LBSInfo();
    public C2CType0x211_SubC2CType0x8.WifiAbility msg_wifi_abi = new C2CType0x211_SubC2CType0x8.WifiAbility();
    public C2CType0x211_SubC2CType0x8.WifiDetailInfo msg_wifi_detail = new C2CType0x211_SubC2CType0x8.WifiDetailInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "msg_lbs_info", "msg_conn_type", "msg_ip_info", "msg_wifi_detail", "msg_wifi_abi", "bytes_extra" }, new Object[] { null, null, null, null, null, localByteStringMicro }, NearfieldInfo.class);
    }
  }
  
  public static final class NotifyList
    extends MessageMicro<NotifyList>
  {
    public static final int NOTIFY_TYPE_FIELD_NUMBER = 1;
    public static final int RPT_MSG_UPDATE_LIST_FIELD_NUMBER = 2;
    public static final int UINT32_SESSION_ID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "notify_type", "rpt_msg_update_list", "uint32_session_id" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, NotifyList.class);
    public final PBEnumField notify_type = PBField.initEnum(0);
    public final PBRepeatMessageField<C2CType0x211_SubC2CType0x8.UpdateInfo> rpt_msg_update_list = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8.UpdateInfo.class);
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  }
  
  public static final class PushJudgeResult
    extends MessageMicro<PushJudgeResult>
  {
    public static final int BYTES_PEER_EXTRA_FIELD_NUMBER = 6;
    public static final int INT32_PEER_IP_FIELD_NUMBER = 4;
    public static final int INT32_PEER_PORT_FIELD_NUMBER = 5;
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_RESULT_FIELD_NUMBER = 3;
    public static final int UINT64_TO_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_peer_extra = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_peer_ip = PBField.initInt32(0);
    public final PBInt32Field int32_peer_port = PBField.initInt32(0);
    public C2CType0x211_SubC2CType0x8.BusiRespHead msg_head = new C2CType0x211_SubC2CType0x8.BusiRespHead();
    public C2CType0x211_SubC2CType0x8.JudgeResult msg_result = new C2CType0x211_SubC2CType0x8.JudgeResult();
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "msg_head", "uint64_to_uin", "msg_result", "int32_peer_ip", "int32_peer_port", "bytes_peer_extra" }, new Object[] { null, Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, PushJudgeResult.class);
    }
  }
  
  public static final class ReqAIOJudge
    extends MessageMicro<ReqAIOJudge>
  {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_NEARFIELD_INFO_FIELD_NUMBER = 3;
    public static final int UINT64_TO_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_head", "uint64_to_uin", "msg_nearfield_info" }, new Object[] { null, Long.valueOf(0L), null }, ReqAIOJudge.class);
    public C2CType0x211_SubC2CType0x8.BusiReqHead msg_head = new C2CType0x211_SubC2CType0x8.BusiReqHead();
    public C2CType0x211_SubC2CType0x8.NearfieldInfo msg_nearfield_info = new C2CType0x211_SubC2CType0x8.NearfieldInfo();
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqExit
    extends MessageMicro<ReqExit>
  {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_NEARFIELD_INFO_FIELD_NUMBER = 3;
    public static final int UINT32_SESSION_ID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_head", "uint32_session_id", "msg_nearfield_info" }, new Object[] { null, Integer.valueOf(0), null }, ReqExit.class);
    public C2CType0x211_SubC2CType0x8.BusiReqHead msg_head = new C2CType0x211_SubC2CType0x8.BusiReqHead();
    public C2CType0x211_SubC2CType0x8.NearfieldInfo msg_nearfield_info = new C2CType0x211_SubC2CType0x8.NearfieldInfo();
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  }
  
  public static final class ReqGetList
    extends MessageMicro<ReqGetList>
  {
    public static final int BYTES_COOKIE_FIELD_NUMBER = 4;
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_NEARFIELD_INFO_FIELD_NUMBER = 2;
    public static final int UINT32_SESSION_ID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public C2CType0x211_SubC2CType0x8.BusiReqHead msg_head = new C2CType0x211_SubC2CType0x8.BusiReqHead();
    public C2CType0x211_SubC2CType0x8.NearfieldInfo msg_nearfield_info = new C2CType0x211_SubC2CType0x8.NearfieldInfo();
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_head", "msg_nearfield_info", "uint32_session_id", "bytes_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, ReqGetList.class);
    }
  }
  
  public static final class ReqReportNearFieldAbi
    extends MessageMicro<ReqReportNearFieldAbi>
  {
    public static final int BYTES_COOKIE_FIELD_NUMBER = 4;
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_NEARFIELD_INFO_FIELD_NUMBER = 3;
    public static final int UINT64_FROM_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public C2CType0x211_SubC2CType0x8.BusiReqHead msg_head = new C2CType0x211_SubC2CType0x8.BusiReqHead();
    public C2CType0x211_SubC2CType0x8.NearfieldInfo msg_nearfield_info = new C2CType0x211_SubC2CType0x8.NearfieldInfo();
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "msg_head", "uint64_from_uin", "msg_nearfield_info", "bytes_cookie" }, new Object[] { null, Long.valueOf(0L), null, localByteStringMicro }, ReqReportNearFieldAbi.class);
    }
  }
  
  public static final class RespAIOJudge
    extends MessageMicro<RespAIOJudge>
  {
    public static final int BYTES_PEER_EXTRA_FIELD_NUMBER = 7;
    public static final int INT32_PEER_IP_FIELD_NUMBER = 5;
    public static final int INT32_PEER_PORT_FIELD_NUMBER = 6;
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int MSG_RESULT_FIELD_NUMBER = 2;
    public static final int UINT32_TIMEOUT_FIELD_NUMBER = 3;
    public static final int UINT64_TO_UIN_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_peer_extra = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_peer_ip = PBField.initInt32(0);
    public final PBInt32Field int32_peer_port = PBField.initInt32(0);
    public C2CType0x211_SubC2CType0x8.BusiRespHead msg_head = new C2CType0x211_SubC2CType0x8.BusiRespHead();
    public C2CType0x211_SubC2CType0x8.JudgeResult msg_result = new C2CType0x211_SubC2CType0x8.JudgeResult();
    public final PBUInt32Field uint32_timeout = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58 }, new String[] { "msg_head", "msg_result", "uint32_timeout", "uint64_to_uin", "int32_peer_ip", "int32_peer_port", "bytes_peer_extra" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RespAIOJudge.class);
    }
  }
  
  public static final class RespExit
    extends MessageMicro<RespExit>
  {
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_head" }, new Object[] { null }, RespExit.class);
    public C2CType0x211_SubC2CType0x8.BusiRespHead msg_head = new C2CType0x211_SubC2CType0x8.BusiRespHead();
  }
  
  public static final class RespGetList
    extends MessageMicro<RespGetList>
  {
    public static final int BYTES_COOKIE_FIELD_NUMBER = 5;
    public static final int INT32_UPDATE_INTERVAL_FIELD_NUMBER = 4;
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    public static final int RPT_MSG_USER_LIST_FIELD_NUMBER = 2;
    public static final int UINT32_SESSION_ID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_update_interval = PBField.initInt32(0);
    public C2CType0x211_SubC2CType0x8.BusiRespHead msg_head = new C2CType0x211_SubC2CType0x8.BusiRespHead();
    public final PBRepeatMessageField<C2CType0x211_SubC2CType0x8.UserProfile> rpt_msg_user_list = PBField.initRepeatMessage(C2CType0x211_SubC2CType0x8.UserProfile.class);
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "msg_head", "rpt_msg_user_list", "uint32_session_id", "int32_update_interval", "bytes_cookie" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RespGetList.class);
    }
  }
  
  public static final class UpdateInfo
    extends MessageMicro<UpdateInfo>
  {
    public static final int MSG_USER_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "msg_user" }, new Object[] { Integer.valueOf(1), null }, UpdateInfo.class);
    public C2CType0x211_SubC2CType0x8.UserProfile msg_user = new C2CType0x211_SubC2CType0x8.UserProfile();
    public final PBEnumField type = PBField.initEnum(1);
  }
  
  public static final class UserAbility
    extends MessageMicro<UserAbility>
  {
    public static final int INT32_ABS_NET_REACHABLECHECK_FIELD_NUMBER = 20;
    public static final int INT32_ABS_NET_SPEED_TEST_FIELD_NUMBER = 21;
    public static final int INT32_ABS_UI_PROMPT_ONCLICK_FIELD_NUMBER = 30;
    public static final int INT32_ABS_UI_PROMPT_PASSIVE_FIELD_NUMBER = 31;
    public static final int INT32_ABS_WIFI_CLIENT_FIELD_NUMBER = 11;
    public static final int INT32_ABS_WIFI_FORCEDCONNECT_FIELD_NUMBER = 13;
    public static final int INT32_ABS_WIFI_FORCEDCREATE_FIELD_NUMBER = 12;
    public static final int INT32_ABS_WIFI_HOST_FIELD_NUMBER = 10;
    public static final int INT32_ABS_WIFI_PASSWORD_FIELD_NUMBER = 14;
    public static final int INT32_SYS_APP_FIELD_NUMBER = 3;
    public static final int INT32_SYS_QLVER_FIELD_NUMBER = 1;
    public static final int INT32_SYS_TERM_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 80, 88, 96, 104, 112, 160, 168, 240, 248 }, new String[] { "int32_sys_qlver", "int32_sys_term", "int32_sys_app", "int32_abs_wifi_host", "int32_abs_wifi_client", "int32_abs_wifi_forcedcreate", "int32_abs_wifi_forcedconnect", "int32_abs_wifi_password", "int32_abs_net_reachablecheck", "int32_abs_net_speed_test", "int32_abs_ui_prompt_onclick", "int32_abs_ui_prompt_passive" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UserAbility.class);
    public final PBInt32Field int32_abs_net_reachablecheck = PBField.initInt32(0);
    public final PBInt32Field int32_abs_net_speed_test = PBField.initInt32(0);
    public final PBInt32Field int32_abs_ui_prompt_onclick = PBField.initInt32(0);
    public final PBInt32Field int32_abs_ui_prompt_passive = PBField.initInt32(0);
    public final PBInt32Field int32_abs_wifi_client = PBField.initInt32(0);
    public final PBInt32Field int32_abs_wifi_forcedconnect = PBField.initInt32(0);
    public final PBInt32Field int32_abs_wifi_forcedcreate = PBField.initInt32(0);
    public final PBInt32Field int32_abs_wifi_host = PBField.initInt32(0);
    public final PBInt32Field int32_abs_wifi_password = PBField.initInt32(0);
    public final PBInt32Field int32_sys_app = PBField.initInt32(0);
    public final PBInt32Field int32_sys_qlver = PBField.initInt32(0);
    public final PBInt32Field int32_sys_term = PBField.initInt32(0);
  }
  
  public static final class UserExtraInfo
    extends MessageMicro<UserExtraInfo>
  {
    public static final int ABILITY_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ability" }, new Object[] { null }, UserExtraInfo.class);
    public C2CType0x211_SubC2CType0x8.UserAbility ability = new C2CType0x211_SubC2CType0x8.UserAbility();
  }
  
  public static final class UserProfile
    extends MessageMicro<UserProfile>
  {
    public static final int BYTES_EXTRA_FIELD_NUMBER = 11;
    public static final int BYTES_TIP_FIELD_NUMBER = 10;
    public static final int BYTES_TMP_TALK_SIG_FIELD_NUMBER = 6;
    public static final int INT32_AGE_FIELD_NUMBER = 4;
    public static final int INT32_FACE_ID_FIELD_NUMBER = 2;
    public static final int INT32_IP_FIELD_NUMBER = 8;
    public static final int INT32_PORT_FIELD_NUMBER = 9;
    public static final int INT32_SEX_FIELD_NUMBER = 3;
    public static final int MSG_RESULT_FIELD_NUMBER = 7;
    public static final int STR_NICK_FIELD_NUMBER = 5;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_extra = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tmp_talk_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_age = PBField.initInt32(0);
    public final PBInt32Field int32_face_id = PBField.initInt32(0);
    public final PBInt32Field int32_ip = PBField.initInt32(0);
    public final PBInt32Field int32_port = PBField.initInt32(0);
    public final PBInt32Field int32_sex = PBField.initInt32(0);
    public C2CType0x211_SubC2CType0x8.JudgeResult msg_result = new C2CType0x211_SubC2CType0x8.JudgeResult();
    public final PBStringField str_nick = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 64, 72, 82, 90 }, new String[] { "uint64_uin", "int32_face_id", "int32_sex", "int32_age", "str_nick", "bytes_tmp_talk_sig", "msg_result", "int32_ip", "int32_port", "bytes_tip", "bytes_extra" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, UserProfile.class);
    }
  }
  
  public static final class Wifi
    extends MessageMicro<Wifi>
  {
    public static final int INT32_RSSI_FIELD_NUMBER = 2;
    public static final int UINT64_MAC_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_mac", "int32_rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, Wifi.class);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
    public final PBUInt64Field uint64_mac = PBField.initUInt64(0L);
  }
  
  public static final class WifiAbility
    extends MessageMicro<WifiAbility>
  {
    public static final int BOOL_AUTO_CONNECT_ABI_FIELD_NUMBER = 2;
    public static final int BOOL_ESTABLISH_ABI_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bool_establish_abi", "bool_auto_connect_abi" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) }, WifiAbility.class);
    public final PBBoolField bool_auto_connect_abi = PBField.initBool(false);
    public final PBBoolField bool_establish_abi = PBField.initBool(false);
  }
  
  public static final class WifiDetailInfo
    extends MessageMicro<WifiDetailInfo>
  {
    public static final int BOOL_SELF_ESTABLISH_FIELD_NUMBER = 1;
    public static final int STR_MAC_FIELD_NUMBER = 3;
    public static final int STR_SSID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "bool_self_establish", "str_ssid", "str_mac" }, new Object[] { Boolean.valueOf(false), "", "" }, WifiDetailInfo.class);
    public final PBBoolField bool_self_establish = PBField.initBool(false);
    public final PBStringField str_mac = PBField.initString("");
    public final PBStringField str_ssid = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8
 * JD-Core Version:    0.7.0.1
 */