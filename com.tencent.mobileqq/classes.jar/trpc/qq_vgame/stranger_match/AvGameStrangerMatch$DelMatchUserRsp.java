package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameStrangerMatch$DelMatchUserRsp
  extends MessageMicro<DelMatchUserRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "res" }, new Object[] { null }, DelMatchUserRsp.class);
  public AvGameCommon.Result res = new AvGameCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameStrangerMatch.DelMatchUserRsp
 * JD-Core Version:    0.7.0.1
 */