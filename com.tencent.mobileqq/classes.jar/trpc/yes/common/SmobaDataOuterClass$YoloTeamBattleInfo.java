package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SmobaDataOuterClass$YoloTeamBattleInfo
  extends MessageMicro<YoloTeamBattleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field iswarmbattle = PBField.initUInt32(0);
  public final PBUInt32Field mapacntnum = PBField.initUInt32(0);
  public final PBUInt32Field mapid = PBField.initUInt32(0);
  public final PBUInt32Field maptype = PBField.initUInt32(0);
  public final PBUInt32Field pkai = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "mapacntnum", "maptype", "mapid", "pkai", "iswarmbattle" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger }, YoloTeamBattleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.SmobaDataOuterClass.YoloTeamBattleInfo
 * JD-Core Version:    0.7.0.1
 */