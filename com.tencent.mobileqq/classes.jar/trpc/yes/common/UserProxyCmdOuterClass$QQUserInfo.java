package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UserProxyCmdOuterClass$QQUserInfo
  extends MessageMicro<QQUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field auth_status = PBField.initInt32(0);
  public GameDataServerOuterClass.SmobaGameRoleInfo defaul_smoba_role = new GameDataServerOuterClass.SmobaGameRoleInfo();
  public final PBInt32Field friend_switch = PBField.initInt32(0);
  public UserProxyCmdOuterClass.UserGameOpenid game_openid = new UserProxyCmdOuterClass.UserGameOpenid();
  public UserProxyCmdOuterClass.QQGroupProInfo group_pro_info = new UserProxyCmdOuterClass.QQGroupProInfo();
  public UserProxyCmdOuterClass.MiniInfo mini_info = new UserProxyCmdOuterClass.MiniInfo();
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public UserProxyCmdOuterClass.UserRoomList user_room_list = new UserProxyCmdOuterClass.UserRoomList();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 64 }, new String[] { "uid", "mini_info", "game_openid", "auth_status", "defaul_smoba_role", "user_room_list", "group_pro_info", "friend_switch" }, new Object[] { Long.valueOf(0L), null, null, localInteger, null, null, null, localInteger }, QQUserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.QQUserInfo
 * JD-Core Version:    0.7.0.1
 */