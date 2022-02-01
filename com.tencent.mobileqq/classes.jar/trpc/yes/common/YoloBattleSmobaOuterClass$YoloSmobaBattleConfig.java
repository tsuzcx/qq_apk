package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloBattleSmobaOuterClass$YoloSmobaBattleConfig
  extends MessageMicro<YoloSmobaBattleConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field camp_add_type = PBField.initInt32(0);
  public final PBInt32Field create_type = PBField.initInt32(0);
  public final PBInt32Field game_mode = PBField.initInt32(0);
  public final PBInt32Field server_id = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "create_type", "game_mode", "server_id", "camp_add_type" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, YoloSmobaBattleConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaBattleConfig
 * JD-Core Version:    0.7.0.1
 */