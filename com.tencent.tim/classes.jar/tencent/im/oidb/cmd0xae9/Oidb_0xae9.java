package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xae9
{
  public static final class GetAddTimeReq
    extends MessageMicro<GetAddTimeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "group_code" }, new Object[] { Long.valueOf(0L) }, GetAddTimeReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
  }
  
  public static final class GetAddTimeRsp
    extends MessageMicro<GetAddTimeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "timestamp" }, new Object[] { Long.valueOf(0L) }, GetAddTimeRsp.class);
    public final PBUInt64Field timestamp = PBField.initUInt64(0L);
  }
  
  public static final class GetListReq
    extends MessageMicro<GetListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_code", "start", "limit" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetListReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class GetListRsp
    extends MessageMicro<GetListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "doc_list", "next" }, new Object[] { null, Integer.valueOf(0) }, GetListRsp.class);
    public final PBRepeatMessageField<group_online_docs.DocInfo> doc_list = PBField.initRepeatMessage(group_online_docs.DocInfo.class);
    public final PBUInt32Field next = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "get_list_req", "get_add_time_req" }, new Object[] { null, null }, ReqBody.class);
    public Oidb_0xae9.GetAddTimeReq get_add_time_req = new Oidb_0xae9.GetAddTimeReq();
    public Oidb_0xae9.GetListReq get_list_req = new Oidb_0xae9.GetListReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "get_list_rsp", "get_add_time_rsp" }, new Object[] { null, null }, RspBody.class);
    public Oidb_0xae9.GetAddTimeRsp get_add_time_rsp = new Oidb_0xae9.GetAddTimeRsp();
    public Oidb_0xae9.GetListRsp get_list_rsp = new Oidb_0xae9.GetListRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xae9.Oidb_0xae9
 * JD-Core Version:    0.7.0.1
 */