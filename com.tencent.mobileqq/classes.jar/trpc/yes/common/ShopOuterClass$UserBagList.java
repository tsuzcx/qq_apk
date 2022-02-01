package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ShopOuterClass$UserBagList
  extends MessageMicro<UserBagList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bag_items" }, new Object[] { null }, UserBagList.class);
  public final PBRepeatMessageField<ShopOuterClass.UserBagItem> bag_items = PBField.initRepeatMessage(ShopOuterClass.UserBagItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.UserBagList
 * JD-Core Version:    0.7.0.1
 */