package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UserProxyCmdOuterClass$UserRoomList
  extends MessageMicro<UserRoomList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_room_list" }, new Object[] { null }, UserRoomList.class);
  public final PBRepeatMessageField<UserProxyCmdOuterClass.UserRoom> user_room_list = PBField.initRepeatMessage(UserProxyCmdOuterClass.UserRoom.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.UserRoomList
 * JD-Core Version:    0.7.0.1
 */