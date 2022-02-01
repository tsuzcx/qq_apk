package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WTogetherCommon$TxPlayerParams
  extends MessageMicro<TxPlayerParams>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "vid", "cid" }, new Object[] { "", "" }, TxPlayerParams.class);
  public final PBStringField cid = PBField.initString("");
  public final PBStringField vid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.TxPlayerParams
 * JD-Core Version:    0.7.0.1
 */