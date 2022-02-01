package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdb1
{
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_lat", "int32_lon", "int32_alt", "int32_type" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(-10000000), Integer.valueOf(0) }, GPS.class);
    public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBInt32Field int32_type = PBField.initInt32(0);
  }
  
  public static final class LBSInfo
    extends MessageMicro<LBSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_gps", "rpt_msg_wifis", "rpt_msg_cells" }, new Object[] { null, null, null }, LBSInfo.class);
    public oidb_0xdb1.GPS msg_gps = new oidb_0xdb1.GPS();
    public final PBRepeatMessageField<oidb_0xdb1.Cell> rpt_msg_cells = PBField.initRepeatMessage(oidb_0xdb1.Cell.class);
    public final PBRepeatMessageField<oidb_0xdb1.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(oidb_0xdb1.Wifi.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_get_search_keywords", "uint32_get_online_num", "msg_lbs_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
    public oidb_0xdb1.LBSInfo msg_lbs_info = new oidb_0xdb1.LBSInfo();
    public final PBUInt32Field uint32_get_online_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_get_search_keywords = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 66, 74, 82, 90, 98, 106, 112, 120, 128, 136, 144 }, new String[] { "uint64_allow_kuolie", "uint32_match_count", "str_func_name", "uint64_expire_time", "uint32_left_chat_time", "uint64_voice_match_flag", "enum_school_verify_status", "str_school_verify_tips", "str_suggest_school_name", "msg_kuolie_school_info", "msg_new_school_info", "msg_voice_search_keywords", "msg_campus_search_keywords", "uint32_online_num", "uint32_need_display_school_info", "uint32_user_identity", "uint32_forbid_flag", "uint32_forbid_end_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
    public final PBEnumField enum_school_verify_status = PBField.initEnum(0);
    public final PBRepeatMessageField<oidb_0xdb1.SearchKeyWord> msg_campus_search_keywords = PBField.initRepeatMessage(oidb_0xdb1.SearchKeyWord.class);
    public oidb_0xdb1.SchoolInfo msg_kuolie_school_info = new oidb_0xdb1.SchoolInfo();
    public oidb_0xdb1.SchoolInfo msg_new_school_info = new oidb_0xdb1.SchoolInfo();
    public final PBRepeatMessageField<oidb_0xdb1.SearchKeyWord> msg_voice_search_keywords = PBField.initRepeatMessage(oidb_0xdb1.SearchKeyWord.class);
    public final PBStringField str_func_name = PBField.initString("");
    public final PBStringField str_school_verify_tips = PBField.initString("");
    public final PBStringField str_suggest_school_name = PBField.initString("");
    public final PBUInt64Field uint32_forbid_end_time = PBField.initUInt64(0L);
    public final PBUInt32Field uint32_forbid_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_left_chat_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_match_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_display_school_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_identity = PBField.initUInt32(0);
    public final PBUInt64Field uint64_allow_kuolie = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_expire_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_voice_match_flag = PBField.initUInt64(0L);
  }
  
  public static final class SchoolInfo
    extends MessageMicro<SchoolInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 800 }, new String[] { "uint32_category", "str_school_id", "str_school_name", "str_department_id", "str_department_name", "uint32_degree", "uint32_enrollment_year", "uint32_graduation_year", "uint32_allow_recommend", "uint32_create_source", "uint32_create_time", "uint32_update_source", "uint32_update_time", "uint32_hidden_flag", "uint32_verify_status", "uint32_verify_type", "uint32_idx" }, new Object[] { Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SchoolInfo.class);
    public final PBStringField str_department_id = PBField.initString("");
    public final PBStringField str_department_name = PBField.initString("");
    public final PBStringField str_school_id = PBField.initString("");
    public final PBStringField str_school_name = PBField.initString("");
    public final PBUInt32Field uint32_allow_recommend = PBField.initUInt32(0);
    public final PBUInt32Field uint32_category = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_degree = PBField.initUInt32(0);
    public final PBUInt32Field uint32_enrollment_year = PBField.initUInt32(0);
    public final PBUInt32Field uint32_graduation_year = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hidden_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_verify_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_verify_type = PBField.initUInt32(0);
  }
  
  public static final class SearchKeyWord
    extends MessageMicro<SearchKeyWord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_school_name", "str_school_id" }, new Object[] { "", "" }, SearchKeyWord.class);
    public final PBStringField str_school_id = PBField.initString("");
    public final PBStringField str_school_name = PBField.initString("");
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
 * Qualified Name:     tencent.im.oidb.cmd0xdb1.oidb_0xdb1
 * JD-Core Version:    0.7.0.1
 */