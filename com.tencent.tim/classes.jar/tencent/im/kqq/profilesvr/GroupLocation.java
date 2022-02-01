package tencent.im.kqq.profilesvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GroupLocation
{
  public static final class SetGroupLocationReq
    extends MessageMicro<SetGroupLocationReq>
  {
    public static final int GROUPCODE_FIELD_NUMBER = 1;
    public static final int GROUPLOCATION_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "groupcode", "grouplocation" }, new Object[] { Integer.valueOf(0), "" }, SetGroupLocationReq.class);
    public final PBUInt32Field groupcode = PBField.initUInt32(0);
    public final PBStringField grouplocation = PBField.initString("");
  }
  
  public static final class SetGroupLocationRes
    extends MessageMicro<SetGroupLocationRes>
  {
    public static final int GROUPLOCATION_FIELD_NUMBER = 2;
    public static final int RESULT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "grouplocation" }, new Object[] { Integer.valueOf(-1), "" }, SetGroupLocationRes.class);
    public final PBStringField grouplocation = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.kqq.profilesvr.GroupLocation
 * JD-Core Version:    0.7.0.1
 */