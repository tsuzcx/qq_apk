package tencent.im.oidb.cmd0x487;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x487
{
  public static final class GroupList
    extends MessageMicro<GroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_opt_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_groupcode", "uint64_opt_uin", "bytes_group_name" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, GroupList.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_channel", "uint64_group", "uint64_subscribe_code" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt32Field uint32_channel = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_subscribe_code = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x487.GroupList> msg_groups = PBField.initRepeatMessage(oidb_0x487.GroupList.class);
    public final PBUInt32Field uint32_follow_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_groups_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_privilege_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remind_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56 }, new String[] { "uint32_result", "bytes_errmsg", "msg_groups", "uint32_privilege_flag", "uint32_groups_flag", "uint32_follow_state", "uint32_remind_flag" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x487.oidb_0x487
 * JD-Core Version:    0.7.0.1
 */