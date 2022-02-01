package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class ShopOuterClass$GetGiftListRsp
  extends MessageMicro<GetGiftListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "gift_common_conf", "gift_list", "bag_list", "gift_conf_list", "gift_tag_conf_list" }, new Object[] { null, null, null, null, null }, GetGiftListRsp.class);
  public ShopOuterClass.UserBagList bag_list = new ShopOuterClass.UserBagList();
  public ShopOuterClass.GiftCommonConf gift_common_conf = new ShopOuterClass.GiftCommonConf();
  public ShopOuterClass.GiftConfList gift_conf_list = new ShopOuterClass.GiftConfList();
  public ShopOuterClass.GiftListConfList gift_list = new ShopOuterClass.GiftListConfList();
  public ShopOuterClass.GiftTagConfList gift_tag_conf_list = new ShopOuterClass.GiftTagConfList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.GetGiftListRsp
 * JD-Core Version:    0.7.0.1
 */