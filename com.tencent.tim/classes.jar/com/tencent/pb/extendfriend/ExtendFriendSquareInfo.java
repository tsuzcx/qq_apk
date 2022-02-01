package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ExtendFriendSquareInfo
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
    public ExtendFriendSquareInfo.GPS msg_gps = new ExtendFriendSquareInfo.GPS();
    public final PBRepeatMessageField<ExtendFriendSquareInfo.Cell> rpt_msg_cells = PBField.initRepeatMessage(ExtendFriendSquareInfo.Cell.class);
    public final PBRepeatMessageField<ExtendFriendSquareInfo.Wifi> rpt_msg_wifis = PBField.initRepeatMessage(ExtendFriendSquareInfo.Wifi.class);
  }
  
  public static final class PageCookie
    extends MessageMicro<PageCookie>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_attach_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> rpt_ad_pos = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_ad_cnt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_idx = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_start_idx", "bytes_attach_info", "rpt_ad_pos", "uint32_ad_cnt" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, PageCookie.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_req_buff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_req_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public ExtendFriendSquareInfo.LBSInfo msg_lbs_info = new ExtendFriendSquareInfo.LBSInfo();
    public final PBBytesField str_keyword = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_get_online_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 58 }, new String[] { "uint64_uin", "bytes_req_page_cookies", "uint32_req_num", "str_keyword", "bytes_req_buff", "uint32_get_online_number", "msg_lbs_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_feedback_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rsp_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<ExtendFriendSquareInfo.StrangerInfo> rpt_msg_stranger_info = PBField.initRepeatMessage(ExtendFriendSquareInfo.StrangerInfo.class);
    public final PBUInt32Field uint32_friend_max_votes = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_profile_complete = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_show_card = PBField.initUInt32(0);
    public final PBUInt32Field uint32_match_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_match_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66, 72, 80, 106, 112, 120, 128 }, new String[] { "uint64_uin", "uint32_over", "bytes_rsp_page_cookies", "uint32_total_count", "rpt_msg_stranger_info", "uint32_is_profile_complete", "uint32_is_show_card", "bytes_cover_url", "uint32_gender", "uint32_friend_max_votes", "bytes_feedback_context", "uint32_match_count", "uint32_match_time", "uint32_online_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    }
  }
  
  public static final class StrangerInfo
    extends MessageMicro<StrangerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ad_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_declaration = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_personalization = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tmp_session_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_voice_code = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_voice_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<ExtendFriendSquareInfo.labelInfo> rpt_label_info = PBField.initRepeatMessage(ExtendFriendSquareInfo.labelInfo.class);
    public final PBRepeatMessageField<ExtendFriendSquareInfo.schoolInfo> rpt_school_info = PBField.initRepeatMessage(ExtendFriendSquareInfo.schoolInfo.class);
    public final PBStringField str_recom_trace = PBField.initString("");
    public final PBUInt32Field uint32_addfri_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bigvip_hide = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bigvip_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bigvip_open = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_my_like = PBField.initUInt32(0);
    public final PBUInt32Field uint32_my_left_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_popularity = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_vip_info_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_svip_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vip_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vipicon_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vote_switch = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_update_time = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56, 66, 74, 80, 90, 96, 112, 120, 128, 138, 144, 152, 160, 168, 176, 184, 192, 202, 210, 218, 224, 234, 242 }, new String[] { "uint64_uin", "bytes_cover_url", "uint32_total_like_count", "uint32_is_my_like", "uint32_my_left_like_count", "bytes_nick", "uint32_popularity", "bytes_declaration", "bytes_voice_url", "uint64_update_time", "bytes_tmp_session_sig", "uint32_voice_duration", "uint32_gender", "uint32_addfri_status", "uint32_vote_switch", "str_recom_trace", "uint32_show_vip_info_flag", "uint32_svip_level", "uint32_vipicon_id", "uint32_bigvip_level", "uint32_bigvip_open", "uint32_bigvip_hide", "uint32_vip_flag", "bytes_ad_content", "bytes_personalization", "rpt_label_info", "uint32_age", "bytes_voice_code", "rpt_school_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, null, Integer.valueOf(0), localByteStringMicro8, null }, StrangerInfo.class);
    }
  }
  
  public static final class Wifi
    extends MessageMicro<Wifi>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_mac", "int32_rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, Wifi.class);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
    public final PBUInt64Field uint64_mac = PBField.initUInt64(0L);
  }
  
  public static final class labelInfo
    extends MessageMicro<labelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_label_id", "str_label_name" }, new Object[] { Long.valueOf(0L), "" }, labelInfo.class);
    public final PBStringField str_label_name = PBField.initString("");
    public final PBUInt64Field uint64_label_id = PBField.initUInt64(0L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.extendfriend.ExtendFriendSquareInfo
 * JD-Core Version:    0.7.0.1
 */