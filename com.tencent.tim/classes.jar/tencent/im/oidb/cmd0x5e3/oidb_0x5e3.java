package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e3
{
  public static final class GetPhoneReq
    extends MessageMicro<GetPhoneReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_phones = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_req_contact_qq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_qq_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96 }, new String[] { "rpt_bytes_phones", "uint32_req_contact_qq", "uint32_req_qq_status" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, GetPhoneReq.class);
    }
  }
  
  public static final class GetPhoneRsp
    extends MessageMicro<GetPhoneRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_phone = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_qq_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_contact_qq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96 }, new String[] { "bytes_phone", "uint64_contact_qq", "uint32_qq_status" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, GetPhoneRsp.class);
    }
  }
  
  public static final class GetQCallUinReq
    extends MessageMicro<GetQCallUinReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 160, 168, 176, 240, 248, 256, 264, 272, 280, 288, 320, 328, 336, 344, 400, 424, 80000, 80008, 80016, 80024, 80032, 80040, 80048, 80056, 80064, 80072, 80080, 80088, 80096, 80104, 80112, 80120, 80128, 80136, 80144, 80152, 80160, 80168, 80176, 80184 }, new String[] { "rpt_uint64_uins", "uint32_req_nick", "uint32_req_gender", "uint32_req_birthday", "uint32_req_in_use_flag", "uint32_req_pre_recycle_flag", "uint32_req_recycle_flag", "uint32_req_frozing_flag", "uint32_req_search_fobid_flag", "uint32_req_login_fobid_flag", "uint32_req_close_friend_recommend_sound", "uint32_req_reg_time", "uint32_req_reg_ip", "uint32_req_recycle_time", "uint32_req_recycle_ip", "uint32_req_photo_ids", "uint32_req_next_photo_id", "uint32_req_remark", "uint32_req_netstatus", "uint32_req_qq", "uint32_req_gsm", "uint32_req_mask_gsm", "uint32_req_is_call_free", "uint32_req_qq_netstatus", "uint32_req_qq_is_call_free", "uint32_req_pstn", "uint32_req_is_ever_pstn", "uint32_req_vip_all_free_time", "uint32_req_vip_left_free_time", "uint32_req_normal_all_free_time", "uint32_req_normal_left_free_time", "uint32_req_used_free_time", "uint32_req_new_gsm", "uint32_req_qq_auto_remark", "uint32_req_profile_card_type", "uint32_req_if_pop_up", "uint32_req_addrlist_time", "uint32_req_identity", "uint32_req_contact_qq", "uint32_req_bind_qq_netstatus", "uint32_req_contact_qq_netstatus" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetQCallUinReq.class);
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_req_addrlist_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_bind_qq_netstatus = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_birthday = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_close_friend_recommend_sound = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_contact_qq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_contact_qq_netstatus = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_frozing_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_gsm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_identity = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_if_pop_up = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_in_use_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_is_call_free = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_is_ever_pstn = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_login_fobid_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_mask_gsm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_netstatus = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_new_gsm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_next_photo_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_nick = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_normal_all_free_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_normal_left_free_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_photo_ids = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_pre_recycle_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_profile_card_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_pstn = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_qq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_qq_auto_remark = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_qq_is_call_free = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_qq_netstatus = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_recycle_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_recycle_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_recycle_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_reg_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_reg_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_remark = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_search_fobid_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_used_free_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_vip_all_free_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_vip_left_free_time = PBField.initUInt32(0);
  }
  
  public static final class GetQCallUinRsp
    extends MessageMicro<GetQCallUinRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_gsm = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_new_gsm = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_photo_ids = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qq_auto_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recycle_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reg_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_addrlist_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bind_qq_netstatus = PBField.initUInt32(0);
    public final PBUInt32Field uint32_birthday = PBField.initUInt32(0);
    public final PBUInt32Field uint32_close_friend_recommend_sound = PBField.initUInt32(0);
    public final PBUInt32Field uint32_contact_qq_netstatus = PBField.initUInt32(0);
    public final PBUInt32Field uint32_frozing_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_identity = PBField.initUInt32(0);
    public final PBUInt32Field uint32_if_pop_up = PBField.initUInt32(0);
    public final PBUInt32Field uint32_in_use_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_call_free = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_ever_pstn = PBField.initUInt32(0);
    public final PBUInt32Field uint32_login_fobid_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mask_gsm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_netstatus = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_photo_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_normal_all_free_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_normal_left_free_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pre_recycle_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_card_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pstn = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qq_is_call_free = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qq_netstatus = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recycle_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recycle_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_reg_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_search_fobid_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_used_free_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vip_all_free_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_vip_left_free_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_contact_qq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 162, 168, 176, 240, 248, 256, 264, 272, 280, 288, 320, 330, 336, 346, 402, 424, 80002, 80008, 80016, 80026, 80032, 80040, 80048, 80056, 80064, 80072, 80080, 80088, 80096, 80104, 80112, 80122, 80130, 80136, 80144, 80152, 80160, 80168, 80176, 80184 }, new String[] { "uint64_uin", "bytes_nick", "uint32_gender", "uint32_birthday", "uint32_in_use_flag", "uint32_pre_recycle_flag", "uint32_recycle_flag", "uint32_frozing_flag", "uint32_search_fobid_flag", "uint32_login_fobid_flag", "uint32_close_friend_recommend_sound", "uint32_reg_time", "bytes_reg_ip", "uint32_recycle_time", "bytes_recycle_ip", "bytes_photo_ids", "uint32_next_photo_id", "bytes_remark", "uint32_netstatus", "uint32_qq", "bytes_gsm", "uint32_mask_gsm", "uint32_is_call_free", "uint32_qq_netstatus", "uint32_qq_is_call_free", "uint32_pstn", "uint32_is_ever_pstn", "uint32_vip_all_free_time", "uint32_vip_left_free_time", "uint32_normal_all_free_time", "uint32_normal_left_free_time", "uint32_used_free_time", "bytes_new_gsm", "bytes_qq_auto_remark", "uint32_profile_card_type", "uint32_if_pop_up", "uint32_addrlist_time", "uint32_identity", "uint64_contact_qq", "uint32_bind_qq_netstatus", "uint32_contact_qq_netstatus" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetQCallUinRsp.class);
    }
  }
  
  public static final class GetQQUinReq
    extends MessageMicro<GetQQUinReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 160016, 160072, 160248, 560000, 560008, 560016, 560024, 560032, 800160 }, new String[] { "rpt_uint64_uins", "uint32_req_nick", "uint32_req_gender", "uint32_req_birthday", "uint32_req_remark", "uint32_req_netstatus", "uint32_req_qcall_id", "uint32_req_is_call_free", "uint32_req_auto_remark", "uint32_req_qcall_nick" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetQQUinReq.class);
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_req_auto_remark = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_birthday = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_is_call_free = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_netstatus = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_nick = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_qcall_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_qcall_nick = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_remark = PBField.initUInt32(0);
  }
  
  public static final class GetQQUinRsp
    extends MessageMicro<GetQQUinRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_auto_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qcall_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_birthday = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_call_free = PBField.initUInt32(0);
    public final PBUInt32Field uint32_netstatus = PBField.initUInt32(0);
    public final PBUInt64Field uint64_qcall_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 160018, 160072, 160248, 560002, 560008, 560016, 560024, 560034, 800162 }, new String[] { "uint64_uin", "bytes_nick", "uint32_gender", "uint32_birthday", "bytes_remark", "uint32_netstatus", "uint64_qcall_id", "uint32_is_call_free", "bytes_auto_remark", "bytes_qcall_nick" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, GetQQUinRsp.class);
    }
  }
  
  public static final class QQLoginSig
    extends MessageMicro<QQLoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_uin", "uint32_type", "bytes_sig", "uint32_appid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, QQLoginSig.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 104, 112, 122, 170 }, new String[] { "rpt_msg_get_qq_uin_req", "rpt_msg_get_qcall_uin_req", "uint64_timestamp", "uint32_max_rsp_len", "msg_qq_login_sig", "msg_get_phone_req" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0), null, null }, ReqBody.class);
    public oidb_0x5e3.GetPhoneReq msg_get_phone_req = new oidb_0x5e3.GetPhoneReq();
    public oidb_0x5e3.QQLoginSig msg_qq_login_sig = new oidb_0x5e3.QQLoginSig();
    public oidb_0x5e3.GetQCallUinReq rpt_msg_get_qcall_uin_req = new oidb_0x5e3.GetQCallUinReq();
    public oidb_0x5e3.GetQQUinReq rpt_msg_get_qq_uin_req = new oidb_0x5e3.GetQQUinReq();
    public final PBUInt32Field uint32_max_rsp_len = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 104, 112, 120, 128, 136, 170 }, new String[] { "rpt_msg_get_qq_uin_rsps", "rpt_msg_get_qcall_uin_rsps", "rpt_uint64_unfilled_qq_uins", "rpt_uint64_unfilled_qcall_uins", "rpt_uint64_not_exist_qq_uins", "rpt_uint64_not_exist_qcall_uins", "uint64_timestamp", "rpt_msg_get_phone_rsps" }, new Object[] { null, null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x5e3.GetPhoneRsp> rpt_msg_get_phone_rsps = PBField.initRepeatMessage(oidb_0x5e3.GetPhoneRsp.class);
    public final PBRepeatMessageField<oidb_0x5e3.GetQCallUinRsp> rpt_msg_get_qcall_uin_rsps = PBField.initRepeatMessage(oidb_0x5e3.GetQCallUinRsp.class);
    public final PBRepeatMessageField<oidb_0x5e3.GetQQUinRsp> rpt_msg_get_qq_uin_rsps = PBField.initRepeatMessage(oidb_0x5e3.GetQQUinRsp.class);
    public final PBRepeatField<Long> rpt_uint64_not_exist_qcall_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_not_exist_qq_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_unfilled_qcall_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_unfilled_qq_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e3.oidb_0x5e3
 * JD-Core Version:    0.7.0.1
 */