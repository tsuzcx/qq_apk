package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserProxyCmdOuterClass$GetTgpaSmobaVersionReq
  extends MessageMicro<GetTgpaSmobaVersionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "xid", "has_update" }, new Object[] { "", Boolean.valueOf(false) }, GetTgpaSmobaVersionReq.class);
  public final PBBoolField has_update = PBField.initBool(false);
  public final PBStringField xid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.GetTgpaSmobaVersionReq
 * JD-Core Version:    0.7.0.1
 */