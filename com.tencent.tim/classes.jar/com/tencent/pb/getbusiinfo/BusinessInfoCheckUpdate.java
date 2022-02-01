package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate
{
  public static final class AppSetting
    extends MessageMicro<AppSetting>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "appid", "setting", "modify_ts" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L) }, AppSetting.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt64Field modify_ts = PBField.initUInt64(0L);
    public final PBBoolField setting = PBField.initBool(false);
  }
  
  public static final class LbsCellInfo
    extends MessageMicro<LbsCellInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "mcc", "mnc", "lac", "cellid", "rssi", "stationLat", "stationLng" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, LbsCellInfo.class);
    public final PBInt32Field cellid = PBField.initInt32(0);
    public final PBInt32Field lac = PBField.initInt32(0);
    public final PBInt32Field mcc = PBField.initInt32(0);
    public final PBInt32Field mnc = PBField.initInt32(0);
    public final PBInt32Field rssi = PBField.initInt32(0);
    public final PBInt32Field stationLat = PBField.initInt32(0);
    public final PBInt32Field stationLng = PBField.initInt32(0);
  }
  
  public static final class LbsDetailInfo
    extends MessageMicro<LbsDetailInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "subnation", "poilist" }, new Object[] { null, null }, LbsDetailInfo.class);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.LbsPoiInfo> poilist = PBField.initRepeatMessage(BusinessInfoCheckUpdate.LbsPoiInfo.class);
    public BusinessInfoCheckUpdate.LbsSubnation subnation = new BusinessInfoCheckUpdate.LbsSubnation();
  }
  
  public static final class LbsDispatchReqBody
    extends MessageMicro<LbsDispatchReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50 }, new String[] { "iProtocolVer", "uiClientPlatID", "sClientVer", "uiUin", "sClientIP", "lbs" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), null }, LbsDispatchReqBody.class);
    public final PBInt32Field iProtocolVer = PBField.initInt32(0);
    public BusinessInfoCheckUpdate.LbsInfo lbs = new BusinessInfoCheckUpdate.LbsInfo();
    public final PBUInt32Field sClientIP = PBField.initUInt32(0);
    public final PBStringField sClientVer = PBField.initString("");
    public final PBUInt32Field uiClientPlatID = PBField.initUInt32(0);
    public final PBUInt64Field uiUin = PBField.initUInt64(0L);
  }
  
  public static final class LbsDispatchRspBody
    extends MessageMicro<LbsDispatchRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "iRetCode" }, new Object[] { Integer.valueOf(0) }, LbsDispatchRspBody.class);
    public final PBInt32Field iRetCode = PBField.initInt32(0);
  }
  
  public static final class LbsInfo
    extends MessageMicro<LbsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "location", "cells", "wlan", "detail_info" }, new Object[] { null, null, null, null }, LbsInfo.class);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.LbsCellInfo> cells = PBField.initRepeatMessage(BusinessInfoCheckUpdate.LbsCellInfo.class);
    public BusinessInfoCheckUpdate.LbsDetailInfo detail_info = new BusinessInfoCheckUpdate.LbsDetailInfo();
    public BusinessInfoCheckUpdate.LbsLocationInfo location = new BusinessInfoCheckUpdate.LbsLocationInfo();
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.LbsWlanInfo> wlan = PBField.initRepeatMessage(BusinessInfoCheckUpdate.LbsWlanInfo.class);
  }
  
  public static final class LbsLocationInfo
    extends MessageMicro<LbsLocationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "coordinate", "latitude", "longitude", "additional" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, LbsLocationInfo.class);
    public final PBStringField additional = PBField.initString("");
    public final PBInt32Field coordinate = PBField.initInt32(0);
    public final PBInt32Field latitude = PBField.initInt32(0);
    public final PBInt32Field longitude = PBField.initInt32(0);
  }
  
  public static final class LbsPoiInfo
    extends MessageMicro<LbsPoiInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 104, 114, 122, 128 }, new String[] { "name", "addr", "catalog", "latitude", "longitude", "dist", "uid", "catalogid", "city", "cityid", "dianping_id", "hotvalue", "is_business_area", "province", "region", "shopping_mall" }, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", Integer.valueOf(0), "", "", Integer.valueOf(0) }, LbsPoiInfo.class);
    public final PBStringField addr = PBField.initString("");
    public final PBStringField catalog = PBField.initString("");
    public final PBStringField catalogid = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField cityid = PBField.initString("");
    public final PBStringField dianping_id = PBField.initString("");
    public final PBStringField dist = PBField.initString("");
    public final PBStringField hotvalue = PBField.initString("");
    public final PBInt32Field is_business_area = PBField.initInt32(0);
    public final PBStringField latitude = PBField.initString("");
    public final PBStringField longitude = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField region = PBField.initString("");
    public final PBInt32Field shopping_mall = PBField.initInt32(0);
    public final PBStringField uid = PBField.initString("");
  }
  
  public static final class LbsSubnation
    extends MessageMicro<LbsSubnation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130 }, new String[] { "name", "code", "nation", "province", "city", "district", "town", "village", "street", "street_no", "ad_area_level_1", "ad_area_level_2", "ad_area_level_3", "locality", "sublocality", "colloquial_area" }, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" }, LbsSubnation.class);
    public final PBStringField ad_area_level_1 = PBField.initString("");
    public final PBStringField ad_area_level_2 = PBField.initString("");
    public final PBStringField ad_area_level_3 = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField code = PBField.initString("");
    public final PBStringField colloquial_area = PBField.initString("");
    public final PBStringField district = PBField.initString("");
    public final PBStringField locality = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField nation = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField street = PBField.initString("");
    public final PBStringField street_no = PBField.initString("");
    public final PBStringField sublocality = PBField.initString("");
    public final PBStringField town = PBField.initString("");
    public final PBStringField village = PBField.initString("");
  }
  
  public static final class LbsWlanInfo
    extends MessageMicro<LbsWlanInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "mac", "ssid", "rssi" }, new Object[] { "", "", Integer.valueOf(0) }, LbsWlanInfo.class);
    public final PBStringField mac = PBField.initString("");
    public final PBInt32Field rssi = PBField.initInt32(0);
    public final PBStringField ssid = PBField.initString("");
  }
  
  public static final class NumMsgBusi
    extends MessageMicro<NumMsgBusi>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 66, 74 }, new String[] { "uint64_msgid", "uint32_appid", "str_path", "str_missionid", "uint32_expire_time", "str_content", "str_url", "str_ext", "str_ret" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", "" }, NumMsgBusi.class);
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_ext = PBField.initString("");
    public final PBStringField str_missionid = PBField.initString("");
    public final PBStringField str_path = PBField.initString("");
    public final PBStringField str_ret = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_msgid = PBField.initUInt64(0L);
  }
  
  public static final class NumMsgReqBody
    extends MessageMicro<NumMsgReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "i_proto_ver", "uint32_plat_id", "str_client_ver", "uint64_uin", "rpt_num_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), null }, NumMsgReqBody.class);
    public final PBInt32Field i_proto_ver = PBField.initInt32(0);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumMsgBusi> rpt_num_msg = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumMsgBusi.class);
    public final PBStringField str_client_ver = PBField.initString("");
    public final PBUInt32Field uint32_plat_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class NumMsgRspBody
    extends MessageMicro<NumMsgRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "i_retcode", "str_errmsg", "uint64_uin", "rpt_num_red" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), null }, NumMsgRspBody.class);
    public final PBInt32Field i_retcode = PBField.initInt32(0);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumMsgBusi> rpt_num_red = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumMsgBusi.class);
    public final PBStringField str_errmsg = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class NumRedBusi
    extends MessageMicro<NumRedBusi>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58 }, new String[] { "uint32_appid", "i_new_flag", "uint32_modify_ts", "rpt_num_red_path", "int32_appset", "uint32_red_total_num", "str_extend" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), "" }, NumRedBusi.class);
    public final PBInt32Field i_new_flag = PBField.initInt32(0);
    public final PBInt32Field int32_appset = PBField.initInt32(0);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumRedPath> rpt_num_red_path = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumRedPath.class);
    public final PBStringField str_extend = PBField.initString("");
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_modify_ts = PBField.initUInt32(0);
    public final PBUInt32Field uint32_red_total_num = PBField.initUInt32(0);
  }
  
  public static final class NumRedInfo
    extends MessageMicro<NumRedInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58 }, new String[] { "appid", "flag", "modify_ts", "num_red_path", "appset", "red_total_num", "extend" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), "" }, NumRedInfo.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBInt32Field appset = PBField.initInt32(0);
    public final PBStringField extend = PBField.initString("");
    public final PBBoolField flag = PBField.initBool(false);
    public final PBUInt32Field modify_ts = PBField.initUInt32(0);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumRedPath> num_red_path = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumRedPath.class);
    public final PBUInt32Field red_total_num = PBField.initUInt32(0);
  }
  
  public static final class NumRedPath
    extends MessageMicro<NumRedPath>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56 }, new String[] { "str_path", "str_missionid", "uint64_msgid", "uint32_msg_status", "uint32_expire_time", "uint32_push_num_red_ts", "uint32_local_recv_ts" }, new Object[] { "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NumRedPath.class);
    public final PBStringField str_missionid = PBField.initString("");
    public final PBStringField str_path = PBField.initString("");
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_local_recv_ts = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_push_num_red_ts = PBField.initUInt32(0);
    public final PBUInt64Field uint64_msgid = PBField.initUInt64(0L);
  }
  
  public static final class NumRedReqBody
    extends MessageMicro<NumRedReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "i_proto_ver", "uint32_plat_id", "str_client_ver", "uint64_uin", "rpt_num_red" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), null }, NumRedReqBody.class);
    public final PBInt32Field i_proto_ver = PBField.initInt32(0);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumRedBusi> rpt_num_red = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumRedBusi.class);
    public final PBStringField str_client_ver = PBField.initString("");
    public final PBUInt32Field uint32_plat_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class NumRedRspBody
    extends MessageMicro<NumRedRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "i_retcode", "str_errmsg", "i_inteval", "uint64_uin", "rpt_num_red" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), null }, NumRedRspBody.class);
    public final PBInt32Field i_inteval = PBField.initInt32(0);
    public final PBInt32Field i_retcode = PBField.initInt32(0);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumRedBusi> rpt_num_red = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumRedBusi.class);
    public final PBStringField str_errmsg = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReportReqBody
    extends MessageMicro<ReportReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 66, 72, 80, 88, 98 }, new String[] { "uin", "platid", "clientver", "platver", "appid", "missionid", "buffer", "reportdata", "msgids", "cmd", "bHebaFlag", "extend" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", null, Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), "" }, ReportReqBody.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBBoolField bHebaFlag = PBField.initBool(false);
    public final PBStringField buffer = PBField.initString("");
    public final PBStringField clientver = PBField.initString("");
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBStringField extend = PBField.initString("");
    public final PBRepeatField<String> missionid = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<Long> msgids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field platid = PBField.initUInt32(0);
    public final PBStringField platver = PBField.initString("");
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.ReportStaticsData> reportdata = PBField.initRepeatMessage(BusinessInfoCheckUpdate.ReportStaticsData.class);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class ReportRspBody
    extends MessageMicro<ReportRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "code", "errmsg", "uin", "appid", "buffer" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), "" }, ReportRspBody.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField buffer = PBField.initString("");
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class ReportStaticsData
    extends MessageMicro<ReportStaticsData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, ReportStaticsData.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
  }
  
  public static final class SettingReqBody
    extends MessageMicro<SettingReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "iProtocolVer", "uiClientPlatID", "sClientVer", "uiUin", "rptAppid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0) }, SettingReqBody.class);
    public final PBInt32Field iProtocolVer = PBField.initInt32(0);
    public final PBRepeatField<Integer> rptAppid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField sClientVer = PBField.initString("");
    public final PBUInt32Field uiClientPlatID = PBField.initUInt32(0);
    public final PBUInt64Field uiUin = PBField.initUInt64(0L);
  }
  
  public static final class SettingRspBody
    extends MessageMicro<SettingRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "iResult", "sErrMsg", "iInterval", "uiUin", "rptSetting" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), null }, SettingRspBody.class);
    public final PBInt32Field iInterval = PBField.initInt32(0);
    public final PBInt32Field iResult = PBField.initInt32(0);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.AppSetting> rptSetting = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppSetting.class);
    public final PBStringField sErrMsg = PBField.initString("");
    public final PBUInt64Field uiUin = PBField.initUInt64(0L);
  }
  
  public static final class TimeReqBody
    extends MessageMicro<TimeReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 66, 72, 80, 90 }, new String[] { "iProtocolVer", "uiClientPlatID", "sClientVer", "uiUin", "rptMsgAppInfo", "rptSetting", "rptNoRedPath", "lbs", "uiNetType", "bHebaFlag", "sQimei" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), null, null, "", null, Integer.valueOf(0), Boolean.valueOf(false), "" }, TimeReqBody.class);
    public final PBBoolField bHebaFlag = PBField.initBool(false);
    public final PBInt32Field iProtocolVer = PBField.initInt32(0);
    public BusinessInfoCheckUpdate.LbsInfo lbs = new BusinessInfoCheckUpdate.LbsInfo();
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.AppInfo> rptMsgAppInfo = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppInfo.class);
    public final PBRepeatField<String> rptNoRedPath = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.AppSetting> rptSetting = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppSetting.class);
    public final PBStringField sClientVer = PBField.initString("");
    public final PBStringField sQimei = PBField.initString("");
    public final PBUInt32Field uiClientPlatID = PBField.initUInt32(0);
    public final PBUInt32Field uiNetType = PBField.initUInt32(0);
    public final PBUInt64Field uiUin = PBField.initUInt64(0L);
  }
  
  public static final class TimeRspBody
    extends MessageMicro<TimeRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50, 58, 64, 72 }, new String[] { "iResult", "sErrMsg", "iInterval", "rptMsgAppInfo", "uiUin", "rptSetting", "rptMsgNumRedInfo", "iLbsInterval", "iStatInterval" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, Long.valueOf(0L), null, null, Integer.valueOf(0), Integer.valueOf(0) }, TimeRspBody.class);
    public final PBInt32Field iInterval = PBField.initInt32(0);
    public final PBInt32Field iLbsInterval = PBField.initInt32(0);
    public final PBInt32Field iResult = PBField.initInt32(0);
    public final PBInt32Field iStatInterval = PBField.initInt32(0);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.AppInfo> rptMsgAppInfo = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppInfo.class);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.NumRedInfo> rptMsgNumRedInfo = PBField.initRepeatMessage(BusinessInfoCheckUpdate.NumRedInfo.class);
    public final PBRepeatMessageField<BusinessInfoCheckUpdate.AppSetting> rptSetting = PBField.initRepeatMessage(BusinessInfoCheckUpdate.AppSetting.class);
    public final PBStringField sErrMsg = PBField.initString("");
    public final PBUInt64Field uiUin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate
 * JD-Core Version:    0.7.0.1
 */