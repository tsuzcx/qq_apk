package tencent.im.oidb.cmd0x48a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x48a
{
  public static final class ChkBlockReq
    extends MessageMicro<ChkBlockReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_block_account_data" }, new Object[] { null }, ChkBlockReq.class);
    public oidb_0x48a.OneBlockAccountData msg_block_account_data = new oidb_0x48a.OneBlockAccountData();
  }
  
  public static final class ChkBlockRsp
    extends MessageMicro<ChkBlockRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_block_account_data", "uint32_result" }, new Object[] { null, Integer.valueOf(0) }, ChkBlockRsp.class);
    public oidb_0x48a.OneBlockAccountData msg_block_account_data = new oidb_0x48a.OneBlockAccountData();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
  
  public static final class OneBlockAccountData
    extends MessageMicro<OneBlockAccountData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_account_type", "uint64_block_qcall_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, OneBlockAccountData.class);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_qcall_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_chk_block_req" }, new Object[] { null }, ReqBody.class);
    public oidb_0x48a.ChkBlockReq msg_chk_block_req = new oidb_0x48a.ChkBlockReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_chk_block_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_0x48a.ChkBlockRsp msg_chk_block_rsp = new oidb_0x48a.ChkBlockRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x48a.oidb_0x48a
 * JD-Core Version:    0.7.0.1
 */