package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class im_msg_body$MarketTrans
  extends MessageMicro
{
  public static final int BYTES_MSG_RESID_FIELD_NUMBER = 3;
  public static final int BYTES_XML_FIELD_NUMBER = 2;
  public static final int INT32_FLAG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_xml = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_flag = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_flag", "bytes_xml", "bytes_msg_resid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, MarketTrans.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.MarketTrans
 * JD-Core Version:    0.7.0.1
 */