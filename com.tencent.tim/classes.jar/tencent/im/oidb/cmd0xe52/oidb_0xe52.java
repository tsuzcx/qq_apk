package tencent.im.oidb.cmd0xe52;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe52
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_verify_type", "rpt_uint64_schoolmates", "msg_user_school_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null }, ReqBody.class);
    public oidb_0xe52.SchoolInfo msg_user_school_info = new oidb_0xe52.SchoolInfo();
    public final PBRepeatField<Long> rpt_uint64_schoolmates = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_verify_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_verify_result" }, new Object[] { Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field uint32_verify_result = PBField.initUInt32(0);
  }
  
  public static final class SchoolInfo
    extends MessageMicro<SchoolInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 800 }, new String[] { "uint32_category", "str_school_id", "str_school_name", "str_department_id", "str_department_name", "uint32_degree", "uint32_enrollment_year", "uint32_graduation_year", "uint32_allow_recommend", "uint32_create_source", "uint32_create_time", "uint32_update_source", "uint32_update_time", "uint32_hidden_flag", "uint32_verified", "uint32_idx" }, new Object[] { Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SchoolInfo.class);
    public final PBStringField str_department_id = PBField.initString("");
    public final PBStringField str_department_name = PBField.initString("");
    public final PBStringField str_school_id = PBField.initString("");
    public final PBStringField str_school_name = PBField.initString("");
    public final PBUInt32Field uint32_allow_recommend = PBField.initUInt32(0);
    public final PBUInt32Field uint32_category = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_degree = PBField.initUInt32(0);
    public final PBUInt32Field uint32_enrollment_year = PBField.initUInt32(0);
    public final PBUInt32Field uint32_graduation_year = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hidden_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_verified = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe52.oidb_0xe52
 * JD-Core Version:    0.7.0.1
 */