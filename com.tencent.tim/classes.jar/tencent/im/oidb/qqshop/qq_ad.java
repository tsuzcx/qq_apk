package tencent.im.oidb.qqshop;

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

public final class qq_ad
{
  public static final class QQAdGet
    extends MessageMicro<QQAdGet>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64 }, new String[] { "pos_id", "ad_count", "pos_layout", "net_info", "last_adid", "last_req_time", "get_back", "debug_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L) }, QQAdGet.class);
    public final PBRepeatField<Integer> ad_count = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt64Field debug_id = PBField.initUInt64(0L);
    public final PBBoolField get_back = PBField.initBool(false);
    public final PBRepeatField<Long> last_adid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field last_req_time = PBField.initUInt64(0L);
    public Phone net_info = new Phone();
    public final PBRepeatField<Long> pos_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBInt32Field pos_layout = PBField.initInt32(0);
    
    public static final class Phone
      extends MessageMicro<Phone>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBStringField aid_ticket = PBField.initString("");
      public final PBUInt64Field app_id = PBField.initUInt64(0L);
      public final PBInt32Field app_version_id = PBField.initInt32(0);
      public final PBUInt32Field carrier = PBField.initUInt32(0);
      public final PBStringField client_ipv4 = PBField.initString("");
      public final PBUInt32Field conn = PBField.initUInt32(0);
      public final PBInt32Field coordinates_type = PBField.initInt32(0);
      public final PBBytesField device_brand_and_model = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBoolField is_googleplay_version = PBField.initBool(false);
      public final PBInt32Field latitude = PBField.initInt32(0);
      public final PBInt32Field longitude = PBField.initInt32(0);
      public final PBBytesField manufacturer = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBStringField md5_android_id = PBField.initString("");
      public final PBStringField md5_mac = PBField.initString("");
      public final PBStringField muid = PBField.initString("");
      public final PBInt32Field muid_type = PBField.initInt32(0);
      public final PBUInt32Field os_type = PBField.initUInt32(0);
      public final PBStringField os_ver = PBField.initString("");
      public final PBStringField qadid = PBField.initString("");
      public final PBStringField qq_ver = PBField.initString("");
      public final PBStringField taid_ticket = PBField.initString("");
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48, 56, 64, 72, 82, 90, 98, 104, 114, 120, 130, 136, 146, 154, 160, 170 }, new String[] { "muid", "conn", "carrier", "os_ver", "qq_ver", "os_type", "app_id", "latitude", "longitude", "manufacturer", "device_brand_and_model", "qadid", "is_googleplay_version", "aid_ticket", "app_version_id", "client_ipv4", "coordinates_type", "md5_android_id", "md5_mac", "muid_type", "taid_ticket" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, "", Boolean.valueOf(false), "", Integer.valueOf(0), "", Integer.valueOf(0), "", "", Integer.valueOf(0), "" }, Phone.class);
      }
    }
  }
  
  public static final class QQAdGetRsp
    extends MessageMicro<QQAdGetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 42, 50, 56, 64, 74 }, new String[] { "ret", "pos_ads_info", "msg", "is_boss_qq", "del_aid", "red_point" }, new Object[] { Integer.valueOf(0), null, "", Boolean.valueOf(false), Long.valueOf(0L), null }, QQAdGetRsp.class);
    public final PBRepeatField<Long> del_aid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBoolField is_boss_qq = PBField.initBool(false);
    public final PBStringField msg = PBField.initString("");
    public final PBRepeatMessageField<PosAdInfo> pos_ads_info = PBField.initRepeatMessage(PosAdInfo.class);
    public final PBRepeatMessageField<RedPointInfo> red_point = PBField.initRepeatMessage(RedPointInfo.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    
    public static final class AdInfo
      extends MessageMicro<AdInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 34, 42, 50, 58, 82, 98, 104, 114, 154, 160, 170, 178, 186, 194, 202, 210, 216, 226, 234, 250, 258, 266, 272, 288, 306, 314 }, new String[] { "img", "img_s", "txt", "desc", "rl", "apurl", "traceid", "product_id", "product_type", "via", "landing_page", "price", "button_txt", "view_id", "customized_invoke_url", "corporation_name", "corporate_image_name", "corporate_logo", "ad_uin", "ext", "video_url", "title_list", "image_list", "url_list", "aid", "creative_size", "button_url", "app_download_schema" }, new Object[] { "", "", "", "", "", "", "", "", Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", "", "", "", Integer.valueOf(0), "", "", "", "", "", Long.valueOf(0L), Integer.valueOf(0), "", "" }, AdInfo.class);
      public final PBUInt32Field ad_uin = PBField.initUInt32(0);
      public final PBUInt64Field aid = PBField.initUInt64(0L);
      public final PBStringField app_download_schema = PBField.initString("");
      public final PBStringField apurl = PBField.initString("");
      public final PBStringField button_txt = PBField.initString("");
      public final PBStringField button_url = PBField.initString("");
      public final PBStringField corporate_image_name = PBField.initString("");
      public final PBStringField corporate_logo = PBField.initString("");
      public final PBStringField corporation_name = PBField.initString("");
      public final PBUInt32Field creative_size = PBField.initUInt32(0);
      public final PBStringField customized_invoke_url = PBField.initString("");
      public final PBStringField desc = PBField.initString("");
      public final PBStringField ext = PBField.initString("");
      public final PBRepeatField<String> image_list = PBField.initRepeat(PBStringField.__repeatHelper__);
      public final PBStringField img = PBField.initString("");
      public final PBStringField img_s = PBField.initString("");
      public final PBStringField landing_page = PBField.initString("");
      public final PBUInt32Field price = PBField.initUInt32(0);
      public final PBStringField product_id = PBField.initString("");
      public final PBInt32Field product_type = PBField.initInt32(0);
      public final PBStringField rl = PBField.initString("");
      public final PBRepeatField<String> title_list = PBField.initRepeat(PBStringField.__repeatHelper__);
      public final PBStringField traceid = PBField.initString("");
      public final PBStringField txt = PBField.initString("");
      public final PBRepeatField<String> url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
      public final PBStringField via = PBField.initString("");
      public final PBStringField video_url = PBField.initString("");
      public final PBStringField view_id = PBField.initString("");
    }
    
    public static final class PosAdInfo
      extends MessageMicro<PosAdInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 32, 42 }, new String[] { "ret", "msg", "pos_id", "ads_info" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), null }, PosAdInfo.class);
      public final PBRepeatMessageField<qq_ad.QQAdGetRsp.AdInfo> ads_info = PBField.initRepeatMessage(qq_ad.QQAdGetRsp.AdInfo.class);
      public final PBStringField msg = PBField.initString("");
      public final PBUInt64Field pos_id = PBField.initUInt64(0L);
      public final PBInt32Field ret = PBField.initInt32(0);
    }
    
    public static final class RedPointInfo
      extends MessageMicro<RedPointInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "task_id", "tab_id", "begin_time", "end_time", "delay_second", "red_type", "red_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RedPointInfo.class);
      public final PBUInt32Field begin_time = PBField.initUInt32(0);
      public final PBUInt32Field delay_second = PBField.initUInt32(0);
      public final PBUInt32Field end_time = PBField.initUInt32(0);
      public final PBUInt32Field red_type = PBField.initUInt32(0);
      public final PBStringField red_url = PBField.initString("");
      public final PBInt32Field tab_id = PBField.initInt32(0);
      public final PBInt32Field task_id = PBField.initInt32(0);
    }
  }
  
  public static final class QQAdReport
    extends MessageMicro<QQAdReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 88, 96, 106, 112, 122, 130, 138, 146, 152, 160, 168, 176, 184, 192, 202, 210, 218, 224, 232, 240 }, new String[] { "type", "view_id", "trace_id", "act_time", "sns_uid", "resolution", "referer", "user_agent", "q_user_agent", "feeds_index", "is_impression", "is_installed", "feeds_video_attachment", "platform_id", "imei", "click_source", "antispam_info", "hardware_addr", "stay_time", "net_type", "client_id", "action_id", "msg_floor", "puin", "version", "ad_id", "msgid", "get_back", "ad_puin", "source" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Boolean.valueOf(true), Boolean.valueOf(false), "", Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", "", Boolean.valueOf(false), Long.valueOf(0L), Integer.valueOf(0) }, QQAdReport.class);
    public final PBUInt32Field act_time = PBField.initUInt32(0);
    public final PBUInt32Field action_id = PBField.initUInt32(0);
    public final PBStringField ad_id = PBField.initString("");
    public final PBUInt64Field ad_puin = PBField.initUInt64(0L);
    public final PBStringField antispam_info = PBField.initString("");
    public final PBStringField click_source = PBField.initString("");
    public final PBUInt32Field client_id = PBField.initUInt32(0);
    public final PBUInt32Field feeds_index = PBField.initUInt32(0);
    public final PBStringField feeds_video_attachment = PBField.initString("");
    public final PBBoolField get_back = PBField.initBool(false);
    public final PBStringField hardware_addr = PBField.initString("");
    public final PBStringField imei = PBField.initString("");
    public final PBBoolField is_impression = PBField.initBool(true);
    public final PBBoolField is_installed = PBField.initBool(false);
    public final PBUInt32Field msg_floor = PBField.initUInt32(0);
    public final PBStringField msgid = PBField.initString("");
    public final PBUInt32Field net_type = PBField.initUInt32(0);
    public final PBUInt32Field platform_id = PBField.initUInt32(0);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBStringField q_user_agent = PBField.initString("");
    public final PBStringField referer = PBField.initString("");
    public final PBStringField resolution = PBField.initString("");
    public final PBStringField sns_uid = PBField.initString("");
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field stay_time = PBField.initUInt32(0);
    public final PBStringField trace_id = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField user_agent = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField view_id = PBField.initString("");
  }
  
  public static final class QQAdReportRsp
    extends MessageMicro<QQAdReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "click_id" }, new Object[] { Integer.valueOf(0), "" }, QQAdReportRsp.class);
    public final PBStringField click_id = PBField.initString("");
    public final PBInt32Field ret_code = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qq_ad
 * JD-Core Version:    0.7.0.1
 */