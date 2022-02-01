package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class PremadesTeamServerOuterClass$BatchGetSmobaTeamInfoRsp
  extends MessageMicro<BatchGetSmobaTeamInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 32 }, new String[] { "team_list", "share_yolo_room_msg", "refresh_interval" }, new Object[] { null, null, Integer.valueOf(0) }, BatchGetSmobaTeamInfoRsp.class);
  public final PBInt32Field refresh_interval = PBField.initInt32(0);
  public final PBRepeatMessageField<MessageOuterClass.ShareYoloRoomMsg> share_yolo_room_msg = PBField.initRepeatMessage(MessageOuterClass.ShareYoloRoomMsg.class);
  public final PBRepeatMessageField<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> team_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass.SmobaPremadesTeamInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoRsp
 * JD-Core Version:    0.7.0.1
 */