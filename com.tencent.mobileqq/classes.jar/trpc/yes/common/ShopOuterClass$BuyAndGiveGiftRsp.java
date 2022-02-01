package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ShopOuterClass$BuyAndGiveGiftRsp
  extends MessageMicro<BuyAndGiveGiftRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field base_num = PBField.initInt32(0);
  public final PBInt32Field change_money_type = PBField.initInt32(0);
  public final PBInt32Field cur_money_num = PBField.initInt32(0);
  public final PBInt32Field gift_id = PBField.initInt32(0);
  public final PBInt32Field gift_price = PBField.initInt32(0);
  public final PBRepeatMessageField<CommonOuterClass.QQUserId> recv_list = PBField.initRepeatMessage(CommonOuterClass.QQUserId.class);
  public final PBInt32Field total_num = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56 }, new String[] { "change_money_type", "cur_money_num", "recv_list", "gift_id", "total_num", "base_num", "gift_price" }, new Object[] { localInteger, localInteger, null, localInteger, localInteger, localInteger, localInteger }, BuyAndGiveGiftRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.BuyAndGiveGiftRsp
 * JD-Core Version:    0.7.0.1
 */