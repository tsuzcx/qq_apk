package tencent.im.oidb.cmd0xb57;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb57
{
  public static final class GetNumApproveListReqBody
    extends MessageMicro<GetNumApproveListReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_start", "uint32_need_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetNumApproveListReqBody.class);
    public final PBUInt32Field uint32_need_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start = PBField.initUInt32(0);
  }
  
  public static final class GetNumApproveListRspBody
    extends MessageMicro<GetNumApproveListRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_isend", "uint32_next_index", "rpt_msg_num_approve_state_items" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, GetNumApproveListRspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xb57.NumApproveStateItem> rpt_msg_num_approve_state_items = PBField.initRepeatMessage(oidb_cmd0xb57.NumApproveStateItem.class);
    public final PBUInt32Field uint32_isend = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_index = PBField.initUInt32(0);
  }
  
  public static final class GetNumApproveStateReqBody
    extends MessageMicro<GetNumApproveStateReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rpt_uint64_query_num", "uint32_need_medal" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GetNumApproveStateReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_query_num = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_need_medal = PBField.initUInt32(0);
  }
  
  public static final class GetNumApproveStateRspBody
    extends MessageMicro<GetNumApproveStateRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_num_approve_state_items" }, new Object[] { null }, GetNumApproveStateRspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xb57.NumApproveStateItem> rpt_msg_num_approve_state_items = PBField.initRepeatMessage(oidb_cmd0xb57.NumApproveStateItem.class);
  }
  
  public static final class GetTopQualityNumReqBody
    extends MessageMicro<GetTopQualityNumReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_quality_num" }, new Object[] { Long.valueOf(0L) }, GetTopQualityNumReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_quality_num = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class GetTopQualityNumRspBody
    extends MessageMicro<GetTopQualityNumRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_quality_num_items" }, new Object[] { null }, GetTopQualityNumRspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xb57.QualityNumItem> rpt_msg_quality_num_items = PBField.initRepeatMessage(oidb_cmd0xb57.QualityNumItem.class);
  }
  
  public static final class MedalInfo
    extends MessageMicro<MedalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_medal_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_medal_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_jump = PBField.initUInt32(0);
    public final PBUInt32Field uint32_medal_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_medal_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56, 64 }, new String[] { "uint64_medal_id", "bytes_medal_name", "bytes_medal_url", "uint32_medal_type", "uint32_is_jump", "bytes_jump_url", "uint32_pic_width", "uint32_pic_height" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, MedalInfo.class);
    }
  }
  
  public static final class NumApproveStateItem
    extends MessageMicro<NumApproveStateItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_num_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0xb57.MedalInfo> rpt_msg_medal_info = PBField.initRepeatMessage(oidb_cmd0xb57.MedalInfo.class);
    public final PBUInt32Field uint32_is_approve = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_star = PBField.initUInt32(0);
    public final PBUInt64Field uint64_query_num = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint64_query_num", "uint32_is_approve", "bytes_num_summary", "uint32_is_star", "rpt_msg_medal_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), null }, NumApproveStateItem.class);
    }
  }
  
  public static final class QualityNumItem
    extends MessageMicro<QualityNumItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_num_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_approve_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fans_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_star = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mark_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_publish_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_quality_num = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56 }, new String[] { "uint64_quality_num", "uint32_mark_state", "uint32_approve_state", "bytes_num_summary", "uint32_fans_num", "uint32_publish_num", "uint32_is_star" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, QualityNumItem.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_oper", "msg_get_top_quality_req", "msg_get_num_approve_state_req", "msg_get_num_approve_list_req" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
    public oidb_cmd0xb57.GetNumApproveListReqBody msg_get_num_approve_list_req = new oidb_cmd0xb57.GetNumApproveListReqBody();
    public oidb_cmd0xb57.GetNumApproveStateReqBody msg_get_num_approve_state_req = new oidb_cmd0xb57.GetNumApproveStateReqBody();
    public oidb_cmd0xb57.GetTopQualityNumReqBody msg_get_top_quality_req = new oidb_cmd0xb57.GetTopQualityNumReqBody();
    public final PBUInt32Field uint32_oper = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_oper", "msg_get_top_quality_rsp", "msg_get_num_approve_state_rsp", "msg_get_num_approve_list_rsp" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
    public oidb_cmd0xb57.GetNumApproveListRspBody msg_get_num_approve_list_rsp = new oidb_cmd0xb57.GetNumApproveListRspBody();
    public oidb_cmd0xb57.GetNumApproveStateRspBody msg_get_num_approve_state_rsp = new oidb_cmd0xb57.GetNumApproveStateRspBody();
    public oidb_cmd0xb57.GetTopQualityNumRspBody msg_get_top_quality_rsp = new oidb_cmd0xb57.GetTopQualityNumRspBody();
    public final PBUInt32Field uint32_oper = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb57.oidb_cmd0xb57
 * JD-Core Version:    0.7.0.1
 */