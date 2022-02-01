package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Unisso
{
  public static final class UniSsoServerReq
    extends MessageMicro<UniSsoServerReq>
  {
    public static final int COMM_FIELD_NUMBER = 1;
    public static final int REQDATA_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public Unisso.UniSsoServerReqComm comm = new Unisso.UniSsoServerReqComm();
    public final PBBytesField reqdata = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "comm", "reqdata" }, new Object[] { null, localByteStringMicro }, UniSsoServerReq.class);
    }
  }
  
  public static final class UniSsoServerReqComm
    extends MessageMicro<UniSsoServerReqComm>
  {
    public static final int MQQVER_FIELD_NUMBER = 3;
    public static final int OSVER_FIELD_NUMBER = 2;
    public static final int PLATFORM_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platform", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, UniSsoServerReqComm.class);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
    public final PBInt64Field platform = PBField.initInt64(0L);
  }
  
  public static final class UniSsoServerRsp
    extends MessageMicro<UniSsoServerRsp>
  {
    public static final int COMM_FIELD_NUMBER = 3;
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int RET_FIELD_NUMBER = 1;
    public static final int RSPDATA_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public Unisso.UniSsoServerRspComm comm = new Unisso.UniSsoServerRspComm();
    public final PBStringField errmsg = PBField.initString("");
    public final PBInt64Field ret = PBField.initInt64(0L);
    public final PBBytesField rspdata = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "ret", "errmsg", "comm", "rspdata" }, new Object[] { Long.valueOf(0L), "", null, localByteStringMicro }, UniSsoServerRsp.class);
    }
  }
  
  public static final class UniSsoServerRspComm
    extends MessageMicro<UniSsoServerRspComm>
  {
    public static final int DELAYMS_FIELD_NUMBER = 1;
    public static final int PACKAGESIZE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "delayms", "packagesize" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, UniSsoServerRspComm.class);
    public final PBUInt32Field delayms = PBField.initUInt32(0);
    public final PBUInt32Field packagesize = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.new_year_2014.Unisso
 * JD-Core Version:    0.7.0.1
 */