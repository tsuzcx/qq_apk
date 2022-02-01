package tencent.im.oidb.cmd0xa1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa1e
{
  public static final class AppClick
    extends MessageMicro<AppClick>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "appid", "click_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, AppClick.class);
    public final PBUInt64Field appid = PBField.initUInt64(0L);
    public final PBUInt32Field click_num = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_app_click", "platform", "position" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt32Field position = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xa1e.AppClick> rpt_app_click = PBField.initRepeatMessage(oidb_0xa1e.AppClick.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa1e.oidb_0xa1e
 * JD-Core Version:    0.7.0.1
 */