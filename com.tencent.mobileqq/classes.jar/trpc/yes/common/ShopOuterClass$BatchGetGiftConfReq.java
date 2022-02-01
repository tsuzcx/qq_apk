package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ShopOuterClass$BatchGetGiftConfReq
  extends MessageMicro<BatchGetGiftConfReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> gift_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> tag_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "gift_id", "tag_id" }, new Object[] { localInteger, localInteger }, BatchGetGiftConfReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.BatchGetGiftConfReq
 * JD-Core Version:    0.7.0.1
 */