package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x533
{
  public static final class HttpAROcrInfo
    extends MessageMicro<HttpAROcrInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26 }, new String[] { "uint64_ocr_recog_type", "msg_sougou_req" }, new Object[] { Long.valueOf(0L), null }, HttpAROcrInfo.class);
    public subcmd0x533.HttpClientRequestBodyV2 msg_sougou_req = new subcmd0x533.HttpClientRequestBodyV2();
    public final PBUInt64Field uint64_ocr_recog_type = PBField.initUInt64(0L);
  }
  
  public static final class HttpAROcrResult
    extends MessageMicro<HttpAROcrResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26 }, new String[] { "uint64_ocr_recog_type", "msg_sougou_rsp" }, new Object[] { Long.valueOf(0L), null }, HttpAROcrResult.class);
    public subcmd0x533.HttpServerResponseBodyV2 msg_sougou_rsp = new subcmd0x533.HttpServerResponseBodyV2();
    public final PBUInt64Field uint64_ocr_recog_type = PBField.initUInt64(0L);
  }
  
  public static final class HttpCardV2
    extends MessageMicro<HttpCardV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "string_template_name", "bool_is_recommended", "rpt_msg_card_properties", "rpt_msg_carousel", "rpt_msg_subcards" }, new Object[] { "", Boolean.valueOf(false), null, null, null }, HttpCardV2.class);
    public final PBBoolField bool_is_recommended = PBField.initBool(false);
    public final PBRepeatMessageField<subcmd0x533.HttpMapItem> rpt_msg_card_properties = PBField.initRepeatMessage(subcmd0x533.HttpMapItem.class);
    public final PBRepeatMessageField<HttpCarouselUnitV2> rpt_msg_carousel = PBField.initRepeatMessage(HttpCarouselUnitV2.class);
    public final PBRepeatMessageField<HttpCardV2> rpt_msg_subcards = PBField.initRepeatMessage(HttpCardV2.class);
    public final PBStringField string_template_name = PBField.initString("");
    
    public static final class HttpCarouselUnitV2
      extends MessageMicro<HttpCarouselUnitV2>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_card_properties" }, new Object[] { null }, HttpCarouselUnitV2.class);
      public final PBRepeatMessageField<subcmd0x533.HttpMapItem> rpt_msg_card_properties = PBField.initRepeatMessage(subcmd0x533.HttpMapItem.class);
    }
  }
  
  public static final class HttpClientRequestBodyV2
    extends MessageMicro<HttpClientRequestBodyV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 34, 80 }, new String[] { "msg_device", "rpt_string_sentences", "uint32_timeout_ms" }, new Object[] { null, "", Integer.valueOf(0) }, HttpClientRequestBodyV2.class);
    public subcmd0x533.HttpDeviceV2 msg_device = new subcmd0x533.HttpDeviceV2();
    public final PBRepeatField<String> rpt_string_sentences = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class HttpDeviceV2
    extends MessageMicro<HttpDeviceV2>
  {
    public static final int Android = 1;
    public static final int IOS = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "platform" }, new Object[] { Integer.valueOf(0) }, HttpDeviceV2.class);
    public final PBEnumField platform = PBField.initEnum(0);
  }
  
  public static final class HttpMapItem
    extends MessageMicro<HttpMapItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "string_key", "string_value", "rpt_string_key_list" }, new Object[] { "", "", "" }, HttpMapItem.class);
    public final PBRepeatField<String> rpt_string_key_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField string_key = PBField.initString("");
    public final PBStringField string_value = PBField.initString("");
  }
  
  public static final class HttpServerResponseBodyV2
    extends MessageMicro<HttpServerResponseBodyV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58, 64, 72 }, new String[] { "int32_tencent_errorcode", "string_tencent_errormsg", "int32_sougou_errorcode", "string_sougou_errormsg", "rpt_msg_cards", "string_request_class", "rpt_msg_container_properties", "bool_is_recommended", "int64_session_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", null, "", null, Boolean.valueOf(false), Long.valueOf(0L) }, HttpServerResponseBodyV2.class);
    public final PBBoolField bool_is_recommended = PBField.initBool(false);
    public final PBInt32Field int32_sougou_errorcode = PBField.initInt32(0);
    public final PBInt32Field int32_tencent_errorcode = PBField.initInt32(0);
    public final PBInt64Field int64_session_id = PBField.initInt64(0L);
    public final PBRepeatMessageField<subcmd0x533.HttpCardV2> rpt_msg_cards = PBField.initRepeatMessage(subcmd0x533.HttpCardV2.class);
    public final PBRepeatMessageField<subcmd0x533.HttpMapItem> rpt_msg_container_properties = PBField.initRepeatMessage(subcmd0x533.HttpMapItem.class);
    public final PBStringField string_request_class = PBField.initString("");
    public final PBStringField string_sougou_errormsg = PBField.initString("");
    public final PBStringField string_tencent_errormsg = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 40, 48, 90, 106 }, new String[] { "string_session_id", "uint64_req_recog_type", "uint32_business_type", "string_clt_version", "msg_ocr_info" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), "", null }, ReqBody.class);
    public subcmd0x533.HttpAROcrInfo msg_ocr_info = new subcmd0x533.HttpAROcrInfo();
    public final PBStringField string_clt_version = PBField.initString("");
    public final PBStringField string_session_id = PBField.initString("");
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_req_recog_type = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 74 }, new String[] { "string_session_id", "uint64_req_recog_type", "uint32_business_type", "msg_ocr_result" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), null }, RspBody.class);
    public subcmd0x533.HttpAROcrResult msg_ocr_result = new subcmd0x533.HttpAROcrResult();
    public final PBStringField string_session_id = PBField.initString("");
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_req_recog_type = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x533
 * JD-Core Version:    0.7.0.1
 */