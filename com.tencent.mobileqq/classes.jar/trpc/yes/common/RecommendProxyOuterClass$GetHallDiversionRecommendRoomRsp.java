package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class RecommendProxyOuterClass$GetHallDiversionRecommendRoomRsp
  extends MessageMicro<GetHallDiversionRecommendRoomRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "enter_room_rsp", "white_flag", "room_list" }, new Object[] { null, Integer.valueOf(0), null }, GetHallDiversionRecommendRoomRsp.class);
  public YoloRoomOuterClass.YoloRoomEnterRsp enter_room_rsp = new YoloRoomOuterClass.YoloRoomEnterRsp();
  public final PBRepeatMessageField<RecommendProxyOuterClass.KuolieRoomInfo> room_list = PBField.initRepeatMessage(RecommendProxyOuterClass.KuolieRoomInfo.class);
  public final PBInt32Field white_flag = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.RecommendProxyOuterClass.GetHallDiversionRecommendRoomRsp
 * JD-Core Version:    0.7.0.1
 */