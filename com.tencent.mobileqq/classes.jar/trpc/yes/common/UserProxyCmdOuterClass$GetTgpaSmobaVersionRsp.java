package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserProxyCmdOuterClass$GetTgpaSmobaVersionRsp
  extends MessageMicro<GetTgpaSmobaVersionRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "cur_version_id", "new_version_id", "cur_source_id", "new_source_id" }, new Object[] { "", "", "", "" }, GetTgpaSmobaVersionRsp.class);
  public final PBStringField cur_source_id = PBField.initString("");
  public final PBStringField cur_version_id = PBField.initString("");
  public final PBStringField new_source_id = PBField.initString("");
  public final PBStringField new_version_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.GetTgpaSmobaVersionRsp
 * JD-Core Version:    0.7.0.1
 */