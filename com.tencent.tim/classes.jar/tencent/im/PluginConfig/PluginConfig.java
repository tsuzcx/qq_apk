package tencent.im.PluginConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PluginConfig
{
  public static final class BatchGetResourceReq
    extends MessageMicro<BatchGetResourceReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "req_list" }, new Object[] { null }, BatchGetResourceReq.class);
    public final PBRepeatMessageField<PluginConfig.GetResourceReq> req_list = PBField.initRepeatMessage(PluginConfig.GetResourceReq.class);
  }
  
  public static final class BatchGetResourceResp
    extends MessageMicro<BatchGetResourceResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uin", "errcode", "errmsg", "resp_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", null }, BatchGetResourceResp.class);
    public final PBUInt32Field errcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<PluginConfig.GetResourceResp> resp_list = PBField.initRepeatMessage(PluginConfig.GetResourceResp.class);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class GetResourceReq
    extends MessageMicro<GetResourceReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "reqinfo_list", "plugin_type", "plugin_layout_seq" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, GetResourceReq.class);
    public final PBUInt32Field plugin_layout_seq = PBField.initUInt32(0);
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<PluginConfig.GetResourceReqInfo> reqinfo_list = PBField.initRepeatMessage(PluginConfig.GetResourceReqInfo.class);
  }
  
  public static final class GetResourceReqInfo
    extends MessageMicro<GetResourceReqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "res_id", "res_seq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetResourceReqInfo.class);
    public final PBUInt32Field res_id = PBField.initUInt32(0);
    public final PBUInt32Field res_seq = PBField.initUInt32(0);
  }
  
  public static final class GetResourceResp
    extends MessageMicro<GetResourceResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "plugin_type", "respinfo_list", "plugin_layout" }, new Object[] { Integer.valueOf(0), null, null }, GetResourceResp.class);
    public PluginConfig.PluginLayout plugin_layout = new PluginConfig.PluginLayout();
    public final PBUInt32Field plugin_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<PluginConfig.GetResourceRespInfo> respinfo_list = PBField.initRepeatMessage(PluginConfig.GetResourceRespInfo.class);
  }
  
  public static final class GetResourceRespInfo
    extends MessageMicro<GetResourceRespInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 80, 90, 96, 106 }, new String[] { "res_id", "state", "res_seq", "sub_type", "res_name", "icon_url", "jump_url", "res_conf", "can_change_state", "pkg_name", "simple_mode", "grid_icon_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), "" }, GetResourceRespInfo.class);
    public final PBUInt32Field can_change_state = PBField.initUInt32(0);
    public final PBStringField grid_icon_url = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField res_conf = PBField.initString("");
    public final PBUInt32Field res_id = PBField.initUInt32(0);
    public final PBStringField res_name = PBField.initString("");
    public final PBUInt32Field res_seq = PBField.initUInt32(0);
    public final PBUInt32Field simple_mode = PBField.initUInt32(0);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBUInt32Field sub_type = PBField.initUInt32(0);
  }
  
  public static final class PluginGroup
    extends MessageMicro<PluginGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "res_id" }, new Object[] { Integer.valueOf(0) }, PluginGroup.class);
    public final PBRepeatField<Integer> res_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class PluginLayout
    extends MessageMicro<PluginLayout>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "plugin_layout_seq", "group_list", "layout_type" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, PluginLayout.class);
    public final PBRepeatMessageField<PluginConfig.PluginGroup> group_list = PBField.initRepeatMessage(PluginConfig.PluginGroup.class);
    public final PBUInt32Field layout_type = PBField.initUInt32(0);
    public final PBUInt32Field plugin_layout_seq = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.PluginConfig.PluginConfig
 * JD-Core Version:    0.7.0.1
 */