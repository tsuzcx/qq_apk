package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class RecommendProxyOuterClass$GetTopKuolieRoomListRsp
  extends MessageMicro<GetTopKuolieRoomListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "room_list" }, new Object[] { null }, GetTopKuolieRoomListRsp.class);
  public final PBRepeatMessageField<RecommendProxyOuterClass.KuolieRoomInfo> room_list = PBField.initRepeatMessage(RecommendProxyOuterClass.KuolieRoomInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.RecommendProxyOuterClass.GetTopKuolieRoomListRsp
 * JD-Core Version:    0.7.0.1
 */