package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WujiSmobaOuterClass$WujiSmobaShowTypeConfList
  extends MessageMicro<WujiSmobaShowTypeConfList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { null }, WujiSmobaShowTypeConfList.class);
  public final PBRepeatMessageField<WujiSmobaOuterClass.WujiSmobaShowTypeConf> data = PBField.initRepeatMessage(WujiSmobaOuterClass.WujiSmobaShowTypeConf.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaShowTypeConfList
 * JD-Core Version:    0.7.0.1
 */