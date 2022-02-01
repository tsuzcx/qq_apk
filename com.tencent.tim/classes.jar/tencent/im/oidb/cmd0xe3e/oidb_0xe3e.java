package tencent.im.oidb.cmd0xe3e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe3e
{
  public static final class GroupList
    extends MessageMicro<GroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_group_code", "uint32_common_friend_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GroupList.class);
    public final PBUInt32Field uint32_common_friend_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_friend_uin" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0L);
  }
  
  public static final class ResvAttr
    extends MessageMicro<ResvAttr>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_friend_banned_flag", "uint32_gray_tips_from" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ResvAttr.class);
    public final PBUInt32Field uint32_friend_banned_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gray_tips_from = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_cache_time_seconds", "rpt_group_list" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xe3e.GroupList> rpt_group_list = PBField.initRepeatMessage(oidb_0xe3e.GroupList.class);
    public final PBUInt32Field uint32_cache_time_seconds = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe3e.oidb_0xe3e
 * JD-Core Version:    0.7.0.1
 */