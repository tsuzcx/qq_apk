package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ShopOuterClass$BuyAndGiveGiftReq
  extends MessageMicro<BuyAndGiveGiftReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field base_num = PBField.initInt32(0);
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public final PBInt32Field game_id = PBField.initInt32(0);
  public final PBUInt32Field gift_id = PBField.initUInt32(0);
  public final PBBoolField is_just_bag = PBField.initBool(false);
  public final PBInt32Field reason = PBField.initInt32(0);
  public final PBRepeatMessageField<CommonOuterClass.QQUserId> recv_list = PBField.initRepeatMessage(CommonOuterClass.QQUserId.class);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public ShopOuterClass.GiftSceneInfo scene_info = new ShopOuterClass.GiftSceneInfo();
  public final PBInt32Field total_num = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 64, 72, 80 }, new String[] { "recv_list", "gift_id", "total_num", "reason", "game_id", "is_just_bag", "scene_info", "room_id", "base_num", "expire_time" }, new Object[] { null, localInteger, localInteger, localInteger, localInteger, Boolean.valueOf(false), null, Long.valueOf(0L), localInteger, localInteger }, BuyAndGiveGiftReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.BuyAndGiveGiftReq
 * JD-Core Version:    0.7.0.1
 */