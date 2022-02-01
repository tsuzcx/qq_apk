package tencent.im.s2c.msgtype0x210.submsgtype0x90;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x90
{
  public static final class DpNotifyMsgBdoy
    extends MessageMicro<DpNotifyMsgBdoy>
  {
    public static final int RPT_MSG_NOTIFY_INFO_FIELD_NUMBER = 3;
    public static final int STRING_EXTEND_INFO_FIELD_NUMBER = 4;
    public static final int UINT32_PID_FIELD_NUMBER = 1;
    public static final int UINT64_DIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_pid", "uint64_din", "rpt_msg_notify_info", "string_extend_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, "" }, DpNotifyMsgBdoy.class);
    public final PBRepeatMessageField<SubMsgType0x90.NotifyItem> rpt_msg_notify_info = PBField.initRepeatMessage(SubMsgType0x90.NotifyItem.class);
    public final PBStringField string_extend_info = PBField.initString("");
    public final PBUInt32Field uint32_pid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
  }
  
  public static final class Head
    extends MessageMicro<Head>
  {
    public static final int UINT32_CMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_cmd" }, new Object[] { Integer.valueOf(0) }, Head.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    public static final int MSG_BODY_FIELD_NUMBER = 2;
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "msg_body" }, new Object[] { null, null }, MsgBody.class);
    public SubMsgType0x90.PushBody msg_body = new SubMsgType0x90.PushBody();
    public SubMsgType0x90.Head msg_head = new SubMsgType0x90.Head();
  }
  
  public static final class NotifyItem
    extends MessageMicro<NotifyItem>
  {
    public static final int UINT32_PROPERTYID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_propertyid" }, new Object[] { Integer.valueOf(0) }, NotifyItem.class);
    public final PBUInt32Field uint32_propertyid = PBField.initUInt32(0);
  }
  
  public static final class OccupyMicrophoneNotifyMsgBody
    extends MessageMicro<OccupyMicrophoneNotifyMsgBody>
  {
    public static final int UINT32_UIN_FIELD_NUMBER = 1;
    public static final int UINT64_DIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_uin", "uint64_din" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, OccupyMicrophoneNotifyMsgBody.class);
    public final PBUInt32Field uint32_uin = PBField.initUInt32(0);
    public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
  }
  
  public static final class PushBody
    extends MessageMicro<PushBody>
  {
    public static final int MSG_DP_NOTIFY_BODY_FIELD_NUMBER = 1;
    public static final int MSG_OCCUPY_MICROPHONE_BODY_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_dp_notify_body", "msg_occupy_microphone_body" }, new Object[] { null, null }, PushBody.class);
    public SubMsgType0x90.DpNotifyMsgBdoy msg_dp_notify_body = new SubMsgType0x90.DpNotifyMsgBdoy();
    public SubMsgType0x90.OccupyMicrophoneNotifyMsgBody msg_occupy_microphone_body = new SubMsgType0x90.OccupyMicrophoneNotifyMsgBody();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90
 * JD-Core Version:    0.7.0.1
 */