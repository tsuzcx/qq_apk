package tencent.im.oidb.cmd0xdc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ImageInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RspBody;

public final class oidb_cmd0xdc2
{
  public static final class BatchSendReq
    extends MessageMicro<BatchSendReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "send_type", "recv_uin", "recv_openid", "image_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", null }, BatchSendReq.class);
    public oidb_cmd0xb77.ImageInfo image_info = new oidb_cmd0xb77.ImageInfo();
    public final PBStringField recv_openid = PBField.initString("");
    public final PBUInt64Field recv_uin = PBField.initUInt64(0L);
    public final PBUInt32Field send_type = PBField.initUInt32(0);
  }
  
  public static final class BatchSendRsp
    extends MessageMicro<BatchSendRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50 }, new String[] { "send_type", "recv_uin", "recv_openid", "err_code", "err_msg", "rsp_body" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), "", null }, BatchSendRsp.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBStringField recv_openid = PBField.initString("");
    public final PBUInt64Field recv_uin = PBField.initUInt64(0L);
    public oidb_cmd0xb77.RspBody rsp_body = new oidb_cmd0xb77.RspBody();
    public final PBUInt32Field send_type = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_body", "batch_send_req" }, new Object[] { null, null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0xdc2.BatchSendReq> batch_send_req = PBField.initRepeatMessage(oidb_cmd0xdc2.BatchSendReq.class);
    public oidb_cmd0xb77.ReqBody msg_body = new oidb_cmd0xb77.ReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "batch_send_rsp" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xdc2.BatchSendRsp> batch_send_rsp = PBField.initRepeatMessage(oidb_cmd0xdc2.BatchSendRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2
 * JD-Core Version:    0.7.0.1
 */