package tencent.im.oidb.cmd0xbe1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class cmd0xbe1
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_more_rowkey_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_rowkey_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_bytes_rowkey_list", "rpt_bytes_more_rowkey_list" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe1.cmd0xbe1
 * JD-Core Version:    0.7.0.1
 */