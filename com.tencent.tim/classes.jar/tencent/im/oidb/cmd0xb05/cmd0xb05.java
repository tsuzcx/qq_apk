package tencent.im.oidb.cmd0xb05;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;
import tencent.im.oidb.cmd0xae9.online_docs.DocInfo;
import tencent.im.oidb.cmd0xae9.online_docs.DocMetaData;

public final class cmd0xb05
{
  public static final class CreateReq
    extends MessageMicro<CreateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field create_source = PBField.initUInt32(0);
    public final PBUInt32Field create_type = PBField.initUInt32(0);
    public online_docs.DocId doc_id = new online_docs.DocId();
    public final PBUInt32Field doc_status = PBField.initUInt32(0);
    public final PBUInt32Field doc_type = PBField.initUInt32(0);
    public final PBUInt32Field template_id = PBField.initUInt32(0);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56 }, new String[] { "title", "doc_type", "create_type", "template_id", "doc_status", "doc_id", "create_source" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, CreateReq.class);
    }
  }
  
  public static final class CreateRsp
    extends MessageMicro<CreateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public online_docs.DocId doc_id = new online_docs.DocId();
    public final PBBytesField doc_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "doc_id", "doc_url" }, new Object[] { null, localByteStringMicro }, CreateRsp.class);
    }
  }
  
  public static final class DeleteReq
    extends MessageMicro<DeleteReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "doc_id" }, new Object[] { null }, DeleteReq.class);
    public online_docs.DocId doc_id = new online_docs.DocId();
  }
  
  public static final class DeleteRsp
    extends MessageMicro<DeleteRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], DeleteRsp.class);
  }
  
  public static final class ListReq
    extends MessageMicro<ListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "start", "limit", "fetch_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ListReq.class);
    public final PBUInt32Field fetch_type = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class ListRsp
    extends MessageMicro<ListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "doc_info", "next" }, new Object[] { null, Integer.valueOf(0) }, ListRsp.class);
    public final PBRepeatMessageField<online_docs.DocInfo> doc_info = PBField.initRepeatMessage(online_docs.DocInfo.class);
    public final PBUInt32Field next = PBField.initUInt32(0);
  }
  
  public static final class QueryReq
    extends MessageMicro<QueryReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "doc_id_list", "query_type" }, new Object[] { null, Integer.valueOf(0) }, QueryReq.class);
    public final PBRepeatMessageField<online_docs.DocId> doc_id_list = PBField.initRepeatMessage(online_docs.DocId.class);
    public final PBUInt32Field query_type = PBField.initUInt32(0);
  }
  
  public static final class QueryRsp
    extends MessageMicro<QueryRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "doc_info" }, new Object[] { null }, QueryRsp.class);
    public final PBRepeatMessageField<online_docs.DocInfo> doc_info = PBField.initRepeatMessage(online_docs.DocInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 34, 42, 50, 58 }, new String[] { "delete_req", "list_req", "update_req", "create_req", "query_req" }, new Object[] { null, null, null, null, null }, ReqBody.class);
    public cmd0xb05.CreateReq create_req = new cmd0xb05.CreateReq();
    public cmd0xb05.DeleteReq delete_req = new cmd0xb05.DeleteReq();
    public cmd0xb05.ListReq list_req = new cmd0xb05.ListReq();
    public cmd0xb05.QueryReq query_req = new cmd0xb05.QueryReq();
    public cmd0xb05.UpdateReq update_req = new cmd0xb05.UpdateReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 34, 42, 50, 58 }, new String[] { "delete_rsp", "list_rsp", "update_rsp", "create_rsp", "query_rsp" }, new Object[] { null, null, null, null, null }, RspBody.class);
    public cmd0xb05.CreateRsp create_rsp = new cmd0xb05.CreateRsp();
    public cmd0xb05.DeleteRsp delete_rsp = new cmd0xb05.DeleteRsp();
    public cmd0xb05.ListRsp list_rsp = new cmd0xb05.ListRsp();
    public cmd0xb05.QueryRsp query_rsp = new cmd0xb05.QueryRsp();
    public cmd0xb05.UpdateRsp update_rsp = new cmd0xb05.UpdateRsp();
  }
  
  public static final class UpdateReq
    extends MessageMicro<UpdateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "doc_meta", "update_flag" }, new Object[] { null, Long.valueOf(0L) }, UpdateReq.class);
    public online_docs.DocMetaData doc_meta = new online_docs.DocMetaData();
    public final PBUInt64Field update_flag = PBField.initUInt64(0L);
  }
  
  public static final class UpdateRsp
    extends MessageMicro<UpdateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], UpdateRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb05.cmd0xb05
 * JD-Core Version:    0.7.0.1
 */