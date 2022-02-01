package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WujiSmobaOuterClass$WujiSmobaSkinConfList
  extends MessageMicro<WujiSmobaSkinConfList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { null }, WujiSmobaSkinConfList.class);
  public final PBRepeatMessageField<WujiSmobaOuterClass.WujiSmobaSkinConf> data = PBField.initRepeatMessage(WujiSmobaOuterClass.WujiSmobaSkinConf.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaSkinConfList
 * JD-Core Version:    0.7.0.1
 */