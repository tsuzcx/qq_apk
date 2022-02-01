package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.GameStatusInfo;

public final class AvGameNotify$NotifyMsg
  extends MessageMicro<NotifyMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public AvGameNotify.NotifyActorGiveOutAnswerS2CReq actor_giveout_answer_req = new AvGameNotify.NotifyActorGiveOutAnswerS2CReq();
  public AvGameNotify.NotifyAnswerFinishS2cReq answer_finish_req = new AvGameNotify.NotifyAnswerFinishS2cReq();
  public AvGameNotify.NotifyAnswerRightS2CReq answer_right_req = new AvGameNotify.NotifyAnswerRightS2CReq();
  public AvGameNotify.NotifyChangeActorS2CReq change_actor_req = new AvGameNotify.NotifyChangeActorS2CReq();
  public AvGameNotify.RoomOwnerChangeGameS2CReq change_game_req = new AvGameNotify.RoomOwnerChangeGameS2CReq();
  public AvGameNotify.NotifyChangeQuestionS2CReq change_question_req = new AvGameNotify.NotifyChangeQuestionS2CReq();
  public AvGameNotify.NotifyGameOverS2CReq game_over_req = new AvGameNotify.NotifyGameOverS2CReq();
  public AvGameNotify.NotifyMatchUserCreateRoom match_user_create_room = new AvGameNotify.NotifyMatchUserCreateRoom();
  public AvGameNotify.NotifyMatchUserEnterRoom match_user_enter_room = new AvGameNotify.NotifyMatchUserEnterRoom();
  public AvGameNotify.NotifyMatchV2UserCreateRoom match_v2_user_create_room = new AvGameNotify.NotifyMatchV2UserCreateRoom();
  public AvGameNotify.NotifyMatchV2UserEnterRoom match_v2_user_enter_room = new AvGameNotify.NotifyMatchV2UserEnterRoom();
  public AvGameNotify.NotifyNextActorTipsS2CReq next_actor_tips_req = new AvGameNotify.NotifyNextActorTipsS2CReq();
  public final PBUInt32Field pkID = PBField.initUInt32(0);
  public AvGameNotify.NotifyPKCallinUserTooFew pk_callin_user_too_few = new AvGameNotify.NotifyPKCallinUserTooFew();
  public AvGameNotify.NotifyPKPoolUserChange pk_pool_user_change = new AvGameNotify.NotifyPKPoolUserChange();
  public AvGameNotify.NotifyPKUserCreateRoom pk_user_create_room = new AvGameNotify.NotifyPKUserCreateRoom();
  public AvGameNotify.NotifyPKUserDraw pk_user_draw = new AvGameNotify.NotifyPKUserDraw();
  public AvGameNotify.NotifyPKUserEnterRoom pk_user_enter_room = new AvGameNotify.NotifyPKUserEnterRoom();
  public AvGameNotify.NotifyPKUserFail pk_user_fail = new AvGameNotify.NotifyPKUserFail();
  public AvGameNotify.NotifyPKUserFinalSucc pk_user_final_succ = new AvGameNotify.NotifyPKUserFinalSucc();
  public AvGameNotify.NotifyPKUserPass pk_user_pass = new AvGameNotify.NotifyPKUserPass();
  public AvGameNotify.NotifyPKUserSucc pk_user_succ = new AvGameNotify.NotifyPKUserSucc();
  public final PBStringField play_game_id = PBField.initString("");
  public final PBUInt32Field poolID = PBField.initUInt32(0);
  public AvGameNotify.NotifyQuestionTimeoutS2CReq question_timeout_req = new AvGameNotify.NotifyQuestionTimeoutS2CReq();
  public final PBUInt32Field realPoolID = PBField.initUInt32(0);
  public AvGameNotify.RoomDestoryS2CReq room_destory_req = new AvGameNotify.RoomDestoryS2CReq();
  public AvGameNotify.NotifyRoomMatchStatus room_match_status = new AvGameNotify.NotifyRoomMatchStatus();
  public AvGameNotify.RoomUserChangeStatusS2CReq room_user_change_status_req = new AvGameNotify.RoomUserChangeStatusS2CReq();
  public AvGameNotify.RoomUserEnterS2CReq room_user_enter_req = new AvGameNotify.RoomUserEnterS2CReq();
  public AvGameNotify.RoomUserExitS2CReq room_user_exit_req = new AvGameNotify.RoomUserExitS2CReq();
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public AvGameNotify.RoomOwnerStartGameS2CReq start_game_req = new AvGameNotify.RoomOwnerStartGameS2CReq();
  public AvGameCommon.GameStatusInfo status_info = new AvGameCommon.GameStatusInfo();
  public AvGameNotify.NotifyTranslateInfoS2CReq translate_info_req = new AvGameNotify.NotifyTranslateInfoS2CReq();
  public final PBEnumField type = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 136, 146, 154, 162, 170, 178, 186, 194, 202, 210, 218, 226, 234, 242, 248, 256, 266, 274, 282, 288, 298 }, new String[] { "seq", "type", "room_user_enter_req", "room_user_exit_req", "room_destory_req", "room_user_change_status_req", "status_info", "change_game_req", "start_game_req", "answer_right_req", "question_timeout_req", "change_question_req", "next_actor_tips_req", "change_actor_req", "actor_giveout_answer_req", "game_over_req", "roomid", "play_game_id", "translate_info_req", "match_user_enter_room", "match_user_create_room", "room_match_status", "pk_user_create_room", "pk_user_enter_room", "pk_user_succ", "pk_user_final_succ", "pk_user_fail", "pk_user_pass", "pk_callin_user_too_few", "pk_user_draw", "pkID", "poolID", "pk_pool_user_change", "match_v2_user_enter_room", "match_v2_user_create_room", "realPoolID", "answer_finish_req" }, new Object[] { Long.valueOf(0L), localInteger, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(0L), "", null, null, null, null, null, null, null, null, null, null, null, null, localInteger, localInteger, null, null, null, localInteger, null }, NotifyMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg
 * JD-Core Version:    0.7.0.1
 */