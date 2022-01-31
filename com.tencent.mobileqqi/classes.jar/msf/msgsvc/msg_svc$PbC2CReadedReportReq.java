package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class msg_svc$PbC2CReadedReportReq
  extends MessageMicro
{
  public static final int PAIR_INFO_FIELD_NUMBER = 2;
  public static final int SYNC_COOKIE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField pair_info = PBField.initRepeatMessage(msg_svc.PbC2CReadedReportReq.UinPairReadInfo.class);
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "sync_cookie", "pair_info" }, new Object[] { localByteStringMicro, null }, PbC2CReadedReportReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbC2CReadedReportReq
 * JD-Core Version:    0.7.0.1
 */