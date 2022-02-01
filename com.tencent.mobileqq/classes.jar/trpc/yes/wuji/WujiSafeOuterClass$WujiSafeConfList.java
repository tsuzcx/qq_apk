package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WujiSafeOuterClass$WujiSafeConfList
  extends MessageMicro<WujiSafeConfList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { null }, WujiSafeConfList.class);
  public final PBRepeatMessageField<WujiSafeOuterClass.WujiSafeConf> data = PBField.initRepeatMessage(WujiSafeOuterClass.WujiSafeConf.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSafeOuterClass.WujiSafeConfList
 * JD-Core Version:    0.7.0.1
 */