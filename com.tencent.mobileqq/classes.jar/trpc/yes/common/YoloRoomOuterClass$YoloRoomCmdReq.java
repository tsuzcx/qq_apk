package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloRoomOuterClass$YoloRoomCmdReq
  extends MessageMicro<YoloRoomCmdReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 194, 202, 210, 218, 234, 242, 258, 266, 826, 834, 874, 1610, 1626, 1658, 1842, 1850, 2410, 2418, 2426, 2434, 2442 }, new String[] { "yolo_room_speaking_pos_change_cmd", "yolo_room_ready_status_change_cmd", "yolo_room_voice_switch_change_cmd", "yolo_room_modify_info_cmd", "yolo_room_speaking_pos_status_change_cmd", "yolo_room_greet_user_cmd", "yolo_room_complaint_user_cmd", "yolo_room_kick_out_speaking_cmd", "yolo_room_kick_out_room_cmd", "yolo_room_start_game_cmd", "yolo_room_join_game_cmd", "yolo_room_double_check_cmd", "yolo_room_stay_in_room_cmd", "yolo_room_invited_speaking_cmd", "yolo_room_apply_speaking_cmd", "yolo_room_agree_speaking_cmd", "yolo_room_speaking_user_update_cmd", "yolo_room_forbidden_speech_cmd", "yolo_room_black_list_change_cmd", "yolo_room_sound_switch_change_cmd", "yolo_room_admin_list_change_cmd", "yolo_room_send_gift_cmd", "yolo_room_like_cmd", "yolo_room_battle_result_cmd", "yolo_smoba_room_chooce_hero", "yolo_smoba_room_remind_start_game_cmd", "yolo_smoba_room_change_role_cmd", "yolo_start_battle_ob_cmd", "yolo_close_battle_ob_cmd", "yolo_live_room_start_live_cmd", "yolo_live_room_close_live_cmd", "yolo_live_room_pause_live_cmd", "yolo_live_room_restart_live_cmd", "yolo_live_room_extend_live_cmd" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, YoloRoomCmdReq.class);
  public YoloRoomOuterClass.YoloCloseBattleOBCmd yolo_close_battle_ob_cmd = new YoloRoomOuterClass.YoloCloseBattleOBCmd();
  public YoloRoomOuterClass.YoloLiveRoomCloseLiveCmd yolo_live_room_close_live_cmd = new YoloRoomOuterClass.YoloLiveRoomCloseLiveCmd();
  public YoloRoomOuterClass.YoloLiveRoomExtendLiveCmd yolo_live_room_extend_live_cmd = new YoloRoomOuterClass.YoloLiveRoomExtendLiveCmd();
  public YoloRoomOuterClass.YoloLiveRoomPauseLiveCmd yolo_live_room_pause_live_cmd = new YoloRoomOuterClass.YoloLiveRoomPauseLiveCmd();
  public YoloRoomOuterClass.YoloLiveRoomRestartLiveCmd yolo_live_room_restart_live_cmd = new YoloRoomOuterClass.YoloLiveRoomRestartLiveCmd();
  public YoloRoomOuterClass.YoloLiveRoomStartLiveCmd yolo_live_room_start_live_cmd = new YoloRoomOuterClass.YoloLiveRoomStartLiveCmd();
  public YoloRoomOuterClass.YoloRoomAdminListChangeCmd yolo_room_admin_list_change_cmd = new YoloRoomOuterClass.YoloRoomAdminListChangeCmd();
  public YoloRoomOuterClass.YoloRoomAgreeSpeakingCmd yolo_room_agree_speaking_cmd = new YoloRoomOuterClass.YoloRoomAgreeSpeakingCmd();
  public YoloRoomOuterClass.YoloRoomApplySpeakingCmd yolo_room_apply_speaking_cmd = new YoloRoomOuterClass.YoloRoomApplySpeakingCmd();
  public YoloRoomOuterClass.YoloRoomBattleResultCmd yolo_room_battle_result_cmd = new YoloRoomOuterClass.YoloRoomBattleResultCmd();
  public YoloRoomOuterClass.YoloRoomBlackListChangeCmd yolo_room_black_list_change_cmd = new YoloRoomOuterClass.YoloRoomBlackListChangeCmd();
  public YoloRoomOuterClass.YoloRoomComplaintUserCmd yolo_room_complaint_user_cmd = new YoloRoomOuterClass.YoloRoomComplaintUserCmd();
  public YoloRoomOuterClass.YoloRoomDoubleCheckCmd yolo_room_double_check_cmd = new YoloRoomOuterClass.YoloRoomDoubleCheckCmd();
  public YoloRoomOuterClass.YoloRoomForbiddenSpeechCmd yolo_room_forbidden_speech_cmd = new YoloRoomOuterClass.YoloRoomForbiddenSpeechCmd();
  public YoloRoomOuterClass.YoloRoomGreetUserCmd yolo_room_greet_user_cmd = new YoloRoomOuterClass.YoloRoomGreetUserCmd();
  public YoloRoomOuterClass.YoloRoomInvitedSpeakingCmd yolo_room_invited_speaking_cmd = new YoloRoomOuterClass.YoloRoomInvitedSpeakingCmd();
  public YoloRoomOuterClass.YoloRoomJoinGameCmd yolo_room_join_game_cmd = new YoloRoomOuterClass.YoloRoomJoinGameCmd();
  public YoloRoomOuterClass.YoloRoomKickOutRoomCmd yolo_room_kick_out_room_cmd = new YoloRoomOuterClass.YoloRoomKickOutRoomCmd();
  public YoloRoomOuterClass.YoloRoomKickOutSpeakingCmd yolo_room_kick_out_speaking_cmd = new YoloRoomOuterClass.YoloRoomKickOutSpeakingCmd();
  public YoloRoomOuterClass.YoloRoomGameResultLikeCmd yolo_room_like_cmd = new YoloRoomOuterClass.YoloRoomGameResultLikeCmd();
  public YoloRoomOuterClass.YoloRoomModifyInfoCmd yolo_room_modify_info_cmd = new YoloRoomOuterClass.YoloRoomModifyInfoCmd();
  public YoloRoomOuterClass.YoloRoomReadyStatusChangeCmd yolo_room_ready_status_change_cmd = new YoloRoomOuterClass.YoloRoomReadyStatusChangeCmd();
  public YoloRoomOuterClass.YoloRoomSendGiftCmd yolo_room_send_gift_cmd = new YoloRoomOuterClass.YoloRoomSendGiftCmd();
  public YoloRoomOuterClass.YoloRoomSoundSwitchChangeCmd yolo_room_sound_switch_change_cmd = new YoloRoomOuterClass.YoloRoomSoundSwitchChangeCmd();
  public YoloRoomOuterClass.YoloRoomSpeakingPosChangeCmd yolo_room_speaking_pos_change_cmd = new YoloRoomOuterClass.YoloRoomSpeakingPosChangeCmd();
  public YoloRoomOuterClass.YoloRoomSpeakingPosStatusChangeCmd yolo_room_speaking_pos_status_change_cmd = new YoloRoomOuterClass.YoloRoomSpeakingPosStatusChangeCmd();
  public YoloRoomOuterClass.YoloRoomSpeakingUserUpdateCmd yolo_room_speaking_user_update_cmd = new YoloRoomOuterClass.YoloRoomSpeakingUserUpdateCmd();
  public YoloRoomOuterClass.YoloRoomStartGameCmd yolo_room_start_game_cmd = new YoloRoomOuterClass.YoloRoomStartGameCmd();
  public YoloRoomOuterClass.YoloRoomStayInRoomCmd yolo_room_stay_in_room_cmd = new YoloRoomOuterClass.YoloRoomStayInRoomCmd();
  public YoloRoomOuterClass.YoloRoomVoiceSwitchChangeCmd yolo_room_voice_switch_change_cmd = new YoloRoomOuterClass.YoloRoomVoiceSwitchChangeCmd();
  public YoloRoomOuterClass.YoloSmobaRoomChangeRoleCmd yolo_smoba_room_change_role_cmd = new YoloRoomOuterClass.YoloSmobaRoomChangeRoleCmd();
  public YoloRoomOuterClass.YoloSmobaRoomChooceHeroCmd yolo_smoba_room_chooce_hero = new YoloRoomOuterClass.YoloSmobaRoomChooceHeroCmd();
  public YoloRoomOuterClass.YoloSmobaRoomRemindStartGameCmd yolo_smoba_room_remind_start_game_cmd = new YoloRoomOuterClass.YoloSmobaRoomRemindStartGameCmd();
  public YoloRoomOuterClass.YoloStartBattleOBCmd yolo_start_battle_ob_cmd = new YoloRoomOuterClass.YoloStartBattleOBCmd();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdReq
 * JD-Core Version:    0.7.0.1
 */