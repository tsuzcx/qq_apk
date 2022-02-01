package trpc.mizarproto.passthrough;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FunctionLockMsg$FunctionLockBeatRsp
  extends MessageMicro<FunctionLockBeatRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "wording", "btns" }, new Object[] { "", null }, FunctionLockBeatRsp.class);
  public final PBRepeatMessageField<FunctionLockMsg.FunctionLockBtn> btns = PBField.initRepeatMessage(FunctionLockMsg.FunctionLockBtn.class);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.mizarproto.passthrough.FunctionLockMsg.FunctionLockBeatRsp
 * JD-Core Version:    0.7.0.1
 */