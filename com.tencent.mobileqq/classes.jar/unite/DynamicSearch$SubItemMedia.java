package unite;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicSearch$SubItemMedia
  extends MessageMicro<SubItemMedia>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField coverUrl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField description = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "type", "coverUrl", "description" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, SubItemMedia.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     unite.DynamicSearch.SubItemMedia
 * JD-Core Version:    0.7.0.1
 */