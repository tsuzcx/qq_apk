package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFunCallAndRing
{
  public static final class TGroupInfo
    extends MessageMicro<TGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "i32_group_id", "str_group_name", "i32_ring_id", "u64_group_uins", "st_src_info" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), null }, TGroupInfo.class);
    public final PBInt32Field i32_group_id = PBField.initInt32(0);
    public final PBInt32Field i32_ring_id = PBField.initInt32(0);
    public VipFunCallAndRing.TSourceInfo st_src_info = new VipFunCallAndRing.TSourceInfo();
    public final PBStringField str_group_name = PBField.initString("");
    public final PBRepeatField<Long> u64_group_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class TSourceInfo
    extends MessageMicro<TSourceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "str_media_url", "str_image_url", "str_ring_url", "str_thumb_url", "str_fc_name" }, new Object[] { "", "", "", "", "" }, TSourceInfo.class);
    public final PBStringField str_fc_name = PBField.initString("");
    public final PBStringField str_image_url = PBField.initString("");
    public final PBStringField str_media_url = PBField.initString("");
    public final PBStringField str_ring_url = PBField.initString("");
    public final PBStringField str_thumb_url = PBField.initString("");
  }
  
  public static final class TSsoCmd0x1Req
    extends MessageMicro<TSsoCmd0x1Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "u64_local_ver" }, new Object[] { Long.valueOf(0L) }, TSsoCmd0x1Req.class);
    public final PBUInt64Field u64_local_ver = PBField.initUInt64(0L);
  }
  
  public static final class TSsoCmd0x1Rsp
    extends MessageMicro<TSsoCmd0x1Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "u64_server_ver", "st_User_Info" }, new Object[] { Long.valueOf(0L), null }, TSsoCmd0x1Rsp.class);
    public VipFunCallAndRing.TUserInfo st_User_Info = new VipFunCallAndRing.TUserInfo();
    public final PBUInt64Field u64_server_ver = PBField.initUInt64(0L);
  }
  
  public static final class TSsoCmd0x2Req
    extends MessageMicro<TSsoCmd0x2Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "u64_friend_uin", "str_friend_phone" }, new Object[] { Long.valueOf(0L), "" }, TSsoCmd0x2Req.class);
    public final PBStringField str_friend_phone = PBField.initString("");
    public final PBUInt64Field u64_friend_uin = PBField.initUInt64(0L);
  }
  
  public static final class TSsoCmd0x2Rsp
    extends MessageMicro<TSsoCmd0x2Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "i32_funcall_id", "i32_ring_id", "st_src_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, TSsoCmd0x2Rsp.class);
    public final PBInt32Field i32_funcall_id = PBField.initInt32(0);
    public final PBInt32Field i32_ring_id = PBField.initInt32(0);
    public VipFunCallAndRing.TSourceInfo st_src_info = new VipFunCallAndRing.TSourceInfo();
  }
  
  public static final class TSsoCmd0x3Req
    extends MessageMicro<TSsoCmd0x3Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "i32_funcall_id", "i32_ring_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, TSsoCmd0x3Req.class);
    public final PBInt32Field i32_funcall_id = PBField.initInt32(0);
    public final PBInt32Field i32_ring_id = PBField.initInt32(0);
  }
  
  public static final class TSsoCmd0x3Rsp
    extends MessageMicro<TSsoCmd0x3Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "u64_server_ver" }, new Object[] { Long.valueOf(0L) }, TSsoCmd0x3Rsp.class);
    public final PBUInt64Field u64_server_ver = PBField.initUInt64(0L);
  }
  
  public static final class TSsoCmd0x4Req
    extends MessageMicro<TSsoCmd0x4Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "i32_funcall_id", "i32_ring_id", "rpt_uins" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, TSsoCmd0x4Req.class);
    public final PBInt32Field i32_funcall_id = PBField.initInt32(0);
    public final PBInt32Field i32_ring_id = PBField.initInt32(0);
    public final PBRepeatField<Long> rpt_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class TSsoCmd0x4Rsp
    extends MessageMicro<TSsoCmd0x4Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "u64_server_ver" }, new Object[] { Long.valueOf(0L) }, TSsoCmd0x4Rsp.class);
    public final PBUInt64Field u64_server_ver = PBField.initUInt64(0L);
  }
  
  public static final class TSsoCmd0x5Req
    extends MessageMicro<TSsoCmd0x5Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "i32_funcall_id" }, new Object[] { Integer.valueOf(0) }, TSsoCmd0x5Req.class);
    public final PBInt32Field i32_funcall_id = PBField.initInt32(0);
  }
  
  public static final class TSsoCmd0x5Rsp
    extends MessageMicro<TSsoCmd0x5Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "u64_server_ver" }, new Object[] { Long.valueOf(0L) }, TSsoCmd0x5Rsp.class);
    public final PBUInt64Field u64_server_ver = PBField.initUInt64(0L);
  }
  
  public static final class TSsoReq
    extends MessageMicro<TSsoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66 }, new String[] { "i32_cmd", "i32_implat", "str_qq_ver", "st_cmd0x1_req", "st_cmd0x2_req", "st_cmd0x3_req", "st_cmd0x4_req", "st_cmd0x5_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null, null, null, null, null }, TSsoReq.class);
    public final PBInt32Field i32_cmd = PBField.initInt32(0);
    public final PBInt32Field i32_implat = PBField.initInt32(0);
    public VipFunCallAndRing.TSsoCmd0x1Req st_cmd0x1_req = new VipFunCallAndRing.TSsoCmd0x1Req();
    public VipFunCallAndRing.TSsoCmd0x2Req st_cmd0x2_req = new VipFunCallAndRing.TSsoCmd0x2Req();
    public VipFunCallAndRing.TSsoCmd0x3Req st_cmd0x3_req = new VipFunCallAndRing.TSsoCmd0x3Req();
    public VipFunCallAndRing.TSsoCmd0x4Req st_cmd0x4_req = new VipFunCallAndRing.TSsoCmd0x4Req();
    public VipFunCallAndRing.TSsoCmd0x5Req st_cmd0x5_req = new VipFunCallAndRing.TSsoCmd0x5Req();
    public final PBStringField str_qq_ver = PBField.initString("");
  }
  
  public static final class TSsoRsp
    extends MessageMicro<TSsoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "i32_ret", "str_msg", "st_cmd0x1_rsp", "st_cmd0x2_rsp", "st_cmd0x3_rsp", "st_cmd0x4_rsp", "st_cmd0x5_rsp", "str_url", "str_act_wording" }, new Object[] { Integer.valueOf(0), "", null, null, null, null, null, "", "" }, TSsoRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
    public VipFunCallAndRing.TSsoCmd0x1Rsp st_cmd0x1_rsp = new VipFunCallAndRing.TSsoCmd0x1Rsp();
    public VipFunCallAndRing.TSsoCmd0x2Rsp st_cmd0x2_rsp = new VipFunCallAndRing.TSsoCmd0x2Rsp();
    public VipFunCallAndRing.TSsoCmd0x3Rsp st_cmd0x3_rsp = new VipFunCallAndRing.TSsoCmd0x3Rsp();
    public VipFunCallAndRing.TSsoCmd0x4Rsp st_cmd0x4_rsp = new VipFunCallAndRing.TSsoCmd0x4Rsp();
    public VipFunCallAndRing.TSsoCmd0x5Rsp st_cmd0x5_rsp = new VipFunCallAndRing.TSsoCmd0x5Rsp();
    public final PBStringField str_act_wording = PBField.initString("");
    public final PBStringField str_msg = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
  }
  
  public static final class TUserInfo
    extends MessageMicro<TUserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "i32_common_id", "i32_ring_id", "rpt_user_groups", "st_src_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, TUserInfo.class);
    public final PBInt32Field i32_common_id = PBField.initInt32(0);
    public final PBInt32Field i32_ring_id = PBField.initInt32(0);
    public final PBRepeatMessageField<VipFunCallAndRing.TGroupInfo> rpt_user_groups = PBField.initRepeatMessage(VipFunCallAndRing.TGroupInfo.class);
    public VipFunCallAndRing.TSourceInfo st_src_info = new VipFunCallAndRing.TSourceInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.funcall.VipFunCallAndRing
 * JD-Core Version:    0.7.0.1
 */