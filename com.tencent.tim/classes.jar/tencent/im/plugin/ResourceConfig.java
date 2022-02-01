package tencent.im.plugin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ResourceConfig
{
  public static final class GetResourceReqInfoV2
    extends MessageMicro<GetResourceReqInfoV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "pkgName", "curVer", "resSubType", "lanType", "state", "resId", "status", "push", "pluginType", "delFlag" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetResourceReqInfoV2.class);
    public final PBInt64Field curVer = PBField.initInt64(0L);
    public final PBUInt32Field delFlag = PBField.initUInt32(0);
    public final PBUInt32Field lanType = PBField.initUInt32(0);
    public final PBStringField pkgName = PBField.initString("");
    public final PBUInt32Field pluginType = PBField.initUInt32(0);
    public final PBUInt32Field push = PBField.initUInt32(0);
    public final PBUInt32Field resId = PBField.initUInt32(0);
    public final PBUInt32Field resSubType = PBField.initUInt32(0);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
  }
  
  public static final class GetResourceReqV2
    extends MessageMicro<GetResourceReqV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "resReqInfo", "pluginType", "model", "appid", "reqVer", "revision" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, GetResourceReqV2.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField model = PBField.initString("");
    public final PBUInt32Field pluginType = PBField.initUInt32(0);
    public final PBUInt32Field reqVer = PBField.initUInt32(0);
    public final PBRepeatMessageField<ResourceConfig.GetResourceReqInfoV2> resReqInfo = PBField.initRepeatMessage(ResourceConfig.GetResourceReqInfoV2.class);
    public final PBStringField revision = PBField.initString("");
  }
  
  public static final class GetResourceRespInfoV2
    extends MessageMicro<GetResourceRespInfoV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 58, 66, 74, 82, 88, 96, 104, 112, 120, 128, 138, 146 }, new String[] { "pkgName", "newVer", "resSubType", "lanType", "priority", "resName", "resDesc", "resURLBig", "resURLSmall", "resConf", "defaultState", "canChangeState", "resId", "status", "push", "pluginType", "newPluginDesc", "newPluginURL" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "" }, GetResourceRespInfoV2.class);
    public final PBUInt32Field canChangeState = PBField.initUInt32(0);
    public final PBUInt32Field defaultState = PBField.initUInt32(0);
    public final PBUInt32Field lanType = PBField.initUInt32(0);
    public final PBStringField newPluginDesc = PBField.initString("");
    public final PBStringField newPluginURL = PBField.initString("");
    public final PBUInt32Field newVer = PBField.initUInt32(0);
    public final PBStringField pkgName = PBField.initString("");
    public final PBUInt32Field pluginType = PBField.initUInt32(0);
    public final PBUInt32Field priority = PBField.initUInt32(0);
    public final PBUInt32Field push = PBField.initUInt32(0);
    public final PBStringField resConf = PBField.initString("");
    public final PBStringField resDesc = PBField.initString("");
    public final PBUInt32Field resId = PBField.initUInt32(0);
    public final PBStringField resName = PBField.initString("");
    public final PBUInt32Field resSubType = PBField.initUInt32(0);
    public final PBStringField resURLBig = PBField.initString("");
    public final PBStringField resURLSmall = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
  }
  
  public static final class GetResourceRespV2
    extends MessageMicro<GetResourceRespV2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uin", "result", "addedResInfo", "deletedResInfo", "updatedResInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null }, GetResourceRespV2.class);
    public final PBRepeatMessageField<ResourceConfig.GetResourceRespInfoV2> addedResInfo = PBField.initRepeatMessage(ResourceConfig.GetResourceRespInfoV2.class);
    public final PBRepeatMessageField<ResourceConfig.GetResourceRespInfoV2> deletedResInfo = PBField.initRepeatMessage(ResourceConfig.GetResourceRespInfoV2.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBRepeatMessageField<ResourceConfig.GetResourceRespInfoV2> updatedResInfo = PBField.initRepeatMessage(ResourceConfig.GetResourceRespInfoV2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.plugin.ResourceConfig
 * JD-Core Version:    0.7.0.1
 */