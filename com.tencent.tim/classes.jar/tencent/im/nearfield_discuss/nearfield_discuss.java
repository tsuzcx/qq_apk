package tencent.im.nearfield_discuss;

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

public final class nearfield_discuss
{
  public static final class BusiReqHead
    extends MessageMicro<BusiReqHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_version", "int32_seq" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, BusiReqHead.class);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
    public final PBInt32Field int32_version = PBField.initInt32(1);
  }
  
  public static final class BusiRespHead
    extends MessageMicro<BusiRespHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_version", "int32_seq", "int32_reply_code", "str_result" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), "" }, BusiRespHead.class);
    public final PBInt32Field int32_reply_code = PBField.initInt32(0);
    public final PBInt32Field int32_seq = PBField.initInt32(0);
    public final PBInt32Field int32_version = PBField.initInt32(1);
    public final PBStringField str_result = PBField.initString("");
  }
  
  public static final class Cell
    extends MessageMicro<Cell>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "int32_mcc", "int32_mnc", "int32_lac", "int32_cellid", "int32_rssi" }, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(0) }, Cell.class);
    public final PBInt32Field int32_cellid = PBField.initInt32(-1);
    public final PBInt32Field int32_lac = PBField.initInt32(-1);
    public final PBInt32Field int32_mcc = PBField.initInt32(-1);
    public final PBInt32Field int32_mnc = PBField.initInt32(-1);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_lat", "int32_lon", "int32_alt", "eType" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(-10000000), Integer.valueOf(0) }, GPS.class);
    public final PBEnumField eType = PBField.initEnum(0);
    public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  }
  
  public static final class LBSInfo
    extends MessageMicro<LBSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
    public nearfield_discuss.GPS msg_gps = new nearfield_discuss.GPS();
    public final PBRepeatMessageField<nearfield_discuss.Cell> rpt_msg_cells = PBField.initRepeatMessage(nearfield_discuss.Cell.class);
    public final PBRepeatMessageField<nearfield_discuss.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(nearfield_discuss.Wifi.class);
  }
  
  public static final class NotifyList
    extends MessageMicro<NotifyList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "notify_type", "rpt_msg_update_list", "uint32_session_id" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, NotifyList.class);
    public final PBEnumField notify_type = PBField.initEnum(0);
    public final PBRepeatMessageField<nearfield_discuss.UpdateInfo> rpt_msg_update_list = PBField.initRepeatMessage(nearfield_discuss.UpdateInfo.class);
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  }
  
  public static final class ReqExit
    extends MessageMicro<ReqExit>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "msg_head", "msg_lbs_info", "str_number", "uint32_session_id" }, new Object[] { null, null, "", Integer.valueOf(0) }, ReqExit.class);
    public nearfield_discuss.BusiReqHead msg_head = new nearfield_discuss.BusiReqHead();
    public nearfield_discuss.LBSInfo msg_lbs_info = new nearfield_discuss.LBSInfo();
    public final PBStringField str_number = PBField.initString("");
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  }
  
  public static final class ReqGetList
    extends MessageMicro<ReqGetList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public nearfield_discuss.BusiReqHead msg_head = new nearfield_discuss.BusiReqHead();
    public nearfield_discuss.LBSInfo msg_lbs_info = new nearfield_discuss.LBSInfo();
    public final PBStringField str_number = PBField.initString("");
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "msg_head", "msg_lbs_info", "str_number", "uint32_session_id", "bytes_cookie" }, new Object[] { null, null, "", Integer.valueOf(0), localByteStringMicro }, ReqGetList.class);
    }
  }
  
  public static final class ReqJoinDiscuss
    extends MessageMicro<ReqJoinDiscuss>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "msg_head", "msg_lbs_info", "str_number", "uint32_session_id", "uint32_join_type" }, new Object[] { null, null, "", Integer.valueOf(0), Integer.valueOf(0) }, ReqJoinDiscuss.class);
    public nearfield_discuss.BusiReqHead msg_head = new nearfield_discuss.BusiReqHead();
    public nearfield_discuss.LBSInfo msg_lbs_info = new nearfield_discuss.LBSInfo();
    public final PBStringField str_number = PBField.initString("");
    public final PBUInt32Field uint32_join_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  }
  
  public static final class RespExit
    extends MessageMicro<RespExit>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_head" }, new Object[] { null }, RespExit.class);
    public nearfield_discuss.BusiRespHead msg_head = new nearfield_discuss.BusiRespHead();
  }
  
  public static final class RespGetList
    extends MessageMicro<RespGetList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_update_interval = PBField.initInt32(0);
    public nearfield_discuss.BusiRespHead msg_head = new nearfield_discuss.BusiRespHead();
    public final PBRepeatMessageField<nearfield_discuss.UserProfile> rpt_msg_user_list = PBField.initRepeatMessage(nearfield_discuss.UserProfile.class);
    public final PBUInt32Field uint32_button_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_has_created = PBField.initUInt32(0);
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_creator = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 64 }, new String[] { "msg_head", "rpt_msg_user_list", "uint32_session_id", "int32_update_interval", "bytes_cookie", "uint32_button_switch", "uint32_has_created", "uint64_creator" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, RespGetList.class);
    }
  }
  
  public static final class RespJoinDiscuss
    extends MessageMicro<RespJoinDiscuss>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "msg_head", "str_number", "uint32_session_id", "uint32_discuss_id", "bool_is_creater", "uint32_join_type" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, RespJoinDiscuss.class);
    public final PBBoolField bool_is_creater = PBField.initBool(false);
    public nearfield_discuss.BusiRespHead msg_head = new nearfield_discuss.BusiRespHead();
    public final PBStringField str_number = PBField.initString("");
    public final PBUInt32Field uint32_discuss_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  }
  
  public static final class UpdateInfo
    extends MessageMicro<UpdateInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "msg_user" }, new Object[] { Integer.valueOf(1), null }, UpdateInfo.class);
    public nearfield_discuss.UserProfile msg_user = new nearfield_discuss.UserProfile();
    public final PBEnumField type = PBField.initEnum(1);
  }
  
  public static final class UserProfile
    extends MessageMicro<UserProfile>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_uin", "int32_face_id", "int32_sex", "int32_age", "str_nick" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, UserProfile.class);
    public final PBInt32Field int32_age = PBField.initInt32(0);
    public final PBInt32Field int32_face_id = PBField.initInt32(0);
    public final PBInt32Field int32_sex = PBField.initInt32(0);
    public final PBStringField str_nick = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class Wifi
    extends MessageMicro<Wifi>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_mac", "int32_rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, Wifi.class);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
    public final PBUInt64Field uint64_mac = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.nearfield_discuss.nearfield_discuss
 * JD-Core Version:    0.7.0.1
 */