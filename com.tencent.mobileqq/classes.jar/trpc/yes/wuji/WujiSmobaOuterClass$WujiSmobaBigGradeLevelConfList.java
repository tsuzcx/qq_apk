package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WujiSmobaOuterClass$WujiSmobaBigGradeLevelConfList
  extends MessageMicro<WujiSmobaBigGradeLevelConfList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { null }, WujiSmobaBigGradeLevelConfList.class);
  public final PBRepeatMessageField<WujiSmobaOuterClass.WujiSmobaBigGradeLevelConf> data = PBField.initRepeatMessage(WujiSmobaOuterClass.WujiSmobaBigGradeLevelConf.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaBigGradeLevelConfList
 * JD-Core Version:    0.7.0.1
 */