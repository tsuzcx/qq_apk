package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserProxyCmdOuterClass$MiniInfo
  extends MessageMicro<MiniInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 42 }, new String[] { "base_info", "avatar", "long_nick" }, new Object[] { null, "", "" }, MiniInfo.class);
  public final PBStringField avatar = PBField.initString("");
  public UserProxyCmdOuterClass.BaseInfo base_info = new UserProxyCmdOuterClass.BaseInfo();
  public final PBStringField long_nick = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.MiniInfo
 * JD-Core Version:    0.7.0.1
 */