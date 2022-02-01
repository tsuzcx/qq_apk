package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TcloudServerOuterClass$GetUserTCloudSignRsp
  extends MessageMicro<GetUserTCloudSignRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "im_sign", "trtc_sign", "expire_time" }, new Object[] { "", "", Integer.valueOf(0) }, GetUserTCloudSignRsp.class);
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public final PBStringField im_sign = PBField.initString("");
  public final PBStringField trtc_sign = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.TcloudServerOuterClass.GetUserTCloudSignRsp
 * JD-Core Version:    0.7.0.1
 */