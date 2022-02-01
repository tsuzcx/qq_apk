package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x435
{
  public static final class AddTopicReqBody
    extends MessageMicro<AddTopicReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_topic_info" }, new Object[] { null }, AddTopicReqBody.class);
    public oidb_0x435.TopicInfo msg_topic_info = new oidb_0x435.TopicInfo();
  }
  
  public static final class AddTopicRspBody
    extends MessageMicro<AddTopicRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_topic_info" }, new Object[] { null }, AddTopicRspBody.class);
    public oidb_0x435.TopicInfo msg_topic_info = new oidb_0x435.TopicInfo();
  }
  
  public static final class AddVoteReqBody
    extends MessageMicro<AddVoteReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_pk_item_id", "rpt_msg_vote_item" }, new Object[] { Integer.valueOf(0), null }, AddVoteReqBody.class);
    public final PBRepeatMessageField<oidb_0x435.VoteItem> rpt_msg_vote_item = PBField.initRepeatMessage(oidb_0x435.VoteItem.class);
    public final PBUInt32Field uint32_pk_item_id = PBField.initUInt32(0);
  }
  
  public static final class AddVoteRspBody
    extends MessageMicro<AddVoteRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AddVoteRspBody.class);
  }
  
  public static final class DeletePKItemReqBody
    extends MessageMicro<DeletePKItemReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_pk_item_id" }, new Object[] { Integer.valueOf(0) }, DeletePKItemReqBody.class);
    public final PBUInt32Field uint32_pk_item_id = PBField.initUInt32(0);
  }
  
  public static final class DeletePKItemRspBody
    extends MessageMicro<DeletePKItemRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], DeletePKItemRspBody.class);
  }
  
  public static final class GetAllPKItemsReqBody
    extends MessageMicro<GetAllPKItemsReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_pk_item_id" }, new Object[] { Integer.valueOf(0) }, GetAllPKItemsReqBody.class);
    public final PBUInt32Field uint32_pk_item_id = PBField.initUInt32(0);
  }
  
  public static final class GetAllPKItemsRspBody
    extends MessageMicro<GetAllPKItemsRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_pk_item" }, new Object[] { null }, GetAllPKItemsRspBody.class);
    public final PBRepeatMessageField<oidb_0x435.PKItem> rpt_msg_pk_item = PBField.initRepeatMessage(oidb_0x435.PKItem.class);
  }
  
  public static final class GetPKItemReqBody
    extends MessageMicro<GetPKItemReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_pk_item_id" }, new Object[] { Integer.valueOf(0) }, GetPKItemReqBody.class);
    public final PBUInt32Field uint32_pk_item_id = PBField.initUInt32(0);
  }
  
  public static final class GetPKItemRspBody
    extends MessageMicro<GetPKItemRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_pk_item" }, new Object[] { null }, GetPKItemRspBody.class);
    public final PBRepeatMessageField<oidb_0x435.PKItem> rpt_msg_pk_item = PBField.initRepeatMessage(oidb_0x435.PKItem.class);
  }
  
  public static final class PKItem
    extends MessageMicro<PKItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pk_description = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x435.VoteItem> rpt_msg_vote = PBField.initRepeatMessage(oidb_0x435.VoteItem.class);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interval_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pk_is_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pk_item_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_valid_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56, 64 }, new String[] { "uint32_pk_item_id", "bytes_pk_description", "uint32_start_time", "uint32_end_time", "uint32_valid_time", "rpt_msg_vote", "uint32_interval_time", "uint32_pk_is_over" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, PKItem.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_topic_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x435.AddTopicReqBody msg_add_req_body = new oidb_0x435.AddTopicReqBody();
    public oidb_0x435.DeletePKItemReqBody msg_del_req_body = new oidb_0x435.DeletePKItemReqBody();
    public oidb_0x435.GetAllPKItemsReqBody msg_get_all_pk_items_req_body = new oidb_0x435.GetAllPKItemsReqBody();
    public oidb_0x435.GetPKItemReqBody msg_get_req_body = new oidb_0x435.GetPKItemReqBody();
    public oidb_0x435.AddVoteReqBody msg_vote_req_body = new oidb_0x435.AddVoteReqBody();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 90, 98, 106, 114, 122 }, new String[] { "uint32_subcmd", "bytes_topic_id", "msg_add_req_body", "msg_vote_req_body", "msg_del_req_body", "msg_get_req_body", "msg_get_all_pk_items_req_body" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null, null, null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_topic_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public oidb_0x435.AddTopicRspBody msg_add_rsp_body = new oidb_0x435.AddTopicRspBody();
    public oidb_0x435.DeletePKItemRspBody msg_del_rsp_body = new oidb_0x435.DeletePKItemRspBody();
    public oidb_0x435.GetAllPKItemsRspBody msg_get_all_pk_items_rsp_body = new oidb_0x435.GetAllPKItemsRspBody();
    public oidb_0x435.GetPKItemRspBody msg_get_rsp_body = new oidb_0x435.GetPKItemRspBody();
    public oidb_0x435.AddVoteRspBody msg_vote_rsp_body = new oidb_0x435.AddVoteRspBody();
    public final PBUInt32Field uint32_interval_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 90, 98, 106, 114, 122 }, new String[] { "int32_ret_code", "bytes_error_msg", "uint32_subcmd", "bytes_topic_id", "uint32_interval_time", "msg_add_rsp_body", "msg_vote_rsp_body", "msg_del_rsp_body", "msg_get_rsp_body", "msg_get_all_pk_items_rsp_body" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), null, null, null, null, null }, RspBody.class);
    }
  }
  
  public static final class TopicInfo
    extends MessageMicro<TopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x435.PKItem> rpt_msg_pkitems = PBField.initRepeatMessage(oidb_0x435.PKItem.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_topic_name", "rpt_msg_pkitems" }, new Object[] { localByteStringMicro, null }, TopicInfo.class);
    }
  }
  
  public static final class VoteItem
    extends MessageMicro<VoteItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_option_description = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_user_define = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vote_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vote_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_vote_id", "bytes_option_description", "uint32_vote_count", "uint32_user_define" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, VoteItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x435.oidb_0x435
 * JD-Core Version:    0.7.0.1
 */