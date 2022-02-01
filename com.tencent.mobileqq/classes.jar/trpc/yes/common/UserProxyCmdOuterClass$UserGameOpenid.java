package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserProxyCmdOuterClass$UserGameOpenid
  extends MessageMicro<UserGameOpenid>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "smoba_openid" }, new Object[] { "" }, UserGameOpenid.class);
  public final PBStringField smoba_openid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.UserGameOpenid
 * JD-Core Version:    0.7.0.1
 */