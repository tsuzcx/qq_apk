package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomGameResultLikeCmd
  extends MessageMicro<YoloRoomGameResultLikeCmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "msg_id", "to_uid", "is_need_send_msg" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0) }, YoloRoomGameResultLikeCmd.class);
  public final PBInt32Field is_need_send_msg = PBField.initInt32(0);
  public final PBStringField msg_id = PBField.initString("");
  public final PBUInt64Field to_uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomGameResultLikeCmd
 * JD-Core Version:    0.7.0.1
 */