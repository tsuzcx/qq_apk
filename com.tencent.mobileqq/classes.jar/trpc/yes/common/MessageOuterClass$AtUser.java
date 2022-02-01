package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MessageOuterClass$AtUser
  extends MessageMicro<AtUser>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "user_id", "nick_name", "head_url" }, new Object[] { null, "", "" }, AtUser.class);
  public final PBStringField head_url = PBField.initString("");
  public final PBStringField nick_name = PBField.initString("");
  public CommonOuterClass.QQUserId user_id = new CommonOuterClass.QQUserId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.MessageOuterClass.AtUser
 * JD-Core Version:    0.7.0.1
 */