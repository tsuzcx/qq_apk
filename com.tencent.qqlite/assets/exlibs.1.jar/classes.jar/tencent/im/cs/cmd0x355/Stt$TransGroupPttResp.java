package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Stt$TransGroupPttResp
  extends MessageMicro
{
  public static final int STR_FILEMD5_FIELD_NUMBER = 7;
  public static final int UINT32_ERROR_CODE_FIELD_NUMBER = 2;
  public static final int UINT32_FILEID_FIELD_NUMBER = 6;
  public static final int UINT32_SERVICEPROVIDER_FIELD_NUMBER = 8;
  public static final int UINT32_WAITTIME_FIELD_NUMBER = 3;
  public static final int UINT64_GROUP_UIN_FIELD_NUMBER = 5;
  public static final int UINT64_SENDER_UIN_FIELD_NUMBER = 4;
  public static final int UINT64_SESSIONID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64 }, new String[] { "uint64_sessionid", "uint32_error_code", "uint32_waittime", "uint64_sender_uin", "uint64_group_uin", "uint32_fileid", "str_Filemd5", "uint32_serviceprovider" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0) }, TransGroupPttResp.class);
  public final PBStringField str_Filemd5 = PBField.initString("");
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fileid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_serviceprovider = PBField.initUInt32(0);
  public final PBUInt32Field uint32_waittime = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x355.Stt.TransGroupPttResp
 * JD-Core Version:    0.7.0.1
 */