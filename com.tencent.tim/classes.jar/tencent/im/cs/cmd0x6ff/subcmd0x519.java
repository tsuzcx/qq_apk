package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x519
{
  public static final class CRMMsgHead
    extends MessageMicro<CRMMsgHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72, 80, 88, 98, 104 }, new String[] { "uint32_crm_sub_cmd", "uint32_head_len", "uint32_ver_no", "uint64_kf_uin", "uint32_seq", "uint32_pack_num", "uint32_cur_pack", "str_buf_sig", "uint64_pub_qq", "uint32_clienttype", "uint64_labor_uin", "str_labor_name", "uint64_puin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), "", Long.valueOf(0L) }, CRMMsgHead.class);
    public final PBStringField str_buf_sig = PBField.initString("");
    public final PBStringField str_labor_name = PBField.initString("");
    public final PBUInt32Field uint32_clienttype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_crm_sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cur_pack = PBField.initUInt32(0);
    public final PBUInt32Field uint32_head_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pack_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
    public final PBUInt64Field uint64_kf_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_labor_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_pub_qq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  }
  
  public static final class GetNavigationMenuReqBody
    extends MessageMicro<GetNavigationMenuReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_puin", "uint64_uin", "uint32_ver_no" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GetNavigationMenuReqBody.class);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetNavigationMenuRspBody
    extends MessageMicro<GetNavigationMenuRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "msg_ret", "int32_is_show", "str_struct_msg", "uint32_ver_no" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0) }, GetNavigationMenuRspBody.class);
    public final PBInt32Field int32_is_show = PBField.initInt32(0);
    public subcmd0x519.RetInfo msg_ret = new subcmd0x519.RetInfo();
    public final PBStringField str_struct_msg = PBField.initString("");
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 282 }, new String[] { "uint32_sub_cmd", "msg_crm_common_head", "msg_get_navigation_menu_req" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
    public subcmd0x519.CRMMsgHead msg_crm_common_head = new subcmd0x519.CRMMsgHead();
    public subcmd0x519.GetNavigationMenuReqBody msg_get_navigation_menu_req = new subcmd0x519.GetNavigationMenuReqBody();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_ret_code", "str_error_msg" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField str_error_msg = PBField.initString("");
    public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 282 }, new String[] { "uint32_sub_cmd", "msg_crm_common_head", "msg_get_navigation_menu_rsp" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
    public subcmd0x519.CRMMsgHead msg_crm_common_head = new subcmd0x519.CRMMsgHead();
    public subcmd0x519.GetNavigationMenuRspBody msg_get_navigation_menu_rsp = new subcmd0x519.GetNavigationMenuRspBody();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x519
 * JD-Core Version:    0.7.0.1
 */