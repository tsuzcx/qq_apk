package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ServerApi
{
  public static final class ErrorInfo
    extends MessageMicro<ErrorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "err_code", "err_msg", "jump_url" }, new Object[] { Integer.valueOf(0), "", "" }, ErrorInfo.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
  }
  
  public static final class ReqDownloadCheckRecmd
    extends MessageMicro<ReqDownloadCheckRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "uin", "source", "platform", "pkg_name", "scheme", "url", "extra_info", "ref_source" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", "", "" }, ReqDownloadCheckRecmd.class);
    public final PBStringField extra_info = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBStringField ref_source = PBField.initString("");
    public final PBStringField scheme = PBField.initString("");
    public final PBStringField source = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class ReqJumpCheckRecmd
    extends MessageMicro<ReqJumpCheckRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "uin", "source", "platform", "pkg_name", "scheme", "url", "action", "extra_info", "ref_source" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", "", "", "" }, ReqJumpCheckRecmd.class);
    public final PBStringField action = PBField.initString("");
    public final PBStringField extra_info = PBField.initString("");
    public final PBRepeatField<String> pkg_name = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField platform = PBField.initString("");
    public final PBStringField ref_source = PBField.initString("");
    public final PBStringField scheme = PBField.initString("");
    public final PBStringField source = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class ReqPreDownloadRecmd
    extends MessageMicro<ReqPreDownloadRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uin", "source", "platform", "pkg_name", "scene" }, new Object[] { Long.valueOf(0L), "", "", "", "" }, ReqPreDownloadRecmd.class);
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
    public final PBStringField source = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqUpdateDownCountRecmd
    extends MessageMicro<ReqUpdateDownCountRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uin", "source", "pkg_name", "scene" }, new Object[] { Long.valueOf(0L), "", "", "" }, ReqUpdateDownCountRecmd.class);
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
    public final PBStringField source = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class RspDownloadCheckRecmd
    extends MessageMicro<RspDownloadCheckRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "err_info", "check_pass" }, new Object[] { null, Boolean.valueOf(true) }, RspDownloadCheckRecmd.class);
    public final PBBoolField check_pass = PBField.initBool(true);
    public ServerApi.ErrorInfo err_info = new ServerApi.ErrorInfo();
  }
  
  public static final class RspJumpCheckRecmd
    extends MessageMicro<RspJumpCheckRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "err_info", "jump_method" }, new Object[] { null, Integer.valueOf(0) }, RspJumpCheckRecmd.class);
    public ServerApi.ErrorInfo err_info = new ServerApi.ErrorInfo();
    public final PBUInt32Field jump_method = PBField.initUInt32(0);
  }
  
  public static final class RspPreDownloadRecmd
    extends MessageMicro<RspPreDownloadRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58 }, new String[] { "err_info", "start_time", "end_time", "interval", "daily_num", "quota_num", "download_url" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RspPreDownloadRecmd.class);
    public final PBUInt32Field daily_num = PBField.initUInt32(0);
    public final PBStringField download_url = PBField.initString("");
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public ServerApi.ErrorInfo err_info = new ServerApi.ErrorInfo();
    public final PBUInt32Field interval = PBField.initUInt32(0);
    public final PBUInt32Field quota_num = PBField.initUInt32(0);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
  }
  
  public static final class RspUpdateDownCountRecmd
    extends MessageMicro<RspUpdateDownCountRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "err_info", "download_num" }, new Object[] { null, Integer.valueOf(0) }, RspUpdateDownCountRecmd.class);
    public final PBUInt32Field download_num = PBField.initUInt32(0);
    public ServerApi.ErrorInfo err_info = new ServerApi.ErrorInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.ServerApi
 * JD-Core Version:    0.7.0.1
 */