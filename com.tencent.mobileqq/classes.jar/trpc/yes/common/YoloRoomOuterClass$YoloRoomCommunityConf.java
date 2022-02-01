package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf;

public final class YoloRoomOuterClass$YoloRoomCommunityConf
  extends MessageMicro<YoloRoomCommunityConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "wuji_yolo_room_community_conf", "add_friend_tips_text_list" }, new Object[] { null, "" }, YoloRoomCommunityConf.class);
  public final PBRepeatField<String> add_friend_tips_text_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf wuji_yolo_room_community_conf = new WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomCommunityConf
 * JD-Core Version:    0.7.0.1
 */