package tencent.im.DynamicPluginSvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicPluginSvc
{
  public static final class PluginData
    extends MessageMicro<PluginData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field click_cnt = PBField.initUInt32(0);
    public final PBUInt32Field plugin_id = PBField.initUInt32(0);
    public final PBBytesField plugin_name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "plugin_id", "plugin_name", "click_cnt" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, PluginData.class);
    }
  }
  
  public static final class ReqDynamicPluginReport
    extends MessageMicro<ReqDynamicPluginReport>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field plugin_id = PBField.initUInt32(0);
    public final PBBytesField plugin_name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "plugin_id", "plugin_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ReqDynamicPluginReport.class);
    }
  }
  
  public static final class ReqDynamicPluginStat
    extends MessageMicro<ReqDynamicPluginStat>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "old_user" }, new Object[] { Boolean.valueOf(false) }, ReqDynamicPluginStat.class);
    public final PBBoolField old_user = PBField.initBool(false);
  }
  
  public static final class RspDynamicPluginReport
    extends MessageMicro<RspDynamicPluginReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, RspDynamicPluginReport.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
  
  public static final class RspDynamicPluginStat
    extends MessageMicro<RspDynamicPluginStat>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "list_data", "ret", "old_user" }, new Object[] { null, Integer.valueOf(0), Boolean.valueOf(false) }, RspDynamicPluginStat.class);
    public final PBRepeatMessageField<DynamicPluginSvc.PluginData> list_data = PBField.initRepeatMessage(DynamicPluginSvc.PluginData.class);
    public final PBBoolField old_user = PBField.initBool(false);
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.DynamicPluginSvc.DynamicPluginSvc
 * JD-Core Version:    0.7.0.1
 */