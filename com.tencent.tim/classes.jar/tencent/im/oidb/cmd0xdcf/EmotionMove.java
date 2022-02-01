package tencent.im.oidb.cmd0xdcf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmotionMove
{
  public static final class OrderFileResult
    extends MessageMicro<OrderFileResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26, 32, 40 }, new String[] { "filename", "bid", "max_roam_size", "uint32_emoji_type" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, OrderFileResult.class);
    public final PBStringField bid = PBField.initString("");
    public final PBRepeatField<String> filename = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field max_roam_size = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_emoji_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class PlatInfo
    extends MessageMicro<PlatInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "implat", "osver", "mqqver" }, new Object[] { Integer.valueOf(0), "", "" }, PlatInfo.class);
    public final PBInt32Field implat = PBField.initInt32(0);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_comm_info", "str_req_filename" }, new Object[] { null, "" }, ReqBody.class);
    public EmotionMove.PlatInfo msg_comm_info = new EmotionMove.PlatInfo();
    public final PBRepeatField<String> str_req_filename = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret", "errmsg", "msg_order_filename" }, new Object[] { Integer.valueOf(0), "", null }, RspBody.class);
    public final PBStringField errmsg = PBField.initString("");
    public EmotionMove.OrderFileResult msg_order_filename = new EmotionMove.OrderFileResult();
    public final PBInt32Field ret = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcf.EmotionMove
 * JD-Core Version:    0.7.0.1
 */