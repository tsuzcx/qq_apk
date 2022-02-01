package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SmobaDataOuterClass$YoloBattleRoomInfo
  extends MessageMicro<YoloBattleRoomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public SmobaDataOuterClass.RoomBattleInfo battleinfo = new SmobaDataOuterClass.RoomBattleInfo();
  public final PBInt32Field curmemnum = PBField.initInt32(0);
  public final PBInt32Field maxmemnum = PBField.initInt32(0);
  public final PBRepeatMessageField<SmobaDataOuterClass.RoomMemberInfo> memberlist = PBField.initRepeatMessage(SmobaDataOuterClass.RoomMemberInfo.class);
  public SmobaDataOuterClass.RoomID roomid = new SmobaDataOuterClass.RoomID();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "roomid", "curmemnum", "maxmemnum", "memberlist", "battleinfo" }, new Object[] { null, localInteger, localInteger, null, null }, YoloBattleRoomInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.SmobaDataOuterClass.YoloBattleRoomInfo
 * JD-Core Version:    0.7.0.1
 */