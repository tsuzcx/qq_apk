package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AccountSecurityInfo
{
  public static final class AccSecInfoRequire
    extends MessageMicro<AccSecInfoRequire>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "u64_uin", "str_version", "u32_client_type" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0) }, AccSecInfoRequire.class);
    public final PBStringField str_version = PBField.initString("");
    public final PBUInt32Field u32_client_type = PBField.initUInt32(0);
    public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
  }
  
  public static final class AccSecInfoResponse
    extends MessageMicro<AccSecInfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "u32_valid", "str_wording", "str_AccInfoUrl" }, new Object[] { Integer.valueOf(0), "", "" }, AccSecInfoResponse.class);
    public final PBStringField str_AccInfoUrl = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field u32_valid = PBField.initUInt32(0);
  }
  
  public static final class SecCheckBanner
    extends MessageMicro<SecCheckBanner>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_wording", "u32_timeToShow" }, new Object[] { "", Integer.valueOf(0) }, SecCheckBanner.class);
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field u32_timeToShow = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.AccountSecurityInfo
 * JD-Core Version:    0.7.0.1
 */