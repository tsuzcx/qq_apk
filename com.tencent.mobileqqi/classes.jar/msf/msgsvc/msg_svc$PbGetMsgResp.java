package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm.UinPairMsg;

public final class msg_svc$PbGetMsgResp
  extends MessageMicro
{
  public static final int BIND_UIN_FIELD_NUMBER = 6;
  public static final int ERRMSG_FIELD_NUMBER = 2;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int SYNC_COOKIE_FIELD_NUMBER = 3;
  public static final int SYNC_FLAG_FIELD_NUMBER = 4;
  public static final int UIN_PAIR_MSGS_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField sync_flag = PBField.initEnum(0);
  public final PBRepeatMessageField uin_pair_msgs = PBField.initRepeatMessage(msg_comm.UinPairMsg.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48 }, new String[] { "result", "errmsg", "sync_cookie", "sync_flag", "uin_pair_msgs", "bind_uin" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, Integer.valueOf(0), null, Long.valueOf(0L) }, PbGetMsgResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetMsgResp
 * JD-Core Version:    0.7.0.1
 */