package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x26
{
  public static final class AppID
    extends MessageMicro<AppID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_app_id" }, new Object[] { Long.valueOf(0L) }, AppID.class);
    public final PBUInt64Field uint64_app_id = PBField.initUInt64(0L);
  }
  
  public static final class AppNotifyContent
    extends MessageMicro<AppNotifyContent>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field game_id = PBField.initUInt32(0);
    public final PBUInt32Field live_extra_mode = PBField.initUInt32(0);
    public final PBRepeatMessageField<submsgtype0x26.AppNotifyUser> opt_msg_app_notify_user = PBField.initRepeatMessage(submsgtype0x26.AppNotifyUser.class);
    public final PBUInt32Field room_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_ts = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56 }, new String[] { "bytes_text", "opt_msg_app_notify_user", "uint32_online_count", "uint32_expire_ts", "room_mode", "live_extra_mode", "game_id" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AppNotifyContent.class);
    }
  }
  
  public static final class AppNotifyUser
    extends MessageMicro<AppNotifyUser>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint64_uin", "opt_uint32_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, AppNotifyUser.class);
    public final PBUInt32Field opt_uint32_flag = PBField.initUInt32(0);
    public final PBUInt64Field opt_uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class AppTip
    extends MessageMicro<AppTip>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tooltip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_icon_time_stamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reportid_click = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reportid_show = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tip_info_seq = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "uint32_tip_info_seq", "bytes_icon", "uint32_icon_time_stamp", "bytes_tooltip", "uint32_reportid_click", "uint32_reportid_show" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, AppTip.class);
    }
  }
  
  public static final class AppTipNotify
    extends MessageMicro<AppTipNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public submsgtype0x26.AppTip msg_app_tip = new submsgtype0x26.AppTip();
    public submsgtype0x26.AppNotifyContent opt_msg_app_notify_content = new submsgtype0x26.AppNotifyContent();
    public final PBUInt32Field uint32_action = PBField.initUInt32(0);
    public final PBUInt32Field uint32_needed_tip_info_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_notify_seq = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "msg_app_tip", "uint32_action", "bytes_text", "uint32_notify_seq", "uint32_needed_tip_info_seq", "opt_msg_app_notify_content" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, AppTipNotify.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_sub_cmd", "rpt_msg_subcmd_0x1_push_body", "msg_subcmd_0x2_push_body", "msg_subcmd_0x3_push_body", "msg_subcmd_0x4_push_body" }, new Object[] { Integer.valueOf(0), null, null, null, null }, MsgBody.class);
    public SubCmd0x2UpdateAppList msg_subcmd_0x2_push_body = new SubCmd0x2UpdateAppList();
    public SubCmd0x3UpdateDiscussAppInfo msg_subcmd_0x3_push_body = new SubCmd0x3UpdateDiscussAppInfo();
    public SubCmd0x4UpdateApp msg_subcmd_0x4_push_body = new SubCmd0x4UpdateApp();
    public final PBRepeatMessageField<SubCmd0x1UpdateAppUnreadNum> rpt_msg_subcmd_0x1_push_body = PBField.initRepeatMessage(SubCmd0x1UpdateAppUnreadNum.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    
    public static final class SubCmd0x1UpdateAppUnreadNum
      extends MessageMicro<SubCmd0x1UpdateAppUnreadNum>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "msg_app_id", "uint64_group_code", "sint32_unread_num", "msg_app_tip_notify", "sint32_album_cnt" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, SubCmd0x1UpdateAppUnreadNum.class);
      public submsgtype0x26.AppID msg_app_id = new submsgtype0x26.AppID();
      public submsgtype0x26.AppTipNotify msg_app_tip_notify = new submsgtype0x26.AppTipNotify();
      public final PBSInt32Field sint32_album_cnt = PBField.initSInt32(0);
      public final PBSInt32Field sint32_unread_num = PBField.initSInt32(0);
      public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    }
    
    public static final class SubCmd0x2UpdateAppList
      extends MessageMicro<SubCmd0x2UpdateAppList>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_msg_app_id", "rpt_uint32_time_stamp", "uint64_group_code" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, SubCmd0x2UpdateAppList.class);
      public final PBRepeatMessageField<submsgtype0x26.AppID> rpt_msg_app_id = PBField.initRepeatMessage(submsgtype0x26.AppID.class);
      public final PBRepeatField<Integer> rpt_uint32_time_stamp = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
      public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    }
    
    public static final class SubCmd0x3UpdateDiscussAppInfo
      extends MessageMicro<SubCmd0x3UpdateDiscussAppInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_app_id", "uint64_conf_uin", "msg_app_tip_notify" }, new Object[] { null, Long.valueOf(0L), null }, SubCmd0x3UpdateDiscussAppInfo.class);
      public submsgtype0x26.AppID msg_app_id = new submsgtype0x26.AppID();
      public submsgtype0x26.AppTipNotify msg_app_tip_notify = new submsgtype0x26.AppTipNotify();
      public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
    }
    
    public static final class SubCmd0x4UpdateApp
      extends MessageMicro<SubCmd0x4UpdateApp>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "msg_app_id", "uint64_group_code", "sint32_unread_num" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0) }, SubCmd0x4UpdateApp.class);
      public submsgtype0x26.AppID msg_app_id = new submsgtype0x26.AppID();
      public final PBSInt32Field sint32_unread_num = PBField.initSInt32(0);
      public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    }
  }
  
  public static final class TransferCnt
    extends MessageMicro<TransferCnt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "chain_id" }, new Object[] { Long.valueOf(0L) }, TransferCnt.class);
    public final PBUInt64Field chain_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26
 * JD-Core Version:    0.7.0.1
 */