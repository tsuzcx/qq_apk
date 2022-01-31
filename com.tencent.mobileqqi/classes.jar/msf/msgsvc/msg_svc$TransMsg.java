package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$TransMsg
  extends MessageMicro
{
  public static final int C2C_CMD_FIELD_NUMBER = 2;
  public static final int TO_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "to_uin", "c2c_cmd" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, TransMsg.class);
  public final PBUInt32Field c2c_cmd = PBField.initUInt32(0);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.TransMsg
 * JD-Core Version:    0.7.0.1
 */