package trpc.mizarproto.passthrough;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FunctionLockMsg$FunctionLockBtn
  extends MessageMicro<FunctionLockBtn>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "woding", "url", "jump_type" }, new Object[] { "", "", Integer.valueOf(0) }, FunctionLockBtn.class);
  public final PBUInt32Field jump_type = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBStringField woding = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.mizarproto.passthrough.FunctionLockMsg.FunctionLockBtn
 * JD-Core Version:    0.7.0.1
 */