package tencent.im.oidb.cmd0x886;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x886
{
  public static final class AdInfo
    extends MessageMicro<AdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_apurl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_button_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_corporate_image_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_corporate_logo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_corporation_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_customized_invoke_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_img = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_img_s = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_price = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_product_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_trace_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_via = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_view_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_ad_layout = PBField.initEnum(0);
    public final PBEnumField enum_pos_layout = PBField.initEnum(0);
    public final PBEnumField enum_report_type = PBField.initEnum(1);
    public final PBInt32Field int32_kd_pos = PBField.initInt32(0);
    public final PBInt32Field int32_product_type = PBField.initInt32(0);
    public oidb_cmd0x886.VideoPlayInfo msg_video_play_info = new oidb_cmd0x886.VideoPlayInfo();
    public final PBUInt32Field uint32_ad_material_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ad_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cost_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dis_channel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ad_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_aid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_neg_fb_type_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_pos_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_pull_time = PBField.initUInt64(0L);
    
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
      ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro16 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro17 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro18 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro19 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 56, 64, 72, 80, 90, 96, 106, 112, 120, 130, 138, 146, 154, 162, 168, 178, 186, 192, 200, 210, 218, 226, 234, 240, 248, 258, 264, 274, 282, 288 }, new String[] { "bytes_trace_id", "uint64_pull_time", "enum_report_type", "bytes_apurl", "bytes_rl", "bytes_view_id", "uint64_neg_fb_type_id", "uint64_pos_id", "uint64_channel_id", "int32_kd_pos", "bytes_cl", "enum_pos_layout", "bytes_product_id", "int32_product_type", "uint32_ad_type", "bytes_price", "bytes_customized_invoke_url", "bytes_corporation_name", "bytes_corporate_image_name", "bytes_corporate_logo", "uint64_ad_uin", "bytes_ext", "bytes_video_url", "uint32_cost_type", "uint64_aid", "bytes_img", "bytes_img_s", "bytes_txt", "bytes_desc", "enum_ad_layout", "uint32_ad_material_id", "bytes_via", "uint32_dis_channel", "bytes_button_url", "msg_video_play_info", "uint32_duration" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(1), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, Long.valueOf(0L), localByteStringMicro12, localByteStringMicro13, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro14, localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro18, Integer.valueOf(0), localByteStringMicro19, null, Integer.valueOf(0) }, AdInfo.class);
    }
  }
  
  public static final class PhoneInfo
    extends MessageMicro<PhoneInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_client_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_client_mac = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_muid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_os_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qq_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_carrier = PBField.initUInt32(0);
    public final PBUInt32Field uint32_conn = PBField.initUInt32(0);
    public final PBUInt32Field uint32_muid_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_os_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66, 74, 80 }, new String[] { "bytes_muid", "uint32_conn", "uint32_carrier", "uint32_muid_type", "bytes_os_ver", "bytes_qq_ver", "bytes_client_ip", "bytes_client_mac", "bytes_appid", "uint32_os_type" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0) }, PhoneInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_ad_display = PBField.initEnum(2);
    public oidb_cmd0x886.AdInfo msg_ad_info = new oidb_cmd0x886.AdInfo();
    public oidb_cmd0x886.PhoneInfo msg_phone_info = new oidb_cmd0x886.PhoneInfo();
    public final PBUInt64Field uint64_client_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "uint64_uin", "msg_phone_info", "msg_ad_info", "bytes_uuid", "uint64_client_time", "enum_ad_display" }, new Object[] { Long.valueOf(0L), null, null, localByteStringMicro, Long.valueOf(0L), Integer.valueOf(2) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_ret", "uint64_uin", "bytes_msg" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class VideoPlayInfo
    extends MessageMicro<VideoPlayInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uint32_bt", "uint32_et", "uint32_bf", "uint32_ef", "uint32_pp", "uint32_pa", "uint32_pb" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VideoPlayInfo.class);
    public final PBUInt32Field uint32_bf = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ef = PBField.initUInt32(0);
    public final PBUInt32Field uint32_et = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pa = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pb = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pp = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x886.oidb_cmd0x886
 * JD-Core Version:    0.7.0.1
 */