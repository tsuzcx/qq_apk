package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARCloudRecogCustomPb
{
  public static final class ARFaceDetectInfo
    extends MessageMicro<ARFaceDetectInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin32_timeout_ms" }, new Object[] { Integer.valueOf(0) }, ARFaceDetectInfo.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class ARFaceDetectResult
    extends MessageMicro<ARFaceDetectResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field ar_face_detect_errorcode = PBField.initInt32(0);
    public final PBStringField ar_face_detect_errormsg = PBField.initString("");
    public final PBRepeatField<ByteStringMicro> cdb_res = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public YTOpenDetection.DetectFaceRsp image_ar_face_detect_res = new YTOpenDetection.DetectFaceRsp();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "ar_face_detect_errorcode", "ar_face_detect_errormsg", "cdb_res", "image_ar_face_detect_res" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, null }, ARFaceDetectResult.class);
    }
  }
  
  public static final class ARFaceRecogInfo
    extends MessageMicro<ARFaceRecogInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin32_timeout_ms", "face_rect" }, new Object[] { Integer.valueOf(0), null }, ARFaceRecogInfo.class);
    public final PBRepeatMessageField<ARCloudRecogCustomPb.FaceRect> face_rect = PBField.initRepeatMessage(ARCloudRecogCustomPb.FaceRect.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class ARFaceRecogRes
    extends MessageMicro<ARFaceRecogRes>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "errorcode", "errormsg", "session_id", "star_info", "time_ms", "group_size" }, new Object[] { Integer.valueOf(0), "", "", null, Integer.valueOf(0), Integer.valueOf(0) }, ARFaceRecogRes.class);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBInt32Field group_size = PBField.initInt32(0);
    public final PBStringField session_id = PBField.initString("");
    public final PBRepeatMessageField<ARCloudRecogCustomPb.StarInfo> star_info = PBField.initRepeatMessage(ARCloudRecogCustomPb.StarInfo.class);
    public final PBInt32Field time_ms = PBField.initInt32(0);
  }
  
  public static final class ARFaceRecogResult
    extends MessageMicro<ARFaceRecogResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field ar_face_recog_errorcode = PBField.initInt32(0);
    public final PBStringField ar_face_recog_errormsg = PBField.initString("");
    public final PBRepeatField<ByteStringMicro> cdb_res = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public ARCloudRecogCustomPb.ARFaceRecogRes image_ar_face_recog_res = new ARCloudRecogCustomPb.ARFaceRecogRes();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "ar_face_recog_errorcode", "ar_face_recog_errormsg", "cdb_res", "image_ar_face_recog_res" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, null }, ARFaceRecogResult.class);
    }
  }
  
  public static final class ARFaceRegInfo
    extends MessageMicro<ARFaceRegInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_img_cnt", "uin32_timeout_ms", "person_id", "person_name", "group_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, ARFaceRegInfo.class);
    public final PBRepeatField<String> group_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField person_id = PBField.initString("");
    public final PBStringField person_name = PBField.initString("");
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
    public final PBUInt32Field uint32_img_cnt = PBField.initUInt32(0);
  }
  
  public static final class ARFaceRegResult
    extends MessageMicro<ARFaceRegResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "errorcode", "errormsg", "ar_face_reg_errorcode", "ar_face_reg_errormsg", "session_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "" }, ARFaceRegResult.class);
    public final PBInt32Field ar_face_reg_errorcode = PBField.initInt32(0);
    public final PBStringField ar_face_reg_errormsg = PBField.initString("");
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBStringField session_id = PBField.initString("");
  }
  
  public static final class ARGameInfo
    extends MessageMicro<ARGameInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "uint32_ar_game_cmd", "msg_get_id_req", "msg_recog_id_req" }, new Object[] { Integer.valueOf(0), null, null }, ARGameInfo.class);
    public ARCloudRecogCustomPb.GetIdentityReq msg_get_id_req = new ARCloudRecogCustomPb.GetIdentityReq();
    public ARCloudRecogCustomPb.RecogIdentityReq msg_recog_id_req = new ARCloudRecogCustomPb.RecogIdentityReq();
    public final PBUInt32Field uint32_ar_game_cmd = PBField.initUInt32(0);
  }
  
  public static final class ARGameResult
    extends MessageMicro<ARGameResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 90, 98 }, new String[] { "uint32_ar_game_cmd", "errorcode", "errormsg", "msg_get_id_rsp", "msg_recog_id_rsp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null, null }, ARGameResult.class);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public ARCloudRecogCustomPb.GetIdentityRsp msg_get_id_rsp = new ARCloudRecogCustomPb.GetIdentityRsp();
    public ARCloudRecogCustomPb.RecogIdentityRsp msg_recog_id_rsp = new ARCloudRecogCustomPb.RecogIdentityRsp();
    public final PBUInt32Field uint32_ar_game_cmd = PBField.initUInt32(0);
  }
  
  public static final class ARMarkerRecogInfo
    extends MessageMicro<ARMarkerRecogInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin32_timeout_ms" }, new Object[] { Integer.valueOf(0) }, ARMarkerRecogInfo.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class ARMarkerRecogResult
    extends MessageMicro<ARMarkerRecogResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "image_ar_search_errorcode", "image_ar_search_errormsg", "image_ar_search_res" }, new Object[] { Integer.valueOf(0), "", null }, ARMarkerRecogResult.class);
    public final PBInt32Field image_ar_search_errorcode = PBField.initInt32(0);
    public final PBStringField image_ar_search_errormsg = PBField.initString("");
    public ARCloudRecogCustomPb.ImageARSearchRes image_ar_search_res = new ARCloudRecogCustomPb.ImageARSearchRes();
  }
  
  public static final class ARObjectClassifyInfo
    extends MessageMicro<ARObjectClassifyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin32_timeout_ms" }, new Object[] { Integer.valueOf(0) }, ARObjectClassifyInfo.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class ARObjectClassifyResult
    extends MessageMicro<ARObjectClassifyResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ar_object_classify_errorcode", "ar_object_classify_errormsg", "image_ar_search_res" }, new Object[] { Integer.valueOf(0), "", null }, ARObjectClassifyResult.class);
    public final PBInt32Field ar_object_classify_errorcode = PBField.initInt32(0);
    public final PBStringField ar_object_classify_errormsg = PBField.initString("");
    public ARCloudRecogCustomPb.ImageARSearchRes image_ar_search_res = new ARCloudRecogCustomPb.ImageARSearchRes();
  }
  
  public static final class AROcrInfo
    extends MessageMicro<AROcrInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uin64_ocr_recog_type", "youtu_ocr_req", "sougou_req", "jd_pic_search_req", "jd_hot_search_req", "jd_search_req" }, new Object[] { Long.valueOf(0L), null, null, null, null, null }, AROcrInfo.class);
    public JDSearch.JdHotSearchReq jd_hot_search_req = new JDSearch.JdHotSearchReq();
    public JDSearch.JdPicSearchReq jd_pic_search_req = new JDSearch.JdPicSearchReq();
    public JDSearch.JdSearchReq jd_search_req = new JDSearch.JdSearchReq();
    public SougouSearch.ClientRequestBodyV2 sougou_req = new SougouSearch.ClientRequestBodyV2();
    public final PBUInt64Field uin64_ocr_recog_type = PBField.initUInt64(0L);
    public YoutuOcr.YoutuOcrReq youtu_ocr_req = new YoutuOcr.YoutuOcrReq();
  }
  
  public static final class AROcrResult
    extends MessageMicro<AROcrResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uin64_ocr_recog_type", "youtu_ocr_rsp", "sougou_rsp", "jd_pic_search_rsp", "jd_hot_search_rsp", "jd_search_rsp" }, new Object[] { Long.valueOf(0L), null, null, null, null, null }, AROcrResult.class);
    public JDSearch.JdHotSearchRsp jd_hot_search_rsp = new JDSearch.JdHotSearchRsp();
    public JDSearch.JdPicSearchRsp jd_pic_search_rsp = new JDSearch.JdPicSearchRsp();
    public JDSearch.JdSearchRsp jd_search_rsp = new JDSearch.JdSearchRsp();
    public SougouSearch.ServerResponseBodyV2 sougou_rsp = new SougouSearch.ServerResponseBodyV2();
    public final PBUInt64Field uin64_ocr_recog_type = PBField.initUInt64(0L);
    public YoutuOcr.YoutuOcrRsp youtu_ocr_rsp = new YoutuOcr.YoutuOcrRsp();
  }
  
  public static final class ARSceneClassifyInfo
    extends MessageMicro<ARSceneClassifyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin32_timeout_ms" }, new Object[] { Integer.valueOf(0) }, ARSceneClassifyInfo.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class ARSceneClassifyResult
    extends MessageMicro<ARSceneClassifyResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ar_errorcode", "ar_errormsg", "image_ar_search_res" }, new Object[] { Integer.valueOf(0), "", null }, ARSceneClassifyResult.class);
    public final PBInt32Field ar_errorcode = PBField.initInt32(0);
    public final PBStringField ar_errormsg = PBField.initString("");
    public ARCloudRecogCustomPb.ImageARSearchRes image_ar_search_res = new ARCloudRecogCustomPb.ImageARSearchRes();
  }
  
  public static final class ARWordDetectInfo
    extends MessageMicro<ARWordDetectInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin32_timeout_ms", "uin32_get_ocr_class" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ARWordDetectInfo.class);
    public final PBUInt32Field uin32_get_ocr_class = PBField.initUInt32(0);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class ARWordDetectResult
    extends MessageMicro<ARWordDetectResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 61, 66 }, new String[] { "errorcode", "errormsg", "ar_word_detect_errorcode", "ar_word_detect_errormsg", "session_id", "word_type", "confidence", "ocr_class" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "", Integer.valueOf(0), Float.valueOf(0.0F), null }, ARWordDetectResult.class);
    public final PBInt32Field ar_word_detect_errorcode = PBField.initInt32(0);
    public final PBStringField ar_word_detect_errormsg = PBField.initString("");
    public final PBFloatField confidence = PBField.initFloat(0.0F);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBRepeatMessageField<ARCloudRecogCustomPb.OcrClassify> ocr_class = PBField.initRepeatMessage(ARCloudRecogCustomPb.OcrClassify.class);
    public final PBStringField session_id = PBField.initString("");
    public final PBInt32Field word_type = PBField.initInt32(0);
  }
  
  public static final class CNBSInfo
    extends MessageMicro<CNBSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 808, 816 }, new String[] { "uint32_game_id", "uint32_confirmed", "uint32_confirm_time", "uint32_be_killed", "uint32_killed_time", "uint32_key_time", "uint32_sum_num", "uint32_dead_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, CNBSInfo.class);
    public final PBUInt32Field uint32_be_killed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_confirm_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_confirmed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dead_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_game_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_key_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_killed_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sum_num = PBField.initUInt32(0);
  }
  
  public static final class Coordinate
    extends MessageMicro<Coordinate>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_x", "int32_y", "int32_width", "int32_height" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Coordinate.class);
    public final PBInt32Field int32_height = PBField.initInt32(0);
    public final PBInt32Field int32_width = PBField.initInt32(0);
    public final PBInt32Field int32_x = PBField.initInt32(0);
    public final PBInt32Field int32_y = PBField.initInt32(0);
  }
  
  public static final class FaceRect
    extends MessageMicro<FaceRect>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "face_rect_id", "face_origin_x", "face_origin_y", "face_size_w", "face_size_h" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FaceRect.class);
    public final PBInt32Field face_origin_x = PBField.initInt32(0);
    public final PBInt32Field face_origin_y = PBField.initInt32(0);
    public final PBInt32Field face_rect_id = PBField.initInt32(0);
    public final PBInt32Field face_size_h = PBField.initInt32(0);
    public final PBInt32Field face_size_w = PBField.initInt32(0);
  }
  
  public static final class GetIdentityReq
    extends MessageMicro<GetIdentityReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_face_reg_info" }, new Object[] { null }, GetIdentityReq.class);
    public ARCloudRecogCustomPb.ARFaceRegInfo msg_face_reg_info = new ARCloudRecogCustomPb.ARFaceRegInfo();
  }
  
  public static final class GetIdentityRsp
    extends MessageMicro<GetIdentityRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "enum_game_id", "uint32_confirmed" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetIdentityRsp.class);
    public final PBEnumField enum_game_id = PBField.initEnum(0);
    public final PBUInt32Field uint32_confirmed = PBField.initUInt32(0);
  }
  
  public static final class ImageARSearchRes
    extends MessageMicro<ImageARSearchRes>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 66 }, new String[] { "errorcode", "errormsg", "session_id", "tags", "time_ms", "score", "kpt_num", "coordinate" }, new Object[] { Integer.valueOf(0), "", "", null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ImageARSearchRes.class);
    public ARCloudRecogCustomPb.Coordinate coordinate = new ARCloudRecogCustomPb.Coordinate();
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBInt32Field kpt_num = PBField.initInt32(0);
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBStringField session_id = PBField.initString("");
    public final PBRepeatMessageField<ARCloudRecogCustomPb.ImageARTag> tags = PBField.initRepeatMessage(ARCloudRecogCustomPb.ImageARTag.class);
    public final PBInt32Field time_ms = PBField.initInt32(0);
  }
  
  public static final class ImageARTag
    extends MessageMicro<ImageARTag>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field cdb_errorcode = PBField.initInt32(0);
    public final PBBytesField cdb_res = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field conf_id = PBField.initInt32(0);
    public final PBStringField image_id = PBField.initString("");
    public final PBUInt32Field need_check_lbs = PBField.initUInt32(0);
    public final PBInt32Field tag_confidence = PBField.initInt32(0);
    public final PBFloatField tag_confidence_f = PBField.initFloat(0.0F);
    public final PBStringField tag_name = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 37, 40, 808, 818, 824 }, new String[] { "image_id", "tag_name", "tag_confidence", "tag_confidence_f", "need_check_lbs", "cdb_errorcode", "cdb_res", "conf_id" }, new Object[] { "", "", Integer.valueOf(0), Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, ImageARTag.class);
    }
  }
  
  public static final class ImageRecord
    extends MessageMicro<ImageRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField angle = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field coordinate_x = PBField.initInt32(0);
    public final PBInt32Field coordinate_y = PBField.initInt32(0);
    public final PBInt32Field height = PBField.initInt32(0);
    public final PBBytesField source_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField target_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field width = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58 }, new String[] { "source_text", "target_text", "coordinate_x", "coordinate_y", "width", "height", "angle" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, ImageRecord.class);
    }
  }
  
  public static final class ImageTranslateReqInfo
    extends MessageMicro<ImageTranslateReqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField plateform = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField session_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField source_lang = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField target_lang = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "session_uuid", "source_lang", "target_lang", "plateform" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ImageTranslateReqInfo.class);
    }
  }
  
  public static final class ImageTranslateRspResult
    extends MessageMicro<ImageTranslateRspResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field image_translate_err_code = PBField.initInt32(0);
    public final PBBytesField image_translate_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<ARCloudRecogCustomPb.ImageRecord> msg_image_record_list = PBField.initRepeatMessage(ARCloudRecogCustomPb.ImageRecord.class);
    public final PBBytesField session_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField source_lange = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> support_translate_lang = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField target_lang = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "image_translate_err_code", "image_translate_err_msg", "session_uuid", "source_lange", "target_lang", "msg_image_record_list", "support_translate_lang" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, localByteStringMicro5 }, ImageTranslateRspResult.class);
    }
  }
  
  public static final class ImgRetrievalInfo
    extends MessageMicro<ImgRetrievalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin32_timeout_ms" }, new Object[] { Integer.valueOf(0) }, ImgRetrievalInfo.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class ImgRetrievalResult
    extends MessageMicro<ImgRetrievalResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "errorcode", "errormsg", "msg_ir_logic_rsp", "jd_search_rsp" }, new Object[] { Integer.valueOf(0), "", null, null }, ImgRetrievalResult.class);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public JDSearch.JdSearchRsp jd_search_rsp = new JDSearch.JdSearchRsp();
    public ImageRetrievalLogic.IRLogicRsp msg_ir_logic_rsp = new ImageRetrievalLogic.IRLogicRsp();
  }
  
  public static final class OcrClassify
    extends MessageMicro<OcrClassify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21 }, new String[] { "ocr_class", "confidence" }, new Object[] { "", Float.valueOf(0.0F) }, OcrClassify.class);
    public final PBFloatField confidence = PBField.initFloat(0.0F);
    public final PBStringField ocr_class = PBField.initString("");
  }
  
  public static final class QuestionRes
    extends MessageMicro<QuestionRes>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uin64_question_id", "str_question_content", "str_jump_url" }, new Object[] { Long.valueOf(0L), "", "" }, QuestionRes.class);
    public final PBStringField str_jump_url = PBField.initString("");
    public final PBStringField str_question_content = PBField.initString("");
    public final PBUInt64Field uin64_question_id = PBField.initUInt64(0L);
  }
  
  public static final class RecogIdentityReq
    extends MessageMicro<RecogIdentityReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_face_recog_info" }, new Object[] { null }, RecogIdentityReq.class);
    public ARCloudRecogCustomPb.ARFaceRecogInfo msg_face_recog_info = new ARCloudRecogCustomPb.ARFaceRecogInfo();
  }
  
  public static final class RecogIdentityRsp
    extends MessageMicro<RecogIdentityRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "image_ar_face_recog_res" }, new Object[] { null }, RecogIdentityRsp.class);
    public ARCloudRecogCustomPb.ARFaceRecogRes image_ar_face_recog_res = new ARCloudRecogCustomPb.ARFaceRecogRes();
  }
  
  public static final class SearchQuestionInfo
    extends MessageMicro<SearchQuestionInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin32_timeout_ms", "uin64_pic_height", "uin64_pic_width" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, SearchQuestionInfo.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
    public final PBUInt64Field uin64_pic_height = PBField.initUInt64(0L);
    public final PBUInt64Field uin64_pic_width = PBField.initUInt64(0L);
  }
  
  public static final class SearchQuestionResult
    extends MessageMicro<SearchQuestionResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> cdb_res = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public ARCloudRecogCustomPb.QuestionRes question_res = new ARCloudRecogCustomPb.QuestionRes();
    public final PBInt32Field search_question_errorcode = PBField.initInt32(0);
    public final PBStringField search_question_errormsg = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "search_question_errorcode", "search_question_errormsg", "cdb_res", "question_res" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, null }, SearchQuestionResult.class);
    }
  }
  
  public static final class StarInfo
    extends MessageMicro<StarInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 53, 58, 64, 72, 80, 88, 98, 808, 816 }, new String[] { "uin", "face_rect_id", "name", "star_wiki", "star_wiki_jumpurl", "confidence", "pinyin_name", "side_face", "mask", "sunglasses", "perspective", "star_wiki_title", "enum_game_id", "uint32_be_killed" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", "", Float.valueOf(0.0F), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, StarInfo.class);
    public final PBFloatField confidence = PBField.initFloat(0.0F);
    public final PBEnumField enum_game_id = PBField.initEnum(0);
    public final PBInt32Field face_rect_id = PBField.initInt32(0);
    public final PBInt32Field mask = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field perspective = PBField.initInt32(0);
    public final PBStringField pinyin_name = PBField.initString("");
    public final PBInt32Field side_face = PBField.initInt32(0);
    public final PBStringField star_wiki = PBField.initString("");
    public final PBStringField star_wiki_jumpurl = PBField.initString("");
    public final PBStringField star_wiki_title = PBField.initString("");
    public final PBInt32Field sunglasses = PBField.initInt32(0);
    public final PBInt64Field uin = PBField.initInt64(0L);
    public final PBUInt32Field uint32_be_killed = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb
 * JD-Core Version:    0.7.0.1
 */