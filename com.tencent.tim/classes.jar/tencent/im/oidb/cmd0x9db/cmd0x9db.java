package tencent.im.oidb.cmd0x9db;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x9db
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int RPT_UINT64_ID_FIELD_NUMBER = 2;
    public static final int UINT32_SEQUENCE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_sequence", "rpt_uint64_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int INT32_RESULT_FIELD_NUMBER = 1;
    public static final int RPT_UINT64_UIN_FIELD_NUMBER = 4;
    public static final int STR_ERRORMESSAGE_FIELD_NUMBER = 3;
    public static final int UINT32_SEQUENCE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "int32_result", "uint32_sequence", "str_errormessage", "rpt_uint64_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L) }, RspBody.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField str_errormessage = PBField.initString("");
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9db.cmd0x9db
 * JD-Core Version:    0.7.0.1
 */