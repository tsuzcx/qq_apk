package NS_STORE_APP_CLIENT;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MiniAppStore
{
  public static final class StAppRecommendCard
    extends MessageMicro<StAppRecommendCard>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 56 }, new String[] { "strCardId", "strCardTitle", "strCardSubTitle", "uiCardType", "vecAppInfo", "stSpecialAppInfo", "uiCardStatus" }, new Object[] { "", "", "", Integer.valueOf(0), null, null, Integer.valueOf(0) }, StAppRecommendCard.class);
    public MiniAppStore.StSpecialAppInfo stSpecialAppInfo = new MiniAppStore.StSpecialAppInfo();
    public final PBStringField strCardId = PBField.initString("");
    public final PBStringField strCardSubTitle = PBField.initString("");
    public final PBStringField strCardTitle = PBField.initString("");
    public final PBUInt32Field uiCardStatus = PBField.initUInt32(0);
    public final PBUInt32Field uiCardType = PBField.initUInt32(0);
    public final PBRepeatMessageField<INTERFACE.StUserAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
  }
  
  public static final class StChangeTopAppOrderReq
    extends MessageMicro<StChangeTopAppOrderReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecAppInfo" }, new Object[] { null, null }, StChangeTopAppOrderReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StUserAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
  }
  
  public static final class StChangeTopAppOrderRsp
    extends MessageMicro<StChangeTopAppOrderRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StChangeTopAppOrderRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetFirstPageByTypeReq
    extends MessageMicro<StGetFirstPageByTypeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "uiPageType" }, new Object[] { null, Integer.valueOf(0) }, StGetFirstPageByTypeReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field uiPageType = PBField.initUInt32(0);
  }
  
  public static final class StGetFirstPageByTypeRsp
    extends MessageMicro<StGetFirstPageByTypeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "vecAppInfo", "vecAppRecommendCard" }, new Object[] { null, null, null }, StGetFirstPageByTypeRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StUserAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
    public final PBRepeatMessageField<MiniAppStore.StAppRecommendCard> vecAppRecommendCard = PBField.initRepeatMessage(MiniAppStore.StAppRecommendCard.class);
  }
  
  public static final class StGetMyAppListByTypeReq
    extends MessageMicro<StGetMyAppListByTypeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "extInfo", "uiAppType", "uiListType" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, StGetMyAppListByTypeReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field uiAppType = PBField.initUInt32(0);
    public final PBUInt32Field uiListType = PBField.initUInt32(0);
  }
  
  public static final class StGetMyAppListByTypeRsp
    extends MessageMicro<StGetMyAppListByTypeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecAppInfo" }, new Object[] { null, null }, StGetMyAppListByTypeRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StUserAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
  }
  
  public static final class StGetRecommendCardDetailReq
    extends MessageMicro<StGetRecommendCardDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "strCardId" }, new Object[] { null, "" }, StGetRecommendCardDetailReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strCardId = PBField.initString("");
  }
  
  public static final class StGetRecommendCardDetailRsp
    extends MessageMicro<StGetRecommendCardDetailRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "stAppRecommendCard" }, new Object[] { null, null }, StGetRecommendCardDetailRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public MiniAppStore.StAppRecommendCard stAppRecommendCard = new MiniAppStore.StAppRecommendCard();
  }
  
  public static final class StPicInfo
    extends MessageMicro<StPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "strUrl", "uiWidth", "uiHeight" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, StPicInfo.class);
    public final PBStringField strUrl = PBField.initString("");
    public final PBUInt32Field uiHeight = PBField.initUInt32(0);
    public final PBUInt32Field uiWidth = PBField.initUInt32(0);
  }
  
  public static final class StSpecialAppInfo
    extends MessageMicro<StSpecialAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "stAppInfo", "stFirstPicInfo", "vecPicInfo", "stVideoInfo", "strText" }, new Object[] { null, null, null, null, "" }, StSpecialAppInfo.class);
    public INTERFACE.StUserAppInfo stAppInfo = new INTERFACE.StUserAppInfo();
    public MiniAppStore.StPicInfo stFirstPicInfo = new MiniAppStore.StPicInfo();
    public MiniAppStore.StVideoInfo stVideoInfo = new MiniAppStore.StVideoInfo();
    public final PBStringField strText = PBField.initString("");
    public final PBRepeatMessageField<MiniAppStore.StPicInfo> vecPicInfo = PBField.initRepeatMessage(MiniAppStore.StPicInfo.class);
  }
  
  public static final class StVideoInfo
    extends MessageMicro<StVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "strVideoUrl", "strCoverUrl", "uiDuration", "uiWidth", "uiHeight", "uiSize" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StVideoInfo.class);
    public final PBStringField strCoverUrl = PBField.initString("");
    public final PBStringField strVideoUrl = PBField.initString("");
    public final PBUInt32Field uiDuration = PBField.initUInt32(0);
    public final PBUInt32Field uiHeight = PBField.initUInt32(0);
    public final PBUInt32Field uiSize = PBField.initUInt32(0);
    public final PBUInt32Field uiWidth = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.MiniAppStore
 * JD-Core Version:    0.7.0.1
 */