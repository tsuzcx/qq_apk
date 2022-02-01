package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xccb
{
  public static final class C2cMsgInfo
    extends MessageMicro<C2cMsgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "msg_seq", "msg_time", "msg_random", "roam_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, C2cMsgInfo.class);
    public final PBUInt32Field msg_random = PBField.initUInt32(0);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_time = PBField.initUInt32(0);
    public final PBUInt32Field roam_flag = PBField.initUInt32(0);
  }
  
  public static final class GroupMsgInfo
    extends MessageMicro<GroupMsgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "msg_seq", "roam_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GroupMsgInfo.class);
    public final PBUInt32Field msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field roam_flag = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56 }, new String[] { "type", "dest_uin", "group_code", "c2c_msg", "group_msg", "c2c_type", "service_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBRepeatMessageField<cmd0xccb.C2cMsgInfo> c2c_msg = PBField.initRepeatMessage(cmd0xccb.C2cMsgInfo.class);
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt64Field dest_uin = PBField.initUInt64(0L);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBRepeatMessageField<cmd0xccb.GroupMsgInfo> group_msg = PBField.initRepeatMessage(cmd0xccb.GroupMsgInfo.class);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<cmd0xccb.C2cMsgInfo> c2c_msg = PBField.initRepeatMessage(cmd0xccb.C2cMsgInfo.class);
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt64Field dest_uin = PBField.initUInt64(0L);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBRepeatMessageField<cmd0xccb.GroupMsgInfo> group_msg = PBField.initRepeatMessage(cmd0xccb.GroupMsgInfo.class);
    public final PBBytesField res_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 56, 64 }, new String[] { "type", "dest_uin", "group_code", "c2c_msg", "group_msg", "res_id", "c2c_type", "service_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xccb
 * JD-Core Version:    0.7.0.1
 */