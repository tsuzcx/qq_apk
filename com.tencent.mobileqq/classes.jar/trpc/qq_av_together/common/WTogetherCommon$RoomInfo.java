package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WTogetherCommon$RoomInfo
  extends MessageMicro<RoomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 66 }, new String[] { "seq", "roomid", "owner_uin", "last_update_time", "player_status", "users", "room_create_ts", "video_info_rsp" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, Long.valueOf(0L), null }, RoomInfo.class);
  public final PBUInt64Field last_update_time = PBField.initUInt64(0L);
  public final PBUInt64Field owner_uin = PBField.initUInt64(0L);
  public WTogetherCommon.PlayerStatus player_status = new WTogetherCommon.PlayerStatus();
  public final PBUInt64Field room_create_ts = PBField.initUInt64(0L);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBRepeatMessageField<WTogetherCommon.RoomUserInfo> users = PBField.initRepeatMessage(WTogetherCommon.RoomUserInfo.class);
  public WTogetherCommon.VideoInfoRsp video_info_rsp = new WTogetherCommon.VideoInfoRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.RoomInfo
 * JD-Core Version:    0.7.0.1
 */