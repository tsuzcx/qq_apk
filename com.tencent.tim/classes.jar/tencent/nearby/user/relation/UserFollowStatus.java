package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.nearby.common.nearby_common.ErrorInfo;

public final class UserFollowStatus
{
  public static final class UserFollowStatusInfo
    extends MessageMicro<UserFollowStatusInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "dst_uin", "follow_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, UserFollowStatusInfo.class);
    public final PBUInt64Field dst_uin = PBField.initUInt64(0L);
    public final PBEnumField follow_status = PBField.initEnum(0);
  }
  
  public static final class UserFollowStatusReq
    extends MessageMicro<UserFollowStatusReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "dst_uin_list" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, UserFollowStatusReq.class);
    public final PBRepeatField<Long> dst_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class UserFollowStatusRsp
    extends MessageMicro<UserFollowStatusRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uin", "follow_status_info_list", "result" }, new Object[] { Long.valueOf(0L), null, null }, UserFollowStatusRsp.class);
    public final PBRepeatMessageField<UserFollowStatus.UserFollowStatusInfo> follow_status_info_list = PBField.initRepeatMessage(UserFollowStatus.UserFollowStatusInfo.class);
    public nearby_common.ErrorInfo result = new nearby_common.ErrorInfo();
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.nearby.user.relation.UserFollowStatus
 * JD-Core Version:    0.7.0.1
 */