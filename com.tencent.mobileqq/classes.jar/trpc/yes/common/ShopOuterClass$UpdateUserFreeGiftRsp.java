package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ShopOuterClass$UpdateUserFreeGiftRsp
  extends MessageMicro<UpdateUserFreeGiftRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enter_room_time", "send_gift_time" }, new Object[] { Integer.valueOf(0), null }, UpdateUserFreeGiftRsp.class);
  public final PBUInt32Field enter_room_time = PBField.initUInt32(0);
  public ShopOuterClass.SendGiftTimeInfo send_gift_time = new ShopOuterClass.SendGiftTimeInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.UpdateUserFreeGiftRsp
 * JD-Core Version:    0.7.0.1
 */