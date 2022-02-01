package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ShopOuterClass$GiftTagConf
  extends MessageMicro<GiftTagConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 42 }, new String[] { "tag_id", "tag_name", "tag_icon" }, new Object[] { Integer.valueOf(0), "", "" }, GiftTagConf.class);
  public final PBStringField tag_icon = PBField.initString("");
  public final PBUInt32Field tag_id = PBField.initUInt32(0);
  public final PBStringField tag_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.ShopOuterClass.GiftTagConf
 * JD-Core Version:    0.7.0.1
 */