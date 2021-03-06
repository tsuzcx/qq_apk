import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ScBypassCb
{
  public static final class StScBypassCbReq
    extends MessageMicro<StScBypassCbReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56 }, new String[] { "msgid", "puin", "cmd", "hitReason", "beat_common", "appid", "src" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StScBypassCbReq.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field beat_common = PBField.initUInt32(0);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field hitReason = PBField.initUInt32(0);
    public final PBStringField msgid = PBField.initString("");
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBUInt32Field src = PBField.initUInt32(0);
  }
  
  public static final class StScBypassCbRsp
    extends MessageMicro<StScBypassCbRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "errmsg" }, new Object[] { Integer.valueOf(0), "" }, StScBypassCbRsp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ScBypassCb
 * JD-Core Version:    0.7.0.1
 */