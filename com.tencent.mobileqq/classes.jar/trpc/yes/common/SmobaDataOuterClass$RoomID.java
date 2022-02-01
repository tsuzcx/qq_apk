package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SmobaDataOuterClass$RoomID
  extends MessageMicro<RoomID>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field roomid = PBField.initUInt32(0);
  public final PBUInt32Field roomseq = PBField.initUInt32(0);
  public final PBUInt32Field roomsvrentityid = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "roomid", "roomseq", "roomsvrentityid" }, new Object[] { localInteger, localInteger, localInteger }, RoomID.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.SmobaDataOuterClass.RoomID
 * JD-Core Version:    0.7.0.1
 */