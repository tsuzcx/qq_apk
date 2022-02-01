package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserProxyCmdOuterClass$QQGroupProUserInfo
  extends MessageMicro<QQGroupProUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "tinyid", "nick", "avatar", "full_age", "gender" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0) }, QQGroupProUserInfo.class);
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField full_age = PBField.initString("");
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public final PBStringField nick = PBField.initString("");
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.QQGroupProUserInfo
 * JD-Core Version:    0.7.0.1
 */