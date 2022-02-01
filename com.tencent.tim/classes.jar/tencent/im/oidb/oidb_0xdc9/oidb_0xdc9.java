package tencent.im.oidb.oidb_0xdc9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdc9
{
  public static final class GroupUser
    extends MessageMicro<GroupUser>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GroupUser.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class HonorInfo
    extends MessageMicro<HonorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "id", "achieve", "day_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, HonorInfo.class);
    public final PBUInt32Field achieve = PBField.initUInt32(0);
    public final PBUInt32Field day_count = PBField.initUInt32(0);
    public final PBUInt32Field id = PBField.initUInt32(0);
  }
  
  public static final class HonorList
    extends MessageMicro<HonorList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_id", "id", "is_gray" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, HonorList.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBRepeatField<Integer> id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field is_gray = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "group_id", "group_user" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
    public final PBRepeatField<Long> group_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public oidb_0xdc9.GroupUser group_user = new oidb_0xdc9.GroupUser();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "honor_list", "cache_ts", "honor_info" }, new Object[] { null, Integer.valueOf(0), null }, RspBody.class);
    public final PBUInt32Field cache_ts = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xdc9.HonorInfo> honor_info = PBField.initRepeatMessage(oidb_0xdc9.HonorInfo.class);
    public final PBRepeatMessageField<oidb_0xdc9.HonorList> honor_list = PBField.initRepeatMessage(oidb_0xdc9.HonorList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xdc9.oidb_0xdc9
 * JD-Core Version:    0.7.0.1
 */