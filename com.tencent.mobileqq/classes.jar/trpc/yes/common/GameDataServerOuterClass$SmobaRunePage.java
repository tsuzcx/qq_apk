package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GameDataServerOuterClass$SmobaRunePage
  extends MessageMicro<SmobaRunePage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field rune_page_idx = PBField.initUInt32(0);
  public final PBStringField rune_str = PBField.initString("");
  public final PBRepeatMessageField<GameDataServerOuterClass.SmobaRune> runes = PBField.initRepeatMessage(GameDataServerOuterClass.SmobaRune.class);
  public final PBRepeatMessageField<GameDataServerOuterClass.SmobaCommAttr> total_comm_attr = PBField.initRepeatMessage(GameDataServerOuterClass.SmobaCommAttr.class);
  public final PBInt32Field total_level = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "name", "runes", "rune_page_idx", "total_level", "total_comm_attr", "rune_str" }, new Object[] { "", null, localInteger, localInteger, null, "" }, SmobaRunePage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.SmobaRunePage
 * JD-Core Version:    0.7.0.1
 */