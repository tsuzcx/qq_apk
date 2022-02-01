package tencent.im.DynamicList;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicList
{
  public static final class SubCmd_DynamicItem_Req
    extends MessageMicro<SubCmd_DynamicItem_Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uiPluginID", "uiNewVer", "uiOpenFlag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd_DynamicItem_Req.class);
    public final PBUInt32Field uiNewVer = PBField.initUInt32(0);
    public final PBUInt32Field uiOpenFlag = PBField.initUInt32(0);
    public final PBUInt32Field uiPluginID = PBField.initUInt32(0);
  }
  
  public static final class SubCmd_DynamicItem_Resp
    extends MessageMicro<SubCmd_DynamicItem_Resp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 66, 74, 82, 90, 98, 104, 112, 122 }, new String[] { "strPkgName", "uiPluginID", "uiNewVer", "uiType", "uiWeight", "uiOpenFlag", "strResName", "strResDesc", "strResURL_big", "strResURL_small", "strResConf", "strJumpInfo", "uiCanChangeStatus", "uiJumpType", "strDescIconUrl" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "" }, SubCmd_DynamicItem_Resp.class);
    public final PBStringField strDescIconUrl = PBField.initString("");
    public final PBStringField strJumpInfo = PBField.initString("");
    public final PBStringField strPkgName = PBField.initString("");
    public final PBStringField strResConf = PBField.initString("");
    public final PBStringField strResDesc = PBField.initString("");
    public final PBStringField strResName = PBField.initString("");
    public final PBStringField strResURL_big = PBField.initString("");
    public final PBStringField strResURL_small = PBField.initString("");
    public final PBUInt32Field uiCanChangeStatus = PBField.initUInt32(0);
    public final PBUInt32Field uiJumpType = PBField.initUInt32(0);
    public final PBUInt32Field uiNewVer = PBField.initUInt32(0);
    public final PBUInt32Field uiOpenFlag = PBField.initUInt32(0);
    public final PBUInt32Field uiPluginID = PBField.initUInt32(0);
    public final PBUInt32Field uiType = PBField.initUInt32(0);
    public final PBUInt32Field uiWeight = PBField.initUInt32(0);
  }
  
  public static final class SubCmd_DynamicList_ReqInfo
    extends MessageMicro<SubCmd_DynamicList_ReqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "SubCmd_Req", "isGrayVer" }, new Object[] { null, Boolean.valueOf(false) }, SubCmd_DynamicList_ReqInfo.class);
    public final PBRepeatMessageField<DynamicList.SubCmd_DynamicItem_Req> SubCmd_Req = PBField.initRepeatMessage(DynamicList.SubCmd_DynamicItem_Req.class);
    public final PBBoolField isGrayVer = PBField.initBool(false);
  }
  
  public static final class SubCmd_DynamicList_RespInfo
    extends MessageMicro<SubCmd_DynamicList_RespInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uiReturnCode", "SubCmd_Resp_Add", "SubCmd_Resp_Modify", "SubCmd_Resp_Delete" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0) }, SubCmd_DynamicList_RespInfo.class);
    public final PBRepeatMessageField<DynamicList.SubCmd_DynamicItem_Resp> SubCmd_Resp_Add = PBField.initRepeatMessage(DynamicList.SubCmd_DynamicItem_Resp.class);
    public final PBRepeatField<Integer> SubCmd_Resp_Delete = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<DynamicList.SubCmd_DynamicItem_Resp> SubCmd_Resp_Modify = PBField.initRepeatMessage(DynamicList.SubCmd_DynamicItem_Resp.class);
    public final PBUInt32Field uiReturnCode = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.DynamicList.DynamicList
 * JD-Core Version:    0.7.0.1
 */