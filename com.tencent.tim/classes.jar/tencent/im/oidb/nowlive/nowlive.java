package tencent.im.oidb.nowlive;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nowlive
{
  public static final class AnchorInfo
    extends MessageMicro<AnchorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "fans", "status" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, AnchorInfo.class);
    public final PBUInt64Field fans = PBField.initUInt64(0L);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class CheckInfo
    extends MessageMicro<CheckInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField live_url = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uin", "live_url", "vid" }, new Object[] { Long.valueOf(0L), "", localByteStringMicro }, CheckInfo.class);
    }
  }
  
  public static final class CheckLiveStatusReq
    extends MessageMicro<CheckLiveStatusReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "check_info" }, new Object[] { null }, CheckLiveStatusReq.class);
    public final PBRepeatMessageField<nowlive.CheckInfo> check_info = PBField.initRepeatMessage(nowlive.CheckInfo.class);
  }
  
  public static final class CheckLiveStatusRsp
    extends MessageMicro<CheckLiveStatusRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "err_code", "err_msg", "mix_info" }, new Object[] { Integer.valueOf(0), "", null }, CheckLiveStatusRsp.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<nowlive.MixInfo> mix_info = PBField.initRepeatMessage(nowlive.MixInfo.class);
  }
  
  public static final class GetAnchorFansReq
    extends MessageMicro<GetAnchorFansReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "anchor_info" }, new Object[] { null }, GetAnchorFansReq.class);
    public nowlive.AnchorInfo anchor_info = new nowlive.AnchorInfo();
  }
  
  public static final class GetAnchorFansRsp
    extends MessageMicro<GetAnchorFansRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "err_code", "err_msg", "anchor_info" }, new Object[] { Integer.valueOf(0), "", null }, GetAnchorFansRsp.class);
    public nowlive.AnchorInfo anchor_info = new nowlive.AnchorInfo();
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
  }
  
  public static final class LiveInfo
    extends MessageMicro<LiveInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field audience = PBField.initUInt32(0);
    public final PBUInt32Field live_statue = PBField.initUInt32(0);
    public final PBStringField live_url = PBField.initString("");
    public final PBStringField room_cover = PBField.initString("");
    public final PBStringField room_name = PBField.initString("");
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50 }, new String[] { "live_url", "room_name", "room_cover", "live_statue", "audience", "vid" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, LiveInfo.class);
    }
  }
  
  public static final class MixInfo
    extends MessageMicro<MixInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "anchor_info", "live_info", "video_info" }, new Object[] { null, null, null }, MixInfo.class);
    public nowlive.AnchorInfo anchor_info = new nowlive.AnchorInfo();
    public nowlive.LiveInfo live_info = new nowlive.LiveInfo();
    public nowlive.VideoInfo video_info = new nowlive.VideoInfo();
  }
  
  public static final class PushAnchorInfo
    extends MessageMicro<PushAnchorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "msg_type", "anchor_info", "live_info", "timestamp" }, new Object[] { Integer.valueOf(0), null, null, Long.valueOf(0L) }, PushAnchorInfo.class);
    public nowlive.AnchorInfo anchor_info = new nowlive.AnchorInfo();
    public nowlive.LiveInfo live_info = new nowlive.LiveInfo();
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt64Field timestamp = PBField.initUInt64(0L);
  }
  
  public static final class VideoInfo
    extends MessageMicro<VideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField video_cover_url = PBField.initString("");
    public final PBStringField video_url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "vid", "video_url", "video_cover_url" }, new Object[] { localByteStringMicro, "", "" }, VideoInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.nowlive.nowlive
 * JD-Core Version:    0.7.0.1
 */