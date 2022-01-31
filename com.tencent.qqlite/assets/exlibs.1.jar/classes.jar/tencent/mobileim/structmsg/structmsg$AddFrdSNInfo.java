package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$AddFrdSNInfo
  extends MessageMicro
{
  public static final int UINT32_NOT_SEE_DYNAMIC_FIELD_NUMBER = 1;
  public static final int UINT32_SET_SN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_not_see_dynamic", "uint32_set_sn" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AddFrdSNInfo.class);
  public final PBUInt32Field uint32_not_see_dynamic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_set_sn = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.AddFrdSNInfo
 * JD-Core Version:    0.7.0.1
 */