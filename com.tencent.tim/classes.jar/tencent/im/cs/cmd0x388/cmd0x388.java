package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x388
{
  public static final class DelImgReq
    extends MessageMicro<DelImgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_platform_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_term = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64, 72 }, new String[] { "uint64_src_uin", "uint64_dst_uin", "uint32_req_term", "uint32_req_platform_type", "uint32_bu_type", "bytes_build_ver", "bytes_file_resid", "uint32_pic_width", "uint32_pic_height" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, DelImgReq.class);
    }
  }
  
  public static final class DelImgRsp
    extends MessageMicro<DelImgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_fail_msg", "bytes_file_resid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, DelImgRsp.class);
    }
  }
  
  public static final class ExpRoamExtendInfo
    extends MessageMicro<ExpRoamExtendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_resid" }, new Object[] { localByteStringMicro }, ExpRoamExtendInfo.class);
    }
  }
  
  public static final class ExpRoamPicInfo
    extends MessageMicro<ExpRoamPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_pkg_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_shop_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_shop_flag", "uint32_pkg_id", "bytes_pic_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ExpRoamPicInfo.class);
    }
  }
  
  public static final class ExtensionCommPicTryUp
    extends MessageMicro<ExtensionCommPicTryUp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_extinfo = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_bytes_extinfo" }, new Object[] { localByteStringMicro }, ExtensionCommPicTryUp.class);
    }
  }
  
  public static final class ExtensionExpRoamTryUp
    extends MessageMicro<ExtensionExpRoamTryUp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_exproam_pic_info" }, new Object[] { null }, ExtensionExpRoamTryUp.class);
    public final PBRepeatMessageField<cmd0x388.ExpRoamPicInfo> rpt_msg_exproam_pic_info = PBField.initRepeatMessage(cmd0x388.ExpRoamPicInfo.class);
  }
  
  public static final class GetImgUrlReq
    extends MessageMicro<GetImgUrlReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_original_pic = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_up_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_platform_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_term = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retry_req = PBField.initUInt32(0);
    public final PBUInt32Field uint32_url_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64, 72, 80, 90, 96, 104, 112, 120, 128, 136, 144, 152, 160 }, new String[] { "uint64_group_code", "uint64_dst_uin", "uint64_fileid", "bytes_file_md5", "uint32_url_flag", "uint32_url_type", "uint32_req_term", "uint32_req_platform_type", "uint32_inner_ip", "uint32_bu_type", "bytes_build_ver", "uint64_file_id", "uint64_file_size", "uint32_original_pic", "uint32_retry_req", "uint32_file_height", "uint32_file_width", "uint32_pic_type", "uint32_pic_up_timestamp", "uint32_req_transfer_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetImgUrlReq.class);
    }
  }
  
  public static final class GetImgUrlRsp
    extends MessageMicro<GetImgUrlRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_big_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_big_thumb_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_client_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_down_domain = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_original_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0x388.ImgInfo msg_img_info = new cmd0x388.ImgInfo();
    public final PBRepeatField<ByteStringMicro> rpt_bytes_big_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_original_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_thumb_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<cmd0x388.IPv6Info> rpt_msg_down_ip6 = PBField.initRepeatMessage(cmd0x388.IPv6Info.class);
    public final PBRepeatField<Integer> rpt_uint32_down_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_down_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_order_down_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_auto_down_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_https_url_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58, 66, 72, 80, 90, 98, 106, 114, 120, 128, 136, 154, 160, 210, 218 }, new String[] { "uint64_fileid", "bytes_file_md5", "uint32_result", "bytes_fail_msg", "msg_img_info", "rpt_bytes_thumb_down_url", "rpt_bytes_original_down_url", "rpt_bytes_big_down_url", "rpt_uint32_down_ip", "rpt_uint32_down_port", "bytes_down_domain", "bytes_thumb_down_para", "bytes_original_down_para", "bytes_big_down_para", "uint64_file_id", "uint32_auto_down_type", "rpt_uint32_order_down_type", "bytes_big_thumb_down_para", "uint32_https_url_flag", "rpt_msg_down_ip6", "bytes_client_ip6" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, null, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro10, Integer.valueOf(0), null, localByteStringMicro11 }, GetImgUrlRsp.class);
    }
  }
  
  public static final class GetPttUrlReq
    extends MessageMicro<GetPttUrlReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bu_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_codec = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_auto = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_platform_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_term = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64, 74, 80, 90, 96, 104, 112, 120 }, new String[] { "uint64_group_code", "uint64_dst_uin", "uint64_fileid", "bytes_file_md5", "uint32_req_term", "uint32_req_platform_type", "uint32_inner_ip", "uint32_bu_type", "bytes_build_ver", "uint64_file_id", "bytes_file_key", "uint32_codec", "uint32_bu_id", "uint32_req_transfer_type", "uint32_is_auto" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetPttUrlReq.class);
    }
  }
  
  public static final class GetPttUrlRsp
    extends MessageMicro<GetPttUrlRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_down_domain = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<cmd0x388.IPv6Info> rpt_msg_down_ip6 = PBField.initRepeatMessage(cmd0x388.IPv6Info.class);
    public final PBStringField rpt_str_domain = PBField.initString("");
    public final PBRepeatField<Integer> rpt_uint32_down_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_down_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_allow_retry = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_transfer_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 56, 66, 74, 80, 88, 96, 210, 218, 226 }, new String[] { "uint64_fileid", "bytes_file_md5", "uint32_result", "bytes_fail_msg", "rpt_bytes_down_url", "rpt_uint32_down_ip", "rpt_uint32_down_port", "bytes_down_domain", "bytes_down_para", "uint64_file_id", "uint32_transfer_type", "uint32_allow_retry", "rpt_msg_down_ip6", "bytes_client_ip6", "rpt_str_domain" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro6, "" }, GetPttUrlRsp.class);
    }
  }
  
  public static final class IPv6Info
    extends MessageMicro<IPv6Info>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_ip6", "uint32_port" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, IPv6Info.class);
    }
  }
  
  public static final class ImgInfo
    extends MessageMicro<ImgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "bytes_file_md5", "uint32_file_type", "uint64_file_size", "uint32_file_width", "uint32_file_height" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ImgInfo.class);
    }
  }
  
  public static final class PicSize
    extends MessageMicro<PicSize>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_original", "uint32_thumb", "uint32_high" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PicSize.class);
    public final PBUInt32Field uint32_high = PBField.initUInt32(0);
    public final PBUInt32Field uint32_original = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_extension = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<cmd0x388.DelImgReq> rpt_msg_del_img_req = PBField.initRepeatMessage(cmd0x388.DelImgReq.class);
    public final PBRepeatMessageField<cmd0x388.GetImgUrlReq> rpt_msg_getimg_url_req = PBField.initRepeatMessage(cmd0x388.GetImgUrlReq.class);
    public final PBRepeatMessageField<cmd0x388.GetPttUrlReq> rpt_msg_getptt_url_req = PBField.initRepeatMessage(cmd0x388.GetPttUrlReq.class);
    public final PBRepeatMessageField<cmd0x388.TryUpImgReq> rpt_msg_tryup_img_req = PBField.initRepeatMessage(cmd0x388.TryUpImgReq.class);
    public final PBRepeatMessageField<cmd0x388.TryUpPttReq> rpt_msg_tryup_ptt_req = PBField.initRepeatMessage(cmd0x388.TryUpPttReq.class);
    public final PBUInt32Field uint32_command_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 66, 8010 }, new String[] { "uint32_net_type", "uint32_subcmd", "rpt_msg_tryup_img_req", "rpt_msg_getimg_url_req", "rpt_msg_tryup_ptt_req", "rpt_msg_getptt_url_req", "uint32_command_id", "rpt_msg_del_img_req", "bytes_extension" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58 }, new String[] { "uint32_client_ip", "uint32_subcmd", "rpt_msg_tryup_img_rsp", "rpt_msg_getimg_url_rsp", "rpt_msg_tryup_ptt_rsp", "rpt_msg_getptt_url_rsp", "rpt_msg_del_img_rsp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null }, RspBody.class);
    public final PBRepeatMessageField<cmd0x388.DelImgRsp> rpt_msg_del_img_rsp = PBField.initRepeatMessage(cmd0x388.DelImgRsp.class);
    public final PBRepeatMessageField<cmd0x388.GetImgUrlRsp> rpt_msg_getimg_url_rsp = PBField.initRepeatMessage(cmd0x388.GetImgUrlRsp.class);
    public final PBRepeatMessageField<cmd0x388.GetPttUrlRsp> rpt_msg_getptt_url_rsp = PBField.initRepeatMessage(cmd0x388.GetPttUrlRsp.class);
    public final PBRepeatMessageField<cmd0x388.TryUpImgRsp> rpt_msg_tryup_img_rsp = PBField.initRepeatMessage(cmd0x388.TryUpImgRsp.class);
    public final PBRepeatMessageField<cmd0x388.TryUpPttRsp> rpt_msg_tryup_ptt_rsp = PBField.initRepeatMessage(cmd0x388.TryUpPttRsp.class);
    public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class TryUpImgReq
    extends MessageMicro<TryUpImgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_index = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_transfer_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_app_pic_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_original_pic = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt32Field uint32_srv_upload = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56, 64, 72, 80, 88, 96, 106, 112, 120, 128, 138, 144, 152, 162 }, new String[] { "uint64_group_code", "uint64_src_uin", "uint64_file_id", "bytes_file_md5", "uint64_file_size", "bytes_file_name", "uint32_src_term", "uint32_platform_type", "uint32_bu_type", "uint32_pic_width", "uint32_pic_height", "uint32_pic_type", "bytes_build_ver", "uint32_inner_ip", "uint32_app_pic_type", "uint32_original_pic", "bytes_file_index", "uint64_dst_uin", "uint32_srv_upload", "bytes_transfer_url" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro5 }, TryUpImgReq.class);
    }
  }
  
  public static final class TryUpImgRsp
    extends MessageMicro<TryUpImgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exit = PBField.initBool(false);
    public final PBBoolField bool_new_big_chan = PBField.initBool(false);
    public final PBBytesField bytes_client_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_up_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0x388.ImgInfo msg_img_info = new cmd0x388.ImgInfo();
    public cmd0x388.TryUpInfo4Busi msg_info4busi = new cmd0x388.TryUpInfo4Busi();
    public final PBRepeatMessageField<cmd0x388.IPv6Info> rpt_msg_up_ip6 = PBField.initRepeatMessage(cmd0x388.IPv6Info.class);
    public final PBRepeatField<Integer> rpt_uint32_up_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_up_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_up_offset = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66, 72, 80, 88, 96, 210, 218, 8010 }, new String[] { "uint64_file_id", "uint32_result", "bytes_fail_msg", "bool_file_exit", "msg_img_info", "rpt_uint32_up_ip", "rpt_uint32_up_port", "bytes_up_ukey", "uint64_fileid", "uint64_up_offset", "uint64_block_size", "bool_new_big_chan", "rpt_msg_up_ip6", "bytes_client_ip6", "msg_info4busi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Boolean.valueOf(false), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), null, localByteStringMicro3, null }, TryUpImgRsp.class);
    }
  }
  
  public static final class TryUpInfo4Busi
    extends MessageMicro<TryUpInfo4Busi>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_big_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_down_domain = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_resid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_original_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "bytes_down_domain", "bytes_thumb_down_url", "bytes_original_down_url", "bytes_big_down_url", "bytes_file_resid" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, TryUpInfo4Busi.class);
    }
  }
  
  public static final class TryUpPttReq
    extends MessageMicro<TryUpPttReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_new_up_chan = PBField.initBool(false);
    public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bu_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_codec = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_length = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56, 64, 72, 82, 88, 96, 104, 112, 120, 128 }, new String[] { "uint64_group_code", "uint64_src_uin", "uint64_file_id", "bytes_file_md5", "uint64_file_size", "bytes_file_name", "uint32_src_term", "uint32_platform_type", "uint32_bu_type", "bytes_build_ver", "uint32_inner_ip", "uint32_voice_length", "bool_new_up_chan", "uint32_codec", "uint32_voice_type", "uint32_bu_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TryUpPttReq.class);
    }
  }
  
  public static final class TryUpPttRsp
    extends MessageMicro<TryUpPttRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exit = PBField.initBool(false);
    public final PBBytesField bytes_client_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_up_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<cmd0x388.IPv6Info> rpt_msg_up_ip6 = PBField.initRepeatMessage(cmd0x388.IPv6Info.class);
    public final PBRepeatField<Integer> rpt_uint32_up_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_up_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_up_offset = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 58, 64, 72, 80, 90, 96, 210, 218 }, new String[] { "uint64_file_id", "uint32_result", "bytes_fail_msg", "bool_file_exit", "rpt_uint32_up_ip", "rpt_uint32_up_port", "bytes_up_ukey", "uint64_fileid", "uint64_up_offset", "uint64_block_size", "bytes_file_key", "uint32_channel_type", "rpt_msg_up_ip6", "bytes_client_ip6" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), null, localByteStringMicro4 }, TryUpPttRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388
 * JD-Core Version:    0.7.0.1
 */