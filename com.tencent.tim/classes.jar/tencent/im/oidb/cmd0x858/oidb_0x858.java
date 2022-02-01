package tencent.im.oidb.cmd0x858;

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

public final class oidb_0x858
{
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
  
  public static final class NotifyMsgBody
    extends MessageMicro<NotifyMsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82 }, new String[] { "opt_enum_type", "opt_uint64_msg_time", "opt_uint64_msg_expires", "opt_uint64_conf_uin", "opt_msg_redtips", "opt_msg_recall_reminder", "opt_msg_obj_update", "opt_stcm_game_state", "apllo_msg_push", "opt_msg_goldtips" }, new Object[] { Integer.valueOf(5), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, null, null }, NotifyMsgBody.class);
    public apollo_push_msgInfo.STPushMsgElem apllo_msg_push = new apollo_push_msgInfo.STPushMsgElem();
    public final PBEnumField opt_enum_type = PBField.initEnum(5);
    public oidb_0x858.GoldMsgTipsElem opt_msg_goldtips = new oidb_0x858.GoldMsgTipsElem();
    public oidb_0x858.NotifyObjmsgUpdate opt_msg_obj_update = new oidb_0x858.NotifyObjmsgUpdate();
    public oidb_0x858.MessageRecallReminder opt_msg_recall_reminder = new oidb_0x858.MessageRecallReminder();
    public oidb_0x858.RedGrayTipsInfo opt_msg_redtips = new oidb_0x858.RedGrayTipsInfo();
    public apollo_game_status.STCMGameMessage opt_stcm_game_state = new apollo_game_status.STCMGameMessage();
    public final PBUInt64Field opt_uint64_conf_uin = PBField.initUInt64(0L);
    public final PBUInt64Field opt_uint64_msg_expires = PBField.initUInt64(0L);
    public final PBUInt64Field opt_uint64_msg_time = PBField.initUInt64(0L);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x858.oidb_0x858
 * JD-Core Version:    0.7.0.1
 */