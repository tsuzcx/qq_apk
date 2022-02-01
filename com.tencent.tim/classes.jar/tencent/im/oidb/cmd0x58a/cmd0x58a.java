package tencent.im.oidb.cmd0x58a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x58a
{
  public static final class CmdErrorCode
    extends MessageMicro<CmdErrorCode>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_code = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_code", "bytes_err_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, CmdErrorCode.class);
    }
  }
  
  public static final class ConfBaseInfo
    extends MessageMicro<ConfBaseInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_conf_uin", "uint32_is_favorite", "uint32_info_seq", "uint32_member_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ConfBaseInfo.class);
    public final PBUInt32Field uint32_info_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_favorite = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetCommConfReq
    extends MessageMicro<GetCommConfReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_other_uin" }, new Object[] { Long.valueOf(0L) }, GetCommConfReq.class);
    public final PBUInt64Field uint64_other_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetConfListRsp
    extends MessageMicro<GetConfListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_msg_conf_base_info", "rpt_uint64_other_conf_list" }, new Object[] { null, Long.valueOf(0L) }, GetConfListRsp.class);
    public final PBRepeatMessageField<cmd0x58a.ConfBaseInfo> rpt_msg_conf_base_info = PBField.initRepeatMessage(cmd0x58a.ConfBaseInfo.class);
    public final PBRepeatField<Long> rpt_uint64_other_conf_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_subcmd", "msg_get_comm_conf_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public cmd0x58a.GetCommConfReq msg_get_comm_conf_req = new cmd0x58a.GetCommConfReq();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_cmd_error_code", "uint32_subcmd", "msg_get_conf_list" }, new Object[] { null, Integer.valueOf(0), null }, RspBody.class);
    public cmd0x58a.CmdErrorCode msg_cmd_error_code = new cmd0x58a.CmdErrorCode();
    public cmd0x58a.GetConfListRsp msg_get_conf_list = new cmd0x58a.GetConfListRsp();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58a.cmd0x58a
 * JD-Core Version:    0.7.0.1
 */