package tencent.im.oidb.cmd0x874;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x874
{
  public static final class ConvertToGroupReq
    extends MessageMicro<ConvertToGroupReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_conf_uin" }, new Object[] { Long.valueOf(0L) }, ConvertToGroupReq.class);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  }
  
  public static final class ConvertToGroupRsp
    extends MessageMicro<ConvertToGroupRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_conf_uin", "uint64_group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ConvertToGroupRsp.class);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_subcmd", "msg_convert_group" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public cmd0x874.ConvertToGroupReq msg_convert_group = new cmd0x874.ConvertToGroupReq();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0x874.ConvertToGroupRsp msg_convert_group = new cmd0x874.ConvertToGroupRsp();
    public final PBUInt32Field uint32_code = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_code", "bytes_err_msg", "msg_convert_group" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x874.cmd0x874
 * JD-Core Version:    0.7.0.1
 */