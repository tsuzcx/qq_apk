package tencent.im.qim.trans.QIMVideoUpload;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QIMVideoUpload
{
  public static final class ErrorInfo
    extends MessageMicro<ErrorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_err_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_err_code", "bytes_err_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ErrorInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_video_uuid = PBField.initString("");
    public final PBUInt64Field uint64_data_type = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_not_notify_story_flag = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_pic_type = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_service_type = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 800, 810 }, new String[] { "uint64_uin", "uint64_service_type", "uint64_data_type", "bytes_md5", "uint64_not_notify_story_flag", "uint64_pic_type", "str_video_uuid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), "" }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 80, 88, 98 }, new String[] { "msg_err", "uint64_uin", "uint64_service_type", "str_uuid" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), "" }, RspBody.class);
    public QIMVideoUpload.ErrorInfo msg_err = new QIMVideoUpload.ErrorInfo();
    public final PBStringField str_uuid = PBField.initString("");
    public final PBUInt64Field uint64_service_type = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload
 * JD-Core Version:    0.7.0.1
 */