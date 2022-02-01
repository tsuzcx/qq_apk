package tencent.im.oidb.cmd0xada;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xada
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField a2 = PBField.initString("");
    public final PBBytesField busi_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field not_register = PBField.initUInt32(0);
    public final PBUInt64Field now_id = PBField.initUInt64(0L);
    public final PBStringField original_id = PBField.initString("");
    public final PBUInt32Field original_id_type = PBField.initUInt32(0);
    public final PBStringField original_key = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt32Field stream_type = PBField.initUInt32(0);
    public final PBUInt32Field subcmd = PBField.initUInt32(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBStringField version = PBField.initString("");
    public final PBUInt32Field version_code = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 56, 64, 74, 82, 88, 96, 104, 112, 120 }, new String[] { "uid", "tinyid", "a2", "platform", "version", "busi_buf", "version_code", "stream_type", "original_id", "original_key", "original_id_type", "cmd", "subcmd", "not_register", "now_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busi_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field proxy_code = PBField.initUInt32(0);
    public final PBUInt32Field report = PBField.initUInt32(0);
    public final PBUInt32Field stream_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "proxy_code", "err_msg", "busi_buf", "report", "stream_type" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xada.oidb_0xada
 * JD-Core Version:    0.7.0.1
 */