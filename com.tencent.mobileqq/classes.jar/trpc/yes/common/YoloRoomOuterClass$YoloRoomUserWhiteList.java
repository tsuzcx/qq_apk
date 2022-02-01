package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloRoomOuterClass$YoloRoomUserWhiteList
  extends MessageMicro<YoloRoomUserWhiteList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "is_community_host" }, new Object[] { Boolean.valueOf(false) }, YoloRoomUserWhiteList.class);
  public final PBBoolField is_community_host = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomUserWhiteList
 * JD-Core Version:    0.7.0.1
 */