package trpc.qq_vgame.activity_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class ActivityCenter$GetActivitysRsp
  extends MessageMicro<GetActivitysRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "res", "icon_url", "red_point", "jump_url" }, new Object[] { null, "", Integer.valueOf(0), "" }, GetActivitysRsp.class);
  public final PBStringField icon_url = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
  public final PBUInt32Field red_point = PBField.initUInt32(0);
  public AvGameCommon.Result res = new AvGameCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.activity_center.ActivityCenter.GetActivitysRsp
 * JD-Core Version:    0.7.0.1
 */