package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.RoomUserInfo;

public final class AvGameNotify$RoomOwnerStartGameS2CReq
  extends MessageMicro<RoomOwnerStartGameS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "actor_info", "question_info", "game_info", "question_class" }, new Object[] { null, null, null, "" }, RoomOwnerStartGameS2CReq.class);
  public AvGameCommon.RoomUserInfo actor_info = new AvGameCommon.RoomUserInfo();
  public AvGameCommon.GameInfo game_info = new AvGameCommon.GameInfo();
  public final PBStringField question_class = PBField.initString("");
  public AvGameCommon.GameQuestionInfo question_info = new AvGameCommon.GameQuestionInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.RoomOwnerStartGameS2CReq
 * JD-Core Version:    0.7.0.1
 */