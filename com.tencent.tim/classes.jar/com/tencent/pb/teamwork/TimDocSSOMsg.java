package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TimDocSSOMsg
{
  public static final class BatchGetReqBody
    extends MessageMicro<BatchGetReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_appid", "msg_login_info", "rpt_msg_padid_list" }, new Object[] { Integer.valueOf(0), null, null }, BatchGetReqBody.class);
    public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
    public final PBRepeatMessageField<TimDocSSOMsg.PadId> rpt_msg_padid_list = PBField.initRepeatMessage(TimDocSSOMsg.PadId.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  }
  
  public static final class BatchGetRspBody
    extends MessageMicro<BatchGetRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_retcode", "rpt_msg_pad_list" }, new Object[] { Integer.valueOf(0), null }, BatchGetRspBody.class);
    public final PBRepeatMessageField<TimDocSSOMsg.PadInfo> rpt_msg_pad_list = PBField.initRepeatMessage(TimDocSSOMsg.PadInfo.class);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
  }
  
  public static final class CancelPinPadReqBody
    extends MessageMicro<CancelPinPadReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_list_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "uint32_appid", "bytes_pad_url", "msg_login_info", "uint32_list_type", "uint32_domainid", "bytes_localpadid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, CancelPinPadReqBody.class);
    }
  }
  
  public static final class CancelPinPadRspBody
    extends MessageMicro<CancelPinPadRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_list_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "uint32_retcode", "bytes_pad_url", "uint32_list_type", "uint32_domainid", "bytes_localpadid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, CancelPinPadRspBody.class);
    }
  }
  
  public static final class DeletePadReqBody
    extends MessageMicro<DeletePadReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
    public final PBRepeatMessageField<TimDocSSOMsg.PadId> rpt_msg_padid_list = PBField.initRepeatMessage(TimDocSSOMsg.PadId.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_list_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 58 }, new String[] { "uint32_appid", "bytes_pad_url", "msg_login_info", "uint32_list_type", "uint32_domainid", "bytes_localpadid", "rpt_msg_padid_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, null }, DeletePadReqBody.class);
    }
  }
  
  public static final class DeletePadRspBody
    extends MessageMicro<DeletePadRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<TimDocSSOMsg.PadId> rpt_msg_padid_list = PBField.initRepeatMessage(TimDocSSOMsg.PadId.class);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_list_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "uint32_retcode", "bytes_pad_url", "uint32_list_type", "uint32_domainid", "bytes_localpadid", "rpt_msg_padid_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, null }, DeletePadRspBody.class);
    }
  }
  
  public static final class GetPadListReqBody
    extends MessageMicro<GetPadListReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_timestamp = PBField.initBytes(ByteStringMicro.EMPTY);
    public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_list_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_local_count_from_offset = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
    public final PBUInt32Field uint32_request_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66, 72 }, new String[] { "uint32_appid", "uint32_timestamp", "uint32_offset", "uint32_count", "uint32_local_count_from_offset", "msg_login_info", "uint32_request_type", "bytes_timestamp", "uint32_list_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, GetPadListReqBody.class);
    }
  }
  
  public static final class GetPadListRspBody
    extends MessageMicro<GetPadListRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_endflag = PBField.initBool(false);
    public final PBBytesField bytes_timestamp = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<TimDocSSOMsg.PadInfo> rpt_msg_pad_list = PBField.initRepeatMessage(TimDocSSOMsg.PadInfo.class);
    public final PBUInt32Field uint32_auto_fresh_interval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64 }, new String[] { "uint32_retcode", "uint32_total_count", "uint32_timestamp", "uint32_offset", "bool_endflag", "rpt_msg_pad_list", "bytes_timestamp", "uint32_auto_fresh_interval" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), null, localByteStringMicro, Integer.valueOf(0) }, GetPadListRspBody.class);
    }
  }
  
  public static final class GetPadRightInfoReqBody
    extends MessageMicro<GetPadRightInfoReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint32_appid", "bytes_pad_url", "msg_login_info", "uint32_domainid", "bytes_localpadid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, Integer.valueOf(0), localByteStringMicro2 }, GetPadRightInfoReqBody.class);
    }
  }
  
  public static final class GetPadRightInfoRspBody
    extends MessageMicro<GetPadRightInfoRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<TimDocSSOMsg.UinRightInfo> rpt_msg_uin_right_info = PBField.initRepeatMessage(TimDocSSOMsg.UinRightInfo.class);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pad_right = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50 }, new String[] { "uint32_retcode", "bytes_pad_url", "uint32_pad_right", "rpt_msg_uin_right_info", "uint32_domainid", "bytes_localpadid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro2 }, GetPadRightInfoRspBody.class);
    }
  }
  
  public static final class GetSharedPadListReqBody
    extends MessageMicro<GetSharedPadListReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint32_appid", "uint32_timestamp", "uint32_offset", "uint32_count", "uint32_needmore", "msg_login_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, GetSharedPadListReqBody.class);
    public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_needmore = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  }
  
  public static final class GetSharedPadListRspBody
    extends MessageMicro<GetSharedPadListRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint32_retcode", "uint32_total_count", "uint32_timestamp", "rpt_msg_pad_list", "uint32_offset", "bool_endflag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Boolean.valueOf(false) }, GetSharedPadListRspBody.class);
    public final PBBoolField bool_endflag = PBField.initBool(false);
    public final PBRepeatMessageField<TimDocSSOMsg.PadInfo> rpt_msg_pad_list = PBField.initRepeatMessage(TimDocSSOMsg.PadInfo.class);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
  }
  
  public static final class GetTipFlagReqBody
    extends MessageMicro<GetTipFlagReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_appid", "msg_login_info", "uint32_type" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, GetTipFlagReqBody.class);
    public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class GetTipFlagRspBody
    extends MessageMicro<GetTipFlagRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_retcode", "uint32_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetTipFlagRspBody.class);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
  }
  
  public static final class LoginInfo
    extends MessageMicro<LoginInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pskey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_skey = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_skey", "bytes_pskey" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, LoginInfo.class);
    }
  }
  
  public static final class PadId
    extends MessageMicro<PadId>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_domainid", "bytes_localpadid", "bytes_pad_url", "uint32_retcode" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, PadId.class);
    }
  }
  
  public static final class PadInfo
    extends MessageMicro<PadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_delete_flag = PBField.initBool(false);
    public final PBBoolField bool_pinned_flag = PBField.initBool(false);
    public final PBBytesField bytes_creator_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_hostuser_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_last_editor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_last_viewer_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_policy = PBField.initUInt32(0);
    public final PBUInt32Field uint32_right_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_creator_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_current_user_browse_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_hostuser_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_auth_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_delete_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_edit_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_editor_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_pinned_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_unpinned_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_view_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_viewer_uin = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50, 56, 66, 72, 80, 88, 98, 104, 112, 120, 128, 138, 144, 152, 160, 168, 178, 184, 192, 200, 210 }, new String[] { "bytes_pad_url", "uint32_type", "bytes_title", "uint64_create_time", "uint64_creator_uin", "bytes_creator_nick", "uint64_last_editor_uin", "bytes_last_editor_nick", "uint64_last_edit_time", "bool_pinned_flag", "uint64_last_viewer_uin", "bytes_last_viewer_nick", "uint64_last_view_time", "uint64_last_pinned_time", "uint64_current_user_browse_time", "uint64_hostuser_uin", "bytes_hostuser_nick", "uint64_last_auth_time", "uint32_policy", "uint32_right_flag", "uint32_domainid", "bytes_localpadid", "uint64_last_unpinned_time", "bool_delete_flag", "uint64_last_delete_time", "bytes_thumb_url" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), localByteStringMicro5, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), localByteStringMicro8 }, PadInfo.class);
    }
  }
  
  public static final class PinPadReqBody
    extends MessageMicro<PinPadReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_list_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "uint32_appid", "bytes_pad_url", "msg_login_info", "uint32_list_type", "uint32_domainid", "bytes_localpadid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, PinPadReqBody.class);
    }
  }
  
  public static final class PinPadRspBody
    extends MessageMicro<PinPadRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_list_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_pinned_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "uint32_retcode", "bytes_pad_url", "uint64_last_pinned_time", "uint32_list_type", "uint32_domainid", "bytes_localpadid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, PinPadRspBody.class);
    }
  }
  
  public static final class SetPadRightInfoReqBody
    extends MessageMicro<SetPadRightInfoReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
    public final PBRepeatMessageField<TimDocSSOMsg.UinRightInfo> rpt_msg_uin_right_info = PBField.initRepeatMessage(TimDocSSOMsg.UinRightInfo.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pad_right = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 58 }, new String[] { "uint32_appid", "bytes_pad_url", "msg_login_info", "uint32_pad_right", "rpt_msg_uin_right_info", "uint32_domainid", "bytes_localpadid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro2 }, SetPadRightInfoReqBody.class);
    }
  }
  
  public static final class SetPadRightInfoRspBody
    extends MessageMicro<SetPadRightInfoRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_domainiid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 32, 42 }, new String[] { "uint32_retcode", "bytes_pad_url", "uint32_domainiid", "bytes_localpadid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, SetPadRightInfoRspBody.class);
    }
  }
  
  public static final class SetTipFlagReqBody
    extends MessageMicro<SetTipFlagReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_appid", "msg_login_info", "uint32_type", "uint32_flag" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, SetTipFlagReqBody.class);
    public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class SetTipFlagRspBody
    extends MessageMicro<SetTipFlagRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_retcode" }, new Object[] { Integer.valueOf(0) }, SetTipFlagRspBody.class);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
  }
  
  public static final class UinRightInfo
    extends MessageMicro<UinRightInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_uin_type", "uint64_uin", "uint32_right" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, UinRightInfo.class);
    public final PBUInt32Field uint32_right = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uin_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg
 * JD-Core Version:    0.7.0.1
 */