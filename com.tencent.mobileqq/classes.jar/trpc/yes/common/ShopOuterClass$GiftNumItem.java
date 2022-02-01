package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ShopOuterClass$GiftNumItem
  extends MessageMicro<GiftNumItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "text", "num" }, new Object[] { "", Integer.valueOf(0) }, GiftNumItem.class);
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBStringField text = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.GiftNumItem
 * JD-Core Version:    0.7.0.1
 */