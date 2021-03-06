package tencent.im.oidb.cmd0x488;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x488
{
  public static final class AddBlockReq
    extends MessageMicro<AddBlockReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_one_block_data" }, new Object[] { null }, AddBlockReq.class);
    public oidb_0x488.OneAddBlockData msg_one_block_data = new oidb_0x488.OneAddBlockData();
  }
  
  public static final class AddBlockRsp
    extends MessageMicro<AddBlockRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_one_block_data" }, new Object[] { null }, AddBlockRsp.class);
    public oidb_0x488.OneAddBlockData msg_one_block_data = new oidb_0x488.OneAddBlockData();
  }
  
  public static final class OneAddBlockData
    extends MessageMicro<OneAddBlockData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mobile = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_qcall_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_account_type", "uint64_block_qcall_id", "uint32_result", "bytes_mobile" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, OneAddBlockData.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_add_block_req" }, new Object[] { null }, ReqBody.class);
    public oidb_0x488.AddBlockReq msg_add_block_req = new oidb_0x488.AddBlockReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_add_block_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_0x488.AddBlockRsp msg_add_block_rsp = new oidb_0x488.AddBlockRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x488.oidb_0x488
 * JD-Core Version:    0.7.0.1
 */