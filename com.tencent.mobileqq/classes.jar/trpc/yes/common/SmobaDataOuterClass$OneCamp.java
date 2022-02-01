package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SmobaDataOuterClass$OneCamp
  extends MessageMicro<OneCamp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "npc_camp", "camp_players" }, new Object[] { Integer.valueOf(0), null }, OneCamp.class);
  public final PBRepeatMessageField<SmobaDataOuterClass.CampPlayerInfo> camp_players = PBField.initRepeatMessage(SmobaDataOuterClass.CampPlayerInfo.class);
  public final PBInt32Field npc_camp = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.SmobaDataOuterClass.OneCamp
 * JD-Core Version:    0.7.0.1
 */