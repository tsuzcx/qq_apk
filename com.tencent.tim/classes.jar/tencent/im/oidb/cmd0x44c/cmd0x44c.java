package tencent.im.oidb.cmd0x44c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x44c
{
  public static final class ModifyConfInfoReq
    extends MessageMicro<ModifyConfInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint64_conf_uin", "uint32_last_passwd_red_bag_time", "uint32_conf_meeting_origin", "msg_self_member_info", "uint32_qidian_conf_type", "uint32_conf_meeting_option" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ModifyConfInfoReq.class);
    public cmd0x44c.ModifySelfMemberInfo msg_self_member_info = new cmd0x44c.ModifySelfMemberInfo();
    public final PBUInt32Field uint32_conf_meeting_option = PBField.initUInt32(0);
    public final PBUInt32Field uint32_conf_meeting_origin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_passwd_red_bag_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qidian_conf_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  }
  
  public static final class ModifyConfInfoRsp
    extends MessageMicro<ModifyConfInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ModifyConfInfoRsp.class);
  }
  
  public static final class ModifySelfMemberInfo
    extends MessageMicro<ModifySelfMemberInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name_card = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_name_card" }, new Object[] { localByteStringMicro }, ModifySelfMemberInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_subcmd", "msg_modify_conf_info_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public cmd0x44c.ModifyConfInfoReq msg_modify_conf_info_req = new cmd0x44c.ModifyConfInfoReq();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0x44c.ModifyConfInfoRsp msg_modify_conf_info_rsp = new cmd0x44c.ModifyConfInfoRsp();
    public final PBUInt32Field uint32_code = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_code", "bytes_err_msg", "msg_modify_conf_info_rsp" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x44c.cmd0x44c
 * JD-Core Version:    0.7.0.1
 */