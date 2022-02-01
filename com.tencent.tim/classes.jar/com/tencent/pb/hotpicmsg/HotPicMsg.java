package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class HotPicMsg
{
  public static final class GetImgInfoReq
    extends MessageMicro<GetImgInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_search_word = PBField.initString("");
    public final PBUInt32Field uint32_build_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_pic_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_update = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_tag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_search_req = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_pic_index = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 74, 80, 90 }, new String[] { "bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_build_ver", "uint32_pic_tag", "uint32_start_pic_index", "uint32_end_pic_index", "uint32_need_update", "bytes_client_ver", "uint32_search_req", "str_search_word" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), "" }, GetImgInfoReq.class);
    }
  }
  
  public static final class GetImgInfoRsp
    extends MessageMicro<GetImgInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<HotPicMsg.ImgInfo> rpt_msg_img_info = PBField.initRepeatMessage(HotPicMsg.ImgInfo.class);
    public final PBRepeatMessageField<HotPicMsg.TagInfo> rpt_msg_tag_info = PBField.initRepeatMessage(HotPicMsg.TagInfo.class);
    public final PBUInt32Field uint32_build_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48 }, new String[] { "int32_result", "bytes_fail_msg", "uint32_build_ver", "rpt_msg_img_info", "rpt_msg_tag_info", "uint32_tag_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), null, null, Integer.valueOf(0) }, GetImgInfoRsp.class);
    }
  }
  
  public static final class GetVideoInfoReq
    extends MessageMicro<GetVideoInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_build_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_video_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_update = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_video_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 66, 72 }, new String[] { "bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_tag_id", "uint32_build_ver", "uint32_start_video_index", "uint32_end_video_index", "bytes_client_ver", "uint32_need_update" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, GetVideoInfoReq.class);
    }
  }
  
  public static final class GetVideoInfoRsp
    extends MessageMicro<GetVideoInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<HotPicMsg.TagInfo> rpt_msg_tag_info = PBField.initRepeatMessage(HotPicMsg.TagInfo.class);
    public final PBRepeatMessageField<HotPicMsg.VideoInfo> rpt_msg_video_info = PBField.initRepeatMessage(HotPicMsg.VideoInfo.class);
    public final PBUInt32Field uint32_build_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48 }, new String[] { "int32_result", "bytes_fail_msg", "uint32_build_ver", "rpt_msg_video_info", "rpt_msg_tag_info", "uint32_tag_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), null, null, Integer.valueOf(0) }, GetVideoInfoRsp.class);
    }
  }
  
  public static final class ImgInfo
    extends MessageMicro<ImgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public HotPicMsg.ThirdPartyInfo msg_third_party_info = new HotPicMsg.ThirdPartyInfo();
    public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_file_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_file_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_thumb_file_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 58, 64, 72, 80, 90, 96, 104, 114 }, new String[] { "bytes_file_md5", "uint32_file_type", "uint64_file_size", "uint32_file_width", "uint32_file_height", "bytes_pic_down_url", "bytes_thumb_file_md5", "uint64_thumb_file_size", "uint32_thumb_file_width", "uint32_thumb_file_height", "bytes_thumb_down_url", "uint32_pic_index", "uint32_source_type", "msg_third_party_info" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), null }, ImgInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_get_imginfo_req", "msg_get_videoinfo_req" }, new Object[] { null, null }, ReqBody.class);
    public HotPicMsg.GetImgInfoReq msg_get_imginfo_req = new HotPicMsg.GetImgInfoReq();
    public HotPicMsg.GetVideoInfoReq msg_get_videoinfo_req = new HotPicMsg.GetVideoInfoReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_get_imginfo_rsp", "msg_get_videoinfo_rsp" }, new Object[] { null, null }, RspBody.class);
    public HotPicMsg.GetImgInfoRsp msg_get_imginfo_rsp = new HotPicMsg.GetImgInfoRsp();
    public HotPicMsg.GetVideoInfoRsp msg_get_videoinfo_rsp = new HotPicMsg.GetVideoInfoRsp();
  }
  
  public static final class TagInfo
    extends MessageMicro<TagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_tag_id", "bytes_tag_name", "uint32_tag_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, TagInfo.class);
    }
  }
  
  public static final class ThirdPartyInfo
    extends MessageMicro<ThirdPartyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_appid", "bytes_icon_url", "bytes_name", "bytes_jump_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ThirdPartyInfo.class);
    }
  }
  
  public static final class VideoInfo
    extends MessageMicro<VideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_certificated_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_preview_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_preview_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_source = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_preview_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_preview_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_preview_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_video_length = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_video_size = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 58, 66, 74, 82, 88, 96, 104, 114, 122, 130, 136 }, new String[] { "bytes_preview_md5", "uint64_preview_size", "uint32_preview_width", "uint32_preview_height", "bytes_preview_uuid", "uint32_video_index", "bytes_jump_icon", "bytes_jump_url", "bytes_video_name", "bytes_video_source", "uint64_video_length", "uint32_video_width", "uint32_video_height", "bytes_video_uuid", "bytes_video_md5", "bytes_certificated_icon", "uint64_video_size" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Long.valueOf(0L) }, VideoInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.hotpicmsg.HotPicMsg
 * JD-Core Version:    0.7.0.1
 */