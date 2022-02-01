package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class ShopOuterClass$GetGiftListReq
  extends MessageMicro<GetGiftListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "scene_info" }, new Object[] { null }, GetGiftListReq.class);
  public ShopOuterClass.GiftSceneInfo scene_info = new ShopOuterClass.GiftSceneInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.GetGiftListReq
 * JD-Core Version:    0.7.0.1
 */