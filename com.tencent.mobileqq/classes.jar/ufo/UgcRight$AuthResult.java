package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UgcRight$AuthResult
  extends MessageMicro<AuthResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField auth_finstep = PBField.initEnum(1);
  public final PBEnumField auth_result = PBField.initEnum(1);
  public final PBUInt64Field rightFlag = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "auth_result", "auth_finstep", "rightFlag" }, new Object[] { localInteger, localInteger, Long.valueOf(0L) }, AuthResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.AuthResult
 * JD-Core Version:    0.7.0.1
 */