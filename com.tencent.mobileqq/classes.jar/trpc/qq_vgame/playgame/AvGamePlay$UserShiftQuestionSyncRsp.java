package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGamePlay$UserShiftQuestionSyncRsp
  extends MessageMicro<UserShiftQuestionSyncRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "seq", "res" }, new Object[] { Long.valueOf(0L), null }, UserShiftQuestionSyncRsp.class);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBUInt64Field seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.playgame.AvGamePlay.UserShiftQuestionSyncRsp
 * JD-Core Version:    0.7.0.1
 */