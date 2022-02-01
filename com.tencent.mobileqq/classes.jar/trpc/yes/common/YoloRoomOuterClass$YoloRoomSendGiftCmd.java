package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloRoomOuterClass$YoloRoomSendGiftCmd
  extends MessageMicro<YoloRoomSendGiftCmd>
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
  public final PBUInt32Field scene_id = PBField.initUInt32(0);
  public final PBInt32Field total_num = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64, 74, 80, 90 }, new String[] { "recv_user_id", "gift_id", "total_num", "bill_no", "base_num", "combo_seq", "scene_id", "gift_type", "gift_name", "combo_cnt", "client_str" }, new Object[] { null, localInteger, localInteger, "", localInteger, localInteger, localInteger, localInteger, "", localInteger, "" }, YoloRoomSendGiftCmd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomSendGiftCmd
 * JD-Core Version:    0.7.0.1
 */