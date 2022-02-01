package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_interactive_pack
{
  public static final class FDRecvDetailsReq
    extends MessageMicro<FDRecvDetailsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "op_uin", "host_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, FDRecvDetailsReq.class);
    public final PBUInt64Field host_uin = PBField.initUInt64(0L);
    public final PBUInt64Field op_uin = PBField.initUInt64(0L);
  }
  
  public static final class FDRecvDetailsRsp
    extends MessageMicro<FDRecvDetailsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 170 }, new String[] { "host_uin", "busi_elem", "fd_desc", "is_over", "recv_info", "fd_recv_msg", "ctnue_share", "re_recv_list" }, new Object[] { Long.valueOf(0L), null, "", Boolean.valueOf(false), null, "", Boolean.valueOf(false), null }, FDRecvDetailsRsp.class);
    public fd_comm.BusiElement busi_elem = new fd_comm.BusiElement();
    public final PBBoolField ctnue_share = PBField.initBool(false);
    public final PBStringField fd_desc = PBField.initString("");
    public final PBStringField fd_recv_msg = PBField.initString("");
    public final PBUInt64Field host_uin = PBField.initUInt64(0L);
    public final PBBoolField is_over = PBField.initBool(false);
    public final PBRepeatMessageField<fd_interactive_pack.SingleRecvDetail> re_recv_list = PBField.initRepeatMessage(fd_interactive_pack.SingleRecvDetail.class);
    public fd_comm.GrabPack recv_info = new fd_comm.GrabPack();
  }
  
  public static final class GrabeRedEnvelopeReq
    extends MessageMicro<GrabeRedEnvelopeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 88 }, new String[] { "op_prof", "host_uin", "share_meta", "src_version" }, new Object[] { null, Long.valueOf(0L), null, Integer.valueOf(0) }, GrabeRedEnvelopeReq.class);
    public final PBUInt64Field host_uin = PBField.initUInt64(0L);
    public fd_comm.UinProf op_prof = new fd_comm.UinProf();
    public fd_comm.FDShareMeta share_meta = new fd_comm.FDShareMeta();
    public final PBUInt32Field src_version = PBField.initUInt32(0);
  }
  
  public static final class GrabeRedEnvelopeRsp
    extends MessageMicro<GrabeRedEnvelopeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 58 }, new String[] { "host_prof", "grab_state", "pack_info", "top_des", "busi_elem", "switch_jmp_main_page", "luck_card_info" }, new Object[] { null, Integer.valueOf(1), null, "", null, Integer.valueOf(0), null }, GrabeRedEnvelopeRsp.class);
    public fd_comm.BusiElement busi_elem = new fd_comm.BusiElement();
    public final PBEnumField grab_state = PBField.initEnum(1);
    public fd_comm.UinProf host_prof = new fd_comm.UinProf();
    public fd_comm.LuckCard luck_card_info = new fd_comm.LuckCard();
    public fd_comm.GrabPack pack_info = new fd_comm.GrabPack();
    public final PBUInt32Field switch_jmp_main_page = PBField.initUInt32(0);
    public final PBStringField top_des = PBField.initString("");
  }
  
  public static final class ReqFDPkg
    extends MessageMicro<ReqFDPkg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 88, 98, 106, 114, 122 }, new String[] { "fdid", "cmd_type", "share_fd", "grabe_re", "recv_details", "device_info" }, new Object[] { "", Integer.valueOf(0), null, null, null, "" }, ReqFDPkg.class);
    public final PBUInt32Field cmd_type = PBField.initUInt32(0);
    public final PBStringField device_info = PBField.initString("");
    public final PBStringField fdid = PBField.initString("");
    public fd_interactive_pack.GrabeRedEnvelopeReq grabe_re = new fd_interactive_pack.GrabeRedEnvelopeReq();
    public fd_interactive_pack.FDRecvDetailsReq recv_details = new fd_interactive_pack.FDRecvDetailsReq();
    public fd_interactive_pack.ShareFDReq share_fd = new fd_interactive_pack.ShareFDReq();
  }
  
  public static final class RspFDPkg
    extends MessageMicro<RspFDPkg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 88, 98, 106, 114 }, new String[] { "op_uin", "result_code", "result_msg", "fdid", "cmd_type", "share_fd", "grabe_re", "recv_details" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), null, null, null }, RspFDPkg.class);
    public final PBUInt32Field cmd_type = PBField.initUInt32(0);
    public final PBStringField fdid = PBField.initString("");
    public fd_interactive_pack.GrabeRedEnvelopeRsp grabe_re = new fd_interactive_pack.GrabeRedEnvelopeRsp();
    public final PBUInt64Field op_uin = PBField.initUInt64(0L);
    public fd_interactive_pack.FDRecvDetailsRsp recv_details = new fd_interactive_pack.FDRecvDetailsRsp();
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBStringField result_msg = PBField.initString("");
    public fd_interactive_pack.ShareFDRsp share_fd = new fd_interactive_pack.ShareFDRsp();
  }
  
  public static final class ShareFDReq
    extends MessageMicro<ShareFDReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "host_prof", "share_meta" }, new Object[] { null, null }, ShareFDReq.class);
    public fd_comm.UinProf host_prof = new fd_comm.UinProf();
    public fd_comm.FDShareMeta share_meta = new fd_comm.FDShareMeta();
  }
  
  public static final class ShareFDRsp
    extends MessageMicro<ShareFDRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "share_meta" }, new Object[] { null }, ShareFDRsp.class);
    public fd_comm.FDShareMeta share_meta = new fd_comm.FDShareMeta();
  }
  
  public static final class SingleRecvDetail
    extends MessageMicro<SingleRecvDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uin", "nick", "ctime", "re_info" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), null }, SingleRecvDetail.class);
    public final PBUInt32Field ctime = PBField.initUInt32(0);
    public final PBStringField nick = PBField.initString("");
    public fd_comm.GrabPack re_info = new fd_comm.GrabPack();
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     fudai.fd_interactive_pack
 * JD-Core Version:    0.7.0.1
 */