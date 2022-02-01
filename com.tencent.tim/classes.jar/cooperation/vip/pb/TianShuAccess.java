package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TianShuAccess
{
  public static final class AdItem
    extends MessageMicro<AdItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 42, 82, 90, 98, 106, 114, 122, 162 }, new String[] { "iAdId", "traceinfo", "title", "desc", "jumpurl", "iconurl", "lstPic", "argList", "ext_info" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", "", null, "" }, AdItem.class);
    public final PBRepeatMessageField<TianShuAccess.MapEntry> argList = PBField.initRepeatMessage(TianShuAccess.MapEntry.class);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField ext_info = PBField.initString("");
    public final PBUInt32Field iAdId = PBField.initUInt32(0);
    public final PBStringField iconurl = PBField.initString("");
    public final PBStringField jumpurl = PBField.initString("");
    public final PBRepeatField<String> lstPic = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField title = PBField.initString("");
    public final PBStringField traceinfo = PBField.initString("");
  }
  
  public static final class AdPlacementInfo
    extends MessageMicro<AdPlacementInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "type", "lst", "next_query_ts", "extInfo", "ctlInfo" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), "", "" }, AdPlacementInfo.class);
    public final PBStringField ctlInfo = PBField.initString("");
    public final PBStringField extInfo = PBField.initString("");
    public final PBRepeatMessageField<TianShuAccess.AdItem> lst = PBField.initRepeatMessage(TianShuAccess.AdItem.class);
    public final PBUInt32Field next_query_ts = PBField.initUInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
  }
  
  public static final class AdPosItem
    extends MessageMicro<AdPosItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 114 }, new String[] { "posId", "nNeedCnt", "extra_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, AdPosItem.class);
    public final PBRepeatMessageField<TianShuAccess.MapEntry> extra_info = PBField.initRepeatMessage(TianShuAccess.MapEntry.class);
    public final PBUInt32Field nNeedCnt = PBField.initUInt32(0);
    public final PBUInt32Field posId = PBField.initUInt32(0);
  }
  
  public static final class CommInfo
    extends MessageMicro<CommInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26, 34, 40, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 162 }, new String[] { "lUin", "strDeviceInfo", "stGps", "iBid", "strUserIp", "strApp", "strOs", "strVersion", "strOpenId", "strCityCode", "iNetWorkEnv", "strQua", "strQimei", "strUid", "strExpSeq" }, new Object[] { Long.valueOf(0L), "", null, Integer.valueOf(0), "", "", "", "", "", "", Integer.valueOf(0), "", "", "", "" }, CommInfo.class);
    public final PBUInt32Field iBid = PBField.initUInt32(0);
    public final PBInt32Field iNetWorkEnv = PBField.initInt32(0);
    public final PBUInt64Field lUin = PBField.initUInt64(0L);
    public TianShuAccess.Gps stGps = new TianShuAccess.Gps();
    public final PBStringField strApp = PBField.initString("");
    public final PBStringField strCityCode = PBField.initString("");
    public final PBStringField strDeviceInfo = PBField.initString("");
    public final PBStringField strExpSeq = PBField.initString("");
    public final PBStringField strOpenId = PBField.initString("");
    public final PBStringField strOs = PBField.initString("");
    public final PBStringField strQimei = PBField.initString("");
    public final PBStringField strQua = PBField.initString("");
    public final PBStringField strUid = PBField.initString("");
    public final PBStringField strUserIp = PBField.initString("");
    public final PBStringField strVersion = PBField.initString("");
  }
  
  public static final class GetAdsReq
    extends MessageMicro<GetAdsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "stComminfo", "lstPos" }, new Object[] { null, null }, GetAdsReq.class);
    public final PBRepeatMessageField<TianShuAccess.AdPosItem> lstPos = PBField.initRepeatMessage(TianShuAccess.AdPosItem.class);
    public TianShuAccess.CommInfo stComminfo = new TianShuAccess.CommInfo();
  }
  
  public static final class GetAdsRsp
    extends MessageMicro<GetAdsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "code", "errmsg", "mapAds", "rspExtInfo" }, new Object[] { Integer.valueOf(0), "", null, "" }, GetAdsRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<TianShuAccess.RspEntry> mapAds = PBField.initRepeatMessage(TianShuAccess.RspEntry.class);
    public final PBStringField rspExtInfo = PBField.initString("");
  }
  
  public static final class Gps
    extends MessageMicro<Gps>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "lat", "lon", "accuracy" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Gps.class);
    public final PBInt32Field accuracy = PBField.initInt32(0);
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBInt32Field lon = PBField.initInt32(0);
  }
  
  public static final class MapEntry
    extends MessageMicro<MapEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, MapEntry.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
  }
  
  public static final class RspEntry
    extends MessageMicro<RspEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "key", "value" }, new Object[] { Integer.valueOf(0), null }, RspEntry.class);
    public final PBUInt32Field key = PBField.initUInt32(0);
    public TianShuAccess.AdPlacementInfo value = new TianShuAccess.AdPlacementInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.pb.TianShuAccess
 * JD-Core Version:    0.7.0.1
 */