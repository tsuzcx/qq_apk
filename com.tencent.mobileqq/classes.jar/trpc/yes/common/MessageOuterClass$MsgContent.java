package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class MessageOuterClass$MsgContent
  extends MessageMicro<MsgContent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 386, 442, 490, 522, 530, 634, 642, 650, 658 }, new String[] { "text_msg", "yolo_room_action_msg", "share_yolo_room_msg", "yolo_room_rotate_msg", "yolo_room_new_data_push_msg", "at_user_msg", "qq_user_info_msg", "gift_msg", "user_info_modify_notify_msg", "anchor_equip_status_notify_msg" }, new Object[] { null, null, null, null, null, null, null, null, null, null }, MsgContent.class);
  public MessageOuterClass.AnchorEquipStatusNotifyMsg anchor_equip_status_notify_msg = new MessageOuterClass.AnchorEquipStatusNotifyMsg();
  public MessageOuterClass.AtUserMsg at_user_msg = new MessageOuterClass.AtUserMsg();
  public MessageOuterClass.GiftMsg gift_msg = new MessageOuterClass.GiftMsg();
  public MessageOuterClass.QQUserInfoMsg qq_user_info_msg = new MessageOuterClass.QQUserInfoMsg();
  public MessageOuterClass.ShareYoloRoomMsg share_yolo_room_msg = new MessageOuterClass.ShareYoloRoomMsg();
  public MessageOuterClass.TextMsg text_msg = new MessageOuterClass.TextMsg();
  public MessageOuterClass.UserInfoModifyNotifyMsg user_info_modify_notify_msg = new MessageOuterClass.UserInfoModifyNotifyMsg();
  public MessageOuterClass.YoloRoomActionMsg yolo_room_action_msg = new MessageOuterClass.YoloRoomActionMsg();
  public MessageOuterClass.YoloRoomNewDataPushMsg yolo_room_new_data_push_msg = new MessageOuterClass.YoloRoomNewDataPushMsg();
  public MessageOuterClass.YoloRoomRotateMsg yolo_room_rotate_msg = new MessageOuterClass.YoloRoomRotateMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.MessageOuterClass.MsgContent
 * JD-Core Version:    0.7.0.1
 */