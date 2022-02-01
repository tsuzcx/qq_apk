package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x58b
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
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_conf_meeting_option = PBField.initUInt32(0);
    public final PBUInt32Field uint32_conf_meeting_origin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_err_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_info_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_info_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_msg_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qidian_conf_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_inherit_owner_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136 }, new String[] { "uint64_conf_uin", "uint32_err_code", "bytes_conf_name", "uint32_create_time", "uint64_owner_uin", "uint32_info_seq", "uint32_last_info_time", "uint32_msg_seq", "uint32_last_msg_time", "uint32_member_num", "uint32_flag", "uint64_inherit_owner_uin", "uint64_group_code", "uint64_group_uin", "uint32_conf_meeting_origin", "uint32_qidian_conf_type", "uint32_conf_meeting_option" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ConfBaseInfo.class);
    }
  }
  
  public static final class ConfMemberInfo
    extends MessageMicro<ConfMemberInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_name_card = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_member_interemark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interemark_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_msg_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58 }, new String[] { "uint64_uin", "uint32_join_time", "uint32_flag", "uint32_read_msg_seq", "bytes_member_interemark", "uint32_interemark_source", "bytes_conf_name_card" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ConfMemberInfo.class);
    }
  }
  
  public static final class GetConfInfoReq
    extends MessageMicro<GetConfInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_conf_uin", "msg_conf_base_info", "msg_conf_mem_info", "uint32_interemark_timestamp" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0) }, GetConfInfoReq.class);
    public cmd0x58b.ConfBaseInfo msg_conf_base_info = new cmd0x58b.ConfBaseInfo();
    public cmd0x58b.ConfMemberInfo msg_conf_mem_info = new cmd0x58b.ConfMemberInfo();
    public final PBUInt32Field uint32_interemark_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetConfInfoRsp
    extends MessageMicro<GetConfInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_conf_uin", "msg_conf_base_info", "rpt_msg_member_info", "uint32_server_remark_timestamp" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0) }, GetConfInfoRsp.class);
    public cmd0x58b.ConfBaseInfo msg_conf_base_info = new cmd0x58b.ConfBaseInfo();
    public final PBRepeatMessageField<cmd0x58b.ConfMemberInfo> rpt_msg_member_info = PBField.initRepeatMessage(cmd0x58b.ConfMemberInfo.class);
    public final PBUInt32Field uint32_server_remark_timestamp = PBField.initUInt32(0);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetConfNameForPushReq
    extends MessageMicro<GetConfNameForPushReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_conf_uin" }, new Object[] { Long.valueOf(0L) }, GetConfNameForPushReq.class);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetConfNameForPushRsp
    extends MessageMicro<GetConfNameForPushRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_conf_name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_conf_name" }, new Object[] { localByteStringMicro }, GetConfNameForPushRsp.class);
    }
  }
  
  public static final class GetMultiConfInfoReq
    extends MessageMicro<GetMultiConfInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_conf_uin", "msg_conf_base_info", "msg_conf_mem_info", "uint32_interemark_timestamp" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0) }, GetMultiConfInfoReq.class);
    public cmd0x58b.ConfBaseInfo msg_conf_base_info = new cmd0x58b.ConfBaseInfo();
    public cmd0x58b.ConfMemberInfo msg_conf_mem_info = new cmd0x58b.ConfMemberInfo();
    public final PBUInt32Field uint32_interemark_timestamp = PBField.initUInt32(0);
    public final PBRepeatField<Long> uint64_conf_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class GetMultiConfInfoRsp
    extends MessageMicro<GetMultiConfInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_conf_info" }, new Object[] { null }, GetMultiConfInfoRsp.class);
    public final PBRepeatMessageField<cmd0x58b.GetConfInfoRsp> msg_get_conf_info = PBField.initRepeatMessage(cmd0x58b.GetConfInfoRsp.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_subcmd", "msg_get_conf_info", "msg_get_conf_name_for_push", "msg_get_multi_conf_info" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
    public cmd0x58b.GetConfInfoReq msg_get_conf_info = new cmd0x58b.GetConfInfoReq();
    public cmd0x58b.GetConfNameForPushReq msg_get_conf_name_for_push = new cmd0x58b.GetConfNameForPushReq();
    public cmd0x58b.GetMultiConfInfoReq msg_get_multi_conf_info = new cmd0x58b.GetMultiConfInfoReq();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "msg_cmd_error_code", "uint32_subcmd", "msg_get_conf_info", "msg_get_conf_name_for_push", "msg_get_multi_conf_info" }, new Object[] { null, Integer.valueOf(0), null, null, null }, RspBody.class);
    public cmd0x58b.CmdErrorCode msg_cmd_error_code = new cmd0x58b.CmdErrorCode();
    public cmd0x58b.GetConfInfoRsp msg_get_conf_info = new cmd0x58b.GetConfInfoRsp();
    public cmd0x58b.GetConfNameForPushRsp msg_get_conf_name_for_push = new cmd0x58b.GetConfNameForPushRsp();
    public cmd0x58b.GetMultiConfInfoRsp msg_get_multi_conf_info = new cmd0x58b.GetMultiConfInfoRsp();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58b.cmd0x58b
 * JD-Core Version:    0.7.0.1
 */