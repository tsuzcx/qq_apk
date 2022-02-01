package tencent.im.oidb.cmd0x897;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x897
{
  public static final class GroupNextVisitor
    extends MessageMicro<GroupNextVisitor>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48 }, new String[] { "msg_group_uin_code", "uint64_next_visitor", "msg_req_field", "uint32_max_count", "uint32_administrator_field", "uint32_guest_field" }, new Object[] { null, Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupNextVisitor.class);
    public cmd0x897.GroupUinCode msg_group_uin_code = new cmd0x897.GroupUinCode();
    public cmd0x897.VisitorInfo msg_req_field = new cmd0x897.VisitorInfo();
    public final PBUInt32Field uint32_administrator_field = PBField.initUInt32(0);
    public final PBUInt32Field uint32_guest_field = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_next_visitor = PBField.initUInt64(0L);
  }
  
  public static final class GroupUinCode
    extends MessageMicro<GroupUinCode>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_group_uin", "uint64_group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, GroupUinCode.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  }
  
  public static final class GroupVisitorInfo
    extends MessageMicro<GroupVisitorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_group_next_visitor", "uint32_flag", "rpt_msg_visitor_info" }, new Object[] { null, Integer.valueOf(0), null }, GroupVisitorInfo.class);
    public cmd0x897.GroupNextVisitor msg_group_next_visitor = new cmd0x897.GroupNextVisitor();
    public final PBRepeatMessageField<cmd0x897.VisitorInfo> rpt_msg_visitor_info = PBField.initRepeatMessage(cmd0x897.VisitorInfo.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_grp_next_visitor" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<cmd0x897.GroupNextVisitor> rpt_msg_grp_next_visitor = PBField.initRepeatMessage(cmd0x897.GroupNextVisitor.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "rpt_msg_grp_visitor_info", "str_err_msg" }, new Object[] { Integer.valueOf(0), null, "" }, RspBody.class);
    public final PBRepeatMessageField<cmd0x897.GroupVisitorInfo> rpt_msg_grp_visitor_info = PBField.initRepeatMessage(cmd0x897.GroupVisitorInfo.class);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
  
  public static final class VisitorInfo
    extends MessageMicro<VisitorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_visitor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_guest_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_role = PBField.initUInt32(0);
    public final PBUInt32Field uint32_visitor_faceid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_visitor_uin", "uint32_visitor_faceid", "string_visitor_nick", "uint32_role", "uint32_guest_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, VisitorInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x897.cmd0x897
 * JD-Core Version:    0.7.0.1
 */