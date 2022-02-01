package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserProxyCmdOuterClass$RetQQUserInfo
  extends MessageMicro<RetQQUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ret", "uid", "user_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null }, RetQQUserInfo.class);
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public UserProxyCmdOuterClass.QQUserInfo user_info = new UserProxyCmdOuterClass.QQUserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.RetQQUserInfo
 * JD-Core Version:    0.7.0.1
 */