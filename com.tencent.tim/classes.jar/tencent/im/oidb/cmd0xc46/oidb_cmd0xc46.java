package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc46
{
  public static final class Activity
    extends MessageMicro<Activity>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "config_id" }, new Object[] { Long.valueOf(0L) }, Activity.class);
    public final PBInt64Field config_id = PBField.initInt64(0L);
  }
  
  public static final class AdReqInfo
    extends MessageMicro<AdReqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_ad_channel_id" }, new Object[] { Integer.valueOf(0) }, AdReqInfo.class);
    public final PBUInt32Field uint64_ad_channel_id = PBField.initUInt32(0);
  }
  
  public static final class AdRspInfo
    extends MessageMicro<AdRspInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { localByteStringMicro }, AdRspInfo.class);
    }
  }
  
  public static final class ArticleInfo
    extends MessageMicro<ArticleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "comment_count", "forbidden", "use_black_menu", "has_anchor" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ArticleInfo.class);
    public final PBUInt64Field comment_count = PBField.initUInt64(0L);
    public final PBUInt32Field forbidden = PBField.initUInt32(0);
    public final PBInt32Field has_anchor = PBField.initInt32(0);
    public final PBInt32Field use_black_menu = PBField.initInt32(0);
  }
  
  public static final class Banner
    extends MessageMicro<Banner>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "title", "jump_url", "config_id" }, new Object[] { "", "", Long.valueOf(0L) }, Banner.class);
    public final PBInt64Field config_id = PBField.initInt64(0L);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
  }
  
  public static final class Comment
    extends MessageMicro<Comment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_cmd0xc46.Activity activity = new oidb_cmd0xc46.Activity();
    public oidb_cmd0xc46.AdRspInfo ad_rsp_info = new oidb_cmd0xc46.AdRspInfo();
    public final PBInt32Field anonymous = PBField.initInt32(0);
    public final PBStringField author_comment = PBField.initString("");
    public final PBStringField author_id = PBField.initString("");
    public final PBInt32Field author_selection = PBField.initInt32(0);
    public final PBStringField avatar = PBField.initString("");
    public final PBUInt32Field awesome = PBField.initUInt32(0);
    public final PBStringField comment_id = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBInt32Field content_source = PBField.initInt32(0);
    public final PBInt32Field create_source = PBField.initInt32(0);
    public final PBInt64Field create_time = PBField.initInt64(0L);
    public final PBInt32Field dislike = PBField.initInt32(0);
    public final PBUInt32Field family_id = PBField.initUInt32(0);
    public final PBStringField first_comment_id = PBField.initString("");
    public final PBUInt32Field has_target = PBField.initUInt32(0);
    public final PBStringField homepage = PBField.initString("");
    public final PBUInt32Field is_activity = PBField.initUInt32(0);
    public final PBUInt32Field is_ad = PBField.initUInt32(0);
    public final PBUInt32Field is_anchor = PBField.initUInt32(0);
    public final PBUInt32Field is_approved = PBField.initUInt32(0);
    public final PBUInt32Field is_author_reply = PBField.initUInt32(0);
    public final PBUInt32Field is_delete = PBField.initUInt32(0);
    public final PBUInt32Field is_multi_media = PBField.initUInt32(0);
    public final PBUInt32Field is_star = PBField.initUInt32(0);
    public final PBUInt32Field is_star_comment = PBField.initUInt32(0);
    public final PBStringField jump_schema = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField ks_homepage = PBField.initString("");
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBInt32Field like = PBField.initInt32(0);
    public final PBInt32Field like_num = PBField.initInt32(0);
    public oidb_cmd0xc46.MediaData media_data = new oidb_cmd0xc46.MediaData();
    public final PBInt32Field myself = PBField.initInt32(0);
    public final PBStringField nick_name = PBField.initString("");
    public final PBBytesField passthrough = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField pic_url = PBField.initString("");
    public final PBInt32Field rank = PBField.initInt32(0);
    public final PBStringField replied_user_homepage = PBField.initString("");
    public final PBStringField replied_user_id = PBField.initString("");
    public final PBStringField replied_user_nick_name = PBField.initString("");
    public final PBStringField rowkey = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xc46.MedalInfo> rpt_medal_info_list = PBField.initRepeatMessage(oidb_cmd0xc46.MedalInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xc46.MediaData> rpt_media_data_list = PBField.initRepeatMessage(oidb_cmd0xc46.MediaData.class);
    public final PBInt64Field score = PBField.initInt64(0L);
    public final PBStringField style_data = PBField.initString("");
    public final PBRepeatMessageField<Comment> sub_comments = PBField.initRepeatMessage(Comment.class);
    public final PBUInt32Field sub_comments_total = PBField.initUInt32(0);
    public final PBStringField user_title = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64, 72, 80, 88, 98, 106, 114, 120, 130, 136, 146, 152, 160, 170, 242, 250, 258, 266, 272, 320, 330, 336, 344, 354, 362, 368, 378, 386, 392, 402, 408, 416, 424, 432, 442, 450, 456, 466, 474, 482, 488, 496, 506 }, new String[] { "comment_id", "author_id", "create_time", "content", "like", "dislike", "like_num", "anonymous", "author_selection", "rank", "level", "author_comment", "nick_name", "avatar", "myself", "homepage", "awesome", "rowkey", "content_source", "sub_comments_total", "sub_comments", "first_comment_id", "replied_user_id", "replied_user_nick_name", "replied_user_homepage", "has_target", "score", "passthrough", "is_delete", "is_anchor", "pic_url", "jump_url", "is_activity", "rpt_medal_info_list", "activity", "is_multi_media", "media_data", "is_star_comment", "create_source", "is_star", "is_approved", "jump_schema", "rpt_media_data_list", "is_author_reply", "user_title", "ks_homepage", "style_data", "family_id", "is_ad", "ad_rsp_info" }, new Object[] { "", "", Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null, "", "", "", "", Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), null, null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), null }, Comment.class);
    }
  }
  
  public static final class ExtraInfo
    extends MessageMicro<ExtraInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField family_oc_info = PBField.initString("");
    public final PBUInt32Field hidden_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field hot_next = PBField.initUInt32(0);
    public final PBBytesField hot_page_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField jump_kva_schema = PBField.initString("");
    public final PBUInt32Field show_mask = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "hot_next", "hot_page_cookie", "hidden_comment_count", "show_mask", "jump_kva_schema", "family_oc_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), "", "" }, ExtraInfo.class);
    }
  }
  
  public static final class MedalInfo
    extends MessageMicro<MedalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_jump = PBField.initUInt32(0);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field medal_id = PBField.initUInt64(0L);
    public final PBBytesField medal_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field medal_type = PBField.initUInt32(0);
    public final PBBytesField medal_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field pic_height = PBField.initUInt32(0);
    public final PBUInt32Field pic_width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64 }, new String[] { "medal_id", "medal_name", "medal_url", "medal_type", "is_jump", "jump_url", "pic_width", "pic_height" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, MedalInfo.class);
    }
  }
  
  public static final class MediaData
    extends MessageMicro<MediaData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 64, 72, 82 }, new String[] { "text", "pic_url", "pic_width", "pic_length", "sound_url", "sound_duration", "video_url", "video_duration", "media_type", "thumbnail_url" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, MediaData.class);
    public final PBUInt32Field media_type = PBField.initUInt32(0);
    public final PBUInt32Field pic_length = PBField.initUInt32(0);
    public final PBStringField pic_url = PBField.initString("");
    public final PBUInt32Field pic_width = PBField.initUInt32(0);
    public final PBUInt32Field sound_duration = PBField.initUInt32(0);
    public final PBStringField sound_url = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField thumbnail_url = PBField.initString("");
    public final PBUInt32Field video_duration = PBField.initUInt32(0);
    public final PBStringField video_url = PBField.initString("");
  }
  
  public static final class PageCookie
    extends MessageMicro<PageCookie>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "index", "last_timestamp" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, PageCookie.class);
    public final PBInt32Field index = PBField.initInt32(0);
    public final PBInt64Field last_timestamp = PBField.initInt64(0L);
  }
  
  public static final class PhoneInfo
    extends MessageMicro<PhoneInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ads_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_client_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_device_brand_and_model = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_manufacturer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_muid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_os_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qq_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wx_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField string_androidid = PBField.initString("");
    public final PBStringField string_client_ipv4 = PBField.initString("");
    public final PBStringField string_idfa = PBField.initString("");
    public final PBStringField string_imei = PBField.initString("");
    public final PBStringField string_mac = PBField.initString("");
    public final PBStringField string_oaid = PBField.initString("");
    public final PBStringField string_qadid = PBField.initString("");
    public final PBStringField string_taid = PBField.initString("");
    public final PBUInt32Field uint32_carrier = PBField.initUInt32(0);
    public final PBUInt32Field uint32_conn = PBField.initUInt32(0);
    public final PBUInt32Field uint32_muid_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_os_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_func_flag = PBField.initUInt64(0L);
    
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
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66, 72, 80, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178 }, new String[] { "bytes_muid", "uint32_conn", "uint32_carrier", "uint32_muid_type", "bytes_os_ver", "bytes_qq_ver", "bytes_client_ip", "bytes_appid", "uint32_os_type", "uint64_func_flag", "bytes_ads_context", "bytes_manufacturer", "bytes_device_brand_and_model", "string_qadid", "string_oaid", "string_taid", "string_androidid", "string_mac", "string_client_ipv4", "string_imei", "string_idfa", "bytes_wx_ver" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, "", "", "", "", "", "", "", "", localByteStringMicro9 }, PhoneInfo.class);
    }
  }
  
  public static final class ReqAdvertisePara
    extends MessageMicro<ReqAdvertisePara>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ad_user_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xc46.AdReqInfo msg_ad_req_info = new oidb_cmd0xc46.AdReqInfo();
    public oidb_cmd0xc46.PhoneInfo msg_phone_info = new oidb_cmd0xc46.PhoneInfo();
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint64_channel_id", "msg_phone_info", "uint64_last_time", "bytes_ad_user_info", "msg_ad_req_info" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), localByteStringMicro, null }, ReqAdvertisePara.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField anchor_id = PBField.initString("");
    public final PBStringField comment_id = PBField.initString("");
    public final PBUInt32Field content_src = PBField.initUInt32(0);
    public final PBStringField feeds_id = PBField.initString("");
    public final PBUInt32Field feeds_type = PBField.initUInt32(0);
    public final PBUInt32Field fixed_page_size = PBField.initUInt32(0);
    public final PBUInt32Field is_share = PBField.initUInt32(0);
    public final PBBytesField page_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
    public oidb_cmd0xc46.ReqParam req_param = new oidb_cmd0xc46.ReqParam();
    public final PBStringField rowkey = PBField.initString("");
    public final PBUInt32Field with_activity_data = PBField.initUInt32(0);
    public final PBUInt32Field with_first_comment_detail = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 66, 72, 80, 90, 96, 106 }, new String[] { "rowkey", "comment_id", "page_cookie", "page_size", "content_src", "fixed_page_size", "is_share", "feeds_id", "feeds_type", "with_first_comment_detail", "anchor_id", "with_activity_data", "req_param" }, new Object[] { "", "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null }, ReqBody.class);
    }
  }
  
  public static final class ReqParam
    extends MessageMicro<ReqParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "with_sub_comments", "platform", "with_author_reply", "with_style_data", "req_advertise_para" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ReqParam.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public oidb_cmd0xc46.ReqAdvertisePara req_advertise_para = new oidb_cmd0xc46.ReqAdvertisePara();
    public final PBUInt32Field with_author_reply = PBField.initUInt32(0);
    public final PBUInt32Field with_style_data = PBField.initUInt32(0);
    public final PBUInt32Field with_sub_comments = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_cmd0xc46.ArticleInfo article_info = new oidb_cmd0xc46.ArticleInfo();
    public oidb_cmd0xc46.Banner banner = new oidb_cmd0xc46.Banner();
    public final PBRepeatMessageField<oidb_cmd0xc46.Comment> comment_list = PBField.initRepeatMessage(oidb_cmd0xc46.Comment.class);
    public oidb_cmd0xc46.ExtraInfo extra_info = new oidb_cmd0xc46.ExtraInfo();
    public oidb_cmd0xc46.Comment first_comment_detail = new oidb_cmd0xc46.Comment();
    public final PBRepeatMessageField<oidb_cmd0xc46.Comment> hot_comment_list = PBField.initRepeatMessage(oidb_cmd0xc46.Comment.class);
    public final PBUInt32Field next = PBField.initUInt32(0);
    public final PBBytesField page_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "next", "page_cookie", "article_info", "hot_comment_list", "comment_list", "first_comment_detail", "banner", "extra_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null, null, null, null }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46
 * JD-Core Version:    0.7.0.1
 */