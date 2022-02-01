package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class antiphishingAlertQuery
{
  public static final class RequestPack
    extends MessageMicro<RequestPack>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88 }, new String[] { "u32_app_type", "str_url", "i32_xoffset", "i32_yoffset", "u32_ctrl_width", "u32_ctrl_height", "u64_input_uin", "u32_account_type", "u32_cli_url_ver", "u32_seq", "u32_proto_ver" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RequestPack.class);
    public final PBInt32Field i32_xoffset = PBField.initInt32(0);
    public final PBInt32Field i32_yoffset = PBField.initInt32(0);
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field u32_account_type = PBField.initUInt32(0);
    public final PBUInt32Field u32_app_type = PBField.initUInt32(0);
    public final PBUInt32Field u32_cli_url_ver = PBField.initUInt32(0);
    public final PBUInt32Field u32_ctrl_height = PBField.initUInt32(0);
    public final PBUInt32Field u32_ctrl_width = PBField.initUInt32(0);
    public final PBUInt32Field u32_proto_ver = PBField.initUInt32(0);
    public final PBUInt32Field u32_seq = PBField.initUInt32(0);
    public final PBUInt64Field u64_input_uin = PBField.initUInt64(0L);
  }
  
  public static final class ResponsePack
    extends MessageMicro<ResponsePack>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 72, 82, 90, 96 }, new String[] { "u32_app_type", "u32_alert_type", "u32_default_wording", "str_toast", "str_dialog_title", "str_dialog_text", "str_dialog_btn_left", "str_dialog_btn_right", "u32_svr_url_ver", "str_download_link", "str_hash", "u32_seq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), "", "", Integer.valueOf(0) }, ResponsePack.class);
    public final PBStringField str_dialog_btn_left = PBField.initString("");
    public final PBStringField str_dialog_btn_right = PBField.initString("");
    public final PBStringField str_dialog_text = PBField.initString("");
    public final PBStringField str_dialog_title = PBField.initString("");
    public final PBStringField str_download_link = PBField.initString("");
    public final PBStringField str_hash = PBField.initString("");
    public final PBStringField str_toast = PBField.initString("");
    public final PBUInt32Field u32_alert_type = PBField.initUInt32(0);
    public final PBUInt32Field u32_app_type = PBField.initUInt32(0);
    public final PBUInt32Field u32_default_wording = PBField.initUInt32(0);
    public final PBUInt32Field u32_seq = PBField.initUInt32(0);
    public final PBUInt32Field u32_svr_url_ver = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.antiphishingAlertQuery
 * JD-Core Version:    0.7.0.1
 */