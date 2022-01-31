package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$AccostTmp
  extends MessageMicro
{
  public static final int REPLY_FIELD_NUMBER = 3;
  public static final int SIG_FIELD_NUMBER = 2;
  public static final int TO_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField reply = PBField.initBool(false);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "to_uin", "sig", "reply" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Boolean.valueOf(false) }, AccostTmp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.AccostTmp
 * JD-Core Version:    0.7.0.1
 */