package tencent.im.s2c.msgtype0x210.submsgtype0x87;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x87
{
  public static final class CloneInfo
    extends MessageMicro<CloneInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_origin_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_to_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_show_in_aio = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_gender = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56 }, new String[] { "uint64_uin", "bytes_remark", "bytes_origin_nick", "uint32_show_in_aio", "uint64_to_uin", "bytes_to_nick", "uint32_src_gender" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0) }, CloneInfo.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_friend_msg_type_flag", "rpt_msg_msg_notify", "msg_msg_notify_unread" }, new Object[] { Long.valueOf(0L), null, null }, MsgBody.class);
    public SubMsgType0x87.MsgNotifyUnread msg_msg_notify_unread = new SubMsgType0x87.MsgNotifyUnread();
    public final PBRepeatMessageField<SubMsgType0x87.MsgNotify> rpt_msg_msg_notify = PBField.initRepeatMessage(SubMsgType0x87.MsgNotify.class);
    public final PBUInt64Field uint64_friend_msg_type_flag = PBField.initUInt64(0L);
  }
  
  public static final class MsgNotify
    extends MessageMicro<MsgNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint64_uin", "uint64_fuin", "uint32_time", "uint32_reqsubtype", "uint32_max_count", "msg_clone_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, MsgNotify.class);
    public SubMsgType0x87.CloneInfo msg_clone_info = new SubMsgType0x87.CloneInfo();
    public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reqsubtype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgNotifyUnread
    extends MessageMicro<MsgNotifyUnread>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_unreadcount" }, new Object[] { Integer.valueOf(0) }, MsgNotifyUnread.class);
    public final PBUInt32Field uint32_unreadcount = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87
 * JD-Core Version:    0.7.0.1
 */