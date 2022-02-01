package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe03
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
    public oidb_0xe03.GPS msg_gps = new oidb_0xe03.GPS();
    public final PBRepeatMessageField<oidb_0xe03.Cell> rpt_msg_cells = PBField.initRepeatMessage(oidb_0xe03.Cell.class);
    public final PBRepeatMessageField<oidb_0xe03.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(oidb_0xe03.Wifi.class);
  }
  
  public static final class MatchInfo
    extends MessageMicro<MatchInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xe03.MatchUinData msg_match_uin_data = new oidb_0xe03.MatchUinData();
    public oidb_0xe03.TagInfo msg_tag = new oidb_0xe03.TagInfo();
    public final PBStringField string_report_id = PBField.initString("");
    public final PBUInt32Field uint32_match_expired_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_room_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_match_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time_stamp = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48, 58, 66, 74, 88 }, new String[] { "bytes_sig", "uint64_match_uin", "bytes_tips_wording", "bytes_nick", "uint64_time_stamp", "uint32_match_expired_time", "string_report_id", "msg_tag", "msg_match_uin_data", "uint32_room_id" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), "", null, null, Integer.valueOf(0) }, MatchInfo.class);
    }
  }
  
  public static final class MatchUinData
    extends MessageMicro<MatchUinData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_company = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_constellation = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_declaration = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_long_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_school = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_voice_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xe03.LBSInfo msg_lbs_info = new oidb_0xe03.LBSInfo();
    public final PBRepeatMessageField<oidb_0xe03.schoolInfo> rpt_school_info = PBField.initRepeatMessage(oidb_0xe03.schoolInfo.class);
    public final PBRepeatMessageField<oidb_0xe03.ProfileTagInfo> rpt_tag = PBField.initRepeatMessage(oidb_0xe03.ProfileTagInfo.class);
    public final PBStringField str_from_city_name = PBField.initString("");
    public final PBStringField str_to_city_name = PBField.initString("");
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
    public final PBUInt32Field uint32_match_pool = PBField.initUInt32(0);
    public final PBUInt32Field uint32_popularity = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_duration = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 72, 80, 90, 98, 114, 120, 130, 136, 144, 154, 162 }, new String[] { "uint32_age", "bytes_constellation", "bytes_city", "bytes_school", "rpt_tag", "bytes_company", "bytes_declaration", "bytes_voice_url", "uint32_voice_duration", "uint32_sex", "bytes_long_nick", "bytes_nick", "rpt_school_info", "uint32_popularity", "msg_lbs_info", "uint32_distance", "uint32_match_pool", "str_from_city_name", "str_to_city_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), "", "" }, MatchUinData.class);
    }
  }
  
  public static final class ProfileTagInfo
    extends MessageMicro<ProfileTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_same_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_tag", "uint32_same_flag" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ProfileTagInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "uint64_uin", "enum_matchopcode", "uint64_match_uin", "uint32_tag_id", "uint32_sex", "uint32_switch", "uint64_client_version", "msg_lbs_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null }, ReqBody.class);
    public final PBEnumField enum_matchopcode = PBField.initEnum(1);
    public oidb_0xe03.LBSInfo msg_lbs_info = new oidb_0xe03.LBSInfo();
    public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
    public final PBUInt32Field uint32_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_client_version = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_match_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_match_fail_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_matchopcode = PBField.initEnum(1);
    public final PBEnumField enum_matchopretcode = PBField.initEnum(0);
    public oidb_0xe03.MatchInfo msg_match_info = new oidb_0xe03.MatchInfo();
    public final PBRepeatMessageField<oidb_0xe03.TagInfo> rpt_tag = PBField.initRepeatMessage(oidb_0xe03.TagInfo.class);
    public final PBRepeatField<ByteStringMicro> rpt_tips_wording = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_default_tag_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flare_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time_out = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    public final PBRepeatField<Long> uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_voice_match_flag = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 72, 82, 90, 98, 104, 112, 120, 128, 136, 144 }, new String[] { "uint64_uin", "enum_matchopcode", "enum_matchopretcode", "msg_match_info", "uint32_switch", "uint32_default_tag_id", "rpt_tag", "rpt_tips_wording", "bytes_match_fail_wording", "uint32_count", "uint64_uin_list", "uint32_time_out", "uint32_voice_count", "uint64_voice_match_flag", "uint32_flare_switch" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
    }
  }
  
  public static final class TagInfo
    extends MessageMicro<TagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_hot_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_tag_id", "bytes_tag", "uint32_hot_flag" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, TagInfo.class);
    }
  }
  
  public static final class Wifi
    extends MessageMicro<Wifi>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_mac", "int32_rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, Wifi.class);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
    public final PBUInt64Field uint64_mac = PBField.initUInt64(0L);
  }
  
  public static final class schoolInfo
    extends MessageMicro<schoolInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "str_school_id", "str_school_name", "uint64_state" }, new Object[] { "", "", Long.valueOf(0L) }, schoolInfo.class);
    public final PBStringField str_school_id = PBField.initString("");
    public final PBStringField str_school_name = PBField.initString("");
    public final PBUInt64Field uint64_state = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe03.oidb_0xe03
 * JD-Core Version:    0.7.0.1
 */