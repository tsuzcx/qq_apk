package tencent.im.voip.ivr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class voip_ivr
{
  public static final class DialDemoReqBody
    extends MessageMicro<DialDemoReqBody>
  {
    public static final int KEY_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "key" }, new Object[] { "" }, DialDemoReqBody.class);
    public final PBStringField key = PBField.initString("");
  }
  
  public static final class DialDemoRspBody
    extends MessageMicro<DialDemoRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], DialDemoRspBody.class);
  }
  
  public static final class Head
    extends MessageMicro<Head>
  {
    public static final int COMMAND_FIELD_NUMBER = 1;
    public static final int RET_CODE_FIELD_NUMBER = 2;
    public static final int RET_MSG_FIELD_NUMBER = 3;
    public static final int ROOM_ID_FIELD_NUMBER = 4;
    public static final int USER_UIN_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "command", "ret_code", "ret_msg", "room_id", "user_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L) }, Head.class);
    public static final int kDialDemoCmd = 1;
    public static final int kFailRet = 1;
    public static final int kIvrAckCmd = 3;
    public static final int kIvrSubmitCmd = 2;
    public static final int kSeqNotMatch = 2;
    public static final int kSuccRet = 0;
    public final PBUInt32Field command = PBField.initUInt32(0);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBUInt64Field room_id = PBField.initUInt64(0L);
    public final PBUInt64Field user_uin = PBField.initUInt64(0L);
  }
  
  public static final class IvrAckReqBody
    extends MessageMicro<IvrAckReqBody>
  {
    public static final int SEQ_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "seq" }, new Object[] { Integer.valueOf(0) }, IvrAckReqBody.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
  
  public static final class IvrAckRspBody
    extends MessageMicro<IvrAckRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IvrAckRspBody.class);
  }
  
  public static final class IvrSubmitReqBody
    extends MessageMicro<IvrSubmitReqBody>
  {
    public static final int DATA_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { "" }, IvrSubmitReqBody.class);
    public final PBStringField data = PBField.initString("");
  }
  
  public static final class IvrSubmitRspBody
    extends MessageMicro<IvrSubmitRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], IvrSubmitRspBody.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int DIAL_DEMO_BODY_FIELD_NUMBER = 2;
    public static final int HEAD_FIELD_NUMBER = 1;
    public static final int IVR_ACK_BODY_FIELD_NUMBER = 4;
    public static final int IVR_SUBMIT_BODY_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "head", "dial_demo_body", "ivr_submit_body", "ivr_ack_body" }, new Object[] { null, null, null, null }, ReqBody.class);
    public voip_ivr.DialDemoReqBody dial_demo_body = new voip_ivr.DialDemoReqBody();
    public voip_ivr.Head head = new voip_ivr.Head();
    public voip_ivr.IvrAckReqBody ivr_ack_body = new voip_ivr.IvrAckReqBody();
    public voip_ivr.IvrSubmitReqBody ivr_submit_body = new voip_ivr.IvrSubmitReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int DIAL_DEMO_BODY_FIELD_NUMBER = 2;
    public static final int HEAD_FIELD_NUMBER = 1;
    public static final int IVR_ACK_BODY_FIELD_NUMBER = 4;
    public static final int IVR_SUBMIT_BODY_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "head", "dial_demo_body", "ivr_submit_body", "ivr_ack_body" }, new Object[] { null, null, null, null }, RspBody.class);
    public voip_ivr.DialDemoRspBody dial_demo_body = new voip_ivr.DialDemoRspBody();
    public voip_ivr.Head head = new voip_ivr.Head();
    public voip_ivr.IvrAckRspBody ivr_ack_body = new voip_ivr.IvrAckRspBody();
    public voip_ivr.IvrSubmitRspBody ivr_submit_body = new voip_ivr.IvrSubmitRspBody();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.voip.ivr.voip_ivr
 * JD-Core Version:    0.7.0.1
 */