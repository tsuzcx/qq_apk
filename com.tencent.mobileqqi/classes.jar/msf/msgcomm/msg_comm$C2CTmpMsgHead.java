package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_comm$C2CTmpMsgHead
  extends MessageMicro
{
  public static final int C2C_TYPE_FIELD_NUMBER = 1;
  public static final int FROM_PHONE_FIELD_NUMBER = 7;
  public static final int GROUP_CODE_FIELD_NUMBER = 4;
  public static final int GROUP_UIN_FIELD_NUMBER = 3;
  public static final int LOCK_DISPLAY_FIELD_NUMBER = 9;
  public static final int SERVICE_TYPE_FIELD_NUMBER = 2;
  public static final int SIG_FIELD_NUMBER = 5;
  public static final int SIG_TYPE_FIELD_NUMBER = 6;
  public static final int TO_PHONE_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field c2c_type = PBField.initUInt32(0);
  public final PBStringField from_phone = PBField.initString("");
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field group_uin = PBField.initUInt64(0L);
  public final PBUInt32Field lock_display = PBField.initUInt32(0);
  public final PBUInt32Field service_type = PBField.initUInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field sig_type = PBField.initUInt32(0);
  public final PBStringField to_phone = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 72 }, new String[] { "c2c_type", "service_type", "group_uin", "group_code", "sig", "sig_type", "from_phone", "to_phone", "lock_display" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), "", "", Integer.valueOf(0) }, C2CTmpMsgHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgcomm.msg_comm.C2CTmpMsgHead
 * JD-Core Version:    0.7.0.1
 */