package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WebSsoBody
{
  public static final class STServiceMonitItem
    extends MessageMicro<STServiceMonitItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "cmd", "url", "errcode", "cost", "src" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, STServiceMonitItem.class);
    public final PBStringField cmd = PBField.initString("");
    public final PBUInt32Field cost = PBField.initUInt32(0);
    public final PBInt32Field errcode = PBField.initInt32(0);
    public final PBUInt32Field src = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class STServiceMonitReq
    extends MessageMicro<STServiceMonitReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "list" }, new Object[] { null }, STServiceMonitReq.class);
    public final PBRepeatMessageField<WebSsoBody.STServiceMonitItem> list = PBField.initRepeatMessage(WebSsoBody.STServiceMonitItem.class);
  }
  
  public static final class WebSsoControlData
    extends MessageMicro<WebSsoControlData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "frequency", "packageSize" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, WebSsoControlData.class);
    public final PBUInt32Field frequency = PBField.initUInt32(0);
    public final PBUInt32Field packageSize = PBField.initUInt32(0);
  }
  
  public static final class WebSsoRequestBody
    extends MessageMicro<WebSsoRequestBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "version", "type", "data", "webData" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "" }, WebSsoRequestBody.class);
    public final PBStringField data = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBStringField webData = PBField.initString("");
  }
  
  public static final class WebSsoResponseBody
    extends MessageMicro<WebSsoResponseBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "version", "type", "ret", "data", "controlData" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null }, WebSsoResponseBody.class);
    public WebSsoBody.WebSsoControlData controlData = new WebSsoBody.WebSsoControlData();
    public final PBStringField data = PBField.initString("");
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.WebSsoBody
 * JD-Core Version:    0.7.0.1
 */