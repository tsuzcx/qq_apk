package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbGetRoamMsgReq
  extends MessageMicro
{
  public static final int CHECK_PWD_FIELD_NUMBER = 5;
  public static final int LAST_MSGTIME_FIELD_NUMBER = 2;
  public static final int PEER_UIN_FIELD_NUMBER = 1;
  public static final int PWD_FIELD_NUMBER = 7;
  public static final int RANDOM_FIELD_NUMBER = 3;
  public static final int READ_CNT_FIELD_NUMBER = 4;
  public static final int SIG_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field check_pwd = PBField.initUInt32(0);
  public final PBUInt64Field last_msgtime = PBField.initUInt64(0L);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBBytesField pwd = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field random = PBField.initUInt64(0L);
  public final PBUInt32Field read_cnt = PBField.initUInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58 }, new String[] { "peer_uin", "last_msgtime", "random", "read_cnt", "check_pwd", "sig", "pwd" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, PbGetRoamMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetRoamMsgReq
 * JD-Core Version:    0.7.0.1
 */