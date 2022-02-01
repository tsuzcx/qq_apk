package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserProxyCmdOuterClass$Birthday
  extends MessageMicro<Birthday>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field day = PBField.initUInt32(0);
  public final PBUInt32Field month = PBField.initUInt32(0);
  public final PBUInt32Field year = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "year", "month", "day" }, new Object[] { localInteger, localInteger, localInteger }, Birthday.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.Birthday
 * JD-Core Version:    0.7.0.1
 */