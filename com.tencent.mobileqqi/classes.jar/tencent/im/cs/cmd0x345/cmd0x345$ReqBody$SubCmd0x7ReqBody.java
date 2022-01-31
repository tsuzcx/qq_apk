package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345$ReqBody$SubCmd0x7ReqBody
  extends MessageMicro
{
  public static final int STR_FILE_PATH_FIELD_NUMBER = 2;
  public static final int UINT64_DISSCUS_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_disscus_uin", "str_file_path" }, new Object[] { Long.valueOf(0L), "" }, SubCmd0x7ReqBody.class);
  public final PBStringField str_file_path = PBField.initString("");
  public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x7ReqBody
 * JD-Core Version:    0.7.0.1
 */