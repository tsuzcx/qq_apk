package com.tencent.mobileqq.webdownload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DownloadURLCheck
{
  public static final class ReqDownloadUrlCheckRecmd
    extends MessageMicro<ReqDownloadUrlCheckRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uin", "mime_type", "host_url", "download_url", "extra_info" }, new Object[] { Long.valueOf(0L), "", "", "", "" }, ReqDownloadUrlCheckRecmd.class);
    public final PBStringField download_url = PBField.initString("");
    public final PBStringField extra_info = PBField.initString("");
    public final PBStringField host_url = PBField.initString("");
    public final PBStringField mime_type = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class RspDownloadUrlCheckRecmd
    extends MessageMicro<RspDownloadUrlCheckRecmd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "err_code", "err_msg", "is_white_url", "pkg_name", "extra_info" }, new Object[] { Integer.valueOf(0), "", Boolean.valueOf(false), "", "" }, RspDownloadUrlCheckRecmd.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBStringField extra_info = PBField.initString("");
    public final PBBoolField is_white_url = PBField.initBool(false);
    public final PBStringField pkg_name = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webdownload.DownloadURLCheck
 * JD-Core Version:    0.7.0.1
 */