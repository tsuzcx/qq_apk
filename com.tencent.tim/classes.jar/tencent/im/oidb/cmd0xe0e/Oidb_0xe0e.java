package tencent.im.oidb.cmd0xe0e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xe0e
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_id", "disabled", "disabled_appids" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt32Field disabled = PBField.initUInt32(0);
    public final PBRepeatField<Long> disabled_appids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe0e.Oidb_0xe0e
 * JD-Core Version:    0.7.0.1
 */