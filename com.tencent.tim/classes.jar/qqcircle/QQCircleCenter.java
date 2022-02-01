package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCenter
{
  public static final class GetCircleDetailReq
    extends MessageMicro<GetCircleDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "id" }, new Object[] { "" }, GetCircleDetailReq.class);
    public final PBStringField id = PBField.initString("");
  }
  
  public static final class GetCircleDetailRsp
    extends MessageMicro<GetCircleDetailRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "ctype", "name", "logo", "backgroundUrl", "introduction" }, new Object[] { Integer.valueOf(0), "", "", "", "" }, GetCircleDetailRsp.class);
    public final PBStringField backgroundUrl = PBField.initString("");
    public final PBInt32Field ctype = PBField.initInt32(0);
    public final PBStringField introduction = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField name = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleCenter
 * JD-Core Version:    0.7.0.1
 */