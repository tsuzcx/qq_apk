package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x383$ApplyTransFileRspBody
  extends MessageMicro
{
  public static final int STR_SAVE_FILE_PATH_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_save_file_path" }, new Object[] { "" }, ApplyTransFileRspBody.class);
  public final PBStringField str_save_file_path = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyTransFileRspBody
 * JD-Core Version:    0.7.0.1
 */