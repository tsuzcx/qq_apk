package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class ShopOuterClass$GiftSceneInfo
  extends MessageMicro<GiftSceneInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField scene = PBField.initEnum(1);
  public final PBEnumField source_type = PBField.initEnum(1);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "scene", "source_type" }, new Object[] { localInteger, localInteger }, GiftSceneInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.GiftSceneInfo
 * JD-Core Version:    0.7.0.1
 */