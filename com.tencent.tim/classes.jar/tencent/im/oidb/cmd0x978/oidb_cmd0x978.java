package tencent.im.oidb.cmd0x978;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x978
{
  public static final class FollowStatusInfo
    extends MessageMicro<FollowStatusInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "enum_follow_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, FollowStatusInfo.class);
    public final PBEnumField enum_follow_status = PBField.initEnum(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class OneFollowOperationInfo
    extends MessageMicro<OneFollowOperationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_dst_uin", "uint32_op_account_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1) }, OneFollowOperationInfo.class);
    public final PBEnumField uint32_op_account_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  }
  
  public static final class OneFollowOperationResult
    extends MessageMicro<OneFollowOperationResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_dst_uin", "uint32_op_account_type", "uint32_op_result", "enum_follow_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) }, OneFollowOperationResult.class);
    public final PBEnumField enum_follow_status = PBField.initEnum(0);
    public final PBEnumField uint32_op_account_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_op_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 96 }, new String[] { "uint64_uin", "uint64_client_switch", "msg_req_follow_para", "uint32_refer" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0) }, ReqBody.class);
    public oidb_cmd0x978.ReqFollowOperationPara msg_req_follow_para = new oidb_cmd0x978.ReqFollowOperationPara();
    public final PBUInt32Field uint32_refer = PBField.initUInt32(0);
    public final PBUInt64Field uint64_client_switch = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqFollowOperationPara
    extends MessageMicro<ReqFollowOperationPara>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField op_type = PBField.initEnum(1);
    public final PBRepeatMessageField<oidb_cmd0x978.OneFollowOperationInfo> rpt_follow_operation_info = PBField.initRepeatMessage(oidb_cmd0x978.OneFollowOperationInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "op_type", "bytes_cookie", "rpt_follow_operation_info" }, new Object[] { Integer.valueOf(1), localByteStringMicro, null }, ReqFollowOperationPara.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_uin", "msg_rsp_follow_op_result" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
    public oidb_cmd0x978.RspFollowOperationResult msg_rsp_follow_op_result = new oidb_cmd0x978.RspFollowOperationResult();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspFollowOperationResult
    extends MessageMicro<RspFollowOperationResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField op_type = PBField.initEnum(1);
    public final PBRepeatMessageField<oidb_cmd0x978.OneFollowOperationResult> rpt_follow_operation_result = PBField.initRepeatMessage(oidb_cmd0x978.OneFollowOperationResult.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "op_type", "bytes_cookie", "rpt_follow_operation_result" }, new Object[] { Integer.valueOf(1), localByteStringMicro, null }, RspFollowOperationResult.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x978.oidb_cmd0x978
 * JD-Core Version:    0.7.0.1
 */