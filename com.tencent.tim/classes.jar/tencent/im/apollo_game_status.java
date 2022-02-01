package tencent.im;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class apollo_game_status
{
  public static final class STCMGameMessage
    extends MessageMicro<STCMGameMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "uint32_msg_cmd", "msg_comm", "msg_0x01", "msg_0x02", "msg_0x03", "msg_0x04", "msg_0x05", "msg_0x06" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null }, STCMGameMessage.class);
    public STGameJoinRoom msg_0x01 = new STGameJoinRoom();
    public STGameQuitRoom msg_0x02 = new STGameQuitRoom();
    public STGameStart msg_0x03 = new STGameStart();
    public STGameOver msg_0x04 = new STGameOver();
    public STGameInvalid msg_0x05 = new STGameInvalid();
    public STGameCancel msg_0x06 = new STGameCancel();
    public STMsgComm msg_comm = new STMsgComm();
    public final PBUInt32Field uint32_msg_cmd = PBField.initUInt32(0);
    
    public static final class STGameCancel
      extends MessageMicro<STGameCancel>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField str_game_cancel_info = PBField.initBytes(ByteStringMicro.EMPTY);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_game_cancel_info" }, new Object[] { localByteStringMicro }, STGameCancel.class);
      }
    }
    
    public static final class STGameInvalid
      extends MessageMicro<STGameInvalid>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField str_game_invlid_info = PBField.initBytes(ByteStringMicro.EMPTY);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_game_invlid_info" }, new Object[] { localByteStringMicro }, STGameInvalid.class);
      }
    }
    
    public static final class STGameJoinRoom
      extends MessageMicro<STGameJoinRoom>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBRepeatField<Integer> rpt_uint32_uin_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
      public final PBBytesField str_game_join_info = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt32Field uint32_room_vol = PBField.initUInt32(0);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_room_vol", "rpt_uint32_uin_list", "str_game_join_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, STGameJoinRoom.class);
      }
    }
    
    public static final class STGameOver
      extends MessageMicro<STGameOver>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBRepeatMessageField<apollo_game_status.STCMGameMessage.STScoreInfo> rpt_msg_winner_info = PBField.initRepeatMessage(apollo_game_status.STCMGameMessage.STScoreInfo.class);
      public final PBBytesField str_game_over_info = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt32Field uint32_over_type = PBField.initUInt32(0);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "rpt_msg_winner_info", "uint32_over_type", "str_game_over_info" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro }, STGameOver.class);
      }
    }
    
    public static final class STGameQuitRoom
      extends MessageMicro<STGameQuitRoom>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBRepeatField<Integer> rpt_uint32_uin_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
      public final PBBytesField str_game_quit_info = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt32Field uint32_room_vol = PBField.initUInt32(0);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_room_vol", "rpt_uint32_uin_list", "str_game_quit_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, STGameQuitRoom.class);
      }
    }
    
    public static final class STGameStart
      extends MessageMicro<STGameStart>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField str_game_start_info = PBField.initBytes(ByteStringMicro.EMPTY);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_game_start_info" }, new Object[] { localByteStringMicro }, STGameStart.class);
      }
    }
    
    public static final class STMsgComm
      extends MessageMicro<STMsgComm>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBRepeatField<Integer> rpt_uint32_session_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
      public final PBRepeatField<Integer> rpt_uint32_uin_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
      public final PBBytesField str_game_comm_info = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBStringField str_room_id = PBField.initString("");
      public final PBUInt32Field uint32_game_id = PBField.initUInt32(0);
      public final PBUInt32Field uint32_play_model = PBField.initUInt32(0);
      public final PBUInt32Field uint32_room_vol = PBField.initUInt32(0);
      public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
      public final PBUInt64Field uint64_time_stamp = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 64, 72 }, new String[] { "uint32_game_id", "str_room_id", "uint64_time_stamp", "uint32_session_id", "rpt_uint32_session_list", "uint32_play_model", "str_game_comm_info", "rpt_uint32_uin_list", "uint32_room_vol" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, STMsgComm.class);
      }
    }
    
    public static final class STScoreInfo
      extends MessageMicro<STScoreInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_winner", "str_wording" }, new Object[] { Integer.valueOf(0), "" }, STScoreInfo.class);
      public final PBStringField str_wording = PBField.initString("");
      public final PBUInt32Field uint32_winner = PBField.initUInt32(0);
    }
  }
  
  public static final class STGameStateMsgList
    extends MessageMicro<STGameStateMsgList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_list" }, new Object[] { null }, STGameStateMsgList.class);
    public final PBRepeatMessageField<apollo_game_status.STCMGameMessage> rpt_msg_list = PBField.initRepeatMessage(apollo_game_status.STCMGameMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.apollo_game_status
 * JD-Core Version:    0.7.0.1
 */