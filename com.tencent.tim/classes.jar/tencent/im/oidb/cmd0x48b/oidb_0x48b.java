package tencent.im.oidb.cmd0x48b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x48b
{
  public static final class GetTotalblockInfo
    extends MessageMicro<GetTotalblockInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mobile = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_qcall_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_account_type", "uint64_block_qcall_id", "bytes_mobile" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, GetTotalblockInfo.class);
    }
  }
  
  public static final class GetblockListReq
    extends MessageMicro<GetblockListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_start_idx", "uint32_req_num", "uint32_last_get_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetblockListReq.class);
    public final PBUInt32Field uint32_last_get_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_idx = PBField.initUInt32(0);
  }
  
  public static final class GetblockListRsp
    extends MessageMicro<GetblockListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_over", "uint32_next_start_idx", "uint32_get_time", "rpt_msg_get_total_block_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, GetblockListRsp.class);
    public final PBRepeatMessageField<oidb_0x48b.GetTotalblockInfo> rpt_msg_get_total_block_info = PBField.initRepeatMessage(oidb_0x48b.GetTotalblockInfo.class);
    public final PBUInt32Field uint32_get_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_start_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_blocklist_req" }, new Object[] { null }, ReqBody.class);
    public oidb_0x48b.GetblockListReq msg_get_blocklist_req = new oidb_0x48b.GetblockListReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_blocklist_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_0x48b.GetblockListRsp msg_get_blocklist_rsp = new oidb_0x48b.GetblockListRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x48b.oidb_0x48b
 * JD-Core Version:    0.7.0.1
 */