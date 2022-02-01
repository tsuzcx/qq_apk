package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xac5
{
  public static final class HaiWanRecord
    extends MessageMicro<HaiWanRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_uin", "uint64_uid", "uint64_roomid", "uint32_timestamp", "uint32_haiwan_type", "uint64_root_roomid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, HaiWanRecord.class);
    public final PBUInt32Field uint32_haiwan_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_roomid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_root_roomid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class MasterState
    extends MessageMicro<MasterState>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_state = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_state", "bytes_jump_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, MasterState.class);
    }
  }
  
  public static final class NearbyLabelInfo
    extends MessageMicro<NearbyLabelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field font_colour = PBField.initUInt32(0);
    public final PBUInt32Field label_colour = PBField.initUInt32(0);
    public final PBUInt32Field label_id = PBField.initUInt32(0);
    public final PBBytesField label_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField label_pic = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field show_day = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48 }, new String[] { "label_id", "label_pic", "label_name", "label_colour", "font_colour", "show_day" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NearbyLabelInfo.class);
    }
  }
  
  public static final class NearbyNowData
    extends MessageMicro<NearbyNowData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_more_anchor_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_more_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field is_authen = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0xac5.NearbyLabelInfo> label_info = PBField.initRepeatMessage(cmd0xac5.NearbyLabelInfo.class);
    public cmd0xac5.MasterState master_state = new cmd0xac5.MasterState();
    public cmd0xac5.NowConfig msg_now_config = new cmd0xac5.NowConfig();
    public cmd0xac5.NowAnchorState now_anchor_state = new cmd0xac5.NowAnchorState();
    public final PBInt32Field now_msg_switch = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0xac5.NowFollowAnchor> rpt_msg_now_follow_anchor = PBField.initRepeatMessage(cmd0xac5.NowFollowAnchor.class);
    public final PBRepeatMessageField<cmd0xac5.NowHaiWan> rpt_msg_now_haiwan = PBField.initRepeatMessage(cmd0xac5.NowHaiWan.class);
    public final PBRepeatMessageField<cmd0xac5.NowVideoFeed> rpt_msg_now_video_feed = PBField.initRepeatMessage(cmd0xac5.NowVideoFeed.class);
    public final PBUInt64Field uint64_uid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 80, 88, 96 }, new String[] { "rpt_msg_now_haiwan", "rpt_msg_now_follow_anchor", "rpt_msg_now_video_feed", "bytes_more_anchor_url", "bytes_more_video_url", "msg_now_config", "master_state", "now_anchor_state", "label_info", "is_authen", "now_msg_switch", "uint64_uid" }, new Object[] { null, null, null, localByteStringMicro1, localByteStringMicro2, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, NearbyNowData.class);
    }
  }
  
  public static final class NowAnchorState
    extends MessageMicro<NowAnchorState>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_live_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_live_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_level", "uint32_live_status", "bytes_live_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, NowAnchorState.class);
    }
  }
  
  public static final class NowConfig
    extends MessageMicro<NowConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_live_boardcast_gif_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_live_boardcast_gif_url" }, new Object[] { localByteStringMicro }, NowConfig.class);
    }
  }
  
  public static final class NowFollowAnchor
    extends MessageMicro<NowFollowAnchor>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_live_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_live_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_live_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_now_uid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_nowid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 64, 72 }, new String[] { "uint64_uin", "uint64_now_uid", "bytes_nick_name", "bytes_head_url", "uint32_live_status", "bytes_live_url", "bytes_live_cover_url", "uint32_account_type", "uint64_nowid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Long.valueOf(0L) }, NowFollowAnchor.class);
    }
  }
  
  public static final class NowHaiWan
    extends MessageMicro<NowHaiWan>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_game_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_room_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 58, 66 }, new String[] { "bytes_title", "bytes_url", "uint32_status", "bytes_icon", "uint32_type", "bytes_cover_url", "bytes_game_icon", "bytes_room_title" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, NowHaiWan.class);
    }
  }
  
  public static final class NowHaiWanStorage
    extends MessageMicro<NowHaiWanStorage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_haiwan_record" }, new Object[] { null }, NowHaiWanStorage.class);
    public final PBRepeatMessageField<cmd0xac5.HaiWanRecord> rpt_msg_haiwan_record = PBField.initRepeatMessage(cmd0xac5.HaiWanRecord.class);
  }
  
  public static final class NowVideoFeed
    extends MessageMicro<NowVideoFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tnow_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_view_times = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "bytes_cover_url", "bytes_video_url", "uint32_video_duration", "uint32_view_times", "bytes_tnow_video_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, NowVideoFeed.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint64_tinyid", "uint32_gender" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint32_gender = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_now_data = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_now_data" }, new Object[] { localByteStringMicro }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac5.cmd0xac5
 * JD-Core Version:    0.7.0.1
 */