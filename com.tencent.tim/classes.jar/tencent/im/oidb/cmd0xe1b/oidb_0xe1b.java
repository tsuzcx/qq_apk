package tencent.im.oidb.cmd0xe1b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.kandian.flaginfo.flag_info.FlagInfo;

public final class oidb_0xe1b
{
  public static final class GetFlagInfoReq
    extends MessageMicro<GetFlagInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 88, 96 }, new String[] { "rpt_uint64_uin_list", "uint32_need_all", "uint32_ignore_cache", "uint32_need_private_flag", "uint32_need_teenager_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetFlagInfoReq.class);
    public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_ignore_cache = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_all = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_private_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_teenager_flag = PBField.initUInt32(0);
  }
  
  public static final class GetFlagInfoRsp
    extends MessageMicro<GetFlagInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_flag_info_list" }, new Object[] { null }, GetFlagInfoRsp.class);
    public final PBRepeatMessageField<flag_info.FlagInfo> rpt_msg_flag_info_list = PBField.initRepeatMessage(flag_info.FlagInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "uint32_req_type", "msg_get_flag_info_req", "msg_set_flag_info_req" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
    public oidb_0xe1b.GetFlagInfoReq msg_get_flag_info_req = new oidb_0xe1b.GetFlagInfoReq();
    public oidb_0xe1b.SetFlagInfoReq msg_set_flag_info_req = new oidb_0xe1b.SetFlagInfoReq();
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "msg_get_flag_info_rsp", "msg_set_flag_info_rsp" }, new Object[] { null, null }, RspBody.class);
    public oidb_0xe1b.GetFlagInfoRsp msg_get_flag_info_rsp = new oidb_0xe1b.GetFlagInfoRsp();
    public oidb_0xe1b.SetFlagInfoRsp msg_set_flag_info_rsp = new oidb_0xe1b.SetFlagInfoRsp();
  }
  
  public static final class SetFlagInfoReq
    extends MessageMicro<SetFlagInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_flag_info_list" }, new Object[] { null }, SetFlagInfoReq.class);
    public final PBRepeatMessageField<flag_info.FlagInfo> rpt_msg_flag_info_list = PBField.initRepeatMessage(flag_info.FlagInfo.class);
  }
  
  public static final class SetFlagInfoRsp
    extends MessageMicro<SetFlagInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_flag_info_list" }, new Object[] { null }, SetFlagInfoRsp.class);
    public final PBRepeatMessageField<flag_info.FlagInfo> rpt_msg_flag_info_list = PBField.initRepeatMessage(flag_info.FlagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe1b.oidb_0xe1b
 * JD-Core Version:    0.7.0.1
 */