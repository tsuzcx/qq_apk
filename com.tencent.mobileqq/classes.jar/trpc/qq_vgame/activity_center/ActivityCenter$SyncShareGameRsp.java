package trpc.qq_vgame.activity_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class ActivityCenter$SyncShareGameRsp
  extends MessageMicro<SyncShareGameRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "res", "jump_url" }, new Object[] { null, "" }, SyncShareGameRsp.class);
  public final PBStringField jump_url = PBField.initString("");
  public AvGameCommon.Result res = new AvGameCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.activity_center.ActivityCenter.SyncShareGameRsp
 * JD-Core Version:    0.7.0.1
 */