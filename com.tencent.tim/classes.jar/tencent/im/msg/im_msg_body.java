package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body
{
  public static final class AnonymousGroupMsg
    extends MessageMicro<AnonymousGroupMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField str_anon_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_anon_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_rank_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bubble_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
    public final PBUInt32Field uint32_head_portrait = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58 }, new String[] { "uint32_flags", "str_anon_id", "str_anon_nick", "uint32_head_portrait", "uint32_expire_time", "uint32_bubble_id", "str_rank_color" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, AnonymousGroupMsg.class);
    }
  }
  
  public static final class ApolloActMsg
    extends MessageMicro<ApolloActMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_action_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_action_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField diytext_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field diytext_id = PBField.initUInt32(0);
    public final PBBytesField input_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_peer_status = PBField.initInt32(0);
    public final PBInt32Field int32_sender_status = PBField.initInt32(0);
    public final PBUInt32Field uint32_action_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_peer_ts = PBField.initUInt32(0);
    public final PBUInt32Field uint32_peer_uin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sender_ts = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 72, 80, 90, 98, 106 }, new String[] { "uint32_action_id", "bytes_action_name", "bytes_action_text", "uint32_flag", "uint32_peer_uin", "uint32_sender_ts", "uint32_peer_ts", "int32_sender_status", "int32_peer_status", "diytext_id", "diytext_content", "input_text", "bytes_pb_reserve" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, ApolloActMsg.class);
    }
  }
  
  public static final class ArkAppElem
    extends MessageMicro<ArkAppElem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField app_name = PBField.initString("");
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField min_version = PBField.initString("");
    public final PBStringField xml_template = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "app_name", "min_version", "xml_template", "bytes_data" }, new Object[] { "", "", "", localByteStringMicro }, ArkAppElem.class);
    }
  }
  
  public static final class Attr
    extends MessageMicro<Attr>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field char_set = PBField.initUInt32(78);
    public final PBSInt32Field code_page = PBField.initSInt32(-1);
    public final PBUInt32Field color = PBField.initUInt32(0);
    public final PBUInt32Field effect = PBField.initUInt32(7);
    public final PBStringField font_name = PBField.initString("Times New Roman");
    public final PBUInt32Field pitch_and_family = PBField.initUInt32(90);
    public final PBUInt32Field random = PBField.initUInt32(0);
    public final PBBytesField reserve_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field size = PBField.initUInt32(10);
    public final PBUInt32Field time = PBField.initUInt32(1);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 74, 82 }, new String[] { "code_page", "time", "random", "color", "size", "effect", "char_set", "pitch_and_family", "font_name", "reserve_data" }, new Object[] { Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(7), Integer.valueOf(78), Integer.valueOf(90), "Times New Roman", localByteStringMicro }, Attr.class);
    }
  }
  
  public static final class BitAppMsg
    extends MessageMicro<BitAppMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_buf" }, new Object[] { localByteStringMicro }, BitAppMsg.class);
    }
  }
  
  public static final class BlessingMessage
    extends MessageMicro<BlessingMessage>
  {
    public static final int ETypeBlessing = 1;
    public static final int ETypeNormal = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_msg_type", "uint32_ex_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BlessingMessage.class);
    public final PBUInt32Field uint32_ex_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  }
  
  public static final class CommonElem
    extends MessageMicro<CommonElem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pb_elem = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_service_type", "bytes_pb_elem", "uint32_business_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, CommonElem.class);
    }
  }
  
  public static final class ConferenceTipsInfo
    extends MessageMicro<ConferenceTipsInfo>
  {
    public static final int ECONFST_BUDDY_AV = 2;
    public static final int ECONFST_DISCUSS_AV = 1;
    public static final int ECONFST_NONE = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_session_type", "uint64_session_uin", "str_text" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, ConferenceTipsInfo.class);
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt32Field uint32_session_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_session_uin = PBField.initUInt64(0L);
  }
  
  public static final class CrmElem
    extends MessageMicro<CrmElem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField crm_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_count_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_push_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qidian_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "crm_buf", "bytes_msg_resid", "uint32_qidian_flag", "uint32_push_flag", "uint32_count_flag" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, CrmElem.class);
    }
  }
  
  public static final class CustomElem
    extends MessageMicro<CustomElem>
  {
    public static final int DataType_Bin = 2;
    public static final int DataType_Text = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sound = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_type = PBField.initEnum(1);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "bytes_desc", "bytes_data", "enum_type", "bytes_ext", "bytes_sound" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(1), localByteStringMicro3, localByteStringMicro4 }, CustomElem.class);
    }
  }
  
  public static final class CustomFace
    extends MessageMicro<CustomFace>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field biz_type = PBField.initUInt32(0);
    public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_flag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_old_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_signature = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field image_type = PBField.initUInt32(0);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBUInt32Field repeat_image = PBField.initUInt32(0);
    public final PBUInt32Field repeat_index = PBField.initUInt32(0);
    public final PBStringField str_400_url = PBField.initString("");
    public final PBStringField str_big_url = PBField.initString("");
    public final PBStringField str_file_path = PBField.initString("");
    public final PBStringField str_orig_url = PBField.initString("");
    public final PBStringField str_shortcut = PBField.initString("");
    public final PBStringField str_thumb_url = PBField.initString("");
    public final PBUInt32Field uint32_400_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_400_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_download_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_origin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_server_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_useful = PBField.initUInt32(0);
    public final PBUInt32Field uint32_width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 90, 96, 106, 114, 122, 130, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 250, 256, 264, 274 }, new String[] { "bytes_guid", "str_file_path", "str_shortcut", "bytes_buffer", "bytes_flag", "bytes_old_data", "uint32_file_id", "uint32_server_ip", "uint32_server_port", "uint32_file_type", "bytes_signature", "uint32_useful", "bytes_md5", "str_thumb_url", "str_big_url", "str_orig_url", "biz_type", "repeat_index", "repeat_image", "image_type", "index", "uint32_width", "uint32_height", "uint32_source", "uint32_size", "uint32_origin", "uint32_thumb_width", "uint32_thumb_height", "uint32_show_len", "uint32_download_len", "str_400_url", "uint32_400_width", "uint32_400_height", "bytes_pb_reserve" }, new Object[] { localByteStringMicro1, "", "", localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7 }, CustomFace.class);
    }
  }
  
  public static final class DeliverGiftMsg
    extends MessageMicro<DeliverGiftMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_animation_brief = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_animation_package_url_a = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_animation_package_url_i = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comefrom_link = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gray_tip_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_receiver_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_receiver_pic = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remind_brief = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_stmessage_comefrom = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_stmessage_gifturl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_stmessage_message = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_stmessage_subtitle = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_stmessage_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_to_all_gift_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_animation_package_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gift_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gift_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_stmessage_exflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_stmessage_giftpicid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 56, 66, 72, 80, 90, 98, 106, 112, 122, 128, 138, 146, 154, 162, 170, 178 }, new String[] { "bytes_gray_tip_content", "uint32_animation_package_id", "bytes_animation_package_url_a", "bytes_animation_package_url_i", "bytes_remind_brief", "uint32_gift_id", "uint32_gift_count", "bytes_animation_brief", "uint64_sender_uin", "uint64_receiver_uin", "bytes_stmessage_title", "bytes_stmessage_subtitle", "bytes_stmessage_message", "uint32_stmessage_giftpicid", "bytes_stmessage_comefrom", "uint32_stmessage_exflag", "bytes_to_all_gift_id", "bytes_comefrom_link", "bytes_pb_reserve", "bytes_receiver_name", "bytes_receiver_pic", "bytes_stmessage_gifturl" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9, Integer.valueOf(0), localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localByteStringMicro15 }, DeliverGiftMsg.class);
    }
  }
  
  public static final class EIMInfo
    extends MessageMicro<EIMInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_root_id", "uint32_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, EIMInfo.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_root_id = PBField.initUInt64(0L);
  }
  
  public static final class Elem
    extends MessageMicro<Elem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public im_msg_body.AnonymousGroupMsg anon_group_msg = new im_msg_body.AnonymousGroupMsg();
    public im_msg_body.ApolloActMsg apollo_msg = new im_msg_body.ApolloActMsg();
    public im_msg_body.ArkAppElem ark_app = new im_msg_body.ArkAppElem();
    public final PBBytesField bankcode_ctrl_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public im_msg_body.BitAppMsg bitapp_msg = new im_msg_body.BitAppMsg();
    public im_msg_body.BlessingMessage bless_msg = new im_msg_body.BlessingMessage();
    public im_msg_body.CommonElem common_elem = new im_msg_body.CommonElem();
    public im_msg_body.ConferenceTipsInfo conference_tips_info = new im_msg_body.ConferenceTipsInfo();
    public im_msg_body.CrmElem crm_elem = new im_msg_body.CrmElem();
    public im_msg_body.CustomElem custom_elem = new im_msg_body.CustomElem();
    public im_msg_body.CustomFace custom_face = new im_msg_body.CustomFace();
    public im_msg_body.DeliverGiftMsg deliver_gift_msg = new im_msg_body.DeliverGiftMsg();
    public im_msg_body.EIMInfo eim_info = new im_msg_body.EIMInfo();
    public im_msg_body.ElemFlags elem_flags = new im_msg_body.ElemFlags();
    public im_msg_body.ElemFlags2 elem_flags2 = new im_msg_body.ElemFlags2();
    public im_msg_body.ExtraInfo extra_info = new im_msg_body.ExtraInfo();
    public im_msg_body.Face face = new im_msg_body.Face();
    public im_msg_body.FSJMessageElem fsj_msg_elem = new im_msg_body.FSJMessageElem();
    public im_msg_body.FunFace fun_face = new im_msg_body.FunFace();
    public im_msg_body.GeneralFlags general_flags = new im_msg_body.GeneralFlags();
    public im_msg_body.GroupBusinessMsg group_business_msg = new im_msg_body.GroupBusinessMsg();
    public im_msg_body.GroupFile group_file = new im_msg_body.GroupFile();
    public im_msg_body.GroupPostElem group_post_elem = new im_msg_body.GroupPostElem();
    public im_msg_body.GroupPubAccountInfo group_pub_acc_info = new im_msg_body.GroupPubAccountInfo();
    public im_msg_body.CustomFace hc_flash_pic = new im_msg_body.CustomFace();
    public im_msg_body.LifeOnlineAccount life_online = new im_msg_body.LifeOnlineAccount();
    public im_msg_body.LightAppElem light_app = new im_msg_body.LightAppElem();
    public im_msg_body.LocationInfo location_info = new im_msg_body.LocationInfo();
    public im_msg_body.LolaMsg lola_msg = new im_msg_body.LolaMsg();
    public im_msg_body.LowVersionTips low_version_tips = new im_msg_body.LowVersionTips();
    public im_msg_body.MarketFace market_face = new im_msg_body.MarketFace();
    public im_msg_body.MarketTrans market_trans = new im_msg_body.MarketTrans();
    public im_msg_body.WorkflowNotifyMsg msg_workflow_notify = new im_msg_body.WorkflowNotifyMsg();
    public im_msg_body.NearByMessageType near_by_msg = new im_msg_body.NearByMessageType();
    public im_msg_body.NotOnlineImage not_online_image = new im_msg_body.NotOnlineImage();
    public im_msg_body.OnlineImage online_image = new im_msg_body.OnlineImage();
    public im_msg_body.OpenQQData open_qq_data = new im_msg_body.OpenQQData();
    public im_msg_body.PatsElem pat_elem = new im_msg_body.PatsElem();
    public im_msg_body.PubAccInfo pub_acc_info = new im_msg_body.PubAccInfo();
    public im_msg_body.PubAccount pub_account = new im_msg_body.PubAccount();
    public im_msg_body.PubGroup pub_group = new im_msg_body.PubGroup();
    public im_msg_body.QQLiveOld qq_live_old = new im_msg_body.QQLiveOld();
    public im_msg_body.QQWalletMsg qqwallet_msg = new im_msg_body.QQWalletMsg();
    public im_msg_body.RedBagInfo redbag_info = new im_msg_body.RedBagInfo();
    public im_msg_body.RichMsg rich_msg = new im_msg_body.RichMsg();
    public im_msg_body.SecretFileMsg secret_file = new im_msg_body.SecretFileMsg();
    public im_msg_body.ShakeWindow shake_window = new im_msg_body.ShakeWindow();
    public im_msg_body.SmallEmoji small_emoji = new im_msg_body.SmallEmoji();
    public im_msg_body.SourceMsg src_msg = new im_msg_body.SourceMsg();
    public im_msg_body.Text text = new im_msg_body.Text();
    public im_msg_body.TipsInfo tips_info = new im_msg_body.TipsInfo();
    public im_msg_body.TransElem trans_elem_info = new im_msg_body.TransElem();
    public im_msg_body.VideoFile video_file = new im_msg_body.VideoFile();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 194, 202, 210, 218, 226, 234, 242, 250, 258, 266, 274, 282, 290, 298, 306, 314, 322, 330, 338, 346, 354, 362, 370, 378, 386, 394, 402, 410, 418, 426 }, new String[] { "text", "face", "online_image", "not_online_image", "trans_elem_info", "market_face", "elem_flags", "custom_face", "elem_flags2", "fun_face", "secret_file", "rich_msg", "group_file", "pub_group", "market_trans", "extra_info", "shake_window", "pub_account", "video_file", "tips_info", "anon_group_msg", "qq_live_old", "life_online", "qqwallet_msg", "crm_elem", "conference_tips_info", "redbag_info", "low_version_tips", "bankcode_ctrl_info", "near_by_msg", "custom_elem", "location_info", "pub_acc_info", "small_emoji", "fsj_msg_elem", "ark_app", "general_flags", "hc_flash_pic", "deliver_gift_msg", "bitapp_msg", "open_qq_data", "apollo_msg", "group_pub_acc_info", "bless_msg", "src_msg", "lola_msg", "group_business_msg", "msg_workflow_notify", "pat_elem", "group_post_elem", "light_app", "eim_info", "common_elem" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, localByteStringMicro, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, Elem.class);
    }
  }
  
  public static final class ElemFlags
    extends MessageMicro<ElemFlags>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_business_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_flags1 = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_flags1", "bytes_business_data" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ElemFlags.class);
    }
  }
  
  public static final class ElemFlags2
    extends MessageMicro<ElemFlags2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 74, 80, 88, 96, 106, 112 }, new String[] { "uint32_color_text_id", "uint64_msg_id", "uint32_whisper_session_id", "uint32_ptt_change_bit", "uint32_vip_status", "uint32_compatible_id", "rpt_insts", "uint32_msg_rpt_cnt", "src_inst", "uint32_longtitude", "uint32_latitude", "uint32_custom_font", "pc_support_def", "uint32_crm_flags" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, ElemFlags2.class);
    public im_msg_body.PcSupportDef pc_support_def = new im_msg_body.PcSupportDef();
    public final PBRepeatMessageField<Inst> rpt_insts = PBField.initRepeatMessage(Inst.class);
    public Inst src_inst = new Inst();
    public final PBUInt32Field uint32_color_text_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_compatible_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_crm_flags = PBField.initUInt32(0);
    public final PBUInt32Field uint32_custom_font = PBField.initUInt32(0);
    public final PBUInt32Field uint32_latitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_longtitude = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_rpt_cnt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_change_bit = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vip_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_whisper_session_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_msg_id = PBField.initUInt64(0L);
    
    public static final class Inst
      extends MessageMicro<Inst>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_app_id", "uint32_inst_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Inst.class);
      public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
      public final PBUInt32Field uint32_inst_id = PBField.initUInt32(0);
    }
  }
  
  public static final class ExtraInfo
    extends MessageMicro<ExtraInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_apns_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_card = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sender_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_apns_sound_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_mask = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_state_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_tail_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_group_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 66, 72, 80, 88, 96 }, new String[] { "bytes_nick", "bytes_group_card", "uint32_level", "uint32_flags", "uint32_group_mask", "uint32_msg_tail_id", "bytes_sender_title", "bytes_apns_tips", "uint64_uin", "uint32_msg_state_flag", "uint32_apns_sound_type", "uint32_new_group_flag" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ExtraInfo.class);
    }
  }
  
  public static final class FSJMessageElem
    extends MessageMicro<FSJMessageElem>
  {
    public static final int ETypeHotChatFlashPic = 1;
    public static final int ETypeNormal = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_msg_type" }, new Object[] { Integer.valueOf(0) }, FSJMessageElem.class);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  }
  
  public static final class Face
    extends MessageMicro<Face>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBBytesField old = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 90 }, new String[] { "index", "old", "buf" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, Face.class);
    }
  }
  
  public static final class FunFace
    extends MessageMicro<FunFace>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_turntable", "msg_bomb" }, new Object[] { null, null }, FunFace.class);
    public Bomb msg_bomb = new Bomb();
    public Turntable msg_turntable = new Turntable();
    
    public static final class Bomb
      extends MessageMicro<Bomb>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "bool_burst" }, new Object[] { Boolean.valueOf(false) }, Bomb.class);
      public final PBBoolField bool_burst = PBField.initBool(false);
    }
    
    public static final class Turntable
      extends MessageMicro<Turntable>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "rpt_uint64_uin_list", "uint64_hit_uin", "str_hit_uin_nick" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "" }, Turntable.class);
      public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
      public final PBStringField str_hit_uin_nick = PBField.initString("");
      public final PBUInt64Field uint64_hit_uin = PBField.initUInt64(0L);
    }
  }
  
  public static final class GeneralFlags
    extends MessageMicro<GeneralFlags>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField babyq_guide_msg_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rp_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rp_index = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field long_text_flag = PBField.initUInt32(0);
    public final PBBytesField long_text_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uin32_expert_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bubble_diy_text_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bubble_sub_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_glamour_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_flag_new = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_olympic_torch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_prp_fold = PBField.initUInt32(0);
    public final PBUInt32Field uint32_to_uin_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_rank_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_pendant_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 64, 72, 80, 88, 96, 104, 114, 120, 128, 136, 146, 154 }, new String[] { "uint32_bubble_diy_text_id", "uint32_group_flag_new", "uint64_uin", "bytes_rp_id", "uint32_prp_fold", "long_text_flag", "long_text_resid", "uint32_group_type", "uint32_to_uin_flag", "uint32_glamour_level", "uint32_member_level", "uint64_group_rank_seq", "uint32_olympic_torch", "babyq_guide_msg_cookie", "uin32_expert_flag", "uint32_bubble_sub_id", "uint64_pendant_id", "bytes_rp_index", "bytes_pb_reserve" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro4, localByteStringMicro5 }, GeneralFlags.class);
    }
  }
  
  public static final class GroupBusinessMsg
    extends MessageMicro<GroupBusinessMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_head_clk_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rank = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rank_bgcolor = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rank_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "uint32_flags", "bytes_head_url", "bytes_head_clk_url", "bytes_nick", "bytes_nick_color", "bytes_rank", "bytes_rank_color", "bytes_rank_bgcolor" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, GroupBusinessMsg.class);
    }
  }
  
  public static final class GroupFile
    extends MessageMicro<GroupFile>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_batch_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_batch_item_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_filename = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_feed_msg_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sequence = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 56, 66, 72, 82 }, new String[] { "bytes_filename", "uint64_file_size", "bytes_file_id", "bytes_batch_id", "bytes_file_key", "bytes_mark", "uint64_sequence", "bytes_batch_item_id", "uint32_feed_msg_time", "bytes_pb_reserve" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7 }, GroupFile.class);
    }
  }
  
  public static final class GroupPostElem
    extends MessageMicro<GroupPostElem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_trans_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_trans_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_trans_type", "bytes_trans_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GroupPostElem.class);
    }
  }
  
  public static final class GroupPubAccountInfo
    extends MessageMicro<GroupPubAccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_pub_account" }, new Object[] { Long.valueOf(0L) }, GroupPubAccountInfo.class);
    public final PBUInt64Field uint64_pub_account = PBField.initUInt64(0L);
  }
  
  public static final class LifeOnlineAccount
    extends MessageMicro<LifeOnlineAccount>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField gdt_cli_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField gdt_imp_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_ack = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op = PBField.initUInt32(0);
    public final PBUInt32Field uint32_report = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_bitmap = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_unique_id = PBField.initUInt64(0L);
    public final PBBytesField view_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 74 }, new String[] { "uint64_unique_id", "uint32_op", "uint32_show_time", "uint32_report", "uint32_ack", "uint64_bitmap", "gdt_imp_data", "gdt_cli_data", "view_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, LifeOnlineAccount.class);
    }
  }
  
  public static final class LightAppElem
    extends MessageMicro<LightAppElem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_data", "bytes_msg_resid" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, LightAppElem.class);
    }
  }
  
  public static final class LocationInfo
    extends MessageMicro<LocationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBDoubleField double_latitude = PBField.initDouble(0.0D);
    public final PBDoubleField double_longitude = PBField.initDouble(0.0D);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17, 26 }, new String[] { "double_longitude", "double_latitude", "bytes_desc" }, new Object[] { Double.valueOf(0.0D), Double.valueOf(0.0D), localByteStringMicro }, LocationInfo.class);
    }
  }
  
  public static final class LolaMsg
    extends MessageMicro<LolaMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_encode_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_long_msg_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_msg_resid", "bytes_encode_content", "bytes_long_msg_url", "bytes_download_key" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, LolaMsg.class);
    }
  }
  
  public static final class LowVersionTips
    extends MessageMicro<LowVersionTips>
  {
    public static final int CF_BuddyChatType = 0;
    public static final int CF_DiscussChatType = 3;
    public static final int CF_GroupChatType = 1;
    public static final int CF_TempChatType = 2;
    public static final int CF_UnknownChatType = -1;
    public static final int EBusinessID_ConfScheduleMsg = 1;
    public static final int EBusinessID_DingDongMsg = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint32_business_id", "uint32_session_type", "uint64_session_uin", "uint64_sender_uin", "str_text" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "" }, LowVersionTips.class);
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_session_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_session_uin = PBField.initUInt64(0L);
  }
  
  public static final class MarketFace
    extends MessageMicro<MarketFace>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_face_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_face_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mobileparam = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_param = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_face_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_image_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_image_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_item_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_media_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 58, 66, 72, 80, 88, 98, 106 }, new String[] { "bytes_face_name", "uint32_item_type", "uint32_face_info", "bytes_face_id", "uint32_tab_id", "uint32_sub_type", "bytes_key", "bytes_param", "uint32_media_type", "uint32_image_width", "uint32_image_height", "bytes_mobileparam", "bytes_pb_reserve" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6 }, MarketFace.class);
    }
  }
  
  public static final class MarketTrans
    extends MessageMicro<MarketTrans>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_xml = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_flag = PBField.initInt32(0);
    public final PBUInt32Field uint32_ability = PBField.initUInt32(0);
    public final PBUInt32Field uint32_min_ability = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "int32_flag", "bytes_xml", "bytes_msg_resid", "uint32_ability", "uint32_min_ability" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, MarketTrans.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField msg_encrypt_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public im_msg_body.RichText rich_text = new im_msg_body.RichText();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rich_text", "msg_content", "msg_encrypt_content" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2 }, MsgBody.class);
    }
  }
  
  public static final class MsgBody_subtype4
    extends MessageMicro<MsgBody_subtype4>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_not_online_file", "uint32_msg_time" }, new Object[] { null, Integer.valueOf(0) }, MsgBody_subtype4.class);
    public im_msg_body.NotOnlineFile msg_not_online_file = new im_msg_body.NotOnlineFile();
    public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
  }
  
  public static final class NearByMessageType
    extends MessageMicro<NearByMessageType>
  {
    public static final int ETypeClearingImg = 2;
    public static final int ETypeClearingText = 1;
    public static final int ETypeDefault = 0;
    public static final int ETypeIdentify = 1;
    public static final int ETypeNormal = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_type", "uint32_identify_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, NearByMessageType.class);
    public final PBUInt32Field uint32_identify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class NotOnlineFile
    extends MessageMicro<NotOnlineFile>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_note = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_file_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBStringField str_fileidcrc_media = PBField.initString("");
    public final PBUInt32Field uint32_abs_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_danger_evel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_download_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_life_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_micro_cloud = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 64, 72, 80, 90, 96, 400, 408, 416, 424, 432, 440, 450, 458 }, new String[] { "uint32_file_type", "bytes_sig", "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint64_file_size", "bytes_note", "uint32_reserved", "uint32_subcmd", "uint32_micro_cloud", "rpt_bytes_file_urls", "uint32_download_flag", "uint32_danger_evel", "uint32_life_time", "uint32_upload_time", "uint32_abs_file_type", "uint32_client_type", "uint32_expire_time", "bytes_pb_reserve", "str_fileidcrc_media" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, "" }, NotOnlineFile.class);
    }
  }
  
  public static final class NotOnlineImage
    extends MessageMicro<NotOnlineImage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field biz_type = PBField.initUInt32(0);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField download_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field file_len = PBField.initUInt32(0);
    public final PBBytesField file_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField flag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field img_type = PBField.initUInt32(0);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBBoolField old_pic_md5 = PBField.initBool(false);
    public final PBBytesField old_ver_send_file = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField op_face_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field original = PBField.initUInt32(0);
    public final PBUInt32Field pic_height = PBField.initUInt32(0);
    public final PBBytesField pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field pic_width = PBField.initUInt32(0);
    public final PBBytesField previews_image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField res_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField str_400_url = PBField.initString("");
    public final PBStringField str_big_url = PBField.initString("");
    public final PBStringField str_orig_url = PBField.initString("");
    public final PBStringField str_thumb_url = PBField.initString("");
    public final PBUInt32Field uint32_400_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_400_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_download_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 58, 64, 72, 82, 90, 98, 104, 114, 122, 128, 136, 144, 154, 160, 168, 176, 184, 192, 200, 210, 216, 224, 234 }, new String[] { "file_path", "file_len", "download_path", "old_ver_send_file", "img_type", "previews_image", "pic_md5", "pic_height", "pic_width", "res_id", "flag", "str_thumb_url", "original", "str_big_url", "str_orig_url", "biz_type", "result", "index", "op_face_buf", "old_pic_md5", "uint32_thumb_width", "uint32_thumb_height", "uint32_file_id", "uint32_show_len", "uint32_download_len", "str_400_url", "uint32_400_width", "uint32_400_height", "bytes_pb_reserve" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, "", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro9 }, NotOnlineImage.class);
    }
  }
  
  public static final class OnlineImage
    extends MessageMicro<OnlineImage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField file_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField old_ver_send_file = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "guid", "file_path", "old_ver_send_file" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, OnlineImage.class);
    }
  }
  
  public static final class OpenQQData
    extends MessageMicro<OpenQQData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_car_qq_data = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_car_qq_data" }, new Object[] { localByteStringMicro }, OpenQQData.class);
    }
  }
  
  public static final class PatsElem
    extends MessageMicro<PatsElem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_pat_type", "uint32_pat_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PatsElem.class);
    public final PBUInt32Field uint32_pat_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pat_type = PBField.initUInt32(0);
  }
  
  public static final class PcSupportDef
    extends MessageMicro<PcSupportDef>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint32_pc_ptl_begin", "uint32_pc_ptl_end", "uint32_mac_ptl_begin", "uint32_mac_ptl_end", "rpt_ptls_support", "rpt_ptls_not_support" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PcSupportDef.class);
    public final PBRepeatField<Integer> rpt_ptls_not_support = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_ptls_support = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_mac_ptl_begin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mac_ptl_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pc_ptl_begin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pc_ptl_end = PBField.initUInt32(0);
  }
  
  public static final class Ptt
    extends MessageMicro<Ptt>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_valid = PBField.initBool(false);
    public final PBBytesField bytes_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ptt_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_shortcut = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_signature = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_ptt_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_download_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_magic_ptt_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_server_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_switch = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 64, 72, 80, 88, 98, 106, 114, 120, 128, 138, 146, 152, 162, 232, 242, 250, 256 }, new String[] { "uint32_file_type", "uint64_src_uin", "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_size", "bytes_reserve", "uint32_file_id", "uint32_server_ip", "uint32_server_port", "bool_valid", "bytes_signature", "bytes_shortcut", "bytes_file_key", "uint32_magic_ptt_index", "uint32_voice_switch", "bytes_ptt_url", "bytes_group_file_key", "uint32_time", "bytes_down_para", "uint32_format", "bytes_pb_reserve", "rpt_bytes_ptt_urls", "uint32_download_flag" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), localByteStringMicro10, Integer.valueOf(0), localByteStringMicro11, localByteStringMicro12, Integer.valueOf(0) }, Ptt.class);
    }
  }
  
  public static final class PubAccInfo
    extends MessageMicro<PubAccInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField string_long_msg_url = PBField.initString("");
    public final PBStringField string_msg_template_id = PBField.initString("");
    public final PBUInt32Field uint32_is_inter_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_is_inter_num", "string_msg_template_id", "string_long_msg_url", "bytes_download_key" }, new Object[] { Integer.valueOf(0), "", "", localByteStringMicro }, PubAccInfo.class);
    }
  }
  
  public static final class PubAccount
    extends MessageMicro<PubAccount>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_pub_account_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_buf", "uint64_pub_account_uin" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, PubAccount.class);
    }
  }
  
  public static final class PubGroup
    extends MessageMicro<PubGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "bytes_nickname", "uint32_gender", "uint32_age", "uint32_distance" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PubGroup.class);
    }
  }
  
  public static final class QQLiveOld
    extends MessageMicro<QQLiveOld>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField str_introduce = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_param = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_show_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_sub_cmd", "str_show_text", "str_param", "str_introduce" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, QQLiveOld.class);
    }
  }
  
  public static final class QQWalletAioBody
    extends MessageMicro<QQWalletAioBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_authkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_billno = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pc_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public im_msg_body.QQWalletAioElem receiver = new im_msg_body.QQWalletAioElem();
    public im_msg_body.QQWalletAioElem sender = new im_msg_body.QQWalletAioElem();
    public final PBSInt32Field sint32_channelid = PBField.initSInt32(0);
    public final PBSInt32Field sint32_conftype = PBField.initSInt32(0);
    public final PBSInt32Field sint32_envelopeid = PBField.initSInt32(0);
    public final PBSInt32Field sint32_msg_from = PBField.initSInt32(0);
    public final PBSInt32Field sint32_msgtype = PBField.initSInt32(0);
    public final PBSInt32Field sint32_redtype = PBField.initSInt32(0);
    public final PBSInt32Field sint32_sessiontype = PBField.initSInt32(0);
    public final PBSInt32Field sint32_templateid = PBField.initSInt32(0);
    public final PBBytesField string_index = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_msg_priority = PBField.initUInt32(0);
    public final PBUInt32Field uint32_redchannel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_resend = PBField.initUInt32(0);
    public final PBRepeatField<Long> uint64_grap_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_senduin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104, 114, 120, 128, 138, 146, 152, 160, 170 }, new String[] { "uint64_senduin", "sender", "receiver", "sint32_channelid", "sint32_templateid", "uint32_resend", "uint32_msg_priority", "sint32_redtype", "bytes_billno", "bytes_authkey", "sint32_sessiontype", "sint32_msgtype", "sint32_envelopeid", "bytes_name", "sint32_conftype", "sint32_msg_from", "bytes_pc_body", "string_index", "uint32_redchannel", "uint64_grap_uin", "bytes_pb_reserve" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro6 }, QQWalletAioBody.class);
    }
  }
  
  public static final class QQWalletAioElem
    extends MessageMicro<QQWalletAioElem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_actions_priority = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_aio_image_left = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_aio_image_right = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_blackstripe = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cft_image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_iconurl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_linkurl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_native_android = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_native_ios = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_notice = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subtitle = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_background = PBField.initUInt32(0);
    public final PBUInt32Field uint32_content_bgcolor = PBField.initUInt32(0);
    public final PBUInt32Field uint32_content_color = PBField.initUInt32(0);
    public final PBUInt32Field uint32_icon = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subtitle_color = PBField.initUInt32(0);
    public final PBUInt32Field uint32_title_color = PBField.initUInt32(0);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 72, 80, 90, 98, 106, 114, 122, 128, 136, 146, 154, 162, 170 }, new String[] { "uint32_background", "uint32_icon", "bytes_title", "bytes_subtitle", "bytes_content", "bytes_linkurl", "bytes_blackstripe", "bytes_notice", "uint32_title_color", "uint32_subtitle_color", "bytes_actions_priority", "bytes_jump_url", "bytes_native_ios", "bytes_native_android", "bytes_iconurl", "uint32_content_color", "uint32_content_bgcolor", "bytes_aio_image_left", "bytes_aio_image_right", "bytes_cft_image", "bytes_pb_reserve" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localByteStringMicro15 }, QQWalletAioElem.class);
    }
  }
  
  public static final class QQWalletMsg
    extends MessageMicro<QQWalletMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "aio_body" }, new Object[] { null }, QQWalletMsg.class);
    public im_msg_body.QQWalletAioBody aio_body = new im_msg_body.QQWalletAioBody();
  }
  
  public static final class RedBagInfo
    extends MessageMicro<RedBagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "redbag_type" }, new Object[] { Integer.valueOf(0) }, RedBagInfo.class);
    public final PBUInt32Field redbag_type = PBField.initUInt32(0);
  }
  
  public static final class RichMsg
    extends MessageMicro<RichMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_template_1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rand = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48 }, new String[] { "bytes_template_1", "uint32_service_id", "bytes_msg_resid", "uint32_rand", "uint32_seq", "uint32_flags" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RichMsg.class);
    }
  }
  
  public static final class RichText
    extends MessageMicro<RichText>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "attr", "elems", "not_online_file", "ptt", "tmp_ptt", "trans_211_tmp_msg" }, new Object[] { null, null, null, null, null, null }, RichText.class);
    public im_msg_body.Attr attr = new im_msg_body.Attr();
    public final PBRepeatMessageField<im_msg_body.Elem> elems = PBField.initRepeatMessage(im_msg_body.Elem.class);
    public im_msg_body.NotOnlineFile not_online_file = new im_msg_body.NotOnlineFile();
    public im_msg_body.Ptt ptt = new im_msg_body.Ptt();
    public im_msg_body.TmpPtt tmp_ptt = new im_msg_body.TmpPtt();
    public im_msg_body.Trans211TmpMsg trans_211_tmp_msg = new im_msg_body.Trans211TmpMsg();
  }
  
  public static final class SecretFileMsg
    extends MessageMicro<SecretFileMsg>
  {
    public static final int TYPE_C2C = 0;
    public static final int TYPE_DISCU = 4;
    public static final int TYPE_GROUP = 2;
    public static final int TYPE_NEARBA = 3;
    public static final int TYPE_WPA = 5;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public im_msg_body.ElemFlags2 elem_flags2 = new im_msg_body.ElemFlags2();
    public im_msg_body.NotOnlineImage not_online_image = new im_msg_body.NotOnlineImage();
    public final PBStringField str_fromphonenum = PBField.initString("");
    public final PBUInt32Field uint32_encrypt_prehead_length = PBField.initUInt32(0);
    public final PBUInt32Field uint32_encrypt_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_left_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_opertype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 74, 80, 88, 98, 106, 112, 122 }, new String[] { "bytes_file_key", "uint64_from_uin", "uint64_to_uin", "uint32_status", "uint32_ttl", "uint32_type", "uint32_encrypt_prehead_length", "uint32_encrypt_type", "bytes_encrypt_key", "uint32_read_times", "uint32_left_time", "not_online_image", "elem_flags2", "uint32_opertype", "str_fromphonenum" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0), "" }, SecretFileMsg.class);
    }
  }
  
  public static final class ShakeWindow
    extends MessageMicro<ShakeWindow>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_type", "uint32_reserve", "uint64_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ShakeWindow.class);
    public final PBUInt32Field uint32_reserve = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SmallEmoji
    extends MessageMicro<SmallEmoji>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "packIdSum", "imageType" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SmallEmoji.class);
    public final PBUInt32Field imageType = PBField.initUInt32(0);
    public final PBUInt32Field packIdSum = PBField.initUInt32(0);
  }
  
  public static final class SourceMsg
    extends MessageMicro<SourceMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_richMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_troop_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<im_msg_body.Elem> elems = PBField.initRepeatMessage(im_msg_body.Elem.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_orig_seqs = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 74, 80, 90 }, new String[] { "uint32_orig_seqs", "uint64_sender_uin", "uint32_time", "uint32_flag", "elems", "uint32_type", "bytes_richMsg", "bytes_pb_reserve", "bytes_src_msg", "uint64_to_uin", "bytes_troop_name" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4 }, SourceMsg.class);
    }
  }
  
  public static final class Text
    extends MessageMicro<Text>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField attr_6_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField attr_7_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField link = PBField.initString("");
    public final PBBytesField str = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 90, 98 }, new String[] { "str", "link", "attr_6_buf", "attr_7_buf", "buf", "bytes_pb_reserve" }, new Object[] { localByteStringMicro1, "", localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, Text.class);
    }
  }
  
  public static final class TipsInfo
    extends MessageMicro<TipsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "text" }, new Object[] { "" }, TipsInfo.class);
    public final PBStringField text = PBField.initString("");
  }
  
  public static final class TmpPtt
    extends MessageMicro<TmpPtt>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ptt_encode_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptttrans_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_msg_id = PBField.initUInt64(0L);
    public final PBUInt32Field uint64_ptt_times = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 64, 72, 80, 242, 250 }, new String[] { "uint32_file_type", "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_size", "uint64_ptt_times", "uint32_user_type", "uint32_ptttrans_flag", "uint32_busi_type", "uint64_msg_id", "bytes_pb_reserve", "ptt_encode_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro4, localByteStringMicro5 }, TmpPtt.class);
    }
  }
  
  public static final class Trans211TmpMsg
    extends MessageMicro<Trans211TmpMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_c2c_cmd = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_msg_body", "uint32_c2c_cmd" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, Trans211TmpMsg.class);
    }
  }
  
  public static final class TransElem
    extends MessageMicro<TransElem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field elem_type = PBField.initUInt32(0);
    public final PBBytesField elem_value = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "elem_type", "elem_value" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, TransElem.class);
    }
  }
  
  public static final class VideoFile
    extends MessageMicro<VideoFile>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_support_progressive = PBField.initBool(false);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_source = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_thumb_file_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_video_file_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_download_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_file_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_to_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_download_flag = PBField.initUInt32(0);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104, 112, 120, 128, 136, 144, 152, 162, 170, 176, 184, 194 }, new String[] { "bytes_file_uuid", "bytes_file_md5", "bytes_file_name", "uint32_file_format", "uint32_file_time", "uint32_file_size", "uint32_thumb_width", "uint32_thumb_height", "bytes_thumb_file_md5", "bytes_source", "uint32_thumb_file_size", "uint32_busi_type", "uint32_from_chat_type", "uint32_to_chat_type", "bool_support_progressive", "uint32_file_width", "uint32_file_height", "uint32_sub_busi_type", "uint32_video_attr", "rpt_bytes_thumb_file_urls", "rpt_bytes_video_file_urls", "uint32_thumb_download_flag", "uint32_video_download_flag", "bytes_pb_reserve" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8 }, VideoFile.class);
    }
  }
  
  public static final class WorkflowNotifyMsg
    extends MessageMicro<WorkflowNotifyMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_ext_msg", "uint64_create_uin" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, WorkflowNotifyMsg.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body
 * JD-Core Version:    0.7.0.1
 */