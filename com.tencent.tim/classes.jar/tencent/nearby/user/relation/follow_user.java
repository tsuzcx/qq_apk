package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.nearby.common.nearby_common.ErrorInfo;

public final class follow_user
{
  public static final class FollowUserReq
    extends MessageMicro<FollowUserReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uin", "dst_uin", "follow_type", "source" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1) }, FollowUserReq.class);
    public final PBUInt64Field dst_uin = PBField.initUInt64(0L);
    public final PBEnumField follow_type = PBField.initEnum(0);
    public final PBEnumField source = PBField.initEnum(1);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class FollowUserRsp
    extends MessageMicro<FollowUserRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uin", "dst_uin", "result" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null }, FollowUserRsp.class);
    public final PBUInt64Field dst_uin = PBField.initUInt64(0L);
    public nearby_common.ErrorInfo result = new nearby_common.ErrorInfo();
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.nearby.user.relation.follow_user
 * JD-Core Version:    0.7.0.1
 */