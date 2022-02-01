package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloBattleSmobaOuterClass$YoloSmobaBattleEntity
  extends MessageMicro<YoloSmobaBattleEntity>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field desk_id = PBField.initUInt32(0);
  public final PBUInt32Field desk_seq = PBField.initUInt32(0);
  public final PBUInt32Field relay_entity = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "desk_id", "relay_entity", "desk_seq" }, new Object[] { localInteger, localInteger, localInteger }, YoloSmobaBattleEntity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaBattleEntity
 * JD-Core Version:    0.7.0.1
 */