package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloRoomOuterClass$YoloRoomAdminListChangeAction
  extends MessageMicro<YoloRoomAdminListChangeAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "op", "user_id" }, new Object[] { Integer.valueOf(0), null }, YoloRoomAdminListChangeAction.class);
  public final PBInt32Field op = PBField.initInt32(0);
  public CommonOuterClass.QQUserId user_id = new CommonOuterClass.QQUserId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomAdminListChangeAction
 * JD-Core Version:    0.7.0.1
 */