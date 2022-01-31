package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7da$ReqBody
  extends MessageMicro
{
  public static final int RPT_MSG_APPOINT_IDS_FIELD_NUMBER = 1;
  public static final int UINT32_APPOINT_OPERATION_FIELD_NUMBER = 2;
  public static final int UINT32_OPERATION_REASON_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_msg_appoint_ids", "uint32_appoint_operation", "uint32_operation_reason" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatMessageField rpt_msg_appoint_ids = PBField.initRepeatMessage(appoint_define.AppointID.class);
  public final PBUInt32Field uint32_appoint_operation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_operation_reason = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7da.ReqBody
 * JD-Core Version:    0.7.0.1
 */