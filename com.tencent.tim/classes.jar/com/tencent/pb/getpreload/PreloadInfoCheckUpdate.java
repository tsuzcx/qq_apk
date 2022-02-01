package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PreloadInfoCheckUpdate
{
  public static final class AppBehavior
    extends MessageMicro<AppBehavior>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "appid", "click_num", "click_red_num", "red_state" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AppBehavior.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBInt32Field click_num = PBField.initInt32(0);
    public final PBInt32Field click_red_num = PBField.initInt32(0);
    public final PBInt32Field red_state = PBField.initInt32(0);
  }
  
  public static final class ControlReqHead
    extends MessageMicro<ControlReqHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58 }, new String[] { "protocol_ver", "client_plat_id", "client_ver", "os_ver", "uin", "mem", "ext1" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L), Integer.valueOf(0), "" }, ControlReqHead.class);
    public final PBInt32Field client_plat_id = PBField.initInt32(0);
    public final PBStringField client_ver = PBField.initString("");
    public final PBStringField ext1 = PBField.initString("");
    public final PBUInt32Field mem = PBField.initUInt32(0);
    public final PBStringField os_ver = PBField.initString("");
    public final PBInt32Field protocol_ver = PBField.initInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class ControlRspHead
    extends MessageMicro<ControlRspHead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "code", "err_msg" }, new Object[] { Integer.valueOf(0), "" }, ControlRspHead.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
  }
  
  public static final class FirstShowReq
    extends MessageMicro<FirstShowReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "head", "appid" }, new Object[] { null, Integer.valueOf(0) }, FirstShowReq.class);
    public final PBInt32Field appid = PBField.initInt32(0);
    public PreloadInfoCheckUpdate.ControlReqHead head = new PreloadInfoCheckUpdate.ControlReqHead();
  }
  
  public static final class FirstShowRsp
    extends MessageMicro<FirstShowRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "data" }, new Object[] { null, "" }, FirstShowRsp.class);
    public final PBStringField data = PBField.initString("");
    public PreloadInfoCheckUpdate.ControlRspHead head = new PreloadInfoCheckUpdate.ControlRspHead();
  }
  
  public static final class PreloadInfoReq
    extends MessageMicro<PreloadInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "app_behavior" }, new Object[] { null, null }, PreloadInfoReq.class);
    public final PBRepeatMessageField<PreloadInfoCheckUpdate.AppBehavior> app_behavior = PBField.initRepeatMessage(PreloadInfoCheckUpdate.AppBehavior.class);
    public PreloadInfoCheckUpdate.ControlReqHead head = new PreloadInfoCheckUpdate.ControlReqHead();
  }
  
  public static final class PreloadInfoRsp
    extends MessageMicro<PreloadInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 56, 66 }, new String[] { "head", "preload_switch", "preload", "interval", "applist", "red_ram", "click_ram", "preload_result" }, new Object[] { null, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null }, PreloadInfoRsp.class);
    public final PBRepeatField<String> applist = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field click_ram = PBField.initInt32(0);
    public PreloadInfoCheckUpdate.ControlRspHead head = new PreloadInfoCheckUpdate.ControlRspHead();
    public final PBInt32Field interval = PBField.initInt32(0);
    public final PBBoolField preload = PBField.initBool(false);
    public final PBRepeatMessageField<PreloadInfoCheckUpdate.PreloadResult> preload_result = PBField.initRepeatMessage(PreloadInfoCheckUpdate.PreloadResult.class);
    public final PBInt32Field preload_switch = PBField.initInt32(0);
    public final PBInt32Field red_ram = PBField.initInt32(0);
  }
  
  public static final class PreloadResult
    extends MessageMicro<PreloadResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "appid", "preload_switch", "preload", "preload_data", "mem_limit", "ext1" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), "" }, PreloadResult.class);
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBStringField ext1 = PBField.initString("");
    public final PBInt32Field mem_limit = PBField.initInt32(0);
    public final PBBoolField preload = PBField.initBool(false);
    public final PBBoolField preload_data = PBField.initBool(false);
    public final PBInt32Field preload_switch = PBField.initInt32(0);
  }
  
  public static final class WebJsInfo
    extends MessageMicro<WebJsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66 }, new String[] { "head", "err_page_url", "err_file", "err_line", "err_message", "err_timestamp", "err_level", "phone_model" }, new Object[] { null, "", "", "", "", Long.valueOf(0L), "", "" }, WebJsInfo.class);
    public final PBStringField err_file = PBField.initString("");
    public final PBStringField err_level = PBField.initString("");
    public final PBStringField err_line = PBField.initString("");
    public final PBStringField err_message = PBField.initString("");
    public final PBStringField err_page_url = PBField.initString("");
    public final PBInt64Field err_timestamp = PBField.initInt64(0L);
    public PreloadInfoCheckUpdate.ControlReqHead head = new PreloadInfoCheckUpdate.ControlReqHead();
    public final PBStringField phone_model = PBField.initString("");
  }
  
  public static final class WebViewConfigReq
    extends MessageMicro<WebViewConfigReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "head" }, new Object[] { null }, WebViewConfigReq.class);
    public PreloadInfoCheckUpdate.ControlReqHead head = new PreloadInfoCheckUpdate.ControlReqHead();
  }
  
  public static final class WebViewConfigRsp
    extends MessageMicro<WebViewConfigRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "head", "url_check", "url_list", "js_report", "interval" }, new Object[] { null, Boolean.valueOf(false), "", Boolean.valueOf(false), Integer.valueOf(0) }, WebViewConfigRsp.class);
    public PreloadInfoCheckUpdate.ControlRspHead head = new PreloadInfoCheckUpdate.ControlRspHead();
    public final PBInt32Field interval = PBField.initInt32(0);
    public final PBBoolField js_report = PBField.initBool(false);
    public final PBBoolField url_check = PBField.initBool(false);
    public final PBRepeatField<String> url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate
 * JD-Core Version:    0.7.0.1
 */