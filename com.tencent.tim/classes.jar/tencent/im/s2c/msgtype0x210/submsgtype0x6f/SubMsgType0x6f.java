package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f
{
  public static final class AddFriendSource
    extends MessageMicro<AddFriendSource>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source", "uint32_sub_source" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AddFriendSource.class);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source = PBField.initUInt32(0);
  }
  
  public static final class AddQimFriendNotifyToQQ
    extends MessageMicro<AddQimFriendNotifyToQQ>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_longnick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_smart_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cares_count = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_fans_count = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_storys_total_num = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 74, 82 }, new String[] { "uint32_op_type", "uint64_uin", "uint32_gender", "bytes_smart_remark", "bytes_longnick", "uint64_storys_total_num", "uint64_cares_count", "uint64_fans_count", "bytes_wording", "bytes_src_wording" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4 }, AddQimFriendNotifyToQQ.class);
    }
  }
  
  public static final class AddQimNotLoginFrdNotifyToQQ
    extends MessageMicro<AddQimNotLoginFrdNotifyToQQ>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_coverstory = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<SubMsgType0x6f.VideoInfo> rpt_msg_video_info = PBField.initRepeatMessage(SubMsgType0x6f.VideoInfo.class);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_storys_total_num = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 58, 66, 72 }, new String[] { "uint64_uin", "bytes_nick", "uint32_gender", "uint32_age", "bytes_coverstory", "uint64_storys_total_num", "rpt_msg_video_info", "bytes_wording", "uint64_qq_uin" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), null, localByteStringMicro3, Long.valueOf(0L) }, AddQimNotLoginFrdNotifyToQQ.class);
    }
  }
  
  public static final class BirthdayReminderPush
    extends MessageMicro<BirthdayReminderPush>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reminder_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16034 }, new String[] { "bytes_reminder_wording" }, new Object[] { localByteStringMicro }, BirthdayReminderPush.class);
    }
  }
  
  public static final class FanpaiziNotify
    extends MessageMicro<FanpaiziNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tips_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_from_nick = PBField.initString("");
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_from_uin", "str_from_nick", "bytes_tips_content", "bytes_sig" }, new Object[] { Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2 }, FanpaiziNotify.class);
    }
  }
  
  public static final class ForwardBody
    extends MessageMicro<ForwardBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 16002, 16010, 16018, 16026, 16034, 16042, 16058, 16066, 16074, 16082, 16090 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_fanpanzi_notify", "msg_mcard_notification_like", "msg_vip_info_notify", "msg_push_lost_dev_found", "msg_birthday_reminder_push", "msg_push_lost_dev", "msg_babyq_reward_info", "msg_hot_friend_notify", "msg_push_qim_recommend", "msg_mod_qim_friend", "msg_mod_qim_friend_to_qq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null }, ForwardBody.class);
    public SubMsgType0x6f.RewardInfo msg_babyq_reward_info = new SubMsgType0x6f.RewardInfo();
    public SubMsgType0x6f.BirthdayReminderPush msg_birthday_reminder_push = new SubMsgType0x6f.BirthdayReminderPush();
    public SubMsgType0x6f.FanpaiziNotify msg_fanpanzi_notify = new SubMsgType0x6f.FanpaiziNotify();
    public SubMsgType0x6f.HotFriendNotify msg_hot_friend_notify = new SubMsgType0x6f.HotFriendNotify();
    public SubMsgType0x6f.MCardNotificationLike msg_mcard_notification_like = new SubMsgType0x6f.MCardNotificationLike();
    public SubMsgType0x6f.QimFriendNotify msg_mod_qim_friend = new SubMsgType0x6f.QimFriendNotify();
    public SubMsgType0x6f.QimFriendNotifyToQQ msg_mod_qim_friend_to_qq = new SubMsgType0x6f.QimFriendNotifyToQQ();
    public SubMsgType0x6f.PushLostDevFound msg_push_lost_dev = new SubMsgType0x6f.PushLostDevFound();
    public SubMsgType0x6f.PushLostDevFound msg_push_lost_dev_found = new SubMsgType0x6f.PushLostDevFound();
    public SubMsgType0x6f.QimRecomendMsg msg_push_qim_recommend = new SubMsgType0x6f.QimRecomendMsg();
    public SubMsgType0x6f.VipInfoNotify msg_vip_info_notify = new SubMsgType0x6f.VipInfoNotify();
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  }
  
  public static final class GPS
    extends MessageMicro<GPS>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_lat", "int32_lon", "int32_alt", "int32_type" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(-10000000), Integer.valueOf(0) }, GPS.class);
    public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBInt32Field int32_type = PBField.initInt32(0);
  }
  
  public static final class HotFriendNotify
    extends MessageMicro<HotFriendNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104 }, new String[] { "uint64_dst_uin", "uint32_praise_hot_level", "uint32_chat_hot_level", "uint32_praise_hot_days", "uint32_chat_hot_days", "uint32_close_level", "uint32_close_days", "uint32_praise_flag", "uint32_chat_flag", "uint32_close_flag", "uint64_notify_time", "uint64_last_praise_time", "uint64_last_chat_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, HotFriendNotify.class);
    public final PBUInt32Field uint32_chat_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_hot_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_hot_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_close_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_close_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_hot_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_hot_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_chat_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_praise_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_notify_time = PBField.initUInt64(0L);
  }
  
  public static final class MCardNotificationLike
    extends MessageMicro<MCardNotificationLike>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_from_uin", "uint32_counter_total", "uint32_counter_new", "str_wording" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, MCardNotificationLike.class);
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field uint32_counter_new = PBField.initUInt32(0);
    public final PBUInt32Field uint32_counter_total = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_mod_infos" }, new Object[] { null }, MsgBody.class);
    public final PBRepeatMessageField<SubMsgType0x6f.ForwardBody> rpt_msg_mod_infos = PBField.initRepeatMessage(SubMsgType0x6f.ForwardBody.class);
  }
  
  public static final class PushLostDevFound
    extends MessageMicro<PushLostDevFound>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 48 }, new String[] { "uint32_msg_type", "uint32_dev_time", "uint64_din" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, PushLostDevFound.class);
    public final PBUInt32Field uint32_dev_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
  }
  
  public static final class QimFriendNotify
    extends MessageMicro<QimFriendNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_mobiles = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fans_total_count = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_fans_unread_count = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_push_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint32_op_type", "rpt_uint64_uins", "uint64_fans_unread_count", "uint64_fans_total_count", "uint64_push_time", "rpt_bytes_mobiles" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, QimFriendNotify.class);
    }
  }
  
  public static final class QimFriendNotifyToQQ
    extends MessageMicro<QimFriendNotifyToQQ>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_notify_type", "msg_add_notify_to_qq", "msg_upgrade_notify", "msg_add_not_login_frd_notify_to_qq" }, new Object[] { Integer.valueOf(0), null, null, null }, QimFriendNotifyToQQ.class);
    public SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ msg_add_not_login_frd_notify_to_qq = new SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ();
    public SubMsgType0x6f.AddQimFriendNotifyToQQ msg_add_notify_to_qq = new SubMsgType0x6f.AddQimFriendNotifyToQQ();
    public SubMsgType0x6f.UpgradeQimFriendNotify msg_upgrade_notify = new SubMsgType0x6f.UpgradeQimFriendNotify();
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  }
  
  public static final class QimRecomendInfo
    extends MessageMicro<QimRecomendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_alghbuff = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_longnick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_source_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0x6f.AddFriendSource msg_android_source = new SubMsgType0x6f.AddFriendSource();
    public SubMsgType0x6f.AddFriendSource msg_ios_source = new SubMsgType0x6f.AddFriendSource();
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 64, 74, 82, 90 }, new String[] { "uint64_uin", "bytes_name", "bytes_reason", "uint32_gender", "bytes_longnick", "bytes_alghbuff", "uint32_age", "uint32_source", "bytes_source_reason", "msg_ios_source", "msg_android_source" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, null, null }, QimRecomendInfo.class);
    }
  }
  
  public static final class QimRecomendMsg
    extends MessageMicro<QimRecomendMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_msg_recomend_list", "uint64_timestamp" }, new Object[] { null, Long.valueOf(0L) }, QimRecomendMsg.class);
    public final PBRepeatMessageField<SubMsgType0x6f.QimRecomendInfo> rpt_msg_recomend_list = PBField.initRepeatMessage(SubMsgType0x6f.QimRecomendInfo.class);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  }
  
  public static final class RewardInfo
    extends MessageMicro<RewardInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jmp_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_opt_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_opt_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_toast_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_report_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_face_addon_id = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 74, 82, 88 }, new String[] { "uint32_type", "bytes_name", "bytes_jmp_url", "bytes_cookies", "bytes_jmp_wording", "bytes_opt_wording", "bytes_opt_url", "uint64_face_addon_id", "bytes_icon_url", "bytes_toast_wording", "uint32_report_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0) }, RewardInfo.class);
    }
  }
  
  public static final class UpgradeQimFriendNotify
    extends MessageMicro<UpgradeQimFriendNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "bytes_wording" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, UpgradeQimFriendNotify.class);
    }
  }
  
  public static final class VideoInfo
    extends MessageMicro<VideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_vid", "bytes_video_cover_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, VideoInfo.class);
    }
  }
  
  public static final class VipInfoNotify
    extends MessageMicro<VipInfoNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 74 }, new String[] { "uint64_uin", "uint32_vip_level", "uint32_vip_identify", "uint32_ext", "str_ext", "uint32_red_flag", "uint32_disable_red_envelope", "uint32_redpack_id", "str_redpack_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, VipInfoNotify.class);
    public final PBStringField str_ext = PBField.initString("");
    public final PBStringField str_redpack_name = PBField.initString("");
    public final PBUInt32Field uint32_disable_red_envelope = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ext = PBField.initUInt32(0);
    public final PBUInt32Field uint32_red_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_redpack_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vip_identify = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vip_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f
 * JD-Core Version:    0.7.0.1
 */