package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb49
{
  public static final class ARClassifyLBSCheckReq
    extends MessageMicro<ARClassifyLBSCheckReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_id" }, new Object[] { "" }, ARClassifyLBSCheckReq.class);
    public final PBStringField str_id = PBField.initString("");
  }
  
  public static final class ARClassifyLBSCheckRsp
    extends MessageMicro<ARClassifyLBSCheckRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "str_id", "uint32_lbs_result", "msg_nearest_point" }, new Object[] { "", Integer.valueOf(0), null }, ARClassifyLBSCheckRsp.class);
    public oidb_cmd0xb49.LBSPoint msg_nearest_point = new oidb_cmd0xb49.LBSPoint();
    public final PBStringField str_id = PBField.initString("");
    public final PBUInt32Field uint32_lbs_result = PBField.initUInt32(0);
  }
  
  public static final class LBSPoint
    extends MessageMicro<LBSPoint>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "int32_lat", "int32_lon", "str_name", "str_addr", "uint32_dist" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), "", "", Integer.valueOf(0) }, LBSPoint.class);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBStringField str_addr = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt32Field uint32_dist = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82 }, new String[] { "int32_lat", "int32_lon", "msg_ar_classify_req" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), null }, ReqBody.class);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public oidb_cmd0xb49.ARClassifyLBSCheckReq msg_ar_classify_req = new oidb_cmd0xb49.ARClassifyLBSCheckReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82 }, new String[] { "msg_ar_classify_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_cmd0xb49.ARClassifyLBSCheckRsp msg_ar_classify_rsp = new oidb_cmd0xb49.ARClassifyLBSCheckRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.oidb_cmd0xb49
 * JD-Core Version:    0.7.0.1
 */