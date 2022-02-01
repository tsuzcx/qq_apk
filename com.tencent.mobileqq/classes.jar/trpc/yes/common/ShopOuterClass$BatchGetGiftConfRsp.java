package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class ShopOuterClass$BatchGetGiftConfRsp
  extends MessageMicro<BatchGetGiftConfRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "gift_conf_list", "gift_tag_conf_list" }, new Object[] { null, null }, BatchGetGiftConfRsp.class);
  public ShopOuterClass.GiftConfList gift_conf_list = new ShopOuterClass.GiftConfList();
  public ShopOuterClass.GiftTagConfList gift_tag_conf_list = new ShopOuterClass.GiftTagConfList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.BatchGetGiftConfRsp
 * JD-Core Version:    0.7.0.1
 */