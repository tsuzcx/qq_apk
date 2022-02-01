package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SafeOuterClass$QQGetUserSafeSercetRsp
  extends MessageMicro<QQGetUserSafeSercetRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "uin_key", "aes_decrypt_key" }, new Object[] { "", "" }, QQGetUserSafeSercetRsp.class);
  public final PBStringField aes_decrypt_key = PBField.initString("");
  public final PBStringField uin_key = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.SafeOuterClass.QQGetUserSafeSercetRsp
 * JD-Core Version:    0.7.0.1
 */