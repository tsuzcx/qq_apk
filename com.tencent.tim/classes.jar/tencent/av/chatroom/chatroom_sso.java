package tencent.av.chatroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class chatroom_sso
{
  public static final class Msg
    extends MessageMicro<Msg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uin", "msg", "msg_id", "msg_time" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L) }, Msg.class);
    public final PBStringField msg = PBField.initString("");
    public final PBUInt32Field msg_id = PBField.initUInt32(0);
    public final PBUInt64Field msg_time = PBField.initUInt64(0L);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class PushMsg
    extends MessageMicro<PushMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "room_key", "msg" }, new Object[] { null, null }, PushMsg.class);
    public chatroom_sso.Msg msg = new chatroom_sso.Msg();
    public chatroom_sso.RoomKey room_key = new chatroom_sso.RoomKey();
  }
  
  public static final class ReqGetMsg
    extends MessageMicro<ReqGetMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "room_key", "is_terminal_switch", "room_id" }, new Object[] { null, Boolean.valueOf(false), Long.valueOf(0L) }, ReqGetMsg.class);
    public final PBBoolField is_terminal_switch = PBField.initBool(false);
    public final PBUInt64Field room_id = PBField.initUInt64(0L);
    public chatroom_sso.RoomKey room_key = new chatroom_sso.RoomKey();
  }
  
  public static final class ReqSendMsg
    extends MessageMicro<ReqSendMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "room_key", "msg" }, new Object[] { null, null }, ReqSendMsg.class);
    public chatroom_sso.Msg msg = new chatroom_sso.Msg();
    public chatroom_sso.RoomKey room_key = new chatroom_sso.RoomKey();
  }
  
  public static final class RoomKey
    extends MessageMicro<RoomKey>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "type", "id", "room_id", "create_ts" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, RoomKey.class);
    public final PBUInt32Field create_ts = PBField.initUInt32(0);
    public final PBUInt64Field id = PBField.initUInt64(0L);
    public final PBUInt64Field room_id = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class RspGetMsg
    extends MessageMicro<RspGetMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "result", "err_msg", "msg_list", "retry", "retry_delay" }, new Object[] { Integer.valueOf(0), "", null, Boolean.valueOf(false), Long.valueOf(0L) }, RspGetMsg.class);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<chatroom_sso.Msg> msg_list = PBField.initRepeatMessage(chatroom_sso.Msg.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBoolField retry = PBField.initBool(false);
    public final PBUInt64Field retry_delay = PBField.initUInt64(0L);
  }
  
  public static final class RspSendMsg
    extends MessageMicro<RspSendMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "result", "err_msg", "msg_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, RspSendMsg.class);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field msg_id = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.av.chatroom.chatroom_sso
 * JD-Core Version:    0.7.0.1
 */