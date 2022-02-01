package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_imagent
{
  public static final class ImAgentHead
    extends MessageMicro<ImAgentHead>
  {
    public static final int COMMAND_FIELD_NUMBER = 1;
    public static final int ECHO_BUF_FIELD_NUMBER = 5;
    public static final int ERR_FIELD_NUMBER = 4;
    public static final int REQ_INFO_FIELD_NUMBER = 7;
    public static final int REQ_USER_FIELD_NUMBER = 6;
    public static final int RESULT_FIELD_NUMBER = 3;
    public static final int SEQ_FIELD_NUMBER = 2;
    public static final int SERVER_IP_FIELD_NUMBER = 10;
    public static final int SIGNATURE_FIELD_NUMBER = 8;
    public static final int SUB_CMD_FIELD_NUMBER = 9;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField command = PBField.initEnum(1);
    public final PBBytesField echo_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField err = PBField.initString("");
    public im_imagent.Requestinfo req_info = new im_imagent.Requestinfo();
    public im_common.User req_user = new im_common.User();
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field server_ip = PBField.initUInt32(0);
    public im_imagent.Signature signature = new im_imagent.Signature();
    public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 72, 80 }, new String[] { "command", "seq", "result", "err", "echo_buf", "req_user", "req_info", "signature", "sub_cmd", "server_ip" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro, null, null, null, Integer.valueOf(0), Integer.valueOf(0) }, ImAgentHead.class);
    }
  }
  
  public static final class ImAgentPackage
    extends MessageMicro<ImAgentPackage>
  {
    public static final int HEAD_FIELD_NUMBER = 1;
    public static final int MSG_SEND_REQ_FIELD_NUMBER = 11;
    public static final int MSG_SEND_RESP_FIELD_NUMBER = 12;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 90, 98 }, new String[] { "head", "msg_send_req", "msg_send_resp" }, new Object[] { null, null, null }, ImAgentPackage.class);
    public im_imagent.ImAgentHead head = new im_imagent.ImAgentHead();
    public im_msg.MsgSendReq msg_send_req = new im_msg.MsgSendReq();
    public im_msg.MsgSendResp msg_send_resp = new im_msg.MsgSendResp();
  }
  
  public static final class Requestinfo
    extends MessageMicro<Requestinfo>
  {
    public static final int REQ_FLAG_FIELD_NUMBER = 3;
    public static final int REQ_IP_FIELD_NUMBER = 1;
    public static final int REQ_PORT_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 16, 24 }, new String[] { "req_ip", "req_port", "req_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Requestinfo.class);
    public final PBUInt32Field req_flag = PBField.initUInt32(0);
    public final PBFixed32Field req_ip = PBField.initFixed32(0);
    public final PBUInt32Field req_port = PBField.initUInt32(0);
  }
  
  public static final class Signature
    extends MessageMicro<Signature>
  {
    public static final int KEY_TYPE_FIELD_NUMBER = 1;
    public static final int SESSION_APP_ID_FIELD_NUMBER = 2;
    public static final int SESSION_KEY_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field key_type = PBField.initUInt32(0);
    public final PBUInt32Field session_app_id = PBField.initUInt32(0);
    public final PBBytesField session_key = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "key_type", "session_app_id", "session_key" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, Signature.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.msg.im_imagent
 * JD-Core Version:    0.7.0.1
 */