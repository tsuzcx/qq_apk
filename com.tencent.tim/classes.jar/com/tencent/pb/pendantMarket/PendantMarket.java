package com.tencent.pb.pendantMarket;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PendantMarket
{
  public static final class SetAddonReq
    extends MessageMicro<SetAddonReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 64, 72 }, new String[] { "cmd", "int_platform", "int_version", "long_addon_id", "str_qq_version", "int_valid_days", "str_open_key", "i_key_type", "int_from_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, SetAddonReq.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field i_key_type = PBField.initUInt32(0);
    public final PBUInt32Field int_from_type = PBField.initUInt32(0);
    public final PBUInt32Field int_platform = PBField.initUInt32(0);
    public final PBUInt32Field int_valid_days = PBField.initUInt32(0);
    public final PBUInt32Field int_version = PBField.initUInt32(0);
    public final PBUInt64Field long_addon_id = PBField.initUInt64(0L);
    public final PBStringField str_open_key = PBField.initString("");
    public final PBStringField str_qq_version = PBField.initString("");
  }
  
  public static final class SetAddonRsp
    extends MessageMicro<SetAddonRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int_result", "str_msg", "str_url", "tips_info" }, new Object[] { Integer.valueOf(0), "", "", null }, SetAddonRsp.class);
    public final PBUInt32Field int_result = PBField.initUInt32(0);
    public final PBStringField str_msg = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public PendantMarket.TipsInfo tips_info = new PendantMarket.TipsInfo();
  }
  
  public static final class TipsInfo
    extends MessageMicro<TipsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 72, 82 }, new String[] { "valid", "ret", "type", "title_wording", "wording", "right_btn_wording", "left_btn_wording", "vip_type", "vip_month", "url" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), "" }, TipsInfo.class);
    public final PBStringField left_btn_wording = PBField.initString("");
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField right_btn_wording = PBField.initString("");
    public final PBStringField title_wording = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBBoolField valid = PBField.initBool(false);
    public final PBUInt32Field vip_month = PBField.initUInt32(0);
    public final PBStringField vip_type = PBField.initString("");
    public final PBStringField wording = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.pendantMarket.PendantMarket
 * JD-Core Version:    0.7.0.1
 */