package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x2dc
{
  public static final class GroupVisitorJoinMsg
    extends MessageMicro<GroupVisitorJoinMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_group_uin", "uint64_group_code", "rpt_msg_visitor_join_info", "uint32_op_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0) }, GroupVisitorJoinMsg.class);
    public final PBRepeatMessageField<cmd0x2dc.VisitorJoinInfo> rpt_msg_visitor_join_info = PBField.initRepeatMessage(cmd0x2dc.VisitorJoinInfo.class);
    public final PBUInt32Field uint32_op_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  }
  
  public static final class VisitorJoinInfo
    extends MessageMicro<VisitorJoinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_visitor_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_face_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_visitor_uin", "uint32_join_time", "bytes_visitor_name", "uint32_face_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, VisitorJoinInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.group.cmd0x2dc
 * JD-Core Version:    0.7.0.1
 */