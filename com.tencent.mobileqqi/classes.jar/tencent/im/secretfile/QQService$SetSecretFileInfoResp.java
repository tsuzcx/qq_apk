package tencent.im.secretfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQService$SetSecretFileInfoResp
  extends MessageMicro
{
  public static final int INT32_RET_CODE_FIELD_NUMBER = 2;
  public static final int STR_RET_MSG_FIELD_NUMBER = 3;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "int32_ret_code", "str_ret_msg" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, SetSecretFileInfoResp.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.secretfile.QQService.SetSecretFileInfoResp
 * JD-Core Version:    0.7.0.1
 */