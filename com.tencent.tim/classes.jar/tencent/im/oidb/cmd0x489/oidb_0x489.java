package tencent.im.oidb.cmd0x489;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x489
{
  public static final class DelBlockReq
    extends MessageMicro<DelBlockReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_one_block_data" }, new Object[] { null }, DelBlockReq.class);
    public oidb_0x489.OneDelBlockData msg_one_block_data = new oidb_0x489.OneDelBlockData();
  }
  
  public static final class DelBlockRsp
    extends MessageMicro<DelBlockRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_one_block_data" }, new Object[] { null }, DelBlockRsp.class);
    public oidb_0x489.OneDelBlockData msg_one_block_data = new oidb_0x489.OneDelBlockData();
  }
  
  public static final class OneDelBlockData
    extends MessageMicro<OneDelBlockData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mobile = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_qcall_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_account_type", "uint64_block_qcall_id", "uint32_result", "bytes_mobile" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, OneDelBlockData.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_del_block_req" }, new Object[] { null }, ReqBody.class);
    public oidb_0x489.DelBlockReq msg_del_block_req = new oidb_0x489.DelBlockReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_del_block_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_0x489.DelBlockRsp msg_del_block_rsp = new oidb_0x489.DelBlockRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x489.oidb_0x489
 * JD-Core Version:    0.7.0.1
 */