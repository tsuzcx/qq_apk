package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGamePlay$StartGameReq
  extends MessageMicro<StartGameReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64, 72 }, new String[] { "uin", "roomid", "type", "question_class", "pk_id", "scene_type", "pk_round", "game_mode", "trans_mod" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StartGameReq.class);
  public final PBUInt32Field game_mode = PBField.initUInt32(0);
  public final PBUInt32Field pk_id = PBField.initUInt32(0);
  public final PBUInt32Field pk_round = PBField.initUInt32(0);
  public final PBStringField question_class = PBField.initString("");
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBEnumField scene_type = PBField.initEnum(0);
  public final PBUInt32Field trans_mod = PBField.initUInt32(0);
  public final PBEnumField type = PBField.initEnum(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.playgame.AvGamePlay.StartGameReq
 * JD-Core Version:    0.7.0.1
 */