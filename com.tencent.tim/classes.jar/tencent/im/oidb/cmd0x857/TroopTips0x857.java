package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.apollo_game_status.STCMGameMessage;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;

public final class TroopTips0x857
{
  public static final class AIOGrayTipsInfo
    extends MessageMicro<AIOGrayTipsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_brief = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField opt_bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field opt_uint32_remind = PBField.initUInt32(0);
    public final PBUInt32Field opt_uint32_show_lastest = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reliao_admin_opt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_robot_group_opt = PBField.initUInt32(0);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 56 }, new String[] { "opt_uint32_show_lastest", "opt_bytes_content", "opt_uint32_remind", "opt_bytes_brief", "uint64_receiver_uin", "uint32_reliao_admin_opt", "uint32_robot_group_opt" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, AIOGrayTipsInfo.class);
    }
  }
  
  public static final class AIOTopTipsInfo
    extends MessageMicro<AIOTopTipsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField opt_bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField opt_bytes_data_a = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField opt_bytes_data_i = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField opt_bytes_data_p = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField opt_bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField opt_enum_action = PBField.initEnum(1);
    public final PBUInt32Field opt_uint32_icon = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "opt_bytes_content", "opt_uint32_icon", "opt_enum_action", "opt_bytes_url", "opt_bytes_data", "opt_bytes_data_i", "opt_bytes_data_a", "opt_bytes_data_p" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, AIOTopTipsInfo.class);
    }
  }
  
  public static final class FloatedTipsInfo
    extends MessageMicro<FloatedTipsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "opt_bytes_content" }, new Object[] { localByteStringMicro }, FloatedTipsInfo.class);
    }
  }
  
  public static final class GeneralGrayTipInfo
    extends MessageMicro<GeneralGrayTipInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pb_reserv = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<TroopTips0x857.TemplParam> rpt_msg_templ_param = PBField.initRepeatMessage(TroopTips0x857.TemplParam.class);
    public final PBUInt32Field uint32_c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ctrl_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_busi_type = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_templ_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_tips_seq_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 80, 802 }, new String[] { "uint64_busi_type", "uint64_busi_id", "uint32_ctrl_flag", "uint32_c2c_type", "uint32_service_type", "uint64_templ_id", "rpt_msg_templ_param", "bytes_content", "uint64_tips_seq_id", "bytes_pb_reserv" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, GeneralGrayTipInfo.class);
    }
  }
  
  public static final class GoldMsgTipsElem
    extends MessageMicro<GoldMsgTipsElem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "type", "billno", "result", "amount", "total", "interval", "finish", "uin", "action" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GoldMsgTipsElem.class);
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBUInt32Field amount = PBField.initUInt32(0);
    public final PBStringField billno = PBField.initString("");
    public final PBUInt32Field finish = PBField.initUInt32(0);
    public final PBUInt32Field interval = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatField<Long> uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class GrayData
    extends MessageMicro<GrayData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "all_read", "feed_id" }, new Object[] { Integer.valueOf(0), "" }, GrayData.class);
    public final PBUInt32Field all_read = PBField.initUInt32(0);
    public final PBStringField feed_id = PBField.initString("");
  }
  
  public static final class GroupAnnounceTBCInfo
    extends MessageMicro<GroupAnnounceTBCInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "feeds_id", "group_id", "action" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, GroupAnnounceTBCInfo.class);
    }
  }
  
  public static final class GroupInfoChange
    extends MessageMicro<GroupInfoChange>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_group_honor_switch" }, new Object[] { Integer.valueOf(0) }, GroupInfoChange.class);
    public final PBUInt32Field uint32_group_honor_switch = PBField.initUInt32(0);
  }
  
  public static final class GroupNotifyInfo
    extends MessageMicro<GroupNotifyInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field opt_uint32_auto_pull_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint32_auto_pull_flag", "opt_bytes_feeds_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GroupNotifyInfo.class);
    }
  }
  
  public static final class InstCtrl
    extends MessageMicro<InstCtrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_msg_send_to_inst", "rpt_msg_exclude_inst", "msg_from_inst" }, new Object[] { null, null, null }, InstCtrl.class);
    public TroopTips0x857.InstInfo msg_from_inst = new TroopTips0x857.InstInfo();
    public final PBRepeatMessageField<TroopTips0x857.InstInfo> rpt_msg_exclude_inst = PBField.initRepeatMessage(TroopTips0x857.InstInfo.class);
    public final PBRepeatMessageField<TroopTips0x857.InstInfo> rpt_msg_send_to_inst = PBField.initRepeatMessage(TroopTips0x857.InstInfo.class);
  }
  
  public static final class InstInfo
    extends MessageMicro<InstInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_apppid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_open_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
    public final PBUInt32Field uint32_productid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sso_bid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ver_max = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ver_min = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 72 }, new String[] { "uint32_apppid", "uint32_instid", "uint32_platform", "uint32_open_appid", "uint32_productid", "uint32_sso_bid", "bytes_guid", "uint32_ver_min", "uint32_ver_max" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, InstInfo.class);
    }
  }
  
  public static final class LbsShareChangePushInfo
    extends MessageMicro<LbsShareChangePushInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gray_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_version_ctrl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_join_nums = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_push_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_oper_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64, 792, 802 }, new String[] { "uint32_msg_type", "bytes_msg_info", "bytes_version_ctrl", "uint64_group_id", "uint64_oper_uin", "bytes_gray_tips", "uint64_msg_seq", "uint32_join_nums", "uint32_push_type", "bytes_ext_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, LbsShareChangePushInfo.class);
    }
  }
  
  public static final class LuckyBagNotify
    extends MessageMicro<LuckyBagNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_msg_tips" }, new Object[] { localByteStringMicro }, LuckyBagNotify.class);
    }
  }
  
  public static final class MediaChangePushInfo
    extends MessageMicro<MediaChangePushInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gray_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_version_ctrl = PBField.initBytes(ByteStringMicro.EMPTY);
    public PersonalSetting msg_per_setting = new PersonalSetting();
    public final PBUInt32Field uint32_join_nums = PBField.initUInt32(0);
    public final PBUInt32Field uint32_media_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_play_mode = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_oper_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64, 74, 80, 792, 802 }, new String[] { "uint32_msg_type", "bytes_msg_info", "bytes_version_ctrl", "uint64_group_id", "uint64_oper_uin", "bytes_gray_tips", "uint64_msg_seq", "uint32_join_nums", "msg_per_setting", "uint32_play_mode", "uint32_media_type", "bytes_ext_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, MediaChangePushInfo.class);
    }
    
    public static final class PersonalSetting
      extends MessageMicro<PersonalSetting>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_theme_id", "uint32_player_id", "uint32_font_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PersonalSetting.class);
      public final PBUInt32Field uint32_font_id = PBField.initUInt32(0);
      public final PBUInt32Field uint32_player_id = PBField.initUInt32(0);
      public final PBUInt32Field uint32_theme_id = PBField.initUInt32(0);
    }
  }
  
  public static final class MessageBoxInfo
    extends MessageMicro<MessageBoxInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_button = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField opt_bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField opt_bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "opt_bytes_content", "opt_bytes_title", "opt_bytes_button" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, MessageBoxInfo.class);
    }
  }
  
  public static final class MessageRecallReminder
    extends MessageMicro<MessageRecallReminder>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField str_reminder_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<MessageMeta> uint32_recalled_msg_list = PBField.initRepeatMessage(MessageMeta.class);
    public final PBUInt64Field uint64_admin_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64 }, new String[] { "uint64_uin", "bytes_nickname", "uint32_recalled_msg_list", "str_reminder_content", "bytes_userdef", "uint32_group_type", "uint32_op_type", "uint64_admin_uin" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, MessageRecallReminder.class);
    }
    
    public static final class MessageMeta
      extends MessageMicro<MessageMeta>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uint32_seq", "uint32_time", "uint32_msg_random", "uint32_msg_type", "uint32_msg_flag", "uint64_author_uin", "uint32_is_anony_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, MessageMeta.class);
      public final PBUInt32Field uint32_is_anony_msg = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_flag = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
      public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
      public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
      public final PBUInt32Field uint32_time = PBField.initUInt32(0);
      public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    }
  }
  
  public static final class MiniAppNotify
    extends MessageMicro<MiniAppNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_msg" }, new Object[] { localByteStringMicro }, MiniAppNotify.class);
    }
  }
  
  public static final class NotifyMsgBody
    extends MessageMicro<NotifyMsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82, 90, 98, 104, 114, 122, 130, 138, 146, 162, 168, 178, 186, 194, 210, 218, 226, 234, 242, 250 }, new String[] { "opt_enum_type", "opt_uint64_msg_time", "opt_uint64_msg_expires", "opt_uint64_group_code", "opt_msg_graytips", "opt_msg_messagebox", "opt_msg_floatedtips", "opt_msg_toptips", "opt_msg_redtips", "opt_msg_group_notify", "opt_msg_recall", "opt_msg_theme_notify", "uint32_service_type", "opt_msg_objmsg_update", "opt_msg_werewolf_push", "opt_stcm_game_state", "apllo_msg_push", "opt_msg_goldtips", "opt_msg_miniapp_notify", "opt_uint64_sender_uin", "opt_msg_luckybag_notify", "opt_msg_troopformtips_push", "opt_msg_media_push", "opt_general_gray_tip", "opt_msg_video_push", "opt_lbs_share_change_plus_info", "opt_msg_sing_push", "opt_msg_group_info_change", "opt_group_announce_tbc_info" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, null, null, null, null, Integer.valueOf(0), null, null, null, null, null, null, Long.valueOf(0L), null, null, null, null, null, null, null, null, null }, NotifyMsgBody.class);
    public apollo_push_msgInfo.STPushMsgElem apllo_msg_push = new apollo_push_msgInfo.STPushMsgElem();
    public final PBEnumField opt_enum_type = PBField.initEnum(1);
    public TroopTips0x857.GeneralGrayTipInfo opt_general_gray_tip = new TroopTips0x857.GeneralGrayTipInfo();
    public TroopTips0x857.GroupAnnounceTBCInfo opt_group_announce_tbc_info = new TroopTips0x857.GroupAnnounceTBCInfo();
    public TroopTips0x857.LbsShareChangePushInfo opt_lbs_share_change_plus_info = new TroopTips0x857.LbsShareChangePushInfo();
    public TroopTips0x857.FloatedTipsInfo opt_msg_floatedtips = new TroopTips0x857.FloatedTipsInfo();
    public TroopTips0x857.GoldMsgTipsElem opt_msg_goldtips = new TroopTips0x857.GoldMsgTipsElem();
    public TroopTips0x857.AIOGrayTipsInfo opt_msg_graytips = new TroopTips0x857.AIOGrayTipsInfo();
    public TroopTips0x857.GroupInfoChange opt_msg_group_info_change = new TroopTips0x857.GroupInfoChange();
    public TroopTips0x857.GroupNotifyInfo opt_msg_group_notify = new TroopTips0x857.GroupNotifyInfo();
    public TroopTips0x857.LuckyBagNotify opt_msg_luckybag_notify = new TroopTips0x857.LuckyBagNotify();
    public TroopTips0x857.MediaChangePushInfo opt_msg_media_push = new TroopTips0x857.MediaChangePushInfo();
    public TroopTips0x857.MessageBoxInfo opt_msg_messagebox = new TroopTips0x857.MessageBoxInfo();
    public TroopTips0x857.MiniAppNotify opt_msg_miniapp_notify = new TroopTips0x857.MiniAppNotify();
    public TroopTips0x857.NotifyObjmsgUpdate opt_msg_objmsg_update = new TroopTips0x857.NotifyObjmsgUpdate();
    public TroopTips0x857.MessageRecallReminder opt_msg_recall = new TroopTips0x857.MessageRecallReminder();
    public TroopTips0x857.RedGrayTipsInfo opt_msg_redtips = new TroopTips0x857.RedGrayTipsInfo();
    public TroopTips0x857.SingChangePushInfo opt_msg_sing_push = new TroopTips0x857.SingChangePushInfo();
    public TroopTips0x857.ThemeStateNotify opt_msg_theme_notify = new TroopTips0x857.ThemeStateNotify();
    public TroopTips0x857.AIOTopTipsInfo opt_msg_toptips = new TroopTips0x857.AIOTopTipsInfo();
    public TroopTips0x857.TroopFormGrayTipsInfo opt_msg_troopformtips_push = new TroopTips0x857.TroopFormGrayTipsInfo();
    public TroopTips0x857.VideoChangePushInfo opt_msg_video_push = new TroopTips0x857.VideoChangePushInfo();
    public TroopTips0x857.WereWolfPush opt_msg_werewolf_push = new TroopTips0x857.WereWolfPush();
    public apollo_game_status.STCMGameMessage opt_stcm_game_state = new apollo_game_status.STCMGameMessage();
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field opt_uint64_msg_expires = PBField.initUInt64(0L);
    public final PBUInt64Field opt_uint64_msg_time = PBField.initUInt64(0L);
    public final PBUInt64Field opt_uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
  }
  
  public static final class NotifyObjmsgUpdate
    extends MessageMicro<NotifyObjmsgUpdate>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_objmsg_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_update_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_objmsg_id", "uint32_update_type", "bytes_ext_msg" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, NotifyObjmsgUpdate.class);
    }
  }
  
  public static final class RedGrayTipsInfo
    extends MessageMicro<RedGrayTipsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_authkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_broadcast_rich_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_idiom = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_idiom_alpha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jumpurl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pc_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_receiver_rich_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sender_rich_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field opt_uint32_show_lastest = PBField.initUInt32(0);
    public final PBSInt32Field sint32_msgtype = PBField.initSInt32(0);
    public final PBUInt32Field uint32_hide_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_icon = PBField.initUInt32(0);
    public final PBUInt32Field uint32_idiom_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lucky_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_random = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subchannel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_lucky_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 64, 72, 82, 88, 96, 104, 112, 122, 130, 136, 146, 154, 160 }, new String[] { "opt_uint32_show_lastest", "uint64_sender_uin", "uint64_receiver_uin", "bytes_sender_rich_content", "bytes_receiver_rich_content", "bytes_authkey", "sint32_msgtype", "uint32_lucky_flag", "uint32_hide_flag", "bytes_pc_body", "uint32_icon", "uint64_lucky_uin", "uint32_time", "uint32_random", "bytes_broadcast_rich_content", "bytes_idiom", "uint32_idiom_seq", "bytes_idiom_alpha", "bytes_jumpurl", "uint32_subchannel" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0) }, RedGrayTipsInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public TroopTips0x857.InstCtrl msg_inst_ctrl = new TroopTips0x857.InstCtrl();
    public final PBBytesField opt_bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field opt_uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field opt_uint32_offline = PBField.initUInt32(0);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
    public final PBRepeatField<Long> rpt_uint64_memberuins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48 }, new String[] { "opt_uint64_group_code", "rpt_uint64_memberuins", "opt_uint32_offline", "msg_inst_ctrl", "opt_bytes_msg", "opt_uint32_busi_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro, Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "opt_uint64_group_code" }, new Object[] { Long.valueOf(0L) }, RspBody.class);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class SingChangePushInfo
    extends MessageMicro<SingChangePushInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_gray_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_nums = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_oper_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint64_seq", "uint32_action_type", "uint64_group_id", "uint64_oper_uin", "bytes_gray_tips", "uint32_join_nums" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, SingChangePushInfo.class);
    }
  }
  
  public static final class TemplParam
    extends MessageMicro<TemplParam>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_name", "bytes_value" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, TemplParam.class);
    }
  }
  
  public static final class ThemeStateNotify
    extends MessageMicro<ThemeStateNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_theme_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_state = PBField.initUInt32(0);
    public final PBUInt64Field uint64_action_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uint32_state", "bytes_feeds_id", "bytes_theme_name", "uint64_action_uin", "uint64_create_uin" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L) }, ThemeStateNotify.class);
    }
  }
  
  public static final class TroopFormGrayTipsInfo
    extends MessageMicro<TroopFormGrayTipsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_creator_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_opt_bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rich_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_creator_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_writer_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint64_writer_uin", "uint64_creator_uin", "bytes_rich_content", "bytes_opt_bytes_url", "bytes_creator_nick" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, TroopFormGrayTipsInfo.class);
    }
  }
  
  public static final class VideoChangePushInfo
    extends MessageMicro<VideoChangePushInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gray_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_nums = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_oper_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 802 }, new String[] { "uint64_seq", "uint32_action_type", "uint64_group_id", "uint64_oper_uin", "bytes_gray_tips", "uint32_join_nums", "bytes_ext_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, VideoChangePushInfo.class);
    }
  }
  
  public static final class WereWolfPush
    extends MessageMicro<WereWolfPush>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_judge_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_judge_words = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field enum_game_state = PBField.initUInt32(0);
    public final PBUInt32Field enum_operation = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_dead_users = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<Role> rpt_roles = PBField.initRepeatMessage(Role.class);
    public final PBRepeatField<Long> rpt_voted_tie_users = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_game_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_game_round = PBField.initUInt32(0);
    public final PBUInt32Field uint32_kill_confirmed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_push_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timeout_sec = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_user = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_game_room = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_judge_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_speaker = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_src_user = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66, 72, 80, 88, 96, 104, 112, 120, 130, 136 }, new String[] { "uint32_push_type", "uint64_game_room", "enum_game_state", "uint32_game_round", "rpt_roles", "uint64_speaker", "uint64_judge_uin", "bytes_judge_words", "enum_operation", "uint64_src_user", "uint64_dst_user", "rpt_dead_users", "uint32_game_result", "uint32_timeout_sec", "uint32_kill_confirmed", "bytes_judge_nickname", "rpt_voted_tie_users" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L) }, WereWolfPush.class);
    }
    
    public static final class GameRecord
      extends MessageMicro<GameRecord>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_total", "uint32_win", "uint32_lose", "uint32_draw" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GameRecord.class);
      public final PBUInt32Field uint32_draw = PBField.initUInt32(0);
      public final PBUInt32Field uint32_lose = PBField.initUInt32(0);
      public final PBUInt32Field uint32_total = PBField.initUInt32(0);
      public final PBUInt32Field uint32_win = PBField.initUInt32(0);
    }
    
    public static final class Role
      extends MessageMicro<Role>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 138, 144, 152, 160 }, new String[] { "uint64_uin", "enum_type", "enum_state", "uint32_can_speak", "uint32_can_listen", "uint32_position", "uint32_can_vote", "uint32_can_voted", "uint32_already_checked", "uint32_already_saved", "uint32_already_poisoned", "uint32_player_state", "enum_dead_op", "enum_operation", "uint64_dst_user", "uint32_operation_round", "msg_game_record", "uint32_is_werewolf", "uint64_defended_user", "uint32_is_sheriff" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, Role.class);
      public final PBUInt32Field enum_dead_op = PBField.initUInt32(0);
      public final PBUInt32Field enum_operation = PBField.initUInt32(0);
      public final PBUInt32Field enum_state = PBField.initUInt32(0);
      public final PBUInt32Field enum_type = PBField.initUInt32(0);
      public TroopTips0x857.WereWolfPush.GameRecord msg_game_record = new TroopTips0x857.WereWolfPush.GameRecord();
      public final PBUInt32Field uint32_already_checked = PBField.initUInt32(0);
      public final PBUInt32Field uint32_already_poisoned = PBField.initUInt32(0);
      public final PBUInt32Field uint32_already_saved = PBField.initUInt32(0);
      public final PBUInt32Field uint32_can_listen = PBField.initUInt32(0);
      public final PBUInt32Field uint32_can_speak = PBField.initUInt32(0);
      public final PBUInt32Field uint32_can_vote = PBField.initUInt32(0);
      public final PBUInt32Field uint32_can_voted = PBField.initUInt32(0);
      public final PBUInt32Field uint32_is_sheriff = PBField.initUInt32(0);
      public final PBUInt32Field uint32_is_werewolf = PBField.initUInt32(0);
      public final PBUInt32Field uint32_operation_round = PBField.initUInt32(0);
      public final PBUInt32Field uint32_player_state = PBField.initUInt32(0);
      public final PBUInt32Field uint32_position = PBField.initUInt32(0);
      public final PBUInt64Field uint64_defended_user = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_dst_user = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857
 * JD-Core Version:    0.7.0.1
 */