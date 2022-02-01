package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QSecControlBitsQuery
{
  public static final class QSecCbQuery
    extends MessageMicro<QSecCbQuery>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "cb_query_head", "cb_query_body" }, new Object[] { null, null }, QSecCbQuery.class);
    public QSecControlBitsQuery.QSecCbQueryBody cb_query_body = new QSecControlBitsQuery.QSecCbQueryBody();
    public QQProtectCommon.QQProtectQueryHead cb_query_head = new QQProtectCommon.QQProtectQueryHead();
  }
  
  public static final class QSecCbQueryBody
    extends MessageMicro<QSecCbQueryBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u32_cfg_id", "u32_qsec_ver" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, QSecCbQueryBody.class);
    public final PBUInt32Field u32_cfg_id = PBField.initUInt32(0);
    public final PBUInt32Field u32_qsec_ver = PBField.initUInt32(0);
  }
  
  public static final class QSecCbResp
    extends MessageMicro<QSecCbResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "u32_status", "u32_time_interval", "str_cbstr", "str_extra" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "" }, QSecCbResp.class);
    public final PBStringField str_cbstr = PBField.initString("");
    public final PBStringField str_extra = PBField.initString("");
    public final PBUInt32Field u32_status = PBField.initUInt32(0);
    public final PBUInt32Field u32_time_interval = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.QSecControlBitsQuery
 * JD-Core Version:    0.7.0.1
 */