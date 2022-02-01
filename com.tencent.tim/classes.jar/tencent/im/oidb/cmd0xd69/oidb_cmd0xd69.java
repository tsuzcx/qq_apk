package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xd69
{
  public static final class CheckReqBody
    extends MessageMicro<CheckReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "doubt_uin" }, new Object[] { Long.valueOf(0L) }, CheckReqBody.class);
    public final PBUInt64Field doubt_uin = PBField.initUInt64(0L);
  }
  
  public static final class CheckRspBody
    extends MessageMicro<CheckRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "is_exsit" }, new Object[] { Integer.valueOf(0) }, CheckRspBody.class);
    public final PBUInt32Field is_exsit = PBField.initUInt32(0);
  }
  
  public static final class DeleteReqBody
    extends MessageMicro<DeleteReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "doubt_uin" }, new Object[] { Long.valueOf(0L) }, DeleteReqBody.class);
    public final PBUInt64Field doubt_uin = PBField.initUInt64(0L);
  }
  
  public static final class DoubtInfo
    extends MessageMicro<DoubtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name_more = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_source = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comm_frd_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 64, 72, 80, 90, 98, 106 }, new String[] { "uint64_uin", "bytes_nick", "uint32_age", "uint32_sex", "bytes_msg", "bytes_source", "bytes_reason", "uint32_time", "uint64_group", "uint32_comm_frd_num", "bytes_name_more", "bytes_city", "bytes_session_key" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, DoubtInfo.class);
    }
  }
  
  public static final class GetListReqBody
    extends MessageMicro<GetListReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field req_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "req_num", "bytes_cookies" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GetListReqBody.class);
    }
  }
  
  public static final class GetListRspBody
    extends MessageMicro<GetListRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0xd69.DoubtInfo> rpt_msg_list = PBField.initRepeatMessage(oidb_cmd0xd69.DoubtInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_list", "bytes_cookies" }, new Object[] { null, localByteStringMicro }, GetListRspBody.class);
    }
  }
  
  public static final class GetUnreadNumRspBody
    extends MessageMicro<GetUnreadNumRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "doubt_unread_num" }, new Object[] { Integer.valueOf(0) }, GetUnreadNumRspBody.class);
    public final PBUInt32Field doubt_unread_num = PBField.initUInt32(0);
  }
  
  public static final class ReportRspBody
    extends MessageMicro<ReportRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_read_time" }, new Object[] { Integer.valueOf(0) }, ReportRspBody.class);
    public final PBUInt32Field uint32_read_time = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "cmd_type", "msg_get_list_body", "msg_delete_body", "msg_check_body" }, new Object[] { Integer.valueOf(1), null, null, null }, ReqBody.class);
    public final PBEnumField cmd_type = PBField.initEnum(1);
    public oidb_cmd0xd69.CheckReqBody msg_check_body = new oidb_cmd0xd69.CheckReqBody();
    public oidb_cmd0xd69.DeleteReqBody msg_delete_body = new oidb_cmd0xd69.DeleteReqBody();
    public oidb_cmd0xd69.GetListReqBody msg_get_list_body = new oidb_cmd0xd69.GetListReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "cmd_type", "msg_get_list_body", "msg_get_unread_num_body", "msg_report_body", "msg_check_body" }, new Object[] { Integer.valueOf(1), null, null, null, null }, RspBody.class);
    public final PBEnumField cmd_type = PBField.initEnum(1);
    public oidb_cmd0xd69.CheckRspBody msg_check_body = new oidb_cmd0xd69.CheckRspBody();
    public oidb_cmd0xd69.GetListRspBody msg_get_list_body = new oidb_cmd0xd69.GetListRspBody();
    public oidb_cmd0xd69.GetUnreadNumRspBody msg_get_unread_num_body = new oidb_cmd0xd69.GetUnreadNumRspBody();
    public oidb_cmd0xd69.ReportRspBody msg_report_body = new oidb_cmd0xd69.ReportRspBody();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd69.oidb_cmd0xd69
 * JD-Core Version:    0.7.0.1
 */