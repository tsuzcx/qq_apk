package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.RoomUserInfo;

public final class AvGameNotify$NotifyChangeActorS2CReq
  extends MessageMicro<NotifyChangeActorS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "actor_info", "question_info" }, new Object[] { null, null }, NotifyChangeActorS2CReq.class);
  public AvGameCommon.RoomUserInfo actor_info = new AvGameCommon.RoomUserInfo();
  public AvGameCommon.GameQuestionInfo question_info = new AvGameCommon.GameQuestionInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyChangeActorS2CReq
 * JD-Core Version:    0.7.0.1
 */