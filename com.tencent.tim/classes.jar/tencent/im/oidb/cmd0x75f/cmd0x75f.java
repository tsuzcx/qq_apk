package tencent.im.oidb.cmd0x75f;

import QTimedMessage.QTimedMessage.Message;
import QTimedMessage.QTimedMessage.User;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x75f
{
  public static final class AddBatchReq
    extends MessageMicro<AddBatchReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_messages" }, new Object[] { null }, AddBatchReq.class);
    public final PBRepeatMessageField<QTimedMessage.Message> rpt_messages = PBField.initRepeatMessage(QTimedMessage.Message.class);
  }
  
  public static final class AddBatchRsp
    extends MessageMicro<AddBatchRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_messages", "rpt_failures" }, new Object[] { null, null }, AddBatchRsp.class);
    public final PBRepeatMessageField<QTimedMessage.Message> rpt_failures = PBField.initRepeatMessage(QTimedMessage.Message.class);
    public final PBRepeatMessageField<QTimedMessage.Message> rpt_messages = PBField.initRepeatMessage(QTimedMessage.Message.class);
  }
  
  public static final class AddReq
    extends MessageMicro<AddReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_message" }, new Object[] { null }, AddReq.class);
    public QTimedMessage.Message msg_message = new QTimedMessage.Message();
  }
  
  public static final class AddRsp
    extends MessageMicro<AddRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_message" }, new Object[] { null }, AddRsp.class);
    public QTimedMessage.Message msg_message = new QTimedMessage.Message();
  }
  
  public static final class DeleteReq
    extends MessageMicro<DeleteReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_msg_id" }, new Object[] { localByteStringMicro }, DeleteReq.class);
    }
  }
  
  public static final class DeleteRsp
    extends MessageMicro<DeleteRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_msg_id" }, new Object[] { localByteStringMicro }, DeleteRsp.class);
    }
  }
  
  public static final class GetListReq
    extends MessageMicro<GetListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "msg_owner", "uint64_end_time", "uint32_main_type", "rpt_uint32_sub_type" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetListReq.class);
    public QTimedMessage.User msg_owner = new QTimedMessage.User();
    public final PBRepeatField<Integer> rpt_uint32_sub_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  }
  
  public static final class GetListRsp
    extends MessageMicro<GetListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "msg_owner", "uint64_start_time", "uint64_end_time", "rpt_messages" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), null }, GetListRsp.class);
    public QTimedMessage.User msg_owner = new QTimedMessage.User();
    public final PBRepeatMessageField<QTimedMessage.Message> rpt_messages = PBField.initRepeatMessage(QTimedMessage.Message.class);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
  }
  
  public static final class GetOneReq
    extends MessageMicro<GetOneReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_msg_id" }, new Object[] { localByteStringMicro }, GetOneReq.class);
    }
  }
  
  public static final class GetOneRsp
    extends MessageMicro<GetOneRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_message" }, new Object[] { null }, GetOneRsp.class);
    public QTimedMessage.Message msg_message = new QTimedMessage.Message();
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66 }, new String[] { "uint64_appid", "uint32_subcmd", "msg_add_req", "msg_delete_req", "msg_get_list_req", "msg_update_req", "msg_get_one_req", "msg_add_batch_req" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, null, null, null, null }, ReqBody.class);
    public cmd0x75f.AddBatchReq msg_add_batch_req = new cmd0x75f.AddBatchReq();
    public cmd0x75f.AddReq msg_add_req = new cmd0x75f.AddReq();
    public cmd0x75f.DeleteReq msg_delete_req = new cmd0x75f.DeleteReq();
    public cmd0x75f.GetListReq msg_get_list_req = new cmd0x75f.GetListReq();
    public cmd0x75f.GetOneReq msg_get_one_req = new cmd0x75f.GetOneReq();
    public cmd0x75f.UpdateReq msg_update_req = new cmd0x75f.UpdateReq();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66 }, new String[] { "uint64_appid", "uint32_subcmd", "msg_add_rsp", "msg_delete_rsp", "msg_get_list_rsp", "msg_update_rsp", "msg_get_one_rsp", "msg_add_batch_rsp" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, null, null, null, null }, RspBody.class);
    public cmd0x75f.AddBatchRsp msg_add_batch_rsp = new cmd0x75f.AddBatchRsp();
    public cmd0x75f.AddRsp msg_add_rsp = new cmd0x75f.AddRsp();
    public cmd0x75f.DeleteRsp msg_delete_rsp = new cmd0x75f.DeleteRsp();
    public cmd0x75f.GetListRsp msg_get_list_rsp = new cmd0x75f.GetListRsp();
    public cmd0x75f.GetOneRsp msg_get_one_rsp = new cmd0x75f.GetOneRsp();
    public cmd0x75f.UpdateRsp msg_update_rsp = new cmd0x75f.UpdateRsp();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
  }
  
  public static final class UpdateReq
    extends MessageMicro<UpdateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_message" }, new Object[] { null }, UpdateReq.class);
    public QTimedMessage.Message msg_message = new QTimedMessage.Message();
  }
  
  public static final class UpdateRsp
    extends MessageMicro<UpdateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], UpdateRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75f.cmd0x75f
 * JD-Core Version:    0.7.0.1
 */