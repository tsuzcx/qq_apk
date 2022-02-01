package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ShopOuterClass$UpdateUserFreeGiftReq
  extends MessageMicro<UpdateUserFreeGiftReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "gift_id", "room_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, UpdateUserFreeGiftReq.class);
  public final PBRepeatField<Integer> gift_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.UpdateUserFreeGiftReq
 * JD-Core Version:    0.7.0.1
 */