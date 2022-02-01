package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TcloudServerOuterClass$GetUserTCloudSignReq
  extends MessageMicro<GetUserTCloudSignReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uid" }, new Object[] { Long.valueOf(0L) }, GetUserTCloudSignReq.class);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.TcloudServerOuterClass.GetUserTCloudSignReq
 * JD-Core Version:    0.7.0.1
 */