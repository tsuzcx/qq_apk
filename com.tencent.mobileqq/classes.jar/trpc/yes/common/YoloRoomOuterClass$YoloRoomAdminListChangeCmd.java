package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomAdminListChangeCmd
  extends MessageMicro<YoloRoomAdminListChangeCmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "op", "uid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, YoloRoomAdminListChangeCmd.class);
  public final PBInt32Field op = PBField.initInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomAdminListChangeCmd
 * JD-Core Version:    0.7.0.1
 */