package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb81
{
  public static final class AccountInfo
    extends MessageMicro<AccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_account_type", "uint64_uin", "uint64_friend_status" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, AccountInfo.class);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_friend_status = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class AccountLevelInfo
    extends MessageMicro<AccountLevelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 40, 50, 58 }, new String[] { "uint32_account_cc_level", "account_cc_level_icon_s", "account_cc_level_icon_l" }, new Object[] { Integer.valueOf(0), "", "" }, AccountLevelInfo.class);
    public final PBStringField account_cc_level_icon_l = PBField.initString("");
    public final PBStringField account_cc_level_icon_s = PBField.initString("");
    public final PBUInt32Field uint32_account_cc_level = PBField.initUInt32(0);
  }
  
  public static final class AppUserOpenID
    extends MessageMicro<AppUserOpenID>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_from = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_from", "bytes_appid", "bytes_openid" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, AppUserOpenID.class);
    }
  }
  
  public static final class BindRelationship
    extends MessageMicro<BindRelationship>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_master", "rpt_slave" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, BindRelationship.class);
    public final PBRepeatField<Long> rpt_slave = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_master = PBField.initUInt64(0L);
  }
  
  public static final class GetUserInfoReq
    extends MessageMicro<GetUserInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 82 }, new String[] { "msg_account_info", "msg_user_option", "uint32_info_priority", "msg_shadow_ctl" }, new Object[] { null, null, Integer.valueOf(0), null }, GetUserInfoReq.class);
    public final PBRepeatMessageField<oidb_cmd0xb81.AccountInfo> msg_account_info = PBField.initRepeatMessage(oidb_cmd0xb81.AccountInfo.class);
    public oidb_cmd0xb81.ShadowInfoCtl msg_shadow_ctl = new oidb_cmd0xb81.ShadowInfoCtl();
    public oidb_cmd0xb81.UserInfoOption msg_user_option = new oidb_cmd0xb81.UserInfoOption();
    public final PBUInt32Field uint32_info_priority = PBField.initUInt32(0);
  }
  
  public static final class GetUserInfoRsp
    extends MessageMicro<GetUserInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_user_info" }, new Object[] { null }, GetUserInfoRsp.class);
    public final PBRepeatMessageField<oidb_cmd0xb81.UserInfoItem> rpt_msg_user_info = PBField.initRepeatMessage(oidb_cmd0xb81.UserInfoItem.class);
  }
  
  public static final class HeadInfo
    extends MessageMicro<HeadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 82 }, new String[] { "uint32_face_type", "uint64_timestamp", "uint32_face_flag", "str_url", "uint32_sysid", "uint32_source", "str_big_url" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, HeadInfo.class);
    public final PBStringField str_big_url = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field uint32_face_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_face_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sysid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_client_type", "msg_get_user_info_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public oidb_cmd0xb81.GetUserInfoReq msg_get_user_info_req = new oidb_cmd0xb81.GetUserInfoReq();
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_user_info_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_cmd0xb81.GetUserInfoRsp msg_get_user_info_rsp = new oidb_cmd0xb81.GetUserInfoRsp();
  }
  
  public static final class ShadowInfoCtl
    extends MessageMicro<ShadowInfoCtl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rpt_sys_id", "uint32_op_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ShadowInfoCtl.class);
    public final PBRepeatField<Integer> rpt_sys_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  }
  
  public static final class UserInfoItem
    extends MessageMicro<UserInfoItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_cmd0xb81.AccountLevelInfo account_level_info = new oidb_cmd0xb81.AccountLevelInfo();
    public oidb_cmd0xb81.BindRelationship bind_rel = new oidb_cmd0xb81.BindRelationship();
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_friend_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_kandian_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qq_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_share_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xb81.AccountInfo msg_account_info = new oidb_cmd0xb81.AccountInfo();
    public oidb_cmd0xb81.HeadInfo msg_head_info = new oidb_cmd0xb81.HeadInfo();
    public oidb_cmd0xb81.HeadInfo msg_kandian_head = new oidb_cmd0xb81.HeadInfo();
    public oidb_cmd0xb81.HeadInfo msg_qq_head = new oidb_cmd0xb81.HeadInfo();
    public oidb_cmd0xb81.HeadInfo msg_share_head_url = new oidb_cmd0xb81.HeadInfo();
    public final PBStringField str_bg_pic = PBField.initString("");
    public final PBStringField string_home_url = PBField.initString("");
    public final PBUInt32Field uint32_account_sysid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bg_pic_default = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_home_page_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_info_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mp_auth_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upgc_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
    public oidb_cmd0xb81.AppUserOpenID user_openid = new oidb_cmd0xb81.AppUserOpenID();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 240, 248, 256, 266, 1602, 1608, 1616, 1626, 1632, 1642 }, new String[] { "msg_account_info", "bytes_nick", "msg_head_info", "bytes_qq_nick", "bytes_friend_remark", "bytes_kandian_nick", "msg_qq_head", "msg_kandian_head", "bytes_share_nick", "msg_share_head_url", "bytes_desc", "uint32_mp_auth_flag", "uint32_user_type", "string_home_url", "uint32_account_sysid", "uint32_info_type", "uint32_gender", "account_level_info", "str_bg_pic", "uint32_bg_pic_default", "uint32_home_page_type", "user_openid", "uint32_upgc_flag", "bind_rel" }, new Object[] { null, localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, null, localByteStringMicro5, null, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null }, UserInfoItem.class);
    }
  }
  
  public static final class UserInfoOption
    extends MessageMicro<UserInfoOption>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 240, 248, 256, 264, 1600, 1608, 1616, 1624, 1640 }, new String[] { "uint32_nick", "uint32_head_url", "uint32_qq_nick", "uint32_friend_remark", "uint32_kandian_nick", "uint32_qq_head", "uint32_kandian_head", "uint32_share_nick", "uint32_share_head_url", "uint32_desc", "uint32_mp_auth", "uint32_user_type", "uint32_home_url", "uint32_account_sysid", "uint32_head_real_url", "uint32_gender", "uint32_account_cc_level", "uint32_bg_pic", "uint32_home_page_type", "uint32_openid", "uint32_upgc_flag", "uint32_bind_rel" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UserInfoOption.class);
    public final PBUInt32Field uint32_account_cc_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_account_sysid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bg_pic = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bind_rel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_desc = PBField.initUInt32(0);
    public final PBUInt32Field uint32_friend_remark = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_head_real_url = PBField.initUInt32(0);
    public final PBUInt32Field uint32_head_url = PBField.initUInt32(0);
    public final PBUInt32Field uint32_home_page_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_home_url = PBField.initUInt32(0);
    public final PBUInt32Field uint32_kandian_head = PBField.initUInt32(0);
    public final PBUInt32Field uint32_kandian_nick = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mp_auth = PBField.initUInt32(0);
    public final PBUInt32Field uint32_nick = PBField.initUInt32(0);
    public final PBUInt32Field uint32_openid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qq_head = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qq_nick = PBField.initUInt32(0);
    public final PBUInt32Field uint32_share_head_url = PBField.initUInt32(0);
    public final PBUInt32Field uint32_share_nick = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upgc_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81
 * JD-Core Version:    0.7.0.1
 */