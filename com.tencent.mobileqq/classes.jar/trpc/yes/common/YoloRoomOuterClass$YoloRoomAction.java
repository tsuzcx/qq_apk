package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomAction
  extends MessageMicro<YoloRoomAction>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field action_id = PBField.initUInt64(0L);
  public final PBUInt64Field action_time = PBField.initUInt64(0L);
  public final PBEnumField action_type = PBField.initEnum(11);
  public final PBUInt64Field client_seq_id = PBField.initUInt64(0L);
  public YoloRoomOuterClass.YoloBattleOBStatusChangeAction yolo_battle_ob_status_change_action = new YoloRoomOuterClass.YoloBattleOBStatusChangeAction();
  public YoloRoomOuterClass.YoloRoomAdminListChangeAction yolo_room_admin_list_change_action = new YoloRoomOuterClass.YoloRoomAdminListChangeAction();
  public YoloRoomOuterClass.YoloRoomAgreeSpeakingAction yolo_room_agree_speaking_action = new YoloRoomOuterClass.YoloRoomAgreeSpeakingAction();
  public YoloRoomOuterClass.YoloRoomApplySpeakingAction yolo_room_apply_speaking_action = new YoloRoomOuterClass.YoloRoomApplySpeakingAction();
  public YoloRoomOuterClass.YoloRoomBlackListChangeAction yolo_room_black_list_change_action = new YoloRoomOuterClass.YoloRoomBlackListChangeAction();
  public YoloRoomOuterClass.YoloRoomCloseGameAction yolo_room_close_game_action = new YoloRoomOuterClass.YoloRoomCloseGameAction();
  public YoloRoomOuterClass.YoloRoomDoubleCheckAction yolo_room_double_check_action = new YoloRoomOuterClass.YoloRoomDoubleCheckAction();
  public YoloRoomOuterClass.YoloRoomEnterAction yolo_room_enter_action = new YoloRoomOuterClass.YoloRoomEnterAction();
  public YoloRoomOuterClass.YoloRoomForbiddenSpeechAction yolo_room_forbidden_speech_action = new YoloRoomOuterClass.YoloRoomForbiddenSpeechAction();
  public YoloRoomOuterClass.YoloRoomGameResultLikeAction yolo_room_game_result_like_action = new YoloRoomOuterClass.YoloRoomGameResultLikeAction();
  public YoloRoomOuterClass.YoloRoomGreetUserAction yolo_room_greet_user_action = new YoloRoomOuterClass.YoloRoomGreetUserAction();
  public YoloRoomOuterClass.YoloRoomInvitedSpeakingAction yolo_room_invited_speaking_action = new YoloRoomOuterClass.YoloRoomInvitedSpeakingAction();
  public YoloRoomOuterClass.YoloRoomJoinGameAction yolo_room_join_game_action = new YoloRoomOuterClass.YoloRoomJoinGameAction();
  public YoloRoomOuterClass.YoloRoomKickOutRoomAction yolo_room_kick_out_room_action = new YoloRoomOuterClass.YoloRoomKickOutRoomAction();
  public YoloRoomOuterClass.YoloRoomKickOutSpeakingAction yolo_room_kick_out_speaking_action = new YoloRoomOuterClass.YoloRoomKickOutSpeakingAction();
  public YoloRoomOuterClass.YoloRoomLeaveAction yolo_room_leave_action = new YoloRoomOuterClass.YoloRoomLeaveAction();
  public YoloRoomOuterClass.YoloRoomModifyInfoAction yolo_room_modify_info_action = new YoloRoomOuterClass.YoloRoomModifyInfoAction();
  public YoloRoomOuterClass.YoloRoomReadyStatusChangeAction yolo_room_ready_status_change_action = new YoloRoomOuterClass.YoloRoomReadyStatusChangeAction();
  public YoloRoomOuterClass.YoloRoomSendGiftAction yolo_room_send_gift_action = new YoloRoomOuterClass.YoloRoomSendGiftAction();
  public YoloRoomOuterClass.YoloRoomSpeakingPosChangeAction yolo_room_speaking_pos_change_action = new YoloRoomOuterClass.YoloRoomSpeakingPosChangeAction();
  public YoloRoomOuterClass.YoloRoomSpeakingPosListInitAction yolo_room_speaking_pos_list_init_action = new YoloRoomOuterClass.YoloRoomSpeakingPosListInitAction();
  public YoloRoomOuterClass.YoloRoomSpeakingPosStatusChangeAction yolo_room_speaking_pos_status_change_action = new YoloRoomOuterClass.YoloRoomSpeakingPosStatusChangeAction();
  public YoloRoomOuterClass.YoloRoomSpeakingUserStatusUpdateAction yolo_room_speaking_user_status_update_action = new YoloRoomOuterClass.YoloRoomSpeakingUserStatusUpdateAction();
  public YoloRoomOuterClass.YoloRoomStartGameAction yolo_room_start_game_action = new YoloRoomOuterClass.YoloRoomStartGameAction();
  public YoloRoomOuterClass.YoloRoomUpdateGameRouteInfoAction yolo_room_update_game_route_info_action = new YoloRoomOuterClass.YoloRoomUpdateGameRouteInfoAction();
  public YoloRoomOuterClass.YoloRoomUserExpireAction yolo_room_user_expire_action = new YoloRoomOuterClass.YoloRoomUserExpireAction();
  public YoloRoomOuterClass.YoloRoomVoiceSwitchChangeAction yolo_room_voice_switch_change_action = new YoloRoomOuterClass.YoloRoomVoiceSwitchChangeAction();
  public YoloRoomOuterClass.YoloSmobaRoomBattleResultAction yolo_smoba_room_battle_result_action = new YoloRoomOuterClass.YoloSmobaRoomBattleResultAction();
  public YoloRoomOuterClass.YoloSmobaRoomChangeRoleAction yolo_smoba_room_change_role_action = new YoloRoomOuterClass.YoloSmobaRoomChangeRoleAction();
  public YoloRoomOuterClass.YoloSmobaRoomChooceHeroAction yolo_smoba_room_chooce_hero_action = new YoloRoomOuterClass.YoloSmobaRoomChooceHeroAction();
  public YoloRoomOuterClass.YoloSmobaRoomOwnerChangeAction yolo_smoba_room_owner_change_action = new YoloRoomOuterClass.YoloSmobaRoomOwnerChangeAction();
  public YoloRoomOuterClass.YoloSmobaRoomRemindOwnerStartGameAction yolo_smoba_room_remind_owner_start_game_action = new YoloRoomOuterClass.YoloSmobaRoomRemindOwnerStartGameAction();
  public YoloRoomOuterClass.YoloSmobaRoomRemindUserStartGameAction yolo_smoba_room_remind_user_start_game_action = new YoloRoomOuterClass.YoloSmobaRoomRemindUserStartGameAction();
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 90, 98, 106, 114, 122, 130, 146, 154, 162, 170, 178, 194, 202, 210, 218, 234, 242, 266, 810, 818, 826, 842, 858, 866, 874, 882, 1610, 1626, 1634, 1658, 2010, 2018, 2082 }, new String[] { "action_id", "action_time", "action_type", "client_seq_id", "yolo_room_speaking_pos_change_action", "yolo_room_ready_status_change_action", "yolo_room_voice_switch_change_action", "yolo_room_modify_info_action", "yolo_room_speaking_pos_status_change_action", "yolo_room_greet_user_action", "yolo_room_kick_out_speaking_action", "yolo_room_kick_out_room_action", "yolo_room_start_game_action", "yolo_room_join_game_action", "yolo_room_double_check_action", "yolo_room_invited_speaking_action", "yolo_room_apply_speaking_action", "yolo_room_agree_speaking_action", "yolo_room_speaking_user_status_update_action", "yolo_room_forbidden_speech_action", "yolo_room_black_list_change_action", "yolo_room_admin_list_change_action", "yolo_room_enter_action", "yolo_room_leave_action", "yolo_room_send_gift_action", "yolo_room_speaking_pos_list_init_action", "yolo_room_close_game_action", "yolo_room_update_game_route_info_action", "yolo_room_game_result_like_action", "yolo_room_user_expire_action", "yolo_smoba_room_chooce_hero_action", "yolo_smoba_room_remind_owner_start_game_action", "yolo_smoba_room_remind_user_start_game_action", "yolo_smoba_room_change_role_action", "yolo_smoba_room_owner_change_action", "yolo_smoba_room_battle_result_action", "yolo_battle_ob_status_change_action" }, new Object[] { localLong, localLong, Integer.valueOf(11), localLong, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, YoloRoomAction.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomAction
 * JD-Core Version:    0.7.0.1
 */