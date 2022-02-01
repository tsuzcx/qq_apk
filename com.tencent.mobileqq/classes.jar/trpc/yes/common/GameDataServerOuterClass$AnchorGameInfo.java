package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameDataServerOuterClass$AnchorGameInfo
  extends MessageMicro<AnchorGameInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "title", "desc", "hero_url_list", "url" }, new Object[] { "", "", "", "" }, AnchorGameInfo.class);
  public final PBStringField desc = PBField.initString("");
  public final PBRepeatField<String> hero_url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField title = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.AnchorGameInfo
 * JD-Core Version:    0.7.0.1
 */