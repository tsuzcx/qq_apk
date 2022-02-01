package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby
{
  public static final class BarInfo
    extends MessageMicro<BarInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_bar_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_bar_pic = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_bar_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_bar_name", "bytes_bar_pic", "bytes_bar_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, BarInfo.class);
    }
  }
  
  public static final class Cmd0x1ReqBody
    extends MessageMicro<Cmd0x1ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_bars = PBField.initBool(false);
    public final PBBoolField bool_face_score = PBField.initBool(false);
    public final PBBoolField bool_fans = PBField.initBool(false);
    public final PBBoolField bool_published = PBField.initBool(false);
    public oidb_common.CommParamReq bytes_comm_param = new oidb_common.CommParamReq();
    public final PBBytesField bytes_user_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBFixed32Field uint32_client_addr = PBField.initFixed32(0);
    public final PBUInt32Field uint32_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_id_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_req_nowid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_req_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_req_uid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_user_uid = PBField.initUInt64(0L);
    public nearby.LoginSig user_login_sig = new nearby.LoginSig();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 45, 48, 56, 64, 72, 82, 88, 96, 106, 112, 120 }, new String[] { "uint32_seq", "uint64_req_uid", "uint64_req_tinyid", "bytes_user_cookie", "uint32_client_addr", "bool_published", "bool_bars", "bool_fans", "uint64_user_uid", "user_login_sig", "uint32_from", "bool_face_score", "bytes_comm_param", "uint64_req_nowid", "uint32_req_id_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(0L), null, Integer.valueOf(0), Boolean.valueOf(false), null, Long.valueOf(0L), Integer.valueOf(0) }, Cmd0x1ReqBody.class);
    }
  }
  
  public static final class Cmd0x1RspBody
    extends MessageMicro<Cmd0x1RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public nearby.FansInfo FansInfo_fans = new nearby.FansInfo();
    public final PBBoolField bool_follow = PBField.initBool(false);
    public final PBBytesField bytes_bars_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_chat_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_common.DataCardConfig bytes_face_score_config = new oidb_common.DataCardConfig();
    public final PBBytesField bytes_feed_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_feed_wording_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_feeds_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mask_gift_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mask_msg_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qunlist_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public nearby.NearbyJumpInfo nearby_popover_info = new nearby.NearbyJumpInfo();
    public final PBRepeatMessageField<nearby.BarInfo> rpt_BarInfo_bars = PBField.initRepeatMessage(nearby.BarInfo.class);
    public final PBRepeatMessageField<nearby.FeedInfo> rpt_FeedInfo_feeds = PBField.initRepeatMessage(nearby.FeedInfo.class);
    public final PBStringField str_jump_app_result_msg = PBField.initString("");
    public final PBStringField str_jump_app_url = PBField.initString("");
    public final PBStringField str_plus_download_app_msg = PBField.initString("");
    public final PBUInt32Field uint32_bars_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_err_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_high_score_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_if_mask_gift = PBField.initUInt32(0);
    public final PBUInt32Field uint32_if_mask_msg = PBField.initUInt32(0);
    public final PBUInt32Field uint32_jump_app_open = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 66, 74, 82, 90, 96, 104, 114, 120, 130, 138, 146, 152, 162, 168, 178, 186, 194, 202 }, new String[] { "uint32_seq", "uint32_err_code", "bytes_err_msg", "rpt_FeedInfo_feeds", "bytes_feeds_url", "rpt_BarInfo_bars", "uint32_bars_num", "bytes_bars_url", "FansInfo_fans", "bytes_qunlist_url", "bytes_chat_sig", "bool_follow", "uint32_if_mask_msg", "bytes_mask_msg_reason", "uint32_if_mask_gift", "bytes_mask_gift_reason", "bytes_feed_wording", "bytes_feed_wording_title", "uint32_high_score_num", "bytes_face_score_config", "uint32_jump_app_open", "str_jump_app_result_msg", "str_jump_app_url", "str_plus_download_app_msg", "nearby_popover_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2, null, Integer.valueOf(0), localByteStringMicro3, null, localByteStringMicro4, localByteStringMicro5, Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), null, Integer.valueOf(0), "", "", "", null }, Cmd0x1RspBody.class);
    }
  }
  
  public static final class FansInfo
    extends MessageMicro<FansInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fans_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_follows_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_fans_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follows_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_fans_num", "bytes_fans_url", "uint32_follows_num", "bytes_follows_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, FansInfo.class);
    }
  }
  
  public static final class FeedInfo
    extends MessageMicro<FeedInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_type", "bytes_pic" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, FeedInfo.class);
    }
  }
  
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_type", "bytes_sig", "uint32_appid" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, LoginSig.class);
    }
  }
  
  public static final class NearbyJumpInfo
    extends MessageMicro<NearbyJumpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "tip_content", "tip_left_btn", "tip_right_btn_installed", "tip_right_btn_not_installed", "android_app_key", "ios_app_key", "jump_uri", "app_download_url" }, new Object[] { "", "", "", "", "", "", "", "" }, NearbyJumpInfo.class);
    public final PBStringField android_app_key = PBField.initString("");
    public final PBStringField app_download_url = PBField.initString("");
    public final PBStringField ios_app_key = PBField.initString("");
    public final PBStringField jump_uri = PBField.initString("");
    public final PBStringField tip_content = PBField.initString("");
    public final PBStringField tip_left_btn = PBField.initString("");
    public final PBStringField tip_right_btn_installed = PBField.initString("");
    public final PBStringField tip_right_btn_not_installed = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.jungle.nearby.nio.proto.nearby
 * JD-Core Version:    0.7.0.1
 */