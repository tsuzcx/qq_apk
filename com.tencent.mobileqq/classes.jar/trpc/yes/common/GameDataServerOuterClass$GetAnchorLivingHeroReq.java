package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameDataServerOuterClass$GetAnchorLivingHeroReq
  extends MessageMicro<GetAnchorLivingHeroReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "anchor_id", "game_id" }, new Object[] { "", Integer.valueOf(0) }, GetAnchorLivingHeroReq.class);
  public final PBStringField anchor_id = PBField.initString("");
  public final PBInt32Field game_id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GetAnchorLivingHeroReq
 * JD-Core Version:    0.7.0.1
 */