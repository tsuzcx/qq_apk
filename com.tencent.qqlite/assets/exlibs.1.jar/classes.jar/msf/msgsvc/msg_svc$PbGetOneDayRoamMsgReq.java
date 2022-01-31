package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbGetOneDayRoamMsgReq
  extends MessageMicro
{
  public static final int LAST_MSGTIME_FIELD_NUMBER = 2;
  public static final int PEER_UIN_FIELD_NUMBER = 1;
  public static final int RANDOM_FIELD_NUMBER = 3;
  public static final int READ_CNT_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "peer_uin", "last_msgtime", "random", "read_cnt" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, PbGetOneDayRoamMsgReq.class);
  public final PBUInt64Field last_msgtime = PBField.initUInt64(0L);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBUInt64Field random = PBField.initUInt64(0L);
  public final PBUInt32Field read_cnt = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetOneDayRoamMsgReq
 * JD-Core Version:    0.7.0.1
 */