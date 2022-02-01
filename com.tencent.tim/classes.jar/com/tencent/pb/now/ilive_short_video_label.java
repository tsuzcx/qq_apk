package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_short_video_label
{
  public static final class FeedInfo
    extends MessageMicro<FeedInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField topic = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "feed_id", "topic", "url" }, new Object[] { localByteStringMicro, "", "" }, FeedInfo.class);
    }
  }
  
  public static final class GetShortVideoVideoLabelReq
    extends MessageMicro<GetShortVideoVideoLabelReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uid", "feed_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, GetShortVideoVideoLabelReq.class);
    }
  }
  
  public static final class GetShortVideoVideoLabelRsp
    extends MessageMicro<GetShortVideoVideoLabelRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "type", "video_status", "feed_info", "video_info" }, new Object[] { Integer.valueOf(0), null, null, null }, GetShortVideoVideoLabelRsp.class);
    public ilive_short_video_label.FeedInfo feed_info = new ilive_short_video_label.FeedInfo();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public ilive_short_video_label.VideoInfo video_info = new ilive_short_video_label.VideoInfo();
    public ilive_short_video_label.VideoStatus video_status = new ilive_short_video_label.VideoStatus();
  }
  
  public static final class OpensdkCB
    extends MessageMicro<OpensdkCB>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fileid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_format = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_json = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_streamid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_videoid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_videourl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 98 }, new String[] { "uint32_start_time", "uint32_end_time", "bytes_streamid", "bytes_fileid", "bytes_videoid", "bytes_videourl", "bytes_format", "bytes_json" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, OpensdkCB.class);
    }
  }
  
  public static final class RichTitleElement
    extends MessageMicro<RichTitleElement>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_type", "string_text", "string_url" }, new Object[] { Integer.valueOf(0), "", "" }, RichTitleElement.class);
    public final PBStringField string_text = PBField.initString("");
    public final PBStringField string_url = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class RoomInfo
    extends MessageMicro<RoomInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField anchor_logo_640 = PBField.initString("");
    public final PBStringField anchor_logo_80 = PBField.initString("");
    public final PBUInt64Field anchor_uin = PBField.initUInt64(0L);
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field get_from_room_info_svr_is_seted = PBField.initUInt32(0);
    public final PBStringField nick_name = PBField.initString("");
    public final PBStringField room_cover_url_640 = PBField.initString("");
    public final PBStringField room_cover_url_90 = PBField.initString("");
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBStringField room_name = PBField.initString("");
    public final PBUInt32Field subroom_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<ilive_short_video_label.RichTitleElement> title_info = PBField.initRepeatMessage(ilive_short_video_label.RichTitleElement.class);
    public final PBUInt32Field total_money = PBField.initUInt32(0);
    public final PBUInt32Field total_people = PBField.initUInt32(0);
    public final PBUInt32Field total_record_people = PBField.initUInt32(0);
    public final PBStringField vid = PBField.initString("");
    public final PBStringField video_cover_url = PBField.initString("");
    public final PBUInt32Field video_end_action_svr_is_seted = PBField.initUInt32(0);
    public final PBUInt32Field video_end_time = PBField.initUInt32(0);
    public final PBUInt32Field video_start_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 64, 74, 82, 88, 98, 106, 112, 122, 130, 136, 146, 400, 408 }, new String[] { "room_id", "subroom_id", "anchor_uin", "vid", "room_name", "title_info", "total_people", "total_money", "room_cover_url_90", "video_cover_url", "video_end_time", "room_cover_url_640", "nick_name", "video_start_time", "anchor_logo_80", "anchor_logo_640", "total_record_people", "city", "video_end_action_svr_is_seted", "get_from_room_info_svr_is_seted" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", null, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RoomInfo.class);
    }
  }
  
  public static final class RoomState
    extends MessageMicro<RoomState>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_m3u8_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sdk_fileid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sdk_json = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sdk_videourl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_transcode_result = PBField.initInt32(0);
    public final PBRepeatMessageField<ilive_short_video_label.OpensdkCB> rpt_extra_cb = PBField.initRepeatMessage(ilive_short_video_label.OpensdkCB.class);
    public final PBUInt32Field uint32_callbacktime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hlsState = PBField.initUInt32(0);
    public final PBUInt32Field uint32_indeletewhitelist = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inuinwhitelist = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_hls = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mp4State = PBField.initUInt32(0);
    public final PBUInt32Field uint32_roomid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sdk_starttime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sdk_stoptime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_starttime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_stoptime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subroomid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_viddeletedbyuser = PBField.initUInt32(0);
    public final PBUInt64Field uint64_anchor = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72, 82, 88, 96, 104, 112, 120, 128, 138, 146, 152, 160, 178, 186 }, new String[] { "uint64_anchor", "uint32_state", "uint32_roomid", "uint32_subroomid", "bytes_vid", "uint32_starttime", "uint32_stoptime", "uint32_callbacktime", "uint32_is_hls", "bytes_m3u8_path", "int32_transcode_result", "uint32_mp4State", "uint32_hlsState", "uint32_inuinwhitelist", "uint32_indeletewhitelist", "uint32_viddeletedbyuser", "bytes_sdk_fileid", "bytes_sdk_videourl", "uint32_sdk_starttime", "uint32_sdk_stoptime", "bytes_sdk_json", "rpt_extra_cb" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, null }, RoomState.class);
    }
  }
  
  public static final class VideoInfo
    extends MessageMicro<VideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField cover_url = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "vid", "url", "cover_url" }, new Object[] { localByteStringMicro, "", "" }, VideoInfo.class);
    }
  }
  
  public static final class VideoStatus
    extends MessageMicro<VideoStatus>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 69, 72, 80, 88 }, new String[] { "room_id", "root_room_id", "stat", "live_type", "timestamp", "client_type", "uin", "video_begin_timestamp", "sdk_type", "master_uin", "co_play_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, VideoStatus.class);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> co_play_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field live_type = PBField.initUInt32(0);
    public final PBUInt64Field master_uin = PBField.initUInt64(0L);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBUInt32Field root_room_id = PBField.initUInt32(0);
    public final PBUInt32Field sdk_type = PBField.initUInt32(0);
    public final PBUInt32Field stat = PBField.initUInt32(0);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBFixed32Field video_begin_timestamp = PBField.initFixed32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_short_video_label
 * JD-Core Version:    0.7.0.1
 */