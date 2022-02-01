package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class PremadesTeamServerOuterClass$RefreshAPIRsp
  extends MessageMicro<RefreshAPIRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "team_list", "share_yolo_room_msg", "user_route_list", "refresh_interval" }, new Object[] { null, null, null, Integer.valueOf(0) }, RefreshAPIRsp.class);
  public final PBInt32Field refresh_interval = PBField.initInt32(0);
  public final PBRepeatMessageField<MessageOuterClass.ShareYoloRoomMsg> share_yolo_room_msg = PBField.initRepeatMessage(MessageOuterClass.ShareYoloRoomMsg.class);
  public final PBRepeatMessageField<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> team_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass.SmobaPremadesTeamInfo.class);
  public final PBRepeatMessageField<PremadesTeamServerOuterClass.UserOnlineRouteInfoList> user_route_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass.UserOnlineRouteInfoList.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.PremadesTeamServerOuterClass.RefreshAPIRsp
 * JD-Core Version:    0.7.0.1
 */