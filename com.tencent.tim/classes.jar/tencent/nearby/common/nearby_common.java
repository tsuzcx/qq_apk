package tencent.nearby.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_common
{
  public static final class ErrorInfo
    extends MessageMicro<ErrorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBBytesField error_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "error_code", "error_desc" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ErrorInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.nearby.common.nearby_common
 * JD-Core Version:    0.7.0.1
 */