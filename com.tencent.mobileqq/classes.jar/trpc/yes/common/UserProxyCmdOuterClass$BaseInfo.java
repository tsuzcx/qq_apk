package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserProxyCmdOuterClass$BaseInfo
  extends MessageMicro<BaseInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field age = PBField.initUInt32(0);
  public final PBStringField age_group = PBField.initString("");
  public UserProxyCmdOuterClass.Birthday birthday = new UserProxyCmdOuterClass.Birthday();
  public final PBStringField city = PBField.initString("");
  public final PBStringField constellation = PBField.initString("");
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBStringField nick = PBField.initString("");
  public UserProxyCmdOuterClass.Birthday self_birthday = new UserProxyCmdOuterClass.Birthday();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 58, 66 }, new String[] { "nick", "age", "constellation", "gender", "birthday", "self_birthday", "age_group", "city" }, new Object[] { "", localInteger, "", localInteger, null, null, "", "" }, BaseInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.BaseInfo
 * JD-Core Version:    0.7.0.1
 */