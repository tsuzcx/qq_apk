package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQProtectRisks
{
  public static final class QQProtectRisksRequest
    extends MessageMicro<QQProtectRisksRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_sec_cmd", "str_package_name", "uint32_app_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, QQProtectRisksRequest.class);
    public final PBStringField str_package_name = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
  }
  
  public static final class QQProtectRisksResponse
    extends MessageMicro<QQProtectRisksResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 58 }, new String[] { "uint32_sec_cmd", "str_no_risk_text", "risk_info_list", "uint32_qpim_switches", "str_risk_tip_text", "uint32_cache_time", "str_risk_exist" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0), "", Integer.valueOf(0), "" }, QQProtectRisksResponse.class);
    public final PBRepeatMessageField<QQProtectRisks.RiskInfo> risk_info_list = PBField.initRepeatMessage(QQProtectRisks.RiskInfo.class);
    public final PBStringField str_no_risk_text = PBField.initString("");
    public final PBStringField str_risk_exist = PBField.initString("");
    public final PBStringField str_risk_tip_text = PBField.initString("");
    public final PBUInt32Field uint32_cache_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qpim_switches = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
  }
  
  public static final class RiskInfo
    extends MessageMicro<RiskInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 66 }, new String[] { "uint32_item_type", "str_left_text", "str_right_text", "str_desc_text", "str_jump_target", "uint32_click_report_id", "uint32_item_id", "str_right_text_open" }, new Object[] { Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "" }, RiskInfo.class);
    public final PBStringField str_desc_text = PBField.initString("");
    public final PBStringField str_jump_target = PBField.initString("");
    public final PBStringField str_left_text = PBField.initString("");
    public final PBStringField str_right_text = PBField.initString("");
    public final PBStringField str_right_text_open = PBField.initString("");
    public final PBUInt32Field uint32_click_report_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_item_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_item_type = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.QQProtectRisks
 * JD-Core Version:    0.7.0.1
 */