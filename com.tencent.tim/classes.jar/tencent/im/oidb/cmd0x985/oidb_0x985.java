package tencent.im.oidb.cmd0x985;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x985
{
  public static final class GetReadListReq
    extends MessageMicro<GetReadListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_conf_uin", "uint32_msg_seq", "uint64_from_uin" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, GetReadListReq.class);
    public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetReadListRsp
    extends MessageMicro<GetReadListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_read_list", "rpt_msg_unread_list" }, new Object[] { null, null }, GetReadListRsp.class);
    public final PBRepeatMessageField<oidb_0x985.UinInfo> rpt_msg_read_list = PBField.initRepeatMessage(oidb_0x985.UinInfo.class);
    public final PBRepeatMessageField<oidb_0x985.UinInfo> rpt_msg_unread_list = PBField.initRepeatMessage(oidb_0x985.UinInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_subcmd", "msg_get_read_list_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public oidb_0x985.GetReadListReq msg_get_read_list_req = new oidb_0x985.GetReadListReq();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x985.GetReadListRsp msg_get_read_list_rsp = new oidb_0x985.GetReadListRsp();
    public final PBUInt32Field uint32_code = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_code", "bytes_err_msg", "msg_get_read_list_rsp" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, RspBody.class);
    }
  }
  
  public static final class UinInfo
    extends MessageMicro<UinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_uin", "uint32_time", "bytes_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, UinInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x985.oidb_0x985
 * JD-Core Version:    0.7.0.1
 */