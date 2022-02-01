package tencent.im;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PasswdUrlReport
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "upload_type", "upload_req_item" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public PasswdUrlReport.UploadReqItem upload_req_item = new PasswdUrlReport.UploadReqItem();
    public final PBInt32Field upload_type = PBField.initInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "upload_rsp_item" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public PasswdUrlReport.UploadRespItem upload_rsp_item = new PasswdUrlReport.UploadRespItem();
  }
  
  public static final class UploadReqItem
    extends MessageMicro<UploadReqItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<String> js_func_features = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField origin_url = PBField.initString("");
    public final PBInt32Field passwd_input = PBField.initInt32(0);
    public final PBInt32Field passwd_show = PBField.initInt32(0);
    public final PBStringField screenshot = PBField.initString("");
    public final PBRepeatField<String> text_features = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField title = PBField.initString("");
    public final PBBytesField uin = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72 }, new String[] { "url", "origin_url", "text_features", "js_func_features", "screenshot", "title", "uin", "passwd_show", "passwd_input" }, new Object[] { "", "", "", "", "", "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, UploadReqItem.class);
    }
  }
  
  public static final class UploadRespItem
    extends MessageMicro<UploadRespItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "ret_msg" }, new Object[] { Integer.valueOf(0), "" }, UploadRespItem.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.PasswdUrlReport
 * JD-Core Version:    0.7.0.1
 */