package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class device_lock_query_status
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int U32_APP_ID_FIELD_NUMBER = 3;
    public static final int U32_SEQ_FIELD_NUMBER = 1;
    public static final int U32_SYS_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "u32_seq", "u32_sys_type", "u32_app_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field u32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field u32_seq = PBField.initUInt32(0);
    public final PBUInt32Field u32_sys_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int STR_WORDING_FIELD_NUMBER = 3;
    public static final int U32_RET_FIELD_NUMBER = 4;
    public static final int U32_SEQ_FIELD_NUMBER = 1;
    public static final int U32_STATUS_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "u32_seq", "u32_status", "str_wording", "u32_ret" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, RspBody.class);
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field u32_ret = PBField.initUInt32(0);
    public final PBUInt32Field u32_seq = PBField.initUInt32(0);
    public final PBUInt32Field u32_status = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.device_lock_query_status
 * JD-Core Version:    0.7.0.1
 */