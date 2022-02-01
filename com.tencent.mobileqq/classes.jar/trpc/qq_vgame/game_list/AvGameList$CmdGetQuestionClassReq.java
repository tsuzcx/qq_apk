package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameList$CmdGetQuestionClassReq
  extends MessageMicro<CmdGetQuestionClassReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "roomid", "game_type_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, CmdGetQuestionClassReq.class);
  public final PBRepeatField<Integer> game_type_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.game_list.AvGameList.CmdGetQuestionClassReq
 * JD-Core Version:    0.7.0.1
 */