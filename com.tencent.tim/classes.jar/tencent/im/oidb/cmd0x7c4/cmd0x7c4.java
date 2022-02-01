package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7c4
{
  public static final class GetRecommendSNFrdListReq
    extends MessageMicro<GetRecommendSNFrdListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_uin", "uint32_sequence", "uint32_start_idx", "uint32_req_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetRecommendSNFrdListReq.class);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_idx = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetRecommendSNFrdListRsp
    extends MessageMicro<GetRecommendSNFrdListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_uin", "uint32_sequence", "uint32_over", "uint32_next_start_idx", "rpt_msg_one_frd_data" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, GetRecommendSNFrdListRsp.class);
    public final PBRepeatMessageField<cmd0x7c4.OneFrdData> rpt_msg_one_frd_data = PBField.initRepeatMessage(cmd0x7c4.OneFrdData.class);
    public final PBUInt32Field uint32_next_start_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetSNFrdListReq
    extends MessageMicro<GetSNFrdListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_uin", "uint32_sequence", "uint32_start_idx", "uint32_req_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetSNFrdListReq.class);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_idx = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetSNFrdListRsp
    extends MessageMicro<GetSNFrdListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint64_uin", "uint32_sequence", "uint32_over", "uint32_next_start_idx", "rpt_msg_one_frd_data", "uint32_recommend_frd_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, GetSNFrdListRsp.class);
    public final PBRepeatMessageField<cmd0x7c4.OneFrdData> rpt_msg_one_frd_data = PBField.initRepeatMessage(cmd0x7c4.OneFrdData.class);
    public final PBUInt32Field uint32_next_start_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recommend_frd_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class MsgBox
    extends MessageMicro<MsgBox>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_reason_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_reason_id", "bytes_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, MsgBox.class);
    }
  }
  
  public static final class OneFrdData
    extends MessageMicro<OneFrdData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_smart_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_ages = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reason_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_frd_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_frd_id", "uint32_reason_id", "bytes_smart_remark", "uint32_gender", "uint32_ages" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, OneFrdData.class);
    }
  }
  
  public static final class RecommendReason
    extends MessageMicro<RecommendReason>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_reason_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_reason_id", "bytes_recommend_reason" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, RecommendReason.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_get_recommend_sn_frd_list_req", "msg_get_sn_frd_list_req", "uint32_client_ver" }, new Object[] { null, null, Integer.valueOf(0) }, ReqBody.class);
    public cmd0x7c4.GetRecommendSNFrdListReq msg_get_recommend_sn_frd_list_req = new cmd0x7c4.GetRecommendSNFrdListReq();
    public cmd0x7c4.GetSNFrdListReq msg_get_sn_frd_list_req = new cmd0x7c4.GetSNFrdListReq();
    public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "msg_get_recommend_sn_frd_list_rsp", "msg_get_sn_frd_list_rsp", "rpt_msg_recommend_reason", "msg_box" }, new Object[] { null, null, null, null }, RspBody.class);
    public cmd0x7c4.MsgBox msg_box = new cmd0x7c4.MsgBox();
    public cmd0x7c4.GetRecommendSNFrdListRsp msg_get_recommend_sn_frd_list_rsp = new cmd0x7c4.GetRecommendSNFrdListRsp();
    public cmd0x7c4.GetSNFrdListRsp msg_get_sn_frd_list_rsp = new cmd0x7c4.GetSNFrdListRsp();
    public final PBRepeatMessageField<cmd0x7c4.RecommendReason> rpt_msg_recommend_reason = PBField.initRepeatMessage(cmd0x7c4.RecommendReason.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c4.cmd0x7c4
 * JD-Core Version:    0.7.0.1
 */