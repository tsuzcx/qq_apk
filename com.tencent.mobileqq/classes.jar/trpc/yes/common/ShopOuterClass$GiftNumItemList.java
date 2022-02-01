package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ShopOuterClass$GiftNumItemList
  extends MessageMicro<GiftNumItemList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { null }, GiftNumItemList.class);
  public final PBRepeatMessageField<ShopOuterClass.GiftNumItem> data = PBField.initRepeatMessage(ShopOuterClass.GiftNumItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.GiftNumItemList
 * JD-Core Version:    0.7.0.1
 */