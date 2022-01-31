package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$DisTmp
  extends MessageMicro
{
  public static final int DIS_UIN_FIELD_NUMBER = 1;
  public static final int TO_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "dis_uin", "to_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, DisTmp.class);
  public final PBUInt64Field dis_uin = PBField.initUInt64(0L);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.DisTmp
 * JD-Core Version:    0.7.0.1
 */