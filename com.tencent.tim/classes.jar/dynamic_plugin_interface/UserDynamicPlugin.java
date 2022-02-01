package dynamic_plugin_interface;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserDynamicPlugin
{
  public static final class ReqGetUserDynamicPlugin
    extends MessageMicro<ReqGetUserDynamicPlugin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "platform", "plugin_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ReqGetUserDynamicPlugin.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);
  }
  
  public static final class ReqSetUserDynamicPlugin
    extends MessageMicro<ReqSetUserDynamicPlugin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "plugin_id", "last_time", "plugin_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqSetUserDynamicPlugin.class);
    public final PBUInt32Field last_time = PBField.initUInt32(0);
    public final PBRepeatField<Integer> plugin_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);
  }
  
  public static final class RspGetUserDynamicPlugin
    extends MessageMicro<RspGetUserDynamicPlugin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "plugin_id", "last_time", "ret", "plugin_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspGetUserDynamicPlugin.class);
    public final PBUInt32Field last_time = PBField.initUInt32(0);
    public final PBRepeatField<Integer> plugin_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
  
  public static final class RspSetUserDynamicPlugin
    extends MessageMicro<RspSetUserDynamicPlugin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, RspSetUserDynamicPlugin.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dynamic_plugin_interface.UserDynamicPlugin
 * JD-Core Version:    0.7.0.1
 */