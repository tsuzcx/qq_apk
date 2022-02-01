package tencent.im.oidb.cmd0x5d1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5d1
{
  public static final class ClearFriendIdReq
    extends MessageMicro<ClearFriendIdReq>
  {
    public static final int RPT_UINT64_FRIENDS_FIELD_NUMBER = 3;
    public static final int UINT32_IF_CHECK_SEQ_FIELD_NUMBER = 1;
    public static final int UINT64_SEQ_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_if_check_seq", "uint64_seq", "rpt_uint64_friends" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ClearFriendIdReq.class);
    public final PBRepeatField<Long> rpt_uint64_friends = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_if_check_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  }
  
  public static final class ClearFriendIdRsp
    extends MessageMicro<ClearFriendIdRsp>
  {
    public static final int BYTES_ERROR_MSG_FIELD_NUMBER = 3;
    public static final int UINT32_RESULT_FIELD_NUMBER = 1;
    public static final int UINT64_SEQ_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_result", "uint64_seq", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, ClearFriendIdRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_CLEAR_FRIEND_ID_FIELD_NUMBER = 4;
    public static final int MSG_SET_FRIEND_ID_FIELD_NUMBER = 3;
    public static final int UINT32_CMD_FIELD_NUMBER = 1;
    public static final int UINT32_ID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_cmd", "uint32_id", "msg_set_friend_id", "msg_clear_friend_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, ReqBody.class);
    public Oidb_0x5d1.ClearFriendIdReq msg_clear_friend_id = new Oidb_0x5d1.ClearFriendIdReq();
    public Oidb_0x5d1.SetFriendIdReq msg_set_friend_id = new Oidb_0x5d1.SetFriendIdReq();
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_CLEAR_FRIEND_ID_FIELD_NUMBER = 4;
    public static final int MSG_SET_FRIEND_ID_FIELD_NUMBER = 3;
    public static final int UINT32_CMD_FIELD_NUMBER = 1;
    public static final int UINT32_ID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_cmd", "uint32_id", "msg_set_friend_id", "msg_clear_friend_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, RspBody.class);
    public Oidb_0x5d1.ClearFriendIdRsp msg_clear_friend_id = new Oidb_0x5d1.ClearFriendIdRsp();
    public Oidb_0x5d1.SetFriendIdRsp msg_set_friend_id = new Oidb_0x5d1.SetFriendIdRsp();
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  }
  
  public static final class SetFriendIdReq
    extends MessageMicro<SetFriendIdReq>
  {
    public static final int RPT_UINT64_FRIENDS_FIELD_NUMBER = 3;
    public static final int UINT32_IF_CHECK_SEQ_FIELD_NUMBER = 1;
    public static final int UINT64_SEQ_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_if_check_seq", "uint64_seq", "rpt_uint64_friends" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, SetFriendIdReq.class);
    public final PBRepeatField<Long> rpt_uint64_friends = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_if_check_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  }
  
  public static final class SetFriendIdRsp
    extends MessageMicro<SetFriendIdRsp>
  {
    public static final int BYTES_ERROR_MSG_FIELD_NUMBER = 3;
    public static final int UINT32_RESULT_FIELD_NUMBER = 1;
    public static final int UINT64_SEQ_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_result", "uint64_seq", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, SetFriendIdRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d1.Oidb_0x5d1
 * JD-Core Version:    0.7.0.1
 */