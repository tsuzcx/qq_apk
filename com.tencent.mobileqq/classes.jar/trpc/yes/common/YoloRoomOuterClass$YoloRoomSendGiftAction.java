package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomSendGiftAction
  extends MessageMicro<YoloRoomSendGiftAction>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field base_num = PBField.initInt32(0);
  public final PBStringField bill_no = PBField.initString("");
  public final PBStringField client_str = PBField.initString("");
  public final PBUInt32Field combo_cnt = PBField.initUInt32(0);
  public final PBUInt32Field combo_seq = PBField.initUInt32(0);
  public final PBInt32Field gift_id = PBField.initInt32(0);
  public final PBStringField gift_name = PBField.initString("");
  public final PBUInt32Field gift_type = PBField.initUInt32(0);
  public CommonOuterClass.QQUserId recv_user_id = new CommonOuterClass.QQUserId();
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBUInt32Field scene_id = PBField.initUInt32(0);
  public final PBStringField schema = PBField.initString("");
  public CommonOuterClass.QQUserId send_user_id = new CommonOuterClass.QQUserId();
  public final PBInt32Field total_num = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 64, 74, 80, 88, 96, 104, 114 }, new String[] { "send_user_id", "recv_user_id", "gift_id", "total_num", "bill_no", "base_num", "schema", "room_id", "gift_name", "combo_seq", "scene_id", "gift_type", "combo_cnt", "client_str" }, new Object[] { null, null, localInteger, localInteger, "", localInteger, "", Long.valueOf(0L), "", localInteger, localInteger, localInteger, localInteger, "" }, YoloRoomSendGiftAction.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomSendGiftAction
 * JD-Core Version:    0.7.0.1
 */