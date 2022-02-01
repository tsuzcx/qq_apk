package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameDataServerOuterClass$SmobaRune
  extends MessageMicro<SmobaRune>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<String> cate = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatMessageField<GameDataServerOuterClass.SmobaCommAttr> comm_attr = PBField.initRepeatMessage(GameDataServerOuterClass.SmobaCommAttr.class);
  public final PBStringField icon = PBField.initString("");
  public final PBInt32Field level = PBField.initInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBInt32Field rune_id = PBField.initInt32(0);
  public final PBStringField title = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 66 }, new String[] { "rune_id", "title", "name", "cate", "level", "comm_attr", "num", "icon" }, new Object[] { localInteger, "", "", "", localInteger, null, localInteger, "" }, SmobaRune.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.SmobaRune
 * JD-Core Version:    0.7.0.1
 */