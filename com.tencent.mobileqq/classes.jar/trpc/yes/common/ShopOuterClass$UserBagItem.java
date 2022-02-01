package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ShopOuterClass$UserBagItem
  extends MessageMicro<UserBagItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBInt32Field props_id = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "props_id", "num", "expire_time", "create_time" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, UserBagItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.UserBagItem
 * JD-Core Version:    0.7.0.1
 */