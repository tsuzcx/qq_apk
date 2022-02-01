package tencent.im.oidb.cmd0x8dd;

import appoint.define.appoint_define.CommonLabel;
import appoint.define.appoint_define.RptInterestTag;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8dd
{
  public static final class AlumnusConf
    extends MessageMicro<AlumnusConf>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_alumnus_entrance_open", "str_alumnus_pic_url", "str_alumnus_pic_md5" }, new Object[] { Integer.valueOf(0), "", "" }, AlumnusConf.class);
    public final PBStringField str_alumnus_pic_md5 = PBField.initString("");
    public final PBStringField str_alumnus_pic_url = PBField.initString("");
    public final PBUInt32Field uint32_alumnus_entrance_open = PBField.initUInt32(0);
  }
  
  public static final class Anchor1v1Info
    extends MessageMicro<Anchor1v1Info>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 42, 50 }, new String[] { "str_jump_url", "str_wording", "str_tags" }, new Object[] { "", "", "" }, Anchor1v1Info.class);
    public final PBStringField str_jump_url = PBField.initString("");
    public final PBRepeatField<String> str_tags = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_wording = PBField.initString("");
  }
  
  public static final class AnchorCache
    extends MessageMicro<AnchorCache>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_anchor" }, new Object[] { null }, AnchorCache.class);
    public final PBRepeatMessageField<oidb_0x8dd.NearbyPeople> rpt_msg_anchor = PBField.initRepeatMessage(oidb_0x8dd.NearbyPeople.class);
  }
  
  public static final class AnchorCookie
    extends MessageMicro<AnchorCookie>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_index" }, new Object[] { Integer.valueOf(0) }, AnchorCookie.class);
    public final PBUInt32Field uint32_index = PBField.initUInt32(0);
  }
  
  public static final class AnchorInfo
    extends MessageMicro<AnchorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64 }, new String[] { "uint32_live_flag", "str_live_jump_url", "str_live_avatar_gif", "str_live_boardcast_gif", "str_live_wording", "uint32_live_avatar_animation", "love_game_id", "type" }, new Object[] { Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AnchorInfo.class);
    public final PBUInt32Field love_game_id = PBField.initUInt32(0);
    public final PBStringField str_live_avatar_gif = PBField.initString("");
    public final PBStringField str_live_boardcast_gif = PBField.initString("");
    public final PBStringField str_live_jump_url = PBField.initString("");
    public final PBStringField str_live_wording = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_live_avatar_animation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_live_flag = PBField.initUInt32(0);
  }
  
  public static final class CkvCookie
    extends MessageMicro<CkvCookie>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_index", "uint32_uin", "uint32_end" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, CkvCookie.class);
    public final PBUInt32Field uint32_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uin = PBField.initUInt32(0);
  }
  
  public static final class CkvValue
    extends MessageMicro<CkvValue>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_people_cache", "msg_anchor_cache" }, new Object[] { null, null }, CkvValue.class);
    public oidb_0x8dd.AnchorCache msg_anchor_cache = new oidb_0x8dd.AnchorCache();
    public oidb_0x8dd.PeopleCache msg_people_cache = new oidb_0x8dd.PeopleCache();
  }
  
  public static final class Cookie
    extends MessageMicro<Cookie>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_dcache_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8dd.AnchorCookie msg_anchor_cookie = new oidb_0x8dd.AnchorCookie();
    public oidb_0x8dd.CkvCookie msg_ckv_cookie = new oidb_0x8dd.CkvCookie();
    public final PBUInt32Field page_cnt = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "msg_ckv_cookie", "bytes_dcache_cookie", "msg_anchor_cookie", "page_cnt" }, new Object[] { null, localByteStringMicro, null, Integer.valueOf(0) }, Cookie.class);
    }
  }
  
  public static final class FeedInfo
    extends MessageMicro<FeedInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feed_pic" }, new Object[] { "" }, FeedInfo.class);
    public final PBStringField feed_pic = PBField.initString("");
  }
  
  public static final class Filter
    extends MessageMicro<Filter>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72 }, new String[] { "uint32_gender", "uint32_time_interval", "uint32_age_up", "uint32_age_low", "uint32_interest", "uint64_sub_interest", "uint32_profession", "msg_hometown", "uint32_constellation" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, Filter.class);
    public oidb_0x8dd.Hometown msg_hometown = new oidb_0x8dd.Hometown();
    public final PBUInt32Field uint32_age_low = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age_up = PBField.initUInt32(0);
    public final PBUInt32Field uint32_constellation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interest = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time_interval = PBField.initUInt32(0);
    public final PBUInt64Field uint64_sub_interest = PBField.initUInt64(0L);
  }
  
  public static final class Hometown
    extends MessageMicro<Hometown>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_country", "uint32_province", "uint32_city" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Hometown.class);
    public final PBUInt32Field uint32_city = PBField.initUInt32(0);
    public final PBUInt32Field uint32_country = PBField.initUInt32(0);
    public final PBUInt32Field uint32_province = PBField.initUInt32(0);
  }
  
  public static final class LBSInfo
    extends MessageMicro<LBSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_location" }, new Object[] { null }, LBSInfo.class);
    public oidb_0x8dd.Location msg_location = new oidb_0x8dd.Location();
  }
  
  public static final class Location
    extends MessageMicro<Location>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_latitude", "int32_longitude", "int32_coordinate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Location.class);
    public final PBInt32Field int32_coordinate = PBField.initInt32(0);
    public final PBInt32Field int32_latitude = PBField.initInt32(0);
    public final PBInt32Field int32_longitude = PBField.initInt32(0);
  }
  
  public static final class LocationInfo
    extends MessageMicro<LocationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "str_province", "str_city", "str_district", "str_town", "str_road", "str_premises" }, new Object[] { "", "", "", "", "", "" }, LocationInfo.class);
    public final PBStringField str_city = PBField.initString("");
    public final PBStringField str_district = PBField.initString("");
    public final PBStringField str_premises = PBField.initString("");
    public final PBStringField str_province = PBField.initString("");
    public final PBStringField str_road = PBField.initString("");
    public final PBStringField str_town = PBField.initString("");
  }
  
  public static final class LoginConf
    extends MessageMicro<LoginConf>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_login_score" }, new Object[] { null }, LoginConf.class);
    public final PBRepeatMessageField<oidb_0x8dd.LoginScore> rpt_msg_login_score = PBField.initRepeatMessage(oidb_0x8dd.LoginScore.class);
  }
  
  public static final class LoginHistory
    extends MessageMicro<LoginHistory>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_login_info" }, new Object[] { null }, LoginHistory.class);
    public final PBRepeatMessageField<oidb_0x8dd.LoginInfo> rpt_msg_login_info = PBField.initRepeatMessage(oidb_0x8dd.LoginInfo.class);
  }
  
  public static final class LoginInfo
    extends MessageMicro<LoginInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_login_day", "uint32_login_date" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, LoginInfo.class);
    public final PBUInt32Field uint32_login_date = PBField.initUInt32(0);
    public final PBUInt32Field uint32_login_day = PBField.initUInt32(0);
  }
  
  public static final class LoginScore
    extends MessageMicro<LoginScore>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_login_day", "uint32_login_score" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, LoginScore.class);
    public final PBUInt32Field uint32_login_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_login_score = PBField.initUInt32(0);
  }
  
  public static final class NearbyAd
    extends MessageMicro<NearbyAd>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ad = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_postion = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_ad", "uint32_postion", "uint32_source" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, NearbyAd.class);
    }
  }
  
  public static final class NearbyConfig
    extends MessageMicro<NearbyConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 56, 74, 82 }, new String[] { "str_security_tips", "str_security_detail_url", "uint32_use_interest_tag", "msg_alumnus_conf", "msg_recomm_people_conf", "uint32_can_add_sub_interest", "uint32_heart_increment", "msg_video_chat_conf", "msg_login_conf" }, new Object[] { "", "", Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0), null, null }, NearbyConfig.class);
    public oidb_0x8dd.AlumnusConf msg_alumnus_conf = new oidb_0x8dd.AlumnusConf();
    public oidb_0x8dd.LoginConf msg_login_conf = new oidb_0x8dd.LoginConf();
    public oidb_0x8dd.RecommPeopleConf msg_recomm_people_conf = new oidb_0x8dd.RecommPeopleConf();
    public oidb_0x8dd.VideoChatConf msg_video_chat_conf = new oidb_0x8dd.VideoChatConf();
    public final PBStringField str_security_detail_url = PBField.initString("");
    public final PBStringField str_security_tips = PBField.initString("");
    public final PBUInt32Field uint32_can_add_sub_interest = PBField.initUInt32(0);
    public final PBUInt32Field uint32_heart_increment = PBField.initUInt32(0);
    public final PBUInt32Field uint32_use_interest_tag = PBField.initUInt32(0);
  }
  
  public static final class NearbyPeople
    extends MessageMicro<NearbyPeople>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_online = PBField.initBool(false);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_picture_face = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_face = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x8dd.FeedInfo> feed_info = PBField.initRepeatMessage(oidb_0x8dd.FeedInfo.class);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBInt32Field int32_lat = PBField.initInt32(0);
    public final PBInt32Field int32_lon = PBField.initInt32(0);
    public final PBInt32Field is_authen = PBField.initInt32(0);
    public final PBUInt32Field logo_level = PBField.initUInt32(0);
    public oidb_0x8dd.Anchor1v1Info msg_anchor_1v1_info = new oidb_0x8dd.Anchor1v1Info();
    public oidb_0x8dd.AnchorInfo msg_anchor_info = new oidb_0x8dd.AnchorInfo();
    public oidb_0x8dd.ThirdLineInfo msg_third_line_info = new oidb_0x8dd.ThirdLineInfo();
    public final PBUInt64Field now_id = PBField.initUInt64(0L);
    public final PBStringField str_description = PBField.initString("");
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm_shown = PBField.initUInt32(0);
    public final PBUInt32Field uint32_constellation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_god_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_marriage = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
    public final PBUInt32Field uint32_real_video_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vip_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 88, 96, 104, 112, 120, 128, 136, 146, 154, 162, 170, 176, 184, 194, 200, 208, 224, 232, 240, 250 }, new String[] { "uint64_uin", "uint64_tinyid", "uint32_distance", "uint64_timestamp", "int32_lat", "int32_lon", "str_description", "bytes_nick", "uint32_gender", "uint32_age", "uint32_charm", "uint32_charm_level", "uint32_charm_shown", "uint32_profession", "uint32_constellation", "uint32_god_flag", "uint32_vip_type", "msg_third_line_info", "msg_anchor_info", "bytes_video_face", "bytes_picture_face", "uint32_real_video_flag", "bool_online", "msg_anchor_1v1_info", "is_authen", "index", "now_id", "logo_level", "uint32_marriage", "feed_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Boolean.valueOf(false), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, NearbyPeople.class);
    }
  }
  
  public static final class POIDetail
    extends MessageMicro<POIDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 34, 42, 50, 58, 66, 74, 82, 90 }, new String[] { "str_nation", "str_name", "str_province", "str_city", "str_district", "str_town", "str_village", "str_street", "str_street_no", "str_code" }, new Object[] { "", "", "", "", "", "", "", "", "", "" }, POIDetail.class);
    public final PBStringField str_city = PBField.initString("");
    public final PBStringField str_code = PBField.initString("");
    public final PBStringField str_district = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_nation = PBField.initString("");
    public final PBStringField str_province = PBField.initString("");
    public final PBStringField str_street = PBField.initString("");
    public final PBStringField str_street_no = PBField.initString("");
    public final PBStringField str_town = PBField.initString("");
    public final PBStringField str_village = PBField.initString("");
  }
  
  public static final class PeopleCache
    extends MessageMicro<PeopleCache>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_people" }, new Object[] { null }, PeopleCache.class);
    public final PBRepeatMessageField<oidb_0x8dd.NearbyPeople> rpt_msg_people = PBField.initRepeatMessage(oidb_0x8dd.NearbyPeople.class);
  }
  
  public static final class RecommPeopleConf
    extends MessageMicro<RecommPeopleConf>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "str_icon_url", "str_title", "uint32_postion", "uint32_show_num", "recommend_cookie" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "" }, RecommPeopleConf.class);
    public final PBStringField recommend_cookie = PBField.initString("");
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBUInt32Field uint32_postion = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_num = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field areaStat = PBField.initInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qq_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_req_ad = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field code = PBField.initUInt64(0L);
    public oidb_0x8dd.Filter msg_filter = new oidb_0x8dd.Filter();
    public oidb_0x8dd.LBSInfo msg_lbs_info = new oidb_0x8dd.LBSInfo();
    public oidb_0x8dd.ReqCtrl msg_req_ctrl = new oidb_0x8dd.ReqCtrl();
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 58, 64, 72, 80, 90, 96, 104, 114 }, new String[] { "bytes_cookie", "uint32_source_type", "msg_lbs_info", "msg_filter", "bytes_req_ad", "msg_req_ctrl", "uint32_gender", "uint32_client_version", "uint32_client_type", "bytes_qq_version", "code", "areaStat", "bytes_recommend_cookie" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), null, null, localByteStringMicro2, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro4 }, ReqBody.class);
    }
  }
  
  public static final class ReqCtrl
    extends MessageMicro<ReqCtrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104 }, new String[] { "uint32_req_uin", "uint32_req_tinyid", "uint32_req_anchor", "uint32_req_ad", "uint32_req_self", "uint32_req_safe", "uint32_req_check_in", "uint32_req_people_number", "uint32_req_none", "uint32_req_third_line", "uint32_req_sort_algorithm", "uint32_req_from_web", "uint32_req_recommend_cookie" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqCtrl.class);
    public final PBUInt32Field uint32_req_ad = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_anchor = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_check_in = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_from_web = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_none = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_people_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_recommend_cookie = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_safe = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_self = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_sort_algorithm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_third_line = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_tinyid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_uin = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8dd.NearbyConfig msg_config = new oidb_0x8dd.NearbyConfig();
    public oidb_0x8dd.LBSInfo msg_lbs_info = new oidb_0x8dd.LBSInfo();
    public oidb_0x8dd.SelfInfo msg_self_info = new oidb_0x8dd.SelfInfo();
    public final PBRepeatMessageField<oidb_0x8dd.NearbyAd> rpt_nearby_ad = PBField.initRepeatMessage(oidb_0x8dd.NearbyAd.class);
    public final PBRepeatMessageField<oidb_0x8dd.NearbyPeople> rpt_nearby_people = PBField.initRepeatMessage(oidb_0x8dd.NearbyPeople.class);
    public final PBRepeatMessageField<oidb_0x8dd.NearbyPeople> rpt_recomm_people = PBField.initRepeatMessage(oidb_0x8dd.NearbyPeople.class);
    public final PBStringField str_result_msg = PBField.initString("");
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result_code = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 66, 72, 82 }, new String[] { "bytes_cookie", "uint32_is_end", "msg_config", "msg_self_info", "rpt_nearby_people", "rpt_recomm_people", "rpt_nearby_ad", "msg_lbs_info", "uint32_result_code", "str_result_msg" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null, null, null, null, null, null, Integer.valueOf(0), "" }, RspBody.class);
    }
  }
  
  public static final class SelfInfo
    extends MessageMicro<SelfInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_birthday = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8dd.LoginScore msg_cur_login_score = new oidb_0x8dd.LoginScore();
    public final PBStringField str_third_line_icon = PBField.initString("");
    public final PBStringField str_third_line_info = PBField.initString("");
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_all_task_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charm_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_finish_task_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_god_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_heart_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_real_video_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vote_increment = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vote_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 72, 80, 90, 98, 104, 112, 122, 128, 136 }, new String[] { "uint64_tinyid", "uint32_gender", "uint32_age", "bytes_birthday", "bytes_nick", "uint32_vote_num", "uint32_vote_increment", "uint32_charm", "uint32_charm_level", "uint32_god_flag", "str_third_line_info", "str_third_line_icon", "uint32_heart_num", "uint32_real_video_flag", "msg_cur_login_score", "uint32_finish_task_num", "uint32_all_task_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, SelfInfo.class);
    }
  }
  
  public static final class ThirdLineInfo
    extends MessageMicro<ThirdLineInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_common_label = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_interest_tag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rich_state = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rich_state2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_third_line_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_third_line_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.CommonLabel common_label = new appoint_define.CommonLabel();
    public final PBUInt32Field identity_type = PBField.initUInt32(0);
    public final PBBytesField identity_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public appoint_define.RptInterestTag interest_tag = new appoint_define.RptInterestTag();
    public final PBUInt32Field mark_type = PBField.initUInt32(0);
    public final PBBytesField mark_word = PBField.initBytes(ByteStringMicro.EMPTY);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 72, 82, 88, 98 }, new String[] { "bytes_third_line_icon", "bytes_third_line_info", "bytes_common_label", "bytes_interest_tag", "bytes_rich_state", "common_label", "interest_tag", "bytes_rich_state2", "identity_type", "identity_word", "mark_type", "mark_word" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, null, null, localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), localByteStringMicro8 }, ThirdLineInfo.class);
    }
  }
  
  public static final class VideoChatConf
    extends MessageMicro<VideoChatConf>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 24 }, new String[] { "uint32_video_chat_num" }, new Object[] { Integer.valueOf(0) }, VideoChatConf.class);
    public final PBUInt32Field uint32_video_chat_num = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd
 * JD-Core Version:    0.7.0.1
 */